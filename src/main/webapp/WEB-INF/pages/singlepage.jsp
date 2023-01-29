<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公布事項</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
	
	
</head>
<body>

	<div class="container">
		<table width="1200" border="0"
			class="table table-bordered table-condensed">
			<tr>
				<td colspan="2" bgcolor="#CCCCCC">
					<div align="center">
						<strong>公布事項</strong>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="1200" border="0"
						class="table table-bordered table-condensed table-striped table-hover">
						<tr>
							
							<td id="color">
								<div align="center">
									<strong>標題</strong>
								</div>
							</td>
									<td id="color">
								<div align="center">
									<strong>發佈者</strong>
								</div>
							</td>
							<td id="color">
								<div align="center">
									<strong>發佈日期</strong>
								</div>
							</td>

							<td id="color">
								<div align="center">
									<strong>截止日期</strong>
								</div>
							</td>
							
						</tr>
					

						<tr>
							<td>
								<div align="center">${page.title}</div>
							</td>
							<td>
								<div align="center">${page.publisher}</div>
							</td>
							<td>
								<div align="center">${page.publishedDate}</div>
							</td>
							<td>
								<div align="center">${page.expirationDate}</div>
							</td>
						</tr>
					
					</table>
					<table >
						<tr>
							<td>
								<div ><p>${page.content}</p></div>
							</td>
							</tr>
					
					</table>
				</td>
			</tr>
		

		</table>
		<div class="d-flex justify-content-center">
			<button class="btn btn-secondary" type="button" onclick="javascript:location.href='${contextRoot}/index'">回主頁</button>
	</div>
	</div>
</body>
</html>