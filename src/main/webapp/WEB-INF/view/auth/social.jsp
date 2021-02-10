<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form class="socialLogin" method="post" action="../login">
		<input type="hidden" name="username" value="${sub }">
		<input type="hidden" name="password" value="${sub }">
	</form>
	
	<script>
		let social = document.querySelector(".socialLogin");
		
		social.submit();
	</script>
</body>
</html>