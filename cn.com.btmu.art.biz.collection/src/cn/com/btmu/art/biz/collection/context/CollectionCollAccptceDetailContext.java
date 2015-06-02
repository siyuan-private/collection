package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.biz.collection.datacollection.CollectionCollAccptceDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComTriggerDetailContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcAccptceOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;

/**
 * CollectionCollAccptceDetailContext
 * 
 * 托收承兑节点用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollAccptceDetailContext extends
	AbstractComTriggerDetailContext<BcInfoImpl, BcAccptceOpDtlImpl> {
	/** 托收业务用DataRepository */
	private CollectionDataRepository<CollectionCollAccptceDataCollection> dataRepository = new CollectionDataRepository<CollectionCollAccptceDataCollection>(
			this, new CollectionCollAccptceDataCollection());

	/**
     * 获取DataRepository
	 * @return dataRepository
	 */
	public CollectionDataRepository<CollectionCollAccptceDataCollection> getDataRepository() {
		return dataRepository;
	}
}
