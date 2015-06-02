<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/page/common/bizTagLib.inc"%>
<html>
<head>
<title>状态查询</title>
	<%@include file="/page/common/commonHeaderSummary.jsp"%>
	<script>
		function setPositionTxt(reqType){
			var url = getURLContextPrefix() + "/cn.com.btmu.art.framework.pageflow.detailNoWrap.flow?data/_common/ReqType=" + reqType + "&data/_common/action=init&data/_common/viewName=v_summary_load";
			document.getElementById("mainFrame").src = url;
		}
		$(function(){
          setPositionTxt("Collection//summary");
		})
	</script>
</head>
<body>
<form id="form_doSearchCstminf" action="" method="post">
<div class="sub_left" style="overflow: hidden;">
<iframe src="" id="mainFrame" width="100%" height="100%"></iframe>
</div>
</form>
<!-- 切换信息 -->
<div class="sub_right">
<div class="nvg_trade_menu">
<dl>
<dt>
  <h2 class="dt1" style="margin-top: -2px"><arthtml:label key="Link_823_00002"/><%--通知书打印--%></h2>
</dt>
<dd class="special twocols">
  <a href="#" onclick="setPositionTxt('Collection//summary')"><span class="icon2_tuoshou"></span></br><arthtml:label key="Link_823_00001"/><%--托收--%></a>
</dd>
<dd class="special twocols">
  <a href="#" onclick="setPositionTxt('Collection/second/summary')"><span class="icon2_tongzhishudayin"></span></br><arthtml:label key="Link_823_00002"/><%--通知书打印--%></a>
</dd>
<!--第二行-->
<div class="fbr"></div>
</dl>
</div>
</body>
</html>