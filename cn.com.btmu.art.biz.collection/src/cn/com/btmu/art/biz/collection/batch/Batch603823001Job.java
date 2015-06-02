package cn.com.btmu.art.biz.collection.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.messageinfodataset.impl.MessageInfoImpl;
import cn.com.btmu.art.framework.exception.ErrMessage;
import cn.com.btmu.art.framework.page.service.IMessageService;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;
import cn.com.btmu.art.integration.framework.batch.exception.BatchJobException;
import cn.com.btmu.art.integration.framework.batch.job.AbstractJob;

/**
 *Batch603823001Job
 *
 *发送托收的索偿部门消息的批处理实现
 *
 *@author iVision
 *
 *@version 1.0.0
 *
 */
public class Batch603823001Job extends AbstractJob {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   *从托收基本信息中查询第二天为远期索偿日的数据，调用部门消息发送接口发送部门消息
   *
   *@return void
   *
   */
  public void execute() throws BatchJobException {
    logger.debug("Batch603823001Job-execute start");
    //定义结果集对象
    ResultSet result = null;
    // 取得系统日期的方法
    DateUtil bizDataUtil = (DateUtil) FactoryBeanUtil
        .getBean(BizBeanNameConst.I00300_UTIL_DATE);
    //获取数据库连接
    Connection conn = this.dbCon();
    //定义sql与预执行对象
    PreparedStatement pstmt = null;

    try {

      //系统日期加1天
      String tomorrow = bizDataUtil.toString(bizDataUtil.getEndDate(bizDataUtil
          .getNow(), CollectionConstant.INTEGER_1),
          ComBizConstant.COMMON_REPORT_DATE_FORMAT_PATTERN1);
      //设置sql文
      String sql = "";
      sql = " SELECT BC.T_KIND" + 
            "       ,BC.TXN_PRMRY_REF_NO" +
            "       ,BC.TXN_SUB_REF_NO" +
            " FROM   BC_INFO BC" + 
            "       ,BC_ACCPTCE_OP_DTL ACC" +
            " WHERE  BC.COLL_ACCPTCE_OPER_SN IS NOT NULL" + 
            " AND    BC.COLL_BOOK_OPER_SN IS NULL" +
            " AND    BC.COLL_ACCPTCE_OPER_SN = ACC.OPER_SN" +
            " AND    BC.COLL_ACCPTCE_OPER_VER_NO = ACC.OPER_VER_NO" +
            " AND    ACC.FORWD_CLM_RMBRSMT_DATE = '" + tomorrow + "'";
      //预加载sql
      pstmt = conn.prepareStatement(sql);
      //取得查询结果
      result = pstmt.executeQuery();
      
      //当结果集不为0条时，进行循环处理
      while (result.next()) {
        logger.debug("DB中数据查询后进行循环");
        //新建部门传送信息
        MessageInfoImpl deptMsgBo = new MessageInfoImpl();
        //取得信息传送服务
        IMessageService msgService = (IMessageService) FactoryBeanUtil
            .getBean("messageService");
        //内容的作成 交易TKind
        String content = result.getString(CollectionConstant.T_KIND)
            + ComBizConstant.COMMON_STRING_HYPHEN;
        //内容的作成 交易主参号
        content += result.getString(CollectionConstant.TXN_PRMRY_REF_NO)
            + ComBizConstant.COMMON_STRING_HYPHEN;
        //内容的作成 交易子参号
        content += result.getString(CollectionConstant.TXN_SUB_REF_NO);
        
        //内容的作成 传送的具体文字内容
        content += CollectionConstant.MESSAGE_CONTENT;

        //设置内容
        deptMsgBo.setTitle(CollectionConstant.MESSAGE_TITLE);

        //设置业务组编号
        deptMsgBo.setBizGroupNo(CollectionConstant.MESSAGE_BIZ_CODE);

        //设置内容
        deptMsgBo.setContent(content);

        //设置有效期
        deptMsgBo.setPeriodValidity(bizDataUtil.getEndDate(
            bizDataUtil.getNow(), CollectionConstant.INTEGER_1));

        //设置发布人
        deptMsgBo.setPublishUser(CollectionConstant.MESSAGE_PUBLISH_USER);

        //设置消息类型
        deptMsgBo.setMsgType(CollectionConstant.ZERO_STRING);

        msgService.sendDeptMessage(deptMsgBo);
      }

    } catch (Exception ex) {

      logger.debug("Batch603823001Job-execute 异常" + ex.getMessage());
      List<ErrMessage> messages = new ArrayList<ErrMessage>();
      //创建ErrMessage对象 
      ErrMessage message = new ErrMessage();
      //设置错误信息id
      message.setMessageID("待定");
      //添加错误消息到错误消息集合
      messages.add(message);
      //手动抛出异常
      throw new BatchJobException(messages, ex);
    } finally {
      if (result != null) {
        try {
          //关闭结果集
          result.close();
        } catch (Exception e) {
        	logger.debug("result.close() 异常" + e.getMessage());
          //输出错误堆栈内容
          e.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          //关闭statement
          pstmt.close();
        } catch (Exception e) {
        	logger.debug("pstmt.close() 异常" + e.getMessage());
          //输出错误堆栈内容
          e.printStackTrace();
        }
      }
    }
    logger.debug("Batch603823001Job-execute end");
  }
}
