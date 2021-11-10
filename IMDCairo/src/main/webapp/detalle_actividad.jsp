
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body> 
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Detalles Actividad</p></h2>
        </div>
        <article class="row row-cols-3 row-cols-md-3 g-4" class="card-body" class="col-sm-6">
            <form id="formDetalle" action="ActionsServices">
                <h5 class="text-center"><c:out value="${actividad.nombre}"/></h5>
                <img src=resources/images/deportes/${actividad.idActividad}.jpg alt="300" width="100%"/>
                <input id="idActividad" type="number" name="idActividad" value="${actividad.idActividad}" hidden>
                <c:out value="${actividad.descripcion}"/></p>
                <p class="text-center"><c:out value="${actividad.precio}€"/></p>
                <c:forEach items="${errores}" var="error">
                    <c:out value="${error.getMessage()}"/><br/>
                </c:forEach>
                <label for="metodoPago">Escoge un metodo de pago</label>
                <select id="metodoPago" name="metodoPago">
                    <c:forEach items="${clienteSession.metodosPagoCliente}" var="metodo" >
                        <option id="${metodo.getClass().getSimpleName()} ${metodo.idPago}" value="${metodo.idPago}"><c:out value="${metodo.getClass().getSimpleName()} ${metodo.idPago}"/></option>
                    </c:forEach>
                </select>
                <br><br>
                <input id="btnVolver" type="submit" class="btn btn-outline-info" name="accion" value="Volver" formaction="PrePrincipalServlet">
                <input id="btnInscribirse" type="submit" class="btn btn-outline-info" name="accion" value="Inscribirse">
            </form>
        </article>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>