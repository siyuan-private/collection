<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/page/common/bizTagLib.inc"%>
<html>
	<head>
		<title>通知书打印详情</title>	
		<%@include file="/page/common/commonHeader.jsp"%>
		<h:script src="/page/collection/js/billOfCollectionNoticeprintDetail823004.js"/>
		<script charset="utf-8" src="<%=basePath%>/js/locale/Label823.<%=locale%>.js" type="text/javascript"></script>
		<html:script logicPrefix="billOfCollectionNoticeprintDetail" srcParent="/page/collection/js"/> 		
	</head>
	<body style="overflow-x:hidden">
		<arthtml:hidden property="data/BbNoticeLettInfoVO/hidTrasfTKind"/>
		<arthtml:hidden property="data/BbNoticeLettInfoVO/hidTrasfNoPrmryRefNo"/>
		<arthtml:hidden property="data/BbNoticeLettInfoVO/hidTrasfNoSubRefNo"/>
		<arthtml:hidden property="data/BbNoticeLettInfoVO/hidBtnType"/>
		<arthtml:hidden property="data/BbNoticeLettInfoVO/ntid"/>
		<arthtml:hidden property="data/bizTypeNo" value="850-00"/> 
		<arthtml:hidden id="commonReqtype" name="" value="Collection/NoticeLetterCreate/detail"/> 
		
		<div class="block_tabs_content detail_content">
			<div class="content_title block_title_nomargin">
				<a id="coveriControl" href="#" class="a_expand" index="0"></a>
				<span class="icon_tongzhishuxinxi"></span>
				&nbsp;<arthtml:label key="Label_COM_02341"/><%-- 通知书信息 --%> 
			</div>
			<div id="coveriControlPanel" class="div_display expand_table">
				<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
					<thead>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>
						<tr>
							<th><arthtml:label key="Label_COM_02341"/><!--种类-->：</th>
							<td>
							    <dict:radioGroup dictTypeId="CA0286" property="data/BbNoticeLettInfoVO/type"/>
							</td>
							<th><arthtml:label key="Label_823_10001"/><!--转让编号-->：</th>
							<td>
								<arthtml:artuiBusiDealNumber id="dealNumber">
									<arthtml:artuiBusiDealNumberTKND property="data/BbNoticeLettInfoVO/trasfTKind"/>
									<arthtml:label key="Label_COM_00001"/>
									<arthtml:artuiBusiDealNumberMainParam property="data/BbNoticeLettInfoVO/trasfNoPrmryRefNo"/>
									<arthtml:label key="Label_COM_00001"/>
									<arthtml:artuiBusiDealNumberSubParam property="data/BbNoticeLettInfoVO/trasfNoSubRefNo"/>
								</arthtml:artuiBusiDealNumber>
								<arthtml:permission resourceId = "85000002000001" bizDefId = "850-00">
								<a href="#" class="btn_gray" id="btn_index"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_10001"/><!--检索--></a>			
								</arthtml:permission>										
							</td>												
						</tr>											
						<tr>
							<th><arthtml:label key="Label_COM_01186"/><!--登记日-->：</th>
							<td>
								<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BbNoticeLettInfoVO/regDate" showWeekDay="false"/>
							</td>
							<th><arthtml:label key="Label_COM_01551"/><!--结算方式-->：</th>
							<td>
								<dict:checkbox dictTypeId="CA0276" property="data/BbNoticeLettInfoVO/lcStlmtMeth" id = "lcStlmtMeth" value="1"/>
								<dict:checkbox dictTypeId="CA0276" property="data/BbNoticeLettInfoVO/lgStlmtMeth" id = "lgStlmtMeth" value="2"/>
								<dict:checkbox dictTypeId="CA0276" property="data/BbNoticeLettInfoVO/collStlmtMeth" id = "collStlmtMeth" value="3"/>
								<dict:checkbox dictTypeId="CA0276" property="data/BbNoticeLettInfoVO/otherStlmtMeth" id = "otherStlmtMeth" value="4"/>
							</td>
							<th><arthtml:label key="Label_COM_02151"/><!--信用证编号-->：</th>
							<td>
								<arthtml:text maxlength="16" styleClass="input_cn_15em" property="data/BbNoticeLettInfoVO/lcNo"/>												
							</td>												
						</tr>
						<tr>
							<th><arthtml:label key="Label_823_10003"/><!--来单金额-->：</th>
							<td>
									<arthtml:currency id="docRecvdCcy" property="data/BbNoticeLettInfoVO/docRecvdCcy"  styleClass="input_en_3em" childId="docRecvdAmt"/>
									<arthtml:currencyMoney id='docRecvdAmt' styleClass="input_money_long t_right" property="data/BbNoticeLettInfoVO/docRecvdAmt" precision="2" /> 
							</td>
							<th><arthtml:label key="Label_COM_01626"/><!--开证日期-->：</th>
							<td>
								<arthtml:artuiDatetime id="issueDate" dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BbNoticeLettInfoVO/issueDate" showWeekDay="false"/>
							</td>												
						</tr>
						<tr>
							<th><arthtml:label key="Label_823_10007"/><!--索汇金额-->：</th>
							<td>
							  <arthtml:currency id="clmExchgAmtCcy" property="data/BbNoticeLettInfoVO/clmExchgAmtCcy"  styleClass="input_en_3em" childId="clmExchgAmt"/>
								<arthtml:currencyMoney id='clmExchgAmt' styleClass="input_money_long t_right" property="data/BbNoticeLettInfoVO/clmExchgAmt" precision="2" /> 	
							</td>
							<th><arthtml:label key="Label_COM_01764"/><!--期限-->：</th>
							<td>
								<arthtml:text styleClass="input_cn_10em" maxlength="40" property="data/BbNoticeLettInfoVO/term"/>
							</td>
							<th><arthtml:label key="Label_COM_01182"/><!--到期日-->：</th>
							<td>
								<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BbNoticeLettInfoVO/dueDate" showWeekDay="false"/>
							</td>
						</tr>
						<tr>
							<th><arthtml:label key="Label_COM_01675"/><!--来单行名称-->：</th>
							<td>
								<arthtml:text maxlength="60" styleClass="input_cn_20em" property="data/BbNoticeLettInfoVO/docRecvdBankName" title="<b:write property='data/BbNoticeLettInfoVO/docRecvdBankName'/>"/>											
							</td>
							<th><arthtml:label key="Label_COM_01674"/><!--来单行编号-->：</th>
							<td>
								<arthtml:text maxlength="8" styleClass="input_cn_10em" property="data/BbNoticeLettInfoVO/docRecvdBankNo"/>
							</td>	
							<th><arthtml:label key="Label_COM_01677"/><!--来单行邮件号-->：</th>
							<td>
								<arthtml:text maxlength="30" styleClass="input_cn_20em" property="data/BbNoticeLettInfoVO/docRecvdBankMailNo"/>
							</td>											
						</tr>
						<tr>
							<th><arthtml:label key="Label_COM_01914"/><!--收款人名称-->：</th>
							<td>
								<arthtml:text id="payeeName" maxlength="60" styleClass="input_cn_20em" property="data/BbNoticeLettInfoVO/payeeName" title="<b:write property='data/BbNoticeLettInfoVO/payeeName'/>"/>												
							</td>												
							<th><arthtml:label key="Label_COM_01904"/><!--收款行名称及地址-->：</th>
							<td>
								<arthtml:text maxlength="60" styleClass="input_cn_20em" property="data/BbNoticeLettInfoVO/recvgBankNameAndAddr" title="<b:write property='data/BbNoticeLettInfoVO/recvgBankNameAndAddr'/>"/>													
							</td>
							<th><arthtml:label key="Label_COM_01335"/><!--付款人名称-->：</th>
							<td>
								<arthtml:text id="payerName" maxlength="60" styleClass="input_cn_20em" property="data/BbNoticeLettInfoVO/payerName" title="<b:write property='data/BbNoticeLettInfoVO/payerName'/>"/>												
							</td>
						</tr>
						<tr>
							<th><arthtml:label key="Label_COM_01216"/><!--对公-->：</th>
							<td>
								<arthtml:dynCheckbox id="toPubFlg" property="data/BbNoticeLettInfoVO/toPubFlg" value="Y"/>&nbsp;&nbsp;<arthtml:label key="Label_COM_02392"/><!--组织机构代码-->：
								<arthtml:text styleClass="input_cn_8em" maxlength="8" id="orgCode1" property="data/BbNoticeLettInfoVO/orgCode1"/>
								-
								<arthtml:text styleClass="input_cn_1em" maxlength="1" id="orgCode2" property="data/BbNoticeLettInfoVO/orgCode2"/>
							</td>
							<th><arthtml:label key="Label_COM_01240"/><!--对私-->：</th>
							<td>
								<arthtml:dynCheckbox id="toPrivtFlg" property="data/BbNoticeLettInfoVO/toPrivtFlg" value="Y"/>
								&nbsp;&nbsp;<arthtml:label key="Label_COM_01350"/><!--个人身份证-->：
								<arthtml:text styleClass="input_cn_15em" maxlength="20" id="personalId" property="data/BbNoticeLettInfoVO/personalId"/>
							</td>
							<th><arthtml:label key="Label_COM_02335"/><!--中国居民个人-->：</th>
							<td>
								<dict:radioGroup dictTypeId="CA0435" id="cnResdnt" property="data/BbNoticeLettInfoVO/cnResdnt"/>
							</td>
						</tr>
						<tr>
							<th style="width:175px"><arthtml:label key="Label_COM_02006"/><!--提运单/货运单据号-->：</th>
							<td>
								<arthtml:text maxlength="25" styleClass="input_cn_15em" property="data/BbNoticeLettInfoVO/delvrFrtDocNo"/>
							</td>
							<th><arthtml:label key="Label_COM_01445"/><!--合同号-->：</th>
							<td>
								<arthtml:text maxlength="25" styleClass="input_cn_15em" property="data/BbNoticeLettInfoVO/contrNo"/>
							</td>
							<th><arthtml:label key="Label_COM_01275"/><!--发票号-->：</th>
							<td>
								<arthtml:text maxlength="25" styleClass="input_cn_15em" property="data/BbNoticeLettInfoVO/ivcNo"/>
							</td>
						</tr>
						<tr>
							<th><arthtml:label key="Label_823_10008"/><!--扣费金额-->：</th>
							<td>
							  <arthtml:currency id="chgCcy" property="data/BbNoticeLettInfoVO/chgCcy"  styleClass="input_en_3em" childId="chgAmt"/>
								<arthtml:currencyMoney id='chgAmt' styleClass="input_money_long t_right" property="data/BbNoticeLettInfoVO/chgAmt" precision="2" /> 	
							</td>
							<th><arthtml:label key="Label_823_10009"/><!--合同金额-->：</th>
							<td>
							   <arthtml:currency id="contrCcy" property="data/BbNoticeLettInfoVO/contrCcy"  styleClass="input_en_3em" childId="contrAmt"/>
								<arthtml:currencyMoney id='contrAmt' styleClass="input_money_long t_right" property="data/BbNoticeLettInfoVO/contrAmt" precision="2" /> 
							</td>
						</tr>
						<tr>
							<th><arthtml:label key="Label_COM_00798"/><!--Shipped On-->：</th>
							<td>
								<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BbNoticeLettInfoVO/shippedOn" showWeekDay="false"/>
							</td>
							<th><arthtml:label key="Label_COM_00797"/><!--Shipped From-->：</th>
							<td>
								<arthtml:text maxlength="25" styleClass="input_cn_15em" property="data/BbNoticeLettInfoVO/shippedFrom"/>
							</td>
							<th><arthtml:label key="Label_COM_00799"/><!--Shipped To-->：</th>
							<td>
								<arthtml:text maxlength="25" styleClass="input_cn_15em" property="data/BbNoticeLettInfoVO/shippedTo"/>
							</td>												
						</tr>
					</tbody>
				</table>	
				<fieldset  class="fieldset_border">
					<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_10010"/><!--Numer of Documents Attached 所附单据-->&nbsp;&nbsp;</legend>
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
							<th></th>
							<td></td>
							<th></th>
							<td></td>
							<th></th>
							<td></td>
							</tr>
						</tbody>
					</table>
					<div class="">
					<table cellpadding="0" cellspacing="0" border=0 class="ww_table">	
						
						<tbody>
							<tr class="ww_title">
								<th class="ww_outside_r">&nbsp;</th>
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00383"/><!--Draft--></th>
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00518"/><!--Inv.--></th>
								<th class="ww_outside_r">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_823_10011"/><!--B/L,AWB,C/R-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
								<th class="ww_outside_r" ><arthtml:label key="Label_COM_00482"/><!--Ins.Pol./Cert.--></th>
								<th class="ww_outside_r" ><arthtml:label key="Label_COM_00678"/><!--P/L--></th>
								<th class="ww_outside_r" ><arthtml:label key="Label_COM_00627"/><!--Origin--></th>
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00699"/><!--Quality--></th>
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00700"/><!--Quantity--></th>
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00614"/><!--Non-wood--></th>
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00483"/><!--Inspect--></th> 
								<th class="ww_outside_r"><arthtml:label key="Label_COM_00240"/><!--Cert.--></th>
								<th class="ww_outside_r"><arthtml:text style="width:102px" property="data/BbNoticeLettInfoVO/otherName1"/></th>
								<th class="ww_outside_r"><arthtml:text style="width:102px" property="data/BbNoticeLettInfoVO/otherName2"/></th>
								<th class="ww_outside_r"><arthtml:text style="width:102px" property="data/BbNoticeLettInfoVO/otherName3"/></th>
							</tr>
							<tr>
								<td >&nbsp;&nbsp;<arthtml:label key="Label_823_10012"/><%-- 1st --%>&nbsp;&nbsp;</td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/draft1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/inv1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/blAwbCr11"/><arthtml:label key="Label_823_10013"/><!--+--><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/blAwbCr21"/><arthtml:label key="Label_823_10014"/><!--NN--></td>
								<td ><arthtml:text styleClass="input_en_8em" property="data/BbNoticeLettInfoVO/inspolCert1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/pl1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/origin1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/quality1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/quantity1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/nonWood1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/inspect1st"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/cert1st"/></td>
								<td ><arthtml:text styleClass="input_en_10em" property="data/BbNoticeLettInfoVO/otherValue11st"/></td>
								<td ><arthtml:text styleClass="input_en_10em" property="data/BbNoticeLettInfoVO/otherValue21st"/></td>
								<td ><arthtml:text styleClass="input_en_10em" property="data/BbNoticeLettInfoVO/otherValue31st"/></td>																
							</tr>
							<tr>
								<td >&nbsp;&nbsp;<arthtml:label key="Label_823_10015"/><%-- 2nd --%>&nbsp;&nbsp;</td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/draft2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/inv2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/blAwbCr12"/><arthtml:label key="Label_823_10013"/><!--+--><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/blAwbCr22"/><arthtml:label key="Label_823_10014"/><!--NN--></td>
								<td ><arthtml:text styleClass="input_en_8em" property="data/BbNoticeLettInfoVO/inspolCert2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/pl2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/origin2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/quality2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/quantity2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/nonWood2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/inspect2nd"/></td>
								<td ><arthtml:text styleClass="input_en_6em" property="data/BbNoticeLettInfoVO/cert2nd"/></td>
								<td ><arthtml:text styleClass="input_en_10em" property="data/BbNoticeLettInfoVO/otherValue12nd"/></td>
								<td ><arthtml:text styleClass="input_en_10em" property="data/BbNoticeLettInfoVO/otherValue22nd"/></td>
								<td ><arthtml:text styleClass="input_en_10em" property="data/BbNoticeLettInfoVO/otherValue32nd"/></td>			
							</tr>
						</tbody>
					</table>
					</div>
					<br/>
				</fieldset>	
				<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
					<thead>
					</thead>
					<tfoot>
					</tfoot>
					<tbody>							
						<tr>
							<th><arthtml:label key="Label_823_10018"/><!--Remarks 备注-->：</th>
							<td colspan ="3"><arthtml:text styleClass="input_cn_30em" property="data/BbNoticeLettInfoVO/remarksRmrk" title="<b:write property='data/BbNoticeLettInfoVO/remarksRmrk'/>"/></td>
							<th></th>
							<td></td>
						</tr>
						<tr>
							<th rowspan="2"><arthtml:label key="Label_823_10019"/><!--不符点-->：</th>
							<td colspan="5">
								<arthtml:dynCheckbox property="data/BbNoticeLettInfoVO/lateShipmentFlg" id = "lateShipmentFlg" value="Y"/><label for = "lateShipmentFlg">&nbsp;<arthtml:label key="Label_COM_00540"/><!--Late Shipment 晚装船--></label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<arthtml:dynCheckbox property="data/BbNoticeLettInfoVO/latePresentationFlg" id = "latePresentationFlg" value="Y"/><label for = "latePresentationFlg">&nbsp;<arthtml:label key="Label_COM_00539"/><!--Late Presentation 晚交单--></label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<arthtml:dynCheckbox property="data/BbNoticeLettInfoVO/lcOverdueFlg" id = "lcOverdueFlg" value="Y"/><label for = "lcOverdueFlg">&nbsp;<arthtml:label key="Label_COM_00535"/><!--L/C Expired 信用证过有效期--></label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
								<arthtml:dynCheckbox property="data/BbNoticeLettInfoVO/overdrawnFlg" id = "overdrawnFlg" value="Y"/><label for = "overdrawnFlg">&nbsp;<arthtml:label key="Label_COM_00673"/><!--Overdrawn by 超金额-->&nbsp;&nbsp;</label>
								<arthtml:currency id="overdrawnAmtCcy" property="data/BbNoticeLettInfoVO/overdrawnAmtCcy" childId="overdrawnAmt"/>	
							    <arthtml:currencyMoney id="overdrawnAmt"  property="data/BbNoticeLettInfoVO/overdrawnAmt" precision="2" /> 										
							</td>
						</tr>
						<tr>
							<td colspan="5">
								<arthtml:dynCheckbox property="data/BbNoticeLettInfoVO/addDiscOther" id = "addDiscOther" value="Y"/><label for = "addDiscOther">&nbsp;<arthtml:label key="Label_COM_00154"/><!--Additional Discrepancies 其他-->：</label>
							</td>
						</tr>
						<tr>
							<th>&nbsp;</th>
							<td colspan="5">
								<arthtml:textarea style="width:812px;height:110px" property="data/BbNoticeLettInfoVO/other" title="<b:write property='data/BbNoticeLettInfoVO/other'/>"/>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="block_tabs_content hide" style="height: 600px; overflow: auto; margin-top: 0px;">
				<table width="1224px" style="margin:5px auto;">
					<tr>
						<td>
							<div class="account_title"></div>	
						</td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td class="account_item green_bg" width="606" height="424">
									</td>
									<td width="8" height="424">
									</td>
									<td class="account_item blue_bg" width="606" height="424">
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<div class="content_title" >
								<img src="../../../artframework/themes/default/images/ico/exchange.png" />
								&nbsp;Exchange 
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		<div>
				<table style="width: 100%;">
					<tr>
						<td id="btnControlBizLeft" style="float: left; margin-left: 10px;">
						</td>
						
						<td id="btnControlBizRight" style="float: right;">
						<a href="javascript:void(0)" id="saveSubmit" class="btn_gray"><span class = "icon3_baocuntijiao"></span>保存提交</a>&nbsp;
						</td>
						
						<td id="btnControlFramework" style="float: right;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</div>
	</body>
</html>

