<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/page/common/bizTagLib.inc"%>

<html>
	<head>
		<title>通知书打印一览</title>
		<h:script charset="utf-8" src="/artframework/js/jquery.art.core.js"/>
		<h:script charset="utf-8" src="/artframework/js/jquery.art.operButton.js"/>
		<h:script charset="utf-8" src="/artframework/js/summary/art.datagrid.plugin.js"/>
		<h:script charset="utf-8" src="/artframework/js/summary/art.search.js"/>
		<h:script charset="utf-8" src="/artframework/js/jquery.art.searchBtn.js"/>
			
		<h:script src="/page/common/js/plugin/jquery.art.fnextend.js" />
		<h:script src="/page/common/js/plugin/jquery.art.dateutil.js" />
		<h:script src="/page/common/js/common.js"/>	
		<h:script src="/js/locale/Label823.zh_cn.js"></h:script>	
		<h:script src="/page/collection/js/billOfCollectionNoticeprintOverview823003.js"></h:script>
	</head>
	
	<body>
		<arthtml:hidden id="comBizEngAbbr" value="Collection"/>
		<arthtml:hidden id="artLogicPageId" value="823003001"/>
		<div class="block">
			<div class="block_title">
			  <div class="block_tabs">
          <div class="tabs">
            <ul>
              <li class="now">
        	      <a href="javaScript:void(0);"><em><arthtml:label key="Label_COM_02407"></arthtml:label></em></a><%--日常操作--%>
              </li>
           		<span class="btn_frtab">
            		<arthtml:dynSelect styleClass="art_templet_query" ></arthtml:dynSelect>
             	</span>
              <span class="text_frtab">
                <arthtml:label key="Label_COM_02410"></arthtml:label><%--常用模板--%>
              </span>
            </ul>
          </div>
			  </div>
			</div>
			<div class="block_tabs_content">
				<div class="curtain_search_wrap">
				  <div class="curtain_search_container" >
					  <div id="tab1" class="block_search_2 search_block_height">
							<form id="searchCriteriaForm" method="post">
								<table class="table_search table_fixed table_3" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<th><arthtml:label key="Label_COM_02341"></arthtml:label><!--种类-->：</th>
											<td>
												<arthtml:dict id="type" data="CA0286" name="type" defaultSel='true'/>
											</td>
											<th>
											<span class="icon_key"></span>
												<arthtml:label key="Label_823_10001"></arthtml:label><!--转让编号-->：</th>
											<td>
												<arthtml:artuiBusiDealNumber id="dealNumber">	
													<arthtml:artuiBusiDealNumberTKND property="trasfTKind" styleClass="input_en_3em control-key-field" /> - 
													<arthtml:artuiBusiDealNumberMainParam property="trasfNoPrmryRefNo" styleClass="input_num_6em control-key-field" /> -
													<arthtml:artuiBusiDealNumberSubParam property="trasfNoSubRefNo" styleClass="input_num_2em control-key-field" />
												</arthtml:artuiBusiDealNumber>
											</td>	
										</tr>
										<tr>
											<th><arthtml:label key="Label_COM_01186"></arthtml:label><!--登记日-->：</th>
											<td>
												<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-start-date" property="regDateFrom"/>	
												<arthtml:label key="Label_COM_00032"/><%--～--%>
												<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-end-date" property="regDateTo"/>
											</td>
											<th><arthtml:label key="Label_COM_02151"></arthtml:label><!--信用证编号-->：</th>
											<td>
												<arthtml:text styleClass="input_cn_10em" property="lcNo" maxlength="16"/>
											</td>
										</tr>
										<tr>
											<th><arthtml:label key="Label_COM_01551"></arthtml:label><!--结算方式-->：</th>
											<td>
												<arthtml:dict id="stlmtMeth" data="CA0276" styleClass="input_cn_8em" property="stlmtMeth" name="stlmtMeth" defaultSel='true'/>
											</td>
											<th><arthtml:label key="Label_COM_01193"></arthtml:label><!--第二受益人-->：</th>
											<td>
												<arthtml:text styleClass="input_cn_20em" property="payeeName" maxlength="45"/>
											</td>
										</tr>
										<tr>
											<th>&nbsp;</th>
											<td>&nbsp;</td>
											<th>&nbsp;</th>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<th>&nbsp;</th>
											<td>&nbsp;</td>
											<th>&nbsp;</th>
											<td>&nbsp;</td>
										</tr>
									</tbody>
								</table>
						  </form>
					  </div>

						<!-- 共通按钮 -->
            <div class="block_search_btn dropdown1">
						  <div class="dropdown1_btn"></div>
							<arthtml:summaryQueryButton resultTableId="summaryDataGrid" searchFormId="searchCriteriaForm" />
						</div>
				  </div>
				</div>
					
				<div class="block_slide_content">
					<div class="block_nom">
						<div class="block_title">
							<h3><arthtml:label key="Label_COM_02415"></arthtml:label><!--检索结果一览--></h3>
						  <em>
								<div class="select_title">
									<%-- value值为actionCategory的name --%>
									<arthtml:hidden id="bizQuery" value="Collection/NoticeLetterBizSearch/summary"/>
									&nbsp;&nbsp;<arthtml:label key="Label_COM_02416"></arthtml:label><%--查询各操作节点--%> &nbsp;&nbsp;&nbsp;&nbsp;
								</div>
							</em>
						</div>
				  	<div class="block_content_nopadding ">
							<div class="block_content_table_long"  style="overflow-x:scroll">
								<table id="summaryDataGrid" class="table_result artui-datagrid" style="width:1300px;"
											 data-options="pageId:'page_pagination',reqType:'Collection/NoticeLetterBizSearch/summary',action:'queryList',pageSize:20,pageType:0,checkbox:true,singleSelect:true"
											 cellpadding="0" cellspacing="0">   
								  <thead>
									  <tr>
											<th class="t_center" width="15px"><arthtml:dynCheckbox /></th>
											<th class="t_center" width="25px"><arthtml:label key="Label_COM_00604"/><%--No.--%></th>												
											<th width="53.13px"><arthtml:label key="Label_COM_02341"></arthtml:label><%--  种类 --%></th>
											<th width="162.98px"><arthtml:label key="Label_823_10001"></arthtml:label><!--转让编号--></th>
											<th width="99.71px"><arthtml:label key="Label_COM_01186"></arthtml:label><!--登记日--></th>
											<th width="101.48px"><arthtml:label key="Label_COM_01551"></arthtml:label><!--结算方式--></th>
											<th width="166.97px"><arthtml:label key="Label_COM_02151"></arthtml:label><!--信用证编号--></th>
											<th colspan=2 width="150.23px"><arthtml:label key="Label_823_10003"></arthtml:label><!--来单金额--></th>
											<th width="83.86px"><arthtml:label key="Label_COM_01764"></arthtml:label><!--期限--></th>
											<th width="99.71px"><arthtml:label key="Label_COM_01182"></arthtml:label><!--到期日--></th>
											<th width="232.63px"><arthtml:label key="Label_COM_01193"></arthtml:label><!--第二受益人--></th>
											<th class="hide"></th>
										</tr>
									</thead>
									<tbody>
										<tr class="td_data_list">
							    		<td class="t_center"><arthtml:dynCheckbox styleClass="datagrid-cell-check"/></td>
							    		<td class="t_center" data-options="field:'no',formatter:function(val,row,rowidx){return getGridRowNum('page_pagination',rowidx)}"></td>
							    		<td data-options="field:'type'"></td>
                      <td data-options="field:'combinedTrasfTNo',formatter:function(val,row,rowidx){return getTxnNo(val,row,rowidx);}"></td>
                      <td data-options="field:'regDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
                      <td data-options="field:'stlmtMeth'"></td>
                      <td data-options="field:'lcNo'"></td>
                      <td data-options="field:'docRecvdCcy'"></td>
                      <td data-options="field:'docRecvdAmt',formatter:function(val,row,rowidx){return formatNum(val,2)}"></td>
                      <td data-options="field:'term'"></td>
                      <td data-options="field:'dueDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
                      <td data-options="field:'payeeName'"></td>
                      <td data-options="field:'ntid'" class="hide"></td>  		
								    </tr>
									</tbody>
								</table>
							</div>
							<arthtml:artuiPagination id="page_pagination"/>
								
							<div id="btn1" class="block_bottom">
								<div class="block_bottom_left">
										<arthtml:permission resourceId="00000002000009" bizDefId="850-00">
											<arthtml:artuiExportExcel reqType="" action="exportExcel"  formId="searchCriteriaForm"
									 		id="exportExcel" styleClass="btn_gray art_export_excel" iconClass="icon3_excleshuchu">
									 			<arthtml:label key="Label_COM_02425"></arthtml:label><%--导出EXCEL--%>
											</arthtml:artuiExportExcel>
										</arthtml:permission>
										<arthtml:hidden id="bizExport" value="Collection/NoticeLetterBizSearch/exportExcel"/>
								</div>
								<div class="block_bottom_right">
									<a href="javaScript:void(0)"  id="NoticeLetterForCreate" class="btn_gray" onclick="NoticeLetterForCreate()" actionback="detailNew" eventid="E-850-001" detailid="" reqtype="Collection/NoticeLetterCreate/detail"><span></span>通知书新建</a>	
									<a href="javaScript:void(0)"  id="NoticeLetterForModify" class="btn_gray" onclick="NoticeLetterForModify()" actionback="detailNoSelected" eventid="E-850-002" detailid="" reqtype="Collection/NoticeLetterModfctn/detail"><span></span>通知书修改</a>
									<a href="javaScript:void(0)"  id="NoticeLetterForDelete" class="btn_gray" onclick="NoticeLetterForDelete()" actionback="detailNoSelected" eventid="E-850-003" detailid="" reqtype="Collection/NoticeLetterDel/detail"><span></span>通知书删除</a>	
								</div>
							</div>
				  	</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>