<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="../css/public.css">
<script language="javascript" type="text/javascript" src="../js/birthday.js"></script>
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
		function checkAll()
		{
			var obj = document.getElementById("all");
			var arr = document.getElementsByName("yids");
			for(var i = 0; i < arr.length; i++)
			{
				arr[i].checked = obj.checked;
			} 
		}
		function check1(){
			document.getElementById("form2").action='CarsAction!queryCarsByid.action';
		}
		function check2(){
			document.getElementById("form2").action='CarsAction!CarsList.action';
		}
</script>
<body>
<table class="maintable" border="0" width="100%" cellspacing="0">
	<tr>
		<td background="../images/topBarBg.gif">销售管理</td>
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
		<div align="center">汽车信息</div>
		</td>
		<td width="50" background="../images/tab/lastRightSel.gif">&nbsp;</td>
		<td background="../images/tab/bg.gif">&nbsp;</td>
	</tr>
</table>
<form action="listResume.do?page=1" method="post">
<table class="maintable" border="0" width="100%" cellspacing="0">
  <tr>
    <td height="27" class="searchfontlist"><div align="right">汽车属性：:</div></td>
    <td><label>
      <select name="select">
        <option>汽车名称</option>
        <option>汽车型号</option>
        <option>汽车颜色</option>
      </select>
    </label></td>
    <td><div align="center">汽车属性：
      <label>
            <select name="select2">
              <option>上海仓库</option>
              <option>北京仓库</option>
              <option>武汉仓库</option>
            </select>
            </label>
    </div></td>
    <td>　
      <div align="center"></div>
      <div align="center"></div>
      　 
    </td>
  </tr>
	<tr>
		<td width="22%" height="40" class="searchfontlist">
	  <div align="right">生产日期：:</div>	  </td>
		<td width="22%"><label>
		  <input type="text" name="mailingTime2" id="mailingTime2" onClick="show_cele_date(this,'','',this)">
	  </label></td>
		<td width="35%">
	      <div align="center">入库日期：
	        <label>
	        <input type="text" name="mailingTime" id="mailingTime" onClick="show_cele_date(this,'','',this)">
	        </label>
      　　</div></td>
		<td width="21%">　
		  <label>
		  <input type="button" name="Submit" value="查询">
		  </label>
		  <div align="center"></div>
		  <div align="center"></div>      </td>
	</tr>
</table>
</form>
<form action="" method="post" id="form2">
<table class="tablelistcontent" width="100%" border="1" cellspacing="1">
	<tr>
		<th width="45"><label>
		  <input type="checkbox" name="checkbox2" value="checkbox" id="all" onClick="checkAll()"/>
      </label></th>
		<th width="67">汽车编号</th>
		<th width="74">汽车名称</th>
		<th width="75">汽车型号</th>
		<th width="59">汽车颜色</th>
		<th width="60">发动机号</th>
		<th width="68">生产地</th>
		<th width="87"><div align="center">生产日期</div></th>
		<th width="87">入库日期</th>
		<th width="79">车辆流向</th>
		<th width="61">汽车描述</th>
		<th width="68">所属仓库</th>
	</tr>
	<c:forEach items="${pager.currentPagedText }" var="car">
	<tr class=Off onMouseOut="this.className='Off'"
		onMouseOver="this.className='Up'">
	  <td height="24"><div align="center">
	    <input type="checkbox" name="yids" value="${car.carId }">
	    </div></td>
	  <td><div align="center">${car.carId }</div></td>
	  <td><div align="center">${car.carName }</div></td>
	  <td><div align="center">${car.carType }</div></td>
	  <td><div align="center">${car.carColor }</div></td>
	  <td><div align="center">${car.engineId }</div></td>
	  <td><div align="center">${car.carFromArea }</div></td>
	  <td><div align="center">${car.createDate }</div></td>
	  <td><div align="center">${car.intoStockDate }</div></td>
	  <td><div align="center">${car.carToArea }</div></td>
	  <td><div align="center">${car.remarks }</div></td>
	  <td><div align="center">${car.stockName }</div></td>
	  </tr>
	  </c:forEach>
	
</table>
<table width="100%">
	<tr>
		<td height="40" align="center" valign="middle">
		<div align="left">
		  <label></label>
		  <input type="submit" name="Submit3" value="汽车移库"  onClick="check1()">
          </div>
		<div align="center"></div>
		<div align="center"></div>		</td>
		<td width="20">
		<div align="center"></div>		</td>
		<td width="20">
		<div align="center"><a href="CarsAction!CarsList?pagers=1"><img
			src="../images/report/firstPage.gif" width="17" height="11"
			border="0"></a></div>		</td>
		<td width="20">
		<div align="center">
		<a href="CarsAction!CarsList?pagers=${pager.currentPage-1 }">
		  <img
			src="../images/report/prePage.gif" width="14" height="11" border="0"></a></div>		</td>
		<td width="20">
		<div align="center">
		  <a href="CarsAction!CarsList?pagers=${pager.currentPage+1 }">
		  <img
			src="../images/report/nextPage.gif" width="14" height="11" border="0"></a></div>		</td>
		<td width="20">
		<div align="center"><a href="CarsAction!CarsList?pagers=${pager.totalPage }"><img
			src="../images/report/endPage.gif" width="17" height="11" border="0"></a></div>	</td>
		<td width="40">
		<div align="left"><a href="#">页次</a></div>		</td>
		<td width="40">
		<div align="left"></div>		</td>
		<td width="40">
		<div align="right">转至</div>		</td>
		<td width="35" align="center"><input class="inputcontent"
			name="pagers" type="textfield" size="5"></td>
		<td width="80" align="center"><input type="image"  src="../images/report/go.gif" onClick="check2()"></td>
		<td width="6"></td>
	</tr>
</table>
</form>
</body>
</html>
