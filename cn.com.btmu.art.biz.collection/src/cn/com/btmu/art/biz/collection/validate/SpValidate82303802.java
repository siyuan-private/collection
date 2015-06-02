package cn.com.btmu.art.biz.collection.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common.feemngt.util.ChargeFeeUtil;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.feemgmtdataset.FeeRegDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82303802业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82303802 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 是否有需要验证的判断.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext data) {
		// 直接返回true，必须进行校验
		return true;
	}

	/**
	 * 【画：手续费】板块中‘单独记账’不勾选的手续费条数必须小于等于5条，否则报错
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

		logger.debug("SpValidate82303802-doCheckLogic start");

		// 校验方法：调用组件列表【E00060】随交易登录手续费过滤方法，取得手续费信息,当取得手续费的条数大于5条时，显示报错信息
		ChargeFeeUtil chargeFeeUtil = (ChargeFeeUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.E00020_UTIL_CHARGEFEE);
		// 获取手续费信息
		List<FeeRegDtl> feeRegDtl = chargeFeeUtil.getFee(data,
				CollectionConstant.STRING_CRPRIPLFLG,
				CollectionConstant.STRING_CHGMETH);
		// 当手续费条数大于5
		if (feeRegDtl.size() > 5) {
			// 获取国际化标签转换工具
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 国际化标签转换
			String lableExpenses = i18nUtil.getI18nMessage(data.getSystemPara()
					.getLocale(), CollectionConstant.LABEL_823_00045);
			// 字符5
			String lableNo = CollectionConstant.FIVE_STRING;

			logger.debug("SpValidate82303802-doCheckLogic 手续费的条数大于5条");
			// 返回错误消息ID ART00121_E， {0}画面只支持{1}条以下的手续费（含{1}条）.
			errorContainer.error(createErrMessage(
					CollectionConstant.MSG_ID_ART00121_E, lableExpenses,
					lableNo));
		}

		logger.debug("SpValidate82303802-doCheckLogic end");
	}
}
