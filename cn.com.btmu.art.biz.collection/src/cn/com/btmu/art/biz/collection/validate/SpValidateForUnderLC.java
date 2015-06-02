package cn.com.btmu.art.biz.collection.validate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.datacollection.common.ICollectionCommonMntnDataCollection;
import cn.com.btmu.art.biz.common01biz.base.AbstractBizCheckUnit;
import cn.com.btmu.art.biz.common01biz.base.constant.LabelComConstant;
import cn.com.btmu.art.biz.common01biz.base.error.ErrorContainer;
import cn.com.btmu.art.framework.bo.domain.bbdataset.BbCombLcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcMntnOpDtl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcMntnOpDtl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.exception.BizException;

import commonj.sdo.DataObject;

/**
 * SpValidate823004业务校验
 * 
 * @author ivision
 * @version 1.0.0
 */
public class SpValidateForUnderLC extends AbstractBizCheckUnit<ICollectionCommonMntnDataCollection> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  private String locale = "";
  
  private DataObject tempObject;
  
  public SpValidateForUnderLC(DataObject tempObject, String locale) {
    logger.debug("SpValidateForUnderLC构造方法-start");
    //设置locale值
    this.locale = locale;
    //设置tempObject的值
    this.tempObject = tempObject;
    logger.debug("SpValidateForUnderLC构造方法-end");
  }

  /**
   * 当【画：新建.信用证项下】为‘Y’时
   * 
   * @return boolean 判断结果
   * @param data
   *            数据存储
   */
  @Override
  protected boolean canExecute(ICollectionCommonMntnDataCollection data) {

    logger.debug("SpValidateForUnderLC-canExecute start");
    //当【画：新建.信用证项下】为‘Y’时
    if (DataTypeConstant.DATA_TYPE_YES.equals(data.getBcMntnOpDtl().getLcFlg())) {

      logger.debug("SpValidateForUnderLC-canExecute canExecute true");
      logger.debug("SpValidateForUnderLC-canExecute end");
      //返回true
      return true;
    }

    logger.debug("SpValidateForUnderLC-canExecute canExecute false");
    logger.debug("SpValidateForUnderLC-canExecute end");
     //当【画：新建.信用证项下】不为‘Y’时返回false
    return false;
  }

  /**
   * 【画：信用证信息.有偿付行】必须为‘Y’，否则报错
   * 
   * @return ErrMessage 错误信息
   * @param dataCollection
   *            数据存储
   */
  @Override
  protected void doCheckLogic(ICollectionCommonMntnDataCollection dataCollection, ErrorContainer errorContainer) throws BizException {
	    logger.debug("SpValidateForUnderLC-doCheckLogic start");
	    //取得出口信用证维护操作明细
	    ExpLcMntnOpDtl expLcMntnOpDtl = dataCollection.getExpLcMntnOpDtl();
        //取得Combined LC 维护操作明细
	    List<BbCombLcMntnOpDtl> bbCombLcMntnOpDtlList = dataCollection.getBbCombLcMntnOpDtlList();
        //取得托收维护操作明细
	    BcMntnOpDtl bcMntnOpDtl = dataCollection.getBcMntnOpDtl();

	    // 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）
	    SpValidate82309801 spValidate82309801 = new SpValidate82309801(tempObject, locale);
	    spValidate82309801.execute(bcMntnOpDtl, errorContainer);

	    // 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）
	    SpValidate82309802 spValidate82309802 = new SpValidate82309802(tempObject, locale);
	    spValidate82309802.execute(bcMntnOpDtl, errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证编号】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302001 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_02151);
	    spValidate82302001.execute(bcMntnOpDtl.getLcNo(), errorContainer);
	    
	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证金额.币种】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302002 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00026);
	    spValidate82302002.execute(expLcMntnOpDtl.getLcAmtCcy(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证金额.金额】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate82302001 spValidate82302003 = new SpValidate82302001(locale, CollectionConstant.LABEL_823_00026);
	    spValidate82302003.execute(expLcMntnOpDtl.getLcAmt(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证余额.金额】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate82302001 spValidate82302004 = new SpValidate82302001(locale, CollectionConstant.LABEL_823_00027);
	    spValidate82302004.execute(expLcMntnOpDtl.getLcBalAmt(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证日期】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate82302002 spValidate82302005 = new SpValidate82302002(locale, LabelComConstant.LABEL_COM_01626);
	    spValidate82302005.execute(expLcMntnOpDtl.getIssueDate(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.到期日期】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate82302002 spValidate82302006 = new SpValidate82302002(locale, LabelComConstant.LABEL_COM_01184);
	    spValidate82302006.execute(expLcMntnOpDtl.getDueDate(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.第二受益人】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302007 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01193);
	    spValidate82302007.execute(expLcMntnOpDtl.getBene2ndFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.进口商名称】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302008 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01588);
	    spValidate82302008.execute(expLcMntnOpDtl.getImptrName(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.进口商国别】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302009 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01587);
	    spValidate82302009.execute(expLcMntnOpDtl.getImptrNatnlty(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.OSA/NRA】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302010 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00631);
	    spValidate82302010.execute(expLcMntnOpDtl.getOsaNraFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行同开证行】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302011 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01521);
	    spValidate82302011.execute(expLcMntnOpDtl.getDispchBankEqIssueFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.有偿付行】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302012 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_02238);
	    spValidate82302012.execute(expLcMntnOpDtl.getWithReimbsBankFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.行号】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302013 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01420);
	    spValidate82302013.execute(expLcMntnOpDtl.getIssueBankCode(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302014 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00839);
	    spValidate82302014.execute(expLcMntnOpDtl.getIssueBankSwift(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.名称】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302015 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01720);
	    spValidate82302015.execute(expLcMntnOpDtl.getIssueBankName(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.地址】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302016 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01191);
	    spValidate82302016.execute(expLcMntnOpDtl.getIssueBankAddr(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302017 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01420);
	    spValidate82302017.execute(expLcMntnOpDtl.getDispchDocBankCode(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302018 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00839);
	    spValidate82302018.execute(expLcMntnOpDtl.getDispchDocBankSwift(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302019 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01720);
	    spValidate82302019.execute(expLcMntnOpDtl.getDispchDocBankName(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302020 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01191);
	    spValidate82302020.execute(expLcMntnOpDtl.getDispchDocBankAddr(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.我行承兑】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302021 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_02094);
	    spValidate82302021.execute(expLcMntnOpDtl.getOurBankAccptceFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.转让信用证】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302022 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_02362);
	    spValidate82302022.execute(expLcMntnOpDtl.getTrasfLcFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.警报国家】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302023 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01593);
	    spValidate82302023.execute(expLcMntnOpDtl.getAlertCountry(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.代理行】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302024 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01129);
	    spValidate82302024.execute(expLcMntnOpDtl.getAgcBankFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.国内信用证】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302025 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01404);
	    spValidate82302025.execute(expLcMntnOpDtl.getDomstcLcFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.Combined
	    // LC】不得为空，否则报错（SP_VALIDATE_823_020）
	    SpValidate823020 spValidate82302026 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00305);
	    spValidate82302026.execute(bcMntnOpDtl.getCombinedLcFlg(), errorContainer);

	    // 当【画：新建.信用证项下】为‘Y’且当【画：信用证信息.第二受益人】为‘Y’时，
	    if (DataTypeConstant.DATA_TYPE_YES.equals(expLcMntnOpDtl.getBene2ndFlg())) {
            logger.debug("且【画：信用证信息.第二受益人】为‘Y’");
	    	// 当【画：新建.信用证项下】为‘Y’且当【画：信用证信息.第二受益人】为‘Y’时，【画：信用证信息.中转行】不得为空，否则报错（SP_VALIDATE_823_033）
	    	SpValidate823020 spValidate82303301 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_02339);
	    	spValidate82303301.execute(expLcMntnOpDtl.getTrastBank(), errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且当【画：信用证信息.第二受益人】为‘Y’时，【画：信用证信息.中转行国别】不得为空，否则报错（SP_VALIDATE_823_033）
	    	SpValidate823020 spValidate82303302 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_02340);
		    spValidate82303302.execute(expLcMntnOpDtl.getTrastBankNatnlty(), errorContainer);
        }
        
	    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时
        if(DataTypeConstant.DATA_TYPE_YES.equals(bcMntnOpDtl.getTrasf2ndBene())){
            logger.debug("且【画：信用证信息.转让第二受益人】为‘Y’");
		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.转让编号】不得为空，否则报错（SP_VALIDATE_823_023）
		    SpValidate82302301 spValidate82302301 = new SpValidate82302301(locale);
		    spValidate82302301.execute(bcMntnOpDtl, errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.第一受益人账户】不得为空，否则报错（SP_VALIDATE_823_023）
		    SpValidate82302302 spValidate82302302 = new SpValidate82302302(locale);
		    spValidate82302302.execute(bcMntnOpDtl, errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.转让金额.金额】不得为空，否则报错（SP_VALIDATE_823_023）
		    SpValidate82302001 spValidate82302303 = new SpValidate82302001(locale, CollectionConstant.LABEL_823_00036);
		    spValidate82302303.execute(bcMntnOpDtl.getTrasfAmt(), errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.第二受益人银行国别.国家】不得为空，否则报错（SP_VALIDATE_823_023）
		    SpValidate823020 spValidate82302304 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00037);
		    spValidate82302304.execute(bcMntnOpDtl.getBene2ndNatnlty(), errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.OSA/NRA】不得为空，否则报错（SP_VALIDATE_823_023）
		    SpValidate823020 spValidate82302305 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00631);
		    spValidate82302305.execute(bcMntnOpDtl.getOsaNraFlg(), errorContainer);
        }

        // 当【画：信用证信息.第二受益人银行国别.国家】为‘CHN’
        if (CollectionConstant.COUNTRY_CHN.equals(bcMntnOpDtl.getBene2ndNatnlty())) {
            logger.debug("且【画：信用证信息.第二受益人银行国别.国家】为‘CHN’");
            // 当【画：信用证信息.第二受益人银行国别.国家】为‘CHN’,【画：信用证信息.第二受益人银行国别.省】不得为空，否则报错（SP_VALIDATE_823_035）
            SpValidate823020 spValidate82303501 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00037);
            spValidate82303501.execute(bcMntnOpDtl.getBene2ndProv(), errorContainer);

            // 当【画：信用证信息.第二受益人银行国别.国家】为‘CHN’,【画：信用证信息.第二受益人银行国别.市】不得为空，否则报错（SP_VALIDATE_823_035）
            SpValidate823020 spValidate82303502 = new SpValidate823020(locale, CollectionConstant.LABEL_823_00037);
            spValidate82303502.execute(bcMntnOpDtl.getBene2ndCity(), errorContainer);
		    }
	    
	    
	    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时
	    if (DataTypeConstant.DATA_TYPE_YES.equals(expLcMntnOpDtl.getWithReimbsBankFlg())) {
           logger.debug("且【画：信用证信息.有偿付行】为‘Y’");
		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.行号】不得为空，否则报错（SP_VALIDATE_823_021）
	    	SpValidate823020 spValidate82302101 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01420);
		    spValidate82302101.execute(expLcMntnOpDtl.getReimbBankCode(), errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.Swift】不得为空，否则报错（SP_VALIDATE_823_021）
		    SpValidate823020 spValidate82302102 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_00839);
		    spValidate82302102.execute(expLcMntnOpDtl.getReimbBankSwift(), errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.名称】不得为空，否则报错（SP_VALIDATE_823_021）
		    SpValidate823020 spValidate82302103 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01720);
		    spValidate82302103.execute(expLcMntnOpDtl.getReimbBankName(), errorContainer);

		    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.地址】不得为空，否则报错（SP_VALIDATE_823_021）
		    SpValidate823020 spValidate82302104 = new SpValidate823020(locale, LabelComConstant.LABEL_COM_01191);
		    spValidate82302104.execute(expLcMntnOpDtl.getReimbBankAddr(), errorContainer);	    	
	    }
	    
	    // 当【画：信用证信息.留行信用证】勾选时
	    if (DataTypeConstant.DATA_TYPE_YES.equals(expLcMntnOpDtl.getKibLcFlg())) {
            logger.debug("且【画：信用证信息.留行信用证】勾选时");
		    // 当【画：信用证信息.留行信用证】勾选时，【画：信用证信息.留行日期】不得为空，否则报错（SP_VALIDATE_823_022）
		    SpValidate82302002 spValidate823022 = new SpValidate82302002(locale, LabelComConstant.LABEL_COM_01697);
		    spValidate823022.execute(expLcMntnOpDtl.getKibLcDate(), errorContainer);	    	
	    }

	    // 当【画：新建.P.P.NEGO】勾选时，
	    if (DataTypeConstant.DATA_TYPE_YES.equals(bcMntnOpDtl.getPpnegoFlg())) {
            logger.debug("且当【画：新建.P.P.NEGO】勾选时");
	    	// 【画：信用证信息.有偿付行】必须为‘Y’，否则报错（SP_VALIDATE_823_004）
		    SpValidate823004 spValidate823004 = new SpValidate823004();
			spValidate823004.execute(expLcMntnOpDtl, errorContainer);
	    }
	    
	    // 【画：信用证信息.信用证编号】不为空时，信用证已被取消的场合，显示报错信息（SP_VALIDATE_823_009）
	    // 	信用证的受益人不等于交易的受益人时，显示报错信息（SP_VALIDATE_823_039）
	    SpValidate82300901 spValidate82300901 = new SpValidate82300901();
	    spValidate82300901.execute(dataCollection, errorContainer);
	    
	    // 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时，
	    if (DataTypeConstant.DATA_TYPE_YES.equals(bcMntnOpDtl.getCombinedLcFlg())) {
            logger.debug("且【画：信用证信息.Combined LC】为‘Y’");
		    // Combined LC信息表格中信用证编号有值的记录条数必须大于等于2，否则报错（SP_VALIDATE_823_005）
		    SpValidate823005 spValidate823005 = new SpValidate823005();
		    spValidate823005.execute(bbCombLcMntnOpDtlList, errorContainer);
		    
		    // 当以下项目中有一个项目被输入时，其余项目都不得为空，否则报错（SP_VALIDATE_823_029）
		    SpValidate823029 spValidate823029 = new SpValidate823029(locale);
		    spValidate823029.execute(bbCombLcMntnOpDtlList, errorContainer);
		    
		    // 画：信用证信息.Combined LC信息.drawnamount#1-#5.金额】的合计必须等于【画：新建.汇票金额.金额】，否则报错（SP_VALIDATE_823_008）
		    SpValidate823008 spValidate823008 = new SpValidate823008(bcMntnOpDtl.getBxAmt());
		    spValidate823008.execute(bbCombLcMntnOpDtlList, errorContainer);
		    
		    // 【画：信用证信息.Combined LC信息.信用证编号#2-#5】不为空时，
		    // 信用证已被取消检查（SP_VALIDATE_823_009）
		    // 子信用证和主信用证关键信息不一致检查（SP_VALIDATE_823_006）
		    // 子信用证非我行保兑检查（SP_VALIDATE_823_007）
		    // 我行通知信用证检查（SP_VALIDATE_823_037）
		    SpValidate82300902 spValidate82300902 = new SpValidate82300902(expLcMntnOpDtl, bcMntnOpDtl);
		    spValidate82300902.execute(dataCollection, errorContainer);
	    }

	    logger.debug("SpValidateForUnderLC-doCheckLogic end");
  }
}
