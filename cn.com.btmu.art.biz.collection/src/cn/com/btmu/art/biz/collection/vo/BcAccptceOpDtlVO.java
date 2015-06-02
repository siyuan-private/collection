package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;

/**
 * !BcAccptceOpDtlVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class BcAccptceOpDtlVO {
  /** 承兑登记日 */
  private Date accptceRegDate;

  /** 承兑到期日 */
  private Date accptceDueDate;

  /** 远期索偿日 */
  private Date forwdClmRmbrsmtDate;

  /** 合理 */
  private String resnblFlg;

  /** Accepted Flag */
  private String acceptedFlg;

  /** WSID.WSID1 */
  private String bcAccptceWsid1;

  /** WSID.WSID2 */
  private String bcAccptceWsid2;

  /** WSID日期 */
  private Date bcAccptceWsidDate;

  /** 承兑备注 */
  private String accptceRmrk;

  /**
   * @return acceptedFlg
   */
  public String getAcceptedFlg() {
    return acceptedFlg;
  }

  /**
   * @param acceptedFlg 要设置的 acceptedFlg
   */
  public void setAcceptedFlg(String acceptedFlg) {
    this.acceptedFlg = acceptedFlg;
  }

  /**
   * @return accptceDueDate
   */
  public Date getAccptceDueDate() {
    return accptceDueDate;
  }

  /**
   * @param accptceDueDate 要设置的 accptceDueDate
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
   * @param accptceRegDate 要设置的 accptceRegDate
   */
  public void setAccptceRegDate(Date accptceRegDate) {
    this.accptceRegDate = accptceRegDate;
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
   * @return bcAccptceWsid1
   */
  public String getBcAccptceWsid1() {
    return bcAccptceWsid1;
  }

  /**
   * @param bcAccptceWsid1 要设置的 bcAccptceWsid1
   */
  public void setBcAccptceWsid1(String bcAccptceWsid1) {
    this.bcAccptceWsid1 = bcAccptceWsid1;
  }

  /**
   * @return bcAccptceWsid2
   */
  public String getBcAccptceWsid2() {
    return bcAccptceWsid2;
  }

  /**
   * @param bcAccptceWsid2 要设置的 bcAccptceWsid2
   */
  public void setBcAccptceWsid2(String bcAccptceWsid2) {
    this.bcAccptceWsid2 = bcAccptceWsid2;
  }

  /**
   * @return bcAccptceWsidDate
   */
  public Date getBcAccptceWsidDate() {
    return bcAccptceWsidDate;
  }

  /**
   * @param bcAccptceWsidDate 要设置的 bcAccptceWsidDate
   */
  public void setBcAccptceWsidDate(Date bcAccptceWsidDate) {
    this.bcAccptceWsidDate = bcAccptceWsidDate;
  }

  /**
   * @return forwdClmRmbrsmtDate
   */
  public Date getForwdClmRmbrsmtDate() {
    return forwdClmRmbrsmtDate;
  }

  /**
   * @param forwdClmRmbrsmtDate 要设置的 forwdClmRmbrsmtDate
   */
  public void setForwdClmRmbrsmtDate(Date forwdClmRmbrsmtDate) {
    this.forwdClmRmbrsmtDate = forwdClmRmbrsmtDate;
  }

  /**
   * @return resnblFlg
   */
  public String getResnblFlg() {
    return resnblFlg;
  }

  /**
   * @param resnblFlg 要设置的 resnblFlg
   */
  public void setResnblFlg(String resnblFlg) {
    this.resnblFlg = resnblFlg;
  }

}
