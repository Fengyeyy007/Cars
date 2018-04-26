<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>


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
						<div class="searchfontlist">销售信息</div> 
					</strong>
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
					<div align="center">
						<span class="tabTitleSel">汽车移库</span></div>
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
			action="CarsAction!carsmovesto.action"
			method="post"
			onSubmit="return subUser()">
			<table
				class="maintable"
				width="100%"
				border="0"
				cellspacing="0">
				<input type="hidden" name="delstockId" value="${car.stockId }"/>
				<tr>
					<td width="104">
						<div align="right">
							汽车编号：						</div>					</td>
					<td
						width="201"
						height="24"><input
							name="cars.carId"
							type="text"
							class="inputcontent"
							id="username"
							value="${car.carId }"
							size="20"
							readonly="true" 
							 />
				    <span class="star">*</span>					</td>
					<td width="473">
															</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							汽车名称：						</div>					</td>
					<td height="24">
						<input
							name="cars.carName"
							type="text"
							class="inputcontent"
							id="test"
							value="${car.carName }"
							size="20"
							maxlength="16"  />
						<span class="star">*</span>					</td>
					<td height="24">
													</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							汽车型号：						</div>					</td>
					<td height="24"><input
							name="cars.carType"
							type="text"
							class="inputcontent"
							id="text"
							value="${car.carType }"
							size="20"
							maxlength="16" />
				    <span class="star">*</span>					</td>
					<td height="24">
													</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">汽车颜色：						</div>					</td>
					<td height="24">
						<input
							name="cars.carColor"
							type="text"
							class="inputcontent"
							id="name"
							value="${car.carColor }"
							size="20">
						<span class="star">*</span>					</td>
					<td height="24">
																</td>
				</tr>
				<tr>
					<td width="104">
						<div align="right">
							所属仓库：						</div>					</td>
					<td
						height="24"
						colspan="2">
						<span class="star"> <select
								name="cars.stockId"
								id="project">
						  <c:forEach items="${stoNlist}" var="sto">
						  <option value="${sto.stockId }">${sto.stockName }</option>
							</c:forEach>	
							</select> *</span>					</td>
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
									>
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
