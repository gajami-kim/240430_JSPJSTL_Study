<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 코어를 사용하는 if문 -> cif -->
	<h1>cif 명령어</h1>
	<!-- query String에서 보낸 데이터 받기 (param.key)-->
	
	<h2>step-1에서 보낸 데이터</h2>
	이름 : ${param.name } <br>
	나이 : ${param.age } <br>
	
	<hr>
	
	<c:if test="false">
		<h2>true일 때 실행되는 명령어</h2>
	</c:if>
	
	<c:if test="${param.age <=18 }">
		<h2>${param.name }은 미성년자 입니다.</h2>
	</c:if>
	
	<!-- query String 방식으로 name=과일이름&address=원산지 -->
	<a href="step-3.jsp?name=귤&address=제주">step-3.jsp로 이동</a>
</body>
</html>