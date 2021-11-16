<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
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
                        <img src="resources/images/pagina/comun/logo.png" alt="100%" width="100%">          
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <form action="ActionsServices">
                            <div class="form-outline mb-4">
                                <label class="form-label">Email</label>
                                <input type="email" name="email" class="form-control form-control-lg" value="${email}"
                                       placeholder="Introduzca email" />                              
                            </div>
                            <div class="form-outline mb-3">
                                <label class="form-label">Password</label>
                                <input type="password" name="password" class="form-control form-control-lg" value="${password}"
                                       placeholder="Introduzca password" />
                            </div>
                            <!-- TODO: Revisar ubicacion -->
                            <c:forEach items="${errores}" var="error">
                                <label class="text-danger"><c:out value="${error.getMessage()}"/></label>
                            </c:forEach>
                            <div class="text-center text-lg-start mt-4 pt-2">
                                <input type="submit" name="accion" value="Login" class="btn btn-outline-primary" style="padding-left: 2.5rem; padding-right: 2.5rem;"></input>
                                <p class="small fw-bold mt-2 pt-1 mb-0">¿No tienes cuenta? <a href="ActionsServices?accion=PreRegistro" class="link-danger">Registrate</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>  
            <%@ include file="structure/footer.jsp" %>
        </section>
    </body>
</html>