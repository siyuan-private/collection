package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.AccptceBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcAccptceOpDtlVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcAccptceOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;

/**
 * CollectionCollAccptceForCollModDocDataBuilder
 * 
 * 托收承兑节点数据（改单操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollAccptceForCollModDocDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollModDocDetailContext, BcAccptceOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcAccptceOpDtlVO vo,
      CollectionCollModDocDetailContext context) {

  }

  /**
   * 将业务BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromBizVisitor(
      CollectionCollModDocDetailContext context) {
    logger
        .debug("CollectionCollAccptceForCollModDocDataBuilder-registBuildOutFromBizVisitor start");
    //将context中【托收承兑操作信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getBcAccptceOpDtl(), BcAccptceOpDtlVOBizBuildOutVisitor.getInstance());
    
    //将context中【WSID信息For承兑】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForAccptce(),
        AccptceBizBuildOutFromSPgSmileVisitor.getInstance());
    logger
        .debug("CollectionCollAccptceForCollModDocDataBuilder-registBuildOutFromBizVisitor end");
  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollModDocDetailContext context) {

  }

}
