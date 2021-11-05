<%-- 
    Document   : misActividades
    Created on : 4 nov. 2021, 12:23:45
    Author     : pryet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="h-100">
    <%@ include file="structure/head.jsp" %>
    <body class="d-flex flex-column h-100">       

        <%@ include file="structure/header_login.jsp" %>
        <header style="height: 100px;" >
            <h2 class="text-center" > Sus actividades</h2>
        </header>
        
        <main class="container">
            <table class="table table-hover">
                <thead>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Fecha alta</th>
                </thead>
                <tbody>
                    <c:forEach items="${inscripciones}" var="insc">

                        <tr>
                            <td>${insc.actividad.nombre}</td>
                            <td>${insc.actividad.descripcion}</td>
                            <td>${insc.getFechaAlta()}</td>
                        </tr>

                    </c:forEach> 
                </tbody>
            </table>
        </main>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>
