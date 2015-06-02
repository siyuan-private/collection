package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate823031业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823031 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：入账.入两个账户】不勾选时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext data) {

		logger.debug("SpValidate823031-canExecute start");

		// 取得托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = data.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 当【画：入账.入两个账户】不勾选时.
		if (DataTypeConstant.DATA_TYPE_NO
				.equals(bcBookOpDtl.getEnter2AcctFlg())) {

			logger.debug("SpValidate823031-canExecute 【画：入账.入两个账户】勾选");
			logger.debug("SpValidate823031-canExecute returnValue true");
			logger.debug("SpValidate823031-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("SpValidate823031-canExecute 【画：入账.入两个账户】不勾选");
		logger.debug("SpValidate823031-canExecute returnValue false");
		logger.debug("SpValidate823031-canExecute end");
		// 当【画：入账.入两个账户】勾选时.返回false
		return false;
	}

	/**
	 * 【画：入账.金额#1.金额】必须等于【画：入账.头寸金额.金额】，否则报错
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

		logger.debug("SpValidate823031-doCheckLogic start");

		// 取得托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = data.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 【画：入账.金额#1.金额】不等于【画：入账.头寸金额.金额】
		if (!bcBookOpDtl.getBookAmt1().equals(bcBookOpDtl.getPosAmt())) {
			// 获取国际化标签工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableBookAmt1 = i18nUtil.getI18nMessage(data.getSystemPara()
					.getLocale(), LabelComConstant.LABEL_COM_01570);
			// 转换国际化标签
			String lablePosAmt = i18nUtil.getI18nMessage(data.getSystemPara()
					.getLocale(), CollectionConstant.LABEL_823_00013);

			logger
					.debug("SpValidate823031-doCheckLogic 【画：入账.金额#1.金额】不等于【画：入账.头寸金额.金额】");

			// 返回错误信息ID ART00012_E，{0}的数值必须等于{1}.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00012_E, lableBookAmt1,
					lablePosAmt));

		}

		logger.debug("SpValidate823031-doCheckLogic end");
	}
}
