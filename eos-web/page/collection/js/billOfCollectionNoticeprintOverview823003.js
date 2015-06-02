$(function(){
	//共通按钮
	$(".dropdown1_btn").toggle(function(){
		$(".curtain_search_container .search_hide_tr").show();
	},function(){
		$(".curtain_search_container .search_hide_tr").hide();
	});
	
	$("#commonQueryType").prop("disabled",true) ;
});
/**
*方法说明：交易参号取得
*返回值:
*    交易参号
*参数：
*    val		需要绑定的链接的内容
*    rowData	一行内容
*    rowIndex	内容所在行号
*/
function getTxnNo(val,rowData,rowIndex){
	//设置转让编号格式
	val = combinedHyphenString(rowData.trasfTKind,rowData.trasfNoPrmryRefNo,rowData.trasfNoSubRefNo);
	//设置显示格式
	var html = "<span style=\"color:red\">"+val+"</span>";
	//返回只读链接
//	return $.art.dataGridPlugin.linkReadOnlyDetail(html,rowData.commBizNo,rowData.commonOperSn,rowData.commonOperVerNo);
	return "<a herf=\"javaScript:void(0);\" onclick=\"linkReadOnlyDetail('"+rowData.trasfTKind+"','"+rowData.trasfNoPrmryRefNo+"',"+rowData.trasfNoSubRefNo + ");\">"+html+"<a/>";
}

function NoticeLetterForCreate(){
		//定义表单元素div
		var div=$("<div/>");
		//定义表单元素form
		var asynform = $("<form/>");
		//将元素form添加到div中
		asynform.appendTo(div);
		//form元素中设置action属性值
		asynform.attr("action",$.art.Constants.BASE_PATH + "/cn.com.btmu.art.framework.pageflow.detail.flow");
		//form元素中设置method属性值
		asynform.attr("method","post");
		//form元素中设置target属性值
		asynform.attr("target","_blank");
		//定义表单元素input
		var inputReqType=$("<input/>");
		//input元素中设置属性name值，value值
		inputReqType.attr("name","data/_common/ReqType").attr("value","Collection/NoticeLetterCreate/detail");
		//添加到元素form中
		inputReqType.appendTo(asynform);
		//定义表单元素input
		var inputAction=$("<input/>");
		//input元素中设置属性name值，value值
		inputAction.attr("name","data/_common/action").attr("value","query");
		//添加到元素form中
		inputAction.appendTo(asynform);
		//设置操作为新建
		var hidBtnType = $("<input name='data/BbNoticeLettInfoVO/hidBtnType' value='Create' type='hidden'/>");
		//添加到元素form中
		hidBtnType.appendTo(asynform);
		//div添加到body中
		div.appendTo("body");
		//form提交
		asynform.submit();
		//隐藏div层元素
		div.hide();
}


function NoticeLetterForDelete(){
	
		//当未勾选时，提示需要勾选，不做后续动作 
		if ($("#summaryDataGrid").find(":checkbox:visible").length == 1 || $("#summaryDataGrid").artDatagrid("getChecked").length < 1)
		{
			showErrorMessage();
			return;
		}
		//定义表单元素div
		var div=$("<div/>");
		//定义表单元素form
		var asynform = $("<form/>");
		//将元素form添加到div中
		asynform.appendTo(div);
		//form元素中设置action属性值
		asynform.attr("action",$.art.Constants.BASE_PATH + "/cn.com.btmu.art.framework.pageflow.detail.flow");
		//form元素中设置method属性值
		asynform.attr("method","post");
		//form元素中设置target属性值
		asynform.attr("target","_blank");
		//定义表单元素input
		var inputReqType=$("<input/>");
		//input元素中设置属性name值，value值
		inputReqType.attr("name","data/_common/ReqType").attr("value","Collection/NoticeLetterDel/detail");
		//将元素input添加到form中
		inputReqType.appendTo(asynform);
		var inputAction=$("<input/>");
		//input元素中设置属性name值，value值
		inputAction.attr("name","data/_common/action").attr("value","query");
		inputAction.appendTo(asynform);
		
		//获取勾选行
		var selectedDataRow = $("#summaryDataGrid").artDatagrid("getChecked")[0];
		//获取勾选行中的转让TKind定义为input
		var trasfTKind = $("<input name='data/BbNoticeLettInfoVO/trasfTKind' value='"+ selectedDataRow.trasfTKind + "' type='hidden'/>");
		//添加到元素form中
		trasfTKind.appendTo(asynform);
		//获取勾选行中的转让trasfNoPrmryRefNo定义为input
		var trasfNoPrmryRefNo = $("<input name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo' value='"+ selectedDataRow.trasfNoPrmryRefNo + "' type='hidden'/>");
		//添加到元素form中
		trasfNoPrmryRefNo.appendTo(asynform);
		//获取勾选行中的转让trasfNoSubRefNo定义为input
		var trasfNoSubRefNo = $("<input name='data/BbNoticeLettInfoVO/trasfNoSubRefNo' value='"+ selectedDataRow.trasfNoSubRefNo + "' type='hidden'/>");
		//添加到元素form中
		trasfNoSubRefNo.appendTo(asynform);
		//设置操作为删除
		var hidBtnType = $("<input name='data/BbNoticeLettInfoVO/hidBtnType' value='Delete' type='hidden'/>");
		//添加到元素form中
		hidBtnType.appendTo(asynform);
		//div添加到body中
		div.appendTo("body");
		//form提交
		asynform.submit();
		//隐藏div层元素
		div.hide();
}


function NoticeLetterForModify(){
	
		//当未勾选时，提示需要勾选，不做后续动作 
		if ($("#summaryDataGrid").find(":checkbox:visible").length == 1 || $("#summaryDataGrid").artDatagrid("getChecked").length < 1)
		{
			showErrorMessage();
			return;
		}
		//定义表单元素div
		var div=$("<div/>");
		//定义表单元素form
		var asynform = $("<form/>");
		//将元素form添加到div中
		asynform.appendTo(div);
		//form元素中设置action属性值
		asynform.attr("action",$.art.Constants.BASE_PATH + "/cn.com.btmu.art.framework.pageflow.detail.flow");
		//form元素中设置method属性值
		asynform.attr("method","post");
		//form元素中设置target属性值
		asynform.attr("target","_blank");
		//定义表单元素input
		var inputReqType=$("<input/>");
		//input元素中设置属性name值，value值
		inputReqType.attr("name","data/_common/ReqType").attr("value","Collection/NoticeLetterModfctn/detail");
		//将元素input添加到form中
		inputReqType.appendTo(asynform);
		//定义表单元素input
		var inputAction=$("<input/>");
		//input元素中设置属性name值，value值
		inputAction.attr("name","data/_common/action").attr("value","query");
		//将元素input添加到form中
		inputAction.appendTo(asynform);
		
		//获取勾选行
		var selectedDataRow = $("#summaryDataGrid").artDatagrid("getChecked")[0];
		//获取勾选行中的转让TKind定义为input
		var trasfTKind = $("<input name='data/BbNoticeLettInfoVO/trasfTKind' value='"+ selectedDataRow.trasfTKind + "' type='hidden'/>");
		//添加到元素form中
		trasfTKind.appendTo(asynform);
		//获取勾选行中的转让trasfNoPrmryRefNo定义为input
		var trasfNoPrmryRefNo = $("<input name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo' value='"+ selectedDataRow.trasfNoPrmryRefNo + "' type='hidden'/>");
		//添加到元素form中
		trasfNoPrmryRefNo.appendTo(asynform);
		//获取勾选行中的转让trasfNoSubRefNo定义为input
		var trasfNoSubRefNo = $("<input name='data/BbNoticeLettInfoVO/trasfNoSubRefNo' value='"+ selectedDataRow.trasfNoSubRefNo + "' type='hidden'/>");
		//添加到元素form中
		trasfNoSubRefNo.appendTo(asynform);
		//设置操作为修改
		var hidBtnType = $("<input name='data/BbNoticeLettInfoVO/hidBtnType' value='Modify' type='hidden'/>");
		//添加到元素form中
		hidBtnType.appendTo(asynform);
		//div添加到body中
		div.appendTo("body");
		//form提交
		asynform.submit();
		//隐藏div层元素
		div.hide();
}

function linkReadOnlyDetail(trasfTKind,trasfNoPrmryRefNo,trasfNoSubRefNo){

	alert("linkReadOnlyDetail" + trasfTKind + "-" + trasfNoPrmryRefNo + "-" + trasfNoSubRefNo);
	//定义表单元素div
	var div=$("<div/>");
	//定义表单元素form
	var asynform = $("<form/>");
	//将元素form添加到div中
	asynform.appendTo(div);
	//form元素中设置action属性值
	asynform.attr("action",$.art.Constants.BASE_PATH + "/cn.com.btmu.art.framework.pageflow.detail.flow");
	//form元素中设置method属性值
	asynform.attr("method","post");
	//form元素中设置target属性值
	asynform.attr("target","_blank");
	//定义表单元素input
	var inputReqType=$("<input/>");
	//input元素中设置属性name值，value值
	inputReqType.attr("name","data/_common/ReqType").attr("value","Collection/NoticeLetterDel/detail");
	//将元素input添加到form中
	inputReqType.appendTo(asynform);
	var inputAction=$("<input/>");
	//input元素中设置属性name值，value值
	inputAction.attr("name","data/_common/action").attr("value","query");
	inputAction.appendTo(asynform);
	
	//获取勾选行中的转让TKind定义为input
	var tTKind = $("<input name='data/BbNoticeLettInfoVO/trasfTKind' value='"+ trasfTKind + "' type='hidden'/>");
	//添加到元素form中
	tTKind.appendTo(asynform);
	//获取勾选行中的转让trasfNoPrmryRefNo定义为input
	var tNoPrmryRefNo = $("<input name='data/BbNoticeLettInfoVO/trasfNoPrmryRefNo' value='"+ trasfNoPrmryRefNo + "' type='hidden'/>");
	//添加到元素form中
	tNoPrmryRefNo.appendTo(asynform);
	//获取勾选行中的转让trasfNoSubRefNo定义为input
	var tNoSubRefNo = $("<input name='data/BbNoticeLettInfoVO/trasfNoSubRefNo' value='"+ trasfNoSubRefNo + "' type='hidden'/>");
	//添加到元素form中
	tNoSubRefNo.appendTo(asynform);
	//设置操作为删除
	var hidBtnType = $("<input name='data/BbNoticeLettInfoVO/hidBtnType' value='ReadOnly' type='hidden'/>");
	//添加到元素form中
	hidBtnType.appendTo(asynform);
	//div添加到body中
	div.appendTo("body");
	//form提交
	asynform.submit();
	//隐藏div层元素
	div.hide();
	
}

function showErrorMessage(){
	var warningMessages;
	var errorMessages = new Array();
	var msgText;
	msgText = "您没有在结果一览中选择具体的项目";
	errorMessages.push(msgText);
	$("#error_warning").warningDiv('open',{
				warningMsgs: warningMessages,
				errorMsgs: errorMessages
	});
}