﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="../css/public.css">
</head>


	<body>
		
		<table
			border="0"
			width="100%"
			cellspacing="0">
			<tr>
				<td
					background="images/topBarBg.gif"
					height="23">
					<strong>
						<div class="searchfontlist">

							系统管理∶修改用户
						</div> </strong>
				</td>
			</tr>
		</table>
		<table
			width="100%"
			border="0"
			cellpadding="0"
			cellspacing="0"
			bordercolor="#6490C2">
			<tr>
				<td
					width="25"
					height="24"
					background="images/tab/firstLeftSel.gif">&nbsp;
					
				</td>
				<td
					width="100"
					background="images/tab/middleSel.gif">
					
				</td>
				<td
					width="50"
					background="images/tab/lastRightSel.gif">&nbsp;
					
				</td>
				<td background="images/tab/bg.gif">&nbsp;
					
				</td>
			</tr>
		</table>
		<form
			action="UroleptreeAction!upduserrole.action"
			method="post"
			>
			<input type="hidden" name="uro.userId" value="${userurp.userId }"/>
			<table
				class="maintable"
				width="100%"
				border="0"
				cellspacing="0">
				<tr>
					<td width="104">
						<div align="right">
							用户名：						</div>					</td>
					<td
						width="201"
						height="24">
						<input
							name="uro.loginName"
							type="text"
							class="inputcontent"
							id="username"
							value="${userurp.loginName }"
							size="20"
							readonly="true">
						<span class="star">*</span>					</td>
					<td width="473">
																	</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							用户密码：						</div>					</td>
					<td height="24">
						<input
							name="uro.loginPwd"
							type="password"
							class="inputcontent"
							id="password"
							value="${userurp.loginPwd } "
							size="20"
							maxlength="16" />
						<span class="star">*</span>					</td>
					<td height="24">
															</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							确认密码：						</div>					</td>
					<td height="24">
						<input
							name="ensurePassword"
							type="password"
							class="inputcontent"
							id="ensurePassword"
							value="${userurp.loginPwd }"
							size="20"
							maxlength="16" />
						<span class="star">*</span>					</td>
					<td height="24">
													</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							姓名：						</div>					</td>
					<td height="24">
						<input
							name="uro.userName"
							type="text"
							class="inputcontent"
							id="name"
							value="${userurp.userName }"
							size="20">
						<span class="star">*</span>					</td>
					<td height="24">
												</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							角色：						</div>					</td>
					<td
						height="24"
						colspan="2">
						<select
							name="uro.roleName"
							id="role">
						  <option selected>${userurp.roleName }</option>
						<c:if test="${userurp.roleId!=1 }">
								<option >系统管理员</option>
						</c:if>
						<c:if test="${userurp.roleId!=2 }">
								<option >仓库管理员</option>
						</c:if>
						<c:if test="${userurp.roleId!=3 }">
								<option >销售管理员</option>
						</c:if>	
						<c:if test="${userurp.roleId!=4 }">
								<option >统计管理员</option>
						</c:if>
						<c:if test="${userurp.roleId!=5 }">
								<option >客户管理员</option>
						</c:if>
						</select>
						<span class="star">*</span>					</td>
				</tr>
			</table>
			<table
				align="right"
				width="100%">
				<tr>
					<td
						height="30"
						width="70"></td>
					<td width="65">
						<input
							type="submit"
							name="Submit"
							value="确定">
					</td>
					<td width="96">
						<div align="center">
							<label>
								<input
									type="button"
									name="Submit"
									value="返回"
									onClick="history.back()">
							</label>
						</div>
					</td>
					<td width="60">&nbsp;
						
				  </td>
					<td width="486"></td>
				</tr>
				<tr>
					<td
						height="30"
						colspan="5"
						background="images/tab/bg.gif"></td>
				</tr>
			</table>
			
		</form>
	</body>
</html>
