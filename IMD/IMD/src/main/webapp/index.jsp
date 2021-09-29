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

        <div class="row">
            <c:forEach items="${actividades}" var="actividad">
                <div class="col-sm-4 card card-body">
                    <div class="card-header">${actividad.nombreActividad}</div>
                    <h5 class="card-title">${actividad.lugarActividad}</h5>
                    <p class="card-text">${actividad.descripcionActividad}</p>
                    <a href="PreDetalleServlet?actividad=${actividad.idActividad}" class="btn btn-primary">Detalles</a>
                </div>
            </c:forEach>
        </div>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>