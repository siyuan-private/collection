/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.collection.impl;

import cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0119;

import com.primeton.ext.data.sdo.DataUtil;
import com.primeton.ext.data.sdo.ExtendedDataObjectImpl;

import commonj.sdo.Type;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0119Impl#getRegDate <em>RegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0119Impl#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0119Impl#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0119Impl#getBeneName <em>BeneName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0119Impl#getBxCcy <em>BxCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollection0119Impl#getBxAmt <em>BxAmt</em>}</li>
 * </ul>
 * </p>
 *
 * @extends ExtendedDataObjectImpl;
 *
 * @implements QOCollection0119;
 */

public class QOCollection0119Impl extends ExtendedDataObjectImpl implements QOCollection0119 {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	public final static int INDEX_REGDATE = 0;
	public final static int INDEX_TKIND = 1;
	public final static int INDEX_TXNPRMRYREFNO = 2;
	public final static int INDEX_BENENAME = 3;
	public final static int INDEX_BXCCY = 4;
	public final static int INDEX_BXAMT = 5;
	public final static int SDO_PROPERTY_COUNT = 6;

	public final static int EXTENDED_PROPERTY_COUNT = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOCollection0119Impl() {
		this(TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOCollection0119Impl(Type type) {
		super(type);
	}

	protected void validate() {
		validateType(TYPE);
	}

	/**
	 * Returns the value of the '<em><b>RegDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RegDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>RegDate</em>' attribute.
	 * @see #setRegDate(java.util.Date)
	 */
	public Date getRegDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_REGDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getRegDate <em>RegDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RegDate</em>' attribute.
	 * @see #getRegDate()
	 */
	public void setRegDate(Date regDate) {
		super.setByIndex(INDEX_REGDATE, regDate);
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
	 * Returns the value of the '<em><b>BeneName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BeneName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BeneName</em>' attribute.
	 * @see #setBeneName(java.lang.String)
	 */
	public String getBeneName() {
		return DataUtil.toString(super.getByIndex(INDEX_BENENAME, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBeneName <em>BeneName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BeneName</em>' attribute.
	 * @see #getBeneName()
	 */
	public void setBeneName(String beneName) {
		super.setByIndex(INDEX_BENENAME, beneName);
	}

	/**
	 * Returns the value of the '<em><b>BxCcy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BxCcy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BxCcy</em>' attribute.
	 * @see #setBxCcy(java.lang.String)
	 */
	public String getBxCcy() {
		return DataUtil.toString(super.getByIndex(INDEX_BXCCY, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBxCcy <em>BxCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BxCcy</em>' attribute.
	 * @see #getBxCcy()
	 */
	public void setBxCcy(String bxCcy) {
		super.setByIndex(INDEX_BXCCY, bxCcy);
	}

	/**
	 * Returns the value of the '<em><b>BxAmt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BxAmt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BxAmt</em>' attribute.
	 * @see #setBxAmt(java.math.BigDecimal)
	 */
	public BigDecimal getBxAmt() {
		return DataUtil.toBigDecimal(super.getByIndex(INDEX_BXAMT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBxAmt <em>BxAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BxAmt</em>' attribute.
	 * @see #getBxAmt()
	 */
	public void setBxAmt(BigDecimal bxAmt) {
		super.setByIndex(INDEX_BXAMT, bxAmt);
	}


}