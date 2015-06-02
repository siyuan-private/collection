package cn.com.btmu.art.biz.collection.databuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz;
import cn.com.btmu.art.biz.collection.vo.BillOfCollectionQueryVO;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.context.ComQueryContext;
import cn.com.btmu.art.component.dict.DataDictionaryUtil;
import cn.com.btmu.art.framework.biz.databuilder.impl.BaseDataBuilder;
import cn.com.btmu.art.framework.config.element.FieldMappingConfigElement;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.dao.QueryModel;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import com.eos.system.utility.StringUtil;

/**
 * BillOfClctQueryByBizDataBuilder
 * 
 * 托收一览业务查询数据转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionQueryByBizDataBuilder extends
    BaseDataBuilder<ComQueryContext, BillOfCollectionQueryVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo
   *            画面数据VO
   * @param fieldMap
   *            VO与PO字段映射关系Map
   * @param context
   *            上下文信息
   */
  public void buildInput(BillOfCollectionQueryVO vo,
      FieldMappingConfigElement fieldMap, ComQueryContext context) {
    logger.debug("CollectionQueryByBizDataBuilder-buildInput start");
    // 当vo等于null时，直接返回
    if (vo == null) {
      logger.debug("VO为空校验");
      logger.debug("CollectionQueryByBizDataBuilder-buildInput end");
      return;
    }
    // 从context中取得QM
    QueryModel qm = context.getQueryModel();

    // 设置查询模板的
    qm.setQueryObjectClass(QOCollectionBiz.class);

    // 设置查询条件
    // 当vo.业务状态不等于空时，qm.业务状态 = vo.业务状态
    if (StringUtil.isNotEmpty(vo.getCommonBizStatus())) {
      qm.queryExprEqual(ComBizConstant.COMMON_BIZ_STATUS, vo
          .getCommonBizStatus());
    }

    // 当vo.操作不等于空时，qm.操作 = vo.操作
    if (StringUtil.isNotEmpty(vo.getCommonOper())) {
      qm.queryExprEqual(ComBizConstant.COMMON_OPER, vo.getCommonOper());
    }

    // 当vo.操作状态不等于空时，qm.操作状态 = vo.操作状态
    if (StringUtil.isNotEmpty(vo.getCommonOperStatus())) {
      qm.queryExprEqual(ComBizConstant.COMMON_OPER_STATUS, vo
          .getCommonOperStatus());
    }

    // 当vo.定价状态不等于空时，qm.定价状态 = vo.定价状态
    if (StringUtil.isNotEmpty(vo.getCommonPriceStatus())) {
      qm.queryExprEqual(ComBizConstant.COMMON_PRICE_STATUS, vo
          .getCommonPriceStatus());
    }

    // 当vo.交易参号T-kind不等于空时，qm.交易参号T-kind = vo.交易参号T-kind
    if (StringUtil.isNotEmpty(vo.getTkind())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_TKIND, vo.getTkind());
    }

    // 当vo.交易参号主参号不等于空时，qm.交易参号主参号 = vo.交易参号主参号
    if (StringUtil.isNotEmpty(vo.getTxnPrmryRefNo())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_TXNPRMRYREFNO, vo
          .getTxnPrmryRefNo());
    }

    // 当vo.交易参号子参号不等于空时，qm.交易参号子参号 = vo.交易参号子参号
    if (StringUtil.isNotEmpty(vo.getTxnSubRefNo())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_TXNSUBREFNO, vo
          .getTxnSubRefNo());
    }

    // 当vo.托收日期From、to不等于空时，qm.托收日期 Between vo.托收日期From and vo.托收日期to
    if (vo.getCollDateFrom() != null && vo.getCollDateTo() != null) {
      qm.queryExprBetween(CollectionConstant.QOFIELD_COLLDATE, vo
          .getCollDateFrom(), vo.getCollDateTo());
    } else if (vo.getCollDateFrom() != null) {
      // 当vo.托收日期From不等于空时，qm.托收日期 >= vo.托收日期From
      qm.queryExprGE(CollectionConstant.QOFIELD_COLLDATE, vo.getCollDateFrom());
    } else if (vo.getCollDateTo() != null) {
      // 当vo.托收日期to不等于空时，qm.托收日期 <= vo.托收日期to
      qm.queryExprLE(CollectionConstant.QOFIELD_COLLDATE, vo.getCollDateTo());
    }

    // 当vo.受益人.客户CIF不等于空时，qm.客户CIF = vo.客户CIF
    if (StringUtil.isNotEmpty(vo.getBeneCif())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_BENECIF, vo.getBeneCif());
    }

    // 当vo.受益人.客户名称不等于空时，qm.客户名称 LIKE % + vo.客户名称 + %
    if (StringUtil.isNotEmpty(vo.getBeneName())) {
      qm.queryExprLike(CollectionConstant.QOFIELD_BENENAME,
          ComBizConstant.COMMON_STRING_PERCENT + vo.getBeneName()
              + ComBizConstant.COMMON_STRING_PERCENT);
    }

    // 当vo.汇票金额币种不等于空时，qm.汇票金额币种 = vo.汇票金额币种
    if (StringUtil.isNotEmpty(vo.getBxCcy())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_BXCCY, vo.getBxCcy());
    }

    // 当vo.汇票金额From、to不等于空时，qm.汇票金额 Between vo.汇票金额From and vo.汇票金额to
    if (vo.getBxAmtFrom() != null && vo.getBxAmtTo() != null) {
      qm.queryExprBetween(CollectionConstant.QOFIELD_BXAMT, vo.getBxAmtFrom(),
          vo.getBxAmtTo());
    } else if (vo.getBxAmtFrom() != null) {
      // 当vo.汇票金额From不等于空时，qm.汇票金额 >= vo.汇票金额From
      qm.queryExprGE(CollectionConstant.QOFIELD_BXAMT, vo.getBxAmtFrom());
    } else if (vo.getBxAmtTo() != null) {
      // 当vo.汇票金额to不等于空时，qm.汇票金额 <= vo.汇票金额to
      qm.queryExprLE(CollectionConstant.QOFIELD_BXAMT, vo.getBxAmtTo());
    }

    // 当vo.发票编号 不等于空时，qm.发票编号 = vo.发票编号
    if (StringUtil.isNotEmpty(vo.getIvcNo())) {
      qm.queryExprLike(CollectionConstant.QOFIELD_IVCNO, vo.getIvcNo()
          + ComBizConstant.COMMON_STRING_PERCENT);
    }

    // 当vo.信用证编号 不等于空时，qm.信用证编号 = vo.信用证编号
    if (StringUtil.isNotEmpty(vo.getLcNo())) {
      qm.queryExprLike(CollectionConstant.QOFIELD_LCNO, vo.getLcNo()
          + ComBizConstant.COMMON_STRING_PERCENT);
    }

    // 当vo.履行保兑责任 不等于空时，qm.履行保兑责任 = vo.履行保兑责任
    if (StringUtil.isNotEmpty(vo.getPerfmConfmDuties())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_PERFMCONFMDUTIES, vo
          .getPerfmConfmDuties());
    }

    // 当vo.国内信用证 不等于空时，qm.国内信用证 = vo.国内信用证
    if (StringUtil.isNotEmpty(vo.getDomstcLcFlg())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_DOMSTCLCFLG, vo
          .getDomstcLcFlg());
    }

    // 当vo.承兑登记日From、to不等于空时，qm.承兑登记日 Between vo.承兑登记日From and vo.承兑登记日to
    if (vo.getAccptceRegDateFrom() != null && vo.getAccptceRegDateTo() != null) {
      qm.queryExprBetween(CollectionConstant.QOFIELD_ACCPTCEREGDATE, vo
          .getAccptceRegDateFrom(), vo.getAccptceRegDateTo());
    } else if (vo.getAccptceRegDateFrom() != null) {
      // 当vo.承兑登记日From不等于空时，qm.承兑登记日 >= vo.承兑登记日From
      qm.queryExprGE(CollectionConstant.QOFIELD_ACCPTCEREGDATE, vo
          .getAccptceRegDateFrom());
    } else if (vo.getAccptceRegDateTo() != null) {
      // 当vo.承兑登记日to不等于空时，qm.承兑登记日 <= vo.承兑登记日to
      qm.queryExprLE(CollectionConstant.QOFIELD_ACCPTCEREGDATE, vo
          .getAccptceRegDateTo());
    }

    // 当vo.我行对客入账日From、to不等于空时，qm.我行对客入账日 Between vo.我行对客入账日From and vo.我行对客入账日to
    if (vo.getOurBankToCustBookingDateFrom() != null
        && vo.getOurBankToCustBookingDateTo() != null) {
      qm.queryExprBetween(CollectionConstant.QOFIELD_OURBANKTOCUSTBOOKINGDATE,
          vo.getOurBankToCustBookingDateFrom(), vo
              .getOurBankToCustBookingDateTo());
    } else if (vo.getAccptceRegDateFrom() != null) {
      // 当vo.我行对客入账日From不等于空时，qm.我行对客入账日 >= vo.我行对客入账日From
      qm.queryExprGE(CollectionConstant.QOFIELD_OURBANKTOCUSTBOOKINGDATE, vo
          .getOurBankToCustBookingDateFrom());
    } else if (vo.getAccptceRegDateTo() != null) {
      // 当vo.我行对客入账日to不等于空时，qm.我行对客入账日 <= vo.我行对客入账日to
      qm.queryExprLE(CollectionConstant.QOFIELD_OURBANKTOCUSTBOOKINGDATE, vo
          .getOurBankToCustBookingDateTo());
    }

    // 当vo.退改单登记日From、to不等于空时，qm.退改单登记日 Between vo.退改单登记日From and vo.退改单登记日to
    if (vo.getRegDateFrom() != null && vo.getRegDateTo() != null) {
      qm.queryExprBetween(CollectionConstant.QOFIELD_REGDATE, vo
          .getRegDateFrom(), vo.getRegDateTo());
    } else if (vo.getRegDateFrom() != null) {
      // 当vo.退改单登记日From不等于空时，qm.退改单登记日 >= vo.退改单登记日From
      qm.queryExprGE(CollectionConstant.QOFIELD_REGDATE, vo.getRegDateFrom());
    } else if (vo.getRegDateTo() != null) {
      // 当vo.退改单登记日to不等于空时，qm.退改单登记日 <= vo.退改单登记日to
      qm.queryExprLE(CollectionConstant.QOFIELD_REGDATE, vo.getRegDateTo());
    }

    // 当vo.电报议付 不等于空时，qm.电报议付 = vo.电报议付
    if (StringUtil.isNotEmpty(vo.getTelegNegoFlg())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_TELEGNEGOCLSDATE, vo
          .getTelegNegoFlg());
    }

    // 当vo.故障编号 不等于空时，qm.故障编号 = vo.故障编号
    if (StringUtil.isNotEmpty(vo.getFaultNo())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_FAULT_T_KIND, vo
          .getFaultTKind());
      qm.queryExprEqual(CollectionConstant.QOFIELD_FAULT_TXN_T_KIND, vo
          .getFaultTxnTKind());
      qm.queryExprLike(CollectionConstant.QOFIELD_FAULTNO, vo.getFaultNo());
    }

    // 设置排序条件
    // qm.交易参号T-kind 降序
    qm.orderField(CollectionConstant.QOFIELD_TKIND, QueryModel.ORDER_DESC);
    // qm.交易参号主参号 降序
    qm.orderField(CollectionConstant.QOFIELD_TXNPRMRYREFNO,
        QueryModel.ORDER_DESC);
    // qm.交易参号子参号 降序
    qm.orderField(CollectionConstant.QOFIELD_TXNSUBREFNO,
            QueryModel.ORDER_DESC);
    // 设置数据查询条件
    context.setQueryModel(qm);
    logger.debug("CollectionQueryByBizDataBuilder-buildInput end");
  }

  /**
   * 将BO转换成VO
   * 
   * @return Object 画面数据VO
   * @param context
   *            上下文信息
   * @param fieldMap
   *            VO与PO字段映射关系Map
   */
  public Object buildOutput(ComQueryContext context,
      FieldMappingConfigElement fieldMap) {
    logger.debug("CollectionQueryByBizDataBuilder-buildOutput start");
    // 从context取得查询结果
    QOCollectionBiz[] qoLst = (QOCollectionBiz[]) context.getQueryModelResult();
    if (qoLst == null) {
      return null;
    }
    // 新建变量.voLst
    List<BillOfCollectionQueryVO> voLst = new ArrayList<BillOfCollectionQueryVO>();
    // 循环查询结果
    for (QOCollectionBiz qo : qoLst) {
      BillOfCollectionQueryVO vo = new BillOfCollectionQueryVO();
      // 从QO中将数据赋值到VO中
      ArtBeanUtils.copyProperties(qo, vo);
      // 其他名称不一样的属性需要单独赋值
      // T-Kind
      vo.setTkind(qo.getTKind());
      // 退改单备注
      vo.setBbRmrk(qo.getModChgbkRmrk());
      
      // 信用证项下勾选，信用证信息名称不一样的属性需要单独赋值
      if (DataTypeConstant.DATA_TYPE_YES.equals(qo.getLcFlg())) {
        logger.debug("信用证信息");
        // 进口商名称
        vo.setImptrName(qo.getExpImptrName());
        //寄单行.名称
        vo.setExpDispch(qo.getExpDispch());
        // Osa/Nra
        vo.setExpOsaNra(qo.getExpOsa());
        
        // 信用证项下不勾选，非信用证信息名称不一样的属性需要单独赋值
      } else if (DataTypeConstant.DATA_TYPE_NO.equals(qo.getLcFlg())) {
        logger.debug("非信用证信息");
        // 进口商名称
        vo.setImptrName(qo.getBcImptrName());
        //寄单行.名称
        vo.setExpDispch(qo.getNonExpDispch());
        // Osa/Nra
        vo.setExpOsaNra(qo.getBcOsa());
      }
      
      // 数据字典字段显示值转换
      DataDictionaryUtil dataDictUtil = (DataDictionaryUtil) FactoryBeanUtil
          .getBean(BizBeanNameConst.E90340_UTIL_DATADICTIONARY);
      // Tenor种类
      vo.setTenorType(dataDictUtil.getValue(qo.getTenorType(),
          CollectionConstant.DICT_TENORTYPE, context.getSystemPara()
              .getLocale()));
      // 退改单
      vo.setBbMaintType(dataDictUtil.getValue(qo.getMaintType(),
          CollectionConstant.DICT_BBMAINTTYPE, context.getSystemPara()
              .getLocale()));
      
      // 将vo追加到变量.voLst
      voLst.add(vo);
    }
    logger.debug("CollectionQueryByBizDataBuilder-buildOutput end");
    // 返回变量.volst
    return voLst;
  }

}
