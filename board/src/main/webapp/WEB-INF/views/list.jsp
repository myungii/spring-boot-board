<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.board.dto.boardDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<h1>게시물 리스트</h1>
	
	<c:forEach var="list" items="${list}">
		<section>
		번호 : ${list.seq}, 아이디 : ${list.userid}, 제목 : ${list.title}, 내용 : ${list.content}
		</section>
		
	</c:forEach>
</body>
</html>