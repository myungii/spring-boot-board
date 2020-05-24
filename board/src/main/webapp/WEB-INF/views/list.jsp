<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.board.dto.boardDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap 게시판용 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>list.jsp</title>
<style type="text/css">
.container {
	width: 70%;
}
</style>
</head>
<body>

	<div class="container">
		<h2>게시물 리스트</h2>
		<p>자유게시판입니다.</p>
		<div align="right">총 ${total} 개의 게시글이 있습니다.</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번 호</th>
					<th>아이디</th>
					<th>제 목</th>
					<th>조회수</th>
					<th>추천수</th>
					<th>등록날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}" varStatus="st">
					<tr>
						<td>${size-(st.index)}</td>
						<td>${list.userid}</td>
						<td><a href="/board/detail?seq=" ${list.seq}>${list.title}</a></td>
						<td>${list.hit}</td>
						<td>${list.recommend}</td>
						<td>${list.wdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table align="center">
			<tr>
				<td colspan="6"><c:if test="${startpage>10}">
						<a href="/board/list?pageNum=${startpage-10}">이전</a>
					</c:if> <c:forEach var="i" begin="${startpage}" end="${endpage}">
						<c:choose>
							<c:when test="${pageNUM == i}">
								<font style='color: red;'>${i}</font>
							</c:when>
							<c:otherwise>
								<a href="/board/list?pageNum=${i}"> ${i} </a>
							</c:otherwise>
						</c:choose>
					</c:forEach> <c:if test="${endpage<pagecount}">
						<a href="/board/list?pageNum=${startpage+10}">다음</a>
					</c:if></td>
			</tr>
		</table>
		<div align="center">
			<form name="myform" action="/board/list">
				검색 : <select name="keyfield" onchange="clearText();">
					<option value="">선택하세요</option>
					<option value="name"
						<c:if test="${skey.equals('name')}">selected</c:if>>아이디
					</option>
					<option value="title"
						<c:if test="${skey.equals('title')}">selected</c:if>>
						제목</option>
					<option value="content"
						<c:if test="${skey.equals('content')}">selected</c:if>>
						내용</option>
				</select> <input type="text" name="keyword" size=10 value="${sval}">
				<input type="submit" value="검색">
			</form>
		</div>

		<p class="text-right">
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='/board/write'">글쓰기</button>
			<button type="button" class="btn btn-outline-dark"
				onclick="location.href='/home/main'">index</button>
		</p>
	</div>


</body>
</html>