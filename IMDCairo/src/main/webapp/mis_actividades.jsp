<%-- 
    Document   : actividades
    Created on : 7 sept. 2021, 12:14:24
    Author     : pryet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <main class="container col-8 mt-5">

            <header class="justify-content-end">
                <h1 class=" ">Nuestras Actividades</h1>
                <div class="">
                    <a href="./login">Login</a>
                    <a href="./registro">Registro</a>
                </div>
            </header>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Dias</th>
                        <th>Horario</th>
                        <th>Precio</th>
                        <th></th>
                    </tr>  
                </thead>


                <c:forEach var="act" items="${actividadesDTO}">

                    <tr>
                        <td>${act.nombre}</td>
                        <td>${act.dias}</td>
                        <td>${act.horario}</td>
                        <td>${act.precio}</td>
                        <td><a href="./detalle?indice=${actividadesDTO.indexOf(act)}">Ver mas</a></td>
                    </tr>
                </c:forEach>

                <tr>

                    <td>Nombre</td>
                    <td>Dias</td>
                    <td>Horario</td>
                    <td>Precio</td>
                    <td><a href="./detalle?indice=${actividadesDTO.indexOf(act)}">Ver mas</a></td>
                </tr>


            </table>
        </main>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</html>
