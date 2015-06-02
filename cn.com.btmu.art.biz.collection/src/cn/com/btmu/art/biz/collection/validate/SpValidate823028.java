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
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate823028业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823028 extends AbstractBizCheckUnit<List<DispchDocInfo>> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String locale;

	public SpValidate823028(String locale) {
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
	protected boolean canExecute(List<DispchDocInfo> dispchDocInfoList) {
		return dispchDocInfoList == null || dispchDocInfoList.size() == 0 ? false
				: true;
	}

	/**
	 * 当前寄单信息行的【Hidden：新增寄单信息标志】的值设为：Y时，做以下【画：寄单信息】板块项目的校验
	 * 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 * 
	 */
	@Override
	protected void doCheckLogic(List<DispchDocInfo> dispchDocInfoList,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823028-doCheckLogic start");
		// 循环判断寄单信息集合中寄单对象为1时，寄单种类是否为空
		for (DispchDocInfo dispchDocInfo : dispchDocInfoList) {
			if (CollectionConstant.DISPCHDOCOBJ_1.equals(dispchDocInfo
					.getDispchDocObj())
					&& ArtStringUtil.isEmpty(dispchDocInfo.getDispchDocType())) {
				// 获取国际化换标签转换工具类
				I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
						.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
				// 转换国际化标签
				String lableDispchDocType = i18nUtil.getI18nMessage(locale,
						LabelComConstant.LABEL_COM_01522);
				logger.debug("SpValidate823028-doCheckLogic 【画：寄单信息.寄单种类】为空");
				// 返回错误信息ID ART00018_E， {0}不能为空.
				errorContainer.error(createErrMessage(
						MsgIdComConstant.COM_MSG_ID_ART00018_E,
						lableDispchDocType));
			}
		}

		logger.debug("SpValidate823028-doCheckLogic end");
	}

}
