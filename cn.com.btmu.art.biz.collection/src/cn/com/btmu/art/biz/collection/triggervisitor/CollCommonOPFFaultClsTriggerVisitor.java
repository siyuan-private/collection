package cn.com.btmu.art.biz.collection.triggervisitor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.datacollection.CollectionBizDataCollection;
import cn.com.btmu.art.biz.collection.datacollection.CollectionDataRepository;
import cn.com.btmu.art.biz.collection.util.NextOperationUtil;
import cn.com.btmu.art.biz.common01biz.base.constant.BizBeanNameConst;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.AbstractOPFCollClsTriggerVisitor;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.OPFTriggerData;
import cn.com.btmu.art.biz.common01biz.util.DateUtil;
import cn.com.btmu.art.framework.bo.domain.coldhnrfltdataset.FaultHistInfo;
import cn.com.btmu.art.framework.util.FactoryBeanUtil;

/**
 * OPFCollclsForAccptceNewTriggerVisitor 
 * 自动触发催收销号 承兑New节点用TriggerVisitor
 * 
 * @author ivision
 * @version 1.0.0
 */
public class CollCommonOPFFaultClsTriggerVisitor extends
    AbstractOPFCollClsTriggerVisitor<AbstractProtoDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  private static CollCommonOPFFaultClsTriggerVisitor instance = new CollCommonOPFFaultClsTriggerVisitor();

  private static DateUtil dateUtil = (DateUtil) FactoryBeanUtil
      .getBean(BizBeanNameConst.I00300_UTIL_DATE);

  private CollCommonOPFFaultClsTriggerVisitor() {
  }

  public static CollCommonOPFFaultClsTriggerVisitor getInstance() {
    return instance;
  }

  /**
   * 设置自动触发用的参数
   * @param context               业务传递的context实体
   * @return IMPFinacTriggerData  自动触发用的参数集
   */
  public List<OPFTriggerData> buildMediaData(
		  AbstractProtoDetailContext context) {
    logger.debug("OPFCollclsForAccptceNewTriggerVisitor-buildMediaData start");

    CollectionDataRepository dataRepo = (CollectionDataRepository) context.getDataRepository();
    CollectionBizDataCollection bizCollection = (CollectionBizDataCollection) dataRepo.getBizDataCollection();
    
    if (bizCollection.getOpfData() == null
    		|| bizCollection.getOpfData().getFault() != null
    		|| bizCollection.getOpfData().getFault().size() == 0) {
    	return null;
    }
    
    // 创建自动触发对象
    List<OPFTriggerData> triggerDataLst = new ArrayList<OPFTriggerData>();
    for (FaultHistInfo faultHistInfo : bizCollection.getOpfData().getFault()) {
      // 新建单条自动触发对象
      OPFTriggerData triggerData = new OPFTriggerData();
      // 从context取得T-Kind赋值
      triggerData.setTKind(bizCollection.getBcInfo().getTKind());
      // 从context取得交易主参号赋值
      triggerData.setRefNo(bizCollection.getBcInfo().getTxnPrmryRefNo());
      // 获取工作日日期信息
      triggerData.setClsDate(dateUtil.getNow());
      // 获取后续状态节点编号
      triggerData.setNextOperation(NextOperationUtil.getNextOperation(context
          .getSystemPara().getOperDefID()));
      triggerData.setRemark(null);
      //  业务主键
      triggerData.setTargetCommBizNo(faultHistInfo.getSCrBizInfo()
          .getBizInfoId());
      // 将作成完了的单条自动触发信息加入自动触发信息对象列表
      triggerDataLst.add(triggerData);
    }
    
    logger.debug("OPFCollclsForAccptceNewTriggerVisitor-buildMediaData end");
    return triggerDataLst;
  }
}
