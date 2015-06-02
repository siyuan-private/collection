package cn.com.btmu.art.biz.collection.vo;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.btmu.art.biz.common01biz.base.vo.ComQueryVO;

/**	
 * BillOfCollectionNoticeprintVO	
 * 通知书打印一览用VO
 * 
 * @author iVision
 * @version 1.0.0
 */
public class BillOfCollectionNoticeprintVO extends ComQueryVO {
  
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

  /** 结算方式 */
  private String stlmtMeth;

  /** 信用证编号 */
  private String lcNo;

  /** 来单金额.币种 */
  private String docRecvdCcy;

  /** 来单金额.金额 */
  private BigDecimal docRecvdAmt;

  /** 期限 */
  private String term;

  /** 到期日 */
  private Date dueDate;

  /** 第二受益人 */
  private String payeeName;

  /** 登记日(开始） */
  private Date regDateFrom;

  /** 登记日(结束） */
  private Date regDateTo;

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
   * @return stlmtMeth
   */
  public String getStlmtMeth() {
    return stlmtMeth;
  }

  /**
   * @param stlmtMeth 
   *				要设置的 stlmtMeth
   */
  public void setStlmtMeth(String stlmtMeth) {
    this.stlmtMeth = stlmtMeth;
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
