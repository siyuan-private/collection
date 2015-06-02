package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate823017业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823017 extends AbstractBizCheckUnit<BcMntnOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String locale;

	public SpValidate823017(String locale) {

		logger.debug("SpValidate823017 构造方法-start");
		logger.debug("SpValidate823017 构造方法 StrLocale" + locale);
		// 设置locale值
		this.locale = locale;

		logger.debug("SpValidate823017 构造方法-end");
	}

	/**
	 * 当【画：新建.电报议付】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(BcMntnOpDtl bcMntnOpDtl) {

		logger.debug("SpValidate823017-canExecute start");
		// 当【画：新建.电报议付】为‘Y’时.
		if (DataTypeConstant.DATA_TYPE_YES
				.equals(bcMntnOpDtl.getTelegNegoFlg())) {

			logger.debug("SpValidate823017-canExecute 【画：新建.电报议付】为Y");
			logger.debug("SpValidate823017-canExecute returnValue true");
			logger.debug("SpValidate823017-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("SpValidate823017-canExecute 【画：新建.电报议付】不为Y");
		logger.debug("SpValidate823017-canExecute returnValue false");
		logger.debug("SpValidate823017-canExecute end");
		// 当【画：新建.电报议付】不为‘Y’时.返回false
		return false;

	}

	/**
	 * 【画：新建.电报议付销号日期】不得为空，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(BcMntnOpDtl bcMntnOpDtl,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823017-doCheckLogic start");
		// 【画：新建.电报议付销号日期】\为空
		if (bcMntnOpDtl.getTelegNegoClsDate() == null) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际换标签
			String lableTelegNegoClsDate = i18nUtil.getI18nMessage(locale,
					LabelComConstant.LABEL_COM_01201);

			logger.debug("【画：新建.电报议付销号日期】为空");

			// 返回错误消息ID ART00018_E, {0}不能为空.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00018_E,
					lableTelegNegoClsDate));

		}

		logger.debug("SpValidate823017-doCheckLogic end");
	}
}
