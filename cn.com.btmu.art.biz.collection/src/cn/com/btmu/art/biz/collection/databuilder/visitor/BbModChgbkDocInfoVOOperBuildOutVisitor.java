package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;

import commonj.sdo.DataObject;

/**
 * BbModChgbkDocInfoVOOperBuildOutVisitor
 * 
 * BbModChgbkDocInfoVO用OperBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BbModChgbkDocInfoVOOperBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<BbModChgbkDocInfo, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BbModChgbkDocInfoVOOperBuildOutVisitor instance = new BbModChgbkDocInfoVOOperBuildOutVisitor();

  /**
   * 构造函数.
   */
  private BbModChgbkDocInfoVOOperBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BbModChgbkDocInfoVOOperBuildOutVisitor实例
   */
  public static BbModChgbkDocInfoVOOperBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  【退改单信息】
   * @param hiddenArea 临时用数据
   * @param to  BbModChgbkDocInfoVO
   *            
   */
  public void buildOutputDataFromPO(BbModChgbkDocInfo from,
      DataObject hiddenArea, BbModChgbkDocInfoVO to) {
    logger
        .debug("BbModChgbkDocInfoVOOperBuildOutVisitor-buildOutputDataFromPO start");
    // 给BbModChgbkDocInfoVO赋值
    if (from != null) {
      logger.debug("【退改单信息】不为空");
      ArtBeanUtils.copyProperties(from, to);
      to.setModChgbkDocRmrk(from.getRmrk());
    }
    logger
        .debug("BbModChgbkDocInfoVOOperBuildOutVisitor-buildOutputDataFromPO end");
  }
}
