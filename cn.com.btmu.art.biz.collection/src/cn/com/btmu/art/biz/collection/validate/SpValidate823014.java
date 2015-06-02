package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * SpValidate823014业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823014 extends
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
	protected boolean canExecute(CollectionCollBookingDetailContext context) {

		logger.debug("SpValidate823014-canExecute start");

		// 使用托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 当【画：入账.福费廷】勾选时.
		if (DataTypeConstant.DATA_TYPE_YES.equals(bcBookOpDtl.getForftingFlg())) {

			logger.debug("入账.福费廷勾选");
			logger.debug("SpValidate823014-canExecute returnValue true");
			logger.debug("SpValidate823014-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("入账.福费廷不勾选");
		logger.debug("SpValidate823014-canExecute returnValue false");
		logger.debug("SpValidate823014-canExecute end");
		// 当【画：入账.福费廷】未勾选时，返回false
		return false;
	}

	/**
	 * 【画：单据信息.有追索权】必须为‘N’，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(CollectionCollBookingDetailContext context,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823014-doCheckLogic start");

		// 使用托收基本信息取得数据
		BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
				.getBcInfo();
		// 【画：单据信息.有追索权】不为‘N’
		if (!DataTypeConstant.DATA_TYPE_NO.equals(bcInfo.getWithRcsFlg())) {

			logger.debug("有追索权不为“N”");

			// 有追索权为“N”时，才可以勾选福费廷.返回错误消息ID ART82300_E
			errorContainer
					.error(createErrMessage(CollectionConstant.MSG_ID_ART82300_E));

		}

		logger.debug("SpValidate823014-doCheckLogic end");
	}
}
