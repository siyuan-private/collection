package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizWarningUnit;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.exception.ErrMessage;

/**
 * Warning823003业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class Warning823003 extends
    AbstractBizWarningUnit<String> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 有无需要校验.
   * 
   * @return boolean 判断结果
   * @param data
   *            数据存储
   */
  protected boolean canExecute(String data) {
    //返回true，必须进行校验
    return true;
  }

  /**
   * 当【画：新建.受益人为我行客户】=‘N’时，显示警告信息。（WARNING_823_003）
   * 
   * @return ErrMessage 错误信息
   * @param data 数据存储
   */
  protected ErrMessage doCheckLogic(String data) {

    logger.debug("Warning823003-doCheckLogic start");

    // 当【画：新建.受益人为我行客户】=‘N’时，显示警告信息
    if (ArtStringUtil.equals(DataTypeConstant.DATA_TYPE_NO, data)) {
      logger.debug("Warning823003-doCheckLogic 【画：新建.受益人为我行客户】=‘N’");
      logger.debug("Warning823003-doCheckLogic end");
      //返回警告消息ID ART00034_W
      return createErrMessage(CollectionConstant.MSG_ID_ART00034_W);
    }

    logger.debug("Warning823003-doCheckLogic end");
    //当【画：新建.受益人为我行客户】不为‘N’时，返回null
    return null;
  }
}
