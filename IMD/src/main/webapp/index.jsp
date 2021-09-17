<%-- 
    Document   : launchpage
    Created on : 07-sep-2021, 13:25:18
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <%@include file="./include_HTML/head_bootstrap.jsp"%>
    <body>
        <%@include file="./include_HTML/header/cabecera.jsp"%>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Instituto Municipal de Deportes</h1>
        </div>
        <div class=" text-center" style="margin-bottom:15px">
            <hr>
            <h3>Actividades disponibles</h3>
            <hr>
        </div>
        <div class ="container">
            <ul>
                <div class="row justify-content-center">
                    <div class="col-2">Actividad</div>
                    <div class="col-2 text-center">Localizacion</div>
                    <div class="col-2 text-right">Precio</div>
                </div>
                <c:forEach items="${actividades}" var="actividad">
                    <div class="row justify-content-center">
                        <div class="col-2"><a href="PreDetalleServlet?actividad=${actividad.idActividad}">${actividad.nombreActividad}</a></div>
                        <div class="col-2 text-center">${actividad.lugarActividad}</div>
                        <div class="col-2 text-right">${actividad.precioActividad}€</div>
                    </div>
                </c:forEach>
            </ul>
        </div>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>
