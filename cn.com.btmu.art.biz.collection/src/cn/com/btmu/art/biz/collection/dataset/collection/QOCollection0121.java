/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.collection;

import com.eos.data.sdo.IObjectFactory;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getExprsDispchDocDate <em>ExprsDispchDocDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getBizType <em>BizType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getDispchDocType <em>DispchDocType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getExprsNo <em>ExprsNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getTxnSubRefNo <em>TxnSubRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getLcNo <em>LcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getRecpnt <em>Recpnt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getRmrk <em>Rmrk</em>}</li>
 * </ul>
 * </p>
 *
 * @extends DataObject;
 */
public interface QOCollection0121 extends DataObject {

	public final static String QNAME = "cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121";

	public final static Type TYPE = TypeHelper.INSTANCE.getType("cn.com.btmu.art.biz.collection.dataset.collection", "QOCollection0121");

	public final static IObjectFactory<QOCollection0121> FACTORY = new IObjectFactory<QOCollection0121>() {
		public QOCollection0121 create() {
			return (QOCollection0121) DataFactory.INSTANCE.create(TYPE);
		}
	};

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
	public Date getExprsDispchDocDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getExprsDispchDocDate <em>ExprsDispchDocDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExprsDispchDocDate</em>' attribute.
	 * @see #getExprsDispchDocDate()
	 */
	public void setExprsDispchDocDate(Date exprsDispchDocDate);

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
	public String getBizType();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getBizType <em>BizType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BizType</em>' attribute.
	 * @see #getBizType()
	 */
	public void setBizType(String bizType);

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
	public String getDispchDocType();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getDispchDocType <em>DispchDocType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DispchDocType</em>' attribute.
	 * @see #getDispchDocType()
	 */
	public void setDispchDocType(String dispchDocType);

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
	public String getExprsNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getExprsNo <em>ExprsNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExprsNo</em>' attribute.
	 * @see #getExprsNo()
	 */
	public void setExprsNo(String exprsNo);

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
	public String getTKind();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getTKind <em>TKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TKind</em>' attribute.
	 * @see #getTKind()
	 */
	public void setTKind(String tKind);

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
	public String getTxnPrmryRefNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnPrmryRefNo</em>' attribute.
	 * @see #getTxnPrmryRefNo()
	 */
	public void setTxnPrmryRefNo(String txnPrmryRefNo);

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
	public String getTxnSubRefNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getTxnSubRefNo <em>TxnSubRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnSubRefNo</em>' attribute.
	 * @see #getTxnSubRefNo()
	 */
	public void setTxnSubRefNo(String txnSubRefNo);

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
	public String getLcNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getLcNo <em>LcNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcNo</em>' attribute.
	 * @see #getLcNo()
	 */
	public void setLcNo(String lcNo);

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
	public String getRecpnt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getRecpnt <em>Recpnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recpnt</em>' attribute.
	 * @see #getRecpnt()
	 */
	public void setRecpnt(String recpnt);

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
	public String getRmrk();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0121#getRmrk <em>Rmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rmrk</em>' attribute.
	 * @see #getRmrk()
	 */
	public void setRmrk(String rmrk);


}