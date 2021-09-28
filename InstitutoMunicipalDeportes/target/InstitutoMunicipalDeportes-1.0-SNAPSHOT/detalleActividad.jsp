<%-- 
    Document   : DetalleActividad
    Created on : 07-sep-2021, 13:34:02
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
            <h2>${actividadDetalle.nombre}</h2>
        </div>
        <form action="PostDetalleServlet">
            <div class="justified">
                <fieldset>
                    <legend>Descripcion</legend>
                    ${actividadDetalle.descripcion}
                </fieldset>
            </div>
        <%@include file="./botonera_por_estado/botonera_detalle.jsp"%>    
        </form>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>