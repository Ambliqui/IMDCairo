<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html lang="es" class="h-100">
    <%@ include file="structure/head.jsp" %>
    <body class="d-flex flex-column h-100">
        <%@ include file="structure/header.jsp" %>
        <%@ include file="includePages/form_perfil_usuario.jsp" %>
        <%@ include file="botoneras/registrar_usuario.jsp" %>
        <input id="btnSiguiente" type="text" name="accion" form="formPerfilUsuario" value=PrePrincipalServlet hidden>;
        <c:forEach items="${errores}" var="error">
            <c:out value="${error.getMessage()}"/><br/>
        </c:forEach>
        <%@ include file="structure/footer.jsp" %>   
        <script src="resources/js/acordeon.js"></script>
    </body>
</html>


