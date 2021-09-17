<%-- 
    Document   : alta_persona
    Created on : 15-sep-2021, 13:08:38
    Author     : Mefisto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta actividad</h1>
        ${persona.nombre}
        ${persona.apellido}
        ${persona.telefono}
        <form action="PostAltaAficion">
            <label>Nombre</label></br>
            <input type="text" name ="nombre"></br>
            <label>Descripcion</label></br>
            <input type="text" name ="descripcion"></br></br>
            <input type="submit" name="accion" value="Alta Actividad">
            <input type="submit" name="accion" value="Inicio" formnovalidate formaction="MainServlet">
        </form>
    </body>
</html>
