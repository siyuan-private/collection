package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizWarningUnit;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.exception.ErrMessage;

/**
 * Warning82300101业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class Warning82300101 extends
    AbstractBizWarningUnit<String> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  public Warning82300101() {
  }
  
  /**
   * 当【画：费用信息.手续费支付方】为‘B：Buyer’时.
   * 
   * @return boolean 判断结果
   * @param data
   *            数据存储
   */
  @Override
  protected boolean canExecute(String data) {
    logger.debug("Warning82300101-canExecute start");
    logger.debug("Warning82300101-canExecute returnValue true");
    logger.debug("Warning82300101-canExecute end");
    //直接返回true，必须进行校验
    return true;
  }

  /**
   * 画面上显示提示message，清算行账户请输入237中间账户
   * 
   * @return ErrMessage 错误信息
   * @param data
   *            数据存储
   */
  @Override
  protected ErrMessage doCheckLogic(String data) {
    logger.debug("Warning82300101-doCheckLogic start");
    logger.debug("Warning82300101-doCheckLogic end");
    //当【画：费用信息.手续费支付方】为‘B：Buyer’时
    if (ArtStringUtil.equals(data, CollectionConstant.FEEPAYER_B)) {
        // 手续费支付方为“B：Buyer”时，清算行账户请输入237中间账户.
        return createErrMessage(CollectionConstant.MSG_ID_ART82307_W);
    }
    //当【画：费用信息.手续费支付方】不为‘B：Buyer’时，返回null
    return null;
  }
}
