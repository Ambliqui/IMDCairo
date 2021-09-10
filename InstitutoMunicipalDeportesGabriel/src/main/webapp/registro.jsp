<%-- 
    Document   : registro
    Created on : 07-sep-2021, 13:28:33
    Author     : usuario
--%>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Instituto Municipal de Deportes</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery.js"></script>
       <style>

       .container1 {
            margin-top: 70px;
            width: 45%;
            margin-left: 30%;
        }

        /*  Elementos que deben estar en fila */
        .inline-style {
            display: inline-block;
        }
        /*  El texto debe ser correcto */
        .font-position-right{
            text-align: right;
        }
        /*  Botón de registro */
        .register-btn{
            margin-left: 10%;
        }


    </style>
    </head>
    <body class="text-center">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand logo" href="launchpage.jsp"><img src="IMG/Flag_of_Sevilla,_Spain.svg.png" alt="logo" width="50" /></a>
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
            <h2>Datos de Login</h2>
            <form class="form-horizontal" action="./PostRegistroServlet" method="GET">
        <div class="form-group">
            <!--<h2 class = "form-signin-header"> Registrarse </h2>-->
            <!--  class = "sr-only" ocultar la etiqueta -->
            <label for="exampleInputMail" class="col-sm-2 control-label inline-style font-position-right">Correo</label>
            <div class="col-sm-9 inline-style ">
                <input type="email" class="form-control" id="exampleInputMail" placeholder= "Correo electronico" required>
            </div>
        </div>
        <div class="form-group">
            <!--<h2 class = "form-signin-header"> Registrarse </h2>-->
            <label for="exampleInputUsername1" class="col-sm-2 control-label  inline-style font-position-right">Contraseña</label>
            <div class="col-sm-9  inline-style">
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder= "Contraseña" required>
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
</div>
    </body>
    <footer class="bg-light text-center text-white">

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2020 Copyright:
            <a class="text-white">Instituto Municipal de Deportes</a>
        </div>
        <!-- Copyright -->
    </footer>
</html>

