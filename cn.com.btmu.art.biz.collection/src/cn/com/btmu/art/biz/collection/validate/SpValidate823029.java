package cn.com.btmu.art.biz.collection.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate823029业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823029 extends
		AbstractBizCheckUnit<List<BbCombLcMntnOpDtl>> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String locale;

	public SpValidate823029(String locale) {

		logger.debug("SpValidate823029 构造方法-start");
		logger.debug("SpValidate823029 构造方法 StrLocale" + locale);
		// 设置locale值
		this.locale = locale;

		logger.debug("SpValidate823029 构造方法-end");
	}

	/**
	 * 是否有需要验证的判断.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList) {
		return bbCombLcMntnOpDtlList == null ? false : true;
	}

	/**
	 * 当以下项目中有一个项目被输入时，其余项目都不得为空，否则报错 【画：信用证信息.Combined LC信息.信用证编号#1-#5】
	 * 【画：信用证信息.Combined LC信息.信用证金额#1-#5.金额】 【画：信用证信息.Combined LC信息.drawn
	 * amount#1-#5.金额】 【画：信用证信息.Combined LC信息.信用证余额#1-#5.金额
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823029-doCheckLogic start");
		// 获取国际化标签转换工具类
		I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
		// 国际化标签 信用证编号
		String labelLcNo = i18nUtil.getI18nMessage(this.locale,
				LabelComConstant.LABEL_COM_02151);
		// 国际化标签 信用证金额 金额
		String labelDrawnAmt = i18nUtil.getI18nMessage(this.locale,
				CollectionConstant.LABEL_823_00026);
		// 国际化标签 drawn amount 金额
		String labelLcAmt = i18nUtil.getI18nMessage(this.locale,
                CollectionConstant.LABEL_823_00032);
		// 国际化标签 信用证余额 金额
		String labelLcBalAmt = i18nUtil.getI18nMessage(this.locale,
                CollectionConstant.LABEL_823_00027);
		// 信用证信息.Combined LC信息循环 各个项目是否为空
		for (BbCombLcMntnOpDtl bbCombLcMntnOpDtl : bbCombLcMntnOpDtlList) {
			if (!ArtStringUtil.isEmpty(bbCombLcMntnOpDtl.getLcNo())
					|| bbCombLcMntnOpDtl.getDrawnAmt() != null
					|| bbCombLcMntnOpDtl.getLcAmt() != null
					|| bbCombLcMntnOpDtl.getLcBalAmt() != null) {
				if (ArtStringUtil.isEmpty(bbCombLcMntnOpDtl.getLcNo())
						|| bbCombLcMntnOpDtl.getDrawnAmt() == null
						|| bbCombLcMntnOpDtl.getLcAmt() == null
						|| bbCombLcMntnOpDtl.getLcBalAmt() == null) {

					logger.debug("SpValidate823029-doCheckLogic 有项目为空");
					logger.debug("SpValidate823029-doCheckLogic end");
					// 返回错误消息ID ART00018_E
					errorContainer.error(createErrMessage(
							MsgIdComConstant.COM_MSG_ID_ART00018_E, labelLcNo
									+ CollectionConstant.COMMON_STRING_COMMA
									+ labelDrawnAmt
									+ CollectionConstant.COMMON_STRING_COMMA
									+ labelLcAmt
									+ CollectionConstant.COMMON_STRING_COMMA
									+ labelLcBalAmt));
				}
			}
		}

		logger.debug("SpValidate823029-doCheckLogic end");
	}
}
