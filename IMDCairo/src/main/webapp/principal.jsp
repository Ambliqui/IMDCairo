
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="structure/head.jsp" %>
    <body>       
        <%@ include file="structure/header.jsp" %>
        <div style="height: 100px;" >
            <h2 class="text-center" ><p>Nuestros deportes</p></h2>
        </div>        
        <div class="row row-cols-3 row-cols-md-3 g-4" class="card-body" class="col-sm-6">
            <article>
                <img src="img/1.jpeg" alt="300" width="100%"/>
                <h5  class="text-center">Futbol</h5>
                <p>El sueño de todo niño iberico, ser como un portugues o como un argentino.</p>
                <p class="text-center">10 €</p>
                <button type="button" class="btn btn-outline-info">Detalles</button>
            </article>
            <article>
                <img src="img/2.jpg" alt="300" width="100%"/>
                <h5 class="text-center">Natacion</h5>
                <p>Si quieres participar en la pelicula live action de la sirenita este es tu momento.</p>
                <p class="text-center">11 €</p>
                <button type="button" class="btn btn-outline-info">Detalles</button>
            </article>
            <article>
                <img src="img/3.jpg" alt="300" width="100%"/>
                <h5 class="text-center">Ajedrez</h5>
                <p>Con todo lo mejor de Gambito de Dama y Juego de Tronos. Vive la experiencia sin tener plataformas streaming.</p>
                <p class="text-center">12 €</p>
               <button type="button" class="btn btn-outline-info">Detalles</button>
            </article>
             <article>
                <img src="img/4.jpg" alt="300" width="100%"/>
                <h5 class="text-center">Baloncesto</h5>
                <p>Todo se centra en pasar por el aro. Una bella oda a la vida misma y lo que vas a pasar dia a dia.</p>
                <p class="text-center">13 €</p>
               <button type="button" class="btn btn-outline-info">Detalles</button>
            </article>
            <article>
                <img src="img/5.jpg" alt="300" width="100%"/>
                <h5 class="text-center">Hockey</h5>
                <p>Deporte exotico que solo vemos en las olimpiadas y no conoces a nadie que lo practique. Se tu el primero.</p>
                <p class="text-center">14 €</p>
               <button type="button" class="btn btn-outline-info">Detalles</button>
            </article>
            <article>
                <img src="img/6.jpg" alt="300" width="100%"/>
                <h5 class="text-center">Tenis</h5>
                <p>Todos quieren ser Rafa Nadal.</p>
                <p class="text-center">15 €</p>
               <button type="button" class="btn btn-outline-info">Detalles</button>
            </article>                      
        </div>
        <c:forEach items="${listaActividades}" var="actividad">
            ${actividad.nombre}
        </c:forEach>
        <%@ include file="structure/footer.jsp" %>
    </body>
</html>
