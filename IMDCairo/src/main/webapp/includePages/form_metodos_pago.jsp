<div class="row mb-4">
    <div class="col-lg-8 mx-auto text-center">
        <h4>Metodo de pago</h4>
    </div>
</div>
<form id="formMetodosPago">
    <div class="col-md-12 col-lg-12 col-xl-12">
        <div class="container py-5">

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
                                            <input type="number" min="01" max="12" placeholder="MM" id="mesTarjeta" name="mesTarjeta" class="form-control" value="${mesTarjeta}" required>
                                            <input type="number" min="00" max="99" placeholder="YY" id="annoTarjeta" name="annoTarjeta" class="form-control" value="${annoTarjeta}" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group mb-4"> 
                                        <h6>CVS</h6>
                                        <input type="number" min="000" max="999" id="cvsTarjeta" name="cvsTarjeta" class="form-control" value="${cvsTarjeta}" required>
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
                                <input type="text" id="cuentaPaypal" name="cuentaPaypal" class="form-control" placeholder="Inserte cuenta paypal" value="${cuentaPaypal}">
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
                                <input type="text" id="IBAN" name="IBAN" class="form-control" placeholder="Inserte IBAN" value="${IBAN}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
    </div>
</form>