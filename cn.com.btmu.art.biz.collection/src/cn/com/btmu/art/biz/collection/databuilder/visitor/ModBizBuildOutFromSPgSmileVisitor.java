package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.syscoredataset.SPgSmileInvokeInfo;

import commonj.sdo.DataObject;

/**
 * ModBizBuildOutFromSPgSmileVisitor
 * 
 * WSID信息For退改单用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class ModBizBuildOutFromSPgSmileVisitor implements
    IDataBuildOutFromPOVisitor<SPgSmileInvokeInfo, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static ModBizBuildOutFromSPgSmileVisitor instance = new ModBizBuildOutFromSPgSmileVisitor();

  /**
   * 构造函数.
   */
  private ModBizBuildOutFromSPgSmileVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance ModBizBuildOutFromSPgSmileVisitor实例
   */
  public static ModBizBuildOutFromSPgSmileVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【WSID信息For退改单】
   * @param hiddenArea 临时用数据
   * @param to  BbModChgbkDocInfoVO
   *            
   */
  public void buildOutputDataFromPO(SPgSmileInvokeInfo from,
      DataObject hiddenArea, BbModChgbkDocInfoVO to) {
    logger
        .debug("ModBizBuildOutFromSPgSmileVisitor-buildOutputDataFromPO start");
    if (from != null) {
      logger.debug("【WSID信息For退改单】不为空");
      // WSID.止付WSID1
      to.setModChgbkDocWsid1(from.getWsid1());

      // WSID.止付WSID2
      to.setModChgbkDocWsid2(from.getWsid2());

      // WSID.止付WSID日期
      to.setModChgbkDocWsidDate(from.getBookAcctDate());
    }
    logger.debug("ModBizBuildOutFromSPgSmileVisitor-buildOutputDataFromPO end");
  }
}
