package cn.com.btmu.art.biz.collection.vo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**	
 * BbNoticeLettInfoVO	
 * 通知书打印详情用VO
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BbNoticeLettInfoVO {
  /** 前台一览进详情对应的操作类型 */
  private String hidBtnType;
  
  /** 主键ID */
  private int ntid;
  
  /** 种类 */
  private String type;

  /** 转让编号.T-kind */
  private String trasfTKind;

  /** 转让编号.主参号 */
  private String trasfNoPrmryRefNo;

  /** 转让编号.子参号 */
  private String trasfNoSubRefNo;

  /** 登记日 */
  private Date regDate;
  
  /** 结算方式.信用证 */
  private String lcStlmtMeth;

  /** 结算方式.保函 */
  private String lgStlmtMeth;

  /** 结算方式.托收 */
  private String collStlmtMeth;

  /** 结算方式.其他 */
  private String otherStlmtMeth;

  /** 信用证编号 */
  private String lcNo;

  /** 来单金额.币种 */
  private String docRecvdCcy;

  /** 来单金额.金额 */
  private BigDecimal docRecvdAmt;

  /** 开证日期 */
  private Date issueDate;

  /** 索汇金额.币种 */
  private String clmExchgAmtCcy;

  /** 索汇金额.金额 */
  private BigDecimal clmExchgAmt;

  /** 期限 */
  private String term;

  /** 到期日 */
  private Date dueDate;

  /** 来单行名称 */
  private String docRecvdBankName;

  /** 来单行编号 */
  private String docRecvdBankNo;

  /** 来单行邮件号 */
  private String docRecvdBankMailNo;

  /** 收款人名称 */
  private String payeeName;

  /** 收款行名称及地址 */
  private String recvgBankNameAndAddr;

  /** 付款人名称 */
  private String payerName;

  /** 对公 */
  private String toPubFlg;

  /** 组织机构代码.代码1 */
  private String orgCode1;

  /** 组织机构代码.代码2 */
  private String orgCode2;

  /** 对私 */
  private String toPrivtFlg;

  /** 个人身份证 */
  private String personalId;

  /** 中国居民个人 */
  private String cnResdnt;

  /** 提运单/货运单据号 */
  private String delvrFrtDocNo;

  /** 合同号 */
  private String contrNo;

  /** 发票号 */
  private String ivcNo;

  /** 扣费金额.币种 */
  private String chgCcy;

  /** 扣费金额.金额 */
  private BigDecimal chgAmt;

  /** 合同金额.币种 */
  private String contrCcy;

  /** 合同金额.金额 */
  private BigDecimal contrAmt;

  /** Shipped On */
  private Date shippedOn;

  /** Shipped From */
  private String shippedFrom;

  /** Shipped To */
  private String shippedTo;

  /** 所附单据.Other1（title） */
  private String otherName1;

  /** 所附单据.Other2（title） */
  private String otherName2;

  /** 所附单据.Other3（title） */
  private String otherName3;

  /** 所附单据.Detail信息#1.Draft */
  private BigInteger draft1st;

  /** 所附单据.Detail信息#1.Inv.  */
  private BigInteger inv1st;

  /** 所附单据.Detail信息#1.B/L,AWB,C/R1 */
  private BigInteger blAwbCr11;

  /** 所附单据.Detail信息#1.B/L,AWB,C/R2 */
  private BigInteger blAwbCr21;

  /** 所附单据.Detail信息#1.Ins.Pol./Cert. */
  private BigInteger inspolCert1st;

  /** 所附单据.Detail信息#1.P/L */
  private BigInteger pl1st;

  /** 所附单据.Detail信息#1.Origin */
  private BigInteger origin1st;

  /** 所附单据.Detail信息#1.Quality */
  private BigInteger quality1st;

  /** 所附单据.Detail信息#1.Quantity */
  private BigInteger quantity1st;

  /** 所附单据.Detail信息#1.Non-wood */
  private BigInteger nonWood1st;

  /** 所附单据.Detail信息#1.Inspect */
  private BigInteger inspect1st;

  /** 所附单据.Detail信息#1.Cert. */
  private BigInteger cert1st;

  /** 所附单据.Detail信息#1.Other1 */
  private String otherValue11st;

  /** 所附单据.Detail信息#1.Other2 */
  private String otherValue21st;

  /** 所附单据.Detail信息#1.Other3 */
  private String otherValue31st;

  /** 所附单据.Detail信息#2.Draft */
  private BigInteger draft2nd;

  /** 所附单据.Detail信息#2.Inv.  */
  private BigInteger inv2nd;

  /** 所附单据.Detail信息#2.B/L,AWB,C/R1 */
  private BigInteger blAwbCr12;

  /** 所附单据.Detail信息#2.B/L,AWB,C/R2 */
  private BigInteger blAwbCr22;

  /** 所附单据.Detail信息#2.Ins.Pol./Cert. */
  private BigInteger inspolCert2nd;

  /** 所附单据.Detail信息#2.P/L */
  private BigInteger pl2nd;

  /** 所附单据.Detail信息#2.Origin */
  private BigInteger origin2nd;

  /** 所附单据.Detail信息#2.Quality */
  private BigInteger quality2nd;

  /** 所附单据.Detail信息#2.Quantity */
  private BigInteger quantity2nd;

  /** 所附单据.Detail信息#2.Non-wood */
  private BigInteger nonWood2nd;

  /** 所附单据.Detail信息#2.Inspect */
  private BigInteger inspect2nd;

  /** 所附单据.Detail信息#2.Cert. */
  private BigInteger cert2nd;

  /** 所附单据.Detail信息#2.Other1 */
  private String otherValue12nd;

  /** 所附单据.Detail信息#2.Other2 */
  private String otherValue22nd;

  /** 所附单据.Detail信息#2.Other3 */
  private String otherValue32nd;

  /** Remarks备注 */
  private String remarksRmrk;

  /** 不符点.Late Shipment 晚装船 */
  private String lateShipmentFlg;

  /** 不符点.Late Presentation 晚交单 */
  private String latePresentationFlg;

  /** 不符点.L/C Expired 信用证过有效期 */
  private String lcOverdueFlg;

  /** 不符点.Overdrawn by 超金额 */
  private String overdrawnFlg;

  /** 不符点.超金额.币种 */
  private String overdrawnAmtCcy;

  /** 不符点.超金额.金额 */
  private BigDecimal overdrawnAmt;

  /** 不符点.Additional Discrepancies 其他 */
  private String addDiscOther;

  /** 不符点.其它 */
  private String other;

  /** Hidden：转让编号 tkind */
  private String hidTrasfTKind;
  
  /** Hidden：转让编号 tkind */
  private String hidTrasfNoPrmryRefNo;
  
  /** Hidden：转让编号 tkind */
  private String hidTrasfNoSubRefNo;

  /**
   * @return addDiscOther
   */
  public String getAddDiscOther() {
    return addDiscOther;
  }

  /**
   * @return hidTrasfNoPrmryRefNo
   */
  public String getHidTrasfNoPrmryRefNo() {
    return hidTrasfNoPrmryRefNo;
  }

  /**
   * @param hidTrasfNoPrmryRefNo 要设置的 hidTrasfNoPrmryRefNo
   */
  public void setHidTrasfNoPrmryRefNo(String hidTrasfNoPrmryRefNo) {
    this.hidTrasfNoPrmryRefNo = hidTrasfNoPrmryRefNo;
  }

  /**
   * @return hidTrasfNoSubRefNo
   */
  public String getHidTrasfNoSubRefNo() {
    return hidTrasfNoSubRefNo;
  }

  /**
   * @param hidTrasfNoSubRefNo 要设置的 hidTrasfNoSubRefNo
   */
  public void setHidTrasfNoSubRefNo(String hidTrasfNoSubRefNo) {
    this.hidTrasfNoSubRefNo = hidTrasfNoSubRefNo;
  }

  /**
   * @return hidTrasfTKind
   */
  public String getHidTrasfTKind() {
    return hidTrasfTKind;
  }

  /**
   * @param hidTrasfTKind 要设置的 hidTrasfTKind
   */
  public void setHidTrasfTKind(String hidTrasfTKind) {
    this.hidTrasfTKind = hidTrasfTKind;
  }

  /**
   * @param addDiscOther 
   *				要设置的 addDiscOther
   */
  public void setAddDiscOther(String addDiscOther) {
    this.addDiscOther = addDiscOther;
  }

  /**
   * @return chgAmt
   */
  public BigDecimal getChgAmt() {
    return chgAmt;
  }

  /**
   * @param chgAmt 
   *				要设置的 chgAmt
   */
  public void setChgAmt(BigDecimal chgAmt) {
    this.chgAmt = chgAmt;
  }

  /**
   * @return chgCcy
   */
  public String getChgCcy() {
    return chgCcy;
  }

  /**
   * @param chgCcy 
   *				要设置的 chgCcy
   */
  public void setChgCcy(String chgCcy) {
    this.chgCcy = chgCcy;
  }

  /**
   * @return clmExchgAmt
   */
  public BigDecimal getClmExchgAmt() {
    return clmExchgAmt;
  }

  /**
   * @param clmExchgAmt 
   *				要设置的 clmExchgAmt
   */
  public void setClmExchgAmt(BigDecimal clmExchgAmt) {
    this.clmExchgAmt = clmExchgAmt;
  }

  /**
   * @return clmExchgAmtCcy
   */
  public String getClmExchgAmtCcy() {
    return clmExchgAmtCcy;
  }

  /**
   * @param clmExchgAmtCcy 
   *				要设置的 clmExchgAmtCcy
   */
  public void setClmExchgAmtCcy(String clmExchgAmtCcy) {
    this.clmExchgAmtCcy = clmExchgAmtCcy;
  }

  /**
   * @return cnResdnt
   */
  public String getCnResdnt() {
    return cnResdnt;
  }

  /**
   * @param cnResdnt 
   *				要设置的 cnResdnt
   */
  public void setCnResdnt(String cnResdnt) {
    this.cnResdnt = cnResdnt;
  }

  /**
   * @return contrAmt
   */
  public BigDecimal getContrAmt() {
    return contrAmt;
  }

  /**
   * @param contrAmt 
   *				要设置的 contrAmt
   */
  public void setContrAmt(BigDecimal contrAmt) {
    this.contrAmt = contrAmt;
  }

  /**
   * @return contrCcy
   */
  public String getContrCcy() {
    return contrCcy;
  }

  /**
   * @param contrCcy 
   *				要设置的 contrCcy
   */
  public void setContrCcy(String contrCcy) {
    this.contrCcy = contrCcy;
  }

  /**
   * @return contrNo
   */
  public String getContrNo() {
    return contrNo;
  }

  /**
   * @param contrNo 
   *				要设置的 contrNo
   */
  public void setContrNo(String contrNo) {
    this.contrNo = contrNo;
  }

  /**
   * @return delvrFrtDocNo
   */
  public String getDelvrFrtDocNo() {
    return delvrFrtDocNo;
  }

  /**
   * @param delvrFrtDocNo 
   *				要设置的 delvrFrtDocNo
   */
  public void setDelvrFrtDocNo(String delvrFrtDocNo) {
    this.delvrFrtDocNo = delvrFrtDocNo;
  }

  /**
   * @return docRecvdAmt
   */
  public BigDecimal getDocRecvdAmt() {
    return docRecvdAmt;
  }

  /**
   * @param docRecvdAmt 
   *				要设置的 docRecvdAmt
   */
  public void setDocRecvdAmt(BigDecimal docRecvdAmt) {
    this.docRecvdAmt = docRecvdAmt;
  }

  /**
   * @return docRecvdBankMailNo
   */
  public String getDocRecvdBankMailNo() {
    return docRecvdBankMailNo;
  }

  /**
   * @param docRecvdBankMailNo 
   *				要设置的 docRecvdBankMailNo
   */
  public void setDocRecvdBankMailNo(String docRecvdBankMailNo) {
    this.docRecvdBankMailNo = docRecvdBankMailNo;
  }

  /**
   * @return docRecvdBankName
   */
  public String getDocRecvdBankName() {
    return docRecvdBankName;
  }

  /**
   * @param docRecvdBankName 
   *				要设置的 docRecvdBankName
   */
  public void setDocRecvdBankName(String docRecvdBankName) {
    this.docRecvdBankName = docRecvdBankName;
  }

  /**
   * @return docRecvdBankNo
   */
  public String getDocRecvdBankNo() {
    return docRecvdBankNo;
  }

  /**
   * @param docRecvdBankNo 
   *				要设置的 docRecvdBankNo
   */
  public void setDocRecvdBankNo(String docRecvdBankNo) {
    this.docRecvdBankNo = docRecvdBankNo;
  }

  /**
   * @return docRecvdCcy
   */
  public String getDocRecvdCcy() {
    return docRecvdCcy;
  }

  /**
   * @param docRecvdCcy 
   *				要设置的 docRecvdCcy
   */
  public void setDocRecvdCcy(String docRecvdCcy) {
    this.docRecvdCcy = docRecvdCcy;
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
   * @return latePresentationFlg
   */
  public String getLatePresentationFlg() {
    return latePresentationFlg;
  }

  /**
   * @param latePresentationFlg 
   *				要设置的 latePresentationFlg
   */
  public void setLatePresentationFlg(String latePresentationFlg) {
    this.latePresentationFlg = latePresentationFlg;
  }

  /**
   * @return lateShipmentFlg
   */
  public String getLateShipmentFlg() {
    return lateShipmentFlg;
  }

  /**
   * @param lateShipmentFlg 
   *				要设置的 lateShipmentFlg
   */
  public void setLateShipmentFlg(String lateShipmentFlg) {
    this.lateShipmentFlg = lateShipmentFlg;
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
   * @return lcOverdueFlg
   */
  public String getLcOverdueFlg() {
    return lcOverdueFlg;
  }

  /**
   * @param lcOverdueFlg 
   *				要设置的 lcOverdueFlg
   */
  public void setLcOverdueFlg(String lcOverdueFlg) {
    this.lcOverdueFlg = lcOverdueFlg;
  }

  /**
   * @return orgCode1
   */
  public String getOrgCode1() {
    return orgCode1;
  }

  /**
   * @param orgCode1 
   *				要设置的 orgCode1
   */
  public void setOrgCode1(String orgCode1) {
    this.orgCode1 = orgCode1;
  }

  /**
   * @return orgCode2
   */
  public String getOrgCode2() {
    return orgCode2;
  }

  /**
   * @param orgCode2 
   *				要设置的 orgCode2
   */
  public void setOrgCode2(String orgCode2) {
    this.orgCode2 = orgCode2;
  }

  /**
   * @return other
   */
  public String getOther() {
    return other;
  }

  /**
   * @param other 
   *				要设置的 other
   */
  public void setOther(String other) {
    this.other = other;
  }

  /**
   * @return otherName1
   */
  public String getOtherName1() {
    return otherName1;
  }

  /**
   * @param otherName1 
   *				要设置的 otherName1
   */
  public void setOtherName1(String otherName1) {
    this.otherName1 = otherName1;
  }

  /**
   * @return otherName2
   */
  public String getOtherName2() {
    return otherName2;
  }

  /**
   * @param otherName2 
   *				要设置的 otherName2
   */
  public void setOtherName2(String otherName2) {
    this.otherName2 = otherName2;
  }

  /**
   * @return otherName3
   */
  public String getOtherName3() {
    return otherName3;
  }

  /**
   * @param otherName3 
   *				要设置的 otherName3
   */
  public void setOtherName3(String otherName3) {
    this.otherName3 = otherName3;
  }

  /**
   * @return collStlmtMeth
   */
  public String getCollStlmtMeth() {
    return collStlmtMeth;
  }

  /**
   * @param collStlmtMeth 要设置的 collStlmtMeth
   */
  public void setCollStlmtMeth(String collStlmtMeth) {
    this.collStlmtMeth = collStlmtMeth;
  }

  /**
   * @return lcStlmtMeth
   */
  public String getLcStlmtMeth() {
    return lcStlmtMeth;
  }

  /**
   * @param lcStlmtMeth 要设置的 lcStlmtMeth
   */
  public void setLcStlmtMeth(String lcStlmtMeth) {
    this.lcStlmtMeth = lcStlmtMeth;
  }

  /**
   * @return lgStlmtMeth
   */
  public String getLgStlmtMeth() {
    return lgStlmtMeth;
  }

  /**
   * @param lgStlmtMeth 要设置的 lgStlmtMeth
   */
  public void setLgStlmtMeth(String lgStlmtMeth) {
    this.lgStlmtMeth = lgStlmtMeth;
  }

  /**
   * @return otherStlmtMeth
   */
  public String getOtherStlmtMeth() {
    return otherStlmtMeth;
  }

  /**
   * @param otherStlmtMeth 要设置的 otherStlmtMeth
   */
  public void setOtherStlmtMeth(String otherStlmtMeth) {
    this.otherStlmtMeth = otherStlmtMeth;
  }

  /**
   * @return otherValue11st
   */
  public String getOtherValue11st() {
    return otherValue11st;
  }

  /**
   * @param otherValue11st 
   *				要设置的 otherValue11st
   */
  public void setOtherValue11st(String otherValue11st) {
    this.otherValue11st = otherValue11st;
  }

  /**
   * @return otherValue12nd
   */
  public String getOtherValue12nd() {
    return otherValue12nd;
  }

  /**
   * @param otherValue12nd 
   *				要设置的 otherValue12nd
   */
  public void setOtherValue12nd(String otherValue12nd) {
    this.otherValue12nd = otherValue12nd;
  }

  /**
   * @return otherValue21st
   */
  public String getOtherValue21st() {
    return otherValue21st;
  }

  /**
   * @param otherValue21st 
   *				要设置的 otherValue21st
   */
  public void setOtherValue21st(String otherValue21st) {
    this.otherValue21st = otherValue21st;
  }

  /**
   * @return otherValue22nd
   */
  public String getOtherValue22nd() {
    return otherValue22nd;
  }

  /**
   * @param otherValue22nd 
   *				要设置的 otherValue22nd
   */
  public void setOtherValue22nd(String otherValue22nd) {
    this.otherValue22nd = otherValue22nd;
  }

  /**
   * @return otherValue31st
   */
  public String getOtherValue31st() {
    return otherValue31st;
  }

  /**
   * @param otherValue31st 
   *				要设置的 otherValue31st
   */
  public void setOtherValue31st(String otherValue31st) {
    this.otherValue31st = otherValue31st;
  }

  /**
   * @return otherValue32nd
   */
  public String getOtherValue32nd() {
    return otherValue32nd;
  }

  /**
   * @param otherValue32nd 
   *				要设置的 otherValue32nd
   */
  public void setOtherValue32nd(String otherValue32nd) {
    this.otherValue32nd = otherValue32nd;
  }

  /**
   * @return overdrawnAmt
   */
  public BigDecimal getOverdrawnAmt() {
    return overdrawnAmt;
  }

  /**
   * @param overdrawnAmt 
   *				要设置的 overdrawnAmt
   */
  public void setOverdrawnAmt(BigDecimal overdrawnAmt) {
    this.overdrawnAmt = overdrawnAmt;
  }

  /**
   * @return overdrawnAmtCcy
   */
  public String getOverdrawnAmtCcy() {
    return overdrawnAmtCcy;
  }

  /**
   * @param overdrawnAmtCcy 
   *				要设置的 overdrawnAmtCcy
   */
  public void setOverdrawnAmtCcy(String overdrawnAmtCcy) {
    this.overdrawnAmtCcy = overdrawnAmtCcy;
  }

  /**
   * @return overdrawnFlg
   */
  public String getOverdrawnFlg() {
    return overdrawnFlg;
  }

  /**
   * @param overdrawnFlg 
   *				要设置的 overdrawnFlg
   */
  public void setOverdrawnFlg(String overdrawnFlg) {
    this.overdrawnFlg = overdrawnFlg;
  }

  /**
   * @return payeeName
   */
  public String getPayeeName() {
    return payeeName;
  }

  /**
   * @param payeeName 
   *				要设置的 payeeName
   */
  public void setPayeeName(String payeeName) {
    this.payeeName = payeeName;
  }

  /**
   * @return payerName
   */
  public String getPayerName() {
    return payerName;
  }

  /**
   * @param payerName 
   *				要设置的 payerName
   */
  public void setPayerName(String payerName) {
    this.payerName = payerName;
  }

  /**
   * @return personalId
   */
  public String getPersonalId() {
    return personalId;
  }

  /**
   * @param personalId 
   *				要设置的 personalId
   */
  public void setPersonalId(String personalId) {
    this.personalId = personalId;
  }

  /**
   * @return blAwbCr11
   */
  public BigInteger getBlAwbCr11() {
    return blAwbCr11;
  }

  /**
   * @param blAwbCr11 要设置的 blAwbCr11
   */
  public void setBlAwbCr11(BigInteger blAwbCr11) {
    this.blAwbCr11 = blAwbCr11;
  }

  /**
   * @return blAwbCr12
   */
  public BigInteger getBlAwbCr12() {
    return blAwbCr12;
  }

  /**
   * @param blAwbCr12 要设置的 blAwbCr12
   */
  public void setBlAwbCr12(BigInteger blAwbCr12) {
    this.blAwbCr12 = blAwbCr12;
  }

  /**
   * @return blAwbCr21
   */
  public BigInteger getBlAwbCr21() {
    return blAwbCr21;
  }

  /**
   * @param blAwbCr21 要设置的 blAwbCr21
   */
  public void setBlAwbCr21(BigInteger blAwbCr21) {
    this.blAwbCr21 = blAwbCr21;
  }

  /**
   * @return blAwbCr22
   */
  public BigInteger getBlAwbCr22() {
    return blAwbCr22;
  }

  /**
   * @param blAwbCr22 要设置的 blAwbCr22
   */
  public void setBlAwbCr22(BigInteger blAwbCr22) {
    this.blAwbCr22 = blAwbCr22;
  }

  /**
   * @return cert1st
   */
  public BigInteger getCert1st() {
    return cert1st;
  }

  /**
   * @param cert1st 要设置的 cert1st
   */
  public void setCert1st(BigInteger cert1st) {
    this.cert1st = cert1st;
  }

  /**
   * @return cert2nd
   */
  public BigInteger getCert2nd() {
    return cert2nd;
  }

  /**
   * @param cert2nd 要设置的 cert2nd
   */
  public void setCert2nd(BigInteger cert2nd) {
    this.cert2nd = cert2nd;
  }

  /**
   * @return draft1st
   */
  public BigInteger getDraft1st() {
    return draft1st;
  }

  /**
   * @param draft1st 要设置的 draft1st
   */
  public void setDraft1st(BigInteger draft1st) {
    this.draft1st = draft1st;
  }

  /**
   * @return draft2nd
   */
  public BigInteger getDraft2nd() {
    return draft2nd;
  }

  /**
   * @param draft2nd 要设置的 draft2nd
   */
  public void setDraft2nd(BigInteger draft2nd) {
    this.draft2nd = draft2nd;
  }

  /**
   * @return inspect1st
   */
  public BigInteger getInspect1st() {
    return inspect1st;
  }

  /**
   * @param inspect1st 要设置的 inspect1st
   */
  public void setInspect1st(BigInteger inspect1st) {
    this.inspect1st = inspect1st;
  }

  /**
   * @return inspect2nd
   */
  public BigInteger getInspect2nd() {
    return inspect2nd;
  }

  /**
   * @param inspect2nd 要设置的 inspect2nd
   */
  public void setInspect2nd(BigInteger inspect2nd) {
    this.inspect2nd = inspect2nd;
  }

  /**
   * @return inspolCert1st
   */
  public BigInteger getInspolCert1st() {
    return inspolCert1st;
  }

  /**
   * @param inspolCert1st 要设置的 inspolCert1st
   */
  public void setInspolCert1st(BigInteger inspolCert1st) {
    this.inspolCert1st = inspolCert1st;
  }

  /**
   * @return inspolCert2nd
   */
  public BigInteger getInspolCert2nd() {
    return inspolCert2nd;
  }

  /**
   * @param inspolCert2nd 要设置的 inspolCert2nd
   */
  public void setInspolCert2nd(BigInteger inspolCert2nd) {
    this.inspolCert2nd = inspolCert2nd;
  }

  /**
   * @return inv1st
   */
  public BigInteger getInv1st() {
    return inv1st;
  }

  /**
   * @param inv1st 要设置的 inv1st
   */
  public void setInv1st(BigInteger inv1st) {
    this.inv1st = inv1st;
  }

  /**
   * @return inv2nd
   */
  public BigInteger getInv2nd() {
    return inv2nd;
  }

  /**
   * @param inv2nd 要设置的 inv2nd
   */
  public void setInv2nd(BigInteger inv2nd) {
    this.inv2nd = inv2nd;
  }

  /**
   * @return nonWood1st
   */
  public BigInteger getNonWood1st() {
    return nonWood1st;
  }

  /**
   * @param nonWood1st 要设置的 nonWood1st
   */
  public void setNonWood1st(BigInteger nonWood1st) {
    this.nonWood1st = nonWood1st;
  }

  /**
   * @return nonWood2nd
   */
  public BigInteger getNonWood2nd() {
    return nonWood2nd;
  }

  /**
   * @param nonWood2nd 要设置的 nonWood2nd
   */
  public void setNonWood2nd(BigInteger nonWood2nd) {
    this.nonWood2nd = nonWood2nd;
  }

  /**
   * @return origin1st
   */
  public BigInteger getOrigin1st() {
    return origin1st;
  }

  /**
   * @param origin1st 要设置的 origin1st
   */
  public void setOrigin1st(BigInteger origin1st) {
    this.origin1st = origin1st;
  }

  /**
   * @return origin2nd
   */
  public BigInteger getOrigin2nd() {
    return origin2nd;
  }

  /**
   * @param origin2nd 要设置的 origin2nd
   */
  public void setOrigin2nd(BigInteger origin2nd) {
    this.origin2nd = origin2nd;
  }

  /**
   * @return pl1st
   */
  public BigInteger getPl1st() {
    return pl1st;
  }

  /**
   * @param pl1st 要设置的 pl1st
   */
  public void setPl1st(BigInteger pl1st) {
    this.pl1st = pl1st;
  }

  /**
   * @return pl2nd
   */
  public BigInteger getPl2nd() {
    return pl2nd;
  }

  /**
   * @param pl2nd 要设置的 pl2nd
   */
  public void setPl2nd(BigInteger pl2nd) {
    this.pl2nd = pl2nd;
  }

  /**
   * @return quality1st
   */
  public BigInteger getQuality1st() {
    return quality1st;
  }

  /**
   * @param quality1st 要设置的 quality1st
   */
  public void setQuality1st(BigInteger quality1st) {
    this.quality1st = quality1st;
  }

  /**
   * @return quality2nd
   */
  public BigInteger getQuality2nd() {
    return quality2nd;
  }

  /**
   * @param quality2nd 要设置的 quality2nd
   */
  public void setQuality2nd(BigInteger quality2nd) {
    this.quality2nd = quality2nd;
  }

  /**
   * @return quantity1st
   */
  public BigInteger getQuantity1st() {
    return quantity1st;
  }

  /**
   * @param quantity1st 要设置的 quantity1st
   */
  public void setQuantity1st(BigInteger quantity1st) {
    this.quantity1st = quantity1st;
  }

  /**
   * @return quantity2nd
   */
  public BigInteger getQuantity2nd() {
    return quantity2nd;
  }

  /**
   * @param quantity2nd 要设置的 quantity2nd
   */
  public void setQuantity2nd(BigInteger quantity2nd) {
    this.quantity2nd = quantity2nd;
  }

  /**
   * @return recvgBankNameAndAddr
   */
  public String getRecvgBankNameAndAddr() {
    return recvgBankNameAndAddr;
  }

  /**
   * @return hidBtnType
   */
  public String getHidBtnType() {
    return hidBtnType;
  }

  /**
   * @param hidBtnType 要设置的 hidBtnType
   */
  public void setHidBtnType(String hidBtnType) {
    this.hidBtnType = hidBtnType;
  }

  /**
   * @param recvgBankNameAndAddr 
   *				要设置的 recvgBankNameAndAddr
   */
  public void setRecvgBankNameAndAddr(String recvgBankNameAndAddr) {
    this.recvgBankNameAndAddr = recvgBankNameAndAddr;
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
   * @return remarksRmrk
   */
  public String getRemarksRmrk() {
    return remarksRmrk;
  }

  /**
   * @param remarksRmrk 
   *				要设置的 remarksRmrk
   */
  public void setRemarksRmrk(String remarksRmrk) {
    this.remarksRmrk = remarksRmrk;
  }

  /**
   * @return shippedFrom
   */
  public String getShippedFrom() {
    return shippedFrom;
  }

  /**
   * @param shippedFrom 
   *				要设置的 shippedFrom
   */
  public void setShippedFrom(String shippedFrom) {
    this.shippedFrom = shippedFrom;
  }

  /**
   * @return shippedOn
   */
  public Date getShippedOn() {
    return shippedOn;
  }

  /**
   * @param shippedOn 
   *				要设置的 shippedOn
   */
  public void setShippedOn(Date shippedOn) {
    this.shippedOn = shippedOn;
  }

  /**
   * @return shippedTo
   */
  public String getShippedTo() {
    return shippedTo;
  }

  /**
   * @param shippedTo 
   *				要设置的 shippedTo
   */
  public void setShippedTo(String shippedTo) {
    this.shippedTo = shippedTo;
  }

  /**
   * @return term
   */
  public String getTerm() {
    return term;
  }

  /**
   * @param term 
   *				要设置的 term
   */
  public void setTerm(String term) {
    this.term = term;
  }

  /**
   * @return toPrivtFlg
   */
  public String getToPrivtFlg() {
    return toPrivtFlg;
  }

  /**
   * @param toPrivtFlg 
   *				要设置的 toPrivtFlg
   */
  public void setToPrivtFlg(String toPrivtFlg) {
    this.toPrivtFlg = toPrivtFlg;
  }

  /**
   * @return toPubFlg
   */
  public String getToPubFlg() {
    return toPubFlg;
  }

  /**
   * @param toPubFlg 
   *				要设置的 toPubFlg
   */
  public void setToPubFlg(String toPubFlg) {
    this.toPubFlg = toPubFlg;
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
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type 
   *				要设置的 type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return ntid
   */
  public int getNtid() {
    return ntid;
  }

  /**
   * @param ntid 要设置的 ntid
   */
  public void setNtid(int ntid) {
    this.ntid = ntid;
  }

}
