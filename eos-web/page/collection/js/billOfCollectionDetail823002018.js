/**
*方法说明：画面初始化
*返回值:
*    无
*参数：
*    无
*/
$(function(){
	// 共通按钮动作校验
	$("#artform_def_detail").artForm({
		save : function(target, esrc) {
			//暂存	
			FormValidate.check(saveValidate()).doThrow();
			$("#param_reqtype").val("Collection/CollModf/detail");
			$("#param_action").val('save');
		},
		submit : function(target,esrc){
			//保存提交
			FormValidate.check(submitValidate()).doThrow();
			$("#param_reqtype").val("Collection/CollModf/detail");
			$("#param_action").val('submit');
		}
	});
	
	//默认加载页面时缓存表单数据
	var detailInit = $.art.common.jsonStringInit(COMMON_CONSTANT.DETAIL_FORM_ID);
	//设置genAccReqtype值
	$("#genAccReqtype").val("Collection/CollModf/genacc");
	
	// 修正编辑画面初始化
	// 1.1.2）画面特殊按钮和链接的初始化	
	// 1- 显示【画：退改单.比对】，【画：退改单.修改履历】，【画：寄单信息.增加】和【画：寄单信息.删除】按钮
	$("#compareButton,#modHistButton,#dispch_add,#dispch_del").show();

	// 2- 【画：退改单.比对】，【画：退改单.修改履历】，【画：寄单信息.增加】和【画：寄单信息.删除】按钮可点击 	
	$("#compareButton,#modHistButton,#dispch_add,#dispch_del").prop("disabled",false);
	
	// 1.1.3）板块初期显示配置
	controlBlockDisplay(2, 2);
	controlBlockDisplay(4, 4);

	// 1.1.4）设置【画：新建.Tenor.天数】，【画：新建.Tenor.日期】的可编辑
	var tenortype = $("[name='data/BcMntnOpDtlVO/tenorType']").val();
	var tenordays = $("[name='data/BcMntnOpDtlVO/tenorDays']");
	var tenordate = $("[name='data/BcMntnOpDtlVO/tenorDate']");
	// 1- 当【画：新建.Tenor.种类】为‘O： others’时
	if("△" == tenortype) {
		
		// 【画：新建.Tenor.天数】，【画：新建.Tenor.日期】设为不可编辑
		tenordays.setReadOnly(true);
		tenordate.setReadOnly(true);
	}
	// 2- 当【画：新建.Tenor.种类】为‘A： after sight’或‘B： after B/L date’时
	else if ("A" == tenortype || "B" == tenortype) {

		// 【画：新建.tenor.天数】设为可编辑，【画：新建.tenor.日期】设为不可编辑
		tenordays.setReadOnly(false);
		tenordate.setReadOnly(true);
	}
	// 3- 当【画：新建.Tenor.种类】为‘空： at sight’时
	else if ("O" == tenortype){
	
		// 【画：新建.Tenor.天数】，【画：新建.Tenor.日期】设为可编辑
		tenordays.setReadOnly(false);
		tenordate.setReadOnly(false);
	}
	
	// 1.1.5）设置【画：信用证信息】板块和【画：非信用证信息】板块的初期显示
	// 1- 当【画：新建.信用证项下】为‘Y’
	if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val())) {
	
		// 显示【画：信用证信息】板块
		$("#LcInfo").show();
		
		// 【画：非信用证信息】板块不显示
		$("#nonLcInfo").hide();
		
		// 【画：信用证信息.信用证编号.检索】显示且不可点击
		$("#search1").show().prop("disabled",true);
		
		// a- 当【画：信用证信息.寄单行同开证行】为‘Y’时
		if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked").val())) {
		
			// 【画：信用证信息.寄单行】不可编辑
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(true);
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(true);
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(true);
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(true);
		}
		
		// 当【画：信用证信息.寄单行同开证行】为‘N’时
		else {
		
			// 【画：信用证信息.寄单行】可编辑
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(false);
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(false);
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(false);
			$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(false);
		}
		
		// b- 当【画：信用证信息.Combined LC】为‘Y’时
		if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked").val())) {
		
			// 显示【画：信用证信息.Combined LC信息】表格
			$("#bbCombLcNo").show();
			
			//【画：信用证信息.Combined LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined LC信息.信用证编号#2-#5.删除】显示且不可点击
			$("#lcSearch2,#lcSearch3,#lcSearch4,#lcSearch5").show().prop("disabled",true);
			$("#lcDel2,#lcDel3,#lcDel4,#lcDel5").show().prop("disabled",true);
		}
		
		// 当【画：信用证信息.Combined LC】为‘N’时
		else {
		
			// 不显示【画：信用证信息.Combined LC信息】表格
			$("#bbCombLcNo").hide();
		}
		
		// c- 当【画：信用证信息.转让第二受益人】为‘Y’时
		if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked").val())) {
		
			// 显示【画：信用证信息.转让信息】表格
			$("#trasfTable").show();
			
			// 【画：信用证信息.转让编号.检索】显示且不可点击
			$("#btn_scan").show().prop("disabled",true);
		}
		
		// 当【画：信用证信息.转让第二受益人】为‘N’时
		else {
		
			// 不显示【画：信用证信息.转让信息】表格
			$("#trasfTable").hide();
		}
	}
	
	// 2- 当【画：新建.信用证项下】为‘N’
	else {
	
		// 【画：信用证信息】板块不显示
		$("#LcInfo").hide();
		
		// 显示【画：非信用证信息】板块
		$("#nonLcInfo").show();
	}
	
	// 1.1.6）设置【画：承兑】板块的可编辑
	// 1- 当【画：承兑.Accepted Flag】为‘Y’时
	if ("Y" == ($(":radio[name='data/BcAccptceOpDtlVO/acceptedFlg']:checked").val())) {
	
		// a- 【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.合理】，【画：承兑.承兑备注】设为可编辑
		$("[name='data/BcAccptceOpDtlVO/accptceRegDate']").setReadOnly(false);
		$("[name='data/BcAccptceOpDtlVO/accptceDueDate']").setReadOnly(false);
		$(":radio[name='data/BcAccptceOpDtlVO/resnblFlg']").setReadOnly(false);
		$("[name='data/BcAccptceOpDtlVO/accptceRmrk']").setReadOnly(false);
		
		// b- 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时
		if (("Y" == ($(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val())) &&
			("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val()))) {
			
			// 【画：承兑.远期索偿日】设为可编辑
			$("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").setReadOnly(false);
		}
		
		// 当【画：新建.信用证项下】不为‘Y’或【画：信用证信息.有偿付行】不为‘Y’时
		else {
		
			// 【画：承兑.远期索偿日】设为不可编辑
			$("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").setReadOnly(true);
		}
	}
	
	// 2- 当【画：承兑.Accepted Flag】为‘N’时
	else {
		//当【画：承兑.Accepted Flag】为空时，设为‘N’
		if("" == ($(":radio[name='data/BcAccptceOpDtlVO/acceptedFlg']:checked").val())){
			$(":radio[name='data/BcAccptceOpDtlVO/acceptedFlg']").val("N");
		}
	
		// 【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.远期索偿日】，【画：承兑.合理】，【画：承兑.承兑备注】设为不可编辑
			$("[name='data/BcAccptceOpDtlVO/accptceRegDate']").setReadOnly(true);
			$("[name='data/BcAccptceOpDtlVO/accptceDueDate']").setReadOnly(true);
			$(":radio[name='data/BcAccptceOpDtlVO/resnblFlg']").setReadOnly(true);
			$("[name='data/BcAccptceOpDtlVO/accptceRmrk']").setReadOnly(true);
			$("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").setReadOnly(true);
	}
	
	//设置【画：寄单信息】的初期显示
		//当【画：寄单信息】无数据时，只显示表头
		//当【画：寄单信息】有数据时：
			//a- 当【DM：寄单信息.操作流水号】不等于当前操作流水号或【DM：寄单信息.操作版本号】不等于当前操作版本号时，将该寄单信息行设为不可编辑
			//b- 当【DM：寄单信息.操作流水号】等于当前操作流水号且【DM：寄单信息.操作版本号】等于当前操作版本号时，将该寄单信息行设为可编辑，将当前行的【Hidden：新增寄单信息标志】的值设为：Y
			// 当【画：寄单信息.寄单对象】为‘2：客户’时，【画：寄单信息.寄单种类】设为不可编辑	
			//※以上a+b需循环处理
	dispchBlockInit();
	
	// reqtype初期化
	$("#commonReqtype").val("Collection/CollModf/detail");
});


/**
 * 方法说明：暂存校验 返回值: true 校验通过 false 校验未通过 参数： 无
 */
function saveValidate() {
	var errMsg = [];
	// 1- 调用IV共通功能一览中"画面项目有无修改校验"。
	var detailSave = $.art.common.jsonStringDeal(
			COMMON_CONSTANT.DETAIL_FORM_ID, value);
	if (!detailSave) {
		return $.getExceptionMsg('ART00104-E');
	}
	return errMsg;
}


/**
*方法说明：保存提交校验
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    无
*/
function submitValidate(){
	var errMsg = [];
	var validateResult;
	
	// 1- 调用IV共通功能一览中“画面项目有无修改校验”。
	var detailSave = $.art.common.jsonStringDeal(COMMON_CONSTANT.DETAIL_FORM_ID,value);
	if (!detailSave) {
		return $.getExceptionMsg('ART00104-E');
	}	
	// 2- 【画：新建.Tenor.种类】不得为空(‘请选择’)，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/tenorType']").val(),"required",artI18N.Label.Label_COM_00844);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 3- 【【画：新建.发票编号】不得为空，否则报错（VALIDATE_00018）						
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/ivcNo']").val(),"required",artI18N.Label.Label_COM_01274);					
	if (validateResult.state == false) {					
		errMsg.push(validateResult.messages);
	}					
  // 4- 【【画：单据信息.发票编号】不得为空，否则报错（VALIDATE_00018）						
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/docIvcNo']").val(),"required",artI18N.Label.Label_COM_01274);					
	if (validateResult.state == false) {					
		errMsg.push(validateResult.messages);
	}					
  // 5- 【【画：单据信息.CHQ Kind】不得为空，否则报错（VALIDATE_00018）						
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/chqKind']").val(),"required",artI18N.Label.Label_COM_00278);					
	if (validateResult.state == false) {					
		errMsg.push(validateResult.messages);
	}					
	// 6-	【画：退改单.登记日】不得为空，否则报错（VALIDATE_00018）	
	validateResult = $.art.Validator.validateBatch($("[name='data/BbModChgbkDocInfoVO/regDate']").val(),"required",artI18N.Label.Label_COM_01186);					
	if (validateResult.state == false) {					
		errMsg.push(validateResult.messages);
	}					
	// 7- 【【画：新建.到期日期】不为空时，必须大于等于系统日期，否则报错（VALIDATE_00040）						
	if("" != $.trim($("[name='data/BcMntnOpDtlVO/dueDate']").val())){					
		validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/dueDate']").val(),"dateMorethanEq['"+getCommonSysDate()+"']",artI18N.Label.Label_COM_01184);				
		if (validateResult.state == false) {				
		errMsg.push(validateResult.messages);
		}				
	}		
	// 8- 【画：承兑.承兑到期日】不为空时，必须大于等于系统日期，否则报错（VALIDATE_00040）
	if("" != $.trim($("[name='data/BcAccptceOpDtlVO/accptceDueDate']").val())){
		validateResult = $.art.Validator.validateBatch($("[name='data/BcAccptceOpDtlVO/accptceDueDate']").val(),"dateMorethanEq['"+getCommonSysDate()+"']",artI18N.Label.Label_COM_01052);	
		if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
		}
	}
	// 9- 【画：承兑.远期索偿日】不为空时，必须大于等于系统日期，否则报错（VALIDATE_00040）
	if("" != $.trim($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val())){
		validateResult = $.art.Validator.validateBatch($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val(),"dateMorethanEq['"+getCommonSysDate()+"']",artI18N.Label.Label_COM_02279);	
		if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
		}
	}
		
	if(errMsg.length > 0){
		return errMsg;
	}		
	//----------end of 单项目-------------
	
	// 10- 【画：新建.最终到期日】不为空时，必须大于等于【画：新建.到期日期】，否则报错（VALIDATE_00027）: {0}必须大于等于{1}						
	if ("" != $.trim($("[name='data/BcMntnOpDtlVO/finalDueDate']").val())) {					
		validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/finalDueDate']").val(),"dateMorethanEq["+$("[name='data/BcMntnOpDtlVO/dueDate']").val()+"]",artI18N.Label.Label_COM_02403,artI18N.Label.Label_COM_01184);				
		if (validateResult.state == false) {				
			return validateResult.messages;			
		}				
	}					
	// 11- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.行号】不得为空，否则报错（SP_VALIDATE_823_020）						
	var issueBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']").val();					
	if (!SP_VALIDATE_823_020(issueBankCode)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00028]);		
	}					
	// 12- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）					
	var issueBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']").val();					
	if (!SP_VALIDATE_823_020(issueBankSwift)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00028]);				
	}					
	// 13- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.名称】不得为空，否则报错（SP_VALIDATE_823_020）					
	var issueBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']").val();					
	if (!SP_VALIDATE_823_020(issueBankName)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00028]);							
	}					
	// 14- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.地址】不得为空，否则报错（SP_VALIDATE_823_020）					
	var issueBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']").val();					
	if (!SP_VALIDATE_823_020(issueBankAddr)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00028]);			
	}					
	// 15- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_020）					
	var dispchDocBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").val();					
	if (!SP_VALIDATE_823_020(dispchDocBankCode)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);					
	}					
	// 16- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）					
	var dispchDocBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").val();					
	if (!SP_VALIDATE_823_020(dispchDocBankSwift)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);					
	}					
	// 17- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_020）					
	var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").val();					
	if (!SP_VALIDATE_823_020(dispchDocBankName)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);							
	}					
	// 18- 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_020）					
	var dispchDocBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").val();					
	if (!SP_VALIDATE_823_020(dispchDocBankAddr)) {					
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);				
	}					
	// 19- 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_024）					
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankCode']").val())){				
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);						
	}				
	// 20- 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_024）				
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankSwift']").val())){				
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);					
	}				
	// 21- 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_024）				
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankName']").val())){				
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);						
	}				
	// 22- 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_024）				
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankAddr']").val())){				
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);				
	}				
	// 23- 【画：承兑.远期索偿日】不为空时，必须小于等于【画：承兑.承兑到期日】，否则报错（VALIDATE_00029）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val(),"dateLessthanEq['"+$("[name='data/BcAccptceOpDtlVO/accptceDueDate']").val()+"']",artI18N.Label.Label_COM_02279);
	if ($.trim($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val()) != ""){
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}
	// 24- 当【画：承兑.Accepted Flag】为‘Y’时，则【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.合理】,【画：承兑.Classified Flag】不得为空，【画：承兑.远期索偿日】在【画：信用证信息.有偿付行】为‘Y’时，不得为空，否则报错（SP_VALIDATE_824_010）
	if (!SP_VALIDATE_823_012()){
		return $.getExceptionMsg('ART00100-E');		
	}		
	// 25- 当前寄单信息行的【Hidden：新增寄单信息标志】的值设为：Y时，做以下【画：寄单信息】板块项目的校验（※需循环判断，出错后退出校验）				
		for(var i = 1; i <=($("#dispchDocTable :checkbox").length-2); i++){
	    if ($("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+i+"]/dispchDocFlgAdd']").val() == "Y"){	
			    	//【画：寄单信息.快递类型】不得为空，否则报错（VALIDATE_00018）		
			    	validateResult = $.art.Validator.validateBatch($.trim($(":radio[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+i+"]/exprsType']:checked").val()),"required",artI18N.Label.Label_COM_01671);		
					if (validateResult.state == false) {	
						return validateResult.messages;
					}	
					//当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）	
					if (!SP_VALIDATE_823_028(i)){	
						return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01522]);		
					}	
					//【画：寄单信息.收件人】不得为空，否则报错（VALIDATE_00018）	
					validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+i+"]/recpnt']").val(),"required",artI18N.Label.Label_COM_01895);	
					if (validateResult.state == false) {	
						return validateResult.messages;
					}	
					//【画：寄单信息.快递寄单日】不得为空，否则报错（VALIDATE_00018)	
					validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+i+"]/exprsDispchDocDate']").val(),"required",artI18N.Label.Label_COM_01669);	
					if (validateResult.state == false) {	
						return validateResult.messages;
					}	
				}		
			}		
	return errMsg;
}