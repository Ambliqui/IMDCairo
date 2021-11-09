<%-- 
    Document   : misActividades
    Created on : 4 nov. 2021, 12:23:45
    Author     : pryet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="es" class="h-100">
    <%@ include file="structure/head.jsp" %>
    <body class="d-flex flex-column h-100">       

        <%@ include file="structure/header.jsp" %>
        <header style="height: 100px;" >
            <h2 class="text-center" > Sus actividades</h2>
        </header>
        
        <main class="container">
            <table class="table table-hover">
                <thead>
                <th>Actividad</th>
                <th>Metodo de pago</th>
                <th>Datos de pago</th>
                <th>Fecha alta</th>
                <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${inscripciones}" var="insc">

                        <tr>
                            <td>${insc.actividad.nombre}</td>
                            <td>${insc.metodoPago.getClass().getSimpleName()}</td>
                            <td>${insc.metodoPago.getDatos()}</td>
                            <td>${insc.inscripcion.getFechaAlta()}</td>
                            <td><a class="btn btn-outline-danger" href="./baja?actividad=${insc.actividad.idActividad}&mPago=${insc.metodoPago.idPago}">Baja Actividad</a></td>
                        </tr>

                    </c:forEach> 
                </tbody>
            </table>
        </main>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>
