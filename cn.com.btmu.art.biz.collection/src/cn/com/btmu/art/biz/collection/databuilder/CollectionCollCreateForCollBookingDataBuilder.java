package cn.com.btmu.art.biz.collection.databuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbCombLcMntnOpDtlVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcInfoVOBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.CreateBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DishnrHistInfoVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DispchDocInfoVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DispchDocInfoVOBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ExpLcMntnOpDtlVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.FaultHistInfoVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.CollHistInfo;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.FaultHistInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;

/**
 * CollectionCollCreateForCollBookingDataBuilder
 * 
 * 托收新建节点数据（入账操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollCreateForCollBookingDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollBookingDetailContext, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcMntnOpDtlVO vo,
      CollectionCollBookingDetailContext context) {
    logger
        .debug("CollectionCollCreateForCollBookingDataBuilder-registBuildInVisitor start");

    //  创建【寄单信息】对象
    context.getDataRepository().getOperationDataCollection()
        .setDispchDocInfoForSaveList(new ArrayList<DispchDocInfo>());
    // 将VO新增【寄单信息】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getDispchDocInfoForSaveList(), DispchDocInfoVOBuildInVisitor
        .getInstance());
    logger
        .debug("CollectionCollCreateForCollBookingDataBuilder-registBuildInVisitor end");
  }

  /**
   * 将业务BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromBizVisitor(
      CollectionCollBookingDetailContext context) {
    logger
        .debug("CollectionCollCreateForCollBookingDataBuilder-registBuildOutFromBizVisitor start");
    //将context中【托收基本信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getBcInfo(), BcInfoVOBuildOutVisitor.getInstance());

    //将context中【WSID信息For新建】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForCreate(), CreateBizBuildOutFromSPgSmileVisitor
        .getInstance());

    //将context中【出口信用证信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getExpLcInfo(), ExpLcMntnOpDtlVOBizBuildOutVisitor.getInstance());

    //将context中【Combined LC基本信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getBbCombLcInfoList(), BbCombLcMntnOpDtlVOBizBuildOutVisitor
        .getInstance());

    //将context中【催收拒付故障】的值赋值到vo中
    List<CollHistInfo> listCollHistInfo = context.getDataRepository().getBizDataCollection().getOpfData().getOverdue();
    if (null != listCollHistInfo && listCollHistInfo.size() > 0) {
    	putBuildOutBizVisitor(listCollHistInfo.get(0), 
    			DishnrHistInfoVOBizBuildOutVisitor.getInstance());
    }

    //将context中【故障履历信息】的值赋值到vo中
    List<FaultHistInfo> listFaultHistInfo = context.getDataRepository().getBizDataCollection().getOpfData().getFault();
    if (null != listFaultHistInfo && listFaultHistInfo.size() > 0) {
	    putBuildOutBizVisitor(listFaultHistInfo.get(0), 
	    		FaultHistInfoVOBizBuildOutVisitor.getInstance());
    }

    // 从context取得操作流水号、版本号，保存到临时用数据中
    context.getDataRepository().getTempDataObject().set(
        CollectionConstant.VISITOR_OPERSN, context.getOperSN());
    context.getDataRepository().getTempDataObject().set(
        CollectionConstant.VISITOR_OPERVER, context.getOperVer());

    // 将context中【寄单信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getDispchDocInfoList(), DispchDocInfoVOBuildOutVisitor.getInstance());
    logger
        .debug("CollectionCollCreateForCollBookingDataBuilder-registBuildOutFromBizVisitor end");
  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollBookingDetailContext context) {

  }

}
