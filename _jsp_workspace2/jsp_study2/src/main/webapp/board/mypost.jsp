<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container-sm">
		<h1>Mypost Page</h1>
		<table class="table">
			<tr>			
				<th scope="col">bno</th>
				<th scope="col">title</th>
				<th scope="col">regdate</th>
				<th scope="col">moddate</th>
			</tr>
			<c:forEach items="${postList }" var="bvo">
				<tr class="table-group-divider">
					<td scope="row">${bvo.bno }</td>
					<td> <a href="/brd/detail?bno=${bvo.bno }"> ${bvo.title }</a></td>
					<td>${bvo.writer }</td>
					<td>${bvo.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/brd/register"><button>글쓰기</button></a>
		<a href="../index.jsp"><button>index</button></a>
	</div>
</body>
</html>