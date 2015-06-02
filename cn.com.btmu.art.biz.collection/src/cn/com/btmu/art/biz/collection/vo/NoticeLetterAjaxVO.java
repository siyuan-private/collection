package cn.com.btmu.art.biz.collection.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BbNoticeLettInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BbNoticeLettInfoImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.ExpLcTrasfInfo;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.ExpLcInfoImpl;
import cn.com.btmu.art.framework.bo.domain.exportlcdataset.impl.ExpLcTrasfInfoImpl;
import cn.com.btmu.art.framework.constant.BeanInfoConstant;
import cn.com.btmu.art.framework.dao.ICommonDAO;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.exception.ErrMessage;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/** 
 * NoticeLetterAjaxVO    
 * 通知书打印Ajax用VO.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class NoticeLetterAjaxVO {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  //将前台传来的参数设为VO的属性
  /**分行号*/
  private String branchNo;

  /**转让编号 TKind*/
  private String trasfTKind;

  /**转让编号 交易主参号*/
  private String trasfNoPrmryRefNo;

  /**转让编号 交易子参号*/
  private String trasfNoSubRefNo;

  /**调用函数名*/
  private String functionName;

  //取得出口信用证转让信息及出口信用证信息中相关字段值
  @SuppressWarnings("unchecked")
  public AjaxResultSet findInfo() throws BizException {

    logger.debug("NoticeLetterAjaxVO-findInfo start");
    AjaxResultSet ajaxResultSet = new AjaxResultSet();
    Map<String, Object> map = new HashMap<String, Object>();
    //如果分行号、转让编号为空，则直接返回
    if (ArtStringUtil.isEmpty(this.branchNo)
        || ArtStringUtil.isEmpty(this.trasfTKind)
        || ArtStringUtil.isEmpty(this.trasfNoPrmryRefNo)
        || ArtStringUtil.isEmpty(this.trasfNoSubRefNo)) {

      logger
          .debug("branchNo/trasfTKind/trasfNoPrmryRefNo/trasfNoSubRefNo 为空,return null!!");
      logger.debug("NoticeLetterAjaxVO-findInfo end");
      return null;
    }
    
    ICommonDAO<DataObject> commonDAO = (ICommonDAO) FactoryBeanUtil
        .getBean(BeanInfoConstant.BEAN_ID_COMMON_DAO);

    ExpLcTrasfInfo expLcTrasfInfoTemplate = new ExpLcTrasfInfoImpl();

    expLcTrasfInfoTemplate.setBranchCode(this.branchNo);
    expLcTrasfInfoTemplate.setTKind(this.trasfTKind);
    expLcTrasfInfoTemplate.setTxnPrmryRefNo(this.trasfNoPrmryRefNo);
    expLcTrasfInfoTemplate.setTrasfNo(this.trasfNoSubRefNo);

    ExpLcTrasfInfo expLcTRasfInfo = (ExpLcTrasfInfo) commonDAO
        .query(expLcTrasfInfoTemplate);

    if (expLcTRasfInfo != null) {
      logger.debug("检索结果不为0");

      ExpLcInfo expLcInfoTemplate = new ExpLcInfoImpl();
      expLcInfoTemplate.setLcNo(expLcTRasfInfo.getLcNo());

      ExpLcInfo expLcInfo = (ExpLcInfo) commonDAO.query(expLcInfoTemplate);

      BbNoticeLettInfo noticeLetterInfo = new BbNoticeLettInfoImpl();
      noticeLetterInfo.setBranchCode(branchNo);
      noticeLetterInfo.setTrasfTKind(trasfTKind);
      noticeLetterInfo.setTrasfNoPrmryRefNo(trasfNoPrmryRefNo);
      noticeLetterInfo.setTrasfNoSubRefNo(trasfNoSubRefNo);

      BbNoticeLettInfo ntLetter = (BbNoticeLettInfo) commonDAO
          .query(noticeLetterInfo);

      if (ntLetter != null) {
        map.put(NoticeLetterConstant.QOFIELD_NTID, ntLetter.getId());
        
      }

      if (expLcInfo != null) {
        map.put(NoticeLetterConstant.ISSUE_DATE, expLcInfo.getIssueDate());
        map.put(NoticeLetterConstant.BENENAME, expLcInfo.getBeneName());
      }
      map.put(NoticeLetterConstant.QOFIELD_LCNO, expLcTRasfInfo.getLcNo());

      map.put(NoticeLetterConstant.BENE2NDNOTICEBANK, expLcTRasfInfo
          .getBene2ndNoticeBank());
      map
          .put(NoticeLetterConstant.BENE2NDNAME, expLcTRasfInfo
              .getBene2ndName());
      map.put(NoticeLetterConstant.RECIVNAME_ADDR, expLcTRasfInfo
          .getBene2ndNoticeBank());

      ajaxResultSet.setMap(map);
      ajaxResultSet.setFlag(true);
    } else {
      //当检索结果为0时：显示报错信息（SP_VALIDATE_823_099） 
      logger.debug("当检索结果为0时：显示报错信息（SP_VALIDATE_823_099）");
      //创建ErrorMessage对象
      ErrMessage msg = new ErrMessage();

      msg.setMessageID(NoticeLetterConstant.MSG_ID_ART00071_E);

      List<ErrMessage> errList = new ArrayList<ErrMessage>();

      errList.add(msg);

      ajaxResultSet.setErrList(errList);
      ajaxResultSet.setFlag(false);
      ajaxResultSet.setMap(map);
    }

    logger.debug("NoticeLetterAjaxVO-findInfo end");
    return ajaxResultSet;
  }

  /**
   * @return branchNo
   */
  public String getBranchNo() {
    return branchNo;
  }

  /**
   * @param branchNo 要设置的 branchNo
   */
  public void setBranchNo(String branchNo) {
    this.branchNo = branchNo;
  }

  /**
   * @return trasfNoPrmryRefNo
   */
  public String getTrasfNoPrmryRefNo() {
    return trasfNoPrmryRefNo;
  }

  /**
   * @param trasfNoPrmryRefNo 要设置的 trasfNoPrmryRefNo
   */
  public void setTrasfNoPrmryRefNo(String trasfNoPrmryRefNo) {
    this.trasfNoPrmryRefNo = trasfNoPrmryRefNo;
  }

  /**
   * @return trasfNoSubRefNo
   */
  public String getTrasfNoSubRefNo() {
    return trasfNoSubRefNo;
  }

  /**
   * @param trasfNoSubRefNo 要设置的 trasfNoSubRefNo
   */
  public void setTrasfNoSubRefNo(String trasfNoSubRefNo) {
    this.trasfNoSubRefNo = trasfNoSubRefNo;
  }

  /**
   * @return trasfTKing
   */
  public String getTrasfTKind() {
    return trasfTKind;
  }

  /**
   * @param trasfTKing 要设置的 trasfTKing
   */
  public void setTrasfTKind(String trasfTKind) {
    this.trasfTKind = trasfTKind;
  }

  /**
   * @return functionName
   */
  public String getFunctionName() {
    return functionName;
  }

  /**
   * @param functionName 要设置的 functionName
   */
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

}
