package cn.com.btmu.art.biz.collection.datacollection;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollCreateDetailContext;
import cn.com.btmu.art.biz.collection.datacollection.common.ICollectionCommonMntnDataCollection;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.component.autocomplete.AutoMemoryUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.dao.ICommonDAO;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * CollectionCollCreateDataCollection 
 * 
 * 托收业务新建节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollCreateDataCollection implements
    ICollectionCommonMntnDataCollection<CollectionCollCreateDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收业务用数据集合. */
  private CollectionOperationDataCollection dataCollection;

  /**
   * 构造函数
   */
  public CollectionCollCreateDataCollection() {
    dataCollection = new CollectionOperationDataCollection();
  }

  /** 当前新建操作节点用到的所有操作信息的取得方法 */

  /**
   * 取得托收维护操作明细.
   * 
   * @return bcMntnOpDtl 托收维护操作明细
   */
  public BcMntnOpDtl getBcMntnOpDtl() {
    return dataCollection.getBcMntnOpDtl();
  }

  /**
   * 设定托收维护操作明细.
   * 
   * @param bcMntnOpDtl 托收维护操作明细
   */
  public void setBcMntnOpDtl(BcMntnOpDtl bcMntnOpDtl) {
    dataCollection.setBcMntnOpDtl(bcMntnOpDtl);
  }

  /**
   * 取得出口信用证维护操作明细.
   * 
   * @return ExpLcMntnOpDtl 出口信用证维护操作明细
   */
  public ExpLcMntnOpDtl getExpLcMntnOpDtl() {
    return dataCollection.getExpLcMntnOpDtl();
  }

  /**
   * 设置出口信用证维护操作明细.
   * 
   * @param expLcMntnOpDtl 出口信用证维护操作明细
   */
  public void setExpLcMntnOpDtl(ExpLcMntnOpDtl expLcMntnOpDtl) {
    dataCollection.setExpLcMntnOpDtl(expLcMntnOpDtl);
  }

  /**
   * 取得Combined LC 维护操作明细.
   * 
   * @return BbCombLcMntnOpDtl Combined LC 维护操作明细
   */
  public List<BbCombLcMntnOpDtl> getBbCombLcMntnOpDtlList() {
    return dataCollection.getBbCombLcMntnOpDtlList();
  }

  /**
   * 设定寄单信息 用于保存当前节点新增条目用
   * 
   * @param dispchDocInfo 寄单信息
   */
  public void setBbCombLcMntnOpDtlList(
      List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList) {
    dataCollection.setBbCombLcMntnOpDtlList(bbCombLcMntnOpDtlList);
  }

  /**
   * 取得寄单信息
   * 
   * @return DispchDocInfo 寄单信息
   */
  public List<DispchDocInfo> getDispchDocInfoForSaveList() {
    return dataCollection.getDispchDocInfoForSaveList();
  }

  /**
   * 设定寄单信息 用于保存当前节点新增条目用
   * 
   * @param dispchDocInfoForSaveList 寄单信息
   */
  public void setDispchDocInfoForSaveList(
      List<DispchDocInfo> dispchDocInfoForSaveList) {
    dataCollection.setDispchDocInfoForSaveList(dispchDocInfoForSaveList);
  }

  /**
   * 取得合并信用证信息
   * 
   * @return ExpLcInfo 信用证信息
   */
  public List<ExpLcInfo> getCombinedLcInfo() {
    return dataCollection.getCombinedLcInfo();
  }

  /**
   * 取得主信用证信息
   * 
   * @return ExpLcInfo 信用证信息
   */
  public ExpLcInfo getMainLcInfo() {
    return dataCollection.getMainLcInfo();
  }

  /**
   * 设定合并信用证信息
   * 
   * @param ExpLcInfo 信用证信息
   */
  public void setCombinedLcInfo(List<ExpLcInfo> combinedLcInfo) {
    dataCollection.setCombinedLcInfo(combinedLcInfo);
  }

  /**
   * 设定主信用证信息
   * 
   * @param ExpLcInfo 信用证信息
   */
  public void setMainLcInfo(ExpLcInfo mainLcInfo) {
    dataCollection.setMainLcInfo(mainLcInfo);
  }

  /**
   * 判定是否需要进行留行信用证新建的触发处理
   * @return 需要触发true，否则false
   */
  public boolean isNeedToTrigLcKindle() {
    return dataCollection.isNeedToTrigLcKindle();
  }

  /**
   * 判定是否需要保存信用证信息
   * @return 需要保存true，否则false
   */
  public boolean isNeedSaveLcInfo() {
    return dataCollection.isNeedSaveLcInfo();
  }

  /**
   * 判定是否需要删除信用证信息
   * @return 需要删除true，否则false
   */
  public boolean isNeedDeleteLcInfo(BcInfo bcInfo) {
    return dataCollection.isNeedDeleteLcInfo(bcInfo);
  }

  /**
   * 加载新建节点的操作数据（只包含本机能的操作表，其他业务的通过业务间函数实现）. 加载当前操作明细信息以外的其他操作信息
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void loadProcessingOpDtlWithRelation(
      CollectionCollCreateDetailContext context) {
    logger
        .debug("CollectionCollCreateDataCollection-loadProcessingOpDtlWithRelation start");

    // 加载【出口信用证维护操作明细】
    dataCollection.loadExpLcMntnOpDtl(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载【Combined LC维护操作明细】
    dataCollection.loadBbCombLcMntnOpDtlList(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载【寄单信息】
    dataCollection.loadDispchDocInfo(context.getOperSN(), context.getOperVer(),
        context.getCommonDAO());

    logger
        .debug("CollectionCollCreateDataCollection-loadProcessingOpDtlWithRelation end");
  }

  /**
   * 保存子操作明细信息 如果当前业务没有操作明细子表，方法内容为空
   * 
   * @return void
   */
  public void saveOprData(CollectionCollCreateDetailContext context) {
    logger.debug("CollectionCollCreateDataCollection-saveOprData start");
    ICommonDAO commonDAO = context.getCommonDAO();

    // 取得匹配业务数据项数值采集Bean
    AutoMemoryUtil autoMemoryUtil = (AutoMemoryUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90540_UTIL_AUTOMEMORY);

    // 非信用证寄单精确匹配时的数据扩展值,自动记忆数据的存储
    dataCollection
        .autoMemoForNotLcDispch(autoMemoryUtil, context.getBranchId());

    // 信用证精确匹配时的数据扩展值,自动记忆数据的存储
    dataCollection.autoMemoForLc(autoMemoryUtil, context.getBranchId());

    // 保存【出口信用证维护操作明细】
    dataCollection.saveOrDeleteExpLcMntnOpDtl(context.getDataRepository()
        .getBizDataCollection().getBcInfo(), context.getOperSN(), context
        .getOperVer(), commonDAO);

    // 保存【Combined LC维护操作明细】
    dataCollection.saveOrDeleteBbCombLcMntnOpDtlList(context
        .getDataRepository().getOperationDataCollection().getBcMntnOpDtl(), context
        .getOperSN(), context.getOperVer(), commonDAO);

    // 保存【寄单信息】
    dataCollection.saveDispchDocInfoList(context.getOperSN(), context
        .getOperVer());

    logger.debug("CollectionCollCreateDataCollection-saveOprData end");
  }

  /**
   * 更新【托收维护操作信息】表的SmileExMethod信息
   *
   */
  public void updateBcMntnOpDtl() {
    dataCollection.updateBcMntnOpDtlSmileExMethod();
  }

  /**
   * 更新关联操作表的操作流水号，版本号信息
   * @param operSn
   * @param operVerNo
   */
  public void updateOpRelationDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionCollCreateDataCollection-updateOpRelationDtlOperInfo start");
    // 更新【出口信用证维护操作明细】的操作流水号,版本号信息
    dataCollection.updateExpLcMntnOpDtlOperInfo(operSn, operVerNo);
    // 更新【Combined LC 维护操作明细】的操作流水号,版本号信息
    dataCollection.updateBbCombLcMntnOpDtlOperInfo(operSn, operVerNo);
    // 更新【寄单信息】的操作流水号,版本号信息
    dataCollection.updateDispchDocInfoOperInfo(operSn, operVerNo);
    logger
        .debug("CollectionCollCreateDataCollection-updateOpRelationDtlOperInfo end");
  }

  /**
   * 从操作信息中更新业务信息 新建操作需要更新的业务信息更新到业务信息中
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void updateBizDataFromOpData(CollectionCollCreateDetailContext context) {
    logger
        .debug("CollectionCollCreateDataCollection-updateBizDataFromOpData start");

    // 保存【DM：托收基本信息】
    ArtBeanUtils.copyProperties(getBcMntnOpDtl(), context.getDataRepository()
        .getBizDataCollection().getBcInfo());

    // 托收操作流水号
    // 托收操作版本号
    context.getBizData().setBcMntnOpDtl(getBcMntnOpDtl());

    // 信用证余额金额处理
    //【画：新建.信用证项下】为‘Y’时，保存【DM：出口信用证信息】
    //【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时，保存【DM：Combined
    // LC基本信息】
    if (dataCollection.isNeedSaveLcInfo()) {
        // Combined LC基本信息分行号设置
        for (BbCombLcInfo bbCombLcInfo : context.getDataRepository().getBizDataCollection().getBbCombLcInfoList()) {
        	bbCombLcInfo.setBranchCode(context.getBranchId());
        }
        dataCollection.updateLcInfoWithBalanceBbCombLcInfo(context
          .getDataRepository().getBizDataCollection().getBcInfo()
          .getSCrBizInfo().getBizInfoId(), context.getDataRepository()
          .getBizDataCollection().getBcInfo().getBeneCif(), getBcMntnOpDtl()
          .getBxAmt().multiply(new BigDecimal("-1")), context
          .getDataRepository().getBizDataCollection().getBbCombLcInfoList());
    }

    // 7- 调用组件列表【I00180】，参数：业务种类，空，操作，取得预计催收登记日、预计催收原因
    // 调用组件列表【I00190】，参数：业务种类，空，操作，空，取得预计故障登记日、预计故障理由
    BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
        .getBcInfo();
    dataCollection.updatePredictToBcInfo(
        CollectionConstant.CREATE_OPERATION_ID, bcInfo, null);
    
    // Combined LC分行号设置
    List<BbCombLcInfo> listBbCombLcInfo = 
    	context.getDataRepository().getBizDataCollection().getBbCombLcInfoList();
    if (null != listBbCombLcInfo) {
	    for (BbCombLcInfo bbCombLcInfo : context.getDataRepository()
	        .getBizDataCollection().getBbCombLcInfoList()) {
	      bbCombLcInfo.setBranchCode(context.getBranchId());
	    }
    }

    // 出口信用证信息分行号设置
    ExpLcInfo expLcInfo = context.getDataRepository().getBizDataCollection().getExpLcInfo();
    if (null != expLcInfo) {
    	context.getDataRepository().getBizDataCollection().getExpLcInfo().setBranchCode(context.getBranchId());
    }

    logger.debug("CollectionCollCreateDataCollection-updateBizDataFromOpData end");
  }

}