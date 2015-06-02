package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollModfDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * SpValidate823012业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823012 extends
		AbstractBizCheckUnit<CollectionCollModfDetailContext> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 当【画：承兑.Accepted Flag】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(CollectionCollModfDetailContext context) {

		logger.debug("SpValidate823012-canExecute start");
		// 获取承兑操作明细
		BcAccptceOpDtl accptceOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcAccptceOpDtl();
		// 当【画：承兑.Accepted Flag】为‘Y’时
		if (DataTypeConstant.DATA_TYPE_YES
				.equals(accptceOpDtl.getAcceptedFlg())) {

			logger.debug("【画：承兑.Accepted Flag】为‘Y’");
			logger.debug("SpValidate823012-canExecute returnValue true");
			logger.debug("SpValidate823012-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("【画：承兑.Accepted Flag】不为‘Y’");
		logger.debug("SpValidate823012-canExecute returnValue false");
		logger.debug("SpValidate823012-canExecute end");
		// 当【画：承兑.Accepted Flag】不为‘Y’时，返回false
		return false;
	}

	/**
	 * 当【画：承兑.Accepted
	 * Flag】为‘Y’时，则【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.合理】不得为空，【画：承兑.远期索偿日】在【画：信用证信息.有偿付行】为‘Y’时，不得为空，否则报错（SP_VALIDATE_823_012）
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */

	@Override
	protected void doCheckLogic(CollectionCollModfDetailContext context,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823012-doCheckLogic start");
		// 获取出口信用证维护操作明细
		ExpLcMntnOpDtl expLcMntnOpDtl = context.getDataRepository()
				.getOperationDataCollection().getExpLcMntnOpDtl();
		// 获取承兑操作明细
		BcAccptceOpDtl accptceOpDtl = context.getDataRepository()
				.getOperationDataCollection().getBcAccptceOpDtl();
		// AcceptedFlag”为“Y”时，则“承兑登记日”、“承兑到期日”、“合理”未输入，“远期索偿日”在“有偿付行”为“Y”时，未输入.
		if ((accptceOpDtl.getAccptceRegDate() == null
				|| accptceOpDtl.getAccptceDueDate() == null
				|| ArtStringUtil.isEmpty(accptceOpDtl.getResnblFlg()) || ((accptceOpDtl
				.getForwdClmRmbrsmtDate() == null) && DataTypeConstant.DATA_TYPE_YES
				.equals(expLcMntnOpDtl.getWithReimbsBankFlg())))) {
			logger.debug("承兑登记日、承兑到期日、合理 必须输入，远期索偿日");
			// AcceptedFlag”为“Y”时，则“承兑登记日”、“承兑到期日”、“合理”未输入，“远期索偿日”在“有偿付行”为“Y”时，未输入.返回错误信息ID
			// ART00100_E
			errorContainer
					.error(createErrMessage(MsgIdComConstant.COM_MSG_ID_ART00100_E));
		}

		logger.debug("SpValidate823012-doCheckLogic end");
	}

}
