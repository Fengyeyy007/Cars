﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" type="text/css" href="css/birthday.css">
<script language="javascript" type="text/javascript" src="../js/birthday.js"></script>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->

</script>
<style type="text/css">
<!--
.style2 {
	font-size: 12px
}
-->
</style>
</head>
<body>
<table border="0" width="100%" cellspacing="0">
	<tr>
		<td background="../images/topBarBg.gif" height="23">仓库管理</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	bordercolor="#6490C2">
	<tr>
		<td width="25" height="24" background="../images/tab/firstLeftSel.gif">&nbsp;</td>
		<td width="100" background="../images/tab/middleSel.gif">
		<div align="center">增加新车</div>
		</td>
		<td width="50" background="../images/tab/lastRightSel.gif">&nbsp;</td>
		<td background="../images/tab/bg.gif">&nbsp;</td>
	</tr>
</table>
<form name="listform" action="CarsAction!addCarss.action" method="post" onSubmit="return subUser() ">
  <table class="maintable" width="97%" border="0" cellspacing="0">
 
    <tr>
      <td width="14%"><div align="center">汽车编号</div></td>
      <td width="23%"><input type="text" name="cars.carId" id="names" >
      *<div id="test_names" style="display:none ">请填写汽车编号</div>      </td>
      <td width="15%"><div align="center">汽车名称</div></td>
      <td width="48%"><input type="text" name="cars.carName" id="otherLink"></td>
    </tr>
    <tr>
      <td><div align="center">汽车型号</div></td>
      <td><input type="text" id="linkPhone" name="cars.carType"></td>
      <td><div align="center">汽车颜色</div></td>
      <td><input type="text" id="age" name="cars.carColor"></td>
    </tr>
    <tr>
      <td><div align="center">发动机号</div></td>
      <td><input type="text" name="cars.engineId" id="specialty"></td>
      <td><div align="center">生产地</div></td>
      <td><input type="text" name="cars.carFromArea" id="school"></td>
    </tr>
    <tr>
      <td><div align="center">车辆流向 </div></td>
      <td><input type="text" name="cars.carToArea" id="school2"></td>
      <td><div align="center">所属仓库</div></td>
      <td><label>
        <select name="cars.stockName">
        <c:forEach items="${stos }" var="sto">
          <option selected>${sto.stockName }</option>
        </c:forEach>
        </select>
      </label></td>
    </tr>
    <tr>
      <td><div align="center">生产日期</div></td>
      <td><input type="text" name="cars.createDate" id="mailingTime2" onClick="show_cele_date(this,'','',this)"></td>
      <td><div align="center">入库日期</div></td>
      <td>
	  <input type="text" name="cars.intoStockDate" id="mailingTime" onClick="show_cele_date(this,'','',this)"></td>
    </tr>
    <tr align="center" bgcolor="#99CCFF">
      <td height="26" colspan="4" class="titleLine"><div align="left"> 汽车描述：<span class="style2"></span></div></td>
    </tr>
    <tr>
      <td height="121" colspan="4" align="center"><textarea name="cars.remarks" id="texts" cols="140" rows="5"></textarea></td>
    </tr>
  </table>
  <option></option>
<option></option>
<table align="left" width="100%">
	<tr>
		<td height="107">
		<div align="center"><input type="submit" name="Submit"
			value="提交"> 
		  <input type="reset" name="Submit"
			value="重置">
		</div>
	  </td>
	</tr>
	<tr>
		<td height="30" background="../images/tab/bg.gif"></td>
	</tr>
</table>
</form>
</body>
</html>
