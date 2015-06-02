package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollChgbkDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbModChgbkDocInfoVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbModChgbkDocInfoVOOperBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ModBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbModChgbkDocInfoImpl;

/**
 * CollectionCollChgbkDocForCollChgbkDataBuilder
 * 
 * 托收退单节点数据（退单操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollChgbkForCollChgbkDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollChgbkDetailContext, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BbModChgbkDocInfoVO vo,
      CollectionCollChgbkDetailContext context) {
    logger
        .debug("CollectionCollChgbkForCollChgbkDataBuilder-registBuildInVisitor start");

    //画面VO为空 && 【退改单信息】为空时，创建【退改单信息】对象
    if (vo != null
        && context.getDataRepository().getOperationDataCollection()
            .getBbModChgbkDocInfo() == null) {
      logger.debug("【退改单信息】为空，创建对象");
      context.getDataRepository().getOperationDataCollection()
          .setBbModChgbkDocInfo(new BbModChgbkDocInfoImpl());
    }
    //将VO【退改单信息】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getBbModChgbkDocInfo(), BbModChgbkDocInfoVOBuildInVisitor
        .getInstance());
    logger
        .debug("CollectionCollChgbkForCollChgbkDataBuilder-registBuildInVisitor end");
  }

  /**
   * 将业务BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromBizVisitor(
      CollectionCollChgbkDetailContext context) {
    logger
        .debug("CollectionCollChgbkForCollChgbkDataBuilder-registBuildOutFromBizVisitor start");
    //将context中【WSID信息For退改单】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForMod(), ModBizBuildOutFromSPgSmileVisitor
        .getInstance());
    logger
        .debug("CollectionCollChgbkForCollChgbkDataBuilder-registBuildOutFromBizVisitor end");
  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollChgbkDetailContext context) {
    logger
        .debug("CollectionCollChgbkForCollChgbkDataBuilder-registBuildOutFromOperVisitor start");
    // 从context取得国际化locale
    context.getDataRepository().getTempDataObject().set(
        CollectionConstant.VISITOR_LOCALE, context.getSystemPara().getLocale());
    
    //将context中【退改单信息】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getBbModChgbkDocInfo(),
        BbModChgbkDocInfoVOOperBuildOutVisitor.getInstance());
    logger
        .debug("CollectionCollChgbkForCollChgbkDataBuilder-registBuildOutFromOperVisitor end");
  }

}
