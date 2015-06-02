package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.biz.collection.datacollection.CollectionCollChgbkDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComTriggerDetailContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcMntnOpDtlImpl;

/**
 * CollectionCollChgbkDetailContext
 * 
 * 托收业务退单节点用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollChgbkDetailContext extends
		AbstractComTriggerDetailContext<BcInfoImpl, BcMntnOpDtlImpl> {

	/** 托收业务用DataRepository */
	private CollectionDataRepository<CollectionCollChgbkDataCollection> dataRepository = new CollectionDataRepository<CollectionCollChgbkDataCollection>(
			this, new CollectionCollChgbkDataCollection());

	/**
     * 获取DataRepository
	 * @return dataRepository
	 */
	public CollectionDataRepository<CollectionCollChgbkDataCollection> getDataRepository() {
		return dataRepository;
	}
}
