<%@ include file="structure/head.jsp" %>
<body>
    <%@ include file="structure/header.jsp" %>
    <div style="height: 5px;" >
        <h2 class="text-center" ><p>Registro</p></h2>
    </div>
    <section class="vh-100">
        <div class="container-fluid h-custom">    
            <div class="row d-flex justify-content-center align-items-center h-75">    
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1" >
                    <form>
                        <div class="form-outline mb-4">
                            <label class="form-label">Nombre</label>
                            <input type="name" class="form-control" placeholder="Introduzca nombre">                                 
                            <div class="form-outline mb-4"> 
                                <label class="form-label">Apellidos</label>
                                <input name="surname" type="text" class="form-control" placeholder="Introduzca apellidos">

                                <div class="form-outline mb-4">
                                    <label class="form-label">Telefono</label>
                                    <input type="phone" class="form-control" placeholder="Introduzca telefono">
                                </div>
                            </div> 
                        </div>
                        <div class="align-items-center">
                            <button type="submit" class="btn btn-outline-success">Registro</button>
                        </div> 
                    </form>                     
                </div>
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <div class="container py-5">
                        <div class="row mb-4">
                            <div class="col-lg-8 mx-auto text-center">
                                <h4>Metodo de pago</h4>
                            </div>
                        </div> 
                        <div class="row">
                            <div class="col-lg-6 mx-auto">
                                <div class="card card-header">
                                        <ul role="tablist" class="nav bg-light nav-pills rounded nav-fill mb-3">
                                            <li class="nav-item"> <a data-toggle="pill" href="#credit-card" class="nav-link active "> <i class="fas fa-credit-card mr-2"></i> Tarjeta de crédito/débito </a> </li>
                                            <li class="nav-item"> <a data-toggle="pill" href="#paypal" class="nav-link "> <i class="fab fa-paypal mr-2"></i> Paypal </a> </li>
                                            <li class="nav-item"> <a data-toggle="pill" href="#net-banking" class="nav-link "> <i class="fas fa-mobile-alt mr-2"></i> Transferencia </a> </li>
                                        </ul>
                                    </div> 
                                    <div class="tab-content">
                                        <div id="credit-card" class="tab-pane fade show active pt-3">
                                            <form role="form" onsubmit="event.preventDefault()">
                                                <div class="form-group"> <label for="cardNumber">
                                                        <h6>Numero de tarjeta</h6>
                                                    </label>
                                                    <div class="input-group"> 
                                                        <input type="text" name="cardNumber" placeholder="Numero de tarjeta" class="form-control " required>                                          
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-8">
                                                        <div class="form-group">
                                                            <h6>Fecha de caducidad</h6>
                                                            <div class="input-group">
                                                                <input type="number" min="01" max="12" placeholder="MM" name="" class="form-control" required> 
                                                                <input type="number" min="00" max="99"placeholder="YY" name="" class="form-control" required> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <div class="form-group mb-4"> 
                                                            <h6>CVS</h6>
                                                            <input type="text" required class="form-control"> 
                                                        </div>
                                                    </div>
                                                </div>       
                                            </form>
                                        </div> 
                                        <div id="paypal" class="tab-pane fade pt-3">
                                            <h6 class="pb-2">Paypal</h6>
                                            <div class="form-group">
                                                <input type="text" required class="form-control" placeholder="Inserte cuenta paypal">
                                            </div>
                                        </div>   
                                        <div id="net-banking" class="tab-pane fade pt-3">
                                            <div class="form-group ">
                                                <h6>Registra tu numero de cuenta</h6>
                                                <div class="form-group">
                                                    <input type="text" required class="form-control" placeholder="Inserte IBAN">
                                                </div>
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
</section>

</body>
</html>


