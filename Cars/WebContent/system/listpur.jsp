<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta
			http-equiv="Content-Type"
			content="text/html; charset=UTF-8">

		<link
			type="text/css"
			rel="stylesheet"
			href="../css/public.css">
	</head>

		<script
			language="javascript"
			type="text/javascript">
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
			document.getElementById("form1").action='UroleptreeAction!delpre.action';
		}
		function check2(){
			document.getElementById("form1").action='UroleptreeAction!queryAllroles.action';
		}
		function checkAll(){
			var checks=document.getElementById("All");
			var ids=document.getElementsByName("dels");
			for(var i=0;i<ids.length;i++){
				ids[i].checked=checks.checked;
			}
		}


</script>
	<body>
		<form name="pur"
			action="DelPur.do"
			method="post" >
			<table
				class="maintable"
				border="0"
				width="100%"
				cellspacing="0">
				<tr>
					<td background="../images/topBarBg.gif">
						系统管理：权限管理
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



			<table
				class="tablelistcontent"
				width="100%"
				border="1"
				cellspacing="1">
				<tr>
					<th width="27">
						<input
							type="checkbox"
							name="checkbox"
							value="checkbox"
							id="All" onClick="checkAll()"/>
					</th>
					<th>
						权限编号
					</th>
					<th width="521">
						权限
					</th>
					<th>
						修改
					</th>
				</tr>
				<c:forEach items="${perlist }" var="per">
					<tr
						class=Off
						onMouseOut="this.className='Off'"
						onMouseOver="this.className='Up'">
						<td height="24">
							<div align="center">
								<input
									name="dels"
									type="checkbox"
									id="dels"
									value="${per.perviewId }"
									>
							</div>
						</td>
						<td>
							<div align="center">
								${per.perviewId }
							</div>
						</td>
						<td>
							<div align="center">
								${per.perviewName }
							</div>
						</td>

						<td>
							<div align="left">
							</div>
							<div align="center">
								<a href="UroleptreeAction!queryperById?perview.perviewId=${per.perviewId }"><img
										src="../images/edit.gif"
										width="16"
										height="19"
										border="0">
								</a>
							</div>
							<div align="center"></div>
						</td>
					</tr>
				</c:forEach>
			</table>

			<table width="100%">
				<tr>
					<td
						height="40"
						width="28">
						<div align="left"></div>
					</td>
					<td width="591">
						<div align="left">
							<input
								type="submit"
								name="submit"
								value="删除" onClick="check1()">
						</div>
					</td>
					<td width="51">
						<div align="left">
							<p>
								添加权限
							</p>
						</div>
					</td>
					<td width="168">
						<div align="left">
							<input
								type="text"
								name="perview.perviewName" id="cc"
								>
						</div>
					</td>
					<td width="42"> 
						<div align="left">
							<input
								type="submit"
								name="submit"
								value="添加" onClick="check2()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
