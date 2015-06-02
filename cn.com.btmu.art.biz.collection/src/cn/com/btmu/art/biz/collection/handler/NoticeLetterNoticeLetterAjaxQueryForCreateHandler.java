package cn.com.btmu.art.biz.collection.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.collection.context.NoticeLetterNoticeLetterAjaxContext;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BbNoticeLettInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BbNoticeLettInfoImpl;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.exception.BizException;
import cn.com.btmu.art.framework.service.handler.CommonHandler;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * NoticeLetterNoticeLetterAjaxQueryForCreateHandler类
 * 通知书打印新建节点查询用handler
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterNoticeLetterAjaxQueryForCreateHandler extends
    CommonHandler<NoticeLetterNoticeLetterAjaxContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public void execution() throws BizException {
    logger
        .debug("NoticeLetterNoticeLetterAjaxQueryForCreateHandler-execution start");
    //当context中的通知书打印为空时，实例化通知书打印基本信息对象
    if (getContext().getBbNoticeLetterInfo() == null) {
      getContext().setBbNoticeLetterInfo(new BbNoticeLettInfoImpl());
    }
    //获取context中的通知书打印基本信息对象
    BbNoticeLettInfo reqData = getContext().getBbNoticeLetterInfo();
    //获取日期工具类
    DateUtil bizDataUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);

    //登记日 系统日期
    reqData.setRegDate(bizDataUtil.getNow());

    //结算方式 信用证
    reqData.setStlmtMeth(NoticeLetterConstant.ONE_STRING);
    //期限 at sight
    reqData.setTerm(NoticeLetterConstant.TERM_AT_SIGHT);

    //对公 不勾选
    reqData.setToPubFlg(DataTypeConstant.DATA_TYPE_NO);

    //对私 不勾选
    reqData.setToPrivtFlg(DataTypeConstant.DATA_TYPE_NO);

    //不符点：晚装船不勾选
    reqData.setLateShipmentFlg(DataTypeConstant.DATA_TYPE_NO);

    //不符点：晚交单 不勾选
    reqData.setLatePresentationFlg(DataTypeConstant.DATA_TYPE_NO);

    //不符点：信用证过期 不勾选
    reqData.setLcOverdueFlg(DataTypeConstant.DATA_TYPE_NO);

    //不符点：超金额不勾选
    reqData.setOverdrawnFlg(DataTypeConstant.DATA_TYPE_NO);

    //additional 不勾选
    reqData.setAddDiscOther(DataTypeConstant.DATA_TYPE_NO);

    logger
        .debug("NoticeLetterNoticeLetterAjaxQueryForCreateHandler-execution end");
  }

}
