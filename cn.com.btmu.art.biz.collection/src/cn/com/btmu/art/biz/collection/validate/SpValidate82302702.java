package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82302702业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82302702 extends
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
	protected boolean canExecute(CollectionCollBookingDetailContext data) {

		logger.debug("SpValidate82302702-canExecute start");

		// 取得托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = data.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 当【画：入账.入两个账户】勾选时.
		if (DataTypeConstant.DATA_TYPE_YES.equals(bcBookOpDtl
				.getEnter2AcctFlg())) {

			logger.debug("SpValidate82302702-canExecute 【画：入账.入两个账户】勾选");
			logger.debug("SpValidate82302702-canExecute returnValue true");
			logger.debug("SpValidate82302702-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("SpValidate82302702-canExecute 【画：入账.入两个账户】不勾选");
		logger.debug("SpValidate82302702-canExecute returnValue false");
		logger.debug("SpValidate82302702-canExecute end");
		// 当【画：入账.入两个账户】不勾选时.返回false
		return false;
	}

	/**
	 * 【画：入账.金额#2.金额】不得为空，否则报错
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

		logger.debug("SpValidate82302702-doCheckLogic start");

		// 取得托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = data.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 【画：入账.金额#2.金额】为空
		if (bcBookOpDtl.getAmt2() == null) {
			// 获取国际化标签换换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableAmt2 = i18nUtil.getI18nMessage(data.getSystemPara()
					.getLocale(), CollectionConstant.LABEL_823_00060);
			logger.debug("【画：入账.金额#2.金额】为空");
			// 返回错误信息ID ART00131_E, {0}不能为空.
			errorContainer.error(createErrMessage(
					CollectionConstant.MSG_ID_ART00131_E, lableAmt2));

		}

		logger.debug("SpValidate82302702-doCheckLogic end");
	}
}
