package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82309806业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82309806 extends
		AbstractBizCheckUnit<CollectionCollModDocDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 是否有需要验证的判断.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollModDocDetailContext data) {
		// 直接返回true，必须进行校验
		return true;
	}

	/**
	 * 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(CollectionCollModDocDetailContext data,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate82309806-doCheckLogic start");

		// 取得托收维护操作信息取得操作数据
		BcMntnOpDtl reqData = data.getDataRepository()
				.getOperationDataCollection().getBcMntnOpDtl();

		// 【转让编号】=【T-kind】+【主参号】+【转让参号】
		String TrasferNumber = reqData.getTrasfTKind()
				+ ComBizConstant.COMMON_STRING_HYPHEN
				+ reqData.getTrasfNoPrmryRefNo()
				+ ComBizConstant.COMMON_STRING_HYPHEN
				+ reqData.getTrasfNoSubRefNo();
		// 【Hidden：转让编号】不等于【画：信用证信息.转让编号】
		if (!ArtStringUtil.equals(TrasferNumber, (String) data
				.getDataRepository().getTempDataObject().get(
						CollectionConstant.HIDDEN_TRANSFERNO))) {
			// 获取国际化标签转换工具
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableBtn = i18nUtil.getI18nMessage(data.getSystemPara()
					.getLocale(), CollectionConstant.LINK_823_00004);
			// 转换国际化标签
			String lableTransferNo = i18nUtil.getI18nMessage(data
					.getSystemPara().getLocale(),
					CollectionConstant.LABEL_823_00034);

			logger
					.debug("SpValidate82309806-doCheckLogic 【Hidden：转让编号】不等于【画：信用证信息.转让编号】");

			// 返回错误消息ID ART00130_E,{0}被修改过，请重新点击{1}按钮，或恢复为修改前的值。
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00130_E, lableTransferNo,
					lableBtn));

		}

		logger.debug("SpValidate82309806-doCheckLogic end");
	}

}
