<%@ page language="java"  import="java.util.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/public.css" rel="stylesheet" type="text/css" />
</head>
<script language=javascript>
NS4 = (document.layers) ? 1 : 0;
IE4 = (document.all) ? 1 : 0;
ver4 = (NS4 || IE4) ? 1 : 0;

if (ver4) {
with (document) {
write("<STYLE TYPE='text/css'>");
if (NS4) {
write(".parent {position:absolute; visibility:visible background:red}");
write(".child {position:absolute; visibility:hide }");
write(".regular {position:absolute; visibility:visible}")
}
else {
write(".child {display:none;text-align:left}")
}
write("</STYLE>");
}
}
</script>
<script language=javascript>

function expandIt(el)
{
var whichEl = eval(el + "Child");
var s1 = eval(el + "f");
//alert(whichEl);

if (whichEl.style.display != "block") 
{
whichEl.style.display = "block";
//alert(whichEl.style.pixelHeight);
//alert(whichEl.style.width);
s1.innerHTML = "<img src='../images/iOpenFolder.gif'>"
}
else 
{
whichEl.style.display = "none";
s1.innerHTML = "<img src='../images/iGenericFolder.gif'>"
}
//arrange()
// whichE1.pageY = 200;
}
function button_over(o)
{
o.style.background="#CCCCCC";
}

function button_out(o)
{
o.style.background="";
}


</script>
<body>
<c:forEach items="${treelist}" var="urp">
<c:if test="${urp.perId==0 }">
<div id="KB1Parent" class="parent">
<table width="190"><tr><td width="16" id="KB1f"><img src="../images/iGenericFolder.gif" width="16" height="16"></td>
<td width="162">
<a href="#" onClick="expandIt('KB1'); return false">${urp.perviewName }</a></td>
</tr></table>
</div>

<div id="KB1Child" class="child">
<c:forEach items="${treelist}" var="urpp">
<c:if test="${urp.perviewId==urpp.perId }">
<table width="190" border=0 cellpadding="0" cellSpacing=0>
<tr>
<td width="8"><img src="../images/ftv2vertline.gif"></td>
<td width="8"><img src="../images/ftv2node.gif" width="16" height="22"></td>
<td width="16"><img src="../images/iGenericAttribute.gif" width="16" height="16"></td>
<td width="158" onMouseover="button_over(this);" onMouseout="button_out(this);"><a href="../system/listuser.jsp" target="workspace">${urpp.perviewName }</a></td>
</tr>
</table>
</c:if>
</c:forEach>
</div>

</c:if>



</c:forEach>





</body>
</html>
