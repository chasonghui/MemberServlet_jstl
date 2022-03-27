<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록행</title>
</head>
<body>
	<form action="regmember.do" method="post" id="rform">
		<h2>회원등록</h2>
		<label for="id">아이디</label><input type="text" name="id" id="id"/>
		<label for="pw">비밀번호</label><input type="text" name="pw" id="pw"/>
		<label for="name">이름</label><input type="text" name="name" id="name"/>
		<label for="phone">전화번호</label><input type="text" name="phone" id="phone"/>
		
		<div>
			<input type="reset" value="취소">
			<input type="submit" value="등록">
		</div>
	</form>
	
	<a href="initpage.do">메인화면</a>
</body>
</html>