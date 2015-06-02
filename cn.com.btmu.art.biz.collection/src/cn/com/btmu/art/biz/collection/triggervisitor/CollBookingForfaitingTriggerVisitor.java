package cn.com.btmu.art.biz.collection.triggervisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.AbstractForfaitingTriggerVisitor;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.ForfaitingTriggerData;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;

/**
 * CollBookingForfaitingTriggerVisitor
 * 
 * 托收（入账节点用）自动发起福费廷新建业务操作Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class CollBookingForfaitingTriggerVisitor extends
    AbstractForfaitingTriggerVisitor<CollectionCollBookingDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  private static CollBookingForfaitingTriggerVisitor instance = new CollBookingForfaitingTriggerVisitor();

  /**
   * 构造函数.
   */
  private CollBookingForfaitingTriggerVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance CollBookingForfaitingTriggerVisitor 实例
   */
  public static CollBookingForfaitingTriggerVisitor getInstance() {
    return instance;
  }

  /**
   * 自动发起福费廷新建业务操作
   * 
   * @param context 上下文信息
   * @return forfaitingTriggerData
   */
  public ForfaitingTriggerData buildMediaData(CollectionCollBookingDetailContext context) {
    logger.debug("CollBookingForfaitingTriggerVisitor-buildMediaData start");

	ForfaitingTriggerData forfaitingTriggerData = new ForfaitingTriggerData();
    BcInfo bcInfo = new BcInfoImpl();
    //【ARTContext：基本信息.交易参号.T-kind】赋值为【DM：托收基本信息.交易参号.T-kind】
    bcInfo.setTKind(context.getDataRepository().getBizDataCollection()
        .getBcInfo().getTKind());
    //【ARTContext：基本信息.交易参号.主参号】赋值为【DM：托收基本信息.交易参号.主参号】
    bcInfo.setTxnPrmryRefNo(context.getDataRepository().getBizDataCollection()
        .getBcInfo().getTxnPrmryRefNo());
    //【ARTContext：基本信息.交易参号.子参号】赋值为【DM：托收基本信息.交易参号.子参号】
    bcInfo.setTxnSubRefNo(context.getDataRepository().getBizDataCollection()
        .getBcInfo().getTxnSubRefNo());
    forfaitingTriggerData.setBcInfo(bcInfo);
    // 托收承兑操作明细;承兑到期日
    BcAccptceOpDtl bcAccptceOpDtl = context.getDataRepository().getBizDataCollection().getBcAccptceOpDtl();
    if (null != bcAccptceOpDtl) {
    	forfaitingTriggerData.setForwdEndDate(
    			bcAccptceOpDtl.getAccptceDueDate());
    }

    logger.debug("CollBookingForfaitingTriggerVisitor-buildMediaData end");
    return forfaitingTriggerData;
  }

}
