package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcBookOpDtlVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcBookOpDtlVOOperBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcBookOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcBookOpDtlImpl;

/**
 * CollectionCollBookingForCollBookingDataBuilder
 * 
 * 托收入账节点数据（入账操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollBookingForCollBookingDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollBookingDetailContext, BcBookOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcBookOpDtlVO vo,
      CollectionCollBookingDetailContext context) {
    logger
        .debug("CollectionCollBookingForCollBookingDataBuilder-registBuildInVisitor start");

    // 画面数据VO && 【入账操作明细】为空时，创建【入账操作明细】对象
    if (vo != null
        && context.getDataRepository().getOperationDataCollection()
            .getBcBookOpDtl() == null) {
      logger.debug("【入账操作明细】为空，创建对象");
      context.getDataRepository().getOperationDataCollection().setBcBookOpDtl(
          new BcBookOpDtlImpl());
    }
    // 将VO【入账操作明细】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getBcBookOpDtl(), BcBookOpDtlVOBuildInVisitor.getInstance());
    logger
        .debug("CollectionCollBookingForCollBookingDataBuilder-registBuildInVisitor end");
  }

  /**
   * 将业务BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromBizVisitor(
      CollectionCollBookingDetailContext context) {

  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollBookingDetailContext context) {
    logger
        .debug("CollectionCollBookingForCollBookingDataBuilder-registBuildOutFromOperVisitor start");
    // 从context取得国际化locale，保存到临时用数据中
    context.getDataRepository().getTempDataObject().set(
        CollectionConstant.VISITOR_LOCALE, context.getSystemPara().getLocale());
    
    //将context中【入账操作明细】的值赋值到vo中
    BcBookOpDtl bcBookOpDtl = context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl();
    putBuildOutOperVisitor(bcBookOpDtl, BcBookOpDtlVOOperBuildOutVisitor
        .getInstance());
    logger
        .debug("CollectionCollBookingForCollBookingDataBuilder-registBuildOutFromOperVisitor end");
  }

}
