package cn.com.btmu.art.biz.collection.handler;

import org.apache.commons.beanutils.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.collection.context.NoticeLetterAjaxContext;
import cn.com.btmu.art.biz.collection.vo.NoticeLetterAjaxVO;
import cn.com.btmu.art.framework.service.handler.CommonHandler;

/**
 * NoticeLetterAjaxHandler类
 * 通知书打印Ajax用Handler
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterAjaxHandler extends
    CommonHandler<NoticeLetterAjaxContext> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 执行前台请求
   * 
   * @return void
   * */
  public void execution() {
    logger.debug("NoticeLetterAjaxHandler-execution start");
    //定义结果集对象
    Object result = null;
    //获取context
    NoticeLetterAjaxContext context = (NoticeLetterAjaxContext) getContext();
    //获取输入vo
    NoticeLetterAjaxVO inVO = (NoticeLetterAjaxVO) context
        .getVoData(NoticeLetterConstant.AJAX_SET_VODATA_INVO);
    //获取对应函数名
    String functionName = inVO.getFunctionName();

    try {
      //通过反射调用对应函数名的方法取得查询结果
      result = MethodUtils.invokeMethod(inVO, functionName, null);
    } catch (Exception e) {

      logger.debug("调用MethodUtils.invokeMethod方法异常functionName为" + functionName
          + "\t " + e.getMessage());
      //输出错误堆栈信息
      e.printStackTrace();
    }
    //将查询结果集设置到context中的voData集合中
    context.setVoData(NoticeLetterConstant.AJAX_GET_VODATA_RESULT,
        result);

    logger.debug("NoticeLetterAjaxHandler-execution end");
  }

}
