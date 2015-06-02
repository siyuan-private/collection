package cn.com.btmu.art.biz.collection.databuilder.visitor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.DishnrHistInfoVO;
import cn.com.btmu.art.biz.collection.vo.DispchDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

import commonj.sdo.DataObject;

/**
 * DispchDocInfoVOBuildOutVisitor
 * 
 * DispchDocInfoVO用OperBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class DispchDocInfoVOBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<List<DispchDocInfo>, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static DispchDocInfoVOBuildOutVisitor instance = new DispchDocInfoVOBuildOutVisitor();

  /**
   * 构造函数.
   */
  private DispchDocInfoVOBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance DispchDocInfoVOBuildOutVisitor实例
   */
  public static DispchDocInfoVOBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【寄单信息】
   * @param hiddenArea 临时用数据
   * @param to  BcMntnOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(List<DispchDocInfo> from,
      DataObject hiddenArea, BcMntnOpDtlVO to) {
    logger.debug("DispchDocInfoVOBuildOutVisitor-buildOutputDataFromPO start");
    if (from != null) {
      logger.debug("【寄单信息】不为空");
      if (to.getDishnrHistInfoVO() == null) {
        logger.debug("【寄单信息】VO");
        to.setDishnrHistInfoVO(new DishnrHistInfoVO());
      }
      // 操作流水号
      String operSN = hiddenArea.getString(CollectionConstant.VISITOR_OPERSN);
      // 操作版本号
      int operVer = hiddenArea.getInt(CollectionConstant.VISITOR_OPERVER);

      // 循环赋值
      for (DispchDocInfo dispchDocInfo : from) {

        DispchDocInfoVO dispchDocInfoVO = new DispchDocInfoVO();
        ArtBeanUtils.copyProperties(dispchDocInfo, dispchDocInfoVO);
        // 字段名不一致的字段需要单独赋值
        // 备注 
        dispchDocInfoVO.setDispchDocRmrk(dispchDocInfo.getRmrk());

        if (ArtStringUtil.equals(dispchDocInfo.getOperSn(), operSN)
            && dispchDocInfo.getOperVerNo() == operVer) {
          logger.debug("新增寄单信息标志设为‘Y’");
          dispchDocInfoVO.setDispchDocFlgAdd(DataTypeConstant.DATA_TYPE_YES);
        } else {
          logger.debug("新增寄单信息标志设为‘N’");
          dispchDocInfoVO.setDispchDocFlgAdd(DataTypeConstant.DATA_TYPE_NO);
        }
        to.getDispchDocInfoVOList().add(dispchDocInfoVO);
      }
    }
    logger.debug("DispchDocInfoVOBuildOutVisitor-buildOutputDataFromPO end");
  }
}
