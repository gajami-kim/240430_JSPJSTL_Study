<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<h1>Member List Page</h1>
<div class="container-sm">
	<table class="table table-striped-columns">
		<tr>
			<th>id</th>
			<th>email</th>
			<th>age</th>
			<th>phone</th>
			<th>regdate</th>
			<th>lastlogin</th>
		</tr>
		<c:forEach items="${list }" var="mvo">
			<tr>
				<td>${mvo.id }</td>
				<td>${mvo.email }</td>
				<td>${mvo.age }</td>
				<td>${mvo.phone }</td>
				<td>${mvo.regdate }</td>
				<td>${mvo.lastlogin }</td>
			</tr>		
		</c:forEach>		
	</table>
	<a href="../index.jsp"> <button type="button">index로 돌아가기</button> </a>
</div>
</body>
</html>