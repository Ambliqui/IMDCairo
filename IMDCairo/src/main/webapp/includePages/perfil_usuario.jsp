
<body>
    <div style="height: 100px;" >
        <h2 class="text-center" ><p>Tus Datos Personales</p></h2>
    </div>
    <form id="formPerfilUsuario" action="ActionsServices" class="container">
        <div class="row gutters">
            <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                <div class="card h-100">
                    <div class="card-body">
                        <div class="account-settings">
                            <div class="user-profile">
                                <div class="user-avatar">
                                    <img src="resources/images/pagina/perfiles/avatar.png" width="100%" alt="avatar">
                                </div>
                                <h5 class="user-name"> ${clienteSession.nombreCliente} </h5>
                                <h5 class="user-surname">${clienteSession.apellido1Cliente}</h5>
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
                                <h6 class="mb-2 text-primary">Perfil de Usuario</h6>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label id="formModificar" for="fullName">Nombre</label>
                                    <input id="nombre" type="text" class="form-control" name="nombre" value="${clienteSession.nombreCliente}" placeholder="Nombre">
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label id="lbApellidos" for="apellidos">Apellidos</label>
                                    <input id="apellidos" type="text" class="form-control" name="apellidos" value="${clienteSession.apellido1Cliente}" placeholder="Apellidos">
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label id="lbTelefono" for="telefono">Telefono</label>
                                    <input id="telefono" type="text" class="form-control" name="telefono" value="${clienteSession.telefonoCliente}" placeholder="Telefono">
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label id="lbPassword" for="password">Password</label>
                                    <input id="password" type="password" class="form-control" name="password" value="${clienteSession.passCliente}" placeholder="Password">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>