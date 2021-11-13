<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
    <%@include file="structure/head.jsp"%>
    <body>
        <%@include file="structure/header.jsp"%>
        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include file="structure/sidebar_definitiva.jsp"%>
            <!-- Page Content  -->
            <div id="content">
                <%@ include file="includePages/metodos_pago.jsp" %>
                <%@ include file="botoneras/modificar_usuario.jsp" %>
            </div>
        </div>
    </body>
    <%@ include file="structure/footer.jsp"%>
</html>
