<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function del() {
		document.getElementById("rform").action = "delmember.do";
		document.getElementById("rform").submit();
	}
	function update() {
		document.getElementById("rform").action = "updatemember.do";
		document.getElementById("rform").submit();
	}
</script>


<title>회원 수정/삭제</title>
</head>
<body>
	<form method="post" id="rform">
		<h2>회원 수정/삭제</h2>
		<label for="id">아이디</label> <input type="text" name="id" id="id"
			value="${param.id}" /> <br> <label for="pw">비밀번호</label> <input
			type="text" name="pass" id="pass" value="${param.pass}" /> <br>
		<label for="name">이름</label> <input type="text" name="name" id="name"
			value="${param.name}" /> <br> <label for="phone">연락처</label> <input
			type="text" name="phone" id="phone" value="${param.phone}" /> <br>
		<input type="button" value="삭제" onclick="del()"> <input
			type="button" value="수정" onclick="update()">
	</form>
</body>
</html>