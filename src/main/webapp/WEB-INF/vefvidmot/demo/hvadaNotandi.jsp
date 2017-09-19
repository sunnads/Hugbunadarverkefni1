<!-- Höfundur: Elvar Kjartansson, elk11@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Hver er notandinn</title>
</head>
<body>

<h1></h1>

<form method="POST" action="/demo/hver">
    Hvað heitirðu? <input name="nafn" type="text" placeholder="Nafn"></input>
    <input type="submit" value="Í lagi" />
</form>

</body>

</html>