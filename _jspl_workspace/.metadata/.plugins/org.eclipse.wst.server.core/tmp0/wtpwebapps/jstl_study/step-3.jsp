<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>step-2에서 보낸 데이터</h2>
	<h1>상품명 : ${param.name } / 원산지 : ${param.address }</h1>
	<hr>
	
	<h2>
		1. 스크립틀릿 방식으로 파라미터 받기 <br>
		
		<%= request.getParameter("name") %> <br>
		<%= request.getParameter("address") %>
	</h2>
	<hr>
	<h2>
		2. EL 방식으로 파라미터 받기 <br>
		${param.name } <br>
		${param.address }
	</h2>
	<hr>
	
	<!-- form tag로 데이터 전송 -->
	<!-- query String 방식의 전송은 get방식으로 전송을 하여 주소표시줄에 나타남 -->
	<!-- form tag 전송방식은 get / post 방식 중 선택가능 -->
	
	<form action="step-4.jsp">
		이름 : <input type="text" name="name"> <br>
		나이 : <input type="text" name="age"> <br>
		<button type="submit">전송</button>
	</form>
	
	
	
	
</body>
</html>








