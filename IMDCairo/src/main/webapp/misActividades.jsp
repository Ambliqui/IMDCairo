<%-- 
    Document   : misActividades
    Created on : 4 nov. 2021, 12:23:45
    Author     : pryet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body>       
        <%@ include file="structure/header_login.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Sus actividades</p></h2>
        </div>
        <div class="row row-cols-3 row-cols-md-3 g-4" class="card-body" class="col-sm-6">
            <c:forEach items="${inscripciones}" var="insc">
            <article>
                <p>Fecha de inscripción: ${insc.fechaAltaInscripcion}</p>
                <img src=resources/images/deportes/${insc.actividad.idActividad}.jpg alt="300" width="100%"/>
                <h5 class="text-center"><c:out value="${insc.actividad.nombre}"/></h5>
                <p><c:out value="${insc.actividad.descripcion}"/></p>
                <button type="button" class="btn btn-outline-info"><a href="PreDetallesServlet?actividad=${insc.actividad.idActividad}">Detalles</a></button>
            </article>
            </c:forEach>                    
        </div>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>
