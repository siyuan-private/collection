package cn.com.btmu.art.biz.collection.vo;

import java.util.List;
import java.util.Map;

import cn.com.btmu.art.framework.exception.ErrMessage;

public class AjaxResultSet {

  /**查询结果标志 true 为查询到数据 false 为没有捞到数据*/
  private Boolean flag ;
  
  /**传回前台的数据Map*/
  private Map<String, Object> map ;
  
  /**错误消息List*/
  private List<ErrMessage> errList ;

  /**
   * @return errList
   */
  public List<ErrMessage> getErrList() {
    return errList;
  }

  /**
   * @param errList 要设置的 errList
   */
  public void setErrList(List<ErrMessage> errList) {
    this.errList = errList;
  }

  /**
   * @return flag
   */
  public Boolean getFlag() {
    return flag;
  }

  /**
   * @param flag 要设置的 flag
   */
  public void setFlag(Boolean flag) {
    this.flag = flag;
  }

  /**
   * @return map
   */
  public Map<String, Object> getMap() {
    return map;
  }

  /**
   * @param map 要设置的 map
   */
  public void setMap(Map<String, Object> map) {
    this.map = map;
  }
  
}
