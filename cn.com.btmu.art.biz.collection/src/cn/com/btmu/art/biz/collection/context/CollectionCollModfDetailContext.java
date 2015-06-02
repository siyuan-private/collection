package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.biz.collection.datacollection.CollectionCollModfDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComTriggerDetailContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcMntnOpDtlImpl;

/**
 * CollectionModBillDetailContext
 * 
 * 托收业务修正节点用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollModfDetailContext extends
		AbstractComTriggerDetailContext<BcInfoImpl, BcMntnOpDtlImpl> {

	/** 托收业务用DataRepository */
	private CollectionDataRepository<CollectionCollModfDataCollection> dataRepository = new CollectionDataRepository<CollectionCollModfDataCollection>(
			this, new CollectionCollModfDataCollection());

	/**
     * 获取DataRepository
	 * @return dataRepository
	 */
	public CollectionDataRepository<CollectionCollModfDataCollection> getDataRepository() {
		return dataRepository;
	}
}