
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body> 
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Detalles Actividad</p></h2>
        </div>
        <div class="row row-cols-3 row-cols-md-3 g-4" class="card-body" class="col-sm-6">
            <article>
                <form action="PostDetalleServlet">
                    <h5 class="text-center"><c:out value="${actividad.nombre}"/></h5>
                    <img src=resources/images/deportes/${actividad.idActividad}.jpg alt="300" width="100%"/>
                    <p><c:out value="${actividad.descripcion}"/></p>
                    <p class="text-center"><c:out value="${actividad.precio}€"/></p>
                    <button type="button" class="btn btn-outline-info">Inscribirte</button>
                    <input type="submit" value="Inscribirse">
                </form>
            </article>
        </div>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>