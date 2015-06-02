package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.DispchDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildInVisitor;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.DispchDocInfoImpl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

import commonj.sdo.DataObject;

/**
 * DispchDocInfoVOBuildInVisitor
 * 
 * DispchDocInfoVO用BuildIn Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class DispchDocInfoVOBuildInVisitor implements
    IDataBuildInVisitor<List<DispchDocInfo>, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static DispchDocInfoVOBuildInVisitor instance = new DispchDocInfoVOBuildInVisitor();

  /**
   * 构造函数.
   */
  private DispchDocInfoVOBuildInVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance DispchDocInfoVOBuildInVisitor实例
   */
  public static DispchDocInfoVOBuildInVisitor getInstance() {
    return instance;
  }

  /**
   * 将VO转换成BO.
   * 
   * @return void
   * @param from  BcMntnOpDtlVO
   * @param hiddenArea 临时用数据
   * @param to  【寄单信息】
   *            
   */
  public void buildInputData(BcMntnOpDtlVO from, List<DispchDocInfo> to,
      DataObject hiddenArea) {
    logger.debug("DispchDocInfoVOBuildInVisitor-buildInputData start");

    //取得VO【寄单信息】
    List<DispchDocInfoVO> dispchDocInfoVOList = from.getDispchDocInfoVOList();
    // 将VO的数据赋值到【寄单信息】中
    if (dispchDocInfoVOList != null) {
      //循环赋值
      for (DispchDocInfoVO voTemp : dispchDocInfoVOList) {
        if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(voTemp
            .getDispchDocFlgAdd()) && !ArtStringUtil.isEmpty(voTemp.getExprsType())) {
          logger.debug("新增寄单信息");
          DispchDocInfo temp = new DispchDocInfoImpl();
          ArtBeanUtils.copyProperties(voTemp, temp);
          to.add(temp);
        }
      }
    }
    logger.debug("DispchDocInfoVOBuildInVisitor-buildInputData end");
  }
}
