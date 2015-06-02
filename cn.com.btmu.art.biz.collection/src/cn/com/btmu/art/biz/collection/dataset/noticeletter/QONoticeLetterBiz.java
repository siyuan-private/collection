/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.noticeletter;

import com.eos.data.sdo.IObjectFactory;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.TypeHelper;

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
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getNoticeLetterType <em>NoticeLetterType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTrasfTKind <em>TrasfTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTrasfNoPrmryRefNo <em>TrasfNoPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTrasfNoSubRefNo <em>TrasfNoSubRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getRegDate <em>RegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getStlmtMeth <em>StlmtMeth</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getLcNo <em>LcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getDocRecvdCcy <em>DocRecvdCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getDocRecvdAmt <em>DocRecvdAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTerm <em>Term</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getDueDate <em>DueDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getPayeeName <em>PayeeName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getNtid <em>Ntid</em>}</li>
 * </ul>
 * </p>
 *
 * @extends DataObject;
 */
public interface QONoticeLetterBiz extends DataObject {

	public final static String QNAME = "cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz";

	public final static Type TYPE = TypeHelper.INSTANCE.getType("cn.com.btmu.art.biz.collection.dataset.noticeletter", "QONoticeLetterBiz");

	public final static IObjectFactory<QONoticeLetterBiz> FACTORY = new IObjectFactory<QONoticeLetterBiz>() {
		public QONoticeLetterBiz create() {
			return (QONoticeLetterBiz) DataFactory.INSTANCE.create(TYPE);
		}
	};

	/**
	 * Returns the value of the '<em><b>NoticeLetterType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NoticeLetterType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NoticeLetterType</em>' attribute.
	 * @see #setNoticeLetterType(java.lang.String)
	 */
	public String getNoticeLetterType();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getNoticeLetterType <em>NoticeLetterType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NoticeLetterType</em>' attribute.
	 * @see #getNoticeLetterType()
	 */
	public void setNoticeLetterType(String noticeLetterType);

	/**
	 * Returns the value of the '<em><b>TrasfTKind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TrasfTKind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TrasfTKind</em>' attribute.
	 * @see #setTrasfTKind(java.lang.String)
	 */
	public String getTrasfTKind();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTrasfTKind <em>TrasfTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TrasfTKind</em>' attribute.
	 * @see #getTrasfTKind()
	 */
	public void setTrasfTKind(String trasfTKind);

	/**
	 * Returns the value of the '<em><b>TrasfNoPrmryRefNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TrasfNoPrmryRefNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TrasfNoPrmryRefNo</em>' attribute.
	 * @see #setTrasfNoPrmryRefNo(java.lang.String)
	 */
	public String getTrasfNoPrmryRefNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTrasfNoPrmryRefNo <em>TrasfNoPrmryRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TrasfNoPrmryRefNo</em>' attribute.
	 * @see #getTrasfNoPrmryRefNo()
	 */
	public void setTrasfNoPrmryRefNo(String trasfNoPrmryRefNo);

	/**
	 * Returns the value of the '<em><b>TrasfNoSubRefNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TrasfNoSubRefNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TrasfNoSubRefNo</em>' attribute.
	 * @see #setTrasfNoSubRefNo(java.lang.String)
	 */
	public String getTrasfNoSubRefNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTrasfNoSubRefNo <em>TrasfNoSubRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TrasfNoSubRefNo</em>' attribute.
	 * @see #getTrasfNoSubRefNo()
	 */
	public void setTrasfNoSubRefNo(String trasfNoSubRefNo);

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
	public Date getRegDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getRegDate <em>RegDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RegDate</em>' attribute.
	 * @see #getRegDate()
	 */
	public void setRegDate(Date regDate);

	/**
	 * Returns the value of the '<em><b>StlmtMeth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>StlmtMeth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>StlmtMeth</em>' attribute.
	 * @see #setStlmtMeth(java.lang.String)
	 */
	public String getStlmtMeth();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getStlmtMeth <em>StlmtMeth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>StlmtMeth</em>' attribute.
	 * @see #getStlmtMeth()
	 */
	public void setStlmtMeth(String stlmtMeth);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getLcNo <em>LcNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcNo</em>' attribute.
	 * @see #getLcNo()
	 */
	public void setLcNo(String lcNo);

	/**
	 * Returns the value of the '<em><b>DocRecvdCcy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DocRecvdCcy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DocRecvdCcy</em>' attribute.
	 * @see #setDocRecvdCcy(java.lang.String)
	 */
	public String getDocRecvdCcy();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getDocRecvdCcy <em>DocRecvdCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DocRecvdCcy</em>' attribute.
	 * @see #getDocRecvdCcy()
	 */
	public void setDocRecvdCcy(String docRecvdCcy);

	/**
	 * Returns the value of the '<em><b>DocRecvdAmt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DocRecvdAmt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DocRecvdAmt</em>' attribute.
	 * @see #setDocRecvdAmt(java.math.BigDecimal)
	 */
	public BigDecimal getDocRecvdAmt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getDocRecvdAmt <em>DocRecvdAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DocRecvdAmt</em>' attribute.
	 * @see #getDocRecvdAmt()
	 */
	public void setDocRecvdAmt(BigDecimal docRecvdAmt);

	/**
	 * Returns the value of the '<em><b>Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' attribute.
	 * @see #setTerm(java.lang.String)
	 */
	public String getTerm();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getTerm <em>Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' attribute.
	 * @see #getTerm()
	 */
	public void setTerm(String term);

	/**
	 * Returns the value of the '<em><b>DueDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DueDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DueDate</em>' attribute.
	 * @see #setDueDate(java.util.Date)
	 */
	public Date getDueDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getDueDate <em>DueDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DueDate</em>' attribute.
	 * @see #getDueDate()
	 */
	public void setDueDate(Date dueDate);

	/**
	 * Returns the value of the '<em><b>PayeeName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PayeeName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PayeeName</em>' attribute.
	 * @see #setPayeeName(java.lang.String)
	 */
	public String getPayeeName();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getPayeeName <em>PayeeName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PayeeName</em>' attribute.
	 * @see #getPayeeName()
	 */
	public void setPayeeName(String payeeName);

	/**
	 * Returns the value of the '<em><b>Ntid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ntid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ntid</em>' attribute.
	 * @see #setNtid(int)
	 */
	public int getNtid();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz#getNtid <em>Ntid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ntid</em>' attribute.
	 * @see #getNtid()
	 */
	public void setNtid(int ntid);


}