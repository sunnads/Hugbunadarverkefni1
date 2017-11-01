<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
    <title>Foo'd'bar - Veitingastaði bætt við</title>
</head>

<body>
    <h1>Eftirfarandi veitingastað hefur verið bætt við</h1>
    <p>Nafn: ${restaurants.getName()}</p>
    <p>Heimilisfang: ${restaurants.getAddress()}</p>
    <p>Póstnúmer: ${restaurants.getPostCode()}</p>
    <p>Símanúmer: ${restaurants.getPhoneNumber()}</p>
    <p>Gæðakrafa: ${restaurants.getQuality()}</p>
    <p>Tegund: ${restaurants.getType()}</p>
    <p>Matseðill: ${restaurants.getMenuType()}</p>
    <p>Opnunartími: ${restaurants.getOpeningTime()}</p>
    <p>Lokunartími: ${restaurants.getClosingTime()}</p>
    <a method="POST" href="/addRestaurant">Bættu við öðrum veitingarstað</a>
    <a method="POST" href="/restList">Skoða veitingastaði</a>
</body>

</html>
