package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.ExpLcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;

import commonj.sdo.DataObject;

/**
 * ExpLcMntnOpDtlVOOperBuildOutVisitor
 * 
 * ExpLcMntnOpDtlVO用OperBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class ExpLcMntnOpDtlVOOperBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<ExpLcMntnOpDtl, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static ExpLcMntnOpDtlVOOperBuildOutVisitor instance = new ExpLcMntnOpDtlVOOperBuildOutVisitor();

  /**
   * 构造函数.
   */
  private ExpLcMntnOpDtlVOOperBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance ExpLcMntnOpDtlVOOperBuildOutVisitor实例
   */
  public static ExpLcMntnOpDtlVOOperBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【出口信用证维护操作明细】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(ExpLcMntnOpDtl from, DataObject hiddenArea,
      BcMntnOpDtlVO to) {
    logger
        .debug("ExpLcMntnOpDtlVOOperBuildOutVisitor-buildOutputDataFromPO start");
    // 将context中的出口信用证维护信息赋值到VO中
    if (from != null) {
      logger.debug("【出口信用证维护操作明细】不为空");
      if (to.getExpLcMntnOpDtlVO() == null) {
        logger.debug("【出口信用证维护操作明细】VO");
        to.setExpLcMntnOpDtlVO(new ExpLcMntnOpDtlVO());
      }
      ArtBeanUtils.copyProperties(from, to.getExpLcMntnOpDtlVO());
    }
    logger
        .debug("ExpLcMntnOpDtlVOOperBuildOutVisitor-buildOutputDataFromPO end");
  }
}
