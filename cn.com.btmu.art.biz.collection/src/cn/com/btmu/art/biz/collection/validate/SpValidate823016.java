package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * SpValidate823016业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823016 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：入账.入两个账户】勾选时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext context) {

		logger.debug("SpValidate823016-canExecute start");

		// 使用托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 当【画：入账.入两个账户】勾选时.返回true
		if (DataTypeConstant.DATA_TYPE_YES.equals(bcBookOpDtl
				.getEnter2AcctFlg())) {

			logger.debug("SpValidate823016-canExecute 【画：入账.入两个账户】勾选");
			logger.debug("SpValidate823016-canExecute returnValue true");
			logger.debug("SpValidate823016-canExecute end");

			return true;
		}

		logger.debug("SpValidate823016-canExecute 【画：入账.入两个账户】不勾选");
		logger.debug("SpValidate823016-canExecute returnValue false");
		logger.debug("SpValidate823016-canExecute end");
		// 否则返回false
		return false;
	}

	/**
	 * 【画：入账.金额#1.金额】+【画：入账.金额#2.金额】必须等于【画：入账.头寸金额.金额】，否则报错
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

		logger.debug("SpValidate823016-doCheckLogic start");

		// 使用托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 【画：入账.金额#1.金额】+【画：入账.金额#2.金额】不等于【画：入账.头寸金额.金额】
		if (!(bcBookOpDtl.getAmt1().add(bcBookOpDtl.getAmt2()))
				.equals(bcBookOpDtl.getPosAmt())) {

			// 折算前金额的合计必须等于头寸金额.

			logger.debug("【画：入账.金额#1.金额】+【画：入账.金额#2.金额】不等于【画：入账.头寸金额.金额】");

			// 返回错误信息IDART82306_E
			errorContainer
					.error(createErrMessage(CollectionConstant.MSG_ID_ART82306_E));

		}

		logger.debug("SpValidate823016-doCheckLogic end");
	}
}
