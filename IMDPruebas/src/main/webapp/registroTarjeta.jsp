<%-- 
    Document   : registroTarjeta
    Created on : 08-sep-2021, 13:10:03
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <%@include file="./include_HTML/header/cabecera.jsp"%>
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
                    <!--<h2 class = "form-signin-header"> Registrarse </h2>-->
                    <label for="exampleInputDate" class="col-sm-2 control-label  inline-style font-position-right">Fecha Caducidad</label>
                    <div class="col-sm-9  inline-style">
                        <input type="date" class="form-control" id="exampleInputDate" placeholder= "fecha caducidad" required>
                    </div>
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <!--<input type="checkbox">
                                                         Recordar contraseña-->
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-lg btn-primary btn-block register-btn" type="submit">Siguiente</button>
                    </div>
                </div>
            </form>
            <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>
