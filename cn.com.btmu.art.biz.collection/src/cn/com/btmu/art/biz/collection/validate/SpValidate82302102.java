package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollAccptceDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82302102业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82302102 extends
		AbstractBizCheckUnit<CollectionCollAccptceDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollAccptceDetailContext context) {

		logger.debug("SpValidate82302102-canExecute start");

		// 取得托收基本信息取得操作数据
		BcInfo reqData = context.getDataRepository().getBizDataCollection()
				.getBcInfo();

		// 取得出口信用证信息取得操作数据
		ExpLcInfo expLcInfo = context.getDataRepository()
				.getBizDataCollection().getExpLcInfo();
		// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时
		if (DataTypeConstant.DATA_TYPE_YES.equals(reqData.getLcFlg())
				&& DataTypeConstant.DATA_TYPE_YES.equals(expLcInfo
						.getWithReimbsBankFlg())) {

			logger
					.debug("SpValidate82302102-canExecute 【画：新建.信用证项下】为Y且【画：信用证信息.有偿付行】为Y");
			logger.debug("SpValidate82302102-canExecute returnValue true");
			logger.debug("SpValidate82302102-canExecute end");
			// 返回true
			return true;
		}

		logger
				.debug("SpValidate82302102-canExecute 【画：新建.信用证项下】为Y或【画：信用证信息.有偿付行】为Y");
		logger.debug("SpValidate82302102-canExecute returnValue false");
		logger.debug("SpValidate82302102-canExecute end");
		// 当【画：新建.信用证项下】不为‘Y’且【画：信用证信息.有偿付行】不为‘Y’时，返回false
		return false;
	}

	/**
	 * 【画：承兑.远期索偿日】不得为空，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(CollectionCollAccptceDetailContext context,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate82302102-doCheckLogic start");

		// 取得托收承兑维护操作明细取得操作数据
		BcAccptceOpDtl bcAccptceOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcAccptceOpDtl();
		// 【画：承兑.远期索偿日】为空
		if (bcAccptceOpDtl.getForwdClmRmbrsmtDate() == null) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableForwdClmRmbrsmtDate = i18nUtil.getI18nMessage(context
					.getSystemPara().getLocale(),
					LabelComConstant.LABEL_COM_02279);

			logger.debug("【画：承兑.远期索偿日】为空");
			// 返回错误消息ID ART00018_E， {0}不能为空.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00018_E,
					lableForwdClmRmbrsmtDate));

		}

		logger.debug("SpValidate82302102-doCheckLogic end");
	}
}
