package cn.com.btmu.art.biz.collection.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.NoticeLetterNoticeLetterAjaxContext;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.service.handler.CommonHandler;

/**
 * NoticeLetterNoticeLetterAjaxModifyForDeleteHandler类
 * 通知书打印删除节点修改用handler
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterNoticeLetterAjaxModifyForDeleteHandler extends
    CommonHandler<NoticeLetterNoticeLetterAjaxContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 删除节点保存通知书基本信息
   * 
   * @return void
   */
  @SuppressWarnings("unchecked")
  public void execution() throws BizException {

    logger
        .debug("NoticeLetterNoticeLetterAjaxModifyForDeleteHandler-execution start");
    //设置分行号
    getContext().getBbNoticeLetterInfo().setBranchCode(
        getContext().getBranchId());
    //保存修改后的通知书打印基本信息
    getContext().getCommonDAO().delete(
        getContext().getBbNoticeLetterInfo());

    logger
        .debug("NoticeLetterNoticeLetterAjaxModifyForDeleteHandler-execution end");

  }

}
