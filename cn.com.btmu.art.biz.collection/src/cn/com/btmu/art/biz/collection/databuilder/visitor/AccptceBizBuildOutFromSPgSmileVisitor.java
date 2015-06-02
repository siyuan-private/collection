package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.vo.BcAccptceOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.syscoredataset.SPgSmileInvokeInfo;

import commonj.sdo.DataObject;

/**
 * AccptceBizBuildOutFromSPgSmileVisitor
 * 
 * WSID信息For承兑用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class AccptceBizBuildOutFromSPgSmileVisitor implements
    IDataBuildOutFromPOVisitor<SPgSmileInvokeInfo, BcAccptceOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static AccptceBizBuildOutFromSPgSmileVisitor instance = new AccptceBizBuildOutFromSPgSmileVisitor();

  /**
   * 构造函数.
   */
  private AccptceBizBuildOutFromSPgSmileVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance AccptceBizBuildOutFromSPgSmileVisitor实例
   */
  public static AccptceBizBuildOutFromSPgSmileVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【WSID信息For承兑】
   * @param hiddenArea 临时用数据
   * @param to  BcAccptceOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(SPgSmileInvokeInfo from,
      DataObject hiddenArea, BcAccptceOpDtlVO to) {
    logger
        .debug("AccptceBizBuildOutFromSPgSmileVisitor-buildOutputDataFromPO start");
    if (from != null) {
      logger.debug("【WSID信息For承兑】不为空");
      // WSID.止付WSID1
      to.setBcAccptceWsid1(from.getWsid1());

      // WSID.止付WSID2
      to.setBcAccptceWsid2(from.getWsid2());

      // WSID.止付WSID日期
      to.setBcAccptceWsidDate(from.getBookAcctDate());
    }
    logger
        .debug("AccptceBizBuildOutFromSPgSmileVisitor-buildOutputDataFromPO end");
  }
}
