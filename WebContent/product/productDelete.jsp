<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="js/product.js"></script>
</head>
<body>
<div id="wrap" align="center">
	<h1>상품 삭제 - 관리자 페이지</h1>
	<form method="post" action="productDelete.do">
		<input type="hidden" name="code" value="${product.code }">
		<table>
			<tr>
				<td>
					<c:choose>
						<c:when test="${empty product.pictureUrl }">
							<img src="upload/noimage.gif">
						</c:when>
						<c:otherwise>
							<img src="upload/${product.pictureUrl }">
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<table>
						<tr>
							<th style="width: 80px">상품명</th>
							<td><input type="text" name="name" value="${product.name }" size="80"></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><input type="text" name="price" value="${product.price }" size="80"></td>
						</tr>
						<tr>
							<th>설명</th>
							<td><dov style="height: 220px; width: 100%">${product.description}</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<br>
	<input type="submit" value="삭제">
	<input type="button" value="목록" onclick="location.href='productList.do'">
	</form>
</div>
</body>
</html>