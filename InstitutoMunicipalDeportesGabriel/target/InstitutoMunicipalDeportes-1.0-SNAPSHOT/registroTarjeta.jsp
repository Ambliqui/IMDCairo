<%-- 
    Document   : registroTarjeta
    Created on : 08-sep-2021, 13:10:03
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
                        <a class="nav-link" href="index.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registro.jsp">Register</a>
                    </li>    
                </ul>
            </div>  
        </nav>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class="container1">
            <h2>Registro de Tarjeta</h2>
            <form class="form-horizontal" action="" method="GET">
                <div class="form-group">
                    <!--<h2 class = "form-signin-header"> Registrarse </h2>-->
                    <!--  class = "sr-only" ocultar la etiqueta -->
                    <label for="exampleInputNumber" class="col-sm-2 control-label inline-style font-position-right">Numero tarjeta</label>
                    <div class="col-sm-9 inline-style ">
                        <input type="number" class="form-control" id="exampleInputMail" placeholder= "Nº tarjeta" required>
                    </div>
                </div>
                <div class="form-group">
                    <!--<h2 class = "form-signin-header"> Registrarse </h2>-->
                    <label for="exampleInputDate" class="col-sm-2 control-label  inline-style font-position-right">Fecha Caducidad</label>
                    <div class="col-sm-9  inline-style">
                        <input type="date" class="form-control" id="exampleInputDate" placeholder= "fecha caducidad" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <!--<input type="checkbox">
                                                         Recordar contraseña-->
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-lg btn-primary btn-block register-btn" type="submit">Siguiente</button>
                    </div>

                </div>
            </form>

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
