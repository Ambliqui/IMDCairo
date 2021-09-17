<%-- 
    Document   : registroParte2
    Created on : 08-sep-2021, 10:05:53
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
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
        <%@include file="./include_HTML/header/cabecera.jsp"%>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class="container1">
            <h2>Datos personales</h2>
            <form class="form-horizontal" action="./PostRegistro2Servlet">
                <div class="form-group">
                    <!--<h2 class = "form-signin-header"> Registrarse </h2>-->
                    <!--  class = "sr-only" ocultar la etiqueta -->
                    <label for="exampleInputUsername1" class="col-sm-2 control-label inline-style font-position-right">Nombre</label>
                    <div class="col-sm-9 inline-style ">
                        <input type="text" class="form-control" id="exampleInputUsername1" name="nombre" placeholder= "Nombre" required>
                    </div>
                    <label for="exampleInputLastName" class="col-sm-2 control-label  inline-style font-position-right">Apellidos</label>
                    <div class="col-sm-9  inline-style">
                        <input type="text" class="form-control" id="exampleInputLastName" name="apellidos" placeholder= "Apellidos" required>
                    </div>
                    <label for="exampleInputPhone" class="col-sm-2 control-label  inline-style font-position-right">Telefono</label>
                    <div class="col-sm-9  inline-style">
                        <input type="number" class="form-control" id="exampleInputMail" name="telefono" placeholder= "Telefono" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" value="Registrarse">
                        <input type="reset" value="Limpiar">
                    </div>
                </div>
            </form>
        </div>
    </body>
    <%@include file="./include_HTML/footer.jsp"%>
</html>