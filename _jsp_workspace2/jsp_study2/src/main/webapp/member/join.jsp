<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>Member Join Page</h1>
	<form action="/memb/register" method="post">
		id : <input type="text" name="id"> <br>
		pwd : <input type="text" name="pwd"> <br>
		email : <input type="text" name="email"> <br>
		age : <input type="text" name="age"> <br>
		phone : <input type="text" name="phone"> <br>
		<button type="submit">가입하기</button>
	</form>
</div>
</body>
</html>