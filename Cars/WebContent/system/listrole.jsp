﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="../css/public.css">
</head>
<script language="javascript" type="text/javascript">
        var popUp; 
		function openwin(idname)
		{
			popUp = window.open('date.html?formname=form1&id=' + idname,
			'选择日期',
			'height=180, width=200,left=300,top=150, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
		}

		function SetDate(id,newDate)
		{
			
			popUp.close();
			form1.elements[id].value = newDate;
		}
		function check1(){
			document.getElementById("form1").action='UroleptreeAction!delrole.action';
		}
		function check2(){
			document.getElementById("form1").action='UroleptreeAction!queryAllroles.action';
		}
		function checkAll(){
			var checks=document.getElementById("all");
			var ids=document.getElementsByName("dels");
			for(var i=0;i<ids.length;i++){
				ids[i].checked=checks.checked;
			}
		}
</script>
<body>
<table class="maintable" border="0" width="100%" cellspacing="0">
  <tr>
    <td background="../images/topBarBg.gif">系统管理：角色管理</td>
    <td width="20" height="23" background="images/topBarBg.gif"><div align="right"><a href="#"><img src="images/iHelp.gif" width="16" height="16" border="0"></a></div></td>
  </tr>
</table>


  <form id="form1" action="" method="post">
    <table class="tablelistcontent" width="100%" border="1" cellspacing="1">
      <tr>
        <th width="61"><div align="center">
            <input type="checkbox" name="checkbox" id="all" value="checkbox" onClick="checkAll()">
        </div></th>
        <th width="87"><div align="center">角色编号</div></th>
        <th width="93"><div align="center">角色名称</div></th>
        <th width="114"><div align="center">角色描述</div></th>
        <th width="348"><div align="center">权限</div></th>
        <th width="168">编辑</th>
      </tr>
      <c:forEach items="${pager.currentPagedText }" var="rolep">
      <tr class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'">
        <td height="24"><div align="center">
            <input type="checkbox" name="dels" value="${rolep.roleId }" >
        </div></td>
        <td><div align="center">${rolep.roleId }</div></td>
        <td><div align="center"><a href="viewrole.jsp">${rolep.roleName }</a></div></td>
        <td><div align="center">${rolep.roleMark }</div></td>
        <td><div align="center">
            <div align="center">
              <div align="center">${rolep.perviewName }</div>
            </div>
        </div></td>
        <td><div align="center"><a href="UroleptreeAction!queryroleById?uro.roleId=${rolep.roleId }"><img src="../images/edit.gif" width="16" height="19" border="0"></a></div>
            <div align="center"></div></td>
      </tr>
	</c:forEach>
    </table>
    <table width="100%">
    <tr>
      <td height="40" width="10"><div align="center"></div></td>
      <td width="50"><div align="center">
        <input type="submit" name="Submit" value="删除" onClick="check1()">
          </div></td>
      <td width="50"><div align="center">
        <input type="button" name="Submit" value="添加" onClick="window.location.href='../system/addrole.jsp'">
      </div></td>
      <td width="86"><div align="center">
      </div></td>
      <td width="69"><div align="center">
      </div></td>
      <td width="69"><div align="center">
      </div></td>
      <td width="69"><div align="center">
	  </div></td>
      <td width="17"><div align="center"></div></td>
      <td width="19"><div align="center"><a href="UroleptreeAction!queryAllroles?pagers=1"><img src="../images/report/firstPage.gif" width="17" height="11" border="0"></div></td>
      <td width="19"><div align="center"><a href="UroleptreeAction!queryAllroles?pagers=${pager.currentPage-1 }">
        <img src="../images/report/prePage.gif" width="14" height="11" border="0"></div></td>
      <td width="19"><div align="center"><a href="UroleptreeAction!queryAllroles?pagers=${pager.currentPage+1 }"><img src="../images/report/nextPage.gif" width="14" height="11" border="0"></div></td>
      <td width="19"><div align="center"><a href="UroleptreeAction!queryAllroles?pagers=${pager.totalPage }"><img src="../images/report/endPage.gif" width="17" height="11" border="0"></div></td>
      <td width="37"><div align="left"><a href="#">页次</a>:</div></td>
      <td width="37">&nbsp;</td>
      <td width="36"><div align="right">转至</div></td>
      <td width="35" align="center"><input name="pagers" type="text" size="2"></td>
      <td width="84" align="center"><input type="image" src="../images/report/go.gif" onClick="check2()"></td>
	  <td width="0"></td>
    </tr>
</table>
  </form>
</body>
</html>
