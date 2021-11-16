<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="container">
    <div style="height: 100px;" >
        <h2 class="text-center" ><p>Mis Actividades</p></h2>
    </div>
    <c:if test="${inscripciones.size() == 0}">
        <p>Aún no te has inscrito en ninguna actividad. <a href="PrePrincipalServlet" class="link-danger">Inscribete aquí</a></p>
    </c:if>
    <table class="table table-hover">
        <thead>
        <th>Actividad</th>
        <th>Horario</th>
        <th>Metodo de pago</th>
        <th>Datos de pago</th>
        <th>Fecha alta</th>
        <th></th>
        <th></th>
        </thead>
        <tbody>
            <c:if test="${inscripciones.size() > 0}">
                <c:forEach items="${inscripciones}" var="insc">
                    <tr>
                        <td>${insc.actividad.nombre}</td>
                        <td>${insc.actividad.dias}</td>
                        <td>${insc.metodoPago.getClass().getSimpleName()}</td>
                        <td>${insc.metodoPago.getDatos()}</td>
                        <td>${insc.inscripcion.getFechaFormateada()}</td>
                        <td><a class="btn btn-outline-success" href="./ActionsServices?accion=ModificarActividad&actividad=${insc.actividad.idActividad}&mPago=${insc.metodoPago.idPago}">Modificar</a></td>
                        <td><a class="btn btn-outline-danger" href="./ActionsServices?accion=BajaActividad&actividad=${insc.actividad.idActividad}&mPago=${insc.metodoPago.idPago}">Baja</a></td>
                    </tr>
                </c:forEach> 
            </c:if>
        </tbody>
    </table>
</main>
