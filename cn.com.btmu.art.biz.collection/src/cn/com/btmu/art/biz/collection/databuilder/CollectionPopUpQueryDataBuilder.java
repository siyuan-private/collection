package cn.com.btmu.art.biz.collection.databuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.dataset.collection.QOModHist;
import cn.com.btmu.art.biz.collection.vo.BcMntnOpDtlVO;
import cn.com.btmu.art.biz.collection.vo.ModHistVO;
import cn.com.btmu.art.biz.common01biz.base.context.ComQueryContext;
import cn.com.btmu.art.framework.biz.databuilder.impl.BaseDataBuilder;
import cn.com.btmu.art.framework.config.element.FieldMappingConfigElement;
import cn.com.btmu.art.framework.dao.QueryModel;
import cn.com.btmu.art.framework.exception.bizexception.BizCheckException;

import com.eos.system.utility.StringUtil;

/**
 * CollectionPopUpQueryDataBuilder
 * 
 * 托收POPUP画面数据转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionPopUpQueryDataBuilder extends
    BaseDataBuilder<ComQueryContext, BcMntnOpDtlVO> {
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
  public void buildInput(BcMntnOpDtlVO vo, FieldMappingConfigElement fieldMap,
      ComQueryContext context) throws BizCheckException {
    logger.debug("CollectionPopUpQueryDataBuilder-buildInput start");
    if (vo == null) {
      logger.debug("VO为空校验");
      logger.debug("CollectionPopUpQueryDataBuilder-buildInput end");
      return;
    }
    // 从context中取得QM
    QueryModel qm = context.getQueryModel();
    // 设置查询模板的
    qm.setQueryObjectClass(QOModHist.class);
    // 设置查询条件
    // T-Kind
    if (StringUtil.isNotEmpty(vo.getTkind())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_TKIND, vo.getTkind());
    }
    // 交易参号主参号
    if (StringUtil.isNotEmpty(vo.getTxnPrmryRefNo())) {
      qm.queryExprEqual(CollectionConstant.QOFIELD_TXNPRMRYREFNO, vo
          .getTxnPrmryRefNo());
    }
    // 设置排序条件
    qm.orderField(CollectionConstant.QOFIELD_TMSTMP, QueryModel.ORDER_ASC);
    // 设置数据查询条件
    context.setQueryModel(qm);

    logger.debug("CollectionPopUpQueryDataBuilder-buildInput end");
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
      FieldMappingConfigElement fieldMap) throws BizCheckException {
    logger.debug("CollectionPopUpQueryDataBuilder-buildOutput start");
    // 从context中取得查询结果
    QOModHist[] qoList = (QOModHist[]) context.getQueryModelResult();
    // 新建变量.voLst
    List<ModHistVO> voList = new ArrayList<ModHistVO>();
    // 循环查询结果
    for (QOModHist qo : qoList) {
      ModHistVO vo = new ModHistVO();

      // 从QO中将数据赋值到VO中
      ArtBeanUtils.copyProperties(qo, vo);

      // 其他名称不一样的属性需要单独赋值
      vo.setTkind(qo.getTKind());

      // 将vo追加到变量.voLst
      voList.add(vo);
    }
    logger.debug("CollectionPopUpQueryDataBuilder-buildOutput end");
    // 返回变量.volst
    return voList;
  }

}
