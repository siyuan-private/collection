package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;
import java.util.List;

/**
 * !BbModChgbkDocInfoVO
 * 
 * @author ivison
 * @version 1.0.0
 *
 */
public class BbModChgbkDocInfoVO {
  /** 退改单 */
  private String bbMaintType;

  /** 登记日 */
  private Date regDate;

  /** 原因 */
  private String resn;

  /** 备注 */
  private String modChgbkDocRmrk;
  
  /** WSID1 */
  private String modChgbkDocWsid1;

  /** WSID2 */
  private String modChgbkDocWsid2;

  /** WSID日期 */
  private Date modChgbkDocWsidDate;

  /** 退改单.修改履历 */
  private List<ModHisDtlVO> modHisDtlVOList;

  /**
   * @return bbMaintType
   */
  public String getBbMaintType() {
    return bbMaintType;
  }

  /**
   * @param bbMaintType 要设置的 bbMaintType
   */
  public void setBbMaintType(String bbMaintType) {
    this.bbMaintType = bbMaintType;
  }

  /**
   * @return modChgbkDocRmrk
   */
  public String getModChgbkDocRmrk() {
    return modChgbkDocRmrk;
  }

  /**
   * @param modChgbkDocRmrk 要设置的 modChgbkDocRmrk
   */
  public void setModChgbkDocRmrk(String modChgbkDocRmrk) {
    this.modChgbkDocRmrk = modChgbkDocRmrk;
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
   * @return modHisDtlVOList
   */
  public List<ModHisDtlVO> getModHisDtlVOList() {
    return modHisDtlVOList;
  }

  /**
   * @param modHisDtlVOList 要设置的 modHisDtlVOList
   */
  public void setModHisDtlVOList(List<ModHisDtlVO> modHisDtlVOList) {
    this.modHisDtlVOList = modHisDtlVOList;
  }
  
  /**
   * @return modChgbkDocWsid1
   */
  public String getModChgbkDocWsid1() {
    return modChgbkDocWsid1;
  }

  /**
   * @param modChgbkDocWsid1 要设置的 modChgbkDocWsid1
   */
  public void setModChgbkDocWsid1(String modChgbkDocWsid1) {
    this.modChgbkDocWsid1 = modChgbkDocWsid1;
  }

  /**
   * @return modChgbkDocWsid2
   */
  public String getModChgbkDocWsid2() {
    return modChgbkDocWsid2;
  }

  /**
   * @param modChgbkDocWsid1 要设置的 modChgbkDocWsid1
   */
  public void setModChgbkDocWsid2(String modChgbkDocWsid2) {
    this.modChgbkDocWsid2 = modChgbkDocWsid2;
  }

  /**
   * @return modChgbkDocWsidDate
   */
  public Date getModChgbkDocWsidDate() {
    return modChgbkDocWsidDate;
  }

  /**
   * @param modChgbkDocWsidDate 要设置的 modChgbkDocWsidDate
   */
  public void setModChgbkDocWsidDate(Date modChgbkDocWsidDate) {
    this.modChgbkDocWsidDate = modChgbkDocWsidDate;
  }

}
