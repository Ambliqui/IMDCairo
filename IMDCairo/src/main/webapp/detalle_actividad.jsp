
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


                    <label for="metodoPago">Escoge un metodo de pago</label>
                    <select name="metodoPago" id="metodoPago">
                        <c:forEach items="${clienteSession.metodosPagoCliente}" var="metodo" >
                            <option value="${metodo.idPago}"><c:out value="${metodo.getClass().getName()} ${metodo.idPago}"/></option>
                        </c:forEach>
                    </select>
                    <br><br>
                    <input type="submit" class="btn btn-outline-info" value="Inscribirse">
                </form>
            </article>
        </div>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>