package cn.com.btmu.art.biz.collection.datacollection;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common.feemngt.util.ChargeFeeUtil;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.repo.IOperationDataCollection;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.feemgmtdataset.FeeRegDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * CollectionCollBookingDataCollection 
 * 
 * 托收业务入账节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollBookingDataCollection implements
    IOperationDataCollection<CollectionCollBookingDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收业务用数据集合. */
  private CollectionOperationDataCollection dataCollection;

  /**
   * 构造函数
   */
  public CollectionCollBookingDataCollection() {
    dataCollection = new CollectionOperationDataCollection();
  }

  /** 当前新建操作节点用到的所有操作信息的取得方法 */

  /**
   * 取得托收入账操作明细.
   * 
   * @return BcBookOpDtl 托收维护操作明细
   */
  public BcBookOpDtl getBcBookOpDtl() {
    return dataCollection.getBcBookOpDtl();
  }

  /**
   * 设定托收入账操作明细.
   * 
   * @param bcBookOpDtl 托收维护操作明细
   */
  public void setBcBookOpDtl(BcBookOpDtl bcBookOpDtl) {
    dataCollection.setBcBookOpDtl(bcBookOpDtl);
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
   * 设定寄单信息 用于保存当前节点新增条目用
   * 
   * @param dispchDocInfo 寄单信息
   */
  public void setDispchDocInfoForSaveList(
      List<DispchDocInfo> DispchDocInfoForSaveList) {
    dataCollection.setDispchDocInfoForSaveList(DispchDocInfoForSaveList);
  }

  /**
   * 加载入账节点的操作数据（只包含本机能的操作表，其他业务的通过业务间函数实现）. 加载当前操作明细信息以外的其他操作信息
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void loadProcessingOpDtlWithRelation(
      CollectionCollBookingDetailContext context) {
    logger
        .debug("CollectionCollBookingDataCollection-loadProcessingOpDtlWithRelation start");
    // 设置当前操作的操作数据信息【托收入账操作明细】
    dataCollection.setBcBookOpDtl(context.getReqData());
    logger
        .debug("CollectionCollBookingDataCollection-loadProcessingOpDtlWithRelation end");
  }

  /**
   * 保存子操作明细信息 如果当前业务没有操作明细子表，方法内容为空
   * 
   * @return void
   */
  public void saveOprData(CollectionCollBookingDetailContext context) {
    logger.debug("CollectionCollBookingDataCollection-saveOprData start");

    // 保存寄单信息表
    dataCollection.saveDispchDocInfoList(context.getOperSN(), context
        .getOperVer());

    logger.debug("CollectionCollBookingDataCollection-saveOprData end");
  }

  /**
   * 从操作信息中更新业务信息 入账操作需要更新的业务信息更新到业务信息中
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void updateBizDataFromOpData(CollectionCollBookingDetailContext context) {
    logger
        .debug("CollectionCollBookingDataCollection-updateBizDataFromOpData start");

    // 将【DM：托收基本信息.托收入账操作流水号】的值更新为：当前操作流水号
    // 将【DM：托收基本信息.托收入账操作版本号】的值更新为：当前操作版本号
    context.getBizData().setBcBookOpDtl(getBcBookOpDtl());

    // 将【DM：托收基本信息.预计催收登记日期】的值更新为：空
    context.getBizData().setExpctdCollRegDate(null);

    // 将【DM：托收基本信息.预计催收理由】的值更新为：空
    context.getBizData().setExpctdCollResn(null);

    // 将【DM：托收基本信息.预计故障登记日期】的值更新为：空
    context.getBizData().setExpctdFaultRegDate(null);

    // 将【DM：托收基本信息.预计故障登记原因】的值更新为：空
    context.getBizData().setExpctdFaultRegResn(null);
    
    // Combined LC分行号设置
    List<BbCombLcInfo> listBbCombLcInfo = context.getDataRepository().getBizDataCollection().getBbCombLcInfoList();
    if (null !=listBbCombLcInfo ){
	    for (BbCombLcInfo bbCombLcInfo : listBbCombLcInfo) {
	      bbCombLcInfo.setBranchCode(context.getBranchId());
	    }
    }
        
    // 出口信用证信息分行号设置
    ExpLcInfo expLcInfo = context.getDataRepository().getBizDataCollection().getExpLcInfo();
    if (null != expLcInfo){
    	expLcInfo.setBranchCode(context.getBranchId());
    }
    
    logger
        .debug("CollectionCollBookingDataCollection-updateBizDataFromOpData end");
  }

  /**
   * 更新关联操作表的操作流水号，版本号信息
   * @param operSn
   * @param operVerNo
   */
  public void updateOpRelationDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionCollBookingDataCollection-updateOpRelationDtlOperInfo start");
    // 更新【寄单信息】的操作流水号,版本号信息
    dataCollection.updateDispchDocInfoOperInfo(operSn, operVerNo);
    logger
        .debug("CollectionCollBookingDataCollection-updateOpRelationDtlOperInfo end");
  }
  
}
