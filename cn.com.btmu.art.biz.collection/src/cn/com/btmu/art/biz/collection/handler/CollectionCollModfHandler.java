package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModfDetailContext;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFCollclsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFDishnrClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFFaultClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.validate.SpValidate823012;
import cn.com.btmu.art.biz.collection.validate.SpValidate823020;
import cn.com.btmu.art.biz.collection.validate.SpValidate823028;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309701;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.base.handler.ComTriggerEventHandler;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbModChgbkDocInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dto.SeqRelation;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.smile.service.SmileConstants;
import cn.com.btmu.smile.service.SmileInvocationInstructions;

/**
 * CollectionCollModfHandler 托收修正节点用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollModfHandler extends
    ComTriggerEventHandler<CollectionCollModfDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 初始化方法，自定义初始化逻辑.
   * 
   * @return void
   */
  public void init() {
    logger.debug("CollectionCollModfHandler-init start");
    //取得退改单基本信息
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

    // 修正
    reqData.setMaintType(CollectionConstant.BB_MAINT_TYPE_3);

    // 登记日
    reqData.setRegDate(bizDataUtil.getNow());

    // 取得托收基本信息
    BcInfo bcInfo = getContext().getDataRepository().getBizDataCollection()
        .getBcInfo();

    // 托收维护操作明细赋值
    ArtBeanUtils.copyProperties(bcInfo, getContext().getDataRepository()
        .getOperationDataCollection().getBcMntnOpDtl());

    // 出口信用证维护操作明细赋值
    ExpLcMntnOpDtl expLcMntnOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getExpLcMntnOpDtl();
    ExpLcInfo expLcInfo = getContext().getDataRepository()
    	.getBizDataCollection().getExpLcInfo();
    if (null != expLcInfo){
        ArtBeanUtils.copyProperties(getContext().getDataRepository()
                .getBizDataCollection().getExpLcInfo(), expLcMntnOpDtl);
    }

    // 托收承兑操作明细赋值
    BcAccptceOpDtl bcAccptceOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getBcAccptceOpDtl();
    BcAccptceOpDtl bcAccptceOpDtl2 = getContext().getDataRepository()
    	.getBizDataCollection().getBcAccptceOpDtl();
    if (null != bcAccptceOpDtl2){
	    //将托收承兑操作明细表赋值到托收承兑基本信息表
	    ArtBeanUtils.copyProperties(getContext().getDataRepository()
	        .getBizDataCollection().getBcAccptceOpDtl(), bcAccptceOpDtl);
    }

    logger.debug("CollectionCollModfHandler-init end");
  }

  /**
   * 保存提交时数据校验.
   * 
   * @return ErrorMsgContainer 错误信息容器
   */
  @Override
  public void internalDataValidate(ErrorContainer errorContainer) throws BizException {
    logger.debug("CollectionCollModfHandler-internalDataValidate start");
    //取得出口信用证维护操作明细
    ExpLcMntnOpDtl expLcMntnOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getExpLcMntnOpDtl();
    //取得托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getBcMntnOpDtl();
    //取得寄单信息
    List<DispchDocInfo> dispchDocInfoList = getContext().getDataRepository()
        .getOperationDataCollection().getDispchDocInfoForSaveList();
    //取得系统locale
    String locale = getContext().getSystemPara().getLocale();
    //当信用证项下为Y时
    if (DataTypeConstant.DATA_TYPE_YES.equals(bcMntnOpDtl.getLcFlg())) {
    	   // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.行号】不得为空，否则报错（SP_VALIDATE_823_020）
    	SpValidate823020 spValidate82302027 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01420);
        spValidate82302027.execute(expLcMntnOpDtl.getIssueBankCode(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302028 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00839);
        spValidate82302028.execute(expLcMntnOpDtl.getIssueBankSwift(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.名称】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302029 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01720);
        spValidate82302029.execute(expLcMntnOpDtl.getIssueBankName(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.地址】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302030 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01191);
        spValidate82302030.execute(expLcMntnOpDtl.getIssueBankAddr(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302031 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01420);
        spValidate82302031.execute(expLcMntnOpDtl.getDispchDocBankCode(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302032 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00839);
        spValidate82302032.execute(expLcMntnOpDtl.getDispchDocBankSwift(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302033 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01720);
        spValidate82302033.execute(expLcMntnOpDtl.getDispchDocBankName(), errorContainer);

        // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_020）
        SpValidate823020 spValidate82302034 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01191);
        spValidate82302034.execute(expLcMntnOpDtl.getDispchDocBankAddr(), errorContainer);
    } else {
	    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_024）
    	SpValidate823020 spValidate82302410 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
	    spValidate82302410.execute(bcMntnOpDtl.getDispchDocBankCode(), errorContainer);
	
	    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_024）
	    SpValidate823020 spValidate82302411 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
	    spValidate82302411.execute(bcMntnOpDtl.getDispchDocBankSwift(), errorContainer);
	
	    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_024）
	    SpValidate823020 spValidate82302412 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
	    spValidate82302412.execute(bcMntnOpDtl.getDispchDocBankName(), errorContainer);
	
	    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_024）
	    SpValidate823020 spValidate82302413 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
	    spValidate82302413.execute(bcMntnOpDtl.getDispchDocBankAddr(), errorContainer);
    }

    // 当【画：承兑.Accepted
    // Flag】为‘Y’时，则【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.合理】不得为空，【画：承兑.远期索偿日】在【画：信用证信息.有偿付行】为‘Y’时，不得为空，否则报错（SP_VALIDATE_823_012）
    SpValidate823012 spValidate823012 = new SpValidate823012();
    spValidate823012.execute(getContext(), errorContainer);

    // 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
    SpValidate823028 spValidate82302804 = new SpValidate823028(locale);
    spValidate82302804.execute(dispchDocInfoList, errorContainer);

    // 手续费的收取方式校验：手续费不能通过特殊画面收取，只能选择手续费模块中的单独记账收取，否则报错（SP_VALIDATE_823_099）
    SpValidate82309701 spValidate82309701 = new SpValidate82309701();
    spValidate82309701.execute(getContext(), errorContainer);

    logger.debug("CollectionCollModfHandler-internalDataValidate end");
  }

  /**
   * 采号信息取得
   * 
   * @return SeqRelation 采号信息
   */
  public List<SeqRelation> getSequence() throws BizException {
    logger.debug("CollectionCollModfHandler-getSequence start");
    //定义预采号信息集合
    List<SeqRelation> preSeqList = new ArrayList<SeqRelation>();
    // 采号信息取得
    SeqRelation reqRelation = new SeqRelation(getContext().getReqData()
        .getTKind()
        + getContext().getReqData().getTxnPrmryRefNo()
        + getContext().getReqData().getTxnSubRefNo(), null);
    //添加到预采号信息集合
    preSeqList.add(reqRelation);

    logger.debug("CollectionCollModfHandler-getSequence end");
    //返回预采号信息集合
    return preSeqList;
  }

  @Override
  protected void registTriggerVisitors() throws BizException {
    logger.debug("CollectionCollModfHandler-registTriggerVisitors start");

    if (getContext().getDataRepository().getOperationDataCollection().isNeedToTrigOPFClear(getContext())) {
        //【DM：催收履历信息】未销号履历信息件数大于0
        // a- 自动触发催收拒付故障业务的‘催收销号’操作，业务状态为‘销号完成’，操作为‘催收销号’，操作状态为“完了”。
        getContext().registerVisitor(
        		CollCommonOPFCollclsTriggerVisitor.getInstance());
          
        // b- 自动触发催收拒付故障业务的‘拒付销号’操作，业务状态为‘销号完成’，操作为‘拒付销号’，操作状态为“完了”。
        getContext().registerVisitor(
        		CollCommonOPFDishnrClsTriggerVisitor.getInstance());

        //当需要触发故障销号时
        if (!getContext().getDataRepository().getOperationDataCollection().isNeedToTrigFaultClear(getContext())) {
           logger.debug("【DM：故障履历信息】未销号履历信息件数大于0");
           // c- 自动触发催收拒付故障业务的‘故障销号’操作，业务状态为‘销号完成’，操作为‘故障销号’，操作状态为“完了”。
           getContext().registerVisitor(
        		CollCommonOPFFaultClsTriggerVisitor.getInstance());
        }
    }
    logger.debug("CollectionCollModfHandler-registTriggerVisitors end");
  }
  
  @Override
  public void updateRequestData() throws BizException {
    
    //  取得托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = getContext().getReqData();
    // 分行号设置
    bcMntnOpDtl.setBranchCode(getContext().getBranchId());
    // 退改单信息分行号,交易参号设置
    BbModChgbkDocInfo bbModChgbkDocInfo = getContext().getDataRepository()
        .getOperationDataCollection().getBbModChgbkDocInfo();
    
    bbModChgbkDocInfo.setBranchCode(getContext().getBranchId());
    bbModChgbkDocInfo.setTKind(bcMntnOpDtl.getTKind());
    bbModChgbkDocInfo.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
    bbModChgbkDocInfo.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    // 承兑操作明细分行号,交易参号设置
    BcAccptceOpDtl bcAccptceOpDtl = getContext().getDataRepository().getOperationDataCollection()
    .getBcAccptceOpDtl();
    
    bcAccptceOpDtl.setBranchCode(getContext().getBranchId());
    bcAccptceOpDtl.setTKind(bcMntnOpDtl.getTKind());
    bcAccptceOpDtl.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
    bcAccptceOpDtl.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    // 出口信用证操作明细分行号设置
    getContext().getDataRepository().getOperationDataCollection()
    .getExpLcMntnOpDtl().setBranchCode(getContext().getBranchId());
    //  寄单信息分行号,交易参号设置
    for (DispchDocInfo dispchDocInfo : 
            getContext().getDataRepository().getOperationDataCollection().getDispchDocInfoForSaveList()) {
      dispchDocInfo.setBranchCode(getContext().getBranchId());
      dispchDocInfo.setTKind(bcMntnOpDtl.getTKind());
      dispchDocInfo.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
      dispchDocInfo.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    }
    //  修改履历分行号,交易参号设置
    for (ModHisDtl modHisDtl : 
      getContext().getDataRepository().getOperationDataCollection().getModHisDtlList()) {
      modHisDtl.setBranchCode(getContext().getBranchId());
      modHisDtl.setTKind(bcMntnOpDtl.getTKind());
      modHisDtl.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
      modHisDtl.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    }
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
        .debug("CollectionCollModfHandler-getSmileInvocationInstructions start");
    logger.debug("smileServiceType: " + smileServiceType);
    //实例化
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
        .debug("CollectionCollModfHandler-getSmileInvocationInstructions end");
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
