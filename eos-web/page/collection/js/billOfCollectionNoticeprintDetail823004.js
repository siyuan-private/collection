/**
*方法说明：画面动作处理
*返回值:
*    无
*参数：
*    无
*/	
$(function(){
		
		//新建操作时处理
		if ($("[name='data/BbNoticeLettInfoVO/hidBtnType']").val() == "Create") {
			$("#btn_index").prop("disabled",false);
			//设置登记日不可编辑
			$("[name='data/BbNoticeLettInfoVO/regDate']").setReadOnly(true);
			//点击提交保存按钮时处理
			$("#saveSubmit").click(function(){ 
				$("#param_reqtype").val("Collection/NoticeLetterCreate/detail");
				$("#param_action").val("modify");
				FormValidate.check(submitValidate()).doShow().success(function(){
					$("#artform_def_detail")[0].submit();
				});				
    	});
    	
		//删除操作时处理
		}else if ($("[name='data/BbNoticeLettInfoVO/hidBtnType']").val() == "Delete") {
			//设置检索按钮不可点击
    	$("#btn_index").prop("disabled",true);
    	$(":text,textarea,select,:checkbox,:radio",$("#coveriControlPanel")).setReadOnly(true);
			$("#saveSubmit").click(function(){ 
        //设置reqtye值
				$("#param_reqtype").val("Collection/NoticeLetterDel/detail");
				//设置action值
				$("#param_action").val("modify");
				//form提交
				$("#artform_def_detail")[0].submit();
    	});
    	
		//修改操作时处理
		}else if ($("[name='data/BbNoticeLettInfoVO/hidBtnType']").val() == "Modify") {
			//设置检索按钮可点击
			$("#btn_index").prop("disabled",false);
  		//设置登记日不可编辑
			$("[name='data/BbNoticeLettInfoVO/regDate']").setReadOnly(true);
			//设置隐藏转让编号
			$("[name = 'data/BbNoticeLettInfoVO/hidTrasfTKind']").val($("[name = 'data/BbNoticeLettInfoVO/trasfTKind']").val()) ;
    	$("[name = 'data/BbNoticeLettInfoVO/hidTrasfNoPrmryRefNo']").val($("[name = 'data/BbNoticeLettInfoVO/trasfNoPrmryRefNo']").val()) ;
    	$("[name = 'data/BbNoticeLettInfoVO/hidTrasfNoSubRefNo']").val($("[name = 'data/BbNoticeLettInfoVO/trasfNoSubRefNo']").val()) ;
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
 		 	//提交保存时处理
			$("#saveSubmit").click(function(){ 
        $("#param_reqtype").val("Collection/NoticeLetterModfctn/detail");
				$("#param_action").val("modify");
				FormValidate.check(submitValidate()).doShow().success(function(){
					$("#artform_def_detail")[0].submit();
				});
				
    	});
			
		}else if ($("[name='data/BbNoticeLettInfoVO/hidBtnType']").val() == "ReadOnly") {
			//设置检索按钮不可点击
    	$("#btn_index").prop("disabled",true);
    	$(":text,textarea,select,:checkbox,:radio",$("#coveriControlPanel")).setReadOnly(true);
    	$("#saveSubmit").hide();
		}
    //【画：通知书信息.种类】选择时处理
    $("[name='data/BbNoticeLettInfoVO/type']").click(function(){ 
        changeType();
    });
    
    //【画：通知书信息.来单金额.币种】输入值变化时
    $("[name='data/BbNoticeLettInfoVO/docRecvdCcy']").change(function(){  
        changeDocRecvdCcy();
    });
    
    //【画：通知书信息.来单金额.金额】输入值变化时
    $("#docRecvdAmt").change(function(){      
        changeDocRecvdAmt();
    });
  
   
   //【画：通知书信息.来单行名称】输入值变化时
    $("[name='data/BbNoticeLettInfoVO/docRecvdBankName']").change(function(){            
       changeDocRecvdBankName();
    });
   
  
   //点击【画：检索】按钮时 
    $("#btn_index").click(function(){          
        clickSelect();
    }); 
    
   //结算方式信用证点击时处理
   $("#lcStlmtMeth").click(function(){
   	//设置保函方式不勾选
   	$("#lgStlmtMeth,#collStlmtMeth,#otherStlmtMeth").prop("checked",false);
   });
   //结算方式保函点击时处理
   $("#lgStlmtMeth").click(function(){
   	//设置其他三种方式不勾选
   	$("#lcStlmtMeth,#collStlmtMeth,#otherStlmtMeth").prop("checked",false);
   });
   //结算方式托收点击时处理
   $("#collStlmtMeth").click(function(){
   	//设置其他三种方式不勾选
   	$("#lgStlmtMeth,#lcStlmtMeth,#otherStlmtMeth").prop("checked",false);
   });
   //结算方式其他点击时处理
   $("#otherStlmtMeth").click(function(){
   	//设置保函方式不勾选
   	$("#lgStlmtMeth,#collStlmtMeth,#lcStlmtMeth").prop("checked",false);
   });
   
   //对公点击处理
   $("#toPubFlg").click(function(){
   	//设置对私不勾选
   	$("#toPrivtFlg").prop("checked",false);
   	//清空个人身份证值
   	$("#personalId").val("");
   });
   //对私点击处理
   $("#toPrivtFlg").click(function(){
   	//设置对公不勾选
   	$("#toPubFlg").prop("checked",false);
   	//清空组织机构代码1
   	$("#orgCode1").val("");
   	//清空组织机构代码2
   	$("#orgCode2").val("");
   });
});

//【画：通知书信息.种类】选择时处理方法
function changeType(){  
	//通知书信息种类
    var type = $("[name='data/BbNoticeLettInfoVO/type']:checked").val();
    //通知书信息保函
    var lgStlmtMeth=$("[name='data/BbNoticeLettInfoVO/lgStlmtMeth']");
   // 当【画：通知书信息.种类】为'1：境内'时,清空【画：通知书信息.结算方式.保函】的值，设为不可编辑
    if($.trim(type)=="1"){
        lgStlmtMeth.prop("checked",false); 
        lgStlmtMeth.setReadOnly(true);
    }else if($.trim(type)=="2"){ 
    	 //当【画：通知书信息.种类】为‘2：对外’时,【画：通知书信息.结算方式.保函】设置为可编辑
       lgStlmtMeth.setReadOnly(false);
    }
}


//【画：费用信息.来单金额.币种】输入值变化时处理方法
function changeDocRecvdCcy() {
	//来单金额币种	
	var docRecvdCcy = $("[name='data/BbNoticeLettInfoVO/docRecvdCcy']");
	//索汇金额币种
	var clmExchgAmtCcy = $("#clmExchgAmtCcy");
	if ($.trim(docRecvdCcy.val()) != "") {
		//不为空时，将【画：通知书信息.索汇金额.币种】的值设为【画：通知书信息.来单金额.币种】
		clmExchgAmtCcy.val(docRecvdCcy.val());		
	} else {
	   //为空时，清空【画：通知书信息.索汇金额.币种】的值
		clmExchgAmtCcy.val("");		
	}
}

//【画：费用信息.来单金额.金额】输入值变化时处理方法
function changeDocRecvdAmt() {
	//来单金额 金额
	var docRecvdAmt = $("#docRecvdAmt");
	//索汇金额 金额
	var clmExchgAmt = $("#clmExchgAmt");
	if ($.trim(docRecvdAmt.val()) != "") {	  
		//不为空时，将【画：通知书信息.索汇金额.金额】的值设为【画：通知书信息.来单金额.金额】
		clmExchgAmt.val(docRecvdAmt.val());		
	} else {
	   //为空时，清空【画：通知书信息.索汇金额.金额】的值
		clmExchgAmt.val("");		
	}
}

//【画：通知书信息.来单行名称】输入值变化时处理方法
function changeDocRecvdBankName() {
	//来单行名称
	var docRecvdBankName = $("[name='data/BbNoticeLettInfoVO/docRecvdBankName']");
	//收款行名称及地址
	var recvgBankNameAndAddr = $("[name='data/BbNoticeLettInfoVO/recvgBankNameAndAddr']");
	if ($.trim(docRecvdBankName.val()) != "") {	  
		//不为空时，将【画：通知书信息.收款行名称及地址】的值设为【画：通知书信息.来单行名称】
		recvgBankNameAndAddr.val(docRecvdBankName.val());		
	} else {
	   //为空时，清空【画：通知书信息.收款行名称及地址】的值
		recvgBankNameAndAddr.val("");		
	}
}


//点击【画：检索】按钮时处理逻辑
function clickSelect(){
	//信用证编号
  var lcNo=$("[name='data/BbNoticeLettInfoVO/lcNo']");
  //来单行名称
  var docRecvdBankName = $("[name='data/BbNoticeLettInfoVO/docRecvdBankName']");
  //收款行名称及地址
	var recvgBankNameAndAddr = $("[name='data/BbNoticeLettInfoVO/recvgBankNameAndAddr']");
  // 【画：通知书信息.转让编号】不得为空，否则报错（VALIDATE_00018）
	if (!SP_VALIDATE_823_004()) {
		FormValidate.check($.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_10001])).doShow().success(function(){});
		//return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_10001]);
	}	
		//清空信用证编号的值
    lcNo.val("");
    //情况来单行名称的值
    docRecvdBankName.val("");
    //情况收款行名称及地址的值
    recvgBankNameAndAddr.val("");
    //清空开证日期的值
    $("#issueDate").val("");
    //清空收款人的值
    $("#payeeName").val("");
    //清空付款人的值
    $("#payerName").val("");
    //根据输入的【画.通知书信息.转让编号】，到【DM：出口信用证转让信息】检索数据。
    
    //取得画面上的转让编号
    var trasfTKind = $("[name = 'data/BbNoticeLettInfoVO/trasfTKind']").val() ;
    var trasfNoPrmryRefNo = $("[name = 'data/BbNoticeLettInfoVO/trasfNoPrmryRefNo']").val() ;
    var trasfNoSubRefNo = $("[name = 'data/BbNoticeLettInfoVO/trasfNoSubRefNo']").val() ;
    
    //当转让编号不为空时
    if ($.trim(trasfTKind) != "" && $.trim(trasfNoPrmryRefNo) != "" && $.trim(trasfNoSubRefNo) != "") {
    	//获取分行号
    	var branchNo = $("#artCommonOrgCode").val();
    	//组建json串
    	var jsonStr = {"functionName":"findInfo","trasfTKind":trasfTKind,"trasfNoPrmryRefNo":trasfNoPrmryRefNo,"trasfNoSubRefNo":trasfNoSubRefNo,"branchNo":"676"};
    	//调用查询方法
    	bizQueryAjaxPost('categoryNoticeLetterAjax', jsonStr, function(data){
    		if (data.flag) {
    			
    			// 将【画：通知书信息.信用证编号】的值设为：【DM：出口信用证转让信息.信用证编号】
    			lcNo.val(data.map.lcNo) ;
    			
    			//将【画：通知书信息.开证日期】的值设为：【DM：出口信用证信息.开证日期】
    			$("#issueDate").val($.dateUtil.dateToString($.dateUtil.stringToDate(data.map.issueDate))) ;
    			// 将【画：通知书信息.来单行名称】的值设为：【DM：出口信用证转让信息.第二受益人通知行】
    			docRecvdBankName.val(data.map.bene2ndNoticeBank) ;
    			
    			// 将【画：通知书信息.收款人名称】的值设为：【DM：出口信用证转让信息.第二受益人名称】
    			$("#payeeName").val(data.map.bene2ndName) ;
    			
    			// 将【画：通知书信息.收款行名称及地址】的值设为：【DM：出口信用证转让信息.第二受益人通知行】
    			recvgBankNameAndAddr.val(data.map.bene2ndNoticeBank) ;
    			
    			//将【画：通知书信息.付款人名称】的值设为：【DM：出口信用证转让信息.受益人名称】
    			 $("#payerName").val(data.map.beneName) ;
    			//将【Hidden：ntid】的值设为【DM:通知书基本信息.ID】
    			if(data.map.ntid != undefined) {
    				$("[name = 'data/BbNoticeLettInfoVO/ntid']").val(data.map.ntid);
    			}else {
    				$("[name = 'data/BbNoticeLettInfoVO/ntid']").val(0);
    			}
    			//将【Hidden：转让编号】的值设为：【画.通知书信息.转让编号】
    			$("[name = 'data/BbNoticeLettInfoVO/hidTrasfTKind']").val(trasfTKind) ;
    			$("[name = 'data/BbNoticeLettInfoVO/hidTrasfNoPrmryRefNo']").val(trasfNoPrmryRefNo) ;
    			$("[name = 'data/BbNoticeLettInfoVO/hidTrasfNoSubRefNo']").val(trasfNoSubRefNo) ;
    		}else{
    			//显示报错信息
    			FormValidate.check($.getExceptionMsg(data.errList[0])).doShow().success(function(){});
    			//return data.errList[0];
    		}
    	});
    }
}

/**
*方法说明：新建保存提交校验
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
		errMsg.push(validateResult.messages);
		}
	}
	

	// 2- 【画：通知书信息.转让编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/trasfTKind']").val(),"required",artI18N.Label.Label_823_10001);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo']").val(),"required",artI18N.Label.Label_823_10001);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}	
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/trasfNoSubRefNo']").val(),"required",artI18N.Label.Label_823_10001);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 3-【画：通知书信息.信用证编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/lcNo']").val(),"required",artI18N.Label.Label_COM_02151);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 4- 【画：通知书信息.来单金额.币种】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("#docRecvdCcy").val(),"required",artI18N.Label.Label_823_10003);	
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 5- 【画：通知书信息.来单金额.金额】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("#docRecvdAmt").val(),"required",artI18N.Label.Label_823_10003);		
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	
	// 6- 【画：通知书信息.开证日期】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/issueDate']").val(),"required",artI18N.Label.Label_COM_01626);		
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 7- 【画：通知书信息.期限】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BbNoticeLettInfoVO/term']").val(),"required",artI18N.Label.Label_COM_01764);		
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
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


/**
*方法说明：通知书信息.转让编号不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_004(){
	//转让编号为空，返回false
	if($("[name='data/BbNoticeLettInfoVO/trasfTKind']").val() == "" ||		
		$("[name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo']").val() == "" || 
		  $("[name='data/BbNoticeLettInfoVO/trasfNoSubRefNo']").val() == ""){
		return false;
	}
	//否则返回true
	return true;
}

/**
*方法说明：当【Hidden：转让编号】不等于【画：通知书信息.转让编号】时，报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_098(){
	//获取hidden转让编号TrasfTKind
	var hidTrasfTKind = $("[name='data/BbNoticeLettInfoVO/hidTrasfTKind']");
	//获取hidden转让编号TrasfNoPrmryRefNo
	var hidTrasfNoPrmryRefNo = $("[name='data/BbNoticeLettInfoVO/hidTrasfNoPrmryRefNo']");
	//获取hidden转让编号TrasfNoSubRefNo
	var hidTrasfNoSubRefNo = $("[name='data/BbNoticeLettInfoVO/hidTrasfNoSubRefNo']");
	//获取画面上的转让编号TKind
	var TrasfTKind = $("[name = 'data/BbNoticeLettInfoVO/trasfTKind']");
	//获取画面上的转让编号PrmryRefNo 
	var TrasfNoPrmryRefNo = $("[name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo']");
	//获取画面上的转让编号SubRefNo
	var TrasfNoSubRefNo = $("[name='data/BbNoticeLettInfoVO/trasfNoSubRefNo']");
	//当【Hidden：转让编号】不等于【画：通知书信息.转让编号】时，return false
	if ( $.trim(hidTrasfTKind.val()) !=  $.trim(TrasfTKind.val())) {
		return false;
	}
	if ( $.trim(hidTrasfNoPrmryRefNo.val()) !=  $.trim(TrasfNoPrmryRefNo.val())) {
		return false;
	}
	if ( $.trim(hidTrasfNoSubRefNo.val()) !=  $.trim(TrasfNoSubRefNo.val())) {
		return false;
	}
	//否则返回true
	return true;
}