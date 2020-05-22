
<%@ page language="java"
         contentType="text/html; charset=UTF-8"   
         pageEncoding="UTF-8"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> write.jsp </title>
	<style type="text/css">
	
	</style>

	<script type="text/javascript">
	
	</script>
</head>
<body>
	<h1>게시물 리스트</h1>
	
	<form  name="myform" action="/board/insert" >

		아이디: <input type="text" name="userid" value="aa" > <br>
		이름: <input type="text" name="name" value="aa" > <br>
		제목: <input type="text" name="title" value="bb"> <br>
		내용: <input type="text" name="detail"  value="abc"> <br>
		    <input type="submit" value="글올리기"> &nbsp;
		    <input type="reset" value="다시입력">
		    <input type="button" value="목록으로" onclick="history.back();">
	</form>
	
	<p>
	<a href="/home/main">[index]</a> 
	<a href="/board/list">[리스트]</a>
  	
</body>
</html>






