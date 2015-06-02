package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbModChgbkDocInfo;

import commonj.sdo.DataObject;

/**
 * BbModChgbkDocInfoVOBuildInVisitor
 * 
 * BbModChgbkDocInfoVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BbModChgbkDocInfoVOBuildInVisitor implements
    IDataBuildInVisitor<BbModChgbkDocInfo, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BbModChgbkDocInfoVOBuildInVisitor instance = new BbModChgbkDocInfoVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private BbModChgbkDocInfoVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BbModChgbkDocInfoVOBuildInVisitor实例
   */
  public static BbModChgbkDocInfoVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BbModChgbkDocInfoVO
   * @param hiddenArea 临时用数据
   * @param to  【退改单信息】
   *            
   */
  public void buildInputData(BbModChgbkDocInfoVO from, BbModChgbkDocInfo to,
      DataObject hiddenArea) {
    logger.debug("BbModChgbkDocInfoVOBuildInVisitor-buildInputData start");
    // 将VO的数据赋值到Context中
    ArtBeanUtils.copyProperties(from, to);
    to.setRmrk(from.getModChgbkDocRmrk());
    logger.debug("BbModChgbkDocInfoVOBuildInVisitor-buildInputData end");
  }
}
