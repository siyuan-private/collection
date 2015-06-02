package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;

/**
 * !FaultHistInfoVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class FaultHistInfoVO {
  /** 故障编号 */
  private String faultNo;

  /** 故障日期 */
  private Date regDate;

  /**
   * @return faultNo
   */
  public String getFaultNo() {
    return faultNo;
  }

  /**
   * @param faultNo 要设置的 faultNo
   */
  public void setFaultNo(String faultNo) {
    this.faultNo = faultNo;
  }

  /**
   * @return regDate
   */
  public Date getRegDate() {
    return regDate;
  }

  /**
   * @param regDate 要设置的 regDate
   */
  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

}
