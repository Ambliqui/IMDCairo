<%@page contentType="text/html" pageEncoding="UTF-8"  session="false"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body> 
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Detalles Actividad</p></h2>
        </div>
        <form id="formDetalle" action="ActionsServices" class="container">
            <div class="row gutters">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="account-settings">
                                <div class="user-profile">
                                    <input id="idActividad" type="number" name="idActividad" value="${actividad.idActividad}" hidden>
                                    <h5 class="mb-2 text-primary"><c:out value="${actividad.nombre}"/></h5>
                                    <img class="user-avatar" src="resources/images/deportes/${actividad.idActividad}.jpg" width="100%"><br/><br/>
                                    <div class="text-right">
                                        <input id="btnVolver" type="submit" class="btn btn-secondary" name="accion" value="Volver" formaction="PrePrincipalServlet">
                                        <input id="btnInscribirse" type="submit" class="btn btn-primary" name="accion" value="Inscribirse">
                                        <select id="metodoPago" name="metodoPago">
                                            <c:forEach items="${clienteSession.metodosPagoCliente}" var="metodo" >
                                                <option id="${metodo.getClass().getSimpleName()} ${metodo.idPago}" value="${metodo.idPago}"><c:out value="${metodo.getClass().getSimpleName()} ${metodo.idPago}"/></option>
                                            </c:forEach>
                                        </select>
                                        <c:forEach items="${errores}" var="error">
                                            <c:out value="${error.getMessage()}"/><br/>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <h6 class="mb-2 text-primary">Detalles Actividad</h6>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="entrenador">Entrenador</label>
                                    <input type="text" class="form-control" id="entrenador" value="${actividad.idEntrenadorActividad.nombreEntrenador} ${actividad.idEntrenadorActividad.apellido1Entrenador}" disabled>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="lugar">Localización</label>
                                    <input type="text" class="form-control" id="lugar" value="${actividad.lugar}" disabled>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 form-group">
                                    <label for="descripcion">Descripción de la actividad</label>
                                    <input type="text" class="form-control" id="descripcion" value="${actividad.descripcion}" disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>














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