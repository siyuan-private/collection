package cn.com.btmu.art.biz.collection.databuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz;
import cn.com.btmu.art.biz.collection.vo.BillOfCollectionNoticeprintVO;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.base.context.ComQueryContext;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.dict.DataDictionaryUtil;
import cn.com.btmu.art.framework.biz.databuilder.impl.BaseDataBuilder;
import cn.com.btmu.art.framework.config.element.FieldMappingConfigElement;
import cn.com.btmu.art.framework.dao.QueryModel;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**	
 * NoticeLetterQueryBizDataBuilder	
 * 通知书打印一览用DataBuilder.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterQueryBizDataBuilder extends
    BaseDataBuilder<ComQueryContext, BillOfCollectionNoticeprintVO> {

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
  public void buildInput(BillOfCollectionNoticeprintVO vo,
      FieldMappingConfigElement fieldMap, ComQueryContext context) {

    logger.debug("NoticeLetterQueryBizDataBuilder-buildInput start");
    // VO为空时返回，不进行后面的属性赋值操作
    if (vo == null) {

      logger.debug("NoticeLetterQueryBizDataBuilder-buildInput vo为空");
      logger.debug("NoticeLetterQueryBizDataBuilder-buildInput end");
      return;
    }

    //从context中取得QM
    QueryModel qm = context.getQueryModel();

    //设置查询模板的
    qm.setQueryObjectClass(QONoticeLetterBiz.class);

    //设置查询条件

    //当种类不为空时，设置qm.种类 = vo.种类
    if (ArtStringUtil.isNotEmpty(vo.getType())) {
      qm.queryExprEqual(NoticeLetterConstant.QOFIELD_NOTICELETTERTYPE, vo
          .getType());
    }
    //转让编号.T-kind不为空时，设置qm.T-kind = vo.T-kind
    if (ArtStringUtil.isNotEmpty(vo.getTrasfTKind())) {
      qm.queryExprEqual(NoticeLetterConstant.QOFIELD_TRASFTKIND, vo
          .getTrasfTKind());
    }
    //转让编号.主参号不为空时，设置qm.主参号 = vo.主参号
    if (ArtStringUtil.isNotEmpty(vo.getTrasfNoPrmryRefNo())) {
      qm.queryExprEqual(NoticeLetterConstant.QOFIELD_TRASFNOPRMRYREFNO, vo
          .getTrasfNoPrmryRefNo());
    }
    //转让编号.转让号不为空时，设置qm.转让号 = vo.转让号
    if (ArtStringUtil.isNotEmpty(vo.getTrasfNoSubRefNo())) {
      qm.queryExprEqual(NoticeLetterConstant.QOFIELD_TRASFNOSUBREFNO, vo
          .getTrasfNoSubRefNo());
    }
    //登记日开始日期和结束日期均不为空时，设置qm.登记日 为开始日期与结束日期之间
    if (vo.getRegDateFrom() != null && vo.getRegDateTo() != null) {
      qm.queryExprBetween(NoticeLetterConstant.QOFIELD_REGDATE, vo
          .getRegDateFrom(), vo.getRegDateTo());
    } else if (vo.getRegDateFrom() != null) {
      //当登记日开始日期不为空时，设置qm.登记日为大于开始日期
      qm.queryExprGE(NoticeLetterConstant.QOFIELD_REGDATE, vo.getRegDateFrom());
    } else if (vo.getRegDateTo() != null) {
      //当登记日结束日期不为空时，设置qm.登记日为小于结束日期
      qm.queryExprLE(NoticeLetterConstant.QOFIELD_REGDATE, vo.getRegDateTo());
    }
    //信用证编号不为空时，设置qm.信用证编号 = vo.信用证编号
    if (ArtStringUtil.isNotEmpty(vo.getLcNo())) {
      qm.queryExprEqual(NoticeLetterConstant.QOFIELD_LCNO, vo.getLcNo());
    }
    //结算方式不为空时，设置qm.结算方式 = vo.结算方式
    if (ArtStringUtil.isNotEmpty(vo.getStlmtMeth())) {
      qm.queryExprEqual(NoticeLetterConstant.QOFIELD_STLMTMETH, vo
          .getStlmtMeth());
    }
    //第二受益人不为空时，设置qm.第二受益人 = vo.第二受益人
    if (ArtStringUtil.isNotEmpty(vo.getPayeeName())) {
      qm.queryExprLike(NoticeLetterConstant.QOFIELD_PAYEENAME,
          ComBizConstant.COMMON_STRING_PERCENT + vo.getPayeeName()
              + ComBizConstant.COMMON_STRING_PERCENT);
    }

    //设置排序条件
    //种类  升序
    qm.orderField(NoticeLetterConstant.QOFIELD_NOTICELETTERTYPE,
        QueryModel.ORDER_ASC);
    //转让编号 T-kind 降序
    qm.orderField(NoticeLetterConstant.QOFIELD_TRASFTKIND,
        QueryModel.ORDER_DESC);
    //转让编号 主参号 降序
    qm.orderField(NoticeLetterConstant.QOFIELD_TRASFNOPRMRYREFNO,
        QueryModel.ORDER_DESC);
    //转让编号 转让号 降序
    qm.orderField(NoticeLetterConstant.QOFIELD_TRASFNOSUBREFNO,
        QueryModel.ORDER_DESC);
    //登记日 降序
    qm.orderField(NoticeLetterConstant.QOFIELD_REGDATE, QueryModel.ORDER_DESC);
    //设置查询条件到context中
    context.setQueryModel(qm);

    logger.debug("NoticeLetterQueryBizDataBuilder-buildInput end");
  }

  /**
   * 将BO转换成VO
   * 
   * @return Object 
   *                画面数据VO
   * @param context 
   *                上下文信息
   * @param fieldMap 
   *                VO与PO字段映射关系Map
   */
  public Object buildOutput(ComQueryContext context,
      FieldMappingConfigElement fieldMap) {

    logger.debug("NoticeLetterQueryBizDataBuilder-buildOutput start");
    //从context取得查询结果
    QONoticeLetterBiz[] qoList = (QONoticeLetterBiz[]) context
        .getQueryModelResult();
    if (qoList == null) {
      return null;
    }
    //定义查询结果集输出vo对象集合
    List<BillOfCollectionNoticeprintVO> voLst = new ArrayList<BillOfCollectionNoticeprintVO>();
    //获取数据字典转换工具
    DataDictionaryUtil dataDictUtil = (DataDictionaryUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90340_UTIL_DATADICTIONARY);
    //循环将qo结果集赋值到输出vo对象集合中
    for (QONoticeLetterBiz qo : qoList) {
      BillOfCollectionNoticeprintVO vo = new BillOfCollectionNoticeprintVO();
      //从QO中将数据赋值到VO中
      ArtBeanUtils.copyProperties(qo, vo);
      //其他名称不一样的属性单独赋值
      // T-Kind
      vo.setTrasfTKind(qo.getTrasfTKind());
      vo.setType(qo.getNoticeLetterType());
      //取得结算方式
      String stlmtMeth = dataDictUtil.getValue(qo.getStlmtMeth(),
          NoticeLetterConstant.DIC_ID, context.getSystemPara().getLocale());
      //取得种类
      String type = dataDictUtil.getValue(qo.getNoticeLetterType(),
          NoticeLetterConstant.TYPE_ID, context.getSystemPara().getLocale());
      logger.debug("通过数据字典工具类DataDictionaryUtil取得 CA0286 值为 " + qo.getNoticeLetterType() + "的对应值为" + type);
      //设置结算方式
      vo.setStlmtMeth(stlmtMeth);
      //设置种类
      vo.setType(type);
      //添加到输出vo对象集合中
      voLst.add(vo);
    }

    logger.debug("NoticeLetterQueryBizDataBuilder-buildOutput end");
    //返回输出vo对象集合
    return voLst;
  }

}
