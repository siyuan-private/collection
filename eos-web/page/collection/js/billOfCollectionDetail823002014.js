/**
*方法说明：托收退单承认画面初始化
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
			
		}
		,submit : function(target,esrc){
			
		}
		,check : function(target,esrc){
		
		}
		,approval : function(target,esrc){
			//承认
			$("#param_reqtype").val("Collection/CollChgbk/detail");
			$("#param_action").val('approval');
		}
	});	
	
	//画面特殊按钮和链接的初始化	
		//【画：退改单.比对】，【画：退改单.修改履历】，【画：寄单信息.增加】，【画：寄单信息.删除】按钮显示且不可点击	
		$("#compareButton,#modHistButton").show() ;
		$("#compareButton,#modHistButton").prop("disabled",true) ;
		$("#dispch_add,#dispch_del").show() ;
		$("#dispch_add,#dispch_del").prop("disabled",true) ;
		
	// reqtype初期化
	$("#commonReqtype").val("Collection/CollChgbk/detail");
		
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
		
	//【画：退改单.比对结果一览】只显示表头		
	
	//板块初期显示配置
	controlBlockDisplay(4,4);
	controlBlockDisplay(2,2) ;
});