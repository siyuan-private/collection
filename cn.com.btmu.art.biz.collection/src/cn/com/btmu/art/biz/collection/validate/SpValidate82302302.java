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
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82302302业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82302302 extends AbstractBizCheckUnit<BcMntnOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String locale;

	public SpValidate82302302(String locale) {

		logger.debug("SpValidate82302302 构造方法-start");
		logger.debug("SpValidate82302302 构造方法 StrLocale" + locale);
		// 设置locale值
		this.locale = locale;

		logger.debug("SpValidate82302302 构造方法-end");
	}

	/**
	 * 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(BcMntnOpDtl bcMntnOpDtl) {

		logger.debug("SpValidate82302302-canExecute start");
		logger.debug("SpValidate82302302-canExecute end");
		// 直接返回true，必须进行校验
		return true;

	}

	/**
	 * 【画：信用证信息.第一受益人账户】不得为空，否则报错
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

		logger.debug("SpValidate82302302-doCheckLogic start");
		// 【画：信用证信息.第一受益人账户】为空
		if (ArtStringUtil.isEmpty(bcMntnOpDtl.getBene1stAcctSubGl())
				|| ArtStringUtil.isEmpty(bcMntnOpDtl.getBene1stAcctCcy())
				|| ArtStringUtil.isEmpty(bcMntnOpDtl.getBene1stAcctGl())
				|| ArtStringUtil.isEmpty(bcMntnOpDtl.getBene1stAcctNo())) {
			// 获取国际换标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际换标签
			String lableBene1st = i18nUtil.getI18nMessage(locale,
					CollectionConstant.LABEL_823_00035);

			logger.debug("【画：信用证信息.第一受益人账户】为空");
			// 返回错误消息ID ART00018_E， {0}不能为空.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00018_E, lableBene1st));

		}

		logger.debug("SpValidate82302302-doCheckLogic end");
	}
}
