package cn.com.btmu.art.biz.collection.calculaterule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollModfDetailContext;
import cn.com.btmu.art.framework.bo.context.IArtContext;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BcAccptceOpDtl;
import cn.com.btmu.art.framework.calculaterule.ICalculateByClass;
import cn.com.btmu.art.framework.constant.DataTypeConstant;

/**
 * R823002 托收业务规则配置（R-823-002）.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class R823002 implements ICalculateByClass {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 用java类处理计算规则.
   * 
   * @return Boolean 计算规则判断结果
   * @param context
   *            上下文信息
   */
  public boolean execute(IArtContext arg0) {
      logger.debug("R823002-executeRuleForCls start");
      CollectionCollModfDetailContext context = (CollectionCollModfDetailContext)arg0;
	  BcAccptceOpDtl bcAccptceOpDtl = 
		  context.getDataRepository().getOperationDataCollection().getBcAccptceOpDtl();
	  String acceptedFlg = DataTypeConstant.DATA_TYPE_NO;
	  if (null != bcAccptceOpDtl) {
		  acceptedFlg = bcAccptceOpDtl.getAcceptedFlg();
	  }
      logger.debug("R823002-executeRuleForCls end");
      return (DataTypeConstant.DATA_TYPE_YES.equals(acceptedFlg));
  }
}
