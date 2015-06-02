package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcAccptceOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;

import commonj.sdo.DataObject;

/**
 * BcAccptceOpDtlVOBizBuildOutVisitor
 * 
 * BcAccptceOpDtlVO用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BcAccptceOpDtlVOBizBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<BcAccptceOpDtl, BcAccptceOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BcAccptceOpDtlVOBizBuildOutVisitor instance = new BcAccptceOpDtlVOBizBuildOutVisitor();

  /**
   * 构造函数.
   */
  private BcAccptceOpDtlVOBizBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BcAccptceOpDtlVOBizBuildOutVisitor实例
   */
  public static BcAccptceOpDtlVOBizBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【托收承兑操作信息】
   * @param hiddenArea 临时用数据
   * @param to  BcAccptceOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(BcAccptceOpDtl from, DataObject hiddenArea,
      BcAccptceOpDtlVO to) {
    logger
        .debug("BcAccptceOpDtlVOBizBuildOutVisitor-buildOutputDataFromPO start");
    if (from != null) {
      logger.debug("【托收承兑操作信息】不为空");
      ArtBeanUtils.copyProperties(from, to);
    }
    logger
        .debug("BcAccptceOpDtlVOBizBuildOutVisitor-buildOutputDataFromPO end");
  }
}
