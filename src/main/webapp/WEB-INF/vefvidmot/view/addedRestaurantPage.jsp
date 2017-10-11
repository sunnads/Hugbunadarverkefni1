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
        <button onclick="/restList">Skoða veitingastaði</button>
    </body>

</html>
