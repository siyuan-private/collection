package cn.com.btmu.art.biz.collection.databuilder;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbModChgbkDocInfoVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.BbModChgbkDocInfoVOOperBuildOutVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ModBizBuildOutFromSPgSmileVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ModHisDtlVOBuildInVisitor;
import cn.com.btmu.art.biz.collection.databuilder.visitor.ModHisDtlVOBuildOutVisitor;
import cn.com.btmu.art.biz.collection.vo.BbModChgbkDocInfoVO;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComComplexDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.bbdataset.impl.BbModChgbkDocInfoImpl;
import cn.com.btmu.art.framework.bo.domain.brdataset.ModHisDtl;

/**
 * CollectionCollChgbkForCollModDocDataBuilder
 * 
 * 托收退单节点数据（改单操作时）转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollChgbkForCollModDocDataBuilder
    extends
    AbstractComComplexDetailDataBuilder<CollectionCollModDocDetailContext, BbModChgbkDocInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 画面数据VO
   * @param context 上下文信息
   */
  protected void registBuildInVisitor(BbModChgbkDocInfoVO vo,
      CollectionCollModDocDetailContext context) {
    logger
        .debug("CollectionCollChgbkForCollModDocDataBuilder-registBuildInVisitor start");

    // 画面VO不为空 && 【退改单信息】为空时，创建【退改单信息】对象
    if (vo != null
        && context.getDataRepository().getOperationDataCollection()
            .getBbModChgbkDocInfo() == null) {
      logger.debug("【退改单信息】为空，创建对象");
      context.getDataRepository().getOperationDataCollection()
          .setBbModChgbkDocInfo(new BbModChgbkDocInfoImpl());
    }
    // 将VO【退改单信息】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getBbModChgbkDocInfo(), BbModChgbkDocInfoVOBuildInVisitor
        .getInstance());

    // 画面【修改履历】VO不为空 && 【修改履历】为空时，创建【修改履历】对象
    if (vo.getModHisDtlVOList() != null
        && context.getDataRepository().getOperationDataCollection()
            .getModHisDtlList() == null) {
      logger.debug("【修改履历】为空，构建对象");
      context.getDataRepository().getOperationDataCollection()
          .setModHisDtlList(new ArrayList<ModHisDtl>());
    }
    // 将VO【修改履历】的数据赋值到Context中
    putBuildInVisitor(context.getDataRepository().getOperationDataCollection()
        .getModHisDtlList(), ModHisDtlVOBuildInVisitor.getInstance());
    logger
        .debug("CollectionCollChgbkForCollModDocDataBuilder-registBuildInVisitor end");
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
        .debug("CollectionCollChgbkForCollModDocDataBuilder-registBuildOutFromBizVisitor start");
    // 将context中【WSID信息For退改单】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository().getBizDataCollection()
        .getSPgSmileInvokeInfoForMod(), ModBizBuildOutFromSPgSmileVisitor
        .getInstance());
    logger
        .debug("CollectionCollChgbkForCollModDocDataBuilder-registBuildOutFromBizVisitor end");
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
        .debug("CollectionCollChgbkForCollModDocDataBuilder-registBuildOutFromOprVisitor start");
    //将context中【退改单信息】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getBbModChgbkDocInfo(),
        BbModChgbkDocInfoVOOperBuildOutVisitor.getInstance());
    
    //将context中【修改履历】的值赋值到vo中
    putBuildOutOperVisitor(context.getDataRepository()
        .getOperationDataCollection().getModHisDtlList(),
        ModHisDtlVOBuildOutVisitor.getInstance());
    logger
        .debug("CollectionCollChgbkForCollModDocDataBuilder-registBuildOutFromOprVisitor end");
  }

}
