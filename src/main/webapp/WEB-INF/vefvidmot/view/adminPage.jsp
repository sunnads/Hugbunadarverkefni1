<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

    <head>
        <title>Foo'd'bar - Admin innskráning</title>
    </head>

    <body>
        <h1>Admin innskráning</h1>

        <form method="POST" action="/addRestaurant">
            <fieldset>
                <legend>Admin Innskráning</legend>
                <div>
                    <label>Admin:</label>
                    <input name="admin" type="text" placeholder="Admin"/>
                </div>
                <div>
                    <label>Lykilorð:</label>
                    <input name="password" type="password" placeholder="Password"/>
                </div>

                    <input type="submit" value="Skrá inn" />
                </div>
            </fieldset>
        </form>

    </body>

</html>