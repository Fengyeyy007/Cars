<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/public.css">
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
		<div align="center">仓库信息查看</div>
		</td>
		<td width="50" background="../images/tab/lastRightSel.gif">&nbsp;</td>
		<td background="../images/tab/bg.gif">&nbsp;</td>
	</tr>
</table>
<form name="form1" method="post" action="CarsAction!CartBy.action">
  <label></label>
　　　　　仓库名：
<select name="cars.stockName">
	<c:forEach items="${stockName }" var="stocn">
  		<option value="${stocn.stockName}">${stocn.stockName}</option>
  	</c:forEach>
</select> 　　
汽车类型：
<label>
<select name="cars.carName">
<c:forEach items="${carNamelist }" var="carName">
  <option value="${carName}">${carName}</option>
 </c:forEach>
</select>
</label> 　 
汽车型号：
<label>
<input type="text" name="cars.carType">
</label>　　
<label>
<input type="submit" name="Submit" value="查询">
</label>
<p>&nbsp;</p>
</form>
<form name="editdemo" action="addResume.do" method="post">
<table class="maintable" width="100%" border="0" cellspacing="0">
	<c:forEach items="${liststo }" var="stoc">
	<tr>
		<td width="12%" height="27">
	  <div align="center">仓　　库：</div>		</td>
		<td width="13%"><div align="center">${stoc.stockName }</div></td>
		<td width="14%">&nbsp;</td>
		<td width="14%">&nbsp;</td>
		<td width="20%">
		  <div align="center">仓库存储量：</div></td>
		<td width="27%"><div align="center">${stoc.maxSum }</div></td>
	</tr>
	
	<tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	<tr>
		<td height="23">
	  <div align="center">仓库地址：</div>		</td>
		<td colspan="5"><div align="center">${stoc.stockPlace }</div></td>
	</tr>
	<c:forEach items="${list }" var="carstoc">
	<c:if test="${stoc.stockId==carstoc.stockId }">
	<tr>
      <td><div align="center">汽车名称：</div></td>
	  <td><div align="center">${carstoc.carName }</div></td>
	  <td><div align="center">型号：</div></td>
	  <td><div align="center">${carstoc.carType }</div></td>
	  <td><div align="center">数　　量：</div></td>
	  <td><div align="center">${carstoc.liveSum }</div></td>
    </tr>
    <tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
    </c:if>
	</c:forEach>
	<tr align="center" bgcolor="#FFFFFF">
		<td height="19" colspan="6" class="titleLine" bgcolor="#99CCFF">
		<div align="left">
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
		</div>		</td>
	</tr>
	</c:forEach>
	
	<c:forEach items="${cartby }" var="cartbyy">
	<tr>
		<td width="12%" height="27">
	  <div align="center">仓　　库：</div>		</td>
		<td width="13%"><div align="center">${cartbyy.stockName }</div></td>
		<td width="14%">&nbsp;</td>
		<td width="14%">&nbsp;</td>
		<td width="20%">
		  <div align="center">仓库存储量：</div></td>
		<td width="27%"><div align="center">${cartbyy.maxSum }</div></td>
	</tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	<tr>
		<td height="23">
	  <div align="center">仓库地址：</div>		</td>
		<td colspan="5"><div align="center">${cartbyy.stockPlace }</div></td>
	</tr>
	<tr>
      <td><div align="center">汽车名称：</div></td>
	  <td><div align="center">${cartbyy.carName }</div></td>
	  <td><div align="center">型号：</div></td>
	  <td><div align="center">${cartbyy.carType }</div></td>
	  <td><div align="center">数　　量：</div></td>
	  <td><div align="center">${cartbyy.liveSum }</div></td>
    </tr>
    <tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	</c:forEach>
	<!-- <tr>
      <td height="27"><div align="center">仓　　库：</div></td>
	  <td><div align="center">北京仓库</div></td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
	  <td><div align="center">仓库存储量：</div></td>
	  <td><div align="center">200辆</div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td height="23"><div align="center">仓库地址：</div></td>
	  <td colspan="5"><div align="center">中华人民共和国上海浦东开发区</div>
      <div align="center"></div>	    <div align="center"></div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td><div align="center">汽车名称：</div></td>
	  <td><div align="center">奔驰</div></td>
	  <td><div align="center">型号：</div></td>
	  <td><div align="center">S600</div></td>
	  <td><div align="center">数　　量：</div></td>
	  <td><div align="center">10辆</div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td><div align="center">汽车名称：</div></td>
	  <td><div align="center">宝马</div></td>
	  <td><div align="center">型号：</div></td>
	  <td><div align="center">BMW</div></td>
	  <td><div align="center">数　　量：</div></td>
	  <td><div align="center">20辆</div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td><div align="center">汽车名称：</div></td>
	  <td><div align="center">法拉利</div></td>
	  <td><div align="center">型号：</div></td>
	  <td><div align="center">F001</div></td>
	  <td><div align="center">数　　量：</div></td>
	  <td><div align="center">5辆</div></td>
    </tr>
 -->
	<tr>
		<td colspan="6" align="center">&nbsp;</td>
	</tr>
</table>
<table align="center" width="100%">
	<tr>
		<td height="30">
		  <div align="center"></div></td>
	</tr>
	<tr>
		<td height="30" background="images/tab/bg.gif"></td>
	</tr>
</table>
</form>
</body>
</html>
