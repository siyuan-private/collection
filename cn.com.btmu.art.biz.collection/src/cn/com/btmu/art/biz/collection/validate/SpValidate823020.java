package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate823020业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823020 extends AbstractBizCheckUnit<String> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String locale;

	private String label;

	public SpValidate823020(String locale, String label) {

		logger.debug("SpValidate823020 构造方法-start");
		logger.debug("SpValidate823020 构造方法 StrLocale" + locale);
		logger.debug("SpValidate823020 构造方法 StrLabel" + label);
		// 设置locale值
		this.locale = locale;
		// 设置lable值
		this.label = label;

		logger.debug("SpValidate823020 构造方法-end");
	}

	/**
	 * 当【画：新建.信用证项下】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(String value) {

		logger.debug("SpValidate823020-canExecute start");
		logger.debug("SpValidate823020-canExecute returnValue true");
		logger.debug("SpValidate823020-canExecute end");
		// 直接返回true，必须校验
		return true;
	}

	/**
	 * data项目不得为空，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(String value, ErrorContainer errorContainer) {

		logger.debug("SpValidate823020-doCheckLogic start");
		// 当value值为空
		if (ArtStringUtil.isEmpty(value)) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String labelMsg = i18nUtil.getI18nMessage(locale, label);

			logger.debug("data项目为空");
			// 返回错误消息ID ART00018_E, {0}不能为空.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00018_E, labelMsg));

		}

		logger.debug("SpValidate823020-doCheckLogic end");
	}
}
