<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="web_study_11.ds.JndiDs" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 테이스</title>
</head>
<body>
	<c:set var="con" value="${JndiDs.getConnection()}"></c:set>
	<c:out value="${ con}"></c:out><br>
	<a href="productList.do">상품 리스트로 이동</a>
</body>
</html>