package cn.com.btmu.art.biz.collection.triggervisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.AbstractNetworkInspectionTriggerVisitor;
import cn.com.btmu.art.biz.common01biz.base.context.AbstractProtoDetailContext.NetworkInspectionTriggerData;

/**
 * CollBookingNetworkInspectionTriggerVisitor
 * 
 * 托收（入账节点用）自动发起联网核查操作Visitor.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class CollBookingNetworkInspectionTriggerVisitor extends
    AbstractNetworkInspectionTriggerVisitor<CollectionCollBookingDetailContext> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  
  private static CollBookingNetworkInspectionTriggerVisitor instance = new CollBookingNetworkInspectionTriggerVisitor();

  /**
   * 构造函数.
   */
  private CollBookingNetworkInspectionTriggerVisitor() {
  }

  /**
   * 取得实例.
   * 
   * @return instance CollBookingNetworkInspectionTriggerVisitor 实例
   */
  public static CollBookingNetworkInspectionTriggerVisitor getInstance() {
    return instance;
  }

  /**
   * 自动触发催收拒付故障业务的‘催收销号’
   * 
   * @param context 上下文信息
   * @return networkInspectionTriggerData
   */
  public NetworkInspectionTriggerData buildMediaData(
      CollectionCollBookingDetailContext context) {
    logger.debug("CollBookingNetworkInspectionTriggerVisitor-buildMediaData start");

    NetworkInspectionTriggerData networkInspectionTriggerData = new NetworkInspectionTriggerData();
    //【ARTContext：额度信息.源交易参号.T-Kind】赋值为【画：基本信息.交易参号.T-Kind】
    networkInspectionTriggerData.setSrcTKind(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getTKind());
    //【ARTContext：额度信息.源交易参号.主参号】赋值为【画：基本信息.交易参号.主参号】
    networkInspectionTriggerData.setSrcPrmryRefNo(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getTxnPrmryRefNo());
    //【ARTContext：额度信息.源交易参号.子参号】赋值为【画：基本信息.交易参号.子参号】
    networkInspectionTriggerData.setSrcSubRefNo(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getTxnSubRefNo());
    //【ARTContext：额度信息.客户.CIF】赋值为【画：新建.受益人.客户CIF】 
    networkInspectionTriggerData.setCif(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getBeneCif());
    //【ARTContext：额度信息.客户.名称】赋值为【画：新建.受益人.客户名称】    
    networkInspectionTriggerData.setCustName(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getBeneName());
    //【ARTContext：额度信息.登记日期】赋值为【画：入账.我行对客入账日】
    networkInspectionTriggerData.setRegDate(context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl()
        .getOurBankToCustBookingDate());
    //【ARTContext：额度信息.保税区属性】赋值为【画：新建.保税区属性】
    networkInspectionTriggerData.setBondedAreaAttbtCode(context
        .getDataRepository().getBizDataCollection().getBcInfo()
        .getBondedAreaAttbt());
    //【ARTContext：额度信息.待核查账户.币种】赋值为【画：入账.待核查账户.币种】  
    networkInspectionTriggerData.setValidatnAcctCcy(context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl().getValidatnAcctCcy());
    //【ARTContext：额度信息.待核查账户.GL】赋值为【画：入账.GL】   
    networkInspectionTriggerData.setValidatnAcctGl(context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl().getValidatnAcctGl());
    //【ARTContext：额度信息.待核查账户.SUB GL】赋值为【画：入账.SUB GL】  
    networkInspectionTriggerData.setValidatnAcctSubGl(context
        .getDataRepository().getOperationDataCollection().getBcBookOpDtl()
        .getValidatnAcctSubGl());
    //【ARTContext：额度信息.待核查账户.账户】赋值为【画：入账.账号】  
    networkInspectionTriggerData.setValidatnAcctNo(context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl().getValidatnAcctNo());
    //【ARTContext：额度信息.入账账户.币种】赋值为【画：新建.受益人账户.币种】   
    networkInspectionTriggerData.setBookAcctCcy(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getBeneAcctCcy());
    //【ARTContext：额度信息.入账账户.GL】赋值为【画：新建.受益人账户.GL】    
    networkInspectionTriggerData.setBookAcctGl(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getBeneAcctGl());
    //【ARTContext：额度信息.入账账户.SUB GL】赋值为【画：新建.受益人账户.SUB GL】    
    networkInspectionTriggerData.setBookAcctSubGl(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getBeneAcctSubGl());
    //【ARTContext：额度信息.入账账户.账户】赋值为【画：新建.受益人账户.账号】 
    networkInspectionTriggerData.setBookAcctNo(context.getDataRepository()
        .getBizDataCollection().getBcInfo().getBeneAcctNo());
    //【ARTContext：额度信息.转入金额.币种】赋值为【画：入账.头寸金额.币种】
    networkInspectionTriggerData.setIncomingCcy(context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl().getPosCcy());
    //【ARTContext：额度信息.转入金额.金额】赋值为【画：入账.头寸金额.金额】     
    networkInspectionTriggerData.setIncomingAmt(context.getDataRepository()
        .getOperationDataCollection().getBcBookOpDtl().getPosAmt());

    logger.debug("CollBookingNetworkInspectionTriggerVisitor-buildMediaData end");
    return networkInspectionTriggerData;
  }
}
