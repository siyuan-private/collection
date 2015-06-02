/*******************************************************************************
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 *
 * Created on Apr 11, 2008
 *******************************************************************************/
package cn.com.btmu.art.biz.collection.dataset.collection.impl;

import cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionOpr;

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
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTxnSubRefNo <em>TxnSubRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBeneCif <em>BeneCif</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBeneName <em>BeneName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBxCcy <em>BxCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBxAmt <em>BxAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTenorType <em>TenorType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getDueDate <em>DueDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getNatnlty <em>Natnlty</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getFaultNo <em>FaultNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getDomstcLcFlg <em>DomstcLcFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getPerfmConfmDuties <em>PerfmConfmDuties</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOperStatus <em>CommonOperStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOper <em>CommonOper</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonPriceStatus <em>CommonPriceStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonBizStatus <em>CommonBizStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOperSn <em>CommonOperSn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCollDate <em>CollDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getIvcNo <em>IvcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getLcFlg <em>LcFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBpoFlg <em>BpoFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTsuFlg <em>TsuFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getLcNo <em>LcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getExpImptrName <em>ExpImptrName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBcImptrName <em>BcImptrName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getExpDispch <em>ExpDispch</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getNonExpDispch <em>NonExpDispch</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getAccptceRegDate <em>AccptceRegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getAccptceDueDate <em>AccptceDueDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getPosDate <em>PosDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getOurBankToCustBookingDate <em>OurBankToCustBookingDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getPosCcy <em>PosCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getPosAmt <em>PosAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTheirDedctCcy <em>TheirDedctCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTheirDedctAmt <em>TheirDedctAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getPpnegoFlg <em>PpnegoFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTelegNegoFlg <em>TelegNegoFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getTelegNegoClsDate <em>TelegNegoClsDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBcRmrk <em>BcRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getRegDate <em>RegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getModChgbkRmrk <em>ModChgbkRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getFakeForwdFlg <em>FakeForwdFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getExpOsa <em>ExpOsa</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getReimbBankName <em>ReimbBankName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBcOsa <em>BcOsa</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getDishnrNo <em>DishnrNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getAccptceRmrk <em>AccptceRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getBookRmrk <em>BookRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getResn <em>Resn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getLcBalCcy <em>LcBalCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getLcBalAmt <em>LcBalAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getFaultTKind <em>FaultTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getFaultTxnTKind <em>FaultTxnTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getDishnrTKind <em>DishnrTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getDishnrTxnTKind <em>DishnrTxnTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonBranchCode <em>CommonBranchCode</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonBizGroupId <em>CommonBizGroupId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getMaintType <em>MaintType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOperInfoNo <em>CommonOperInfoNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonAfterwardsStatus <em>CommonAfterwardsStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonMakerId <em>CommonMakerId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonCurrOper <em>CommonCurrOper</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOnpReason <em>CommonOnpReason</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOnpPreDate <em>CommonOnpPreDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOnpRmrk <em>CommonOnpRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommBizNo <em>CommBizNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.impl.QOCollectionOprImpl#getCommonOperVerNo <em>CommonOperVerNo</em>}</li>
 * </ul>
 * </p>
 *
 * @extends ExtendedDataObjectImpl;
 *
 * @implements QOCollectionOpr;
 */

public class QOCollectionOprImpl extends ExtendedDataObjectImpl implements QOCollectionOpr {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	public final static int INDEX_TKIND = 0;
	public final static int INDEX_TXNPRMRYREFNO = 1;
	public final static int INDEX_TXNSUBREFNO = 2;
	public final static int INDEX_BENECIF = 3;
	public final static int INDEX_BENENAME = 4;
	public final static int INDEX_BXCCY = 5;
	public final static int INDEX_BXAMT = 6;
	public final static int INDEX_TENORTYPE = 7;
	public final static int INDEX_DUEDATE = 8;
	public final static int INDEX_NATNLTY = 9;
	public final static int INDEX_FAULTNO = 10;
	public final static int INDEX_DOMSTCLCFLG = 11;
	public final static int INDEX_PERFMCONFMDUTIES = 12;
	public final static int INDEX_COMMONOPERSTATUS = 13;
	public final static int INDEX_COMMONOPER = 14;
	public final static int INDEX_COMMONPRICESTATUS = 15;
	public final static int INDEX_COMMONBIZSTATUS = 16;
	public final static int INDEX_COMMONOPERSN = 17;
	public final static int INDEX_COLLDATE = 18;
	public final static int INDEX_IVCNO = 19;
	public final static int INDEX_LCFLG = 20;
	public final static int INDEX_BPOFLG = 21;
	public final static int INDEX_TSUFLG = 22;
	public final static int INDEX_LCNO = 23;
	public final static int INDEX_EXPIMPTRNAME = 24;
	public final static int INDEX_BCIMPTRNAME = 25;
	public final static int INDEX_EXPDISPCH = 26;
	public final static int INDEX_NONEXPDISPCH = 27;
	public final static int INDEX_ACCPTCEREGDATE = 28;
	public final static int INDEX_ACCPTCEDUEDATE = 29;
	public final static int INDEX_POSDATE = 30;
	public final static int INDEX_OURBANKTOCUSTBOOKINGDATE = 31;
	public final static int INDEX_POSCCY = 32;
	public final static int INDEX_POSAMT = 33;
	public final static int INDEX_THEIRDEDCTCCY = 34;
	public final static int INDEX_THEIRDEDCTAMT = 35;
	public final static int INDEX_PPNEGOFLG = 36;
	public final static int INDEX_TELEGNEGOFLG = 37;
	public final static int INDEX_TELEGNEGOCLSDATE = 38;
	public final static int INDEX_BCRMRK = 39;
	public final static int INDEX_REGDATE = 40;
	public final static int INDEX_MODCHGBKRMRK = 41;
	public final static int INDEX_FAKEFORWDFLG = 42;
	public final static int INDEX_EXPOSA = 43;
	public final static int INDEX_REIMBBANKNAME = 44;
	public final static int INDEX_BCOSA = 45;
	public final static int INDEX_DISHNRNO = 46;
	public final static int INDEX_ACCPTCERMRK = 47;
	public final static int INDEX_BOOKRMRK = 48;
	public final static int INDEX_RESN = 49;
	public final static int INDEX_LCBALCCY = 50;
	public final static int INDEX_LCBALAMT = 51;
	public final static int INDEX_FAULTTKIND = 52;
	public final static int INDEX_FAULTTXNTKIND = 53;
	public final static int INDEX_DISHNRTKIND = 54;
	public final static int INDEX_DISHNRTXNTKIND = 55;
	public final static int INDEX_COMMONBRANCHCODE = 56;
	public final static int INDEX_COMMONBIZGROUPID = 57;
	public final static int INDEX_MAINTTYPE = 58;
	public final static int INDEX_COMMONOPERINFONO = 59;
	public final static int INDEX_COMMONAFTERWARDSSTATUS = 60;
	public final static int INDEX_COMMONMAKERID = 61;
	public final static int INDEX_COMMONCURROPER = 62;
	public final static int INDEX_COMMONONPREASON = 63;
	public final static int INDEX_COMMONONPPREDATE = 64;
	public final static int INDEX_COMMONONPRMRK = 65;
	public final static int INDEX_COMMBIZNO = 66;
	public final static int INDEX_COMMONOPERVERNO = 67;
	public final static int SDO_PROPERTY_COUNT = 68;

	public final static int EXTENDED_PROPERTY_COUNT = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOCollectionOprImpl() {
		this(TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public QOCollectionOprImpl(Type type) {
		super(type);
	}

	protected void validate() {
		validateType(TYPE);
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
	 * Returns the value of the '<em><b>BeneCif</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BeneCif</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BeneCif</em>' attribute.
	 * @see #setBeneCif(java.lang.String)
	 */
	public String getBeneCif() {
		return DataUtil.toString(super.getByIndex(INDEX_BENECIF, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBeneCif <em>BeneCif</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BeneCif</em>' attribute.
	 * @see #getBeneCif()
	 */
	public void setBeneCif(String beneCif) {
		super.setByIndex(INDEX_BENECIF, beneCif);
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

	/**
	 * Returns the value of the '<em><b>TenorType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TenorType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TenorType</em>' attribute.
	 * @see #setTenorType(java.lang.String)
	 */
	public String getTenorType() {
		return DataUtil.toString(super.getByIndex(INDEX_TENORTYPE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTenorType <em>TenorType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TenorType</em>' attribute.
	 * @see #getTenorType()
	 */
	public void setTenorType(String tenorType) {
		super.setByIndex(INDEX_TENORTYPE, tenorType);
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
	 * Returns the value of the '<em><b>Natnlty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Natnlty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Natnlty</em>' attribute.
	 * @see #setNatnlty(java.lang.String)
	 */
	public String getNatnlty() {
		return DataUtil.toString(super.getByIndex(INDEX_NATNLTY, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getNatnlty <em>Natnlty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Natnlty</em>' attribute.
	 * @see #getNatnlty()
	 */
	public void setNatnlty(String natnlty) {
		super.setByIndex(INDEX_NATNLTY, natnlty);
	}

	/**
	 * Returns the value of the '<em><b>FaultNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FaultNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FaultNo</em>' attribute.
	 * @see #setFaultNo(java.lang.String)
	 */
	public String getFaultNo() {
		return DataUtil.toString(super.getByIndex(INDEX_FAULTNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getFaultNo <em>FaultNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FaultNo</em>' attribute.
	 * @see #getFaultNo()
	 */
	public void setFaultNo(String faultNo) {
		super.setByIndex(INDEX_FAULTNO, faultNo);
	}

	/**
	 * Returns the value of the '<em><b>DomstcLcFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DomstcLcFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DomstcLcFlg</em>' attribute.
	 * @see #setDomstcLcFlg(java.lang.String)
	 */
	public String getDomstcLcFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_DOMSTCLCFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDomstcLcFlg <em>DomstcLcFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DomstcLcFlg</em>' attribute.
	 * @see #getDomstcLcFlg()
	 */
	public void setDomstcLcFlg(String domstcLcFlg) {
		super.setByIndex(INDEX_DOMSTCLCFLG, domstcLcFlg);
	}

	/**
	 * Returns the value of the '<em><b>PerfmConfmDuties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PerfmConfmDuties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PerfmConfmDuties</em>' attribute.
	 * @see #setPerfmConfmDuties(java.lang.String)
	 */
	public String getPerfmConfmDuties() {
		return DataUtil.toString(super.getByIndex(INDEX_PERFMCONFMDUTIES, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getPerfmConfmDuties <em>PerfmConfmDuties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PerfmConfmDuties</em>' attribute.
	 * @see #getPerfmConfmDuties()
	 */
	public void setPerfmConfmDuties(String perfmConfmDuties) {
		super.setByIndex(INDEX_PERFMCONFMDUTIES, perfmConfmDuties);
	}

	/**
	 * Returns the value of the '<em><b>CommonOperStatus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOperStatus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOperStatus</em>' attribute.
	 * @see #setCommonOperStatus(java.lang.String)
	 */
	public String getCommonOperStatus() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONOPERSTATUS, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOperStatus <em>CommonOperStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperStatus</em>' attribute.
	 * @see #getCommonOperStatus()
	 */
	public void setCommonOperStatus(String commonOperStatus) {
		super.setByIndex(INDEX_COMMONOPERSTATUS, commonOperStatus);
	}

	/**
	 * Returns the value of the '<em><b>CommonOper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOper</em>' attribute.
	 * @see #setCommonOper(java.lang.String)
	 */
	public String getCommonOper() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONOPER, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOper <em>CommonOper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOper</em>' attribute.
	 * @see #getCommonOper()
	 */
	public void setCommonOper(String commonOper) {
		super.setByIndex(INDEX_COMMONOPER, commonOper);
	}

	/**
	 * Returns the value of the '<em><b>CommonPriceStatus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonPriceStatus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonPriceStatus</em>' attribute.
	 * @see #setCommonPriceStatus(java.lang.String)
	 */
	public String getCommonPriceStatus() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONPRICESTATUS, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonPriceStatus <em>CommonPriceStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonPriceStatus</em>' attribute.
	 * @see #getCommonPriceStatus()
	 */
	public void setCommonPriceStatus(String commonPriceStatus) {
		super.setByIndex(INDEX_COMMONPRICESTATUS, commonPriceStatus);
	}

	/**
	 * Returns the value of the '<em><b>CommonBizStatus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonBizStatus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonBizStatus</em>' attribute.
	 * @see #setCommonBizStatus(java.lang.String)
	 */
	public String getCommonBizStatus() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONBIZSTATUS, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonBizStatus <em>CommonBizStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonBizStatus</em>' attribute.
	 * @see #getCommonBizStatus()
	 */
	public void setCommonBizStatus(String commonBizStatus) {
		super.setByIndex(INDEX_COMMONBIZSTATUS, commonBizStatus);
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
	 * Returns the value of the '<em><b>CollDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CollDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CollDate</em>' attribute.
	 * @see #setCollDate(java.util.Date)
	 */
	public Date getCollDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_COLLDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCollDate <em>CollDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CollDate</em>' attribute.
	 * @see #getCollDate()
	 */
	public void setCollDate(Date collDate) {
		super.setByIndex(INDEX_COLLDATE, collDate);
	}

	/**
	 * Returns the value of the '<em><b>IvcNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IvcNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IvcNo</em>' attribute.
	 * @see #setIvcNo(java.lang.String)
	 */
	public String getIvcNo() {
		return DataUtil.toString(super.getByIndex(INDEX_IVCNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getIvcNo <em>IvcNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IvcNo</em>' attribute.
	 * @see #getIvcNo()
	 */
	public void setIvcNo(String ivcNo) {
		super.setByIndex(INDEX_IVCNO, ivcNo);
	}

	/**
	 * Returns the value of the '<em><b>LcFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LcFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LcFlg</em>' attribute.
	 * @see #setLcFlg(java.lang.String)
	 */
	public String getLcFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_LCFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getLcFlg <em>LcFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcFlg</em>' attribute.
	 * @see #getLcFlg()
	 */
	public void setLcFlg(String lcFlg) {
		super.setByIndex(INDEX_LCFLG, lcFlg);
	}

	/**
	 * Returns the value of the '<em><b>BpoFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BpoFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BpoFlg</em>' attribute.
	 * @see #setBpoFlg(java.lang.String)
	 */
	public String getBpoFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_BPOFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBpoFlg <em>BpoFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BpoFlg</em>' attribute.
	 * @see #getBpoFlg()
	 */
	public void setBpoFlg(String bpoFlg) {
		super.setByIndex(INDEX_BPOFLG, bpoFlg);
	}

	/**
	 * Returns the value of the '<em><b>TsuFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TsuFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TsuFlg</em>' attribute.
	 * @see #setTsuFlg(java.lang.String)
	 */
	public String getTsuFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_TSUFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTsuFlg <em>TsuFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TsuFlg</em>' attribute.
	 * @see #getTsuFlg()
	 */
	public void setTsuFlg(String tsuFlg) {
		super.setByIndex(INDEX_TSUFLG, tsuFlg);
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
	 * Returns the value of the '<em><b>ExpImptrName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ExpImptrName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ExpImptrName</em>' attribute.
	 * @see #setExpImptrName(java.lang.String)
	 */
	public String getExpImptrName() {
		return DataUtil.toString(super.getByIndex(INDEX_EXPIMPTRNAME, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getExpImptrName <em>ExpImptrName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExpImptrName</em>' attribute.
	 * @see #getExpImptrName()
	 */
	public void setExpImptrName(String expImptrName) {
		super.setByIndex(INDEX_EXPIMPTRNAME, expImptrName);
	}

	/**
	 * Returns the value of the '<em><b>BcImptrName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BcImptrName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BcImptrName</em>' attribute.
	 * @see #setBcImptrName(java.lang.String)
	 */
	public String getBcImptrName() {
		return DataUtil.toString(super.getByIndex(INDEX_BCIMPTRNAME, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBcImptrName <em>BcImptrName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BcImptrName</em>' attribute.
	 * @see #getBcImptrName()
	 */
	public void setBcImptrName(String bcImptrName) {
		super.setByIndex(INDEX_BCIMPTRNAME, bcImptrName);
	}

	/**
	 * Returns the value of the '<em><b>ExpDispch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ExpDispch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ExpDispch</em>' attribute.
	 * @see #setExpDispch(java.lang.String)
	 */
	public String getExpDispch() {
		return DataUtil.toString(super.getByIndex(INDEX_EXPDISPCH, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getExpDispch <em>ExpDispch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExpDispch</em>' attribute.
	 * @see #getExpDispch()
	 */
	public void setExpDispch(String expDispch) {
		super.setByIndex(INDEX_EXPDISPCH, expDispch);
	}

	/**
	 * Returns the value of the '<em><b>NonExpDispch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NonExpDispch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NonExpDispch</em>' attribute.
	 * @see #setNonExpDispch(java.lang.String)
	 */
	public String getNonExpDispch() {
		return DataUtil.toString(super.getByIndex(INDEX_NONEXPDISPCH, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getNonExpDispch <em>NonExpDispch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NonExpDispch</em>' attribute.
	 * @see #getNonExpDispch()
	 */
	public void setNonExpDispch(String nonExpDispch) {
		super.setByIndex(INDEX_NONEXPDISPCH, nonExpDispch);
	}

	/**
	 * Returns the value of the '<em><b>AccptceRegDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AccptceRegDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AccptceRegDate</em>' attribute.
	 * @see #setAccptceRegDate(java.util.Date)
	 */
	public Date getAccptceRegDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_ACCPTCEREGDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getAccptceRegDate <em>AccptceRegDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AccptceRegDate</em>' attribute.
	 * @see #getAccptceRegDate()
	 */
	public void setAccptceRegDate(Date accptceRegDate) {
		super.setByIndex(INDEX_ACCPTCEREGDATE, accptceRegDate);
	}

	/**
	 * Returns the value of the '<em><b>AccptceDueDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AccptceDueDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AccptceDueDate</em>' attribute.
	 * @see #setAccptceDueDate(java.util.Date)
	 */
	public Date getAccptceDueDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_ACCPTCEDUEDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getAccptceDueDate <em>AccptceDueDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AccptceDueDate</em>' attribute.
	 * @see #getAccptceDueDate()
	 */
	public void setAccptceDueDate(Date accptceDueDate) {
		super.setByIndex(INDEX_ACCPTCEDUEDATE, accptceDueDate);
	}

	/**
	 * Returns the value of the '<em><b>PosDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PosDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PosDate</em>' attribute.
	 * @see #setPosDate(java.util.Date)
	 */
	public Date getPosDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_POSDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getPosDate <em>PosDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PosDate</em>' attribute.
	 * @see #getPosDate()
	 */
	public void setPosDate(Date posDate) {
		super.setByIndex(INDEX_POSDATE, posDate);
	}

	/**
	 * Returns the value of the '<em><b>OurBankToCustBookingDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OurBankToCustBookingDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OurBankToCustBookingDate</em>' attribute.
	 * @see #setOurBankToCustBookingDate(java.util.Date)
	 */
	public Date getOurBankToCustBookingDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_OURBANKTOCUSTBOOKINGDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getOurBankToCustBookingDate <em>OurBankToCustBookingDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OurBankToCustBookingDate</em>' attribute.
	 * @see #getOurBankToCustBookingDate()
	 */
	public void setOurBankToCustBookingDate(Date ourBankToCustBookingDate) {
		super.setByIndex(INDEX_OURBANKTOCUSTBOOKINGDATE, ourBankToCustBookingDate);
	}

	/**
	 * Returns the value of the '<em><b>PosCcy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PosCcy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PosCcy</em>' attribute.
	 * @see #setPosCcy(java.lang.String)
	 */
	public String getPosCcy() {
		return DataUtil.toString(super.getByIndex(INDEX_POSCCY, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getPosCcy <em>PosCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PosCcy</em>' attribute.
	 * @see #getPosCcy()
	 */
	public void setPosCcy(String posCcy) {
		super.setByIndex(INDEX_POSCCY, posCcy);
	}

	/**
	 * Returns the value of the '<em><b>PosAmt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PosAmt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PosAmt</em>' attribute.
	 * @see #setPosAmt(java.math.BigDecimal)
	 */
	public BigDecimal getPosAmt() {
		return DataUtil.toBigDecimal(super.getByIndex(INDEX_POSAMT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getPosAmt <em>PosAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PosAmt</em>' attribute.
	 * @see #getPosAmt()
	 */
	public void setPosAmt(BigDecimal posAmt) {
		super.setByIndex(INDEX_POSAMT, posAmt);
	}

	/**
	 * Returns the value of the '<em><b>TheirDedctCcy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TheirDedctCcy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TheirDedctCcy</em>' attribute.
	 * @see #setTheirDedctCcy(java.lang.String)
	 */
	public String getTheirDedctCcy() {
		return DataUtil.toString(super.getByIndex(INDEX_THEIRDEDCTCCY, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTheirDedctCcy <em>TheirDedctCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TheirDedctCcy</em>' attribute.
	 * @see #getTheirDedctCcy()
	 */
	public void setTheirDedctCcy(String theirDedctCcy) {
		super.setByIndex(INDEX_THEIRDEDCTCCY, theirDedctCcy);
	}

	/**
	 * Returns the value of the '<em><b>TheirDedctAmt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TheirDedctAmt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TheirDedctAmt</em>' attribute.
	 * @see #setTheirDedctAmt(java.math.BigDecimal)
	 */
	public BigDecimal getTheirDedctAmt() {
		return DataUtil.toBigDecimal(super.getByIndex(INDEX_THEIRDEDCTAMT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTheirDedctAmt <em>TheirDedctAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TheirDedctAmt</em>' attribute.
	 * @see #getTheirDedctAmt()
	 */
	public void setTheirDedctAmt(BigDecimal theirDedctAmt) {
		super.setByIndex(INDEX_THEIRDEDCTAMT, theirDedctAmt);
	}

	/**
	 * Returns the value of the '<em><b>PpnegoFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PpnegoFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PpnegoFlg</em>' attribute.
	 * @see #setPpnegoFlg(java.lang.String)
	 */
	public String getPpnegoFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_PPNEGOFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getPpnegoFlg <em>PpnegoFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PpnegoFlg</em>' attribute.
	 * @see #getPpnegoFlg()
	 */
	public void setPpnegoFlg(String ppnegoFlg) {
		super.setByIndex(INDEX_PPNEGOFLG, ppnegoFlg);
	}

	/**
	 * Returns the value of the '<em><b>TelegNegoFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TelegNegoFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TelegNegoFlg</em>' attribute.
	 * @see #setTelegNegoFlg(java.lang.String)
	 */
	public String getTelegNegoFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_TELEGNEGOFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTelegNegoFlg <em>TelegNegoFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TelegNegoFlg</em>' attribute.
	 * @see #getTelegNegoFlg()
	 */
	public void setTelegNegoFlg(String telegNegoFlg) {
		super.setByIndex(INDEX_TELEGNEGOFLG, telegNegoFlg);
	}

	/**
	 * Returns the value of the '<em><b>TelegNegoClsDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TelegNegoClsDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TelegNegoClsDate</em>' attribute.
	 * @see #setTelegNegoClsDate(java.util.Date)
	 */
	public Date getTelegNegoClsDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_TELEGNEGOCLSDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getTelegNegoClsDate <em>TelegNegoClsDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TelegNegoClsDate</em>' attribute.
	 * @see #getTelegNegoClsDate()
	 */
	public void setTelegNegoClsDate(Date telegNegoClsDate) {
		super.setByIndex(INDEX_TELEGNEGOCLSDATE, telegNegoClsDate);
	}

	/**
	 * Returns the value of the '<em><b>BcRmrk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BcRmrk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BcRmrk</em>' attribute.
	 * @see #setBcRmrk(java.lang.String)
	 */
	public String getBcRmrk() {
		return DataUtil.toString(super.getByIndex(INDEX_BCRMRK, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBcRmrk <em>BcRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BcRmrk</em>' attribute.
	 * @see #getBcRmrk()
	 */
	public void setBcRmrk(String bcRmrk) {
		super.setByIndex(INDEX_BCRMRK, bcRmrk);
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
	 * Returns the value of the '<em><b>ModChgbkRmrk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ModChgbkRmrk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ModChgbkRmrk</em>' attribute.
	 * @see #setModChgbkRmrk(java.lang.String)
	 */
	public String getModChgbkRmrk() {
		return DataUtil.toString(super.getByIndex(INDEX_MODCHGBKRMRK, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getModChgbkRmrk <em>ModChgbkRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ModChgbkRmrk</em>' attribute.
	 * @see #getModChgbkRmrk()
	 */
	public void setModChgbkRmrk(String modChgbkRmrk) {
		super.setByIndex(INDEX_MODCHGBKRMRK, modChgbkRmrk);
	}

	/**
	 * Returns the value of the '<em><b>FakeForwdFlg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FakeForwdFlg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FakeForwdFlg</em>' attribute.
	 * @see #setFakeForwdFlg(java.lang.String)
	 */
	public String getFakeForwdFlg() {
		return DataUtil.toString(super.getByIndex(INDEX_FAKEFORWDFLG, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getFakeForwdFlg <em>FakeForwdFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FakeForwdFlg</em>' attribute.
	 * @see #getFakeForwdFlg()
	 */
	public void setFakeForwdFlg(String fakeForwdFlg) {
		super.setByIndex(INDEX_FAKEFORWDFLG, fakeForwdFlg);
	}

	/**
	 * Returns the value of the '<em><b>ExpOsa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ExpOsa</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ExpOsa</em>' attribute.
	 * @see #setExpOsa(java.lang.String)
	 */
	public String getExpOsa() {
		return DataUtil.toString(super.getByIndex(INDEX_EXPOSA, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getExpOsa <em>ExpOsa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExpOsa</em>' attribute.
	 * @see #getExpOsa()
	 */
	public void setExpOsa(String expOsa) {
		super.setByIndex(INDEX_EXPOSA, expOsa);
	}

	/**
	 * Returns the value of the '<em><b>ReimbBankName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ReimbBankName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ReimbBankName</em>' attribute.
	 * @see #setReimbBankName(java.lang.String)
	 */
	public String getReimbBankName() {
		return DataUtil.toString(super.getByIndex(INDEX_REIMBBANKNAME, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getReimbBankName <em>ReimbBankName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ReimbBankName</em>' attribute.
	 * @see #getReimbBankName()
	 */
	public void setReimbBankName(String reimbBankName) {
		super.setByIndex(INDEX_REIMBBANKNAME, reimbBankName);
	}

	/**
	 * Returns the value of the '<em><b>BcOsa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BcOsa</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BcOsa</em>' attribute.
	 * @see #setBcOsa(java.lang.String)
	 */
	public String getBcOsa() {
		return DataUtil.toString(super.getByIndex(INDEX_BCOSA, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBcOsa <em>BcOsa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BcOsa</em>' attribute.
	 * @see #getBcOsa()
	 */
	public void setBcOsa(String bcOsa) {
		super.setByIndex(INDEX_BCOSA, bcOsa);
	}

	/**
	 * Returns the value of the '<em><b>DishnrNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DishnrNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DishnrNo</em>' attribute.
	 * @see #setDishnrNo(java.lang.String)
	 */
	public String getDishnrNo() {
		return DataUtil.toString(super.getByIndex(INDEX_DISHNRNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDishnrNo <em>DishnrNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DishnrNo</em>' attribute.
	 * @see #getDishnrNo()
	 */
	public void setDishnrNo(String dishnrNo) {
		super.setByIndex(INDEX_DISHNRNO, dishnrNo);
	}

	/**
	 * Returns the value of the '<em><b>AccptceRmrk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AccptceRmrk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AccptceRmrk</em>' attribute.
	 * @see #setAccptceRmrk(java.lang.String)
	 */
	public String getAccptceRmrk() {
		return DataUtil.toString(super.getByIndex(INDEX_ACCPTCERMRK, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getAccptceRmrk <em>AccptceRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AccptceRmrk</em>' attribute.
	 * @see #getAccptceRmrk()
	 */
	public void setAccptceRmrk(String accptceRmrk) {
		super.setByIndex(INDEX_ACCPTCERMRK, accptceRmrk);
	}

	/**
	 * Returns the value of the '<em><b>BookRmrk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BookRmrk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BookRmrk</em>' attribute.
	 * @see #setBookRmrk(java.lang.String)
	 */
	public String getBookRmrk() {
		return DataUtil.toString(super.getByIndex(INDEX_BOOKRMRK, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getBookRmrk <em>BookRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BookRmrk</em>' attribute.
	 * @see #getBookRmrk()
	 */
	public void setBookRmrk(String bookRmrk) {
		super.setByIndex(INDEX_BOOKRMRK, bookRmrk);
	}

	/**
	 * Returns the value of the '<em><b>Resn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resn</em>' attribute.
	 * @see #setResn(java.lang.String)
	 */
	public String getResn() {
		return DataUtil.toString(super.getByIndex(INDEX_RESN, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getResn <em>Resn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resn</em>' attribute.
	 * @see #getResn()
	 */
	public void setResn(String resn) {
		super.setByIndex(INDEX_RESN, resn);
	}

	/**
	 * Returns the value of the '<em><b>LcBalCcy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LcBalCcy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LcBalCcy</em>' attribute.
	 * @see #setLcBalCcy(java.lang.String)
	 */
	public String getLcBalCcy() {
		return DataUtil.toString(super.getByIndex(INDEX_LCBALCCY, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getLcBalCcy <em>LcBalCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcBalCcy</em>' attribute.
	 * @see #getLcBalCcy()
	 */
	public void setLcBalCcy(String lcBalCcy) {
		super.setByIndex(INDEX_LCBALCCY, lcBalCcy);
	}

	/**
	 * Returns the value of the '<em><b>LcBalAmt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LcBalAmt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LcBalAmt</em>' attribute.
	 * @see #setLcBalAmt(java.math.BigDecimal)
	 */
	public BigDecimal getLcBalAmt() {
		return DataUtil.toBigDecimal(super.getByIndex(INDEX_LCBALAMT, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getLcBalAmt <em>LcBalAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcBalAmt</em>' attribute.
	 * @see #getLcBalAmt()
	 */
	public void setLcBalAmt(BigDecimal lcBalAmt) {
		super.setByIndex(INDEX_LCBALAMT, lcBalAmt);
	}

	/**
	 * Returns the value of the '<em><b>FaultTKind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FaultTKind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FaultTKind</em>' attribute.
	 * @see #setFaultTKind(java.lang.String)
	 */
	public String getFaultTKind() {
		return DataUtil.toString(super.getByIndex(INDEX_FAULTTKIND, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getFaultTKind <em>FaultTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FaultTKind</em>' attribute.
	 * @see #getFaultTKind()
	 */
	public void setFaultTKind(String faultTKind) {
		super.setByIndex(INDEX_FAULTTKIND, faultTKind);
	}

	/**
	 * Returns the value of the '<em><b>FaultTxnTKind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FaultTxnTKind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FaultTxnTKind</em>' attribute.
	 * @see #setFaultTxnTKind(java.lang.String)
	 */
	public String getFaultTxnTKind() {
		return DataUtil.toString(super.getByIndex(INDEX_FAULTTXNTKIND, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getFaultTxnTKind <em>FaultTxnTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FaultTxnTKind</em>' attribute.
	 * @see #getFaultTxnTKind()
	 */
	public void setFaultTxnTKind(String faultTxnTKind) {
		super.setByIndex(INDEX_FAULTTXNTKIND, faultTxnTKind);
	}

	/**
	 * Returns the value of the '<em><b>DishnrTKind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DishnrTKind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DishnrTKind</em>' attribute.
	 * @see #setDishnrTKind(java.lang.String)
	 */
	public String getDishnrTKind() {
		return DataUtil.toString(super.getByIndex(INDEX_DISHNRTKIND, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDishnrTKind <em>DishnrTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DishnrTKind</em>' attribute.
	 * @see #getDishnrTKind()
	 */
	public void setDishnrTKind(String dishnrTKind) {
		super.setByIndex(INDEX_DISHNRTKIND, dishnrTKind);
	}

	/**
	 * Returns the value of the '<em><b>DishnrTxnTKind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DishnrTxnTKind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DishnrTxnTKind</em>' attribute.
	 * @see #setDishnrTxnTKind(java.lang.String)
	 */
	public String getDishnrTxnTKind() {
		return DataUtil.toString(super.getByIndex(INDEX_DISHNRTXNTKIND, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getDishnrTxnTKind <em>DishnrTxnTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DishnrTxnTKind</em>' attribute.
	 * @see #getDishnrTxnTKind()
	 */
	public void setDishnrTxnTKind(String dishnrTxnTKind) {
		super.setByIndex(INDEX_DISHNRTXNTKIND, dishnrTxnTKind);
	}

	/**
	 * Returns the value of the '<em><b>CommonBranchCode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonBranchCode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonBranchCode</em>' attribute.
	 * @see #setCommonBranchCode(java.lang.String)
	 */
	public String getCommonBranchCode() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONBRANCHCODE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonBranchCode <em>CommonBranchCode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonBranchCode</em>' attribute.
	 * @see #getCommonBranchCode()
	 */
	public void setCommonBranchCode(String commonBranchCode) {
		super.setByIndex(INDEX_COMMONBRANCHCODE, commonBranchCode);
	}

	/**
	 * Returns the value of the '<em><b>CommonBizGroupId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonBizGroupId</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonBizGroupId</em>' attribute.
	 * @see #setCommonBizGroupId(java.lang.String)
	 */
	public String getCommonBizGroupId() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONBIZGROUPID, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonBizGroupId <em>CommonBizGroupId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonBizGroupId</em>' attribute.
	 * @see #getCommonBizGroupId()
	 */
	public void setCommonBizGroupId(String commonBizGroupId) {
		super.setByIndex(INDEX_COMMONBIZGROUPID, commonBizGroupId);
	}

	/**
	 * Returns the value of the '<em><b>MaintType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MaintType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MaintType</em>' attribute.
	 * @see #setMaintType(java.lang.String)
	 */
	public String getMaintType() {
		return DataUtil.toString(super.getByIndex(INDEX_MAINTTYPE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getMaintType <em>MaintType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MaintType</em>' attribute.
	 * @see #getMaintType()
	 */
	public void setMaintType(String maintType) {
		super.setByIndex(INDEX_MAINTTYPE, maintType);
	}

	/**
	 * Returns the value of the '<em><b>CommonOperInfoNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOperInfoNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOperInfoNo</em>' attribute.
	 * @see #setCommonOperInfoNo(java.lang.String)
	 */
	public String getCommonOperInfoNo() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONOPERINFONO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOperInfoNo <em>CommonOperInfoNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperInfoNo</em>' attribute.
	 * @see #getCommonOperInfoNo()
	 */
	public void setCommonOperInfoNo(String commonOperInfoNo) {
		super.setByIndex(INDEX_COMMONOPERINFONO, commonOperInfoNo);
	}

	/**
	 * Returns the value of the '<em><b>CommonAfterwardsStatus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonAfterwardsStatus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonAfterwardsStatus</em>' attribute.
	 * @see #setCommonAfterwardsStatus(java.lang.String)
	 */
	public String getCommonAfterwardsStatus() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONAFTERWARDSSTATUS, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonAfterwardsStatus <em>CommonAfterwardsStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonAfterwardsStatus</em>' attribute.
	 * @see #getCommonAfterwardsStatus()
	 */
	public void setCommonAfterwardsStatus(String commonAfterwardsStatus) {
		super.setByIndex(INDEX_COMMONAFTERWARDSSTATUS, commonAfterwardsStatus);
	}

	/**
	 * Returns the value of the '<em><b>CommonMakerId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonMakerId</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonMakerId</em>' attribute.
	 * @see #setCommonMakerId(java.lang.String)
	 */
	public String getCommonMakerId() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONMAKERID, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonMakerId <em>CommonMakerId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonMakerId</em>' attribute.
	 * @see #getCommonMakerId()
	 */
	public void setCommonMakerId(String commonMakerId) {
		super.setByIndex(INDEX_COMMONMAKERID, commonMakerId);
	}

	/**
	 * Returns the value of the '<em><b>CommonCurrOper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonCurrOper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonCurrOper</em>' attribute.
	 * @see #setCommonCurrOper(java.lang.String)
	 */
	public String getCommonCurrOper() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONCURROPER, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonCurrOper <em>CommonCurrOper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonCurrOper</em>' attribute.
	 * @see #getCommonCurrOper()
	 */
	public void setCommonCurrOper(String commonCurrOper) {
		super.setByIndex(INDEX_COMMONCURROPER, commonCurrOper);
	}

	/**
	 * Returns the value of the '<em><b>CommonOnpReason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOnpReason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOnpReason</em>' attribute.
	 * @see #setCommonOnpReason(java.lang.String)
	 */
	public String getCommonOnpReason() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONONPREASON, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOnpReason <em>CommonOnpReason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOnpReason</em>' attribute.
	 * @see #getCommonOnpReason()
	 */
	public void setCommonOnpReason(String commonOnpReason) {
		super.setByIndex(INDEX_COMMONONPREASON, commonOnpReason);
	}

	/**
	 * Returns the value of the '<em><b>CommonOnpPreDate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOnpPreDate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOnpPreDate</em>' attribute.
	 * @see #setCommonOnpPreDate(java.util.Date)
	 */
	public Date getCommonOnpPreDate() {
		return DataUtil.toDate(super.getByIndex(INDEX_COMMONONPPREDATE, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOnpPreDate <em>CommonOnpPreDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOnpPreDate</em>' attribute.
	 * @see #getCommonOnpPreDate()
	 */
	public void setCommonOnpPreDate(Date commonOnpPreDate) {
		super.setByIndex(INDEX_COMMONONPPREDATE, commonOnpPreDate);
	}

	/**
	 * Returns the value of the '<em><b>CommonOnpRmrk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOnpRmrk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOnpRmrk</em>' attribute.
	 * @see #setCommonOnpRmrk(java.lang.String)
	 */
	public String getCommonOnpRmrk() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMONONPRMRK, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOnpRmrk <em>CommonOnpRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOnpRmrk</em>' attribute.
	 * @see #getCommonOnpRmrk()
	 */
	public void setCommonOnpRmrk(String commonOnpRmrk) {
		super.setByIndex(INDEX_COMMONONPRMRK, commonOnpRmrk);
	}

	/**
	 * Returns the value of the '<em><b>CommBizNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommBizNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommBizNo</em>' attribute.
	 * @see #setCommBizNo(java.lang.String)
	 */
	public String getCommBizNo() {
		return DataUtil.toString(super.getByIndex(INDEX_COMMBIZNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommBizNo <em>CommBizNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommBizNo</em>' attribute.
	 * @see #getCommBizNo()
	 */
	public void setCommBizNo(String commBizNo) {
		super.setByIndex(INDEX_COMMBIZNO, commBizNo);
	}

	/**
	 * Returns the value of the '<em><b>CommonOperVerNo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CommonOperVerNo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CommonOperVerNo</em>' attribute.
	 * @see #setCommonOperVerNo(int)
	 */
	public int getCommonOperVerNo() {
		return DataUtil.toInt(super.getByIndex(INDEX_COMMONOPERVERNO, true));
	}

	/**
	 * Sets the value of the '{@link com.primeton.eos.Test#getCommonOperVerNo <em>CommonOperVerNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperVerNo</em>' attribute.
	 * @see #getCommonOperVerNo()
	 */
	public void setCommonOperVerNo(int commonOperVerNo) {
		super.setByIndex(INDEX_COMMONOPERVERNO, commonOperVerNo);
	}


}