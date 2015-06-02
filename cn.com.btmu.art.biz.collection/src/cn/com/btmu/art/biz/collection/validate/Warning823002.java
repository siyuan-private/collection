package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizWarningUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.component.blacklist.BlackListValidateUtil;
import cn.com.btmu.art.component.i18n.I18nLocalesUtil;
import cn.com.btmu.art.framework.exception.ErrMessage;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * Warning823002业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class Warning823002 extends
    AbstractBizWarningUnit<CollectionCollBookingDetailContext> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 有无需要校验.
   * 
   * @return boolean 判断结果
   * @param data
   *            数据存储
   */
  @Override
  protected boolean canExecute(CollectionCollBookingDetailContext data) {
    //返回true，必须进行校验
    return true;
  }

  /**
   * 当客户CIF存在于不申报不解付黑名单时，画面显示提示message,该客户存在于不申报不解付黑名单中，是否还要继续？
   * 校验方法：调用组件列表【E90240】，参数：分行号，客户CIF，黑名单类型（ 10.不申报不解付名单），若组件返回值不为0，则提示Message
   * 
   * @return ErrMessage 错误信息
   * @param data
   *            数据存储
   */
  @Override
  protected ErrMessage doCheckLogic(CollectionCollBookingDetailContext data) {

    logger.debug("Warning823002-doCheckLogic start");

    // 调用组件列表【E90240】，参数：分行号，客户CIF，黑名单类型（ 10.不申报不解付名单）
    int[] types = new int[] { 10 };
    BlackListValidateUtil blackListValidateUtil = (BlackListValidateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.E90240_UTIL_BLACKLIST_VALIDATOR);
    //取得结果
    String result = blackListValidateUtil.blackListValidate(data.getBranchId(),
		    data.getDataRepository().getBizDataCollection().getBcInfo()
		        .getBeneCif(), null, types);
    // 若组件返回值不为0，则提示Message
    if (!CollectionConstant.BLACKLIST_VALIDATE_RESULT_0.equals(result)) {
      //获取国际化标签转换工具类
      I18nLocalesUtil i18nUtil = (I18nLocalesUtil) FactoryBeanUtil
          .getBean(BizBeanNameConst.E90700_UTIL_I18NLOCALESUTIL);
      //转换国际化标签
      String lableCif = i18nUtil.getI18nMessage(data.getSystemPara()
          .getLocale(), CollectionConstant.LABEL_823_00004);
      logger.debug("该客户存在于不申报不解付黑名单中");
      logger.debug("Warning823002-doCheckLogic end");
      //返回错误消息ID ART00077_W, {0}存在于不申报不解付黑名单中，是否还要继续？
      return createErrMessage(CollectionConstant.MSG_ID_ART00077_W, lableCif);
    }

    logger.debug("该客户不存在于不申报不解付黑名单中");
    logger.debug("Warning823002-doCheckLogic end");
    //若组件返回值为0，则返回null
    return null;
  }
}
