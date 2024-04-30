<!-- import -->
<%@page import="java.util.ArrayList"%>
<%@page import="jstl_study.CarVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		CarVO car = new CarVO("1234","소나타",2000);
		request.setAttribute("car", car); //(변수명, 객체명);
	%>

	<!-- car 객체 출력 -->
	${requestScope.car.name } <br>
	${car.num } <br>
	${car.price } <br>
	
	<%
		ArrayList<CarVO> list = new ArrayList<>();
		list.add(car);
		list.add(new CarVO("1111","그랜저",3000));
		list.add(new CarVO("2222","모닝",1500));
		//request는 선언한 jsp 페이지 안에서만 사용가능함
		request.setAttribute("list", list);
		//session은 모든 jsp에서 사용가능함
		//session.setAttribute("list", list);
	%>
	
	<c:forEach items="${list }" var="carlist" varStatus="i">
		${i.count }. ${carlist.name} / ${carlist.num } / ${carlist.price } <br>
	</c:forEach>
</body>
</html>