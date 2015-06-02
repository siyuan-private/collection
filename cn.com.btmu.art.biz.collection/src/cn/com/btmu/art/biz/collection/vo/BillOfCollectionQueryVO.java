package cn.com.btmu.art.biz.collection.vo;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.btmu.art.biz.common01biz.base.vo.ComQueryVO;

/**	
 * BillOfCollectionQueryVO	
 * ？
 * @author ivision
 * @version 1.0.0
 */
public class BillOfCollectionQueryVO extends ComQueryVO {

  /** 交易参号-T-kind */
  private String tkind;

  /** 交易参号-主参号 */
  private String txnPrmryRefNo;

  /** 交易参号-子参号 */
  private String txnSubRefNo;

  /** 托收日期 */
  private Date collDate;

  /** 受益人-客户CIF */
  private String beneCif;

  /** 受益人-客户名称 */
  private String beneName;

  /** 汇票金额-币种 */
  private String bxCcy;

  /** 汇票金额-金额 */
  private BigDecimal bxAmt;

  /** 信用证余额-币种 */
  private String lcBalCcy;

  /**信用证余额-金额 */
  private BigDecimal lcBalAmt;

  /** 发票编号 */
  private String ivcNo;

  /** Tenor */
  private String tenorType;

  /** 到期日期 */
  private Date dueDate;

  /** 信用证项下 */
  private String lcFlg;

  /** BPO */
  private String bpoFlg;

  /** TSU */
  private String tsuFlg;

  /** 信用证编号 */
  private String lcNo;

  /** 进口商名称 */
  private String imptrName;

  /** 寄单行.名称  */
  private String expDispch;

  /** 国别 */
  private String natnlty;

  /** 承兑登记日 */
  private Date accptceRegDate;

  /** 承兑到期日 */
  private Date accptceDueDate;

  /** 头寸日 */
  private Date posDate;

  /** 我行对客入账日 */
  private Date ourBankToCustBookingDate;

  /** 头寸金额.币种 */
  private String posCcy;

  /** 头寸金额.金额 */
  private BigDecimal posAmt;

  /** 他行扣款金额.币种 */
  private String theirDedctCcy;

  /** 他行扣款金额.金额 */
  private BigDecimal theirDedctAmt;

  /** P.P.NEGO */
  private String ppnegoFlg;

  /** 电报议付 */
  private String telegNegoFlg;

  /** 电报议付销号日期 */
  private Date telegNegoClsDate;

  /** 电报议付备注 */
  private String bcRmrk;

  /** 退改单登记日 */
  private Date regDate;

  /** 退改单 */
  private String bbMaintType;

  /** 退改单备注 */
  private String bbRmrk;
  
  /** 故障T-Kind */
  private String faultTKind;

  /** 故障交易主参号 */
  private String faultTxnTKind;

  /** 故障编号 */
  private String faultNo;
  
  /** 一览条件 故障编号 */
  private String faultSearchNo;

  /** 国内信用证 */
  private String domstcLcFlg;

  /** 履行保兑责任 */
  private String perfmConfmDuties;

  /** 托收日期(开始) */
  private Date collDateFrom;

  /** 托收日期(结束） */
  private Date collDateTo;

  /** 汇票金额-金额FROM */
  private BigDecimal bxAmtFrom;

  /** 汇票金额-金额TO */
  private BigDecimal bxAmtTo;

  /** 承兑登记日(开始） */
  private Date accptceRegDateFrom;

  /** 承兑登记日(结束） */
  private Date accptceRegDateTo;

  /** 我行对客入账日(开始） */
  private Date ourBankToCustBookingDateFrom;

  /** 我行对客入账日(结束） */
  private Date ourBankToCustBookingDateTo;

  /** 退改单登记日(开始） */
  private Date regDateFrom;

  /** 退改单登记日(结束） */
  private Date regDateTo;

  /** 假远期 */
  private String fakeForwdFlg;

  /** 信用证 OSA/NRA */
  private String expOsaNra;

  /** 偿付行.名称 */
  private String reimbBankName;

  /** 拒付编号 */
  private String dishnrNo;

  /** 承兑备注 */
  private String accptceRmrk;

  /** 原因 */
  private String resn;

  /** 入账备注 */
  private String bookRmrk;

  /**
   * @return accptceDueDate
   */
  public Date getAccptceDueDate() {
    return accptceDueDate;
  }

  /**
   * @param accptceDueDate 
   *				要设置的 accptceDueDate
   */
  public void setAccptceDueDate(Date accptceDueDate) {
    this.accptceDueDate = accptceDueDate;
  }

  /**
   * @return accptceRegDate
   */
  public Date getAccptceRegDate() {
    return accptceRegDate;
  }

  /**
   * @param accptceRegDate 
   *				要设置的 accptceRegDate
   */
  public void setAccptceRegDate(Date accptceRegDate) {
    this.accptceRegDate = accptceRegDate;
  }

  /**
   * @return accptceRegDateFrom
   */
  public Date getAccptceRegDateFrom() {
    return accptceRegDateFrom;
  }

  /**
   * @param accptceRegDateFrom 
   *				要设置的 accptceRegDateFrom
   */
  public void setAccptceRegDateFrom(Date accptceRegDateFrom) {
    this.accptceRegDateFrom = accptceRegDateFrom;
  }

  /**
   * @return accptceRegDateTo
   */
  public Date getAccptceRegDateTo() {
    return accptceRegDateTo;
  }

  /**
   * @param accptceRegDateTo 
   *				要设置的 accptceRegDateTo
   */
  public void setAccptceRegDateTo(Date accptceRegDateTo) {
    this.accptceRegDateTo = accptceRegDateTo;
  }

  /**
   * @return bbMaintType
   */
  public String getBbMaintType() {
    return bbMaintType;
  }

  /**
   * @param bbMaintType 
   *				要设置的 bbMaintType
   */
  public void setBbMaintType(String bbMaintType) {
    this.bbMaintType = bbMaintType;
  }

  /**
   * @return bbRmrk
   */
  public String getBbRmrk() {
    return bbRmrk;
  }

  /**
   * @param bbModChgbkDocInfoRmrk 
   *				要设置的 bbModChgbkDocInfoRmrk
   */
  public void setBbRmrk(String bbRmrk) {
    this.bbRmrk = bbRmrk;
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
   * @return bxAmtFrom
   */
  public BigDecimal getBxAmtFrom() {
    return bxAmtFrom;
  }

  /**
   * @param bxAmtFrom 
   *				要设置的 bxAmtFrom
   */
  public void setBxAmtFrom(BigDecimal bxAmtFrom) {
    this.bxAmtFrom = bxAmtFrom;
  }

  /**
   * @return bxAmtTo
   */
  public BigDecimal getBxAmtTo() {
    return bxAmtTo;
  }

  /**
   * @param bxAmtTo 
   *				要设置的 bxAmtTo
   */
  public void setBxAmtTo(BigDecimal bxAmtTo) {
    this.bxAmtTo = bxAmtTo;
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
   * @return collDateFrom
   */
  public Date getCollDateFrom() {
    return collDateFrom;
  }

  /**
   * @param collDateFrom 
   *				要设置的 collDateFrom
   */
  public void setCollDateFrom(Date collDateFrom) {
    this.collDateFrom = collDateFrom;
  }

  /**
   * @return collDateTo
   */
  public Date getCollDateTo() {
    return collDateTo;
  }

  /**
   * @param collDateTo 
   *				要设置的 collDateTo
   */
  public void setCollDateTo(Date collDateTo) {
    this.collDateTo = collDateTo;
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
   * @return faultNo
   */
  public String getFaultNo() {
    return faultNo;
  }

  /**
   * @param faultNo 
   *				要设置的 faultNo
   */
  public void setFaultNo(String faultNo) {
    this.faultNo = faultNo;
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
   * @return ourBankToCustBookingDate
   */
  public Date getOurBankToCustBookingDate() {
    return ourBankToCustBookingDate;
  }

  /**
   * @param ourBankToCustBookingDate 
   *				要设置的 ourBankToCustBookingDate
   */
  public void setOurBankToCustBookingDate(Date ourBankToCustBookingDate) {
    this.ourBankToCustBookingDate = ourBankToCustBookingDate;
  }

  /**
   * @return ourBankToCustBookingDateFrom
   */
  public Date getOurBankToCustBookingDateFrom() {
    return ourBankToCustBookingDateFrom;
  }

  /**
   * @param ourBankToCustBookingDateFrom 
   *				要设置的 ourBankToCustBookingDateFrom
   */
  public void setOurBankToCustBookingDateFrom(Date ourBankToCustBookingDateFrom) {
    this.ourBankToCustBookingDateFrom = ourBankToCustBookingDateFrom;
  }

  /**
   * @return ourBankToCustBookingDateTo
   */
  public Date getOurBankToCustBookingDateTo() {
    return ourBankToCustBookingDateTo;
  }

  /**
   * @param ourBankToCustBookingDateTo 
   *				要设置的 ourBankToCustBookingDateTo
   */
  public void setOurBankToCustBookingDateTo(Date ourBankToCustBookingDateTo) {
    this.ourBankToCustBookingDateTo = ourBankToCustBookingDateTo;
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
   * @return posAmt
   */
  public BigDecimal getPosAmt() {
    return posAmt;
  }

  /**
   * @param posAmt 
   *				要设置的 posAmt
   */
  public void setPosAmt(BigDecimal posAmt) {
    this.posAmt = posAmt;
  }

  /**
   * @return posCcy
   */
  public String getPosCcy() {
    return posCcy;
  }

  /**
   * @param posCcy 
   *				要设置的 posCcy
   */
  public void setPosCcy(String posCcy) {
    this.posCcy = posCcy;
  }

  /**
   * @return posDate
   */
  public Date getPosDate() {
    return posDate;
  }

  /**
   * @param posDate 
   *				要设置的 posDate
   */
  public void setPosDate(Date posDate) {
    this.posDate = posDate;
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
   * @return regDateFrom
   */
  public Date getRegDateFrom() {
    return regDateFrom;
  }

  /**
   * @param regDateFrom 
   *				要设置的 regDateFrom
   */
  public void setRegDateFrom(Date regDateFrom) {
    this.regDateFrom = regDateFrom;
  }

  /**
   * @return regDateTo
   */
  public Date getRegDateTo() {
    return regDateTo;
  }

  /**
   * @param regDateTo 
   *				要设置的 regDateTo
   */
  public void setRegDateTo(Date regDateTo) {
    this.regDateTo = regDateTo;
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
   * @return theirDedctAmt
   */
  public BigDecimal getTheirDedctAmt() {
    return theirDedctAmt;
  }

  /**
   * @param theirDedctAmt 
   *				要设置的 theirDedctAmt
   */
  public void setTheirDedctAmt(BigDecimal theirDedctAmt) {
    this.theirDedctAmt = theirDedctAmt;
  }

  /**
   * @return theirDedctCcy
   */
  public String getTheirDedctCcy() {
    return theirDedctCcy;
  }

  /**
   * @param theirDedctCcy 
   *				要设置的 theirDedctCcy
   */
  public void setTheirDedctCcy(String theirDedctCcy) {
    this.theirDedctCcy = theirDedctCcy;
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
   * @return accptceRmrk
   */
  public String getAccptceRmrk() {
    return accptceRmrk;
  }

  /**
   * @param accptceRmrk 要设置的 accptceRmrk
   */
  public void setAccptceRmrk(String accptceRmrk) {
    this.accptceRmrk = accptceRmrk;
  }

  /**
   * @return expDispch
   */
  public String getExpDispch() {
    return expDispch;
  }

  /**
   * @param expDispch 要设置的 expDispch
   */
  public void setExpDispch(String expDispch) {
    this.expDispch = expDispch;
  }

  /**
   * @return bcRmrk
   */
  public String getBcRmrk() {
    return bcRmrk;
  }

  /**
   * @param bcRmrk 要设置的 bcRmrk
   */
  public void setBcRmrk(String bcRmrk) {
    this.bcRmrk = bcRmrk;
  }

  /**
   * @return bookRmrk
   */
  public String getBookRmrk() {
    return bookRmrk;
  }

  /**
   * @param bookRmrk 要设置的 bookRmrk
   */
  public void setBookRmrk(String bookRmrk) {
    this.bookRmrk = bookRmrk;
  }

  /**
   * @return dishnrNo
   */
  public String getDishnrNo() {
    return dishnrNo;
  }

  /**
   * @param dishnrNo 要设置的 dishnrNo
   */
  public void setDishnrNo(String dishnrNo) {
    this.dishnrNo = dishnrNo;
  }

  /**
   * @return expOsaNra
   */
  public String getExpOsaNra() {
    return expOsaNra;
  }

  /**
   * @param expOsaNra 要设置的 expOsaNra
   */
  public void setExpOsaNra(String expOsaNra) {
    this.expOsaNra = expOsaNra;
  }

  /**
   * @return fakeForwdFlg
   */
  public String getFakeForwdFlg() {
    return fakeForwdFlg;
  }

  /**
   * @param fakeForwdFlg 要设置的 fakeForwdFlg
   */
  public void setFakeForwdFlg(String fakeForwdFlg) {
    this.fakeForwdFlg = fakeForwdFlg;
  }

  /**
   * @return reimbBankName
   */
  public String getReimbBankName() {
    return reimbBankName;
  }

  /**
   * @param reimbBankName 要设置的 reimbBankName
   */
  public void setReimbBankName(String reimbBankName) {
    this.reimbBankName = reimbBankName;
  }

  /**
   * @return resn
   */
  public String getResn() {
    return resn;
  }

  /**
   * @param resn 要设置的 resn
   */
  public void setResn(String resn) {
    this.resn = resn;
  }

  /**
   * @return lcBalAmt
   */
  public BigDecimal getLcBalAmt() {
    return lcBalAmt;
  }

  /**
   * @param lcBalAmt 要设置的 lcBalAmt
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
   * @param lcBalCcy 要设置的 lcBalCcy
   */
  public void setLcBalCcy(String lcBalCcy) {
    this.lcBalCcy = lcBalCcy;
  }

/**
 * @return faultSearchNo
 */
public String getFaultSearchNo() {
	return faultSearchNo;
}

/**
 * @param faultSearchNo 要设置的 faultSearchNo
 */
public void setFaultSearchNo(String faultSearchNo) {
	this.faultSearchNo = faultSearchNo;
}

/**
 * @return faultTKind
 */
public String getFaultTKind() {
	return faultTKind;
}

/**
 * @param faultTKind 要设置的 faultTKind
 */
public void setFaultTKind(String faultTKind) {
	this.faultTKind = faultTKind;
}

/**
 * @return faultTxnTKind
 */
public String getFaultTxnTKind() {
	return faultTxnTKind;
}

/**
 * @param faultTxnTKind 要设置的 faultTxnTKind
 */
public void setFaultTxnTKind(String faultTxnTKind) {
	this.faultTxnTKind = faultTxnTKind;
}

}
