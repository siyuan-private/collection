package cn.com.btmu.art.biz.collection.util;

import java.util.HashMap;

/**
 * NextOperationUtil 自动触发用 后续状态的节点对应值
 * 
 * @author ivision
 * @version 1.0.0
 */
public class NextOperationUtil {
  private static HashMap<String, String> nextOperatonMap = new HashMap<String, String>();

  static {
    // 承兑
    nextOperatonMap.put("E-823-002", "11");
    // 入账
    nextOperatonMap.put("E-823-003", "12");
    // 退单
    nextOperatonMap.put("E-823-004", "08");
    // 改单
    nextOperatonMap.put("E-823-005", "06");
    // 改单
    nextOperatonMap.put("E-823-006", "07");
  }

  /**
   * 返回指定节点的后续状态值
   * 
   * @return String
   */
  public static String getNextOperation(String currentOperDefId) {
    return nextOperatonMap.get(currentOperDefId);
  }
}
