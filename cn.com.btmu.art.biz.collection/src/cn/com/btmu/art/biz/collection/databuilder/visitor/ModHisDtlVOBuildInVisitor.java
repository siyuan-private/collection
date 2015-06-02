package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.collection.vo.ModHisDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;
import cn.com.btmu.art.framework.bo.domain.brdataset.impl.ModHisDtlImpl;

import commonj.sdo.DataObject;

/**
 * ModHisDtlVOBuildInVisitor
 * 
 * ModHisDtlVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class ModHisDtlVOBuildInVisitor implements
    IDataBuildInVisitor<List<ModHisDtl>, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static ModHisDtlVOBuildInVisitor instance = new ModHisDtlVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private ModHisDtlVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance ModHisDtlVOBuildInVisitor实例
   */
  public static ModHisDtlVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BbModChgbkDocInfoVO
   * @param hiddenArea 临时用数据
   * @param to  【修改履历】
   *            
   */
  public void buildInputData(BbModChgbkDocInfoVO from, List<ModHisDtl> to,
      DataObject hiddenArea) {
    logger.debug("ModHisDtlVOBuildInVisitor-buildInputData start");

    if(from.getModHisDtlVOList() != null) {
    	to.clear();
        // 将vo的数据赋值到修改履历表中
        for (ModHisDtlVO modHisDtlVO : from.getModHisDtlVOList()) {
          ModHisDtl modHisDtl = new ModHisDtlImpl();
          ArtBeanUtils.copyProperties(modHisDtlVO, modHisDtl);
          to.add(modHisDtl);
        }
    }
    
    logger.debug("ModHisDtlVOBuildInVisitor-buildInputData end");
  }
}
