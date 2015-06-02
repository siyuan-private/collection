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
		preSeqGenerate : function(target,esrc){
			
		}
		,seqGenerate : function(target,esrc){
			//采号
			FormValidate.check(seqGenerateValidate()).doThrow();
			$("#param_reqtype").val("Collection/CollCreate/detail");
			$("#param_action").val('seqGenerate');
		}
		,submit : function(target,esrc){

		}
		,check : function(target,esrc){
		}
		,approval : function(target,esrc){
		}
	});
		
	// 新建新建画面初始化
	// 1.1.2）画面特殊按钮和链接的初始化	
	// 1- 显示【画：寄单信息.增加】和【画：寄单信息.删除】按钮
	$("#dispch_add,#dispch_del").show();
	
	// 2- 【画：寄单信息.增加】和【画：寄单信息.删除】按钮可点击 	
	$("#dispch_add,#dispch_del").prop("disabled",false);
	
	// 1.1.3）板块初期显示配置
	controlBlockDisplay(2, 4);
	controlBlockDisplay(3, 4);
	controlBlockDisplay(4, 4);
	
	// 1.1.4）设置【画：信用证信息】板块和【画：非信用证信息】板块的初期显示
	// 【画：信用证信息】板块和【画：非信用证信息】板块不显示；
	$("#LcInfo,#nonLcInfo").hide();
	
	//将【Hidden：信用证编号】和【Hidden：转让编号】的值设为：空
	$("[name='data/BcMntnOpDtlVO/tmpLcNo']").val("");
	$("[name='data/BcMntnOpDtlVO/tmpTrasfNo']").val("");
	
	// reqtype初期化
	$("#commonReqtype").val("Collection/CollCreate/detail");
});


/**
*方法说明：正式采号前台校验
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    无
*/
function seqGenerateValidate(){
	var errMsg = [];
	var validateResult;
	//1	【画：新建.信用证项下】不得为空，否则报错（VALIDATE_00018）
	if($("[name='data/BcMntnOpDtlVO/lcFlg']:checked").val() == undefined){
		validateResult = $.art.Validator.validateBatch("","required",artI18N.Label.Label_COM_02158);	
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		}
	}
	
	//2	【画：新建.受益人.客户名称】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/beneName']").val(),"required",artI18N.Label.Label_823_00004);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//3	【画：新建.汇票金额.币种】不得为空，否则报错（VALIDATE_00018）	
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/bxCcy']").val(),"required",artI18N.Label.Label_823_00005);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//4	【画：新建.汇票金额.金额】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/bxAmt']").val(),"required",artI18N.Label.Label_823_00005);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//5	【画：新建.Tenor.种类】不得为空(‘请选择’)，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/tenorType']").val(),"required",artI18N.Label.Label_COM_00844);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	if(errMsg.length > 0){
		return errMsg;
	}	
	//6	【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）	:{0}被修改过，请重新点击{1}按钮，或恢复为修改前的值。
	if (!SP_VALIDATE_823_098("lcNo")) {
		return $.getExceptionMsg('ART00130-E',[artI18N.Label.Label_COM_00844 , artI18N.Label.Link_823_00004]);
	}
	//【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）
	if (!SP_VALIDATE_823_098("trasfNo")) {
		return $.getExceptionMsg('ART00130-E',[artI18N.Label.Label_823_00034 , artI18N.Label.Link_823_00004]);
	}
	//调用采号共通方法，取得交易参号T-kind，交易参号主参号
	//	3.5.3）数据处理逻辑					
	//		1- 将【画：基本信息】至【画：费用信息】版块的项目值保存至【DM：托收维护操作明细】			
	//				当【画：汇票金额.币种】不等于‘CNY’时，将【DM：托收维护操作明细.SMILE EX.Method】的值设为：NOEX	
	//				将【DM：托收维护操作明细.T-Kind】的值设为：取得的交易参号T-kind	
	//				将【DM：托收维护操作明细.交易主参号】的值设为：取得的交易参号主参号	
	//				将【DM：托收维护操作明细.交易子参号】的值设为：‘00’	
	//				将【DM：托收维护操作明细.登记日期】的值设为：系统日期	
	//		2- 当【画：新建.信用证项下】为‘Y’时，将【画：信用证信息】板块的项目值保存至【DM：出口信用证维护操作明细】			
	//				将【画：新建.受益人.客户CIF】保存至【DM：出口信用证维护操作明细.受益人客户编号】	
	//		3- 当【画：信用证信息.Combined LC】为‘Y’时，将【画：信用证信息.Combined LC信息】保存至【DM：Combined LC维护操作明细】			
	//		4- 当【画：寄单信息】行的【Hidden：新增寄单信息标志】的值等于‘Y’时，将【画：寄单信息】行的项目值保存至【DM：寄单信息】（※需循环判断）	
	return errMsg;
}



