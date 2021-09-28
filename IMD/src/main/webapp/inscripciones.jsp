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
                Atributo de peticion:</br>
                ${requestScope.CAI}</br>
                Atributo de peticion recuperado:</br>
                email: ${usuarioPrueba.emailLogin}</br>
                id: ${usuarioPrueba.idUsuarioLogin}</br>
                Atributo de sesion:</br>
                <c:out value="Id: ${usuarioSesion.idUsuarioLogin}"/></br>
                <c:out value="Email: ${usuarioSesion.emailLogin}"/></br>
                Campos asociados:</br>
                <c:forEach var="sesion" items="${usuarioSesion.usuarioCollection}">
                    ${sesion.nombreUsuario}
                </c:forEach>
                <li><a href="detalleActividad.jsp">Futbol</a></li>
                <li><a href="detalleActividad.jsp">Baloncesto</a></li>
                <li><a href="detalleActividad.jsp">Tenis</a></li>
                <li><a href="detalleActividad.jsp">Natacion</a></li>
            </ul>
        </div>
        <%@include file="./include_HTML/footer.jsp"%>
    </body>
</html>
