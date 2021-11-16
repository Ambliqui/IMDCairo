
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
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
                                    <div class="text-center">
                                        <input id="btnVolver" type="submit" class="btn btn-primary" name="accion" value="Volver">
                                        <c:if test="${clienteSession != null}">
                                            <input id="btnInscribirse" type="submit" class="btn btn-success" name="accion" value= "${editar==true?"Cambiar":"Inscribirse"}"><br/><br/>
                                            <select id="metodoPago" name="metodoPago">
                                                <c:forEach items="${clienteSession.metodosPagoCliente}" var="metodo" >
                                                    <option id="${metodo.getClass().getSimpleName()} ${metodo.idPago}" value="${metodo.idPago}"><c:out value="${metodo.getClass().getSimpleName()} ${metodo.idPago}"/></option>
                                                </c:forEach>
                                            </select><br/><br/>
                                            <c:forEach items="${errores}" var="error">
                                                <label class="text-danger"><c:out value="${error.getMessage()}"/></label>
                                            </c:forEach>
                                        </c:if>
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
                                    <label for="localizacion">Localización</label>
                                    <input id="localizacion" type="text" class="form-control" value="${actividad.lugar}" disabled>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="dias">Dias de actividad</label>
                                    <input id="dias" type="text" class="form-control" value="${actividad.dias}" disabled>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="entrenador">Entrenador</label>
                                    <input id="entrenador" type="text" class="form-control" value="${actividad.idEntrenadorActividad.nombreEntrenador} ${actividad.idEntrenadorActividad.apellido1Entrenador}" disabled>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12 form-group">
                                    <label for="entrenador">Precio</label>
                                    <input id="precio" type="text" class="form-control" value="${actividad.precio}€" disabled>
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