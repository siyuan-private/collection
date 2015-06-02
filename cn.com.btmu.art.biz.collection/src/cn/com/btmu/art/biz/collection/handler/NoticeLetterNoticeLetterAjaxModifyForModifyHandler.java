package cn.com.btmu.art.biz.collection.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.NoticeLetterNoticeLetterAjaxContext;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.service.handler.CommonHandler;

/**
 * NoticeLetterNoticeLetterAjaxModifyForModifyHandler类
 * 通知书打印修改节点修改用handler
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterNoticeLetterAjaxModifyForModifyHandler extends
    CommonHandler<NoticeLetterNoticeLetterAjaxContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 修改节点保存通知书基本信息
   * 
   * @return void
   */
  @SuppressWarnings("unchecked")
  public void execution() throws BizException {

    logger
        .debug("NoticeLetterNoticeLetterAjaxModifyForModifyHandler-execution start");
    //设置分行号
    getContext().getBbNoticeLetterInfo().setBranchCode(
        getContext().getBranchId());
    //保存修改后的通知书打印基本信息
    getContext().getCommonDAO().saveOrUpdate(
        getContext().getBbNoticeLetterInfo());

    logger
        .debug("NoticeLetterNoticeLetterAjaxModifyForModifyHandler-execution end");
  }

}
