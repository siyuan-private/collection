package cn.com.btmu.art.biz.collection.databuilder.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.vo.BcBookOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder.IDataBuildOutFromPOVisitor;
import cn.com.btmu.art.component.dict.DataDictionaryUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/**
 * BcBookOpDtlVOOperBuildOutVisitor
 * 
 * BcBookOpDtlVO用OperBuildOut Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BcBookOpDtlVOOperBuildOutVisitor implements
    IDataBuildOutFromPOVisitor<BcBookOpDtl, BcBookOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /** 创建实例. */
  private static BcBookOpDtlVOOperBuildOutVisitor instance = new BcBookOpDtlVOOperBuildOutVisitor();

  /**
   * 构造函数.
   */
  private BcBookOpDtlVOOperBuildOutVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance BcBookOpDtlVOOperBuildOutVisitor实例
   */
  public static BcBookOpDtlVOOperBuildOutVisitor getInstance() {
    return instance;
  }

  /**
   * 将BO转换成VO.
   * 
   * @return void
   * @param from  【托收入账操作明细】
   * @param hiddenArea 临时用数据
   * @param to  BcAccptceOpDtlVO
   *            
   */
  public void buildOutputDataFromPO(BcBookOpDtl from, DataObject hiddenArea,
      BcBookOpDtlVO to) {
    logger
        .debug("BcBookOpDtlVOOperBuildOutVisitor-buildOutputDataFromPO start");

    if (from != null) {
      logger.debug("【托收入账操作明细】不为空");
      ArtBeanUtils.copyProperties(from, to);

      // 名称不同的属性，不能通过CopyProPerties实现，单独赋值
      // 账户性质#1.二级分类code
      to.setAcctPropty2ndCd1(from.getAcctPropty2nd1());
      // 账户性质#1.三级分类code
      to.setAcctPropty3rdCd1(from.getAcctPropty3rd1());
      // 账户性质#2.二级分类code
      to.setAcctPropty2ndCd2(from.getAcctPropty2nd2());
      // 账户性质#2.三级分类code
      to.setAcctPropty3rdCd2(from.getAcctPropty3rd2());

      // 国际化locale
      String locale = hiddenArea.getString(CollectionConstant.VISITOR_LOCALE);

      // 数据字典字段显示值转换
      DataDictionaryUtil dataDictUtil = (DataDictionaryUtil) FactoryBeanUtil
          .getBean(BizBeanNameConst.E90340_UTIL_DATADICTIONARY);
      // 账户性质#1.二级分类
      to.setAcctPropty2nd1(dataDictUtil.getValue(from.getAcctPropty2nd1(),
          CollectionConstant.DICT_ACCTPROPTY2ND, locale));
      // 账户性质#1.三级分类
      to.setAcctPropty3rd1(dataDictUtil.getValue(from.getAcctPropty3rd1(),
          CollectionConstant.DICT_ACCTPROPTY3RD, locale));
      // 账户性质#2.二级分类
      to.setAcctPropty2nd2(dataDictUtil.getValue(from.getAcctPropty2nd2(),
          CollectionConstant.DICT_ACCTPROPTY2ND, locale));
      // 账户性质#2.三级分类
      to.setAcctPropty3rd2(dataDictUtil.getValue(from.getAcctPropty3rd2(),
          CollectionConstant.DICT_ACCTPROPTY3RD, locale));
    }
    logger.debug("BcBookOpDtlVOOperBuildOutVisitor-buildOutputDataFromPO end");
  }
}
