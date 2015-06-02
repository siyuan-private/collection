<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/page/common/bizTagLib.inc"%>
<html>
	<head>
		<title>托收详情</title>
		<%@include file="/page/common/commonHeader.jsp"%>
		<%-- <h:script src="/artframework/js/util/art.util.currency.js"/> --%>
		<h:script src="/artframework/js/util/art.util.blackListValidate.js"/>
		<script charset="utf-8" src="<%=basePath%>/js/locale/Label823.<%=locale%>.js" type="text/javascript"></script>
		<h:script src="/page/collection/js/billOfCollectionDetail823002.js"/>
		<html:script logicPrefix="billOfCollectionDetail" srcParent="/page/collection/js" charset="UTF-8"/>
		<l:in property="data/LogicPageId" targetValue="823002001,823002002,823002003,823002004,823002008,823002009,823002010,823002011,823002012,823002013,823002014,823002015,823002016,823002017,823002018,823002019,823002020">
			<h:script charset="UTF-8" src="/page/feemanagement/js/feeManagementRegisterWithTransactionDetail806002.js"/>
		</l:in>
		<l:in property="data/LogicPageId" targetValue="823002001,823002002,823002003,823002004,823002012,823002013,823002014,823002015,823002016,823002017,823002018,823002019,823002020">
			<h:script charset="UTF-8" src="/page/pendingmanagement/js/unfinishedManagementRegisterwithtransactionDetail838003.js"/>
		</l:in>
	</head>
	<body style="overflow-x:hidden">
	    <div class="abs_popmsg"></div>
		<arthtml:hidden property="data/BcMntnOpDtlVO/smileDispchDocBankCode"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/smileKeepword2"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/smileTrasfAmt"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCode1"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCcy1"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgAmt1"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCode2"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCcy2"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgAmt2"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCode3"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCcy3"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgAmt3"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCode4"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCcy4"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgAmt4"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCode5"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgCcy5"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/chgAmt5"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/exMethod"/>
		<arthtml:hidden property="data/BcBookOpDtlVO/acctPropty2ndCd1"/>
		<arthtml:hidden property="data/BcBookOpDtlVO/acctPropty3rdCd1"/>
		<arthtml:hidden property="data/BcBookOpDtlVO/acctPropty2ndCd2"/>
		<arthtml:hidden property="data/BcBookOpDtlVO/acctPropty3rdCd2"/>
		
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfBeneCustNo"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfBcBookAcctSubjGl"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfBcBookAcctSubjSubGl"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfTxnPrmryRefNo"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfTxnSubRefNo"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfBxCcy"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/modDocBfBxAmt"/>
		
		<arthtml:hidden property="data/BcMntnOpDtlVO/tmpLcNo"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/tmpTrasfNo"/>
		
		<arthtml:hidden property="data/BcMntnOpDtlVO/ourBkNtcLc"/>
		<arthtml:hidden property="data/BcMntnOpDtlVO/pricingStatus"/>
		
		<arthtml:hidden id="genAccReqtype" /><%-- 记账  --%>
		<arthtml:hidden id="genAccValidateReqtype" />
		<arthtml:hidden id="genBopReqtype"/>
		
		<arthtml:hidden property="data/bizTypeNo" value="823-00"/> <!-- 业务类型编号 -->
		<arthtml:hidden id="commonReqtype" name="" value="Collection/CollCreate/detail"/>
		
			<div class="block_tabs_content detail_content">
				<div class="content_title block_title_nomargin" >
					<a id="basciControl" href="#" class="a_expand" index="0"></a>
					<span class="icon_jibenxinxi"></span><!--<img src="../../../images/ico/jibenxinxi.png" />-->
					&nbsp;<arthtml:label key="Label_823_00019"/><%--基本信息--%>
				</div>
				<div id="basciControlPanel" class="div_display expand_table">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th><arthtml:label key="Label_823_00003"/><%--交易参号--%>：</th>
								<td class="comparison">
									<arthtml:artuiBusiDealNumber id="dealNumber">	
									<arthtml:artuiBusiDealNumberTKND id="srcTkind" property="data/BcMntnOpDtlVO/tkind"/><arthtml:label key="Label_COM_00001"/><%-----%> 
									<arthtml:artuiBusiDealNumberMainParam id="srcPrmryRefNo" property="data/BcMntnOpDtlVO/txnPrmryRefNo"/><arthtml:label key="Label_COM_00001"/><%-----%>
									<arthtml:artuiBusiDealNumberSubParam id="srcSubRefNo" property="data/BcMntnOpDtlVO/txnSubRefNo"/>
								</arthtml:artuiBusiDealNumber>	
								</td>
								<th><arthtml:label key="Label_COM_01186"/><%--登记日--%>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" property="data/BcMntnOpDtlVO/regDate"/></td>
								<th></th>
								<td></td>
							</tr>
							<tr>
								<th><arthtml:label key="Label_COM_02263"/><%--预录入号--%>：</th>
								<td class="comparison"><arthtml:text maxlength="9" styleClass="input_num_10em" property="data/BcMntnOpDtlVO/preInputNo"/></td>
								<th><arthtml:label key="Label_COM_02262"/><%--预录入备注--%>：</th>
								<td class="comparison"><arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/preInputRmrk" title="<b:write property='data/BcMntnOpDtlVO/preInputRmrk'/>"/></td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02074"/><%--网银--%></span>：</th>
								<td class="comparison">
									<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/internetFlg"/>
									<div style="display:inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span class="compareSpan"><arthtml:label key="Label_COM_01665"/><%--跨境人民币--%></span>：
										<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/crsBorderRmbFlg"/>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="content_title" style="margin-top: 1px;">
					<a id="kaizhengControl" href="#" class="a_expand" index="1"></a>
					<span class="icon_xinjian"></span><!--<img src="../../../images/ico/xinjian.png" />-->
					&nbsp;<arthtml:label key="Label_COM_02134"/><%--新建--%>
				</div>
				<div id="kaizhengControlPanel" class="div_display expand_table">
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
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02158"/><%--信用证项下--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="lcFlg" property="data/BcMntnOpDtlVO/lcFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00220"/><%--BPO--%></span>：</th>
								<td class="comparison">
									<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/bpoFlg"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_COM_00872"/><%--TSU--%>：
									<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/tsuFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00675"/><%--P.P. NEGO--%></span>：</th>
								<td class="comparison"><arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/ppnegoFlg"/></td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01200"/><%--电报议付--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="telegNegoFlg" property="data/BcMntnOpDtlVO/telegNegoFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01201"/><%--电报议付销号日期--%></span>：</th>
								<td class="comparison">
									<arthtml:artuiDatetime styleClass="input_date" property="data/BcMntnOpDtlVO/telegNegoClsDate" showWeekDay="true"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00968"/><%--备注--%></span>：</th>
								<td class="comparison">
									<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/newRmrk" title="<b:write property='data/BcMntnOpDtlVO/newRmrk'/>"/>
								</td>											
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00004"/><%--受益人--%></span>：</th>
							    <td class="comparison">
							    <arthtml:custInfo functionType="CIF_REGIST,CIF_TO_LONG_ACC_REGIST" custCifId="beneCif" custNameId="beneName"  actCcyId="beneAcctCcy" actGlId="beneAcctGl" actSubGlId="beneAcctSubGl" actNoId="beneAcctNo" branchNoId="artCommonOrgCode">
										<arthtml:custCif id="beneCif" styleClass="input_num_8em" property="data/BcMntnOpDtlVO/beneCif"/>
										<arthtml:custName id="beneName" styleClass="input_cn_18em" property="data/BcMntnOpDtlVO/beneName"/>
									</arthtml:custInfo>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00022"/><%--受益人账户--%></span>：</th>
								<td class="comparison">
									<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST,LONG_ACCOUNT_REGIST" actCcyId="beneAcctCcy" actGlId="beneAcctGl" actSubGlId="beneAcctSubGl"
									   actNoId="beneAcctNo" custCifId="beneCif" custNameId="beneName" branchNoId="artCommonOrgCode" >
										<arthtml:actCcy id="beneAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/beneAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actGl id="beneAcctGl" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/beneAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actSubGl id="beneAcctSubGl" styleClass="input_cn_4em" property="data/BcMntnOpDtlVO/beneAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actNo id="beneAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/beneAcctNo"/>
									</arthtml:actInfo>
								</td>										
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01963"/><%--受益人为我行客户--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="beneOurCustFlg" property="data/BcMntnOpDtlVO/beneOurCustFlg"/>
								</td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00005"/><%--汇票金额--%></span>：</th>
								<td class="comparison">
									<arthtml:currency id="bxCcy" property="data/BcMntnOpDtlVO/bxCcy"  styleClass="input_en_3em" childId="bxAmt"/>
									<arthtml:currencyMoney id="bxAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bxAmt" precision="2" />
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00844"/><%--Tenor--%></span>：</th>
								<td class="comparison">
									<arthtml:dict id="tenorType" data="CA0179" styleClass="input_cn_8em select" property="data/BcMntnOpDtlVO/tenorType" name="data/BcMntnOpDtlVO/tenorType"/>&nbsp;&nbsp;
									<arthtml:text maxlength="3" styleClass="input_en_3em t_right" property="data/BcMntnOpDtlVO/tenorDays"/>&nbsp;<arthtml:label key="Label_823_00024"/><%--天--%>&nbsp;
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/tenorDate" showWeekDay="true"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01525"/><%--假远期--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="fakeForwdFlg" property="data/BcMntnOpDtlVO/fakeForwdFlg"/>
								</td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01274"/><%--发票编号--%></span>：</th>
								<td class="comparison">
									<arthtml:text maxlength="30" styleClass="input_num_20em" property="data/BcMntnOpDtlVO/ivcNo"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00961"/><%--保税区属性--%></span>：</th>
							    <td class="comparison">
									<arthtml:text maxlength="20" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/bondedAreaAttbt" title="<b:write property='data/BcMntnOpDtlVO/bondedAreaAttbt'/>"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00960"/><%--保税区--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="bondedAreaFlg" property="data/BcMntnOpDtlVO/bondedAreaFlg"/>
								</td>										
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02206"/><%--已签署GA/TFA--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="sigdGatfa" property="data/BcMntnOpDtlVO/sigdGatfa"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02066"/><%--托收日期--%></span>：</th>
								<td class="comparison">
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/collDate" showWeekDay="true"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01184"/><%--到期日期--%></span>：</th>
								<td class="comparison">
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/dueDate" showWeekDay="true"/>
								</td>										
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01993"/><%--提单日期--%></span>：</th>
								<td class="comparison">
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/blDate" showWeekDay="true"/>
								</td>									
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02403"/><%--最终到期日--%></span>：</th>
								<td class="comparison">
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/finalDueDate" showWeekDay="true"/>
								</td>
							</tr>
						</tbody>
					</table>
					<fieldset  class="fieldset_border" id="LcInfo">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00025"/><%--信用证信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02151"/><%--信用证编号--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="16" styleClass="input_cn_15em" property="data/BcMntnOpDtlVO/lcNo" id="lcNo"/>
										<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
											<a href="#" class="btn_gray" id="search1"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
										</arthtml:permission>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00026"/><%--信用证金额--%></span>：</th>
									<td class="comparison">
										<arthtml:currency id="lcAmtCcy" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmtCcy"  styleClass="input_en_3em" childId="expLcAmt"/>
										<arthtml:currencyMoney id="expLcAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcAmt" precision="2" />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00027"/><%--信用证余额--%></span>：</th>
									<td class="comparison">
										<arthtml:currency id="explcBalCcy" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcBalCcy"  styleClass="input_en_3em" childId="expLcBalAmt"/>
										<arthtml:currencyMoney id="expLcBalAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/lcBalAmt" precision="2" />
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01626"/><%--开证日期--%></span>：</th>
									<td class="comparison">
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueDate" showWeekDay="true"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01184"/><%--到期日期--%></span>：</th>
									<td class="comparison">
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dueDate" showWeekDay="true"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01193"/><%--第二受益人--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="bene2ndFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/bene2ndFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02339"/><%--中转行--%></span>：</th>
										<td class="comparison">
											<arthtml:text maxlength="60" styleClass="input_en_3em" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBank'/>"/>
										</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02340"/><%--中转行国别--%></span>：</th>
									<td class="comparison">
										<arthtml:district id="trastBankNatnlty" name="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trastBankNatnlty" countryProperty="trastBankNatnlty" level='1' />
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01588"/><%--进口商名称--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="60" styleClass="input_cn_25em" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrName'/>"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01587"/><%--进口商国别--%></span>：</th>
									<td class="comparison">
										<arthtml:district id="imptrNatnlty" name="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/imptrNatnlty" countryProperty="imptrNatnlty" level='1' />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="osaNraFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/osaNraFlg"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01521"/><%--寄单行同开证行--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="dispchBankEqIssueFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02238"/><%--有偿付行--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="withReimbsBankFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/withReimbsBankFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02282"/><%--允许电报偿付--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="allowTelegReimbsFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/allowTelegReimbsFlg"/>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part comparison">
							<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left">
								<tbody>
									<tr>
										<th></th>
										<th><arthtml:label key="Label_COM_01420"/><%--行号--%></th>
										<th><arthtml:label key="Label_COM_00839"/><%--Swift--%></th>
										<th><arthtml:label key="Label_COM_01720"/><%--名称--%></th>
										<th><arthtml:label key="Label_COM_01191"/><%--地址--%></th>
									</tr>
									<tr>
										<td><arthtml:label key="Label_823_00028"/><%--开证行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_01420"/><%--开证行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="issueBankCode" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_00839"/><%--开证行Swift--%></span>												
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="issueBankSwift" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_01720"/><%--开证行名称--%></span>			
											<arthtml:text maxlength="26" styleClass="input_cn_30em" id="issueBankName" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankName"/>													
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_01191"/><%--开证行地址--%></span>			
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="issueBankAddr" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/issueBankAddr'/>"/>
										</td>
									</tr>
									<tr>
										<td><arthtml:label key="Label_823_00012"/><%--寄单行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01420"/><%--寄单行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="lcDispchDocBankCode" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_00839"/><%--寄单行Swift--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="lcDispchDocBankSwift" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01720"/><%--寄单行名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="lcDispchDocBankName" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01191"/><%--寄单行地址--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="lcDispchDocBankAddr" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/dispchDocBankAddr'/>"/>
										</td>
									</tr>
									<tr>
										<td><arthtml:label key="Label_823_00030"/><%--偿付行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_01420"/><%--偿付行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="reimbBankCode" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_00839"/><%--偿付行Swift--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="reimbBankSwift" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_01720"/><%--偿付行名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="reimbBankName" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_01191"/><%--偿付行地址--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="reimbBankAddr" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/reimbBankAddr'/>"/>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br/>
						<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02094"/><%--我行保兑--%></span>：</th>
									<td class="comparison">
										<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankConfmdFlg"/>&nbsp;&nbsp;
										<arthtml:artuiBusiDealNumber id="1dealNumber">
										<arthtml:artuiBusiDealNumberTKND property="data/BcMntnOpDtlVO/confmdTKind" /><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:artuiBusiDealNumberMainParam property="data/BcMntnOpDtlVO/confmdPrmryRefNo"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:artuiBusiDealNumberSubParam property="data/BcMntnOpDtlVO/confmdSubRefNo"/>
										</arthtml:artuiBusiDealNumber>
									</td>
								 	<th><span class="compareSpan"><arthtml:label key="Label_COM_01704"/><%--履行保兑责任--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="perfmConfmDuties" property="data/BcMntnOpDtlVO/perfmConfmDuties"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00947"/><%--保兑备注--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/confmdRmrk" title="<b:write property='data/BcMntnOpDtlVO/confmdRmrk'/>"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02096"/><%--我行承兑--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="ourBankAccptceFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/ourBankAccptceFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02362"/><%--转让信用证--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="trasfLcFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/trasfLcFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01698"/><%--留行信用证--%></span>：</th>
									<td class="comparison">
										<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcFlg"/>&nbsp;&nbsp;&nbsp;
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/kibLcDate" showWeekDay="true"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01593"/><%--警报国家--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0285" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/alertCountry"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01129"/><%--代理行--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="agcBankFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/agcBankFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01404"/><%--国内信用证--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="domstcLcFlg" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/domstcLcFlg"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00305"/><%--Combined LC--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="combinedLcFlg" property="data/BcMntnOpDtlVO/combinedLcFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01771"/><%--其他事项--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/expLcMntnOpDtlVO/otherItem" title="<b:write property='data/BcMntnOpDtlVO/expLcMntnOpDtlVO/otherItem'/>"/>
									</td>
									<th></th>
									<td></td>
								</tr>
							</tbody>	
						</table>
						<div class="layout_2part comparison" id="bbCombLcNo" >
							<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left">
								<thead>
									<tr class="ww_title">
										<th>No</th>
										<th colspan="2"><arthtml:label key="Label_COM_02151"/><%--信用证编号--%></th>
										<th><arthtml:label key="Label_823_00026"/><%--信用证金额--%></th>
										<th><arthtml:label key="Label_823_00032"/><%--drawn amount--%></th>
										<th><arthtml:label key="Label_823_00027"/><%--信用证余额--%></th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>  
 									<tr>
										<td>&nbsp;&nbsp;1&nbsp;&nbsp;</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcNo"/>
										</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
										<td>
											<arthtml:currency id="lcCcy1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcCcy"  styleClass="input_en_3em" childId="lcAmt1"/>
											<arthtml:currencyMoney id="lcAmt1" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt1"/>
											<arthtml:currencyMoney id="drawnAmt1" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt1"/>
											<arthtml:currencyMoney id="lcBalAmt1" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcBalAmt" precision="2" />
										</td>
										<td></td>
									</tr>
									<tr>
										<td>2</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch2"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcCcy"  styleClass="input_en_3em" childId="lcAmt2"/>
											<arthtml:currencyMoney id="lcAmt2" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt2"/>
											<arthtml:currencyMoney id="drawnAmt2" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt2"/>
											<arthtml:currencyMoney id="lcBalAmt2" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel2"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
									<tr>
									<td>3</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch3"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcCcy"  styleClass="input_en_3em" childId="lcAmt3"/>
											<arthtml:currencyMoney id="lcAmt3" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt3"/>
											<arthtml:currencyMoney id="drawnAmt3" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt3"/>
											<arthtml:currencyMoney id="lcBalAmt3" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel3"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
									<tr>
										<td>4</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch4"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcCcy"  styleClass="input_en_3em" childId="lcAmt4"/>
											<arthtml:currencyMoney id="lcAmt4" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt4"/>
											<arthtml:currencyMoney id="drawnAmt4" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt4"/>
											<arthtml:currencyMoney id="lcBalAmt4" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel4"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
									<tr>
										<td>5</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch5"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcCcy"  styleClass="input_en_3em" childId="lcAmt5"/>
											<arthtml:currencyMoney id="lcAmt5" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt5"/>
											<arthtml:currencyMoney id="drawnAmt5" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt5"/>
											<arthtml:currencyMoney id="lcBalAmt5" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel5"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0" id="transTable">
							<tbody>	
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02359"/><%--转让第二受益人--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="trasf2ndBene" property="data/BcMntnOpDtlVO/trasf2ndBene"/>
									</td>
									<th></th>
									<td>
									</td>
									<th></th>
									<td>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part block_content_table_long comparison" id="trasfTable">
							<table class="ww_table _left" width="1400px">
								<tbody>
									<tr>
										<th><arthtml:label key="Label_823_00034"/><%--转让编号--%></th>
										<th><arthtml:label key="Label_823_00035"/><%--第一受益人账户--%></th>
										<th><arthtml:label key="Label_823_00036"/><%--转让金额--%></th>
										<th><arthtml:label key="Label_COM_01198"/><%--第一受益人承担--%></th>
										<th><arthtml:label key="Label_COM_01194"/><%--第二受益人名称--%></th>
										<th><arthtml:label key="Label_823_00037"/><%--第二受益人银行国别--%></th>												
										<th>&nbsp;&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%>&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th><arthtml:label key="Label_COM_01195"/><%--第二受益人通知行--%></th>
									</tr>
									<tr>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00034"/><%--转让编号--%></span>
										 	<arthtml:artuiBusiDealNumber id="trasfTKindNumber"> 
												<arthtml:artuiBusiDealNumberTKND property="data/BcMntnOpDtlVO/trasfTKind"/><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:artuiBusiDealNumberMainParam property="data/BcMntnOpDtlVO/trasfNoPrmryRefNo"/><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:artuiBusiDealNumberSubParam property="data/BcMntnOpDtlVO/trasfNoSubRefNo"/>
											</arthtml:artuiBusiDealNumber>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="btn_scan"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00035"/><%--第一受益人账户--%></span>
											<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bene1stAcctCcy" actGlId="bene1stAcctGl" actSubGlId="bene1stAcctSubGl" actNoId="bene1stAcctNo" branchNoId="artCommonOrgCode">
												<arthtml:actCcy id="bene1stAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/bene1stAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:actGl id="bene1stAcctGl" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/bene1stAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:actSubGl id="bene1stAcctSubGl" styleClass="input_cn_4em" property="data/BcMntnOpDtlVO/bene1stAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:actNo id="bene1stAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/bene1stAcctNo"/>
											</arthtml:actInfo>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00036"/><%--转让金额--%></span>
												<arthtml:currency id="trasfAmtCcy" property="data/BcMntnOpDtlVO/trasfAmtCcy"  styleClass="input_en_3em" childId="trasfAmt"/>
												<arthtml:currencyMoney id="trasfAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/trasfAmt" precision="2" />
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_01198"/><%--第一受益人承担--%></span>
											<dict:radioGroup dictTypeId="CA0435" id="undtk1stBeneFlg" property="data/BcMntnOpDtlVO/undtk1stBeneFlg"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_01194"/><%--第二受益人名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_14em" property="data/BcMntnOpDtlVO/bene2ndName" title="<b:write property='data/BcMntnOpDtlVO/bene2ndName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00037"/><%--第二受益人银行国别--%></span>
											<arthtml:district id='bene2ndNatnlty' name='data/BcMntnOpDtlVO/bene2ndNatnlty' countryProperty='bene2ndNatnlty'
												 provinceProperty='bene2ndProv' cityProperty='bene2ndCity' level='3' />
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%></span>
											<dict:radioGroup dictTypeId="CA0435" id="trasfOsaNraFlg" property="data/BcMntnOpDtlVO/trasfOsaNraFlg"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_01195"/><%--第二受益人通知行--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_5em" property="data/BcMntnOpDtlVO/bene2ndNoticeBankSwiftCode"/>
											<arthtml:text maxlength="60" styleClass="input_cn_10em" property="data/BcMntnOpDtlVO/bene2ndNoticeBankName" title="<b:write property='data/BcMntnOpDtlVO/bene2ndNoticeBankName'/>"/>
										</td>
									</tr>										
								</tbody>
							</table>
						</div>
						<br/>
					</fieldset>
					
					<fieldset  class="fieldset_border" id="nonLcInfo">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00038"/><%--非信用证信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01588"/><%--进口商名称--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="60" styleClass="input_cn_25em" property="data/BcMntnOpDtlVO/imptrName" title="<b:write property='data/BcMntnOpDtlVO/imptrName'/>"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01587"/><%--进口商国别--%></span>：</th>
									<td class="comparison">
										<arthtml:district id="bcimptrNatnlty" name="data/BcMntnOpDtlVO/imptrNatnlty" countryProperty="imptrNatnlty" level='1' />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="osaNraFlg" property="data/BcMntnOpDtlVO/osaNraFlg"/>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part comparison">
							<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left">
								<tbody>
									<tr>
										<th></th>
										<th><arthtml:label key="Label_COM_01420"/><%--行号--%></th>
										<th><arthtml:label key="Label_COM_00839"/><%--Swift--%></th>
										<th><arthtml:label key="Label_COM_01720"/><%--名称--%></th>
										<th><arthtml:label key="Label_COM_01191"/><%--地址--%></th>
									</tr>											
									<tr>
										<td><arthtml:label key="Label_823_00012"/><%--寄单行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01420"/><%--寄单行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="notLcDispchDocBankCode" property="data/BcMntnOpDtlVO/dispchDocBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_00839"/><%--寄单行行号Swift--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="notLcDispchDocBankSwift" property="data/BcMntnOpDtlVO/dispchDocBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01720"/><%--寄单行行号名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="notLcDispchDocBankName" property="data/BcMntnOpDtlVO/dispchDocBankName" title="<b:write property='data/BcMntnOpDtlVO/dispchDocBankName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01191"/><%--寄单行行号地址--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="notLcDispchDocBankAddr" property="data/BcMntnOpDtlVO/dispchDocBankAddr" title="<b:write property='data/BcMntnOpDtlVO/dispchDocBankAddr'/>"/>
										</td>
									</tr>											
								</tbody>
							</table>
						</div>
						<br/>
						<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
							<tr>												
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01593"/><%--警报国家--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0285" property="data/BcMntnOpDtlVO/alertCountry"/>
								</td>											
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01129"/><%--代理行--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="agcBankFlg" property="data/BcMntnOpDtlVO/agcBankFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01771"/><%--其他事项--%></span>：</th>
								<td class="comparison">
									<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/otherItem" title="<b:write property='data/BcMntnOpDtlVO/otherItem'/>"/>
								</td>
					 		</tr>
						</table>
					</fieldset>

					<fieldset  class="fieldset_border">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00040"/><%--单据信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01274"/><%--发票编号--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="16" styleClass="input_cn_15em" property="data/BcMntnOpDtlVO/docIvcNo"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01351"/><%--跟单票/光票--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0077" property="data/BcMntnOpDtlVO/docClean"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01527"/><%--交货方式--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0268" property="data/BcMntnOpDtlVO/delvrMeth"/>
									</td>											
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02243"/><%--有追索权--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0435" id="withRcsFlg" property="data/BcMntnOpDtlVO/withRcsFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00278"/><%--CHQ Kind--%></span>：</th>
									<td class="comparison">
										<arthtml:dict id="chqKind" data="CA0061" styleClass="input_cn_15em select" property="data/BcMntnOpDtlVO/chqKind" name="data/BcMntnOpDtlVO/chqKind"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01604"/><%--拒绝证明--%></span>：</th>
									<td class="comparison">	
										<arthtml:dict id="refuseCertfct" data="CA0288" styleClass="input_cn_20em select" property="data/BcMntnOpDtlVO/refuseCertfct" name="data/BcMntnOpDtlVO/refuseCertfct"/>
									</td>																						
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01785"/><%--清算行信息--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="2" styleClass="input_num_2em" property="data/BcMntnOpDtlVO/clrBankInfo"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00041"/><%--清算行账户--%></span>：</th>
									<td class="comparison">
										<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bcMntnOpDtlVOclrBankAcctCcy" actGlId="bcMntnOpDtlVOclrBankAcctGL" actSubGlId="bcMntnOpDtlVOclrBankAcctSubGL" actNoId="bcMntnOpDtlVOclrBankAcctNo" branchNoId="artCommonOrgCode">
											<arthtml:actCcy id="bcMntnOpDtlVOclrBankAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/clrBankAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="bcMntnOpDtlVOclrBankAcctGL" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/clrBankAcctGL"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="bcMntnOpDtlVOclrBankAcctSubGL" styleClass="input_cn_4em" property="data/BcMntnOpDtlVO/clrBankAcctSubGL"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="bcMntnOpDtlVOclrBankAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/clrBankAcctNo"/>
										</arthtml:actInfo>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00042"/><%--BC记账科目--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="3" styleClass="input_num_3em" property="data/BcMntnOpDtlVO/bcBookAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:text maxlength="4" styleClass="input_num_4em" property="data/BcMntnOpDtlVO/bcBookAcctSubGl"/>
									</td>											
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01399"/><%--国别--%></span>：</th>
									<td class="comparison">
										<arthtml:district id="natnlty" name="data/BcMntnOpDtlVO/natnlty" countryProperty="natnlty" level='1' />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01837"/><%--商品--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="5" styleClass="input_cn_4em" property="data/BcMntnOpDtlVO/goods"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01741"/><%--目的--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="5" styleClass="input_cn_4em" property="data/BcMntnOpDtlVO/purpose"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00968"/><%--备注--%></span>：</th>
									<td colspan="3" class="comparison">
										<arthtml:text maxlength="8" styleClass="input_cn_8em" property="data/BcMntnOpDtlVO/docRmrk1"/>&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="8" styleClass="input_cn_8em" property="data/BcMntnOpDtlVO/docRmrk2"/>&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="26" styleClass="input_cn_20em" property="data/BcMntnOpDtlVO/docRmrk3"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00043"/><%--WSID--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="2" styleClass="input_num_2em" property="data/BcMntnOpDtlVO/bcMntnWsid1"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:text maxlength="5" styleClass="input_num_5em" property="data/BcMntnOpDtlVO/bcMntnWsid2"/>
									</td>
								</tr>										
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00928"/><%--WSID日期--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="8" styleClass="input_date_readonly" property="data/BcMntnOpDtlVO/bcMntnWsidDate"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01598"/><%--拒付编号--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="15" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/dishnrHistInfoVO/dishnrNo"/>&nbsp;&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="8" styleClass="input_date_readonly" property="data/BcMntnOpDtlVO/dishnrHistInfoVO/regDate"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01368"/><%--故障编号--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="15" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/faultHistInfoVO/faultNo"/>&nbsp;&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="8" styleClass="input_date_readonly" property="data/BcMntnOpDtlVO/faultHistInfoVO/regDate"/>
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<fieldset  class="fieldset_border">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00044"/><%--费用信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01946"/><%--手续费支付方--%></span>：</th>
									<td class="comparison">
										<dict:radioGroup dictTypeId="CA0329" property="data/BcMntnOpDtlVO/feePayer"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00045"/><%--手续费账户--%></span>：</th>
									<td class="comparison">
										<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bcInfoVOfeeAcctCcy" actGlId="bcInfoVOfeeAcctGL" actSubGlId="bcInfoVOfeeAcctSubGL" actNoId="bcInfoVOfeeAcctNo" branchNoId="artCommonOrgCode">
											<arthtml:actCcy id="bcInfoVOfeeAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/feeAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="bcInfoVOfeeAcctGL" styleClass="input_cn_3em" property="data/BcMntnOpDtlVO/feeAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="bcInfoVOfeeAcctSubGL" styleClass="input_cn_4em" property="data/BcMntnOpDtlVO/feeAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="bcInfoVOfeeAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/feeAcctNo"/>
										</arthtml:actInfo>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00590"/><%--N/W区分--%></span>：</th>
									<td class="comparison">
										<arthtml:text maxlength="1" styleClass="input_num_6em" property="data/BcMntnOpDtlVO/noWfDist"/>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part compareSpan">
							<table  class="ww_table _left " width="800">
								<tbody>
									<tr>
										<th>&nbsp;</th>
										<th><arthtml:label key="Label_COM_00401"/><%--EX.Method--%></th>
										<th><arthtml:label key="Label_COM_00702"/><%--Quote--%></th>
										<th><arthtml:label key="Label_823_00046"/><%--Cont.No.--%></th>
										<th><arthtml:label key="Label_COM_00706"/><%--Rate--%></th>
										<th><arthtml:label key="Label_COM_00554"/><%--M/D--%></th>
									</tr>
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_COM_01933"/><%--手续费--%>&nbsp;&nbsp;&nbsp;
										</td>												
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00401"/><%--EX.Method--%></span>
											<arthtml:dict id="feeExMethod" data="CA0079" styleClass="select" property="data/BcMntnOpDtlVO/feeExMethod" name="data/BcMntnOpDtlVO/feeExMethod"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00702"/><%--Quote--%></span>
											<arthtml:dict id="quote" data="CA0129" styleClass="select" property="data/BcMntnOpDtlVO/quote" name="data/BcMntnOpDtlVO/quote"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00046"/><%--Cont.No.--%></span>
											<arthtml:text maxlength="6" styleClass="input_cn_6em" property="data/BcMntnOpDtlVO/contNo1"/>
											<arthtml:text maxlength="2" styleClass="input_cn_2em" property="data/BcMntnOpDtlVO/contNo2"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00706"/><%--Rate--%></span>
											<arthtml:text maxlength="13" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/rate"/><arthtml:label key="Label_823_00047"/><%--%--%>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00554"/><%--M/D--%></span>
											<arthtml:dict id="md" data="CA0113" styleClass="select" property="data/BcMntnOpDtlVO/md" name="data/BcMntnOpDtlVO/md"/>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br/>
					</fieldset>							
				</div>
				<div class="content_title" style="margin-top: 1px;">
					<a id="chengduiControl" href="#" class="a_expand" index="2"></a>
					<span class="icon_chengdui"></span><!--<img src="../../../images/ico/chengdui.png" />-->
					&nbsp;<arthtml:label key="Label_823_00048"/><%--承兑--%>
				</div>
				<div id="chengduiControlPanel" class="div_display expand_table">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01055"/><%--承兑登记日--%></span>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcAccptceOpDtlVO/accptceRegDate" showWeekDay="true"/></td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01052"/><%--承兑到期日--%></span>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcAccptceOpDtlVO/accptceDueDate" showWeekDay="true"/></td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02279"/><%--远期索偿日--%></span>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcAccptceOpDtlVO/forwdClmRmbrsmtDate" showWeekDay="true"/></td>
							</tr>
							<tr>										
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01441"/><%--合理--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="resnblFlg" property="data/BcAccptceOpDtlVO/resnblFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00146"/><%--Accepted Flag--%></span>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0435" id="acceptedFlg" property="data/BcAccptceOpDtlVO/acceptedFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00043"/><%--WSID--%></span>：</th>
								<td class="comparison">
									<arthtml:text maxlength="2" styleClass="input_num_2em" property="data/BcAccptceOpDtlVO/bcAccptceWsid1"/><arthtml:label key="Label_COM_00001"/><%-----%>
									<arthtml:text maxlength="5" styleClass="input_num_5em" property="data/BcAccptceOpDtlVO/bcAccptceWsid2"/>
								</td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00928"/><%--WSID日期--%></span>：</th>
								<td class="comparison">
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" property="data/BcAccptceOpDtlVO/bcAccptceWsidDate"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01051"/><%--承兑备注--%></span>：</th>
								<td colspan="3" class="comparison"><arthtml:text maxlength="40" styleClass="input_cn_50em" property="data/BcAccptceOpDtlVO/accptceRmrk" title="<b:write property='data/BcAccptceOpDtlVO/accptceRmrk'/>"/></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="content_title" style="margin-top: 1px;">
					<table width="100%">
						<tr>
							<td>
								<a id="tuigaidanControl" href="#" class="a_expand" index="3"></a>
								<span class="icon_tuigaidan"></span>&nbsp;<arthtml:label key="Label_COM_02048"/><%--退改单--%>
							</td>
							<td align="right">
								<arthtml:permission resourceId="82300002000004" bizDefId="823-00">
									<a href="javascript:void(0)" class="btn_gray" id="compareButton">
										<span class="icon3_bidui"></span><arthtml:label key="Link_823_00009"/><%--比对--%>
					      	</a>
					      </arthtml:permission>
					      <arthtml:permission resourceId="82300002000005" bizDefId="823-00">
									<a href="javascript:void(0)" class="btn_gray artui-btnwin" 
						       url="billOfCollectionPopupChgHis823005.jsp"
						       w="980" h="200" text="修改履历" dialog="true" id="modHistButton">
										<span class="icon3_xiugailvli"></span><arthtml:label key="Link_823_00010"/><%--修改履历--%>
									</a>
								</arthtml:permission>
							</td>
						</tr>
					</table>
				</div>
				<div id="tuigaidanControlPanel" class="div_display expand_table">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th></th>
								<td class="comparison">
									<dict:radioGroup id="bbMaintType" dictTypeId="CA0354" property="data/BbModChgbkDocInfoVO/bbMaintType"/>
								</td>
								<th><arthtml:label key="Label_COM_01186"/><%--登记日--%>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date art_detail_tally" id="modChgbkDocRegDate" property="data/BbModChgbkDocInfoVO/regDate"  showWeekDay="true"/></td>
								<th><arthtml:label key="Label_COM_02274"/><%--原因--%>：</th>
								<td class="comparison"><arthtml:text maxlength="40" styleClass="input_cn_20em" id="resn" property="data/BbModChgbkDocInfoVO/resn" title="<b:write property='data/BbModChgbkDocInfoVO/resn'/>"/></td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00968"/><%--备注--%></span>：</th>
								<td colspan="3" class="comparison"><arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BbModChgbkDocInfoVO/modChgbkDocRmrk" title="<b:write property='data/BbModChgbkDocInfoVO/modChgbkDocRmrk'/>"/></td>
								<th><arthtml:label key="Label_823_00043"/><%--WSID--%>：</th>
							<td class="comparison">
								<arthtml:text maxlength="2" styleClass="input_cn_2em" id="modChgbkDocWsid1" property="data/BbModChgbkDocInfoVO/modChgbkDocWsid1"/><arthtml:label key="Label_COM_00001"/><%-----%>											
								<arthtml:text maxlength="5" styleClass="input_cn_5em" id="modChgbkDocWsid2" property="data/BbModChgbkDocInfoVO/modChgbkDocWsid2"/>
							</td>	
							<th><arthtml:label key="Label_COM_00928"/><%--WSID日期--%>：</th>
							<td class="comparison">
								<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" id="modChgbkDocWsidDate" property="data/BbModChgbkDocInfoVO/modChgbkDocWsidDate"/>										                                                     
							</td>
							</tr>
						</tbody>
					</table>

				<div class="layout_2part comparison">
					<table id="mosHist"  border="0" class="ww_table _left artui-datagrid">
						<thead>
							<tr class="ww_title">
								<th class="ww_outside_r" width="33.31px">No</th>
								<th class="ww_outside_r" width="128px"><arthtml:label key="Label_COM_02121"/><%--项目名称--%></th>
								<th class="ww_outside_r" width="368px"><arthtml:label key="Label_COM_02175"/><%--修改前--%></th>
								<th class="ww_outside_r" width="608px"><arthtml:label key="Label_COM_02171"/><%--修改后--%></th>
							</tr>
						</thead>
						<tbody>
							<tr style="display:none">
								<td></td>
								<td>
									<arthtml:text maxlength="20" property="data/BbModChgbkDocInfoVO/modHisDtlVOList[0]/modfctnItemName" title="<b:write property='data/BbModChgbkDocInfoVO/modHisDtlVOList[0]/modfctnItemName'/>"/>
								</td>
								<td>
									<arthtml:text maxlength="60" property="data/BbModChgbkDocInfoVO/modHisDtlVOList[0]/bfChagContnt" title="<b:write property='data/BbModChgbkDocInfoVO/modHisDtlVOList[0]/bfChagContnt'/>"/>
								</td>
								<td>
									<arthtml:text maxlength="60" property="data/BbModChgbkDocInfoVO/modHisDtlVOList[0]/modfdContnt" title="<b:write property='data/BbModChgbkDocInfoVO/modHisDtlVOList[0]/modfdContnt'/>"/>
								</td>
							</tr>
							<l:empty property="data/BbModChgbkDocInfoVO/modHisDtlVOList">
        			</l:empty>
							<l:notEmpty property="data/BbModChgbkDocInfoVO/modHisDtlVOList">
         				<l:iterate id="ModHisDtlVO" property="data/BbModChgbkDocInfoVO/modHisDtlVOList" indexId="ind">
									<tr class="td_data_list">
										<td></td>
										<td>
											<arthtml:text maxlength="20" property="data/BbModChgbkDocInfoVO/modHisDtlVOList[${ind}]/modfctnItemName" title="<b:write property='data/BbModChgbkDocInfoVO/modHisDtlVOList[${ind}]/modfctnItemName'/>"/>
										</td>
										<td>
											<arthtml:text maxlength="60" property="data/BbModChgbkDocInfoVO/modHisDtlVOList[${ind}]/bfChagContnt" title="<b:write property='data/BbModChgbkDocInfoVO/modHisDtlVOList[${ind}]/bfChagContnt'/>"/>
										</td>
										<td>
											<arthtml:text maxlength="60" property="data/BbModChgbkDocInfoVO/modHisDtlVOList[${ind}]/modfdContnt" title="<b:write property='data/BbModChgbkDocInfoVO/modHisDtlVOList[${ind}]/modfdContnt'/>"/>
										</td>
									</tr>
	       				</l:iterate>
							</l:notEmpty>
						</tbody>
					</table>
				</div>
			</div>
				<div class="content_title" style="margin-top: 1px;">
					<a id="xiugaiControl" href="#" class="a_expand" index="4"></a>
					<span class="icon_ruzhang"></span><!--<img src="../../../images/ico/ruzhang.png" />-->
					&nbsp;<arthtml:label key="Label_COM_01825"/><%--入账--%>
				</div>
				<div id="xiugaiControlPanel" class="div_display expand_table">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th><arthtml:label key="Label_COM_01314"/><%--福费廷--%>：</th>
								<td class="comparison"><arthtml:dynCheckbox value="Y" styleClass="art_detail_tally" property="data/BcBookOpDtlVO/forftingFlg"/></td>
								<th><arthtml:label key="Label_COM_02044"/><%--头寸日--%>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date art_detail_tally" property="data/BcBookOpDtlVO/posDate" showWeekDay="true"/></td>
								<th><arthtml:label key="Label_823_00013"/><%--头寸金额--%>：</th>
								<td class="comparison">
									<arthtml:currency id="posCcy" property="data/BcBookOpDtlVO/posCcy"  styleClass="input_en_3em art_detail_tally" childId="posAmt"/>
									<arthtml:currencyMoney id="posAmt" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/posAmt" precision="2" />
								</td>																		
							</tr>
							<tr>
								<th><arthtml:label key="Label_COM_02097"/><%--我行对客入账日--%>：</th>
								<td class="comparison"><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date art_detail_tally" property="data/BcBookOpDtlVO/ourBankToCustBookingDate" showWeekDay="true"/></td>		
								<th><arthtml:label key="Label_823_00052"/><%--待核查账户--%>：</th>
								<td class="comparison">
									<arthtml:dynCheckbox value="Y" property="data/BcBookOpDtlVO/validatnFlg"/>&nbsp;&nbsp;
									<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="validatnAcctCcy" actGlId="validatnAcctGl" actSubGlId="validatnAcctSubGl" actNoId="validatnAcctNo" branchNoId="artCommonOrgCode">
										<arthtml:actCcy id="validatnAcctCcy" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/validatnAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actGl id="validatnAcctGl" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/validatnAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actSubGl id="validatnAcctSubGl" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/validatnAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actNo id="validatnAcctNo" styleClass="input_cn_6em art_detail_tally" property="data/BcBookOpDtlVO/validatnAcctNo"/>
									</arthtml:actInfo>
								</td>
								<th><arthtml:label key="Label_COM_01634"/><%--客户等级--%>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0289" styleClass="art_detail_tally" property="data/BcBookOpDtlVO/custLv"/>
								</td>									
							</tr>
							<tr>
								<th><arthtml:label key="Label_823_00041"/><%--清算行账户--%>：</th>
								<td class="comparison">
									<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bcBookOpDtlVOclrBankAcctCcy" actGlId="bcBookOpDtlVOclrBankAcctGl" actSubGlId="bcBookOpDtlVOclrBankAcctSubGl" actNoId="bcBookOpDtlVOclrBankAcctNo" branchNoId="artCommonOrgCode">
										<arthtml:actCcy id="bcBookOpDtlVOclrBankAcctCcy" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/clrBankAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actGl id="bcBookOpDtlVOclrBankAcctGl" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/clrBankAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actSubGl id="bcBookOpDtlVOclrBankAcctSubGl" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/clrBankAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actNo id="bcBookOpDtlVOclrBankAcctNo" styleClass="input_cn_6em art_detail_tally" property="data/BcBookOpDtlVO/clrBankAcctNo"/>
									</arthtml:actInfo>
								</td>
								<th><arthtml:label key="Label_COM_01340"/><%--付款银行编号--%>：</th>
								<td class="comparison"><arthtml:text maxlength="16" styleClass="input_cn_15em art_detail_tally" property="data/BcBookOpDtlVO/pymtBankNo"/></td>
								<th><arthtml:label key="Label_823_00014"/><%--他行扣款金额--%>：</th>
								<td class="comparison">
									<arthtml:currency id="theirDedctCcy" property="data/BcBookOpDtlVO/theirDedctCcy"  styleClass="input_en_3em art_detail_tally" childId="theirDedctAmt"/>
									<arthtml:currencyMoney id="theirDedctAmt" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/theirDedctAmt" precision="2" />
								</td>																				
							</tr>
							<tr>
								<th><arthtml:label key="Label_COM_00755"/><%--Remarks--%>：</th>
								<td class="comparison"><arthtml:text maxlength="26" styleClass="input_cn_15em art_detail_tally" property="data/BcBookOpDtlVO/rmrk"/></td>
								<th><arthtml:label key="Label_COM_01946"/><%--手续费支付方--%>：</th>
								<td class="comparison">
									<dict:radioGroup dictTypeId="CA0329" styleClass="art_detail_tally" property="data/BcBookOpDtlVO/feePayer"/>
								</td>
								<th><arthtml:label key="Label_823_00045"/><%--手续费账户--%>：</th>
								<td class="comparison">	
									<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bcBookOpDtlVOfeeAcctCcy" actGlId="bcBookOpDtlVOfeeAcctGL" actSubGlId="bcBookOpDtlVOfeeAcctSubGL" actNoId="bcBookOpDtlVOfeeAcctNo" branchNoId="artCommonOrgCode">							
										<arthtml:actCcy id="bcBookOpDtlVOfeeAcctCcy" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/feeAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actGl id="bcBookOpDtlVOfeeAcctGL" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/feeAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actSubGl id="bcBookOpDtlVOfeeAcctSubGL" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/feeAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actNo id="bcBookOpDtlVOfeeAcctNo" styleClass="input_cn_6em art_detail_tally" property="data/BcBookOpDtlVO/feeAcctNo"/>
									</arthtml:actInfo>
								</td>										
							</tr>
							<tr>
								<th><arthtml:label key="Label_COM_00590"/><%--N/W区分--%>：</th>
								<td class="comparison"><arthtml:text maxlength="1" styleClass="input_num_6em art_detail_tally" property="data/BcBookOpDtlVO/noWfDist"/>
								</td>
								<th><arthtml:label key="Label_COM_01821"/><%--入两个账户--%>：</th>
								<td class="comparison"><arthtml:dynCheckbox value="Y" styleClass="art_detail_tally" property="data/BcBookOpDtlVO/enter2AcctFlg"/></td>
								<th><arthtml:label key="Label_COM_01826"/><%--入账备注--%>：</th>
								<td colspan="3" class="comparison"><arthtml:text maxlength="40" styleClass="input_cn_20em art_detail_tally" property="data/BcBookOpDtlVO/bookRmrk" title="<b:write property='data/BcBookOpDtlVO/bookRmrk'/>"/></td>
							</tr>
							<tr>
								<th><arthtml:label key="Label_823_00056"/><%--对手方银行国别--%>：</th>
								<td class="comparison">
									<arthtml:district id="counterPartyCountry" name="data/BcBookOpDtlVO/counterPartyCountry" classstyle="art_detail_tally" countryProperty="counterPartyCountry"
									  	provinceProperty='counterPartyProv' cityProperty='counterPartyCity' level='3' />
								</td>
							</tr>
						</tbody>
					</table>
					<table width="98%">
						<tr>
							<td align="right">
								<arthtml:permission resourceId="82300002000006" bizDefId="823-00">
									<a href="#" class="btn_gray" id="btn_price_costinfo"><span class="icon3_dingjia"></span><arthtml:label key="Link_823_00008"/><%--定价--%></a>	
								</arthtml:permission>									
							</td>
						</tr>
					</table>
						
					<div class="layout_2part block_content_table_long comparison">
						<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left" width="1380px">
							<tbody>
								<tr>
									<th>No</th>
									<th><arthtml:label key="Label_823_00057"/><%--入账账户--%></th>
									<th><arthtml:label key="Label_COM_01570"/><%--金额--%></th>
									<th><arthtml:label key="Label_823_00058"/><%--定价金额--%></th>
									<th><arthtml:label key="Label_COM_00401"/><%--EX.Method--%></th>
									<th><arthtml:label key="Label_COM_00702"/><%--Quote--%></th>
									<th><arthtml:label key="Label_823_00046"/><%--Cont.No.--%></th>
									<th><arthtml:label key="Label_COM_00706"/><%--Rate--%></th>												
									<th><arthtml:label key="Label_COM_00554"/><%--M/D--%></th>
									<th><arthtml:label key="Label_COM_00389"/><%--E/C--%></th>
									<th><arthtml:label key="Label_823_00060"/><%--入账金额--%></th>
								</tr>
								<tr>
									<td rowspan=2>
										&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;
									</td>
									<td>
										<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bookAcctCcy1" actGlId="bookAcctGl1" actSubGlId="bookAcctSubGl1" actNoId="bookAcctNo1" branchNoId="artCommonOrgCode">
											<arthtml:actCcy id="bookAcctCcy1" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctCcy1"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="bookAcctGl1" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctGl1"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="bookAcctSubGl1" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctSubGl1"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="bookAcctNo1" styleClass="input_cn_6em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctNo1"/>
										</arthtml:actInfo>
									</td>
									<td>
										<arthtml:currency id="ccy1" property="data/BcBookOpDtlVO/ccy1"  styleClass="input_en_3em art_detail_tally" childId="amt1"/>
										<arthtml:currencyMoney id="amt1" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/amt1" precision="2" />
									</td>
									<td>
										<arthtml:currency id="prcCcy1" property="data/BcBookOpDtlVO/prcCcy1"  styleClass="input_en_3em art_detail_tally" childId="prcAmt1"/>
										<arthtml:currencyMoney id="prcAmt1" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/prcAmt1" precision="2" />
									</td>
									<td>
										<arthtml:dict id="exMethod1" data="CA0079" styleClass="select art_detail_tally" property="data/BcBookOpDtlVO/exMethod1" name="data/BcBookOpDtlVO/exMethod1"/>
									</td>
									<td>
										<arthtml:dict id="quote1" data="CA0129" styleClass="select art_detail_tally" property="data/BcBookOpDtlVO/quote1" name="data/BcBookOpDtlVO/quote1"/>
									</td>
									<td>
										<arthtml:text maxlength="6" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/contNo11"/>
										<arthtml:text maxlength="2" styleClass="input_cn_2em art_detail_tally" property="data/BcBookOpDtlVO/contNo12"/>
									</td>
									<td><arthtml:text maxlength="16" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/rate1"/><arthtml:label key="Label_823_00047"/><%--%--%></td>
									<td>
										<arthtml:dict id="md1" data="CA0113" styleClass="select art_detail_tally" property="data/BcBookOpDtlVO/md1" name="data/BcBookOpDtlVO/md1"/>
									</td>
									<td>
										<arthtml:text maxlength="16" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/ecRate1"/><arthtml:label key="Label_823_00047"/><%--%--%>
									</td>
									<td>
										<arthtml:currency id="bookCcy1" property="data/BcBookOpDtlVO/bookCcy1"  styleClass="input_en_3em art_detail_tally" childId="bookAmt1"/>
										<arthtml:currencyMoney id="bookAmt1" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/bookAmt1" precision="2" />
									</td>												
								</tr>
								<tr>
									<th><arthtml:label key="Label_COM_02306"/><%--账户性质--%></th>
									<td colspan="4"><arthtml:text maxlength="7" id="acctPropty2nd1" styleClass="input_cn_40em art_detail_tally" property="data/BcBookOpDtlVO/acctPropty2nd1"/></td>
									<td colspan="5"><arthtml:text maxlength="2" id="acctPropty3rd1" styleClass="input_cn_40em art_detail_tally" property="data/BcBookOpDtlVO/acctPropty3rd1"/></td>
                </tr>
								<tr>
									<td rowspan=2>
										&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;
									</td>
									<td>
										<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bookAcctCcy2" actGlId="bookAcctGl2" actSubGlId="bookAcctSubGl2" actNoId="bookAcctNo2" branchNoId="artCommonOrgCode">
											<arthtml:actCcy id="bookAcctCcy2" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctCcy2"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="bookAcctGl2" styleClass="input_cn_3em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctGl2"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="bookAcctSubGl2" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctSubGl2"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="bookAcctNo2" styleClass="input_cn_6em art_detail_tally" property="data/BcBookOpDtlVO/bookAcctNo2"/>
										</arthtml:actInfo>
									</td>
									<td>
										<arthtml:currency id="ccy2" property="data/BcBookOpDtlVO/ccy2"  styleClass="input_en_3em art_detail_tally" childId="amt2"/>
										<arthtml:currencyMoney id="amt2" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/amt2" precision="2" />
									</td>
									<td>
										<arthtml:currency id="prcCcy2" property="data/BcBookOpDtlVO/prcCcy2"  styleClass="input_en_3em art_detail_tally" childId="prcAmt2"/>
										<arthtml:currencyMoney id="prcAmt2" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/prcAmt2" precision="2" />
									</td>
									<td>
										<arthtml:dict id="exMethod2" data="CA0079" styleClass="select art_detail_tally" property="data/BcBookOpDtlVO/exMethod2" name="data/BcBookOpDtlVO/exMethod2"/>
									</td>
									<td>
										<arthtml:dict id="quote2" data="CA0129" styleClass="select art_detail_tally" property="data/BcBookOpDtlVO/quote2" name="data/BcBookOpDtlVO/quote2"/>
									</td>
									<td>
										<arthtml:text maxlength="6" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/contNo21"/>
										<arthtml:text maxlength="2" styleClass="input_cn_2em art_detail_tally" property="data/BcBookOpDtlVO/contNo22"/>
									</td>
									<td>
										<arthtml:text maxlength="13" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/rate2"/><arthtml:label key="Label_823_00047"/><%--%--%>
									</td>
									<td>
										<arthtml:dict id="md2" data="CA0113" styleClass="select art_detail_tally" property="data/BcBookOpDtlVO/md2" name="data/BcBookOpDtlVO/md2"/>
									</td>
									<td>
										<arthtml:text maxlength="19" styleClass="input_cn_4em art_detail_tally" property="data/BcBookOpDtlVO/ecRate2"/><arthtml:label key="Label_823_00047"/><%--%--%>
									</td>
									<td>
										<arthtml:currency id="bookCcy2" property="data/BcBookOpDtlVO/bookCcy2"  styleClass="input_en_3em art_detail_tally" childId="bookAmt2"/>
										<arthtml:currencyMoney id="bookAmt2" styleClass="input_money_long t_right art_detail_tally" property="data/BcBookOpDtlVO/bookAmt2" precision="2" />
									</td>												
								</tr>
								<tr>
									<th><arthtml:label key="Label_COM_02306"/><%--账户性质--%></th>
									<td colspan="4"><arthtml:text maxlength="7" id="acctPropty2nd2" styleClass="input_cn_40em art_detail_tally" property="data/BcBookOpDtlVO/acctPropty2nd2"/></td>
                  <td colspan="5"><arthtml:text maxlength="2" id="acctPropty3rd2" styleClass="input_cn_40em art_detail_tally" property="data/BcBookOpDtlVO/acctPropty3rd2"/></td>
                </tr>										
							</tbody>
						</table>
					</div>
				</div>
				<div class="content_title">
					<table width="100%">
						<tr>
							<td>
								<a id="jidanControl" href="javascript:void(0)" class="a_expand" index="5"></a>
								<span class="icon_jidanxinxi"></span>
								&nbsp;<arthtml:label key="Label_823_00061"/><%--寄单信息--%>
							</td>
							<td align="right">
								<arthtml:permission resourceId="82300002000002" bizDefId="823-00">
									<a href="javascript:void(0)" class="img_link" id="dispch_add"><span class="icon3_xinjian"></span><arthtml:label key="Link_823_00013"/><%--增加--%></a>
								</arthtml:permission>
								<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
									<a href="javascript:void(0)" class="img_link" id="dispch_del"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
								</arthtml:permission>
								&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
					<div class="block_content_table_long layout_2part div_display expand_table comparison">	
						<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left" width="1250px" id="dispchDocTable">
							<thead>
								<tr>
									<th class="ww_title ww_outside_r" width="25.01px"><arthtml:dynCheckbox value="Y" id="dispchDocAllCheck"/></th>
									<th class="ww_outside_r" width="29.48px">&nbsp;&nbsp;No&nbsp;&nbsp;</th>
									<th class="ww_outside_r" width="172.42px"><arthtml:label key="Label_COM_01671"/><%--快递类型--%></th>
									<th class="ww_outside_r" width="91.07px"><arthtml:label key="Label_COM_01519"/><%--寄单对象--%></th>
									<th class="ww_outside_r" width="105.5px"><arthtml:label key="Label_COM_01522"/><%--寄单种类--%></th>
									<th class="ww_outside_r" width="249.12px"><arthtml:label key="Label_COM_01668"/><%--快递号码--%></th>
									<th class="ww_outside_r" width="104.48px"><arthtml:label key="Label_COM_01895"/><%--收件人--%></th>
									<th class="ww_outside_r" width="104.48px"><arthtml:label key="Label_COM_01669"/><%--快递寄单日--%></th>
									<th class="ww_outside_r" width="249.12px"><arthtml:label key="Label_COM_00968"/><%--备注--%></th>
									<th class="ww_outside_r" width="68.32px"><arthtml:label key="Label_COM_01037"/><%--操作节点--%></th>
	           		</tr>
	           	</thead>
	      			<tbody>
								<tr class="hide">
									<td></td>
									<td></td>
									<td>
										<dict:radioGroup dictTypeId="CA0294" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/exprsType" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/exprsType"/>
									</td>
									<td>
										<dict:radioGroup dictTypeId="CA0265" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocObj" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocObj"/> 
									</td>
									<td>
										<%--
										<arthtml:dict data="CA0266" styleClass="select" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocType" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocType" id="dispchDocType"/>
										--%>
									</td>
									<td>
										<arthtml:text maxlength="30" styleClass="input_cn_20em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/exprsNo" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/exprsNo" />
									</td>
									<td>
										<arthtml:text maxlength="60" styleClass="input_cn_8em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/recpnt" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/recpnt" title="<b:write property='data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/recpnt'/>"/>
									</td>
									<td>
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_rate" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/exprsDispchDocDate" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/exprsDispchDocDate"/>
									</td>
									<td>
										<arthtml:text maxlength="40" styleClass="input_cn_20em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocRmrk" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocRmrk" title="<b:write property='data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocRmrk'/>"/>
									</td>
									<td>
										<arthtml:text maxlength="20" styleClass="input_cn_5em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/operNod" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/operNod"/>
										<arthtml:hidden property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/dispchDocFlgAdd"/>
										<arthtml:hidden property="data/BcMntnOpDtlVO/dispchDocInfoVOList[0]/bizType"/>
									</td>
									
								</tr>
			     	 	<l:empty property="data/BcMntnOpDtlVO/dispchDocInfoVOList">
			       		</l:empty>
								<l:notEmpty property="data/BcMntnOpDtlVO/dispchDocInfoVOList">
				       		<l:iterate id="DispchDocInfoVO" property="data/BcMntnOpDtlVO/dispchDocInfoVOList" indexId="ind">
										<tr>
											<td></td>
											<td></td>
											<td>
												<dict:radioGroup dictTypeId="CA0294" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/exprsType"  property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/exprsType"/>
											</td>
											<td>
												<dict:radioGroup dictTypeId="CA0265" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocObj"  property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocObj"/> 
											</td>
											<td>												
												<arthtml:dict data="CA0266" styleClass="select" id="dispchDocType0" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocType" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocType"/>
											</td>
											<td>
												<arthtml:text maxlength="30" styleClass="input_cn_20em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/exprsNo"  property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/exprsNo"/>
											</td>
											<td>
												<arthtml:text maxlength="60" styleClass="input_cn_8em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/recpnt"  property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/recpnt" title="<b:write property='data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/recpnt'/>"/>
											</td>
											<td>
												<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_rate" property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/exprsDispchDocDate"/>
											</td>
											<td>
												<arthtml:text maxlength="40" styleClass="input_cn_20em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocRmrk"  property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocRmrk" title="<b:write property='data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocRmrk'/>"/>
											</td>
											<td>
												<arthtml:text maxlength="20" styleClass="input_cn_5em" name="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/operNod"  property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/operNod"/>
											</td>
											<arthtml:hidden property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/dispchDocFlgAdd"/>
											<arthtml:hidden property="data/BcMntnOpDtlVO/dispchDocInfoVOList[${ind}]/bizType"/>
										</tr>
									</l:iterate>
								</l:notEmpty>	
							</tbody>
						</table>
					</div>
				</div>
				<br/>
				
				<div id="basciControlPanelForCompare" class="div_display expand_table" style="display:none">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th><arthtml:label key="Label_823_00003"/><%--交易参号--%>：</th>
								<td>
									<arthtml:artuiBusiDealNumber id="dealNumber">	
									<arthtml:artuiBusiDealNumberTKND id="srcTkind" property="data/BcMntnOpDtlForCompareVO/tkind"/><arthtml:label key="Label_COM_00001"/><%-----%> 
									<arthtml:artuiBusiDealNumberMainParam id="srcPrmryRefNo" property="data/BcMntnOpDtlForCompareVO/txnPrmryRefNo"/><arthtml:label key="Label_COM_00001"/><%-----%>
									<arthtml:artuiBusiDealNumberSubParam id="srcSubRefNo" property="data/BcMntnOpDtlForCompareVO/txnSubRefNo"/>
								</arthtml:artuiBusiDealNumber>	
								</td>
								<th><arthtml:label key="Label_COM_01186"/><%--登记日--%>：</th>
								<td><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" property="data/BcMntnOpDtlForCompareVO/regDate"/></td>
								<th></th>
								<td></td>
							</tr>
							<tr>
								<th><arthtml:label key="Label_COM_02263"/><%--预录入号--%>：</th>
								<td><arthtml:text maxlength="9" styleClass="input_num_10em" property="data/BcMntnOpDtlForCompareVO/preInputNo"/></td>
								<th><arthtml:label key="Label_COM_02262"/><%--预录入备注--%>：</th>
								<td><arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/preInputRmrk" title="<b:write property='data/BcMntnOpDtlForCompareVO/preInputRmrk'/>"/></td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02074"/><%--网银--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="internetFlg" property="data/ForfaitingNewOpDtlVO/domtcLcFlg"/>
									<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/internetFlg"/>
									<div style="display:inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span class="compareSpan"><arthtml:label key="Label_COM_01665"/><%--跨境人民币--%></span>：
										<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/crsBorderRmbFlg"/>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="kaizhengControlPanelForCompare" class="div_display expand_table" style="display:none">
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
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02158"/><%--信用证项下--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="lcFlg" property="data/BcMntnOpDtlForCompareVO/lcFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00220"/><%--BPO--%></span>：</th>
								<td>
									<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/bpoFlg"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_COM_00872"/><%--TSU--%>：
									<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/tsuFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00675"/><%--P.P. NEGO--%></span>：</th>
								<td><arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/ppnegoFlg"/></td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01200"/><%--电报议付--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="telegNegoFlg" property="data/BcMntnOpDtlForCompareVO/telegNegoFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01201"/><%--电报议付销号日期--%></span>：</th>
								<td>
									<arthtml:artuiDatetime styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/telegNegoClsDate" showWeekDay="true"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00968"/><%--备注--%></span>：</th>
								<td>
									<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/newRmrk" title="<b:write property='data/BcMntnOpDtlForCompareVO/newRmrk'/>"/>
								</td>											
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00004"/><%--受益人--%></span>：</th>
							    <td>
									<arthtml:text id="beneCif" maxlength="8" styleClass="input_num_8em" property="data/BcMntnOpDtlForCompareVO/beneCif"/>
									<arthtml:text id="beneName" maxlength="60" styleClass="input_cn_18em" property="data/BcMntnOpDtlForCompareVO/beneName"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00022"/><%--受益人账户--%></span>：</th>
								<td>
									<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST,LONG_ACCOUNT_REGIST" actCcyId="beneAcctCcy" actGlId="beneAcctGl" actSubGlId="beneAcctSubGl"
									   actNoId="beneAcctNo" custCifId="beneCif" custNameId="beneName" branchNoId="artCommonOrgCode" >
										<arthtml:actCcy id="beneAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/beneAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actGl id="beneAcctGl" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/beneAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actSubGl id="beneAcctSubGl" styleClass="input_cn_4em" property="data/BcMntnOpDtlForCompareVO/beneAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:actNo id="beneAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/beneAcctNo"/>
									</arthtml:actInfo>
								</td>										
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01963"/><%--受益人为我行客户--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="beneOurCustFlg" property="data/BcMntnOpDtlForCompareVO/beneOurCustFlg"/>
								</td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00005"/><%--汇票金额--%></span>：</th>
								<td>
									<arthtml:currency id="bxCcy" property="data/BcMntnOpDtlForCompareVO/bxCcy"  styleClass="input_en_3em" childId="bxAmt"/>
									<arthtml:currencyMoney id="bxAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlForCompareVO/bxAmt" precision="2" />
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00844"/><%--Tenor--%></span>：</th>
								<td>
									<arthtml:dict id="tenorType" data="CA0179" styleClass="input_cn_8em select" property="data/BcMntnOpDtlForCompareVO/tenorType" name="data/BcMntnOpDtlForCompareVO/tenorType"/>&nbsp;&nbsp;
									<arthtml:text maxlength="3" styleClass="input_en_3em t_right" property="data/BcMntnOpDtlForCompareVO/tenorDays"/>&nbsp;<arthtml:label key="Label_823_00024"/><%--天--%>&nbsp;
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/tenorDate" showWeekDay="true"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01525"/><%--假远期--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="fakeForwdFlg" property="data/BcMntnOpDtlForCompareVO/fakeForwdFlg"/>
								</td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01274"/><%--发票编号--%></span>：</th>
								<td>
									<arthtml:text maxlength="30" styleClass="input_num_20em" property="data/BcMntnOpDtlForCompareVO/ivcNo"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00961"/><%--保税区属性--%></span>：</th>
							    <td>
									<arthtml:text maxlength="20" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/bondedAreaAttbt" title="<b:write property='data/BcMntnOpDtlForCompareVO/bondedAreaAttbt'/>"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00960"/><%--保税区--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="bondedAreaFlg" property="data/BcMntnOpDtlForCompareVO/bondedAreaFlg"/>
								</td>										
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02206"/><%--已签署GA/TFA--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="sigdGatfa" property="data/BcMntnOpDtlForCompareVO/sigdGatfa"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02066"/><%--托收日期--%></span>：</th>
								<td>
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/collDate" showWeekDay="true"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01184"/><%--到期日期--%></span>：</th>
								<td>
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/dueDate" showWeekDay="true"/>
								</td>										
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01993"/><%--提单日期--%></span>：</th>
								<td>
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/blDate" showWeekDay="true"/>
								</td>									
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02403"/><%--最终到期日--%></span>：</th>
								<td>
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/finalDueDate" showWeekDay="true"/>
								</td>
							</tr>
						</tbody>
					</table>
					<fieldset  class="fieldset_border" id="LcInfo">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00025"/><%--信用证信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02151"/><%--信用证编号--%></span>：</th>
									<td>
										<arthtml:text maxlength="16" styleClass="input_cn_15em" property="data/BcMntnOpDtlForCompareVO/lcNo" id="lcNo"/>
										<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
											<a href="#" class="btn_gray" id="search1"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
										</arthtml:permission>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00026"/><%--信用证金额--%></span>：</th>
									<td>
										<arthtml:currency id="lcAmtCcy" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/lcAmtCcy"  styleClass="input_en_3em" childId="expLcAmt"/>
										<arthtml:currencyMoney id="expLcAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/lcAmt" precision="2" />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00027"/><%--信用证余额--%></span>：</th>
									<td>
										<arthtml:currency id="explcBalCcy" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/lcBalCcy"  styleClass="input_en_3em" childId="expLcBalAmt"/>
										<arthtml:currencyMoney id="expLcBalAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/lcBalAmt" precision="2" />
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01626"/><%--开证日期--%></span>：</th>
									<td>
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/issueDate" showWeekDay="true"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01184"/><%--到期日期--%></span>：</th>
									<td>
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dueDate" showWeekDay="true"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01193"/><%--第二受益人--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="bene2ndFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/bene2ndFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02339"/><%--中转行--%></span>：</th>
									<td>
										<arthtml:text maxlength="60" styleClass="input_en_3em" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/trastBank" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/trastBank'/>"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02340"/><%--中转行国别--%></span>：</th>
									<td>
										<arthtml:district id="trastBankNatnlty" name="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/trastBankNatnlty" countryProperty="trastBankNatnlty" level='1' />
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01588"/><%--进口商名称--%></span>：</th>
									<td>
										<arthtml:text maxlength="60" styleClass="input_cn_25em" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/imptrName" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/imptrName'/>"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01587"/><%--进口商国别--%></span>：</th>
									<td>
										<arthtml:district id="imptrNatnlty" name="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/imptrNatnlty" countryProperty="imptrNatnlty" level='1' />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="osaNraFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/osaNraFlg"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01521"/><%--寄单行同开证行--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="dispchBankEqIssueFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchBankEqIssueFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02238"/><%--有偿付行--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="withReimbsBankFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/withReimbsBankFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02282"/><%--允许电报偿付--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="allowTelegReimbsFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/allowTelegReimbsFlg"/>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part">
							<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left">
								<tbody>
									<tr>
										<th></th>
										<th><arthtml:label key="Label_COM_01420"/><%--行号--%></th>
										<th><arthtml:label key="Label_COM_00839"/><%--Swift--%></th>
										<th><arthtml:label key="Label_COM_01720"/><%--名称--%></th>
										<th><arthtml:label key="Label_COM_01191"/><%--地址--%></th>
									</tr>
									<tr>
										<td><arthtml:label key="Label_823_00028"/><%--开证行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_01420"/><%--开证行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="issueBankCode" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/issueBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_00839"/><%--开证行Swift--%></span>												
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="issueBankSwift" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/issueBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_01720"/><%--开证行名称--%></span>			
											<arthtml:text maxlength="26" styleClass="input_cn_30em" id="issueBankName" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/issueBankName"/>													
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00028"/><arthtml:label key="Label_COM_01191"/><%--开证行地址--%></span>			
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="issueBankAddr" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/issueBankAddr" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/issueBankAddr'/>"/>
										</td>
									</tr>
									<tr>
										<td><arthtml:label key="Label_823_00012"/><%--寄单行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01420"/><%--寄单行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="lcDispchDocBankCode" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchDocBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_00839"/><%--寄单行Swift--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="lcDispchDocBankSwift" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchDocBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01720"/><%--寄单行名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="lcDispchDocBankName" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchDocBankName" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchDocBankName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01191"/><%--寄单行地址--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="lcDispchDocBankAddr" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchDocBankAddr" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/dispchDocBankAddr'/>"/>
										</td>
									</tr>
									<tr>
										<td><arthtml:label key="Label_823_00030"/><%--偿付行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_01420"/><%--偿付行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="reimbBankCode" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/reimbBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_00839"/><%--偿付行Swift--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="reimbBankSwift" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/reimbBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_01720"/><%--偿付行名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="reimbBankName" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/reimbBankName" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/reimbBankName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00030"/><arthtml:label key="Label_COM_01191"/><%--偿付行地址--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="reimbBankAddr" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/reimbBankAddr" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/reimbBankAddr'/>"/>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br/>
						<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02094"/><%--我行保兑--%></span>：</th>
									<td>
										<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/ourBankConfmdFlg"/>&nbsp;&nbsp;
										<arthtml:artuiBusiDealNumber id="1dealNumber">
										<arthtml:artuiBusiDealNumberTKND property="data/BcMntnOpDtlForCompareVO/confmdTKind" /><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:artuiBusiDealNumberMainParam property="data/BcMntnOpDtlForCompareVO/confmdPrmryRefNo"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:artuiBusiDealNumberSubParam property="data/BcMntnOpDtlForCompareVO/confmdSubRefNo"/>
										</arthtml:artuiBusiDealNumber>
									</td>
								 	<th><span class="compareSpan"><arthtml:label key="Label_COM_01704"/><%--履行保兑责任--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="perfmConfmDuties" property="data/BcMntnOpDtlForCompareVO/perfmConfmDuties"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00947"/><%--保兑备注--%></span>：</th>
									<td>
										<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/confmdRmrk" title="<b:write property='data/BcMntnOpDtlForCompareVO/confmdRmrk'/>"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02096"/><%--我行承兑--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="ourBankAccptceFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/ourBankAccptceFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02362"/><%--转让信用证--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="trasfLcFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/trasfLcFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01698"/><%--留行信用证--%></span>：</th>
									<td>
										<arthtml:dynCheckbox value="Y" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/kibLcFlg"/>&nbsp;&nbsp;&nbsp;
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/kibLcDate" showWeekDay="true"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01593"/><%--警报国家--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0285" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/alertCountry"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01129"/><%--代理行--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="agcBankFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/agcBankFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01404"/><%--国内信用证--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="domstcLcFlg" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/domstcLcFlg"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00305"/><%--Combined LC--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="combinedLcFlg" property="data/BcMntnOpDtlForCompareVO/combinedLcFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01771"/><%--其他事项--%></span>：</th>
									<td>
										<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/otherItem" title="<b:write property='data/BcMntnOpDtlForCompareVO/expLcMntnOpDtlVO/otherItem'/>"/>
									</td>
									<th></th>
									<td></td>
								</tr>
							</tbody>	
						</table>
						<div class="layout_2part" id="bbCombLcNo" >
							<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left">
								<thead>
									<tr class="ww_title">
										<th>No</th>
										<th colspan="2"><arthtml:label key="Label_COM_02151"/><%--信用证编号--%></th>
										<th><arthtml:label key="Label_823_00026"/><%--信用证金额--%></th>
										<th><arthtml:label key="Label_823_00032"/><%--drawn amount--%></th>
										<th><arthtml:label key="Label_823_00027"/><%--信用证余额--%></th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>  
 									<tr>
										<td>&nbsp;&nbsp;1&nbsp;&nbsp;</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcNo"/>
										</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
										<td>
											<arthtml:currency id="lcCcy1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcCcy"  styleClass="input_en_3em" childId="lcAmt1"/>
											<arthtml:currencyMoney id="lcAmt1" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt1"/>
											<arthtml:currencyMoney id="drawnAmt1" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy1" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt1"/>
											<arthtml:currencyMoney id="lcBalAmt1" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[1]/lcBalAmt" precision="2" />
										</td>
										<td></td>
									</tr>
									<tr>
										<td>2</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch2"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcCcy"  styleClass="input_en_3em" childId="lcAmt2"/>
											<arthtml:currencyMoney id="lcAmt2" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt2"/>
											<arthtml:currencyMoney id="drawnAmt2" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy2" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt2"/>
											<arthtml:currencyMoney id="lcBalAmt2" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[2]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel2"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
									<tr>
									<td>3</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch3"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcCcy"  styleClass="input_en_3em" childId="lcAmt3"/>
											<arthtml:currencyMoney id="lcAmt3" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt3"/>
											<arthtml:currencyMoney id="drawnAmt3" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy3" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt3"/>
											<arthtml:currencyMoney id="lcBalAmt3" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[3]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel3"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
									<tr>
										<td>4</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch4"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcCcy"  styleClass="input_en_3em" childId="lcAmt4"/>
											<arthtml:currencyMoney id="lcAmt4" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt4"/>
											<arthtml:currencyMoney id="drawnAmt4" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy4" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt4"/>
											<arthtml:currencyMoney id="lcBalAmt4" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[4]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel4"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
									<tr>
										<td>5</td>
										<td>
											<arthtml:text maxlength="16" styleClass="input_cn_15em" id="lcNo5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcNo"/>
										</td>
										<td>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="lcSearch5"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<arthtml:currency id="lcCcy5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcCcy"  styleClass="input_en_3em" childId="lcAmt5"/>
											<arthtml:currencyMoney id="lcAmt5" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="drawnCcy5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/drawnCcy"  styleClass="input_en_3em" childId="drawnAmt5"/>
											<arthtml:currencyMoney id="drawnAmt5" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/drawnAmt" precision="2" />
										</td>
										<td>
											<arthtml:currency id="lcBalCcy5" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcBalCcy"  styleClass="input_en_3em" childId="lcBalAmt5"/>
											<arthtml:currencyMoney id="lcBalAmt5" styleClass="input_money_long t_right" property="data/BcMntnOpDtlVO/bbCombLcMntnOpDtlVoList[5]/lcBalAmt" precision="2" />
										</td>
										<td>
											<arthtml:permission resourceId="82300002000003" bizDefId="823-00">
												<a href="#" class="img_link" id="lcDel5"><span class="icon3_shanchu"></span><arthtml:label key="Link_823_00006"/><%--删除--%></a>
											</arthtml:permission>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0" id="transTable">
							<tbody>	
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02359"/><%--转让第二受益人--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="trasf2ndBene" property="data/BcMntnOpDtlForCompareVO/trasf2ndBene"/>
									</td>
									<th></th>
									<td>
									</td>
									<th></th>
									<td>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part block_content_table_long" id="trasfTable">
							<table class="ww_table _left" width="1400px">
								<tbody>
									<tr>
										<th><arthtml:label key="Label_823_00034"/><%--转让编号--%></th>
										<th><arthtml:label key="Label_823_00035"/><%--第一受益人账户--%></th>
										<th><arthtml:label key="Label_823_00036"/><%--转让金额--%></th>
										<th><arthtml:label key="Label_COM_01198"/><%--第一受益人承担--%></th>
										<th><arthtml:label key="Label_COM_01194"/><%--第二受益人名称--%></th>
										<th><arthtml:label key="Label_823_00037"/><%--第二受益人银行国别--%></th>												
										<th>&nbsp;&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%>&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th><arthtml:label key="Label_COM_01195"/><%--第二受益人通知行--%></th>
									</tr>
									<tr>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00034"/><%--转让编号--%></span>
										 	<arthtml:artuiBusiDealNumber id="trasfTKindNumber"> 
												<arthtml:artuiBusiDealNumberTKND property="data/BcMntnOpDtlForCompareVO/trasfTKind"/><arthtml:label key="Label_COM_00001"/><%-----%> 
												<arthtml:artuiBusiDealNumberMainParam property="data/BcMntnOpDtlForCompareVO/trasfNoPrmryRefNo"/><arthtml:label key="Label_COM_00001"/><%-----%>
												<arthtml:artuiBusiDealNumberSubParam property="data/BcMntnOpDtlForCompareVO/trasfNoSubRefNo"/>
											</arthtml:artuiBusiDealNumber>
											<arthtml:permission resourceId="82300002000001" bizDefId="823-00">
												<a href="#" class="btn_gray" id="btn_scan"><span class="icon3_jiansuo"></span><arthtml:label key="Link_823_00004"/><%--检索--%></a>
											</arthtml:permission>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00035"/><%--第一受益人账户--%></span>
											<arthtml:actCcy id="bene1stAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/bene1stAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="bene1stAcctGl" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/bene1stAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="bene1stAcctSubGl" styleClass="input_cn_4em" property="data/BcMntnOpDtlForCompareVO/bene1stAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="bene1stAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/bene1stAcctNo"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00036"/><%--转让金额--%></span>
											<arthtml:currency id="trasfAmtCcy" property="data/BcMntnOpDtlForCompareVO/trasfAmtCcy"  styleClass="input_en_3em" childId="trasfAmt"/>
											<arthtml:currencyMoney id="trasfAmt" styleClass="input_money_long t_right" property="data/BcMntnOpDtlForCompareVO/trasfAmt" precision="2" />
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_01198"/><%--第一受益人承担--%></span>
											<dict:radioGroup dictTypeId="CA0435" id="undtk1stBeneFlg" property="data/BcMntnOpDtlForCompareVO/undtk1stBeneFlg"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_01194"/><%--第二受益人名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_14em" property="data/BcMntnOpDtlForCompareVO/bene2ndName" title="<b:write property='data/BcMntnOpDtlForCompareVO/bene2ndName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00037"/><%--第二受益人银行国别--%></span>
											<arthtml:district id="bene2ndNatnlty" name="data/BcMntnOpDtlForCompareVO/bene2ndNatnlty" countryProperty="bene2ndNatnlty"  
												provinceProperty='bene2ndProv'  cityProperty='bene2ndCity' level='3' />
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%></span>
											<dict:radioGroup dictTypeId="CA0435" id="trasfOsaNraFlg" property="data/BcMntnOpDtlForCompareVO/trasfOsaNraFlg"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_01195"/><%--第二受益人通知行--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_5em" property="data/BcMntnOpDtlForCompareVO/bene2ndNoticeBankSwiftCode"/>
											<arthtml:text maxlength="60" styleClass="input_cn_10em" property="data/BcMntnOpDtlForCompareVO/bene2ndNoticeBankName" title="<b:write property='data/BcMntnOpDtlForCompareVO/bene2ndNoticeBankName'/>"/>
										</td>
									</tr>										
								</tbody>
							</table>
						</div>
						<br/>
					</fieldset>
					<fieldset  class="fieldset_border" id="nonLcInfo">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00038"/><%--非信用证信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01588"/><%--进口商名称--%></span>：</th>
									<td>
										<arthtml:text maxlength="60" styleClass="input_cn_25em" property="data/BcMntnOpDtlForCompareVO/imptrName" title="<b:write property='data/BcMntnOpDtlForCompareVO/imptrName'/>"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01587"/><%--进口商国别--%></span>：</th>
									<td>
										<arthtml:district id="bcimptrNatnlty" name="data/BcMntnOpDtlForCompareVO/bcimptrNatnlty" countryProperty="imptrNatnlty" level='1' />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00631"/><%--OSA/NRA--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="osaNraFlg" property="data/BcMntnOpDtlForCompareVO/osaNraFlg"/>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part">
							<table cellpadding="0" cellspacing="0" border="0" class="ww_table _left">
								<tbody>
									<tr>
										<th><arthtml:label key="Label_COM_01420"/><%--行号--%></th>
										<th><arthtml:label key="Label_COM_00839"/><%--Swift--%></th>
										<th><arthtml:label key="Label_COM_01720"/><%--名称--%></th>
										<th><arthtml:label key="Label_COM_01191"/><%--地址--%></th>
									</tr>											
									<tr>
										<td><arthtml:label key="Label_823_00012"/><%--寄单行--%></td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01420"/><%--寄单行行号--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="notLcDispchDocBankCode" property="data/BcMntnOpDtlForCompareVO/dispchDocBankCode"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_00839"/><%--寄单行Swift--%></span>
											<arthtml:text maxlength="8" styleClass="input_cn_10em" id="notLcDispchDocBankSwift" property="data/BcMntnOpDtlForCompareVO/dispchDocBankSwift"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01720"/><%--寄单行名称--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="notLcDispchDocBankName" property="data/BcMntnOpDtlForCompareVO/dispchDocBankName" title="<b:write property='data/BcMntnOpDtlForCompareVO/dispchDocBankName'/>"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00012"/><arthtml:label key="Label_COM_01191"/><%--寄单行地址--%></span>
											<arthtml:text maxlength="60" styleClass="input_cn_30em" id="notLcDispchDocBankAddr" property="data/BcMntnOpDtlForCompareVO/dispchDocBankAddr" title="<b:write property='data/BcMntnOpDtlForCompareVO/dispchDocBankAddr'/>"/>
										</td>
									</tr>											
								</tbody>
							</table>
						</div>
						<br/>
						<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
							<tr>												
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01593"/><%--警报国家--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0285" property="data/BcMntnOpDtlForCompareVO/alertCountry"/>
								</td>											
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01129"/><%--代理行--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="agcBankFlg" property="data/BcMntnOpDtlForCompareVO/agcBankFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01771"/><%--其他事项--%></span>：</th>
								<td>
									<arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/otherItem" title="<b:write property='data/BcMntnOpDtlForCompareVO/otherItem'/>"/>
								</td>
					 		</tr>
						</table>
					</fieldset>
					<fieldset  class="fieldset_border">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00040"/><%--单据信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01274"/><%--发票编号--%></span>：</th>
									<td>
										<arthtml:text maxlength="16" styleClass="input_cn_15em" property="data/BcMntnOpDtlForCompareVO/docIvcNo"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01351"/><%--跟单票/光票--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0077" property="data/BcMntnOpDtlForCompareVO/docClean"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01527"/><%--交货方式--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0268" property="data/BcMntnOpDtlForCompareVO/delvrMeth"/>
									</td>											
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_02243"/><%--有追索权--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0435" id="withRcsFlg" property="data/BcMntnOpDtlForCompareVO/withRcsFlg"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00278"/><%--CHQ Kind--%></span>：</th>
									<td>
										<arthtml:dict id="chqKind" data="CA0061" styleClass="input_cn_15em select" property="data/BcMntnOpDtlForCompareVO/chqKind" name="data/BcMntnOpDtlForCompareVO/chqKind"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01604"/><%--拒绝证明--%></span>：</th>
									<td>
										<arthtml:dict id="refuseCertfct" data="CA0288" styleClass="input_cn_20em select" property="data/BcMntnOpDtlForCompareVO/refuseCertfct" name="data/BcMntnOpDtlForCompareVO/refuseCertfct"/>
									</td>																						
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01785"/><%--清算行信息--%></span>：</th>
									<td>
										<arthtml:text maxlength="2" styleClass="input_num_2em" property="data/BcMntnOpDtlForCompareVO/clrBankInfo"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00041"/><%--清算行账户--%></span>：</th>
									<td>
										<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="BcMntnOpDtlForCompareVOclrBankAcctCcy" actGlId="BcMntnOpDtlForCompareVOclrBankAcctGL" actSubGlId="BcMntnOpDtlForCompareVOclrBankAcctSubGL" actNoId="BcMntnOpDtlForCompareVOclrBankAcctNo" branchNoId="artCommonOrgCode">
											<arthtml:actCcy id="BcMntnOpDtlForCompareVOclrBankAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/clrBankAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="BcMntnOpDtlForCompareVOclrBankAcctGL" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/clrBankAcctGL"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="BcMntnOpDtlForCompareVOclrBankAcctSubGL" styleClass="input_cn_4em" property="data/BcMntnOpDtlForCompareVO/clrBankAcctSubGL"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="BcMntnOpDtlForCompareVOclrBankAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/clrBankAcctNo"/>
										</arthtml:actInfo>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00042"/><%--BC记账科目--%></span>：</th>
									<td>
										<arthtml:text maxlength="3" styleClass="input_num_3em" property="data/BcMntnOpDtlForCompareVO/bcBookAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:text maxlength="4" styleClass="input_num_4em" property="data/BcMntnOpDtlForCompareVO/bcBookAcctSubGl"/>
									</td>											
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01399"/><%--国别--%></span>：</th>
									<td>
										<arthtml:district id="natnlty" name="data/BcMntnOpDtlForCompareVO/natnlty" countryProperty="natnlty" level='1' />
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01837"/><%--商品--%></span>：</th>
									<td>
										<arthtml:text maxlength="5" styleClass="input_cn_4em" property="data/BcMntnOpDtlForCompareVO/goods"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01741"/><%--目的--%></span>：</th>
									<td>
										<arthtml:text maxlength="5" styleClass="input_cn_4em" property="data/BcMntnOpDtlForCompareVO/purpose"/>
									</td>
								</tr>
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00968"/><%--备注--%></span>：</th>
									<td colspan="3">
										<arthtml:text maxlength="8" styleClass="input_cn_8em" property="data/BcMntnOpDtlForCompareVO/docRmrk1"/>&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="8" styleClass="input_cn_8em" property="data/BcMntnOpDtlForCompareVO/docRmrk2"/>&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="26" styleClass="input_cn_20em" property="data/BcMntnOpDtlForCompareVO/docRmrk3"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00043"/><%--WSID--%></span>：</th>
									<td>
										<arthtml:text maxlength="2" styleClass="input_num_2em" property="data/BcMntnOpDtlForCompareVO/bcMntnWsid1"/><arthtml:label key="Label_COM_00001"/><%-----%>
										<arthtml:text maxlength="5" styleClass="input_num_5em" property="data/BcMntnOpDtlForCompareVO/bcMntnWsid2"/>
									</td>
								</tr>										
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00928"/><%--WSID日期--%></span>：</th>
									<td>
										<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" property="data/BcMntnOpDtlForCompareVO/bcMntnWsidDate"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01598"/><%--拒付编号--%></span>：</th>
									<td>
										<arthtml:text maxlength="15" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/dishnrHistInfoVO/dishnrNo"/>&nbsp;&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="8" styleClass="input_date_readonly" property="data/BcMntnOpDtlForCompareVO/dishnrHistInfoVO/regDate"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01368"/><%--故障编号--%></span>：</th>
									<td>
										<arthtml:text maxlength="15" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/faultHistInfoVO/faultNo"/>&nbsp;&nbsp;&nbsp;&nbsp;
										<arthtml:text maxlength="8" styleClass="input_date_readonly" property="data/BcMntnOpDtlForCompareVO/faultHistInfoVO/regDate"/>
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<fieldset  class="fieldset_border">
						<legend >&nbsp;&nbsp;<arthtml:label key="Label_823_00044"/><%--费用信息--%>&nbsp;&nbsp;</legend>
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
								<tr>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_01946"/><%--手续费支付方--%></span>：</th>
									<td>
										<dict:radioGroup dictTypeId="CA0329" property="data/BcMntnOpDtlForCompareVO/feePayer"/>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_823_00045"/><%--手续费账户--%></span>：</th>
									<td>
										<arthtml:actInfo functionType="SHORT_ACCOUNT_REGIST" actCcyId="bcInfoVOfeeAcctCcy" actGlId="bcInfoVOfeeAcctGL" actSubGlId="bcInfoVOfeeAcctSubGL" actNoId="bcInfoVOfeeAcctNo" branchNoId="artCommonOrgCode">
											<arthtml:actCcy id="bcInfoVOfeeAcctCcy" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/feeAcctCcy"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actGl id="bcInfoVOfeeAcctGL" styleClass="input_cn_3em" property="data/BcMntnOpDtlForCompareVO/feeAcctGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actSubGl id="bcInfoVOfeeAcctSubGL" styleClass="input_cn_4em" property="data/BcMntnOpDtlForCompareVO/feeAcctSubGl"/><arthtml:label key="Label_COM_00001"/><%-----%>
											<arthtml:actNo id="bcInfoVOfeeAcctNo" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/feeAcctNo"/>
										</arthtml:actInfo>
									</td>
									<th><span class="compareSpan"><arthtml:label key="Label_COM_00590"/><%--N/W区分--%></span>：</th>
									<td>
										<arthtml:text maxlength="1" styleClass="input_num_6em" property="data/BcMntnOpDtlForCompareVO/noWfDist"/>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="layout_2part">
							<table  class="ww_table _left" width="800">
								<tbody>
									<tr>
										<th>&nbsp;</th>
										<th><arthtml:label key="Label_COM_00401"/><%--EX.Method--%></th>
										<th><arthtml:label key="Label_COM_00702"/><%--Quote--%></th>
										<th><arthtml:label key="Label_823_00046"/><%--Cont.No.--%></th>
										<th><arthtml:label key="Label_COM_00706"/><%--Rate--%></th>
										<th><arthtml:label key="Label_COM_00554"/><%--M/D--%></th>
									</tr>
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;<arthtml:label key="Label_COM_01933"/><%--手续费--%>&nbsp;&nbsp;&nbsp;
										</td>												
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00401"/><%--EX.Method--%></span>
											<arthtml:dict id="feeExMethod" data="CA0079" styleClass="select" property="data/BcMntnOpDtlForCompareVO/feeExMethod" name="data/BcMntnOpDtlForCompareVO/feeExMethod"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00702"/><%--Quote--%></span>
											<arthtml:dict id="quote" data="CA0129" styleClass="select" property="data/BcMntnOpDtlForCompareVO/quote" name="data/BcMntnOpDtlForCompareVO/quote"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_823_00046"/><%--Cont.No.--%></span>
											<arthtml:text maxlength="6" styleClass="input_cn_6em" property="data/BcMntnOpDtlForCompareVO/contNo1"/>
											<arthtml:text maxlength="2" styleClass="input_cn_2em" property="data/BcMntnOpDtlForCompareVO/contNo2"/>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00706"/><%--Rate--%></span>
											<arthtml:text maxlength="13" styleClass="input_money_long t_right" property="data/BcMntnOpDtlForCompareVO/rate"/><arthtml:label key="Label_823_00047"/><%--%--%>
										</td>
										<td>
											<span class="compareSpan" style="display:none"><arthtml:label key="Label_COM_00554"/><%--M/D--%></span>
											<arthtml:dict id="md" data="CA0113" styleClass="select"  property="data/BcMntnOpDtlForCompareVO/md" name="data/BcMntnOpDtlForCompareVO/md"/>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br/>
					</fieldset>							
				</div>
				<div id="chengduiControlPanelForCompare" class="div_display expand_table" style="display:none">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01055"/><%--承兑登记日--%></span>：</th>
								<td><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcAccptceOpDtlForCompareVO/accptceRegDate" showWeekDay="true"/></td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01052"/><%--承兑到期日--%></span>：</th>
								<td><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcAccptceOpDtlForCompareVO/accptceDueDate" showWeekDay="true"/></td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_02279"/><%--远期索偿日--%></span>：</th>
								<td><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" property="data/BcAccptceOpDtlForCompareVO/forwdClmRmbrsmtDate" showWeekDay="true"/></td>
							</tr>
							<tr>										
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01441"/><%--合理--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="resnblFlg" property="data/BcAccptceOpDtlForCompareVO/resnblFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00146"/><%--Accepted Flag--%></span>：</th>
								<td>
									<dict:radioGroup dictTypeId="CA0435" id="acceptedFlg" property="data/BcAccptceOpDtlForCompareVO/acceptedFlg"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_823_00043"/><%--WSID--%></span>：</th>
								<td>
									<arthtml:text maxlength="2" styleClass="input_num_2em" property="data/BcAccptceOpDtlForCompareVO/bcAccptceWsid1"/><arthtml:label key="Label_COM_00001"/><%-----%>
									<arthtml:text maxlength="5" styleClass="input_num_5em" property="data/BcAccptceOpDtlForCompareVO/bcAccptceWsid2"/>
								</td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00928"/><%--WSID日期--%></span>：</th>
								<td>
									<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" property="data/BcAccptceOpDtlForCompareVO/bcAccptceWsidDate"/>
								</td>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_01051"/><%--承兑备注--%></span>：</th>
								<td colspan="3"><arthtml:text maxlength="40" styleClass="input_cn_50em" property="data/BcAccptceOpDtlForCompareVO/accptceRmrk" title="<b:write property='data/BcAccptceOpDtlForCompareVO/accptceRmrk'/>"/></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="tuigaidanControlPanelForCompare" class="div_display expand_table" style="display:none">
					<table class="table_search table_3 table_fixed" cellpadding="0" cellspacing="0">
						<thead>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<tr>
								<th></th>
								<td>
									<dict:radioGroup id="bbMaintType" dictTypeId="CA0354" property="data/BbModChgbkDocInfoForCompareVO/bbMaintType"/>
								</td>
								<th><arthtml:label key="Label_COM_01186"/><%--登记日--%>：</th>
								<td><arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date" id="modChgbkDocRegDate" property="data/BbModChgbkDocInfoForCompareVO/regDate"  showWeekDay="true"/></td>
								<th><arthtml:label key="Label_COM_02274"/><%--原因--%>：</th>
								<td><arthtml:text maxlength="40" styleClass="input_cn_20em" id="resn" property="data/BbModChgbkDocInfoForCompareVO/resn" title="<b:write property='data/BbModChgbkDocInfoForCompareVO/resn'/>"/></td>
							</tr>
							<tr>
								<th><span class="compareSpan"><arthtml:label key="Label_COM_00968"/><%--备注--%></span>：</th>
								<td colspan="3"><arthtml:text maxlength="40" styleClass="input_cn_20em" property="data/BbModChgbkDocInfoForCompareVO/modChgbkDocRmrk" title="<b:write property='data/BbModChgbkDocInfoForCompareVO/modChgbkDocRmrk'/>"/></td>
								<th><arthtml:label key="Label_823_00043"/><%--WSID--%>：</th>
							<td>
								<arthtml:text maxlength="2" styleClass="input_cn_2em" id="modChgbkDocWsid1" property="data/BbModChgbkDocInfoForCompareVO/modChgbkDocWsid1"/><arthtml:label key="Label_COM_00001"/><%-----%>											
								<arthtml:text maxlength="5" styleClass="input_cn_5em" id="modChgbkDocWsid2" property="data/BbModChgbkDocInfoForCompareVO/modChgbkDocWsid2"/>
							</td>	
							<th><arthtml:label key="Label_COM_00928"/><%--WSID日期--%>：</th>
							<td>
								<arthtml:artuiDatetime dateFmt="yyyy-MM-dd" styleClass="input_date_readonly" id="modChgbkDocWsidDate" property="data/BbModChgbkDocInfoForCompareVO/modChgbkDocWsidDate"/>										                                                     
							</td>
							</tr>
						</tbody>
					</table>
				</div>
				<%--
				<div>
					<l:in property="data/LogicPageId" targetValue="823002001,823002002,823002003,823002004,823002012,823002013,823002014,823002015,823002016,823002017,823002018,823002019,823002020">
						<jsp:include flush="true" page="/page/pendingmanagement/unfinishedManagementRegisterwithtransactionDetail838003.jsp"/>
					</l:in>
				</div>
				<div>
					<l:in property="data/LogicPageId" targetValue="823002001,823002002,823002003,823002004,823002008,823002009,823002010,823002011,823002012,823002013,823002014,823002015,823002016,823002017,823002018,823002019,823002020">
						<jsp:include flush="true" page="/page/feemanagement/feeManagementRegisterWithTransactionDetail806002.jsp"/>
					</l:in>
				</div>
				<div>
					<%@include file="../../artframework/common/onp.jsp" %>	
				</div>
				<div>
					<%@include file="../../artframework/common/bop.jsp" %>
				</div>
				--%>
				<%--
				<script language="javascript">
					$(document).ready(function(){
	  					$('#basciControlPanel, #kaizhengControlPanel, #chengduiControlPanel, #tuigaidanControlPanel').BlockObserve({excludeFilter:["#bbCombLcNo", "#bbMaintType", "#modChgbkDocRegDate", "#resn"],compareBtn:"#compareButton",exportTable:"#mosHist",compareOriginal:"#basciControlPanelForCompare, #kaizhengControlPanelForCompare, #chengduiControlPanelForCompare,#tuigaidanControlPanelForCompare"});
					});
				</script>--%>
			</div>	
	</body>
</html>