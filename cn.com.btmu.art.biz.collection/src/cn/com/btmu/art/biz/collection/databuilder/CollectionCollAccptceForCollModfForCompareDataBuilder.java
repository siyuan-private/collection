package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollModfDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.AccptceBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcAccptceOpDtlVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcAccptceOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;

/**
 * CollectionCollAccptceForCollModfForCompareDataBuilder
 * 
 * 托收承兑节点数据（修正操作时）转换用ForCompareDataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollAccptceForCollModfForCompareDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollModfDetailContext, BcAccptceOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcAccptceOpDtlVO vo,
      CollectionCollModfDetailContext context) {

  }

  /**
   * 将业务BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromBizVisitor(
      CollectionCollModfDetailContext context) {
    logger
        .debug("CollectionCollAccptceForCollModfForCompareDataBuilder-registBuildOutFromBizVisitor start");
    // 将VO【承兑维护操作明细For业务】的数据赋值到Context中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getBcAccptceOpDtl(), BcAccptceOpDtlVOBizBuildOutVisitor.getInstance());
    
    // 将【WSID信息For承兑】VO的数据赋值到Context中 		
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForAccptce(),
        AccptceBizBuildOutFromSPgSmileVisitor.getInstance());
    logger
        .debug("CollectionCollAccptceForCollModfForCompareDataBuilder-registBuildOutFromBizVisitor end");
  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollModfDetailContext context) {

  }

}
