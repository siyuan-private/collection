package cn.com.btmu.art.biz.collection.datacollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.common01biz.base.context.AbstractComDetailContext;
import cn.com.btmu.art.biz.common01biz.repo.AbstractDataRepository;
import cn.com.btmu.art.biz.common01biz.repo.IOperationDataCollection;

/**
 * CollectionDataRepository
 * 
 * 托收业务用DataRepository
 * 
 * @author ivision
 * @version 1.0.0
 * 
 */
public class CollectionDataRepository<V extends IOperationDataCollection>
    extends AbstractDataRepository<CollectionBizDataCollection, V> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 构造函数
   * 
   * @param context 上下文信息
   * @param operationDataCollection 操作信息数据集合
   */
  public CollectionDataRepository(AbstractComDetailContext context,
      V operationDataCollection) {
    super(context, operationDataCollection);
  }

  /**
   * 加载业务信息数据. 如果当前业务需要加载多张业务表信息，主表以外的信息在此加载
   * 
   * @return void
   */
  public void loadBizDataWithRelation() {
    logger.debug("CollectionDataRepository-loadBizDataWithRelation start");
    // 加载承兑操作明细
    bizDataCollection.loadBcAccptceOpDtl();
    // 加载故障履历信息
    bizDataCollection.loadOPFInfo();
    // 加载寄单信息
    bizDataCollection.loadDispchDocInfo();
    // 加载WSID信息
    bizDataCollection.loadWSIDInfo();

    logger.debug("CollectionDataRepository-loadBizDataWithRelation end");
  }
}
