<!-- Höfundur: Elvar Kjartansson, elk11@hi.is -->
<!-- Höfundur: Karítas Sif Halldórsdóttir, ksh18@hi.is -->
<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

    <head>
        <title>Foo'd'bar</title>
        <link rel="stylesheet" type="text/css" href="/css/indexPage.css/"/>
    </head>

    <body>

    <ul class="topnav">
        <li><img src="/css/images/logo.jpg" alt="Logo foodbar"></li>
        <li><a class="active" href="#home">Upphafsíða</a></li>
        <li><a href="#contact">Veitingarstaðir</a></li>
        <li class="right"><a method="POST" href="/admin">Admin innskráning</a></li>
    </ul>


        <div class="header">
            <img class="imageheader" src="/css/images/header.jpg" alt="Food" width="1000" height="300">

            <form class="center" method="POST" action="/search">
                <h1>Foo'd'bar</h1>

                <div class="flex-container">
                    <div class="flex-item">
                        <input name="nafnVeitingastad" type="search" placeholder="Nafn á veitingastað"/>
                    </div>
                    <div class="flex-item">
                        <input name="address" type="search" placeholder="Heimilisfang"/>
                    </div>
                    <div class="flex-item">

                        <select name="postCode">
                            <option value="0">Póstnúmer</option>
                            <option value="101">101</option>
                            <option value="107">107</option>
                            <option value="105">105</option>
                            <option value="109">109</option>
                            <option value="111">111</option>
                            <option value="200">200</option>
                        </select>
                    </div>

                    <div class="flex-item">

                        <select name="quality">
                            <option value="0">Gæðaflokkur</option>
                            <option value="1">Skyndibitastaður</option>
                            <option value="3">Millifínt</option>
                            <option value="5">Fínt</option>
                        </select>
                    </div>
                    <div class="flex-item">
                        <select name="menuType" >
                            <option value="0">Matseðil</option>
                            <option value="Morgunmatur">Morgunmatur</option>
                            <option value="Kvöldmatur">Kvöldmatur</option>
                            <option value="Hádeigismatur">Hádeigismatur</option>
                            <option value="Kaffi og kökur">Kaffi og kökur</option>
                        </select>
                    </div>
                    <div class="flex-item">
                        <input type="submit" value="Leita" />
                    </div>
            </div>

            </form>
        </div>

    </body>

</html>