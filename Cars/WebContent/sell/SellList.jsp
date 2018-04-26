<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
		function checkAll(){		
			var checks=document.getElementById("all");
			var ids=document.getElementsByName("tmps");
			for(var i=0;i<ids.length;i++){
				ids[i].checked=checks.checked;
			}
		}
</script>
<body>
	<form action="OrderAction!querobby.action" method=post>
		<table
			class="maintable"
			border="0"
			width="100%"
			cellspacing="0">
			<tr>
				<td background="../images/topBarBg.gif">
					订单列表
				</td>
				<td
					width="20"
					height="23"
					background="images/topBarBg.gif">
					<div align="right">
						<a href="#"><img
								src="images/iHelp.gif"
								width="16"
								height="16"
								border="0">
						</a>
					</div>
				</td>
			</tr>
		</table>


        <p>
          <label>　　　<br>
          　　　　
          <select name="selectn">
            <option value="订单号">订单号</option>
            <option value="客户号">客户号</option>
            <option value="车名称">车名称</option>
            <option value="车类型">车类型</option>
          </select>
          ：          </label>
          <label>
          <input type="text" name="values">
          </label>
      　　　销售时间：
      <label>
      <input type="text" name="orderc.sellDate" id="mailingTime" onClick="show_cele_date(this,'','',this)">
      </label>

      <label>
      <input type="submit" name="Submit" value="查询">
      </label>
      </p>
      </form>
      
        <label></label>
        <p>
          <label></label></p>
        <p>&nbsp;</p>
        ${msgs }
        <form action="OrderAction!delCustomers.action" method="post">
        <table
				class="tablelistcontent"
				width="100%"
				border="1"
				cellspacing="1">
				
				<tr>
					<th width="29">
						<input
							type="checkbox"
							name="all"
							id="all"
							onClick="checkAll()">
					</th>
					<th width="203">
						订单号
					</th>
					<th width="236">
						客户号
					</th>
					<th width="224">
						车名称
					</th>
					<th width="195">
						车类型
					</th>
					<th width="196">
						销售时间
					</th>
					<th width="195">
						状态
					</th>
				</tr>

			
				<c:forEach items="${orderlist }" var="oc">
					<tr
						class=Off
						onMouseOut="this.className='Off'"
						onMouseOver="this.className='Up'">
						<td height="24">
							<div align="center">
								<input
									type="checkbox"
									name="tmps"
									value="${oc.orderId }">
							</div>
						</td>
						<td>
							<div align="center">
								${oc.orderId }
							</div>
						</td>
						<td>
							<div align="center">
								${oc.customerId }
							</div>
						</td>
						<td>
							<div align="center">
								${oc.carName }
							</div>
						</td>
						<td>
							<div align="center">
								${oc.carType }
							</div>
						</td>
						<td>
							<div align="center">
								${oc.sellDate }
							</div>
						</td>
						<td>
							<div align="center">
								<a href="">售出</a>
							</div>
						</td>
					</tr>
			</c:forEach>




	  </table>
	        <p>
	          <input name="submit" type="submit" value="删除">
      </p>
	        <p>&nbsp;        </p>
	</form>
	</body>
</html>
