package cn.com.btmu.art.biz.collection.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;

/**
 * SpValidate823005业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823005 extends
		AbstractBizCheckUnit<List<BbCombLcMntnOpDtl>> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public SpValidate823005() {
		logger.debug("SpValidate823005构造方法-start");
		logger.debug("SpValidate823005构造方法-end");
	}

	/**
	 * 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(List<BbCombLcMntnOpDtl> data) {
		logger.debug("SpValidate823005-canExecute start");
		logger.debug("SpValidate823005-canExecute returnValue true");
		logger.debug("SpValidate823005-canExecute end");
		// 返回true
		return true;
	}

	/**
	 * Combined LC信息表格中信用证编号有值的记录条数必须大于等于2，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(List<BbCombLcMntnOpDtl> data,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823005-doCheckLogic start");
		// 当Combined LC少于两条时
		if ((data == null ? 0 : data.size()) < 2) {
			// Combined LC为“Y”时，必须输入至少2条Combined LC信息.
			logger.debug("少于两条Combined LC信息");
			// 返回错误消息ID ART00097_E
			errorContainer
					.error(createErrMessage(MsgIdComConstant.COM_MSG_ID_ART00097_E));
		}

		logger.debug("SpValidate823005-doCheckLogic end");
	}
}
