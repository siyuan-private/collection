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
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getCommonOperSn <em>CommonOperSn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getCommonOperVerSn <em>CommonOperVerSn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getModfctnItemField <em>ModfctnItemField</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getBfChagContnt <em>BfChagContnt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getModfdContnt <em>ModfdContnt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getMakerId <em>MakerId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getTmstmp <em>Tmstmp</em>}</li>
 * </ul>
 * </p>
 *
 * @extends DataObject;
 */
public interface QOModHist extends DataObject {

	public final static String QNAME = "cn.com.btmu.art.biz.collection.dataset.collection.QOModHist";

	public final static Type TYPE = TypeHelper.INSTANCE.getType("cn.com.btmu.art.biz.collection.dataset.collection", "QOModHist");

	public final static IObjectFactory<QOModHist> FACTORY = new IObjectFactory<QOModHist>() {
		public QOModHist create() {
			return (QOModHist) DataFactory.INSTANCE.create(TYPE);
		}
	};

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
	public String getCommonOperSn();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getCommonOperSn <em>CommonOperSn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperSn</em>' attribute.
	 * @see #getCommonOperSn()
	 */
	public void setCommonOperSn(String commonOperSn);

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
	public int getCommonOperVerSn();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getCommonOperVerSn <em>CommonOperVerSn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperVerSn</em>' attribute.
	 * @see #getCommonOperVerSn()
	 */
	public void setCommonOperVerSn(int commonOperVerSn);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getTKind <em>TKind</em>}' attribute.
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnPrmryRefNo</em>' attribute.
	 * @see #getTxnPrmryRefNo()
	 */
	public void setTxnPrmryRefNo(String txnPrmryRefNo);

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
	public String getModfctnItemField();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getModfctnItemField <em>ModfctnItemField</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ModfctnItemField</em>' attribute.
	 * @see #getModfctnItemField()
	 */
	public void setModfctnItemField(String modfctnItemField);

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
	public String getBfChagContnt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getBfChagContnt <em>BfChagContnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BfChagContnt</em>' attribute.
	 * @see #getBfChagContnt()
	 */
	public void setBfChagContnt(String bfChagContnt);

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
	public String getModfdContnt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getModfdContnt <em>ModfdContnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ModfdContnt</em>' attribute.
	 * @see #getModfdContnt()
	 */
	public void setModfdContnt(String modfdContnt);

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
	public String getMakerId();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getMakerId <em>MakerId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MakerId</em>' attribute.
	 * @see #getMakerId()
	 */
	public void setMakerId(String makerId);

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
	public Date getTmstmp();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOModHist#getTmstmp <em>Tmstmp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tmstmp</em>' attribute.
	 * @see #getTmstmp()
	 */
	public void setTmstmp(Date tmstmp);


}