package cn.com.btmu.art.biz.collection.validate;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.datacollection.common.ICollectionCommonMntnDataCollection;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.service.locadvice.GetLCInfoWithConfirmationCommand;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.GetLCInfoWithConfirmationCommandInput;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.GetLCInfoWithConfirmationCommandResult;
import cn.com.btmu.art.biz.common01biz.service.locadvice.data.LCInfoWithConfirmation;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;

/**
 * SpValidate82300902业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82300902 extends
		AbstractBizCheckUnit<ICollectionCommonMntnDataCollection> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 定义出口信用证维护操作明细对象
	private ExpLcMntnOpDtl expLcMntnOpDtl;

	// 定义托收维护操作明细对象
	private BcMntnOpDtl bcMntnOpDtl;

	public SpValidate82300902(ExpLcMntnOpDtl expLcMntnOpDtl,
			BcMntnOpDtl bcMntnOpDtl) {
		this.expLcMntnOpDtl = expLcMntnOpDtl;
		this.bcMntnOpDtl = bcMntnOpDtl;
	}

	/**
	 * 是否有需要验证的判断.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(ICollectionCommonMntnDataCollection data) {
		return data.getBbCombLcMntnOpDtlList() == null ? false : true;
	}

	/**
	 * 【画：信用证信息.Combined LC信息.信用证编号#2-#5】不为空时，信用证已被取消检查 校验方法：根据【画：信用证信息.Combined
	 * LC信息.信用证编号#2-#5】分别到【DM：出口信用证信息】中检索数据
	 * 当对应的信用证编号检索的结果等于1件且【DM：出口信用证信息.取消标志】为‘1’时，显示报错信息
	 * 
	 * @return ErrMessage 错误信息
	 * @param data
	 *            数据存储
	 */
	@Override
	protected void doCheckLogic(ICollectionCommonMntnDataCollection data,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate82300902-doCheckLogic start");
		// Combined LC信息获取
		List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList = data
				.getBbCombLcMntnOpDtlList();
		// 定义Combined LC信息检查结果确认集合
		List<LCInfoWithConfirmation> combinedLcInfoList = new ArrayList<LCInfoWithConfirmation>();
		// 获取业务间函数
		GetLCInfoWithConfirmationCommand command = GetLCInfoWithConfirmationCommand
				.getInstance();
		GetLCInfoWithConfirmationCommandInput input;
		// 画：信用证信息.Combined LC信息.信用证编号#2-#5】不为空时
		for (BbCombLcMntnOpDtl lc : bbCombLcMntnOpDtlList) {
			input = command.createInputData();
			// 设置分行号
			input.setBranchCode(lc.getBranchCode());
			// 设置信用证编号
			input.setLcNo(lc.getLcNo());
			input.setSpecs(command.createLCStatusCheckSpec().and(
					command.createLcInfoConsistencyCheckSpec(expLcMntnOpDtl,
							bcMntnOpDtl)).and(
					command.createCombinedLcCheckSpec()).and(
					command.createOurAdvicedLcCheckSpec(lc)));
			// 取得结果
			GetLCInfoWithConfirmationCommandResult result = command.fire(input);
			// 当确认失败时
			if (!result.isSuccess()) {
				// 返回错误信息
				errorContainer.error(result.getErrList());
			} else {
				// 添加结果集中
				combinedLcInfoList.add(result.getResult());
			}
		}
		// 将结果集设置到context中
		data.setCombinedLcInfo(combinedLcInfoList);

		logger.debug("SpValidate82300902-doCheckLogic end");
	}
}
