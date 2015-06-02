package cn.com.btmu.art.biz.collection.datacollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.repo.IBizDataCollection;
import cn.com.btmu.art.biz.common01biz.service.dispatchdoc.GetDispchDocInfoCommand;
import cn.com.btmu.art.biz.common01biz.service.dispatchdoc.data.GetDispchDocInfoCommandInput;
import cn.com.btmu.art.biz.common01biz.service.dispatchdoc.data.GetDispchDocInfoCommandResult;
import cn.com.btmu.art.biz.common01biz.service.locadvice.GetLCInfoWithConfirmationCommand;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.GetLCInfoWithConfirmationCommandInput;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.GetLCInfoWithConfirmationCommandResult;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.GetAllOpfInfosUnderTransactionCommand;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.GetAllOpfInfosUnderTransactionCommandInput;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.GetAllOpfInfosUnderTransactionCommandResult;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.OpfData;
import cn.com.btmu.art.biz.common01biz.util.PageCondUtil;
import cn.com.btmu.art.biz.common01biz.util.SmileUtil;
import cn.com.btmu.art.framework.bo.context.impl.DetailContext;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbCombLcInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.syscoredataset.SPgSmileInvokeInfo;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dao.ICommonDAO;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * CollectionBizDataCollection 
 * 
 * 托收业务业务信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionBizDataCollection implements IBizDataCollection {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收基本信息 */
  private BcInfo bcInfo;

  /** 出口信用证基本信息 */
  private ExpLcInfo expLcInfo;

  /** Combined LC 基本信息 */
  private List<BbCombLcInfo> bbCombLcInfoList;

  /** 托收承兑操作明细For业务 */
  private BcAccptceOpDtl bcAccptceOpDtl;

  /** 催收，拒付，故障履历信息 */
  private OpfData opfData;

  /** WSID信息For新建 */
  private SPgSmileInvokeInfo sPgSmileInvokeInfoForCreate;

  /** WSID信息For承兑 */
  private SPgSmileInvokeInfo sPgSmileInvokeInfoForAccptce;

  /** WSID信息For退改单 */
  private SPgSmileInvokeInfo sPgSmileInvokeInfoForMod;

  /** 寄单信息 */
  private List<DispchDocInfo> dispchDocInfoList;

  /**
   * 加载信用证信息
   * 
   * @return void
   */
  public void loadExpLcInfo() throws BizException {
    logger.debug("CollectionBizDataCollection-loadExpLcInfo start");
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcInfo().getLcFlg())) {
      logger.debug("【画：新建.信用证项下】为‘Y’");
      // 通过业务间函数取得指定【信用证信息】（业务间函数ID：I00200）
      GetLCInfoWithConfirmationCommand command = GetLCInfoWithConfirmationCommand
          .getInstance();
      // 参数设定
      GetLCInfoWithConfirmationCommandInput input = command.createInputData();
      // 分行编号 = 托收基本信息.分行号
      input.setBranchCode(getBcInfo().getBranchCode());
      // 信用证编号 = 托收基本信息.信用证编号
      input.setLcNo(getBcInfo().getLcNo());
      // 设置校验
      input.setSpecs(command.createLcInfoExistCheckSpec().and(
          command.createLCStatusCheckSpec()));
      // 执行句柄,取得查询结果
      GetLCInfoWithConfirmationCommandResult result = command.fire(input);
      // 当查询不成功
      if (!result.isSuccess()) {
        logger.debug("command result failed");
        throw new BizException(result.getErrList());
      }
      // 当查询成功，将【信用证信息】设置到福费廷业务业务信息数据集合
      this.expLcInfo = result.getResult().getLcInfo();
    }
    logger.debug("CollectionBizDataCollection-loadExpLcInfo end");
  }

  /**
   * 加载Combined LC 基本信息
   * 
   * @return void
   */
  public void loadBbCombLcInfo(ICommonDAO commonDAO) throws BizException {
    logger.debug("CollectionBizDataCollection-loadBbCombLcInfo start");
    // 加载Combined LC 基本信息表
    // 创建查询模板
    BbCombLcInfo template = new BbCombLcInfoImpl();
    // 设置模板查询条件
    template.setCommBizNo(getBcInfo().getSCrBizInfo().getBizInfoId());
    // 通过查询模板，获取查询结果
    BbCombLcInfo[] bbCombLcInfos = (BbCombLcInfo[]) commonDAO.queryList(
        template, PageCondUtil.getPageCond());
    // 查询结果不为空，将查询结果设置到Combined LC 基本信息
    if (bbCombLcInfos != null) {
      List<BbCombLcInfo> bbCombLcInfoList = new ArrayList<BbCombLcInfo>();
      bbCombLcInfoList.addAll(Arrays.asList(bbCombLcInfos));
      setBbCombLcInfoList(bbCombLcInfoList);
    }
    logger.debug("CollectionBizDataCollection-loadBbCombLcInfo end");
  }

  /**
   * 加载寄单信息
   * 
   * @return void
   */
  public void loadDispchDocInfo() {
    logger.debug("CollectionBizDataCollection-loadDispchDocInfo start");
    // 通过业务间函数查询【寄单信息】（业务间函数ID：I00250）
    GetDispchDocInfoCommand commandDispch = GetDispchDocInfoCommand
        .getInstance();
    // 参数设定
    GetDispchDocInfoCommandInput inputDispch = commandDispch.createInputData();
    // 分行编号 = 托收基本信息.分行号
    inputDispch.setBranchCode(getBcInfo().getBranchCode());
    // T-KIND = 托收基本信息.交易参号T-KIND
    inputDispch.setTKind(getBcInfo().getTKind());
    // 主参号 = 托收基本信息.交易参号主参号
    inputDispch.setRefNo(getBcInfo().getTxnPrmryRefNo());
    // 子参号 = 托收基本信息.交易参号子参号
    inputDispch.setSubRefNo(getBcInfo().getTxnSubRefNo());
    // 执行句柄,取得查询结果
    GetDispchDocInfoCommandResult resultDispch = commandDispch
        .fire(inputDispch);
    // 当查询成功，加载【寄单信息】
    if (null != resultDispch && resultDispch.isSuccess()) {
      logger.debug("寄单信息不为空");
      setDispchDocInfoList(resultDispch.getResult());
    }
    logger.debug("CollectionBizDataCollection-loadDispchDocInfo end");
  }

  /**
   * 加载故障履历信息
   * 
   * @return void
   */
  public void loadOPFInfo() {
    logger.debug("CollectionBizDataCollection-loadOPFInfo start");
    // 加载故障履历信息
    // 通过业务间函数查询指定交易的催收，拒付，故障履历信息（业务间函数ID：I00170）
    GetAllOpfInfosUnderTransactionCommand command = GetAllOpfInfosUnderTransactionCommand
        .getInstance();
    // 参数设定
    GetAllOpfInfosUnderTransactionCommandInput input = command
        .createInputData();
    // 分行编号 = 托收基本信息.分行号
    input.setBranchCode(getBcInfo().getBranchCode());
    // T-KIND = 托收基本信息.交易参号T-KIND
    input.setTKind(getBcInfo().getTKind());
    // 主参号 = 托收基本信息.交易参号主参号
    input.setRefNo(getBcInfo().getTxnPrmryRefNo());
    // 子参号 = 托收基本信息.交易参号子参号
    input.setSubRefNo(getBcInfo().getTxnSubRefNo());
    // 设置过滤条件
    input.setFilter(command.createUnclosedOpfInfoFilter());
    // 执行句柄,取得查询结果
    GetAllOpfInfosUnderTransactionCommandResult result = command.fire(input);
    // 当查询成功，加载【故障履历信息】
    if (result.isSuccess()) {
      logger.debug("加载故障拒付履历校验");
      if (result.getResult() != null) {
        logger.debug("故障履历信息校验");
        // 故障履历信息
        setOpfData(result.getResult());
      }
    }
    logger.debug("CollectionBizDataCollection-loadOPFInfo end");
  }

  /**
   * 加载WSID信息
   * 
   * @return void
   */
  public void loadWSIDInfo() {
    logger.debug("CollectionBizDataCollection-loadWSIDInfo start");
    // 调用业务间函数取得WSID信息（业务间函数ID：I00436）
    SmileUtil smileUtil = (SmileUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00436_UTIL_SMILE);
    // 当托收操作明细不为空
    if (getBcInfo().getBcMntnOpDtl() != null) {
      // 通过操作流水号，操作版本号，SMILE画面名取得WSID信息For新建
      setSPgSmileInvokeInfoForCreate(smileUtil.getWsid(getBcInfo()
          .getBcMntnOpDtl().getOperSn(), getBcInfo().getBcMntnOpDtl()
          .getOperVerNo(), CollectionConstant.SMILE_ID_BCONEW));
    }

    // 当承兑操作明细不为空
    if (getBcInfo().getBcAccptceOpDtl() != null) {
      // 通过操作流水号，操作版本号，SMILE画面名取得WSID信息For承兑
      setSPgSmileInvokeInfoForAccptce(smileUtil.getWsid(getBcInfo()
          .getBcAccptceOpDtl().getOperSn(), getBcInfo().getBcAccptceOpDtl()
          .getOperVerNo(), CollectionConstant.SMILE_ID_BCOCOR));
    }

    // 当退改单信息不为空
    if (getBcInfo().getBbModChgbkDocInfo() != null) {
      // 通过操作流水号，操作版本号，SMILE画面名取得WSID信息For退改单
      setSPgSmileInvokeInfoForMod(smileUtil.getWsid(getBcInfo()
          .getBbModChgbkDocInfo().getOperSn(), getBcInfo()
          .getBbModChgbkDocInfo().getOperVerNo(),
          CollectionConstant.SMILE_ID_BCOCOR));
    }
    logger.debug("CollectionBizDataCollection-loadWSIDInfo end");
  }

  /**
   * 加载承兑操作明细
   * 
   * @return void
   */
  public void loadBcAccptceOpDtl() {
    logger.debug("CollectionBizDataCollection-loadBcAccptceOpDtl start");
    // 加载托收承兑操作明细For操作
    this.bcAccptceOpDtl = getBcInfo().getBcAccptceOpDtl();
    logger.debug("CollectionBizDataCollection-loadBcAccptceOpDtl end");
  }

  /**
   * 保存子业务基本信息
   * 
   * @return void
   */
  public void saveBizData(DetailContext context) {
    logger.debug("CollectionBizDataCollection-saveBizData start");
    //业务主参号
    String commBizNo = bcInfo.getSCrBizInfo().getBizInfoId();
    ICommonDAO<ExpLcInfo> expLcInfoDAO = context.getCommonDAO();
    if (expLcInfo != null) {
      logger.debug("【出口信用证信息】不为空");
      expLcInfo.setCommBizNo(commBizNo);
      // 保存出口信用证基本信息到DB中 
      expLcInfoDAO.saveOrUpdate(expLcInfo);
    }
    // 取得Combined LC 基本信息
    ICommonDAO<BbCombLcInfo> bbCombLcInfoDAO = context.getCommonDAO();

    // 先删除【DM：Combined LC信息】的信息
    // 查询模板
    BbCombLcInfo template = new BbCombLcInfoImpl();
    // 设置查询参数
    template.setCommBizNo(commBizNo);
    // 查询
    BbCombLcInfo[] result = bbCombLcInfoDAO.queryList(template, PageCondUtil
        .getPageCond());
    // 逐条删除【DM：Combined LC信息】的信息
    if (result != null && result.length > 0) {
      for (BbCombLcInfo item : result) {
        bbCombLcInfoDAO.delete(item);
      }
    }
    // 【Combined LC基本信息】不为空时，逐条设置业务主参号
    if (bbCombLcInfoList != null) {
      logger.debug("【Combined LC基本信息】不为空");
      for (int i = 0; i < bbCombLcInfoList.size(); i++) {
        bbCombLcInfoList.get(i).setCommBizNo(commBizNo);
        bbCombLcInfoList.get(i).setSn(i);
      }
      // 保存Combined LC 基本信息到DB中
      bbCombLcInfoDAO.saveList((BbCombLcInfo[]) bbCombLcInfoList
          .toArray(new BbCombLcInfo[bbCombLcInfoList.size()]));
    }
    logger.debug("CollectionBizDataCollection-saveBizData end");
  }

  /**
   * @return dispchDocInfoList
   */
  public List<DispchDocInfo> getDispchDocInfoList() {
    return dispchDocInfoList;
  }

  /**
   * @param dispchDocInfoList
   *            要设置的 dispchDocInfoList
   */
  public void setDispchDocInfoList(List<DispchDocInfo> dispchDocInfoList) {
    this.dispchDocInfoList = dispchDocInfoList;
  }

  /**
   * @return sPgSmileInvokeInfoForCreate
   */
  public SPgSmileInvokeInfo getSPgSmileInvokeInfoForCreate() {
    return sPgSmileInvokeInfoForCreate;
  }

  /**
   * @param sPgSmileInvokeInfoForCreate
   *            要设置的 sPgSmileInvokeInfoForCreate
   */
  public void setSPgSmileInvokeInfoForCreate(
      SPgSmileInvokeInfo sPgSmileInvokeInfoForCreate) {
    this.sPgSmileInvokeInfoForCreate = sPgSmileInvokeInfoForCreate;
  }

  /**
   * @return sPgSmileInvokeInfoForAccptce
   */
  public SPgSmileInvokeInfo getSPgSmileInvokeInfoForAccptce() {
    return sPgSmileInvokeInfoForAccptce;
  }

  /**
   * @param sPgSmileInvokeInfoForAccptce
   *            要设置的 sPgSmileInvokeInfoForAccptce
   */
  public void setSPgSmileInvokeInfoForAccptce(
      SPgSmileInvokeInfo sPgSmileInvokeInfoForAccptce) {
    this.sPgSmileInvokeInfoForAccptce = sPgSmileInvokeInfoForAccptce;
  }

  /**
   * @return sPgSmileInvokeInfoForMod
   */
  public SPgSmileInvokeInfo getSPgSmileInvokeInfoForMod() {
    return sPgSmileInvokeInfoForMod;
  }

  /**
   * @param sPgSmileInvokeInfoForMod
   *            要设置的 sPgSmileInvokeInfoForMod
   */
  public void setSPgSmileInvokeInfoForMod(
      SPgSmileInvokeInfo sPgSmileInvokeInfoForMod) {
    this.sPgSmileInvokeInfoForMod = sPgSmileInvokeInfoForMod;
  }

  /**
   * @return opfData
   */
  public OpfData getOpfData() {
    return opfData;
  }

  /**
   * @param opfData 要设置的 opfData
   */
  public void setOpfData(OpfData opfData) {
    this.opfData = opfData;
  }

  /**
   * @return bcAccptceOpDtlBiz
   */
  public BcAccptceOpDtl getBcAccptceOpDtl() {
    return bcAccptceOpDtl;
  }

  /**
   * @param bcAccptceOpDtlBiz
   *            要设置的 bcAccptceOpDtlBiz
   */
  public void setBcAccptceOpDtl(BcAccptceOpDtl bcAccptceOpDtl) {
    this.bcAccptceOpDtl = bcAccptceOpDtl;
  }

  /**
   * @return bbCombLcInfoList
   */
  public List<BbCombLcInfo> getBbCombLcInfoList() {
    return bbCombLcInfoList;
  }

  /**
   * @param bbCombLcInfoList
   *            要设置的 bbCombLcInfoList
   */
  public void setBbCombLcInfoList(List<BbCombLcInfo> bbCombLcInfoList) {
    this.bbCombLcInfoList = bbCombLcInfoList;
  }

  /**
   * @return bcInfo
   */
  public BcInfo getBcInfo() {
    return bcInfo;
  }

  /**
   * @param bcInfo
   *            要设置的 bcInfo
   */
  public void setBcInfo(BcInfo bcInfo) {
    this.bcInfo = bcInfo;
  }

  /**
   * @return expLcInfo
   */
  public ExpLcInfo getExpLcInfo() {
    return expLcInfo;
  }

  /**
   * @param expLcInfo
   *            要设置的 expLcInfo
   */
  public void setExpLcInfo(ExpLcInfo expLcInfo) {
    this.expLcInfo = expLcInfo;
  }

}
