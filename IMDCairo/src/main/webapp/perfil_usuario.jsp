
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
                <%@ include file="includePages/form_perfil_usuario.jsp" %>
                <%@ include file="botoneras/modificar_usuario.jsp"%>
            </div>
        </div>
        <%@ include file="structure/footer.jsp"%>
    </body>
</html>