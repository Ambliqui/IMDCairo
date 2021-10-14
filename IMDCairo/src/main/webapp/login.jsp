<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body>
        <%@ include file="structure/header.jsp" %>
        <div style="height:100px;" >
            <h2 class="text-center" ><p>Login</p></h2>
        </div>
        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="img/logo.jpg" alt="100%" width="100%">          
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form>
                            <div class="form-outline mb-4">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control form-control-lg"
                                       placeholder="Introduzca email" />                              
                            </div>
                            <div class="form-outline mb-3">
                                <label class="form-label">Password</label>
                                <input type="password" class="form-control form-control-lg"
                                       placeholder="Introduzca password" />
                            </div>
                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button type="button" class="btn btn-outline-info""
                                        style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                                <p class="small fw-bold mt-2 pt-1 mb-0">¿No tienes cuenta? <a href="registro.jsp"
                                                                                              class="link-danger">Registrate</a></p>
                            </div>
                        </form>
                    </div>
                   
                </div>
            </div>  
        <%@ include file="structure/footer.jsp" %>
    </section>
 

</body>
</html>