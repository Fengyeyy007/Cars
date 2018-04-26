﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>客户管理</title>
<link type="text/css" rel="stylesheet" href="../css/public.css">
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</script>
</head>
<script language="javascript" type="text/javascript">
        var popUp; 
		function openwin(idname)
		{
			popUp = window.open('date.html?formname=form1&id=' + idname,
			'ѡ������',
			'height=180, width=200,left=300,top=150, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
		}

		function SetDate(id,newDate)
		{
			
			popUp.close();
			form1.elements[id].value = newDate;
		}
		function check(){		
			var id=document.getElementById("tramp");
			var checks=document.getElementById("delid");
			var ids=document.getElementsByName("tmps");
			var fir=new Array();
 			var flag;
			for(var i=0;i<ids.length;i++){
/* 				ids[i].checked=checks.checked; */
				flag=true;
				if(ids[i].checked==false){
/* 					fir.push(ids[i].value); */
					flag=false;
				}  
			}
/* 			id.value=fir; */
			checks.checked=flag;
		}
		function check1(){		
			var checks=document.getElementById("delid");
			var ids=document.getElementsByName("tmps");
			for(var i=0;i<ids.length;i++){
				ids[i].checked=checks.checked;
			}
		}
</script>
<body>
<table class="maintable" border="0" width="100%" cellspacing="0">
	<tr>
		<td background="../images/topBarBg.gif">客户管理</td>
		<td width="20" height="23" background="../images/topBarBg.gif">
		<div align="right"><a href="#"><img
			src="../images/iHelp.gif" width="16" height="16" border="0"></a></div>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	bordercolor="#6490C2">
	<tr>
		<td width="25" height="24" background="../images/tab/firstLeftSel.gif">&nbsp;</td>
		<td width="100" background="../images/tab/middleSel.gif">
		<div align="center">客户信息</div>
		</td>
		<td width="50" background="../images/tab/lastRightSel.gif">&nbsp;</td>
		<td background="../images/tab/bg.gif">&nbsp;</td>
	</tr>
</table>
<form action="listResume.do?page=1" method="post">
<table class="maintable" border="0" width="100%" cellspacing="0">
	<tr>
	  <td width="3%" class="searchfontlist">&nbsp;</td>
		<td width="54%">　　　　　　　　　　　　　　客户信息：
		  <label>
		  <input type="text" name="textfield">
      </label></td>
		<td width="34%" class="searchfontlist"><label>
		  <input type="button" name="Submit3" value="查询">
	  </label></td>
		<td width="3%">&nbsp;</td>
		<td width="3%">&nbsp;</td>
		<td width="3%"></td>
	</tr>
</table>
</form>
<form action="CustomerAction!delCustomers.action" method="post">
<input type="hidden" id="tramp" name="tmp"/>
  <table class="tablelistcontent" width="100%" border="1" cellspacing="1">
    <tr>
      <th width="73">选择</th>
      <th width="125">客户号</th>
      <th width="114">姓名</th>
      <th width="104">性别</th>
      <th width="121">联系电话</th>
      <th width="101">身份证</th>
      <th width="87">住址</th>
      <th width="147">修改</th>
    </tr>
    <c:forEach items="${customerlist }" var="cu">
      <tr class=Off onMouseOut="this.className='Off'"
		onMouseOver="this.className='Up'">
        <td height="24"><div align="center">
            <input type="checkbox" name="tmps" value="${cu.customerId }"  onclick="check()"/>
        </div></td>
        <td><div align="center">${cu.customerId }</div></td>
        <td><div align="center">${cu.customerName }</div></td>
        <td><div align="center">${cu.customerGender }</div></td>
        <td><div align="center">${cu.customerPhone }</div></td>
        <td><div align="center">${cu.customerCode }</div></td>
        <td><div align="center">${cu.customerAdd }</div></td>
        <td><div align="center"><a href="CustomerAction!queryCById?custo.customerId=${cu.customerId }">修改</a></div></td>
      </tr>
      </c:forEach>
  </table>
  <table width="100%">
	<tr>
		<td height="40">
		<div align="left"><input type="checkbox" name="checkbox4" id="delid"
			value="checkbox" onclick="check1()"> 全选 <input type="button" name="Submit"
			value="添加客户" onClick="window.location.href='../customer/addcustomer.jsp'">
			 <input type="submit" name="Submit" value="删除客户">
		</div>
		<div align="center"></div>
		<div align="center"></div>
		</td>
		<td width="20">
		<div align="center"></div>
		</td>
		<td width="20">
		<div align="center"><a href="listResume.do?page=1"><img
			src="../images/report/firstPage.gif" width="17" height="11"
			border="0"></a></div>
		</td>
		<td width="20">
		<div align="center">
		  <c:if test="${showPage <= 1 }"></c:if>
		  <img
			src="../images/report/prePage.gif" width="14" height="11" border="0"></div>
		</td>
		<td width="20">
		<div align="center">
		  <c:if test="${showPage >= pageSum }"></c:if>
		  <img
			src="../images/report/nextPage.gif" width="14" height="11" border="0"></div>
		</td>
		<td width="20">
		<div align="center"><a href="listResume.do?page=${pageSum}"><img
			src="../images/report/endPage.gif" width="17" height="11" border="0"></div>
		</td>
		<td width="40">
		<div align="left"><a href="#">页次</a></div>
		</td>
		<td width="40">
		<div align="left"></div>
		</td>
		<td width="40">
		<div align="right">转至</div>
		</td>
		<td width="35" align="center"><input class="inputcontent"
			name="go" type="textfield" size="5"></td>
		<td width="80" align="center"><input type="image" src="../images/report/go.gif"></td>
		<td width="6"></td>
	</tr>
</table>
</form>
</body>
</html>
