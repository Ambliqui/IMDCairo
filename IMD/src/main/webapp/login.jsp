<%-- 
    Document   : login
    Created on : 07-sep-2021, 13:27:08
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="es">
    <%@include file="./include_HTML/head_bootstrap.jsp"%>
    <body>
        <%@include file="./include_HTML/header/cabecera.jsp"%>
        <h1 class="jumbotron text-center" style="margin-bottom:0">Instituto Municipal de Deportes</h1> 
        <h2 class="text-center text-white pt-5">Login form</h2>
        
        <div id="login">
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-6">
                        <div id="login-box" class="col-md-12">
                            <h3 class="text-center text-info">Login</h3>
                            <form id="login-form" class="form" action="./PostLoginServlet" method="GET">
                                <div class="form-group">
                                    <label for="email" class="text-info">Email</label><br>
                                    <input type="email" name="username" id="email" class="form-control" required>
                                    <label for="password" class="text-info">Password:</label><br>
                                    <input type="password" name="password" id="password" class="form-control" required>
                                    <input type="submit" class="text-info" name="actionLogin" value="Identificate">
                                    <input type ="reset" class="text-info" name="actionLogin"value="Borrar">
                                </div>
                            </form>
                        </div>
                        ${msg}
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="./include_HTML/footer.jsp"%>
</html>

