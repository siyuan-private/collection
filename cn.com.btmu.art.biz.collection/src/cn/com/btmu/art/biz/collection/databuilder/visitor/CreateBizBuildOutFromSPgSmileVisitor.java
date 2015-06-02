package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.syscoredataset.SPgSmileInvokeInfo;

import commonj.sdo.DataObject;

/**
 * CreateBizBuildOutFromSPgSmileVisitor
 * 
 * WSID信息For新建用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class CreateBizBuildOutFromSPgSmileVisitor implements
    IDataBuildOutFromPOVisitor<SPgSmileInvokeInfo, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static CreateBizBuildOutFromSPgSmileVisitor instance = new CreateBizBuildOutFromSPgSmileVisitor();

  /**
   * 构造函数.
   */
  private CreateBizBuildOutFromSPgSmileVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance CreateBizBuildOutFromSPgSmileVisitor实例
   */
  public static CreateBizBuildOutFromSPgSmileVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【WSID信息For新建】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(SPgSmileInvokeInfo from,
      DataObject hiddenArea, BcMntnOpDtlVO to) {
    logger
        .debug("CreateBizBuildOutFromSPgSmileVisitor-buildOutputDataFromPO start");
    if (from != null) {
      logger.debug("【WSID信息For新建】不为空");
      // WSID.止付WSID1
      to.setBcMntnWsid1(from.getWsid1());

      // WSID.止付WSID2
      to.setBcMntnWsid2(from.getWsid2());

      // WSID.止付WSID日期
      to.setBcMntnWsidDate(from.getBookAcctDate());
    }
    logger
        .debug("CreateBizBuildOutFromSPgSmileVisitor-buildOutputDataFromPO end");
  }
}
