package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbCombLcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcInfo;

import commonj.sdo.DataObject;

/**
 * BbCombLcMntnOpDtlVOBizBuildOutVisitor
 * 
 * BbCombLcMntnOpDtlVO用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BbCombLcMntnOpDtlVOBizBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<List<BbCombLcInfo>, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BbCombLcMntnOpDtlVOBizBuildOutVisitor instance = new BbCombLcMntnOpDtlVOBizBuildOutVisitor();

  /**
   * 构造函数.
   */
  private BbCombLcMntnOpDtlVOBizBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BbCombLcMntnOpDtlVOBizBuildOutVisitor实例
   */
  public static BbCombLcMntnOpDtlVOBizBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【Combined LC基本信息】
   * @param hiddenArea 临时用数据
   * @param to  BcAccptceOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(List<BbCombLcInfo> from,
      DataObject hiddenArea, BcMntnOpDtlVO to) {
    logger
        .debug("BbCombLcMntnOpDtlVOBizBuildOutVisitor-buildOutputDataFromPO start");
    // Combined LC 基本信息赋值到VO中
    if (from != null) {
      logger.debug("【Combined LC基本信息】不为空");
      if (to.getBbCombLcMntnOpDtlVoList() == null) {
        logger.debug("【Combined LC基本信息】VO");
        to.setBbCombLcMntnOpDtlVoList(new ArrayList<BbCombLcMntnOpDtlVO>());
      }
      // 循环赋值到VO中
      for (BbCombLcInfo bbCombLcInfo : from) {
        BbCombLcMntnOpDtlVO bbCombLcMntnOpDtlVO = new BbCombLcMntnOpDtlVO();
        ArtBeanUtils.copyProperties(bbCombLcInfo, bbCombLcMntnOpDtlVO);
        to.getBbCombLcMntnOpDtlVoList().add(bbCombLcMntnOpDtlVO);
      }
    }
    logger
        .debug("BbCombLcMntnOpDtlVOBizBuildOutVisitor-buildOutputDataFromPO end");
  }
}
