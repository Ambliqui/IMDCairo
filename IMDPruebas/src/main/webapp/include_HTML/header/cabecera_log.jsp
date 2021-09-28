<li class="nav-item">
    <a class="nav-link" href="#">Bienvenido:
        <c:forEach var="sesion" items="${usuarioSesion.usuarioCollection}">
            <c:out value="${sesion.nombreUsuario} ${sesion.apellidosUsuario}"/>
        </c:forEach>
    </a>
</li>
<li class="nav-item"><a class="nav-link" href="CerrarSesionServlet">Desconectar</a></li>
<li class="nav-item"><a class="nav-link" href="#">Datos personales</a></li>
<li class="nav-item"><a class="nav-link" href="PreInscripcionesServlet">Mis actividades</a></li>