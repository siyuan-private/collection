package cn.com.btmu.art.biz.collection.validate;

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
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/**
 * SpValidate82309801业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82309801 extends AbstractBizCheckUnit<BcMntnOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataObject tempObject;

	private String locale;

	public SpValidate82309801(DataObject tempObject, String locale) {
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
		// 当信用证项下为Y，
		if (DataTypeConstant.DATA_TYPE_YES.equals(data.getLcFlg())) {
			// 返回true
			return true;
		}
		// 当信用证项下不为Y时返回false
		return false;
	}

	/**
	 * 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(BcMntnOpDtl data, ErrorContainer errorContainer) {

		logger.debug("SpValidate82309801-doCheckLogic start");

		// 取得托收维护操作信息取得操作数据
		// 【Hidden：信用证编号】不等于【画：信用证信息.信用证编号】
		if (!ArtStringUtil.equals(data.getLcNo(), (String) tempObject
				.get(CollectionConstant.HIDDEN_LCNO))) {
			// 取得国际化转换工具
			I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
					.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
			// 转换国际化标签
			String lableBtn = i18nUtil.getI18nMessage(locale,
					CollectionConstant.LINK_823_00004);
			// 转换国际化标签
			String lableLcNo = i18nUtil.getI18nMessage(locale,
					LabelComConstant.LABEL_COM_02151);

			logger
					.debug("SpValidate82309801-doCheckLogic 【Hidden：信用证编号】不等于【画：信用证信息.信用证编号】");
			logger.debug("SpValidate82309801-doCheckLogic end");
			// 返回错误消息ID ART00130_E, {0}被修改过，请重新点击{1}按钮，或恢复为修改前的值.
			errorContainer
					.error(createErrMessage(
							MsgIdComConstant.COM_MSG_ID_ART00130_E, lableLcNo,
							lableBtn));
		}

		logger.debug("SpValidate82309801-doCheckLogic end");
	}
}
