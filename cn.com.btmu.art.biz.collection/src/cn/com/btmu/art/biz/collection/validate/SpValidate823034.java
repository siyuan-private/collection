package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * SpValidate823034业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823034 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：入账.福费廷】勾选时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext data) {

		logger.debug("SpValidate823034-canExecute start");

		// 使用托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = data.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 【画：入账.福费廷】勾选时.
		if (DataTypeConstant.DATA_TYPE_YES.equals(bcBookOpDtl.getForftingFlg())) {

			logger.debug("SpValidate823034-canExecute 【画：入账.福费廷】勾选");
			logger.debug("SpValidate823034-canExecute returnValue true");
			logger.debug("SpValidate823034-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("SpValidate823034-canExecute 【画：入账.福费廷】不勾选");
		logger.debug("SpValidate823034-canExecute returnValue false");
		logger.debug("SpValidate823034-canExecute end");
		// 【画：入账.福费廷】不勾选时.返回false
		return false;
	}

	/**
	 * 【画：承兑.Accepted Flag】必须为‘Y’，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(CollectionCollBookingDetailContext data,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823034-doCheckLogic start");
		// 获取承兑操作明细
		BcAccptceOpDtl accptceOpDtl = data.getDataRepository()
				.getBizDataCollection().getBcAccptceOpDtl();

		// 当【画：承兑.Accepted Flag】不为‘Y’
		if (!DataTypeConstant.DATA_TYPE_YES.equals(accptceOpDtl
				.getAcceptedFlg())) {
			logger.debug("【画：承兑.Accepted Flag】不为‘Y’");
			// 返回错误消息ID ART82311_E
			errorContainer
					.error(createErrMessage(CollectionConstant.MSG_ID_ART82311_E));

		}

		logger.debug("SpValidate823034-doCheckLogic end");
	}
}
