package cn.com.btmu.art.biz.collection.databuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbCombLcMntnOpDtlVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbCombLcMntnOpDtlVOOperBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcMntnOpDtlVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BcMntnOpDtlVOBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.CreateBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DishnrHistInfoVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DispchDocInfoVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.DispchDocInfoVOBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ExpLcMntnOpDtlVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ExpLcMntnOpDtlVOOperBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.FaultHistInfoVOBizBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcMntnOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.CollHistInfo;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.FaultHistInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.ExpLcMntnOpDtlImpl;

/**
 * CollectionCollCreateForCollModDocDataBuilder
 * 
 * 托收新建节点数据（改单操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollCreateForCollModDocDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollModDocDetailContext, BcMntnOpDtlVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BcMntnOpDtlVO vo,
      CollectionCollModDocDetailContext context) {
    logger
        .debug("CollectionCollCreateForCollModDocDataBuilder-registBuildInVisitor start");

    // 画面【寄单信息】VO不为空 && 【托收维护操作明细】为空时，创建【托收维护操作明细】对象
    if (vo != null
        && context.getDataRepository().getOperationDataCollection()
            .getBcMntnOpDtl() == null) {
      logger.debug("【托收维护操作明细】为空，构建对象");
      context.getDataRepository().getOperationDataCollection().setBcMntnOpDtl(
          new BcMntnOpDtlImpl());
    }
    // 将VO【托收维护操作明细】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getBcMntnOpDtl(), BcMntnOpDtlVOBuildInVisitor.getInstance());

    // 画面【出口信用证维护操作明细】VO不为空 && 【出口信用证维护操作明细】为空时，创建【出口信用证维护操作明细】对象
    if (vo.getExpLcMntnOpDtlVO() != null
        && context.getDataRepository().getOperationDataCollection()
            .getExpLcMntnOpDtl() == null) {
      logger.debug("【出口信用证维护操作明细】为空，构建对象");
      context.getDataRepository().getOperationDataCollection()
          .setExpLcMntnOpDtl(new ExpLcMntnOpDtlImpl());
    }
    // 将VO【出口信用证维护操作明细】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getExpLcMntnOpDtl(), ExpLcMntnOpDtlVOBuildInVisitor.getInstance());

    // 画面【Combined LC维护操作明细】VO不为空 && 【Combined LC维护操作明细】为空时，创建【Combined LC维护操作明细】对象
    if (vo.getBbCombLcMntnOpDtlVoList() != null
        && context.getDataRepository().getOperationDataCollection()
            .getBbCombLcMntnOpDtlList() == null) {
      logger.debug("【Combined LC维护操作明细】为空，构建对象");
      context.getDataRepository().getOperationDataCollection()
          .setBbCombLcMntnOpDtlList(new ArrayList<BbCombLcMntnOpDtl>());
    }
    // 将VO新增【Combined LC维护操作明细】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getBbCombLcMntnOpDtlList(), BbCombLcMntnOpDtlVOBuildInVisitor
        .getInstance());

    // 创建【寄单信息】对象
    context.getDataRepository().getOperationDataCollection()
        .setDispchDocInfoForSaveList(new ArrayList<DispchDocInfo>());
    // 将VO新增【寄单信息】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getDispchDocInfoForSaveList(), DispchDocInfoVOBuildInVisitor
        .getInstance());
    logger
        .debug("CollectionCollCreateForCollModDocDataBuilder-registBuildInVisitor end");
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
        .debug("CollectionCollCreateForCollModDocDataBuilder-registBuildOutFromBizVisitor start");
    //将context中【WSID信息For新建】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForCreate(), CreateBizBuildOutFromSPgSmileVisitor
        .getInstance());

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

    // 从context取得操作流水号、版本号，保存到临时用数据中
    context.getDataRepository().getTempDataObject().set(
        CollectionConstant.VISITOR_OPERSN, context.getOperSN());
    context.getDataRepository().getTempDataObject().set(
        CollectionConstant.VISITOR_OPERVER, context.getOperVer());

    //将context中【寄单信息】的值赋值到vo中
    putBuildOutBizVisitor(context.getDataRepository().getBizDataCollection()
        .getDispchDocInfoList(), DispchDocInfoVOBuildOutVisitor.getInstance());
    logger
        .debug("CollectionCollCreateForCollModDocDataBuilder-registBuildOutFromBizVisitor end");
  }

  /**
   * 将操作BO转换成VO
   * 
   * @return void
   * @param context 上下文信息
   */
  protected void registBuildOutFromOperVisitor(
      CollectionCollModDocDetailContext context) {
    logger
        .debug("CollectionCollCreateForCollModDocDataBuilder-registBuildOutFromOperVisitor start");
    // 将context中【托收维护操作明细】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getBcMntnOpDtl(),
        BcMntnOpDtlVOBuildOutVisitor.getInstance());

    // 将context中【出口信用证信息】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getExpLcMntnOpDtl(),
        ExpLcMntnOpDtlVOOperBuildOutVisitor.getInstance());

    //将context中【Combined LC基本信息】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getBbCombLcMntnOpDtlList(),
        BbCombLcMntnOpDtlVOOperBuildOutVisitor.getInstance());
    logger
        .debug("CollectionCollCreateForCollModDocDataBuilder-registBuildOutFromOperVisitor end");
  }

}
