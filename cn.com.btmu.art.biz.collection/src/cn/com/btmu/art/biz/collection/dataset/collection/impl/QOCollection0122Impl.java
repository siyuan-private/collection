/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.collection.impl;

import cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0122;

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
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getExprsDispchDocDate <em>ExprsDispchDocDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getBizType <em>BizType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getDispchDocType <em>DispchDocType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getExprsNo <em>ExprsNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getTxnSubRefNo <em>TxnSubRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getLcNo <em>LcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getRecpnt <em>Recpnt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0122Impl#getRmrk <em>Rmrk</em>}</li>
 * </ul>
 * </p>
 *
 * @extends ExtendedDataObjectImpl;
 *
 * @implements QOCollection0122;
 */

public class QOCollection0122Impl extends ExtendedDataObjectImpl implements QOCollection0122 {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	public final static int INDEX_EXPRSDISPCHDOCDATE = 0;
	public final static int INDEX_BIZTYPE = 1;
	public final static int INDEX_DISPCHDOCTYPE = 2;
	public final static int INDEX_EXPRSNO = 3;
	public final static int INDEX_TKIND = 4;
	public final static int INDEX_TXNPRMRYREFNO = 5;
	public final static int INDEX_TXNSUBREFNO = 6;
	public final static int INDEX_LCNO = 7;
	public final static int INDEX_RECPNT = 8;
	public final static int INDEX_RMRK = 9;
	public final static int SDO_PROPERTY_COUNT = 10;

	public final static int EXTENDED_PROPERTY_COUNT = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOCollection0122Impl() {
		this(TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOCollection0122Impl(Type type) {
		super(type);
	}

	protected void validate() {
		validateType(TYPE);
	}

	/**
	 * Returns the value of the '<em><b>ExprsDispchDocDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ExprsDispchDocDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ExprsDispchDocDate</em>' attribute.
	 * @see #setExprsDispchDocDate(java.util.Date)
	 */
	public Date getExprsDispchDocDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_EXPRSDISPCHDOCDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getExprsDispchDocDate <em>ExprsDispchDocDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExprsDispchDocDate</em>' attribute.
	 * @see #getExprsDispchDocDate()
	 */
	public void setExprsDispchDocDate(Date exprsDispchDocDate) {
		super.setByIndex(INDEX_EXPRSDISPCHDOCDATE, exprsDispchDocDate);
	}

	/**
	 * Returns the value of the '<em><b>BizType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BizType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BizType</em>' attribute.
	 * @see #setBizType(java.lang.String)
	 */
	public String getBizType() {
		return DataUtil.toString(super.getByIndex(INDEX_BIZTYPE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBizType <em>BizType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BizType</em>' attribute.
	 * @see #getBizType()
	 */
	public void setBizType(String bizType) {
		super.setByIndex(INDEX_BIZTYPE, bizType);
	}

	/**
	 * Returns the value of the '<em><b>DispchDocType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DispchDocType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DispchDocType</em>' attribute.
	 * @see #setDispchDocType(java.lang.String)
	 */
	public String getDispchDocType() {
		return DataUtil.toString(super.getByIndex(INDEX_DISPCHDOCTYPE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDispchDocType <em>DispchDocType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DispchDocType</em>' attribute.
	 * @see #getDispchDocType()
	 */
	public void setDispchDocType(String dispchDocType) {
		super.setByIndex(INDEX_DISPCHDOCTYPE, dispchDocType);
	}

	/**
	 * Returns the value of the '<em><b>ExprsNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ExprsNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ExprsNo</em>' attribute.
	 * @see #setExprsNo(java.lang.String)
	 */
	public String getExprsNo() {
		return DataUtil.toString(super.getByIndex(INDEX_EXPRSNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getExprsNo <em>ExprsNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExprsNo</em>' attribute.
	 * @see #getExprsNo()
	 */
	public void setExprsNo(String exprsNo) {
		super.setByIndex(INDEX_EXPRSNO, exprsNo);
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
	 * Returns the value of the '<em><b>TxnSubRefNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TxnSubRefNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TxnSubRefNo</em>' attribute.
	 * @see #setTxnSubRefNo(java.lang.String)
	 */
	public String getTxnSubRefNo() {
		return DataUtil.toString(super.getByIndex(INDEX_TXNSUBREFNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTxnSubRefNo <em>TxnSubRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnSubRefNo</em>' attribute.
	 * @see #getTxnSubRefNo()
	 */
	public void setTxnSubRefNo(String txnSubRefNo) {
		super.setByIndex(INDEX_TXNSUBREFNO, txnSubRefNo);
	}

	/**
	 * Returns the value of the '<em><b>LcNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LcNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LcNo</em>' attribute.
	 * @see #setLcNo(java.lang.String)
	 */
	public String getLcNo() {
		return DataUtil.toString(super.getByIndex(INDEX_LCNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getLcNo <em>LcNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcNo</em>' attribute.
	 * @see #getLcNo()
	 */
	public void setLcNo(String lcNo) {
		super.setByIndex(INDEX_LCNO, lcNo);
	}

	/**
	 * Returns the value of the '<em><b>Recpnt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recpnt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recpnt</em>' attribute.
	 * @see #setRecpnt(java.lang.String)
	 */
	public String getRecpnt() {
		return DataUtil.toString(super.getByIndex(INDEX_RECPNT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getRecpnt <em>Recpnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recpnt</em>' attribute.
	 * @see #getRecpnt()
	 */
	public void setRecpnt(String recpnt) {
		super.setByIndex(INDEX_RECPNT, recpnt);
	}

	/**
	 * Returns the value of the '<em><b>Rmrk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rmrk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rmrk</em>' attribute.
	 * @see #setRmrk(java.lang.String)
	 */
	public String getRmrk() {
		return DataUtil.toString(super.getByIndex(INDEX_RMRK, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getRmrk <em>Rmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rmrk</em>' attribute.
	 * @see #getRmrk()
	 */
	public void setRmrk(String rmrk) {
		super.setByIndex(INDEX_RMRK, rmrk);
	}


}