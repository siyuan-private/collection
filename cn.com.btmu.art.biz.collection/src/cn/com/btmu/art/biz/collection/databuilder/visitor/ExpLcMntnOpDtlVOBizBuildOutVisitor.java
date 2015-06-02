package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.ExpLcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;

import commonj.sdo.DataObject;

/**
 * ExpLcMntnOpDtlVOBizBuildOutVisitor
 * 
 * ExpLcMntnOpDtlVO用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class ExpLcMntnOpDtlVOBizBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<ExpLcInfo, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static ExpLcMntnOpDtlVOBizBuildOutVisitor instance = new ExpLcMntnOpDtlVOBizBuildOutVisitor();

  /**
   * 构造函数.
   */
  private ExpLcMntnOpDtlVOBizBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance ExpLcMntnOpDtlVOBizBuildOutVisitor实例
   */
  public static ExpLcMntnOpDtlVOBizBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【出口信用证信息】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(ExpLcInfo from, DataObject hiddenArea,
      BcMntnOpDtlVO to) {
    logger
        .debug("ExpLcMntnOpDtlVOBizBuildOutVisitor-buildOutputDataFromPO start");
    // 将context中的出口信用证基本信息赋值到VO中
    if (from != null) {
      logger.debug("【出口信用证信息】不为空");
      if (to.getExpLcMntnOpDtlVO() == null) {
        logger.debug("【出口信用证信息】VO");
        to.setExpLcMntnOpDtlVO(new ExpLcMntnOpDtlVO());
      }
      ArtBeanUtils.copyProperties(from, to.getExpLcMntnOpDtlVO());
      // 无字段名称不一样项
    }
    logger
        .debug("ExpLcMntnOpDtlVOBizBuildOutVisitor-buildOutputDataFromPO end");
  }
}
