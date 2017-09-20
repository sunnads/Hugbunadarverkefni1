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
        <title>Foo´d´bar</title>
    </head>

    <body>
        <h1>Foo´d´bar</h1>
        <form method="POST" action="/veiw/search">
            <fieldset>
                <legend>Leit að veitingastað</legend>
                <div>
                    <input name="leit" type="text" placeholder="Leit:"></input>
                    <input type="submit" value="Í lagi" />
                </div>
                <div>
                    <input name="leit" type="text" placeholder="Leit:"></input>
                    <input type="submit" value="Í lagi" />
                </div>
            </fieldset>
        </form>

    </body>

</html>