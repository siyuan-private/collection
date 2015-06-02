package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BbCombLcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbCombLcMntnOpDtlImpl;

import commonj.sdo.DataObject;

/**
 * BbCombLcMntnOpDtlVOBuildInVisitor
 * 
 * BbCombLcMntnOpDtlVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BbCombLcMntnOpDtlVOBuildInVisitor implements
    IDataBuildInVisitor<List<BbCombLcMntnOpDtl>, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BbCombLcMntnOpDtlVOBuildInVisitor instance = new BbCombLcMntnOpDtlVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private BbCombLcMntnOpDtlVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BbCombLcMntnOpDtlVOBuildInVisitor实例
   */
  public static BbCombLcMntnOpDtlVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BcMntnOpDtlVO
   * @param hiddenArea 临时用数据
   * @param to  【Combined LC维护操作明细】
   *            
   */
  public void buildInputData(BcMntnOpDtlVO from, List<BbCombLcMntnOpDtl> to,
      DataObject hiddenArea) {
    logger.debug("BbCombLcMntnOpDtlVOBuildInVisitor-buildInputData start");
    if (null == from || null == from.getBbCombLcMntnOpDtlVoList()) {
    	return;
    }
    to.clear();
    // 将VO的数据赋值到【Combined LC维护操作明细】中
    List<BbCombLcMntnOpDtlVO> combLcVOList = from.getBbCombLcMntnOpDtlVoList();
    // 画面【Combined LC维护操作明细】VO不为空，循环赋值到BO
    if (combLcVOList != null) {
      for (BbCombLcMntnOpDtlVO voTemp : combLcVOList) {
        BbCombLcMntnOpDtl temp = new BbCombLcMntnOpDtlImpl();
        if (!ArtStringUtil.isEmpty(voTemp.getLcNo())) {
        	ArtBeanUtils.copyProperties(voTemp, temp);
            to.add(temp);
        }
      }
    }
    logger.debug("BbCombLcMntnOpDtlVOBuildInVisitor-buildInputData end");
  }
}
