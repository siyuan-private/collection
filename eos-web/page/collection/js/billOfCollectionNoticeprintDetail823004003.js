/**
*方法说明：通知书打印(修改) 画面初始化
*返回值:
*    无
*参数：
*    无
*/
$(function(){
	alert("修改逻辑js");
	//设置检索按钮不可点击
  $("#btn_index").prop("disabled",false);
  //种类 境内
  var typeFlg1= $(":radio[name='data/BbNoticeLettInfoVO/type'][value='1']");
  //种类 对外
  var typeFlg2= $(":radio[name='data/BbNoticeLettInfoVO/type'][value='2']");
  //结算方式 保函
  var lgStlmtMeth=$("[name='data/BbNoticeLettInfoVO/lgStlmtMeth']");
  //当【画：通知书信息.种类】为‘1：境内’时，【画：通知书信息.结算方式.保函】设为不可编辑
  if(typeFlg1.prop("checked")){
     lgStlmtMeth.setReadOnly(true);    
  }
  //当【画：通知书信息.种类】为‘2：对外’时，【画：通知书信息.结算方式.保函】设为可编辑
  if(typeFlg2.prop("checked")){
    lgStlmtMeth.setReadOnly(false); 
  }
  // reqtype初期化
	$("#commonReqtype").val("Collection/NoticeLetter/Modify");
 
});


function save(){
	alert("修改提交保存");
	//设置reqtye值
	$("#param_reqtype").val("Collection/NoticeLetter/Modify");
	//设置action值
	$("#param_action").val("modify");
	//form提交
	$("#artform_def_detail")[0].submit();
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
	//定义errMsg数组
	var errMsg = [];
	//定义判断结果
	var validateResult;
	
	// 1- 【画：通知书信息.种类】不得为空，否则报错（VALIDATE_00018）
	if($("[name='data/BbNoticeLettInfoVO/type']:checked").val() == undefined){
		validateResult = $.art.Validator.validateBatch("","required",artI18N.Label.Label_COM_02341);	
		if (validateResult.state == false) {
		errMsg.push(validateResult.message);
		}
	}
	// 2- 【画：通知书信息.转让编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/trasfTKind']").val(),"required",artI18N.Label.Label_823_10001);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo']").val(),"required",artI18N.Label.Label_823_10001);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}	
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/trasfNoSubRefNo']").val(),"required",artI18N.Label.Label_823_10001);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}
	// 3-【画：通知书信息.信用证编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/lcNo']").val(),"required",artI18N.Label.Label_COM_02151);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}
	// 4- 【画：通知书信息.来单金额.币种】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("#docRecvdCcy").val(),"required",artI18N.Label.Label_823_10003);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}
	// 5- 【画：通知书信息.来单金额.金额】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("#docRecvdAmt").val(),"required",artI18N.Label.Label_823_10003);		
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}
	
	// 6- 【画：通知书信息.开证日期】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/issueDate']").val(),"required",artI18N.Label.Label_COM_01626);		
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}
	// 7- 【画：通知书信息.期限】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/term']").val(),"required",artI18N.Label.Label_COM_01764);		
	if (validateResult.state == false) {
		errMsg.push(validateResult.message);
	}	
	//当errMsg长度大于零时 返回errMsg
	if(errMsg.length > 0){
		
		return errMsg;
	}	

	// 8- 当【Hidden：转让编号】不等于【画：通知书信息.转让编号】时，显示报错信息（SP_VALIDATE_823_098）
	if (!SP_VALIDATE_823_098()) {
		
		return $.getExceptionMsg('ART00130-E',[artI18N.Label.Label_823_10001]);
	}
	//返回errorMessage
	return errMsg;
}
