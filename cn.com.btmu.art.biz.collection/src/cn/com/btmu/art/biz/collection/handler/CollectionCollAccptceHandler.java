package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollAccptceDetailContext;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFCollclsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFDishnrClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFFaultClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302102;
import cn.com.btmu.art.biz.collection.validate.SpValidate823028;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309701;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.base.handler.ComTriggerEventHandler;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcAccptceOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dto.SeqRelation;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.smile.service.SmileConstants;
import cn.com.btmu.smile.service.SmileInvocationInstructions;

/**
 * CollectionCollAccptceHandler 托收承兑节点用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollAccptceHandler extends
    ComTriggerEventHandler<CollectionCollAccptceDetailContext> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 采号信息取得
   * 
   * @return SeqRelation 采号信息
   */
  public List<SeqRelation> getSequence() throws BizException {
    logger.debug("CollectionCollAccptceHandler-getSequence start");
    //定义采号信息集合
    List<SeqRelation> preSeqList = new ArrayList<SeqRelation>();
    // 采号信息取得
    SeqRelation reqRelation = new SeqRelation(getContext().getReqData()
        .getTKind()
        + getContext().getReqData().getTxnPrmryRefNo()
        + getContext().getReqData().getTxnSubRefNo(), null);
    //添加采号信息
    preSeqList.add(reqRelation);
    logger.debug("CollectionCollAccptceHandler-getSequence end");
    //返回采号信息集合
    return preSeqList;
  }

  /**
   * 初始化方法，自定义初始化逻辑.
   * 
   * @return void
   */
  @Override
  public void init() {
    logger.debug("CollectionCollAccptceHandler-init start");

    // 取得系统日期的方法
    DateUtil bizDataUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);
    //后去托收承兑操作明细
    BcAccptceOpDtlImpl reqData = getContext().getReqData();

    // 承兑登记日 系统日期
    reqData.setAccptceRegDate(bizDataUtil.getNow());

    // 承兑到期日期设为托收基本信息的到期日期
    reqData.setAccptceDueDate(getContext().getDataRepository()
        .getBizDataCollection().getBcInfo().getDueDate());

    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时
    BcInfo bcInfo = getContext().getDataRepository().getBizDataCollection().getBcInfo();
    ExpLcInfo expLcInfo = getContext().getDataRepository().getBizDataCollection().getExpLcInfo();
    if (null != bcInfo && null != expLcInfo) {
	    if (DataTypeConstant.DATA_TYPE_YES.equals(bcInfo.getLcFlg())
	        && DataTypeConstant.DATA_TYPE_YES.equals(expLcInfo.getWithReimbsBankFlg())) {
	      logger.debug("【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’");
	      // 【画：承兑.远期索偿日】=【画：承兑.承兑到期日】-10天（自然日）
	      reqData.setForwdClmRmbrsmtDate(bizDataUtil.getBizStartDate(reqData
	          .getAccptceDueDate(), 10, ComBizConstant.COMMON_STRING_EMPTY));
	    }
    }

    // 合理标志 Y
    reqData.setResnblFlg(DataTypeConstant.DATA_TYPE_YES);

    // Accepted Flg Y
    reqData.setAcceptedFlg(DataTypeConstant.DATA_TYPE_YES);

    logger.debug("CollectionCollAccptceHandler-init end");
  }
  
  /**
   * 保存交易信息.
   * 
   * @return void
   */
  public void updateRequestData() throws BizException {
	logger.debug("CollectionCollAccptceHandler-updateRequestData start");
    // 获取托收承兑操作明细
    BcAccptceOpDtlImpl reqData = getContext().getReqData();
    // 获取托收基本信息
    BcInfo bcInfo = getContext().getDataRepository().getBizDataCollection()
        .getBcInfo();
	// 将【DM：托收承兑操作明细.承兑操作标志】的值设为：Y
    reqData.setAccptceOperFlg(DataTypeConstant.DATA_TYPE_YES);
    // 分行号设置
    reqData.setBranchCode(getContext().getBranchId());
    // T-Kind
    reqData.setTKind(bcInfo.getTKind());
    // 交易主参号
    reqData.setTxnPrmryRefNo(bcInfo.getTxnPrmryRefNo());
    // 交易子参号
    reqData.setTxnSubRefNo(bcInfo.getTxnSubRefNo());

    // 寄单信息分行号,交易参号设置
    for (DispchDocInfo dispchDocInfo : 
            getContext().getDataRepository().getOperationDataCollection().getDispchDocInfoForSaveList()) {
        dispchDocInfo.setBranchCode(getContext().getBranchId());
        dispchDocInfo.setTKind(bcInfo.getTKind());
        dispchDocInfo.setTxnPrmryRefNo(bcInfo.getTxnPrmryRefNo());
        dispchDocInfo.setTxnSubRefNo(bcInfo.getTxnSubRefNo());
    }

	logger.debug("CollectionCollAccptceHandler-updateRequestData start");
  }

  /**
   * 保存提交时数据校验.
   * 
   * @return ErrorMsgContainer 错误信息容器
   * @throws BizException
   */
  @Override
  public void internalDataValidate(ErrorContainer errorContainer) throws BizException {
    logger.debug("CollectionCollAccptceHandler-internalDataValidate start");
    //获取寄单信息
    List<DispchDocInfo> dispchDocInfoList = getContext().getDataRepository()
        .getOperationDataCollection().getDispchDocInfoForSaveList();
    //获取系统locale
    String locale = getContext().getSystemPara().getLocale();

    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：承兑.远期索偿日】不得为空，否则报错（SP_VALIDATE_823_02105）
    SpValidate82302102 spValidate82302105 = new SpValidate82302102();
    spValidate82302105.execute(getContext(), errorContainer);

    // 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
    SpValidate823028 spValidate82302802 = new SpValidate823028(locale);
    spValidate82302802.execute(dispchDocInfoList, errorContainer);

    // 手续费的收取方式校验：手续费不能通过特殊画面收取，只能选择手续费模块中的单独记账收取，否则报错（SP_VALIDATE_823_099）
    SpValidate82309701 spValidate82309701 = new SpValidate82309701();
    spValidate82309701.execute(getContext(), errorContainer);

    logger.debug("CollectionCollAccptceHandler-internalDataValidate end");
  }

  /**
   * 自动触发访问者注册器
   * 
   * @throws BizException
   */
  @Override
  protected void registTriggerVisitors() throws BizException {
    logger.debug("CollectionCollAccptceHandler-registTriggerVisitors start");

    // a- 自动触发催收拒付故障业务的‘催收销号’操作，业务状态为‘销号完成’，操作为‘催收销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFCollclsTriggerVisitor.getInstance());
    
    // b- 自动触发催收拒付故障业务的‘拒付销号’操作，业务状态为‘销号完成’，操作为‘拒付销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFDishnrClsTriggerVisitor.getInstance());
    
    // c- 自动触发催收拒付故障业务的‘故障销号’操作，业务状态为‘销号完成’，操作为‘故障销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFFaultClsTriggerVisitor.getInstance());
    
    logger.debug("CollectionCollAccptceHandler-registTriggerVisitors end");
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
        .debug("CollectionCollAccptceHandler-getSmileInvocationInstructions start");
    logger.debug("smileServiceType: " + smileServiceType);
    //实例化smile服务信息
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
        .debug("CollectionCollAccptceHandler-getSmileInvocationInstructions end");
    //返回smile服务信息
    return instructions;
  }

@Override
protected void preSequenceValidate(ErrorContainer errorContainer) throws BizException {
}

@Override
protected void sequenceValidate(ErrorContainer errorContainer) throws BizException {
}
}
