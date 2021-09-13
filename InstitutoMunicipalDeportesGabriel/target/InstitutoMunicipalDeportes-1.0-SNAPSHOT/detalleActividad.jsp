<%-- 
    Document   : DetalleActividad
    Created on : 07-sep-2021, 13:34:02
    Author     : usuario
--%>

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
        <style>
            div.justified {
                display: flex;
                justify-content: center;
            }

        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand logo" href="launchpage.jsp"><img src="IMG/Flag_of_Sevilla,_Spain.svg.png" alt="logo" width="50" /></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="./PreIndexServlet">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./PreLoginServlet">Desconectar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./CerrarSesionServlet">Mis actividades</a>
                    </li>    
                </ul>
            </div>  
        </nav>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class=" text-center" style="margin-bottom:0">
            <h2>Nombre Actividad Deportiva</h2>
        </div>
        <div class="justified">
            <textarea name="textarea" rows="10" cols="50">Descripción actividad</textarea>
        </div>
        <div class="form-group">
            <button type="submit">Volver</button>
            <button type="submit">Inscribirse</button>
            <label for="pago">Elija método de pago: </label>
            <select id="pago" name="listapago" form="formapago">
                <option value="Tarjeta">Tarjeta</option>
                <option value="Transferencia">Transferencia</option>
            </select>
        </div>
        <footer class="bg-light text-center text-white">

            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2020 Copyright:
                <a class="text-white">Instituto Municipal de Deportes</a>
            </div>
            <!-- Copyright -->
        </footer>

    </body>
</html>