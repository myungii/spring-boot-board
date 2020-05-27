<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<title>[guest_reply.jsp]</title>
<style type="text/css">
.container {
	width: 80%;
}
</style>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	function replyEdit(rseq, ruserid, rdetail, seq) {
		$("#ruserid" + rseq)
				.html(
						"<input type='text' id='edit_userid"+rseq+"' value='" + ruserid + "' required  size=10>");

		$("#rdetail" + rseq)
				.html(
						"<input type='text' id='edit_detail"+rseq+"' value='" + rdetail + "' required  size=25>");

		$("#rbt" + rseq).html(
				"<input type='button' onClick='replyEditSave(" + rseq + ","
						+ seq + ")' id='btnEdit'  value='수정' size=10>&nbsp;"
						+ "<a href='javascript:location.reload();'>[취소]</a>");
	}//end

	function replyEditSave(rseq, seq) {
		var userid = $("#edit_userid" + rseq).val();
		var detail = $("#edit_detail" + rseq).val();

		location.href = "/reply/edit?rseq=" + rseq + "&ruserid=" + userid
				+ "&rdetail=" + detail + "&seq=" + seq;
	}//end
</script>
</head>
<body>
	<div class="container">

		<form name="frm" method="get" action="/boardreply/insert">
			board_seq <input type="text" name="seq" value="${dto.seq}" readonly><br>

			<div class="id_form">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">아이디</span>
					</div>
					<div class="text_size">
						<input type="text" class="form-control" name="ruserid"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-default">
					</div>
					<div style="margin-left:1em;">
					<button type="submit" name="bt_save" value="저장 " class="btn btn-primary">저장</button>
					</div>
				</div>
				
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">댓글</span>
					</div>
					<textarea name="rdetail" class="form-control"
						aria-label="With textarea"></textarea>
				</div>


			</div>
		</form>
		
		<p>
		<div class="col-lg-6 offset-lg-5 py-1">
			<ul class="pagination mx-auto">
				<c:choose>
					<c:when test="${startpage>0}">
						<li class="page-item"><a class="page-link"
							href="/board/detail?seq=${dto.seq}&pageNum=${pageNUM-1}">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="#">이전</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${pagecount>endpage}">
						<li class="page-item"><a class="page-link"
							href="/board/detail?seq=${dto.seq}&pageNum=${pageNUM+1}">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		<div align="right">총 ${total} 개의 댓글이 있습니다.</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>번 호</th>
					<th>아이디</th>
					<th>댓 글</th>
					<th>등록날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rdto" items="${list}">
					<tr>
						<td>${rdto.seq}</td>
						<td>${start=start+1}</td>
						<td id="ruserid${rdto.rseq}">${rdto.ruserid}</td>
						<td id="rdetail${rdto.rseq}">${rdto.rdetail}</td>
						<td id="rwdate${rdto.rseq}">${rdto.rwdate}</td>
						<td id="rbt${rdto.rseq}" align="right"><input type="button"
							onclick="location.href='/reply/delete?rseq=${rdto.rseq}&seq=${rdto.seq}'"
							value="삭제"> <input type="button"
							onClick="replyEdit('${rdto.rseq}','${rdto.ruserid}','${rdto.rdetail}','${rdto.seq}')"
							value="수정"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>

	</div>

</body>
</html>