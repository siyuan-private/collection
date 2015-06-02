package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

import commonj.sdo.DataObject;

/**
 * BcMntnOpDtlVOBuildInVisitor
 * 
 * BcMntnOpDtlVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BcMntnOpDtlVOBuildInVisitor implements
    IDataBuildInVisitor<BcMntnOpDtl, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BcMntnOpDtlVOBuildInVisitor instance = new BcMntnOpDtlVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private BcMntnOpDtlVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BcMntnOpDtlVOBuildInVisitor实例
   */
  public static BcMntnOpDtlVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BcMntnOpDtlVO
   * @param hiddenArea 临时用数据
   * @param to  【托收操作明细】
   *            
   */
  public void buildInputData(BcMntnOpDtlVO from, BcMntnOpDtl to,
      DataObject hiddenArea) {
    logger.debug("BcMntnOpDtlVOBuildInVisitor-buildInputData start");
    // 将VO的数据赋值到Context中
    ArtBeanUtils.copyProperties(from, to);
    // 字段名不一样的单独赋值
    // 备注
    to.setRmrk(from.getNewRmrk());
    // 备注.备注1
    to.setRmrk1(from.getDocRmrk1());
    // 备注.备注2
    to.setRmrk2(from.getDocRmrk2());
    // 备注.备注3
    to.setRmrk3(from.getDocRmrk3());
    // T-Kind
    to.setTKind(from.getTkind());

    // checkbox没有选择时设置为"N"
    // 网银
    if (to.getInternetFlg() == null) {
      to.setInternetFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // 跨境人民币
    if (to.getCrsBorderRmbFlg() == null) {
      to.setCrsBorderRmbFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // BPO
    if (to.getBpoFlg() == null) {
      to.setBpoFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // TSU
    if (to.getTsuFlg() == null) {
      to.setTsuFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // P.P. NEGO
    if (to.getPpnegoFlg() == null) {
      to.setPpnegoFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    logger.debug("BcMntnOpDtlVOBuildInVisitor-buildInputData end");
  }
}
