package cn.com.btmu.art.biz.collection.datacollection.common;

import java.util.List;

import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext;
import cn.com.btmu.art.biz.common01biz.repo.IOperationDataCollection;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;

/**
 * CollectionCollCreateDataCollection 
 * 
 * 托收业务新建节点操作信息数据集合.
 * 
 * @author ivision
 * @version 1.0.0
 */
public interface ICollectionCommonMntnDataCollection<T extends AbstractProtoDetailContext> extends
    IOperationDataCollection<T> {

	/** 当前新建操作节点用到的所有操作信息的取得方法 */

  /**
   * 取得托收维护操作明细.
   * 
   * @return BcMntnOpDtl 托收维护操作明细
   */
  public BcMntnOpDtl getBcMntnOpDtl();

  /**
   * 取得出口信用证维护操作明细.
   * 
   * @return ExpLcMntnOpDtl 出口信用证维护操作明细
   */
  public ExpLcMntnOpDtl getExpLcMntnOpDtl();
  
  /**
   * 设置出口信用证维护操作明细.
   * 
   * @param expLcMntnOpDtl 出口信用证维护操作明细
   */
  public void setExpLcMntnOpDtl(ExpLcMntnOpDtl expLcMntnOpDtl);

  /**
   * 取得Combined LC 维护操作明细.
   * 
   * @return BbCombLcMntnOpDtl Combined LC 维护操作明细
   */
  public List<BbCombLcMntnOpDtl> getBbCombLcMntnOpDtlList();

  /**
   * 取得寄单信息 用于保存当前节点新增条目用
   * 
   * @return DispchDocInfo 寄单信息
   */
  public List<DispchDocInfo> getDispchDocInfoForSaveList();
  
	/**
	 * @return combinedLcInfo
	 */
	public List<ExpLcInfo> getCombinedLcInfo();

	/**
	 * @param combinedLcInfo 要设置的 combinedLcInfo
	 */
	public void setCombinedLcInfo(List<ExpLcInfo> combinedLcInfo);

	/**
	 * @return mainLcInfo
	 */
	public ExpLcInfo getMainLcInfo();

	/**
	 * @param mainLcInfo 要设置的 mainLcInfo
	 */
	public void setMainLcInfo(ExpLcInfo mainLcInfo);
	
	public boolean isNeedToTrigLcKindle();
}
