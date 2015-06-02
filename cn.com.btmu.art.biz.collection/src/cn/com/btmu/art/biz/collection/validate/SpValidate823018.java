package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate823018业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823018 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 有无需要进行校验.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext context) {
		// 直接返回true，必须进行校验
		return true;
	}

	/**
	 * 当【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致时,显示报错信息，提示需要定价
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

		logger.debug("SpValidate823018-doCheckLogic start");

		// 取得托收基本信息获取操作数据
		BcInfo bcInfo = context.getDataRepository().getBizDataCollection()
				.getBcInfo();

		// 取得托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 当【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致时
		if (!ArtStringUtil.equals(bcBookOpDtl.getBookAcctCcy1(), bcInfo
				.getBxCcy())) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableBookAcctCcy1 = i18nUtil.getI18nMessage(context
					.getSystemPara().getLocale(),
					CollectionConstant.LABEL_823_00057);
			// 转换国际化标签
			String lableBxCcy = i18nUtil.getI18nMessage(context.getSystemPara()
					.getLocale(), CollectionConstant.LABEL_823_00005);

			logger.debug("【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致");

			// 返回错误消息ID ART00131_E, {0}与{1}不一致，请进行定价操作.
			errorContainer.error(createErrMessage(
					CollectionConstant.MSG_ID_ART00131_E, lableBookAcctCcy1,
					lableBxCcy));

		}

		logger.debug("SpValidate823018-doCheckLogic end");
	}
}
