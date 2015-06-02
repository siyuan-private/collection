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
import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTKind <em>TKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTxnSubRefNo <em>TxnSubRefNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBeneCif <em>BeneCif</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBeneName <em>BeneName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBxCcy <em>BxCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBxAmt <em>BxAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTenorType <em>TenorType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDueDate <em>DueDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getNatnlty <em>Natnlty</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFaultNo <em>FaultNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDomstcLcFlg <em>DomstcLcFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPerfmConfmDuties <em>PerfmConfmDuties</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonBizStatus <em>CommonBizStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperSn <em>CommonOperSn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperStatus <em>CommonOperStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOper <em>CommonOper</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonPriceStatus <em>CommonPriceStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCollDate <em>CollDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getIvcNo <em>IvcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcFlg <em>LcFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBpoFlg <em>BpoFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTsuFlg <em>TsuFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcNo <em>LcNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getExpImptrName <em>ExpImptrName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBcImptrName <em>BcImptrName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getExpDispch <em>ExpDispch</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getNonExpDispch <em>NonExpDispch</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getAccptceRegDate <em>AccptceRegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getAccptceDueDate <em>AccptceDueDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPosDate <em>PosDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getOurBankToCustBookingDate <em>OurBankToCustBookingDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPosCcy <em>PosCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPosAmt <em>PosAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTheirDedctCcy <em>TheirDedctCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTheirDedctAmt <em>TheirDedctAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPpnegoFlg <em>PpnegoFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTelegNegoFlg <em>TelegNegoFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTelegNegoClsDate <em>TelegNegoClsDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBcRmrk <em>BcRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getRegDate <em>RegDate</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getModChgbkRmrk <em>ModChgbkRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFakeForwdFlg <em>FakeForwdFlg</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getExpOsa <em>ExpOsa</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getReimbBankName <em>ReimbBankName</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBcOsa <em>BcOsa</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDishnrNo <em>DishnrNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getAccptceRmrk <em>AccptceRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBookRmrk <em>BookRmrk</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getResn <em>Resn</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcBalCcy <em>LcBalCcy</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcBalAmt <em>LcBalAmt</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFaultTKind <em>FaultTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFaultTxnTKind <em>FaultTxnTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDishnrTKind <em>DishnrTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDishnrTxnTKind <em>DishnrTxnTKind</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonBranchCode <em>CommonBranchCode</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonBizGroupId <em>CommonBizGroupId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getMaintType <em>MaintType</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperInfoNo <em>CommonOperInfoNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonAfterwardsStatus <em>CommonAfterwardsStatus</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonMakerId <em>CommonMakerId</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperVerNo <em>CommonOperVerNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommBizNo <em>CommBizNo</em>}</li>
 *   <li>{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonCurrOper <em>CommonCurrOper</em>}</li>
 * </ul>
 * </p>
 *
 * @extends DataObject;
 */
public interface QOCollectionBiz extends DataObject {

	public final static String QNAME = "cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz";

	public final static Type TYPE = TypeHelper.INSTANCE.getType("cn.com.btmu.art.biz.collection.dataset.collection", "QOCollectionBiz");

	public final static IObjectFactory<QOCollectionBiz> FACTORY = new IObjectFactory<QOCollectionBiz>() {
		public QOCollectionBiz create() {
			return (QOCollectionBiz) DataFactory.INSTANCE.create(TYPE);
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTKind <em>TKind</em>}' attribute.
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTxnPrmryRefNo <em>TxnPrmryRefNo</em>}' attribute.
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTxnSubRefNo <em>TxnSubRefNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TxnSubRefNo</em>' attribute.
	 * @see #getTxnSubRefNo()
	 */
	public void setTxnSubRefNo(String txnSubRefNo);

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
	public String getBeneCif();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBeneCif <em>BeneCif</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BeneCif</em>' attribute.
	 * @see #getBeneCif()
	 */
	public void setBeneCif(String beneCif);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBeneName <em>BeneName</em>}' attribute.
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBxCcy <em>BxCcy</em>}' attribute.
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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBxAmt <em>BxAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BxAmt</em>' attribute.
	 * @see #getBxAmt()
	 */
	public void setBxAmt(BigDecimal bxAmt);

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
	public String getTenorType();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTenorType <em>TenorType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TenorType</em>' attribute.
	 * @see #getTenorType()
	 */
	public void setTenorType(String tenorType);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDueDate <em>DueDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DueDate</em>' attribute.
	 * @see #getDueDate()
	 */
	public void setDueDate(Date dueDate);

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
	public String getNatnlty();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getNatnlty <em>Natnlty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Natnlty</em>' attribute.
	 * @see #getNatnlty()
	 */
	public void setNatnlty(String natnlty);

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
	public String getFaultNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFaultNo <em>FaultNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FaultNo</em>' attribute.
	 * @see #getFaultNo()
	 */
	public void setFaultNo(String faultNo);

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
	public String getDomstcLcFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDomstcLcFlg <em>DomstcLcFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DomstcLcFlg</em>' attribute.
	 * @see #getDomstcLcFlg()
	 */
	public void setDomstcLcFlg(String domstcLcFlg);

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
	public String getPerfmConfmDuties();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPerfmConfmDuties <em>PerfmConfmDuties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PerfmConfmDuties</em>' attribute.
	 * @see #getPerfmConfmDuties()
	 */
	public void setPerfmConfmDuties(String perfmConfmDuties);

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
	public String getCommonBizStatus();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonBizStatus <em>CommonBizStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonBizStatus</em>' attribute.
	 * @see #getCommonBizStatus()
	 */
	public void setCommonBizStatus(String commonBizStatus);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperSn <em>CommonOperSn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperSn</em>' attribute.
	 * @see #getCommonOperSn()
	 */
	public void setCommonOperSn(String commonOperSn);

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
	public String getCommonOperStatus();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperStatus <em>CommonOperStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperStatus</em>' attribute.
	 * @see #getCommonOperStatus()
	 */
	public void setCommonOperStatus(String commonOperStatus);

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
	public String getCommonOper();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOper <em>CommonOper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOper</em>' attribute.
	 * @see #getCommonOper()
	 */
	public void setCommonOper(String commonOper);

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
	public String getCommonPriceStatus();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonPriceStatus <em>CommonPriceStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonPriceStatus</em>' attribute.
	 * @see #getCommonPriceStatus()
	 */
	public void setCommonPriceStatus(String commonPriceStatus);

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
	public Date getCollDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCollDate <em>CollDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CollDate</em>' attribute.
	 * @see #getCollDate()
	 */
	public void setCollDate(Date collDate);

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
	public String getIvcNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getIvcNo <em>IvcNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IvcNo</em>' attribute.
	 * @see #getIvcNo()
	 */
	public void setIvcNo(String ivcNo);

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
	public String getLcFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcFlg <em>LcFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcFlg</em>' attribute.
	 * @see #getLcFlg()
	 */
	public void setLcFlg(String lcFlg);

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
	public String getBpoFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBpoFlg <em>BpoFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BpoFlg</em>' attribute.
	 * @see #getBpoFlg()
	 */
	public void setBpoFlg(String bpoFlg);

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
	public String getTsuFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTsuFlg <em>TsuFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TsuFlg</em>' attribute.
	 * @see #getTsuFlg()
	 */
	public void setTsuFlg(String tsuFlg);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcNo <em>LcNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcNo</em>' attribute.
	 * @see #getLcNo()
	 */
	public void setLcNo(String lcNo);

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
	public String getExpImptrName();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getExpImptrName <em>ExpImptrName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExpImptrName</em>' attribute.
	 * @see #getExpImptrName()
	 */
	public void setExpImptrName(String expImptrName);

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
	public String getBcImptrName();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBcImptrName <em>BcImptrName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BcImptrName</em>' attribute.
	 * @see #getBcImptrName()
	 */
	public void setBcImptrName(String bcImptrName);

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
	public String getExpDispch();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getExpDispch <em>ExpDispch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExpDispch</em>' attribute.
	 * @see #getExpDispch()
	 */
	public void setExpDispch(String expDispch);

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
	public String getNonExpDispch();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getNonExpDispch <em>NonExpDispch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NonExpDispch</em>' attribute.
	 * @see #getNonExpDispch()
	 */
	public void setNonExpDispch(String nonExpDispch);

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
	public Date getAccptceRegDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getAccptceRegDate <em>AccptceRegDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AccptceRegDate</em>' attribute.
	 * @see #getAccptceRegDate()
	 */
	public void setAccptceRegDate(Date accptceRegDate);

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
	public Date getAccptceDueDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getAccptceDueDate <em>AccptceDueDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AccptceDueDate</em>' attribute.
	 * @see #getAccptceDueDate()
	 */
	public void setAccptceDueDate(Date accptceDueDate);

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
	public Date getPosDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPosDate <em>PosDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PosDate</em>' attribute.
	 * @see #getPosDate()
	 */
	public void setPosDate(Date posDate);

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
	public Date getOurBankToCustBookingDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getOurBankToCustBookingDate <em>OurBankToCustBookingDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OurBankToCustBookingDate</em>' attribute.
	 * @see #getOurBankToCustBookingDate()
	 */
	public void setOurBankToCustBookingDate(Date ourBankToCustBookingDate);

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
	public String getPosCcy();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPosCcy <em>PosCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PosCcy</em>' attribute.
	 * @see #getPosCcy()
	 */
	public void setPosCcy(String posCcy);

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
	public BigDecimal getPosAmt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPosAmt <em>PosAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PosAmt</em>' attribute.
	 * @see #getPosAmt()
	 */
	public void setPosAmt(BigDecimal posAmt);

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
	public String getTheirDedctCcy();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTheirDedctCcy <em>TheirDedctCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TheirDedctCcy</em>' attribute.
	 * @see #getTheirDedctCcy()
	 */
	public void setTheirDedctCcy(String theirDedctCcy);

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
	public BigDecimal getTheirDedctAmt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTheirDedctAmt <em>TheirDedctAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TheirDedctAmt</em>' attribute.
	 * @see #getTheirDedctAmt()
	 */
	public void setTheirDedctAmt(BigDecimal theirDedctAmt);

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
	public String getPpnegoFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getPpnegoFlg <em>PpnegoFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PpnegoFlg</em>' attribute.
	 * @see #getPpnegoFlg()
	 */
	public void setPpnegoFlg(String ppnegoFlg);

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
	public String getTelegNegoFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTelegNegoFlg <em>TelegNegoFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TelegNegoFlg</em>' attribute.
	 * @see #getTelegNegoFlg()
	 */
	public void setTelegNegoFlg(String telegNegoFlg);

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
	public Date getTelegNegoClsDate();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getTelegNegoClsDate <em>TelegNegoClsDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TelegNegoClsDate</em>' attribute.
	 * @see #getTelegNegoClsDate()
	 */
	public void setTelegNegoClsDate(Date telegNegoClsDate);

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
	public String getBcRmrk();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBcRmrk <em>BcRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BcRmrk</em>' attribute.
	 * @see #getBcRmrk()
	 */
	public void setBcRmrk(String bcRmrk);

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
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getRegDate <em>RegDate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RegDate</em>' attribute.
	 * @see #getRegDate()
	 */
	public void setRegDate(Date regDate);

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
	public String getModChgbkRmrk();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getModChgbkRmrk <em>ModChgbkRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ModChgbkRmrk</em>' attribute.
	 * @see #getModChgbkRmrk()
	 */
	public void setModChgbkRmrk(String modChgbkRmrk);

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
	public String getFakeForwdFlg();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFakeForwdFlg <em>FakeForwdFlg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FakeForwdFlg</em>' attribute.
	 * @see #getFakeForwdFlg()
	 */
	public void setFakeForwdFlg(String fakeForwdFlg);

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
	public String getExpOsa();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getExpOsa <em>ExpOsa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ExpOsa</em>' attribute.
	 * @see #getExpOsa()
	 */
	public void setExpOsa(String expOsa);

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
	public String getReimbBankName();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getReimbBankName <em>ReimbBankName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ReimbBankName</em>' attribute.
	 * @see #getReimbBankName()
	 */
	public void setReimbBankName(String reimbBankName);

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
	public String getBcOsa();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBcOsa <em>BcOsa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BcOsa</em>' attribute.
	 * @see #getBcOsa()
	 */
	public void setBcOsa(String bcOsa);

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
	public String getDishnrNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDishnrNo <em>DishnrNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DishnrNo</em>' attribute.
	 * @see #getDishnrNo()
	 */
	public void setDishnrNo(String dishnrNo);

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
	public String getAccptceRmrk();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getAccptceRmrk <em>AccptceRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AccptceRmrk</em>' attribute.
	 * @see #getAccptceRmrk()
	 */
	public void setAccptceRmrk(String accptceRmrk);

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
	public String getBookRmrk();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getBookRmrk <em>BookRmrk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BookRmrk</em>' attribute.
	 * @see #getBookRmrk()
	 */
	public void setBookRmrk(String bookRmrk);

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
	public String getResn();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getResn <em>Resn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resn</em>' attribute.
	 * @see #getResn()
	 */
	public void setResn(String resn);

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
	public String getLcBalCcy();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcBalCcy <em>LcBalCcy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcBalCcy</em>' attribute.
	 * @see #getLcBalCcy()
	 */
	public void setLcBalCcy(String lcBalCcy);

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
	public BigDecimal getLcBalAmt();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getLcBalAmt <em>LcBalAmt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LcBalAmt</em>' attribute.
	 * @see #getLcBalAmt()
	 */
	public void setLcBalAmt(BigDecimal lcBalAmt);

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
	public String getFaultTKind();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFaultTKind <em>FaultTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FaultTKind</em>' attribute.
	 * @see #getFaultTKind()
	 */
	public void setFaultTKind(String faultTKind);

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
	public String getFaultTxnTKind();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getFaultTxnTKind <em>FaultTxnTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FaultTxnTKind</em>' attribute.
	 * @see #getFaultTxnTKind()
	 */
	public void setFaultTxnTKind(String faultTxnTKind);

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
	public String getDishnrTKind();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDishnrTKind <em>DishnrTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DishnrTKind</em>' attribute.
	 * @see #getDishnrTKind()
	 */
	public void setDishnrTKind(String dishnrTKind);

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
	public String getDishnrTxnTKind();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getDishnrTxnTKind <em>DishnrTxnTKind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DishnrTxnTKind</em>' attribute.
	 * @see #getDishnrTxnTKind()
	 */
	public void setDishnrTxnTKind(String dishnrTxnTKind);

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
	public String getCommonBranchCode();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonBranchCode <em>CommonBranchCode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonBranchCode</em>' attribute.
	 * @see #getCommonBranchCode()
	 */
	public void setCommonBranchCode(String commonBranchCode);

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
	public String getCommonBizGroupId();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonBizGroupId <em>CommonBizGroupId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonBizGroupId</em>' attribute.
	 * @see #getCommonBizGroupId()
	 */
	public void setCommonBizGroupId(String commonBizGroupId);

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
	public String getMaintType();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getMaintType <em>MaintType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MaintType</em>' attribute.
	 * @see #getMaintType()
	 */
	public void setMaintType(String maintType);

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
	public String getCommonOperInfoNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperInfoNo <em>CommonOperInfoNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperInfoNo</em>' attribute.
	 * @see #getCommonOperInfoNo()
	 */
	public void setCommonOperInfoNo(String commonOperInfoNo);

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
	public String getCommonAfterwardsStatus();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonAfterwardsStatus <em>CommonAfterwardsStatus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonAfterwardsStatus</em>' attribute.
	 * @see #getCommonAfterwardsStatus()
	 */
	public void setCommonAfterwardsStatus(String commonAfterwardsStatus);

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
	public String getCommonMakerId();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonMakerId <em>CommonMakerId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonMakerId</em>' attribute.
	 * @see #getCommonMakerId()
	 */
	public void setCommonMakerId(String commonMakerId);

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
	public int getCommonOperVerNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonOperVerNo <em>CommonOperVerNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonOperVerNo</em>' attribute.
	 * @see #getCommonOperVerNo()
	 */
	public void setCommonOperVerNo(int commonOperVerNo);

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
	public String getCommBizNo();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommBizNo <em>CommBizNo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommBizNo</em>' attribute.
	 * @see #getCommBizNo()
	 */
	public void setCommBizNo(String commBizNo);

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
	public String getCommonCurrOper();

	/**
	 * Sets the value of the '{@link cn.com.btmu.art.biz.collection.dataset.collection.QOCollectionBiz#getCommonCurrOper <em>CommonCurrOper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CommonCurrOper</em>' attribute.
	 * @see #getCommonCurrOper()
	 */
	public void setCommonCurrOper(String commonCurrOper);


}