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
<title> detail.jsp </title>
	<style type="text/css">
	
	</style>

	<script type="text/javascript">
	
	</script>
</head>
<body>
	<div class="container">
  <h2>자유게시물</h2>
  <p>나만의 자유로운 게시물을 작성해보세요!</p>            
	<table class="table">
    <thead>
    <tr><th>${dto.title}</th></tr>
      <tr>
        <th>${dto.userid}</th>
        <th>${dto.wdate}</th>
        <th>조회 : ${dto.hit}</th>
        <th>추천 : ${dto.recommend}</th>
      </tr>
    </thead>
    <tbody>
    <tr>
    <td align="right">
    	<a href="/board/list">목록</a> | <a href="#">댓글[0]</a>
    </td>
    <td>
     ${dto.detail}
     </td>
     </tr>
    </tbody>
  </table>
	
	<p>
	<button type="button" class="btn btn-outline-primary" onclick="location.href='/board/write'">글쓰기</button>
	<button type="button" class="btn btn-outline-dark" onclick="location.href='/board.list'">목록</button>
</div>
  	
</body>
</html>






