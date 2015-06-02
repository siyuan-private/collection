package cn.com.btmu.art.biz.collection.triggervisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollCreateDetailContext;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.AbstractKinLcredleTriggerVisitor;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.KinLcredleTriggerData;

/**
 * CollCreateKinLcredleTriggerVisitor
 * 
 * 托收（新建节点用）自动发起留行信用证的‘新建’操作Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class CollCommonKinLcredleTriggerVisitor extends
AbstractKinLcredleTriggerVisitor<CollectionCollCreateDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  private static CollCommonKinLcredleTriggerVisitor instance = new CollCommonKinLcredleTriggerVisitor();

  /**
   * 构造函数.
   */
  private CollCommonKinLcredleTriggerVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance CollCreateKinLcredleTriggerVisitor 实例
   */
  public static CollCommonKinLcredleTriggerVisitor getInstance() {
    return instance;
  }

  /**
   * 自动发起留行信用证的‘新建’操作
   * 
   * @param context 上下文信息
   * @return 留行信用证触发数据 
   */
  public KinLcredleTriggerData buildMediaData(
      CollectionCollCreateDetailContext context) {
    logger.debug("CollCreateKinLcredleTriggerVisitor-buildMediaData start");

    KinLcredleTriggerData kinLcredleTriggerData = new KinLcredleTriggerData();
    //【ARTContext：信用证信息.信用证编号】赋值为【DM：托收基本信息.信用证编号】
    kinLcredleTriggerData.setLcNo(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getLcNo());
    //【ARTContext：信用证信息.备注】赋值为空
    kinLcredleTriggerData.setRemark(null);

    logger.debug("CollCreateKinLcredleTriggerVisitor-buildMediaData end");
    return kinLcredleTriggerData;
  }

}
