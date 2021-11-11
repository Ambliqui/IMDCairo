
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body> 
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Tus Datos Personales</p></h2>
        </div>
        <div class="container">
            <div class="row gutters">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="account-settings">
                                <div class="user-profile">
                                    <div class="user-avatar">
                                        <img src="resources/images/pagina/perfiles/avatar.png" width="100%">
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
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <h6 class="mt-3 mb-2 text-primary">Metodos de Pago</h6>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="accordion accordion-flush" id="accordionFlushExample">
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="flush-headingOne">
                                                <button id="btnTarjeta" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio" name="metodoPago" id="tarjeta" value="tarjeta" checked>
                                                        <label id="lbTarjeta" class="form-check-label" for="tarjeta">
                                                            Tarjeta
                                                        </label>
                                                    </div>
                                                </button>
                                            </h2>
                                            <div id="flush-collapseOne" class="accordion-collapse collapse show" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                                                <div class="accordion-body">
                                                    <div class="form-group">
                                                        <label for="numeroTarjeta">
                                                            <h6>Numero de tarjeta</h6>
                                                        </label>
                                                        <div class="input-group">
                                                            <input id="numeroTarjeta" type="text" name="numeroTarjeta" placeholder="Numero de tarjeta" class="form-control" value="${numeroTarjeta}" required>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-8">
                                                            <div class="form-group">
                                                                <h6>Fecha de caducidad</h6>
                                                                <div class="input-group">
                                                                    <input id="mesTarjeta" type="number" min="01" max="12" placeholder="MM" name="mesTarjeta" class="form-control" value="${mesTarjeta}">
                                                                    <input id="annoTarjeta" type="number" min="00" max="99" placeholder="YY" name="annoTarjeta" class="form-control" value="${annoTarjeta}">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group mb-4"> 
                                                                <h6>CVS</h6>
                                                                <input type="number" min="000" max="999" id="cvsTarjeta" name="cvsTarjeta" class="form-control" value="${cvsTarjeta}">
                                                            </div>
                                                        </div>
                                                    </div>       
                                                </div>
                                            </div>
                                        </div>
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="flush-headingTwo">
                                                <button id="btnPaypal" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio" name="metodoPago" id="paypal" value="paypal">
                                                        <label class="form-check-label" for="paypal">
                                                            PayPal
                                                        </label>
                                                    </div>
                                                </button>
                                            </h2>
                                            <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                                                <div class="accordion-body">
                                                    <h6 class="pb-2">Paypal</h6>
                                                    <div class="form-group">
                                                        <input type="text" name="cuentaPaypal" required class="form-control" placeholder="Inserte cuenta paypal" form="RegistroForm">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="flush-headingThree">
                                                <button id="btnTransferencia" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio" name="metodoPago" id="transferencia" value="transferencia" >
                                                        <label style="display:block;" class="form-check-label" for="transferencia">
                                                            Transferencia
                                                        </label>
                                                    </div>
                                                </button>
                                            </h2>
                                            <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
                                                <div class="accordion-body"><h6>Registra tu numero de cuenta</h6>
                                                    <div class="form-group">
                                                        <input type="text" name="IBAN" required class="form-control" placeholder="Inserte IBAN" form="RegistroForm">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row gutters">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="text-right">
                                            <button type="button" id="submit" name="submit" class="btn btn-secondary">Cancelar</button>
                                            <button type="button" id="submit" name="submit" class="btn btn-primary">Modificar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>