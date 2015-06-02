package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcAccptceOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

import commonj.sdo.DataObject;

/**
 * BcAccptceOpDtlVOBuildInVisitor
 * 
 * BcAccptceOpDtlVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BcAccptceOpDtlVOBuildInVisitor implements
    IDataBuildInVisitor<BcAccptceOpDtl, BcAccptceOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BcAccptceOpDtlVOBuildInVisitor instance = new BcAccptceOpDtlVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private BcAccptceOpDtlVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BcAccptceOpDtlVOBuildInVisitor实例
   */
  public static BcAccptceOpDtlVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BcAccptceOpDtlVO
   * @param hiddenArea 临时用数据
   * @param to  【承兑操作明细】
   *            
   */
  public void buildInputData(BcAccptceOpDtlVO from, BcAccptceOpDtl to,
      DataObject hiddenArea) {
    logger.debug("BcAccptceOpDtlVOBuildInVisitor-buildInputData start");
    // 将VO的数据赋值到Context中
    if(DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(from.getAcceptedFlg())) {
      ArtBeanUtils.copyProperties(from, to);
    }

    logger.debug("BcAccptceOpDtlVOBuildInVisitor-buildInputData end");
  }
}
