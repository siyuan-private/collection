package cn.com.btmu.art.biz.collection.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0123;
import cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0123Impl;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.handler.AbstractComReportQueryHandler;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.biz.common01biz.util.PageCondUtil;
import cn.com.btmu.art.framework.dao.QueryModel;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.ppc.ICSVGenerator;
import cn.com.btmu.ppc.PPCCSVGenerator;

import commonj.sdo.DataObject;

public class Collection0123ReportHandler extends AbstractComReportQueryHandler {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 生成报表的CSV 将数据查出，拼成CSV字符串格式返回。
   * 
   * @return void
   */
  public void getCSV() {
    logger.debug("Collection0123ReportHandler-getCSV start");

    // 将数据查出,拼成CSV字符串格式返回.
    // 初始化当前页码
    int curPage = 0;
    // 初始化总页码
    int pageCount = 0;
    // 初始化记录No
    long recNo = 0;

    // 设置QueryModel
    QueryModel qm = new QueryModel();
    qm.setQueryObjectClass(QOCollection0123.class);
    qm.setPageCond(PageCondUtil.getPageCond());
    getContext().setQueryModel(qm);
    DataObject[] resultList = getResultListByQueryModel(BizDataFilter
        .getInstance());

    // 取得系统日期的方法
    DateUtil dateUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);

    // 新建CSV对象
    ICSVGenerator csv = new PPCCSVGenerator();

    // 设置CSV文件Head行
    //数据类型标识
    csv.add(ComBizConstant.COMMON_REPORT_HD);
    //帐票ID
    csv.add(ComBizConstant.COMMON_REPORT_ID_ONE_HUNDRED_TWENTY_THREE);
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
    //换行
    csv.newLine();

    // 以下设置CSV文件Data行（数据行，第二行开始）
    // 计算总页数(无分页逻辑则无需此处理)
    pageCount = (int) Math.ceil((double) resultList.length
        / ComBizConstant.COMMON_REPORT_MAX_RECORDS_CNT_FIFTEEN);

    for (DataObject qo : resultList) {
      QOCollection0123Impl  dojb = (QOCollection0123Impl) qo;
      recNo = recNo + 1;
      if (recNo == 1
          || recNo > ComBizConstant.COMMON_REPORT_MAX_RECORDS_CNT_FIFTEEN
              * curPage) {
        csv.newLine();
        //当前页
        curPage = curPage + 1;
        csv.add(ComBizConstant.COMMON_REPORT_DT);
        // 帐票页码,无分页逻辑则设置半角空格csv.add(" ");
        csv.add(ArtStringUtil.nullConvert(curPage));
        // 帐票总页数,无分页逻辑则设置半角空格csv.add(" ");
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
        // 快递寄单日
        csv.add(ArtStringUtil.nullConvert(dateUtil.toString(dateUtil.getNow(),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1)));
        // 合计件数
        csv.add(ArtStringUtil.nullConvert(resultList.length));
        // 打印时间
        csv.add(dateUtil.toString(dateUtil.getNow(),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN2));
        // 表格,添加组分隔符
        csv.addGroupDelimiter();
      }
      // 编号
      csv.add(ArtStringUtil.nullConvert(recNo));
      // 业务种类
      csv.add(ArtStringUtil.nullConvert(dojb.getBizType()));
      // 寄单种类
      csv.add(ArtStringUtil.nullConvert(dojb.getDispchDocType()));
      // 快递号码
      csv.add(ArtStringUtil.nullConvert(dojb.getExprsNo()));
      // 交易参号
      csv.add(ArtStringUtil.nullConvert(dojb.getTKind()) + ComBizConstant.COMMON_STRING_HYPHEN
          + ArtStringUtil.nullConvert(dojb.getTxnPrmryRefNo())
          + ComBizConstant.COMMON_STRING_HYPHEN
          + ArtStringUtil.nullConvert(dojb.getTxnSubRefNo()));
      // 收件人
      csv.add(ArtStringUtil.nullConvert(dojb.getRecpnt()));
      // 备注
      csv.add(ArtStringUtil.nullConvert(dojb.getRmrk()));
    }
    csv.newLine();
    // 报表结束符
    csv.end();

    // 最终将CSV字符串设置到ComReportQueryContext
    this.getContext().setReportCsv(csv.getCSV());

    logger.debug("Collection0123ReportHandler-getCSV end");
  }

  @Override
  public void afterProcessor() {

  }

}
