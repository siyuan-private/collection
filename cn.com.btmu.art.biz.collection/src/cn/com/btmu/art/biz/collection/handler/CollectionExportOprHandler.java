package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionOpr;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.handler.AbstractComExportExcelOperationHandler;
import cn.com.btmu.art.biz.common01biz.util.CurrencyUtil;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.component.dict.DataDictionaryUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/**
 * CollectionExportOprHandler
 * 
 * 托收By操作查询时,Excel导出用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionExportOprHandler extends
		AbstractComExportExcelOperationHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 取得导出列名称
	 * 
	 * @return List 导出列名称列表
	 */
	protected List<String> getColumnNames() {
		logger.debug("CollectionExportOprHandler-getColumnNames start");
		// 定义要导出列名的集合
		List<String> queryClmNm = new ArrayList<String>();
		// 国际化标签bean取得
		I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
		String local = getContext().getSystemPara().getLocale();

		// 交易参号.T-kind + "-" + 交易参号.主参号 + "-" + 交易参号.子参号
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00003));
		// 信用证项下
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02158));
		// BPO
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00220));
		// TSU
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00872));
		// P.P. NEGO
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00675));
		// 电报议付
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01200));
		// 电报议付销号日期
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01201));
		// 备注
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00968));
		// 受益人.客户CIF + "-" + 受益人.客户名称
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00004));
		// 汇票金额.币种 + "-" + 汇票金额.金额
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00005));
		// Tenor.种类
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00844));
		// 假远期
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01525));
		// 发票编号
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01274));
		// 托收日期
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02066));
		// 到期日期
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01184));
		// 信用证信息-->
		// 信用证编号
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02151));
		// 信用证余额.币种 + "-" + 信用证余额.金额
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00027));
		// 进口商名称
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01588));
		// OSA/NRA
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00631));
		// 寄单行.名称
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01720));
		// 偿付行.名称
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01720));
		// 履行保兑责任
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01704));
		// 国内信用证
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01404));

		// 非信用证信息-->
		// 进口商名称
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01588));
		// OSA/NRA
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00631));
		// 寄单行.名称
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00012));
		// 单据信息-->
		// 国别
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01399));
		// 拒付编号
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01598));
		// 故障编号
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01368));
		// 承兑登记日
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01055));
		// 承兑到期日
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01052));
		// 承兑备注
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01051));
		// 退改单
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02048));
		// 原因
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02274));
		// 备注
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_00968));
		// 头寸日
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02044));
		// 头寸金额.币种 + "-" + 头寸金额.金额
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00013));
		// 我行对客入账日
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_02097));
		// 他行扣款金额.币种 + "-" + 他行扣款金额.金额
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				CollectionConstant.LABEL_823_00014));
		// 入账备注
		queryClmNm.add(i18nUtil.getI18nMessage(local,
				LabelComConstant.LABEL_COM_01826));

		logger.debug("CollectionExportOprHandler-getColumnNames end");
		// 返回导出列名
		return queryClmNm;
	}

	/**
	 * 取得导出数据
	 * 
	 * @param resultList
	 *            查询结果
	 * @return List 导出列名称列表
	 */
	protected List<String> getExportData(DataObject result) {
		logger.debug("CollectionExportOprHandler-getExportData start");
		// 定义导出数据集合
		List<String> exportData = new ArrayList<String>();

		// 数据字典字段显示值转换
		DataDictionaryUtil dataDictUtil = (DataDictionaryUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.E90340_UTIL_DATADICTIONARY);

		// 取得日期的方法
		DateUtil dateUtil = (DateUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.I00300_UTIL_DATE);
		// 币种转换工具类
		CurrencyUtil currencyUtil = (CurrencyUtil) FactoryBeanUtil
				.getBean(BizBeanNameConst.I00291_UTIL_CURRENCY);
		// 将结果强制转换为QOCollectionOpr类型
		QOCollectionOpr opr = (QOCollectionOpr) result;
		// 交易参号.T-kind + "-" + 交易参号.主参号 + "-" + 交易参号.子参号
		exportData.add(opr.getTKind() + ComBizConstant.COMMON_STRING_HYPHEN
				+ opr.getTxnPrmryRefNo() + ComBizConstant.COMMON_STRING_HYPHEN
				+ opr.getTxnSubRefNo());
		// 信用证项下
		exportData.add(opr.getLcFlg());
		// BPO
		exportData.add(opr.getBpoFlg());
		// TSU
		exportData.add(opr.getTsuFlg());
		// P.P. NEGO
		exportData.add(opr.getPpnegoFlg());
		// 电报议付
		exportData.add(opr.getTelegNegoFlg());
		// 电报议付销号日期
		exportData.add(dateUtil.toString(opr.getTelegNegoClsDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
		// 备注
		exportData.add(opr.getBcRmrk());

		// 受益人.客户CIF + "-" + 受益人.客户名称
		exportData.add(opr.getBeneCif() + ComBizConstant.COMMON_STRING_HYPHEN
				+ opr.getBeneName());

		// 汇票金额.币种 + "-" + 汇票金额.金额
		exportData.add(opr.getBxCcy() + ComBizConstant.COMMON_STRING_HYPHEN
				+ currencyUtil.formatMoney(opr.getBxCcy(), opr.getBxAmt()));
		// Tenor.种类
		exportData.add(dataDictUtil.getValue(opr.getTenorType(),
				CollectionConstant.DICT_TENORTYPE, getContext().getSystemPara()
						.getLocale()));
		// 假远期
		exportData.add(opr.getFakeForwdFlg());
		// 发票编号
		exportData.add(opr.getIvcNo());
		// 托收日期
		exportData.add(dateUtil.toString(opr.getCollDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
		// 到期日期
		exportData.add(dateUtil.toString(opr.getDueDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
		// 信用证信息-->
		// 信用证编号
		exportData.add(opr.getLcNo());

		// 信用证余额.币种 + "-" + 信用证余额.金额
		exportData.add(opr.getLcBalCcy()
				+ ComBizConstant.COMMON_STRING_HYPHEN
				+ currencyUtil
						.formatMoney(opr.getLcBalCcy(), opr.getLcBalAmt()));

		// 进口商名称
		exportData.add(opr.getExpImptrName());
		// OSA/NRA
		exportData.add(opr.getExpOsa());
		// 寄单行.名称
		exportData.add(opr.getExpDispch());
		// 偿付行.名称
		exportData.add(opr.getReimbBankName());
		// 履行保兑责任
		exportData.add(opr.getPerfmConfmDuties());
		// 国内信用证
		exportData.add(opr.getDomstcLcFlg());

		// 非信用证信息-->
		// 进口商名称
		exportData.add(opr.getBcImptrName());
		// OSA/NRA
		exportData.add(opr.getBcOsa());
		// 寄单行.名称
		exportData.add(opr.getNonExpDispch());
		// 单据信息-->
		// 国别
		exportData.add(opr.getNatnlty());
		// 拒付编号
		exportData.add(opr.getDishnrTKind()
				+ ComBizConstant.COMMON_STRING_HYPHEN + opr.getDishnrTxnTKind()
				+ ComBizConstant.COMMON_STRING_HYPHEN + opr.getDishnrNo());
		// 故障编号
		exportData.add(opr.getFaultTKind()
				+ ComBizConstant.COMMON_STRING_HYPHEN + opr.getFaultTxnTKind()
				+ ComBizConstant.COMMON_STRING_HYPHEN + opr.getFaultNo());
		// 承兑登记日
		exportData.add(dateUtil.toString(opr.getAccptceRegDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
		// 承兑到期日
		exportData.add(dateUtil.toString(opr.getAccptceDueDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
		// 承兑备注
		exportData.add(opr.getAccptceRmrk());
		// 退改单
		exportData.add(dataDictUtil.getValue(opr.getMaintType(),
				CollectionConstant.DICT_BBMAINTTYPE, getContext()
						.getSystemPara().getLocale()));
		// 原因
		exportData.add(opr.getResn());
		// 备注
		exportData.add(opr.getModChgbkRmrk());
		// 头寸日
		exportData.add(dateUtil.toString(opr.getPosDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));

		// 头寸金额.币种 + "-" + 头寸金额.金额
		exportData.add(opr.getPosCcy() + ComBizConstant.COMMON_STRING_HYPHEN
				+ currencyUtil.formatMoney(opr.getPosCcy(), opr.getPosAmt()));

		// 我行对客入账日
		exportData.add(dateUtil.toString(opr.getOurBankToCustBookingDate(),
				ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));

		// 他行扣款金额.币种 + "-" + 他行扣款金额.金额
		exportData.add(opr.getTheirDedctCcy()
				+ ComBizConstant.COMMON_STRING_HYPHEN
				+ currencyUtil.formatMoney(opr.getTheirDedctCcy(), opr
						.getTheirDedctAmt()));

		// 入账备注
		exportData.add(opr.getAccptceRmrk());

		logger.debug("CollectionExportOprHandler-getExportData end");
		// 返回导出数据集合
		return exportData;
	}

	/**
	 * 取得查询策略.
	 * 
	 * @return IQueryStrategy
	 */
	@Override
	protected IQueryStrategy getQueryStrategy() {
		// 返回查询策略
		return new QueryModelStrategy();
	}
}
