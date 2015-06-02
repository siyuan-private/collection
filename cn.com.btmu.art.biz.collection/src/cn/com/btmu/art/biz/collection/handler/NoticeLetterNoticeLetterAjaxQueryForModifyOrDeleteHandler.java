package cn.com.btmu.art.biz.collection.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.NoticeLetterNoticeLetterAjaxContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BbNoticeLettInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BbNoticeLettInfoImpl;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.service.handler.CommonHandler;

/**
 * NoticeLetterNoticeLetterAjaxQueryForModifyOrDeleteHandler类
 * 通知书打印删除、修改节点查询用handler
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterNoticeLetterAjaxQueryForModifyOrDeleteHandler extends
    CommonHandler<NoticeLetterNoticeLetterAjaxContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 根据前台传来的转让编号到DB中查询相关结果
   * 
   * @return void
   */
  @SuppressWarnings ("unchecked")
  public void execution() throws BizException {

    logger
        .debug("NoticeLetterNoticeLetterAjaxQueryForModifyOrDeleteHandler-execution start");
    //获取通知书打印基本信息表的对象
    BbNoticeLettInfo noticeLettInfo = getContext().getBbNoticeLetterInfo();
    //定义查询qm
    BbNoticeLettInfo template = new BbNoticeLettInfoImpl();

    //设置查询条件 qm.TrasfTKind = bo.TrasfTKind
    template.setTrasfTKind(noticeLettInfo.getTrasfTKind());
    //设置查询条件 qm.TrasfNoPrmryRefNo = bo.TrasfNoPrmryRefNo
    template.setTrasfNoPrmryRefNo(noticeLettInfo.getTrasfNoPrmryRefNo());
    //设置查询条件 qm.TrasfNoSubRefNo = bo.TrasfNoSubRefNo
    template.setTrasfNoSubRefNo(noticeLettInfo.getTrasfNoSubRefNo());

    logger
        .debug("NoticeLetterNoticeLetterAjaxQueryForModifyOrDeleteHandler 取得查询结果");
    //取得查询结果
    getContext().setBbNoticeLetterInfo(
        (BbNoticeLettInfo) getContext().getCommonDAO().query(template));
    logger
        .debug("NoticeLetterNoticeLetterAjaxQueryForModifyOrDeleteHandler-execution end");
  }

}
