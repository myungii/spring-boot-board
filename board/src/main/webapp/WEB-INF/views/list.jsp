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
<!-- 페이징버튼 -->
<link rel="stylesheet" href="css/bootstrap.css">

<title>list.jsp</title>
<style type="text/css">
.container {
	width: 70%;
}

input:-ms-input-placeholer {
	color: #a8a8a8;
}

input::-webkit-input-placeholder {
	color: #a8a8a8;
}

input::-moz-paceholder {
	color: #a8a8a8;
}

#keyfield {
	font-size: 10pt;
	height: 40px;
	width: 110px;
	padding: 10px;
	border: 1px solid #1b5ac2;
	outline: none;
	float: left;
}

.search_option {
	height: 40px;
	width: 300px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
	float: left;
}

#search_text {
	font-size: 12pt;
	width: 225px;
	height: 38px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: left;
}

#search_button {
	width: 50px;
	height: 100%;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	float: right;
	color: #ffffff;
}

.padding {
	padding-bottom: 10em;
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
					<th></th>
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
						<td>${list.seq}</td>
						<td>${start=start+1}</td>
						<td>${list.userid}</td>
						<td><a href="/board/detail?seq=${list.seq}">${list.title}</a>
							<c:forEach var="r" items="${r}">
								<c:if test="${r.rcnt > 0 && r.seq == list.seq}">
									<font style='color: red;'>[${r.rcnt}]</font>
								</c:if>
							</c:forEach></td>
						<td>${list.hit}</td>
						<td>${list.recommend}</td>
						<td>${list.wdate}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<hr>



		<div class="col-lg-6 offset-lg-5 py-1">
			<ul class="pagination mx-auto">
				<c:if test="${startpage>10}">
					<li class="page-item disabled"><a class="page-link"
						href="/board/list?pageNum=${startpage-10}${returnpage}"
						aria-label="Previous"> <span aria-hidden="true">«</span> <span
							class="sr-only">Previous</span>
					</a></li>
				</c:if>

				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:choose>
						<c:when test="${pageNUM == i}">
							<li class="page-item active"><a class="page-link" href="#"><font
									style='color: blue;'>${i}</font></a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="/board/list?pageNum=${i}${returnpage}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${endpage<pagecount}">
					<li class="page-item disabled"><a class="page-link"
						href="/board/list?pageNum=${startpage+10}${returnpage}"
						aria-label="Next"> <span aria-hidden="true">»</span> <span
							class="sr-only">Next</span>
					</a></li>
				</c:if>
			</ul>
		</div>

		<div class="main_link">
			<p class="text-right">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='/board/write'">글쓰기</button>
				<button type="button" class="btn btn-outline-dark"
					onclick="location.href='/home/main'">index</button>
			</p>
		</div>
		<div class="padding">
			<div class="col-lg-6 offset-lg-3 py-1">
				<form name="myform" action="/board/list">
					<select name="keyfield" id="keyfield" onchange="clearText();">
						<option value="">선택하세요</option>
						<option value="userid"
							<c:if test="${skey.equals('userid')}">selected</c:if>>아이디
						</option>
						<option value="title"
							<c:if test="${skey.equals('title')}">selected</c:if>>제목</option>
						<option value="detail"
							<c:if test="${skey.equals('detail')}">selected</c:if>>
							내용</option>
					</select>

					<div class="search_option">
						<input type="text" id="search_text" name="keyword" value="${sval}"
							placeholder="검색어 입력"> <input type="submit"
							id="search_button" value="검색">
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>