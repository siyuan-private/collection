package cn.com.btmu.art.biz.collection.databuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ArtBeanUtils;

import cn.com.btmu.art.biz.collection.constant.NoticeLetterConstant;
import cn.com.btmu.art.biz.collection.context.NoticeLetterNoticeLetterAjaxContext;
import cn.com.btmu.art.biz.collection.vo.BbNoticeLettInfoVO;
import cn.com.btmu.art.framework.biz.databuilder.IDataBuilder;
import cn.com.btmu.art.framework.bo.domain.bcdataset.BbNoticeLettInfo;
import cn.com.btmu.art.framework.bo.domain.bcdataset.impl.BbNoticeLettInfoImpl;
import cn.com.btmu.art.framework.config.element.FieldMappingConfigElement;
import cn.com.btmu.art.framework.constant.DataTypeConstant;
import cn.com.btmu.art.framework.exception.bizexception.BizCheckException;
import cn.com.btmu.art.biz.common01biz.util.ArtStringUtil;

/** 
 * NoticeLetterNoticeLetterAjaxForCreateDataBuilder  
 * 通知书打印新建节点用DataBuilder.
 * 
 * @author iVision
 * @version 1.0.0
 */
public class NoticeLetterNoticeLetterAjaxForCreateDataBuilder implements
    IDataBuilder<NoticeLetterNoticeLetterAjaxContext, BbNoticeLettInfoVO> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 将VO转换成BO
   * 
   * @return void
   * @param vo 
   *            画面数据VO
   * @param fieldMap 
   *            VO与PO字段映射关系Map
   * @param context 
   *            上下文信息
   */
  public void buildInput(BbNoticeLettInfoVO vo,
      FieldMappingConfigElement paramFieldMappingConfigElement,
      NoticeLetterNoticeLetterAjaxContext context) throws BizCheckException {
    logger
        .debug("NoticeLetterNoticeLetterAjaxForCreateDataBuilder-buildInput start");

    // VO为空时返回，不进行后面的属性赋值操作
    if (vo == null) {
      logger.debug("vo为空");
      logger
          .debug("NoticeLetterNoticeLetterAjaxForCreateDataBuilder-buildInput end");
      return;
    }
    //取得通知书基本信息
    BbNoticeLettInfo bbNoticeLettInfo = new BbNoticeLettInfoImpl();

    //将VO值赋给context
    ArtBeanUtils.copyProperties(vo, bbNoticeLettInfo);

    //字段不一致转换
    //设置种类字段
    bbNoticeLettInfo.setNoticeLetterType(vo.getType());
    
    //结算方式-信用证
    if (ArtStringUtil.isNotEmpty(vo.getLcStlmtMeth())) {
      bbNoticeLettInfo.setStlmtMeth(vo.getLcStlmtMeth());
    }
    //结算方式-托收
    if (ArtStringUtil.isNotEmpty(vo.getCollStlmtMeth())) {
      bbNoticeLettInfo.setStlmtMeth(vo.getCollStlmtMeth());
    }
    //结算方式-保函
    if (ArtStringUtil.isNotEmpty(vo.getLgStlmtMeth())) {
      bbNoticeLettInfo.setStlmtMeth(vo.getLgStlmtMeth());
    }
    //结算方式-其他
    if (ArtStringUtil.isNotEmpty(vo.getOtherStlmtMeth())) {
      bbNoticeLettInfo.setStlmtMeth(vo.getOtherStlmtMeth());
    }
    //当对公标志为空时，设置bo.对公标志为为N
    if (vo.getToPubFlg() == null) {
      bbNoticeLettInfo.setToPubFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    //当对私标志为空时，设置bo.对私标志为为N
    if (vo.getToPrivtFlg() == null) {
      bbNoticeLettInfo.setToPrivtFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    //当晚装船标志为空时，设置bo.晚装船标志为N
    if (vo.getLateShipmentFlg() == null) {
      bbNoticeLettInfo.setLateShipmentFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    //当LatePresentation标志为空时，设置bo.LatePresentation标志为N
    if (vo.getLatePresentationFlg() == null) {
      bbNoticeLettInfo.setLatePresentationFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    //当LcOverdue标志为空时，设置bo.LcOverdue标志为N
    if (vo.getLcOverdueFlg() == null) {
      bbNoticeLettInfo.setLcOverdueFlg(DataTypeConstant.DATA_TYPE_NO);
    }
    //当Overdrawn标志为空时，设置bo.Overdrawn标志为N
    if (vo.getOverdrawnFlg() == null) {
      bbNoticeLettInfo.setOverdrawnFlg(DataTypeConstant.DATA_TYPE_NO);
    }

    //当其他标志位空时，设置bo.AddDiscOther标志位N
    if (vo.getAddDiscOther() == null) {
      bbNoticeLettInfo.setAddDiscOther(DataTypeConstant.DATA_TYPE_NO);
    }
    if (vo.getNtid() != NoticeLetterConstant.INT_DIGITAL_0) {
      bbNoticeLettInfo.setId(vo.getNtid());
    }
    
    //将通知书打印基本信息表赋值到context中
    context.setBbNoticeLetterInfo(bbNoticeLettInfo);
    
    //将操作类型赋值到context中
    logger.debug("操作类型为" + vo.getHidBtnType());
    context.setHidBtnType(vo.getHidBtnType());

    logger
        .debug("NoticeLetterNoticeLetterAjaxForCreateDataBuilder-buildInput end");
  }

  /**
   * 将BO转换成VO
   * 
   * @return Object 
   *                画面数据VO
   * @param context 
   *                上下文信息
   * @param fieldMap 
   *                VO与PO字段映射关系Map
   */
  public Object buildOutput(NoticeLetterNoticeLetterAjaxContext context,
      FieldMappingConfigElement paramFieldMappingConfigElement)
      throws BizCheckException {
    logger
        .debug("NoticeLetterNoticeLetterAjaxForCreateDataBuilder-buildOutput start");
    //定义要返回的通知书打印信息的VO
    BbNoticeLettInfoVO vo = new BbNoticeLettInfoVO();
    //取得context中的通知书打印基本信息表 
    BbNoticeLettInfo noticeLettInfo = context.getBbNoticeLetterInfo();
    //当通知书打印基本信息表不为空时，将其内容赋值到VO中
    if (noticeLettInfo != null) {
      //将BO赋值到VO中
      ArtBeanUtils.copyProperties(noticeLettInfo, vo);

      //种类字段不一致，手动设置
      vo.setType(noticeLettInfo.getNoticeLetterType());
      
      //将context中的隐藏变量赋值到vo中
      logger.debug("context中的操作类型" + context.getHidBtnType());
      vo.setHidBtnType(context.getHidBtnType());
      //当BO中的结算方式不为空，进行结算方式的数据字典转换
      if (noticeLettInfo.getStlmtMeth() != null) {
        //将结算方式字符串转换为int类型
        int stlmtMeth = Integer.parseInt(noticeLettInfo.getStlmtMeth());
        //进行结算方式的种类判断
        switch (stlmtMeth) {
        case 1:
          //当结算方式为1时，设置信用证方式勾选
          vo.setLcStlmtMeth(NoticeLetterConstant.ONE_STRING);
          break;
        case 2:
          //当结算方式为2时，设置保函方式勾选
          vo.setLgStlmtMeth(NoticeLetterConstant.TWO_STRING);
          break;
        case 3:
          //当结算方式为3时，设置托收方式勾选
          vo.setCollStlmtMeth(NoticeLetterConstant.THREE_STRING);
          break;
        case 4:
          //当结算方式为4时，设置其他方式勾选
          vo.setOtherStlmtMeth(NoticeLetterConstant.FOUR_STRING);
        }
      }
    }

    logger
        .debug("NoticeLetterNoticeLetterAjaxForCreateDataBuilder-buildOutput end");
    //返回VO
    return vo;
  }

}
