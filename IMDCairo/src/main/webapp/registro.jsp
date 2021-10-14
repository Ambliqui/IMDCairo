<%@ include file="structure/head.jsp" %>
<body>
    <%@ include file="structure/header.jsp" %>
    <div style="height: 10px;" >
        <h2 class="text-center" ><p>Registro</p></h2>
    </div>
    <section>
        <div class="row d-flex justify-content-center align-items-center h-75">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="img/logo.jpg" alt="100%" width="100%">          
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form>
                    <div>
                        <label class="form-label">Email</label>
                        <input type="email" class="form-control"
                               placeholder="Introduzca email" />                                 
                        <div> 
                            <input name="cemail" type="text" class="form-control" placeholder="Repite Email">
                        </div> 
                    </div>
                    <div>
                        <label class="form-label">Password</label>
                        <input type="password" class="form-control"
                              placeholder="Introduzca password" />
                        <div> 
                            <input name="cpassword" type="password" class="form-control" placeholder="Repite Password">
                        </div> 
                    </div>
                    <div class="align-items-center">
                        <p><a href="registro_2.jsp" class="link-danger">Siguiente</a></p>
                    </div> 
                </form>

            </div>
       
        </div> 
    </section>
         <%@ include file="structure/footer.jsp" %>
</body>
</html>

