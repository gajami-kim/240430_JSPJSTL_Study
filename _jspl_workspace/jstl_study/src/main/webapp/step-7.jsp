<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <% 
    //post 방식의 한글처리
    request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.customer }님의 주문내역</h1>
	<h3>
		<c:forEach items="${paramValues.burger }" var="order" varStatus="i">
			주문내역 ${i.count } : ${order } <br>
		</c:forEach>
	</h3>
	
	<a href="step-8.jsp">step-8.jsp로 이동</a>
	
	<hr>
	
	<c:forEach items="${list }" var="carlist" varStatus="i">
		${i.count }. ${carlist.name} / ${carlist.num } / ${carlist.price } <br>
	</c:forEach>
</body>
</html>