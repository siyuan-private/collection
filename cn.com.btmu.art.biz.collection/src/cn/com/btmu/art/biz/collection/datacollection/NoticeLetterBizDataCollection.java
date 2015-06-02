package cn.com.btmu.art.biz.collection.datacollection;

import cn.com.btmu.art.framework.bo.domain.bcdataset.BbNoticeLettInfo;

/** 
 * CollectionBizDataCollection  
 * 托收业务下通知书打印业务信息数据集合.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterBizDataCollection {

  /** 通知书基本信息 */
  private BbNoticeLettInfo bbNoticeLettInfo;

  /**
   * @return bbNoticeLettInfo
   */
  public BbNoticeLettInfo getBbNoticeLettInfo() {
    //返回通知书打印基本信息
    return bbNoticeLettInfo;
  }

  /**
   * @param bbNoticeLettInfo 要设置的 bbNoticeLettInfo
   */
  public void setBbNoticeLettInfo(BbNoticeLettInfo bbNoticeLettInfo) {
    //设置通知书打印基本信息
    this.bbNoticeLettInfo = bbNoticeLettInfo;
  }

}
