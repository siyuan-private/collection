package cn.com.btmu.art.biz.collection.context;

import cn.com.btmu.art.framework.bo.context.impl.QoQueryContext;
import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import com.eos.foundation.data.DataObjectUtil;
import commonj.sdo.DataObject;

/**
 * NoticeLetterAjaxContext
 * 通知书打印Ajax验证用 DetailContext
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterAjaxContext extends QoQueryContext<DataObject> {

  //定义voData对象集合
  private DataObject voData = DataObjectUtil
      .createDataObject(NoticeLetterConstant.DATAOBJ_CREATE_STRING);

  /**
   * @return voData
   */
  public Object getVoData(String key) {
    //返回对应key值的voData
    return this.voData.get(key);
  }

  /**
   * @param voData 要设置的 voData
   */
  public void setVoData(String key, Object voData) {
    //设置key值对应的voData数据
    this.voData.set(key, voData);
  }

}
