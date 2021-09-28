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
        <div class=" text-center" style="margin-bottom:0">
            <h2>Actividades disponibles</h2>
        </div>
        <div class ="container">
            <ul>
                <c:forEach items="${actividades}" var="actividad">
                    <li><a href="PreDetalleServlet?actividad=${actividad.idActividad}">${actividad.nombre}</a> ${actividad.precio}€</li>
                </c:forEach>
            </ul>
        </div>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>
