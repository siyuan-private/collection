package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.framework.bo.context.impl.QoQueryContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BbNoticeLettInfo;
import cn.com.btmu.art.framework.constant.BeanInfoConstant;
import cn.com.btmu.art.framework.dao.ICommonDAO;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

import commonj.sdo.DataObject;

/**
 * NoticeLetterNoticeLetterAjaxContext
 * 
 * 通知书打印用Context.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class NoticeLetterNoticeLetterAjaxContext extends QoQueryContext<DataObject>  {
  // 定义通知书打印基本信息表的对象
  private BbNoticeLettInfo bbNoticeLetterInfo = null;
  //定义前台一览进详情对应的操作类型临时变量
  private String hidBtnType = null;
  
  /**
   * @return bbNoticeLetterInfo
   */
  public BbNoticeLettInfo getBbNoticeLetterInfo() {
    //返回通知书打印基本信息表
    return bbNoticeLetterInfo;
  }

  /**
   * @return hidBtnType
   */
  public String getHidBtnType() {
    //返回操作类型
    return hidBtnType;
  }

  /**
   * @param hidBtnType 要设置的 hidBtnType
   */
  public void setHidBtnType(String hidBtnType) {
    //设置操作类型
    this.hidBtnType = hidBtnType;
  }

  /**
   * @param bbNoticeLetterInfo 要设置的 bbNoticeLetterInfo
   */
  public void setBbNoticeLetterInfo(BbNoticeLettInfo bbNoticeLetterInfo) {
    //设置通知书打印基本信息表
    this.bbNoticeLetterInfo = bbNoticeLetterInfo;
  }
  /**
   * 取得commonDAO
   * 
   * @return commonDAO 返回获取的CommonDAO
   */
  public ICommonDAO getCommonDAO()
  {
    //返回获取的CommonDAO
    return (ICommonDAO)FactoryBeanUtil.getBean(BeanInfoConstant.BEAN_ID_COMMON_DAO);
  }
  
}
