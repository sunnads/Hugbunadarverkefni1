<!-- Höfundur: Brynja Pálína Sigurgeirsdóttir, bps5@hi.is -->
<!-- Höfundur: Elvar Kjartansson, elk11@hi.is -->

<!DOCTYPE html>

<!-- Línan fyrir neðan lagar íslensku stafina -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

    <head>
        <title>Foo'd'bar - Bæta við veitingastað</title>
    </head>

    <body>
        <h1>Bættu við veitingastað hér fyrir neðan</h1>
        <form method="POST" action="/addedRest">
            <fieldset>
                <legend>Grunnupplýsingar</legend>
                <div>
                    <label>Nafn:</label>
                    <input name="addNameRest" type="text" placeholder="Nafn á veitingastað" required/>
                </div>
                <div>
                    <label>Póstnúmer:</label>
                    <input name="addPostCode" type="text" placeholder="Póstnúmer" required/>
                </div>
                <div>
                    <label>Heimiisfang:</label>
                    <input name="addAddress" type="text" placeholder="Heimilisfang" required/>
                </div>
                <div>
                    <label>Símanúmer:</label>
                    <input name="addNumber" type="text" placeholder="Símanúmer" required/>
                </div>
                <div>
                    <label>Gæðaflokkur:</label>
                    <input name="addQuality" type="text" placeholder="Gæðaflokkur"/>
                </div>
                <div>
                    <label>Matseðil:</label>
                    <input name="addMenuType" type="text" placeholder="Matseðill"/>
                </div>
                <div>
                    <label>Tegund:</label>
                    <input name="addType" type="text" placeholder="Tegund matar"/>
                </div>
                <div>
                    <label>Opnunartími Mánudagar:</label>
                    <input name="addOpenMon" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Mánudagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <label>Opnunartími Þriðjudagar:</label>
                    <input name="addOpenTue" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Þriðjudagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <label>Opnunartími Miðvikudagar:</label>
                    <input name="addOpenWed" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Miðvikudagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <label>Opnunartími Fimmtudagar:</label>
                    <input name="addOpenThu" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Fimmtudagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <label>Opnunartími Föstudagar:</label>
                    <input name="addOpenFri" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Föstudagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <label>Opnunartími Laugardagar:</label>
                    <input name="addOpenSat" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Laugardagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <label>Opnunartími Sunnudagar:</label>
                    <input name="addOpenSun" type="text" placeholder="Opnunartími"/>
                </div>
                <div>
                    <label>Lokunartími Sunnudagar:</label>
                    <input name="addCloseMon" type="text" placeholder="Lokunartími" class="spaceAfter"/>
                </div>
                <div>
                    <input type="submit" value="Bæta við veitingastað" />
                </div>
            </fieldset>
        </form>
    </body>
</html>

<style>
    .spaceAfter{
        margin-bottom: 20px;
    }
</style>