package cn.com.btmu.art.biz.collection.vo;

import java.math.BigDecimal;
import java.util.Date;

/**	
 * ExpLcMntnOpDtlVO	
 * ？
 * @author ivision
 * @version 1.0.0
 */
public class ExpLcMntnOpDtlVO {
  /** 信用证金额.币种 */
  private String lcAmtCcy;

  /** 信用证金额.金额 */
  private BigDecimal lcAmt;

  /** 信用证余额.币种 */
  private String lcBalCcy;

  /** 信用证余额.金额 */
  private BigDecimal lcBalAmt;

  /** 开证日期 */
  private Date issueDate;

  /** 到期日期 */
  private Date dueDate;

  /** 第二受益人 */
  private String bene2ndFlg;

  /** 中转行 */
  private String trastBank;

  /** 中转行国别 */
  private String trastBankNatnlty;

  /** 进口商名称 */
  private String imptrName;

  /** 进口商国别 */
  private String imptrNatnlty;

  /** OSA/NRA */
  private String osaNraFlg;

  /** 寄单行同开证行 */
  private String dispchBankEqIssueFlg;

  /** 有偿付行 */
  private String withReimbsBankFlg;

  /** 允许电报偿付 */
  private String allowTelegReimbsFlg;

  /** 开证行.行号 */
  private String issueBankCode;

  /** 开证行.Swift */
  private String issueBankSwift;

  /** 开证行.名称 */
  private String issueBankName;

  /** 开证行.地址 */
  private String issueBankAddr;

  /** 寄单行.行号 */
  private String dispchDocBankCode;

  /** 寄单行.Swift */
  private String dispchDocBankSwift;

  /** 寄单行.名称 */
  private String dispchDocBankName;

  /** 寄单行.地址 */
  private String dispchDocBankAddr;

  /** 偿付行.行号 */
  private String reimbBankCode;

  /** 偿付行.Swift */
  private String reimbBankSwift;

  /** 偿付行.名称 */
  private String reimbBankName;

  /** 偿付行.地址 */
  private String reimbBankAddr;

  /** 我行保兑 */
  private String ourBankConfmdFlg;

  /** 我行承兑 */
  private String ourBankAccptceFlg;

  /** 转让信用证 */
  private String trasfLcFlg;

  /** 留行信用证 */
  private String kibLcFlg;

  /** 留行日期 */
  private Date kibLcDate;

  /** 警报国家 */
  private String alertCountry;

  /** 代理行 */
  private String agcBankFlg;

  /** 国内信用证 */
  private String domstcLcFlg;

  /** 其他事项 */
  private String otherItem;

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
   * @return allowTelegReimbsFlg
   */
  public String getAllowTelegReimbsFlg() {
    return allowTelegReimbsFlg;
  }

  /**
   * @param allowTelegReimbsFlg 
   *				要设置的 allowTelegReimbsFlg
   */
  public void setAllowTelegReimbsFlg(String allowTelegReimbsFlg) {
    this.allowTelegReimbsFlg = allowTelegReimbsFlg;
  }

  /**
   * @return bene2ndFlg
   */
  public String getBene2ndFlg() {
    return bene2ndFlg;
  }

  /**
   * @param bene2ndFlg 
   *				要设置的 bene2ndFlg
   */
  public void setBene2ndFlg(String bene2ndFlg) {
    this.bene2ndFlg = bene2ndFlg;
  }

  /**
   * @return dispchBankEqIssueFlg
   */
  public String getDispchBankEqIssueFlg() {
    return dispchBankEqIssueFlg;
  }

  /**
   * @param dispchBankEqIssueFlg 
   *				要设置的 dispchBankEqIssueFlg
   */
  public void setDispchBankEqIssueFlg(String dispchBankEqIssueFlg) {
    this.dispchBankEqIssueFlg = dispchBankEqIssueFlg;
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
   * @return domstcLcFlg
   */
  public String getDomstcLcFlg() {
    return domstcLcFlg;
  }

  /**
   * @param domstcLcFlg 
   *				要设置的 domstcLcFlg
   */
  public void setDomstcLcFlg(String domstcLcFlg) {
    this.domstcLcFlg = domstcLcFlg;
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
   * @return issueBankAddr
   */
  public String getIssueBankAddr() {
    return issueBankAddr;
  }

  /**
   * @param issueBankAddr 
   *				要设置的 issueBankAddr
   */
  public void setIssueBankAddr(String issueBankAddr) {
    this.issueBankAddr = issueBankAddr;
  }

  /**
   * @return issueBankCode
   */
  public String getIssueBankCode() {
    return issueBankCode;
  }

  /**
   * @param issueBankCode 
   *				要设置的 issueBankCode
   */
  public void setIssueBankCode(String issueBankCode) {
    this.issueBankCode = issueBankCode;
  }

  /**
   * @return issueBankName
   */
  public String getIssueBankName() {
    return issueBankName;
  }

  /**
   * @param issueBankName 
   *				要设置的 issueBankName
   */
  public void setIssueBankName(String issueBankName) {
    this.issueBankName = issueBankName;
  }

  /**
   * @return issueBankSwift
   */
  public String getIssueBankSwift() {
    return issueBankSwift;
  }

  /**
   * @param issueBankSwift 
   *				要设置的 issueBankSwift
   */
  public void setIssueBankSwift(String issueBankSwift) {
    this.issueBankSwift = issueBankSwift;
  }

  /**
   * @return issueDate
   */
  public Date getIssueDate() {
    return issueDate;
  }

  /**
   * @param issueDate 
   *				要设置的 issueDate
   */
  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

  /**
   * @return kibLcDate
   */
  public Date getKibLcDate() {
    return kibLcDate;
  }

  /**
   * @param kibLcDate 
   *				要设置的 kibLcDate
   */
  public void setKibLcDate(Date kibLcDate) {
    this.kibLcDate = kibLcDate;
  }

  /**
   * @return kibLcFlg
   */
  public String getKibLcFlg() {
    return kibLcFlg;
  }

  /**
   * @param kibLcFlg 
   *				要设置的 kibLcFlg
   */
  public void setKibLcFlg(String kibLcFlg) {
    this.kibLcFlg = kibLcFlg;
  }

  /**
   * @return lcAmt
   */
  public BigDecimal getLcAmt() {
    return lcAmt;
  }

  /**
   * @param lcAmt 
   *				要设置的 lcAmt
   */
  public void setLcAmt(BigDecimal lcAmt) {
    this.lcAmt = lcAmt;
  }

  /**
   * @return lcAmtCcy
   */
  public String getLcAmtCcy() {
    return lcAmtCcy;
  }

  /**
   * @param lcAmtCcy 
   *				要设置的 lcAmtCcy
   */
  public void setLcAmtCcy(String lcAmtCcy) {
    this.lcAmtCcy = lcAmtCcy;
  }

  /**
   * @return lcBalAmt
   */
  public BigDecimal getLcBalAmt() {
    return lcBalAmt;
  }

  /**
   * @param lcBalAmt 
   *				要设置的 lcBalAmt
   */
  public void setLcBalAmt(BigDecimal lcBalAmt) {
    this.lcBalAmt = lcBalAmt;
  }

  /**
   * @return lcBalCcy
   */
  public String getLcBalCcy() {
    return lcBalCcy;
  }

  /**
   * @param lcBalCcy 
   *				要设置的 lcBalCcy
   */
  public void setLcBalCcy(String lcBalCcy) {
    this.lcBalCcy = lcBalCcy;
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
   * @return ourBankAccptceFlg
   */
  public String getOurBankAccptceFlg() {
    return ourBankAccptceFlg;
  }

  /**
   * @param ourBankAccptceFlg 
   *				要设置的 ourBankAccptceFlg
   */
  public void setOurBankAccptceFlg(String ourBankAccptceFlg) {
    this.ourBankAccptceFlg = ourBankAccptceFlg;
  }

  /**
   * @return ourBankConfmdFlg
   */
  public String getOurBankConfmdFlg() {
    return ourBankConfmdFlg;
  }

  /**
   * @param ourBankConfmdFlg 
   *				要设置的 ourBankConfmdFlg
   */
  public void setOurBankConfmdFlg(String ourBankConfmdFlg) {
    this.ourBankConfmdFlg = ourBankConfmdFlg;
  }

  /**
   * @return reimbBankAddr
   */
  public String getReimbBankAddr() {
    return reimbBankAddr;
  }

  /**
   * @param reimbBankAddr 
   *				要设置的 reimbBankAddr
   */
  public void setReimbBankAddr(String reimbBankAddr) {
    this.reimbBankAddr = reimbBankAddr;
  }

  /**
   * @return reimbBankCode
   */
  public String getReimbBankCode() {
    return reimbBankCode;
  }

  /**
   * @param reimbBankCode 
   *				要设置的 reimbBankCode
   */
  public void setReimbBankCode(String reimbBankCode) {
    this.reimbBankCode = reimbBankCode;
  }

  /**
   * @return reimbBankName
   */
  public String getReimbBankName() {
    return reimbBankName;
  }

  /**
   * @param reimbBankName 
   *				要设置的 reimbBankName
   */
  public void setReimbBankName(String reimbBankName) {
    this.reimbBankName = reimbBankName;
  }

  /**
   * @return reimbBankSwift
   */
  public String getReimbBankSwift() {
    return reimbBankSwift;
  }

  /**
   * @param reimbBankSwift 
   *				要设置的 reimbBankSwift
   */
  public void setReimbBankSwift(String reimbBankSwift) {
    this.reimbBankSwift = reimbBankSwift;
  }

  /**
   * @return trasfLcFlg
   */
  public String getTrasfLcFlg() {
    return trasfLcFlg;
  }

  /**
   * @param trasfLcFlg 
   *				要设置的 trasfLcFlg
   */
  public void setTrasfLcFlg(String trasfLcFlg) {
    this.trasfLcFlg = trasfLcFlg;
  }

  /**
   * @return trastBank
   */
  public String getTrastBank() {
    return trastBank;
  }

  /**
   * @param trastBank 
   *				要设置的 trastBank
   */
  public void setTrastBank(String trastBank) {
    this.trastBank = trastBank;
  }

  /**
   * @return trastBankNatnlty
   */
  public String getTrastBankNatnlty() {
    return trastBankNatnlty;
  }

  /**
   * @param trastBankNatnlty 
   *				要设置的 trastBankNatnlty
   */
  public void setTrastBankNatnlty(String trastBankNatnlty) {
    this.trastBankNatnlty = trastBankNatnlty;
  }

  /**
   * @return withReimbsBankFlg
   */
  public String getWithReimbsBankFlg() {
    return withReimbsBankFlg;
  }

  /**
   * @param withReimbsBankFlg 
   *				要设置的 withReimbsBankFlg
   */
  public void setWithReimbsBankFlg(String withReimbsBankFlg) {
    this.withReimbsBankFlg = withReimbsBankFlg;
  }

}
