package cn.com.btmu.art.biz.collection.datacollection;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollAccptceDetailContext;
import cn.com.btmu.art.biz.common01biz.repo.IOperationDataCollection;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;

/**
 * CollectionCollAccptceDataCollection 
 * 
 * 托收业务承兑节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollAccptceDataCollection implements
    IOperationDataCollection<CollectionCollAccptceDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收业务用数据集合. */
  private CollectionOperationDataCollection dataCollection;

  /**
   * 构造函数
   */
  public CollectionCollAccptceDataCollection() {
    dataCollection = new CollectionOperationDataCollection();
  }

  /** 当前新建操作节点用到的所有操作信息的取得方法 */

  /**
   * 设定托收承兑操作明细.
   * 
   * @param bcAccptceOpDtl 托收承兑操作明细
   */
  public void setBcAccptceOpDtl(BcAccptceOpDtl bcAccptceOpDtl) {
    dataCollection.setBcAccptceOpDtl(bcAccptceOpDtl);
  }

  /**
   * 取得托收承兑操作明细.
   * 
   * @return BcAccptceOpDtl 托收承兑操作明细
   */
  public BcAccptceOpDtl getBcAccptceOpDtl() {
    return dataCollection.getBcAccptceOpDtl();
  }

  /**
   * 取得寄单信息 用于保存当前节点新增条目
   * 
   * @return DispchDocInfo 寄单信息
   */
  public List<DispchDocInfo> getDispchDocInfoForSaveList() {
    return dataCollection.getDispchDocInfoForSaveList();
  }

  /**
   * 设定寄单信息 用于保存当前节点新增条目
   * 
   * @param dispchDocInfo 寄单信息
   */
  public void setDispchDocInfoForSaveList(
      List<DispchDocInfo> dispchDocInfoForSaveList) {
    dataCollection.setDispchDocInfoForSaveList(dispchDocInfoForSaveList);
  }

  /**
   * 更新关联操作表的操作流水号，版本号信息
   * @param operSn
   * @param operVerNo
   */
  public void updateOpRelationDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionCollAccptceDataCollection-updateOpRelationDtlOperInfo start");
    // 更新【寄单信息】的操作流水号,版本号信息
    dataCollection.updateDispchDocInfoOperInfo(operSn, operVerNo);
    logger
        .debug("CollectionCollAccptceDataCollection-updateOpRelationDtlOperInfo end");
  }

  /**
   * 加载承兑节点的操作数据（只包含本机能的操作表，其他业务的通过业务间函数实现）. 加载当前操作明细信息以外的其他操作信息
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void loadProcessingOpDtlWithRelation(
      CollectionCollAccptceDetailContext context) {
    logger
        .debug("CollectionCollAccptceDataCollection-loadProcessingOpDtlWithRelation start");
    // 设置当前操作的操作数据信息【托收承兑操作明细】
    dataCollection.setBcAccptceOpDtl(context.getReqData());
    logger
        .debug("CollectionCollAccptceDataCollection-loadProcessingOpDtlWithRelation end");
  }

  /**
   * 保存子操作明细信息 如果当前业务没有操作明细子表，方法内容为空
   * 
   * @return void
   */
  public void saveOprData(CollectionCollAccptceDetailContext context) {
    logger.debug("CollectionCollAccptceDataCollection-saveOprData start");

    //    // 先删除寄单信息
    //    dataCollection.deleteDispchDocInfo(operSN,operVer,commonDAO);
    //    
    //    // 保存寄单信息表
    //    dataCollection.updateDispchDocInfoForSaveList(operSN, operVer);

    // 保存寄单信息表
    dataCollection.saveDispchDocInfoList(context.getOperSN(), context
        .getOperVer());

    logger.debug("CollectionCollAccptceDataCollection-saveOprData end");
  }


  /**
   * 从操作信息中更新业务信息 承兑操作需要更新的业务信息更新到业务信息中
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void updateBizDataFromOpData(CollectionCollAccptceDetailContext context) {
    logger
        .debug("CollectionCollAccptceDataCollection-updateBizDataFromOpData start");
    // 2- 调用组件列表【I00180】，参数：业务种类，空，操作，取得预计催收登记日、预计催收原因
    // 调用组件列表【I00190】，参数：业务种类，空，操作，空，取得预计故障登记日、预计故障理由
    BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
        .getBcInfo();
    dataCollection.updatePredictToBcInfo(
        CollectionConstant.ACCPTCE_OPERATION_ID, bcInfo, getBcAccptceOpDtl()
            .getAccptceDueDate());

    // 将【DM：托收基本信息.托收承兑操作流水号】更新
    if (dataCollection.isNeedClearAcceptanceInBizInfo(context
        .getDataRepository().getBizDataCollection().getBcAccptceOpDtl())) {
      logger.debug("【画：承兑.Accepted Flag】从'Y'改为'N'");
      context.getBizData().setBcAccptceOpDtl(null);
    } else {
      logger.debug("【画：承兑.Accepted Flag】为'Y'");
      // 托收承兑操作流水号
      // 托收承兑操作版本号
      context.getBizData().setBcAccptceOpDtl(getBcAccptceOpDtl());
    }  
    
    // Combined LC分行号设置
    List<BbCombLcInfo> listBbCombLcInfo = 
    	context.getDataRepository().getBizDataCollection().getBbCombLcInfoList();
    if (null != listBbCombLcInfo) {
	    for (BbCombLcInfo bbCombLcInfo : listBbCombLcInfo) {
	      bbCombLcInfo.setBranchCode(context.getBranchId());
	    }
    }
        
    // 出口信用证信息分行号设置
    ExpLcInfo expLcInfo = context.getDataRepository().getBizDataCollection().getExpLcInfo();
    if (null != expLcInfo) {
    	context.getDataRepository().getBizDataCollection().getExpLcInfo().setBranchCode(context.getBranchId());
    }
    
    logger
        .debug("CollectionCollAccptceDataCollection-updateBizDataFromOpData end");
  }

}
