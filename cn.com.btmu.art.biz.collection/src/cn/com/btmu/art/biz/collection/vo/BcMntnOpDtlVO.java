package cn.com.btmu.art.biz.collection.vo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**	
 * BcMntnOpDtlVO
 * 
 * @author ivision
 * @version 1.0.0
 */
public class BcMntnOpDtlVO {
  /** 交易参号.T-kind */
  private String tkind;

  /** 交易参号.主参号 */
  private String txnPrmryRefNo;

  /** 交易参号.子参号 */
  private String txnSubRefNo;

  /** 登记日 */
  private Date regDate;

  /** 预录入号 */
  private String preInputNo;

  /** 预录入备注 */
  private String preInputRmrk;

  /** 网银 */
  private String internetFlg;

  /** 跨境人民币 */
  private String crsBorderRmbFlg;

  /** 信用证项下 */
  private String lcFlg;

  /** BPO */
  private String bpoFlg;

  /** TSU */
  private String tsuFlg;

  /** P.P. NEGO */
  private String ppnegoFlg;

  /** 电报议付 */
  private String telegNegoFlg;

  /** 电报议付销号日期 */
  private Date telegNegoClsDate;

  /** 备注 */
  private String newRmrk;

  /** 受益人.客户CIF */
  private String beneCif;

  /** 受益人.客户名称 */
  private String beneName;

  /** 受益人账户.币种 */
  private String beneAcctCcy;

  /** 受益人账户.GL */
  private String beneAcctGl;

  /** 受益人账户.SUB GL */
  private String beneAcctSubGl;

  /** 受益人账户.账号 */
  private String beneAcctNo;

  /** 受益人为我行客户 */
  private String beneOurCustFlg;

  /** 汇票金额.币种 */
  private String bxCcy;

  /** 汇票金额.金额 */
  private BigDecimal bxAmt;

  /** Tenor.种类 */
  private String tenorType;

  /** Tenor.天数 */
  private BigInteger tenorDays;

  /** Tenor.日期 */
  private Date tenorDate;

  /** 假远期 */
  private String fakeForwdFlg;

  /** 发票编号 */
  private String ivcNo;

  /** 保税区属性 */
  private String bondedAreaAttbt;

  /** 保税区 */
  private String bondedAreaFlg;

  /** 已签署GA/TFA */
  private String sigdGatfa;

  /** 托收日期 */
  private Date collDate;

  /** 到期日期 */
  private Date dueDate;

  /** 提单日期 */
  private Date blDate;

  /** 最终到期日 */
  private Date finalDueDate;

  /** 信用证编号 */
  private String lcNo;

  /** 我行保兑.T-kind */
  private String confmdTKind;

  /** 我行保兑.主参号 */
  private String confmdPrmryRefNo;

  /** 我行保兑.转让号 */
  private String confmdSubRefNo;

  /** 履行保兑责任 */
  private String perfmConfmDuties;

  /** 保兑备注 */
  private String confmdRmrk;

  /** Combined LC */
  private String combinedLcFlg;

  /** 转让第二受益人 */
  private String trasf2ndBene;

  /** 转让编号.T-kind */
  private String trasfTKind;

  /** 转让编号.主参号 */
  private String trasfNoPrmryRefNo;

  /** 转让编号.转让号 */
  private String trasfNoSubRefNo;

  /** 第一受益人账户.币种 */
  private String bene1stAcctCcy;

  /** 第一受益人账户.GL */
  private String bene1stAcctGl;

  /** 第一受益人账户.SUB GL */
  private String bene1stAcctSubGl;

  /** 第一受益人账户.账号 */
  private String bene1stAcctNo;

  /** 转让金额.币种 */
  private String trasfAmtCcy;

  /** 转让金额.金额 */
  private BigDecimal trasfAmt;

  /** 第一受益人承担 */
  private String undtk1stBeneFlg;

  /** 第二受益人名称 */
  private String bene2ndName;

  /** 第二受益人银行国别.国家 */
  private String bene2ndNatnlty;

  /** 第二受益人银行国别.省 */
  private String bene2ndProv;

  /** 第二受益人银行国别.市 */
  private String bene2ndCity;

  /** TRASF_OSA_NRA_FLG */
  private String trasfOsaNraFlg;

  /** 第二受益人通知行.Swift */
  private String bene2ndNoticeBankSwiftCode;

  /** 第二受益人通知行.名称 */
  private String bene2ndNoticeBankName;

  /** 进口商名称 */
  private String imptrName;

  /** 进口商国别 */
  private String imptrNatnlty;

  /** OSA/NRA */
  private String osaNraFlg;

  /** 寄单行.行号 */
  private String dispchDocBankCode;

  /** 寄单行.Swift */
  private String dispchDocBankSwift;

  /** 寄单行.名称 */
  private String dispchDocBankName;

  /** 寄单行.地址 */
  private String dispchDocBankAddr;

  /** 警报国家 */
  private String alertCountry;

  /** 代理行 */
  private String agcBankFlg;

  /** 其他事项 */
  private String otherItem;

  /** 发票编号 */
  private String docIvcNo;

  /** 跟单票/光票 */
  private String docClean;

  /** 交货方式 */
  private String delvrMeth;

  /** 有追索权 */
  private String withRcsFlg;

  /** CHQ Kind */
  private String chqKind;

  /** 拒绝证明 */
  private String refuseCertfct;

  /** 清算行信息 */
  private String clrBankInfo;

  /** 清算行账户.币种 */
  private String clrBankAcctCcy;

  /** 清算行账户.GL */
  private String clrBankAcctGl;

  /** 清算行账户.SUB GL */
  private String clrBankAcctSubGl;

  /** 清算行账户.账号 */
  private String clrBankAcctNo;

  /** BC记账科目.GL */
  private String bcBookAcctGl;

  /** BC记账科目.SUB GL */
  private String bcBookAcctSubGl;

  /** 国别 */
  private String natnlty;

  /** 商品 */
  private String goods;

  /** 目的 */
  private String purpose;

  /** 备注.备注1 */
  private String docRmrk1;

  /** 备注.备注2 */
  private String docRmrk2;

  /** 备注.备注3 */
  private String docRmrk3;

  /** WSID.WSID1 */
  private String bcMntnWsid1;

  /** WSID.WSID2 */
  private String bcMntnWsid2;

  /** WSID日期 */
  private Date bcMntnWsidDate;

  /** hidden：寄单行行号 */
  private String smileDispchDocBankCode;

  /** hidden：空值 */
  private String smileKeepword2;

  /** hidden：转让金额 */
  private String smileTrasfAmt;

  /** hidden：Charges.code1 */
  private String chgCode1;

  /** hidden：Charges.ccy1 */
  private String chgCcy1;

  /** hidden：Charges.Amount1 */
  private BigDecimal chgAmt1;

  /** hidden：Charges.code2 */
  private String chgCode2;

  /** hidden：Charges.ccy2 */
  private String chgCcy2;

  /** hidden：Charges.Amount2 */
  private BigDecimal chgAmt2;

  /** hidden：Charges.code3 */
  private String chgCode3;

  /** hidden：Charges.ccy3 */
  private String chgCcy3;

  /** hidden：Charges.Amount3 */
  private BigDecimal chgAmt3;

  /** hidden：Charges.code4 */
  private String chgCode4;

  /** hidden：Charges.ccy4 */
  private String chgCcy4;

  /** hidden：Charges.Amount4 */
  private BigDecimal chgAmt4;

  /** hidden：Charges.code5 */
  private String chgCode5;

  /** hidden：Charges.ccy5 */
  private String chgCcy5;

  /** hidden：Charges.Amount5 */
  private BigDecimal chgAmt5;

  /** hidden：改单前受益人CIF */
  private String modDocBfBeneCustNo;

  /** hidden：改单前BC记账科目.GL */
  private String modDocBfBcBookAcctSubjGl;

  /** hidden：改单前BC记账科目.SUB GL */
  private String modDocBfBcBookAcctSubjSubGl;

  /** hidden：改单前交易主参号 */
  private String modDocBfTxnPrmryRefNo;

  /** hidden：改单前交易子参号 */
  private String modDocBfTxnSubRefNo;

  /** hidden：改单前汇票金额.币种 */
  private String modDocBfBxCcy;

  /** hidden：改单前汇票金额.金额 */
  private BigDecimal modDocBfBxAmt;

  /** hidden：EX.Method */
  private String exMethod;

  /** hidden：信用证编号 */
  private String tmpLcNo;

  /** hidden：转让编号 */
  private String tmpTrasfNo;

  /** 手续费支付方 */
  private String feePayer;

  /** 手续费账户.币种 */
  private String feeAcctCcy;

  /** 手续费账户.GL */
  private String feeAcctGl;

  /** 手续费账户.SUB GL */
  private String feeAcctSubGl;

  /** 手续费账户.账号 */
  private String feeAcctNo;

  /** N/W区分 */
  private String noWfDist;

  /** Exchange信息(手续费).EX.Method */
  private String feeExMethod;

  /** Exchange信息(手续费).Quote */
  private String quote;

  /** Exchange信息(手续费).Cont.No.No.1 */
  private String contNo1;

  /** Exchange信息(手续费).Cont.No.No.2 */
  private String contNo2;

  /** Exchange信息(手续费).Rate */
  private BigDecimal rate;

  /** Exchange信息(手续费).M/D */
  private String md;

  /** hidden：我行通知信用证标志*/
  private String ourBkNtcLc;

  /** 定价状态 */
  private String pricingStatus;

  /** 寄单信息 */
  private List<DispchDocInfoVO> dispchDocInfoVOList;

  /** 信用证信息 */
  private ExpLcMntnOpDtlVO expLcMntnOpDtlVO;

  /** 拒付编号VO */
  private DishnrHistInfoVO dishnrHistInfoVO;

  /** 故障编号VO */
  private FaultHistInfoVO faultHistInfoVO;
  
  /** Combined LC信息List */
  private List<BbCombLcMntnOpDtlVO> bbCombLcMntnOpDtlVoList;

  /**
   * @return bbCombLcMntnOpDtlVoList
   */
  public List<BbCombLcMntnOpDtlVO> getBbCombLcMntnOpDtlVoList() {
    return bbCombLcMntnOpDtlVoList;
  }

  /**
   * @param bbCombLcMntnOpDtlVoList 要设置的 bbCombLcMntnOpDtlVoList
   */
  public void setBbCombLcMntnOpDtlVoList(
      List<BbCombLcMntnOpDtlVO> bbCombLcMntnOpDtlVoList) {
    this.bbCombLcMntnOpDtlVoList = bbCombLcMntnOpDtlVoList;
  }

  /**
   * @return agcBankFlg
   */
  public String getAgcBankFlg() {
    return agcBankFlg;
  }

  /**
   * @param agcBankFlg 
   *				要设置的 agcBankFlg
   */
  public void setAgcBankFlg(String agcBankFlg) {
    this.agcBankFlg = agcBankFlg;
  }

  /**
   * @return alertCountry
   */
  public String getAlertCountry() {
    return alertCountry;
  }

  /**
   * @param alertCountry 
   *				要设置的 alertCountry
   */
  public void setAlertCountry(String alertCountry) {
    this.alertCountry = alertCountry;
  }

  /**
   * @return bcBookAcctGl
   */
  public String getBcBookAcctGl() {
    return bcBookAcctGl;
  }

  /**
   * @param bcBookAcctGl 
   *				要设置的 bcBookAcctGl
   */
  public void setBcBookAcctGl(String bcBookAcctGl) {
    this.bcBookAcctGl = bcBookAcctGl;
  }

  /**
   * @return bcBookAcctSubGl
   */
  public String getBcBookAcctSubGl() {
    return bcBookAcctSubGl;
  }

  /**
   * @param bcBookAcctSubGl 
   *				要设置的 bcBookAcctSubGl
   */
  public void setBcBookAcctSubGl(String bcBookAcctSubGl) {
    this.bcBookAcctSubGl = bcBookAcctSubGl;
  }

  /**
   * @return bcMntnWsid1
   */
  public String getBcMntnWsid1() {
    return bcMntnWsid1;
  }

  /**
   * @param bcMntnWsid1 
   *				要设置的 bcMntnWsid1
   */
  public void setBcMntnWsid1(String bcMntnWsid1) {
    this.bcMntnWsid1 = bcMntnWsid1;
  }

  /**
   * @return bcMntnWsid2
   */
  public String getBcMntnWsid2() {
    return bcMntnWsid2;
  }

  /**
   * @param bcMntnWsid2 
   *				要设置的 bcMntnWsid2
   */
  public void setBcMntnWsid2(String bcMntnWsid2) {
    this.bcMntnWsid2 = bcMntnWsid2;
  }

  /**
   * @return bcMntnWsidDate
   */
  public Date getBcMntnWsidDate() {
    return bcMntnWsidDate;
  }

  /**
   * @param bcMntnWsidDate 
   *				要设置的 bcMntnWsidDate
   */
  public void setBcMntnWsidDate(Date bcMntnWsidDate) {
    this.bcMntnWsidDate = bcMntnWsidDate;
  }

  /**
   * @return bene1stAcctCcy
   */
  public String getBene1stAcctCcy() {
    return bene1stAcctCcy;
  }

  /**
   * @param bene1stAcctCcy 
   *				要设置的 bene1stAcctCcy
   */
  public void setBene1stAcctCcy(String bene1stAcctCcy) {
    this.bene1stAcctCcy = bene1stAcctCcy;
  }

  /**
   * @return bene1stAcctGl
   */
  public String getBene1stAcctGl() {
    return bene1stAcctGl;
  }

  /**
   * @param bene1stAcctGl 
   *				要设置的 bene1stAcctGl
   */
  public void setBene1stAcctGl(String bene1stAcctGl) {
    this.bene1stAcctGl = bene1stAcctGl;
  }

  /**
   * @return bene1stAcctNo
   */
  public String getBene1stAcctNo() {
    return bene1stAcctNo;
  }

  /**
   * @param bene1stAcctNo 
   *				要设置的 bene1stAcctNo
   */
  public void setBene1stAcctNo(String bene1stAcctNo) {
    this.bene1stAcctNo = bene1stAcctNo;
  }

  /**
   * @return bene1stAcctSubGl
   */
  public String getBene1stAcctSubGl() {
    return bene1stAcctSubGl;
  }

  /**
   * @param bene1stAcctSubGl 
   *				要设置的 bene1stAcctSubGl
   */
  public void setBene1stAcctSubGl(String bene1stAcctSubGl) {
    this.bene1stAcctSubGl = bene1stAcctSubGl;
  }

  /**
   * @return bene2ndCity
   */
  public String getBene2ndCity() {
    return bene2ndCity;
  }

  /**
   * @param bene2ndCity 
   *				要设置的 bene2ndCity
   */
  public void setBene2ndCity(String bene2ndCity) {
    this.bene2ndCity = bene2ndCity;
  }

  /**
   * @return bene2ndName
   */
  public String getBene2ndName() {
    return bene2ndName;
  }

  /**
   * @param bene2ndName 
   *				要设置的 bene2ndName
   */
  public void setBene2ndName(String bene2ndName) {
    this.bene2ndName = bene2ndName;
  }

  /**
   * @return bene2ndNatnlty
   */
  public String getBene2ndNatnlty() {
    return bene2ndNatnlty;
  }

  /**
   * @param bene2ndNatnlty 
   *				要设置的 bene2ndNatnlty
   */
  public void setBene2ndNatnlty(String bene2ndNatnlty) {
    this.bene2ndNatnlty = bene2ndNatnlty;
  }

  /**
   * @return bene2ndNoticeBankName
   */
  public String getBene2ndNoticeBankName() {
    return bene2ndNoticeBankName;
  }

  /**
   * @param bene2ndNoticeBankName 
   *				要设置的 bene2ndNoticeBankName
   */
  public void setBene2ndNoticeBankName(String bene2ndNoticeBankName) {
    this.bene2ndNoticeBankName = bene2ndNoticeBankName;
  }

  /**
   * @return bene2ndNoticeBankSwiftCode
   */
  public String getBene2ndNoticeBankSwiftCode() {
    return bene2ndNoticeBankSwiftCode;
  }

  /**
   * @param bene2ndNoticeBankSwiftCode 
   *				要设置的 bene2ndNoticeBankSwiftCode
   */
  public void setBene2ndNoticeBankSwiftCode(String bene2ndNoticeBankSwiftCode) {
    this.bene2ndNoticeBankSwiftCode = bene2ndNoticeBankSwiftCode;
  }

  /**
   * @return bene2ndProv
   */
  public String getBene2ndProv() {
    return bene2ndProv;
  }

  /**
   * @param bene2ndProv 
   *				要设置的 bene2ndProv
   */
  public void setBene2ndProv(String bene2ndProv) {
    this.bene2ndProv = bene2ndProv;
  }

  /**
   * @return beneAcctCcy
   */
  public String getBeneAcctCcy() {
    return beneAcctCcy;
  }

  /**
   * @param beneAcctCcy 
   *				要设置的 beneAcctCcy
   */
  public void setBeneAcctCcy(String beneAcctCcy) {
    this.beneAcctCcy = beneAcctCcy;
  }

  /**
   * @return beneAcctGl
   */
  public String getBeneAcctGl() {
    return beneAcctGl;
  }

  /**
   * @param beneAcctGl 
   *				要设置的 beneAcctGl
   */
  public void setBeneAcctGl(String beneAcctGl) {
    this.beneAcctGl = beneAcctGl;
  }

  /**
   * @return beneAcctNo
   */
  public String getBeneAcctNo() {
    return beneAcctNo;
  }

  /**
   * @param beneAcctNo 
   *				要设置的 beneAcctNo
   */
  public void setBeneAcctNo(String beneAcctNo) {
    this.beneAcctNo = beneAcctNo;
  }

  /**
   * @return beneAcctSubGl
   */
  public String getBeneAcctSubGl() {
    return beneAcctSubGl;
  }

  /**
   * @param beneAcctSubGl 
   *				要设置的 beneAcctSubGl
   */
  public void setBeneAcctSubGl(String beneAcctSubGl) {
    this.beneAcctSubGl = beneAcctSubGl;
  }

  /**
   * @return beneCif
   */
  public String getBeneCif() {
    return beneCif;
  }

  /**
   * @param beneCif 
   *				要设置的 beneCif
   */
  public void setBeneCif(String beneCif) {
    this.beneCif = beneCif;
  }

  /**
   * @return beneName
   */
  public String getBeneName() {
    return beneName;
  }

  /**
   * @param beneName 
   *				要设置的 beneName
   */
  public void setBeneName(String beneName) {
    this.beneName = beneName;
  }

  /**
   * @return beneOurCustFlg
   */
  public String getBeneOurCustFlg() {
    return beneOurCustFlg;
  }

  /**
   * @param beneOurCustFlg 
   *				要设置的 beneOurCustFlg
   */
  public void setBeneOurCustFlg(String beneOurCustFlg) {
    this.beneOurCustFlg = beneOurCustFlg;
  }

  /**
   * @return blDate
   */
  public Date getBlDate() {
    return blDate;
  }

  /**
   * @param blDate 
   *				要设置的 blDate
   */
  public void setBlDate(Date blDate) {
    this.blDate = blDate;
  }

  /**
   * @return bondedAreaAttbt
   */
  public String getBondedAreaAttbt() {
    return bondedAreaAttbt;
  }

  /**
   * @param bondedAreaAttbt 
   *				要设置的 bondedAreaAttbt
   */
  public void setBondedAreaAttbt(String bondedAreaAttbt) {
    this.bondedAreaAttbt = bondedAreaAttbt;
  }

  /**
   * @return bondedAreaFlg
   */
  public String getBondedAreaFlg() {
    return bondedAreaFlg;
  }

  /**
   * @param bondedAreaFlg 
   *				要设置的 bondedAreaFlg
   */
  public void setBondedAreaFlg(String bondedAreaFlg) {
    this.bondedAreaFlg = bondedAreaFlg;
  }

  /**
   * @return bpoFlg
   */
  public String getBpoFlg() {
    return bpoFlg;
  }

  /**
   * @param bpoFlg 
   *				要设置的 bpoFlg
   */
  public void setBpoFlg(String bpoFlg) {
    this.bpoFlg = bpoFlg;
  }

  /**
   * @return bxAmt
   */
  public BigDecimal getBxAmt() {
    return bxAmt;
  }

  /**
   * @param bxAmt 
   *				要设置的 bxAmt
   */
  public void setBxAmt(BigDecimal bxAmt) {
    this.bxAmt = bxAmt;
  }

  /**
   * @return bxCcy
   */
  public String getBxCcy() {
    return bxCcy;
  }

  /**
   * @param bxCcy 
   *				要设置的 bxCcy
   */
  public void setBxCcy(String bxCcy) {
    this.bxCcy = bxCcy;
  }

  /**
   * @return chgAmt1
   */
  public BigDecimal getChgAmt1() {
    return chgAmt1;
  }

  /**
   * @param chgAmt1 
   *				要设置的 chgAmt1
   */
  public void setChgAmt1(BigDecimal chgAmt1) {
    this.chgAmt1 = chgAmt1;
  }

  /**
   * @return chgAmt2
   */
  public BigDecimal getChgAmt2() {
    return chgAmt2;
  }

  /**
   * @param chgAmt2 
   *				要设置的 chgAmt2
   */
  public void setChgAmt2(BigDecimal chgAmt2) {
    this.chgAmt2 = chgAmt2;
  }

  /**
   * @return chgAmt3
   */
  public BigDecimal getChgAmt3() {
    return chgAmt3;
  }

  /**
   * @param chgAmt3 
   *				要设置的 chgAmt3
   */
  public void setChgAmt3(BigDecimal chgAmt3) {
    this.chgAmt3 = chgAmt3;
  }

  /**
   * @return chgAmt4
   */
  public BigDecimal getChgAmt4() {
    return chgAmt4;
  }

  /**
   * @param chgAmt4 
   *				要设置的 chgAmt4
   */
  public void setChgAmt4(BigDecimal chgAmt4) {
    this.chgAmt4 = chgAmt4;
  }

  /**
   * @return chgAmt5
   */
  public BigDecimal getChgAmt5() {
    return chgAmt5;
  }

  /**
   * @param chgAmt5 
   *				要设置的 chgAmt5
   */
  public void setChgAmt5(BigDecimal chgAmt5) {
    this.chgAmt5 = chgAmt5;
  }

  /**
   * @return chgCcy1
   */
  public String getChgCcy1() {
    return chgCcy1;
  }

  /**
   * @param chgCcy1 
   *				要设置的 chgCcy1
   */
  public void setChgCcy1(String chgCcy1) {
    this.chgCcy1 = chgCcy1;
  }

  /**
   * @return chgCcy2
   */
  public String getChgCcy2() {
    return chgCcy2;
  }

  /**
   * @param chgCcy2 
   *				要设置的 chgCcy2
   */
  public void setChgCcy2(String chgCcy2) {
    this.chgCcy2 = chgCcy2;
  }

  /**
   * @return chgCcy3
   */
  public String getChgCcy3() {
    return chgCcy3;
  }

  /**
   * @param chgCcy3 
   *				要设置的 chgCcy3
   */
  public void setChgCcy3(String chgCcy3) {
    this.chgCcy3 = chgCcy3;
  }

  /**
   * @return chgCcy4
   */
  public String getChgCcy4() {
    return chgCcy4;
  }

  /**
   * @param chgCcy4 
   *				要设置的 chgCcy4
   */
  public void setChgCcy4(String chgCcy4) {
    this.chgCcy4 = chgCcy4;
  }

  /**
   * @return chgCcy5
   */
  public String getChgCcy5() {
    return chgCcy5;
  }

  /**
   * @param chgCcy5 
   *				要设置的 chgCcy5
   */
  public void setChgCcy5(String chgCcy5) {
    this.chgCcy5 = chgCcy5;
  }

  /**
   * @return chgCode1
   */
  public String getChgCode1() {
    return chgCode1;
  }

  /**
   * @param chgCode1 
   *				要设置的 chgCode1
   */
  public void setChgCode1(String chgCode1) {
    this.chgCode1 = chgCode1;
  }

  /**
   * @return chgCode2
   */
  public String getChgCode2() {
    return chgCode2;
  }

  /**
   * @param chgCode2 
   *				要设置的 chgCode2
   */
  public void setChgCode2(String chgCode2) {
    this.chgCode2 = chgCode2;
  }

  /**
   * @return chgCode3
   */
  public String getChgCode3() {
    return chgCode3;
  }

  /**
   * @param chgCode3 
   *				要设置的 chgCode3
   */
  public void setChgCode3(String chgCode3) {
    this.chgCode3 = chgCode3;
  }

  /**
   * @return chgCode4
   */
  public String getChgCode4() {
    return chgCode4;
  }

  /**
   * @param chgCode4 
   *				要设置的 chgCode4
   */
  public void setChgCode4(String chgCode4) {
    this.chgCode4 = chgCode4;
  }

  /**
   * @return chgCode5
   */
  public String getChgCode5() {
    return chgCode5;
  }

  /**
   * @param chgCode5 
   *				要设置的 chgCode5
   */
  public void setChgCode5(String chgCode5) {
    this.chgCode5 = chgCode5;
  }

  /**
   * @return chqKind
   */
  public String getChqKind() {
    return chqKind;
  }

  /**
   * @param chqKind 
   *				要设置的 chqKind
   */
  public void setChqKind(String chqKind) {
    this.chqKind = chqKind;
  }

  /**
   * @return clrBankAcctCcy
   */
  public String getClrBankAcctCcy() {
    return clrBankAcctCcy;
  }

  /**
   * @param clrBankAcctCcy 
   *				要设置的 clrBankAcctCcy
   */
  public void setClrBankAcctCcy(String clrBankAcctCcy) {
    this.clrBankAcctCcy = clrBankAcctCcy;
  }

  /**
   * @return clrBankAcctGl
   */
  public String getClrBankAcctGl() {
    return clrBankAcctGl;
  }

  /**
   * @param clrBankAcctGl 
   *				要设置的 clrBankAcctGl
   */
  public void setClrBankAcctGl(String clrBankAcctGl) {
    this.clrBankAcctGl = clrBankAcctGl;
  }

  /**
   * @return clrBankAcctNo
   */
  public String getClrBankAcctNo() {
    return clrBankAcctNo;
  }

  /**
   * @param clrBankAcctNo 
   *				要设置的 clrBankAcctNo
   */
  public void setClrBankAcctNo(String clrBankAcctNo) {
    this.clrBankAcctNo = clrBankAcctNo;
  }

  /**
   * @return clrBankAcctSubGl
   */
  public String getClrBankAcctSubGl() {
    return clrBankAcctSubGl;
  }

  /**
   * @param clrBankAcctSubGl 
   *				要设置的 clrBankAcctSubGl
   */
  public void setClrBankAcctSubGl(String clrBankAcctSubGl) {
    this.clrBankAcctSubGl = clrBankAcctSubGl;
  }

  /**
   * @return clrBankInfo
   */
  public String getClrBankInfo() {
    return clrBankInfo;
  }

  /**
   * @param clrBankInfo 
   *				要设置的 clrBankInfo
   */
  public void setClrBankInfo(String clrBankInfo) {
    this.clrBankInfo = clrBankInfo;
  }

  /**
   * @return collDate
   */
  public Date getCollDate() {
    return collDate;
  }

  /**
   * @param collDate 
   *				要设置的 collDate
   */
  public void setCollDate(Date collDate) {
    this.collDate = collDate;
  }

  /**
   * @return combinedLcFlg
   */
  public String getCombinedLcFlg() {
    return combinedLcFlg;
  }

  /**
   * @param combinedLcFlg 
   *				要设置的 combinedLcFlg
   */
  public void setCombinedLcFlg(String combinedLcFlg) {
    this.combinedLcFlg = combinedLcFlg;
  }

  /**
   * @return confmdPrmryRefNo
   */
  public String getConfmdPrmryRefNo() {
    return confmdPrmryRefNo;
  }

  /**
   * @param confmdPrmryRefNo 
   *				要设置的 confmdPrmryRefNo
   */
  public void setConfmdPrmryRefNo(String confmdPrmryRefNo) {
    this.confmdPrmryRefNo = confmdPrmryRefNo;
  }

  /**
   * @return confmdRmrk
   */
  public String getConfmdRmrk() {
    return confmdRmrk;
  }

  /**
   * @param confmdRmrk 
   *				要设置的 confmdRmrk
   */
  public void setConfmdRmrk(String confmdRmrk) {
    this.confmdRmrk = confmdRmrk;
  }

  /**
   * @return confmdSubRefNo
   */
  public String getConfmdSubRefNo() {
    return confmdSubRefNo;
  }

  /**
   * @param confmdSubRefNo 
   *				要设置的 confmdSubRefNo
   */
  public void setConfmdSubRefNo(String confmdSubRefNo) {
    this.confmdSubRefNo = confmdSubRefNo;
  }

  /**
   * @return confmdTKind
   */
  public String getConfmdTKind() {
    return confmdTKind;
  }

  /**
   * @param confmdTKind 
   *				要设置的 confmdTKind
   */
  public void setConfmdTKind(String confmdTKind) {
    this.confmdTKind = confmdTKind;
  }

  /**
   * @return crsBorderRmbFlg
   */
  public String getCrsBorderRmbFlg() {
    return crsBorderRmbFlg;
  }

  /**
   * @param crsBorderRmbFlg 
   *				要设置的 crsBorderRmbFlg
   */
  public void setCrsBorderRmbFlg(String crsBorderRmbFlg) {
    this.crsBorderRmbFlg = crsBorderRmbFlg;
  }

  /**
   * @return delvrMeth
   */
  public String getDelvrMeth() {
    return delvrMeth;
  }

  /**
   * @param delvrMeth 
   *				要设置的 delvrMeth
   */
  public void setDelvrMeth(String delvrMeth) {
    this.delvrMeth = delvrMeth;
  }

  /**
   * @return dispchDocBankAddr
   */
  public String getDispchDocBankAddr() {
    return dispchDocBankAddr;
  }

  /**
   * @param dispchDocBankAddr 
   *				要设置的 dispchDocBankAddr
   */
  public void setDispchDocBankAddr(String dispchDocBankAddr) {
    this.dispchDocBankAddr = dispchDocBankAddr;
  }

  /**
   * @return dispchDocBankCode
   */
  public String getDispchDocBankCode() {
    return dispchDocBankCode;
  }

  /**
   * @param dispchDocBankCode 
   *				要设置的 dispchDocBankCode
   */
  public void setDispchDocBankCode(String dispchDocBankCode) {
    this.dispchDocBankCode = dispchDocBankCode;
  }

  /**
   * @return dispchDocBankName
   */
  public String getDispchDocBankName() {
    return dispchDocBankName;
  }

  /**
   * @param dispchDocBankName 
   *				要设置的 dispchDocBankName
   */
  public void setDispchDocBankName(String dispchDocBankName) {
    this.dispchDocBankName = dispchDocBankName;
  }

  /**
   * @return dispchDocBankSwift
   */
  public String getDispchDocBankSwift() {
    return dispchDocBankSwift;
  }

  /**
   * @param dispchDocBankSwift 
   *				要设置的 dispchDocBankSwift
   */
  public void setDispchDocBankSwift(String dispchDocBankSwift) {
    this.dispchDocBankSwift = dispchDocBankSwift;
  }

  /**
   * @return docClean
   */
  public String getDocClean() {
    return docClean;
  }

  /**
   * @param docClean 
   *				要设置的 docClean
   */
  public void setDocClean(String docClean) {
    this.docClean = docClean;
  }

  /**
   * @return docIvcNo
   */
  public String getDocIvcNo() {
    return docIvcNo;
  }

  /**
   * @param docIvcNo 
   *				要设置的 docIvcNo
   */
  public void setDocIvcNo(String docIvcNo) {
    this.docIvcNo = docIvcNo;
  }

  /**
   * @return docRmrk1
   */
  public String getDocRmrk1() {
    return docRmrk1;
  }

  /**
   * @param docRmrk1 
   *				要设置的 docRmrk1
   */
  public void setDocRmrk1(String docRmrk1) {
    this.docRmrk1 = docRmrk1;
  }

  /**
   * @return docRmrk2
   */
  public String getDocRmrk2() {
    return docRmrk2;
  }

  /**
   * @param docRmrk2 
   *				要设置的 docRmrk2
   */
  public void setDocRmrk2(String docRmrk2) {
    this.docRmrk2 = docRmrk2;
  }

  /**
   * @return docRmrk3
   */
  public String getDocRmrk3() {
    return docRmrk3;
  }

  /**
   * @param docRmrk3 
   *				要设置的 docRmrk3
   */
  public void setDocRmrk3(String docRmrk3) {
    this.docRmrk3 = docRmrk3;
  }

  /**
   * @return dueDate
   */
  public Date getDueDate() {
    return dueDate;
  }

  /**
   * @param dueDate 
   *				要设置的 dueDate
   */
  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  /**
   * @return exMethod
   */
  public String getExMethod() {
    return exMethod;
  }

  /**
   * @param exMethod 
   *				要设置的 exMethod
   */
  public void setExMethod(String exMethod) {
    this.exMethod = exMethod;
  }

  /**
   * @return fakeForwdFlg
   */
  public String getFakeForwdFlg() {
    return fakeForwdFlg;
  }

  /**
   * @param fakeForwdFlg 
   *				要设置的 fakeForwdFlg
   */
  public void setFakeForwdFlg(String fakeForwdFlg) {
    this.fakeForwdFlg = fakeForwdFlg;
  }

  /**
   * @return finalDueDate
   */
  public Date getFinalDueDate() {
    return finalDueDate;
  }

  /**
   * @param finalDueDate 
   *				要设置的 finalDueDate
   */
  public void setFinalDueDate(Date finalDueDate) {
    this.finalDueDate = finalDueDate;
  }

  /**
   * @return goods
   */
  public String getGoods() {
    return goods;
  }

  /**
   * @param goods 
   *				要设置的 goods
   */
  public void setGoods(String goods) {
    this.goods = goods;
  }

  /**
   * @return imptrName
   */
  public String getImptrName() {
    return imptrName;
  }

  /**
   * @param imptrName 
   *				要设置的 imptrName
   */
  public void setImptrName(String imptrName) {
    this.imptrName = imptrName;
  }

  /**
   * @return imptrNatnlty
   */
  public String getImptrNatnlty() {
    return imptrNatnlty;
  }

  /**
   * @param imptrNatnlty 
   *				要设置的 imptrNatnlty
   */
  public void setImptrNatnlty(String imptrNatnlty) {
    this.imptrNatnlty = imptrNatnlty;
  }

  /**
   * @return internetFlg
   */
  public String getInternetFlg() {
    return internetFlg;
  }

  /**
   * @param internetFlg 
   *				要设置的 internetFlg
   */
  public void setInternetFlg(String internetFlg) {
    this.internetFlg = internetFlg;
  }

  /**
   * @return ivcNo
   */
  public String getIvcNo() {
    return ivcNo;
  }

  /**
   * @param ivcNo 
   *				要设置的 ivcNo
   */
  public void setIvcNo(String ivcNo) {
    this.ivcNo = ivcNo;
  }

  /**
   * @return lcFlg
   */
  public String getLcFlg() {
    return lcFlg;
  }

  /**
   * @param lcFlg 
   *				要设置的 lcFlg
   */
  public void setLcFlg(String lcFlg) {
    this.lcFlg = lcFlg;
  }

  /**
   * @return lcNo
   */
  public String getLcNo() {
    return lcNo;
  }

  /**
   * @param lcNo 
   *				要设置的 lcNo
   */
  public void setLcNo(String lcNo) {
    this.lcNo = lcNo;
  }

  /**
   * @return modDocBfBcBookAcctSubjGl
   */
  public String getModDocBfBcBookAcctSubjGl() {
    return modDocBfBcBookAcctSubjGl;
  }

  /**
   * @param modDocBfBcBookAcctSubjGl 
   *				要设置的 modDocBfBcBookAcctSubjGl
   */
  public void setModDocBfBcBookAcctSubjGl(String modDocBfBcBookAcctSubjGl) {
    this.modDocBfBcBookAcctSubjGl = modDocBfBcBookAcctSubjGl;
  }

  /**
   * @return modDocBfBcBookAcctSubjSubGl
   */
  public String getModDocBfBcBookAcctSubjSubGl() {
    return modDocBfBcBookAcctSubjSubGl;
  }

  /**
   * @param modDocBfBcBookAcctSubjSubGl 
   *				要设置的 modDocBfBcBookAcctSubjSubGl
   */
  public void setModDocBfBcBookAcctSubjSubGl(String modDocBfBcBookAcctSubjSubGl) {
    this.modDocBfBcBookAcctSubjSubGl = modDocBfBcBookAcctSubjSubGl;
  }

  /**
   * @return modDocBfBeneCustNo
   */
  public String getModDocBfBeneCustNo() {
    return modDocBfBeneCustNo;
  }

  /**
   * @param modDocBfBeneCustNo 
   *				要设置的 modDocBfBeneCustNo
   */
  public void setModDocBfBeneCustNo(String modDocBfBeneCustNo) {
    this.modDocBfBeneCustNo = modDocBfBeneCustNo;
  }

  /**
   * @return modDocBfBxAmt
   */
  public BigDecimal getModDocBfBxAmt() {
    return modDocBfBxAmt;
  }

  /**
   * @param modDocBfBxAmt 
   *				要设置的 modDocBfBxAmt
   */
  public void setModDocBfBxAmt(BigDecimal modDocBfBxAmt) {
    this.modDocBfBxAmt = modDocBfBxAmt;
  }

  /**
   * @return modDocBfBxCcy
   */
  public String getModDocBfBxCcy() {
    return modDocBfBxCcy;
  }

  /**
   * @param modDocBfBxCcy 
   *				要设置的 modDocBfBxCcy
   */
  public void setModDocBfBxCcy(String modDocBfBxCcy) {
    this.modDocBfBxCcy = modDocBfBxCcy;
  }

  /**
   * @return modDocBfTxnPrmryRefNo
   */
  public String getModDocBfTxnPrmryRefNo() {
    return modDocBfTxnPrmryRefNo;
  }

  /**
   * @param modDocBfTxnPrmryRefNo 
   *				要设置的 modDocBfTxnPrmryRefNo
   */
  public void setModDocBfTxnPrmryRefNo(String modDocBfTxnPrmryRefNo) {
    this.modDocBfTxnPrmryRefNo = modDocBfTxnPrmryRefNo;
  }

  /**
   * @return modDocBfTxnSubRefNo
   */
  public String getModDocBfTxnSubRefNo() {
    return modDocBfTxnSubRefNo;
  }

  /**
   * @param modDocBfTxnSubRefNo 
   *				要设置的 modDocBfTxnSubRefNo
   */
  public void setModDocBfTxnSubRefNo(String modDocBfTxnSubRefNo) {
    this.modDocBfTxnSubRefNo = modDocBfTxnSubRefNo;
  }

  /**
   * @return natnlty
   */
  public String getNatnlty() {
    return natnlty;
  }

  /**
   * @param natnlty 
   *				要设置的 natnlty
   */
  public void setNatnlty(String natnlty) {
    this.natnlty = natnlty;
  }

  /**
   * @return newRmrk
   */
  public String getNewRmrk() {
    return newRmrk;
  }

  /**
   * @param newRmrk 
   *				要设置的 newRmrk
   */
  public void setNewRmrk(String newRmrk) {
    this.newRmrk = newRmrk;
  }

  /**
   * @return osaNraFlg
   */
  public String getOsaNraFlg() {
    return osaNraFlg;
  }

  /**
   * @param osaNraFlg 
   *				要设置的 osaNraFlg
   */
  public void setOsaNraFlg(String osaNraFlg) {
    this.osaNraFlg = osaNraFlg;
  }

  /**
   * @return otherItem
   */
  public String getOtherItem() {
    return otherItem;
  }

  /**
   * @param otherItem 
   *				要设置的 otherItem
   */
  public void setOtherItem(String otherItem) {
    this.otherItem = otherItem;
  }

  /**
   * @return perfmConfmDuties
   */
  public String getPerfmConfmDuties() {
    return perfmConfmDuties;
  }

  /**
   * @param perfmConfmDuties 
   *				要设置的 perfmConfmDuties
   */
  public void setPerfmConfmDuties(String perfmConfmDuties) {
    this.perfmConfmDuties = perfmConfmDuties;
  }

  /**
   * @return ppnegoFlg
   */
  public String getPpnegoFlg() {
    return ppnegoFlg;
  }

  /**
   * @param ppnegoFlg 
   *				要设置的 ppnegoFlg
   */
  public void setPpnegoFlg(String ppnegoFlg) {
    this.ppnegoFlg = ppnegoFlg;
  }

  /**
   * @return preInputNo
   */
  public String getPreInputNo() {
    return preInputNo;
  }

  /**
   * @param preInputNo 
   *				要设置的 preInputNo
   */
  public void setPreInputNo(String preInputNo) {
    this.preInputNo = preInputNo;
  }

  /**
   * @return preInputRmrk
   */
  public String getPreInputRmrk() {
    return preInputRmrk;
  }

  /**
   * @param preInputRmrk 
   *				要设置的 preInputRmrk
   */
  public void setPreInputRmrk(String preInputRmrk) {
    this.preInputRmrk = preInputRmrk;
  }

  /**
   * @return purpose
   */
  public String getPurpose() {
    return purpose;
  }

  /**
   * @param purpose 
   *				要设置的 purpose
   */
  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  /**
   * @return refuseCertfct
   */
  public String getRefuseCertfct() {
    return refuseCertfct;
  }

  /**
   * @param refuseCertfct 
   *				要设置的 refuseCertfct
   */
  public void setRefuseCertfct(String refuseCertfct) {
    this.refuseCertfct = refuseCertfct;
  }

  /**
   * @return regDate
   */
  public Date getRegDate() {
    return regDate;
  }

  /**
   * @param regDate 
   *				要设置的 regDate
   */
  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  /**
   * @return sigdGatfa
   */
  public String getSigdGatfa() {
    return sigdGatfa;
  }

  /**
   * @param sigdGatfa 
   *				要设置的 sigdGatfa
   */
  public void setSigdGatfa(String sigdGatfa) {
    this.sigdGatfa = sigdGatfa;
  }

  /**
   * @return smileDispchDocBankCode
   */
  public String getSmileDispchDocBankCode() {
    return smileDispchDocBankCode;
  }

  /**
   * @param smileDispchDocBankCode 
   *				要设置的 smileDispchDocBankCode
   */
  public void setSmileDispchDocBankCode(String smileDispchDocBankCode) {
    this.smileDispchDocBankCode = smileDispchDocBankCode;
  }

  /**
   * @return smileKeepword2
   */
  public String getSmileKeepword2() {
    return smileKeepword2;
  }

  /**
   * @param smileKeepword2 
   *				要设置的 smileKeepword2
   */
  public void setSmileKeepword2(String smileKeepword2) {
    this.smileKeepword2 = smileKeepword2;
  }

  /**
   * @return telegNegoClsDate
   */
  public Date getTelegNegoClsDate() {
    return telegNegoClsDate;
  }

  /**
   * @param telegNegoClsDate 
   *				要设置的 telegNegoClsDate
   */
  public void setTelegNegoClsDate(Date telegNegoClsDate) {
    this.telegNegoClsDate = telegNegoClsDate;
  }

  /**
   * @return telegNegoFlg
   */
  public String getTelegNegoFlg() {
    return telegNegoFlg;
  }

  /**
   * @param telegNegoFlg 
   *				要设置的 telegNegoFlg
   */
  public void setTelegNegoFlg(String telegNegoFlg) {
    this.telegNegoFlg = telegNegoFlg;
  }

  /**
   * @return tenorDate
   */
  public Date getTenorDate() {
    return tenorDate;
  }

  /**
   * @param tenorDate 
   *				要设置的 tenorDate
   */
  public void setTenorDate(Date tenorDate) {
    this.tenorDate = tenorDate;
  }

  /**
   * @return tenorDays
   */
  public BigInteger getTenorDays() {
    return tenorDays;
  }

  /**
   * @param tenorDays 
   *				要设置的 tenorDays
   */
  public void setTenorDays(BigInteger tenorDays) {
    this.tenorDays = tenorDays;
  }

  /**
   * @return tenorType
   */
  public String getTenorType() {
    return tenorType;
  }

  /**
   * @param tenorType 
   *				要设置的 tenorType
   */
  public void setTenorType(String tenorType) {
    this.tenorType = tenorType;
  }

  /**
   * @return tkind
   */
  public String getTkind() {
    return tkind;
  }

  /**
   * @param tkind 
   *				要设置的 tkind
   */
  public void setTkind(String tkind) {
    this.tkind = tkind;
  }

  /**
   * @return tmpLcNo
   */
  public String getTmpLcNo() {
    return tmpLcNo;
  }

  /**
   * @param tmpLcNo 
   *				要设置的 tmpLcNo
   */
  public void setTmpLcNo(String tmpLcNo) {
    this.tmpLcNo = tmpLcNo;
  }

  /**
   * @return tmpTrasfNo
   */
  public String getTmpTrasfNo() {
    return tmpTrasfNo;
  }

  /**
   * @param tmpTrasfNo 
   *				要设置的 tmpTrasfNo
   */
  public void setTmpTrasfNo(String tmpTrasfNo) {
    this.tmpTrasfNo = tmpTrasfNo;
  }

  /**
   * @return trasf2ndBene
   */
  public String getTrasf2ndBene() {
    return trasf2ndBene;
  }

  /**
   * @param trasf2ndBene 
   *				要设置的 trasf2ndBene
   */
  public void setTrasf2ndBene(String trasf2ndBene) {
    this.trasf2ndBene = trasf2ndBene;
  }

  /**
   * @return trasfAmt
   */
  public BigDecimal getTrasfAmt() {
    return trasfAmt;
  }

  /**
   * @param trasfAmt 
   *				要设置的 trasfAmt
   */
  public void setTrasfAmt(BigDecimal trasfAmt) {
    this.trasfAmt = trasfAmt;
  }

  /**
   * @return trasfAmtCcy
   */
  public String getTrasfAmtCcy() {
    return trasfAmtCcy;
  }

  /**
   * @param trasfAmtCcy 
   *				要设置的 trasfAmtCcy
   */
  public void setTrasfAmtCcy(String trasfAmtCcy) {
    this.trasfAmtCcy = trasfAmtCcy;
  }

  /**
   * @return trasfNoPrmryRefNo
   */
  public String getTrasfNoPrmryRefNo() {
    return trasfNoPrmryRefNo;
  }

  /**
   * @param trasfNoPrmryRefNo 
   *				要设置的 trasfNoPrmryRefNo
   */
  public void setTrasfNoPrmryRefNo(String trasfNoPrmryRefNo) {
    this.trasfNoPrmryRefNo = trasfNoPrmryRefNo;
  }

  /**
   * @return trasfNoSubRefNo
   */
  public String getTrasfNoSubRefNo() {
    return trasfNoSubRefNo;
  }

  /**
   * @param trasfNoSubRefNo 
   *				要设置的 trasfNoSubRefNo
   */
  public void setTrasfNoSubRefNo(String trasfNoSubRefNo) {
    this.trasfNoSubRefNo = trasfNoSubRefNo;
  }

  /**
   * @return trasfOsaNraFlg
   */
  public String getTrasfOsaNraFlg() {
    return trasfOsaNraFlg;
  }

  /**
   * @param trasfOsaNraFlg 
   *				要设置的 trasfOsaNraFlg
   */
  public void setTrasfOsaNraFlg(String trasfOsaNraFlg) {
    this.trasfOsaNraFlg = trasfOsaNraFlg;
  }

  /**
   * @return trasfTKind
   */
  public String getTrasfTKind() {
    return trasfTKind;
  }

  /**
   * @param trasfTKind 
   *				要设置的 trasfTKind
   */
  public void setTrasfTKind(String trasfTKind) {
    this.trasfTKind = trasfTKind;
  }

  /**
   * @return tsuFlg
   */
  public String getTsuFlg() {
    return tsuFlg;
  }

  /**
   * @param tsuFlg 
   *				要设置的 tsuFlg
   */
  public void setTsuFlg(String tsuFlg) {
    this.tsuFlg = tsuFlg;
  }

  /**
   * @return txnPrmryRefNo
   */
  public String getTxnPrmryRefNo() {
    return txnPrmryRefNo;
  }

  /**
   * @param txnPrmryRefNo 
   *				要设置的 txnPrmryRefNo
   */
  public void setTxnPrmryRefNo(String txnPrmryRefNo) {
    this.txnPrmryRefNo = txnPrmryRefNo;
  }

  /**
   * @return txnSubRefNo
   */
  public String getTxnSubRefNo() {
    return txnSubRefNo;
  }

  /**
   * @param txnSubRefNo 
   *				要设置的 txnSubRefNo
   */
  public void setTxnSubRefNo(String txnSubRefNo) {
    this.txnSubRefNo = txnSubRefNo;
  }

  /**
   * @return undtk1stBeneFlg
   */
  public String getUndtk1stBeneFlg() {
    return undtk1stBeneFlg;
  }

  /**
   * @param undtk1stBeneFlg 
   *				要设置的 undtk1stBeneFlg
   */
  public void setUndtk1stBeneFlg(String undtk1stBeneFlg) {
    this.undtk1stBeneFlg = undtk1stBeneFlg;
  }

  /**
   * @return withRcsFlg
   */
  public String getWithRcsFlg() {
    return withRcsFlg;
  }

  /**
   * @param withRcsFlg 
   *				要设置的 withRcsFlg
   */
  public void setWithRcsFlg(String withRcsFlg) {
    this.withRcsFlg = withRcsFlg;
  }

  /**
   * @return contNo1
   */
  public String getContNo1() {
    return contNo1;
  }

  /**
   * @param contNo1 要设置的 contNo1
   */
  public void setContNo1(String contNo1) {
    this.contNo1 = contNo1;
  }

  /**
   * @return contNo2
   */
  public String getContNo2() {
    return contNo2;
  }

  /**
   * @param contNo2 要设置的 contNo2
   */
  public void setContNo2(String contNo2) {
    this.contNo2 = contNo2;
  }

  /**
   * @return feeAcctCcy
   */
  public String getFeeAcctCcy() {
    return feeAcctCcy;
  }

  /**
   * @param feeAcctCcy 要设置的 feeAcctCcy
   */
  public void setFeeAcctCcy(String feeAcctCcy) {
    this.feeAcctCcy = feeAcctCcy;
  }

  /**
   * @return feeAcctGl
   */
  public String getFeeAcctGl() {
    return feeAcctGl;
  }

  /**
   * @param feeAcctGl 要设置的 feeAcctGl
   */
  public void setFeeAcctGl(String feeAcctGl) {
    this.feeAcctGl = feeAcctGl;
  }

  /**
   * @return feeAcctNo
   */
  public String getFeeAcctNo() {
    return feeAcctNo;
  }

  /**
   * @param feeAcctNo 要设置的 feeAcctNo
   */
  public void setFeeAcctNo(String feeAcctNo) {
    this.feeAcctNo = feeAcctNo;
  }

  /**
   * @return feeAcctSubGl
   */
  public String getFeeAcctSubGl() {
    return feeAcctSubGl;
  }

  /**
   * @param feeAcctSubGl 要设置的 feeAcctSubGl
   */
  public void setFeeAcctSubGl(String feeAcctSubGl) {
    this.feeAcctSubGl = feeAcctSubGl;
  }

  /**
   * @return feeExMethod
   */
  public String getFeeExMethod() {
    return feeExMethod;
  }

  /**
   * @param feeExMethod 要设置的 feeExMethod
   */
  public void setFeeExMethod(String feeExMethod) {
    this.feeExMethod = feeExMethod;
  }

  /**
   * @return feePayer
   */
  public String getFeePayer() {
    return feePayer;
  }

  /**
   * @param feePayer 要设置的 feePayer
   */
  public void setFeePayer(String feePayer) {
    this.feePayer = feePayer;
  }

  /**
   * @return md
   */
  public String getMd() {
    return md;
  }

  /**
   * @param md 要设置的 md
   */
  public void setMd(String md) {
    this.md = md;
  }

  /**
   * @return noWfDist
   */
  public String getNoWfDist() {
    return noWfDist;
  }

  /**
   * @param noWfDist 要设置的 noWfDist
   */
  public void setNoWfDist(String noWfDist) {
    this.noWfDist = noWfDist;
  }

  /**
   * @return quote
   */
  public String getQuote() {
    return quote;
  }

  /**
   * @param quote 要设置的 quote
   */
  public void setQuote(String quote) {
    this.quote = quote;
  }

  /**
   * @return rate
   */
  public BigDecimal getRate() {
    return rate;
  }

  /**
   * @param rate 要设置的 rate
   */
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  /**
   * @return dispchDocInfoVOList
   */
  public List<DispchDocInfoVO> getDispchDocInfoVOList() {
    return dispchDocInfoVOList;
  }

  /**
   * @param dispchDocInfoVOList 要设置的 dispchDocInfoVOList
   */
  public void setDispchDocInfoVOList(List<DispchDocInfoVO> dispchDocInfoVOList) {
    this.dispchDocInfoVOList = dispchDocInfoVOList;
  }

  /**
   * @return dishnrHistInfoVO
   */
  public DishnrHistInfoVO getDishnrHistInfoVO() {
    return dishnrHistInfoVO;
  }

  /**
   * @param dishnrHistInfoVO 要设置的 dishnrHistInfoVO
   */
  public void setDishnrHistInfoVO(DishnrHistInfoVO dishnrHistInfoVO) {
    this.dishnrHistInfoVO = dishnrHistInfoVO;
  }

  /**
   * @return expLcMntnOpDtlVO
   */
  public ExpLcMntnOpDtlVO getExpLcMntnOpDtlVO() {
    return expLcMntnOpDtlVO;
  }

  /**
   * @param expLcMntnOpDtlVO 要设置的 expLcMntnOpDtlVO
   */
  public void setExpLcMntnOpDtlVO(ExpLcMntnOpDtlVO expLcMntnOpDtlVO) {
    this.expLcMntnOpDtlVO = expLcMntnOpDtlVO;
  }

  /**
   * @return faultHistInfoVO
   */
  public FaultHistInfoVO getFaultHistInfoVO() {
    return faultHistInfoVO;
  }

  /**
   * @param faultHistInfoVO 要设置的 faultHistInfoVO
   */
  public void setFaultHistInfoVO(FaultHistInfoVO faultHistInfoVO) {
    this.faultHistInfoVO = faultHistInfoVO;
  }

  /**
   * @return ourBkNtcLc
   */
  public String getOurBkNtcLc() {
    return ourBkNtcLc;
  }

  /**
   * @param ourBkNtcLc 要设置的 ourBkNtcLc
   */
  public void setOurBkNtcLc(String ourBkNtcLc) {
    this.ourBkNtcLc = ourBkNtcLc;
  }

  /**
   * @return smileTrasfAmt
   */
  public String getSmileTrasfAmt() {
    return smileTrasfAmt;
  }

  /**
   * @param smileTrasfAmt 要设置的 smileTrasfAmt
   */
  public void setSmileTrasfAmt(String smileTrasfAmt) {
    this.smileTrasfAmt = smileTrasfAmt;
  }

  /**
   * @return pricingStatus
   */
  public String getPricingStatus() {
    return pricingStatus;
  }

  /**
   * @param pricingStatus 要设置的 pricingStatus
   */
  public void setPricingStatus(String pricingStatus) {
    this.pricingStatus = pricingStatus;
  }
}
