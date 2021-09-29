<%-- 
    Document   : botonera_detalle
    Created on : 10-sep-2021, 13:51:19
    Author     : Mefisto
--%>

<input type="submit" value="Volver" formaction="PreIndexServlet">
<%if(request.getSession(false) != null){%>
    <%@include file="./detalle_log.jsp"%>
<%}%>