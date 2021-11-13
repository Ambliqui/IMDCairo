<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="es" class="h-100">
    <%@ include file="structure/head.jsp" %>
    <body class="d-flex flex-column h-100">
        <%@ include file="structure/header.jsp" %>
        <div style="height: 5px;" >
            <h2 class="text-center" >Registro</h2>
        </div>
        <section class="flex-shrink-0">
            <div class="container-fluid h-custom">       
                <form id="registroForm" class="row d-flex justify-content-center align-items-start h-75 " action="ActionsServices?accion=Registrar">
                    <div class="container py-5 col-md-8 col-lg-6 col-xl-4 offset-xl-1" >
                        <div class="row mb-4">
                            <div class="col-lg-8 mx-auto text-center">
                                <h4>Datos Personales</h4>
                            </div>
                        </div>
                        <div class="form-outline mb-4">
                            <input id="email" type="email" name="email" value="${email}" hidden>
                            <input id="password" type="password" name="password" value="${password}" hidden>
                            <label class="form-label">Nombre</label>
                            <input type="text" name="nombre" class="form-control" value="${nombre}" placeholder="Introduzca nombre">                                 
                            <div class="form-outline mb-4"> 
                                <label class="form-label">Apellidos</label>
                                <input name="apellidos" type="text" class="form-control" value="${apellidos}" placeholder="Introduzca apellidos">
                                <div class="form-outline mb-4">
                                    <label class="form-label">Telefono</label>
                                    <input type="tel" name="telefono" class="form-control" value="${telefono}" placeholder="Introduzca telefono">
                                </div>
                            </div> 
                        </div>
                        <div class="align-items-center">
                            <input type="submit" name ="accion" value="Registrar" class="btn btn-outline-primary">
                        </div> 
                        <c:forEach items="${errores}" var="error">
                            <c:out value="${error.getMessage()}"/><br/>
                        </c:forEach>
                    </div>
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <div class="container py-5">
                            <div class="row mb-4">
                                <div class="col-lg-8 mx-auto text-center">
                                    <h4>Metodo de pago</h4>
                                </div>
                            </div>

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
            </div>
        </section>
        <%@ include file="structure/footer.jsp" %>   
        <script src="resources/js/acordeon.js"></script>
    </body>
</html>


