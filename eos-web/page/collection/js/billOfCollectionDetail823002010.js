/**
*方法说明：托收入账复核画面初始化
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
		,submit : function(target,esrc){
			
		}
		,check : function(target,esrc){
			//复核
			$("#param_reqtype").val("Collection/CollBooking/detail");
			$("#param_action").val('check');
		}
		,approval : function(target,esrc){
			
		}
	});	
	
	//画面特殊按钮和链接的初始化
		//【画：入账.定价】不可显示，【画：寄单信息.增加】，【画：寄单信息.删除】显示且不可点击
		$("#btn_price_costinfo").hide() ;
		$("#dispch_add,#dispch_del").show() ;
		$("#dispch_add,#dispch_del").prop("disabled",true) ;
		
	// reqtype初期化
	$("#commonReqtype").val("Collection/CollBooking/detail");
	
	//设置【画：信用证信息】板块和【画：非信用证信息】板块的初期显示
		//当【画：信用证信息.信用证项下】为‘Y’，
		var lcFlgInit = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked").val() ;
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
		var combinedLcFlg = $("[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked").val() ;
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
		
	
	//设置【画：寄单信息】的初期显示	
		//当【画：寄单信息】无数据时，只显示表头	
		//当【画：寄单信息】有数据时，显示寄单信息内容
	
	// 1.1.7）当客户CIF存在于不申报不解付黑名单时，画面显示提示message,该客户存在于不申报不解付黑名单中，是否还要继续？（WARNING_824_002）																																																														
	//校验方法：调用组件列表【E90240】，参数：分行号，客户CIF，黑名单类型（ 10.不申报不解付名单），若组件返回值不为0，则提示Message。	
	var types = new Array(10);
	var flag = blackListValidate($("#artCommonOrgCode").val(), $("#beneCif").val(), null, types);
	if(flag != "0"){
		FormValidate.check($.getExceptionMsg('ART00077-W',artI18N.Label.Label_823_00004)).doShow();
	}

	//板块初期显示配置
	controlBlockDisplay(3, 4);
});