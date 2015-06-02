package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;

import commonj.sdo.DataObject;

/**
 * BcInfoVOBuildOutVisitor
 * 
 * BcInfoVO用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BcInfoVOBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<BcInfo, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BcInfoVOBuildOutVisitor instance = new BcInfoVOBuildOutVisitor();

  /**
   * 构造函数.
   */
  private BcInfoVOBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BcInfoVOBuildOutVisitor实例
   */
  public static BcInfoVOBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【托收基本信息】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(BcInfo from, DataObject hiddenArea,
      BcMntnOpDtlVO to) {
    logger.debug("BcInfoVOBuildOutVisitor-buildOutputDataFromPO start");
    // 将context中【托收基本信息】的值赋值到VO中
    if (from != null) {
      logger.debug("【托收基本信息】不为空");
      ArtBeanUtils.copyProperties(from, to);

      // 名称不同的属性，不能通过CopyProPerties实现，单独赋值
      // 备注
      to.setNewRmrk(from.getRmrk());
      // 备注.备注1
      to.setDocRmrk1(from.getRmrk1());
      // 备注.备注2
      to.setDocRmrk2(from.getRmrk2());
      // 备注.备注2
      to.setDocRmrk3(from.getRmrk3());
      // T-Kind
      to.setTkind(from.getTKind());
      // 第二受益人银行国别.国家
      to.setBene2ndNatnlty(from.getBene2ndCountry());
    }
    logger.debug("BcInfoVOBuildOutVisitor-buildOutputDataFromPO end");
  }
}
