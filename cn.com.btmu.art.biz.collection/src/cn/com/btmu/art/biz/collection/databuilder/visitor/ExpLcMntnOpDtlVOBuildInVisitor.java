package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

import commonj.sdo.DataObject;

/**
 * ExpLcMntnOpDtlVOBuildInVisitor
 * 
 * ExpLcMntnOpDtlVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class ExpLcMntnOpDtlVOBuildInVisitor implements
    IDataBuildInVisitor<ExpLcMntnOpDtl, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static ExpLcMntnOpDtlVOBuildInVisitor instance = new ExpLcMntnOpDtlVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private ExpLcMntnOpDtlVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance ExpLcMntnOpDtlVOBuildInVisitor实例
   */
  public static ExpLcMntnOpDtlVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BcMntnOpDtlVO
   * @param hiddenArea 临时用数据
   * @param to  【出口信用证维护操作明细】
   *            
   */
  public void buildInputData(BcMntnOpDtlVO from, ExpLcMntnOpDtl to,
      DataObject hiddenArea) {
    logger.debug("ExpLcMntnOpDtlVOBuildInVisitor-buildInputData start");
    if (null == from || null == from.getExpLcMntnOpDtlVO()){
    	return;
    }
    // 将VO的数据赋值到【出口信用证维护操作明细】中
    ArtBeanUtils.copyProperties(from.getExpLcMntnOpDtlVO(), to);
    // checkbox没有选择时设置为"N"
    // 我行承兑
    if (to.getOurBankAccptceFlg() == null) {
      to.setOurBankAccptceFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // 留行信用证
    if (to.getKibLcFlg() == null) {
      to.setKibLcFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    logger.debug("ExpLcMntnOpDtlVOBuildInVisitor-buildInputData end");
  }
}
