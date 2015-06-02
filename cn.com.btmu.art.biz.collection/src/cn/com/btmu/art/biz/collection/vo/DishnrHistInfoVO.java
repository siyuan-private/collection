package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;

/**
 * !DishnrHistInfoVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class DishnrHistInfoVO {
  /** 拒付编号 */
  private String dishnrNo;

  /** 拒付日期 */
  private Date regDate;

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
