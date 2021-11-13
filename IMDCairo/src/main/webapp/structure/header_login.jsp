<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid" class="collapse navbar-collapse" id="navbarSupportedContent">
            <img src="resources/images/pagina/comun/logo.png" alt="100" width="75"/>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="ActionsServices?accion=Volver">Inicio</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${clienteSession.nombreCliente} ${clienteSession.apellido1Cliente}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="perfil_usuario.jsp">Mi Perfil</a>          
                        <a class="dropdown-item" href="./ActionsServices?accion=MisActividades">Mis Actividades</a>
                        <a class="dropdown-item" href="./ActionsServices?accion=CerrarSesion">Cerrar Sesion</a>
                    </div>
                </li>
            </ul>                   
        </div>
    </nav>
</header>