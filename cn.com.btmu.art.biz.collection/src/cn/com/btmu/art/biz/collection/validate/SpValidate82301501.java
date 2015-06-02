package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82301501业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82301501 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：新建.汇票金额.币种】为外币(≠CNY)时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext context) {

		logger.debug("SpValidate82301501-canExecute start");
		// 使用托收基本信息获取操作数据
		BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
				.getBcInfo();
		// 当【画：新建.汇票金额.币种】为外币(≠CNY)时.
		if (!CollectionConstant.CCY_CNY.equals(bcInfo.getBxCcy())) {

			logger.debug("汇票金额币种不为CNY");
			logger.debug("SpValidate82301501-canExecute returnValue true");
			logger.debug("SpValidate82301501-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("汇票金额币种为CNY");
		logger.debug("SpValidate82301501-canExecute returnValue false");
		logger.debug("SpValidate82301501-canExecute end");
		// 当【画：新建.汇票金额.币种】不为外币(≠CNY)时，返回false
		return false;
	}

	/**
	 * 【画：入账.入账账户#1.币种】不得输入CNY，否则报错
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

		logger.debug("SpValidate82301501-doCheckLogic start");

		// 使用托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 【画：入账.入账账户#1.币种】输入CNY
		if (CollectionConstant.CCY_CNY.equals(bcBookOpDtl.getBookAcctCcy1())) {

			logger.debug("入账账户#1.币种为CNY");
			// 获取国际化标签工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableBookAcctCcy1 = i18nUtil.getI18nMessage(context
					.getSystemPara().getLocale(),
					CollectionConstant.LABEL_823_00057);

			// 若汇票币种为外币时，返回错误信息ID ART00094_E，{0}的币种不可为人民币.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00094_E, lableBookAcctCcy1));

		}

		logger.debug("SpValidate82301501-doCheckLogic end");
	}
}
