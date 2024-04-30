<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>form 태그로 전달한 파라미터 받기</h1>
	<!-- EL 태그 방식은 내부적으로 형변환을 하여 연산이 가능함. -->
	이름 : ${param.name } <br>
	나이 : ${param.age+1 } <br>
	<hr>
	<!-- 스크립틀릿 방식으로 파라미터 가져오기 -->
	<!-- 파라미터 값을 무조건 문자열로 인식, 연산불가능. 필요에 따라 형변환 해야함 -->
	<%= request.getParameter("name") %>
	<%= request.getParameter("age")+1 %>
	
	<!-- c:if 이용하여 나이가 18이하면 미성년자입니다 출력 -->
	<!-- else 처리 불가능 ! if를 계속해서 줘야함 -->
	<c:if test="${param.age <= 18}">
		<h3>${param.name }은 미성년자 입니다.</h3>
	</c:if>	
	
	<hr>
	
	<!-- choose를 사용하여 다중조건 처리 -->
	<!-- age가 19세 이상은 성인, 15세 이상은 청소년, 5세 이상은 어린이, 나머지는 유아 -->
	<!-- c:when을 통해 값을 주고 / c:otherwise는 디폴트값으로 처리 -->
	<!-- c 태그 내에 주석이 있으면 에러가 발생하는 경우가 있다 -->
	<c:choose>
		<c:when test="${param.age>=19 }">
			<h3>${param.name }님은 ${param.age }세 성인입니다.</h3>
		</c:when>
		<c:when test="${param.age>=15 }">
			<h3>${param.name }님은 ${param.age }세 청소년입니다.</h3>
		</c:when>
		<c:when test="${param.age>=5 }">
			<h3>${param.name }님은 ${param.age }세 어린이입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>${param.name }님은 ${param.age }세 유아입니다.</h3>			
		</c:otherwise>
	</c:choose>
	
	<form action="step-5.jsp">
		<input type="checkbox" name="food" value="바나나">바나나 <br>
		<input type="checkbox" name="food" value="참외">참외 <br>
		<input type="checkbox" name="food" value="딸기">딸기 <br>
		<input type="checkbox" name="food" value="수박">수박 <br>
		<input type="checkbox" name="food" value="복숭아">복숭아 <br>
		<button type="submit">전송</button>
	</form>
</body>
</html>











