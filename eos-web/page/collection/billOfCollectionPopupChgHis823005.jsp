<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/page/common/bizTagLib.inc"%>

<html>
	<head>
		<title>托收修改履历</title>
		<jsp:include flush="true" page="/page/common/commonHeader.jsp"/>
		<h:script src="/page/collection/js/billOfCollectionPopupChgHis823005.js"/>
	</head>

	<body>
		<div class="block_content_table_long">
				<table  id="dataGridDetail"  class="table_result artui-datagrid"
					data-options="pageId:'page_tests',reqType:'Collection/PopUpSearch/summary',action:'queryList',pageType:1,checkbox:false,singleSelect:false"
						cellpadding="0" cellspacing="0">   
					<thead>
						<tr class="ww_title">
							<th width="117.08px"><arthtml:label key="Label_COM_02178"/><%--修改日期--%></th>
							<th width="105.99px"><arthtml:label key="Label_COM_02179"/><%--修改项目--%></th>
							<th width="272.47px"><arthtml:label key="Label_COM_02175"/><%--修改前--%></th>
							<th width="272.47px"><arthtml:label key="Label_COM_02171"/><%--修改后--%></th>
							<th width="105.99px"><arthtml:label key="Label_COM_02180"/><%--操作人员--%></th>
						</tr>
			   		</thead>
					<tbody>
						<tr class="td_data_list">
							<td data-options="field:'modfctnDate'"></td>
							<td data-options="field:'modfctnItemField'"></td>
							<td data-options="field:'bfChagContnt'"></td>
							<td data-options="field:'modfdContnt'"></td>
							<td data-options="field:'operPrsn'"></td>    		
						</tr>
				</tbody>
			</table>
		</div>
		
		<br/>
		
		<div class="block_bottom_right">
	
			<a href="#" class="btn_gray"><span class="icon3_guanbi"></span><arthtml:label key="Link_823_00011"/><%--关闭--%></a>
		</div>
	</body>
</html>

