package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82303502业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82303502 extends AbstractBizCheckUnit<BcBookOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String data;

	private String locale;

	public SpValidate82303502(String data, String locale) {

		logger.debug("SpValidate82303502 构造方法-start");
		logger.debug("SpValidate82303502 构造方法 StrLocale" + locale);
		// 设置data值
		this.data = data;
		// 设置locale值
		this.locale = locale;

		logger.debug("SpValidate82303502 构造方法-end");
	}

	/**
	 * 当【画：入账.对手方银行国别.国家】为‘CHN’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(BcBookOpDtl bcBookOpDtl) {

		logger.debug("SpValidate82303502-canExecute start");
		// 【画：入账.对手方银行国别.国家】为‘CHN’"
		if (CollectionConstant.COUNTRY_CHN.equals(bcBookOpDtl
				.getCounterPartyCountry())) {

			logger
					.debug("SpValidate82303502-canExecute 【画：入账.对手方银行国别.国家】为‘CHN’");
			logger.debug("SpValidate82303502-canExecute returnValue true");
			logger.debug("SpValidate82303502-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("SpValidate82303502-canExecute 【画：入账.对手方银行国别.国家】不为‘CHN’");
		logger.debug("SpValidate82303502-canExecute returnValue false");
		logger.debug("SpValidate82303502-canExecute end");
		// 【画：入账.对手方银行国别.国家】不为‘CHN’,返回false
		return false;
	}

	/**
	 * 【画：入账.对手方银行国别.省】不得为空，否则报错
	 * 
	 * @return void
	 * @param bcBookOpDtl
	 *            托收入账操作明细
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(BcBookOpDtl bcBookOpDtl,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate82303502-doCheckLogic start");
		// 【画：入账.对手方银行国别.省】为空
		if (ArtStringUtil.isEmpty(data)) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际换标签
			String lableMsg = i18nUtil.getI18nMessage(locale,
					CollectionConstant.LABEL_823_00056);

			logger.debug("【画：入账.对手方银行国别.省】为空");
			// 返回错误信息ID ART00018_E ，{0}不能为空.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00018_E, lableMsg));
		}

		logger.debug("SpValidate82303502-doCheckLogic end");
	}
}
