<%-- 
    Document   : metodos_pago
    Created on : 13-nov-2021, 12:39:24
    Author     : Mefisto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="row gutters">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <h6 class="mt-3 mb-2 text-primary">Metodos de Pago</h6>
            </div>
            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <c:forEach items="clienteSession.metodosPagoCliente" var="metodoPago">
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
                                            <input id="numeroTarjeta" type="text" name="numeroTarjeta" placeholder="Numero de tarjeta" class="form-control" value="${metodoPago}" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <div class="form-group">
                                                <h6>Fecha de caducidad</h6>
                                                <div class="input-group">
                                                    <input id="mesTarjeta" type="number" min="01" max="12" placeholder="MM" name="mesTarjeta" class="form-control" value="${metodoPago}">
                                                    <input id="annoTarjeta" type="number" min="00" max="99" placeholder="YY" name="annoTarjeta" class="form-control" value="${metodoPago}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="form-group mb-4"> 
                                                <h6>CVS</h6>
                                                <input type="number" min="000" max="999" id="cvsTarjeta" name="cvsTarjeta" class="form-control" value="${metodoPago}">
                                            </div>
                                        </div>
                                    </div>       
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
                        <input id="btnCancelar" type="submit" name="accion" class="btn btn-secondary" value="Cancelar">
                        <input id="btnModificar" type="submit" name="accion" class="btn btn-primary" value="Modificar">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
