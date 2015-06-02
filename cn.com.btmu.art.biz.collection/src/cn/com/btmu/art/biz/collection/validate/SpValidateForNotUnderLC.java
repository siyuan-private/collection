package cn.com.btmu.art.biz.collection.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.datacollection.common.ICollectionCommonMntnDataCollection;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.exception.BizException;

/**
 * SpValidate823004业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidateForNotUnderLC extends AbstractBizCheckUnit<ICollectionCommonMntnDataCollection> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  private String locale = "";
  
  public SpValidateForNotUnderLC(String locale) {
    logger.debug("SpValidateForNotUnderLC构造方法-start");
    //设置locale值
    this.locale = locale;
    logger.debug("SpValidateForNotUnderLC构造方法-end");
  }

  /**
   * 当【画：新建.信用证项下】为N时.
   * 
   * @return boolean 判断结果
   * @param data
   *            数据存储
   */
  @Override
  protected boolean canExecute(ICollectionCommonMntnDataCollection data) {

    logger.debug("SpValidateForNotUnderLC-canExecute start");
    //当【画：新建.信用证项下】为N时
    if (!DataTypeConstant.DATA_TYPE_YES.equals(data.getBcMntnOpDtl().getLcFlg())) {

      logger.debug("SpValidateForNotUnderLC-canExecute returnValue true");
      logger.debug("SpValidateForNotUnderLC-canExecute end");
      //返回true
      return true;
    }

    logger.debug("SpValidateForNotUnderLC-canExecute returnValue false");
    logger.debug("SpValidateForNotUnderLC-canExecute end");
    //当【画：新建.信用证项下】不为N时，返回false
    return false;
  }

  /**
   * 【画：信用证信息.有偿付行】必须为‘Y’，否则报错
   * 
   * @return ErrMessage 错误信息
   * @param data
   *            数据存储
   */
  @Override
  protected void doCheckLogic(ICollectionCommonMntnDataCollection data, ErrorContainer errorContainer) throws BizException {
    logger.debug("SpValidateForNotUnderLC-doCheckLogic start");
    //取得托收维护操作明细
    BcMntnOpDtl bcMntnOpDtl = data.getBcMntnOpDtl();

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.进口商名称】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302401 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01588);
    spValidate82302401.execute(bcMntnOpDtl.getImptrName(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.进口商国别】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302402 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01587);
    spValidate82302402.execute(bcMntnOpDtl.getImptrNatnlty(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.OSA/NRA】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302403 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00631);
    spValidate82302403.execute(bcMntnOpDtl.getOsaNraFlg(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302404 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
    spValidate82302404.execute(bcMntnOpDtl.getDispchDocBankCode(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302405 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
    spValidate82302405.execute(bcMntnOpDtl.getDispchDocBankSwift(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302406 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
    spValidate82302406.execute(bcMntnOpDtl.getDispchDocBankName(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302407 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00012);
    spValidate82302407.execute(bcMntnOpDtl.getDispchDocBankAddr(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.警报国家】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302408 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01593);
    spValidate82302408.execute(bcMntnOpDtl.getAlertCountry(), errorContainer);

    // 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.代理行】不得为空，否则报错（SP_VALIDATE_823_024）
    SpValidate823020 spValidate82302409 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01129);
    spValidate82302409.execute(bcMntnOpDtl.getAgcBankFlg(), errorContainer);
    
    logger.debug("SpValidateForNotUnderLC-doCheckLogic end");
  }
}
