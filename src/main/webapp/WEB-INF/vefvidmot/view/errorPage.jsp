<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->
<!-- Höfundur: Karítas Sif Halldórsdóttir, ksh18@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">


<head>
    <title>Villa í slóðinni </title>
    <link rel="stylesheet" type="text/css" href="/css/indexPage.css/"/>
</head>
<body>
    <ul class="topnav">
        <li><img src="/css/images/logo.jpg" alt="Logo foodbar"></li>
        <li><a href="/index">Til baka á forsíðu</a></li>

    </ul>

    <h2>Úps! Eitthvað fór úrskeiðis, reyndu aftur!!</h2>
    <div>
        <h3>HTTP ${attrs.status} ${attrs.error}</h3>
        <p> ${attrs.message}</p>
    </div>

</body>

</html>