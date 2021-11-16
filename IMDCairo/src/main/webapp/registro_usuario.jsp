<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<%@ include file="structure/head.jsp" %>
<body>
    <%@ include file="structure/header.jsp" %>
    <div style="height:100px;" >
        <h2 class="text-center" ><p>Registro</p></h2>
    </div>
    <section>
        <div class="row d-flex justify-content-center align-items-center h-75">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="resources/images/pagina/comun/logo.png" alt="100%" width="100%">          
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="ActionsServices">
                    <div class="form-outline mb-4">
                        <label class="form-label">Email</label>
                        <input name="email" type="email" value="${email}" class="form-control" placeholder="Introduzca email" />
                        <input name="cemail" type="email" value="${cemail}" class="form-control" placeholder="Repite Email"7>
                    </div>
                    <div class="form-outline mb-4">
                        <label class="form-label">Password</label>
                        <input name="password" type="password" value="${password}" class="form-control" placeholder="Introduzca password" />
                        <input name="cpassword" type="password" value="${cpassword}" class="form-control" placeholder="Repite Password"/>
                    </div>
                    <c:forEach items="${errores}" var="error">
                        <label class="text-danger"><c:out value="${error.getMessage()}"/></label>
                    </c:forEach>
                    <div class="text-center text-lg-start mt-4 pt-2">
                        <input type="submit" name="accion" value="Siguiente" class="btn btn-outline-primary" style="padding-left: 2.5rem; padding-right: 2.5rem;">
                        <p class="small fw-bold mt-2 pt-1 mb-0">¿Tienes cuenta? <a href="PreLoginServlet" class="link-danger">Identificate</a></p>
                    </div>
                </form>
            </div>
        </div> 
    </section>
</body>
<%@ include file="structure/footer.jsp" %>
</html>

