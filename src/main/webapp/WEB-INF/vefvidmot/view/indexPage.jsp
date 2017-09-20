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
        <title>Foo´d´bar</title>
    </head>

    <body>
        <h1>Foo´d´bar</h1>
        <form method="POST" action="/search">
            <fieldset>
                <legend>Leit að veitingastað</legend>
                <div>
                    <label>Nafn:</label>
                    <input name="nafnVeitingastad" type="search" placeholder="Nafn á veitingastað"/>
                </div>
                <div>
                    <label>Póstnúmer:</label>
                    <select name="Póstnúmer">
                        <option value="101">101</option>
                        <option value="107">107</option>
                        <option value="105">105</option>
                        <option value="109">109</option>
                        <option value="111">111</option>
                        <option value="200">200</option>
                    </select>
                </div>
                <div>
                    <label>Heimiisfang:</label>
                    <input name="heimilisfang" type="text" placeholder="Austurstræti 10"/>
                </div>
                <div>
                    <label>Gæðaflokkur:</label>
                    <select name="gæðaflokkur">
                        <option value="1">Skyndibitastaður</option>
                        <option value="3">Millifínt</option>
                        <option value="5">Fínt</option>
                    </select>
                </div>
                <div>
                    <label>Matseðil:</label>
                    <select name="matsedil" >
                        <option value="morgunmatur">Morgunmatur</option>
                        <option value="kvoldmatur">Kvöldmatur</option>
                        <option value="hadeigismatur">Hádeigismatur</option>
                        <option value="kaffiogkokur">Kaffi og kökur</option>
                    </select>
                </div>
                <div>
                    <label>Opnunartími:</label>
                    <input name="openingTime" type="time" />
                     -
                    <input name="closingTime" type="time" />
                </div>
                <div>
                    <input type="submit" value="Leita" />
                </div>
            </fieldset>
        </form>

    </body>

</html>