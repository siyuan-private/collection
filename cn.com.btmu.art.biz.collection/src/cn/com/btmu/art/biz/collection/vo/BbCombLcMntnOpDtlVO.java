package cn.com.btmu.art.biz.collection.vo;

import java.math.BigDecimal;

/**
 * !BbCombLcMntnOpDtlVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class BbCombLcMntnOpDtlVO {
  /** 信用证编号 */
  private String lcNo;

  /** 信用证金额.币种 */
  private String lcCcy;

  /** 信用证金额.金额 */
  private BigDecimal lcAmt;

  /** drawn amount.币种 */
  private String drawnCcy;

  /** drawn amount.金额 */
  private BigDecimal drawnAmt;

  /** 信用证余额.币种 */
  private String lcBalCcy;

  /** 信用证余额.金额 */
  private BigDecimal lcBalAmt;

  /**
   * @return drawnAmt
   */
  public BigDecimal getDrawnAmt() {
    return drawnAmt;
  }

  /**
   * @param drawnAmt 要设置的 drawnAmt
   */
  public void setDrawnAmt(BigDecimal drawnAmt) {
    this.drawnAmt = drawnAmt;
  }

  /**
   * @return drawnCcy
   */
  public String getDrawnCcy() {
    return drawnCcy;
  }

  /**
   * @param drawnCcy 要设置的 drawnCcy
   */
  public void setDrawnCcy(String drawnCcy) {
    this.drawnCcy = drawnCcy;
  }

  /**
   * @return lcAmt
   */
  public BigDecimal getLcAmt() {
    return lcAmt;
  }

  /**
   * @param lcAmt 要设置的 lcAmt
   */
  public void setLcAmt(BigDecimal lcAmt) {
    this.lcAmt = lcAmt;
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
   * @return lcCcy
   */
  public String getLcCcy() {
    return lcCcy;
  }

  /**
   * @param lcCcy 要设置的 lcCcy
   */
  public void setLcCcy(String lcCcy) {
    this.lcCcy = lcCcy;
  }

  /**
   * @return lcNo
   */
  public String getLcNo() {
    return lcNo;
  }

  /**
   * @param lcNo 要设置的 lcNo
   */
  public void setLcNo(String lcNo) {
    this.lcNo = lcNo;
  }

}
