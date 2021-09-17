<%-- 
    Document   : inscripciones
    Created on : 13-sep-2021, 1:32:08
    Author     : Mefisto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./include_HTML/head_bootstrap.jsp"%>
    <body>
        <%@include file="./include_HTML/header/cabecera.jsp"%>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class=" text-center" style="margin-bottom:0">
            <h2>Actividades en las que participo</h2>
        </div>
        <div class ="container">
            ${usuarioSesion.emailLogin}
            ${usuarioSesion.usuario.nombreUsuario}
            <ul>
                <li><a href="detalleActividad.jsp">Futbol</a></li>
                <li><a href="detalleActividad.jsp">Baloncesto</a></li>
                <li><a href="detalleActividad.jsp">Tenis</a></li>
                <li><a href="detalleActividad.jsp">Natacion</a></li>
            </ul>
        </div>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>
