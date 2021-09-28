<%-- 
    Document   : inscripciones
    Created on : 13-sep-2021, 1:32:08
    Author     : Mefisto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <ul>
                <c:forEach var="inscripcionesUsuario" items="${inscripcionesUsuario}">
                <li>
                    <a href=PreDetalleServlet?actividad=${inscripcionesUsuario.actividad.idActividad}><c:out value="${inscripcionesUsuario.actividad.nombreActividad}"/></a> ${inscripcionesUsuario.actividad.precioActividad}</br>
                ${inscripcionesUsuario.formaPagoInscripcion.nombreFormaPago}
                </li>
                </c:forEach>
            </ul>
        </div>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>
