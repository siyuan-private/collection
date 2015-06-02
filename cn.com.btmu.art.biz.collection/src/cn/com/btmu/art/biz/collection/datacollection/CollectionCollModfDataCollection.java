package cn.com.btmu.art.biz.collection.datacollection;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModfDetailContext;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.repo.IOperationDataCollection;
import cn.com.btmu.art.component.autocomplete.AutoMemoryUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dao.ICommonDAO;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * CollectionCollModfDataCollection
 * 
 * 托收修正节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollModfDataCollection implements
    IOperationDataCollection<CollectionCollModfDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 托收业务用数据集合. */
  private CollectionOperationDataCollection dataCollection;

  /**
   * 构造函数
   */
  public CollectionCollModfDataCollection() {
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
   * 取得承兑维护操作明细For操作.
   * 
   * @return BcAccptceOpDtl 承兑维护操作明细
   */
  public BcAccptceOpDtl getBcAccptceOpDtl() {
    return dataCollection.getBcAccptceOpDtl();
  }

  /**
   * 设定承兑维护操作明细For操作.
   * 
   * @return bcAccptceOpDtl 承兑维护操作明细
   */
  public void setBcAccptceOpDtl(BcAccptceOpDtl bcAccptceOpDtl) {
    dataCollection.setBcAccptceOpDtl(bcAccptceOpDtl);
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
   * 
   * @param context 上下文信息
   * @return 需要故障销号true,否则false
   */
  public boolean isNeedToTrigFaultClear(CollectionCollModfDetailContext context) {
    logger.debug("CollectionCollModfDataCollection-isNeedToTrigFaultClear start");
    // 业务或操作承兑flag为“N”时
    if(getBcAccptceOpDtl() == null || context
        .getDataRepository().getBizDataCollection().getBcAccptceOpDtl() == null) {
      logger.debug("CollectionCollModfDataCollection-isNeedToTrigFaultClear end");
      return false;
    }
    // 业务且操作承兑flag为“Y”时
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcAccptceOpDtl()
        .getAcceptedFlg())
        && DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(context
            .getDataRepository().getBizDataCollection().getBcAccptceOpDtl()
            .getAcceptedFlg())) {
      logger.debug("CollectionCollModfDataCollection-isNeedToTrigFaultClear end");
        return true;
      }
    logger.debug("CollectionCollModfDataCollection-isNeedToTrigFaultClear end");
    return false;
  }
  
  
  
  /**
   * 判定是否【DM：修改操作履历明细.修改项目名】中存在‘到期日期’
   * @return 存在true，否则false
   */
  public boolean isExistDueDate() {
    logger.debug("CollectionCollModfDataCollection-isExistDueDate start");
    //  根据当前操作流水号+当前操作版本号到【DM：修改操作履历明细】中检索,当检索结果大于0件且【DM：修改操作履历明细.修改项目名】中存在‘到期日期’时
    if (getModHisDtlList() != null) {
      logger.debug("【修改履历信息】不为空");
      // 取得修改履历明细数据
      List<ModHisDtl> modHisDtlList = getModHisDtlList();
      for (ModHisDtl modHisDtl : modHisDtlList) {
        // 【DM：修改操作履历明细.修改项目名】中存在‘到期日期’时
        if (CollectionConstant.MODITEMNAME_DUEDATE.equals(modHisDtl
            .getModfctnItemName())) {
          logger.debug("CollectionCollModfDataCollection-isExistDueDate end");
          return true;
        }
      }
    }
    logger.debug("CollectionCollModfDataCollection-isExistDueDate end");
    return false;
  }
  
  /**
   *  判定是否承兑flag的值变化
   * @param context 上下文信息
   * @return 承兑flag的值变化时true，否则false
   */
  public boolean isChangeAccFlg(CollectionCollModfDetailContext context) {
    logger.debug("CollectionCollModfDataCollection-isChangeAccFlg start");
    if(getBcAccptceOpDtl() == null) {
      if(context.getDataRepository().getBizDataCollection().getBcAccptceOpDtl() != null){
        logger.debug("CollectionCollModfDataCollection-isChangeAccFlg end");
        return true;
      }
    }else if(context.getDataRepository().getBizDataCollection().getBcAccptceOpDtl() == null) {
      logger.debug("CollectionCollModfDataCollection-isChangeAccFlg end");
        return true;
    }
    logger.debug("CollectionCollModfDataCollection-isChangeAccFlg end");
    return false;
  }

  /**
   * 判定是否需要进行催收,拒付,故障销号的触发处理
   * @return 需要触发true，否则false
   */
  public boolean isNeedToTrigOPFClear(CollectionCollModfDetailContext context) {
    logger
        .debug("CollectionCollModfDataCollection-isNeedToTrigOPFClear start");
   if(isExistDueDate() && isNeedToTrigFaultClear(context)) {
     logger.debug("CollectionCollModfDataCollection-isNeedToTrigOPFClear end");
     return true;
   }else{
     logger.debug("CollectionCollModfDataCollection-isNeedToTrigOPFClear end");
    return isChangeAccFlg(context);
    }
  }

  /**
   * 加载退改单节点的操作数据（只包含本机能的操作表，其他业务的通过业务间函数实现）.
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void loadProcessingOpDtlWithRelation(
      CollectionCollModfDetailContext context) {
    logger
        .debug("CollectionCollModfDataCollection-loadProcessingOpDtlWithRelation start");

    if (context.getReqData() == null) {
      logger.debug("【托收维护操作明细】为空");
      logger
          .debug("CollectionCollModfDataCollection-loadProcessingOpDtlWithRelation end");
      return;
    }

    // 设置当前操作的操作数据信息[托收维护操作明细]
    dataCollection.setBcMntnOpDtl(context.getReqData());

    // 加载托收承兑操作明细
    dataCollection.loadBcAccptceOpDtl(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载退改单信息
    dataCollection.loadBbModChgbkDocInfo(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载出口信用证维护操作明细
    dataCollection.loadExpLcMntnOpDtl(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    // 加载修改履历信息
    dataCollection.loadModHisDtlList(getBcMntnOpDtl().getOperSn(),
        getBcMntnOpDtl().getOperVerNo(), context.getCommonDAO());

    logger
        .debug("CollectionCollModfDataCollection-loadProcessingOpDtlWithRelation end");
  }

  /**
   * 从操作信息中更新业务信息.
   * 
   * @return void
   * @param context
   *            上下文信息
   */
  public void updateBizDataFromOpData(CollectionCollModfDetailContext context) {
    logger
        .debug("CollectionCollModfDataCollection-updateBizDataFromOpData start");

    // 托收退改单操作流水号
    // 托收退改单操作版本号
    context.getBizData().setBbModChgbkDocInfo(getBbModChgbkDocInfo());

    // 当【画：新建.信用证项下】为‘Y’时
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getLcFlg())) {
      logger.debug("【画：新建.信用证项下】为'Y'");
      // 将【DM：出口信用证维护操作明细】全量更新至【DM：出口信用证信息】
      dataCollection.updateLcInfo(context.getBizData().getSCrBizInfo()
          .getBizInfoId(), context.getDataRepository().getBizDataCollection()
          .getBcInfo().getBeneCif());
    }

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
    
    if (isNeedToTrigOPFClear(context)) {
      // 调用组件列表【I00180】，参数：业务种类，空，操作，取得预计催收登记日、预计催收原因
      // 调用组件列表【I00190】，参数：业务种类，空，操作，空，取得预计故障登记日、预计故障理由
      BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
          .getBcInfo();
      dataCollection.updatePredictToBcInfo(
          CollectionConstant.MODF_OPERATION_ID, bcInfo, getBcAccptceOpDtl()
              .getAccptceDueDate());
    }
    
    // Combined LC分行号设置
    List<BbCombLcInfo> listBbCombLcInfo = context.getDataRepository()
				.getBizDataCollection().getBbCombLcInfoList();
		if (null != listBbCombLcInfo) {
			for (BbCombLcInfo bbCombLcInfo : listBbCombLcInfo) {
				bbCombLcInfo.setBranchCode(context.getBranchId());
			}
		}
        
    // 出口信用证信息分行号设置
	ExpLcInfo expLcInfo = context.getDataRepository()
			.getBizDataCollection().getExpLcInfo();
	if (null != expLcInfo) {
		expLcInfo.setBranchCode(context.getBranchId());
	}
    logger
        .debug("CollectionCollModfDataCollection-updateBizDataFromOpData end");
  }

  /**
   * 保存子操作明细信息
   * 
   * @return void
   */
  public void saveOprData(CollectionCollModfDetailContext context) {
    logger.debug("CollectionCollModfDataCollection-saveOprData start");
    // 操作版本号
    int operVer = context.getOperVer();
    // 操作流水号
    String operSN = context.getOperSN();
    ICommonDAO commonDAO = context.getCommonDAO();

    // 取得匹配业务数据项数值采集Bean
    AutoMemoryUtil autoMemoryUtil = (AutoMemoryUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90540_UTIL_AUTOMEMORY);

    // 非信用证寄单精确匹配时的数据扩展值,自动记忆数据的存储
    dataCollection
        .autoMemoForNotLcDispch(autoMemoryUtil, context.getBranchId());

    // 保存出口信用证维护操作明细
    if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcMntnOpDtl()
        .getLcFlg())) {
      logger.debug("【出口信用证维护操作明细】不为空");

      // 信用证精确匹配时的数据扩展值,自动记忆数据的存储
      dataCollection.autoMemoForLc(autoMemoryUtil, context.getBranchId());

      // 当【画：新建.信用证项下】为‘Y’时，保存出口信用证维护操作明细
      context.getCommonDAO().saveOrUpdate(getBcMntnOpDtl());
    }

    // 将【画：退改单】板块的项目值保存至【DM：退改单信息】
    //    dataCollection.saveOrUpdateBbModChgbkDocInfo(operSN,operVer,commonDAO);
    context.getCommonDAO().saveOrUpdate(getBbModChgbkDocInfo());

    // 保存承兑操作明细
    if (getBcAccptceOpDtl() != null) {
      logger.debug("【承兑维护操作明细For操作】不为空");
      if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getBcAccptceOpDtl()
          .getAcceptedFlg())) {
        commonDAO.saveOrUpdate(getBcAccptceOpDtl());
      }
    }

    // 保存修改履历信息
    dataCollection.saveModHisDtlList(context.getOperSN(), context.getOperVer(),
        commonDAO);

    // 保存寄单信息
    //  dataCollection.deleteDispchDocInfo(operSN,operVer,commonDAO);    
    //    dataCollection.updateDispchDocInfoForSaveList(operSN,operVer);
    dataCollection.saveDispchDocInfoList(context.getOperSN(), context
        .getOperVer());

    logger.debug("CollectionCollModfDataCollection-saveOprData end");
  }

  /**
   * 更新关联操作表的操作流水号，版本号信息
   * @param operSn
   * @param operVerNo
   */
  public void updateOpRelationDtlOperInfo(String operSn, int operVerNo) {
    logger
        .debug("CollectionCollModfDataCollection-updateOpRelationDtlOperInfo start");
    // 更新【出口信用证维护操作明细】的操作流水号,版本号信息
    dataCollection.updateExpLcMntnOpDtlOperInfo(operSn, operVerNo);
    // 更新【寄单信息】的操作流水号,版本号信息
    dataCollection.updateDispchDocInfoOperInfo(operSn, operVerNo);
    // 更新【退改单信息】的操作流水号,版本号信息
    dataCollection.updateBbModChgbkDocOperInfo(operSn, operVerNo);
    // 更新【修改履历】的流水号，版本号信息
    dataCollection.updateModHisDtlOperInfo(operSn, operVerNo);
    // 更新【承兑操作明细】的流水号，版本号信息
    dataCollection.updateBcAccptceOpDtlOperInfo(operSn, operVerNo);
    logger
        .debug("CollectionCollModfDataCollection-updateOpRelationDtlOperInfo end");
  }

//  /**
//   * 判定是否需要进行催收,拒付,故障销号的触发处理
//   * @return 需要触发true，否则false
//   */
//  public boolean isNeedToTrigOPFClear() {
//    return dataCollection.isNeedToTrigOPFClear();
//  }
}
