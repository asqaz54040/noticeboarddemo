<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>新增公佈事項</title>
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
<%-- <script src="${contextRoot}/uploadfile/plugin.js"></script> --%>
<%-- <script src="${contextRoot}/uploadimage/plugin.js"></script> --%>
</head>

<body>
	<h3 style="text-align: center;">新增公佈事項</h3>
	<div class="container d-flex justify-content-center">
		<form action="add" method="post" enctype='multipart/form-data'>
			<table>

				<tr>
					<td><label style="display: inline-block; width: 80px;">標題:</label>
						<input type="text" name="title" value="test"></td>
				</tr>
				<tr>
					<td><label style="display: inline-block; width: 80px;">發佈日期:</label>
						<input type="date" name="publishedDate"></td>
				</tr>
				<tr>
					<td><label style="display: inline-block; width: 80px;">截止日期:</label>
						<input type="date" name="expirationDate"></td>
				</tr>
				<tr>
					<td><label style="display: inline-block; width: 80px;">上傳附件:</label>
						<input type="file" name="attach"></td>
				</tr>
				<tr>
					<td><label>公佈者:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;administrator</label>
						<input type="hidden" name="publisher" readonly="readonly"
						value="administrator"></td>
				</tr>
				<tr>

					<td>公佈內容:<textarea name="content" id="editor"></textarea></td>
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
	<script>
		var editors = CKEDITOR.replace('editor', {
			replaceById : true,
			extraPlugins : 'uploadimage',
			filebrowserUploadUrl : '${contextRoot}/uploads',
			enterMode : CKEDITOR.ENTER_BR,
			filebrowserUploadMethod : 'form',
			filebrowserUploadParams : {
				'CKEditorFuncNum' : '',
			}
		});

		// 		var editors = CKEDITOR.replace('editor', {
		// 			replaceById : true,
		// 			"filebrowserUploadUrl" : "${contextRoot}/uploads", //要处理的控制器名称
		// 			uiColor: '#ffffff', //工具栏白色,可以删除本行，默认的淡灰白色也很难好看
		// 			enterMode :CKEDITOR.ENTER_BR //换行直接加br
		// 			});
		function save() {
			editors.updateElement(); //非常重要的一句代码
			//前台验证工作
			//提交到后台
			return true;
		}
	</script>
</body>

</html>