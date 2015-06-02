package cn.com.btmu.art.biz.collection.datacollection;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollChgbkDetailContext;
import cn.com.btmu.art.biz.common01biz.repo.IOperationDataCollection;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * CollectionCollChgbkDataCollection
 * 
 * 托收退单节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollChgbkDataCollection implements
    IOperationDataCollection<CollectionCollChgbkDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收业务用数据集合. */
  private CollectionOperationDataCollection dataCollection;

  /**
   * 构造函数
   */
  public CollectionCollChgbkDataCollection() {
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
   * 设定出口信用证维护操作明细.
   * 
   * @param expLcMntnOpDtl 出口信用证维护操作明细
   */
  public void setExpLcMntnOpDtl(ExpLcMntnOpDtl expLcMntnOpDtl) {
    dataCollection.setExpLcMntnOpDtl(expLcMntnOpDtl);
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
      List<DispchDocInfo> dispchDocInfoForSaveList) {
    dataCollection.setDispchDocInfoForSaveList(dispchDocInfoForSaveList);
  }

  /**
   * 加载退单节点的操作数据（只包含本机能的操作表，其他业务的通过业务间函数实现）.
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void loadProcessingOpDtlWithRelation(
      CollectionCollChgbkDetailContext context) {
    logger
        .debug("CollectionCollChgbkDataCollection-loadProcessingOpDtlWithRelation start");

    // 加载出口信用证维护操作明细
    dataCollection.loadExpLcMntnOpDtl(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载退改单信息
    dataCollection.loadBbModChgbkDocInfo(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 记载寄单信息
    dataCollection.loadDispchDocInfo(context.getOperSN(), context.getOperVer(),
        context.getCommonDAO());
    logger
        .debug("CollectionCollChgbkDataCollection-loadProcessingOpDtlWithRelation end");
  }

  /**
   * 更新关联操作表的操作流水号，版本号信息
   * @param operSn
   * @param operVerNo
   */
  public void updateOpRelationDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionCollChgbkDataCollection-updateOpRelationDtlOperInfo start");
    // 更新【出口信用证维护操作明细】的操作流水号,版本号信息
    dataCollection.updateExpLcMntnOpDtlOperInfo(operSn, operVerNo);
    // 更新【寄单信息】的操作流水号,版本号信息
    dataCollection.updateDispchDocInfoOperInfo(operSn, operVerNo);
    // 更新【退改单信息】的操作流水号,版本号信息
    dataCollection.updateBbModChgbkDocOperInfo(operSn, operVerNo);
    logger
        .debug("CollectionCollChgbkDataCollection-updateOpRelationDtlOperInfo end");
  }

  /**
   * 从操作信息中更新业务信息
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void updateBizDataFromOpData(CollectionCollChgbkDetailContext context) {
    logger
        .debug("CollectionCollChgbkDataCollection-updateBizDataFromOpData start");

    // 取得托收基本信息
    BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
        .getBcInfo();

    // bcInfo.托收退改单操作流水号 = reqData.操作流水号
    // bcInfo.托收退改单操作版本号 = reqData.操作版本号
    bcInfo.setBbModChgbkDocInfo(context.getDataRepository()
        .getOperationDataCollection().getBbModChgbkDocInfo());

    // bcInfo.预计催收登记日期 = 空
    bcInfo.setExpctdCollRegDate(null);

    // bcInfo.预计催收理由 = 空
    bcInfo.setExpctdCollResn(null);

    // bcInfo.预计故障登记日期 = 空
    bcInfo.setExpctdFaultRegDate(null);

    // bcInfo.预计故障登记原因 = 空
    bcInfo.setExpctdFaultRegResn(null);

    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getLcFlg())) {
      //信用证余额金额处理
      dataCollection.updateLcInfoWithBalanceBbCombLcInfo(context.getBizData()
          .getSCrBizInfo().getBizInfoId(), context.getBizData().getBeneCif(),
          context.getBizData().getBxAmt(), context.getDataRepository()
              .getBizDataCollection().getBbCombLcInfoList());
    }
    
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

    logger.debug("CollectionCollChgbkDataCollection-updateBizDataFromOpData end");
  }

  /**
   * 保存子操作明细信息
   * 
   * @return void
   */
  public void saveOprData(CollectionCollChgbkDetailContext context) {
    logger.debug("CollectionCollChgbkDataCollection-saveOprData start");

    // 当【画：新建.信用证项下】为‘Y’时,保存出口信用证维护操作明细
    dataCollection.saveOrDeleteExpLcMntnOpDtl(context.getDataRepository()
            .getBizDataCollection().getBcInfo(), context.getOperSN(), context
            .getOperVer(), context.getCommonDAO());

    // 保存退改单
    context.getCommonDAO().saveOrUpdate(getBbModChgbkDocInfo());

    // 保存寄单信息表
    dataCollection.saveDispchDocInfoList(context.getOperSN(), context
        .getOperVer());

    logger.debug("CollectionCollChgbkDataCollection-saveOprData end");
  }

  /**
   * @return dataCollection
   */
  public CollectionOperationDataCollection getDataCollection() {
    return dataCollection;
  }

  /**
   * @param dataCollection
   *            要设置的 dataCollection
   */
  public void setDataCollection(CollectionOperationDataCollection dataCollection) {
    this.dataCollection = dataCollection;
  }

}
