package cn.com.btmu.art.biz.collection.vo;

/**
 * !ModHisDtlVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class ModHisDtlVO {
  /** 项目名称 */
  private String modfctnItemName;

  /** 修改前 */
  private String bfChagContnt;

  /** 修改后 */
  private String modfdContnt;

  /**
   * @return bfChagContnt
   */
  public String getBfChagContnt() {
    return bfChagContnt;
  }

  /**
   * @param bfChagContnt 要设置的 bfChagContnt
   */
  public void setBfChagContnt(String bfChagContnt) {
    this.bfChagContnt = bfChagContnt;
  }

  /**
   * @return modfctnItemName
   */
  public String getModfctnItemName() {
    return modfctnItemName;
  }

  /**
   * @param modfctnItemName 要设置的 modfctnItemName
   */
  public void setModfctnItemName(String modfctnItemName) {
    this.modfctnItemName = modfctnItemName;
  }

  /**
   * @return modfdContnt
   */
  public String getModfdContnt() {
    return modfdContnt;
  }

  /**
   * @param modfdContnt 要设置的 modfdContnt
   */
  public void setModfdContnt(String modfdContnt) {
    this.modfdContnt = modfdContnt;
  }

}
