package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;

/**
 * !DispchDocInfoVO
 * 
 *@author ivision
 *@version 1.0.0
 */
public class DispchDocInfoVO {
  /** hidden：新增寄单信息标志 */
  private String dispchDocFlgAdd;

  /** 快递类型 */
  private String exprsType;

  /** 寄单对象 */
  private String dispchDocObj;

  /** 寄单种类 */
  private String dispchDocType;

  /** 快递号码 */
  private String exprsNo;

  /** 收件人 */
  private String recpnt;

  /** 快递寄单日 */
  private Date exprsDispchDocDate;

  /** 备注 */
  private String dispchDocRmrk;

  /** 操作节点 */
  private String operNod;

  /** hidden：业务种类 */
  private String bizType;

  /**
   * @return bizType
   */
  public String getBizType() {
    return bizType;
  }

  /**
   * @param bizType 要设置的 bizType
   */
  public void setBizType(String bizType) {
    this.bizType = bizType;
  }

  /**
   * @return dispchDocObj
   */
  public String getDispchDocObj() {
    return dispchDocObj;
  }

  /**
   * @param dispchDocObj 要设置的 dispchDocObj
   */
  public void setDispchDocObj(String dispchDocObj) {
    this.dispchDocObj = dispchDocObj;
  }

  /**
   * @return dispchDocRmrk
   */
  public String getDispchDocRmrk() {
    return dispchDocRmrk;
  }

  /**
   * @param dispchDocRmrk 要设置的 dispchDocRmrk
   */
  public void setDispchDocRmrk(String dispchDocRmrk) {
    this.dispchDocRmrk = dispchDocRmrk;
  }

  /**
   * @return dispchDocType
   */
  public String getDispchDocType() {
    return dispchDocType;
  }

  /**
   * @param dispchDocType 要设置的 dispchDocType
   */
  public void setDispchDocType(String dispchDocType) {
    this.dispchDocType = dispchDocType;
  }

  /**
   * @return exprsDispchDocDate
   */
  public Date getExprsDispchDocDate() {
    return exprsDispchDocDate;
  }

  /**
   * @param exprsDispchDocDate 要设置的 exprsDispchDocDate
   */
  public void setExprsDispchDocDate(Date exprsDispchDocDate) {
    this.exprsDispchDocDate = exprsDispchDocDate;
  }

  /**
   * @return exprsNo
   */
  public String getExprsNo() {
    return exprsNo;
  }

  /**
   * @param exprsNo 要设置的 exprsNo
   */
  public void setExprsNo(String exprsNo) {
    this.exprsNo = exprsNo;
  }

  /**
   * @return exprsType
   */
  public String getExprsType() {
    return exprsType;
  }

  /**
   * @param exprsType 要设置的 exprsType
   */
  public void setExprsType(String exprsType) {
    this.exprsType = exprsType;
  }

  /**
   * @return operNod
   */
  public String getOperNod() {
    return operNod;
  }

  /**
   * @param operNod 要设置的 operNod
   */
  public void setOperNod(String operNod) {
    this.operNod = operNod;
  }

  /**
   * @return recpnt
   */
  public String getRecpnt() {
    return recpnt;
  }

  /**
   * @param recpnt 要设置的 recpnt
   */
  public void setRecpnt(String recpnt) {
    this.recpnt = recpnt;
  }

  /**
   * @return dispchDocFlgAdd
   */
  public String getDispchDocFlgAdd() {
    return dispchDocFlgAdd;
  }

  /**
   * @param dispchDocFlgAdd 要设置的 dispchDocFlgAdd
   */
  public void setDispchDocFlgAdd(String dispchDocFlgAdd) {
    this.dispchDocFlgAdd = dispchDocFlgAdd;
  }
}
