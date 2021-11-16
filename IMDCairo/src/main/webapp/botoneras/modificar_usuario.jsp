<section class="row gutters">
    <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12"></div>
    <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
        <div class="card-body">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 text-center">
                <input id="btnCancelar" type="submit" name="accion" class="btn btn-primary" form="formPerfilUsuario" formnovalidate formaction="PrePrincipalServlet" value="Volver">
                <input id="btnModificar" type="submit" name="accion" class="btn btn-success" form="formPerfilUsuario" formaction="ActionsServices?accion=Modificar" value="Modificar">
                <input id="btnBaja" type="submit" name="accion" class="btn btn-danger" form="formPerfilUsuario" formaction="ActionsServices?accion=BajaUsuario" value="BajaUsuario">
            </div>
        </div>  
    </div>
</section>