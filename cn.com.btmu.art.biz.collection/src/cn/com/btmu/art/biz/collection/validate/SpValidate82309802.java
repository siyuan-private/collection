package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/**
 * SpValidate82309802业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82309802 extends AbstractBizCheckUnit<BcMntnOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataObject tempObject;

	private String locale;

	public SpValidate82309802(DataObject tempObject, String locale) {
		// 设置tempObject值
		this.tempObject = tempObject;
		// 设置locale值
		this.locale = locale;
	}

	/**
	 * 是否有需要验证的判断.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(BcMntnOpDtl data) {
		// 当信用证项下为Y
		if (DataTypeConstant.DATA_TYPE_YES.equals(data.getLcFlg())) {
			// 返回true
			return true;
		}
		// 当信用证项下不为Y，返回false
		return false;
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
	protected void doCheckLogic(BcMntnOpDtl data, ErrorContainer errorContainer) {

		logger.debug("SpValidate82309802-doCheckLogic start");

		// 取得托收维护操作信息取得操作数据
		// 【转让编号】=【T-kind】+【主参号】+【转让参号】
		String TrasferNumber = data.getTrasfTKind()
				+ ComBizConstant.COMMON_STRING_HYPHEN
				+ data.getTrasfNoPrmryRefNo()
				+ ComBizConstant.COMMON_STRING_HYPHEN
				+ data.getTrasfNoSubRefNo();
		// 【Hidden：转让编号】不等于【画：信用证信息.转让编号】
		if (!ArtStringUtil.equals(TrasferNumber, (String) tempObject
				.get(CollectionConstant.HIDDEN_TRANSFERNO))) {
			// 获取国际化标签转换工具
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableTransferNo = i18nUtil.getI18nMessage(locale,
					CollectionConstant.LABEL_823_00034);
			// 转换国际化标签
			String lableBtn = i18nUtil.getI18nMessage(locale,
					CollectionConstant.LINK_823_00004);
			logger
					.debug("SpValidate82309802-doCheckLogic 【Hidden：转让编号】不等于【画：信用证信息.转让编号】");

			// 返回错误消息ID ART00130_E, {0}被修改过，请重新点击{1}按钮，或恢复为修改前的值。
			errorContainer.error(createErrMessage(
					MsgIdComConstant.COM_MSG_ID_ART00130_E, lableTransferNo,
					lableBtn));

		}

		logger.debug("SpValidate82309802-doCheckLogic end");
	}

}
