/**
*方法说明：通知书打印(删除) 画面初始化
*返回值:
*    无
*参数：
*    无
*/
$(function(){
	alert("删除逻辑js");
	//设置检索按钮不可点击
  $("#btn_index").prop("disabled",true);
  // reqtype初期化
	$("#commonReqtype").val("Collection/NoticeLetter/Delete");
});

function save(){
	alert("删除提交保存")；
	//设置reqtye值
	$("#param_reqtype").val("Collection/NoticeLetter/Delete");
	//设置action值
	$("#param_action").val("modify");
	//form提交
	$("#artform_def_detail")[0].submit();
}
