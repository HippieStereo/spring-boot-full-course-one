<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
</head>
<body>
	<form method="post" action="putInDB">
		Enter customer ID : <input type="text" name="cid"><br>
		Enter customer Name : <input type="text" name="cname"><br>
		Enter customer Email : <input type="text" name="cemail"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>