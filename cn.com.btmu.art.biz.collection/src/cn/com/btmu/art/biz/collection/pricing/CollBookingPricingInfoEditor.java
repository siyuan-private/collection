package cn.com.btmu.art.biz.collection.pricing;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.btmu.art.biz.collection.constant.CollectionConstant;
import cn.com.btmu.art.biz.collection.context.CollectionCollBookingDetailContext;
import cn.com.btmu.art.biz.common01biz.util.InternalPositionWrapUtil.TransactionPricingInfoEditor;
import cn.com.btmu.art.biz.common03biz.bizvo.PriceInfoVO;

public class CollBookingPricingInfoEditor implements
    TransactionPricingInfoEditor<CollectionCollBookingDetailContext> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

  private static CollBookingPricingInfoEditor instance = new CollBookingPricingInfoEditor();

  private CollBookingPricingInfoEditor() {

  }

  public static CollBookingPricingInfoEditor getInstance() {
    return instance;
  }

  public void clearPricingInfo(CollectionCollBookingDetailContext context) {
    logger.debug("CollBookingPricingInfoEditor-clearPricingInfo start");
    
    // 更新定价信息到托收入账操作明细
    //【入账.Exchange信息#1.EX.Method】设置为 空
    context.getReqData().setExMethod1(null);
    //【入账.Exchange信息#1.Cont.No.No.1】设置为 空
    context.getReqData().setContNo11(null);
    //【入账.Exchange信息#1.Cont.No.No.2】设置为 空
    context.getReqData().setContNo12(null);
    //【入账.Exchange信息#1.M/D】设置为 空
    context.getReqData().setMd1(null);
    //【入账.Exchange信息#1.Rate】设置为 空
    context.getReqData().setRate1(null);
    //【入账.Exchange信息#1.E/C】设置为 空
    context.getReqData().setEcRate1(null);
    //【入账.Exchange信息#2.EX.Method】设置为 空
    context.getReqData().setExMethod2(null);
    //【入账.Exchange信息#2.Cont.No.No.1】设置为 空
    context.getReqData().setContNo21(null);
    //【入账.Exchange信息#2.Cont.No.No.2】设置为 空
    context.getReqData().setContNo22(null);
    //【入账.Exchange信息#2.M/D】设置为 空
    context.getReqData().setMd2(null);
    //【入账.Exchange信息#2.Rate】设置为 空
    context.getReqData().setRate2(null);
    //【入账.Exchange信息#2.E/C】设置为 空
    context.getReqData().setEcRate2(null);
    
    logger.debug("CollBookingPricingInfoEditor-clearPricingInfo end");
  }

  public void flushIntoTransaction(CollectionCollBookingDetailContext context,
      List<PriceInfoVO> pricingInfos) {
    logger.debug("CollBookingPricingInfoEditor-flushIntoTransaction start");
    
    // 更新定价信息到托收入账操作明细
    for (PriceInfoVO pricingInfo : pricingInfos) {

      if (1 == pricingInfo.getSrcPrcApplSn()) {
        logger.debug("源交易定价申请序号为1");
        //【入账.Exchange信息#1.EX.Method】设置为【定价信息.定价Method】
        context.getReqData().setExMethod1(pricingInfo.getPrcMethod());
        //【入账.Exchange信息#1.Cont.No.No.1】设置为【定价信息.ContractNo】
        context.getReqData().setContNo11(pricingInfo.getContrNo());
        //【入账.Exchange信息#1.Cont.No.No.2】设置为【定价信息.ContractSubNo】
        context.getReqData().setContNo12(pricingInfo.getContrSubNo());
        //【入账.Exchange信息#1.M/D】设置为【定价信息.M/D】
        context.getReqData().setMd1(pricingInfo.getMd());
        //·【定价信息.定价Method】为“CRSP”的场合，
        if (CollectionConstant.CON_METHOD_CRSP.equals(pricingInfo
            .getPrcMethod())) {
          logger.debug("定价Method为CRSP");
          //【入账.Exchange信息#1.Rate】设置为 【定价信息.CustRate】
          context.getReqData().setRate1(pricingInfo.getCustRate());
          //【入账.Exchange信息#1.E/C】设置为 【定价信息.ISRate】
          context.getReqData().setEcRate1(pricingInfo.getRateIs());
        } else {
          logger.debug("定价Method不为CRSP");
          //【入账.Exchange信息#1.Rate】设置为 空
          context.getReqData().setRate1(null);
          //【入账.Exchange信息#1.E/C】设置为 空
          context.getReqData().setEcRate1(null);
        }
      }
      if (2 == pricingInfo.getSrcPrcApplSn()) {
        logger.debug("源交易定价申请序号为2");
        //【入账.Exchange信息#2.EX.Method】设置为【定价信息.定价Method】
        context.getReqData().setExMethod2(pricingInfo.getPrcMethod());
        //【入账.Exchange信息#2.Cont.No.No.1】设置为【定价信息.ContractNo】
        context.getReqData().setContNo21(pricingInfo.getContrNo());
        //【入账.Exchange信息#2.Cont.No.No.2】设置为【定价信息.ContractSubNo】
        context.getReqData().setContNo22(pricingInfo.getContrSubNo());
        //【入账.Exchange信息#2.M/D】设置为【定价信息.M/D】
        context.getReqData().setMd2(pricingInfo.getMd());
        //·【定价信息.定价Method】为“CRSP”的场合，
        if (CollectionConstant.CON_METHOD_CRSP.equals(pricingInfo
            .getPrcMethod())) {
          logger.debug("定价Method为CRSP");
          //【入账.Exchange信息#2.Rate】设置为 【定价信息.CustRate】
          context.getReqData().setRate2(pricingInfo.getCustRate());
          //【入账.Exchange信息#2.E/C】设置为 【定价信息.ISRate】
          context.getReqData().setEcRate2(pricingInfo.getRateIs());
        } else {
          logger.debug("定价Method不为CRSP");
          //【入账.Exchange信息#2.Rate】设置为 空
          context.getReqData().setRate2(null);
          //【入账.Exchange信息#2.E/C】设置为 空
          context.getReqData().setEcRate2(null);
        }
      }
    }
    logger.debug("CollBookingPricingInfoEditor-flushIntoTransaction end");
  }
}
