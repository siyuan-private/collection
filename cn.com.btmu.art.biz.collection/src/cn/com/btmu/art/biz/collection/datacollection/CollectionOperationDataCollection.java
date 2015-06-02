package cn.com.btmu.art.biz.collection.datacollection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.BizCodeIdConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.service.dispatchdoc.SaveDispchDocInfoCommand;
import cn.com.btmu.art.biz.common01biz.service.dispatchdoc.data.SaveDispchDocInfoCommandInput;
import cn.com.btmu.art.biz.common01biz.service.locadvice.UpdateExpLcBalanceInfoCommand;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.ExpLcInfoBalanceUpdateData;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.UpdateExpLcBalanceInfoCommandInput;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.CollectionCalculatCommand;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.OpfData;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.RegistInfoInput;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.RegistInfoResult;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.biz.common01biz.util.PageCondUtil;
import cn.com.btmu.art.component.autocomplete.AutoMemoryUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbCombLcMntnOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbModChgbkDocInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcAccptceOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;
import cn.com.btmu.art.framework.bo.domain.brdataset.impl.ModHisDtlImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.DispchDocInfoImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.ExpLcMntnOpDtlImpl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dao.ICommonDAO;

import com.eos.system.utility.StringUtil;
import commonj.sdo.DataObject;

/**
 * CollectionOperationDataCollection
 * 
 * 托收业务操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionOperationDataCollection {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收维护操作明细 */
  private BcMntnOpDtl bcMntnOpDtl;

  /** 托收入账操作明细 */
  private BcBookOpDtl bcBookOpDtl;

  /** 托收承兑操作明细For操作 */
  private BcAccptceOpDtl bcAccptceOpDtl;

  /** 出口信用证维护操作明细 */
  private ExpLcMntnOpDtl expLcMntnOpDtl;

  /** Combined LC 维护操作明细 */
  private List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList;

  /** 寄单信息For save */
  private List<DispchDocInfo> dispchDocInfoForSaveList;

  /** 退改单信息 */
  private BbModChgbkDocInfo bbModChgbkDocInfo;

  /** 修改履历信息 */
  private List<ModHisDtl> modHisDtlList;

  /** 主信用证信息 */
  private ExpLcInfo mainLcInfo;

  /** 合并信用证信息 */
  private List<ExpLcInfo> combinedLcInfo;

  /** 催收,拒付,故障信息 */
  private OpfData opfData;

  /**
   * 取得催收,拒付,故障信息
   * 
   * @return OpfData 催收,拒付,故障信息
   */
  public OpfData getOpfData() {
    return opfData;
  }

  /**
   * 设定催收,拒付,故障信息
   * 
   * @param OpfData 催收,拒付,故障信息
   */
  public void setOpfData(OpfData opfData) {
    this.opfData = opfData;
  }

  /**
   * 取得退改单信息
   * 
   * @return bbModChgbkDocInfo
   */
  public BbModChgbkDocInfo getBbModChgbkDocInfo() {
    return bbModChgbkDocInfo;
  }

  /**
   * 设置退改单信息
   * 
   * @param bbModChgbkDocInfo
   */
  public void setBbModChgbkDocInfo(BbModChgbkDocInfo bbModChgbkDocInfo) {
    this.bbModChgbkDocInfo = bbModChgbkDocInfo;
  }

  /**
   * 取得Combined LC 维护操作明细
   * 
   * @return bbCombLcMntnOpDtlList Combined LC 维护操作明细
   */
  public List<BbCombLcMntnOpDtl> getBbCombLcMntnOpDtlList() {
    return bbCombLcMntnOpDtlList;
  }

  /**
   * 设定Combined LC维护操作明细
   * 
   * @param BbCombLcMntnOpDtl Combined LC维护操作明细
   */
  public void setBbCombLcMntnOpDtlList(
      List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList) {
    this.bbCombLcMntnOpDtlList = bbCombLcMntnOpDtlList;
  }

  /**
   * 取得寄单信息
   * 
   * @return DispchDocInfo 寄单信息
   */
  public List<DispchDocInfo> getDispchDocInfoForSaveList() {
    return dispchDocInfoForSaveList;
  }

  /**
   * 设定寄单信息 用于保存当前节点新增条目用
   * 
   * @param dispchDocInfoForSaveList 寄单信息
   */
  public void setDispchDocInfoForSaveList(
      List<DispchDocInfo> dispchDocInfoForSaveList) {
    this.dispchDocInfoForSaveList = dispchDocInfoForSaveList;
  }

  /**
   * 取得托收承兑操作明细.
   * 
   * @return BcAccptceOpDtl 托收承兑操作明细
   */
  public BcAccptceOpDtl getBcAccptceOpDtl() {
    return bcAccptceOpDtl;
  }

  /**
   * 设定托收承兑操作明细.
   * 
   * @param bcAccptceOpDtl 托收承兑操作明细
   */
  public void setBcAccptceOpDtl(BcAccptceOpDtl bcAccptceOpDtl) {
    this.bcAccptceOpDtl = bcAccptceOpDtl;
  }

  /**
   * 取得入账操作明细
   * 
   * @return bcBookOpDtl 入账操作明细
   */
  public BcBookOpDtl getBcBookOpDtl() {
    return bcBookOpDtl;
  }

  /**
   * 设定托收承兑操作明细
   * 
   * @param bcBookOpDtl 入账操作明细
   */
  public void setBcBookOpDtl(BcBookOpDtl bcBookOpDtl) {
    this.bcBookOpDtl = bcBookOpDtl;
  }

  /**
   * 取得托收维护操作明细.
   *  
   * @return bcMntnOpDtl 托收维护操作明细
   */
  public BcMntnOpDtl getBcMntnOpDtl() {
    return bcMntnOpDtl;
  }

  /**
   * 设定托收维护操作明细.
   * 
   * @param bcMntnOpDtl 托收维护操作明细
   */
  public void setBcMntnOpDtl(BcMntnOpDtl bcMntnOpDtl) {
    this.bcMntnOpDtl = bcMntnOpDtl;
  }

  /**
   * 取得出口信用证维护操作明细.
   * 
   * @return expLcMntnOpDtl 出口信用证维护操作明细
   */
  public ExpLcMntnOpDtl getExpLcMntnOpDtl() {
    return expLcMntnOpDtl;
  }

  /**
   * 设置出口信用证维护操作明细.
   * 
   * @param expLcMntnOpDtl 出口信用证维护操作明细
   */
  public void setExpLcMntnOpDtl(ExpLcMntnOpDtl expLcMntnOpDtl) {
    this.expLcMntnOpDtl = expLcMntnOpDtl;
  }

  /**
   * 取得修改履历明细.
   * 
   * @return modHisDtlList 修改履历明细
   */
  public List<ModHisDtl> getModHisDtlList() {
    return modHisDtlList;
  }

  /**
   * 设置修改履历明细.
   * 
   * @param modHisDtlList 修改履历明细
   */
  public void setModHisDtlList(List<ModHisDtl> modHisDtlList) {
    this.modHisDtlList = modHisDtlList;
  }

  /**
   * 取得Combined LC 信息
   * 
   * @return combinedLcInfo Combined LC 信息
   */
  public List<ExpLcInfo> getCombinedLcInfo() {
    return combinedLcInfo;
  }

  /**
   * 设置 Combined LC 信息
   * 
   * @param combinedLcInfo Combined LC 信息
   */
  public void setCombinedLcInfo(List<ExpLcInfo> combinedLcInfo) {
    this.combinedLcInfo = combinedLcInfo;
  }

  /**
   * 取得主信用证信息
   * 
   * @return mainLcInfo
   */
  public ExpLcInfo getMainLcInfo() {
    return mainLcInfo;
  }

  /**
   * 设置主信用证信息
   * 
   * @param mainLcInfo 要设置的 mainLcInfo
   */
  public void setMainLcInfo(ExpLcInfo mainLcInfo) {
    this.mainLcInfo = mainLcInfo;
  }

  /**
   * 判定是否需要保存信用证信息
   * 
   * @return 需要保存true，否则false
   */
  public boolean isNeedSaveLcInfo() {
    logger.debug("CollectionOperationDataCollection-isNeedSaveLcInfo start");
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getLcFlg())) {
      logger.debug("信用证项下为‘Y’，isNeedSaveLcInfo-true");
      logger.debug("CollectionOperationDataCollection-isNeedSaveLcInfo end");
      return true;
    }
    logger.debug("信用证项下不为‘Y’，isNeedSaveLcInfo-false");
    logger.debug("CollectionOperationDataCollection-isNeedSaveLcInfo end");
    return false;
  }
  
  /**
   * 判定是否需要保存【Combined LC维护操作明细】
   * 
   * @return 需要保存true，否则false
   */
  public boolean isNeedSaveCombinedLC() {
    logger.debug("CollectionOperationDataCollection-isNeedSaveCombinedLC start");
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getCombinedLcFlg())) {
      logger.debug("Combined LC为‘Y’，isNeedSaveCombinedLC-true");
      logger.debug("CollectionOperationDataCollection-isNeedSaveCombinedLC end");
      return true;
    }
    logger.debug("Combined LC不为‘Y’，isNeedSaveCombinedLC-false");
    logger.debug("CollectionOperationDataCollection-isNeedSaveCombinedLC end");
    return false;
  }

  /**
   * 判定是否需要删除信用证信息
   * 
   * @param bcInfo 托收基本信息
   * @return 需要删除true，否则false
   */
  public boolean isNeedDeleteLcInfo(BcInfo bcInfo) {
	  logger.debug("CollectionOperationDataCollection-isNeedDeleteLcInfo start");
	  if (null == bcInfo) {
		  return false;
	  }

		if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcInfo.getLcFlg())
				&& !DataTypeConstant.DATA_TYPE_YES
						.equalsIgnoreCase(getBcMntnOpDtl().getLcFlg())) {
			logger.debug("业务表信用证项下为‘Y’，操作表信用证项下不为‘Y’，isNeedDeleteLcInfo-true");
			logger
					.debug("CollectionOperationDataCollection-isNeedDeleteLcInfo end");
			return true;
		}
		logger.debug("isNeedDeleteLcInfo-false");
		logger
				.debug("CollectionOperationDataCollection-isNeedDeleteLcInfo end");
		return false;
	}

  /**
   * 判定是否需要删除承兑业务信息
   * 
   * @param bizBcAccptceData 承兑业务信息
   * @return 需要删除true，否则false
   */
  public boolean isNeedClearAcceptanceInBizInfo(BcAccptceOpDtl bizBcAccptceData) {
    logger
        .debug("CollectionOperationDataCollection-isNeedClearAcceptanceInBizInfo start");
    // 当业务信息承兑flag为‘Y’，操作信息承兑flag不为‘Y’
    if (bizBcAccptceData != null
        && DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bizBcAccptceData
            .getAcceptedFlg())) {
      if (!DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcAccptceOpDtl()
          .getAcceptedFlg())) {
        // 需要删除承兑业务信息
        logger.debug("isNeedClearAcceptanceInBizInfo-true");
        logger
            .debug("CollectionOperationDataCollection-isNeedClearAcceptanceInBizInfo end");
        return true;
      }
    }
    // 否则不需要删除承兑业务信息
    logger.debug("isNeedClearAcceptanceInBizInfo-false");
    logger
        .debug("CollectionOperationDataCollection-isNeedClearAcceptanceInBizInfo end");
    return false;
  }

  /**
   * 判定是否需要进行留行信用证新建的触发处理
   * @return 需要触发true，否则false
   */
  public boolean isNeedToTrigLcKindle() {
    logger
        .debug("CollectionOperationDataCollection-isNeedToTrigLcKindle start");
    // 信用证操作明细为空，不需要留行信用证新建的触发处理
    if (getExpLcMntnOpDtl() == null) {
      logger.debug("信用证操作明细为空");
      logger
          .debug("CollectionOperationDataCollection-isNeedToTrigLcKindle end");
      return false;
    }
    //  判定是否需要进行留行信用证新建的触发处理
    if (ArtStringUtil.equals(DataTypeConstant.DATA_TYPE_YES,
        getExpLcMntnOpDtl().getKibLcFlg())
        && !ArtStringUtil.equals(DataTypeConstant.DATA_TYPE_YES,
            getMainLcInfo().getKibLcFlg())) {
      logger.debug("isNeedToTrigLcKindle-true");
      logger
          .debug("CollectionOperationDataCollection-isNeedToTrigLcKindle end");
      // 需要进行留行信用证新建的触发处理
      return true;
    }
    logger.debug("isNeedToTrigLcKindle-false");
    logger.debug("CollectionOperationDataCollection-isNeedToTrigLcKindle end");
    // 不需要进行留行信用证新建的触发处理
    return false;
  }
  
  /**
   * 加载【出口信用证维护操作明细】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void loadExpLcMntnOpDtl(String operSn, int operVerNo,
      ICommonDAO commonDAO) {
    logger.debug("CollectionOperationDataCollection-loadExpLcMntnOpDtl start");
    // 当【画：新建.信用证项下】为'Y'
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getLcFlg())) {
      logger.debug("【画：新建.信用证项下】为'Y'");
      // 设置查询模板
      ExpLcMntnOpDtl temp = new ExpLcMntnOpDtlImpl();
      // 设置查询条件 ：操作流水号
      temp.setOperSn(operSn);
      // 设置查询条件 ：操作版本号
      temp.setOperVerNo(operVerNo);
      // 查询并加载【出口信用证维护操作明细】
      expLcMntnOpDtl = (ExpLcMntnOpDtl) commonDAO.query(temp);
    }
    logger.debug("CollectionOperationDataCollection-loadExpLcMntnOpDtl end");
  }

  /**
   * 加载【Combined LC维护操作明细】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void loadBbCombLcMntnOpDtlList(String operSn, int operVerNo,
      ICommonDAO commonDAO) {

    logger
        .debug("CollectionOperationDataCollection-loadBbCombLcMntnOpDtlList start");
    // 当【画：信用证信息.Combined LC】为'Y'，加载数据
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getCombinedLcFlg())) {
      logger.debug("【画：信用证信息.Combined LC】为'Y'");
      BbCombLcMntnOpDtl temp = new BbCombLcMntnOpDtlImpl();
      // 设置查询条件 ：操作流水号
      temp.setOperSn(operSn);
      // 设置查询条件 ：操作版本号
      temp.setOperVerNo(operVerNo);
      // 查询【Combined LC维护操作明细】
      BbCombLcMntnOpDtl[] bbCombLcMntnOpDtls = (BbCombLcMntnOpDtl[]) commonDAO
          .queryList(temp, PageCondUtil.getPageCond());
      // 当查询结果不为空
      if (bbCombLcMntnOpDtls != null) {
        // 加载【Combined LC维护操作明细】
        List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlLst = new ArrayList<BbCombLcMntnOpDtl>();
        bbCombLcMntnOpDtlLst.addAll(Arrays.asList(bbCombLcMntnOpDtls));
        bbCombLcMntnOpDtlList = bbCombLcMntnOpDtlLst;
      }
    }
    logger
        .debug("CollectionOperationDataCollection-loadBbCombLcMntnOpDtlList end");

  }

  /**
   * 加载【承兑维护操作明细】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void loadBcAccptceOpDtl(String operSn, int operVerNo,
      ICommonDAO commonDAO) {
    logger.debug("CollectionOperationDataCollection-loadBcAccptceOpDtl start");
    // 当托收承兑操作流水号不为空
    if (null != getBcAccptceOpDtl() && !StringUtil.isBlank(getBcAccptceOpDtl().getOperSn())) {
      logger.debug("托收承兑操作流水号不为空");
      // 设置查询模板
      BcAccptceOpDtl temp = new BcAccptceOpDtlImpl();
      // 设置查询条件 ：操作流水号
      temp.setOperSn(operSn);
      // 设置查询条件 ：操作版本号
      temp.setOperVerNo(operVerNo);
      // 查询并加载【承兑维护操作明细】
      bcAccptceOpDtl = (BcAccptceOpDtl) commonDAO.query(temp);
      if(bcAccptceOpDtl == null) {
        bcAccptceOpDtl.setAcceptedFlg(DataTypeConstant.DATA_TYPE_NO);
      }

    }
    logger.debug("CollectionOperationDataCollection-loadBcAccptceOpDtl end");
  }

  /**
   * 获取流程中暂存的寄单信息
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void loadDispchDocInfo(String operSn, int operVerNo,
      ICommonDAO commonDAO) {
    logger.debug("CollectionOperationDataCollection-loadDispchDocInfo start");
    // 设置查询模板
    DispchDocInfo template = new DispchDocInfoImpl();
    // 设置查询条件 ：操作流水号
    template.setOperSn(operSn);
    // 设置查询条件 ：操作版本号
    template.setOperVerNo(operVerNo);
    // 查询【寄单信息】
    DispchDocInfo[] dispchDocInfoList = (DispchDocInfo[]) commonDAO.queryList(
        template, PageCondUtil.getPageCond());
    // 【寄单信息】查询结果
    List<DispchDocInfo> dispchDocInfos = new ArrayList<DispchDocInfo>();
    dispchDocInfos.addAll(Arrays.asList(dispchDocInfoList));
    // 获取流程中暂存的寄单信息
    setDispchDocInfoForSaveList(dispchDocInfos == null ? null : dispchDocInfos);
    logger.debug("CollectionOperationDataCollection-loadDispchDocInfo end");
  }

  /**
   * 加载【退改单信息】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void loadBbModChgbkDocInfo(String operSn, int operVerNo,
      ICommonDAO commonDAO) {
    logger
        .debug("CollectionOperationDataCollection-loadBbModChgbkDocInfo start");
    // 设置查询模板
    BbModChgbkDocInfo temp = new BbModChgbkDocInfoImpl();
    // 设置查询条件 ：操作流水号
    temp.setOperSn(operSn);
    // 设置查询条件 ：操作版本号
    temp.setOperVerNo(operVerNo);
    // 查询并加载【退改单信息】
    bbModChgbkDocInfo = (BbModChgbkDocInfo) commonDAO.query(temp);
    logger.debug("CollectionOperationDataCollection-loadBbModChgbkDocInfo end");
  }

  /**
   * 加载【修改操作履历】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void loadModHisDtlList(String operSn, int operVerNo,
      ICommonDAO commonDAO) {

    logger.debug("CollectionOperationDataCollection-loadModHisDtl start");
    // 设置查询模板
    ModHisDtl temp = new ModHisDtlImpl();
    // 设置查询条件 ：操作流水号
    temp.setOperSn(operSn);
    // 设置查询条件 ：操作版本号
    temp.setOperVerNo(operVerNo);
    // 查询【修改操作履历】
    ModHisDtl[] tempModHisDtlArray = (ModHisDtl[]) commonDAO.queryList(temp,
        PageCondUtil.getPageCond());
    // 当查询结果不为空
    if (tempModHisDtlArray != null) {
      // 加载【修改操作履历】
      List<ModHisDtl> modHisDtls = new ArrayList<ModHisDtl>();
      modHisDtls.addAll(Arrays.asList(tempModHisDtlArray));
      modHisDtlList = modHisDtls;
    }
    logger.debug("CollectionOperationDataCollection-loadModHisDtl end");

  }

  //	  /**
  //	   * 删除【寄单信息】
  //	   * 
  //	   * @return void
  //	   * @param operSn 操作流水号
  //	   * @param operVerNo 操作版本号
  //	   * @param commonDAO commonDAO的实例
  //	   */
  //	  public void deleteDispchDocInfo(String operSn, int operVerNo, ICommonDAO commonDAO){
  //		  
  //		  logger.debug("CollectionOperationDataCollection-deleteDispchDocInfo start");
  //		  DispchDocInfo template = new DispchDocInfoImpl();
  //		  template.setOperSn(operSn);
  //		  template.setOperVerNo(operVerNo);
  //		  commonDAO.delete(template);
  //		  logger.debug("CollectionOperationDataCollection-deleteDispchDocInfo end");
  //		  
  //	  }

  /**
   * 更新【托收维护操作信息】表的SmileExMethod信息
   *
   */
  public void updateBcMntnOpDtlSmileExMethod() {
    logger
        .debug("CollectionOperationDataCollection-updateBcMntnOpDtlSmileExMethod start");
    // 第一个操作节点的操作，新建操作标志设为‘Y’
    bcMntnOpDtl.setCreateOperFlg(DataTypeConstant.DATA_TYPE_YES);

    // 当【画：新建.汇票金额.币种】为‘CNY’时，清空【Hidden：SMILE记账.EX.Method】的值
    if (CollectionConstant.CCY_CNY.equals(bcMntnOpDtl.getBxCcy())) {
      logger.debug("清空【Hidden：SMILE记账.EX.Method】的值");
      bcMntnOpDtl.setSmileExMethod(ComBizConstant.COMMON_STRING_EMPTY);
    } else {
      // 当【画：新建.汇票金额.币种】不为‘CNY’时，将【Hidden：SMILE记账.EX.Method】的值设为：NOEX
      logger.debug("【Hidden：SMILE记账.EX.Method】的值设为：NOEX");
      bcMntnOpDtl.setSmileExMethod(CollectionConstant.COMMON_STRING_NOEX);
    }
    logger
        .debug("CollectionOperationDataCollection-updateBcMntnOpDtlSmileExMethod end");
  }

  //	  /**
  //	   * 保存【寄单信息】
  //	   * 
  //	   * @return void
  //	   * @param operSn 操作流水号
  //	   * @param operVerNo 操作版本号
  //	   * @param commonDAO commonDAO的实例
  //	   */
  //	  public void updateDispchDocInfoForSaveList(String operSn, int operVerNo) {
  //		  
  //		  logger.debug("CollectionOperationDataCollection-updateDispchDocInfo start");
  //		  if (dispchDocInfoForSaveList != null) {
  //		      logger.debug("【寄单信息】不为空");
  //		      for (int i = 0; i < dispchDocInfoForSaveList.size(); i++) {
  //		    	dispchDocInfoForSaveList.get(i).setOperSn(operSn);
  //		    	dispchDocInfoForSaveList.get(i).setOperVerNo(operVerNo);
  //		        dispchDocInfoForSaveList.get(i).setSn(i);
  //		      }
  //		      SaveDispchDocInfoCommand command = SaveDispchDocInfoCommand.getInstance();
  //		      SaveDispchDocInfoCommandInput input = command.createInputData();
  //		      input.setUpdateTarget(dispchDocInfoForSaveList);
  //		      command.fire(input);
  //		    }
  //		  logger.debug("CollectionOperationDataCollection-updateDispchDocInfo end");
  //	  }

  /**
   * 调用组件列表【I00180】，参数：业务种类，空，操作，取得预计催收登记日、预计催收原因
   * 调用组件列表【I00190】，参数：业务种类，空，操作，空，取得预计故障登记日、预计故障理由
   * 
   * @return void
   * @param operationID 
   * @param bcInfo
   * @param acceptanceDate 
   */
  public void updatePredictToBcInfo(String operationID, BcInfo bcInfo,
      Date acceptanceDate) {
    logger
        .debug("CollectionOperationDataCollection-updatePredictToBcInfo start");
    // 调用业务间函数【I00180】，【I00190】
    CollectionCalculatCommand command = CollectionCalculatCommand.getInstance();
    // 参数设定
    RegistInfoInput input = new RegistInfoInput();
    // 操作ID
    input.setOperationID(operationID);
    // 当BpoFlg为‘Y’时，业务ID = BPO勾选的托收业务ID
    if (null != bcMntnOpDtl && DataTypeConstant.DATA_TYPE_YES
        .equalsIgnoreCase(bcMntnOpDtl.getBpoFlg())) {
      logger.debug("BpoFlg为‘Y’");
      input.setBizID(CollectionConstant.BPO_CHECKED_BIZID);
      // 当TsuFlg为‘Y’时，业务ID = TSU勾选的托收业务ID
    } else if (null != bcMntnOpDtl && DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcMntnOpDtl
        .getTsuFlg())) {
      logger.debug("TsuFlg为‘Y’");
      input.setBizID(CollectionConstant.TSU_CHECKED_BIZID);
      // 当PpnegoFlg为‘Y’时，业务ID = PPNEGO勾选且BPO、TSU不勾选的托收业务ID
    } else if (null != bcMntnOpDtl && DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcMntnOpDtl
        .getPpnegoFlg())) {
      logger.debug("PpnegoFlg为‘Y’");
      input
          .setBizID(CollectionConstant.PPNEGO_CHECKED_AND_BPOTSU_UNCHECKED_BIZID);
    }
    // 当都不勾选时，业务ID = 都不勾选的托收业务ID
    else {
      logger.debug("都不勾选");
      input.setBizID(CollectionConstant.UNCHECKEDALL_BIZID);
    }
    //DealDownDate = 托收基本信息.托收日期
    input.setDealDownDate(bcInfo.getCollDate());
    //MaturityDate = 托收基本信息.到期日期
    input.setMaturityDate(bcInfo.getDueDate());
    // 当承兑日期不为空
    if (acceptanceDate != null) {
      logger.debug("acceptanceDate不为空");
      input.setAcceptanceDate(acceptanceDate);
    }
    //MatchFlag 设为空
    input.setMatchFlag(ComBizConstant.COMMON_STRING_EMPTY);
    RegistInfoResult result = command.fire(input);

    // 将【DM：托收基本信息.预计催收登记日期】的值更新为：取得的预计催收登记日
    bcInfo.setExpctdCollRegDate(result.getOverduePredictDate());

    // 将【DM：托收基本信息.预计催收理由】的值更新为：取得的预计催收原因
    bcInfo.setExpctdCollResn(result.getOverduePredicWords());

    // 将【DM：托收基本信息.预计故障登记日期】的值更新为：取得的预计故障登记日
    bcInfo.setExpctdFaultRegDate(result.getFaultPredictDate());

    // 将【DM：托收基本信息.预计故障登记原因】的值更新为：取得的预计故障理由
    bcInfo.setExpctdFaultRegResn(result.getFaultPredictWords());

    logger.debug("CollectionOperationDataCollection-updatePredictToBcInfo end");
  }

  /**
   * 保存【退改单信息】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void updateBbModChgbkDocOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-updateBbModChgbkDocOperInfo start");
    if(bbModChgbkDocInfo != null) {
      // 设置操作版本号
      bbModChgbkDocInfo.setOperVerNo(operVerNo);
      // 设置操作流水号
      bbModChgbkDocInfo.setOperSn(operSn);
    }
    logger
        .debug("CollectionOperationDataCollection-updateBbModChgbkDocOperInfo end");
  }

  /**
   * 更新【修改履历】操作流水号,版本号信息
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   */
  public void updateModHisDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-updateModHisDtlOperInfo start");
    if(getModHisDtlList() != null && getModHisDtlList().size() > 0) {
      for (int i = 0; i < getModHisDtlList().size(); i++) {
        // 更新操作流水号
        getModHisDtlList().get(i).setOperSn(operSn);
        // 更新操作版本号
        getModHisDtlList().get(i).setOperVerNo(operVerNo);
        // 更新编号
        getModHisDtlList().get(i).setSn(i + 1);
      }
    }
    logger
        .debug("CollectionOperationDataCollection-updateModHisDtlOperInfo end");
  }

  /**
   * 更新【承兑操作明细】操作流水号,版本号信息
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   */
  public void updateBcAccptceOpDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-updateBcAccptceOpDtlOperInfo start");
    if(getBcAccptceOpDtl() != null) {
      // 更新操作流水号
      getBcAccptceOpDtl().setOperSn(operSn);
      // 更新操作版本号
      getBcAccptceOpDtl().setOperVerNo(operVerNo);
    }
    
    logger
        .debug("CollectionOperationDataCollection-updateBcAccptceOpDtlOperInfo end");
  }

  /**
   * 保存【修改履历信息】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void saveModHisDtlList(String operSn, int operVerNo,
      ICommonDAO commonDAO) {
    logger.debug("CollectionOperationDataCollection-saveModHisDtlList start");
    // 创建查询模板
    ModHisDtl template = new ModHisDtlImpl();
    // 设置模板查询条件
    // 操作流水号
    template.setOperSn(operSn);
    // 操作版本号
    template.setOperVerNo(operVerNo);
    // 先删除操作明细数据
    deleteOperDtlData(template, commonDAO);
    // 当【修改履历信息】不为空
    if (modHisDtlList != null && modHisDtlList.size() > 0) {
      logger.debug("【修改履历信息】不为空");
      for (int i = 0; i < modHisDtlList.size(); i++) {
        //保存【修改履历信息】操作版本号
        modHisDtlList.get(i).setOperVerNo(operVerNo);
        //保存【修改履历信息】操作流水号
        modHisDtlList.get(i).setOperSn(operSn);
        // 更新编号
        modHisDtlList.get(i).setSn(i + 1);
      }

      commonDAO.saveList((ModHisDtl[]) modHisDtlList.toArray(new ModHisDtl[0]));
    }
    logger.debug("CollectionOperationDataCollection-saveModHisDtlList end");
  }

  /**
   * 更新【出口信用证维护操作明细】的操作流水号,版本号信息
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   */
  public void updateExpLcMntnOpDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-updateExpLcMntnOpDtlOperInfo start");
    if (expLcMntnOpDtl != null && DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcMntnOpDtl.getLcFlg())) {
      logger.debug("【画：新建.信用证项下】为‘Y’");
      logger.debug("【信用证维护操作明细】不为空");
      // 更新操作流水号
      expLcMntnOpDtl.setOperVerNo(operVerNo);
      // 更新操作版本号
      expLcMntnOpDtl.setOperSn(operSn);
    }
    logger
        .debug("CollectionOperationDataCollection-updateExpLcMntnOpDtlOperInfo end");
  }

  /**
   * 更新【Combined LC 维护操作明细】的操作流水号,版本号信息
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   */
  public void updateBbCombLcMntnOpDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-updateBbCombLcMntnOpDtlOperInfo start");
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcMntnOpDtl.getCombinedLcFlg())) {
      logger.debug("【画：新建.Combined LC】为‘Y’");
      logger.debug("【Combined LC 维护操作明细】不为空");
      if (getBbCombLcMntnOpDtlList() != null
          && getBbCombLcMntnOpDtlList().size() > 0) {
        for (int i = 0; i < getBbCombLcMntnOpDtlList().size(); i++) {
          // 更新操作流水号
          getBbCombLcMntnOpDtlList().get(i).setOperSn(operSn);
          // 更新操作版本号
          getBbCombLcMntnOpDtlList().get(i).setOperVerNo(operVerNo);
          // 更新编号
          getBbCombLcMntnOpDtlList().get(i).setSn(i + 1);
        }
      }
    }
    logger
        .debug("CollectionOperationDataCollection-updateBbCombLcMntnOpDtlOperInfo end");
  }

  /**
   * 更新【寄单信息】的操作流水号,版本号信息
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   */
  public void updateDispchDocInfoOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-updateDispchDocInfoOperInfo start");
    if (getDispchDocInfoForSaveList() != null
        && getDispchDocInfoForSaveList().size() > 0) {
      logger.debug("【寄单信息】不为空");
      for (int i = 0; i < getDispchDocInfoForSaveList().size(); i++) {
        // 更新操作流水号
        getDispchDocInfoForSaveList().get(i).setOperSn(operSn);
        // 更新操作版本号
        getDispchDocInfoForSaveList().get(i).setOperVerNo(operVerNo);
        // 更新编号
        getDispchDocInfoForSaveList().get(i).setSn(i + 1);
      }
    }
    logger
        .debug("CollectionOperationDataCollection-updateDispchDocInfoOperInfo end");
  }

  /**
   * 保存【寄单信息】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void saveDispchDocInfoList(String operSn, int operVerNo) {
    logger
        .debug("CollectionOperationDataCollection-saveDispchDocInfoList start");
    if(getDispchDocInfoForSaveList() != null && getDispchDocInfoForSaveList().size() > 0) {
      // 业务间函数保存【寄单信息】（业务间函数ID：I00260）
      SaveDispchDocInfoCommand command = SaveDispchDocInfoCommand.getInstance();
      // 参数设定
      SaveDispchDocInfoCommandInput input = command.createInputData();
      input.setOperSn(operSn);
      input.setOperVerNo(operVerNo);
      input.setUpdateTarget(getDispchDocInfoForSaveList());
      // 执行句柄
      command.fire(input);
    }

    logger.debug("CollectionOperationDataCollection-saveDispchDocInfoList end");
  }

  /**
   * 保存或删除【出口信用证维护操作明细】
   * 
   * @param bcInfo 托收基本信息
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void saveOrDeleteExpLcMntnOpDtl(BcInfo bcInfo, String operSn,
      int operVerNo, ICommonDAO commonDAO) {
    logger
        .debug("CollectionOperationDataCollection-saveOrDeleteExpLcMntnOpDtl start");
     //当需要保存判定为true，保存【出口信用证维护操作明细】
    if (isNeedSaveLcInfo()) {
      logger.debug("保存【出口信用证维护操作明细】");
      commonDAO.saveOrUpdate(getExpLcMntnOpDtl());
      // 当需要删除判定为true，删除【出口信用证维护操作明细】
    } else if (isNeedDeleteLcInfo(bcInfo)) {
      ExpLcMntnOpDtl template = new ExpLcMntnOpDtlImpl();
      template.setOperSn(operSn);
      template.setOperVerNo(operVerNo);
      logger.debug("删除【出口信用证维护操作明细】");
      deleteOperDtlData(template, commonDAO);
    }
    logger
        .debug("CollectionOperationDataCollection-saveOrDeleteExpLcMntnOpDtl end");
  }

  /**
   * 保存【Combined LC维护操作明细表】
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  public void saveOrDeleteBbCombLcMntnOpDtlList(BcMntnOpDtl bcMntnOpDtl, String operSn,
      int operVerNo, ICommonDAO commonDAO) {
    logger
        .debug("CollectionOperationDataCollection-saveOrDeleteBbCombLcMntnOpDtlList start");
    // 创建查询模板
    BbCombLcMntnOpDtl template = new BbCombLcMntnOpDtlImpl();
    // 设置模板查询条件
    template.setOperSn(operSn);
    template.setOperVerNo(operVerNo);
    //删除【Combined LC 信息】
    deleteOperDtlData(template, commonDAO);

    // 当需要保存Combined Lc判定为true
    if (isNeedSaveCombinedLC()) {
      logger.debug("需要保存【Combined LC维护操作明细表】");
      // 当【Combined LC维护操作明细表】不为空
      if (getBbCombLcMntnOpDtlList() != null
          && getBbCombLcMntnOpDtlList().size() > 0) {
        logger.debug("保存【Combined LC维护操作明细表】");
        //保存【Combined LC维护操作明细表】
        for(int i=0;i < getBbCombLcMntnOpDtlList().size(); i++ ){
        	// 将交易参号T-Kind保存到【Combined LC维护操作明细表】
        	getBbCombLcMntnOpDtlList().get(i).setTKind(bcMntnOpDtl.getTKind());
        	// 将交易主参号保存到【Combined LC维护操作明细表】
        	getBbCombLcMntnOpDtlList().get(i).setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
        	// 将交易子参号保存到【Combined LC维护操作明细表】
        	getBbCombLcMntnOpDtlList().get(i).setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
        }
        commonDAO.saveList((BbCombLcMntnOpDtl[]) getBbCombLcMntnOpDtlList()
                .toArray(new BbCombLcMntnOpDtl[0]));
      }
    }

    logger
        .debug("CollectionOperationDataCollection-saveOrDeleteBbCombLcMntnOpDtlList end");
  }

  /**
   * 删除操作明细数据
   * 
   * @return void
   * @param operSn 操作流水号
   * @param operVerNo 操作版本号
   * @param commonDAO commonDAO的实例
   */
  private void deleteOperDtlData(DataObject deleteQueryTemplate,
      ICommonDAO commonDAO) {
    logger.debug("CollectionOperationDataCollection-deleteOperDtlData start");
    // 根据查询模板，查询数据
    DataObject[] result = commonDAO.queryList(deleteQueryTemplate, PageCondUtil
        .getPageCond());
    // 查询结果不为空时，删除数据
    if (result != null && result.length > 0) {
      logger.debug("查询结果不为空！");
      for (DataObject item : result) {
        // 删除数据
        commonDAO.delete(item);
      }
    }
    logger.debug("CollectionOperationDataCollection-deleteOperDtlData end");
  }

  /**
   * 非信用证精确匹配自动记忆
   * 
   * @return void
   * @param autoMemoryUtil 
   * @param branchId 分行号
   */
  public void autoMemoForNotLcDispch(AutoMemoryUtil autoMemoryUtil,
      String branchId) {

    logger
        .debug("CollectionOperationDataCollection-autoMemoForNotLcDispch start");
    // 精确匹配时的数据扩展值
    String notLcDispchDocBankSwiftExtendValue = "['"
        + bcMntnOpDtl.getDispchDocBankSwift() + "']";
    // 自动记忆数据的存储
    if (StringUtil.isNotEmpty(bcMntnOpDtl.getDispchDocBankCode())) {
      logger.debug("【画：非信用证信息.寄单行行号】不为空");
      autoMemoryUtil.noticeValue(branchId,
          BizCodeIdConstant.BIZ_CODE_ID_823_00, 0, bcMntnOpDtl
              .getDispchDocBankCode(), bcMntnOpDtl.getDispchDocBankCode(),
          notLcDispchDocBankSwiftExtendValue);
    }
    logger
        .debug("CollectionOperationDataCollection-autoMemoForNotLcDispch end");

  }

  /**
   * 信用证精确匹配自动记忆
   * 
   * @return void
   * @param autoMemoryUtil 
   * @param branchId 分行号
   */
  public void autoMemoForLc(AutoMemoryUtil autoMemoryUtil, String branchId) {

    logger.debug("CollectionOperationDataCollection-autoMemoForLc start");
//    // 精确匹配时的数据扩展值
//    String issueBankSwiftExtendValue = "['"
//        + expLcMntnOpDtl.getIssueBankSwift() + "']";
//    String lcDispchDocBankSwiftExtendValue = "['"
//        + expLcMntnOpDtl.getDispchDocBankSwift() + "']";
//    String reimbBankSwiftExtendValue = "['"
//        + expLcMntnOpDtl.getReimbBankSwift() + "']";
//
//    // 自动记忆数据的存储
//    if (StringUtil.isNotEmpty(expLcMntnOpDtl.getIssueBankCode())) {
//      logger.debug("【画：信用证信息.开证行行号】不为空");
//      autoMemoryUtil.noticeValue(branchId,
//          BizCodeIdConstant.BIZ_CODE_ID_823_00, 0, expLcMntnOpDtl
//              .getIssueBankCode(), expLcMntnOpDtl.getIssueBankCode(),
//          issueBankSwiftExtendValue);
//    }
//    if (StringUtil.isNotEmpty(expLcMntnOpDtl.getDispchDocBankCode())) {
//      logger.debug("【画：信用证信息.寄单行行号】不为空");
//      autoMemoryUtil.noticeValue(branchId,
//          BizCodeIdConstant.BIZ_CODE_ID_823_00, 0, expLcMntnOpDtl
//              .getDispchDocBankCode(), expLcMntnOpDtl.getDispchDocBankCode(),
//          lcDispchDocBankSwiftExtendValue);
//    }
//    if (StringUtil.isNotEmpty(expLcMntnOpDtl.getReimbBankCode())) {
//      logger.debug("【画：信用证信息.偿付行行号】不为空");
//      autoMemoryUtil.noticeValue(branchId,
//          BizCodeIdConstant.BIZ_CODE_ID_823_00, 0, expLcMntnOpDtl
//              .getReimbBankCode(), expLcMntnOpDtl.getReimbBankCode(),
//          reimbBankSwiftExtendValue);
//    }
    logger.debug("CollectionOperationDataCollection-autoMemoForLc end");

  }

  //	  /**
  //	   * 设置【Hidden:发起留行】
  //	   * 
  //	   * @return void
  //	   * @param context 
  //	   * @param branchId 分行号
  //	   * @param commonDAO commonDAO的实例
  //	   */
  //	  public boolean updateStartKib(ICommonDAO commonDAO ,String branchId){
  //		  
  //		  logger.debug("CollectionOperationDataCollection-updateStartKib start");
  //		  if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(
  //				  expLcMntnOpDtl.getKibLcFlg())) {
  //			      logger.debug("【画：信用证信息.留行信用证】为'Y'");
  //			      ExpLcInfo template = new ExpLcInfoImpl();
  //			      ExpLcInfo expLcInfo = new ExpLcInfoImpl();
  //			      template.setBranchCode(branchId);
  //			      template.setLcNo(bcMntnOpDtl.getLcNo());
  //			      expLcInfo = (ExpLcInfo) commonDAO.query(template);
  //
  //			      // 当【DM：出口信用证信息.留行信用证标志】为空或者为“N”时
  //			      if (null == expLcInfo.getKibLcFlg()
  //			          || (DataTypeConstant.DATA_TYPE_NO.equalsIgnoreCase(expLcInfo
  //			              .getKibLcFlg()))) {
  //			        logger.debug("【画：信用证信息.留行信用证】为空或者为'N'");
  //			        // 将【Hidden:发起留行】的值设为：Y
  //			        return true;
  //			      }
  //			    }
  //		  logger.debug("CollectionOperationDataCollection-updateStartKib end");
  //		  return false;
  //	  }

  /**
   * 信用证基本信息，余额金额，信用证合并基本信息更新处理
   * 
   * @return void
   * @param context 
   * @param branchId 分行号
   * @param commonDAO commonDAO的实例
   */
  public void updateLcInfoWithBalanceBbCombLcInfo(String commonBizNo,
      String beneCif, BigDecimal bxAmt, List<BbCombLcInfo> combinedLcInfoList) {
    logger
        .debug("CollectionOperationDataCollection-updateLcInfoWithBalanceBbCombLcInfo start");
    // 通过业务间函数进行信用证基本信息，余额金额，信用证合并基本信息更新处理
    UpdateExpLcBalanceInfoCommand command = UpdateExpLcBalanceInfoCommand
        .getInstance();
    ExpLcInfoBalanceUpdateData updateTarget = new ExpLcInfoBalanceUpdateData();
    UpdateExpLcBalanceInfoCommandInput input = command.createInputData();
    // 参数设定
    updateTarget.setMainLcInfo(getMainLcInfo());
    updateTarget.setCombinedLcInfoList(getCombinedLcInfo());
    updateTarget.setBbCombLcInfoList(combinedLcInfoList);

    input.setEditStrategy(command.createLcInfoWithBalanceEditor(commonBizNo,
        beneCif, bxAmt, getExpLcMntnOpDtl(), getBbCombLcMntnOpDtlList()));
    // 执行句柄
    command.fire(input);
    logger
        .debug("CollectionOperationDataCollection-updateLcInfoWithBalanceBbCombLcInfo end");
  }

  /**
   * 信用证基本信息更新处理
   * 
   * @return void
   * @param context 
   * @param branchId 分行号
   * @param commonDAO commonDAO的实例
   */
  public void updateLcInfo(String commonBizNo, String beneCif) {
    logger.debug("CollectionOperationDataCollection-updateLcInfo start");
    // 通过业务间函数执行信用证基本信息更新处理
    UpdateExpLcBalanceInfoCommand command = UpdateExpLcBalanceInfoCommand
        .getInstance();
    // 创建对象
    ExpLcInfoBalanceUpdateData updateTarget = new ExpLcInfoBalanceUpdateData();
    UpdateExpLcBalanceInfoCommandInput input = command.createInputData();
    // 参数设定
    updateTarget.setMainLcInfo(getMainLcInfo());
    updateTarget.setCombinedLcInfoList(getCombinedLcInfo());

    input.setUpdateTarget(updateTarget);
    
    input.setEditStrategy(command.createLcInfoEditor(commonBizNo, beneCif,
        getExpLcMntnOpDtl()));
    // 执行句柄
    command.fire(input);
    logger.debug("CollectionOperationDataCollection-updateLcInfo end");
  }
  //	  public void updateLcBalAmt(CollectionBizDataCollection bizCollection 
  //			  ,ICommonDAO commonDAO ,String branchId ,int flag){
  //		  
  //		  logger.debug("CollectionOperationDataCollection-updateLcBalAmt start");
  //		  BcInfo bcInfo = bizCollection.getBcInfo();
  //		  if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcInfo.getLcFlg())) {
  //			  
  //			  if(flag < 0){
  //				  // 取得【DM：出口信用证维护操作明细】中当前操作流水号+当前操作版本号的信息后，（检索条件：<操作版本号，操作流水号>）全量保存至【DM：出口信用证信息】
  //			      ArtBeanUtils.copyProperties(expLcMntnOpDtl, bizCollection.getExpLcInfo());
  //
  //			      // 将【画：新建.受益人.客户CIF】保存至【DM：出口信用证基本信息.受益人客户编号】
  //			      bizCollection.getExpLcInfo().setBeneCif(bcMntnOpDtl.getBeneCif());
  //			  }
  //			  
  //		      if (DataTypeConstant.DATA_TYPE_NO.equalsIgnoreCase(bcInfo.getCombinedLcFlg())) {
  //		        logger.debug("【画：新建.信用证项下】为'Y'，【画：信用证信息.Combined LC】为'N'");
  //		        
  //		        // 取得【DM：出口信用证信息.信用证余额金额】（检索条件：【DM：出口信用证信息】<分行号，信用证编号>）
  //		        BigDecimal lcBalAmt = bizCollection.getExpLcInfo().getLcBalAmt();
  //
  //		        // 取得【DM：托收基本信息.汇票金额】（检索条件：【DM：托收基本信息】<分行号，T-kind，交易主参号>）
  //		        BigDecimal bxAmt = bcInfo.getBxAmt();
  //
  //		        // 信用证余额 = 【DM：出口信用证信息.信用证余额金额】 + 【DM：托收基本信息.汇票金额】
  //		        BigDecimal tempLcBalAmt = lcBalAmt.add(bxAmt.multiply(new BigDecimal(flag)));
  //
  //		        // 将计算后得到的信用证余额更新至【DM：出口信用证信息.信用证余额金额】（更新条件：【DM：出口信用证信息】<分行号，信用证编号>)
  //		        bizCollection.getExpLcInfo().setLcBalAmt(tempLcBalAmt);
  //
  //		      } else if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(bcInfo
  //		          .getCombinedLcFlg())) {
  //		        logger.debug("【画：新建.信用证项下】为'Y'，【画：信用证信息.Combined LC】为'Y'");
  //		        
  //		        if(flag < 0){
  //		        	BbCombLcInfo bbCombLcInfo = new BbCombLcInfoImpl();
  //		        	bizCollection.getBbCombLcInfoList().clear();
  //		            // 取得【DM：Combined
  //		            // LC维护操作明细】中当前操作流水号+当前操作版本号的信息后，（检索条件<操作版本号，操作流水号>）全量保存至【DM：Combined
  //		            // LC基本信息】中
  //		            for (BbCombLcMntnOpDtl bbCombLcMntnOpDtl : bbCombLcMntnOpDtlList) {
  //		              ArtBeanUtils.copyProperties(bbCombLcMntnOpDtl, bbCombLcInfo);
  //		              bizCollection.getBbCombLcInfoList().add(bbCombLcInfo);
  //		            }
  //		        }
  //		        
  //		        BbCombLcInfo temp = bizCollection.getBbCombLcInfoList().get(0);
  //		        BigDecimal lcBalAmtTemp = temp.getLcBalAmt();
  //		        BigDecimal drawnAmtTemp = temp.getDrawnAmt();
  //		        lcBalAmtTemp = lcBalAmtTemp.add(drawnAmtTemp.multiply(new BigDecimal(flag)));
  //		        bizCollection.getExpLcInfo().setLcBalAmt(lcBalAmtTemp);
  //
  //		        for (int i = 1; i < bizCollection.getBbCombLcInfoList().size(); i++) {
  //
  //		          BbCombLcInfo comLcSource = bizCollection.getBbCombLcInfoList().get(i);
  //		          ExpLcInfo template = new ExpLcInfoImpl();
  //		          template.setBranchCode(branchId);
  //		          template.setLcNo(comLcSource.getLcNo());
  //		          ExpLcInfo queryReasult = (ExpLcInfo) commonDAO.query(template);
  //		          if (queryReasult != null) {
  //		            template = (ExpLcInfo)commonDAO.query(template);
  //
  //		            // 【DM：出口信用证信息.信用证余额金额】
  //		            BigDecimal lcBalAmt = template.getLcBalAmt();
  //
  //		            // 【DM：Combined LC基本信息.Drawn Amount 金额】
  //		            BigDecimal drawnAmt = comLcSource.getDrawnAmt();
  //
  //		            // 信用证余额 = 【DM：出口信用证信息.信用证余额金额】 + 【DM：Combined
  //		            // LC基本信息.Drawn Amount 金额】
  //		            lcBalAmt = lcBalAmt.add(drawnAmt.multiply(new BigDecimal(flag)));
  //
  //		            // 信用证余额更新至【DM：出口信用证信息.信用证余额金额】
  //		            queryReasult.setLcBalAmt(lcBalAmt);
  //		            commonDAO.saveOrUpdate(queryReasult);
  //		          }
  //		        }
  //		      }
  //		    }
  //		  logger.debug("CollectionOperationDataCollection-updateLcBalAmt end");
  //	  }

}
