package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.collection.context.NoticeLetterAjaxContext;
import cn.com.btmu.art.biz.collection.vo.NoticeLetterAjaxVO;
import cn.com.btmu.art.framework.biz.databuilder.impl.BaseDataBuilder;
import cn.com.btmu.art.framework.config.element.FieldMappingConfigElement;
import cn.com.btmu.art.framework.exception.bizexception.BizCheckException;

/** 
 * NoticeLetterAjaxDataBuilder  
 * 通知书打印Ajax验证用DataBuilder.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterAjaxDataBuilder extends
    BaseDataBuilder<NoticeLetterAjaxContext, NoticeLetterAjaxVO> {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   */
  public void buildInput(NoticeLetterAjaxVO vo,
      FieldMappingConfigElement fieldMap, NoticeLetterAjaxContext context)
      throws BizCheckException {
    // VO为空时返回，不进行后面的属性赋值操作
    if (vo == null) {

      logger.debug("NoticeLetterAjaxDataBuilder-buildInput vo 为空");
      logger.debug("NoticeLetterAjaxDataBuilder-buildInput end");
      return;
    }
    //设置输入vo到voData集合中
    context.setVoData(NoticeLetterConstant.AJAX_SET_VODATA_INVO, vo);
    logger.debug("NoticeLetterAjaxDataBuilder-buildInput end");
  }

  /**
   * 将BO转换成VO
   */
  public Object buildOutput(NoticeLetterAjaxContext context,
      FieldMappingConfigElement fieldMap) throws BizCheckException {
    //返回输出的vo对象
    return context.getVoData(NoticeLetterConstant.AJAX_GET_VODATA_RESULT);   
  }

}
