package cn.com.btmu.art.biz.collection.datacollection;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.collection.datacollection.common.ICollectionCommonMntnDataCollection;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.service.opfmanagement.data.OpfData;
import cn.com.btmu.art.component.autocomplete.AutoMemoryUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.dao.ICommonDAO;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * CollectionCollModDocDataCollection
 * 
 * 托收改单节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollModDocDataCollection implements
    ICollectionCommonMntnDataCollection<CollectionCollModDocDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收业务用数据集合. */
  private CollectionOperationDataCollection dataCollection;

  /**
   * 构造函数
   */
  public CollectionCollModDocDataCollection() {
    dataCollection = new CollectionOperationDataCollection();
  }

  /**
   * 取得退改单信息.
   * 
   * @return bbModChgbkDocInfo 托收退改单信息
   */
  public BbModChgbkDocInfo getBbModChgbkDocInfo() {
    return dataCollection.getBbModChgbkDocInfo();
  }

  /**
   * 设定退改单信息.
   * 
   * @param bbModChgbkDocInfo 托收退改单信息
   */
  public void setBbModChgbkDocInfo(BbModChgbkDocInfo bbModChgbkDocInfo) {
    dataCollection.setBbModChgbkDocInfo(bbModChgbkDocInfo);
  }

  /**
   * 取得托收维护操作明细.
   * 
   * @return BcMntnOpDtl 托收维护操作明细
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
   * 取得Combined LC维护操作明细.
   * 
   * @return List Combined LC BbCombLcMntnOpDtl
   */
  public List<BbCombLcMntnOpDtl> getBbCombLcMntnOpDtlList() {
    return dataCollection.getBbCombLcMntnOpDtlList();
  }

  /**
   * 设定Combined LC维护操作明细.
   * 
   * @param List Combined LC bbCombLcMntnOpDtlList
   */
  public void setBbCombLcMntnOpDtlList(
      List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList) {
    dataCollection.setBbCombLcMntnOpDtlList(bbCombLcMntnOpDtlList);
  }

  /**
   * 取得寄单信息 用于保存当前节点新增条目用
   * 
   * @return DispchDocInfo 寄单信息
   */
  public void setDispchDocInfoForSaveList(
      List<DispchDocInfo> dispchDocInfoForSaveList) {
    dataCollection.setDispchDocInfoForSaveList(dispchDocInfoForSaveList);
  }

  /**
   * 取得寄单信息 用于保存当前节点新增条目用
   * 
   * @return DispchDocInfo 寄单信息
   */
  public List<DispchDocInfo> getDispchDocInfoForSaveList() {
    return dataCollection.getDispchDocInfoForSaveList();
  }

  /**
   * 取得修改履历信息
   * 
   * @return List<ModHisDtl> 修改履历信息
   */
  public List<ModHisDtl> getModHisDtlList() {
    return dataCollection.getModHisDtlList();
  }

  /**
   * 设定修改履历信息
   * 
   * @param modHisDtlList 修改履历信息
   */
  public void setModHisDtlList(List<ModHisDtl> modHisDtlList) {
    dataCollection.setModHisDtlList(modHisDtlList);
  }

  /**
   * 取得修改履历信息
   * 
   * @return List<ModHisDtl> 修改履历信息
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
   * 设定催收,拒付,故障信息
   * 
   * @param OpfData 催收,拒付,故障信息
   */
  public void setOpfData(OpfData opfData) {
    dataCollection.setOpfData(opfData);
  }

  /**
   * 加载退改单节点的操作数据（只包含本机能的操作表，其他业务的通过业务间函数实现）.
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void loadProcessingOpDtlWithRelation(
      CollectionCollModDocDetailContext context) {
    logger
        .debug("CollectionCollModDocDataCollection-loadProcessingOpDtlWithRelation start");

    // 加载【出口信用证维护操作明细】
    dataCollection.loadExpLcMntnOpDtl(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载【Combined LC维护操作明细】
    dataCollection.loadBbCombLcMntnOpDtlList(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载【寄单信息】
    dataCollection.loadDispchDocInfo(context.getOperSN(), context.getOperVer(),
        context.getCommonDAO());

    // 加载退改单信息
    dataCollection.loadBbModChgbkDocInfo(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载修改履历信息
    dataCollection.loadModHisDtlList(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    logger
        .debug("CollectionCollModDocDataCollection-loadProcessingOpDtlWithRelation end");
  }

  /**
   * 从操作信息中更新业务信息
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void updateBizDataFromOpData(CollectionCollModDocDetailContext context) {
    logger
        .debug("CollectionCollModDocDataCollection-updateBizDataFromOpData start");

    // 取得【DM：托收维护操作明细】中当前操作流水号+当前操作版本号的信息后，（检索条件：<操作版本号，操作流水号>）全量更新至【DM：托收基本信息】
    ArtBeanUtils.copyProperties(getBcMntnOpDtl(), context.getDataRepository()
        .getBizDataCollection().getBcInfo());

    // 信用证余额金额处理
    //【画：新建.信用证项下】为‘Y’时，保存【DM：出口信用证信息】
    //【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时，保存【DM：Combined
    // LC基本信息】
    if (dataCollection.isNeedSaveLcInfo()) {
      dataCollection.updateLcInfoWithBalanceBbCombLcInfo(context
          .getDataRepository().getBizDataCollection().getBcInfo()
          .getSCrBizInfo().getBizInfoId(), context.getDataRepository()
          .getBizDataCollection().getBcInfo().getBeneCif(), getBcMntnOpDtl()
          .getBxAmt().multiply(new BigDecimal("-1")), context
          .getDataRepository().getBizDataCollection().getBbCombLcInfoList());
    }

    // 调用组件列表【I00180】，参数：业务种类，空，操作，取得预计催收登记日、预计催收原因
    // 调用组件列表【I00190】，参数：业务种类，空，操作，空，取得预计故障登记日、预计故障理由
    BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
        .getBcInfo();
    dataCollection.updatePredictToBcInfo(
        CollectionConstant.MODDOC_OPERATION_ID, bcInfo, null);

    // 将【DM：托收基本信息.托收维护操作流水号】的值更新为：当前操作流水号
    // 将【DM：托收基本信息.托收维护操作版本号】的值更新为：当前操作版本号
    bcInfo.setBcMntnOpDtl(getBcMntnOpDtl());

    // 将【DM：托收基本信息.托收退改单操作流水号】的值更新为：当前操作流水号
    // 将【DM：托收基本信息.托收退改单操作版本号】的值更新为：当前操作版本号
    bcInfo.setBbModChgbkDocInfo(getBbModChgbkDocInfo());

    // 将【DM：托收基本信息.托收承兑操作流水号】，【DM：托收基本信息.托收承兑操作版本号】的值更新为：空
    bcInfo.setBcAccptceOpDtl(null);
    
    // Combined LC分行号设置
		if (null != context.getDataRepository().getBizDataCollection()
				.getBbCombLcInfoList()) {
			for (BbCombLcInfo bbCombLcInfo : context.getDataRepository()
					.getBizDataCollection().getBbCombLcInfoList()) {
				bbCombLcInfo.setBranchCode(context.getBranchId());
			}
		}
    
        
    // 出口信用证信息分行号设置
		if (null != context.getDataRepository().getBizDataCollection()
				.getExpLcInfo()) {
    context.getDataRepository().getBizDataCollection().getExpLcInfo().setBranchCode(context.getBranchId());
		}
    
    logger
        .debug("CollectionCollModDocDataCollection-updateBizDataFromOpData end");
  }

  /**
   * 保存子操作明细信息
   * 
   * @return void
   */
  public void saveOprData(CollectionCollModDocDetailContext context) {
    logger.debug("CollectionCollModDocDataCollection-saveOprData start");
    int operVer = context.getOperVer();
    String operSN = context.getOperSN();
    ICommonDAO commonDAO = context.getCommonDAO();

    // 取得匹配业务数据项数值采集Bean
    AutoMemoryUtil autoMemoryUtil = (AutoMemoryUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90540_UTIL_AUTOMEMORY);

    // 非信用证寄单精确匹配时的数据扩展值,自动记忆数据的存储
    dataCollection
        .autoMemoForNotLcDispch(autoMemoryUtil, context.getBranchId());

    // 保存出口信用证维护操作明细
    dataCollection.saveOrDeleteExpLcMntnOpDtl(context.getDataRepository()
        .getBizDataCollection().getBcInfo(), context.getOperSN(), context
        .getOperVer(), commonDAO);

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

    //    // 先删除【DM：Combined LC维护操作明细】<当前操作流水号，当前操作版本号>的信息
    //    dataCollection.deleteBbCombLcMntnOpDtl(operSN, operVer, commonDAO);
    //
    //    // 保存Combined LC维护操作明细表
    //    dataCollection.saveOrUpdateBbCombLcMntnOpDtlList(operSN,operVer,commonDAO);

    // 保存退改单信息
    commonDAO.saveOrUpdate(getBbModChgbkDocInfo());

    // 保存修改履历信息
    dataCollection.saveModHisDtlList(operSN, operVer, commonDAO);

    //    // 先删除寄单信息表
    //    dataCollection.deleteDispchDocInfo(operSN,operVer,commonDAO);
    //
    //    // 保存寄单信息表
    //    dataCollection.updateDispchDocInfoForSaveList(operSN,operVer);

    logger.debug("CollectionCollModDocDataCollection-saveOprData end");
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
        .debug("CollectionCollModDocDataCollection-updateOpRelationDtlOperInfo start");
    // 更新【出口信用证维护操作明细】的操作流水号,版本号信息
    dataCollection.updateExpLcMntnOpDtlOperInfo(operSn, operVerNo);
    // 更新【Combined LC 维护操作明细】的操作流水号,版本号信息
    dataCollection.updateBbCombLcMntnOpDtlOperInfo(operSn, operVerNo);
    // 更新【寄单信息】的操作流水号,版本号信息
    dataCollection.updateDispchDocInfoOperInfo(operSn, operVerNo);
    // 更新【退改单信息】的操作流水号,版本号信息
    dataCollection.updateBbModChgbkDocOperInfo(operSn, operVerNo);
    // 更新【修改履历】的流水号，版本号信息
    dataCollection.updateModHisDtlOperInfo(operSn, operVerNo);
    logger
        .debug("CollectionCollModDocDataCollection-updateOpRelationDtlOperInfo end");
  }

  /**
   * 判定是否需要进行留行信用证新建的触发处理
   * @return 需要触发true，否则false
   */
  public boolean isNeedToTrigLcKindle() {
	return dataCollection.isNeedToTrigLcKindle();
  }
}
