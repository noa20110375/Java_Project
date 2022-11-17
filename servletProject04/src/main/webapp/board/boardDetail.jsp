<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script>
	$(function() {
		$("#delBtn").click(function() {
			if (confirm("정말 삭제할까요?")) {
				location.href = "delete?num=${board.num}"
			}
		})
	})
</script>
<form action = "detail" method = "post">
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Board Detail</h1>
			</div>
			</div>
			<div class="container">


			<input type="hidden" id="num" value="${ad.num }" />
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${ad.num }</td>
			<th>조회수</th>
			<td>${ad.readcount }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${ad.userid }</td>
			<th>작성일</th>
			<td>${ad.regdate }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3">${ad.subject }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3">${ad.content }</td>
		</tr>
	</table>
	<br />
	<button type="button" class="btn btn-primary"
			onclick="location.href='update?num=${ad.num}'">수정</button>
		<button type="button" class="btn btn-secondary" id="delBtn">삭제</button>


	<div class="container mt-5">
		<div class="form-group">
			<label for="comment">Comment:</label>
			<textarea class="form-control" rows="5" id="msg" name="text"></textarea>
		</div>
		<button type="button" class="btn btn-success" id="commentBtn">Comment Write</button>
	</div>
	<div class="mt-5">댓글(<span class ="cntSpan"></span>)</div>
	<div id="result"></div>
			</div>
		</form>

</body>
</html>
<%@ include file="../include/footer.jsp"%>