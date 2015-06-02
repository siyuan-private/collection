/**
*方法说明：托收入账编辑（询价前）画面初始化
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
			$("#param_reqtype").val("Collection/CollBooking/detail");
			$("#param_action").val('save');
		}
		,submit : function(target,esrc){
			//保存提交
			FormValidate.check(submitValidate()).doThrow();
			$("#param_reqtype").val("Collection/CollBooking/detail");
			$("#param_action").val('submit');
		}
		,check : function(target,esrc){
		}
		,approval : function(target,esrc){
		}
	});
	
	// 记账用reqType初期化
	$("#genAccReqtype").val("Collection/CollBooking/genacc");
	// 记账校验用用reqType初期化
	$("#genAccValidateReqtype").val("Collection/CollBooking/genaccValidate");
	// reqtype初期化
	$("#commonReqtype").val("Collection/CollBooking/detail");
	
	//画面特殊按钮和链接的初始化
		//【画：入账.定价】，【画：寄单信息.增加】，【画：寄单信息.删除】显示且可点击
		$("#btn_price_costinfo,#dispch_add,#dispch_del").show() ;
		$("#btn_price_costinfo,#dispch_add,#dispch_del").prop("disabled",false) ;
	
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
	
	//设置【画：入账】板块的可编辑	
		//入账编辑且【画：入账.福费廷】不勾选时
		if(!$("[name = 'data/BcBookOpDtlVO/forftingFlg']").is(":checked")){
		
			//设置【画：入账.待核查账户】(币种，GL，SUB GL，账号)，【画：入账.客户等级】的可编辑	
				//当【画：入账.进待核查】勾选时，【画：入账.待核查账户】(币种，GL，SUB GL，账号)，【画：入账.客户等级】设为可编辑
				if($("[name = 'data/BcBookOpDtlVO/validatnFlg']").is(":checked")){
					$("#validatnAcctCcy").setReadOnly(false) ;
					$("#validatnAcctGl").setReadOnly(false) ;
					$("#validatnAcctSubGl").setReadOnly(false) ;
					$("#validatnAcctNo").setReadOnly(false) ;
					$("[name = 'data/BcBookOpDtlVO/custLv']").setReadOnly(false) ;
				}else{
					//当【画：入账.进待核查】不勾选时，【画：入账.待核查账户】(币种，GL，SUB GL，账号)，【画：入账.客户等级】设为不可编辑	
					$("#validatnAcctCcy").setReadOnly(true) ;
					$("#validatnAcctGl").setReadOnly(true) ;
					$("#validatnAcctSubGl").setReadOnly(true) ;
					$("#validatnAcctNo").setReadOnly(true) ;
					$("[name = 'data/BcBookOpDtlVO/custLv']").setReadOnly(true) ;
				}
				
			//设置【画：入账.入账账户#2】(币种，GL，SUB GL，账号)，【入账.金额#2.金额】，【入账.定价金额#2.金额】，【入账.入账金额#2.金额】的可编辑	
				//当【画：入账.入两个账户】勾选时，	
				if($("[name = 'data/BcBookOpDtlVO/enter2AcctFlg']").is(":checked")){
						//【画：入账.入账账户#2】(币种，GL，SUB GL，账号)，【画：入账.金额#2.金额】，【画：入账.定价金额#2.金额】，【画：入账.入账金额#2.金额】设为可编辑
						$("#bookAcctCcy2").setReadOnly(false) ;
						$("#bookAcctGl2").setReadOnly(false) ;
						$("#bookAcctSubGl2").setReadOnly(false) ;
						$("#bookAcctNo2").setReadOnly(false) ;
						
						$("#amt2").setReadOnly(false) ;
						$("#prcAmt2").setReadOnly(false) ;
						$("#bookAmt2").setReadOnly(false) ;
				}else{
					//当【画：入账.入两个账户】不勾选时
						//【画：入账.入账账户#2】(币种，GL，SUB GL，账号)，【画：入账.金额#2.金额】，【画：入账.定价金额#2.金额】，【画：入账.入账金额#2.金额】设为不可编辑
						$("#bookAcctCcy2").setReadOnly(true) ;
						$("#bookAcctGl2").setReadOnly(true) ;
						$("#bookAcctSubGl2").setReadOnly(true) ;
						$("#bookAcctNo2").setReadOnly(true) ;
						
						$("#amt2").setReadOnly(true) ;
						$("#prcAmt2").setReadOnly(true) ;
						$("#bookAmt2").setReadOnly(true) ;
				}
		}else{
		
			//入账编辑且【画：入账.福费廷】勾选时
			
			  //【画：入账】板块的项目设为不可编辑
				$(":text,textarea,select,:checkbox,:radio",$("#xiugaiControlPanel")).setReadOnly(true);
			
				//以下项目设为可编辑
				//【入账.福费廷】，【入账.头寸金额.金额），【入账.我行对客入账日】，【入账.清算行账户】（GL，SUB GL，账号）
				//【入账.入账账户#1】（币种，GL，SUB GL，账号），【入账.金额#1.金额】，【入账.入账金额#1.金额】
				//【入账.福费廷】设为可编辑
				$("[name = 'data/BcBookOpDtlVO/forftingFlg']").setReadOnly(false) ;
				//【入账.头寸金额.金额）设为可编辑
				$("#posAmt").setReadOnly(false) ;
				//【入账.我行对客入账日】设为可编辑
				$("[name = 'data/BcBookOpDtlVO/ourBankToCustBookingDate']").setReadOnly(false) ;
				//【入账.清算行账户】币种设为可编辑
				$("#bcBookOpDtlVOclrBankAcctCcy").setReadOnly(false) ;
				//【入账.清算行账户】GL设为可编辑
				$("#bcBookOpDtlVOclrBankAcctGl").setReadOnly(false) ;
				//【入账.清算行账户】SUB GL设为可编辑
				$("#bcBookOpDtlVOclrBankAcctSubGl").setReadOnly(false) ;
				//【入账.清算行账户】账号设为可编辑
				$("#bcBookOpDtlVOclrBankAcctNo").setReadOnly(false) ;
				//【入账.入账账户#1】币种设为可编辑
				$("#bookAcctCcy1").setReadOnly(false) ;
				//【入账.入账账户#1】GL设为可编辑
				$("#bookAcctGl1").setReadOnly(false) ;
				//【入账.入账账户#1】SUB GL设为可编辑
				$("#bookAcctSubGl1").setReadOnly(false) ;
				//【入账.入账账户#1】账号设为可编辑
				$("#bookAcctNo1").setReadOnly(false) ;
				//【入账.金额#1.金额】设为可编辑
				$("#amt1").setReadOnly(false) ;
				//入账.入账金额#1.金额】设为可编辑
				$("#bookAmt1").setReadOnly(false) ;
		}
		
	//设置【画：寄单信息】的初期显示
		//当【画：寄单信息】无数据时，只显示表头
		//当【画：寄单信息】有数据时：
			//a- 当【DM：寄单信息.操作流水号】不等于当前操作流水号或【DM：寄单信息.操作版本号】不等于当前操作版本号时，将该寄单信息行设为不可编辑
			//b- 当【DM：寄单信息.操作流水号】等于当前操作流水号且【DM：寄单信息.操作版本号】等于当前操作版本号时，将该寄单信息行设为可编辑，将当前行的【Hidden：新增寄单信息标志】的值设为：Y
			// 当【画：寄单信息.寄单对象】为‘2：客户’时，【画：寄单信息.寄单种类】设为不可编辑	
			//※以上a+b需循环处理
	dispchBlockInit();
			
	//调用前台JS函数“E80010(当前节点定价按钮ID，定价状态的隐藏字段)”,控制业务画面上定价按钮的所显示文字（“定价”或“脱绑”）
		switchBtnText("btn_price_costinfo",getMakePriceCode());
	//定价状态取得			
		$("[name='data/BcMntnOpDtlVO/pricingStatus']").val(getMakePriceCode());
		
	//板块初期显示配置
	controlBlockDisplay(3, 4);
	
	// Bop上报用reqType初期化
	$("#genBopReqtype").val("Collection/CollBooking/genbop");
});


/**
*方法说明：新建编辑 点击【画：记账】Link时，数据校验逻辑
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    无
*/
function generateValidate(){

	var errMsg = [];
	var validateResult;

	//1- 【画：入账.头寸金额.金额】不得为空，否则报错。（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/posAmt']").val(),"required",artI18N.Label.Label_823_00013);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//2- 【画：入账.我行对客入账日】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/ourBankToCustBookingDate']").val(),"required",artI18N.Label.Label_823_00013);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//3- 【画：入账.清算行账户】不得为空，否则报错。（VALIDATE_00018）[※币种，GL，SUB GL，账号都不得为空]
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctCcy]").val(),"required",artI18N.Label.Label_823_00041);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	} else {
		validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctGl']").val(),"required",artI18N.Label.Label_823_00041);	
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		} else {
			validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctSubGl']").val(),"required",artI18N.Label.Label_823_00041);	
			if (validateResult.state == false) {
				errMsg.push(validateResult.messages);
			} else {
				validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctNo']").val(),"required",artI18N.Label.Label_823_00041);	
				if (validateResult.state == false) {
					errMsg.push(validateResult.messages);
				}
			}
		}
	}
	//4- 【画：入账.入账账户#1】不得为空，否则报错。（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctCcy1]").val(),"required",artI18N.Label.Label_823_00057);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	} else {
		validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctGl1']").val(),"required",artI18N.Label.Label_823_00057);	
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		} else {
			validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctSubGl1']").val(),"required",artI18N.Label.Label_823_00057);	
			if (validateResult.state == false) {
				errMsg.push(validateResult.messages);
			} else {
				validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctNo1']").val(),"required",artI18N.Label.Label_823_00057);	
				if (validateResult.state == false) {
					errMsg.push(validateResult.messages);
				}
			}
		}
	}
	//5- 【画：入账.金额#1.金额】不得为空，否则报错。（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/amt1']").val(),"required",artI18N.Label.Label_COM_01570);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	
	if(errMsg.length > 0){
		return errMsg;
	}	
	
	//6- 当【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#1.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
	if(!SP_VALIDATE_823_015(Ccy1)){
			return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_823_00057]);
	}	
	//7- 当【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#1.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
	if(!SP_VALIDATE_823_025(Ccy1)){
				return $.getExceptionMsg('ART00107-E',[artI18N.Label.Label_823_00057]);	
		}		
	//8- 当【画：入账.入两个账户】不勾选时，【画：入账.金额#1.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_031）
	if(!SP_VALIDATE_823_031()){
				return $.getExceptionMsg('ART00012-E',[artI18N.Label.Label_COM_01570,artI18N.Label.Label_823_00013]);		
		}	
	//9- 当【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价（SP_VALIDATE_823_018）
	if(!SP_VALIDATE_823_018()){
				return $.getExceptionMsg('ART00131-E');				
		}	
	//10- 当【画：入账.入两个账户】勾选时，【画：入账.入账账户#2】不得为空，否则报错（SP_VALIDATE_823_027）
	if(!SP_VALIDATE_823_027("Acct")){
				return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00057]);	
		}	
	//11- 当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#2.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
	if("" != $.trim(bookAcctCcy2)){
		if(!SP_VALIDATE_823_015(Ccy2)){
			return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_823_00057]);	
		}
		//12- 当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#2.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
		if(!SP_VALIDATE_823_025(Ccy2)){
				return $.getExceptionMsg('ART00107-E',[artI18N.Label.Label_823_00057]);	
		}
	}
	//13- 当【画：入账.入两个账户】勾选时，【画：入账.金额#2.金额】不得为空，否则报错（SP_VALIDATE_823_027）
	if(!SP_VALIDATE_823_027("Amt")){
				return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01570]);	
		}	
	//14- 当【画：入账.入两个账户】勾选时，【画：入账.金额#1.金额】+【画：入账.金额#2.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_016）
	if(!SP_VALIDATE_823_016()){
				return $.getExceptionMsg('ART82306-E');	
		}
	//15- 当【画：入账.入两个账户】勾选且【画：入账.入账账户#2.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价（SP_VALIDATE_823_019）
	if(!SP_VALIDATE_823_019()){
		    //{0}与{1}不一致，请进行定价操作
				return $.getExceptionMsg('ART00131-E',[artI18N.Label.Label_823_00057,artI18N.Label.Label_823_00005]);		
		}
	//16-【画：手续费】板块中‘单独记账’不勾选且已收的手续费条数必须小于等于5条，否则报错（SP_VALIDATE_823_038）
	if(!SP_VALIDATE_823_038()){
		return $.getExceptionMsg('ART00121-E',[artI18N.Label.Link_823_00001,"5"]);
	}
	return errMsg ;
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
	//1	【画：入账.头寸金额.金额】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name = 'data/BcBookOpDtlVO/posAmt']").val(),"required",artI18N.Label.Label_823_00013);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//2	【画：入账.我行对客入账日】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name = 'data/BcBookOpDtlVO/ourBankToCustBookingDate']").val(),"required",artI18N.Label.Label_COM_02097);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	//3	【画：入账.清算行账户】不得为空，否则报错。（VALIDATE_00018）[※币种，GL，SUB GL，账号都不得为空]
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctCcy']").val(),"required",artI18N.Label.Label_823_00041);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	} else {
		validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctGl']").val(),"required",artI18N.Label.Label_823_00041);	
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		} else {
			validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctSubGl']").val(),"required",artI18N.Label.Label_823_00041);	
			if (validateResult.state == false) {
				errMsg.push(validateResult.messages);
			} else {
				validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/clrBankAcctNo']").val(),"required",artI18N.Label.Label_823_00041);	
				if (validateResult.state == false) {
					errMsg.push(validateResult.messages);
				}
			}
		}
	}
	//4	【画：入账.入账账户#1】不得为空，否则报错。（VALIDATE_00018）[※币种，GL，SUB GL，账号都不得为空]	
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctCcy1']").val(),"required",artI18N.Label.Label_823_00057);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	} else {
		validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctGl1']").val(),"required",artI18N.Label.Label_823_00057);	
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		} else {
			validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctSubGl1']").val(),"required",artI18N.Label.Label_823_00057);	
			if (validateResult.state == false) {
				errMsg.push(validateResult.messages);
			} else {
				validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/bookAcctNo1']").val(),"required",artI18N.Label.Label_823_00057);	
				if (validateResult.state == false) {
					errMsg.push(validateResult.messages);
				}
			}
		}
	}
	//5	【画：入账.金额#1.金额】不得为空，否则报错。（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name = 'data/BcBookOpDtlVO/amt1']").val(),"required",artI18N.Label.Label_COM_01570);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	
	if(errMsg.length > 0){
		return errMsg;
	}	
	
	//6	【画：入账.头寸金额.金额】必须小于等于【画：新建.汇票金额.金额】，否则报错（VALIDATE_00034）
	validateResult = $.art.Validator.validateBatch($("[name = 'data/BcBookOpDtlVO/posAmt']").val(),"moneyLessthanEq["+$("#bxAmt").val()+"]",artI18N.Label.Label_823_00013);
	if (validateResult.state == false) {
		return validateResult.messages;
	}
	//17	【画：入账.定价金额#1.金额】不为空时，必须小于等于【画：入账.金额#1.金额】，否则报错（VALIDATE_00034）
	if($("#amt1").val() != ""){
		validateResult = $.art.Validator.validateBatch($("[name = 'data/BcBookOpDtlVO/prcAmt1']").val(),"moneyLessthanEq["+$("#amt1").val()+"]",artI18N.Label.Label_823_00058);
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}
	//24	【画：入账.定价金额#2.金额】不为空时，必须小于等于【画：入账.金额#2.金额】，否则报错（VALIDATE_00034）
	if($("#prcAmt2").val() != ""){
		validateResult = $.art.Validator.validateBatch($("[name = 'data/BcBookOpDtlVO/prcAmt2']").val(),"moneyLessthanEq["+$("#amt2").val()+"]",artI18N.Label.Label_823_00058);
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}
	
	
	//7	当【画：入账.福费廷】勾选时，【画：单据信息.有追索权】必须为‘N’，否则报错（SP_VALIDATE_823_014）
	if (!SP_VALIDATE_823_014()) {
		return $.getExceptionMsg('ART82300-E');
	}
	//8	当【画：入账.福费廷】勾选时，【画：承兑.Accepted Flag】必须为‘Y’，否则报错（SP_VALIDATE_823_034）
	if (!SP_VALIDATE_823_034()) {
		return $.getExceptionMsg('ART82311-E');
	}
	//9	当【画：入账.进待核查】勾选时，【画：入账.待核查账户】不得为空，否则报错（SP_VALIDATE_823_026）[※币种，GL，SUB GL，账号都不得为空]
	if (!SP_VALIDATE_823_026("Acct")) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00052]);
	}
	//10	当【画：入账.进待核查】勾选时，【画：入账.客户等级】不得为空，否则报错（SP_VALIDATE_823_026）	
	if (!SP_VALIDATE_823_026("CustLv")) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01634]);
	}
	//11	当【画：入账.福费廷】不勾选时，【画：入账.对手方银行国别.国家】不得为空，否则报错（SP_VALIDATE_823_036）
	if(!SP_VALIDATE_823_036()){
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00056]);
	}
	//12	当【画：入账.对手方银行国别.国家】为‘CHN’时,【画：入账.对手方银行国别.省】不得为空，否则报错（SP_VALIDATE_823_035）	
	if(!SP_VALIDATE_823_035($("[name = 'data/BcBookOpDtlVO/counterPartyProv']").val(),1)){
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00056]);
	}
	//13	当【画：入账.对手方银行国别.国家】为‘CHN’时,【画：入账.对手方银行国别.市】不得为空，否则报错（SP_VALIDATE_823_035）	
	if(!SP_VALIDATE_823_035($("[name = 'data/BcBookOpDtlVO/counterPartyCity']").val(),1)){
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00056]);
	}
	//14	当【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#1.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
	if(!SP_VALIDATE_823_015("Ccy1")){
		return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_823_00057]);
	}
	//15	当【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#1.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
	if(!SP_VALIDATE_823_025("Ccy1")){
		return $.getExceptionMsg('ART00107-E',[artI18N.Label.Label_823_00057]);
	}
	//16	当【画：入账.入两个账户】不勾选时，【画：入账.金额#1.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_031）
	if(!SP_VALIDATE_823_031()){
		return $.getExceptionMsg('ART00012-E',[artI18N.Label.Label_COM_01570]);
	}
	//18	当【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价（SP_VALIDATE_823_018）: {0}与{1}不一致，请进行定价操作。
	if(!SP_VALIDATE_823_018()){
		return $.getExceptionMsg('ART00131-E',[artI18N.Label.Label_823_00057,artI18N.Label.Label_823_00005]);
	}
	//19	当【画：入账.入两个账户】勾选时，【画：入账.入账账户#2】不得为空，否则报错（SP_VALIDATE_823_027）
	if(!SP_VALIDATE_823_027("Acct")){
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00057]);
	}
	//20	当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#2.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
	if($("bookAcctCcy2").val() != ""){
		if(!SP_VALIDATE_823_015("Ccy2")){
		return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_823_00057]);
		}
	}
	//21	当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#2.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）	
	if(!SP_VALIDATE_823_025("Ccy2")){
		return $.getExceptionMsg('ART00107-E',[artI18N.Label.Label_823_00057]);
	}
	//22	当【画：入账.入两个账户】勾选时，【画：入账.金额#2.金额】不得为空，否则报错（SP_VALIDATE_823_027）
	if(!SP_VALIDATE_823_027("Amt")){
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00058]);
	}
	//23	当【画：入账.入两个账户】勾选时，【画：入账.金额#1.金额】+【画：入账.金额#2.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_016）
	if(!SP_VALIDATE_823_016()){
		return $.getExceptionMsg('ART82306-E');
	}
	//25	当【画：入账.入两个账户】勾选且【画：入账.入账账户#2.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价（SP_VALIDATE_823_019）: {0}与{1}不一致，请进行定价操作。
	if(!SP_VALIDATE_823_019()){
		return $.getExceptionMsg('ART00131-E',[artI18N.Label.Label_823_00057,artI18N.Label.Label_823_00005]);
	}

	//27	当前寄单信息行的【Hidden：新增寄单信息标志】的值设为：Y时，做以下【画：寄单信息】板块项目的校验（※需循环判断，出错后退出校验）	
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
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01522]);
			}
		}																																																															
	});

	return errMsg ;
}
			
					
							

