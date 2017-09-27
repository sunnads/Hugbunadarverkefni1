<!-- Höfundur: Elvar Kjartansson, elk11@hi.is -->
<!-- Höfundur: Karítas Sif Halldórsdóttir, ksh18@hi.is -->
<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Niðurstöður leitar</title>
</head>
<body>
    <h1>Foo´d´bar</h1>

    <!-- <h1>Listi:  ${listSize}</h1> -->
    <h2>
        <c:forEach items="${listi}" var="listItem">

            <form id="myForm" action="/info" method="post">
                <input type="hidden" name="item" value= ${listItem} />
                <a href="#" onclick="document.getElementById('myForm').submit();">${listItem.name}</a>
            </form>

            <!-- <a href="/info">${listItem.name}</a> -->
        </c:forEach>
    </h2>

</body>

</html>