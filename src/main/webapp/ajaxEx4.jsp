<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<title>Insert title here</title>
<script>
$(document).ready(function() {
	$("#btn-1").click(function() {
		$.ajax({
			type: "post",
			url: "/controller/replies/new",
			contentType: "application/json",
			data: '{"bno":241,"reply":"새 댓글~","replyer":"user01"}',
			complete: function(jqXHR, status) {
				console.log("complete");
				console.log(status);
			}
		});
	});
	$("#btn-2").click(function() {
		$.ajax({
			type: "post",
			url: "/controller/replies/new",
			contentType: "application/json",
			data: '{"reply":"새 댓글~","replyer":"user01"}',
			complete: function(jqXHR, status) {
				console.log("complete");
				console.log(status);
			}
		});
	});
	
	$("#btn-3").click(function() {
		$.ajax({
			type: "post",
			url: "/controller/replies/new",
			contentType: "application/json",
			data: '{"bno":250,"reply":"새 댓글~","replyer":"user01"}'
		}).done(function(data, status, xhr) {
			console.log("등록 성공");
			// console.log(jqXHR.responseText);
			console.log(data);
		}).fail(function() {
			console.log("등록 실패");
		});
	});
	
	$("#btn-4").click(function() {
		$.ajax({
			url: "/controller/replies/pages/241/1",
			type: "get"
		}).done(function(data) {
			console.log(data);
		});
	});
	
	$("#btn-5").click(function() {
		$.ajax({
			method: "put",
			url: "/controller/replies/11",
			data: '{"reply":"수정된 댓글!!!"}',
			contentType: "application/json"
		}).done(function() {
			console.log("수정 완료");
		}).fail(function() {
			console.log("수정 실패");
		});
	});
	
	$("#btn-6").click(function() {
		$.ajax({
			method: "delete",
			url: "/controller/replies/11"
		}).fail(function() {
			console.log("삭제 실패");
		}).done(function() {
			console.log("삭제 완료");
		});
	});
});

</script>
</head>
<body>
<h1>AJAX ex 4</h1>
<div>
<button id="btn-1">댓글 등록 성공</button>
</div>
<div>
<button id="btn-2">댓글 등록 실패</button>
</div>
<div>
<button id="btn-3">댓글 등록 성공 또는 실패</button>
</div>
<div>
<button id="btn-4">댓글 목록</button>
</div>
<div>
<button id="btn-5">댓글 수정</button>
</div>
<div>
<button id="btn-6">댓글 삭제</button>
</div>
</body>
</html>







