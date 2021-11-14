
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div style="height: 100px;" >
        <h2 class="text-center" ><p>Mis Datos Personales</p></h2>
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
                                <br>
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
                                    <input id="nombre" type="text" class="form-control" name="nombre" 
                                           <c:if test="${clienteSession!=null}">
                                               value="${clienteSession.nombreCliente}" 
                                           </c:if>
                                           <c:if test="${nombre==null}">
                                               value="${nombre}" 
                                           </c:if>

                                           placeholder="Nombre">
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label id="lbApellidos" for="apellidos">Apellidos</label>
                                    <input id="apellidos" type="text" class="form-control" name="apellidos" 
                                           <c:if test="${clienteSession!=null}">
                                               value="${clienteSession.apellido1Cliente}"
                                           </c:if>
                                           <c:if test="${apellidos==null}">
                                               value="${apellidos}" 
                                           </c:if>
                                           placeholder="Apellidos">
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label id="lbTelefono" for="telefono">Telefono</label>
                                    <input id="telefono" type="text" class="form-control" name="telefono" 

                                           <c:if test="${clienteSession!=null}">value="${clienteSession.telefonoCliente}"</c:if>
                                           <c:if test="${telefono==null}">value="${telefono}"</c:if>
                                           placeholder="Telefono">
                                </div>
                            </div>
                            <c:if test="${clienteSession!=null}">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label id="lbPassword" for="password">Password</label>
                                        <input id="password" type="password" class="form-control" name="password" 
                                               <c:if test="${clienteSession!=null}">value="${clienteSession.passCliente}"</c:if>
                                               <c:if test="${password==null}">value="${password}"</c:if>
                                                   placeholder="Password">
                                        </div>
                                    </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <c:forEach items="${errores}" var="error">
                <c:out value="${error.getMessage()}"/><br/>
            </c:forEach>
        </div>
    </form>
</body>