package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.DishnrHistInfoVO;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.DishnrHistInfo;

import commonj.sdo.DataObject;

/**
 * DishnrHistInfoVOBizBuildOutVisitor
 * 
 * DishnrHistInfoVO用BizBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class DishnrHistInfoVOBizBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<DishnrHistInfo, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static DishnrHistInfoVOBizBuildOutVisitor instance = new DishnrHistInfoVOBizBuildOutVisitor();

  /**
   * 构造函数.
   */
  private DishnrHistInfoVOBizBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance DishnrHistInfoVOBizBuildOutVisitor实例
   */
  public static DishnrHistInfoVOBizBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【催收拒付故障】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(DishnrHistInfo from, DataObject hiddenArea,
      BcMntnOpDtlVO to) {
    logger
        .debug("DishnrHistInfoVOBizBuildOutVisitor-buildOutputDataFromPO start");
    // 拒付履历信息赋值到VO中
    if (from != null) {
      logger.debug("【催收拒付故障】不为空");
      if (to.getDishnrHistInfoVO() == null) {
        logger.debug("【催收拒付故障】VO");
        to.setDishnrHistInfoVO(new DishnrHistInfoVO());
      }
      ArtBeanUtils.copyProperties(from, to.getDishnrHistInfoVO());
      to.getDishnrHistInfoVO().setDishnrNo(
          from.getDishnrTKind() + ComBizConstant.COMMON_STRING_HYPHEN
              + from.getDishnrTxnTKind() + ComBizConstant.COMMON_STRING_HYPHEN
              + from.getDishnrNo());
      to.getDishnrHistInfoVO().setRegDate(from.getRegDate());
    }
    logger
        .debug("DishnrHistInfoVOBizBuildOutVisitor-buildOutputDataFromPO end");
  }
}
