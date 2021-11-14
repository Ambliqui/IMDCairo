<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
    <%@include file="structure/head.jsp"%>
    <body>
        <%@include file="structure/header.jsp"%>
        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include file="structure/sidebar.jsp"%>
            <!-- Page Content  -->
            <div id="content">
                <%@ include file="includePages/form_metodos_pago.jsp" %>
                <%@ include file="botoneras/modificar_metodo_pago.jsp" %>
            </div>
        </div>
    </body>
    <%@ include file="structure/footer.jsp"%>
</html>
