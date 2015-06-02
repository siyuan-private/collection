package cn.com.btmu.art.biz.collection.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.handler.AbstractComExportExcelBizHandler;
import cn.com.btmu.art.biz.common01biz.util.CurrencyUtil;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.component.dict.DataDictionaryUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/**
 * NoticeLetterExportBizHandler
 * 
 * 通知书打印By业务查询时,Excel导出用Handler.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class NoticeLetterExportBizHandler extends
    AbstractComExportExcelBizHandler {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 取得导出列名称
   * 
   * @return List 导出列名称列表
   */
  @Override
  protected List<String> getColumnNames() {
    logger.debug("NoticeLetterExportBizHandler-getColumnNames start");

    //定义要导出的列名集合
    List<String> queryClmNm = new ArrayList<String>();

    //国际化标签bean取得
    I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
    String local = getContext().getSystemPara().getLocale();

    //种类
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_02341));

    //转让编号
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        NoticeLetterConstant.LABEL_823_10001));

    //登记日
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_01186));

    //结算方式
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_01551));

    //信用证编号
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_02151));

    //来单金额
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        NoticeLetterConstant.LABEL_823_10003));

    //期限
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_01764));

    //到期日
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_01182));

    //第二受益人
    queryClmNm.add(i18nUtil.getI18nMessage(local,
        LabelComConstant.LABEL_COM_01193));

    logger.debug("NoticeLetterExportBizHandler-getColumnNames end");
    return queryClmNm;
  }

  /**
   * 取得导出数据
   * 
   * @return List 导出列名称列表
   */
  protected List<String> getExportData(DataObject result) {
    logger.debug("NoticeLetterExportBizHandler-getExportData start");

    //定义要导出的数据集合
    List<String> exportData = new ArrayList<String>();

    //数据字典字段显示值转换
    DataDictionaryUtil dataDictUtil = (DataDictionaryUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90340_UTIL_DATADICTIONARY);

    //取得日期的方法
    DateUtil dateUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);

    //币种信息转换工具类取得
    CurrencyUtil currencyUtil = (CurrencyUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00291_UTIL_CURRENCY);

    //将结果强制转换为QONoticeLetterBiz类型
    QONoticeLetterBiz biz = (QONoticeLetterBiz) result;

    //种类
    exportData
        .add(dataDictUtil.getValue(biz.getNoticeLetterType(),
            NoticeLetterConstant.TYPE_ID, getContext().getSystemPara()
                .getLocale()));

    //转让编号
    exportData.add(biz.getTrasfTKind() + ComBizConstant.COMMON_STRING_HYPHEN
        + biz.getTrasfNoPrmryRefNo() + ComBizConstant.COMMON_STRING_HYPHEN
        + biz.getTrasfNoSubRefNo());

    //登记日
    exportData.add(dateUtil.toString(biz.getRegDate()));

    //结算方式
    exportData.add(dataDictUtil.getValue(biz.getStlmtMeth(),
        NoticeLetterConstant.DIC_ID, getContext().getSystemPara().getLocale()));

    //信用证编号
    exportData.add(biz.getLcNo());
    
    //来单金额
    exportData.add(biz.getDocRecvdCcy() + ComBizConstant.COMMON_STRING_HYPHEN
        + currencyUtil.formatMoney(biz.getDocRecvdCcy(), biz.getDocRecvdAmt()));
    
    //期限
    exportData.add(biz.getTerm());
    
    //第二受益人
    exportData.add(biz.getPayeeName());
    
    logger.debug("NoticeLetterExportBizHandler-getExportData end");
    //返回结果
    return exportData;
  }

  /**
   * 取得查询策略.
   * 
   * @return IQueryStrategy
   */
  @Override
  protected IQueryStrategy getQueryStrategy() {
    //返回查询策略
    return new QueryModelStrategy();
  }

}
