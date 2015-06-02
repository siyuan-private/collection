package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.biz.collection.datacollection.CollectionCollCreateDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComTriggerDetailContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcInfoImpl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcMntnOpDtlImpl;

/**
 * CollectionCollCreateDetailContext
 * 
 * 托收新建节点用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollCreateDetailContext extends
		AbstractComTriggerDetailContext<BcInfoImpl, BcMntnOpDtlImpl> {
	/** 托收业务用DataRepository */
	private CollectionDataRepository<CollectionCollCreateDataCollection> dataRepository = new CollectionDataRepository<CollectionCollCreateDataCollection>(
			this, new CollectionCollCreateDataCollection());

	/**
     * 获取DataRepository
	 * @return dataRepository
	 */
	public CollectionDataRepository<CollectionCollCreateDataCollection> getDataRepository() {
		return dataRepository;
	}
}
