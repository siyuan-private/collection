package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;

/**
 * !ModHisDtlVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class ModHistVO {
	  /** T-Kind */
	  private String tkind;

	  /** 交易主参号 */
	  private String txnPrmryRefNo;

	  /** 修改项目 */
	  private String modfctnItemField;

	  /** 修改前 */
	  private String bfChagContnt;

	  /** 修改后 */
	  private String modfdContnt;

	  /** 修改时间 */
	  private Date tmstmp;

	  /** 操作人员 */
	  private String makerId;

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
	 * @return makerId
	 */
	public String getMakerId() {
		return makerId;
	}

	/**
	 * @param makerId 要设置的 makerId
	 */
	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	/**
	 * @return modfctnItemField
	 */
	public String getModfctnItemField() {
		return modfctnItemField;
	}

	/**
	 * @param modfctnItemField 要设置的 modfctnItemField
	 */
	public void setModfctnItemField(String modfctnItemField) {
		this.modfctnItemField = modfctnItemField;
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

	/**
	 * @return tkind
	 */
	public String getTkind() {
		return tkind;
	}

	/**
	 * @param tkind 要设置的 tkind
	 */
	public void setTkind(String tkind) {
		this.tkind = tkind;
	}

	/**
	 * @return tmstmp
	 */
	public Date getTmstmp() {
		return tmstmp;
	}

	/**
	 * @param tmstmp 要设置的 tmstmp
	 */
	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	/**
	 * @return txnPrmryRefNo
	 */
	public String getTxnPrmryRefNo() {
		return txnPrmryRefNo;
	}

	/**
	 * @param txnPrmryRefNo 要设置的 txnPrmryRefNo
	 */
	public void setTxnPrmryRefNo(String txnPrmryRefNo) {
		this.txnPrmryRefNo = txnPrmryRefNo;
	}
}
