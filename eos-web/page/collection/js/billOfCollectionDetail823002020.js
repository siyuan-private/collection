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
		approval : function(target,esrc){
			//承认
			$("#param_reqtype").val("Collection/CollModf/detail");
			$("#param_action").val('approval');
		}
	});
	
	// 修正承认画面初始化
	/// 1.1.2）画面特殊按钮和链接的初始化	
	// 1- 【画：退改单.比对】，【画：退改单.修改履历】，【画：寄单信息.增加】和【画：寄单信息.删除】按钮
	$("#compareButton,#modHistButton,#dispch_add,#dispch_del").show();

	// 2- 【画：退改单.比对】，【画：寄单信息.增加】和【画：寄单信息.删除】按钮不可点击 	
	$("#compareButton,#dispch_add,#dispch_del").prop("disabled",true);
	
	// 3- 【画：退改单.修改履历】按钮可点击
	$("#modHistButton").prop("disabled",false);

	
	// 1.1.3）板块初期显示配置
	controlBlockDisplay(2, 2);
	controlBlockDisplay(4, 4);
	
	// 1.1.4）设置【画：信用证信息】板块和【画：非信用证信息】板块的初期显示
	// 1- 当【画：信用证信息.信用证项下】为‘Y’
	if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val())) {
		
		// 显示【画：信用证信息】板块，【画：非信用证信息】板块不显示
		$("#LcInfo").show();
		$("#nonLcInfo").hide();
		
		// 【画：信用证信息.信用证编号.检索】显示且不可点击
		$("#search1").show().prop("disabled",true);
	}
	
	// 2- 当【画：信用证信息.信用证项下】为空或者为‘N’时
	else {
	
		// 显示【画：非信用证信息】板块，【画：信用证信息】板块不显示
		$("#LcInfo").hide();
		$("#nonLcInfo").show();
	}
	
	// 1.1.5）设置【画：信用证信息-Combined LC信息】的初期显示
	// 1- 当【画：信用证信息.信用证项下】为‘Y’且【画：信用证信息.Combined LC 标志】为‘Y’
	if (("Y" == ($(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val())) && 
		("Y" == ($(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked").val()))) {
		
		// 显示【信用证信息-Combined LC信息】
		$("#bbCombLcNo").show();
		
		//【画：信用证信息.Combined LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined LC信息.信用证编号#2-#5.删除】显示且不可点击
		$("#lcSearch2,#lcSearch3,#lcSearch4,#lcSearch5").show().prop("disabled",true);
		$("#lcDel2,#lcDel3,#lcDel4,#lcDel5").show().prop("disabled",true);
	}
	
	// 2- 上述以外的情况
	else {
	
		// 【信用证信息-Combined LC信息】不显示
		$("#bbCombLcNo").hide();
	}
	
	// 1.1.6）设置【画：信用证信息-转让信息】的初期显示
	// 1- 当【画：信用证信息.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】‘Y’
	if (("Y" == ($(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val())) && 
		("Y" == ($(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked").val()))) {
		
		// 显示【信用证信息-转让信息】
		$("#trasfTable").show();
			
		// 【画：信用证信息.转让编号.检索】显示且不可点击
		$("#btn_scan").show().prop("disabled",true);
	}
	
	// 2- 上述以外的情况
	else {
	
		// 【信用证信息-转让信息】不显示
		$("#trasfTable").hide();
	}
	
	// reqtype初期化
	$("#commonReqtype").val("Collection/CollModf/detail");
});