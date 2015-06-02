package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.FaultHistInfoVO;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.FaultHistInfo;

import commonj.sdo.DataObject;

/**
 * FaultHistInfoVOBizBuildOutVisitor
 * 
 * FaultHistInfoVO用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class FaultHistInfoVOBizBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<FaultHistInfo, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static FaultHistInfoVOBizBuildOutVisitor instance = new FaultHistInfoVOBizBuildOutVisitor();

  /**
   * 构造函数.
   */
  private FaultHistInfoVOBizBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance FaultHistInfoVOBizBuildOutVisitor实例
   */
  public static FaultHistInfoVOBizBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【故障履历信息】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(FaultHistInfo from, DataObject hiddenArea,
      BcMntnOpDtlVO to) {
    logger
        .debug("FaultHistInfoVOBizBuildOutVisitor-buildOutputDataFromPO start");
    // 故障履历信息赋值到VO中
    if (from != null) {
      logger.debug("【故障履历信息】不为空");
      if (to.getFaultHistInfoVO() == null) {
        logger.debug("【故障履历信息】VO");
        to.setFaultHistInfoVO(new FaultHistInfoVO());
      }
      ArtBeanUtils.copyProperties(from, to.getFaultHistInfoVO());
      to.getFaultHistInfoVO().setFaultNo(
          from.getFaultTKind() + ComBizConstant.COMMON_STRING_HYPHEN
              + from.getFaultTxnTKind() + ComBizConstant.COMMON_STRING_HYPHEN
              + from.getFaultNo());
      to.getFaultHistInfoVO().setRegDate(from.getRegDate());
    }
    logger.debug("FaultHistInfoVOBizBuildOutVisitor-buildOutputDataFromPO end");
  }
}
