package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcBookOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

import commonj.sdo.DataObject;

/**
 * BcBookOpDtlVOBuildInVisitor
 * 
 * BcBookOpDtlVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BcBookOpDtlVOBuildInVisitor implements
    IDataBuildInVisitor<BcBookOpDtl, BcBookOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BcBookOpDtlVOBuildInVisitor instance = new BcBookOpDtlVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private BcBookOpDtlVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BcBookOpDtlVOBuildInVisitor实例
   */
  public static BcBookOpDtlVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BcBookOpDtlVO
   * @param hiddenArea 临时用数据
   * @param to  【承兑操作明细】
   *            
   */
  public void buildInputData(BcBookOpDtlVO from, BcBookOpDtl to,
      DataObject hiddenArea) {
    logger.debug("BcBookOpDtlVOBuildInVisitor-buildInputData start");

    ArtBeanUtils.copyProperties(from, to);

    // 名称不同的属性，不能通过CopyProPerties实现，单独赋值
    // 账户性质#1.二级分类code
    to.setAcctPropty2nd1(from.getAcctPropty2ndCd1());
    // 账户性质#2.二级分类code
    to.setAcctPropty2nd2(from.getAcctPropty2ndCd2());
    // 账户性质#1.三级分类code
    to.setAcctPropty3rd1(from.getAcctPropty3rdCd1());
    // 账户性质#2.三级分类code
    to.setAcctPropty3rd2(from.getAcctPropty3rdCd2());

    // checkbox没有选择时设置为"N"
    // 福费廷
    if (to.getForftingFlg() == null) {
      to.setForftingFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // 待核查账户
    if (to.getValidatnFlg() == null) {
      to.setValidatnFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    // 入两个账户
    if (to.getEnter2AcctFlg() == null) {
      to.setEnter2AcctFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    logger.debug("BcBookOpDtlVOBuildInVisitor-buildInputData end");
  }
}
