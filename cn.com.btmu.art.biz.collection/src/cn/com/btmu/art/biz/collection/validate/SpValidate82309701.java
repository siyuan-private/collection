package cn.com.btmu.art.biz.collection.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common.feemngt.util.ChargeFeeUtil;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.context.impl.DetailContext;
import cn.com.btmu.art.framework.bo.domain.feemgmtdataset.FeeRegDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82309701业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82309701 extends AbstractBizCheckUnit<DetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 有无需要校验的条件.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(DetailContext data) {
		// 返回true，必须进行校验
		return true;
	}

	/**
	 * 手续费的收取方式校验：手续费不能通过特殊画面收取，只能选择手续费模块中的单独记账收取，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(DetailContext data,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate82309701-doCheckLogic start");

		// 校验方法：调用组件列表【E00060】随交易登录手续费过滤方法，取得手续费信息
		ChargeFeeUtil chargeFeeUtil = (ChargeFeeUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.E00020_UTIL_CHARGEFEE);
		// 获取手续费业务间函数
		List<FeeRegDtl> feeRegDtl = chargeFeeUtil.getFee(data,
				CollectionConstant.STRING_CRPRIPLFLG,
				CollectionConstant.STRING_CHGMETH);
		// 当取得手续费的条数大于0条时，显示报错信息
		if (feeRegDtl.size() > 0) {
			// 获取国际化标签转换工具
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableFee = i18nUtil.getI18nMessage(data.getSystemPara()
					.getLocale(), LabelComConstant.LABEL_COM_02064);

			logger
					.debug("SpValidate82309701-doCheckLogic 手续费不能通过特殊画面收取，只能选择手续费模块中的单独记账收取");
			// 返回错误消息ID ART00071_E, {0}中，手续费只能选择单独记账收取
			errorContainer.error(createErrMessage(
					CollectionConstant.MSGID_ART00071_E, lableFee));
		}

		logger.debug("SpValidate82309701-doCheckLogic end");
	}
}
