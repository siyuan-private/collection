/**
 * 方法说明：画面初始化 返回值: 无 参数： 无
 */
$(function() {
	// 共通按钮动作校验
	$("#artform_def_detail").artForm({
				preSeqGenerate : function(target, esrc) {

				},
				seqGenerate : function(target, esrc) {

				},
				save : function(target, esrc) {
					//暂存	
					FormValidate.check(saveValidate()).doThrow();
					$("#param_reqtype").val("Collection/CollCreate/detail");
					$("#param_action").val('save');
				},
				submit : function(target, esrc) {
					//保存提交
					FormValidate.check(submitValidate()).doThrow();
					$("#param_reqtype").val("Collection/CollCreate/detail");
					$("#param_action").val('submit');
				},
				check : function(target, esrc) {
				},
				approval : function(target, esrc) {
				}
			});

	// 新建编辑画面初始化
	// 1.1.2）画面特殊按钮和链接的初始化
	// 1- 显示【画：寄单信息.增加】和【画：寄单信息.删除】按钮
	$("#dispch_add,#dispch_del").show();

	// 2- 【画：寄单信息.增加】和【画：寄单信息.删除】按钮可点击
	$("#dispch_add,#dispch_del").prop("disabled", false);

	// 记账用reqType初期化
	$("#genAccReqtype").val("Collection/CollCreate/genacc");
	// 记账校验用用reqType初期化
	$("#genAccValidateReqtype").val("Collection/CollCreate/genaccValidate");

	// 1.1.3）板块初期显示配置
	controlBlockDisplay(2, 4);
	controlBlockDisplay(3, 4);
	controlBlockDisplay(4, 4);

	// 1.1.4）设置【画：新建.电报议付】，【画：新建.备注】的可编辑
	// 1- 当【画：新建.P.P. NEGO】勾选时
	if (($("[name='data/BcMntnOpDtlVO/ppnegoFlg']").is(":checked"))) {

		// 【画：新建.电报议付】和【画：新建.备注】设为可编辑
		$(":radio[name='data/BcMntnOpDtlVO/telegNegoFlg']").setReadOnly(false);
		$("[name='data/BcMntnOpDtlVO/newRmrk']").setReadOnly(false);
	}

	// 2- 当【画：新建.P.P. NEGO】不勾选时
	else {

		// 【画：新建.电报议付】和【画：新建.备注】设为不可编辑
		$(":radio[name='data/BcMntnOpDtlVO/telegNegoFlg']").setReadOnly(true);
		$("[name='data/BcMntnOpDtlVO/newRmrk']").setReadOnly(true);
	}

	// 1.1.5）设置【画：新建.电报议付销号日期】的可编辑
	// 1- 当【画：新建.P.P. NEGO】勾选且【画：新建.电报议付】为‘Y’时
	if ((($("[name='data/BcMntnOpDtlVO/ppnegoFlg']").is(":checked")))
			&& ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/telegNegoFlg']:checked")
					.val()))) {

		// 【画：新建.电报议付销号日期】设为可编辑
		$("[name='data/BcMntnOpDtlVO/telegNegoClsDate']").setReadOnly(false);
	}

	// 2- 上述以外的场合
	else {

		// 【画：新建.电报议付销号日期】设为不可编辑
		$("[name='data/BcMntnOpDtlVO/telegNegoClsDate']").setReadOnly(true);
	}

	// 1.1.6）设置【画：新建.Tenor.天数】，【画：新建.Tenor.日期】的可编辑
	var tenortype = $("[name='data/BcMntnOpDtlVO/tenorType']").val();
	var tenordays = $("[name='data/BcMntnOpDtlVO/tenorDays']");
	var tenordate = $("[name='data/BcMntnOpDtlVO/tenorDate']");
	// 1- 当【画：新建.Tenor.种类】为‘空：at sight’时
	if ("△" == tenortype) {

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
	else if ("O" == tenortype) {

		// 【画：新建.Tenor.天数】，【画：新建.Tenor.日期】设为可编辑
		tenordays.setReadOnly(false);
		tenordate.setReadOnly(false);
	}

	// 1.1.7）设置【画：信用证信息】板块和【画：非信用证信息】板块的初期显示
	// 1- 当【画：新建.信用证项下】为‘Y’
	if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/lcFlg']:checked").val())) {

		// 显示【画：信用证信息】板块，【画：非信用证信息】板块不显示
		$("#LcInfo").show();
		$("#nonLcInfo").hide();

		// a- 当【画：信用证信息.信用证编号】为空时
		if ("" == ($("#lcNo").val())) {

			$("#bbCombLcNo").hide();
			$("#trasfTable").hide();
			// 【画：信用证信息】板块的项目可编辑设定参照【附件(新建)】的【编辑画面初期表示1】列
			$("#LcInfo :input").setReadOnly(true);
			$("#lcNo").setReadOnly(false);

			// 将【Hidden：信用证编号】的值设为：空
			$("[name='data/BcMntnOpDtlVO/tmpLcNo']").val("");
		}

		// b- 当【画：信用证信息.信用证编号】不为空时
		else {

			// 根据输入的信用证编号，到【DM：出口信用证信息】检索数据
			// 调用组件类表【I00200】，参数：信用证编号，获取指定信用证信息
			jsonStr = {
				"functionName" : "GetLCInfoWithConfirmationCommand",
				"lcNo" : $("#lcNo").val(),
				"branchCode" : branchCode
			};
			commAjaxPost(jsonStr, function(expLcResult) {
				// 当检索结果为0件时
				if (!expLcResult.success) {

					$("#trasfTable").hide();
					// 【画：信用证信息】板块的项目可编辑设定参照【附件(新建)】的【编辑画面初期表示2】列
					$("#LcInfo :input").setReadOnly(false);
					$("#explcBalCcy").setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdTKind']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdPrmryRefNo']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdSubRefNo']")
							.setReadOnly(true);

					// 当【画：信用证信息.第二受益人】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked")
							.val())) {

						// 【画：信用证信息.中转行】，【画：信用证信息.中转行国别】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.第二受益人】为空或者为‘N’时
					else {

						// 【画：信用证信息.中转行】，【画：信用证信息.中转行国别】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.有偿付行】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked")
							.val())) {

						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.有偿付行】为空或者为‘N’时
					else {

						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.寄单行同开证行】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked")
							.val())) {

						// 【画：信用证信息.寄单行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.寄单行同开证行】为空或者为‘N’时
					else {

						// 【画：信用证信息.寄单行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.我行保兑】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.is(":checked")) {

						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】可编辑
						$(":radio[name='data/BcMntnOpDtlVO/perfmConfmDuties']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.我行保兑】为‘N’时
					else {

						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/perfmConfmDuties']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.留行信用证】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
							.is(":checked")) {

						// 【画：信用证信息.留行日期】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.留行信用证】为‘N’时
					else {

						// 【画：信用证信息.留行日期】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.Combined LC】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked")
							.val())) {

						// 显示【画：Combined LC信息】表格
						$("#bbCombLcNo").show();

						// 【画：信用证信息.Combined
						// LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined
						// LC信息.信用证编号#2-#5.删除】显示且可点击
						$("#lcSearch2,#lcSearch3,#lcSearch4,#lcSearch5").show()
								.prop("disabled", false);
						$("#lcDel2,#lcDel3,#lcDel4,#lcDel5").show().prop(
								"disabled", false);

						// 设置【画：信用证信息.Combined LC信息】表格的可编辑
						// a- 【画：信用证信息.Combined LC信息#1】除【画：信用证信息.Combined
						// LC信息.drawn
						// amount.金额】以外，其他项目不可编辑
						$("#lcNo1,#lcCcy1,#lcAmt1,#drawnCcy1,#lcBalCcy1,#lcBalAmt1")
								.setReadOnly(true);
						$("#drawnAmt1").setReadOnly(false);

						// b- 【画：信用证信息.Combined LC信息#2-#5】的【画：信用证信息.Combined
						// LC.信用证金额.币种】，
						// 【画：信用证信息.Combined LC.drawn
						// amount.币种】，【画：信用证信息.Combined
						// LC.信用证余额.币种】不可编辑
						$("#lcCcy2,#drawnCcy2,#lcBalCcy2").setReadOnly(true);
						$("#lcCcy3,#drawnCcy3,#lcBalCcy3").setReadOnly(true);
						$("#lcCcy4,#drawnCcy4,#lcBalCcy4").setReadOnly(true);
						$("#lcCcy5,#drawnCcy5,#lcBalCcy5").setReadOnly(true);
					}

					// 当【画：信用证信息.Combined LC】为空或者为‘N’时
					else {

						// 不显示【画：Combined LC信息】表格
						$("#bbCombLcNo").hide();
					}

					// 将【Hidden：我行通知信用证】的值设为：N
					$("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val("N");
				}
				// 当检索结果等于1件且【DM：出口信用证信息.来源】为‘1：信用证通知’时
				if (expLcResult.success && ("1" == expLcResult.result[0].src)) {

					// 【画：信用证信息】板块的项目可编辑设定参照【附件(新建)】的【编辑画面初期表示3】列
					$("#LcInfo :input").setReadOnly(false);
					$("#lcAmtCcy").setReadOnly(true);
					$("#expLcAmt").setReadOnly(true);
					$("#explcBalCcy").setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdTKind']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdPrmryRefNo']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdSubRefNo']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']")
							.setReadOnly(true);

					// 当【画：信用证信息.第二受益人】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked")
							.val())) {

						// 【画：信用证信息.中转行】，【画：信用证信息.中转行国别】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.第二受益人】为空或者为‘N’时
					else {

						// 【画：信用证信息.中转行】，【画：信用证信息.中转行国别】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.有偿付行】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked")
							.val())) {

						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.有偿付行】为空或者为‘N’时
					else {

						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.寄单行同开证行】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked")
							.val())) {

						// 【画：信用证信息.寄单行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.寄单行同开证行】为空或者为‘N’时
					else {

						// 【画：信用证信息.寄单行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.我行保兑】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.is(":checked")) {

						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】可编辑
						$(":radio[name='data/BcMntnOpDtlVO/perfmConfmDuties']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.我行保兑】为‘N’时
					else {

						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/perfmConfmDuties']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.留行信用证】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
							.is(":checked")) {

						// 根据信用证编号到【DM：出口信用证信息】中检索：
						// 当【DM：出口信用证信息.留行信用证标志】为‘Y’时
						if ("Y" == "【DM：出口信用证信息.留行信用证标志】") {

							// 【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】不可编辑
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
									.setReadOnly(true);
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
									.setReadOnly(true);
						}

						// 当【DM：出口信用证信息.留行信用证标志】为‘N’时
						else if ("N" == "【DM：出口信用证信息.留行信用证标志】") {

							// 【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】可编辑
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
									.setReadOnly(false);
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
									.setReadOnly(false);
						}
					}

					// 当【画：信用证信息.留行信用证】为空或者为‘N’时
					else {

						// 【画：信用证信息.留行信用证】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
								.setReadOnly(false);

						// 【画：信用证信息.留行日期】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.我行保兑】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.is(":checked")) {

						// 【画：信用证信息.Combined LC】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.我行保兑】为‘N’时
					else {

						// 【画：信用证信息.Combined LC】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.转让信用证】为‘Y’且【Hidden：我行通知信用证】为‘Y’时
					if (("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']:checked")
							.val()))
							&& ("Y" == ($("[name='data/BcMntnOpDtlVO/ourBkNtcLc']")
									.val()))) {

						// 【画：信用证信息.转让第二受益人】可编辑
						$(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.转让信用证】为‘N’或【Hidden：我行通知信用证】为‘N’时
					if (("N" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']")
							.val()))
							|| ("N" == ($("[name='data/BcMntnOpDtlVO/ourBkNtcLc']")
									.val()))) {

						// 【画：信用证信息.转让第二受益人】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.Combined LC】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked")
							.val())) {

						// 显示【画：Combined LC信息】表格
						$("#bbCombLcNo").show();

						// 【画：信用证信息.Combined
						// LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined
						// LC信息.信用证编号#2-#5.删除】显示且可点击
						$("#lcSearch2,#lcSearch3,#lcSearch4,#lcSearch5").show()
								.prop("disabled", false);
						$("#lcDel2,#lcDel3,#lcDel4,#lcDel5").show().prop(
								"disabled", false);

						// 设置【画：信用证信息.Combined LC信息】表格的可编辑
						// a- 【画：信用证信息.Combined LC信息#1】除【画：信用证信息.Combined
						// LC信息.drawn
						// amount.金额】以外，其他项目不可编辑
						$("#lcNo1,#lcCcy1,#lcAmt1,#drawnCcy1,#lcBalCcy1,#lcBalAmt1")
								.setReadOnly(true);
						$("#drawnAmt1").setReadOnly(false);

						// b- 【画：信用证信息.Combined LC信息#2-#5】的【画：信用证信息.Combined
						// LC.信用证金额.币种】，
						// 【画：信用证信息.Combined LC.drawn
						// amount.币种】，【画：信用证信息.Combined
						// LC.信用证余额.币种】不可编辑
						$("#lcCcy2,#drawnCcy2,#lcBalCcy2").setReadOnly(true);
						$("#lcCcy3,#drawnCcy3,#lcBalCcy3").setReadOnly(true);
						$("#lcCcy4,#drawnCcy4,#lcBalCcy4").setReadOnly(true);
						$("#lcCcy5,#drawnCcy5,#lcBalCcy5").setReadOnly(true);
					}

					// 当【画：信用证信息.Combined LC】为空或者为‘N’时
					else {

						// 不显示【画：Combined LC信息】表格
						$("#bbCombLcNo").hide();
					}

					// 当【画：信用证信息.转让第二受益人】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']:checked")
							.val())) {

						// 显示【画：转让信息】表格
						$("#trasfTable").show();

						// 【画：信用证信息.转让编号.检索】显示且可点击
						$("#btn_scan").show().prop("disabled", false);

						// 【画：转让信息】表格的项目可编辑设定参照【附件(新建)】的【编辑画面初期表示3】列
						$("#trasfTable :input").setReadOnly(false);
						$("#trasfAmtCcy").setReadOnly(true);
						$(":radio[name='data/BcMntnOpDtlVO/undtk1stBeneFlg']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/bene2ndName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/bene2ndNoticeBankSwiftCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/bene2ndNoticeBankName']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.转让第二受益人】为‘N’时
					else {

						// 不显示【画：转让信息】表格
						$("#trasfTable").hide();
					}

					// 将【Hidden：我行通知信用证】的值设为：Y
					$("name=['[name='data/BcMntnOpDtlVO/ourBkNtcLc']']")
							.val("Y");
				}

				// 当检索结果等于1件且【DM：出口信用证信息.来源】不为‘1：信用证通知’时
				if (expLcResult.success && ("1" != expLcResult.result[0].src)) {

					$("#trasfTable").hide();
					// 【画：信用证信息】板块的项目可编辑设定参照【附件(新建)】的【编辑画面初期表示4】列
					$("#LcInfo :input").setReadOnly(false);
					$("#explcBalCcy").setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdTKind']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdPrmryRefNo']")
							.setReadOnly(true);
					$("[name='data/BcMntnOpDtlVO/confmdSubRefNo']")
							.setReadOnly(true);
					$(":radio[name='data/BcMntnOpDtlVO/trasf2ndBene']")
							.setReadOnly(true);

					// 当【画：信用证信息.第二受益人】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked")
							.val())) {

						// 【画：信用证信息.中转行】，【画：信用证信息.中转行国别】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.第二受益人】为空或者为‘N’时
					else {

						// 【画：信用证信息.中转行】，【画：信用证信息.中转行国别】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.有偿付行】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked")
							.val())) {

						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.有偿付行】为空或者为‘N’时
					else {

						// 【画：信用证信息.允许电报偿付】，【画：信用证信息.偿付行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.寄单行同开证行】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked")
							.val())) {

						// 【画：信用证信息.寄单行】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.寄单行同开证行】为空或者为‘N’时
					else {

						// 【画：信用证信息.寄单行】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.我行保兑】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.is(":checked")) {

						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】可编辑
						$(":radio[name='data/BcMntnOpDtlVO/perfmConfmDuties']")
								.setReadOnly(false);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.我行保兑】为‘N’时
					else {

						// 【画：信用证信息.履行保兑责任】，【画：信用证信息.保兑备注】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/perfmConfmDuties']")
								.setReadOnly(true);
						$("[name='data/BcMntnOpDtlVO/confmdRmrk']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.留行信用证】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
							.is(":checked")) {

						// 根据信用证编号到【DM：出口信用证信息】中检索：
						// 当【DM：出口信用证信息.留行信用证标志】为‘Y’时
						if ("Y" == "【DM：出口信用证信息.留行信用证标志】") {

							// 【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】不可编辑
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
									.setReadOnly(true);
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
									.setReadOnly(true);
						}

						// 当【DM：出口信用证信息.留行信用证标志】为‘N’时
						else if ("N" == "【DM：出口信用证信息.留行信用证标志】") {

							// 【画：信用证信息.留行信用证】，【画：信用证信息.留行日期】可编辑
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
									.setReadOnly(false);
							$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
									.setReadOnly(false);
						}
					}

					// 当【画：信用证信息.留行信用证】为空或者为‘N’时
					else {

						// 【画：信用证信息.留行信用证】可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg']")
								.setReadOnly(false);

						// 【画：信用证信息.留行日期】不可编辑
						$("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.我行保兑】为‘Y’时
					if ($("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg']")
							.is(":checked")) {

						// 【画：信用证信息.Combined LC】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']")
								.setReadOnly(true);
					}

					// 当【画：信用证信息.我行保兑】为‘N’时
					else {

						// 【画：信用证信息.Combined LC】不可编辑
						$(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']")
								.setReadOnly(false);
					}

					// 当【画：信用证信息.Combined LC】为‘Y’时
					if ("Y" == ($(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked")
							.val())) {

						// 显示【画：Combined LC信息】表格
						$("#bbCombLcNo").show();

						// 【画：信用证信息.Combined
						// LC信息.信用证编号#2-#5.检索】，【画：信用证信息.Combined
						// LC信息.信用证编号#2-#5.删除】显示且可点击
						$("#lcSearch2,#lcSearch3,#lcSearch4,#lcSearch5").show()
								.prop("disabled", false);
						$("#lcDel2,#lcDel3,#lcDel4,#lcDel5").show().prop(
								"disabled", false);

						// 设置【画：信用证信息.Combined LC信息】表格的可编辑
						// a- 【画：信用证信息.Combined LC信息#1】除【画：信用证信息.Combined
						// LC信息.drawn
						// amount.金额】以外，其他项目不可编辑
						$("#lcNo1,#lcCcy1,#lcAmt1,#drawnCcy1,#lcBalCcy1,#lcBalAmt1")
								.setReadOnly(true);
						$("#drawnAmt1").setReadOnly(false);

						// b- 【画：信用证信息.Combined LC信息#2-#5】的【画：信用证信息.Combined
						// LC.信用证金额.币种】，
						// 【画：信用证信息.Combined LC.drawn
						// amount.币种】，【画：信用证信息.Combined
						// LC.信用证余额.币种】不可编辑
						$("#lcCcy2,#drawnCcy2,#lcBalCcy2").setReadOnly(true);
						$("#lcCcy3,#drawnCcy3,#lcBalCcy3").setReadOnly(true);
						$("#lcCcy4,#drawnCcy4,#lcBalCcy4").setReadOnly(true);
						$("#lcCcy5,#drawnCcy5,#lcBalCcy5").setReadOnly(true);
					}

					// 当【画：信用证信息.Combined LC】为空或者为‘N’时
					else {

						// 不显示【画：Combined LC信息】表格
						$("#bbCombLcNo").hide();
					}
				}

				// 将【Hidden：我行通知信用证】的值设为：N
				$("[name='data/BcMntnOpDtlVO/ourBkNtcLc']").val("N");

			});
		}
		// 将【Hidden：转让编号】的值设为：【画：信用证信息.转让编号】
		var trasfTKind = $("[name='data/BcMntnOpDtlVO/trasfTKind']").val();
		var trasfNoPrmryRefNo = $("[name='data/BcMntnOpDtlVO/trasfNoPrmryRefNo']")
				.val();
		var trasfNoSubRefNo = $("[name='data/BcMntnOpDtlVO/trasfNoSubRefNo']")
				.val();
		var tmpTrasfNo = trasfTKind + "-" + trasfNoPrmryRefNo + "-"
				+ trasfNoSubRefNo;
		$("[name='data/BcMntnOpDtlVO/tmpTrasfNo']").val(tmpTrasfNo);
	}

	// 2- 当【画：新建.信用证项下】为为空或者为‘N’时
	else {

		// 显示【画：非信用证信息】板块，【画：信用证信息】板块不显示
		$("#LcInfo").hide();
		$("#notLcInfo").show();
	}

	// 1.1.8）设置【画：寄单信息】的初期显示
	// 当【画：寄单信息】有数据时：
			//a- 当【DM：寄单信息.操作流水号】不等于当前操作流水号或【DM：寄单信息.操作版本号】不等于当前操作版本号时，将该寄单信息行设为不可编辑
			//b- 当【DM：寄单信息.操作流水号】等于当前操作流水号且【DM：寄单信息.操作版本号】等于当前操作版本号时
				//将该寄单信息行设为可编辑，将当前行的【Hidden：新增寄单信息标志】的值设为：Y	
				//当【画：寄单信息.寄单对象】为‘2：客户’时，【画：寄单信息.寄单种类】设为不可编辑	
			//※以上a+b需循环处理
	dispchBlockInit();

	// reqtype初期化
	$("#commonReqtype").val("Collection/CollCreate/detail");
});


/**
 * 方法说明：暂存校验 返回值: true 校验通过 false 校验未通过 参数： 无
 */
function saveValidate() {
	var errMsg = [];
	// 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）
	if (!SP_VALIDATE_823_098("lcNo")) {
		return $.getExceptionMsg('ART00130-E',[artI18N.Label.Label_COM_02151,artI18N.Label.Link_823_00004]);
	}
	// 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）
	if (!SP_VALIDATE_823_098("trasfNo")) {
		return $.getExceptionMsg('ART00130-E',[artI18N.Label.Label_823_00034,artI18N.Label.Link_823_00004]);
	}
	return errMsg;
}

/**
 * 方法说明：保存提交校验 返回值: true 校验通过 false 校验未通过 参数： 无
 */
function submitValidate() {
	var errMsg = [];
	var validateResult;

	// ----------start of 单项目-----------
	// 1- 【画：新建.受益人.客户CIF】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/beneCif']").val(), "required",
			artI18N.Label.Label_823_00004);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 2- 【【画：新建.受益人.客户名称】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/beneName']").val(), "required",
			artI18N.Label.Label_823_00004);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 3- 【【画：新建.受益人账户】不得为空，否则报错（VALIDATE_00018）[※币种，GL，SUB GL，账号都不得为空]
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/beneAcctCcy']").val(), "required",
			artI18N.Label.Label_823_00022);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	} else {
		validateResult = $.art.Validator.validateBatch(
				$("[name='data/BcMntnOpDtlVO/beneAcctGl']").val(), "required",
				artI18N.Label.Label_823_00022);
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		} else {
			validateResult = $.art.Validator.validateBatch(
					$("[name='data/BcMntnOpDtlVO/beneAcctSubGl']").val(),
					"required", artI18N.Label.Label_823_00022);
			if (validateResult.state == false) {
				errMsg.push(validateResult.messages);
			} else {
				validateResult = $.art.Validator.validateBatch(
						$("[name='data/BcMntnOpDtlVO/beneAcctNo']").val(),
						"required", artI18N.Label.Label_823_00022);
				if (validateResult.state == false) {
					errMsg.push(validateResult.messages);
				}
			}
		}
	}
	// 4- 【【画：新建.汇票金额.币种】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/bxCcy']").val(), "required",
			artI18N.Label.Label_823_00005);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 5- 【【画：新建.汇票金额.金额】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/bxAmt']").val(), "required",
			artI18N.Label.Label_823_00005);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 6- 【【画：新建.发票编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/ivcNo']").val(), "required",
			artI18N.Label.Label_COM_01274);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 7- 【【画：新建.保税区】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/bondedAreaFlg']:checked"), "required",
			artI18N.Label.Label_COM_00960);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 8- 【【画：新建.托收日期】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/collDate']").val(), "required",
			artI18N.Label.Label_COM_02066);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 9- 【【画：单据信息.发票编号】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/docIvcNo']").val(), "required",
			artI18N.Label.Label_COM_01274);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 10- 【【画：单据信息.CHQ Kind】不得为空，否则报错（VALIDATE_00018）
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/chqKind']").val(), "required",
			artI18N.Label.Label_COM_00278);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	}
	// 11- 【【画：单据信息.BC记账科目】不得为空，否则报错（VALIDATE_00018）[※GL，SUB GL都不得为空]
	validateResult = $.art.Validator.validateBatch(
			$("[name='data/BcMntnOpDtlVO/bcBookAcctGl']").val(), "required",
			artI18N.Label.Label_823_00042);
	if (validateResult.state == false) {
		errMsg.push(validateResult.messages);
	} else {
		validateResult = $.art.Validator.validateBatch(
				$("[name='data/BcMntnOpDtlVO/bcBookAcctSubGl']").val(),
				"required", artI18N.Label.Label_823_00042);
		if (validateResult.state == false) {
			errMsg.push(validateResult.messages);
		}
	}

	if (errMsg.length > 0) {
		return errMsg;
	}
	// ----------end of 单项目-------------

	// 13- 【画：新建.最终到期日】不为空时，必须大于等于【画：新建.到期日期】，否则报错（VALIDATE_00027）：
	// {0}必须大于等于{1}。
	if ("" != $.trim($("[name='data/BcMntnOpDtlVO/finalDueDate']").val())) {
		validateResult = $.art.Validator.validateBatch(
				$("[name='data/BcMntnOpDtlVO/finalDueDate']").val(),
				"dateMorethanEq["
						+ $("[name='data/BcMntnOpDtlVO/dueDate']").val() + "]",
				artI18N.Label.Label_COM_02403,
				artI18N.Label.Label_COM_01184);
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}

	// 14- 当【画：新建.电报议付】为‘Y’时，【画：新建.电报议付销号日期】不得为空，否则报错（SP_VALIDATE_823_017）
	if (!SP_VALIDATE_823_017()) {
		return $.getExceptionMsg('ART00027-E',[artI18N.Label.Label_COM_01201]);
	}

	// 15 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证编号】不得为空，否则报错（SP_VALIDATE_823_020）
	var lcNo = $("[name='data/BcMntnOpDtlVO/lcNo']").val();
	if (!SP_VALIDATE_823_020(lcNo)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02151]);
	}
	// 16 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证金额.币种】不得为空，否则报错（SP_VALIDATE_823_020）
	var lcAmtCcy = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmtCcy']")
			.val();
	if (!SP_VALIDATE_823_020(lcAmtCcy)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00026]);
	}
	// 17 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证金额.金额】不得为空，否则报错（SP_VALIDATE_823_020）
	var lcAmt = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmt']").val();
	if (!SP_VALIDATE_823_020(lcAmt)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00026]);
	}
	// 18 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.信用证余额.金额】不得为空，否则报错（SP_VALIDATE_823_020）
	var lcBalAmt = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcBalAmt']")
			.val();
	if (!SP_VALIDATE_823_020(lcBalAmt)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00027]);
	}
	// 19 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证日期】不得为空，否则报错（SP_VALIDATE_823_020）
	var issueDate = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate']")
			.val();
	if (!SP_VALIDATE_823_020(issueDate)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01626]);
	}
	// 20 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.到期日期】不得为空，否则报错（SP_VALIDATE_823_020）
	var dueDate = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate']")
			.val();
	if (!SP_VALIDATE_823_020(dueDate)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01184]);
	}
	// 21 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.第二受益人】不得为空，否则报错（SP_VALIDATE_823_020）
	var bene2ndFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(bene2ndFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01193]);
	}

	// 22
	// 当【画：新建.信用证项下】为‘Y’且当【画：信用证信息.第二受益人】为‘Y’时，【画：信用证信息.中转行】不得为空，否则报错（SP_VALIDATE_823_033）
	var trastBank = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank']")
			.val();
	if (!SP_VALIDATE_823_033(trastBank)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02339]);
	}
	// 23
	// 当【画：新建.信用证项下】为‘Y’且当【画：信用证信息.第二受益人】为‘Y’时，【画：信用证信息.中转行国别】不得为空，否则报错（SP_VALIDATE_823_033）
	var trastBankNatnlty = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty']")
			.val();
	if (!SP_VALIDATE_823_033(trastBankNatnlty)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02340]);
	}
	// 24 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.进口商名称】不得为空，否则报错（SP_VALIDATE_823_020）
	var imptrName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName']")
			.val();
	if (!SP_VALIDATE_823_020(imptrName)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01588]);
	}
	// 25 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.进口商国别】不得为空，否则报错（SP_VALIDATE_823_020）
	var imptrNatnlty = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty']")
			.val();
	if (!SP_VALIDATE_823_020(imptrNatnlty)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01587]);
	}
	// 26 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.OSA/NRA】不得为空，否则报错（SP_VALIDATE_823_020）
	var osaNraFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/osaNraFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(osaNraFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00631]);
	}
	// 27 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行同开证行】不得为空，否则报错（SP_VALIDATE_823_020）
	var dispchBankEqIssueFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(dispchBankEqIssueFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01521]);
	}
	// 28 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.有偿付行】不得为空，否则报错（SP_VALIDATE_823_020）
	var withReimbsBankFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(withReimbsBankFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02238]);
	}
	// 29 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.行号】不得为空，否则报错（SP_VALIDATE_823_020）
	var issueBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode']")
			.val();
	if (!SP_VALIDATE_823_020(issueBankCode)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01420]);
	}
	// 30 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）
	var issueBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift']")
			.val();
	if (!SP_VALIDATE_823_020(issueBankSwift)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00839]);
	}
	// 31 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.名称】不得为空，否则报错（SP_VALIDATE_823_020）
	var issueBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName']")
			.val();
	if (!SP_VALIDATE_823_020(issueBankName)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01720]);
	}
	// 32 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.开证行.地址】不得为空，否则报错（SP_VALIDATE_823_020）
	var issueBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr']")
			.val();
	if (!SP_VALIDATE_823_020(issueBankAddr)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01191]);
	}
	// 33 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_020）
	var dispchDocBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode']")
			.val();
	if (!SP_VALIDATE_823_020(dispchDocBankCode)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01420]);
	}
	// 34 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_020）
	var dispchDocBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift']")
			.val();
	if (!SP_VALIDATE_823_020(dispchDocBankSwift)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00839]);
	}
	// 35 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_020）
	var dispchDocBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName']")
			.val();
	if (!SP_VALIDATE_823_020(dispchDocBankName)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01720]);
	}
	// 36 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_020）
	var dispchDocBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr']")
			.val();
	if (!SP_VALIDATE_823_020(dispchDocBankAddr)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01191]);
	}

	// 37-
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.行号】不得为空，否则报错（SP_VALIDATE_823_021）
	// 【画：信用证信息.偿付行.行号】
	var reimbBankCode = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode']");
	if (!SP_VALIDATE_823_021(reimbBankCode)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01420]);
	}
	// 38-
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.Swift】不得为空，否则报错（SP_VALIDATE_823_021）
	// 【画：信用证信息.偿付行.Swift】
	var reimbBankSwift = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift']");
	if (!SP_VALIDATE_823_021(reimbBankSwift)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00839]);
	}
	// 39-
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.名称】不得为空，否则报错（SP_VALIDATE_823_021）
	// 【画：信用证信息.偿付行.名称】
	var reimbBankName = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName']");
	if (!SP_VALIDATE_823_021(reimbBankName)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label_COM_01720]);
	}
	// 40-
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.有偿付行】为‘Y’时，【画：信用证信息.偿付行.地址】不得为空，否则报错（SP_VALIDATE_823_021）
	// 【画：信用证信息.偿付行.地址】
	var reimbBankAddr = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr']");
	if (!SP_VALIDATE_823_021(reimbBankAddr)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01191]);
	}

	// 41 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.我行承兑】不得为空，否则报错（SP_VALIDATE_823_020）
	var ourBankAccptceFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankAccptceFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(ourBankAccptceFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02094]);
	}
	// 42 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.转让信用证】不得为空，否则报错（SP_VALIDATE_823_020）
	var trasfLcFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(trasfLcFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02362]);
	}
	// 43 当【画：信用证信息.留行信用证】勾选时，【画：信用证信息.留行日期】不得为空，否则报错（SP_VALIDATE_823_022）
	if (!SP_VALIDATE_823_022()) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01698]);
	}
	// 44 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.警报国家】不得为空，否则报错（SP_VALIDATE_823_020）
	var alertCountry = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/alertCountry']:checked")
			.val();
	if (!SP_VALIDATE_823_020(alertCountry)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01593]);
	}
	// 45 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.代理行】不得为空，否则报错（SP_VALIDATE_823_020）
	var agcBankFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/agcBankFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(agcBankFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01129]);
	}
	// 46 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.国内信用证】不得为空，否则报错（SP_VALIDATE_823_020）
	var domstcLcFlg = $(":radio[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/domstcLcFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(domstcLcFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01404]);
	}
	// 47 当【画：新建.信用证项下】为‘Y’时，【画：信用证信息.Combined LC】不得为空，否则报错（SP_VALIDATE_823_020）
	var combinedLcFlg = $(":radio[name='data/BcMntnOpDtlVO/combinedLcFlg']:checked")
			.val();
	if (!SP_VALIDATE_823_020(combinedLcFlg)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00305]);
	}

	// 48- 【画：信用证信息.信用证金额.币种】不为空时，必须等于【画：新建.汇票金额.币种】，否则报错（VALIDATE_00035）：
	// {0}的金额必须等于{1}。
	var lcAmtCcy = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmtCcy']")
			.val();
	var bxCcy = $("[name='data/BcMntnOpDtlVO/bxCcy']").val();
	if ($.trim(lcAmtCcy) != "") {
		validateResult = $.art.Validator.validateBatch(lcAmtCcy, "inputEq["
						+ bxCcy + "]", artI18N.Label.Label_823_00026,
				artI18N.Label.Label_823_00005);
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}

	// 49- 【画：信用证信息.信用证余额.金额】不为空时，必须小于等于【画：信用证信息.信用证金额.金额】（VALIDATE_00034）:
	// {0}的金额必须小于等于{1}。
	var lcBalAmt = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcBalAmt']")
			.val();
	var lcAmt = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmt']").val();
	if ($.trim(lcBalAmt) != "") {
		validateResult = $.art.Validator.validateBatch(lcBalAmt,
				"moneyLessthanEq[" + lcAmt + "]",
				artI18N.Label.Label_823_00027,
				artI18N.Label.Label_823_00026);
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}

	// 50- 【画：信用证信息.到期日期】不为空时，必须大于等于【画：信用证信息.开证日期】（VALIDATE_00027）:
	// {0}必须大于等于{1}。
	var dueDate = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate']")
			.val();
	var issueDate = $("[name='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate']")
			.val();
	if ($.trim(dueDate) != "") {
		validateResult = $.art.Validator.validateBatch(dueDate,
				"dateMorethanEq['" + issueDate + "']",
				artI18N.Label.Label_COM_01184,
				artI18N.Label.Label_COM_01626);
		if (validateResult.state == false) {
			return validateResult.messages;
		
		}
	}

	// 51- 当【画：新建.P.P.NEGO】勾选时，【画：信用证信息.有偿付行】必须为‘Y’，否则报错（SP_VALIDATE_823_004）
	if (!SP_VALIDATE_823_004()) {
		return $.getExceptionMsg('ART00094-E');
	}

	/*
	 * 52- 当以下项目中有一个项目被输入时，其余项目都不得为空，否则报错（SP_VALIDATE_823_029） 【画：信用证信息.Combined
	 * LC信息.信用证编号#1-#5】 【画：信用证信息.Combined LC信息.信用证金额#1-#5.金额】 【画：信用证信息.Combined
	 * LC信息.drawn amount#1-#5.金额】 【画：信用证信息.Combined LC信息.信用证余额#1-#5.金额】
	 */
	if (!SP_VALIDATE_823_029()) {
		return $.getExceptionMsg('ART00094-E',[artI18N.Label.Label_COM_00305]);
	}

	// 53- 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时，则Combined
	// LC信息表格中信用证编号有值的记录条数必须大于等于2，否则报错（SP_VALIDATE_823_005）
	if (!SP_VALIDATE_823_005()) {
		return $.getExceptionMsg('ART00097-E');
	}

	/*
	 * 54- 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.Combined LC】为‘Y’时， 【画：信用证信息.Combined
	 * LC信息.drawn amount#1-#5.金额】的合计必须等于【画：新建.汇票金额.金额】，否则报错（SP_VALIDATE_823_008）
	 */
	if (!SP_VALIDATE_823_008()) {
		return $.getExceptionMsg('ART82302-E');
	}

	// 55- 【画：信用证信息.Combined LC信息.信用证余额#2-#5.金额】不为空时，必须分别小于等于【画：信用证信息.Combined
	// LC信息.信用证金额#2-#5.金额】（VALIDATE_00034） ：{0}的金额必须小于等于{1}
	$("#bbCombLcNo>table>tbody>tr:visible").each(function(i, o) {
		var thizTr = $(this);
		var index = i;
		// 【画：信用证信息.Combined LC信息.信用证金额.金额】
		var lcAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[" + index + "]/lcAmt']", thizTr);
		// 【画：信用证信息.Combined LC信息.信用证余额.金额】
		var lcBalAmt = $("[name='data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[" + index + "]/lcBalAmt']", thizTr);
		if (index > 0 && "" != $.trim(lcBalAmt.val())) {
			validateResult = $.art.Validator.validateBatch(lcBalAmt.val(),
					"moneyLessthanEq[" + lcAmt.val() + "]",
					artI18N.Label.Label_823_00027 + index,
					artI18N.Label.Label_823_00026 + index);
			if (validateResult.state == false) {
				return validateResult.messages;
			}
		}
	});

	// 56
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.转让编号】不得为空，否则报错（SP_VALIDATE_823_023）
	var result = ($.trim($("[name='data/BcMntnOpDtlVO/trasfTKind']").val()) == "")
			|| ($
					.trim($("[name='data/BcMntnOpDtlVO/trasfNoPrmryRefNo']")
							.val()) == "")
			|| ($.trim($("[name='data/BcMntnOpDtlVO/trasfNoSubRefNo']").val()) == "")
	if (!SP_VALIDATE_823_023(result)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00034]);
	}
	// 57
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.第一受益人账户】不得为空，否则报错（SP_VALIDATE_823_023）
	result = ($.trim($("#bene1stAcctCcy").val()) == "")
			|| ($.trim($("#bene1stAcctGl").val()) == "")
			|| ($.trim($("#bene1stAcctSubGl").val()) == "")
			|| ($.trim($("#bene1stAcctNo").val()) == "")
	if (!SP_VALIDATE_823_023(result)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00035]);
	}
	// 58
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.转让金额.金额】不得为空，否则报错（SP_VALIDATE_823_023）
	result = ($.trim($("#trasfAmt").val()) == "")
	if (!SP_VALIDATE_823_023(result)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00036]);
	}
	// 59 【画：信用证信息.转让金额.金额】不为空时，必须大于0，否则报错（VALIDATE_00031）: {0}的金额必须大于{1}。
	validateResult = $.art.Validator.validateBatch($("#trasfAmt").val(),
			"moneyMorethan[" + 0 + "]", artI18N.Label.Label_823_00036, "0");
	if ($.trim($("#trasfAmt").val()) == "") {
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}
	// 60 【画：信用证信息.转让金额.金额】不为空时，必须小于等于【画：新建.汇票金额.金额】，否则报错（VALIDATE_00034）:
	// {0}的金额必须小于等于{1}。
	validateResult = $.art.Validator.validateBatch($("#trasfAmt").val(),
			"moneyLessthanEq[" + $("#bxAmt").val() + "]",
			artI18N.Label.Label_823_00036, artI18N.Label.Label_823_00005);
	if ($.trim($("#trasfAmt").val()) != "") {
		if (validateResult.state == false) {
			return validateResult.messages;
		}
	}
	// 61
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.第二受益人银行国别.国家】不得为空，否则报错（SP_VALIDATE_823_023）
	var result = ($.trim($("[name='data/BcMntnOpDtlVO/bene2ndNatnlty']").val()) != "")
	if (!SP_VALIDATE_823_023(result)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00037]);
	}
	// 62
	// 当【画：信用证信息.第二受益人银行国别.国家】为‘CHN’,【画：信用证信息.第二受益人银行国别.省】不得为空，否则报错（SP_VALIDATE_823_035）
	if (!SP_VALIDATE_823_035(
			$("[name='data/BcMntnOpDtlVO/bene2ndProv']").val(), 0)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00037]);
	}
	// 63
	// 当【画：信用证信息.第二受益人银行国别.国家】为‘CHN’,【画：信用证信息.第二受益人银行国别.市】不得为空，否则报错（SP_VALIDATE_823_035）
	if (!SP_VALIDATE_823_035(
			$("[name='data/BcMntnOpDtlVO/bene2ndCity']").val(), 0)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00037]);
	}
	// 64
	// 当【画：新建.信用证项下】为‘Y’且【画：信用证信息.转让第二受益人】为‘Y’时，【画：信用证信息.OSA/NRA】不得为空，否则报错（SP_VALIDATE_823_023）
	var result = ($
			.trim($(":radio[name='data/BcMntnOpDtlVO/undtk1stBeneFlg']:checked")
					.val()) == "")
	if (!SP_VALIDATE_823_023(result)) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00631]);
	}
	// 65 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.进口商名称】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/imptrName']").val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01588]);
	}
	// 66 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.进口商国别】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/imptrNatnlty']")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01587]);
	}
	// 67 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.OSA/NRA】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($(":radio[name='data/BcMntnOpDtlVO/osaNraFlg']:checked")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_00631]);
	}
	// 68 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.行号】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankCode']")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);
	}
	// 69 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.Swift】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankSwift']")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);
	}
	// 70 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.名称】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankName']")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);
	}
	// 71 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.寄单行.地址】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($("[name='data/BcMntnOpDtlVO/dispchDocBankAddr']")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00012]);
	}
	// 72 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.警报国家】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($(":radio[name='data/BcMntnOpDtlVO/alertCountry']:checked")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01593]);
	}
	// 73 当【画：新建.信用证项下】为‘N’时，【画：非信用证信息.代理行】不得为空，否则报错（SP_VALIDATE_823_024）
	if (!SP_VALIDATE_823_024($(":radio[name='data/BcMntnOpDtlVO/agcBankFlg']:checked")
			.val())) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01129]);
	}
	// 74
	// 【Hidden：信用证编号】必须等于【画：信用证信息.信用证编号】，否则报错（SP_VALIDATE_823_098）：{0}被修改过，请重新点击{1}按钮，或恢复为修改前的值。
	if (!SP_VALIDATE_823_098("lcNo")) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_02151,artI18N.Label.Link_823_00004]);
	}
	// 75 【Hidden：转让编号】必须等于【画：信用证信息.转让编号】，否则报错（SP_VALIDATE_823_098）:
	// {0}被修改过，请重新点击{1}按钮，或恢复为修改前的值。
	if (!SP_VALIDATE_823_098("trasfNo")) {
		return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_823_00034,artI18N.Label.Link_823_00004]);
	}
	// 76 当前寄单信息行的【Hidden：新增寄单信息标志】的值设为：Y时，做以下【画：寄单信息】板块项目的校验（※需循环判断，出错后退出校验）
	for (var i = 1; i <= ($("#dispchDocTable :checkbox").length - 2); i++) {
		if ($("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList[" + i
				+ "]/dispchDocFlgAdd']").val() == "Y") {
			// 【画：寄单信息.快递类型】不得为空，否则报错（VALIDATE_00018）
			validateResult = $.art.Validator
					.validateBatch(
							$
									.trim($(":radio[name='data/BcMntnOpDtlVO/dispchDocInfoVOList["
											+ i + "]/exprsType']:checked")
											.val()), "required",
							artI18N.Label.Label_COM_01671);
			if (validateResult.state == false) {
				return validateResult.messages;
			}
			// 当【画：寄单信息.寄单对象】为‘1：银行’时，则【画：寄单信息.寄单种类】不得为空，否则报错（SP_VALIDATE_823_028）
			if (!SP_VALIDATE_823_028(i)) {
				return $.getExceptionMsg('ART00018-E',[artI18N.Label.Label_COM_01522]);
			}
			// 【画：寄单信息.收件人】不得为空，否则报错（VALIDATE_00018）
			validateResult = $.art.Validator.validateBatch(
					$("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList[" + i
							+ "]/recpnt']").val(), "required",
					artI18N.Label.Label_COM_01895);
			if (validateResult.state == false) {
				return validateResult.messages;
			}
			// 【画：寄单信息.快递寄单日】不得为空，否则报错（VALIDATE_00018)
			validateResult = $.art.Validator.validateBatch(
					$("[name='data/BcMntnOpDtlVO/dispchDocInfoVOList[" + i
							+ "]/exprsDispchDocDate']").val(), "required",
					artI18N.Label.Label_COM_01669);
			if (validateResult.state == false) {
				return validateResult.messages;
			}
		}
	}

	return errMsg;
}

/**
 * 方法说明：新建编辑 点击【画：记账】Link时，数据校验逻辑 返回值: true 校验通过 false 校验未通过 参数： 无
 */
function generateValidate() {
	var errMsg = [];

	// 【画：手续费】板块中‘单独记账’不勾选且已收的手续费条数必须小于等于5条，否则报错（SP_VALIDATE_823_038）
	if (!SP_VALIDATE_823_038()) {
		return $.getExceptionMsg('ART00121-E',[artI18N.Label.Link_823_00001, "5"]);
	}

	return errMsg;
}
