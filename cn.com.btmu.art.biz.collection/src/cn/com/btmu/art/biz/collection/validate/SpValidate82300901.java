package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.datacollection.common.ICollectionCommonMntnDataCollection;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.service.locadvice.GetLCInfoWithConfirmationCommand;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.GetLCInfoWithConfirmationCommandInput;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.GetLCInfoWithConfirmationCommandResult;

/**
 * SpValidate82300901业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82300901 extends
		AbstractBizCheckUnit<ICollectionCommonMntnDataCollection> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 【画：信用证信息.信用证编号】不为空时
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(ICollectionCommonMntnDataCollection data) {

		logger.debug("SpValidate82300901-canExecute start");
		// 【画：信用证信息.信用证编号】不为空时
		if (data.getBcMntnOpDtl().getLcNo() != null) {

			logger.debug("信用证信息.信用证编号不为空");
			logger.debug("SpValidate82300901-canExecute returnValue true");
			logger.debug("SpValidate82300901-canExecute end");
			// 返回true
			return true;
		}

		logger.debug("信用证信息.信用证编号为空");
		logger.debug("SpValidate82300901-canExecute returnValue false");
		logger.debug("SpValidate82300901-canExecute end");
		// 【画：信用证信息.信用证编号】为空时,返回false
		return false;
	}

	/**
	 * 【画：信用证信息.信用证编号】不为空时，信用证已被取消的场合，显示报错信息
	 * 校验方法：根据【画：信用证信息.信用证编号】到【DM：出口信用证信息】中检索数据
	 * 当检索结果等于1件且【DM：出口信用证信息.取消标志】为‘1’时，显示报错信息
	 * 
	 * @return ErrMessage 错误信息
	 * @param data
	 *            数据存储
	 */
	@Override
	protected void doCheckLogic(ICollectionCommonMntnDataCollection data,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate82300901-doCheckLogic start");
		// 获取业务间函数实例
		GetLCInfoWithConfirmationCommand command = GetLCInfoWithConfirmationCommand
				.getInstance();
		// 创建输入实例
		GetLCInfoWithConfirmationCommandInput input = command.createInputData();
		// 设置分行号
		input.setBranchCode(data.getBcMntnOpDtl().getBranchCode());
		// 设置信用证编号
		input.setLcNo(data.getBcMntnOpDtl().getLcNo());
		input.setSpecs(command.createLCStatusCheckSpec().and(
				command.createLcInfoBeneCifCheckSpec(data.getBcMntnOpDtl()
						.getBeneCif())));
		// 取得查询结果
		GetLCInfoWithConfirmationCommandResult result = command.fire(input);
		// 当执行失败时
		if (!result.isSuccess()) {
			// 设置错误消息
			errorContainer.error(result.getErrList());
		} else {
			// 执行成功，设置查询结果
			data.setMainLcInfo(result.getResult().getLcInfo());
		}

		logger.debug("SpValidate82300901-doCheckLogic end");
	}
}
