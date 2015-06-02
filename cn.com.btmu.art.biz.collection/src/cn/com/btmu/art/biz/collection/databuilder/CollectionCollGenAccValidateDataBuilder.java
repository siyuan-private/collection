package cn.com.btmu.art.biz.collection.databuilder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.common.feemngt.util.ChargeFeeUtil;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractComDetailContext;
import cn.com.btmu.art.biz.common01biz.base.databuilder.AbstractComDetailDataBuilder;
import cn.com.btmu.art.framework.bo.domain.feemgmtdataset.FeeRegDtl;
import cn.com.btmu.art.framework.config.element.FieldMappingConfigElement;
import cn.com.btmu.art.framework.exception.bizexception.BizCheckException;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * CollectionCollGenAccValidateDataBuilder
 * 
 * 记账Link点击时，数据校验时数据转换用DataBuilder.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollectionCollGenAccValidateDataBuilder extends
    AbstractComDetailDataBuilder<AbstractComDetailContext, String> {
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
  public void buildInputData(String vo, FieldMappingConfigElement fieldMap,
      AbstractComDetailContext context) throws BizCheckException {
  }

  /**
   * 将BO转换成VO
   * 
   * @return Object 校验结果
   * @param context
   *            上下文信息
   * @param fieldMap
   *            VO与PO字段映射关系Map
   */
  public Object buildOutputData(AbstractComDetailContext context,
      FieldMappingConfigElement fieldMap) {
    logger.debug("CollectionCollGenAccValidateDataBuilder-buildOutput start");
    //  取得手续费功能提供的业务间函数
    ChargeFeeUtil chargeFeeUtil = (ChargeFeeUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E00020_UTIL_CHARGEFEE);
    // 新建手续费列表feeRegDtlList并初始化
    List<FeeRegDtl> feeRegDtlList = null;
    // 取的随交易登录的非单独记账并且已收手续费
    feeRegDtlList = chargeFeeUtil.getFee(context, "0", "1");
    logger.debug("CollectionCollGenAccValidateDataBuilder-buildOutput end");
    // 判断feeRegDtlList是否为空或feeRegDtlList.size是否小于等于5，并返回判断值
    return feeRegDtlList == null || feeRegDtlList.size() <= 5;
  }

}
