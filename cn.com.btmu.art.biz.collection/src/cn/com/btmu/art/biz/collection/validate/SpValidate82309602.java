package cn.com.btmu.art.biz.collection.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollModDocDetailContext;
import cn.com.btmu.art.biz.common.feemngt.util.ChargeFeeUtil;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.MsgIdComConstant;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.feemgmtdataset.FeeRegDtl;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.exception.ErrMessage;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * SpValidate82309602业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidate82309602 extends
    AbstractBizCheckUnit<CollectionCollModDocDetailContext> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 【画：费用信息.手续费账户.币种】不为空时
   * 
   * @return boolean 判断结果
   * @param data
   *            数据存储
   */

  protected boolean canExecute(CollectionCollModDocDetailContext context) {

    logger.debug("SpValidate82309602-canExecute start");
    //获取托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = context.getDataRepository()
        .getOperationDataCollection().getBcMntnOpDtl();
    //【画：费用信息.手续费账户.币种】不为空时
    if (ArtStringUtil.isNotEmpty(bcMntnOpDtl.getFeeAcctCcy())) {

      logger.debug("SpValidate82309602-canExecute 【画：费用信息.手续费账户.币种】不为空");
      logger.debug("SpValidate82309602-canExecute returnValue true");
      logger.debug("SpValidate82309602-canExecute end");
      //返回true
      return true;
    }

    logger.debug("SpValidate82309602-canExecute 【画：费用信息.手续费账户.币种】为空");
    logger.debug("SpValidate82309602-canExecute returnValue false");
    logger.debug("SpValidate82309602-canExecute end");
    //【画：费用信息.手续费账户.币种】为空时返回false
    return false;
  }

  protected ErrMessage doCheckLogic(CollectionCollModDocDetailContext context)
      throws BizException {

    logger.debug("SpValidate82309602-doCheckLogic start");
    //获取托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = context.getDataRepository()
        .getOperationDataCollection().getBcMntnOpDtl();
    //获取手续费业管理务间函数
    ChargeFeeUtil chargeFeeUtil = (ChargeFeeUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E00020_UTIL_CHARGEFEE);
    //获取手续费
    List<FeeRegDtl> feeRegDtlList = chargeFeeUtil
        .getFee(context, CollectionConstant.STRING_CRPRIPLFLG,
            CollectionConstant.STRING_CHGMETH);
    //对每条手续费信息进行循环
    for (int i = 0; i < feeRegDtlList.size(); i++) {
      //取得第i条手续费信息
      FeeRegDtl feeRegDtl = feeRegDtlList.get(i);
      //当手续非源交易币种不等于托收维护操作明细中的币种
      if (!ArtStringUtil.equals(feeRegDtl.getSrcTxnCcy(), bcMntnOpDtl
          .getFeeAcctCcy())) {
        //获取国际化标签转换工具
        I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
            .getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
        //转换国际化标签
        String labelFeeAcctCcy = i18nUtil.getI18nMessage(context
            .getSystemPara().getLocale(), CollectionConstant.LABEL_823_00045);
        //转换国际化标签
        String labelFee = i18nUtil.getI18nMessage(context.getSystemPara()
            .getLocale(), LabelComConstant.LABEL_COM_01933);

        logger
            .debug("SpValidate82309602-doCheckLogic 【画：费用信息.手续费账户.币种】不等于【画：手续费】板块手续费的币种");
        logger.debug("SpValidate82309602-doCheckLogic end");
        //返回错误消息ID ART00106_E
        return createErrMessage(MsgIdComConstant.COM_MSG_ID_ART00106_E,
            labelFeeAcctCcy, labelFee);
      }
    }

    logger.debug("SpValidate82309602-doCheckLogic end");
    //当手续非源交易币种等于托收维护操作明细中的币种,返回null
    return null;
  }

}
