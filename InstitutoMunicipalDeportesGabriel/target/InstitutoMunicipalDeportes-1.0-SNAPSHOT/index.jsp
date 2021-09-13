<%-- 
    Document   : launchpage
    Created on : 07-sep-2021, 13:25:18
    Author     : usuario
--%>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Instituto Municipal de Deportes</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand logo" href="index.jsp"><img src="IMG/Flag_of_Sevilla,_Spain.svg.png" alt="logo" width="50" /></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="./PreLoginServlet">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./PreRegistroServlet">Register</a>
                    </li>    
                </ul>
            </div>  
        </nav>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class=" text-center" style="margin-bottom:0">
            <h2>Actividades disponibles</h2>
        </div>
        <div class ="container">
            <ul>
                <li><a href="detalleActividad.jsp">Futbol</a></li>
                 <li><a href="detalleActividad.jsp">Baloncesto</a></li>
                 <li><a href="detalleActividad.jsp">Tenis</a></li>
                 <li><a href="detalleActividad.jsp">Natacion</a></li>
            </ul>
        </div>

        <footer class="bg-light text-center text-white">

            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2021 Copyright:
                <a class="text-white">Instituto Municipal de Deportes</a>
            </div>
            <!-- Copyright -->
        </footer>

    </body>
</html>

