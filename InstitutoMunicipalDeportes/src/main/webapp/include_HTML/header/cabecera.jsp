<%-- 
    Document   : cabecera
    Created on : 12-sep-2021, 15:25:42
    Author     : Mefisto
--%>
<%if (request.getSession(false) == null) {%>
    <%@include file="./cabecera_no_log.jsp"%>
<%} else {%>
    <%@include file="./cabecera_log.jsp"%>
<%}%>