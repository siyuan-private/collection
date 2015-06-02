/**
*方法说明：托收承兑编辑画面初始化
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
		}
		,save : function(target,esrc){			
			//暂存
			$("#param_reqtype").val("Collection/CollAccptce/detail");
			$("#param_action").val('save');
		}
		,submit : function(target,esrc){
			// 保存提交
			FormValidate.check(submitValidate()).doThrow();
			$("#param_reqtype").val("Collection/CollAccptce/detail");
			$("#param_action").val('submit');
		}
		,check : function(target,esrc){
		}
		,approval : function(target,esrc){
		}
	});
	
	$("#genAccReqtype").val("Collection/CollAccptce/genacc");
		// reqtype初期化
	$("#commonReqtype").val("Collection/CollAccptce/detail");
	
	var lcFlgInit = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked").val() ;
	var combinedLcFlg = $("[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked").val() ;
	//画面特殊按钮和链接的初始化
		//【画：寄单信息.增加】，【画：寄单信息.删除】显示且可点击
		$("#dispch_add,#dispch_del").show() ;
		$("#dispch_add,#dispch_del").prop("disabled",false) ;
	
	//设置【画：信用证信息】板块和【画：非信用证信息】板块的初期显示
		//当【画：信用证信息.信用证项下】为‘Y’，
		if($.trim(lcFlgInit) == "Y"){
			//显示【画：信用证信息】板块，【画：非信用证信息】板块不显示；
			$("#LcInfo").show() ;
			$("#nonLcInfo").hide() ;
			//【画：信用证信息.信用证编号.检索】显示且不可点击
			$("#search1").show() ;
			$("#search1").prop("disabled",true) ;
		}else{
			//当【画：信用证信息.信用证项下】为‘N’，显示【画：非信用证信息】板块，【画：信用证信息】板块不显示。
			$("#nonLcInfo").show() ;
			$("#LcInfo").hide() ;
		}
			
	//设置【画：信用证信息-Combined LC信息】的初期显示
		//当【画：信用证信息.信用证项下】为‘Y’且【画：信用证信息.Combined LC 标志】‘Y’，
		if($.trim(lcFlgInit) == "Y" && $.trim(combinedLcFlg) == "Y"){
			//显示【信用证信息-Combined LC信息】；
			$("#bbCombLcNo").show() ;
			//【画：信用证信息.Combined LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined LC信息.信用证编号#2-#5.删除】显示且不可点击          
			$("#lcSearch2,#lcDel2,#lcSearch3,#lcDel3,#lcSearch4,#lcDel4,#lcSearch5,#lcDel5").show() ;			
			$("#lcSearch2,#lcDel2,#lcSearch3,#lcDel3,#lcSearch4,#lcDel4,#lcSearch5,#lcDel5").prop("disabled",true) ;	
		}else{
			//上述以外的情况，【信用证信息-Combined LC信息】不显示。
			$("#bbCombLcNo").hide() ;
		}
	
	//设置【画：信用证信息-转让信息】的初期显示
		//当【画：信用证信息.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】‘Y’
		var trasf2ndBene = $("[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked").val() ;
		if($.trim(lcFlgInit) == "Y" && $.trim(trasf2ndBene) == "Y"){
			//显示【信用证信息-转让信息】
			$("#trasfTable").show() ;
			//【画：信用证信息.转让编号.检索】显示且不可点击
			$("#btn_scan").show() ;
			$("#btn_scan").prop("disabled",true) ;
		}else{
			//上述以外的情况，【信用证信息-转让信息】不显示
			$("#trasfTable").hide() ;
		}
		
	//设置【画：承兑.远期索偿日】的可编辑和初始值	
	
		//当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时
		var withReimbsBankFlg = $("[name = 'data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val() ;
		if($.trim(lcFlgInit) == "Y" && $.trim(withReimbsBankFlg) == "Y"){
			$("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").setReadOnly(false);
		}else{
			//2- 上述以外的情况时，设为不可编辑
			$("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").setReadOnly(true) ;
		}
		
	//设置【画：寄单信息】的初期显示
		//当【画：寄单信息】无数据时，只显示表头
		//当【画：寄单信息】有数据时：
			//a- 当【DM：寄单信息.操作流水号】不等于当前操作流水号或【DM：寄单信息.操作版本号】不等于当前操作版本号时，将该寄单信息行设为不可编辑
			//b- 当【DM：寄单信息.操作流水号】等于当前操作流水号且【DM：寄单信息.操作版本号】等于当前操作版本号时，将该寄单信息行设为可编辑，将当前行的【Hidden：新增寄单信息标志】的值设为：Y
			// 当【画：寄单信息.寄单对象】为‘2：客户’时，【画：寄单信息.寄单种类】设为不可编辑	
			//※以上a+b需循环处理
	dispchBlockInit();
			
	//板块初期显示配置
	controlBlockDisplay(3, 4);
	controlBlockDisplay(4, 4);	
});

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
	//1	【画：承兑.承兑登记日】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcAccptceOpDtlVO/accptceRegDate']").val(),"required",artI18N.Label.Label_COM_01055);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//【画：承兑.承兑到期日】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcAccptceOpDtlVO/accptceDueDate']").val(),"required",artI18N.Label.Label_COM_01052);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//6	【画：承兑.远期索偿日】不为空时，必须小于等于【画：承兑.承兑到期日】，否则报错（VALIDATE_00029）
	if($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val() != ""){
		validateResult = $.art.Validator.validateBatch($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val(),"dateLessthanEq['"+$("[name='data/BcAccptceOpDtlVO/accptceDueDate']").val()+"']",artI18N.Label.Label_COM_02279);
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		}	
	}
	if(errMsg.length > 0){
		return errMsg;
	}	
	
	
	//4	当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：承兑.远期索偿日】不得为空，否则报错（SP_VALIDATE_823_021）
	var forwdClmRmbrsmtDate = $("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']");
	if (!SP_VALIDATE_823_021(forwdClmRmbrsmtDate)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02279]);
	}

	
	//8	当前寄单信息行的【Hidden：新增寄单信息标志】的值设为：Y时，做以下【画：寄单信息】板块项目的校验（※需循环判断，出错后退出校验）	
	$("#dispchDocTable>tbody>tr:visible").each(function (i, o) {
		var thizTr = $(this);
		var index = i;
												
		if($(":hidden[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+index+"]/exprsType']",thizTr).val() == "Y"){
			
			//【画：寄单信息.快递类型】不得为空，否则报错（VALIDATE_00018）
			validateResult = $.art.Validator.validateBatch($("[name = 'data/BcMntnOpDtlVO/dispchDocInfoVOList["+index+"]/recpnt']",thizTr).val(),"required",artI18N.Label.Label_COM_01671);
			if(validateResult.state == false){
				return validateResult.messages;
			}	
			//  【画：寄单信息.收件人】不得为空，否则报错（VALIDATE_00018）
			validateResult = $.art.Validator.validateBatch($("[name = 'data/BcMntnOpDtlVO/dispchDocInfoVOList["+index+"]/recpnt']",thizTr).val(),"required",artI18N.Label.Label_COM_01895);
			if(validateResult.state == false){
				return validateResult.messages;
			}																																																															
			//	【画：寄单信息.快递寄单日】不得为空，否则报错（VALIDATE_00018）		
			validateResult = $.art.Validator.validateBatch($("[name = 'data/BcMntnOpDtlVO/dispchDocInfoVOList["+index+"]/exprsDispchDocDate']",thizTr).val(),"required",artI18N.Label.Label_COM_01669);
			if(validateResult.state == false){
				return validateResult.messages;
			}		 
			//当【画：寄单信息.寄单对象】为‘1：银行’时，【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
			if(!SP_VALIDATE_823_028(index)){
				return validateResult.messages;
			}
		}																																																															
	});																																																																																																																				
	return errMsg;
}
					