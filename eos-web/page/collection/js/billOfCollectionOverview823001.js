$(function(){

	// 导出Excel初始化
	$("#exportExcelBiz").show();
	$("#exportExcelOpr").hide();
	$("#commonQueryType").click(function(){
		if(!!$(this).attr("checked")){
			$("#exportExcelOpr").show();
			$("#exportExcelBiz").hide();
		} else {
			$("#exportExcelBiz").show();
			$("#exportExcelOpr").hide();
		}
	});
	
	$(".a_expand").click(function(){					
		var thiz = $(this);			
		if(thiz.hasClass('a_expand2')){			
			thiz.removeClass('a_expand2');	
			$(".expand_table:eq(" + (thiz.index(".a_expand")) + ")").show();	
		}else{			
			thiz.addClass('a_expand2');	
			$(".expand_table:eq(" + (thiz.index(".a_expand")) + ")").hide();
		}			
		return false;			
	});

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
	val = combinedHyphenString(rowData.tkind,rowData.txnPrmryRefNo,rowData.txnSubRefNo);
	var html = "<span style=\"color:red\">"+val+"</span>";
	// val 需要绑定的链接的内容。
	// bizPrimaryKey：业务主键。
	// operSn：操作流水编号。
	// operVerNo：操作版本号。
	return $.art.dataGridPlugin.linkReadOnlyDetail(html,rowData.commBizNo,rowData.commonOperSn,rowData.commonOperVerNo);
}