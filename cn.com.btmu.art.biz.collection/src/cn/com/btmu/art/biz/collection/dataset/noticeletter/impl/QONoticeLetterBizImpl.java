/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.noticeletter.impl;

import cn.com.btmu.art.biz.collection.dataset.noticeletter.QONoticeLetterBiz;

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
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getNoticeLetterType <em>NoticeLetterType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getTrasfTKind <em>TrasfTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getTrasfNoPrmryRefNo <em>TrasfNoPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getTrasfNoSubRefNo <em>TrasfNoSubRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getRegDate <em>RegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getStlmtMeth <em>StlmtMeth</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getLcNo <em>LcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getDocRecvdCcy <em>DocRecvdCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getDocRecvdAmt <em>DocRecvdAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getTerm <em>Term</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getDueDate <em>DueDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getPayeeName <em>PayeeName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.noticeletter.impl.QONoticeLetterBizImpl#getNtid <em>Ntid</em>}</li>
 * </ul>
 * </p>
 *
 * @extends ExtendedDataObjectImpl;
 *
 * @implements QONoticeLetterBiz;
 */

public class QONoticeLetterBizImpl extends ExtendedDataObjectImpl implements QONoticeLetterBiz {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	public final static int INDEX_NOTICELETTERTYPE = 0;
	public final static int INDEX_TRASFTKIND = 1;
	public final static int INDEX_TRASFNOPRMRYREFNO = 2;
	public final static int INDEX_TRASFNOSUBREFNO = 3;
	public final static int INDEX_REGDATE = 4;
	public final static int INDEX_STLMTMETH = 5;
	public final static int INDEX_LCNO = 6;
	public final static int INDEX_DOCRECVDCCY = 7;
	public final static int INDEX_DOCRECVDAMT = 8;
	public final static int INDEX_TERM = 9;
	public final static int INDEX_DUEDATE = 10;
	public final static int INDEX_PAYEENAME = 11;
	public final static int INDEX_NTID = 12;
	public final static int SDO_PROPERTY_COUNT = 13;

	public final static int EXTENDED_PROPERTY_COUNT = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QONoticeLetterBizImpl() {
		this(TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QONoticeLetterBizImpl(Type type) {
		super(type);
	}

	protected void validate() {
		validateType(TYPE);
	}

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
	public String getNoticeLetterType() {
		return DataUtil.toString(super.getByIndex(INDEX_NOTICELETTERTYPE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getNoticeLetterType <em>NoticeLetterType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NoticeLetterType</em>' attribute.
	 * @see #getNoticeLetterType()
	 */
	public void setNoticeLetterType(String noticeLetterType) {
		super.setByIndex(INDEX_NOTICELETTERTYPE, noticeLetterType);
	}

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
	public String getTrasfTKind() {
		return DataUtil.toString(super.getByIndex(INDEX_TRASFTKIND, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTrasfTKind <em>TrasfTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TrasfTKind</em>' attribute.
	 * @see #getTrasfTKind()
	 */
	public void setTrasfTKind(String trasfTKind) {
		super.setByIndex(INDEX_TRASFTKIND, trasfTKind);
	}

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
	public String getTrasfNoPrmryRefNo() {
		return DataUtil.toString(super.getByIndex(INDEX_TRASFNOPRMRYREFNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTrasfNoPrmryRefNo <em>TrasfNoPrmryRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TrasfNoPrmryRefNo</em>' attribute.
	 * @see #getTrasfNoPrmryRefNo()
	 */
	public void setTrasfNoPrmryRefNo(String trasfNoPrmryRefNo) {
		super.setByIndex(INDEX_TRASFNOPRMRYREFNO, trasfNoPrmryRefNo);
	}

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
	public String getTrasfNoSubRefNo() {
		return DataUtil.toString(super.getByIndex(INDEX_TRASFNOSUBREFNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTrasfNoSubRefNo <em>TrasfNoSubRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TrasfNoSubRefNo</em>' attribute.
	 * @see #getTrasfNoSubRefNo()
	 */
	public void setTrasfNoSubRefNo(String trasfNoSubRefNo) {
		super.setByIndex(INDEX_TRASFNOSUBREFNO, trasfNoSubRefNo);
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
	public String getStlmtMeth() {
		return DataUtil.toString(super.getByIndex(INDEX_STLMTMETH, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getStlmtMeth <em>StlmtMeth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>StlmtMeth</em>' attribute.
	 * @see #getStlmtMeth()
	 */
	public void setStlmtMeth(String stlmtMeth) {
		super.setByIndex(INDEX_STLMTMETH, stlmtMeth);
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
	public String getDocRecvdCcy() {
		return DataUtil.toString(super.getByIndex(INDEX_DOCRECVDCCY, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDocRecvdCcy <em>DocRecvdCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DocRecvdCcy</em>' attribute.
	 * @see #getDocRecvdCcy()
	 */
	public void setDocRecvdCcy(String docRecvdCcy) {
		super.setByIndex(INDEX_DOCRECVDCCY, docRecvdCcy);
	}

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
	public BigDecimal getDocRecvdAmt() {
		return DataUtil.toBigDecimal(super.getByIndex(INDEX_DOCRECVDAMT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDocRecvdAmt <em>DocRecvdAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DocRecvdAmt</em>' attribute.
	 * @see #getDocRecvdAmt()
	 */
	public void setDocRecvdAmt(BigDecimal docRecvdAmt) {
		super.setByIndex(INDEX_DOCRECVDAMT, docRecvdAmt);
	}

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
	public String getTerm() {
		return DataUtil.toString(super.getByIndex(INDEX_TERM, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTerm <em>Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' attribute.
	 * @see #getTerm()
	 */
	public void setTerm(String term) {
		super.setByIndex(INDEX_TERM, term);
	}

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
	public Date getDueDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_DUEDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDueDate <em>DueDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DueDate</em>' attribute.
	 * @see #getDueDate()
	 */
	public void setDueDate(Date dueDate) {
		super.setByIndex(INDEX_DUEDATE, dueDate);
	}

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
	public String getPayeeName() {
		return DataUtil.toString(super.getByIndex(INDEX_PAYEENAME, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getPayeeName <em>PayeeName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PayeeName</em>' attribute.
	 * @see #getPayeeName()
	 */
	public void setPayeeName(String payeeName) {
		super.setByIndex(INDEX_PAYEENAME, payeeName);
	}

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
	public int getNtid() {
		return DataUtil.toInt(super.getByIndex(INDEX_NTID, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getNtid <em>Ntid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ntid</em>' attribute.
	 * @see #getNtid()
	 */
	public void setNtid(int ntid) {
		super.setByIndex(INDEX_NTID, ntid);
	}


}