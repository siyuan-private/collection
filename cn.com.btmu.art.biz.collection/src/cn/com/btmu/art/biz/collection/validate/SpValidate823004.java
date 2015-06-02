package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * SpValidate823004业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823004 extends AbstractBizCheckUnit<ExpLcMntnOpDtl> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public SpValidate823004() {
		logger.debug("SpValidate823004构造方法-start");
		logger.debug("SpValidate823004构造方法-end");
	}

	/**
	 * 当【画：新建.P.P.NEGO】勾选时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(ExpLcMntnOpDtl data) {
		logger.debug("SpValidate823004-canExecute start");
		logger.debug("SpValidate823004-canExecute returnValue true");
		logger.debug("SpValidate823004-canExecute end");
		// 返回true，必须做校验
		return true;
	}

	/**
	 * 【画：信用证信息.有偿付行】必须为‘Y’，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(ExpLcMntnOpDtl data,
			ErrorContainer errorContainer) {
		logger.debug("SpValidate823004-doCheckLogic start");

		// 使用出口信用证维护操作明细取得操作数据 P.P.NEGO勾选时，有偿付行不选择"Y".
		if (!DataTypeConstant.DATA_TYPE_YES.equals(data.getWithReimbsBankFlg())) {
			logger.debug("P.P.NEGO勾选时，有偿付行没有选择Y");
			// 返回错误消息ID ART82301_E
			errorContainer
					.error(createErrMessage(CollectionConstant.MSG_ID_ART82301_E));

		}

		logger.debug("SpValidate823004-doCheckLogic end");
	}
}
