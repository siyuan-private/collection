package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollChgbkDetailContext;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFCollclsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFDishnrClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFFaultClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.validate.SpValidate823028;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309702;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.base.handler.ComTriggerEventHandler;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbModChgbkDocInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.dto.SeqRelation;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.smile.service.SmileConstants;
import cn.com.btmu.smile.service.SmileInvocationInstructions;

/**
 * CollectionCollChgbkHandler 托收退单节点用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollChgbkHandler extends
    ComTriggerEventHandler<CollectionCollChgbkDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 初始化方法，自定义初始化逻辑.
   * 
   * @return void
   */
  public void init() {
    logger.debug("CollectionCollChgbkHandler-init start");
    //取得退改单信息
    BbModChgbkDocInfo reqData = getContext().getDataRepository()
        .getOperationDataCollection().getBbModChgbkDocInfo();
    if (null == reqData){
    	reqData = new BbModChgbkDocInfoImpl();
    	getContext().getDataRepository()
    		.getOperationDataCollection().setBbModChgbkDocInfo(reqData);
    }
    // 取得系统日期的方法
    DateUtil bizDataUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);

    // 退单
    reqData.setMaintType(CollectionConstant.BB_MAINT_TYPE_2);

    // 登记日
    reqData.setRegDate(bizDataUtil.getNow());

    logger.debug("CollectionCollChgbkHandler-init end");
  }

  /**
   * 保存提交时数据校验.
   * 
   * @return ErrorMsgContainer 错误信息容器
   */
  @Override
  public void internalDataValidate(ErrorContainer errorContainer) throws BizException {
    logger.debug("CollectionCollChgbkHandler-internalDataValidate start");
    //取得寄单信息
    List<DispchDocInfo> dispchDocInfoList = getContext().getDataRepository()
        .getOperationDataCollection().getDispchDocInfoForSaveList();
    //取得系统locale
    String locale = getContext().getSystemPara().getLocale();

    // 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
    SpValidate823028 spValidate82302806 = new SpValidate823028(locale);
    spValidate82302806.execute(dispchDocInfoList, errorContainer);

    // 手续费的收取方式校验：手续费不能通过特殊画面收取，只能选择手续费模块中的单独记账收取，否则报错（SP_VALIDATE_823_099）
    SpValidate82309702 spValidate82309702 = new SpValidate82309702();
    spValidate82309702.execute(getContext(), errorContainer);

    logger.debug("CollectionCollChgbkHandler-internalDataValidate end");

  }

  /**
   * 采号信息取得
   * 
   * @return SeqRelation 采号信息
   */
  public List<SeqRelation> getSequence() throws BizException {
    logger.debug("CollectionCollChgbkHandler-getSequence start");
    //定义采号信息集合
    List<SeqRelation> preSeqList = new ArrayList<SeqRelation>();
    // 采号信息取得
    SeqRelation reqRelation = new SeqRelation(getContext().getReqData()
        .getTKind()
        + getContext().getReqData().getTxnPrmryRefNo()
        + getContext().getReqData().getTxnSubRefNo(), null);
    //添加采号信息
    preSeqList.add(reqRelation);

    logger.debug("CollectionCollChgbkHandler-getSequence end");
    //返回采号信息集合
    return preSeqList;
  }
  
  /**
   * 保存交易信息.
   * 
   * @return void
   */
  public void updateRequestData() throws BizException {
    
    BcMntnOpDtl reqData = getContext().getReqData();
    // 分行号设置
    reqData.setBranchCode(getContext().getBranchId());
    // 退改单信息分行号,交易参号设置
    BbModChgbkDocInfo bbModChgbkDocInfo = getContext().getDataRepository().getOperationDataCollection()
    .getBbModChgbkDocInfo();
    bbModChgbkDocInfo.setBranchCode(getContext().getBranchId());
    bbModChgbkDocInfo.setTKind(reqData.getTKind());
    bbModChgbkDocInfo.setTxnPrmryRefNo(reqData.getTxnPrmryRefNo());
    bbModChgbkDocInfo.setTxnSubRefNo(reqData.getTxnSubRefNo());
    // 寄单信息分行号,交易参号设置
    for (DispchDocInfo dispchDocInfo : 
            getContext().getDataRepository().getOperationDataCollection().getDispchDocInfoForSaveList()) {
        dispchDocInfo.setBranchCode(getContext().getBranchId());
        dispchDocInfo.setTKind(reqData.getTKind());
        dispchDocInfo.setTxnPrmryRefNo(reqData.getTxnPrmryRefNo());
        dispchDocInfo.setTxnSubRefNo(reqData.getTxnSubRefNo());
    }
    // 出口信用证操作明细分行号设置
    getContext().getDataRepository().getOperationDataCollection()
        .getExpLcMntnOpDtl().setBranchCode(getContext().getBranchId());
  }

  /**
   * 自动触发访问者注册器
   * 
   * @throws BizException
   */
  @Override
  protected void registTriggerVisitors() throws BizException {
    logger.debug("CollectionCollChgbkHandler-registTriggerVisitors start");

    // a- 自动触发催收拒付故障业务的‘催收销号’操作，业务状态为‘销号完成’，操作为‘催收销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFCollclsTriggerVisitor.getInstance());
    
    // b- 自动触发催收拒付故障业务的‘拒付销号’操作，业务状态为‘销号完成’，操作为‘拒付销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFDishnrClsTriggerVisitor.getInstance());
    
    // c- 自动触发催收拒付故障业务的‘故障销号’操作，业务状态为‘销号完成’，操作为‘故障销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFFaultClsTriggerVisitor.getInstance());
    
    logger.debug("CollectionCollChgbkHandler-registTriggerVisitors end");
  }

  /**
   * 获取smile服务.
   * 
   * @return SmileInvocationInstructions smile服务信息
   * 
   */
  @Override
  public SmileInvocationInstructions getSmileInvocationInstructions(
      String smileServiceType) {
    logger
        .debug("CollectionCollChgbkHandler-getSmileInvocationInstructions start");
    logger.debug("smileServiceType: " + smileServiceType);
    //实例化SmileInvocationInstructions
    SmileInvocationInstructions instructions = new SmileInvocationInstructions();

    // simle调用时，是上传还是校验的判断方法待定
    if (ComBizConstant.SMILE_SERVICE_TYPE_CHECK.equals(smileServiceType)) {
      logger.debug("调用smile校验");
      // 设置本次调用服务ID
      instructions
          .setServiceId(CollectionConstant.SMILE_SERVICE_ID_COLLECTION_CHECK);
      // 设置本次调用服务类型
      instructions.setServiceType(SmileConstants.SMILE_SERVICE_TYPE_CHECK);
    } else {
      logger.debug("调用smile上传");
      // 设置本次调用服务ID
      instructions
          .setServiceId(CollectionConstant.SMILE_SERVICE_ID_COLLECTION_UPLOAD);
      // 设置本次调用服务类型
      instructions.setServiceType(SmileConstants.SMILE_SERVICE_TYPE_UPLOAD);
    }
    // 设置本次调用所属officeCode
    instructions.setOfficeCode(getContext().getBranchId());
    // 设置调用系统ID，按照分散运管给出值设置为常量
    instructions.setRequesterId(SmileConstants.SYS_ID_ART);
    // 设置调用系统名，对于ART来说，固定为ART
    instructions.setRequesterName(SmileConstants.SYS_NAME_ART);
    // 设置校验通用服务MA错误列表
    instructions.generateSmileTransInfoList(getContext());

    logger
        .debug("CollectionCollChgbkHandler-getSmileInvocationInstructions end");
    //返回instructions
    return instructions;
  }

@Override
protected void preSequenceValidate(ErrorContainer errorContainer) throws BizException {
}

@Override
protected void sequenceValidate(ErrorContainer errorContainer) throws BizException {
}

}
