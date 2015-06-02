package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.collection.triggervisitor.CollBookingForfaitingTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollBookingNetworkInspectionTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFCollclsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFDishnrClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonOPFFaultClsTriggerVisitor;
import cn.com.btmu.art.biz.collection.validate.SpValidate823014;
import cn.com.btmu.art.biz.collection.validate.SpValidate82301501;
import cn.com.btmu.art.biz.collection.validate.SpValidate82301502;
import cn.com.btmu.art.biz.collection.validate.SpValidate823016;
import cn.com.btmu.art.biz.collection.validate.SpValidate823018;
import cn.com.btmu.art.biz.collection.validate.SpValidate823019;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302501;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302502;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302601;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302602;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302701;
import cn.com.btmu.art.biz.collection.validate.SpValidate82302702;
import cn.com.btmu.art.biz.collection.validate.SpValidate823028;
import cn.com.btmu.art.biz.collection.validate.SpValidate823031;
import cn.com.btmu.art.biz.collection.validate.SpValidate823034;
import cn.com.btmu.art.biz.collection.validate.SpValidate82303502;
import cn.com.btmu.art.biz.collection.validate.SpValidate823036;
import cn.com.btmu.art.biz.collection.validate.SpValidate82303802;
import cn.com.btmu.art.biz.collection.validate.Warning82300101;
import cn.com.btmu.art.biz.collection.validate.Warning823002;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.base.handler.ComTriggerEventHandler;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcBookOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dto.SeqRelation;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.smile.service.SmileConstants;
import cn.com.btmu.smile.service.SmileInvocationInstructions;

/**
 * CollectionCollBookingHandler 托收入账节点用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollBookingHandler extends
    ComTriggerEventHandler<CollectionCollBookingDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 初始化方法，自定义初始化逻辑.
   * 
   * @return void
   */
  @Override
  public void init() throws BizException {
    logger.debug("CollectionCollBookingHandler-init start");
    //获取托收入账维护操作明细
    BcBookOpDtlImpl reqData = getContext().getReqData();

    // 获取托收基本信息
    BcInfo bcInfo = getContext().getDataRepository().getBizDataCollection()
        .getBcInfo();

    // 取得系统日期的方法
    DateUtil bizDateUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);

    // 福费廷 不勾选
    reqData.setForftingFlg(DataTypeConstant.DATA_TYPE_NO);

    // 头寸日 系统日期 - 2个工作日
    bizDateUtil
        .getStartDate(bizDateUtil.getNow(), CollectionConstant.INTEGER_2);

    // 头寸金额 币种设为托收基本信息汇票币种
    reqData.setPosCcy(bcInfo.getBxCcy());

    // 我行对客入账日 系统日期
    reqData.setOurBankToCustBookingDate(bizDateUtil.getNow());

    // 进待核查 不勾选
    reqData.setValidatnFlg(DataTypeConstant.DATA_TYPE_NO);

    // 清算行账户币种 设为托收基本信息币种汇票币种
    reqData.setClrBankAcctCcy(bcInfo.getBxCcy());

    // 清算行账户GL 设为托收基本信息清算行账户GL
    reqData.setClrBankAcctGl(bcInfo.getClrBankAcctGl());

    // 清算行账户SUB 设为托收基本信息清算行账户SUB
    reqData.setClrBankAcctSubGl(bcInfo.getClrBankAcctSubGl());

    // 清算行账户账号 设为托收基本信息清算行账户账号
    reqData.setClrBankAcctNo(bcInfo.getClrBankAcctNo());

    // 他行扣款金额 币种 设为托收基本信息币种汇票币种
    reqData.setTheirDedctCcy(bcInfo.getBxCcy());

    // 手续费支付方 设为托收基本信息手续费支付方
    reqData.setFeePayer(bcInfo.getFeePayer());

    // 手续费账户币种 设为托收基本信息手续费账户币种
    reqData.setFeeAcctCcy(bcInfo.getFeeAcctCcy());

    // 手续费账户GL 设为托收基本信息手续费账户GL
    reqData.setFeeAcctGl(bcInfo.getFeeAcctGl());

    // 手续费账户SUB 设为托收基本信息手续费账户SUB
    reqData.setFeeAcctSubGl(bcInfo.getFeeAcctSubGl());

    // 手续费账户账号 设为托收基本信息手续费账户账号
    reqData.setFeeAcctNo(bcInfo.getFeeAcctNo());

    // N/W区分 设为托收基本信息N/W区分
    reqData.setNoWfDist(bcInfo.getNoWfDist());

    // 入两个账户 不勾选
    reqData.setEnter2AcctFlg(DataTypeConstant.DATA_TYPE_NO);

    // 对方银行国别 请选择
    reqData.setCounterPartyCountry(ComBizConstant.COMMON_STRING_EMPTY);

    // 对方银行省份 请选择
    reqData.setCounterPartyProv(ComBizConstant.COMMON_STRING_EMPTY);

    // 对方银行城市 请选择
    reqData.setCounterPartyCity(ComBizConstant.COMMON_STRING_EMPTY);

    // 入账账户#1 币种 设为托收基本信息受益人账户币种
    reqData.setBookAcctCcy1(bcInfo.getBene1stAcctCcy());

    // 入账账户#1 GL 设为托收基本信息受益人账户GL
    reqData.setBookAcctGl1(bcInfo.getBene1stAcctGl());

    // 入账账户#1 SUB 设为托收基本信息受益人账户SUB
    reqData.setBookAcctSubGl1(bcInfo.getBene1stAcctSubGl());

    // 入账账户#1 账号 设为托收基本信息受益人账户账号
    reqData.setBookAcctNo1(bcInfo.getBene1stAcctNo());

    // 金额#1 设为托收基本信息币种汇票币种
    reqData.setCcy1(bcInfo.getBxCcy());

    // 定价金额#1 设为托收基本信息币种汇票币种
    reqData.setPrcCcy1(bcInfo.getBxCcy());

    // 入账金额#1 托收基本信息;受益人账户币种
    reqData.setBookCcy1(bcInfo.getBeneAcctCcy());

    logger.debug("CollectionCollBookingHandler-init end");
  }

  /**
   * 保存提交时数据校验.
   * 
   * @return ErrorMsgContainer 错误信息容器
   * @throws BizException
   */
  @Override
  public void internalDataValidate(ErrorContainer errorContainer) throws BizException {
    logger.debug("CollectionCollBookingHandler-internalDataValidate start");

    //获取寄单信息
    List<DispchDocInfo> dispchDocInfoList = getContext().getDataRepository()
        .getOperationDataCollection().getDispchDocInfoForSaveList();
    //获取入账操作明细
    BcBookOpDtl bcBookOpDtl = getContext().getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl();
    //获取系统locale
    String locale = getContext().getSystemPara().getLocale();
    //判断是否为询价前
    if (getContext().isBeforPricing()) {
      logger.debug("询价前");
      // 当【画：入账.福费廷】勾选时，【画：单据信息.有追索权】必须为‘N’，否则报错（SP_VALIDATE_823_014）
      SpValidate823014 spValidate823014 = new SpValidate823014();
      spValidate823014.execute(getContext(), errorContainer);

      // 当【画：入账.福费廷】勾选时，【画：承兑.Accepted
      // Flag】必须为‘Y’，否则报错（SP_VALIDATE_823_034）
      SpValidate823034 spValidate823034 = new SpValidate823034();
      spValidate823034.execute(getContext(), errorContainer);
    }

    // 当【画：入账.进待核查】勾选时，【画：入账.待核查账户】不得为空，否则报错（SP_VALIDATE_823_026）[※币种，GL，SUB
    // GL，账号都不得为空]
    SpValidate82302601 spValidate82302601 = new SpValidate82302601();
    spValidate82302601.execute(getContext(), errorContainer);

    // 当【画：入账.进待核查】勾选时，【画：入账.客户等级】不得为空，否则报错（SP_VALIDATE_823_026）
    SpValidate82302602 spValidate82302602 = new SpValidate82302602();
    spValidate82302602.execute(getContext(), errorContainer);

    // 当【画：入账.福费廷】不勾选时，【画：入账.对手方银行国别.国家】不得为空，否则报错（SP_VALIDATE_823_036）
    SpValidate823036 spValidate823036 = new SpValidate823036();
    spValidate823036.execute(getContext(), errorContainer);

    // 当【画：入账.对手方银行国别.国家】为‘CHN’时,【画：入账.对手方银行国别.省】不得为空，否则报错（SP_VALIDATE_823_035）
    SpValidate82303502 spValidate82303503 = new SpValidate82303502(bcBookOpDtl
        .getCounterPartyProv(), locale);
    spValidate82303503.execute(bcBookOpDtl, errorContainer);

    // 当【画：入账.对手方银行国别.国家】为‘CHN’时,【画：入账.对手方银行国别.市】不得为空，否则报错（SP_VALIDATE_823_035）
    SpValidate82303502 spValidate82303504 = new SpValidate82303502(bcBookOpDtl
        .getCounterPartyCity(), locale);
    spValidate82303504.execute(bcBookOpDtl, errorContainer);

    if (getContext().isBeforPricing()) {
      logger.debug("询价前");
      // 当【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#1.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
      SpValidate82301501 spValidate82301501 = new SpValidate82301501();
      spValidate82301501.execute(getContext(), errorContainer);

      // 当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#2.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
      SpValidate82301502 spValidate82301502 = new SpValidate82301502();
      spValidate82301502.execute(getContext(), errorContainer);

      // 当【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#1.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
      SpValidate82302501 spValidate82302501 = new SpValidate82302501();
      spValidate82302501.execute(getContext(), errorContainer);

      // 当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#2.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
      SpValidate82302502 spValidate82302502 = new SpValidate82302502();
      spValidate82302502.execute(getContext(), errorContainer);

      // 当【画：入账.入两个账户】不勾选时，【画：入账.金额#1.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_031）
      SpValidate823031 spValidate823031 = new SpValidate823031();
      spValidate823031.execute(getContext(), errorContainer);

      // 当【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价（SP_VALIDATE_823_018）
      SpValidate823018 spValidate823018 = new SpValidate823018();
      spValidate823018.execute(getContext(), errorContainer);
    }

    // 当【画：入账.入两个账户】勾选时，【画：入账.入账账户#2】不得为空，否则报错（SP_VALIDATE_823_02701）
    SpValidate82302701 spValidate82302701 = new SpValidate82302701();
    spValidate82302701.execute(getContext(), errorContainer);

    if (getContext().isBeforPricing()) {
      logger.debug("询价前");
      // 当【画：入账.入两个账户】勾选时，【画：入账.金额#2.金额】不得为空，否则报错（SP_VALIDATE_823_027）
      SpValidate82302702 spValidate82302702 = new SpValidate82302702();
      spValidate82302702.execute(getContext(), errorContainer);

      // 当【画：入账.入两个账户】勾选时，【画：入账.金额#1.金额】+【画：入账.金额#2.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_016）
      SpValidate823016 spValidate823016 = new SpValidate823016();
      spValidate823016.execute(getContext(), errorContainer);

      // 当【画：入账.入两个账户】勾选且【画：入账.入账账户#2.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价（SP_VALIDATE_823_019）
      SpValidate823019 spValidate823019 = new SpValidate823019();
      spValidate823019.execute(getContext(), errorContainer);
    }

    // 【画：手续费】板块中‘单独记账’不勾选的手续费条数必须小于等于5条，否则报错（SP_VALIDATE_823_038）
    SpValidate82303802 spValidate82303802 = new SpValidate82303802();
    spValidate82303802.execute(getContext(), errorContainer);

    // 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
    SpValidate823028 spValidate82302803 = new SpValidate823028(locale);
    spValidate82302803.execute(dispchDocInfoList, errorContainer);

    // 当【画：入账.手续费支付方】为‘B：Buyer’时，画面上显示提示message，清算行账户请输入237中间账户（WARNING_823_001）
    Warning82300101 warning82300101 = new Warning82300101();
    warning82300101.execute(bcBookOpDtl.getFeePayer(), errorContainer);

    // 当客户CIF存在于不申报不解付黑名单时，画面显示提示message,该客户存在于不申报不解付黑名单中，是否还要继续？（WARNING_823_002）
    Warning823002 warning823002 = new Warning823002();
    warning823002.execute(getContext(), errorContainer);

    logger.debug("CollectionCollBookingHandler-internalDataValidate end");
  }

  /**
   * 复核通过时数据校验.
   * 
   * @return ErrorMsgContainer 错误信息容器
   * @throws BizException
   */
  @Override
  public void checkValidate(ErrorContainer errorContainer) throws BizException {
    logger.debug("CollectionCollBookingHandler-checkValidate start");
    // 当客户CIF存在于不申报不解付黑名单时，画面显示提示message,该客户存在于不申报不解付黑名单中，是否还要继续？（WARNING_823_002）
    // 校验方法：调用组件列表【E90240】，参数：分行号，客户CIF，黑名单类型（
    // 10.不申报不解付名单），若组件返回值不为0，则提示Message。
    Warning823002 warning823002 = new Warning823002();
    warning823002.execute(getContext(), errorContainer);

    logger.debug("CollectionCollBookingHandler-checkValidate end");
  }

  /**
   * 采号信息取得
   * 
   * @return SeqRelation 采号信息
   */
  public List<SeqRelation> getSequence() throws BizException {
    logger.debug("CollectionCollBookingHandler-getSequence start");
    //定义采号信息集合
    List<SeqRelation> preSeqList = new ArrayList<SeqRelation>();
    // 采号信息取得
    SeqRelation reqRelation = new SeqRelation(getContext().getReqData()
        .getTKind()
        + getContext().getReqData().getTxnPrmryRefNo()
        + getContext().getReqData().getTxnSubRefNo(), null);
    //添加采号信息
    preSeqList.add(reqRelation);

    logger.debug("CollectionCollBookingHandler-getSequence end");
    //返回采号信息集合
    return preSeqList;
  }
  
  /**
   * 保存交易信息.
   * 
   * @return void
   */
  public void updateRequestData() throws BizException {
    //获取托收入账维护操作明细
    BcBookOpDtlImpl reqData = getContext().getReqData();
    // 获取托收基本信息
    BcInfo bcInfo = getContext().getDataRepository().getBizDataCollection()
        .getBcInfo();
    // 分行号设置
    reqData.setBranchCode(getContext().getBranchId());
    // T-Kind
    reqData.setTKind(bcInfo.getTKind());
    // 交易主参号
    reqData.setTxnPrmryRefNo(bcInfo.getTxnPrmryRefNo());
    // 交易子参号
    reqData.setTxnSubRefNo(bcInfo.getTxnSubRefNo());
    
    // 寄单信息分行号，交易参号设置
    for (DispchDocInfo dispchDocInfo : 
            getContext().getDataRepository().getOperationDataCollection().getDispchDocInfoForSaveList()) {
        dispchDocInfo.setBranchCode(getContext().getBranchId());
        dispchDocInfo.setTKind(bcInfo.getTKind());
        dispchDocInfo.setTxnPrmryRefNo(bcInfo.getTxnPrmryRefNo());
        dispchDocInfo.setTxnSubRefNo(bcInfo.getTxnSubRefNo());
        
    }
  }
  
  
  /**
   * 自动触发访问者注册器
   * 
   * @throws BizException
   */
  @Override
  protected void registTriggerVisitors() throws BizException {
    logger.debug("CollectionCollBookingHandler-registTriggerVisitors start");

    // 当【画：入账.福费廷】勾选时，调用接口自动发起福费廷新建业务，业务状态为空，操作为‘新建’，操作状态为‘等待提交’。
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getContext()
        .getReqData().getForftingFlg())) {
      logger.debug("【画：入账.福费廷】勾选");
      getContext().registerVisitor(
          CollBookingForfaitingTriggerVisitor.getInstance());
    }

    // 当【画：入账.进待核查】勾选时，调用接口自动发起联网核查，业务状态为‘新建完成’，操作为‘新建’，操作状态为‘完了’。
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getContext()
        .getDataRepository().getOperationDataCollection().getBcBookOpDtl()
        .getValidatnFlg())) {
      logger.debug("【画：入账.进待核查】勾选");
      getContext().registerVisitor(
          CollBookingNetworkInspectionTriggerVisitor.getInstance());
    }

    // a- 自动触发催收拒付故障业务的‘催收销号’操作，业务状态为‘销号完成’，操作为‘催收销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFCollclsTriggerVisitor.getInstance());
    
    // b- 自动触发催收拒付故障业务的‘拒付销号’操作，业务状态为‘销号完成’，操作为‘拒付销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFDishnrClsTriggerVisitor.getInstance());
    
    // c- 自动触发催收拒付故障业务的‘故障销号’操作，业务状态为‘销号完成’，操作为‘故障销号’，操作状态为“完了”。
    getContext().registerVisitor(
    		CollCommonOPFFaultClsTriggerVisitor.getInstance());
    
    logger.debug("CollectionCollBookingHandler-registTriggerVisitors end");
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
        .debug("CollectionCollBookingHandler-getSmileInvocationInstructions start");
    logger.debug("smileServiceType: " + smileServiceType);
    //实例化smile服务信息
    SmileInvocationInstructions instructions = new SmileInvocationInstructions();

    // simle调用时，是上传还是校验的判断方法待定
    if (ComBizConstant.SMILE_SERVICE_TYPE_CHECK.equals(smileServiceType)) {
      // 设置本次调用服务ID
      instructions
          .setServiceId(CollectionConstant.SMILE_SERVICE_ID_COLLECTION_CHECK);
      // 设置本次调用服务类型
      instructions.setServiceType(SmileConstants.SMILE_SERVICE_TYPE_CHECK);
    } else {
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
        .debug("CollectionCollBookingHandler-getSmileInvocationInstructions end");
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
