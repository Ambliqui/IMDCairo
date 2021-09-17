<%-- 
    Document   : cabecera
    Created on : 12-sep-2021, 15:25:42
    Author     : Mefisto
--%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand logo" href="PreIndexServlet"><img src="src/main/resources/images/Flag_of_Sevilla,_Spain.svg.png" alt="logo" width="50" /></a>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <%if (request.getSession(false) == null) {%>
            <%@include file="./cabecera_no_log.jsp"%>
            <%} else {%>
            <%@include file="./cabecera_log.jsp"%>
            <%}%>
        </ul>
    </div>  
</nav>