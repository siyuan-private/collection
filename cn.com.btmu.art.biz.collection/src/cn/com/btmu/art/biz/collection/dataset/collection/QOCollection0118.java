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

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBeneName <em>BeneName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBxCcy <em>BxCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBxAmt <em>BxAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBizGroupId <em>BizGroupId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBranchCode <em>BranchCode</em>}</li>
 * </ul>
 * </p>
 *
 * @extends DataObject;
 */
public interface QOCollection0118 extends DataObject {

	public final static String QNAME = "cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118";

	public final static Type TYPE = TypeHelper.INSTANCE.getType("cn.com.btmu.art.biz.collection.dataset.collection", "QOCollection0118");

	public final static IObjectFactory<QOCollection0118> FACTORY = new IObjectFactory<QOCollection0118>() {
		public QOCollection0118 create() {
			return (QOCollection0118) DataFactory.INSTANCE.create(TYPE);
		}
	};

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getTKind <em>TKind</em>}' attribute.
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnPrmryRefNo</em>' attribute.
	 * @see #getTxnPrmryRefNo()
	 */
	public void setTxnPrmryRefNo(String txnPrmryRefNo);

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
	public String getBeneName();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBeneName <em>BeneName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BeneName</em>' attribute.
	 * @see #getBeneName()
	 */
	public void setBeneName(String beneName);

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
	public String getBxCcy();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBxCcy <em>BxCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BxCcy</em>' attribute.
	 * @see #getBxCcy()
	 */
	public void setBxCcy(String bxCcy);

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
	public BigDecimal getBxAmt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBxAmt <em>BxAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BxAmt</em>' attribute.
	 * @see #getBxAmt()
	 */
	public void setBxAmt(BigDecimal bxAmt);

	/**
	 * Returns the value of the '<em><b>BizGroupId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BizGroupId</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BizGroupId</em>' attribute.
	 * @see #setBizGroupId(java.lang.String)
	 */
	public String getBizGroupId();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBizGroupId <em>BizGroupId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BizGroupId</em>' attribute.
	 * @see #getBizGroupId()
	 */
	public void setBizGroupId(String bizGroupId);

	/**
	 * Returns the value of the '<em><b>BranchCode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BranchCode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BranchCode</em>' attribute.
	 * @see #setBranchCode(java.lang.String)
	 */
	public String getBranchCode();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollection0118#getBranchCode <em>BranchCode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BranchCode</em>' attribute.
	 * @see #getBranchCode()
	 */
	public void setBranchCode(String branchCode);


}