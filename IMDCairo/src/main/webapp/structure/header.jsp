
<%if(request.getSession().getAttribute("clienteSession") == null){%>
<%@ include file="header_no_login.jsp"%>
<%} else{%>
<%@ include file="header_login.jsp"%>
<%}%>

