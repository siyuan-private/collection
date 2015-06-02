/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.collection.impl;

import cn.com.btmu.art.biz.collection.dataset.collection.QOModHist;

import com.primeton.ext.data.sdo.DataUtil;
import com.primeton.ext.data.sdo.ExtendedDataObjectImpl;

import commonj.sdo.Type;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getCommonOperSn <em>CommonOperSn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getCommonOperVerSn <em>CommonOperVerSn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getModfctnItemField <em>ModfctnItemField</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getBfChagContnt <em>BfChagContnt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getModfdContnt <em>ModfdContnt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getMakerId <em>MakerId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOModHistImpl#getTmstmp <em>Tmstmp</em>}</li>
 * </ul>
 * </p>
 *
 * @extends ExtendedDataObjectImpl;
 *
 * @implements QOModHist;
 */

public class QOModHistImpl extends ExtendedDataObjectImpl implements QOModHist {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	public final static int INDEX_COMMONOPERSN = 0;
	public final static int INDEX_COMMONOPERVERSN = 1;
	public final static int INDEX_TKIND = 2;
	public final static int INDEX_TXNPRMRYREFNO = 3;
	public final static int INDEX_MODFCTNITEMFIELD = 4;
	public final static int INDEX_BFCHAGCONTNT = 5;
	public final static int INDEX_MODFDCONTNT = 6;
	public final static int INDEX_MAKERID = 7;
	public final static int INDEX_TMSTMP = 8;
	public final static int SDO_PROPERTY_COUNT = 9;

	public final static int EXTENDED_PROPERTY_COUNT = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOModHistImpl() {
		this(TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOModHistImpl(Type type) {
		super(type);
	}

	protected void validate() {
		validateType(TYPE);
	}

	/**
	 * Returns the value of the '<em><b>CommonOperSn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOperSn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOperSn</em>' attribute.
	 * @see #setCommonOperSn(java.lang.String)
	 */
	public String getCommonOperSn() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONOPERSN, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOperSn <em>CommonOperSn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperSn</em>' attribute.
	 * @see #getCommonOperSn()
	 */
	public void setCommonOperSn(String commonOperSn) {
		super.setByIndex(INDEX_COMMONOPERSN, commonOperSn);
	}

	/**
	 * Returns the value of the '<em><b>CommonOperVerSn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOperVerSn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOperVerSn</em>' attribute.
	 * @see #setCommonOperVerSn(int)
	 */
	public int getCommonOperVerSn() {
		return DataUtil.toInt(super.getByIndex(INDEX_COMMONOPERVERSN, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOperVerSn <em>CommonOperVerSn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperVerSn</em>' attribute.
	 * @see #getCommonOperVerSn()
	 */
	public void setCommonOperVerSn(int commonOperVerSn) {
		super.setByIndex(INDEX_COMMONOPERVERSN, commonOperVerSn);
	}

	/**
	 * Returns the value of the '<em><b>TKind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TKind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TKind</em>' attribute.
	 * @see #setTKind(java.lang.String)
	 */
	public String getTKind() {
		return DataUtil.toString(super.getByIndex(INDEX_TKIND, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTKind <em>TKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TKind</em>' attribute.
	 * @see #getTKind()
	 */
	public void setTKind(String tKind) {
		super.setByIndex(INDEX_TKIND, tKind);
	}

	/**
	 * Returns the value of the '<em><b>TxnPrmryRefNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TxnPrmryRefNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TxnPrmryRefNo</em>' attribute.
	 * @see #setTxnPrmryRefNo(java.lang.String)
	 */
	public String getTxnPrmryRefNo() {
		return DataUtil.toString(super.getByIndex(INDEX_TXNPRMRYREFNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnPrmryRefNo</em>' attribute.
	 * @see #getTxnPrmryRefNo()
	 */
	public void setTxnPrmryRefNo(String txnPrmryRefNo) {
		super.setByIndex(INDEX_TXNPRMRYREFNO, txnPrmryRefNo);
	}

	/**
	 * Returns the value of the '<em><b>ModfctnItemField</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ModfctnItemField</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ModfctnItemField</em>' attribute.
	 * @see #setModfctnItemField(java.lang.String)
	 */
	public String getModfctnItemField() {
		return DataUtil.toString(super.getByIndex(INDEX_MODFCTNITEMFIELD, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getModfctnItemField <em>ModfctnItemField</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ModfctnItemField</em>' attribute.
	 * @see #getModfctnItemField()
	 */
	public void setModfctnItemField(String modfctnItemField) {
		super.setByIndex(INDEX_MODFCTNITEMFIELD, modfctnItemField);
	}

	/**
	 * Returns the value of the '<em><b>BfChagContnt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BfChagContnt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BfChagContnt</em>' attribute.
	 * @see #setBfChagContnt(java.lang.String)
	 */
	public String getBfChagContnt() {
		return DataUtil.toString(super.getByIndex(INDEX_BFCHAGCONTNT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBfChagContnt <em>BfChagContnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BfChagContnt</em>' attribute.
	 * @see #getBfChagContnt()
	 */
	public void setBfChagContnt(String bfChagContnt) {
		super.setByIndex(INDEX_BFCHAGCONTNT, bfChagContnt);
	}

	/**
	 * Returns the value of the '<em><b>ModfdContnt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ModfdContnt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ModfdContnt</em>' attribute.
	 * @see #setModfdContnt(java.lang.String)
	 */
	public String getModfdContnt() {
		return DataUtil.toString(super.getByIndex(INDEX_MODFDCONTNT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getModfdContnt <em>ModfdContnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ModfdContnt</em>' attribute.
	 * @see #getModfdContnt()
	 */
	public void setModfdContnt(String modfdContnt) {
		super.setByIndex(INDEX_MODFDCONTNT, modfdContnt);
	}

	/**
	 * Returns the value of the '<em><b>MakerId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MakerId</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MakerId</em>' attribute.
	 * @see #setMakerId(java.lang.String)
	 */
	public String getMakerId() {
		return DataUtil.toString(super.getByIndex(INDEX_MAKERID, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getMakerId <em>MakerId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MakerId</em>' attribute.
	 * @see #getMakerId()
	 */
	public void setMakerId(String makerId) {
		super.setByIndex(INDEX_MAKERID, makerId);
	}

	/**
	 * Returns the value of the '<em><b>Tmstmp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tmstmp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tmstmp</em>' attribute.
	 * @see #setTmstmp(java.util.Date)
	 */
	public Date getTmstmp() {
		return DataUtil.toDate(super.getByIndex(INDEX_TMSTMP, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTmstmp <em>Tmstmp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tmstmp</em>' attribute.
	 * @see #getTmstmp()
	 */
	public void setTmstmp(Date tmstmp) {
		super.setByIndex(INDEX_TMSTMP, tmstmp);
	}


}