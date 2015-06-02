package cn.com.btmu.art.biz.collection.databuilder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollModfDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcInfoVOBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.CreateBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DishnrHistInfoVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ExpLcMntnOpDtlVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.FaultHistInfoVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.CollHistInfo;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.FaultHistInfo;

/**
 * CollectionCollCreateForCollModfForCompareDataBuilder
 * 
 * 托收新建节点数据（修正操作时）转换用CompareDataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollCreateForCollModfForCompareDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollModfDetailContext, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcMntnOpDtlVO vo,
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
        .debug("CollectionCollCreateForCollModfForCompareDataBuilder-registBuildOutFromBizVisitor start");
    //将context中【托收基本信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getBcInfo(), BcInfoVOBuildOutVisitor.getInstance());

    //将context中【WSID信息For新建】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForCreate(), CreateBizBuildOutFromSPgSmileVisitor
        .getInstance());

    //将context中【出口信用信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getExpLcInfo(), ExpLcMntnOpDtlVOBizBuildOutVisitor.getInstance());

    //将context中【催收拒付故障】的值赋值到vo中
    List<CollHistInfo> listCollHistInfo = context.getDataRepository()
        .getBizDataCollection().getOpfData().getOverdue();
    
    if (null != listCollHistInfo && listCollHistInfo.size() > 0) {
      putBuildOutBizVisitor(listCollHistInfo.get(0),
          DishnrHistInfoVOBizBuildOutVisitor.getInstance());
    }

    //将context中【故障履历信息】的值赋值到vo中
    List<FaultHistInfo> listFaultHistInfo = context.getDataRepository()
        .getBizDataCollection().getOpfData().getFault();
    
    if (null != listFaultHistInfo && listFaultHistInfo.size() > 0) {
      putBuildOutBizVisitor(listFaultHistInfo.get(0),
          FaultHistInfoVOBizBuildOutVisitor.getInstance());
    }
    logger
        .debug("CollectionCollCreateForCollModfForCompareDataBuilder-registBuildOutFromBizVisitor end");
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
