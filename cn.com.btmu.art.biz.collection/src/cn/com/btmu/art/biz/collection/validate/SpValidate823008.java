package cn.com.btmu.art.biz.collection.validate;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;

/**
 * SpValidate823008业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate823008 extends
		AbstractBizCheckUnit<List<BbCombLcMntnOpDtl>> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 定义bxAmt对象
	private BigDecimal bxAmt;

	public SpValidate823008(BigDecimal bxAmt) {
		logger.debug("SpValidate823008构造方法-start");
		// 设置bxAmt值
		this.bxAmt = bxAmt;
		logger.debug("SpValidate823008构造方法-end");
	}

	/**
	 * 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时.
	 * 
	 * @return boolean 判断结果
	 * @param data
	 *            数据存储
	 */
	@Override
	protected boolean canExecute(List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList) {

		logger.debug("SpValidate823008-canExecute start");
		logger.debug("SpValidate823008-canExecute end");
		// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时.返回true否则返回false
		return bbCombLcMntnOpDtlList == null ? false : true;
	}

	/**
	 * 【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】的合计必须等于【画：新建.汇票金额.金额】，否则报错
	 * 
	 * @return void
	 * @param data
	 *            上下文数据
	 * @param ErrorContainer
	 *            错误信息容器
	 */
	@Override
	protected void doCheckLogic(List<BbCombLcMntnOpDtl> BbCombLcMntnOpDtlList,
			ErrorContainer errorContainer) {

		logger.debug("SpValidate823008-doCheckLogic start");
		// 定义金额总和
		BigDecimal sum = BigDecimal.ZERO;
		// 【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】的合计
		for (BbCombLcMntnOpDtl bbCombLcMntnOpDtl : BbCombLcMntnOpDtlList) {
			if (bbCombLcMntnOpDtl.getDrawnAmt() != null) {
				sum = sum.add(bbCombLcMntnOpDtl.getDrawnAmt());
			}
		}
		// 【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】的合计不等于【画：新建.汇票金额.金额】
		if (bxAmt == null || bxAmt.compareTo(sum) != 0) {

			logger.debug("Combined LC的drawn amount的合计不等于汇票金额");

			// 返回错误信息ID ART82302_E
			errorContainer
					.error(createErrMessage(CollectionConstant.MSG_ID_ART82302_E));
		}

		logger.debug("SpValidate823008-doCheckLogic end");
	}
}
