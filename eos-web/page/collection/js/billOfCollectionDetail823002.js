/**
*方法说明：画面动作处理
*返回值:
*    无
*参数：
*    无
*/	
$(function(){
	// 参数:业务种类、源交易参号-Tkind、源交易参号-主参号、源交易参号-子参号、客户CIF、源交易金额-币种、源交易金额-金额、备注
	feeInitialize(BIZ_CODE_ID["823_00"],"srcTkind","srcPrmryRefNo","srcSubRefNo",$("#beneCif").val(),"bxCcy","bxAmt","");
	
	// 默认加载页面时缓存表单数据
	var detailInit = $.art.common.jsonStringInit(COMMON_CONSTANT.DETAIL_FORM_ID);
	// 默认加载页面时缓存class为art_detail_tally的数据
	var initTally = $.art.common.jsonTallyInit(COMMON_CONSTANT.ART_DETAIL_TALLY);
	

	//【画：新建.信用证项下】选择值变化时处理	
	$("[name='data/BcMntnOpDtlVO/lcFlg']").click(function(){
		changeLcFlg();
	});
	
	//【画；新建.BPO】勾选时处理
	$("[name='data/BcMntnOpDtlVO/bpoFlg']").click(function(){
		checkedBpoFlg();
	});
	
	//【画；新建.TSU】勾选时处理
	$("[name='data/BcMntnOpDtlVO/tsuFlg']").click(function(){
		checkedTsuFlg();
	});
	
	//【画：新建.P.P. NEGO】勾选时处理
	$("[name='data/BcMntnOpDtlVO/ppnegoFlg']").click(function(){
		checkedPpnegoFlg();
	});
	
	//【画：新建.电报议付】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/telegNegoFlg']").click(function(){
		changeTelegNegoFlg();
	});
	
	//【画：新建.汇票金额.币种】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/bxCcy']").change(function(){
		changeBxCcy();
	});
	
	//【画：新建.Tenor.种类】选择值变化时处理	
	$("[name='data/BcMntnOpDtlVO/tenorType']").selectedChange(function(){
		changeTenorType();
	});
	
	//【画：新建.假远期】，【画：新建.Tenor.种类】，【画：新建.Tenor.天数】，【画：新建.托收日期】，【画：新建.提单日期】输入值变化时处理（OnChange处理）
	//【画：新建.假远期】输入值变化时
	$("[name='data/BcMntnOpDtlVO/fakeForwdFlg']").click(function(){
		changeFakeForwdFlg();
	});
	//【画：新建.Tenor.种类】输入值变化时
	$("[name='data/BcMntnOpDtlVO/tenorType']").change(function(){
		changeFakeForwdFlg();
	});
	//【画：新建.Tenor.天数】输入值变化时
	$("[name='data/BcMntnOpDtlVO/tenorDays']").change(function(){
		changeFakeForwdFlg();
	});
	//【画：新建.托收日期】输入值变化时
	$("[name='data/BcMntnOpDtlVO/collDate']").valueChange(function(){
		changeFakeForwdFlg();
	});
	// 【画：新建.提单日期】输入值变化时
	$("[name='data/BcMntnOpDtlVO/blDate']").valueChange(function(){
		changeFakeForwdFlg();
	})
	
	//【画：新建.发票编号】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/ivcNo']").change(function(){
		changeIvcNo();
	});
	
	//【画：新建.到期日期】输入值变化时处理 新建/改单编辑画面
	$("[name='data/BcMntnOpDtlVO/dueDate']").valueChange(function(){
		changeDueDate();
	});
	
	//【画：信用证信息.信用证金额.币种】输入值变化时处理
	$("#lcAmtCcy").change(function(){
		changeLcAmtCcy();
	});
	
	//【画：信用证信息.信用证金额.金额】或【画：信用证信息.信用证余额.金额】输入值变化时处理
	// 【画：信用证信息.信用证金额.金额】输入值变化时
	$("#expLcAmt").change(function(){
		changeLcAmt();
	});
		// 【画：信用证信息.信用证余额.金额】输入值变化时
	$("#expLcBalAmt").change(function(){
		changeLcAmt();
	});
	
	//【画：信用证信息.第二受益人】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']").click(function(){
		changeBene2ndFlg();
	});
	
	//【画：信用证信息.进口商国别】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']").change(function(){
		changeImptrNatnlty();
	});
	
	//【画：信用证信息.寄单行同开证行】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']").click(function(){
		changeDispchBankEqIssueFlg();
	});
	
	//【画：信用证信息.有偿付行】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']").click(function(){
		changeWithReimbsBankFlg();
	});
	
	//【画：信用证信息.开证行.Swift】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']").change(function(){
		changeIssueBankSwift();
	});
	
	//【画：信用证信息.开证行.名称】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']").change(function(){
		changeIssueBankName();
	});
	
	//【画：信用证信息.开证行.地址】输入值变化时处理	
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']").change(function(){
		changeIssueBankAddr();
	});
	
	//【画：信用证信息.留行信用证】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").click(function(){
		changeKibLcFlg();
	});
	
	//【画：信用证信息.Combined LC】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/combinedLcFlg']").click(function(){
		changeCombinedLcFlg();
	});
	
	//【画：信用证信息.转让第二受益人】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/trasf2ndBene']").click(function(){
		changeTrasf2ndBene();
	});
	
	
	//【画：非信用证信息.进口商国别】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/imptrNatnlty']").change(function(){
		changeNotLcImptrNatnlty();
	});
	
	
	//【画：费用信息.手续费支付方】选择值变化时处理
	$("[name='data/BcMntnOpDtlVO/feePayer']").click(function(){
		changeFeePayer();
	});

	
	//【画：寄单信息.寄单对象】选择值变化时处理
	$(":radio", "#dispchDocTable tbody tr:even td:nth-child(4)").click(function () {
       var stlmtAcctNo=$(this);
       var thisTr = stlmtAcctNo.parents("tr").eq(0);
       changeDispchDocObj(thisTr);
  	});	
	

	//【画：寄单信息.寄单种类】选择值变化时处理
	$("select", "#dispchDocTable tbody tr:even td:nth-child(5)").change(function () {
       var stlmtAcctNo=$(this);
       var thisTr = stlmtAcctNo.parents("tr").eq(0);
       changeDispchDocType(thisTr);
  	});
	
	//【画：信用证信息.转让信用证】选择值变化时处理 
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']").click(function(){
		changeTrasfLcFlg();
	});
	//点击【画：信用证信息.Combined LC信息.信用证编号#2.删除】按钮时处理逻辑
	$("#lcDel2").click(function(){
		clickCombinedLCDel(2) ;
	});
		//点击【画：信用证信息.Combined LC信息.信用证编号#3.删除】按钮时处理逻辑
	$("#lcDel3").click(function(){
		clickCombinedLCDel(3) ;
	});
		//点击【画：信用证信息.Combined LC信息.信用证编号#4.删除】按钮时处理逻辑
	$("#lcDel4").click(function(){
		clickCombinedLCDel(4) ;
	});
		//点击【画：信用证信息.Combined LC信息.信用证编号#5.删除】按钮时处理逻辑
	$("#lcDel5").click(function(){
		clickCombinedLCDel(5) ;
	});
	
	// 寄单信息增加和删除处理	
	$("#dispchDocTable").lineOperate({
 		addLink:"#dispch_add",
 		deleteLink:"#dispch_del",
 		interval:1,
 		trClass:"tr_color",
 		singleSelect:false,
 		checkbox:true,
 		afterAdd:clickDispchAdd
  });

	// 【画：承兑.承兑到期日】输入值变化时处理
	$("[name='data/BcAccptceOpDtlVO/accptceDueDate']").valueChange(function(){
		changeAccptceDueDate();
	});
	
	// 【画：入账.福费廷】勾选时处理
	$("[name='data/BcBookOpDtlVO/forftingFlg']").click(function(){
		checkedForftingFlg();
	});
	
  // 【画：入账.头寸金额.金额】输入值变化时处理 
	$("[name='data/BcBookOpDtlVO/posAmt']").change(function(){
		changePosAmt();
	});
		
	//【画：入账.待核查账户】输入值变化时处理
	$("[name='data/BcBookOpDtlVO/validatnAcctCcy']").change(function(){
		//changeBookValidatnAcct();
		changeValidatnAcct();
	});
	$("[name='data/BcBookOpDtlVO/validatnAcctGl']").change(function(){
		//changeBookValidatnAcct();
		changeValidatnAcct();
	});
	$("[name='data/BcBookOpDtlVO/validatnAcctSubGl']").change(function(){
		//changeBookValidatnAcct();
		changeValidatnAcct();
	});
	$("[name='data/BcBookOpDtlVO/validatnAcctNo']").change(function(){
		//changeBookValidatnAcct();
		changeValidatnAcct();
	});
	
	//【画：入账.入两个账户】勾选时处理
	$("[name='data/BcBookOpDtlVO/enter2AcctFlg']").click(function(){
		checkedEnter2AcctFlg() ;
	});
	
	//【画：入账.入账账户#1.币种】输入值变化时处理
	$("#bookAcctCcy1").change(function(){
		changeBookAcctCcy1();
		//changeBookAcct1();
		changeBookAcctNo1();
	});
	//【画：入账.入账账户#1.GL】输入值变化时处理 
	$("#bookAcctGl1").change(function(){
		//changeBookAcct1();
		changeBookAcctNo1();
	});	
	//【画：入账.入账账户#1.SUB GL】输入值变化时处理 
	$("#bookAcctSubGl1").change(function(){
		//changeBookAcct1();
		changeBookAcctNo1();
	});	
	//【画：入账.入账账户#1.账号】输入值变化时处理 
	$("#bookAcctNo1").change(function(){
		//changeBookAcct1();
		changeBookAcctNo1();
	});		
	
	//【画：入账.入账账户#2.币种】输入值变化时处理 
	$("#bookAcctCcy2").change(function(){
		changeBookAcctCcy2();
		//changeBookAcct2();
		changeBookAcctNo2();
	});
	//【画：入账.入账账户#2.GL】输入值变化时处理
	$("#bookAcctGl2").change(function(){
		//changeBookAcct2();
		changeBookAcctNo2();
	});	
	//【画：入账.入账账户#2.SUB GL】输入值变化时处理
	$("#bookAcctSubGl2").change(function(){
		//changeBookAcct2();
		changeBookAcctNo2();
	});	
	//【画：入账.入账账户#2.账号】输入值变化时处理
	$("#bookAcctNo2").change(function(){
		//changeBookAcct2();
		changeBookAcctNo2();
	});	
	
	
	// 控件实现	
//【画：入账.清算行账户】，【画：入账.手续费账户】输入值变化时处理
//	$("#bcBookOpDtlVOclrBankAcctCcy").change(function(){
//		changeBookClrBankAcct();
//	});
//	$("#bcBookOpDtlVOclrBankAcctGl").change(function(){
//		changeBookClrBankAcct();
//	});
//	$("#bcBookOpDtlVOclrBankAcctSubGl").change(function(){
//		changeBookClrBankAcct();
//	});
//	$("#bcBookOpDtlVOclrBankAcctNo").change(function(){
//		changeBookClrBankAcct();
//	});
//	$("#bcBookOpDtlVOfeeAcctCcy").change(function(){
//		changeBookFeeAcct();
//	});
//	$("#bcBookOpDtlVOfeeAcctGL").change(function(){
//		changeBookFeeAcct();
//	});
//	$("#bcBookOpDtlVOfeeAcctSubGL").change(function(){
//		changeBookFeeAcct();
//	});
//	$("#bcBookOpDtlVOfeeAcctNo").change(function(){
//		changeBookFeeAcct();
//	});
		
	// 【画：新建.到期日期】输入值变化时处理   修正编辑画面
	$("[name='data/BcMntnOpDtlVO/dueDate']").valueChange(function(){
		changeReviseDueDate2();
	});	
	
	// 【画：承兑.Accepted Flag】选择值变化时处理
	$("[name='data/BcAccptceOpDtlVO/acceptedFlg']").click(function(){
		changeAcceptedFlag();
	});
	
//	// 【画：信用证信息.Combined LC信息.drawn amount#2-#5.金额】输入值变化时处理
//	$("#drawnAmt1,#drawnAmt2,#drawnAmt3,#drawnAmt4,#drawnAmt5").change(function(){
//		changeDrawnAmt();
//	});
	
	//【画：新建.受益人.客户CIF】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/beneCif']").change(function(){
		changeBeneCif();
	});
	
	//【画：新建.受益人账户】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/beneAcctCcy']").change(function(){
		changeBeneAcct();
	});
	$("[name='data/BcMntnOpDtlVO/beneAcctGl']").change(function(){
		changeBeneAcct();
	});
	$("[name='data/BcMntnOpDtlVO/beneAcctSubGl']").change(function(){
		changeBeneAcct();
	});
	$("[name='data/BcMntnOpDtlVO/beneAcctNo']").change(function(){
		changeBeneAcct();
	});
	
	//【画：信用证信息.开证行.行号】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']").change(function(){
		changeIssueBankCode();
	});	
	
	//【画：信用证信息.寄单行.行号】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/dispchDocBankCode']").change(function(){
		changeLcDispchDocBankCode();
	});
	
	//【画：信用证信息.偿付行.行号】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/reimbBankCode']").change(function(){
		changeReimbBankCode();
	});
	
	//【画：非信用证信息.寄单行.行号】输入值变化时处理
	$("[name='data/BcMntnOpDtlVO/dispchDocBankCode']").change(function(){
		changeComLcDispchDocBankCode();
	});

	// 控件实现	
//【画：信用证信息.第一受益人账户】，【画：单据信息.清算行账户】，【画：费用信息.手续费账户】输入值变化时处理
//	$("#bene1stAcctCcy").change(function(){
//		changeBene1stAcct();
//		});	
//	$("#bene1stAcctGl").change(function(){
//		changeBene1stAcct();
//		});	
//	$("#bene1stAcctSubGl").change(function(){
//		changeBene1stAcct();
//		});	
//	$("#bene1stAcctNo").change(function(){
//		changeBene1stAcct();
//		});	
//	$("#bcMntnOpDtlVOclrBankAcctCcy").change(function(){
//		changeNoBookClrBankAcct();
//	});	
//	$("#bcMntnOpDtlVOclrBankAcctGL").change(function(){
//		changeNoBookClrBankAcct();
//	});	
//	$("#bcMntnOpDtlVOclrBankAcctSubGL").change(function(){
//		changeNoBookClrBankAcct();
//	});	
//	$("#bcMntnOpDtlVOclrBankAcctNo").change(function(){
//		changeNoBookClrBankAcct();
//	});	
	$("#bcInfoVOfeeAcctCcy").change(function(){
//		changeNoBookFeeAcct();
		changeFeeAcctCcy();
	});	
//	$("#bcInfoVOfeeAcctGL").change(function(){
//		changeNoBookFeeAcct();
//	});	
//	$("#bcInfoVOfeeAcctSubGL").change(function(){
//		changeNoBookFeeAcct();
//	});	
//	$("#bcInfoVOfeeAcctNo").change(function(){
//		changeNoBookFeeAcct();
//	});	
		
	//点击【画：信用证信息.信用证编号.检索】按钮时处理逻辑	
	$("#search1").click(function(){
		clickLcNoSelect();
	});		
	
	//【画：入账.进待核查】勾选时处理 
	$("[name='data/BcBookOpDtlVO/validatnFlg']").click(function(){
		checkedValidatnFlg();
	});	
	
	//点击【画：信用证信息.Combined LC信息.信用证编号#2.检索】按钮时处理逻辑
	$("#lcSearch2").click(function(){
		clickCombinedLCSelect("1");
	});
	//点击【画：信用证信息.Combined LC信息.信用证编号#3.检索】按钮时处理逻辑
	$("#lcSearch3").click(function(){
		clickCombinedLCSelect("2");
	});
	//点击【画：信用证信息.Combined LC信息.信用证编号#4.检索】按钮时处理逻辑
	$("#lcSearch4").click(function(){
		clickCombinedLCSelect("3");
	});
	//点击【画：信用证信息.Combined LC信息.信用证编号#5.检索】按钮时处理逻辑
	$("#lcSearch5").click(function(){
		clickCombinedLCSelect("4");
	});
	
	// 点击【画：信用证信息.转让编号.检索】按钮时处理逻辑   
	$("#btn_scan").click(function(){
		clickTrasfNo();
	});
	
	//点击【画：入账.定价】,打开定价共通popup画面，或打开脱绑一览
	$("#btn_price_costinfo").click(function(){
		onClickBtnPricing();
	});
		
});
/**
*方法说明：【画：新建.信用证项下】选择值变化时处理	
*返回值:
*    无
*参数：
*    无
*/

function changeLcFlg(){
	//新建.信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val();
	//非信用证信息板块
	var nonLcInfo = $("#nonLcInfo");
	//信用证信息板块
	var LcInfo = $("#LcInfo");
	if(lcFlg == "Y"){
		//1）当【画：新建.信用证项下】为‘Y’时
		//1.1）清空【画：非信用证信息】板块的项目值，并隐藏该板块
		$(":text","#nonLcInfo").val("");
		$(":radio","#nonLcInfo").prop("checked",false);
		$("[name='data/BcMntnOpDtlVO/imptrNatnlty']").val("");
		nonLcInfo.hide();
		//1.2）显示【画：信用证信息】板块，把信用证版块中除信用证编号以外的项目都设为不可编辑，【画：信用证信息.Combined LC信息】和【画：信用证信息.转让信息】表格不显示
		LcInfo.show();
		$(":text,textarea,select,:checkbox,:radio",LcInfo).setReadOnly(true);
		$("[name='data/BcMntnOpDtlVO/lcNo']").setReadOnly(false);
		$("#bbCombLcNo").hide();
		$("#trasfTable").hide();
		//【画：信用证信息.信用证编号.检索】显示且可点击
		$("#search1").show();
		$("#search1").prop("disabled",false);
		//1.3）将【画：新建.TSU】的值设为：N(不勾选)，设为不可编辑
		$("[name='data/BcMntnOpDtlVO/tsuFlg']").prop("checked",false);
		$("[name='data/BcMntnOpDtlVO/tsuFlg']").setReadOnly(true);
		//1.4）【画：新建.BPO】设为可编辑	
		$("[name='data/BcMntnOpDtlVO/bpoFlg']").setReadOnly(false);
		//1.5）将【画：单据信息.拒绝证明】的值设为：‘请选择’
		$("[name='data/BcMntnOpDtlVO/refuseCertfct']").val("");
		//1.6）将【画：单据信息.BC记账科目.GL】的值设为：‘470’；【画：单据信息.BC记账科目.SUB GL】的值设为：‘1000’
		$("[name='data/BcMntnOpDtlVO/bcBookAcctGl']").val("470");
		$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val("1000");
		//1.7）清空【画：单据信息.国别】的值
		$("[name='data/BcMntnOpDtlVO/natnlty']").val("");
	}else if(lcFlg == "N"){
		//2）当【画：新建.信用证项下】为‘N’时
		//2.1）清空【画：信用证信息】板块的项目值，并隐藏该板块
		$(":text","#LcInfo").val("");
		$(":checkbox,:radio","#LcInfo").prop("checked",false);
		$("select","#LcInfo").val("");
		LcInfo.hide();
		//2.2）显示【画：非信用证信息】板块
		nonLcInfo.show();
		//2.3）将【画：新建.BPO】的值设为：N(不勾选)，设为不可编辑	
		$("[name='data/BcMntnOpDtlVO/bpoFlg']").prop("checked",false);
		$("[name='data/BcMntnOpDtlVO/bpoFlg']").setReadOnly(true);
		//2.4）【画：新建.TSU】设为可编辑
		$("[name='data/BcMntnOpDtlVO/tsuFlg']").setReadOnly(false);
		//2.5）将【画：单据信息.拒绝证明】的值设为：‘4：Waived’
		$("[name='data/BcMntnOpDtlVO/refuseCertfct']").val("4");
		//2.6）将【画：单据信息.BC记账科目.GL】的值设为：‘470’；【画：单据信息.BC记账科目.SUB GL】的值设为：‘2000’
		$("[name='data/BcMntnOpDtlVO/bcBookAcctGl']").val("470");
		$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val("2000");
		//2.7）清空【画：单据信息.国别】，【Hidden：信用证编号】，【Hidden：转让编号】的值
		$("[name='data/BcMntnOpDtlVO/natnlty']").val("");
		$("[name='data/BcMntnOpDtlVO/tmpLcNo']").val("");
		$("[name='data/BcMntnOpDtlVO/tmpTrasfNo']").val("");
	}
}

/**
*方法说明：【画；新建.BPO】勾选时处理	
*返回值:
*    无
*参数：
*    无
*/

function checkedBpoFlg(){
	var bpoFlg = $("[name='data/BcMntnOpDtlVO/bpoFlg']");
	if(bpoFlg.prop("checked") == true){
		//1）当【画；新建.BPO】勾选时，将【画：单据信息.BC记账科目. SUB GL】的值设为：‘3000’	
		$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val("3000");
	}else {
		//2）当【画；新建.BPO】不勾选时，将【画：单据信息.BC记账科目. SUB GL】的值设为：‘1000’
		$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val("1000");
	}
}

/**
*方法说明：【画；新建.TSU】勾选时处理	
*返回值:
*    无
*参数：
*    无
*/

function checkedTsuFlg(){			
	//【画；新建.TSU】
	var tsuFlg = $("[name='data/BcMntnOpDtlVO/tsuFlg']");
	if (tsuFlg.prop("checked") == true){
		//2.3.1）当【画；新建.TSU】勾选时，将【画：单据信息.BC记账科目. SUB GL】的值设为：‘3000’
		$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val("3000");
	}else {
		//2.3.2）当【画；新建.TSU】不勾选时，将【画：单据信息.BC记账科目. SUB GL】的值设为：‘2000’	
		$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val("2000");
	}
}

/**
*方法说明：【画：新建.P.P. NEGO】勾选时处理
*返回值:
*    无
*参数：
*    无
*/

function checkedPpnegoFlg(){	
	//新建.P.P. NEGO
	var ppnegoFlg = $("[name='data/BcMntnOpDtlVO/ppnegoFlg']");
	//新建.电报议付
	var telegNegoFlg = $("[name='data/BcMntnOpDtlVO/telegNegoFlg']");
	//新建.备注
	var newRmrk = $("[name='data/BcMntnOpDtlVO/newRmrk']");
	//新建.电报议付销号日期
	var telegNegoClsDate = $("[name='data/BcMntnOpDtlVO/telegNegoClsDate']");
	if (ppnegoFlg.prop("checked") == true){
		//1）当【画：新建.P.P. NEGO】勾选时，【画：新建.电报议付】，【画：新建.备注】设为可编辑；清空【画：新建.电报议付销号日期】的值，设为不可编辑
		telegNegoFlg.setReadOnly(false);
		newRmrk.setReadOnly(false);
		telegNegoClsDate.val("");
		telegNegoClsDate.setReadOnly(true);
	}else {
		//2）当【画：新建.P.P. NEGO】不勾选时，清空【画：新建.电报议付】，【画：新建.电报议付销号日期】，【画：新建.备注】的值，设为不可编辑
		telegNegoFlg.prop("checked",false);
		newRmrk.val("");
		telegNegoClsDate.val("");
		telegNegoFlg.setReadOnly(true);
		newRmrk.setReadOnly(true);
		telegNegoClsDate.setReadOnly(true);
	}
}

/**
*方法说明：【画：新建.电报议付】选择值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeTelegNegoFlg(){
	//新建.电报议付
	var telegNegoFlg = $(":radio[name='data/BcMntnOpDtlVO/telegNegoFlg']:checked");
	//新建.电报议付销号日期
	var telegNegoClsDate = $("[name='data/BcMntnOpDtlVO/telegNegoClsDate']");
	if (telegNegoFlg.val() == "Y"){
		//1）当【画：新建.电报议付】为‘Y’时，【画：新建.电报议付销号日期】设为可编辑
		telegNegoClsDate.setReadOnly(false);
	}else {
		//2）当【画：新建.电报议付】为‘N’时，清空【画：新建.电报议付销号日期】的值，设为不可编辑
		telegNegoClsDate.val("");
		telegNegoClsDate.setReadOnly(true);
	}
}

/**
*方法说明：【画：新建.汇票金额.币种】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeBxCcy(){
	//新建.汇票金额.币种
	var bxCcy = $("[name='data/BcMntnOpDtlVO/bxCcy']");
	//单据信息.清算行账户.币种
	var clrBankAcctCcy = $("[name='data/BcMntnOpDtlVO/clrBankAcctCcy']");
	//信用证信息.Combined LC
	var combinedLcFlg = $(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked");
	//信用证信息.转让第二受益人
	var trasf2ndBene = $(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked");
	//信用证信息.转让金额.币种
	var trasfAmtCcy = $("[name='data/BcMntnOpDtlVO/trasfAmtCcy']");
		//新建.汇票金额.币种变化时
		//1）将【画：单据信息.清算行账户.币种】的值设为：【新建.汇票金额.币种】
		clrBankAcctCcy.val(bxCcy.val());
		if (combinedLcFlg.val() == "Y"){
		//2）当【画：信用证信息.Combined LC】为‘Y’时，将以下项目的值设为：【新建.汇票金额.币种】
		//【画：信用证信息.Combined LC信息.信用证金额#1-#5.币种】
		//【画：信用证信息.Combined LC信息.信用证余额#1-#5.币种】
		//【画：信用证信息.Combined LC信息.drawn amount#1-#5.币种】
			$("#lcCcy1").val(bxCcy.val());
			$("#lcCcy2").val(bxCcy.val());
			$("#lcCcy3").val(bxCcy.val());
			$("#lcCcy4").val(bxCcy.val());
			$("#lcCcy5").val(bxCcy.val());
			$("#drawnCcy1").val(bxCcy.val());
			$("#drawnCcy2").val(bxCcy.val());
			$("#drawnCcy3").val(bxCcy.val());
			$("#drawnCcy4").val(bxCcy.val());
			$("#drawnCcy5").val(bxCcy.val());
			$("#lcBalCcy1").val(bxCcy.val());
			$("#lcBalCcy2").val(bxCcy.val());
			$("#lcBalCcy3").val(bxCcy.val());
			$("#lcBalCcy4").val(bxCcy.val());
			$("#lcBalCcy5").val(bxCcy.val());
		}
		if (trasf2ndBene.val() == "Y"){
			//1.3）当【画：信用证信息.转让第二受益人】为‘Y’时，将【画：信用证信息.转让金额.币种】的值设为：【新建.汇票金额.币种】
			trasfAmtCcy.val(bxCcy.val());
		}
}
/**
*方法说明：【画：新建.Tenor.种类】选择值变化时处理	
*返回值:
*    无
*参数：
*    无
*/

function changeTenorType(){
	//新建.Tenor.种类
	var tenorType = $("[name='data/BcMntnOpDtlVO/tenorType']");
	//新建.Tenor.天数
	var tenorDays = $("[name='data/BcMntnOpDtlVO/tenorDays']");
	//新建.Tenor.日期
	var tenorDate = $("[name='data/BcMntnOpDtlVO/tenorDate']");
	if (tenorType.val() == "" || tenorType.val() == "△"){
		//1）当【画：新建.Tenor.种类】为‘请选择’或‘空： at sight’时，清空【画：新建.Tenor.天数】，【画：新建.Tenor.日期】的值，设为不可编辑
		tenorDays.val("");
		tenorDate.val("");
		tenorDays.setReadOnly(true);
		tenorDate.setReadOnly(true);
	}
	if (tenorType.val() == "A" || tenorType.val() == "B"){
		//2）当【画：新建.Tenor.种类】为‘A： after sight’或‘B： after B/L date’时，清空【画：新建.Tenor.天数】，
		//		【画：新建.Tenor.日期】的值，【画：新建.Tenor.天数】设为可编辑，【画：新建.Tenor.日期】设为不可编辑
		tenorDays.val("");
		tenorDate.val("");
		tenorDays.setReadOnly(false);
		tenorDate.setReadOnly(true);
	}
	if (tenorType.val() == "O"){
		//3）当【画：新建.Tenor.种类】为‘O： others’时，清空【画：新建.Tenor.天数】，【画：新建.Tenor.日期】的值，设为可编辑
		tenorDays.val("");
		tenorDate.val("");
		tenorDays.setReadOnly(false);
		tenorDate.setReadOnly(false);
	}
}

/**
*方法说明：【画：新建.假远期】，【画：新建.Tenor.种类】，【画：新建.Tenor.天数】，【画：新建.托收日期】，【画：新建.提单日期】输入值变化时处理（OnChange处理）	
*返回值:
*    无
*参数：
*    无
*/

function changeFakeForwdFlg(){
  var days = 0;
  //新建.假远期
	var fakeForwdFlg = $(":radio[name='data/BcMntnOpDtlVO/fakeForwdFlg']:checked");
	//新建.托收日期
	var collDate = $("[name='data/BcMntnOpDtlVO/collDate']");
	//新建.到期日期
	var dueDate = $("[name='data/BcMntnOpDtlVO/dueDate']");
	//新建.Tenor.种类
	var tenorType = $("[name='data/BcMntnOpDtlVO/tenorType']");
	//新建.Tenor.天数
	var tenorDays = $("[name='data/BcMntnOpDtlVO/tenorDays']");
	//新建.提单日期
	var blDate = $("[name='data/BcMntnOpDtlVO/blDate']");

	if (fakeForwdFlg.val() == "Y"){
		//2.10.1）当【画：新建.假远期】为‘Y’时     
		if ($.trim(collDate.val()) == ""){
			//1- 当【画：新建.托收日期】为空时，清空【画：新建.到期日期】的值
			dueDate.val("");
		}else {
			//2- 当【画：新建.托收日期】不为空时，【画：新建.到期日期】 = 【画：新建.托收日期】 + 20天(自然日) 			
			jsonStr = {"functionName":"getBizEndDate", "startDate":collDate.val(), "days":"20"};
			commAjaxPost(jsonStr, function(data){
					if(!$.isEmptyObject(data)){
						dueDate.val(data);
					}
			});			
		}
	}else if (fakeForwdFlg.val() == "N"){
		//2.10.2）当【画：新建.假远期】为‘N’时
		if (tenorType.val() == ""){
			//1- 当【画：新建.Tenor.种类】为‘请选择’时，清空【画：新建.到期日期】的值
			dueDate.val("");
		}else if (tenorType.val() == "△"){
			//a- 当【画：新建.Tenor.种类】为‘空： at sight’时：
			if ($.trim(collDate.val()) == ""){
				//当【画：新建.托收日期】为空时，清空【画：新建.到期日期】
			dueDate.val("");
			}else {
				//当【画：新建.托收日期】不为空时，【画：新建.到期日期】 = 【画：新建.托收日期】 + 20天（自然日）
				jsonStr = {"functionName":"getBizEndDate", "startDate":collDate.val(), "days":"20"};
				commAjaxPost(jsonStr, function(data){
					if(!$.isEmptyObject(data)){
						dueDate.val(data);
					}
			});	
			}
		}else if (tenorType.val() == "A"){
			//b- 当【画：新建.Tenor.种类】为‘A： after sight’时：
			if ($.trim(collDate.val()) == ""){
				//当【画：新建.托收日期】为空时，清空【画：新建.到期日期】
				dueDate.val("");
			}else {
				//当【画：新建.托收日期】不为空时，【画：新建.到期日期】 = 【画：新建.Tenor.天数】 + 20天（自然日） + 【画：新建.托收日期】
				//※【画：新建.Tenor.天数】为空时，默认用0来计算
				if("" != $.trim(tenorDays.val())){
					days = $.trim(tenorDays.val())*1+ 20*1;
				}else{
					days = 20*1;
				}
				jsonStr = {"functionName":"getBizEndDate", "startDate":collDate.val(), "days":days.toString()};
				commAjaxPost(jsonStr, function(data){
					if(!$.isEmptyObject(data)){
						dueDate.val(data);
					}
			});	
			}
		}else if (tenorType.val() == "B"){
			//c- 当【画：新建.Tenor.种类】为‘B： after B/L date’时：
			if ($.trim(blDate.val()) == ""){
				//当【画：新建.提单日期】为空时，清空【画：新建.到期日期】
				dueDate.val("");
			}else {
				//当【当【画：新建.提单日期】不为空时，【画：新建.到期日期】 = 【画：新建.Tenor.天数】 + 【画：新建.提单日期】
				//※【画：新建.Tenor.天数】为空时，默认用0来计算
				if("" != $.trim(tenorDays.val())){
					days = $.trim(tenorDays.val())*1;
				}
				jsonStr = {"functionName":"getBizEndDate", "startDate":blDate.val(), "days":days.toString()};
				commAjaxPost(jsonStr, function(data){
					if(!$.isEmptyObject(data)){
						dueDate.val(data);
					}
				});				
			}
		}else if (tenorType.val() == "O"){
			//d- 当【画：新建.Tenor.种类】为‘O： others’时，清空【画：新建.到期日期】
			dueDate.val("");
		}
	}
	//2.10.3）调用2.12）【画：新建.到期日期】输入值变化时处理
	changeDueDate();
}

/**
*方法说明：【画：新建.发票编号】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeIvcNo(){							
	//新建.发票编号
	var ivcNo = $("[name='data/BcMntnOpDtlVO/ivcNo']");
	//单据信息.发票编号
	var docIvcNo = $("[name='data/BcMntnOpDtlVO/docIvcNo']");
	//新建.发票编号前16位数据
	var ivcNo2 = ivcNo.val().substring(0,16);
		//2.11.1）将【画：单据信息.发票编号】的值设为：【画：新建.发票编号】的前16位
		//※不足16位时，直接将【画：单据信息.发票编号】的值设为：【画：新建.发票编号】
		docIvcNo.val(ivcNo2);
}

/**
*方法说明：【画：新建.到期日期】输入值变化时处理	
*返回值:
*    无
*参数：
*    无
*/

function changeDueDate(){			
	//新建.到期日期
	var dueDate = $("[name='data/BcMntnOpDtlVO/dueDate']");
	//新建.最终到期日
	var finalDueDate = $("[name='data/BcMntnOpDtlVO/finalDueDate']");
	//将【画：新建.最终到期日】的值设为：【画：新建.到期日期】
	finalDueDate.val(dueDate.val());		
}

/**
*方法说明：【画：信用证信息.信用证金额.币种】输入值变化时处理	
*返回值:
*    无
*参数：
*    无
*/

function changeLcAmtCcy(){				
	//信用证信息.信用证金额.币种
	var lcAmtCcy = $("#lcAmtCcy");
	//信用证信息.信用证余额.币种
	var explcBalCcy = $("#explcBalCcy");
	//将【画：信用证信息.信用证余额.币种】的值设为：【画：信用证信息.信用证金额.币种】
	explcBalCcy.val(lcAmtCcy.val());		
}

/**
*方法说明：【画：信用证信息.信用证金额.金额】或【画：信用证信息.信用证余额.金额】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeLcAmt(){
	//信用证信息.Combined LC
	var combinedLcFlg = $(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked");
	//信用证信息.信用证金额.金额
	var expLcAmt = $("#expLcAmt");
	//信用证信息.信用证余额.金额
	var expLcBalAmt = $("#expLcBalAmt");
	//信用证信息.Combined LC信息.信用证金额#1.金额
	var lcAmt1 = $("#lcAmt1");
	//信用证信息.Combined LC信息.信用证余额#1.金额
	var lcBalAmt1 = $("#lcBalAmt1");
	if (combinedLcFlg.val() == "Y"){
		//2.15.1）当【画：信用证信息.Combined LC】为‘Y’时
		//将【画：信用证信息.Combined LC信息.信用证金额#1.金额】的值设为：【画：信用证信息.信用证金额.金额】
		lcAmt1.val(expLcAmt.val());			
		//将【画：信用证信息.Combined LC信息.信用证余额#1.金额】的值设为：【画：信用证信息.信用证余额.金额】
		lcBalAmt1.val(expLcBalAmt.val());			
	}
}

/**
*方法说明：【画：信用证信息.第二受益人】选择值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeBene2ndFlg(){									
	//信用证信息.第二受益人
	var bene2ndFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked");
	//信用证信息.中转行
	var trastBank = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']");
	//信用证信息.中转行国别
	var trastBankNatnlty = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']");
	if (bene2ndFlg.val() =="Y"){
		//2.17.1）当【画：信用证信息.第二受益人】为‘Y’时，【画：信用证信息.中转行】，【画：信用证信息.中转行国别】设为可编辑
		trastBank.setReadOnly(false);
		trastBankNatnlty.setReadOnly(false);
	}else {
		//2.17.2）当【画：信用证信息.第二受益人】为‘N’时，清空【画：信用证信息.中转行】，【画：信用证信息.中转行国别】的值，设为不可编辑
		trastBank.val("");
		trastBankNatnlty.val("");
		trastBank.setReadOnly(true);
		trastBankNatnlty.setReadOnly(true);
	}
}

/**
*方法说明：【画：信用证信息.进口商国别】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeImptrNatnlty(){
	//信用证信息.进口商国别
	var imptrNatnlty = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']");
	//单据信息.国别
	var natnlty = $("[name='data/BcMntnOpDtlVO/natnlty']");
	//2.18.1）将【画：单据信息.国别】的值设为：【画：信用证信息.进口商国别】
	natnlty.val(imptrNatnlty.val());		
}

/**
*方法说明：【画：信用证信息.寄单行同开证行】选择值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeDispchBankEqIssueFlg(){
	//信用证信息.寄单行同开证行
	var dispchBankEqIssueFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked");
	//信用证信息.寄单行.行号
	var dispchDocBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']");
	//信用证信息.开证行.Swift
	var dispchDocBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']");
	//信用证信息.开证行.名称
	var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']");
	//信用证信息.开证行.地址
	var dispchDocBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']");
	//信用证信息.开证行.行号
	var issueBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']");
	//信用证信息.开证行.Swift
	var issueBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']");
	//信用证信息.开证行.名称
	var issueBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']");
	//信用证信息.开证行.地址
	var issueBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']");
	if (dispchBankEqIssueFlg.val() == "Y"){
		//2.19.1）当【画：信用证信息.寄单行同开证行】为‘Y’时,【画：信用证信息.寄单行】整行设为不可编辑，将值设为：【画：信用证信息.开证行】整行
		dispchDocBankCode.setReadOnly(true) ;
		dispchDocBankSwift.setReadOnly(true) ;
		dispchDocBankName.setReadOnly(true) ;
		dispchDocBankAddr.setReadOnly(true) ;
		dispchDocBankCode.val(issueBankCode.val());
		dispchDocBankSwift.val(issueBankSwift.val());
		dispchDocBankName.val(issueBankName.val());
		dispchDocBankAddr.val(issueBankAddr.val());
	}else {
		//2.19.2）当【画：信用证信息.寄单行同开证行】为‘N’时，清空【画：信用证信息.寄单行】整行的值，设为可编辑
		dispchDocBankCode.setReadOnly(false) ;
		dispchDocBankSwift.setReadOnly(false) ;
		dispchDocBankName.setReadOnly(false) ;
		dispchDocBankAddr.setReadOnly(false) ;
		dispchDocBankCode.val("");
		dispchDocBankSwift.val("");
		dispchDocBankName.val("");
		dispchDocBankAddr.val("");
	}
}

/**
*方法说明：【画：信用证信息.有偿付行】选择值变化时处理
*返回值:
*    无
*参数：
*    无
*/

function changeWithReimbsBankFlg(){
	//信用证信息.有偿付行			
	var withReimbsBankFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked");	
	//信用证信息.允许电报偿付
	var allowTelegReimbsFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']");
	//信用证信息.偿付行.行号
	var reimbBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']");
	//信用证信息.偿付行.Swift
	var reimbBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']");
	//信用证信息.偿付行.名称
	var reimbBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']");
	//信用证信息.偿付行.地址
	var reimbBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']");
	
	if (withReimbsBankFlg.val() == "Y"){
		//2.20.1）当【画：信用证信息.有偿付行】为‘Y’时
		//1- 将【画：信用证信息.允许电报偿付】的值设为：N,设为可编辑
		$(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg'][value=N]").prop("checked",true);
		allowTelegReimbsFlg.setReadOnly(false);
		//2- 将【画：信用证信息.偿付行】整行设为可编辑
		reimbBankCode.setReadOnly(false) ;
		reimbBankSwift.setReadOnly(false) ;
		reimbBankName.setReadOnly(false) ;
		reimbBankAddr.setReadOnly(false) ;
	}else {
		//2.20.2）当【画：信用证信息.有偿付行】为‘N’时						
		//1- 将【画：信用证信息.允许电报偿付】的值设为：N，设为不可编辑
		$(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg'][value=N]").prop("checked",true);
		allowTelegReimbsFlg.setReadOnly(true);
		//2- 清空【画：信用证信息.偿付行】整行的值，设为不可编辑
		reimbBankCode.setReadOnly(true) ;
		reimbBankSwift.setReadOnly(true) ;
		reimbBankName.setReadOnly(true) ;
		reimbBankAddr.setReadOnly(true) ;
		reimbBankCode.val("");
		reimbBankSwift.val("");
		reimbBankName.val("");
		reimbBankAddr.val("");
	}
	
}

/**
*方法说明：
【画：信用证信息.开证行.Swift】输入值变化时处理			
	当【画：信用证信息.寄单行同开证行】为‘Y’时：		
		【画：信用证信息.开证行.Swift】不为空时，将【画：信用证信息.寄单行.Swift】的值设为：【画：信用证信息.开证行.Swift】
		【画：信用证信息.开证行.Swift】为空时，清空【画：信用证信息.寄单行.Swift】的值
*返回值:
*    无
*参数：
*    无
*/
function changeIssueBankSwift(){
	//【画：信用证信息.开证行.Swift】
	var issueBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']");
	//【画：信用证信息.寄单行.Swift】
	var dispchDocBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']");
	//【画：信用证信息.寄单行同开证行】
	var dispchBankEqIssueFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked");
	//当【画：信用证信息.寄单行同开证行】为‘Y’时：
	if("Y"==$.trim(dispchBankEqIssueFlg.val())){
		//将【画：信用证信息.寄单行.Swift】的值设为：【画：信用证信息.开证行.Swift】
			dispchDocBankSwift.val($.trim(issueBankSwift.val()));
	}
}

/**
*方法说明：
【画：信用证信息.开证行.名称】输入值变化时处理		
	1）当【画：信用证信息.寄单行同开证行】为‘Y’时：	
		1.1）【画：信用证信息.开证行.名称】不为空时，将【画：信用证信息.寄单行.名称】的值设为：【画：信用证信息.开证行.名称】
		1.2）【画：信用证信息.开证行.名称】为空时，清空【画：信用证信息.寄单行.名称】的值
*返回值:
*    无
*参数：
*    无
*/
function changeIssueBankName(){
	//【画：信用证信息.开证行.名称】
	var issueBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']");
	//【画：信用证信息.寄单行.名称】
	var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']");
	//【画：信用证信息.寄单行同开证行】
	var dispchBankEqIssueFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked");
	//当【画：信用证信息.寄单行同开证行】为‘Y’时：
	if("Y"==$.trim(dispchBankEqIssueFlg.val())){
		//将【画：信用证信息.寄单行.名称】的值设为：【画：信用证信息.开证行.名称】
		dispchDocBankName.val($.trim(issueBankName.val()));
	}
}

/**
*方法说明：
【画：信用证信息.开证行.地址】输入值变化时处理		
	1）当【画：信用证信息.寄单行同开证行】为‘Y’时：	
		1.1）【画：信用证信息.开证行.地址】不为空时，将【画：信用证信息.寄单行.地址】的值设为：【画：信用证信息.开证行.地址】
		1.2）【画：信用证信息.开证行.地址】为空时，清空【画：信用证信息.寄单行.地址】的值
*返回值:
*    无
*参数：
*    无
*/
function changeIssueBankAddr(){
	//【画：信用证信息.开证行.地址】
	var issueBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']");
	//【画：信用证信息.寄单行.地址】
	var dispchDocBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']");
	//【画：信用证信息.寄单行同开证行】
	var dispchBankEqIssueFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked");
	//当【画：信用证信息.寄单行同开证行】为‘Y’时：
	if("Y"==$.trim(dispchBankEqIssueFlg.val())){
		//将【画：信用证信息.寄单行.地址】的值设为：【画：信用证信息.开证行.地址】
			dispchDocBankAddr.val($.trim(issueBankAddr.val()));
	}
}

/**
*方法说明：
【画：信用证信息.留行信用证】选择值变化时处理	
	1）当【画：信用证信息.留行信用证】勾选时，将【画：信用证信息.留行日期】设为可编辑，值设为系统日期
	2）当【画：信用证信息.留行信用证】不勾选时，清空【画：信用证信息.留行日期】的值，设为不可编辑
*返回值:
*    无
*参数：
*    无
*/
function changeKibLcFlg(){
	//【画：信用证信息.留行信用证】
	var kibLcFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']");
	//【画：信用证信息.留行日期】
	var kibLcDate = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']");
	//当【画：信用证信息.留行信用证】勾选时
	if(kibLcFlg.prop("checked")){
		//将【画：信用证信息.留行日期】设为可编辑
		kibLcDate.setReadOnly(false);
		//，值设为系统日期
		kibLcDate.val(getCommonSysDate());
		//当【画：信用证信息.留行信用证】不勾选时
	}else{
		//清空【画：信用证信息.留行日期】的值
		kibLcDate.val("");
		//设为不可编辑
		kibLcDate.setReadOnly(true);
	}
}

/**
*方法说明：
当【画：信用证信息.Combined LC】为‘Y’时，显示【画：Combined LC信息】表格					
		1- 设置【画：Combined LC信息】表格的初始值和可编辑
				将【画：信用证信息.Combined LC信息.信用证编号#1】的值设为：【画：信用证信息.信用证编号】，设为不可编辑	
				将【画：信用证信息.Combined LC信息.信用证金额#1.金额】的值设为：【画：信用证信息.信用证金额.金额】，设为不可编辑	
				将【画：信用证信息.Combined LC信息.信用证余额#1.金额】的值设为：【画：信用证信息.信用证余额.金额】，设为不可编辑	
				将5行的【画：信用证信息.Combined LC信息.信用证金额.币种】的值均设为：【画：新建.汇票金额.币种】，设为不可编辑	
				将5行的【画：信用证信息.Combined LC信息.信用证余额.币种】的值均设为：【画：新建.汇票金额.币种】，设为不可编辑	
				将5行的【画：信用证信息.Combined LC信息.drawn amount.币种】的值均设为：【画：新建.汇票金额.币种】，设为不可编辑	
				【画：信用证信息.Combined LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined LC信息.信用证编号#2-#5.删除】显示且可点击	
当【画：信用证信息.Combined LC】为‘N’时，清空【画：Combined LC信息】表格的值，设为不显示
*返回值:
*    无
*参数：
*    无
*/
function changeCombinedLcFlg(){
	//【画：信用证信息.Combined LC】
	var combinedLcFlg = $("[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked");
	//【画：Combined LC信息】表格
	var bbCombLcNo = $("#bbCombLcNo");
	//【画：信用证信息.信用证编号】
	var lcNo = $("[name='data/BcMntnOpDtlVO/lcNo']");
	//【画：信用证信息.信用证金额.金额】
	var expLcAmt = $("#expLcAmt");
	//【画：信用证信息.信用证余额.金额】
	var expLcBalAmt = $("#expLcBalAmt");
	//【画：新建.汇票金额.币种】
	var bxCcy = $("#bxCcy");
	//【画：信用证信息.留行信用证】
	var kibLcFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']");
	//【画：信用证信息.留行信用证】
	var kibLcFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']");
	//【画：信用证信息.留行信用证】
	var kibLcFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']");
	if("Y" == $.trim(combinedLcFlg.val())){
	 	bbCombLcNo.show();
		$("#bbCombLcNo>table>tbody>tr:visible").each(function (i, o) {
			var thizTr = $(this);
			var index = i;
			//【画：信用证信息.Combined LC信息.信用证编号】
			var ComblcNo = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcNo']",thizTr);
			//【画：信用证信息.Combined LC信息.信用证金额.币种】
			var lcCcy = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcCcy']",thizTr);
			//【画：信用证信息.Combined LC信息.信用证金额.金额】
			var lcAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcAmt']",thizTr);
			//【画：信用证信息.Combined LC信息.drawn amount.币种】
			var drawnCcy = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/drawnCcy']",thizTr);
			//【画：信用证信息.Combined LC信息.drawn amount.金额】
			var drawnAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/drawnAmt']",thizTr);
			//【画：信用证信息.Combined LC信息.信用证金额.币种】
			var lcBalCcy = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcBalCcy']",thizTr);
			//【画：信用证信息.Combined LC信息.信用证金额.金额】
			var lcBalAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcBalAmt']",thizTr);
			if("1" == index){
				//【画：信用证信息.Combined LC信息.信用证编号#1】的值设为：【画：信用证信息.信用证编号】
				ComblcNo.val($.trim(lcNo.val()));
				//，设为不可编辑	
				ComblcNo.setReadOnly(true);
				//将【画：信用证信息.Combined LC信息.信用证金额#1.金额】的值设为：【画：信用证信息.信用证金额.金额】
				lcAmt.val($.trim(expLcAmt.val()));
				//，设为不可编辑	
				lcAmt.setReadOnly(true);
				//将【画：信用证信息.Combined LC信息.信用证余额#1.金额】的值设为：【画：信用证信息.信用证余额.金额】
				lcBalAmt.val($.trim(expLcBalAmt.val()));
				//，设为不可编辑	
				lcBalAmt.setReadOnly(true);
			}
			//【币种】的值均设为：【画：新建.汇票金额.币种】，设为不可编辑
			lcCcy.val($.trim(bxCcy.val()));
			drawnCcy.val($.trim(bxCcy.val()));
			lcBalCcy.val($.trim(bxCcy.val()));
			lcCcy.setReadOnly(true);
			drawnCcy.setReadOnly(true);
			lcBalCcy.setReadOnly(true);
			
					});
			// 【画：信用证信息.Combined LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined LC信息.信用证编号#2-#5.删除】显示且可点击	
			$("#lcSearch2").prop("disabled",false);
			$("#lcSearch2").show();
			$("#lcSearch3").prop("disabled",false);
			$("#lcSearch3").show();
			$("#lcSearch4").prop("disabled",false);
			$("#lcSearch4").show();
			$("#lcSearch5").prop("disabled",false);
			$("#lcSearch5").show();

			$("#lcDel2").prop("disabled",false);
			$("#lcDel2").show();
			$("#lcDel3").prop("disabled",false); 
			$("#lcDel3").show();
			$("#lcDel4").prop("disabled",false);
			$("#lcDel4").show();
			$("#lcDel5").prop("disabled",false);
			$("#lcDel5").show();
	}else if("N" == $.trim(combinedLcFlg.val())){
		$("#bbCombLcNo>table>tbody>tr:visible").each(function (i, o) {
			var thizTr = $(this);
			var index = i;
			//清空【画：Combined LC信息】表格的值
			$(":text,textarea","#bbCombLcNo").val("");
			$("select","#bbCombLcNo").val("");
			});
			//，设为不显示
			bbCombLcNo.hide();
	}
}

/**
*方法说明：
当【画：信用证信息.转让第二受益人】为‘Y’时		
		1- 显示【画：信用证信息.转让信息】表格
		2- 将【画：信用证信息.第一受益人账户】的值设为：【画：新建.受益人账户】
		3- 将【画：信用证信息.转让金额.币种】的值设为：【画：新建.汇票金额.币种】
		4- 将【画：信用证信息.转让金额.金额】的值设为：0
			【画：信用证信息.转让编号.检索】显示且可点击
当【画：信用证信息.转让第二受益人】为‘N’时		
		1- 清空【画：信用证信息.转让信息】表格，设为不显示
		2- 清空【Hidden：转让编号】的值
*返回值:
*    无
*参数：
*    无
*/
function changeTrasf2ndBene(){
	//【画：信用证信息.转让第二受益人】
	var trasf2ndBene = $("[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked");
	
	//【画：信用证信息.第一受益人账户】
	var bene1stAcctCcy = $("[name='data/BcMntnOpDtlVO/bene1stAcctCcy']");
	//【画：信用证信息.第一受益人账户】
	var bene1stAcctGl = $("[name='data/BcMntnOpDtlVO/bene1stAcctGl']");
	//【画：信用证信息.第一受益人账户】
	var bene1stAcctSubGl = $("[name='data/BcMntnOpDtlVO/bene1stAcctSubGl']");
	//【画：信用证信息.第一受益人账户】
	var bene1stAcctNo = $("[name='data/BcMntnOpDtlVO/bene1stAcctNo']");
	
	//【画：新建.受益人账户】
	var beneAcctCcy = $("[name='data/BcMntnOpDtlVO/beneAcctCcy']");
	//【画：新建.受益人账户】
	var beneAcctGl = $("[name='data/BcMntnOpDtlVO/beneAcctGl']");
	//【画：新建.受益人账户】
	var beneAcctSubGl = $("[name='data/BcMntnOpDtlVO/beneAcctSubGl']");
	//【画：新建.受益人账户】
	var beneAcctNo = $("[name='data/BcMntnOpDtlVO/beneAcctNo']");
	
	//【画：信用证信息.转让编号.检索】
	var btn_scan = $("#btn_scan");
	//当【画：信用证信息.转让第二受益人】为‘Y’时	
	if("Y"==$.trim(trasf2ndBene.val())){
		//显示【画：信用证信息.转让信息】表格
		$("#trasfTable").show();
		//将【画：信用证信息.第一受益人账户】的值设为：【画：新建.受益人账户】
		bene1stAcctCcy.val($.trim(beneAcctCcy.val()));
		bene1stAcctGl.val($.trim(beneAcctGl.val()));
		bene1stAcctSubGl.val($.trim(beneAcctSubGl.val()));
		bene1stAcctNo.val($.trim(beneAcctNo.val()));
		//将【画：信用证信息.转让金额.币种】的值设为：【画：新建.汇票金额.币种】
		$("#trasfAmtCcy").val($("#bxCcy").val());
		//将【画：信用证信息.转让金额.金额】的值设为：0 
		$("#trasfAmt").val("0");
		//【画：信用证信息.转让编号.检索】显示且可点击
		btn_scan.show();
		btn_scan.prop("disabled",false);
	}else{
		//清空【画：信用证信息.转让信息】表格
		$(":text,textarea","#trasfTable").val("");
		$(":checkbox,:radio","#trasfTable").prop("checked",false);
		$("select","#trasfTable").val("");
		//，设为不显示
		$("#trasfTable").hide();
		//清空【Hidden：转让编号】的值
		$("[name='data/BcMntnOpDtlVO/tmpTrasfNo']").val("");
	}
}


/** 
 * 设置【画：寄单信息】的初期显示
 */
function dispchBlockInit () {
		// 1.1.8）设置【画：寄单信息】的初期显示
	// 当【画：寄单信息】有数据时：
	$("#dispchDocTable>tbody>tr:visible").each(function(i, o) {
		var thizTr = $(this);
		var index = i;

		// a- 当【DM：寄单信息.操作流水号】不等于当前操作流水号或【DM：寄单信息.操作版本号】不等于当前操作版本号时
		if ("N" == $(":hidden[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+index+"]/dispchDocFlgAdd']",thizTr).val()) {

			// 将该寄单信息行设为不可编辑
			$(":input", thizTr).setReadOnly(true);
		}
		// b- 当【DM：寄单信息.操作流水号】等于当前操作流水号且【DM：寄单信息.操作版本号】等于当前操作版本号时
		else {

			// 将该寄单信息行设为可编辑
			$(":input", thizTr).setReadOnly(false);

			// 将当前行的【Hidden：新增寄单信息标志】的值设为：Y
			$(":hidden[name='data/BcMntnOpDtlVO/dispchDocInfoVOList[" + index + "]/dispchDocFlgAdd']", thizTr).val("Y");

			// 当【画：寄单信息.寄单对象】为‘2：客户’时
			if ("2" == ($(":radio[name='data/BcMntnOpDtlVO/dispchDocInfoVOList[" + index + "]/dispchDocObj']:checked", thizTr).val())) {

				// 【画：寄单信息.寄单种类】设为不可编辑
				$("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList[" + index + "]/dispchDocType']", thizTr).setReadOnly(true);
			}
		}
	});
}
/**
*方法说明：
【画：非信用证信息.进口商国别】输入值变化时处理	
	不为空时，将【画：单据信息.国别】的值设为：【画：非信用证信息.进口商国别】
	为空时，清空【画：单据信息.国别】的值
*返回值:
*    无
*参数：
*    无
*/
function changeNotLcImptrNatnlty(){
	//【画：非信用证信息.进口商国别】
	var imptrNatnlty = $("[name='data/BcMntnOpDtlVO/imptrNatnlty']");
	//【画：单据信息.国别】
	var natnlty = $("[name='data/BcMntnOpDtlVO/natnlty']");
	//将【画：单据信息.国别】的值设为：【画：非信用证信息.进口商国别】
		natnlty.val($.trim(imptrNatnlty.val()));
}

/**
*方法说明：
【画：费用信息.手续费支付方】选择值变化时处理			
	当【画：费用信息.手续费支付方】为‘S：Shipper’时		
			1- 将【画：费用信息.手续费账户】的值设为：【画：新建.受益人账户】
			2- 调用2.36）【画：费用信息.手续费账户.币种】输入值变化时处理
	当【画：费用信息.手续费支付方】为‘B：Buyer’时，清空【画：费用信息.手续费账户】，【画：费用信息.Exchange信息(手续费).EX.Method】的值		
*返回值:
*    无
*参数：
*    无
*/
function changeFeePayer(){
	//【画：费用信息.手续费支付方】
	var feePayer = $("[name='data/BcMntnOpDtlVO/feePayer']:checked");
	
	//【画：新建.受益人账户】
	var beneAcctCcy = $("[name='data/BcMntnOpDtlVO/beneAcctCcy']");
	//【画：新建.受益人账户】
	var beneAcctGl = $("[name='data/BcMntnOpDtlVO/beneAcctGl']");
	//【画：新建.受益人账户】
	var beneAcctSubGl = $("[name='data/BcMntnOpDtlVO/beneAcctSubGl']");
	//【画：新建.受益人账户】
	var beneAcctNo = $("[name='data/BcMntnOpDtlVO/beneAcctNo']");
	
	//【画：费用信息.手续费账户】
	var feeAcctCcy = $("[name='data/BcMntnOpDtlVO/feeAcctCcy']");
	//【画：费用信息.手续费账户】
	var feeAcctGL = $("[name='data/BcMntnOpDtlVO/feeAcctGl']");
	//【画：费用信息.手续费账户】
	var feeAcctSubGL = $("[name='data/BcMntnOpDtlVO/feeAcctSubGl']");
	//【画：费用信息.手续费账户】
	var feeAcctNo = $("[name='data/BcMntnOpDtlVO/feeAcctNo']");
	
	//【画：费用信息.Exchange信息(手续费).EX.Method】
	var exMethod = $("[name='data/BcMntnOpDtlVO/feeExMethod']");

	if("S" == $.trim(feePayer.val())){
		// 将【画：费用信息.手续费账户】的值设为：【画：新建.受益人账户】
		feeAcctCcy.val($.trim(beneAcctCcy.val()));
		feeAcctGL.val($.trim(beneAcctGl.val()));
		feeAcctSubGL.val($.trim(beneAcctSubGl.val()));
		feeAcctNo.val($.trim(beneAcctNo.val()));
		//调用2.36）【画：费用信息.手续费账户.币种】输入值变化时处理
		changeFeeAcctCcy();
		//当【画：费用信息.手续费支付方】为‘B：Buyer’时
	}else {
		//清空【画：费用信息.手续费账户】
		feeAcctCcy.val("");
		feeAcctGL.val("");
		feeAcctSubGL.val("");
		feeAcctNo.val("");
		//清空【画：费用信息.Exchange信息(手续费).EX.Method】的值
		exMethod.val("");
	}
}

/**
*方法说明：
【画：寄单信息.寄单对象】选择值变化时处理			
	当【画：寄单信息.寄单对象】为‘1:银行’时		
			1- 【画：寄单信息.寄单种类】设为可编辑，值设为‘1：1st’ 
			2- 【画：新建.信用证项下】为‘Y’时，将【画：寄单信息.收件人】的值设为：【画：信用证信息.寄单行.名称】
			3- 【画：新建.信用证项下】为‘N’时，将【画：寄单信息.收件人】的值设为：【画：非信用证信息.寄单行.名称】
	当【画：寄单信息.寄单对象】为‘2:客户’时		
			1- 【画：寄单信息.寄单种类】设为不可编辑，值设为‘请选择’
			2- 将【画：寄单信息.收件人】的值设为：【画：新建.受益人.客户名称】
*返回值:
*    无
*参数：
*    无
*/
function changeDispchDocObj(){
	//获取当前行对象
	var thisTr=arguments[0];
	//【画：非信用证信息.寄单行.名称】
	var noDispchDocBankName = $("[name='data/BcMntnOpDtlVO/dispchDocBankName']");
	//【画：信用证信息.寄单行.名称】
	var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']");
	//【画：新建.信用证项下】
	var lcFlg = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked");
	//【画：新建.受益人.客户名称】
	var beneName = $("[name='data/BcMntnOpDtlVO/beneName']");
	//【画：寄单信息.寄单对象】
	var dispchDocObj = $("td:eq(3) :radio:checked", thisTr).val();
	//【画：寄单信息.寄单种类】
	var dispchDocType = $("td:eq(4) select", thisTr);
	//【画：寄单信息.收件人】
	var recpnt = $("td:eq(6) :text", thisTr);
	
	//当【画：寄单信息.寄单对象】为‘1:银行’时	
	if("1" == dispchDocObj){
		//【画：寄单信息.寄单种类】设为可编辑 
		dispchDocType.setReadOnly(false);
		//，值设为‘1：1st’
		dispchDocType.val("1");
		//【画：新建.信用证项下】为‘Y’时
		if("Y" == lcFlg.val()){
			//将【画：寄单信息.收件人】的值设为：【画：信用证信息.寄单行.名称】
			recpnt.val(dispchDocBankName.val());
			//【画：新建.信用证项下】为‘N’时
		}else{
			//将【画：寄单信息.收件人】的值设为：【画：非信用证信息.寄单行.名称】
			recpnt.val(noDispchDocBankName.val());
			
		}
	//当【画：寄单信息.寄单对象】为‘2:客户’时	
	}else if("2" == dispchDocObj){
		//【画：寄单信息.寄单种类】设为不可编辑，值设为‘请选择’
		dispchDocType.val("");
		dispchDocType.setReadOnly(true);
		//将【画：寄单信息.收件人】的值设为：【画：新建.受益人.客户名称】
		recpnt.val(beneName.val());
	}
}

/**
*方法说明：
【画：寄单信息.寄单种类】选择值变化时处理			
	当【画：寄单信息.寄单种类】为‘1:1st’或‘2：2nd’或‘4:Other:resend’时
			1- 【画：新建.信用证项下】为‘Y’时，将【画：寄单信息.收件人】的值设为：【画：信用证信息.寄单行.名称】
			2- 【画：新建.信用证项下】为‘N’时，将【画：寄单信息.收件人】的值设为：【画：非信用证信息.寄单行.名称】
	当【画：寄单信息.寄单种类】为‘3:Reim’时，将【画：寄单信息.收件人】的值设为：【画：信用证信息.偿付行.名称】		
*返回值:
*    无
*参数：
*    无
*/
function changeDispchDocType(){
	//获取当前行对象
		var thizTr = arguments[0];
		//【画：新建.信用证项下】
		var lcFlg = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked");
		//【画：非信用证信息.寄单行.名称】
		var noDispchDocBankName = $("[name='data/BcMntnOpDtlVO/dispchDocBankName']");
		//【画：信用证信息.寄单行.名称】
		var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']");
		//【画：信用证信息.偿付行.名称】
		var reimbBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']");
		//【画：寄单信息.寄单种类】
		var dispchDocType = $("td:eq(4) select", thizTr).val();
		//【画：寄单信息.收件人】
		var recpnt = $("td:eq(6) :text", thizTr);
		
		//【画：寄单信息.寄单种类】为‘3:Reim’时
		if("3"==dispchDocType){
			//将【画：寄单信息.收件人】的值设为：【画：信用证信息.偿付行.名称】		
			recpnt.val(reimbBankName.val());
			
		}else if("1"==dispchDocType || "2"==dispchDocType || "4"==dispchDocType){
			//【画：新建.信用证项下】为‘Y’时
			if("Y" == lcFlg.val()){
				//将【画：寄单信息.收件人】的值设为：【画：信用证信息.寄单行.名称】
				recpnt.val(dispchDocBankName.val());
				//【画：新建.信用证项下】为‘N’时
			}else{
				//将【画：寄单信息.收件人】的值设为：【画：非信用证信息.寄单行.名称】
				recpnt.val(noDispchDocBankName.val());
			}
		}
}

/**
*方法说明：【画：费用信息.手续费账户.币种】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeFeeAcctCcy(){
	var feeAcctCcy = $("#bcInfoVOfeeAcctCcy") ;
	var exMethod = $("[name='data/BcMntnOpDtlVO/feeExMethod']") ;
	//不为空时
	if($.trim(feeAcctCcy.val()) != ""){
		//当【画：费用信息.手续费账户.币种】不等于‘CNY’时，将【画：费用信息.Exchange信息(手续费).EX.Method】的值设为：NOEX
		if($.trim(feeAcctCcy.val()) != "CNY"){
			exMethod.prop("value","NOEX");	
		}
		//当【画：费用信息.手续费账户.币种】等于‘CNY’时，清空【画：费用信息.Exchange信息(手续费).EX.Method】的值
		else{
			exMethod.prop("value","");
		}
	}
	else{
		//为空时，清空【画：费用信息.Exchange信息(手续费).EX.Method】的值
		exMethod.prop("value","");
	}
}
/**
*方法说明：【画：信用证信息.转让信用证】选择值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeTrasfLcFlg(){

	var trasfLcFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']:checked").val() ;
	var trasf2ndBene = $("[name='data/BcMntnOpDtlVO/trasf2ndBene']");
	var ourBkNtcLc= $("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val();
	
	if($.trim(trasfLcFlg) == "Y" && $.trim(ourBkNtcLc) == "Y"){
		//当【画：信用证信息.转让信用证】为‘Y’且【Hidden：我行通知信用证】为‘Y’时，【画：信用证信息.转让第二受益人】设为可编辑，值设为N
		trasf2ndBene.setReadOnly(false) ;
		$(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene'][value = 'N']").prop("checked","true");
	}
	else{
		//当【画：信用证信息.转让信用证】为‘N’或【Hidden：我行通知信用证】为‘N’时，【画：信用证信息.转让第二受益人】设为不可编辑，值设为N
		trasf2ndBene.setReadOnly(true) ;
		$(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene'][value = 'N']").prop("checked","true");
	}
}

/**
*方法说明：点击【画：信用证信息.Combined LC信息.信用证编号#2-#5.删除】按钮时处理逻辑《纯前台》
*返回值：
*		无
*参数：
*		i:被点击删除的行索引
*/
function clickCombinedLCDel(i){
	//3.3.1）清空【画：信用证信息.Combined LC信息】中当前删除按钮所属行下述项目以外的信息																					
	//      【画：信用证信息.Combined LC信息.信用证金额.币种】																		
	//      【画：信用证信息.Combined LC信息.信用证余额.币种】																		
	//      【画：信用证信息.Combined LC信息.drawn amount.币种】
	var lcNo = "#lcNo" + i;
	var lcAmt = "#lcAmt" + i;
	var drawnAmt = "#drawnAmt" + i;
	var lcBalAmt = "#lcBalAmt" + i;
	$(lcNo).val("");
	$(lcAmt).val("");
	$(drawnAmt).val("");
	$(lcBalAmt).val("");
		
}

/**
*方法说明：点击【画：寄单信息.增加】按钮时处理
*返回值:
*    无
*参数：
*    无
*/
function clickDispchAdd(clonedTrs){
  // 初始值设定参照‘初期值对应DM实体属性名(新建)’的‘寄单信息’区域字段
 	var tr0 = clonedTrs.eq(0);
 	$("td:eq(3) :radio:eq(0)",tr0).prop("checked",true);
 	$("td:eq(4) :select:eq(0)",tr0).val("1");
 	$("td:eq(7) :text",tr0).val($.dateUtil.formatDate(new Date(),"yyyy-MM-dd"));
 	setDictName("CB0004", getEventId(), function(result){
				$("td:eq(9) :text",tr0).val(result);
		});
 	$("input[type=hidden]:eq(1)",tr0).val("托收");
 	
 	// 1- 【画：新建.信用证项下】为‘Y’时，将【画：寄单信息.收件人】的值设为：【画：信用证信息.寄单行.名称】
 	//信用证项下
 	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val();
 	//将【画：信用证信息.寄单行.名称】
 	var dispchDocBankName1 = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']");
 	//将【画：非信用证信息.寄单行.名称】
 	var dispchDocBankName2 = $("[name='data/BcMntnOpDtlVO/dispchDocBankName']");
 	if ($.trim(lcFlg) == "Y") {
 		$("td:eq(6) :text",tr0).val(dispchDocBankName1.val());
 	}
 	// 2- 【画：新建.信用证项下】为‘N’时，将【画：寄单信息.收件人】的值设为：【画：非信用证信息.寄单行.名称】
 	if ($.trim(lcFlg) == "N") {
 		$("td:eq(6) :text",tr0).val(dispchDocBankName2.val());
 	}	
 	// 3- 将当前行的【Hidden：新增寄单信息标志】的值设为：Y
 	$("input[type=hidden]:eq(0)",tr0).val("Y");
}

/**
*方法说明：【画：承兑.承兑到期日】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/
function changeAccptceDueDate() {
	
	var miliseconds;
	var tempDate;
	var dateStr;
	// 承兑到期日
	var accptceDueDate = $("[name='data/BcAccptceOpDtlVO/accptceDueDate']"); 
	// 承兑.远期索偿日
	var forwdClmRmbrsmtDate = $("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']"); 
	// 新建.信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val(); 
	// 信用证信息.有偿付行
	var withReimbsBankFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val();; 
	
	
	// 1）承兑到期日不为空时
	if ($.trim(accptceDueDate.val()) != "") {	
			if ($.trim(lcFlg) == "Y" && $.trim(withReimbsBankFlg) == "Y") {
			    // a- 【画：承兑.远期索偿日】=【画：承兑.承兑到期日】-10天（自然日）
			    //forwdClmRmbrsmtDate.val(dateCalculator(accptceDueDate,-10));
			    jsonStr = {"functionName":"getBizStartDate", "startDate":accptceDueDate.val(), "days":"10", "currency":"XXX"};
					commAjaxPost(jsonStr, function(data){
					if(!$.isEmptyObject(data)){
						forwdClmRmbrsmtDate.val(data);
						}
					});
				}
			else{
				forwdClmRmbrsmtDate.val("");
			}
		} else {
		// 2）为空时，清空【画：承兑.远期索偿日】的值	
		forwdClmRmbrsmtDate.val("");
	}
}

/**
*方法说明：【画：入账.福费廷】勾选时处理
*返回值:
*    无
*参数：
*    无
*/
function checkedForftingFlg() {

	// 入账.福费廷
	var forftingFlg = $("[name='data/BcBookOpDtlVO/forftingFlg']");
	// 入账.头寸日
	var posDate = $("[name='data/BcBookOpDtlVO/posDate']");
	// 入账.头寸金额币种
	var posCcy = $("[name='data/BcBookOpDtlVO/posCcy']");
	// 入账.头寸金额
	var posAmt = $("[name='data/BcBookOpDtlVO/posAmt']");
	// 我行对客入账日
	var ourBankToCustBookingDate = $("[name='data/BcBookOpDtlVO/ourBankToCustBookingDate']");
	// 待核查账户
	var validatnAcctCcy = $("#validatnAcctCcy"); 
	// 待核查账户
	var validatnAcctGl = $("#validatnAcctGl"); 
	// 待核查账户
	var validatnAcctSubGl = $("#validatnAcctSubGl"); 
	// 待核查账户
	var validatnAcctNo = $("#validatnAcctNo"); 
	// 客户等级
	var custLv = $("[name='data/BcBookOpDtlVO/custLv']");
	// 入账.清算行账户
	var bcBookOpDtlVOclrBankAcctCcy = $("#bcBookOpDtlVOclrBankAcctCcy"); 
	// 入账.清算行账户
	var bcBookOpDtlVOclrBankAcctGl = $("#bcBookOpDtlVOclrBankAcctGl"); 
	// 入账.清算行账户
	var bcBookOpDtlVOclrBankAcctSubGl = $("#bcBookOpDtlVOclrBankAcctSubGl"); 
	// 入账.清算行账户
	var bcBookOpDtlVOclrBankAcctNo = $("#bcBookOpDtlVOclrBankAcctNo");
	// 他行扣款金额币种
	var theirDedctCcy = $("[name='data/BcBookOpDtlVO/theirDedctCcy']");
	// 手续费支付方
	var feePayer1 = $("[name='data/BcBookOpDtlVO/feePayer'][value=B]");
	// 手续费支付方
	var feePayer2 = $("[name='data/BcBookOpDtlVO/feePayer'][value=S]");
	// 手续费账户
	var bcBookOpDtlVOfeeAcctCcy = $("#bcBookOpDtlVOfeeAcctCcy");
	// 手续费账户
	var bcBookOpDtlVOfeeAcctGL = $("#bcBookOpDtlVOfeeAcctGL"); 
	// 手续费账户
	var bcBookOpDtlVOfeeAcctSubGL = $("#bcBookOpDtlVOfeeAcctSubGL"); 
	// 手续费账户
	var bcBookOpDtlVOfeeAcctNo = $("#bcBookOpDtlVOfeeAcctNo"); 
	// N/W区分
	var noWfDist = $("[name='data/BcBookOpDtlVO/noWfDist']");
	// 国家
	var counterPartyCountry =  $("[name='data/BcBookOpDtlVO/counterPartyCountry’]");
	// 省
	var counterPartyProv =  $("[name='data/BcBookOpDtlVO/counterPartyProv’]");
	// 市
	var counterPartyCity =  $("[name='data/BcBookOpDtlVO/counterPartyCity’]");
	// 入账账户币种
	var bookAcctCcy1 =  $("[name='data/BcBookOpDtlVO/bookAcctCcy1']");
	// 入账账户GL
	var bookAcctGl1 =  $("[name='data/BcBookOpDtlVO/bookAcctGl1']");
	// 入账账户SUB GL
	var bookAcctSubGl1 =  $("[name='data/BcBookOpDtlVO/bookAcctSubGl1']");
	// 入账账户账号
	var bookAcctNo1 =  $("[name='data/BcBookOpDtlVO/bookAcctNo1']");
	// 币种
	var ccy1 =  $("#ccy1");
	// 金额
	var amt1 =  $("#amt1");
	// 定价金额币种
	var prcCcy1 =  $("#prcCcy1");
	// 入账金额币种
	var bookCcy1 =  $("#bookCcy1");
	// 入账金额金额
	var bookAmt1 =  $("#bookAmt1");
	// EX.Method
	var exMethod1 =  $("[name='data/BcBookOpDtlVO/exMethod1']");
	// Quote
	var quote1 =  $("[name='data/BcBookOpDtlVO/quote1']");
	// Cont.No.
	var contNo11 =  $("[name='data/BcBookOpDtlVO/contNo11']");
	// Cont.No.
	var contNo12 =  $("[name='data/BcBookOpDtlVO/contNo12']");
	// Rate
	var rate1 =  $("[name='data/BcBookOpDtlVO/rate1']");
	// M/D
	var md1 =  $("[name='data/BcBookOpDtlVO/md1']");
	// E/C
	var ecRate1 =  $("[name='data/BcBookOpDtlVO/ecRate1']");
	// 新建.汇票金额.币种
	var bxCcy =  $("[name='data/BcMntnOpDtlVO/bxCcy']");
	// 新建.汇票金额
	var bxAmt =  $("[name='data/BcMntnOpDtlVO/bxAmt']");
	// 入账.定价
	var btn_price_costinfo = $("#btn_price_costinfo");
	// EX.Method
	var exMethod2 =  $("[name='data/BcBookOpDtlVO/exMethod2']");
	// 账户性质二级分类
	var acctPropty2nd1 =  $("[name='data/BcBookOpDtlVO/acctPropty2nd1']");
	// 账户性质三级分类
	var acctPropty3rd1 =  $("[name='data/BcBookOpDtlVO/acctPropty3rd1']");
	// 入账账户币种
	var bookAcctCcy2 =  $("[name='data/BcBookOpDtlVO/bookAcctCcy2']");
	// 入账账户GL
	var bookAcctGl2 =  $("[name='data/BcBookOpDtlVO/bookAcctGl2']");
	// 入账账户SUB GL
	var bookAcctSubGl2 =  $("[name='data/BcBookOpDtlVO/bookAcctSubGl2']");
	// 入账账户账号
	var bookAcctNo2 =  $("[name='data/BcBookOpDtlVO/bookAcctNo2']");
	// 币种
	var ccy2 =  $("#ccy2");
	// 金额
	var amt2 =  $("#amt2");
	// 定价金额币种
	var prcCcy2 =  $("#prcCcy2");
	// 定价金额金额
	var prcAmt2 =  $("#prcAmt2");
	// Quote
	var quote2 =  $("[name='data/BcBookOpDtlVO/quote2']");
	// Cont.No.
	var contNo21 =  $("[name='data/BcBookOpDtlVO/contNo21']");
	// Cont.No.
	var contNo22 =  $("[name='data/BcBookOpDtlVO/contNo22']");
	// Rate
	var rate2 =  $("[name='data/BcBookOpDtlVO/rate2']");
	// M/D
	var md2 =  $("[name='data/BcBookOpDtlVO/md2']");
	// E/C
	var ecRate2 =  $("[name='data/BcBookOpDtlVO/ecRate2']");
	// 入账金额币种
	var bookCcy2 =  $("#bookCcy2");
	// 入账金额金额
	var bookAmt2 =  $("#bookAmt2");
	// 账户性质二级分类
	var acctPropty2nd2 =  $("[name='data/BcBookOpDtlVO/acctPropty2nd2']");
	// 账户性质三级分类
	var acctPropty3rd2 =  $("[name='data/BcBookOpDtlVO/acctPropty3rd2']");
	// 清算行账户GL
	var bcMntnOpDtlVOclrBankAcctGL = $("#bcMntnOpDtlVOclrBankAcctGL"); 
	//清算行账户SUB GL
	var bcMntnOpDtlVOclrBankAcctSubGL = $("#bcMntnOpDtlVOclrBankAcctSubGL"); 
	// 清算行账户账号
	var bcMntnOpDtlVOclrBankAcctNo = $("#bcMntnOpDtlVOclrBankAcctNo"); 
	
	
	// 2.1.1）当【画：入账.福费廷】勾选时
	if (forftingFlg.prop("checked")) {
		// 1- 清空【画：入账】板块（除【画：入账.福费廷】以外）的信息
		$(":text,select","#xiugaiControlPanel").val("");
		$(":radio,:checkbox","#xiugaiControlPanel").prop("checked",false);
		forftingFlg.prop("checked",true);
		
		// a- 以下项目设为可编辑 【入账.福费廷】，【入账.头寸金额.金额），【入账.我行对客入账日】，【入账.清算行账户】（GL，SUB GL，账号），
		// 【入账.入账账户#1】（币种，GL，SUB GL，账号），【入账.金额#1.金额】，【入账.入账金额#1.金额】
		// b- 【画：入账】板块的其他项目设为不可编辑
		$(":radio,:checkbox,select","#xiugaiControlPanel").setReadOnly(true);
		$(":text","#xiugaiControlPanel").setReadOnly(true);
		forftingFlg.setReadOnly(false);
		posAmt.setReadOnly(false);
		ourBankToCustBookingDate.setReadOnly(false);
		bcBookOpDtlVOclrBankAcctGl.setReadOnly(false);
		bcBookOpDtlVOclrBankAcctSubGl.setReadOnly(false);
		bcBookOpDtlVOclrBankAcctNo.setReadOnly(false);
		bookAcctCcy1.setReadOnly(false);
		bookAcctGl1.setReadOnly(false);
		bookAcctSubGl1.setReadOnly(false);
		bookAcctNo1.setReadOnly(false);
		amt1.setReadOnly(false);
		bookAmt1.setReadOnly(false);
		
		// 3- 设置画面项目的初始值
		// 将【画：入账.头寸金额.币种】的值设为：【画：新建.汇票金额.币种】
		posCcy.val(bxCcy.val());
		// 将【画：入账.头寸金额.金额】的值设为：【画：新建.汇票金额.金额】
		posAmt.val(bxAmt.val());
		// 将【画：入账.我行对客入账日】的值设为：系统日期
		ourBankToCustBookingDate.val(getCommonSysDate());
		// 将【画：入账.清算行账户】的值设为：【画：新建.汇票金额.币种】-【237】-【0000】-【900052】
		bcBookOpDtlVOclrBankAcctCcy.val(bxCcy.val());
		bcBookOpDtlVOclrBankAcctGl.val("237");
		bcBookOpDtlVOclrBankAcctSubGl.val("0000");
		bcBookOpDtlVOclrBankAcctNo.val("900052");
		// 将【画：入账.入账账户#1】的值设为：【画：新建.汇票金额.币种】-【237】-【0000】-【900052】
		bookAcctCcy1.val(bxCcy.val());
		bookAcctGl1.val("237");
		bookAcctSubGl1.val("0000");
		bookAcctNo1.val("900052");
  	// 调用2.6）【画：入账.入账账户#1.币种】输入值变化时处理
  	changeBookAcctCcy1();
  	// 调用2.7）【画：入账.入账账户#1.账号】输入值变化时处理
  	changeBookAcctNo1();
		// 将【画：入账.金额#1.币种】的值设为：【画：新建.汇票金额.币种】
		ccy1.val(bxCcy.val());
		// 将【画：入账.金额#1.金额】的值设为：【画：新建.汇票金额.金额】
		amt1.val(bxAmt.val());
		// 将【画：入账.入账金额#1.币种】的值设为：【画：新建.汇票金额.币种】
		bookCcy1.val(bxCcy.val());
		// 将【画：入账.入账金额#1.金额】的值设为：【画：新建.汇票金额.金额】
		bookAmt1.val(bxAmt.val());
		// 【画：入账.定价】按钮设为不可点击  id
    btn_price_costinfo.prop("disabled",true);
	}
	// 2.1.2）当【画：入账.福费廷】不勾选时
	else {
		// 1- 清空【画：入账】板块的信息
		$(":text,select","#xiugaiControlPanel").val("");
		$(":radio,:checkbox","#xiugaiControlPanel").prop("checked",false);
		// 2- 参照BD文档的‘表2.字段列表(详情)_1’中的逻辑画面设置可编辑
		$(":radio,:checkbox,select","#xiugaiControlPanel").setReadOnly(false);
		$(":text","#xiugaiControlPanel").setReadOnly(false);
		posCcy.setReadOnly(true);
		validatnAcctCcy.setReadOnly(true);
		validatnAcctGl.setReadOnly(true);
		validatnAcctSubGl.setReadOnly(true);
		validatnAcctNo.setReadOnly(true);
		custLv.setReadOnly(true);
		bcBookOpDtlVOclrBankAcctCcy.setReadOnly(true);
		theirDedctCcy.setReadOnly(true);
		ccy1.setReadOnly(true);
		prcCcy1.setReadOnly(true);
		exMethod1.setReadOnly(true);
		quote1.setReadOnly(true);
		contNo11.setReadOnly(true); 
		contNo12.setReadOnly(true); 
		rate1.setReadOnly(true);
		md1.setReadOnly(true);
		ecRate1.setReadOnly(true);
		bookCcy1.setReadOnly(true);
		acctPropty2nd1.setReadOnly(true);
		acctPropty3rd1.setReadOnly(true);
		bookAcctCcy2.setReadOnly(true);
		bookAcctGl2.setReadOnly(true);
		bookAcctSubGl2.setReadOnly(true);
		bookAcctNo2.setReadOnly(true);
		ccy2.setReadOnly(true);
		amt2.setReadOnly(true);
		prcCcy2.setReadOnly(true);
		prcAmt2.setReadOnly(true);
		exMethod2.setReadOnly(true);
		quote2.setReadOnly(true);
		contNo21.setReadOnly(true);
		contNo22.setReadOnly(true);
		rate2.setReadOnly(true);
		md2.setReadOnly(true);
		ecRate2.setReadOnly(true);
		bookCcy2.setReadOnly(true);
		bookAmt2.setReadOnly(true);
		acctPropty2nd2.setReadOnly(true);
		acctPropty3rd2.setReadOnly(true);
		// 3- 参照入账询价前逻辑画面的‘初期值对应DM实体属性名(新建)’设置画面项目的初始值
		
		var jsonStr = {'functionName':'getNow'};
		commAjaxPost(jsonStr,function(data) {
		 var tempDate = data;
		});
		tempDate.setDate(tempDate.getDate() - 2);
		// 系统日期 - 2（工作日） 
		posDate.val(tempDate.val());  
		
		// 托收基本信息;汇票币种
		posCcy.val(bxCcy.val()); 
		// 系统日期
		ourBankToCustBookingDate.val(getCommonSysDate());  
		// 托收基本信息;汇票币种
		bcBookOpDtlVOclrBankAcctCcy.val(bxCcy.val()); 
		// 托收基本信息;清算行账户GL
		bcBookOpDtlVOclrBankAcctGl.val(bcMntnOpDtlVOclrBankAcctGL.val()); 
		// 托收基本信息;清算行账户SUB GL
		bcBookOpDtlVOclrBankAcctSubGl.val(bcMntnOpDtlVOclrBankAcctSubGL.val()); 
		// 托收基本信息;清算行账户账号
		bcBookOpDtlVOclrBankAcctNo.val(bcMntnOpDtlVOclrBankAcctNo.val()); 
		// 托收基本信息;汇票币种
		theirDedctCcy.val(bxCcy.val()); 
		
		if ($.trim($(":radio[name='data/BcMntnOpDtlVO/feePayer']:checked").val()) == "B" ) {
			// 托收基本信息;手续费支付方
		   feePayer1.prop("checked",true); 
		   
		} else if ($.trim($(":radio[name='data/BcMntnOpDtlVO/feePayer']:checked").val()) == "S" ) {
			// 托收基本信息;手续费支付方
		   feePayer2.prop("checked",true); 
		}
		// 托收基本信息;手续费账户币种
		bcBookOpDtlVOfeeAcctCcy.val($("#bcInfoVOfeeAcctCcy").val()); 
		// 托收基本信息;手续费账户GL
		bcBookOpDtlVOfeeAcctGL.val($("#bcInfoVOfeeAcctGL").val()); 
		// 托收基本信息;手续费账户SUB GL
		bcBookOpDtlVOfeeAcctSubGL.val($("#bcInfoVOfeeAcctSubGL").val()); 
		// 托收基本信息;手续费账户账号
		bcBookOpDtlVOfeeAcctNo.val($("#bcInfoVOfeeAcctNo").val()); 
		// 托收基本信息;N/W区分
		noWfDist.val($("[name='data/BcMntnOpDtlVO/noWfDist']").val()); 
		// “请选择” 
		counterPartyCountry.val(""); 
		// “请选择”
		counterPartyProv.val(""); 
		// “请选择”
		counterPartyCity.val(""); 
		// 托收基本信息;受益人账户币种
		bookAcctCcy1.val($("#beneAcctCcy").val()); 
		// 托收基本信息;受益人账户GL
		bookAcctGl1.val($("#beneAcctGl").val()); 
		// 托收基本信息;受益人账户SUB GL
		bookAcctSubGl1.val($("#beneAcctSubGl").val()); 
		// 托收基本信息;受益人账户账号
		bookAcctNo1.val($("#beneAcctNo").val()); 
		// 托收基本信息;汇票币种
		ccy1.val(bxCcy.val()); 
		// 托收基本信息;汇票币种
		prcCcy1.val(bxCcy.val()); 
		// 托收基本信息;受益人账户币种
		bookCcy1.val($("#beneAcctCcy").val()); 
		
		// 4- 【画：入账.定价】按钮设为可点击
		btn_price_costinfo.prop("disabled",false);
	}
}

/**
*方法说明：【画：入账.头寸金额.金额】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/
function changePosAmt() {

	var posAmt = $("#posAmt");
	var bxAmt = $("#bxAmt");
	// 2.2.1）当【画：入账.头寸金额.金额】不为空，且小于等于【画：新建.汇票金额.金额】时
	if ($.trim(posAmt.val()) != "") {
		// 自动计算【画：入账.他行扣款金额.金额】
		if (parseInt(bxAmt.val()) >= parseInt(posAmt.val())) {
			// 【画：入账.他行扣款金额.金额】=【画：新建.汇票金额.金额】-【画：入账.头寸金额.金额】
			$("#theirDedctAmt").val(bxAmt.val() - posAmt.val());
		}
		else{
			$("#theirDedctAmt").val("");
		}
	} else {
		// 2.1.2）当【画：入账.头寸金额.金额】为空时，清空【画：入账.他行扣款金额.金额】
		$("#theirDedctAmt").val("");
	}
	
}

/**
*方法说明：【画：入账.待核查账户】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeValidatnAcct(){
	var validatnAcctCcy = $("[name='data/BcBookOpDtlVO/validatnAcctCcy']").val() ;
	var validatnAcctGl = $("[name='data/BcBookOpDtlVO/validatnAcctGl']").val() ;
	var validatnAcctSubGl = $("[name='data/BcBookOpDtlVO/validatnAcctSubGl']").val() ;
	var validatnAcctNo = $("[name='data/BcBookOpDtlVO/validatnAcctNo']").val() ;
	var bookAcctCcy1 = $("[name='data/BcBookOpDtlVO/bookAcctCcy1']");
	var bookAcctGl1 = $("[name='data/BcBookOpDtlVO/bookAcctGl1']");
	var bookAcctSubGl1 = $("[name='data/BcBookOpDtlVO/bookAcctSubGl1']");
	var bookAcctNo1 = $("[name='data/BcBookOpDtlVO/bookAcctNo1']");
	if( validatnAcctCcy != "" && validatnAcctGl != "" && validatnAcctSubGl != "" && validatnAcctNo != ""){
		//不为空时
			//将【画：入账.入账账户#1】的值设为：【画：入账.待核查账户】
			bookAcctCcy1.val(validatnAcctCcy);
			bookAcctGl1.val(validatnAcctGl);
			bookAcctSubGl1.val(validatnAcctSubGl);
			bookAcctNo1.val(validatnAcctNo);
			//调用【画：入账.入账账户#1.币种】输入值变化时处理
			changeBookAcctCcy1();
			//调用【画：入账.入账账户#1.账号】输入值变化时处理
			changeBookAcctNo1();
	}else{
		//为空时，
		//清空【画：入账.入账账户#1】，
		bookAcctCcy1.val("");
		bookAcctGl1.val("");
		bookAcctSubGl1.val("");
		bookAcctNo1.val("");
		//【画：入账.入账金额#1.币种】，
		$("[name='data/BcBookOpDtlVO/bookCcy1']").val("");
		//【画：入账.Exchange信息#1.EX.Method】，
		$("[name='data/BcBookOpDtlVO/exMethod1']").val("");
		//【画：入账.账户性质#1】的值
		$("[name='data/BcBookOpDtlVO/acctPropty2ndCd1']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty3rdCd1']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty2nd1']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty3rd1']").val("");
	}
}
	
/**
*方法说明：【画：入账.入两个账户】勾选时处理
*返回值：
*		无
*参数：
*		无
*/
function checkedEnter2AcctFlg(){
	var enter2AcctFlg = $("[name='data/BcBookOpDtlVO/enter2AcctFlg']");
	if(enter2AcctFlg.prop("checked")){
		//当【画：入账.入两个账户】勾选时
		//清空【画：入账.金额#1.金额】，【画：入账.定价金额#1.金额】，【画：入账.入账金额#1.金额】的值
		$("[name='data/BcBookOpDtlVO/amt1']").val("");
		$("[name='data/BcBookOpDtlVO/prcAmt1']").val("");
		$("[name='data/BcBookOpDtlVO/bookAmt1']").val("");
		//【画：入账.入账账户#2】，【画：入账.金额#2.金额】，【画：入账.定价金额#2.金额】，【画：入账.入账金额#2.金额】设为可编辑
		$("[name='data/BcBookOpDtlVO/bookAcctCcy2']").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/bookAcctGl2']").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/bookAcctSubGl2']").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/bookAcctNo2']").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/amt2']").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/prcAmt2']").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/bookAmt2']").setReadOnly(false);
		//将【画：入账.金额#2.币种】的值设为：【画：新建.汇票金额.币种】
		$("[name='data/BcBookOpDtlVO/ccy2']").prop("value",$("[name='data/BcMntnOpDtlVO/bxCcy']").val());
		//将【画：入账.定价金额#2.币种】的值设为：【画：新建.汇票金额.币种】
		$("[name='data/BcBookOpDtlVO/prcCcy2']").prop("value",$("[name='data/BcMntnOpDtlVO/bxCcy']").val());
	}else{
		//当【画：入账.入两个账户】不勾选时
		//清空【画：入账.金额#1.金额】，【画：入账.定价金额#1.金额】，【画：入账.入账金额#1.金额】，
		$("[name='data/BcBookOpDtlVO/amt1']").val("");
		$("[name='data/BcBookOpDtlVO/prcAmt1']").val("");
		$("[name='data/BcBookOpDtlVO/bookAmt1']").val("");
		//清空【画：入账.入账账户#2】整行，【画：入账.账户性质#2】的值
		$("[name='data/BcBookOpDtlVO/bookAcctCcy2']").val("");
		$("[name='data/BcBookOpDtlVO/bookAcctGl2']").val("");
		$("[name='data/BcBookOpDtlVO/bookAcctSubGl2']").val("");
		$("[name='data/BcBookOpDtlVO/bookAcctNo2']").val("");
		$("[name='data/BcBookOpDtlVO/ccy2']").val("");
		$("[name='data/BcBookOpDtlVO/amt2']").val("");
		$("[name='data/BcBookOpDtlVO/prcCcy2']").val("");
		$("[name='data/BcBookOpDtlVO/prcAmt2']").val("");
		$("[name='data/BcBookOpDtlVO/exMethod2']").prop("value","");
		$("[name='data/BcBookOpDtlVO/quote2']").prop("value","");
		$("[name='data/BcBookOpDtlVO/contNo21']").val("");
		$("[name='data/BcBookOpDtlVO/contNo22']").val("");
		$("[name='data/BcBookOpDtlVO/rate2']").val("");
		$("[name='data/BcBookOpDtlVO/md2']").prop("value","");
		$("[name='data/BcBookOpDtlVO/ecRate2']").val("");
		$("[name='data/BcBookOpDtlVO/bookCcy2']").val("");
		$("[name='data/BcBookOpDtlVO/bookAmt2']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty2ndCd2']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty3rdCd2']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty2nd2']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty3rd2']").val("");
		//【画：入账.入账账户#2】，【画：入账.金额#2.金额】，【画：入账.定价金额#2.金额】，【画：入账.入账金额#2.金额】设为不可编辑
		$("[name='data/BcBookOpDtlVO/bookAcctCcy2']").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/bookAcctGl2']").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/bookAcctSubGl2']").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/bookAcctNo2']").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/amt2']").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/prcAmt2']").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/bookAmt2']").setReadOnly(true);
	}
}
/**
*方法说明：【画：入账.入账账户#1.币种】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeBookAcctCcy1(){
	var bookAcctCcy1 = $("[name='data/BcBookOpDtlVO/bookAcctCcy1']").val();
	if($.trim(bookAcctCcy1) != ""){
		//不为空时
		//将【画：入账.入账金额#1.币种】的值设为：【画：入账.入账账户#1.币种】
		$("[name='data/BcBookOpDtlVO/bookCcy1']").prop("value",bookAcctCcy1);
		//当【画：入账.入账账户#1.币种】等于【画：新建.汇票金额.币种】且【画：入账.入账账户#1.币种】不等于‘CNY’时，
		//将【画：入账.Exchange信息#1.EX.Method】的值设为：NOEX
		if($.trim(bookAcctCcy1) == $.trim($("[name='data/BcMntnOpDtlVO/bxCcy']").val()) && $.trim(bookAcctCcy1) != "CNY"){
			$("[name='data/BcBookOpDtlVO/exMethod1']").prop("value","NOEX");
		}else{
			//当【画：入账.入账账户#1.币种】不等于【画：新建.汇票金额.币种】或【画：入账.入账账户#1.币种】等于‘CNY’时，
			//清空【画：入账.Exchange信息#1.EX.Method】的值	
			$("[name='data/BcBookOpDtlVO/exMethod1']").prop("value","");
		}
		
	}else{
		//为空时，清空【画：入账.入账金额#1.币种】，【画：入账.Exchange信息#1.EX.Method】的值
		$("[name='data/BcBookOpDtlVO/bookCcy1']").prop("value","");
		$("[name='data/BcBookOpDtlVO/exMethod1']").prop("value","");
	}
	
	
}
/**
*方法说明：【画：入账.入账账户#1.账号】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeBookAcctNo1(){
	var bookAcctNo1 = $("[name='data/BcBookOpDtlVO/bookAcctNo1']").val();
	var acctPropty2nd1 = $("[name='data/BcBookOpDtlVO/acctPropty2nd1']");
	var acctPropty3rd1 = $("[name='data/BcBookOpDtlVO/acctPropty3rd1']");
	var acctPropty2ndCd1 = $("[name='data/BcBookOpDtlVO/acctPropty2ndCd1']");
	var acctPropty3rdCd1 = $("[name='data/BcBookOpDtlVO/acctPropty3rdCd1']");
	var branchCode = $("#artCommonOrgCode").val();
	if($.trim(bookAcctNo1) != ""){
		//不为空时，调用组件列表【E00150账户信息取得】，参数：分行号、币种、GL、Sub GL、账号，取得账户性质二级分类和账户性质三级分类，分别设值到【画：入账.账户性质#1.二级分类】，【画：入账.账户性质#1.三级分类】
		jsonStr = {"functionName":"getAccountInfo", "branchCode":branchCode, "ccy":$("#bookAcctCcy1").val(), "gl":$("#bookAcctGl1").val(), "subGl":$("#bookAcctSubGl1").val(), "acNo":$("#bookAcctNo1").val()};
		commAjaxPost(jsonStr,function(data){
			if(!!data && !$.isEmptyObject(data)) {
				acctPropty2ndCd1.val(data.acctPropty2nd1);
				acctPropty3rdCd1.val(data.acctPropty3rd1);
			}
		});
		setDictName("CA0396", acctPropty2ndCd1.val(), function(result){
			//设值到【画：费用信息.账户性质#1.二级分类】
			acctPropty2nd1.val(result);
		});
		
		setDictName("CA0397", acctPropty3rdCd1.val(), function(result){
			//设值到【画：费用信息.账户性质#1.三级分类】
			acctPropty3rd1.val(result);
		});
		
	}else{
		//为空时，清空【画：入账.账户性质#1.二级分类】，【画：入账.账户性质#1.三级分类】的值
		acctPropty2nd1.val("");
		acctPropty3rd1.val("");
		acctPropty2ndCd1.val("");
		acctPropty3rdCd1.val("");
	}
	
	
}
/**
*方法说明：【画：入账.入账账户#2.币种】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeBookAcctCcy2(){
	var bookAcctCcy2 = $("[name='data/BcBookOpDtlVO/bookAcctCcy2']").val();
	if($.trim(bookAcctCcy2) != ""){
		//不为空时
		//将【画：入账.入账金额#2.币种】的值设为：【画：入账.入账账户#2.币种】
		$("[name='data/BcBookOpDtlVO/bookCcy2']").val(bookAcctCcy2);
		//当【画：入账.入账账户#2.币种】等于【画：新建.汇票金额.币种】且【画：入账.入账账户#2.币种】不等于‘CNY’时，
		//将【画：入账.Exchange信息#2.EX.Method】的值设为：NOEX
		if($.trim(bookAcctCcy2) == $.trim($("[name='data/BcMntnOpDtlVO/bxCcy']").val()) && $.trim(bookAcctCcy2) != "CNY"){
			$("[name='data/BcBookOpDtlVO/exMethod2']").prop("value","NOEX");
		}else{
			//当【画：入账.入账账户#2.币种】不等于【画：新建.汇票金额.币种】或【画：入账.入账账户#2.币种】等于‘CNY’时，
			//清空【画：入账.Exchange信息#2.EX.Method】的值
			$("[name='data/BcBookOpDtlVO/exMethod2']").prop("value","");
		}
	}else{
		//为空时，清空【画：入账.入账金额#2.币种】，【画：入账.Exchange信息#2.EX.Method】的值
		$("[name='data/BcBookOpDtlVO/bookCcy2']").val("");
		$("[name='data/BcBookOpDtlVO/exMethod2']").prop("value","");
	}
	
		
}
/**
*方法说明：【画：入账.入账账户#2.账号】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeBookAcctNo2(){
	var bookAcctNo2 = $("[name='data/BcBookOpDtlVO/bookAcctNo2']").val();
	var acctPropty2nd2 = $("[name='data/BcBookOpDtlVO/acctPropty2nd2']");
	var acctPropty3rd2 = $("[name='data/BcBookOpDtlVO/acctPropty3rd2']");
	var acctPropty2ndCd2 = $("[name='data/BcBookOpDtlVO/acctPropty2ndCd2']");
	var acctPropty3rdCd2 = $("[name='data/BcBookOpDtlVO/acctPropty3rdCd2']");
	var branchCode = $("#artCommonOrgCode").val();
	if($.trim(bookAcctNo2) != ""){
		//不为空时，调用业务间函数(账户管理)的【账户信息取得(分行号，账户币种，账户GL，账户SUB GL，账户账号)】方法，
		//取得账户性质二级分类和账户性质三级分类，分别设值到【画：入账.账户性质#2.二级分类】，【画：入账.账户性质#2.三级分类】
		jsonStr = {"functionName":"getAccountInfo", "branchCode":branchCode, "ccy":ccy, "gl":gl, "subGl":subGl, "acNo":acNo};
		commAjaxPost(jsonStr,function(data){
			if(!!data && !$.isEmptyObject(data)) {
				acctPropty2ndCd2.val(data.acctPropty2nd2);
				acctPropty3rdCd2.val(data.acctPropty3rd2);
			}
		});
		setDictName("CA0396", acctPropty2ndCd2.val(), function(result){
			//设值到【画：费用信息.账户性质#2.二级分类】
			acctPropty2nd2.val(result);
		});
		
		setDictName("CA0397", acctPropty3rdCd2.val(), function(result){
			//设值到【画：费用信息.账户性质#2.三级分类】
			acctPropty3rd2.val(result);
		});
	}else{
		//为空时，清空【画：入账.账户性质#2.二级分类】，【画：入账.账户性质#2.三级分类】的值
		acctPropty2nd2.val("");
		acctPropty3rd2.val("");
		acctPropty2ndCd2.val("");
		acctPropty3rdCd2.val("");
	}
}
/**
*方法说明：【画：入账.待核查账户】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
//function changeBookValidatnAcct(){
//
//	var branchCode = $("#artCommonOrgCode").val();
//	//用户在账号输入框中输入六位短帐号后，调用组件列表【E90250短账号查长账号】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号 
//	shortAccountRegist("validatnAcctNo",branchCode,"validatnAcctCcy","validatnAcctGl","validatnAcctSubGl");
//
//}


/**
*方法说明：【画：入账.清算行账户】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
//function changeBookClrBankAcct(){
//
//	var branchCode = $("#artCommonOrgCode").val();
//	//用户在账号输入框中输入六位短帐号后，调用组件列表【E90250短账号查长账号】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号 
//	shortAccountRegist("bcBookOpDtlVOclrBankAcctNo",branchCode,"bcBookOpDtlVOclrBankAcctCcy","bcBookOpDtlVOclrBankAcctGl","bcBookOpDtlVOclrBankAcctSubGl");
//
//}
/**
*方法说明：【画：入账.手续费账户】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
//function changeBookFeeAcct(){
//
//	var branchCode = $("#artCommonOrgCode").val();
//	//用户在账号输入框中输入六位短帐号后，调用组件列表【E90250短账号查长账号】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号 
//	shortAccountRegist("bcBookOpDtlVOfeeAcctNo",branchCode,"bcBookOpDtlVOfeeAcctCcy","bcBookOpDtlVOfeeAcctGL","bcBookOpDtlVOfeeAcctSubGL");
//
//}
/**
*方法说明：【画：入账.入账账户#1】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
//function changeBookAcct1(){
//
//	var branchCode = $("#artCommonOrgCode").val();
//	//用户在账号输入框中输入六位短帐号后，调用组件列表【E90250短账号查长账号】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号 
//	shortAccountRegist("bookAcctNo1",branchCode,"bookAcctCcy1","bookAcctGl1","bookAcctSubGl1");
//
//}
/**
*方法说明：【画：入账.入账账户#2】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
//function changeBookAcct2(){
//
//	var branchCode = $("#artCommonOrgCode").val();
//	//用户在账号输入框中输入六位短帐号后，调用组件列表【E90250短账号查长账号】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号 
//	shortAccountRegist("bookAcctNo2",branchCode,"bookAcctCcy2","bookAcctGl2","bookAcctSubGl2");
//
//}

/**
*方法说明：【画：新建.到期日期】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/
function changeReviseDueDate2() {
	
	// 到期日期
	var dueDate = $("[name='data/BcMntnOpDtlVO/dueDate']"); 
	// 最终到期日
	var finalDueDate = $("[name='data/BcMntnOpDtlVO/finalDueDate']"); 
	// 承兑到期日
	var accptceDueDate = $("[name='data/BcAccptceOpDtlVO/accptceDueDate']"); 
	// 承兑.远期索偿日
	var forwdClmRmbrsmtDate = $("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']"); 
	// 承兑.Accepted Flag
	var acceptedFlg = $(":radio[name='data/BcAccptceOpDtlVO/acceptedFlg']:checked").val(); 
	// 新建.信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val(); 
	// 信用证信息.有偿付行
	var withReimbsBankFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val();; 
	// 2.4.1）不为空时
	if ($.trim(dueDate.val()) != "") {	
			// 1- 将【画：新建.最终到期日】的值设为：【画：新建.到期日期】
			finalDueDate.val(dueDate.val());
			// 2- 当【画：承兑.Accepted Flag】为‘Y’时
			if ($.trim(acceptedFlg) == "Y") {
			    // 将【画：承兑.承兑到期日】的值设为：【画：新建.到期日期】
			    accptceDueDate.val(dueDate.val());
			  // 调用【画：承兑.承兑到期日】输入值变化时处理 
			  	changeAccptceDueDate();
			}
	// 2.4.2）为空时				
	} else {
		// 1- 清空【画：新建.最终到期日】的值
		finalDueDate.val("");
		// 2- 当【画：承兑.Accepted Flag】为‘Y’时
		if ($.trim(acceptedFlg) == "Y") {
			  // a- 清空【画：承兑.承兑到期日】的值
			  accptceDueDate.val("");
			  // b- 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，清空【画：承兑.远期索偿日】的值
			  if ($.trim(lcFlg) == "Y" && $.trim(withReimbsBankFlg) == "Y" ) {
			      forwdClmRmbrsmtDate.val("");
			  }
			}
	}
}

/**
*方法说明：【画：承兑.Accepted Flag】选择值变化时处理
*返回值:
*    无
*参数：
*    无
*/
function changeAcceptedFlag() {
	
	var miliseconds;
	var tempDate;
	var dateStr;
	
	// 承兑.Accepted Flag
	var acceptedFlg = $(":radio[name='data/BcAccptceOpDtlVO/acceptedFlg']:checked").val();
	// 信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val(); 
	// 有偿付行
	var withReimbsBankFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val(); 
	// 承兑登记日
	var accptceRegDate = $("[name='data/BcAccptceOpDtlVO/accptceRegDate']");
	// 承兑到期日
	var accptceDueDate = $("[name='data/BcAccptceOpDtlVO/accptceDueDate']");
	// 承兑.合理
	var resnblFlg = $("[name='data/BcAccptceOpDtlVO/resnblFlg']"); 
	// 承兑.承兑备注
	var accptceRmrk = $("[name='data/BcAccptceOpDtlVO/accptceRmrk']");
	// 远期索偿日
	var forwdClmRmbrsmtDate = $("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']"); 
	// 新建.到期日期
	var dueDate = $("[name='data/BcMntnOpDtlVO/dueDate']");
	
	// 当【画：承兑.Accepted Flag】为‘Y’时
	if ($.trim(acceptedFlg) == "Y") {
	
		// 1- 【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.合理】，【画：承兑.承兑备注】设为可编辑
		accptceRegDate.setReadOnly(false);
		accptceDueDate.setReadOnly(false);
		resnblFlg.setReadOnly(false);
		accptceRmrk.setReadOnly(false);
		// 将【画：承兑.承兑登记日】的值设为：系统日期
		accptceRegDate.val(getCommonSysDate());
		// 将【画：承兑.承兑到期日】的值设为：【画：新建.到期日期】
		accptceDueDate.val(dueDate.val());
		// 将【画：承兑.合理】的值设为：Y
		$(":radio[name='data/BcAccptceOpDtlVO/resnblFlg'][value=Y]").prop("checked",true);
		
	    // 2- 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：承兑.远期索偿日】设为可编辑
	    if($.trim(lcFlg) == "Y" && $.trim(withReimbsBankFlg) == "Y") {
	    	forwdClmRmbrsmtDate.setReadOnly(false);
	    	// 将【画：承兑.远期索偿日】的值设为：【画：承兑.承兑到期日】-10天（自然日）
    		//forwdClmRmbrsmtDate.val(dateCalculator(accptceDueDate,-10));
    		jsonStr = {"functionName":"getBizStartDate", "startDate":accptceDueDate.val(), "days":"10", "currency":"XXX"};
					commAjaxPost(jsonStr, function(data){
					if(!$.isEmptyObject(data)){
						forwdClmRmbrsmtDate.val(data);
						}
					});
	    }
	} else {
		// 1- 清空【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.远期索偿日】，【画：承兑.合理】，【画：承兑.承兑备注】的值，设为不可编辑
		accptceRegDate.val("");
		accptceDueDate.val("");
		forwdClmRmbrsmtDate.val("");
		resnblFlg.prop("checked",false);
		accptceRmrk.val("");
		accptceRegDate.setReadOnly(true);
		accptceDueDate.setReadOnly(true);
		forwdClmRmbrsmtDate.setReadOnly(true);
		resnblFlg.setReadOnly(true);
		accptceRmrk.setReadOnly(true);
	}     
	    
}

///**
//*方法说明：【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】输入值变化时处理
//*返回值:
//*    无
//*参数：
//*    无
//*/
//function changeDrawnAmt() {
//	
//	var bxAmt = $("[name='data/BcMntnOpDtlVO/bxAmt']"); // 新建.汇票金额.金额
//	var drawnAmt1 = Number($.trim($("#drawnAmt1").val()) == "" ? 0 : $("#drawnAmt1").val()); // drawn amount#1
//	var drawnAmt2 = Number($.trim($("#drawnAmt2").val()) == "" ? 0 : $("#drawnAmt2").val()); // drawn amount#2
//	var drawnAmt3 = Number($.trim($("#drawnAmt3").val()) == "" ? 0 : $("#drawnAmt3").val());// drawn amount#3
//	var drawnAmt4 = Number($.trim($("#drawnAmt4").val()) == "" ? 0 : $("#drawnAmt4").val()); // drawn amount#4
//	var drawnAmt5 = Number($.trim($("#drawnAmt5").val()) == "" ? 0 : $("#drawnAmt5").val()); // drawn amount#5
//	
//	// 将【画：新建.汇票金额.金额】的值设为：【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】的合计
//	// ※当【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】为空时，默认用0来计算
//	bxAmt.val(drawnAmt1+drawnAmt2+drawnAmt3+drawnAmt4+drawnAmt5);
//	
//}


/**
*方法说明：【画：新建.受益人.客户CIF】输入值变化时处理
*返回值:
*    无
*参数：
*    无
*/
function changeBeneCif() {
	
	//【画：新建.受益人.客户CIF】
	var beneCif = $("#beneCif").val();
	//【画：费用信息.手续费支付方】
	var feePayer = $("[name='data/BcMntnOpDtlVO/feePayer']:checked").val();
	//分行号
	var branchCode = $("#artCommonOrgCode").val();
	//【画：信用证信息.转让第二受益人】
	var trasf2ndBene = $("[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked").val();
	
	//调用共通组件【CIF自动补0】实现客户CIF不足8位时，CIF号前自动补0
	$("#beneCif").val(mendCifNumber(beneCif));
	//调用共通组件【客户号调客户名称】，参数：客户CIF，分行号，取得客户名称
	//cifRegist("beneCif", branchCode, "beneName");
	//通过客户CIF，调用共通组件【CIF获取可用账户】方法来获取受益人账户
	//cifToLongAccRegist("beneCif",branchCode,"beneAcctNo","beneAcctCcy","beneAcctGl","beneAcctSubGl");
	if($.trim($("#beneAcctCcy").val())!="" && $.trim($("#beneAcctGl").val())!="" && $.trim($("#beneAcctSubGl").val())!="" && $.trim($("#beneAcctNo").val()!="")){
  	if("S" == feePayer){
			//当【画：费用信息.手续费支付方】为‘S：Shipper’时，将【画：费用信息.手续费账户】的值设为：【画：新建.受益人账户】
	    $("[name='data/BcMntnOpDtlVO/feeAcctCcy']").val($("#beneAcctCcy").val());
			$("[name='data/BcMntnOpDtlVO/feeAcctGl']").val($("#beneAcctGl").val());
			$("[name='data/BcMntnOpDtlVO/feeAcctSubGl']").val($("#beneAcctSubGl").val());
			$("[name='data/BcMntnOpDtlVO/feeAcctNo']").val($("#beneAcctNo").val());
			//调用2.36）【画：费用信息.手续费账户.币种】输入值变化时处理 
			changeFeeAcctCcy();
		}
		if("Y" == trasf2ndBene){
			//当【画：信用证信息.转让第二受益人】为‘Y’时，将【画：信用证信息.第一受益人账户】的值设为：【画：新建.受益人账户】
			$("[name='data/BcMntnOpDtlVO/bene1stAcctCcy']").val($("#beneAcctCcy").val());
			$("[name='data/BcMntnOpDtlVO/bene1stAcctGl']").val($("#beneAcctGl").val());
			$("[name='data/BcMntnOpDtlVO/bene1stAcctSubGl']").val($("#beneAcctSubGl").val());
			$("[name='data/BcMntnOpDtlVO/bene1stAcctNo']").val($("#beneAcctNo").val());
		}	
	}else{
		//【画：新建.受益人账户】为空时
		if("S" == feePayer){
		//当【画：费用信息.手续费支付方】为‘S：Shipper’时，清空【画：费用信息.手续费账户】，【画：费用信息.Exchange信息(手续费).EX.Method】的值 
		  $("[name='data/BcMntnOpDtlVO/feeAcctCcy']").val("");
			$("[name='data/BcMntnOpDtlVO/feeAcctGl']").val("");
			$("[name='data/BcMntnOpDtlVO/feeAcctSubGl']").val("");
			$("[name='data/BcMntnOpDtlVO/feeAcctNo']").val("");	
			$("[name='data/BcMntnOpDtlVO/feeExMethod']").val("");			
		}
		if("Y" == trasf2ndBene){
		//当【画：信用证信息.转让第二受益人】为‘Y’时，清空【画：信用证信息.第一受益人账户】的值		
			$("[name='data/BcMntnOpDtlVO/bene1stAcctCcy']").val("");
			$("[name='data/BcMntnOpDtlVO/bene1stAcctGl']").val("");
			$("[name='data/BcMntnOpDtlVO/bene1stAcctSubGl']").val("");
			$("[name='data/BcMntnOpDtlVO/bene1stAcctNo']").val("");
		}
	}
	//调用组件列表【取得客户信息详细】，参数：分行号、客户CIF，取得【DM：客户信息明细.特殊经济区内企业类型】，设值到【画：新建.保税区属性】  
		jsonStr = {"functionName":"getCustmerInfo", "branchCode":branchCode, "custNo":beneCif, "custZhName":$("#beneName").val()};
		commAjaxPost(jsonStr, function(data){
			if(!$.isEmptyObject(data)){
				$("[name='data/BcMntnOpDtlVO/bondedAreaAttbt']").val(data.bondedAreaAttbt);
			}
		}, 
		true);	
}


/**
*方法说明：【画：新建.受益人账户】输入值变化时处理

 2.7.1）用户在账号输入框中输入六位短帐号后，调用组件列表【E90250】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号    
 2.7.2）用户在输入账户后，调用组件列表【E90260】，参数：长帐号，分行号，取得客户CIF+客户名称    
 2.7.3）参照2.6.3）调用IV共通组件【E90280】方法，获取【画：新建.受益人账户】的1和2    
 2.7.4）调用组件列表【E00210】，参数：分行号、客户CIF，取得【DM：客户信息明细.特殊经济区内企业类型】，设值到【画：新建.保税区属性】 
 
*返回值:
*    无
*参数：
*    无
*/
function changeBeneAcct() {
	
	//【画：费用信息.手续费支付方】
	var feePayer = $("[name='data/BcMntnOpDtlVO/feePayer']:checked").val();
	//新建.受益人账户.币种
	var beneAcctCcy = $("[name='data/BcMntnOpDtlVO/beneAcctCcy']");
	//新建.受益人账户.Gl
	var beneAcctGl = $("[name='data/BcMntnOpDtlVO/beneAcctGl']");
	//新建.受益人账户.SUB Gl
	var beneAcctSubGl = $("[name='data/BcMntnOpDtlVO/beneAcctSubGl']");
	//新建.受益人账户.账号
	var beneAcctNo = $("[name='data/BcMntnOpDtlVO/beneAcctNo']");
	//分行号
	var branchCode = $("#artCommonOrgCode").val();
	
	//用户在账号输入框中输入六位短帐号后，调用共通组件【短账号查长账号】，参数：短帐号，分行号，取得币种+GL+SUB GL+账号    
	//if($.trim(beneAcctNo.val()) != ""){
	//	shortAccountRegist("beneAcctNo",branchCode,"beneAcctCcy","beneAcctGl","beneAcctSubGl");
	//}
	//用户在输入账户后，调用共通组件【长账号调客户明细】，参数：长帐号，分行号，取得客户CIF+客户名称
	//longAccountRegist("beneAcctNo",branchCode,"beneAcctCcy","beneAcctGl","beneAcctSubGl","beneCif","beneName");   
	//调用共通组件【CIF获取可用账户】，获取【画：新建.受益人账户】的1和2    
	if($.trim($("#beneAcctCcy").val())!="" && $.trim($("#beneAcctGl").val())!="" && $.trim($("#beneAcctSubGl").val())!="" && $.trim($("#beneAcctNo").val()!="")){
		if("S" == feePayer){
			//当【画：费用信息.手续费支付方】为‘S：Shipper’时，将【画：费用信息.手续费账户】的值设为：【画：新建.受益人账户】
			 $("[name='data/BcMntnOpDtlVO/feeAcctCcy']").val($("#beneAcctCcy").val());
			$("[name='data/BcMntnOpDtlVO/feeAcctGl']").val($("#beneAcctGl").val());
			$("[name='data/BcMntnOpDtlVO/feeAcctSubGl']").val($("#beneAcctSubGl").val());
			$("[name='data/BcMntnOpDtlVO/feeAcctNo']").val($("#beneAcctNo").val());
				//调用2.36）【画：费用信息.手续费账户.币种】输入值变化时处理 
			changeFeeAcctCcy();
		}
		if("Y" == trasf2ndBene){
			//当【画：信用证信息.转让第二受益人】为‘Y’时，将【画：信用证信息.第一受益人账户】的值设为：【画：新建.受益人账户】
			$("[name='data/BcMntnOpDtlVO/bene1stAcctCcy']").val($("#beneAcctCcy").val());
			$("[name='data/BcMntnOpDtlVO/bene1stAcctGl']").val($("#beneAcctGl").val());
			$("[name='data/BcMntnOpDtlVO/bene1stAcctSubGl']").val($("#beneAcctSubGl").val());
			$("[name='data/BcMntnOpDtlVO/bene1stAcctNo']").val($("#beneAcctNo").val());
		}	
	}else{
		//【画：新建.受益人账户】为空时
		if("S" == feePayer){
		//当【画：费用信息.手续费支付方】为‘S：Shipper’时，清空【画：费用信息.手续费账户】，【画：费用信息.Exchange信息(手续费).EX.Method】的值 
		  $("[name='data/BcMntnOpDtlVO/feeAcctCcy']").val("");
			$("[name='data/BcMntnOpDtlVO/feeAcctGl']").val("");
			$("[name='data/BcMntnOpDtlVO/feeAcctSubGl']").val("");
			$("[name='data/BcMntnOpDtlVO/feeAcctNo']").val("");	
			$("[name='data/BcMntnOpDtlVO/feeExMethod']").val("");			
		}
		if("Y" == trasf2ndBene){
		//当【画：信用证信息.转让第二受益人】为‘Y’时，清空【画：信用证信息.第一受益人账户】的值		
			$("[name='data/BcMntnOpDtlVO/bene1stAcctCcy']").val("");
			$("[name='data/BcMntnOpDtlVO/bene1stAcctGl']").val("");
			$("[name='data/BcMntnOpDtlVO/bene1stAcctSubGl']").val("");
			$("[name='data/BcMntnOpDtlVO/bene1stAcctNo']").val("");
		}	
	}
	//调用组件列表【取得客户信息详细】，参数：分行号、客户CIF，取得【DM：客户信息明细.特殊经济区内企业类型】，设值到【画：新建.保税区属性】  
		jsonStr = {"functionName":"getCustmerInfo", "branchCode":branchCode, "custNo":$("#beneCif").val(), "custZhName":$("#beneName").val()};
		commAjaxPost(jsonStr, function(data){
			if(!$.isEmptyObject(data)){
				$("[name='data/BcMntnOpDtlVO/bondedAreaAttbt']").val(data.bondedAreaAttbt);
			}
		}, 
		true);	
}

/**
*方法说明：【画：信用证信息.开证行.行号】输入值变化时处理

2.21）【画：信用证信息.开证行.行号】输入值变化时处理         
 2.21.1）调用共通组件【自动记忆功能】的【精确匹配】功能，取得Swift        
 2.21.2）调用组件列表【E00370】，参数：银行代码，取得名称和地址        
 2.21.3）当【画：信用证信息.寄单行同开证行】为‘Y’时：        
   将【画：信用证信息.寄单行.行号】的值设为：【画：信用证信息.开证行.行号】      
   将【画：信用证信息.寄单行.Swift】的值设为：【画：信用证信息.开证行.Swift】      
   将【画：信用证信息.寄单行.名称】的值设为：【画：信用证信息.开证行.名称】      
   将【画：信用证信息.寄单行.地址】的值设为：【画：信用证信息.开证行.地址】  
 
*返回值:
*    无
*参数：
*    无
*/
function changeIssueBankCode(){

	//【画：信用证信息.开证行.行号】  
	var issueBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']");
	//【画：信用证信息.开证行.Swift】  
	var issueBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']");
	//【画：信用证信息.开证行.名称】   
	var issueBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']");
	//【画：信用证信息.开证行.地址】 
	var issueBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']");
	
	//【画：信用证信息.寄单行.行号】
	var dispchDocBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']");
	//【画：信用证信息.寄单行.Swift】
	var dispchDocBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']");
	//【画：信用证信息.寄单行.名称】
	var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']");
	//【画：信用证信息.寄单行.地址】
	var dispchDocBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']");
	
	//【画：信用证信息.开证行同寄单行】
	var dispchBankEqIssueFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked");
	
	// 调用共通组件【自动记忆功能】的【精确匹配】功能，取得Swift  
	//精确匹配注册
	var types = new Array("issueBankSwift");
	registerExact($("#artCommonOrgCode"), "823002-024-KZHHH", "issueBankCode", types,"");
	
	//调用组件列表【取得SMILE银行信息】，参数：银行代码，取得名称和地址
	jsonStr = {"functionName":"getSmileBankInfo", "bankCode":issueBankCode};
	commAjaxPost(jsonStr,function(data){
		if(!$.isEmptyObject(data)) {
			issueBankName.val(data.getNmcst1 + data.getNmcst2);
			issueBankAddr.val(data.getAdcsm1 + data.getAdcsm2 + data.getAdcsm3 + data.getAdcsm4);
		}
	});		
	if("Y" == $.trim(dispchBankEqIssueFlg.val())){
		//当【画：信用证信息.寄单行同开证行】为‘Y’时,//将【画：信用证信息.寄单行】的值设为：【画：信用证信息.开证行】
		dispchDocBankCode.val($.trim(issueBankCode.val()));	
		dispchDocBankSwift.val($.trim(issueBankSwift.val()));
		dispchDocBankName.val($.trim(issueBankName.val()));	
		dispchDocBankAddr.val($.trim(issueBankAddr.val()));
		
	}	
}

/**
*方法说明：【画：信用证信息.寄单行.行号】输入值变化时处理 

*返回值:
*    无
*参数：
*    无
*/
function changeLcDispchDocBankCode(){
	
	//分行号
	var branchCode = $("#artCommonOrgCode").val();
	
	//寄单行行号
	var dispchDocBankCode = $("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/dispchDocBankCode']").val();
		
	//【画：SMILE记账.寄单行行号】等于【画：信用证信息.寄单行.行号】
	$("[name='data/BcMntnOpDtlVO/smileDispchDocBankCode']").val(dispchDocBankCode);
	
	
	//调用共通组件【自动记忆功能】的【精确匹配】功能，取得Swift
	//精确匹配注册
	var types = new Array("lcDispchDocBankSwift");
	registerExact($("#artCommonOrgCode"), "823002-025-JDHHH", "lcDispchDocBankCode", types,"");
	
	//调用业务间函数的【取得SMILE银行信息】方法，取得名称和地址
	jsonStr = {"functionName":"getSmileBankInfo", "branchCode":branchCode, "bankCode":$("#lcDispchDocBankCode").val()};
	commAjaxPost(jsonStr, function(data){
		
		$("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/dispchDocBankName']").val(data.getNmcst1 + data.getNmcst2);
		$("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/dispchDocBankAddr']").val(data.getAdcsm1 + data.getAdcsm2 + data.getAdcsm3 + data.getAdcsm4);
	});
}

/**
*方法说明：【画：信用证信息.偿付行.行号】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeReimbBankCode(){
	
	//分行号
	var branchCode = $("#artCommonOrgCode").val();
	
	//调用共通组件【自动记忆功能】的【精确匹配】功能，取得Swift
	//精确匹配注册
	var types = new Array("reimbBankSwift");
	registerExact($("#artCommonOrgCode"), "823002-026-CFHHH", "reimbBankCode", types,"");
	
	//调用业务间函数的【取得SMILE银行信息】方法，取得名称和地址
	jsonStr = {"functionName":"getSmileBankInfo", "branchCode":branchCode, "bankCode":$("#reimbBankCode").val()};
	commAjaxPost(jsonStr, function(data){
		
		$("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/reimbBankName']").val(data.getNmcst1 + data.getNmcst2);
		$("[name='data/BcMntnOpDtlVO/expLCMntnOpDtlVO/reimbBankAddr']").val(data.getAdcsm1 + data.getAdcsm2 + data.getAdcsm3 + data.getAdcsm4);
	});
}

/**
*方法说明：【画：非信用证信息.寄单行.行号】输入值变化时处理
*返回值：
*		无
*参数：
*		无
*/
function changeComLcDispchDocBankCode(){
	
	//分行号
	var branchCode = $("#artCommonOrgCode").val();
	
	//寄单行行号
	var dispchDocBankCode = $("[name='data/BcMntnOpDtlVO/dispchDocBankCode']").val();
	
	//【画：SMILE记账.寄单行行号】等于【画：非信用证信息.寄单行.行号】
	$("[name='data/BcMntnOpDtlVO/smileDispchDocBankCode']").val(dispchDocBankCode);
	
	//调用共通组件【自动记忆功能】的【精确匹配】功能，取得Swift
	//精确匹配注册
	var types = new Array("notLcDispchDocBankSwift");
	registerExact($("#artCommonOrgCode"), "823002-025-JDHHH", "notLcDispchDocBankCode", types ,"");
	
	//调用业务间函数的【取得SMILE银行信息】方法，取得名称和地址
	jsonStr = {"functionName":"getSmileBankInfo", "branchCode":branchCode, "bankCode":$("#notLcDispchDocBankCode").val()};
	commAjaxPost(jsonStr, function(data){
		
		$("[name='data/BcMntnOpDtlVO/dispchDocBankName']").val(data.getNmcst1 + data.getNmcst2);
		$("[name='data/BcMntnOpDtlVO/dispchDocBankAddr']").val(data.getAdcsm1 + data.getAdcsm2 + data.getAdcsm3 + data.getAdcsm4);
	});
}

 /**
*方法说明：【画：信用证信息.第一受益人账户】输入值变化时处理
**返回值:
*    无
*参数：
*    无：
*/
//function changeBene1stAcct(){
//	//分行号
//	var branchCode = $("#artCommonOrgCode").val();
//	
//	if($.trim(acctNo.val()) != ""){
//		shortAccountRegist("bene1stAcctNo",branchCode,"bene1stAcctCcy","bene1stAcctGl","bene1stAcctSubGl");
//	}	
//
//}

 /**
*方法说明：【画：单据信息.清算行账户】输入值变化时处理
**返回值:
*    无
*参数：
*    无：
*/
//function changeNoBookClrBankAcct(){
//	//分行号
//	var branchCode = $("#artCommonOrgCode").val();
//	
//	if($.trim(acctNo.val()) != ""){
//		shortAccountRegist("bcMntnOpDtlVOclrBankAcctNo",branchCode,"bcMntnOpDtlVOclrBankAcctCcy","bcMntnOpDtlVOclrBankAcctGL","bcMntnOpDtlVOclrBankAcctSubGL");
//	}	
//} 
 /**
*方法说明：【画：费用信息.手续费账户】输入值变化时处理
**返回值:
*    无
*参数：
*    无：
*/
//function changeNoBookFeeAcct(){
//	//分行号
//	var branchCode = $("#artCommonOrgCode").val();
//	
//	if($.trim(acctNo.val()) != ""){
//		shortAccountRegist("bcInfoVOfeeAcctNo",branchCode,"bcInfoVOfeeAcctCcy","bcInfoVOfeeAcctGL","bcInfoVOfeeAcctSubGL");
//	}	
//}



/**
*方法说明：【【画：信用证信息.信用证编号.检索】按钮点击时处理
*返回值:
*    无
*参数：
*    无
*/
function clickLcNoSelect(){
	//【画：信用证信息.信用证编号】不得为空，否则报错（VALIDATE_00018）
	FormValidate.check(unComForLcNoSelect()).doShow().success(function(){
	//校验通过后，清空【画：信用证信息】板块的信息 
	
		$(":text","#LcInfo").val("");
		$(":checkbox,:radio","#LcInfo").prop("checked",false);
		$("select","#LcInfo").val("");
	
	
		//调用组件类表【I00200】，参数：信用证编号，获取指定信用证信息和保兑信息
		jsonStr = {"functionName":"getLCInfoWithConfirmationCommand", "lcNo":$("#lcNo").val(), "branchCode":branchCode};
		commAjaxPost(jsonStr, function(expLcResult){
			//检索结果为0件
			if(!expLcResult.success){
				
				// 将【Hidden：我行通知信用证】的值设为：N
				$("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val("N");

				//设置信用证板块的初期化
				$("#lcNo").setReadOnly(false);
				$("#lcAmtCcy").setReadOnly(false);
				$("#expLcAmt").setReadOnly(false);
				$("#explcBalCcy").setReadOnly(true);
				$("#expLcBalAmt").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate']").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate']").setReadOnly(false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg", "", "N", false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName']").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']").setReadOnly(false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/osaNraFlg", "", "N", false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg", "", "Y", false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg", "", "N", false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg", "", "N", true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']").setReadOnly(false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']").prop("checked",false).setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/confmdTKind']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/confmdPrmryRefNo']").setReadOnly(true);
				$("[name='data/BcMntnOpDtlVO/confmdSubRefNo']").setReadOnly(true);
				setRadioValue("data/BcMntnOpDtlVO/perfmConfmDuties", "", "Y", true);
				$("[name='data/BcMntnOpDtlVO/confmdRmrk']").setReadOnly(true);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankAccptceFlg", "", "N", false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg", "", "N", false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/alertCountry']").val("N").setReadOnly(false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/agcBankFlg", "", "Y", false);
				setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/domstcLcFlg", "", "N", false);
				setRadioValue("data/BcMntnOpDtlVO/combinedLcFlg", "", "N", false);
				$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/otherItem']").setReadOnly(false);
				setRadioValue("data/BcMntnOpDtlVO/trasf2ndBene", "", "N", true);
				
				//调用组件列表【I00240留行信用证共通服务】，校验指定客户是否为留行客户
				jsonStr = {"functionName":"judgeKeepInBankCustomerCommand", "branchCode":branchCode, "cif":$("#beneCif").val()};
				commAjax(jsonStr, function(kicResult){
					
					//检索结果为0时
					if(!kicResult.success){
						
						//【画：信用证信息.留行信用证】默认为不勾选
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").prop("checked", false).setReadOnly(false);
						//【画：信用证信息.留行日期】不可编辑
						$("[name='data/ExpLCMntnOpDtlVO/kibLcDate']").setReadOnly(true);
					}
					//检索结果不为0时	
					else {
					
						//【画：信用证信息.留行信用证】默认勾选
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").prop("checked", true).setReadOnly(false);
						//【画：信用证信息.留行日期】可编辑，默认等于系统日期
						$("[name='data/ExpLCMntnOpDtlVO/kibLcDate']").val(getCommonSysDate()).setReadOnly(false);
					}
				});
				
				$("#bbCombLcNo").hide();
				$("#trasfTable").hide();

				//清空【画：单据信息.国别】的值
				$("[name='data/BcMntnOpDtlVO/natnlty']").val("");
				
			}
			//当检索结果等于1件时
			else{
				
				//当【DM：出口信用证信息.信用证币种】不等于【画：新建.汇票金额.币种】时,显示报错信息（SP_VALIDATE_823_002）
				if($("#bxCcy").val() != expLcResult.result[0].lcCcy){
					return $.getExceptionMsg('ART00099-E',["出口信用证信息.信用证币种"]);
				}
				
				//当【DM：出口信用证信息.受益人客户编号】不等于【画：新建.受益人.客户CIF】时,显示报错信息（SP_VALIDATE_823_039）：信用证的受益人必须与交易的受益人保持一致。
				if($("#beneCif").val() != expLcResult.result[0].beneCif){
					return $.getExceptionMsg('ART00075-E');
				}
				
				//当检索结果为1件且【DM：保兑基本信息.保兑关闭日期】为空时
				if("" == expLcResult.result[1].confmdClsDate){
					
					//取得【DM：保兑基本信息.保兑T-Kind】
					var confmdTKind = expLcResult.result[1].confmdTKind;
					//取得【DM：保兑基本信息.保兑交易主参号】
					var confmdPrmryRefNo = expLcResult.result[1].confmdPrmryRefNo;
					//取得【DM：保兑基本信息.保兑交易子参号】
					var confmdSubRefNo = expLcResult.result[1].confmdSubRefNo;
				}
				
				//当【DM：出口信用证信息.来源】为‘1：信用证通知’时
				if("1" == expLcResult.result[0].src){
					
					// 将【Hidden：我行通知信用证】的值设为：Y
					$("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val("Y");
				
					//设置信用证板块的初期化
					$("#lcNo").val(expLcResult.result[0].lcNo).setReadOnly(false);
					$("#lcAmtCcy").val(expLcResult.result[0].lcAmtCcy).setReadOnly(true);
					$("#expLcAmt").val(expLcResult.result[0].expLcAmt).setReadOnly(true);
					$("#explcBalCcy").val(expLcResult.result[0].lcBalCcy).setReadOnly(true);
					$("#expLcBalAmt").val(expLcResult.result[0].lcBalAmt).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate']").val(expLcResult.result[0].issueDate).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate']").val(expLcResult.result[0].dueDate).setReadOnly(true);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg", expLcResult.result[0].bene2ndFlg, "N", false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").val(expLcResult.result[0].trastBank);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").val(expLcResult.result[0].trastBankNatnlty);					
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName']").val(expLcResult.result[0].imptrName).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']").val(expLcResult.result[0].imptrNatnlty).setReadOnly(false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/osaNraFlg", expLcResult.result[0].osaNraFlg, "N", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg", expLcResult.result[0].dispchBankEqIssueFlg, "Y", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg", expLcResult.result[0].withReimbsBankFlg, "N", false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']").val(expLcResult.result[0].issueBankCode).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']").val(expLcResult.result[0].issueBankSwift).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']").val(expLcResult.result[0].issueBankName).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']").val(expLcResult.result[0].issueBankAddr).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").val(expLcResult.result[0].dispchDocBankCode);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").val(expLcResult.result[0].dispchDocBankSwift);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").val(expLcResult.result[0].dispchDocBankName);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").val(expLcResult.result[0].dispchDocBankAddr);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").val(expLcResult.result[0].reimbBankCode);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").val(expLcResult.result[0].reimbBankSwift);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").val(expLcResult.result[0].reimbBankName);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").val(expLcResult.result[0].reimbBankAddr);
					setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg", expLcResult.result[0].ourBankConfmdFlg, "N", true);
					$("[name='data/BcMntnOpDtlVO/confmdTKind']").val(confmdTKind).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdPrmryRefNo']").val(confmdPrmryRefNo).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdSubRefNo']").val(confmdSubRefNo).setReadOnly(true);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankAccptceFlg", expLcResult.result[0].ourBankAccptceFlg, "N", false);
					setRadioValue("data/ExpLCMntnOpDtlVO/trasfLcFlg", expLcResult.result[0].trasfLcFlg, "N", true);
					setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg", expLcResult.result[0].kibLcFlg, "N", true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").val(kibLcDate);
					
					//※12 当【DM：出口信用证信息.留行信用证标志】为‘Y’时，【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】不可编辑
					if($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").prop("checked")){
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").setReadOnly(true);
					}else{
						//调用组件列表【I00240留行信用证共通服务】，参数：客户CIF，校验指定客户是否为留行客户 
						jsonStr = {"functionName":"judgeKeepInBankCustomerCommand", "branchCode":branchCode, "cif":$("#beneCif").val()};
						commAjax(jsonStr, function(kicResult){
							if(kicResult.success){
								//    检索结果等于1件时（组件列表返回true），【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】可编辑，
								//【画：信用证信息.留行信用证】默认勾选，【画：信用证信息.留行日期】默认等于系统日期
								setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg", expLcResult.result[0].kibLcFlg, "Y", false);
								$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").val(getCommonSysDate()).setReadOnly(false);
							}else{
								//    检索结果等于0件时（组件列表返回false），【画：信用证信息.留行信用证】可编辑，默认为不勾选；【画：信用证信息.留行日期】不可编辑
								setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg", expLcResult.result[0].kibLcFlg, "N", false);
								$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").setReadOnly(true);
							}
						});
					}
					
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/domstcLcFlg", expLcResult.result[0].domstcLcFlg, "N", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/alertCountry", expLcResult.result[0].alertCountry, "4", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/agcBankFlg", expLcResult.result[0].agcBankFlg, "Y", false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/otherItem']").val(expLcResult.result[0].otherItem).setReadOnly(false);
					
					// ※1 当【画：信用证信息.第二受益人】为‘Y’时
					if("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked").val())){
					
						//【画：信用证信息.中转行】，【画：信用证信息.中转行国别】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").setReadOnly(false);
					}
					//当【画：信用证信息.第二受益人】为空或者为‘N’时
					else {
						//【画：信用证信息.中转行】，【画：信用证信息.中转行国别】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").setReadOnly(true);
					}
					
					// ※2 当【画：信用证信息.有偿付行】为‘Y’时
					if("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val())) {
					
						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】可编辑
						setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg", expLcResult.result[0].allowTelegReimbsFlg, "N", false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").setReadOnly(false);
					}
					// 当【画：信用证信息.有偿付行】为空或者为‘N’时
					else {
						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg", expLcResult.result[0].allowTelegReimbsFlg, "N", true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").setReadOnly(true);
					}
					
					// ※3 当【画：信用证信息.寄单行同开证行】为‘Y’时
					if("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked").val())) {
					
						// 【画：信用证信息.寄单行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(true);
					}
				
					// 当【画：信用证信息.寄单行同开证行】为空或者为‘N’时
					else {
					
						// 【画：信用证信息.寄单行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(false);
					}
					
					// ※4 当【画：信用证信息.我行保兑】为‘Y’时
					if($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']").is(":checked")) {
						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】可编辑
						setRadioValue("data/BcMntnOpDtlVO/perfmConfmDuties", "Y", "Y", false);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']").setReadOnly(false);
					}
					// 当【画：信用证信息.我行保兑】为‘N’时
					else {
						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/perfmConfmDuties", "Y", "Y", true);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']").setReadOnly(true);
					}
					
					// ※7 当【画：信用证信息.我行保兑】为‘Y’时
					if($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']").is(":checked")) {
				
						// 【画：信用证信息.Combined LC】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/combinedLcFlg", "N", "N", true);
					}
					// 当【画：信用证信息.我行保兑】为‘N’时
					else {
				
						// 【画：信用证信息.Combined LC】可编辑
						setRadioValue("data/BcMntnOpDtlVO/combinedLcFlg", "N", "N", false);
					}
					// ※8 当【画：信用证信息.转让信用证】为‘Y’且【Hidden：我行通知信用证】为‘Y’时，【画：信用证信息.转让第二受益人】可编辑
					if("Y" == $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']").val() && "Y" == $("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val()){
						setRadioValue("data/BcMntnOpDtlVO/trasf2ndBene", "N", "N", false);
					}else{
						//当【画：信用证信息.转让信用证】为‘N’或【Hidden：我行通知信用证】为‘N’时，【画：信用证信息.转让第二受益人】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/trasf2ndBene", "N", "N", true);
					}

					$("#bbCombLcNo").hide();
					$("#trasfTable").hide();

				}
				//当【DM：出口信用证信息.来源】不为‘1：信用证通知’时
				else{
					
					// 将【Hidden：我行通知信用证】的值设为：N
					$("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val("N");
					
					$("#lcNo").val(expLcResult.result[0].lcNo).setReadOnly(false);
					$("#lcAmtCcy").val(expLcResult.result[0].lcAmtCcy).setReadOnly(false);
					$("#expLcAmt").val(expLcResult.result[0].expLcAmt).setReadOnly(false);
					$("#explcBalCcy").val(expLcResult.result[0].lcBalCcy).setReadOnly(true);
					$("#expLcBalAmt").val(expLcResult.result[0].lcBalAmt).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate']").val(expLcResult.result[0].issueDate).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate']").val(expLcResult.result[0].dueDate).setReadOnly(false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg", expLcResult.result[0].bene2ndFlg, "N", false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").val(expLcResult.result[0].trastBank);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").val(expLcResult.result[0].trastBankNatnlty);					
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName']").val(expLcResult.result[0].imptrName).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']").val(expLcResult.result[0].imptrNatnlty).setReadOnly(false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/osaNraFlg", expLcResult.result[0].osaNraFlg, "N", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg", expLcResult.result[0].dispchBankEqIssueFlg, "Y", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg", expLcResult.result[0].withReimbsBankFlg, "N", false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']").val(expLcResult.result[0].issueBankCode).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']").val(expLcResult.result[0].issueBankSwift).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']").val(expLcResult.result[0].issueBankName).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']").val(expLcResult.result[0].issueBankAddr).setReadOnly(false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").val(expLcResult.result[0].dispchDocBankCode);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").val(expLcResult.result[0].dispchDocBankSwift);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").val(expLcResult.result[0].dispchDocBankName);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").val(expLcResult.result[0].dispchDocBankAddr);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").val(expLcResult.result[0].reimbBankCode);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").val(expLcResult.result[0].reimbBankSwift);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").val(expLcResult.result[0].reimbBankName);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").val(expLcResult.result[0].reimbBankAddr);
					setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg", expLcResult.result[0].ourBankConfmdFlg, "N", true);
					$("[name='data/BcMntnOpDtlVO/confmdTKind']").val(confmdTKind).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdPrmryRefNo']").val(confmdPrmryRefNo).setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdSubRefNo']").val(confmdSubRefNo).setReadOnly(true);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankAccptceFlg", expLcResult.result[0].ourBankAccptceFlg, "N", false);
					setRadioValue("data/ExpLCMntnOpDtlVO/trasfLcFlg", expLcResult.result[0].trasfLcFlg, "N", false);
					setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg", expLcResult.result[0].kibLcFlg, "N", true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").val(kibLcDate);
					setRadioValue("data/BcMntnOpDtlVO/trasf2ndBene", "N", "N", true);
					
					//※12 当【DM：出口信用证信息.留行信用证标志】为‘Y’时，【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】不可编辑
					if($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").prop("checked")){
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").setReadOnly(true);
					}else{
						//调用组件列表【I00240留行信用证共通服务】，参数：客户CIF，校验指定客户是否为留行客户 
						jsonStr = {"functionName":"judgeKeepInBankCustomerCommand", "branchCode":branchCode, "cif":$("#beneCif").val()};
						commAjax(jsonStr, function(kicResult){
							if(kicResult.success){
								//    检索结果等于1件时（组件列表返回true），【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】可编辑，
								//【画：信用证信息.留行信用证】默认勾选，【画：信用证信息.留行日期】默认等于系统日期
								setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg", expLcResult.result[0].kibLcFlg, "Y", false);
								$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").val(getCommonSysDate()).setReadOnly(false);
							}else{
								//    检索结果等于0件时（组件列表返回false），【画：信用证信息.留行信用证】可编辑，默认为不勾选；【画：信用证信息.留行日期】不可编辑
								setCheckBoxValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg", expLcResult.result[0].kibLcFlg, "N", false);
								$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").setReadOnly(true);
							}
						});
					}
					
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/domstcLcFlg", expLcResult.result[0].domstcLcFlg, "N", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/alertCountry", expLcResult.result[0].alertCountry, "N", false);
					setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/agcBankFlg", expLcResult.result[0].agcBankFlg, "Y", false);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/otherItem']").val(expLcResult.result[0].otherItem).setReadOnly(false);
					
					// ※1 当【画：信用证信息.第二受益人】为‘Y’时
					if("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked").val())){
					
						//【画：信用证信息.中转行】，【画：信用证信息.中转行国别】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").setReadOnly(false);
					}
					//当【画：信用证信息.第二受益人】为空或者为‘N’时
					else {
						//【画：信用证信息.中转行】，【画：信用证信息.中转行国别】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']").setReadOnly(true);
					}
					
					// ※2 当【画：信用证信息.有偿付行】为‘Y’时
					if("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked").val())) {
					
						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】可编辑
						setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg", expLcResult.result[0].allowTelegReimbsFlg, "N", false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").setReadOnly(false);
					}
					// 当【画：信用证信息.有偿付行】为空或者为‘N’时
					else {
						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg", expLcResult.result[0].allowTelegReimbsFlg, "N", true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']").setReadOnly(true);
					}
					
					// ※3 当【画：信用证信息.寄单行同开证行】为‘Y’时
					if("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked").val())) {
					
						// 【画：信用证信息.寄单行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(true);
					}
				
					// 当【画：信用证信息.寄单行同开证行】为空或者为‘N’时
					else {
					
						// 【画：信用证信息.寄单行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']").setReadOnly(false);
					}
					
					// ※4 当【画：信用证信息.我行保兑】为‘Y’时
					if($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']").is(":checked")) {
						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】可编辑
						setRadioValue("data/BcMntnOpDtlVO/perfmConfmDuties", "Y", "Y", false);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']").setReadOnly(false);
					}
					// 当【画：信用证信息.我行保兑】为‘N’时
					else {
						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/perfmConfmDuties", "Y", "Y", true);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']").setReadOnly(true);
					}
					
					// ※7 当【画：信用证信息.我行保兑】为‘Y’时
					if($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']").is(":checked")) {
				
						// 【画：信用证信息.Combined LC】不可编辑
						setRadioValue("data/BcMntnOpDtlVO/combinedLcFlg", "N", "N", true);
					}
					// 当【画：信用证信息.我行保兑】为‘N’时
					else {
				
						// 【画：信用证信息.Combined LC】可编辑
						setRadioValue("data/BcMntnOpDtlVO/combinedLcFlg", "N", "N", false);
					}
				
					$("#bbCombLcNo").hide();
					$("#trasfTable").hide();
				}
				//将【画：单据信息.国别】的值设为：【画：信用证信息.进口商国别】  	
				$("[name='data/BcMntnOpDtlVO/natnlty']").val($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']").val());
			}
		//将【Hidden：信用证编号】的值设为：【画：信用证信息.信用证编号】
		$("[name='data/BcMntnOpDtlVO/tmpLcNo']").val(lcNo);
		});
	}); 
}


/**
*方法说明：【画：入账.进待核查】勾选时处理 
*返回值:
*    无
*参数：
*    无：
*/
function checkedValidatnFlg(){
	
	//分行号
	var branchCode = $("#artCommonOrgCode").val();
	//【画：新建.受益人.客户CIF】
	var beneCif = $("#beneCif").val();
	var beneAcctCcy = $("#beneAcctCcy").val();
	
	if($("[name='data/BcBookOpDtlVO/validatnFlg']").prop("checked")){
		//当【画：入账.进待核查】勾选时
		//【画：入账.待核查账户】，【画：入账.客户等级】设为可编辑
		$("#validatnAcctCcy").setReadOnly(false);
		$("#validatnAcctGl").setReadOnly(false);
		$("#validatnAcctSubGl").setReadOnly(false);
		$("#validatnAcctNo").setReadOnly(false);
		$("[name='data/BcBookOpDtlVO/custLv']").setReadOnly(false);
		//调用组件列表【待核查账户取得（通过客户CIF,币种）】，参数：分行号、客户CIF、币种，取得待核查账户信息，设值到【画：入账.待核查账户】  
		jsonStr = {"functionName":"getCheckAccount", "branchCode":branchCode, "ccy":beneAcctCcy, "cif":beneCif};
		commAjaxPost(jsonStr, function(data){
			if(!!data && !$.isEmptyObject(data)){
				$("#validatnAcctCcy").val(data.validatnAcctCcy);
				$("#validatnAcctGl").val(data.validatnAcctGl);
				$("#validatnAcctSubGl").val(data.validatnAcctSubGl);
				$("#validatnAcctNo").val(data.validatnAcctNo);
			}
		}, 
		true);
		//调用2.4）【画：入账.待核查账户】输入值变化时处理   
		changeValidatnAcct();		
		//【画：入账.定价】按钮设为不可点击
		$("#btn_price_costinfo").prop("disabled",true);
	}else{
		//清空【画：入账.待核查账户】，【画：入账.客户等级】，【画：入账.入账账户#1】，【画：入账.入账金额#1.币种】，【画：入账.Exchange信息#1.EX.Method】，【画：入账.账户性质#1】的值
		$("#validatnAcctCcy").val("");
		$("#validatnAcctGl").val("");
		$("#validatnAcctSubGl").val("");
		$("#validatnAcctNo").val("");
		$("[name='data/BcBookOpDtlVO/custLv']").val("");
		
		$("#bookAcctCcy1").val("");
		$("#bookAcctGl1").val("");
		$("#bookAcctSubGl1").val("");
		$("#bookAcctNo1").val("");
		
		$("#bookCcy1").val("");
		$("[name='data/BcBookOpDtlVO/exMethod1']").val("");
		$("#acctPropty2nd1").val("");
		$("#acctPropty3rd1").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty2ndCd1']").val("");
		$("[name='data/BcBookOpDtlVO/acctPropty3rdCd1']").val("");
		// 将【画：入账.待核查账户】，【画：入账.客户等级】设为不可编辑
		$("#validatnAcctCcy").setReadOnly(true);
		$("#validatnAcctGl").setReadOnly(true);
		$("#validatnAcctSubGl").setReadOnly(true);
		$("#validatnAcctNo").setReadOnly(true);
		$("[name='data/BcBookOpDtlVO/custLv']").setReadOnly(true);
		// 【画：入账.定价】按钮设为可点击
		$("#btn_price_costinfo").prop("disabled",false);
	}
}


/**
*方法说明：点击【画：信用证信息.Combined LC信息.信用证编号#2-#5.检索】按钮时处理逻辑
*返回值:
*    无
*参数：
*    无
*/
function clickCombinedLCSelect(index){
	
	var lcNo = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcNo']");
	var lcCcy = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcCcy']");
	var lcAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcAmt']");
	var drawnCcy = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/drawnCcy']");
	var drawnAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/drawnAmt']");
	var lcBalCcy = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcBalCcy']");
	var lcBalAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcBalAmt']");
	var branchCode = $("#artCommonOrgCode").val();
	
	//【画：信用证信息.Combined LC信息.信用证编号#2-#5】不得为空，否则报错（VALIDATE_00018）
		FormValidate.check(unComCombinedLCSelect(lcNo)).doShow().success(function(){
		//校验通过后
		//清空【画：信用证信息.Combined LC信息】中当前检索按钮所属行的【画：信用证信息.Combined LC信息.信用证金额.金额】信息
		lcAmt.val("");
		//清空【画：信用证信息.Combined LC信息】中当前检索按钮所属行的【画：信用证信息.Combined LC信息.信用证余额.金额】信息
		drawnAmt.val("");
		//清空【画：信用证信息.Combined LC信息】中当前检索按钮所属行的【画：信用证信息.Combined LC信息.drawn amount.金额】信息
		lcBalAmt.val("");
	});
	
	//调用组件类表【I00220】，参数：信用证编号，获取指定信用证信息和保兑信息
	jsonStr = {"functionName":"GetLCInfoWithConfirmationCommand", "lcNo":lcNo.val(), "branchCode":branchCode};
	commAjax(jsonStr, function(comLcResult){
		
		//当检索结果等于1件时
		if(comLcResult.success){
			
			//进行数据校验
			if(($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmtCcy']").val() != comLcResult.result[0].lcCcy)
				|| ($("#beneCif").val() != comLcResult.result[0].beneCif) 
				|| ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName']").val() != comLcResult.result[0].imptrName)
				|| ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']").val() != comLcResult.result[0].issueBankName)
				|| ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']").val() != comLcResult.result[0].dispchDocBankName)){
				
				FormValidate.check(unComForLcNoSelect02()).doShow().success(function(){});
				
			}
			//校验通过后
			else{
			
				//将【画：信用证信息.Combined LC信息.信用证金额#2-#5.金额】的值设为：【DM：出口信用证信息.信用证金额】
				lcAmt.val(comLcResult.result[0].lcAmt);
				//将【画：信用证信息.Combined LC信息.信用证余额#2-#5.金额】的值设为：【DM：出口信用证信息.信用证余额金额】
				lcBalAmt.val(comLcResult.result[0].lcBalAmt);
			}
		}
	});
}

/**
*方法说明：点击【画：信用证信息.转让编号.检索】按钮时处理逻辑    
*
*返回值:
*    无
*参数：
*    无
*/
function clickTrasfNo(){

	var lcNo = $("[name='data/BcMntnOpDtlVO/lcNo']");
	var trasfTKind = $("[name='data/BcMntnOpDtlVO/trasfTKind']");
	var trasfNoPrmryRefNo = $("[name='data/BcMntnOpDtlVO/trasfNoPrmryRefNo']");
	var trasfNoSubRefNo = $("[name='data/BcMntnOpDtlVO/trasfNoSubRefNo']");
	var branchCode = $("#artCommonOrgCode").val();

	//校验通过后
	FormValidate.check(unComClickTrasfNoValidate()).doShow().success(function(){
  	//清空转让信息表格的值  
 	 $(":text,textarea","#trasfTable").val("");
		$(":checkbox,:radio","#trasfTable").prop("checked",false);
		$("select","#trasfTable").val("");
  	//调用组件类表【I00230获取指定信用证的指定转让信息】，参数：信用证编号，转让编号，获取指定信用证的指定转让信息
 	 var trasfTKindNumber = trasfTKind.val()+"-"+trasfNoPrmryRefNo.val()+"-"+trasfNoSubRefNo.val();   
 	 jsonStr = {"functionName":"GetLCTransferInfoCommand", "lcNo":lcNo.val(), "branchCode":branchCode};
  	commAjax(jsonStr, function(data){
  		//将【画：信用证信息.第一受益人承担】的值设为：【DM：出口信用证转让信息.第一受益人承担标志】 
  		$("[name='data/BcMntnOpDtlVO/undtk1stBeneFlg']").val(data[0].undtk1stBeneFlg);    
   	 //将【画：信用证信息.第二受益人名称】的值设为：【DM：出口信用证转让信息.第二受益人名称】 
   	 $("[name='data/BcMntnOpDtlVO/bene2ndName']").val(data[0].bene2ndName);    
   	 //将【画：信用证信息.第二受益人通知行.Swift】的值设为：【DM：出口信用证转让信息.第二受益人通知行Swift编号】   
   	 $("[name='data/BcMntnOpDtlVO/bene2ndNoticeBankSwiftCode']").val(data[0].bene2ndNoticeBankSwiftCode);  
   	 //将【画：信用证信息.第二受益人通知行.名称】的值设为：【DM：出口信用证转让信息.第二受益人通知行】    
   	 $("[name='data/BcMntnOpDtlVO/bene2ndNoticeBankName']").val(data[0].bene2ndNoticeBankName);  
   	 //将【Hidden：转让编号】的值设为：【画：信用证信息.转让编号】 data/BcMntnOpDtlVO/tmpTrasfNo
   	 $("[name='data/BcMntnOpDtlVO/tmpTrasfNo']").val(trasfTKindNumber);  
 	 });
	});
}

/**
 * 点击【画：入账.定价】时数据校验
 * 
 */
function onClickBtnPricing(){

	//点击【画：入账.定价】时数据校验
	FormValidate.check(pricingValidate()).doShow().success(function(){
	
		//【画：新建.汇票金额.币种】
		var bxCcy = $.trim($("#bxCcy").val());
		//【画：入账.入账账户#1.币种】
		var bookAcctCcy1 = $("#bookAcctCcy1").val();
		//【画：入账.入账账户#2.币种】
		var bookAcctCcy2 = $("#bookAcctCcy2").val();
	
		var currencyPairList1 =new Array(8);
		var list = new array(2);
		currencyPairList1[0] = $("#prcCcy1").val();
		currencyPairList1[1] = "汇票币种";
		currencyPairList1[2] = $("#bookAcctCcy1").val();
		currencyPairList1[3] = "实际入账金额币种#1";
		currencyPairList1[4] = $("#prcCcy1").val();
		currencyPairList1[5] = $("#prcAmt1").val();
		currencyPairList1[6] = "汇票币种";
		currencyPairList1[7] = "1";
	
		var currencyPairList2 =new Array(8);
		currencyPairList2[0] = $("#prcCcy2").val();
		currencyPairList2[1] = "汇票币种";
		currencyPairList2[2] = $("#bookAcctCcy2").val();
		currencyPairList2[3] = "实际入账金额币种#2";
		currencyPairList2[4] = $("#prcCcy2").val();
		currencyPairList2[5] = $("#prcAmt2").val();
		currencyPairList2[6] = "汇票币种";
		currencyPairList2[7] = "2";
		if(!bookAcctCcy1 == bxCcy){
			list[0] = currencyPairList1;
		}
		if(!bookAcctCcy2 == bxCcy){
			list[1] = currencyPairList2;
		}
	
		popupDJ(
		$("#beneCif").val(),
		$("#beneName").val(),
		"受益人",
		$("[name='data/BcMntnOpDtlVO/tkind']").val(),
		$("[name='data/BcMntnOpDtlVO/txnPrmryRefNo']").val(),
		$("[name='data/BcMntnOpDtlVO/txnSubRefNo']").val(),
		list
		);
	});
}

/**
*方法说明：bop数据处理逻辑
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    无
*/
function generateBop() {	
	var rtnJSON;
	$.art.common.post('http://localhost:8080/default/dispatch/test',
	{ ReqType: 'Collection/CollBooking/genbop'
	  ,action: 'bop'},
	  function(data){
			data = eval('(' + data + ')');
			//success
			var json = {status:"success",result:[]};
			json.result = data.result;
			rtnJSON = JSON.stringify(json);
			},
		function(){
			//error

		},"json");
	return rtnJSON;
}	

/**
 * 转让编号
 * 
 * @return errMsg
 */
function unComClickTrasfNoValidate() {
	
	var errMsg = [];
	var validateResult;
	//【画：信用证信息.信用证编号】不得为空，否则报错（VALIDATE_00018）       
  //【画：信用证信息.转让编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("#lcNo").val(),"required",artI18N.Label.Label_COM_02151);
	if(validateResult.state == false){
		errMsg.push(validateResult.messages);
	}
	validateResult = $.art.Validator.validateBatch($("#trasfTKindNumber").val(),"required",artI18N.Label.Label_COM_02151);
	if(validateResult.state == false){
		errMsg.push(validateResult.messages);
	}
	if(errMsg.length > 0){
	 return errMsg;
	}
	return errMsg;
}

/**
 * 
 * @return errMsg
 */
function unComForLcNoSelect() {
	var errMsg = [];
	var validateResult;
	validateResult = $.art.Validator.validateBatch($("[name='data/BcMntnOpDtlVO/lcNo']").val(),"required",artI18N.Label.Label_COM_02151);	
	if (validateResult.state == false) {
		return validateResult.messages;
	}
	return errMsg;
}


/**
 * 
 * @return errMsg
 */			
function unComForLcNoSelect02(){
	// 显示报错信息（SP_VALIDATE_823_006）
	return $.getExceptionMsg('ART00094-E');
}

/**
 * 
 * @param  lcNo 信用证信息
 * @return errMsg
 */
function unComCombinedLCSelect(lcNo) {
	var errMsg = [];
	var validateResult;
	//【画：信用证信息.Combined LC信息.信用证编号#2-#5】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(lcNo.val(),"required",artI18N.artI18N.Label.Label_COM_02151);
	if(validateResult.state == false){
			return validateResult.messages;
	}
	return errMsg;
}

/**
*方法说明：点击【画：入账.定价】数据校验
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    无
*/
function pricingValidate(){
	var errMsg = [];
	var validateResult;

	//【画：新建.汇票金额.币种】
	var bxCcy = $.trim($("#bxCcy").val());
	//【画：入账.入账账户#1.币种】
	var bookAcctCcy1 = $("#bookAcctCcy1").val();
	//【画：入账.入账账户#2.币种】
	var bookAcctCcy2 = $("#bookAcctCcy2").val();
	
	//1- 当【画：入账.入账账户#1.币种】等于【画：新建.汇票金额.币种】且【画：入账.入账账户#2.币种】等于【画：新建.汇票金额.币种】时，不需要定价，显示报错信息（SP_VALIDATE_823_040）
	if(!SP_VALIDATE_823_040()){
		return $.getExceptionMsg('ART00074-E');
	}
	
	//2- 【画：入账.头寸金额.金额】不得为空，否则报错。（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch($("[name='data/BcBookOpDtlVO/posAmt']").val(),"required",artI18N.Label.Label_823_00013);	
	if (validateResult.state == false) {
		return validateResult.messages;
	}	

	//当【画：入账.入账账户#1.币种】不等于【画：新建.汇票金额.币种】时
	if(!bookAcctCcy1 == bxCcy){
		//1- 当【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#1.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
		if(!SP_VALIDATE_823_015(Ccy1)){
			return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_823_00057]);
		}		
		//2- 当【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#1.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
		if(!SP_VALIDATE_823_025(Ccy1)){
			return $.getExceptionMsg('ART00107-E',[artI18N.Label.Label_823_00057]);
		}		
		//3- 【画：入账.金额#1.金额】不得为空，否则报错。（VALIDATE_00018）
		validateResult = $.art.Validator.validateBatch($("#amt1").val(),"required",artI18N.Label.Label_COM_01570);	
		if (validateResult.state == false) {
			return validateResult.messages;
		}	
		//4- 【画：入账.定价金额#1.金额】不得为空，否则报错。（VALIDATE_00018）
		validateResult = $.art.Validator.validateBatch($("#prcAmt1").val(),"required",artI18N.Label.Label_823_00058);	
		if (validateResult.state == false) {
			return validateResult.messages;
		}	
		//5- 【画：入账.定价金额#1.金额】必须小于等于【画：入账.金额#1.金额】，否则报错（VALIDATE_00034）
		validateResult = $.art.Validator.validateBatch($("#prcAmt1").val(),"moneyLessthanEq["+$("#amt1").val()+"]",artI18N.Label.Label_823_00058,artI18N.Label.Label_COM_01570);	
			if (validateResult.state == false) {
			return validateResult.messages;
			}	
		//6- 当【画：入账.入两个账户】不勾选时，【画：入账.金额#1.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_031）
		if(!SP_VALIDATE_823_031()){
			return $.getExceptionMsg('ART00012-E',[artI18N.Label.Label_COM_01570,artI18N.Label.Label_823_00013]);
		}	
	}
	//当【画：费用信息.入账账户#2.币种】不等于【画：新建.汇票金额.币种】时
	if(!bookAcctCcy2 == bxCcy){
		//1- 当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#2.币种】不得输入CNY，否则报错（SP_VALIDATE_823_015）
		//2- 当【画：入账.入账账户#2.币种】不为空时，【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#2.币种】必须输入CNY，否则报错（SP_VALIDATE_823_025）
		if("" != $.trim(bookAcctCcy2)){
			if(!SP_VALIDATE_823_015(Ccy2)){
				return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_823_00057]);
			}
			if(!SP_VALIDATE_823_025(Ccy2)){
				return $.getExceptionMsg('ART00107-E',[artI18N.Label.Label_823_00057]);
			}
		}	
		//3- 当【画：入账.入两个账户】勾选时，【画：入账.金额#2.金额】不得为空，否则报错（SP_VALIDATE_823_027）
		//4- 当【画：入账.入两个账户】勾选时，【画：入账.定价金额#2.金额】不得为空，否则报错（SP_VALIDATE_823_027）
		if(!SP_VALIDATE_823_027("Amt")){
			return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01570]);
		}	
		if(!SP_VALIDATE_823_027("prcAmt2")){
			return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00058]);
		}	
		//5- 【画：入账.定价金额#2.金额】不为空时，必须小于等于【画：入账.金额#2.金额】，否则报错（VALIDATE_00034）
		if ($.trim($("prcAmt2").val()) != "") {
			validateResult = $.art.Validator.validateBatch($("#prcAmt2").val(),"moneyLessthanEq["+$("#amt2").val()+"]" , artI18N.Label.Label_823_00058 , artI18N.Label.Label_COM_01570);	
			if (validateResult.state == false) {
				return validateResult.messages;
			}
		}
		//6- 当【画：入账.入两个账户】勾选时，【画：入账.金额#1.金额】+【画：入账.金额#2.金额】必须等于【画：入账.头寸金额.金额】，否则报错（SP_VALIDATE_823_016）
		if(!SP_VALIDATE_823_016()){
			return $.getExceptionMsg('ART82306-E');
		}
	}
	return errMsg;
}
/**
*方法说明：当【画：入账.入账账户#1.币种】等于【画：新建.汇票金额.币种】且【画：入账.入账账户#2.币种】等于【画：新建.汇票金额.币种】时，不需要定价，显示报错信息
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    参数1：
*/
function SP_VALIDATE_823_040(){
	//【画：新建.汇票金额.币种】
	var bxCcy = $.trim($("#bxCcy").val());
	//【画：入账.入账账户#1.币种】
	var bookAcctCcy1 = $("#bookAcctCcy1").val();
	//【画：入账.入账账户#2.币种】
	var bookAcctCcy2 = $("#bookAcctCcy2").val();
	if (bxCcy == bookAcctCcy1 && bxCcy == bookAcctCcy2){
		return false;
	}
	return true;
}

/**
*方法说明：当【画：新建.P.P.NEGO】勾选时，【画：信用证信息.有偿付行】必须为‘Y’，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    参数1：
*/
function SP_VALIDATE_823_004(){
	//【画：新建.P.P.NEGO】
	var ppnegoFlg = $("[name='data/BcMntnOpDtlVO/ppnegoFlg']");
	//【画：信用证信息.有偿付行】
	var withReimbsBankFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked");
	if(ppnegoFlg.is(":checked") && "Y" != withReimbsBankFlg.val()){
		return false;
	}
	return true;
}

/**
*方法说明：当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时，则Combined LC信息表格中信用证编号有值的记录条数必须大于等于2，否则报错
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    参数无
*/
function SP_VALIDATE_823_005(){
	//【画：新建.信用证项下】
	var lcFlg = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked");
	//【画：信用证信息.Combined LC】
	var combinedLcFlg = $("[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked");
	var count = 0;
	if("Y"==lcFlg.val() && "Y"==combinedLcFlg.val()){
		$("#bbCombLcNo>table>tbody>tr:visible").each(function (i, o) {
			var thizTr = $(this);
			var index = i;
			//【画：信用证信息.Combined LC信息.信用证编号*】
			var lcNo = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcNo']",thizTr);
			if("" != $.trim(lcNo.val())){
				count++;
			}
		});
		if(2<=count){
			return true;
		}else{
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时，【画：信用证信息.Combined LC信息.drawn amount#1-#5.金额】的合计必须等于【画：新建.汇票金额.金额】，否则报错
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    参数无
*/
function SP_VALIDATE_823_008(){
	//【画：新建.信用证项下】
	var lcFlg = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked");
	//【画：信用证信息.Combined LC】
	var combinedLcFlg = $("[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked");
	//【画：新建.汇票金额.金额】
	var bxAmt = $("[name='data/BcMntnOpDtlVO/bxAmt']");
	var amount=0;
	if("Y"==lcFlg.val() && "Y"==combinedLcFlg.val()){
			$("#bbCombLcNo>table>tbody>tr:visible").each(function (i, o) {
			var thizTr = $(this);
			var index = i;
			//【画：信用证信息.Combined LC信息.drawn amount.金额】
			var drawnAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/drawnAmt']",thizTr);
			amount+=$.trim(drawnAmt.val());
		});
		if($.trim(bxAmt.val()) != amount){
		return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：新建.电报议付】为‘Y’时，【画：新建.电报议付销号日期】不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_017(){
	//【画：新建.电报议付】
	var telegNegoFlg = $("[name='data/BcMntnOpDtlVO/telegNegoFlg']:checked");
	//【画：新建.电报议付销号日期】
	var telegNegoClsDate = $("[name='data/BcMntnOpDtlVO/telegNegoClsDate']");
	if(("Y"==telegNegoFlg.val()) && ""==$.trim(telegNegoClsDate.val())){
			return false;
		}
		return true;
	}

/**
*方法说明：当【画：新建.信用证项下】为‘Y’时，【画：信用证信息】下项目不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_020(lcInfo){
	//信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked");
	if ( $.trim(lcFlg.val()) ==  "Y") {
		if ($.trim(lcInfo) == "") {
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.*】或【画：承兑.远期索偿日】不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    参数1：	validate	偿付行.*，远期索偿日
*/
function SP_VALIDATE_823_021(validate){
	//【画：新建.信用证项下】
	var lcFlg = $("[name='data/BcMntnOpDtlVO/lcFlg']:checked");
	//【画：信用证信息.有偿付行】
	var withReimbsBankFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked");
	if(("Y"==lcFlg.val()) && ("Y"==withReimbsBankFlg.val()) && ""==$.trim(validate.val())){
		return false;
	}
	return true;
}

/**
*方法说明：当【画：信用证信息.留行信用证】勾选时，【画：信用证信息.留行日期】不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_022(){
	//留行日期
	var kibLcDate = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']").val();
	if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']").prop("checked")) {
		if ($.trim(kibLcDate) == "") {
			return false;
		}
	}
	return true;
}


/**
*方法说明：当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息】下的相关内容不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    result 判断【画：信用证信息】下的相关条目value值,为空则true，不为空则为false
*/
function SP_VALIDATE_823_023(result){
	//新建.信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val();
	//信用证信息.转让第二受益人
	var trasf2ndBene = $(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked").val();
	if((lcFlg == "Y") && (trasf2ndBene == "Y")){
		if (result){
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：新建.信用证项下】为‘N’时，【画：非信用证信息】下相关内容不得为空，否则报错（SP_VALIDATE_823_024）
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    notLcInfo 非信用证信息下的相关内容
*/

function SP_VALIDATE_823_024(notLcInfo){
	//新建.信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val();
	if (lcFlg == "N"){
		if ($.trim(notLcInfo) == ""){
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    m 表示当前选中行
*/

function SP_VALIDATE_823_028(m){
	//寄单信息.寄单对象
	var dispchDocObj = $(":radio[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+m+"]/dispchDocObj']:checked").val();
	//寄单信息.寄单种类
	var dispchDocType = $("#dispchDocType").val();
	if (dispchDocObj == "1"){
		if ($.trim(dispchDocType) == ""){
			return false;
		}
	}
	return true;
}


/**
*方法说明：当【画：信用证信息.Combined LC信息】同一行有一个项目被输入时，其余项目都不得为空，否则报错
*返回值:
*    true	校验通过
*    false	校验未通过
*参数：
*    参数无
*/
function SP_VALIDATE_823_029(){
	var flag=false;
	$("#bbCombLcNo>table>tbody>tr:visible").each(function (i, o) {
		var thizTr = $(this);
		var index = i;
		//【画：信用证信息.Combined LC信息.信用证编号*】
		var lcNo = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcNo']",thizTr);
		//【画：信用证信息.Combined LC信息.信用证金额.金额】
		var lcAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcAmt']",thizTr);
		//【画：信用证信息.Combined LC信息.drawn amount.金额】
		var drawnAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/drawnAmt']",thizTr);
		//【画：信用证信息.Combined LC信息.信用证余额.金额】
		var lcBalAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList["+index+"]/lcBalAmt']",thizTr);
		if(("" != $.trim(lcNo.val())) || ("" != $.trim(lcAmt.val())) || ("" != $.trim(drawnAmt.val())) || ("" != $.trim(lcBalAmt.val()))){
			if(("" != $.trim(lcNo.val())) && ("" != $.trim(lcAmt.val())) && ("" != $.trim(drawnAmt.val())) && ("" != $.trim(lcBalAmt.val()))){
				//go on 
			}else{
				flag=true;
				return false;
			}
		}
	});
	if(!flag){
		return true;
		}else{
			return false;
		}
}

/**
*方法说明：当【画：新建.信用证项下】为‘Y’且当【画：信用证信息.第二受益人】为‘Y’时，【画：信用证信息】下项目不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_033(lcInfo){
	//新建.信用证项下
	var lcFlg = $(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val();
	//信用证信息.第二受益人
	var bene2ndFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked").val();
	if ($.trim(lcFlg) == "Y" && $.trim(bene2ndFlg) == "Y") {
		if ($.trim(lcInfo) == "") {
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：信用证信息.第二受益人银行国别.国家】为‘CHN’,【画：信用证信息.第二受益人银行国别.省】不得为空，否则报错（SP_VALIDATE_823_035）
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
		 index 国家  0为第二受益人银行国别.国家  1为对手方银行国别.国家
*    chn 国家为"CHN"时，后面省、市的value值
*/
function SP_VALIDATE_823_035(chn,index){
if(index == 0){
	if($("[name='data/BcMntnOpDtlVO/bene2ndNatnlty']").val() == "CN"){
		if (chn == ""){
			return false;
		}
	}
}else if(index == 1){
	if($("[name = 'data/BcBookOpDtlVO/counterPartyCountry']").val() == "CN"){
		if (chn == ""){
			return false;
		}
	}
}
	
	return true;
}



/**
*方法说明：当【画：承兑.Accepted Flag】为‘Y’时，则【画：承兑.承兑登记日】，【画：承兑.承兑到期日】，【画：承兑.合理】不得为空，【画：承兑.远期索偿日】在【画：信用证信息.有偿付行】为‘Y’时，不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_012(){
	// 承兑.Accepted Flag
	var acceptedFlg = $("[name='data/BcAccptceOpDtlVO/acceptedFlg']:checked");
	// 信用证信息.有偿付行
	var withReimbsBankFlg = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked");
	//承兑.承兑登记日
	var accptceRegDate = $("[name='data/BcAccptceOpDtlVO/accptceRegDate']").val();
	//承兑.承兑到期日
	var accptceDueDate = $("[name='data/BcAccptceOpDtlVO/accptceDueDate']").val();
	//承兑.合理
	var resnblFlg = $(":radio[name='data/BcAccptceOpDtlVO/resnblFlg']:checked").val();
	if("Y" == $.trim(acceptedFlg.val())){
		if ("" == $.trim(accptceRegDate) || "" == $.trim(accptceDueDate) || "" == $.trim(resnblFlg)) {
			return false;
		}
	}
	if("Y" == $.trim(withReimbsBankFlg.val())){
		if ("" == $.trim($("[name='data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate']").val())) {
			return false;
		}
	}
	
	return true;
}

/**
*方法说明：当【画：入账.福费廷】勾选时，【画：单据信息.有追索权】必须为‘N’，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_014(){
	//【画：单据信息.有追索权】
	var withRcsFlg = $("[name = 'data/BcMntnOpDtlVO/withRcsFlg']:checked").val() ;
	//【画：入账.福费廷】
	if ($("[name = 'data/BcBookOpDtlVO/forftingFlg']").is(":checked")) {
		if ( $.trim(withRcsFlg) != "N") {
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：入账.福费廷】勾选时，【画：承兑.Accepted Flag】必须为‘Y’，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_034(){
	//【画：承兑.Accepted Flag】
	var acceptedFlg = $("[name = 'data/BcAccptceOpDtlVO/acceptedFlg']:checked").val() ;
	//【画：入账.福费廷】
	if ($("[name = 'data/BcBookOpDtlVO/forftingFlg']").is(":checked")) {
		if ( $.trim(acceptedFlg) != "Y") {
			return false;
		}
	}
	return true;
}

/**
*方法说明：9	当【画：入账.进待核查】勾选时，【画：入账.待核查账户】不得为空，否则报错
				10	当【画：入账.进待核查】勾选时，【画：入账.客户等级】不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    type		校验对象  Acct，校验账户相关   CustLv,校验客户等级  
*/
function SP_VALIDATE_823_026(type){
	//【画：入账.进待核查】
	if($("[name = 'data/BcBookOpDtlVO/validatnFlg']").is(":checked")){
		if($.trim(type) == "Acct"){
			var validatnAcctCcy = $("#validatnAcctCcy").val() ;
			var validatnAcctGl = $("#validatnAcctGl").val() ;
			var validatnAcctSubGl = $("#validatnAcctSubGl").val() ;
			var validatnAcctNo = $("#validatnAcctNo").val() ;
			if ( $.trim(validatnAcctCcy) == "" || $.trim(validatnAcctGl) == "" || $.trim(validatnAcctSubGl) == "" ||$.trim(validatnAcctNo) == "") {
				return false;
			}
			
		}else{
			if($("[name = 'data/BcBookOpDtlVO/custLv']").val() == ""){
				return false ;
			}
		}
	}
	return true;
}

/**
*方法说明：当【画：入账.福费廷】不勾选时，【画：入账.对手方银行国别.国家】不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_036(){
	//【画：入账.对手方银行国别.国家】
	var counterPartyCountry = $("[name = 'data/BcBookOpDtlVO/counterPartyCountry']:checked").val() ;
	if (!$("[name = 'data/BcBookOpDtlVO/forftingFlg']").is(":checked")) {
		if ( $.trim(counterPartyCountry) == "") {
			return false;
		}
	}
	return true;
}



/**
*方法说明：当【画：新建.汇票金额.币种】为外币(≠CNY)时，【画：入账.入账账户#1.币种】、【画：入账.入账账户#2.币种】不得输入CNY，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    type 校验的账户币种
*/
function SP_VALIDATE_823_015(type){
	//【画：新建.汇票金额.币种】
	var bxCcy = $("[name = 'data/BcMntnOpDtlVO/bxCcy']:checked").val() ;
	//【画：入账.入账账户#1.币种】
	var bookAcctCcy1 = $("#bookAcctCcy1").val() ;
	//【画：入账.入账账户#2.币种】
	var bookAcctCcy2 = $("#bookAcctCcy2").val() ;
	if ($.trim(bxCcy) != "CNY") {
		if($.trim(type) == "Ccy1"){
			if ( $.trim(bookAcctCcy1) == "CNY") {
				return false;
			}
		}else if($.trim(type) == "Ccy2"){
			if ( $.trim(bookAcctCcy2) == "CNY") {
				return false;
			}
		}
		
	}
	return true;
}

/**
*方法说明：当【画：新建.汇票金额.币种】为CNY时，则【画：入账.入账账户#1.币种】、【画：入账.入账账户#2.币种】必须输入CNY，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    type 校验的账户币种
*/
function SP_VALIDATE_823_025(type){
	//【画：新建.汇票金额.币种】
	var bxCcy = $("[name = 'data/BcMntnOpDtlVO/bxCcy']:checked").val() ;
	//【画：入账.入账账户#1.币种】
	var bookAcctCcy1 = $("#bookAcctCcy1").val() ;
	//【画：入账.入账账户#2.币种】
	var bookAcctCcy2 = $("#bookAcctCcy2").val() ;
	if ($.trim(bxCcy) == "CNY") {
		if($.trim(type) == "Ccy1"){
			if ( $.trim(bookAcctCcy1) != "CNY") {
				return false;
			}
		}else if($.trim(type) == "Ccy2"){
			if ( $.trim(bookAcctCcy2) != "CNY") {
				return false;
			}
		}
	}
	return true;
}

/**
*方法说明：当【画：入账.入两个账户】不勾选时，【画：入账.金额#1.金额】必须等于【画：入账.头寸金额.金额】，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_031(){
	//【画：入账.金额#1.金额】
	var amt1 = $("[name = 'data/BcBookOpDtlVO/amt1']").val() ;
	//【画：入账.头寸金额.金额】
	var posAmt = $("[name = 'data/BcBookOpDtlVO/posAmt']").val() ;
	if (!$("[name = 'data/BcBookOpDtlVO/enter2AcctFlg']").is(":checked")) {
		if ( $.trim(amt1) != $.trim(posAmt)) {
			return false;
		}
	}
	return true;
}

/**
*方法说明：当【画：入账.入账账户#1.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_018(){
	//【画：入账.入账账户#1.币种】
	var bookAcctCcy1 = $("[name = 'data/BcBookOpDtlVO/bookAcctCcy1']:checked").val() ;
	//【画：新建.汇票金额.币种】
	var bxCcy = $("[name = 'data/BcMntnOpDtlVO/bxCcy']:checked").val() ;
	if ( $.trim(bookAcctCcy1) != $.trim(posAmt)) {
		return false;
	}
	return true;
}

/**
*方法说明：当【画：入账.入两个账户】勾选时，【画：入账.入账账户#2】、【画：入账.金额#2.金额】、【画：入账.定价金额#2.金额】不得为空不得为空，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    type 校验的账户币种
*/
function SP_VALIDATE_823_027(type){
	//【画：入账.入账账户#2.币种】
	var bookAcctCcy2 = $("#bookAcctCcy2").val() ;
	//【画：入账.入账账户#2.GL】
	var bookAcctGl2 = $("#bookAcctGl2").val() ;
	//【画：入账.入账账户#2.SubGL】
	var bookAcctSubGl2 = $("#bookAcctSubGl2").val() ;
	//【画：入账.入账账户#2】
	var bookAcctNo2 = $("#bookAcctNo2").val() ;
	
	var amt2 = $("#amt2").val() ;
	var amt2 = $("#prcAmt2").val() ;
	if ($("[name = 'data/BcBookOpDtlVO/enter2AcctFlg']").is(":checked")) {
		if($.trim(type) == "Acct"){
			if ($.trim(bookAcctCcy2) == "" || $.trim(bookAcctGl2) == "" || $.trim(bookAcctSubGl2) == "" || $.trim(bookAcctNo2) == "") {
				return false;
			}
		}else if($.trim(type) == "Amt"){
			if ($.trim(amt2) == "") {
				return false;
			}
		}else if($.trim(type) == "prcAmt2"){
			if ($.trim(amt2) == "") {
				return false;
			}
		}
	}
	return true;
}

/**
*方法说明：当【画：入账.入两个账户】勾选时，【画：入账.金额#1.金额】+【画：入账.金额#2.金额】必须等于【画：入账.头寸金额.金额】，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_016(){
	//【画：入账.金额#1.金额】
	var amt1 = 0 + $("[name = 'data/BcBookOpDtlVO/amt1']").val() ;
	//【画：入账.金额#2.金额】
	var amt2 = 0 + $("[name = 'data/BcBookOpDtlVO/amt2']").val() ;
	//【画：入账.头寸金额.金额】
	var posAmt = 0 + $("[name = 'data/BcBookOpDtlVO/posAmt']").val() ;
	//当【画：入账.入两个账户】勾选时
	if ($("[name = 'data/BcBookOpDtlVO/enter2AcctFlg']").is(":checked")) {
		if ( $.trim(amt1 + amt2) != $.trim(posAmt)) {
			return false;
		}
	}
	return true;

}

/**
*方法说明：当【画：入账.入两个账户】勾选且【画：入账.入账账户#2.币种】和【画：新建.汇票金额.币种】不一致时，显示报错信息，提示需要定价
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_019(){
	//【画：入账.入账账户#2.币种】
	var bookAcctCcy2 = $("#bookAcctCcy2").val() ;
	//【画：新建.汇票金额.币种】
	var bxCcy = $("[name = 'data/BcMntnOpDtlVO/bxCcy']:checked").val() ;
	if ($("[name = 'data/BcBookOpDtlVO/enter2AcctFlg']").is(":checked") && $.trim(bookAcctCcy2) != $.trim(bxCcy)) {
		return false;
	}
	return true;
}

/**
*方法说明：【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】、【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    type 	校验种类
*/
function SP_VALIDATE_823_098(type){
  if($.trim(type) == "lcNo"){
  	//【Hidden：信用证编号】
  	var tmpLcNo = $("[name = 'data/BcMntnOpDtlVO/tmpLcNo']").val() ;
  	//【画：信用证信息.信用证编号】
		var lcNo = $("[name = 'data/BcMntnOpDtlVO/lcNo']").val() ;
		if ( $.trim(lcNo)!= $.trim(tmpLcNo)) {
			return false;
		}
  }else if($.trim(type) == "trasfNo"){
  	//【Hidden：转让编号】
  	//------待验证------
  	var trasfTKindNumber = $("#trasfTKindNumber").val() ;
  	//【画：信用证信息.转让编号】
  	var tmpTrasfNo = $("[name = 'data/BcMntnOpDtlVO/tmpTrasfNo']").val();
  	if ( $.trim(trasfTKindNumber)!= $.trim(tmpTrasfNo)) {
			return false;
		}
  }
	return true;
}

/**
*方法说明：【画：手续费】板块中‘单独记账’不勾选且已收的手续费条数必须小于等于5条，否则报错
*返回值:
*    true 	校验通过
*    false	校验未通过
*参数：
*    无
*/
function SP_VALIDATE_823_038(){
	// 调用组件列表【E00060】随交易登录手续费过滤方法，取得手续费信息
	// 当取得手续费的条数大于5条时，显示报错信息
	var resultArr = new Array();
	$("#param_reqtype").val($("#genAccValidateReqtype").val());	
	$("#param_action").val('account');
	var rtnJSON;
    var data = getPostData();
    var success = function (data) {
        var json = {status: "success", result: []};
        if (!$.isEmptyObject(data)) {
            json.result = data.result;
            
            if(json.result.size() <= 5){
		  			 //1- 将【Hidden：SMILE记账.Charges】的值设为：【画：手续费】板块中【单独记账】不勾选的手续费信息（Charge code，币种，金额）
		  			 //（调用组件列表【E00060】，参数：无，取得随交易登录非单独记账手续费信息）
		    		for(var i=0;i<json.result.size();i++){
		    			$("[name='data/BcMntnOpDtlVO/chgCode"+i+"']").val(json.result[i].getChgCode());
		    			$("[name='data/BcMntnOpDtlVO/chgCcy"+i+"']").val(json.result[i].getChgCcy());
		    			$("[name='data/BcMntnOpDtlVO/chgAmt"+i+"']").val(json.result[i].getChgAmt());
		    		}
		 	  }
            
        }
        rtnJSON = JSON.stringify(json);
        resultArr.push(rtnJSON);
    };
    ajaxPost(data, success);
    return resultArr.result;
}

function SP_VALIDATE_823_028(index){
	if("" == $("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["+index+"]/dispchDocType']").val()){
		return false;
	}
	return true;
}
