package cn.com.btmu.art.biz.collection.calculaterule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollAccptceDetailContext;
import cn.com.btmu.art.biz.common01biz.base.constant.ComBizConstant;
import cn.com.btmu.art.framework.bo.context.IArtContext;
import cn.com.btmu.art.framework.calculaterule.ICalculateByClass;

/**
 * R823003 托收业务规则配置（R-823-003）.
 * 
 * @author ivision
 * @version 1.0.0
 */
public class R823003 implements ICalculateByClass {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public boolean execute(IArtContext arg0) {
    logger.debug("R823003-executeRuleForCls start");
    CollectionCollAccptceDetailContext context = (CollectionCollAccptceDetailContext)arg0;
    String tenorType = context.getDataRepository().getBizDataCollection()
        .getBcInfo().getTenorType();
    logger.debug("R823003-executeRuleForCls end");
    return ((!ComBizConstant.COMMON_STRING_EMPTY.equals(tenorType)));
  }
}
