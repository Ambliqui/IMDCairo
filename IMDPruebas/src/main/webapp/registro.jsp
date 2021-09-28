<%-- 
    Document   : registro
    Created on : 07-sep-2021, 13:28:33
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
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
                margin-top: 10px;
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
        <%@include file="./include_HTML/header/cabecera.jsp"%>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class="container1">
            <h2>Datos de Login</h2>
            <form class="form-horizontal" action="PostRegistroServlet" method="GET">
                <div class="form-group">
                    <label for="exampleInputMail" class="col-sm-2 control-label inline-style font-position-right">Correo:</label>
                    <input type="email" class="form-control col-sm-9 inline-style" id="exampleInputMail" name="email" placeholder= "Correo electronico" required>
                    <label for="exampleInputUsername" class="col-sm-2 control-label inline-style font-position-right">Contraseña:</label>
                    <input type="password" class="form-control col-sm-9 inline-style " id="exampleInputPassword1" name="password" placeholder= "Contraseña" required>
                    <input type="submit" class="col-sm-offset-5 col-sm-7 btn btn-lg btn-primary btn-block register-btn" value="Siguiente">
                </div>
            </form>
        </div>
    </body>
    <%@include file="./include_HTML/footer.jsp"%>
</html>

