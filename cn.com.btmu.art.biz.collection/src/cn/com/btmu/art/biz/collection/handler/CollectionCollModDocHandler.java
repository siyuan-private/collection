package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonKinLcredleTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFCollclsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFDishnrClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.validate.SpValidate823017;
import cn.com.btmu.art.biz.collection.validate.SpValidate823028;
import cn.com.btmu.art.biz.collection.validate.SpValidate82303801;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309601;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309801;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309802;
import cn.com.btmu.art.biz.collection.validate.SpValidateForNotUnderLC;
import cn.com.btmu.art.biz.collection.validate.SpValidateForUnderLC;
import cn.com.btmu.art.biz.collection.validate.Warning82300101;
import cn.com.btmu.art.biz.collection.validate.Warning823003;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.base.handler.ComTriggerEventHandler;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbCombLcMntnOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbModChgbkDocInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.dto.SeqRelation;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.smile.service.SmileConstants;
import cn.com.btmu.smile.service.SmileInvocationInstructions;

import commonj.sdo.DataObject;

/**
 * CollectionCollModDocHandler 托收改单节点用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollModDocHandler extends
    ComTriggerEventHandler<CollectionCollModDocDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 初始化方法，自定义初始化逻辑.
   * 
   * @return void
   */
  public void init() {
    logger.debug("CollectionCollModDocHandler-init start");
    //取得退改单维护操作明细
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

    // 改单
    reqData.setMaintType(CollectionConstant.BB_MAINT_TYPE_1);

    // 登记日
    reqData.setRegDate(bizDataUtil.getNow());
    //取得托收基本信息
    BcInfo bcInfo = getContext().getDataRepository().getBizDataCollection()
        .getBcInfo();
    //取得托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getBcMntnOpDtl();

    // 托收维护操作明细赋值
    ArtBeanUtils.copyProperties(bcInfo, bcMntnOpDtl);
    // 设置交易子参号 + 1
    String txnSubRefNo = bcInfo.getTxnSubRefNo();
    //转换为int类型
    int subRefNoInt = Integer.parseInt(txnSubRefNo);
    ++subRefNoInt;
    if (subRefNoInt < 10) {
      logger.debug("交易子参号小于10");
      txnSubRefNo = CollectionConstant.ZERO_STRING + subRefNoInt;
    } else {
      logger.debug("交易子参号大于10");
      txnSubRefNo = ComBizConstant.COMMON_STRING_EMPTY + subRefNoInt;
    }
    //设置托收维护操作明细的交易子参号
    getContext().getDataRepository().getOperationDataCollection()
        .getBcMntnOpDtl().setTxnSubRefNo(txnSubRefNo);

    // 出口信用证维护操作明细赋值
    ExpLcMntnOpDtl expLcMntnOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getExpLcMntnOpDtl();
    ExpLcInfo expLcInfo = getContext().getDataRepository()
		.getBizDataCollection().getExpLcInfo();
    if (null != expLcInfo){
	    //将出口信用证基本信息赋值到出口信仰者维护操作明细
	    ArtBeanUtils.copyProperties(getContext().getDataRepository()
	        .getBizDataCollection().getExpLcInfo(), expLcMntnOpDtl);
    }

    // 取得Combined LC维护操作明细
    List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList = getContext()
        .getDataRepository().getOperationDataCollection()
        .getBbCombLcMntnOpDtlList();
    if (null == bbCombLcMntnOpDtlList){
    	bbCombLcMntnOpDtlList = new ArrayList<BbCombLcMntnOpDtl>();
    	getContext().getDataRepository().getOperationDataCollection()
        	.setBbCombLcMntnOpDtlList(bbCombLcMntnOpDtlList);
    }
    //清空Combined LC维护操作明细
    bbCombLcMntnOpDtlList.clear();

    // 取得Combined LC基本信息
    List<BbCombLcInfo> bbCombLcInfoList = getContext().getDataRepository()
        .getBizDataCollection().getBbCombLcInfoList();
    if (null != bbCombLcInfoList){
	    //将取得的Combined LC信息赋值到Combined LC维护操作明细中
	    for (int i = 0; i < bbCombLcInfoList.size(); i++) {
	      BbCombLcMntnOpDtl bbCombLcMntnOpDtl = new BbCombLcMntnOpDtlImpl();
	      ArtBeanUtils.copyProperties(bbCombLcInfoList.get(i), bbCombLcMntnOpDtl);
	      bbCombLcMntnOpDtlList.add(bbCombLcMntnOpDtl);
	    }
    }

    // 改单画面初期化时设定SMILE记账版块的改单前项目的初始值
    // 改单前受益人CIF
    bcMntnOpDtl.setModDocBfBeneCustNo(bcInfo.getBeneCif());
    // 改单前BC记账科目
    bcMntnOpDtl.setModDocBfBcBookAcctSubjGl(bcInfo.getBcBookAcctGl());
    bcMntnOpDtl.setModDocBfBcBookAcctSubjSubGl(bcInfo.getBcBookAcctSubGl());
    // 改单前交易主参号
    bcMntnOpDtl.setModDocBfTxnPrmryRefNo(bcInfo.getTxnPrmryRefNo());
    // 改单前交易主参号
    bcMntnOpDtl.setModDocBfTxnSubRefNo(bcInfo.getTxnSubRefNo());
    // 改单前汇票金额
    bcMntnOpDtl.setModDocBfBxCcy(bcInfo.getBxCcy());
    bcMntnOpDtl.setModDocBfBxAmt(bcInfo.getBxAmt());

    logger.debug("CollectionCollModDocHandler-init end");
  }

  /**
   * 保存提交时数据校验.
   * 
   * @return ErrorMsgContainer 错误信息容器
   */
  @Override
  public void internalDataValidate(ErrorContainer errorContainer) throws BizException {
    logger.debug("CollectionCollModDocHandler-internalDataValidate start");
    //取得托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = getContext().getDataRepository()
	    .getOperationDataCollection().getBcMntnOpDtl();
    //取得寄单信息
	List<DispchDocInfo> dispchDocInfoList = getContext().getDataRepository()
	    .getOperationDataCollection().getDispchDocInfoForSaveList();
    //获取系统locale
	String locale = getContext().getSystemPara().getLocale();
	
	// 当【画：新建.电报议付】为‘Y’时，【画：新建.电报议付销号日期】不得为空，否则报错（SP_VALIDATE_823_017）
	SpValidate823017 spValidate823017 = new SpValidate823017(locale);
	spValidate823017.execute(bcMntnOpDtl, errorContainer);
	
	// 当【画：新建.信用证项下】为‘Y’时，进行信用证项下的校验
	SpValidateForUnderLC spValidateForUnderLC = new SpValidateForUnderLC(getContext().getDataRepository().getTempDataObject(), locale);
	spValidateForUnderLC.execute(getContext().getDataRepository().getOperationDataCollection(), errorContainer);
	
	// 当【画：新建.信用证项下】为‘N’时，进行非信用证项下的校验
	SpValidateForNotUnderLC spValidateForNotUnderLC = new SpValidateForNotUnderLC(locale);
	spValidateForNotUnderLC.execute(getContext().getDataRepository().getOperationDataCollection(), errorContainer);
	
	// 【画：手续费】板块中‘单独记账’不勾选的手续费条数必须小于等于5条，否则报错（SP_VALIDATE_823_038）
	SpValidate82303801 spValidate823038 = new SpValidate82303801();
	spValidate823038.execute(getContext(), errorContainer);
	
	// 【画：费用信息.手续费账户.币种】不为空时，必须等于【画：手续费】板块所有手续费的币种，否则报错（SP_VALIDATE_823_096）
	SpValidate82309601 spValidate82309601 = new SpValidate82309601(bcMntnOpDtl.getFeeAcctCcy());
	spValidate82309601.execute(getContext(), errorContainer);
	
	// 当【画：费用信息.手续费支付方】为‘B：Buyer’时，画面上显示提示message，清算行账户请输入237中间账户（WARNING_823_001）
	Warning82300101 warning82300101 = new Warning82300101();
	warning82300101.execute(bcMntnOpDtl.getFeePayer(), errorContainer);
	
	// 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
	SpValidate823028 spValidate82302801 = new SpValidate823028(locale);
	spValidate82302801.execute(dispchDocInfoList, errorContainer);
	
	// 当【画：新建.受益人为我行客户】=‘N’时，画面显示提示message,受益人非我行客户！
	Warning823003 warning823003 = new Warning823003();
	warning823003.execute(bcMntnOpDtl.getBeneOurCustFlg(), errorContainer);

    logger.debug("CollectionCollModDocHandler-internalDataValidate end");
  }

  /**
   * 保存交易信息.
   * 
   * @return void
   */
  public void updateRequestData() throws BizException {
    logger.debug("CollectionCollModDocHandler-updateRequestData start");
    //取得托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = getContext().getReqData();
    //当操作为暂存时 
    if (ComBizConstant.COMMON_ACTION_SAVE.equals(getContext().getSystemPara()
        .getAction())) {
      //定义 ErrorContainer
      ErrorContainer errorContainer = new ErrorContainer();
      //取得tempObject
      DataObject tempObject = getContext().getDataRepository().getTempDataObject();
      //取得系统locale
      String locale = getContext().getSystemPara().getLocale();
      // 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）
      SpValidate82309801 spValidate82309801 = new SpValidate82309801(tempObject, locale);
      spValidate82309801.execute(bcMntnOpDtl, errorContainer);

      // 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）
      SpValidate82309802 spValidate82309802 = new SpValidate82309802(tempObject, locale);
      spValidate82309802.execute(bcMntnOpDtl, errorContainer);
    }
    
    // 更新【托收维护信息】的SmileExMethod信息
    getContext().getDataRepository().getOperationDataCollection().updateBcMntnOpDtl();
    
    // 分行号设置
    getContext().getReqData().setBranchCode(getContext().getBranchId());
    // 寄单信息分行号,交易参号设置
    for (DispchDocInfo dispchDocInfo : 
            getContext().getDataRepository().getOperationDataCollection().getDispchDocInfoForSaveList()) {
        dispchDocInfo.setBranchCode(getContext().getBranchId());
        dispchDocInfo.setTKind(bcMntnOpDtl.getTKind());
        dispchDocInfo.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
        dispchDocInfo.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    }
    // Combined LC 分行号,交易参号设置
    for (BbCombLcMntnOpDtl bbCombLcMntnOpDtl : 
            getContext().getDataRepository().getOperationDataCollection().getBbCombLcMntnOpDtlList()) {
            bbCombLcMntnOpDtl.setBranchCode(getContext().getBranchId());
            bbCombLcMntnOpDtl.setTKind(bcMntnOpDtl.getTKind());
            bbCombLcMntnOpDtl.setTxnPrmryRefNo(bcMntnOpDtl.getTxnSubRefNo());
            bbCombLcMntnOpDtl.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    }
    // 出口信用证操作明细分行号设置
    getContext().getDataRepository().getOperationDataCollection()
        .getExpLcMntnOpDtl().setBranchCode(getContext().getBranchId());
    // 退改单信息分行号,交易参号设置
    BbModChgbkDocInfo bbModChgbkDocInfo = getContext().getDataRepository()
        .getOperationDataCollection().getBbModChgbkDocInfo();
    
    bbModChgbkDocInfo.setBranchCode(getContext().getBranchId());
    bbModChgbkDocInfo.setTKind(bcMntnOpDtl.getTKind());
    bbModChgbkDocInfo.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
    bbModChgbkDocInfo.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    // 修改履历分行号,交易参号设置
    for (ModHisDtl modHisDtl : 
      getContext().getDataRepository().getOperationDataCollection().getModHisDtlList()) {
      modHisDtl.setBranchCode(getContext().getBranchId());
      modHisDtl.setTKind(bcMntnOpDtl.getTKind());
      modHisDtl.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
      modHisDtl.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
    }
    
    logger.debug("CollectionCollModDocHandler-updateRequestData end");
  }

  /**
   * 采号信息取得
   * 
   * @return SeqRelation 采号信息
   */
  public List<SeqRelation> getSequence() throws BizException {
    logger.debug("CollectionCollModDocHandler-getSequence start");
    //定于预采号信息集合
    List<SeqRelation> preSeqList = new ArrayList<SeqRelation>();
    // 采号信息取得
    SeqRelation reqRelation = new SeqRelation(getContext().getReqData()
        .getTKind()
        + getContext().getReqData().getTxnPrmryRefNo()
        + getContext().getReqData().getTxnSubRefNo(), null);
    //添加reqRelation
    preSeqList.add(reqRelation);

    logger.debug("CollectionCollModDocHandler-getSequence end");
    //返回preSeqList
    return preSeqList;
  }

  /**
   * 自动触发访问者注册器
   * 
   * @throws BizException
   */
  @Override
  protected void registTriggerVisitors() throws BizException {
		logger.debug("CollectionCollModDocHandler-registTriggerVisitors start");
		// 当信用证项下时，调用接口自动发起留行信用证的‘新建’操作，业务状态为‘留行完成’，操作为‘新建’，操作状态为‘完了’。
		if (getContext().getDataRepository().getOperationDataCollection()
				.isNeedToTrigLcKindle()) {
			logger.debug("【Hidden:发起留行】为‘Y’");
			getContext().registerVisitor(
					CollCommonKinLcredleTriggerVisitor.getInstance());
		}

		// a- 自动触发催收拒付故障业务的‘催收销号’操作，业务状态为‘销号完成’，操作为‘催收销号’，操作状态为“完了”。
		getContext().registerVisitor(
				CollCommonOPFCollclsTriggerVisitor.getInstance());

		// b- 自动触发催收拒付故障业务的‘拒付销号’操作，业务状态为‘销号完成’，操作为‘拒付销号’，操作状态为“完了”。
		getContext().registerVisitor(
				CollCommonOPFDishnrClsTriggerVisitor.getInstance());

		logger.debug("CollectionCollModDocHandler-registTriggerVisitors end");
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
        .debug("CollectionCollModDocHandler-getSmileInvocationInstructions start");
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
        .debug("CollectionCollModDocHandler-getSmileInvocationInstructions end");
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
