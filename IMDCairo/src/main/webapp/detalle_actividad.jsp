
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <h6 class="mb-2 text-primary">Ficha Actividad</h6>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="entrenador">Entrenador</label>
                                    <input type="text" class="form-control" id="entrenador" value="${actividad.idEntrenadorActividad.nombreEntrenador} ${actividad.idEntrenadorActividad.apellido1Entrenador}" disabled>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="lugar">Dias de actividad</label>
                                    <input type="text" class="form-control" id="lugar" value="${actividad.dias}" disabled>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="lugar">Localización</label>
                                    <input type="text" class="form-control" id="lugar" value="${actividad.lugar}" disabled>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 form-group">
                                    <label for="descripcion">Descripción de la actividad</label>
                                    <textarea id="descripcion" name="descripcion" rows="6" class="form-control" readonly disabled>
                                        ${actividad.descripcion}
                                    </textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>