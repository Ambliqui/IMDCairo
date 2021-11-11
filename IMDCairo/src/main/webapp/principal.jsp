
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body>       
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Nuestros deportes</p></h2>
        </div>
        <div class="row row-cols-3 row-cols-md-3 g-4" class="card-body" class="col-sm-6">
            <c:forEach items="${listaActividades}" var="actividad">
            <article>
                <img src=resources/images/deportes/${actividad.idActividad}.jpg alt="300" width="100%"/>
                <h5 class="text-center"><c:out value="${actividad.nombre}"/></h5>
                <p><c:out value="${actividad.descripcion}"/></p>
                <p class="text-center"><c:out value="${actividad.precio}€"/></p>
                <button type="button" class="btn btn-outline-info"><a href="PreDetallesServlet?actividad=${actividad.idActividad}">Detalles</a></button>
            </article>
            </c:forEach>                    
        </div>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>
