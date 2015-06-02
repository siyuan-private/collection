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
 * SpValidate82302301业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82302301 extends AbstractBizCheckUnit<BcMntnOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String locale;

	public SpValidate82302301(String locale) {

		logger.debug("SpValidate82302301构造方法-start");
		logger.debug("SpValidate82302301构造方法 StrLocale" + locale);
		// 设置locale值
		this.locale = locale;

		logger.debug("SpValidate82302301构造方法-end");
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

		logger.debug("SpValidate82302301-canExecute start");
		logger.debug("SpValidate82302301-canExecute returnValue true");
		logger.debug("SpValidate82302301-canExecute end");
		// 直接返回true，必须校验
		return true;
	}

	/**
	 * 【画：信用证信息.转让编号】不得为空，否则报错
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

		logger.debug("SpValidate82302301-doCheckLogic start");
		// 【画：信用证信息.转让编号】为空
		if (ArtStringUtil.isEmpty(bcMntnOpDtl.getTrasfTKind())
				|| ArtStringUtil.isEmpty(bcMntnOpDtl.getTrasfNoPrmryRefNo())
				|| ArtStringUtil.isEmpty(bcMntnOpDtl.getTrasfNoSubRefNo())) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableTrasfNo = i18nUtil.getI18nMessage(locale,
					CollectionConstant.LABEL_823_00034);

			logger.debug("转让编号为空");
			// 返回错误消息ID ART00018_E， {0}不能为空.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00018_E, lableTrasfNo));

		}

		logger.debug("SpValidate82302301-doCheckLogic end");
	}
}
