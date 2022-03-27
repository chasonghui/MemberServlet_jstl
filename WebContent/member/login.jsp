<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function login(){
		document.getElementById("rform").action="login.do";
		document.getElementById("rform").submit();
	}
</script>
<title>로그인행</title>
</head>
<body>
	<form action="login.do" method="post" id="rform">
		<h2>로그인</h2>
		<label for="id">아이디</label><input type="text" name="id" id="id" /> 
		<label for="pw">비밀번호</label><input type="text" name="pw" id="pw" />
		<div>
			<input type="submit" value="로그인" onclick="login()">
		</div>
	</form>
	<a href="initpage.do">메인화면</a>
</body>
</html>