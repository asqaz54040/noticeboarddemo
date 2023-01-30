<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改公佈事項</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<script src="//cdn.ckeditor.com/4.20.1/full/ckeditor.js"></script>
</head>

<body>
	<h3 style="text-align: center;">修改公佈事項</h3>
	<div class="container d-flex justify-content-center">
		<form action="update" method="post"  enctype='multipart/form-data'>
			<table>
				<tr>
					<td><input type="hidden" name="id" value="${page.id}"></td>
				</tr>
				<tr>
					<td><label style="display:inline-block; width:80px;">標題:</label><input type="text" name="title"
						value="${page.title}"></td>
				</tr>
				<tr>
					<td><label style="display:inline-block; width:80px;">發佈日期:</label> <input type="date"
						name="publishedDate" value="${page.publishedDate}"></td>
				</tr>
				<tr>
					<td><label style="display:inline-block; width:80px;">截止日期:</label> <input type="date"
						name="expirationDate" value="${page.expirationDate}"></td>
				</tr>
				<tr>
					<td><label >公佈者:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${page.publisher}</label> <input type="hidden"
						name="publisher" value="${page.publisher}"></td>
				</tr>
					<tr>
					<td><label style="display: inline-block; width: 80px;">附件:${page.attachName}</label>
						<input type="file" name="attach">
					</td>
				</tr>
				<tr>

					<td>公佈內容:<textarea name="content" id="editor">${page.content}</textarea></td>
				<tr>

					<td><button class="btn btn-secondary" type="submit">送出</button></td>
				</tr>

			</table>

		</form>
	</div>
	<div class="d-flex justify-content-center">
		<button class="btn btn-secondary" type="button"
			onclick="javascript:location.href='${contextRoot}/index'">回主頁</button>
	</div>
</body>
<script>
	// CKEDITOR.replace('editor1');
	CKEDITOR.replace('editor', {
		replaceById : true
	});
</script>

</html>