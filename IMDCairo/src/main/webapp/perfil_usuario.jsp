<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body> 
        <%@ include file="structure/header.jsp" %>
        <div class="container">
            <div class="row gutters">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="account-settings">
                                <div class="user-profile">
                                    <div class="user-avatar">
                                        <img src="resources/images/pagina/perfil/avatar.png" width="100%">

                                    </div>
                                    <h5 class="user-name"> ${clienteSession} </h5>
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
                                        <label for="fullName">Nombre</label>
                                        <input type="text" class="form-control" id="fullName" value="${clienteSession.nombreCliente}" placeholder="Nombre">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="aPellidos">Apellidos</label>
                                        <input type="apellidos" class="form-control" id="aPellidos" value="${clienteSession.apellido1Cliente}" placeholder="Apellidos">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="text" class="form-control" id="phone" value="${clienteSession.telefono}" placeholder="Telefono">
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label for="passWord">Password</label>
                                        <input type="password" class="form-control" id="passWord" value="${clienteSession.password}" placeholder="Password">
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
                                                        <label class="form-check-label" for="tarjeta">
                                                            Tarjeta
                                                        </label>
                                                    </div>
                                                </button>
                                            </h2>
                                            <div id="flush-collapseOne" class="accordion-collapse collapse show" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                                       <div class="accordion-body">
                                            <div class="form-group"> <label for="cardNumber">
                                                    <h6>Numero de tarjeta</h6>
                                                </label>
                                                <div class="input-group">
                                                    <input type="text" id="numeroTarjeta" name="numeroTarjeta" placeholder="Numero de tarjeta" class="form-control" value="${numeroTarjeta}" required>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-8">
                                                    <div class="form-group">
                                                        <h6>Fecha de caducidad</h6>
                                                        <div class="input-group">
                                                            <input type="number" min="01" max="12" placeholder="MM" id="mesTarjeta" name="mesTarjeta" class="form-control" value="${mesTarjeta}">
                                                            <input type="number" min="00" max="99" placeholder="YY" id="annoTarjeta" name="annoTarjeta" class="form-control" value="${annoTarjeta}">
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

