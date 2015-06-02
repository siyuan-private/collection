package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.framework.constant.ProcessConstant;
import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollCreateDetailContext;
import cn.com.btmu.art.biz.collection.triggervisitor.CollCommonKinLcredleTriggerVisitor;
import cn.com.btmu.art.biz.collection.validate.SpValidate823017;
import cn.com.btmu.art.biz.collection.validate.SpValidate823028;
import cn.com.btmu.art.biz.collection.validate.SpValidate82303801;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309601;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309801;
import cn.com.btmu.art.biz.collection.validate.SpValidate82309802;
import cn.com.btmu.art.biz.collection.validate.SpValidateForNotUnderLC;
import cn.com.btmu.art.biz.collection.validate.SpValidateForUnderLC;
import cn.com.btmu.art.biz.collection.validate.Warning82300101;
import cn.com.btmu.art.biz.collection.validate.Warning823003;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.biz.common01biz.base.handler.ComTriggerEventHandler;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.component.collect.BizTypeContract;
import cn.com.btmu.art.component.collect.CollectUtil;
import cn.com.btmu.art.component.collect.SeqenceObj;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BcMntnOpDtlImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.DispchDocInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.ExpLcMntnOpDtlImpl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dto.SeqRelation;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.smile.service.SmileConstants;
import cn.com.btmu.smile.service.SmileInvocationInstructions;

import commonj.sdo.DataObject;

/**
 * CollectionCollCreateHandler 托收新建节点用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollCreateHandler extends
		ComTriggerEventHandler<CollectionCollCreateDetailContext> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 采号信息取得
	 * 
	 * @return SeqRelation 采号信息
	 */
	public List<SeqRelation> getSequence() throws BizException {
		logger.debug("CollectionCollCreateHandler-getSequence start");
		// 定义预采号集合
		List<SeqRelation> preSeqList = new ArrayList<SeqRelation>();
		// 采号信息取得
		SeqRelation reqRelation = new SeqRelation(getContext().getReqData()
				.getTKind()
				+ getContext().getReqData().getTxnPrmryRefNo()
				+ getContext().getReqData().getTxnSubRefNo(), null);
		// 添加预采号信息
		preSeqList.add(reqRelation);

		logger.debug("CollectionCollCreateHandler-getSequence end");
		// 返回preSeqList
		return preSeqList;
	}

	/**
	 * 初始化方法，自定义初始化逻辑.
	 * 
	 * @return void
	 */
	@Override
	public void init() {
		logger.debug("CollectionCollCreateHandler-init start");

		// 取得系统日期的方法
		DateUtil bizDataUtil = (DateUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.I00300_UTIL_DATE);
		// 获取托收维护操作明细
		BcMntnOpDtlImpl reqData = getContext().getReqData();
		// 获取出口信用证维护操作明细
		ExpLcMntnOpDtl explcMntnOpDtl = new ExpLcMntnOpDtlImpl();

		// 网银标志位设为 N
		reqData.setInternetFlg(DataTypeConstant.DATA_TYPE_NO);

		// 跨境人民币标志位设为 N
		reqData.setCrsBorderRmbFlg(DataTypeConstant.DATA_TYPE_NO);

		// 跨境人民币业务标志设为 N
		reqData.setPpnegoFlg(DataTypeConstant.DATA_TYPE_NO);

		// BPO标志设为 N
		reqData.setBpoFlg(DataTypeConstant.DATA_TYPE_NO);

		// TSU标志设为 N
		reqData.setTsuFlg(DataTypeConstant.DATA_TYPE_NO);

		// P.P. NEGO标志设为 N
		reqData.setPpnegoFlg(DataTypeConstant.DATA_TYPE_NO);

		// 受益人为我行客户标志位为 Y
		reqData.setBeneOurCustFlg(DataTypeConstant.DATA_TYPE_YES);

		// Tenor种类设为请选择
		reqData.setTenorType(ComBizConstant.COMMON_STRING_EMPTY);
        
        // 假远期设为 N
        reqData.setFakeForwdFlg(DataTypeConstant.DATA_TYPE_NO);

		// 已签署GA/TFA标志设为 Y
		reqData.setSigdGatfa(DataTypeConstant.DATA_TYPE_YES);

		// 托收日期设为系统日期
		reqData.setCollDate(bizDataUtil.getNow());

		// 信用证信息 第二受益人标志位设为 N
		explcMntnOpDtl.setBene2ndFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 OSA/NRA标志标志位设为 N
        explcMntnOpDtl.setOsaNraFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 寄单行同开证行标志位设为 Y
		explcMntnOpDtl.setDispchBankEqIssueFlg(DataTypeConstant.DATA_TYPE_YES);

		// 信用证信息 有偿付行标志位设为 N
		explcMntnOpDtl.setWithReimbsBankFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 允许电报偿付标志设为 N
        explcMntnOpDtl.setAllowTelegReimbsFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 我行保兑不勾选
		explcMntnOpDtl.setOurBankConfmdFlg(DataTypeConstant.DATA_TYPE_NO);

		// 履行保兑责任标志设为 Y
		reqData.setPerfmConfmDuties(DataTypeConstant.DATA_TYPE_YES);

		// 信用证信息 我行承兑设为否 N
		explcMntnOpDtl.setOurBankAccptceFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 转让信用证 否
		explcMntnOpDtl.setTrasfLcFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 留行信用证 N
		explcMntnOpDtl.setKibLcFlg(DataTypeConstant.DATA_TYPE_NO);

		// 信用证信息 警报国家的初始值 4：N
        explcMntnOpDtl.setAlertCountry(CollectionConstant.ALERTCOUNTRY_4);

		// 信用证信息 代理行标志位设为 Y
        explcMntnOpDtl.setAgcBankFlg(DataTypeConstant.DATA_TYPE_YES);

		// 信用证信息 国内信用证 N
		explcMntnOpDtl.setDomstcLcFlg(DataTypeConstant.DATA_TYPE_NO);

		// Combined LC N
		reqData.setCombinedLcFlg(DataTypeConstant.DATA_TYPE_NO);

		// 转让第二受益人 N
		reqData.setTrasf2ndBene(DataTypeConstant.DATA_TYPE_NO);

		// 第二受益人银行国别 国家为请选择
		reqData.setBene2ndNatnlty(ComBizConstant.COMMON_STRING_EMPTY);

		// 第二受益人银行国别 省为请选择
		reqData.setBene2ndProv(ComBizConstant.COMMON_STRING_EMPTY);

		// 第二受益人银行国别 市为请选择
		reqData.setBene2ndCity(ComBizConstant.COMMON_STRING_EMPTY);

        // 转让OSA/NRA N
        reqData.setTrasfOsaNraFlg(DataTypeConstant.DATA_TYPE_NO);
        
		// 非信用证信息OSA/NRA N
		reqData.setOsaNraFlg(DataTypeConstant.DATA_TYPE_NO);
        
		// 警报国家的初始值 4：N
        reqData.setAlertCountry(CollectionConstant.ALERTCOUNTRY_4);

        // 代理行标志位设为 Y
        reqData.setAgcBankFlg(DataTypeConstant.DATA_TYPE_YES);
        
		// 跟单票 光票的初始值D：Documentary
		reqData.setDocClean(CollectionConstant.DOCCLEAN_D);

		// 有追索权标志 N
		reqData.setWithRcsFlg(DataTypeConstant.DATA_TYPE_NO);

		// CHQ King 为请选择
		reqData.setChqKind(ComBizConstant.COMMON_STRING_EMPTY);

		// 拒绝证明 请选择
		reqData.setRefuseCertfct(ComBizConstant.COMMON_STRING_EMPTY);

		// ExMethod 请选择
		reqData.setExMethod(ComBizConstant.COMMON_STRING_EMPTY);

		// Quote 请选择
		reqData.setQuote(ComBizConstant.COMMON_STRING_EMPTY);

		// M/D 请选择
		reqData.setMd(ComBizConstant.COMMON_STRING_EMPTY);
		// 设置出口信用证维护操作明细
		getContext().getDataRepository().getOperationDataCollection()
				.setExpLcMntnOpDtl(explcMntnOpDtl);

		logger.debug("CollectionCollCreateHandler-init end");
	}

	@Override
	protected void internalDataValidate(ErrorContainer errorContainer)
			throws BizException {
		logger.debug("CollectionCollCreateHandler-internalDataValidate start");
		if (ArtStringUtil.equals(ProcessConstant.ID_ACT_SUBMIT, getContext().getSystemPara().getAction())){
			// 取得托收维护操作明细
			BcMntnOpDtl bcMntnOpDtl = getContext().getDataRepository()
					.getOperationDataCollection().getBcMntnOpDtl();
			// 取得寄单信息
			List<DispchDocInfo> dispchDocInfoList = getContext()
					.getDataRepository().getOperationDataCollection()
					.getDispchDocInfoForSaveList();
			// 取得系统locale
			String locale = getContext().getSystemPara().getLocale();
	
			// 当【画：新建.电报议付】为‘Y’时，【画：新建.电报议付销号日期】不得为空，否则报错（SP_VALIDATE_823_017）
			SpValidate823017 spValidate823017 = new SpValidate823017(locale);
			spValidate823017.execute(bcMntnOpDtl, errorContainer);
	
			// 当【画：新建.信用证项下】为‘Y’时，进行信用证项下的校验
			SpValidateForUnderLC spValidateForUnderLC = new SpValidateForUnderLC(
					getContext().getDataRepository().getTempDataObject(), locale);
			spValidateForUnderLC.execute(getContext().getDataRepository()
					.getOperationDataCollection(), errorContainer);
	
			// 当【画：新建.信用证项下】为‘N’时，进行非信用证项下的校验
			SpValidateForNotUnderLC spValidateForNotUnderLC = new SpValidateForNotUnderLC(
					locale);
			spValidateForNotUnderLC.execute(getContext().getDataRepository()
					.getOperationDataCollection(), errorContainer);
	
			// 【画：手续费】板块中‘单独记账’不勾选的手续费条数必须小于等于5条，否则报错（SP_VALIDATE_823_038）
			SpValidate82303801 spValidate823038 = new SpValidate82303801();
			spValidate823038.execute(getContext(), errorContainer);
	
			// 【画：费用信息.手续费账户.币种】不为空时，必须等于【画：手续费】板块所有手续费的币种，否则报错（SP_VALIDATE_823_096）
			SpValidate82309601 spValidate82309601 = new SpValidate82309601(
					bcMntnOpDtl.getFeeAcctCcy());
			spValidate82309601.execute(getContext(), errorContainer);
	
			// 当【画：费用信息.手续费支付方】为‘B：Buyer’时，画面上显示提示message，清算行账户请输入237中间账户（WARNING_823_001）
			Warning82300101 warning82300101 = new Warning82300101();
			warning82300101.execute(bcMntnOpDtl.getFeePayer(), errorContainer);
	
			// 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
			SpValidate823028 spValidate82302801 = new SpValidate823028(locale);
			spValidate82302801.execute(dispchDocInfoList, errorContainer);
	
			// 当【画：新建.受益人为我行客户】=‘N’时，画面显示提示message,受益人非我行客户！
			Warning823003 warning823003 = new Warning823003();
			warning823003.execute(bcMntnOpDtl.getBeneOurCustFlg(), errorContainer);
		}
		logger.debug("CollectionCollCreateHandler-internalDataValidate end");
	}

	/**
	 * 采号.
	 * 
	 * @return SeqRelation 采号信息
	 */
	@Override
	public List<SeqRelation> seqGenerate() {
		logger.debug("CollectionCollCreateHandler-seqGenerate start");

		CollectUtil collectUtil = (CollectUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.E90210_UTIL_COLLECT);
		// 定义采号信息集合
		List<SeqRelation> seqGenerate = new ArrayList<SeqRelation>();
		// 定义分行号字串，业务类型字串
		String bizType = null, branchNo = null;
		// 信用证项下为'Y'
		if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getContext()
				.getDataRepository().getOperationDataCollection()
				.getBcMntnOpDtl().getLcFlg())) {
			logger.debug("信用证项下为'Y'");
			// BPO勾选
			if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getContext()
					.getDataRepository().getOperationDataCollection()
					.getBcMntnOpDtl().getBpoFlg())) {
				logger.debug("BPO勾选");
				// Tenor为即期
				if (CollectionConstant.AT_SIGHT.equalsIgnoreCase(getContext()
						.getDataRepository().getOperationDataCollection()
						.getBcMntnOpDtl().getTenorType())) {
					logger.debug("Tenor为即期");
					// 即期
					bizType = BizTypeContract.BIZTYPECODE_2_1_31;
				} else {
					logger.debug("Tenor为远期");
					// 远期
					bizType = BizTypeContract.BIZTYPECODE_2_1_32;
				}
			} else {
				// BPO不勾选
				logger.debug("BPO不勾选");
				if (CollectionConstant.AT_SIGHT.equalsIgnoreCase(getContext()
						.getDataRepository().getOperationDataCollection()
						.getBcMntnOpDtl().getTenorType())) {
					logger.debug("Tenor为即期");
					// 即期
					bizType = BizTypeContract.BIZTYPECODE_2_1_29;
				} else {
					logger.debug("Tenor为远期");
					// 远期
					bizType = BizTypeContract.BIZTYPECODE_2_1_30;
				}
			}
		} else {
			logger.debug("信用证项下不为'Y'");
			// 信用证项下不为'Y'
			if (DataTypeConstant.DATA_TYPE_YES.equalsIgnoreCase(getContext()
					.getDataRepository().getOperationDataCollection()
					.getBcMntnOpDtl().getTsuFlg())) {
				logger.debug("TSU勾选");
				// TSU勾选
				if (CollectionConstant.AT_SIGHT.equalsIgnoreCase(getContext()
						.getDataRepository().getOperationDataCollection()
						.getBcMntnOpDtl().getTenorType())) {
					logger.debug("Tenor为即期");
					// 即期
					bizType = BizTypeContract.BIZTYPECODE_2_1_31;
				} else {
					logger.debug("Tenor为远期");
					// 远期
					bizType = BizTypeContract.BIZTYPECODE_2_1_32;
				}
			} else {
				// TSU不勾选
				logger.debug("TSU不勾选");
				if (CollectionConstant.AT_SIGHT.equalsIgnoreCase(getContext()
						.getDataRepository().getOperationDataCollection()
						.getBcMntnOpDtl().getTenorType())) {
					logger.debug("Tenor为即期");
					// 即期
					bizType = BizTypeContract.BIZTYPECODE_2_1_29;
				} else {
					logger.debug("Tenor为远期");
					// 远期
					bizType = BizTypeContract.BIZTYPECODE_2_1_30;
				}
			}
		}
		// 设置分行号
		branchNo = getContext().getBranchId();
		// 设置SeqenceObj值
		SeqenceObj seqObj = collectUtil.getSeqenceObject(bizType, branchNo);
		// 设置SeqRelation
		SeqRelation reqRelation = new SeqRelation(seqObj.getCollectNo() + "00",
				null);
		// 添加采号信息
		seqGenerate.add(reqRelation);

		// 将【DM：托收维护操作明细.T-Kind】的值设为取得的T-Kind
		getContext().getDataRepository().getOperationDataCollection()
				.getBcMntnOpDtl().setTKind(seqObj.getCollectValues()[0]);

		// 将【DM：托收维护操作明细.交易主参号】的值设为取得的交易主参号
		getContext().getDataRepository().getOperationDataCollection()
				.getBcMntnOpDtl()
				.setTxnPrmryRefNo(seqObj.getCollectValues()[1]);

		// 将【DM：托收维护操作明细.交易子参号】的值为“00”
		getContext().getDataRepository().getOperationDataCollection()
				.getBcMntnOpDtl()
				.setTxnSubRefNo(CollectionConstant.TXNSUBREFNO);

		// 将【DM：托收维护操作明细.登记日期】的值设为系统日期
		DateUtil bizDataUtil = (DateUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.I00300_UTIL_DATE);
		// 设置系统日期
		getContext().getDataRepository().getOperationDataCollection()
				.getBcMntnOpDtl().setRegDate(bizDataUtil.getNow());

		logger.debug("CollectionCollCreateHandler-seqGenerate end");
		// 返回采号信息集合
		return seqGenerate;
	}

	/**
	 * 点击采号时数据校验.
	 * 
	 * @return ErrorMsgContainer 错误信息容器
	 */
	@Override
	public void sequenceValidate(ErrorContainer errorContainer)
			throws BizException {
		logger.debug("CollectionCollCreateHandler-sequenceValidate start");
		// 取得tempObject
		DataObject tempObject = getContext().getDataRepository()
				.getTempDataObject();
		// 取得托收维护操作明细
		BcMntnOpDtl bcMntnOpDtl = getContext().getReqData();
		// 取得系统locale
		String locale = getContext().getSystemPara().getLocale();

		// 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）
		SpValidate82309801 spValidate82309801 = new SpValidate82309801(
				tempObject, locale);
		spValidate82309801.execute(bcMntnOpDtl, errorContainer);

		// 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）
		SpValidate82309802 spValidate82309802 = new SpValidate82309802(
				tempObject, locale);
		spValidate82309802.execute(bcMntnOpDtl, errorContainer);

		logger.debug("CollectionCollCreateHandler-sequenceValidate end");
	}

	/**
	 * 保存交易信息.
	 * 
	 * @return void
	 */
	public void updateRequestData() throws BizException {
		logger.debug("CollectionCollCreateHandler-updateRequestData start");
		BcMntnOpDtl bcMntnOpDtl = getContext().getDataRepository()
				.getOperationDataCollection().getBcMntnOpDtl();
		// 分行号设置
		bcMntnOpDtl.setBranchCode(getContext().getBranchId());

	    // 出口信用证维护操作明细分行号设置    
	    ExpLcMntnOpDtl expLcMntnOpDtl = getContext().getDataRepository()
				.getOperationDataCollection().getExpLcMntnOpDtl();
	    if (null != expLcMntnOpDtl){
	      expLcMntnOpDtl.setBranchCode(getContext().getBranchId());
	    }

	    // Combined LC维护操作明细分行号,交易参号设置
	    for (BbCombLcMntnOpDtl bbCombLcMntnOpDtl : 
	    		getContext().getDataRepository().getOperationDataCollection().getBbCombLcMntnOpDtlList()) {
	    	bbCombLcMntnOpDtl.setBranchCode(getContext().getBranchId());
            bbCombLcMntnOpDtl.setTKind(bcMntnOpDtl.getTKind());
            bbCombLcMntnOpDtl.setTxnPrmryRefNo(bcMntnOpDtl.getTxnSubRefNo());
            bbCombLcMntnOpDtl.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
	    }

	    // 寄单信息分行号,交易参号设置
	    for (DispchDocInfo dispchDocInfo : 
	    		getContext().getDataRepository().getOperationDataCollection().getDispchDocInfoForSaveList()) {
	    	dispchDocInfo.setBranchCode(getContext().getBranchId());
            dispchDocInfo.setTKind(bcMntnOpDtl.getTKind());
            dispchDocInfo.setTxnPrmryRefNo(bcMntnOpDtl.getTxnPrmryRefNo());
            dispchDocInfo.setTxnSubRefNo(bcMntnOpDtl.getTxnSubRefNo());
	    }

		// 当操作为保存时
		if (ComBizConstant.COMMON_ACTION_SAVE.equals(getContext()
				.getSystemPara().getAction())) {
			// 定义ErrorContainer
			ErrorContainer errorContainer = new ErrorContainer();
			// 获取tempObject
			DataObject tempObject = getContext().getDataRepository()
					.getTempDataObject();
			// 获取系统locale
			String locale = getContext().getSystemPara().getLocale();
			// 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）
			SpValidate82309801 spValidate82309801 = new SpValidate82309801(
					tempObject, locale);
			spValidate82309801.execute(bcMntnOpDtl, errorContainer);

			// 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）
			SpValidate82309802 spValidate82309802 = new SpValidate82309802(
					tempObject, locale);
			spValidate82309802.execute(bcMntnOpDtl, errorContainer);
		}

		// 更新【托收维护信息】的SmileExMethod信息
		getContext().getDataRepository().getOperationDataCollection()
				.updateBcMntnOpDtl();

		logger.debug("CollectionCollCreateHandler-updateRequestData end");
	}

	/**
	 * 自动触发访问者注册器
	 * 
	 * @throws BizException
	 */
	@Override
	protected void registTriggerVisitors() throws BizException {
		logger.debug("CollectionCollCreateHandler-registTriggerVisitors start");

		// 当信用证项下时，调用接口自动发起留行信用证的‘新建’操作，业务状态为‘留行完成’，操作为‘新建’，操作状态为‘完了’。
		if (getContext().getDataRepository().getOperationDataCollection()
				.isNeedToTrigLcKindle()) {
			logger.debug("【Hidden:发起留行】为‘Y’");
			getContext().registerVisitor(
					CollCommonKinLcredleTriggerVisitor.getInstance());
		}
		logger.debug("CollectionCollCreateHandler-registTriggerVisitors end");
	}

	/**
	 * 获取smile服务.
	 * 
	 * @return SmileInvocationInstructions smile服务信息
	 * 
	 */
	@Override
	public SmileInvocationInstructions getSmileInvocationInstructions(
			String smileServiceType) {
		logger
				.debug("CollectionCollCreateHandler-getSmileInvocationInstructions start");
		logger.debug("smileServiceType: " + smileServiceType);
		// 实例化SmileInvocationInstructions
		SmileInvocationInstructions instructions = new SmileInvocationInstructions();

		// simle调用时，是上传还是校验的判断方法待定
		if (ComBizConstant.SMILE_SERVICE_TYPE_CHECK.equals(smileServiceType)) {
			logger.debug("调用smile校验");
			// 设置本次调用服务ID
			instructions
					.setServiceId(CollectionConstant.SMILE_SERVICE_ID_COLLECTION_CHECK);
			// 设置本次调用服务类型
			instructions
					.setServiceType(SmileConstants.SMILE_SERVICE_TYPE_CHECK);
		} else {
			logger.debug("调用smile上传");
			// 设置本次调用服务ID
			instructions
					.setServiceId(CollectionConstant.SMILE_SERVICE_ID_COLLECTION_UPLOAD);
			// 设置本次调用服务类型
			instructions
					.setServiceType(SmileConstants.SMILE_SERVICE_TYPE_UPLOAD);
		}
		// 设置本次调用所属officeCode
		instructions.setOfficeCode(getContext().getBranchId());
		// 设置调用系统ID，按照分散运管给出值设置为常量
		instructions.setRequesterId(SmileConstants.SYS_ID_ART);
		// 设置调用系统名，对于ART来说，固定为ART
		instructions.setRequesterName(SmileConstants.SYS_NAME_ART);
		// 设置校验通用服务MA错误列表
		instructions.generateSmileTransInfoList(getContext());

		logger
				.debug("CollectionCollCreateHandler-getSmileInvocationInstructions end");
		// 返回instructions
		return instructions;
	}

	@Override
	protected void preSequenceValidate(ErrorContainer errorContainer)
			throws BizException {
	}
}
