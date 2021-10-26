<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid" class="collapse navbar-collapse" id="navbarSupportedContent">
            <img src="img/logo.jpg" alt="100" width="75"/>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="PrePrincipalServlet">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="PreLoginServlet">Login</a>                 
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="PreRegistroUsuarioServlet">Registro</a>                 
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${clienteSession.nombreCliente} ${clienteSession.apellido1Cliente}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Mi Perfil</a>          
                        <a class="dropdown-item" href="#">Cerrar Sesion</a>
                    </div>
                </li>
            </ul>                   
        </div>
    </nav>
</header>