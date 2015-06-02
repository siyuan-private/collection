package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.biz.collection.datacollection.CollectionCollModDocDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComTriggerDetailContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcMntnOpDtlImpl;

/**
 * CollectionCollModDocDetailContext
 * 
 * 托收改单节点用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollModDocDetailContext extends
		AbstractComTriggerDetailContext<BcInfoImpl, BcMntnOpDtlImpl> {

	/** 托收业务用DataRepository */
	private CollectionDataRepository<CollectionCollModDocDataCollection> dataRepository = new CollectionDataRepository<CollectionCollModDocDataCollection>(
			this, new CollectionCollModDocDataCollection());

	/**
     * 获取DataRepository
	 * @return dataRepository
	 */
	public CollectionDataRepository<CollectionCollModDocDataCollection> getDataRepository() {
		return dataRepository;
	}
}
