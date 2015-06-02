package cn.com.btmu.art.biz.collection.vo;

import java.util.Date;
import java.math.BigDecimal;

/**
 * ！BcBookOpDtlVO
 * 
 * @author ivision
 * @version 1.0.0
 *
 */
public class BcBookOpDtlVO {
  /**福费廷 */
  private String forftingFlg;

  /** 头寸日 */
  private Date posDate;

  /** 头寸金额.币种 */
  private String posCcy;

  /** 头寸金额.金额 */
  private BigDecimal posAmt;

  /** 我行对客入账日 */
  private Date ourBankToCustBookingDate;

  /** 进待核查 */
  private String validatnFlg;

  /** 待核查账户.币种 */
  private String validatnAcctCcy;

  /** 待核查账户.GL */
  private String validatnAcctGl;

  /** 待核查账户.SUB GL */
  private String validatnAcctSubGl;

  /** 待核查账户.账号 */
  private String validatnAcctNo;

  /** 客户等级 */
  private String custLv;

  /** 清算行账户.币种 */
  private String clrBankAcctCcy;

  /** 清算行账户.GL */
  private String clrBankAcctGl;

  /** 清算行账户.SUB GL */
  private String clrBankAcctSubGl;

  /** 清算行账户.账号 */
  private String clrBankAcctNo;

  /** 付款银行编号 */
  private String pymtBankNo;

  /** 他行扣款金额.币种 */
  private String theirDedctCcy;

  /** 他行扣款金额.金额 */
  private BigDecimal theirDedctAmt;

  /** Remarks */
  private String rmrk;

  /** 手续费支付方 */
  private String feePayer;

  /** 手续费账户. 币种*/
  private String feeAcctCcy;

  /** 手续费账户.GL */
  private String feeAcctGl;

  /** 手续费账户.SUB GL */
  private String feeAcctSubGl;

  /** 手续费账户.账号 */
  private String feeAcctNo;

  /** N/W区分 */
  private String noWfDist;

  /** 入两个账户 */
  private String enter2AcctFlg;

  /** 入账备注 */
  private String bookRmrk;

  /** 对手方银行国别.国家 */
  private String counterPartyCountry;

  /** 对手方银行国别.省 */
  private String counterPartyProv;

  /** 对手方银行国别.市 */
  private String counterPartyCity;

  /** 入账账户#1.币种 */
  private String bookAcctCcy1;

  /** 入账账户#1.GL */
  private String bookAcctGl1;

  /** 入账账户#1.SUB GL */
  private String bookAcctSubGl1;

  /** 入账账户#1.账号 */
  private String bookAcctNo1;

  /** 金额#1.币种 */
  private String ccy1;

  /** 金额#1.金额 */
  private BigDecimal amt1;

  /** 定价金额#1.币种 */
  private String prcCcy1;

  /** 定价金额#1.金额 */
  private BigDecimal prcAmt1;

  /** Exchange信息#1.EX.Method */
  private String exMethod1;

  /** Exchange信息#1.Quote */
  private String quote1;

  /** Exchange信息#1.Cont.No.No.1 */
  private String contNo11;

  /** Exchange信息#1.Cont.No.No.2 */
  private String contNo12;

  /** Exchange信息#1.Rate */
  private BigDecimal rate1;

  /** Exchange信息#1.M/D */
  private String md1;

  /** Exchange信息#1.E/C */
  private BigDecimal ecRate1;

  /** 入账金额#1.币种 */
  private String bookCcy1;

  /** 入账金额#1.金额 */
  private BigDecimal bookAmt1;

  /** 账户性质#1.二级分类 */
  private String acctPropty2nd1;

  /** 账户性质#1.三级分类 */
  private String acctPropty3rd1;
  
  /** 账户性质#1.二级分类code */
  private String acctPropty2ndCd1;

  /** 账户性质#1.三级分类code */
  private String acctPropty3rdCd1;

  /** 入账账户#2.币种 */
  private String bookAcctCcy2;

  /** 入账账户#2.GL */
  private String bookAcctGl2;

  /** 入账账户#2.SUB GL */
  private String bookAcctSubGl2;

  /** 入账账户#2.账号 */
  private String bookAcctNo2;

  /** 金额#2.币种 */
  private String ccy2;

  /** 金额#2.金额 */
  private BigDecimal amt2;

  /** 定价金额#2.币种 */
  private String prcCcy2;

  /** 定价金额#2.金额 */
  private BigDecimal prcAmt2;

  /** Exchange信息#2.EX.Method */
  private String exMethod2;

  /** Exchange信息#2.Quote */
  private String quote2;

  /** Exchange信息#2.Cont.No.No.1 */
  private String contNo21;

  /** Exchange信息#2.Cont.No.No.2 */
  private String contNo22;

  /** Exchange信息#2.Rate */
  private BigDecimal rate2;

  /** Exchange信息#2.M/D */
  private String md2;

  /** Exchange信息#2.E/C */
  private BigDecimal ecRate2;

  /** 入账金额#2.币种 */
  private String bookCcy2;

  /** 入账金额#2.金额 */
  private BigDecimal bookAmt2;

  /** 账户性质#2.二级分类 */
  private String acctPropty2nd2;

  /** 账户性质#2.三级分类 */
  private String acctPropty3rd2;

  /** 账户性质#2.二级分类code */
  private String acctPropty2ndCd2;

  /** 账户性质#2.三级分类code */
  private String acctPropty3rdCd2;

  /**
   * @return acctPropty2ndCd1
   */
  public String getAcctPropty2ndCd1() {
    return acctPropty2ndCd1;
  }

  /**
   * @param acctPropty2ndCd1 要设置的 acctPropty2ndCd1
   */
  public void setAcctPropty2ndCd1(String acctPropty2ndCd1) {
    this.acctPropty2ndCd1 = acctPropty2ndCd1;
  }

  /**
   * @return acctPropty2ndCd2
   */
  public String getAcctPropty2ndCd2() {
    return acctPropty2ndCd2;
  }

  /**
   * @param acctPropty2ndCd2 要设置的 acctPropty2ndCd2
   */
  public void setAcctPropty2ndCd2(String acctPropty2ndCd2) {
    this.acctPropty2ndCd2 = acctPropty2ndCd2;
  }

  /**
   * @return acctPropty3rdCd1
   */
  public String getAcctPropty3rdCd1() {
    return acctPropty3rdCd1;
  }

  /**
   * @param acctPropty3rdCd1 要设置的 acctPropty3rdCd1
   */
  public void setAcctPropty3rdCd1(String acctPropty3rdCd1) {
    this.acctPropty3rdCd1 = acctPropty3rdCd1;
  }

  /**
   * @return acctPropty3rdCd2
   */
  public String getAcctPropty3rdCd2() {
    return acctPropty3rdCd2;
  }

  /**
   * @param acctPropty3rdCd2 要设置的 acctPropty3rdCd2
   */
  public void setAcctPropty3rdCd2(String acctPropty3rdCd2) {
    this.acctPropty3rdCd2 = acctPropty3rdCd2;
  }
  
  /**
   * @return acctPropty2nd1
   */
  public String getAcctPropty2nd1() {
    return acctPropty2nd1;
  }

  /**
   * @param acctPropty2nd1 要设置的 acctPropty2nd1
   */
  public void setAcctPropty2nd1(String acctPropty2nd1) {
    this.acctPropty2nd1 = acctPropty2nd1;
  }

  /**
   * @return acctPropty2nd2
   */
  public String getAcctPropty2nd2() {
    return acctPropty2nd2;
  }

  /**
   * @param acctPropty2nd2 要设置的 acctPropty2nd2
   */
  public void setAcctPropty2nd2(String acctPropty2nd2) {
    this.acctPropty2nd2 = acctPropty2nd2;
  }

  /**
   * @return acctPropty3rd1
   */
  public String getAcctPropty3rd1() {
    return acctPropty3rd1;
  }

  /**
   * @param acctPropty3rd1 要设置的 acctPropty3rd1
   */
  public void setAcctPropty3rd1(String acctPropty3rd1) {
    this.acctPropty3rd1 = acctPropty3rd1;
  }

  /**
   * @return acctPropty3rd2
   */
  public String getAcctPropty3rd2() {
    return acctPropty3rd2;
  }

  /**
   * @param acctPropty3rd2 要设置的 acctPropty3rd2
   */
  public void setAcctPropty3rd2(String acctPropty3rd2) {
    this.acctPropty3rd2 = acctPropty3rd2;
  }

  /**
   * @return amt1
   */
  public BigDecimal getAmt1() {
    return amt1;
  }

  /**
   * @param amt1 要设置的 amt1
   */
  public void setAmt1(BigDecimal amt1) {
    this.amt1 = amt1;
  }

  /**
   * @return amt2
   */
  public BigDecimal getAmt2() {
    return amt2;
  }

  /**
   * @param amt2 要设置的 amt2
   */
  public void setAmt2(BigDecimal amt2) {
    this.amt2 = amt2;
  }

  /**
   * @return bookAcctCcy1
   */
  public String getBookAcctCcy1() {
    return bookAcctCcy1;
  }

  /**
   * @param bookAcctCcy1 要设置的 bookAcctCcy1
   */
  public void setBookAcctCcy1(String bookAcctCcy1) {
    this.bookAcctCcy1 = bookAcctCcy1;
  }

  /**
   * @return bookAcctCcy2
   */
  public String getBookAcctCcy2() {
    return bookAcctCcy2;
  }

  /**
   * @param bookAcctCcy2 要设置的 bookAcctCcy2
   */
  public void setBookAcctCcy2(String bookAcctCcy2) {
    this.bookAcctCcy2 = bookAcctCcy2;
  }

  /**
   * @return bookAcctGl1
   */
  public String getBookAcctGl1() {
    return bookAcctGl1;
  }

  /**
   * @param bookAcctGl1 要设置的 bookAcctGl1
   */
  public void setBookAcctGl1(String bookAcctGl1) {
    this.bookAcctGl1 = bookAcctGl1;
  }

  /**
   * @return bookAcctGl2
   */
  public String getBookAcctGl2() {
    return bookAcctGl2;
  }

  /**
   * @param bookAcctGl2 要设置的 bookAcctGl2
   */
  public void setBookAcctGl2(String bookAcctGl2) {
    this.bookAcctGl2 = bookAcctGl2;
  }

  /**
   * @return bookAcctNo1
   */
  public String getBookAcctNo1() {
    return bookAcctNo1;
  }

  /**
   * @param bookAcctNo1 要设置的 bookAcctNo1
   */
  public void setBookAcctNo1(String bookAcctNo1) {
    this.bookAcctNo1 = bookAcctNo1;
  }

  /**
   * @return bookAcctNo2
   */
  public String getBookAcctNo2() {
    return bookAcctNo2;
  }

  /**
   * @param bookAcctNo2 要设置的 bookAcctNo2
   */
  public void setBookAcctNo2(String bookAcctNo2) {
    this.bookAcctNo2 = bookAcctNo2;
  }

  /**
   * @return bookAcctSubGl1
   */
  public String getBookAcctSubGl1() {
    return bookAcctSubGl1;
  }

  /**
   * @param bookAcctSubGl1 要设置的 bookAcctSubGl1
   */
  public void setBookAcctSubGl1(String bookAcctSubGl1) {
    this.bookAcctSubGl1 = bookAcctSubGl1;
  }

  /**
   * @return bookAcctSubGl2
   */
  public String getBookAcctSubGl2() {
    return bookAcctSubGl2;
  }

  /**
   * @param bookAcctSubGl2 要设置的 bookAcctSubGl2
   */
  public void setBookAcctSubGl2(String bookAcctSubGl2) {
    this.bookAcctSubGl2 = bookAcctSubGl2;
  }

  /**
   * @return bookAmt1
   */
  public BigDecimal getBookAmt1() {
    return bookAmt1;
  }

  /**
   * @param bookAmt1 要设置的 bookAmt1
   */
  public void setBookAmt1(BigDecimal bookAmt1) {
    this.bookAmt1 = bookAmt1;
  }

  /**
   * @return bookAmt2
   */
  public BigDecimal getBookAmt2() {
    return bookAmt2;
  }

  /**
   * @param bookAmt2 要设置的 bookAmt2
   */
  public void setBookAmt2(BigDecimal bookAmt2) {
    this.bookAmt2 = bookAmt2;
  }

  /**
   * @return bookCcy1
   */
  public String getBookCcy1() {
    return bookCcy1;
  }

  /**
   * @param bookCcy1 要设置的 bookCcy1
   */
  public void setBookCcy1(String bookCcy1) {
    this.bookCcy1 = bookCcy1;
  }

  /**
   * @return bookCcy2
   */
  public String getBookCcy2() {
    return bookCcy2;
  }

  /**
   * @param bookCcy2 要设置的 bookCcy2
   */
  public void setBookCcy2(String bookCcy2) {
    this.bookCcy2 = bookCcy2;
  }

  /**
   * @return bookRmrk
   */
  public String getBookRmrk() {
    return bookRmrk;
  }

  /**
   * @param bookRmrk 要设置的 bookRmrk
   */
  public void setBookRmrk(String bookRmrk) {
    this.bookRmrk = bookRmrk;
  }

  /**
   * @return ccy1
   */
  public String getCcy1() {
    return ccy1;
  }

  /**
   * @param ccy1 要设置的 ccy1
   */
  public void setCcy1(String ccy1) {
    this.ccy1 = ccy1;
  }

  /**
   * @return ccy2
   */
  public String getCcy2() {
    return ccy2;
  }

  /**
   * @param ccy2 要设置的 ccy2
   */
  public void setCcy2(String ccy2) {
    this.ccy2 = ccy2;
  }

  /**
   * @return clrBankAcctCcy
   */
  public String getClrBankAcctCcy() {
    return clrBankAcctCcy;
  }

  /**
   * @param clrBankAcctCcy 要设置的 clrBankAcctCcy
   */
  public void setClrBankAcctCcy(String clrBankAcctCcy) {
    this.clrBankAcctCcy = clrBankAcctCcy;
  }

  /**
   * @return clrBankAcctGl
   */
  public String getClrBankAcctGl() {
    return clrBankAcctGl;
  }

  /**
   * @param clrBankAcctGl 要设置的 clrBankAcctGl
   */
  public void setClrBankAcctGl(String clrBankAcctGl) {
    this.clrBankAcctGl = clrBankAcctGl;
  }

  /**
   * @return clrBankAcctNo
   */
  public String getClrBankAcctNo() {
    return clrBankAcctNo;
  }

  /**
   * @param clrBankAcctNo 要设置的 clrBankAcctNo
   */
  public void setClrBankAcctNo(String clrBankAcctNo) {
    this.clrBankAcctNo = clrBankAcctNo;
  }

  /**
   * @return clrBankAcctSubGl
   */
  public String getClrBankAcctSubGl() {
    return clrBankAcctSubGl;
  }

  /**
   * @param clrBankAcctSubGl 要设置的 clrBankAcctSubGl
   */
  public void setClrBankAcctSubGl(String clrBankAcctSubGl) {
    this.clrBankAcctSubGl = clrBankAcctSubGl;
  }

  /**
   * @return contNo11
   */
  public String getContNo11() {
    return contNo11;
  }

  /**
   * @param contNo11 要设置的 contNo11
   */
  public void setContNo11(String contNo11) {
    this.contNo11 = contNo11;
  }

  /**
   * @return contNo12
   */
  public String getContNo12() {
    return contNo12;
  }

  /**
   * @param contNo12 要设置的 contNo12
   */
  public void setContNo12(String contNo12) {
    this.contNo12 = contNo12;
  }

  /**
   * @return contNo21
   */
  public String getContNo21() {
    return contNo21;
  }

  /**
   * @param contNo21 要设置的 contNo21
   */
  public void setContNo21(String contNo21) {
    this.contNo21 = contNo21;
  }

  /**
   * @return contNo22
   */
  public String getContNo22() {
    return contNo22;
  }

  /**
   * @param contNo22 要设置的 contNo22
   */
  public void setContNo22(String contNo22) {
    this.contNo22 = contNo22;
  }

  /**
   * @return counterPartyCity
   */
  public String getCounterPartyCity() {
    return counterPartyCity;
  }

  /**
   * @param counterPartyCity 要设置的 counterPartyCity
   */
  public void setCounterPartyCity(String counterPartyCity) {
    this.counterPartyCity = counterPartyCity;
  }

  /**
   * @return counterPartyCountry
   */
  public String getCounterPartyCountry() {
    return counterPartyCountry;
  }

  /**
   * @param counterPartyCountry 要设置的 counterPartyCountry
   */
  public void setCounterPartyCountry(String counterPartyCountry) {
    this.counterPartyCountry = counterPartyCountry;
  }

  /**
   * @return counterPartyProv
   */
  public String getCounterPartyProv() {
    return counterPartyProv;
  }

  /**
   * @param counterPartyProv 要设置的 counterPartyProv
   */
  public void setCounterPartyProv(String counterPartyProv) {
    this.counterPartyProv = counterPartyProv;
  }

  /**
   * @return custLv
   */
  public String getCustLv() {
    return custLv;
  }

  /**
   * @param custLv 要设置的 custLv
   */
  public void setCustLv(String custLv) {
    this.custLv = custLv;
  }

  /**
   * @return ecRate1
   */
  public BigDecimal getEcRate1() {
    return ecRate1;
  }

  /**
   * @param ecRate1 要设置的 ecRate1
   */
  public void setEcRate1(BigDecimal ecRate1) {
    this.ecRate1 = ecRate1;
  }

  /**
   * @return ecRate2
   */
  public BigDecimal getEcRate2() {
    return ecRate2;
  }

  /**
   * @param ecRate2 要设置的 ecRate2
   */
  public void setEcRate2(BigDecimal ecRate2) {
    this.ecRate2 = ecRate2;
  }

  /**
   * @return enter2AcctFlg
   */
  public String getEnter2AcctFlg() {
    return enter2AcctFlg;
  }

  /**
   * @param enter2AcctFlg 要设置的 enter2AcctFlg
   */
  public void setEnter2AcctFlg(String enter2AcctFlg) {
    this.enter2AcctFlg = enter2AcctFlg;
  }

  /**
   * @return exMethod1
   */
  public String getExMethod1() {
    return exMethod1;
  }

  /**
   * @param exMethod1 要设置的 exMethod1
   */
  public void setExMethod1(String exMethod1) {
    this.exMethod1 = exMethod1;
  }

  /**
   * @return exMethod2
   */
  public String getExMethod2() {
    return exMethod2;
  }

  /**
   * @param exMethod2 要设置的 exMethod2
   */
  public void setExMethod2(String exMethod2) {
    this.exMethod2 = exMethod2;
  }

  /**
   * @return feeAcctCcy
   */
  public String getFeeAcctCcy() {
    return feeAcctCcy;
  }

  /**
   * @param feeAcctCcy 要设置的 feeAcctCcy
   */
  public void setFeeAcctCcy(String feeAcctCcy) {
    this.feeAcctCcy = feeAcctCcy;
  }

  /**
   * @return feeAcctGl
   */
  public String getFeeAcctGl() {
    return feeAcctGl;
  }

  /**
   * @param feeAcctGl 要设置的 feeAcctGl
   */
  public void setFeeAcctGl(String feeAcctGl) {
    this.feeAcctGl = feeAcctGl;
  }

  /**
   * @return feeAcctNo
   */
  public String getFeeAcctNo() {
    return feeAcctNo;
  }

  /**
   * @param feeAcctNo 要设置的 feeAcctNo
   */
  public void setFeeAcctNo(String feeAcctNo) {
    this.feeAcctNo = feeAcctNo;
  }

  /**
   * @return feeAcctSubGl
   */
  public String getFeeAcctSubGl() {
    return feeAcctSubGl;
  }

  /**
   * @param feeAcctSubGl 要设置的 feeAcctSubGl
   */
  public void setFeeAcctSubGl(String feeAcctSubGl) {
    this.feeAcctSubGl = feeAcctSubGl;
  }

  /**
   * @return feePayer
   */
  public String getFeePayer() {
    return feePayer;
  }

  /**
   * @param feePayer 要设置的 feePayer
   */
  public void setFeePayer(String feePayer) {
    this.feePayer = feePayer;
  }

  /**
   * @return forftingFlg
   */
  public String getForftingFlg() {
    return forftingFlg;
  }

  /**
   * @param forftingFlg 要设置的 forftingFlg
   */
  public void setForftingFlg(String forftingFlg) {
    this.forftingFlg = forftingFlg;
  }

  /**
   * @return md1
   */
  public String getMd1() {
    return md1;
  }

  /**
   * @param md1 要设置的 md1
   */
  public void setMd1(String md1) {
    this.md1 = md1;
  }

  /**
   * @return md2
   */
  public String getMd2() {
    return md2;
  }

  /**
   * @param md2 要设置的 md2
   */
  public void setMd2(String md2) {
    this.md2 = md2;
  }

  /**
   * @return noWfDist
   */
  public String getNoWfDist() {
    return noWfDist;
  }

  /**
   * @param noWfDist 要设置的 noWfDist
   */
  public void setNoWfDist(String noWfDist) {
    this.noWfDist = noWfDist;
  }

  /**
   * @return ourBankToCustBookingDate
   */
  public Date getOurBankToCustBookingDate() {
    return ourBankToCustBookingDate;
  }

  /**
   * @param ourBankToCustBookingDate 要设置的 ourBankToCustBookingDate
   */
  public void setOurBankToCustBookingDate(Date ourBankToCustBookingDate) {
    this.ourBankToCustBookingDate = ourBankToCustBookingDate;
  }

  /**
   * @return posAmt
   */
  public BigDecimal getPosAmt() {
    return posAmt;
  }

  /**
   * @param posAmt 要设置的 posAmt
   */
  public void setPosAmt(BigDecimal posAmt) {
    this.posAmt = posAmt;
  }

  /**
   * @return posCcy
   */
  public String getPosCcy() {
    return posCcy;
  }

  /**
   * @param posCcy 要设置的 posCcy
   */
  public void setPosCcy(String posCcy) {
    this.posCcy = posCcy;
  }

  /**
   * @return posDate
   */
  public Date getPosDate() {
    return posDate;
  }

  /**
   * @param posDate 要设置的 posDate
   */
  public void setPosDate(Date posDate) {
    this.posDate = posDate;
  }

  /**
   * @return prcAmt1
   */
  public BigDecimal getPrcAmt1() {
    return prcAmt1;
  }

  /**
   * @param prcAmt1 要设置的 prcAmt1
   */
  public void setPrcAmt1(BigDecimal prcAmt1) {
    this.prcAmt1 = prcAmt1;
  }

  /**
   * @return prcAmt2
   */
  public BigDecimal getPrcAmt2() {
    return prcAmt2;
  }

  /**
   * @param prcAmt2 要设置的 prcAmt2
   */
  public void setPrcAmt2(BigDecimal prcAmt2) {
    this.prcAmt2 = prcAmt2;
  }

  /**
   * @return prcCcy1
   */
  public String getPrcCcy1() {
    return prcCcy1;
  }

  /**
   * @param prcCcy1 要设置的 prcCcy1
   */
  public void setPrcCcy1(String prcCcy1) {
    this.prcCcy1 = prcCcy1;
  }

  /**
   * @return prcCcy2
   */
  public String getPrcCcy2() {
    return prcCcy2;
  }

  /**
   * @param prcCcy2 要设置的 prcCcy2
   */
  public void setPrcCcy2(String prcCcy2) {
    this.prcCcy2 = prcCcy2;
  }

  /**
   * @return pymtBankNo
   */
  public String getPymtBankNo() {
    return pymtBankNo;
  }

  /**
   * @param pymtBankNo 要设置的 pymtBankNo
   */
  public void setPymtBankNo(String pymtBankNo) {
    this.pymtBankNo = pymtBankNo;
  }

  /**
   * @return quote1
   */
  public String getQuote1() {
    return quote1;
  }

  /**
   * @param quote1 要设置的 quote1
   */
  public void setQuote1(String quote1) {
    this.quote1 = quote1;
  }

  /**
   * @return quote2
   */
  public String getQuote2() {
    return quote2;
  }

  /**
   * @param quote2 要设置的 quote2
   */
  public void setQuote2(String quote2) {
    this.quote2 = quote2;
  }

  /**
   * @return rate1
   */
  public BigDecimal getRate1() {
    return rate1;
  }

  /**
   * @param rate1 要设置的 rate1
   */
  public void setRate1(BigDecimal rate1) {
    this.rate1 = rate1;
  }

  /**
   * @return rate2
   */
  public BigDecimal getRate2() {
    return rate2;
  }

  /**
   * @param rate2 要设置的 rate2
   */
  public void setRate2(BigDecimal rate2) {
    this.rate2 = rate2;
  }

  /**
   * @return rmrk
   */
  public String getRmrk() {
    return rmrk;
  }

  /**
   * @param rmrk 要设置的 rmrk
   */
  public void setRmrk(String rmrk) {
    this.rmrk = rmrk;
  }

  /**
   * @return theirDedctAmt
   */
  public BigDecimal getTheirDedctAmt() {
    return theirDedctAmt;
  }

  /**
   * @param theirDedctAmt 要设置的 theirDedctAmt
   */
  public void setTheirDedctAmt(BigDecimal theirDedctAmt) {
    this.theirDedctAmt = theirDedctAmt;
  }

  /**
   * @return theirDedctCcy
   */
  public String getTheirDedctCcy() {
    return theirDedctCcy;
  }

  /**
   * @param theirDedctCcy 要设置的 theirDedctCcy
   */
  public void setTheirDedctCcy(String theirDedctCcy) {
    this.theirDedctCcy = theirDedctCcy;
  }

  /**
   * @return validatnAcctCcy
   */
  public String getValidatnAcctCcy() {
    return validatnAcctCcy;
  }

  /**
   * @param validatnAcctCcy 要设置的 validatnAcctCcy
   */
  public void setValidatnAcctCcy(String validatnAcctCcy) {
    this.validatnAcctCcy = validatnAcctCcy;
  }

  /**
   * @return validatnAcctGl
   */
  public String getValidatnAcctGl() {
    return validatnAcctGl;
  }

  /**
   * @param validatnAcctGl 要设置的 validatnAcctGl
   */
  public void setValidatnAcctGl(String validatnAcctGl) {
    this.validatnAcctGl = validatnAcctGl;
  }

  /**
   * @return validatnAcctNo
   */
  public String getValidatnAcctNo() {
    return validatnAcctNo;
  }

  /**
   * @param validatnAcctNo 要设置的 validatnAcctNo
   */
  public void setValidatnAcctNo(String validatnAcctNo) {
    this.validatnAcctNo = validatnAcctNo;
  }

  /**
   * @return validatnAcctSubGl
   */
  public String getValidatnAcctSubGl() {
    return validatnAcctSubGl;
  }

  /**
   * @param validatnAcctSubGl 要设置的 validatnAcctSubGl
   */
  public void setValidatnAcctSubGl(String validatnAcctSubGl) {
    this.validatnAcctSubGl = validatnAcctSubGl;
  }

  /**
   * @return validatnFlg
   */
  public String getValidatnFlg() {
    return validatnFlg;
  }

  /**
   * @param validatnFlg 要设置的 validatnFlg
   */
  public void setValidatnFlg(String validatnFlg) {
    this.validatnFlg = validatnFlg;
  }

}
