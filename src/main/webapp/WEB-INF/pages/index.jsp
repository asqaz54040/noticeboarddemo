<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>瀏覽公布事項</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<!--引用SweetAlert2.js-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.0/sweetalert2.all.js"></script>
</head>

<body>
	<div class="container">
		<table width="1200" border="0"
			class="table table-bordered table-condensed">
			<tr>
				<td colspan="2" bgcolor="#CCCCCC">
					<div align="center">
						<strong>瀏覽公布事項</strong>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<!-- 請參考 http://kkbruce.tw/Bootstrap/BaseCSS#forms -->
					<div id="heig">
						<form action="${contextRoot}/search" method="Post"
							class="form-inline">
							<strong>搜尋標題: </strong> <label> <input type="text"
								name="title" />
							</label>
							<button class="btn btn-secondary" type="submit">搜尋</button>
							<button class="btn btn-secondary" type="button"
								onclick="javascript:location.href='${contextRoot}/index'">清除結果</button>
						</form>
					</div>
				</td>
				<td>

					<div align="center">
						<a href="${contextRoot}/addpage"><button
								class="btn btn-secondary" type="button">新增公告</button></a>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="1200" border="0"
						class="table table-bordered table-condensed table-striped table-hover">
						<tr>
							<!-- 							<td id="color"> -->
							<!-- 								<div align="center"> -->
							<!-- 									<strong>id</strong> -->
							<!-- 								</div> -->
							<!-- 							</td> -->
							<td id="color">
								<div align="center">
									<strong>標題</strong>
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
							<td id="color">
								<div align="center">
									<strong>修改</strong>
								</div>
							</td>
							<td id="color">
								<div align="center">
									<strong>刪除</strong>
								</div>
							</td>
						</tr>
						<c:forEach var="notelist" items="${dataList}">
							<tr>
								<!-- 								<td> -->
								<%-- 									<div align="center">${notelist.id}</div> --%>
								<!-- 								</td> -->
								<td><a href="${contextRoot}/singlepage?id=${notelist.id}">
										<div align="center">${notelist.title}</div>
								</a></td>
								<td>
									<div align="center">${notelist.publishedDate}</div>
								</td>
								<td>
									<div align="center">${notelist.expirationDate}</div>
								</td>
								<td>
									<div align="center">
										<a href="${contextRoot}/updatepage?id=${notelist.id}"><button
												class="btn btn-secondary" type="button">修改</button></a>
									</div>
								</td>
								<td>
									<div align="center">
										<a href="${contextRoot}/delete?id=${notelist.id}"><button
												class="btn btn-secondary" type="button"
												onclick="delcheck()">刪除</button></a>
									</div>
								</td>
							</tr>

						</c:forEach>
					</table>
				</td>
			</tr>
		</table>

		<div class="btn-container d-flex justify-content-center">
			<div class="btn-group" role="group"
				aria-label="Basic outlined example">
				<c:forEach begin="1" end="${pageCount}" var="p">

					<c:choose>
						<c:when test="${p==pageNumber}">
							<a href="index?pageNumber=${p}"><button type="button"
									class="btn btn-secondary pagebtn disabled">${p}</button></a>
						</c:when>
						<c:otherwise>
							<a href="index?pageNumber=${p}"><button type="button"
									class="btn btn-secondary pagebtn">${p}</button></a>
						</c:otherwise>

					</c:choose>

				</c:forEach>

			</div>
		</div>
		<br>
		<div class=" btn-container2  d-flex justify-content-center">

			<c:if test="${pageNumber > 1}">
				<a href="index?pageNumber=${pageNumber - 1}"><button
						class="btn btn-secondary pagebtn" type="button">上一頁</button></a>
			</c:if>
			<c:if test="${pageNumber < pageCount}">
				<a href="index?pageNumber=${pageNumber + 1}"><button
						class="btn btn-secondary pagebtn" type="button">下一頁</button></a>
			</c:if>
		</div>
	</div>
	<script>
		function delcheck() {
			alert("刪除成功");
		}
	</script>
</body>
</html>