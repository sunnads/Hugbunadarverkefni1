<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

    <head>
        <title>Foo'd'bar - Listi af veitingastöðum</title>
    </head>

    <body>
    <c:choose>
        <c:when test="${not empty restaurantList}">
            <table>
                <thead>
                <tr>
                    <th>Nafn</th>
                    <th>Póstnúmer</th>
                    <th>Heimilisfang</th>
                    <th>Símanúmer</th>
                    <th>Gæðiskrafa</th>
                    <th>Tegund</th>
                    <th>Matseðill</th>
                    <th>Opnunartími</th>
                    <th>Lokunartími</th>
                </tr>
                </thead>
                <c:forEach var ="restaurant" items="${restaurantList}">
                    <tr>
                        <td>${restaurant.name} </td>
                        <td>${restaurant.postCode}</td>
                        <td>${restaurant.address}</td>
                        <td>${restaurant.phoneNumber}</td>
                        <td>${restaurant.quality}</td>
                        <td>${restaurant.type}</td>
                        <td>${restaurant.menuType}</td>
                        <td>${restaurant.openingTime}</td>
                        <td>${restaurant.closingTime}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h3> Engir veitingastaðir></h3>
        </c:otherwise>
    </c:choose>

    <a method="POST" href="/addRestaurant">Til baka í bæta við veitingastaði</a>
    <a method="POST" href="/admin">Skrá út</a>
    </body>

</html>
