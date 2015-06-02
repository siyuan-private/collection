package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.biz.collection.datacollection.CollectionCollBookingDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.collection.pricing.CollBookingPricingInfoEditor;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComTriggerDetailContext;
import cn.com.btmu.art.biz.common01biz.util.InternalPositionWrapUtil.TransactionPricingInfoEditor;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcBookOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;

/**
 * CollectionCollBookingDetailContext
 * 
 * 托收入账节点用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollBookingDetailContext extends
		AbstractComTriggerDetailContext<BcInfoImpl, BcBookOpDtlImpl> {
	/** 托收业务用DataRepository */
	private CollectionDataRepository<CollectionCollBookingDataCollection> dataRepository = new CollectionDataRepository<CollectionCollBookingDataCollection>(
			this, new CollectionCollBookingDataCollection());

	/**
     * 获取DataRepository
	 * @return dataRepository
	 */
	public CollectionDataRepository<CollectionCollBookingDataCollection> getDataRepository() {
		return dataRepository;
	}

    /**
     * 获取当前业务操作对应的定价信息编辑器实例
     * @return 定价信息编辑器实例
     */
	public TransactionPricingInfoEditor<CollectionCollBookingDetailContext> getPricingEditor() {
		return CollBookingPricingInfoEditor.getInstance();
	}

}
