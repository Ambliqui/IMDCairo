
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body>
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Nuestros deportes</p></h2>
        </div>
        
        <div class="row row-cols-3 row-cols-md-3 g-4" class="card-body" class="col-sm-4">
            <article>
            <img src="img/futbol.jpg" alt="300" width="100%"/>
            <h5  class="text-center">Futbol</h5>
            <p>Deporte en el que aprenden a trabajar en equipo.</p>
            <p class="text-center">199.99 €/año</p>
            <button type="button" class="btn btn-outline-info">Detalles</button>
        </article>
        <article>
            <img src="img/natacion.jpg" alt="300" width="100%"/>
            <h5 class="text-center">Natacion</h5>
            <p>Deporte mas completo para ejercitar todos los musculos.</p>
            <p class="text-center">19,95 €/mes</p>
            <button type="button" class="btn btn-outline-info">Detalles</button>
        </article>

        <article>
            <img src="img/ajedrez.jpg" alt="250" width="88%"/>
            <h5 class="text-center">Ajedrez</h5>
            <p>Deporte en el que se adquiere agilidad mental.</p>
            <p class="text-center">9,95 €/mes</p>
           <button type="button" class="btn btn-outline-info">Detalles</button>
        </article>
            </div>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>
