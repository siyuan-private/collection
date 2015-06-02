package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcBookOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcInfo;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82302501业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82302501 extends
		AbstractBizCheckUnit<CollectionCollBookingDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：新建.汇票金额.币种】为CNY时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollBookingDetailContext data) {

		logger.debug("SpValidate82302501-canExecute start");

		// 取得托收基本信息获取操作数据
		BcInfo bcInfo = data.getDataRepository().getBizDataCollection()
				.getBcInfo();
		// 当【画：新建.汇票金额.币种】为CNY时.
		if (CollectionConstant.CCY_CNY.equals(bcInfo.getBxCcy())) {

			logger.debug("SpValidate82302501-canExecute 【画：新建.汇票金额.币种】为CNY");
			logger.debug("SpValidate82302501-canExecute returnValue true");
			logger.debug("SpValidate82302501-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("SpValidate82302501-canExecute 【画：新建.汇票金额.币种】不为CNY");
		logger.debug("SpValidate82302501-canExecute returnValue false");
		logger.debug("SpValidate82302501-canExecute end");
		// 当【画：新建.汇票金额.币种】不为CNY时.返回false
		return false;
	}

	/**
	 * 则【画：入账.入账账户#1.币种】必须输入CNY，否则报错
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

		logger.debug("SpValidate82302501-doCheckLogic start");

		// 取得托收入账操作明细获取操作数据
		BcBookOpDtl bcBookOpDtl = data.getDataRepository()
				.getOperationDataCollection().getBcBookOpDtl();
		// 【画：入账.入账账户#1.币种】未输入CNY
		if (!CollectionConstant.CCY_CNY.equals(bcBookOpDtl.getBookAcctCcy1())) {
			// 获取国际化标签转换工具类
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableBookAcctCcy1 = i18nUtil.getI18nMessage(data
					.getSystemPara().getLocale(),
					CollectionConstant.LABEL_823_00057);
			logger.debug("【画：入账.入账账户#1.币种】未输入CNY");
			// 返回错徐消息ID ART00107_E， {0}的币种必须为CNY.
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00107_E, lableBookAcctCcy1));

		}

		logger.debug("SpValidate82302501-doCheckLogic end");
	}
}
