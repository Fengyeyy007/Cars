<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="../css/public.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<script type="text/javascript">
	function check(data){
		var role=document.getElementsByName("uro.perviewName");
		role[data-1].checked=true;
		} 
</script>
</head>
<body>
<table border="0" width="100%" cellspacing="0">
  <tr>
    <td background="../images/topBarBg.gif" height="23"><strong>
    <div class="searchfontlist"> &nbsp; 系统管理∶编辑角色</div>
    </strong></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#6490C2">
  <tr>
    <td width="25" height="24" background="../images/tab/firstLeftSel.gif">&nbsp;</td>
    <td width="100" background="../images/tab/middleSel.gif"><div align="center"><span class="tabTitleSel">请填写内容</span></div></td>
    <td width="50" background="../images/tab/lastRightSel.gif">&nbsp;</td>
    <td background="../images/tab/bg.gif">&nbsp;</td>
  </tr>
</table>
<form action="" method="post">
  <table class="maintable" width="100%" border="0" cellspacing="0">
    
    <tr>
      <td width="104"><div align="right">角色名称：</div></td>
      <td width="239" height="24"><input name="uro.roleName"  type="text" class="inputcontent" id="roleName" size="20">
      </td>
    <td width="435"></td>
    </tr>
    <tr>
      <td width="104"><div align="right">角色描述：</div></td>
      <td height="24"><textarea name="uro.roleMark" id="roleDepict"></textarea></td>
    <td height="24"></td>
    </tr>
    <tr>
      <td width="104"><div align="right">权限：</div></td>
      <td height="24" colspan="2"><table width="286" border="0">
        <!-- <tr>
          <td width="70" rowspan="4"><select name="select" size="4" id="left" multiple>
            <option>系统管理</option>
            <option>仓库管理</option>
            <option>统计管理</option>
            <option>销售管理</option>
            <option>客户管理</option>
          	
          </select></td>
          <td width="95">&nbsp;</td>
          <td width="107" rowspan="4"><select name="pur" size="4" id="right" multiple>
		    
          </select>-->
          
        <input type="checkbox" name="uro.perviewName" value="系统管理"/>系统管理
        <input type="checkbox" name="uro.perviewName" value="仓库管理"/>仓库管理
        <input type="checkbox" name="uro.perviewName" value="统计管理"/>统计管理
		<input type="checkbox" name="uro.perviewName" value="销售管理"/>销售管理
      	<input type="checkbox" name="uro.perviewName" value="客户管理"/>客户管理
          </td>
        </tr>
        <!-- <tr>
          <td><input type="button" name="Submit" value="添加 &gt;&gt;" onClick="move('left','right')"></td>
        </tr>
        <tr>
          <td><input type="button" name="Submit" value="&lt;&lt; 删除" onClick="move('right','left')"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr> -->
      </table></td>
    </tr>
  </table>
  <table align="right" width="100%">
    <tr>
      <td height="30" width="70"></td>
      <td width="65"><input type="submit" name="Submit" value="确定" ></td>
      <td width="96"><div align="center">
          <label>
          <input type="button" name="Submit" value="返回" >
</label>
        </div></td>
      <td width="60">&nbsp;</td>
      <td width="486"></td>
    </tr>
    <tr>
      <td height="30" colspan="5" background="../images/tab/bg.gif"></td>
    </tr>
  </table>
</form>
</body>
</html>
