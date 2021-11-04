<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<%@ include file="structure/head.jsp" %>
<body>
    <%@ include file="structure/header.jsp" %>
    <div style="height: 10px;" >
        <h2 class="text-center" ><p>Registro</p></h2>
    </div>
    <section>
        <div class="row d-flex justify-content-center align-items-center h-75">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="resources/images/pagina/comun/logo.jpg" alt="100%" width="100%">          
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="PostRegistroUsuarioServlet">
                    <div>
                        <label class="form-label">Email</label>
                        <input name="email" type="email" value="${email}" class="form-control" placeholder="Introduzca email" />
                        <input name="cemail" type="email" value="${cemail}" class="form-control" placeholder="Repite Email"7>
                    </div>
                    <div>
                        <label class="form-label">Password</label>
                        <input name="password" type="password" value="${password}" class="form-control" placeholder="Introduzca password" />
                        <input name="cpassword" type="password" value="${cpassword}" class="form-control" placeholder="Repite Password"/>
                    </div>
                    <div class="align-items-center">
                        <input type="submit" class="link-primary" value="Siguiente"/>
                    </div>
                    <c:forEach items="${errores}" var="error">
                        <c:out value="${error.getMessage()}"/><br/>
                    </c:forEach>
                </form>
            </div>
        </div> 
    </section>
    <%@ include file="structure/footer.jsp" %>
</body>
</html>

