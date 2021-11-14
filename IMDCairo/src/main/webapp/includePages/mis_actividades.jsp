        <main class="container">
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
                    <c:forEach items="${inscripciones}" var="insc">
                        <tr>
                            <td>${insc.actividad.nombre}</td>
                            <td>${insc.actividad.dias}</td>
                            <td>${insc.metodoPago.getClass().getSimpleName()}</td>
                            <td>${insc.metodoPago.getDatos()}</td>
                            <td>${insc.inscripcion.getFechaFormateada()}</td>
                            <td><a class="btn btn-outline-primary" href="./ActionsServices?accion=ModificarActividad&actividad=${insc.actividad.idActividad}&mPago=${insc.metodoPago.idPago}">Modificar</a></td>
                            <td><a class="btn btn-outline-danger" href="./ActionsServices?accion=BajaActividad&actividad=${insc.actividad.idActividad}&mPago=${insc.metodoPago.idPago}">Baja</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </main>
