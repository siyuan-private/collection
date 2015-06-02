package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollAccptceDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcAccptceOpDtlVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcAccptceOpDtlVOOperBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcAccptceOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcAccptceOpDtlImpl;

/**
 * CollectionCollAccptceForCollAccptceDataBuilder
 * 
 * 托收承兑节点数据（承兑操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollAccptceForCollAccptceDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollAccptceDetailContext, BcAccptceOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcAccptceOpDtlVO vo,
      CollectionCollAccptceDetailContext context) {
    logger
        .debug("CollectionCollAccptceForCollAccptceDataBuilder-registBuildInVisitor start");

    //画面VO不为空 && 【承兑操作明细】为空时，创建【承兑操作明细】对象
    if (vo != null
        && context.getDataRepository().getOperationDataCollection()
            .getBcAccptceOpDtl() == null) {
      logger.debug("【承兑操作明细】为空，创建对象");
      context.getDataRepository().getOperationDataCollection()
          .setBcAccptceOpDtl(new BcAccptceOpDtlImpl());
    }
    //将VO【托收承兑操作信息】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getBcAccptceOpDtl(), BcAccptceOpDtlVOBuildInVisitor.getInstance());
    logger
        .debug("CollectionCollAccptceForCollAccptceDataBuilder-registBuildInVisitor end");
  }

  /**
   * 将业务BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromBizVisitor(
      CollectionCollAccptceDetailContext context) {

  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollAccptceDetailContext context) {
    logger
        .debug("CollectionCollAccptceForCollAccptceDataBuilder-registBuildInVisitor start");
    // 将context中【托收承兑操作信息】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getBcAccptceOpDtl(),
        BcAccptceOpDtlVOOperBuildOutVisitor.getInstance());
    logger
        .debug("CollectionCollAccptceForCollAccptceDataBuilder-registBuildInVisitor end");
  }

}
