<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/page/common/bizTagLib.inc"%>

<html>
	<head>
		<title>托收一览</title>
		<h:script charset="utf-8" src="/artframework/js/jquery.art.core.js"/>
		<h:script charset="utf-8" src="/artframework/js/jquery.art.operButton.js"/>
		<h:script charset="utf-8" src="/artframework/js/summary/art.datagrid.plugin.js"/>
		<h:script charset="utf-8" src="/artframework/js/summary/art.search.js"/>
		<h:script charset="utf-8" src="/artframework/js/jquery.art.searchBtn.js"/>
			
		<h:script src="/page/common/js/plugin/jquery.art.fnextend.js" />
		<h:script src="/page/common/js/plugin/jquery.art.dateutil.js" />
		<h:script src="/page/common/js/common.js"/>		
		<h:script src="/page/collection/js/billOfCollectionOverview823001.js"></h:script>
	</head>
	
	<body>
		<arthtml:hidden id="comBizEngAbbr" value="Collection"/>
		<arthtml:hidden id="artLogicPageId" value="823001001"/>
		<div class="block">
			<div class="block_title">
				<div class="block_tabs">
					<div class="tabs">
						<ul>
							<li class="now">
								<a href="javaScript:void(0);"><em><arthtml:label key="Label_COM_02407"></arthtml:label></em></a><%--日常操作--%>
							</li>
							<span class="btn_frtab">
								<arthtml:dynSelect styleClass="art_templet_query" >
								</arthtml:dynSelect>
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
									<!-- 默认生成的业务状态、操作、定价状态三个查询条件 -->
									<tr>
										<th>
											<span class="icon_key"></span>
											<arthtml:label key="Label_COM_02417"/><%--业务状态--%>：
										</th>
										<td>
											<arthtml:bizStatus id="commonBizStatus" name="commonBizStatus" bizDefId="823-00" styleClass="input_cn_8em control-key-field"/>
										</td>	
										<th>
											<span class="icon_key"></span>
											<arthtml:label key="Label_COM_02418"/><%--操作--%>：
										</th>
										<td>
											<arthtml:operType operType="0" id="commonOper" name="commonOper" bizDefId="823-00" styleClass="input_cn_8em control-key-field" filterEventId="E-850-001,E-850-002,E-850-003"/>
											<arthtml:operStatus id="commonOperStatusBack" name="commonOperStatus" styleClass="input_cn_8em control-key-field" value="data/NoticeTaskState/operStatDefNo"/>
										</td>
									</tr>
									<tr>
										<th>
											<span class="icon_key"></span>
											<arthtml:label key="Label_823_00002"/><%--定价状态--%>：
										</th>
										<td>
											<arthtml:dict  data="CA0233" name="commonPriceStatus" property="commonPriceStatus" id="commonPriceStatus" styleClass="input_cn_8em control-key-field"/>
										</td>
										<th>
											<span class="icon_key"></span><arthtml:label key="Label_823_00003"/><%--交易参号--%>：
										</th>
										<td>
											<arthtml:artuiBusiDealNumber id="dealNumber">	
												<arthtml:artuiBusiDealNumberTKND property="tkind" styleClass="input_en_3em control-key-field" /><arthtml:label key="Label_COM_00001"/><%-----%> 
												<arthtml:artuiBusiDealNumberMainParam property="txnPrmryRefNo" styleClass="input_num_6em control-key-field" /><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:artuiBusiDealNumberSubParam property="txnSubRefNo" styleClass="input_num_2em control-key-field" />
											</arthtml:artuiBusiDealNumber>
										</td>	
									</tr>
									<tr>
										<th><arthtml:label key="Label_COM_02066"/><%--托收日期--%>：</th>
										<td>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-start-date" property="collDateFrom"/>	
											<arthtml:label key="Label_COM_00032"/><%--～--%>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-end-date" property="collDateTo"/>
										</td>
										<th>
											<span class="icon_key"></span><arthtml:label key="Label_823_00004"/><%--受益人--%>：
										</th>
										<td>
											<arthtml:custCif id="beneCif" styleClass="input_num_8em control-key-field" property="beneCif"/>
											<arthtml:custName id="beneName" styleClass="input_cn_18em control-key-field" property="beneName"/>
										</td>
									</tr>
									<tr>
										<th><arthtml:label key="Label_823_00005"/><%--汇票金额--%>：</th>
										<td>
                    		<arthtml:artuiScopeMoney>
												<arthtml:artuiScopeMoney-currencyType styleClass="input_en_3em" name="bxCcy"/>
												<arthtml:artuiScopeMoney-minAmount property="bxAmtFrom" styleClass="input_money_short t_right" groupSeparator="true"/>
												<arthtml:artuiScopeMoney-maxAmount property="bxAmtTo" styleClass="input_money_short t_right" groupSeparator="true"/>
											</arthtml:artuiScopeMoney>
                                            
										</td>
										<th><arthtml:label key="Label_COM_01274"/><%--发票编号--%>：</th>
										<td>
											<arthtml:text property="ivcNo" value="" styleClass="input_cn_15em" maxlength="30" />
										</td>									
									</tr>
									<tr>
										<th><arthtml:label key="Label_COM_02151"/><%--信用证编号--%>：</th>
										<td>
											<arthtml:text property="lcNo" value="" styleClass="input_cn_15em" maxlength="16"/>
										</td>
										<th><arthtml:label key="Label_COM_01704"/><%--履行保兑责任--%>：</th>
										<td>
											<arthtml:dict id="perfmConfmDuties" data="CA0435" styleClass="input_cn_8em select" property="perfmConfmDuties" name="perfmConfmDuties"/>
										</td>
									</tr>
									<tr class="search_hide_tr hide">
										<th><arthtml:label key="Label_COM_01404"/><%--国内信用证--%>：</th>
										<td>
											<arthtml:dict id="domstcLcFlg" data="CA0435" styleClass="input_cn_8em select" property="domstcLcFlg" name="domstcLcFlg"/>
										</td>
										<th><arthtml:label key="Label_COM_01055"/><%--承兑登记日--%>：</th>
										<td>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-start-date" property="accptceRegDataFrom"/>
											<arthtml:label key="Label_COM_00032"/><%--～--%>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-end-date" property="accptceRegDataTo"/>
										</td>	
									</tr>
									<tr class="search_hide_tr hide">
										<th><arthtml:label key="Label_COM_02097"/><%--我行对客入账日--%>：</th>
										<td>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-start-date" property="ourBankToCustBookingDateFrom"/>
											<arthtml:label key="Label_COM_00032"/><%--～--%>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-end-date" property="ourBankToCustBookingDateTo"/>
										</td>	
										<th><arthtml:label key="Label_823_00006"/><%--退改单登记日--%>：</th>
										<td>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-start-date" property="regDateFrom"/>
											<arthtml:label key="Label_COM_00032"/><%--～--%>
											<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date control-end-date" property="regDateTo"/>
										</td>	
									</tr>
									<tr class="search_hide_tr hide">
										<th><arthtml:label key="Label_COM_01200"/><%--电报议付--%>：</th>
										<td>
											<arthtml:dict id="telegNegoFlg" data="CA0435" styleClass="input_cn_8em select" property="telegNegoFlg" name="telegNegoFlg"/>
										</td>
										<th><arthtml:label key="Label_COM_01368"/><%--故障编号--%>：</th>
											<td>
												<arthtml:text property="faultNo" value="" maxlength="15"/>
											</td>
										</tr>
									</tbody>
								</table>
								<arthtml:hidden name="branchBank" id="branchBankHidden"/>
								</form>
								<%--  <arthtml:artBranchBankSelect referenceId="branchBankHidden"/>--%>
							</div>

              <!-- 共通按钮 -->
							<div id="srhbtn1" class="block_search_btn dropdown1">
								<div class="dropdown1_btn"></div>
								<arthtml:summaryQueryButton resultTableId="summaryDataGrid" searchFormId="searchCriteriaForm"/>								
							</div>
						</div>
					</div>

					<div class="block_slide_content">
						<div class="block_nom">
							<div class="block_title">
								<h3><arthtml:label key="Label_COM_02415"></arthtml:label><%--检验结果一览--%></h3>
							<em>
								<div class="select_title">
									<arthtml:dynCheckbox id="commonQueryType" name="commonQueryType"/>
									<%-- value值为actionCategory的name --%>
									<arthtml:hidden id="bizQuery" value="Collection/BizSearch/summary"/>
									<arthtml:hidden id="operQuery" value="Collection/OperSearch/summary"/>
									&nbsp;&nbsp;<arthtml:label key="Label_COM_02416"></arthtml:label><%--查询各操作节点--%> &nbsp;&nbsp;&nbsp;&nbsp;
								</div>
							</em>
						</div>
						<div class="block_content_nopadding">
							<div class="block_content_table_long" style="overflow-x:scroll">
								<table id="summaryDataGrid" class="table_result artui-datagrid" style="width:2800px;"
									 data-options="pageId:'page_pagination',reqType:'Collection/BizSearch/summary',action:'queryList',pageSize:20,pageType:0,checkbox:true,singleSelect:true"
									 cellpadding="0" cellspacing="0">
									<thead>
										<tr>
											<th class="t_center" width="15px"><input type="checkbox" /></th>
											<th class="t_center" width="25px">No.</th>
											<th width="62px" nowrap><arthtml:label key="Label_COM_02417"/><%--业务状态--%></th>
											<th width="51px" nowrap><arthtml:label key="Label_COM_02418"/><%--操作--%></th>
											<th width="62px" nowrap><arthtml:label key="Label_COM_02419"/><%--操作状态--%></th>
											<th width="62px"><arthtml:label key="Label_823_00002"/><%--定价状态--%></th>
											<th width="95.85px"><arthtml:label key="Label_823_00003"/><%--交易参号--%></th>
											<th width="72.49px"><arthtml:label key="Label_COM_02066"/><%--托收日期--%></th>
											<th colspan=2 width="282.35px"><arthtml:label key="Label_823_00004"/><%--受益人--%></th>
											<th colspan=2 width="86.89px"><arthtml:label key="Label_823_00005"/><%--汇票金额--%></th>
											<th width="78.73px"><arthtml:label key="Label_COM_01274"/><%--发票编号--%></th>
											<th width="47.55px"><arthtml:label key="Label_COM_00844"/><%--Tenor--%></th>
											<th width="72.49px"><arthtml:label key="Label_COM_01184"/><%--到期日期--%></th>
											<th width="72.25px"><arthtml:label key="Label_COM_02158"/><%--信用证项下--%></th>
											<th width="31.2px"><arthtml:label key="Label_COM_00220"/><%--BPO--%></th>
											<th width="28.87px"><arthtml:label key="Label_COM_00872"/><%--TSU--%></th>
											<th width="96.64px"><arthtml:label key="Label_COM_02151"/><%--信用证编号--%></th>
											<th width="138.62px"><arthtml:label key="Label_COM_01588"/><%--进口商名称--%></th>
											<th width="62.33px"><arthtml:label key="Label_823_00012"/><%--寄单行--%></th>
											<th width="29.65px"><arthtml:label key="Label_COM_01399"/><%--国别--%></th>
											<th width="72.49px"><arthtml:label key="Label_COM_01055"/><%--承兑登记日--%></th>
											<th width="72.49px"><arthtml:label key="Label_COM_01052"/><%--承兑到期日--%></th>
											<th width="43.68px"><arthtml:label key="Label_COM_02044"/><%--头寸日--%></th>
											<th width="100.81px"><arthtml:label key="Label_COM_02097"/><%--我行对客入账日--%></th>
											<th colspan=2 width="57.96px"><arthtml:label key="Label_823_00013"/><%--头寸金额--%></th>
											<th colspan=2 width="86.54px"><arthtml:label key="Label_823_00014"/><%--他行扣款金额--%></th>
											<th width="68.56px"><arthtml:label key="Label_823_00015"/><%--P.P.NEGO--%></th>
											<th width="57.97px"><arthtml:label key="Label_COM_01200"/><%--电报议付--%></th>
											<th width="115.09px"><arthtml:label key="Label_COM_01201"/><%--电报议付销号日期--%></th>
											<th width="86.53px"><arthtml:label key="Label_823_00016"/><%--电报议付备注--%></th>
											<th width="86.53px"><arthtml:label key="Label_823_00006"/><%--退改单登记日--%></th>
											<th width="43.68px"><arthtml:label key="Label_COM_02048"/><%--退改单--%></th>
											<th width="72.25px"><arthtml:label key="Label_823_00018"/><%--退改单备注--%></th>
											<th width="57.97px"><arthtml:label key="Label_COM_01368"/><%--故障编号--%></th>												
											<th width="72.25px"><arthtml:label key="Label_COM_01404"/><%--国内信用证--%></th>
											<th width="86.53px"><arthtml:label key="Label_COM_01704"/><%--履行保兑责任--%></th>
										</tr>
									</thead>

									<tbody>
										<tr class="td_data_list" height="25">
								    		<td align="center"><arthtml:dynCheckbox styleClass="datagrid-cell-check"/></td>
								    		<td class="t_center" data-options="field:'no',formatter:function(val,row,rowidx){return getGridRowNum('page_pagination',rowidx)}"></td>
								    		<td data-options="field:'commonBizStatus',formatter:function(val,row,rowidx){return getLabelByBizStatusId(val,row,rowidx)}"></td>
								    		<td data-options="field:'commonOper',formatter:function(val,row,rowidx){return getLabelByOperId(val,row,rowidx)}"></td>
								    		<td data-options="field:'commonOperStatus',formatter:function(val,row,rowidx){return getLabelByOperStatusId(val,row,rowidx)}"></td>
								    		<td data-options="field:'commonPriceStatus'"></td>
								    		<td data-options="field:'combinedSrcTNo',formatter:function(val,row,rowidx){return getTxnNo(val,row,rowidx)}"></td>
								    		<td data-options="field:'collDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'beneCif'"></td>
								    		<td data-options="field:'beneName'"></td>
								    		<td data-options="field:'bxCcy'"></td>
								    		<td data-options="field:'bxAmt',formatter:function(val,row,rowidx){return formatNum(val,2)}"></td>
								    		<td data-options="field:'ivcNo'"></td>
								    		<td data-options="field:'tenorType'"></td>
								    		<td data-options="field:'dueDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'lcFlg'"></td>
								    		<td data-options="field:'bpoFlg'"></td>
								    		<td data-options="field:'tsuFlg'"></td>
								    		<td data-options="field:'lcNo'"></td>
								    		<td data-options="field:'imptrName'"></td>
								    		<td data-options="field:'dispchDocBankName'"></td>
								    		<td data-options="field:'natnlty'"></td>
								    		<td data-options="field:'accptceRegDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'accptceDueDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'posDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'ourBankToCustBookingDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'posCcy'"></td>
								    		<td data-options="field:'posAmt',formatter:function(val,row,rowidx){return formatNum(val,2)}"></td>
								    		<td data-options="field:'theirDedctCcy'"></td>
								    		<td data-options="field:'theirDedctAmt',formatter:function(val,row,rowidx){return formatNum(val,2)}"></td>
								    		<td data-options="field:'ppnegoFlg'"></td>
								    		<td data-options="field:'telegNegoFlg'"></td>
								    		<td data-options="field:'telegNegoClsDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'rmrk'"></td>
								    		<td data-options="field:'regDate',formatter:function(val,row,rowidx){with($.dateUtil){return dateToString(stringToDate(val))}}"></td>
								    		<td data-options="field:'bbMaintType'"></td>
								    		<td data-options="field:'bbModChgbkDocInfoRmrk'"></td>
								    		<td data-options="field:'faultNo'"></td>
								    		<td data-options="field:'domstcLcFlg'"></td>
								    		<td data-options="field:'perfmConfmDuties'"></td>
								    	</tr>
									</tbody>
								</table>
							</div>
							<arthtml:artuiPagination id="page_pagination"/>
							
							<div id="btn1" class="block_bottom">
								<div class="block_bottom_left">
									<arthtml:permission resourceId="00000002000009" bizDefId="823-00">
										<arthtml:artuiExportExcel action="exportExcel"  formId="searchCriteriaForm" reqType=""
										 id="exportExcel" styleClass="btn_gray art_export_excel" iconClass="icon3_excleshuchu">
										 	<arthtml:label key="Label_COM_02425"></arthtml:label><%--导出EXCEL--%>
										</arthtml:artuiExportExcel>
									</arthtml:permission>
									<arthtml:hidden id="bizExport" value="Collection/BizSearch/exportExcel"/>
									<arthtml:hidden id="operExport" value="Collection/OperSearch/exportExcel"/>
								</div>
								<div class="block_bottom_right">
								    <!-- 工作流按钮 -->
									<arthtml:summaryEventButton bizDefId="823-00" filterEventId="E-850-001,E-850-002,E-850-003" eventFlg="true" operType="0" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>
</html>	