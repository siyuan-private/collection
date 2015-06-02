package cn.com.btmu.art.biz.collection.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118;
import cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0118Impl;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.handler.AbstractComReportQueryHandler;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.biz.common01biz.util.CurrencyUtil;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.biz.common01biz.util.PageCondUtil;
import cn.com.btmu.art.framework.dao.QueryModel;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.ppc.ICSVGenerator;
import cn.com.btmu.ppc.PPCCSVGenerator;

import commonj.sdo.DataObject;

public class Collection0118ReportHandler extends AbstractComReportQueryHandler {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public void getCSV() {
    logger.debug("Collection0118ReportHandler-getCSV start");

    // 初始化当前页码
    int curPage = 0;

    // 初始化总页码
    int pageCount = 0;

    // 初始化记录No
    long recNo = 0;
    //设置QueryModel
    QueryModel qm = new QueryModel();
    qm.setQueryObjectClass(QOCollection0118.class);
    qm.setPageCond(PageCondUtil.getPageCond());
    getContext().setQueryModel(qm);
    
    DataObject[] resultList = getResultListByQueryModel(BizDataFilter
        .getInstance());

    // 取得系统日期的方法
    DateUtil dateUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);

    CurrencyUtil currencyUtil = (CurrencyUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00291_UTIL_CURRENCY);

    // 新建CSV对象
    ICSVGenerator csv = new PPCCSVGenerator();

    // 设置CSV文件Head行
    //数据类型标识
    csv.add(ComBizConstant.COMMON_REPORT_HD);
    //帐票ID
    csv.add(ComBizConstant.COMMON_REPORT_ID_ONE_HUNDRED_EIGHTEEN);
    //帐票保存路径
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    //帐票总页数
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    //帐票总CIF数
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    //帐票作成日期
    csv.add(dateUtil.toString(dateUtil.getNow(),
        ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
    //处理类型标志
    csv.add(ComBizConstant.COMMON_REPORT_TYPE_FLG_ONE);
    //打印机编号
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    //封装机编号
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    //预留控制位1
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    //预留控制位2
    csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);
    
    // 计算总页数
    pageCount = (int) Math.ceil((double) resultList.length
        / ComBizConstant.COMMON_REPORT_MAX_RECORDS_CNT_FIFTEEN);
    
    for (DataObject qo : resultList) {
      QOCollection0118Impl  dojb = (QOCollection0118Impl) qo;
      recNo = recNo + 1;
      if (recNo == 1
          || recNo > ComBizConstant.COMMON_REPORT_MAX_RECORDS_CNT_FIFTEEN
              * curPage) {
        csv.newLine();
        //当前页数
        curPage = curPage + 1;
        //数据类型标识
        csv.add(ComBizConstant.COMMON_REPORT_DT);

        // 帐票页码
        csv.add(ArtStringUtil.nullConvert(curPage));

        // 帐票总页数
        csv.add(ArtStringUtil.nullConvert(pageCount));

        // JOBID
        csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

        // 信封页码
        csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

        // 信封总页数
        csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

        // 分割条件数据
        csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

        // SEQ号
        csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

        // 报表日期
        csv.add(dateUtil.toString(dateUtil.getNow(),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));

        // 合计件数
        csv.add(Integer.toString(resultList.length));

        // 打印时间
        csv.add(dateUtil.toString(dateUtil.getNow(),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN2));

        // 表格,添加组分隔符
        csv.addGroupDelimiter();
      }

      // 编号
      csv.add(ArtStringUtil.nullConvert(recNo));

      // 交易参号
      csv.add(ArtStringUtil.nullConvert(dojb.getTKind()) + ComBizConstant.COMMON_STRING_HYPHEN
          + ArtStringUtil.nullConvert(dojb.getTxnPrmryRefNo()));
      

      // 受益人名称
      
      csv.add(ArtStringUtil.nullConvert(dojb.getBeneName()));

      // 汇票金额
      csv.add(ArtStringUtil.nullConvert(dojb.getBxCcy())
          + ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE
          + currencyUtil.formatMoney(ArtStringUtil.nullConvert(dojb.getBxCcy()), dojb.getBxAmt()));

      // Reason 固定值 C
      csv.add(CollectionConstant.REPORTHANDLER_C);
    }

    csv.newLine();
    // 报表结束符
    csv.end();

    // 最终将CSV字符串设置到ComReportQueryContext
    this.getContext().setReportCsv(csv.getCSV());

    logger.debug("Collection0118ReportHandler-getCSV end");
  }

  @Override
  public void afterProcessor() {

  }

}
