package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbCombLcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;

import commonj.sdo.DataObject;

/**
 * BbCombLcMntnOpDtlVOOperBuildOutVisitor
 * 
 * BbCombLcMntnOpDtlVO用OperBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BbCombLcMntnOpDtlVOOperBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<List<BbCombLcMntnOpDtl>, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BbCombLcMntnOpDtlVOOperBuildOutVisitor instance = new BbCombLcMntnOpDtlVOOperBuildOutVisitor();

  /**
   * 构造函数.
   */
  private BbCombLcMntnOpDtlVOOperBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BbCombLcMntnOpDtlVOOperBuildOutVisitor实例
   */
  public static BbCombLcMntnOpDtlVOOperBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【Combined LC维护操作明细】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(List<BbCombLcMntnOpDtl> from,
      DataObject hiddenArea, BcMntnOpDtlVO to) {
    logger
        .debug("BbCombLcMntnOpDtlVOOperBuildOutVisitor-buildOutputDataFromPO start");
    // Combined LC 维护操作信息赋值到VO中
    if (from != null) {
      logger.debug("【Combined LC维护操作明细】不为空");
      if (to.getBbCombLcMntnOpDtlVoList() == null) {
        logger.debug("【Combined LC基本信息】VO");
        to.setBbCombLcMntnOpDtlVoList(new ArrayList<BbCombLcMntnOpDtlVO>());
      }
      // 循环赋值到VO中
      for (BbCombLcMntnOpDtl bbComLcMntnOpDtl : from) {
        BbCombLcMntnOpDtlVO bbCombLcMntnOpDtlVO = new BbCombLcMntnOpDtlVO();
        ArtBeanUtils.copyProperties(bbComLcMntnOpDtl, bbCombLcMntnOpDtlVO);
        to.getBbCombLcMntnOpDtlVoList().add(bbCombLcMntnOpDtlVO);
      }
    }
    logger
        .debug("BbCombLcMntnOpDtlVOOperBuildOutVisitor-buildOutputDataFromPO end");
  }
}
