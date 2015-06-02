package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.collection.vo.ModHisDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;

import commonj.sdo.DataObject;

/**
 * ModHisDtlVOBuildOutVisitor
 * 
 * ModHisDtlVO用OperBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class ModHisDtlVOBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<List<ModHisDtl>, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static ModHisDtlVOBuildOutVisitor instance = new ModHisDtlVOBuildOutVisitor();

  /**
   * 构造函数.
   */
  private ModHisDtlVOBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance ModHisDtlVOBuildOutVisitor实例
   */
  public static ModHisDtlVOBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【修改履历信息】
   * @param hiddenArea 临时用数据
   * @param to  BbModChgbkDocInfoVO
   *            
   */
  public void buildOutputDataFromPO(List<ModHisDtl> from,
      DataObject hiddenArea, BbModChgbkDocInfoVO to) {
    logger.debug("ModHisDtlVOBuildOutVisitor-buildOutputDataFromPO start");
    if (from != null) {
      logger.debug("【修改履历信息】不为空");
      if (to.getModHisDtlVOList() == null) {
        logger.debug("【修改履历信息】VO");
        to.setModHisDtlVOList(new ArrayList<ModHisDtlVO>());
      }
      // 循环赋值
      for (ModHisDtl modHisDtl : from) {
        ModHisDtlVO modHisDtlVO = new ModHisDtlVO();
        ArtBeanUtils.copyProperties(modHisDtl, modHisDtlVO);
        to.getModHisDtlVOList().add(modHisDtlVO);
      }
    }
    logger.debug("ModHisDtlVOBuildOutVisitor-buildOutputDataFromPO end");
  }
}
