package cn.com.btmu.art.biz.collection.handler;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.handler.AbstractComReportQueryHandler;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.biz.common01biz.util.CurrencyUtil;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.ppc.ICSVGenerator;
import cn.com.btmu.ppc.PPCCSVGenerator;

import com.eos.foundation.data.DataObjectUtil;
import commonj.sdo.DataObject;

/**
 * 境内付款承兑通知书(出口转让用)报表用handler
 * 
 * 帐票ID 0116
 */
public class Collection0116ReportHandler extends AbstractComReportQueryHandler {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public void getCSV() {
    logger.debug("Collection0116ReportHandler-getCSV start");

    // 将数据查出，拼成CSV字符串格式返回
    // 取得查询条件
    String[] conditions = (String[]) getContext().getObjectVO();

    // 查询结果
    DataObject[] resultList;
    //定义查询条件
    List<String> condition;
    // 新建CSV对象
    ICSVGenerator csv = new PPCCSVGenerator();

    // 取得系统日期的方法
    DateUtil dateUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);
    //获取币种转换工具类
    CurrencyUtil currencyUtil = (CurrencyUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00291_UTIL_CURRENCY);

    // 设置CSV文件Head行
    //帐票类型
    csv.add(ComBizConstant.COMMON_REPORT_HD);
    //帐票ID
    csv.add(ComBizConstant.COMMON_REPORT_ID_ONE_HUNDRED_SIXTEEN);
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
    for (String cond : conditions) {
      // 分割报表的查询条件 "|_|"
      condition = Arrays.asList(cond
          .split(ComBizConstant.COMMON_REPORT_CONDITION_SEPARATORSTR));
      //定义用于存放查询条件的类
      DataObject param = DataObjectUtil
          .createDataObject(ComBizConstant.COMMON_STRING_DATAOBJECT);
      //查询条件 转让编号-TKind
      param
          .setString(NoticeLetterConstant.QOFIELD_TRASFTKIND, condition.get(0));
      //查询条件 转让编号-交易主参号
      param.setString(NoticeLetterConstant.QOFIELD_TRASFNOPRMRYREFNO, condition
          .get(1));
      //查询条件 转让编号-交易子参号
      param.setString(NoticeLetterConstant.QOFIELD_TRASFNOSUBREFNO, condition
          .get(2));
      //查询条件 分行号 TODO
//      param.setString("branchcode", getContext().getSystemPara().getBranchID());
      param.setString("branchcode","676");
      logger.debug(getContext().getSystemPara().getBranchID());
      //设置NameSQL查询条件
      getContext().setNamingSQLConditions(param);

      // 调用NameSQL查询报表数据
      resultList = getResultListByNamedSQL(CollectionConstant.COLLECT_0116REPORT_NAMEDSQL_ID);

      // 设置CSV文件Data行（数据行，第二行开始）

      // 数据类型标识
      csv.add(ComBizConstant.COMMON_REPORT_DT);

      // 帐票页码
      csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

      // 帐票总页数
      csv.add(ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE);

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
      for (DataObject dojb : resultList) {

        // 日期 打印时的系统日期
        csv.add(dateUtil.toString(dateUtil.getNow(),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1));
        // 结算方式
        csv.add(dojb.getString(0));
        csv.add(dojb.getString(1));
        csv.add(dojb.getString(2));
        // 信用证编号
        csv.add(ArtStringUtil.nullConvert(dojb.getString(3)));
    
        // 来单币种及金额
        String tempString = ArtStringUtil.nullConvert(dojb.getString(4));
        csv.add(tempString
            + ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE
            + ArtStringUtil.nullConvert(currencyUtil
                .formatMoney(tempString, dojb.getBigDecimal(5))));

        // 开证日期
        csv.add(ArtStringUtil.nullConvert(dateUtil.toString(dojb.getDate(6),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1)));

        // 索汇币种及金额
        tempString = ArtStringUtil.nullConvert(dojb.getString(7));
        csv.add(tempString
            + ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE
            + ArtStringUtil.nullConvert(currencyUtil
                .formatMoney(tempString, dojb.getBigDecimal(8))));

        // 期限
        csv.add(ArtStringUtil.nullConvert(dojb.getString(9)));
        
        // 到期日 10
        csv.add(ArtStringUtil.nullConvert(dateUtil.toString(dojb.getDate(10),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1)));

        // 来单行名称
        csv.add(ArtStringUtil.nullConvert(dojb.getString(11)));

        // 来单行编号
        csv.add(ArtStringUtil.nullConvert(dojb.getString(12)));

        // 收款人名称
        csv.add(ArtStringUtil.nullConvert(dojb.getString(13)));

        // 收款行名称及地址
        csv.add(ArtStringUtil.nullConvert(dojb.getString(14)));

        // 付款人名称
        csv.add(ArtStringUtil.nullConvert(dojb.getString(15)));

        // 对公
        csv.add(ArtStringUtil.nullConvert(dojb.getString(16)));

        // 组织代码机构
        csv.add(ArtStringUtil.nullConvert(dojb.getString(17)) + ArtStringUtil.nullConvert(dojb.getString(18)));

        // 对私
        csv.add(ArtStringUtil.nullConvert(dojb.getString(19)));

        // 个人身份证号码 20
        csv.add(ArtStringUtil.nullConvert(dojb.getString(20)));

        // 中国居民个人 非个人
        csv.add(ArtStringUtil.nullConvert(dojb.getString(21)));
        csv.add(ArtStringUtil.nullConvert(dojb.getString(22)));

        // 提运单/货运单据号
        csv.add(ArtStringUtil.nullConvert(dojb.getString(23)));

        // 合同号
        csv.add(ArtStringUtil.nullConvert(dojb.getString(24)));

        // 发票号
        csv.add(ArtStringUtil.nullConvert(dojb.getString(25)));

        // 扣币金额及币种
        tempString = ArtStringUtil.nullConvert(dojb.getString(26));
        csv.add(tempString
            + ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE
            + ArtStringUtil.nullConvert(currencyUtil.formatMoney(tempString, dojb
                .getBigDecimal(27))));

        // 合同金额币种
        tempString = ArtStringUtil.nullConvert(dojb.getString(28));
        csv.add(tempString
            + ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE
            + ArtStringUtil.nullConvert(currencyUtil.formatMoney(tempString, dojb
                .getBigDecimal(29))));

        // Shipped on 装船日
        csv.add(ArtStringUtil.nullConvert(dateUtil.toString(dojb.getDate(30),
            ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1)));

        // From从
        csv.add(ArtStringUtil.nullConvert(dojb.getString(31)));

        // To至 32
        csv.add(ArtStringUtil.nullConvert(dojb.getString(32)));

        // Other Name1
        csv.add(ArtStringUtil.nullConvert(dojb.getString(33)));

        // Other Name2
        csv.add(ArtStringUtil.nullConvert(dojb.getString(34)));

        // Other Name3
        csv.add(ArtStringUtil.nullConvert(dojb.getString(35)));

        // Draft（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(36)));

        // Inv.（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(37)));
        // B/L,AWB,C/R1（1st） 38
        csv.add(ArtStringUtil.nullConvert(dojb.getString(38)));

        // B/L,AWB,C/R2（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(39)));

        // Ins.Pol./Cert.（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(40)));

        // P/L（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(41)));

        // Origin（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(42)));

        // Quality（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(43)));

        // Quantity（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(44)));

        // Non-wood（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(45)));

        // Inspect（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(46)));

        // Cert.（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(47)));

        // Other Value1（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(48)));

        // Other Value2（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(49)));

        // Other Value3（1st）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(50)));

        // Draft（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(51)));

        // Inv.（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(52)));

        // B/L,AWB,C/R1（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(53)));

        // B/L,AWB,C/R2（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(54)));

        // Ins.Pol./Cert.（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(55)));

        // P/L（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(56)));

        // Origin（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(57)));

        // Quality（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(58)));

        // Quantity（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(59)));

        // Non-wood（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(60)));

        // Inspect（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(61)));

        // Cert.（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(62)));

        // Other Value1（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(63)));

        // Other Value2（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(64)));

        // Other Value3（2nd）
        csv.add(ArtStringUtil.nullConvert(dojb.getString(65)));

        // Remarks 备注
        csv.add(ArtStringUtil.nullConvert(dojb.getString(66)));

        // Late Shipment 晚装船 √
        csv.add(ArtStringUtil.nullConvert(dojb.getString(67)));

        // Late Presentation 晚交单
        csv.add(ArtStringUtil.nullConvert(dojb.getString(68)));

        // L/C Expired 信用证过有效期
        csv.add(ArtStringUtil.nullConvert(dojb.getString(69)));

        // Overdrawn by 超金额选项
        csv.add(dojb.getString(70));

        // Overdrawn by 超金额
        tempString = ArtStringUtil.nullConvert(dojb.getString(71));
        csv.add(tempString
            + ComBizConstant.COMMON_STRING_HALF_WIDTH_SPACE
            + ArtStringUtil.nullConvert(currencyUtil.formatMoney(tempString, dojb
                .getBigDecimal(72))));

        // Additional Discrepancies 其他选项
        csv.add(ArtStringUtil.nullConvert(dojb.getString(73)));
        // 其他 74
        csv.add(ArtStringUtil.nullConvert(dojb.getString(74)));
      }
      //换行
      csv.newLine();
    }
    //换行
    csv.newLine();

    // 报表结束
    csv.end();

    // 最终将CSV字符串设置到ComReportQueryContext
    getContext().setReportCsv(csv.getCSV());

    logger.debug("Collection0116ReportHandler-getCSV end");
  }

  @Override
  public void afterProcessor() {

  }
}
