/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.frontController.qualifiers.ModificarMetodoPagoQ;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.modelo.Paypal;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.modelo.Transferencia;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deportessa.proyectodeportes.servicios.ClienteServicio;
import com.deportessa.proyectodeportes.metodosPago.MetodoPagoLocal;
import com.deportessa.proyectodeportes.metodosPago.factory.MetodoPagoFactoryLocal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio
 */
@Stateless
@ModificarMetodoPagoQ
public class ModificarPago implements FrontControlerLocal {

    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Inject
    private ClienteServicio cliServ;

    @Inject
    private MetodoPagoFactoryLocal metodoFactory;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exception> exceptions = new ArrayList<>();

        String tipo = request.getParameter("metodoPago");

        MetodoPago metodoPago;
        Tarjeta tarjeta = null;
        Paypal paypal = null;
        Transferencia transferencia = null;
        Integer idPago;
        Cliente cliente = (Cliente) request.getSession().getAttribute("clienteSession");
        if (request.getParameter("metodoPago").equalsIgnoreCase("tarjeta")) {

            exceptions = metodoFactory.getPagoTarjeta().validar(request, response);
            if (exceptions.isEmpty()) {
                String id = request.getParameter("idTarjeta");
                if (id != "") {
                    idPago = Integer.parseInt(id);
                    metodoPago = daoFactoryLocal.getMetodoPagoDaoLocal().find(idPago);
                    List<MetodoPago> lista = cliente.getMetodosPagoCliente();
                    lista.remove(metodoPago);
                    Integer numeroTarjeta = Integer.parseInt(request.getParameter("numeroTarjeta"));
                    Integer mesTarjeta = Integer.parseInt(request.getParameter("mesTarjeta"));
                    Integer annoTarjeta = Integer.parseInt(request.getParameter("annoTarjeta"));
                    Integer csvTarjeta = Integer.parseInt(request.getParameter("cvsTarjeta"));
                    metodoPago.editarMetodoPago(new Tarjeta(numeroTarjeta, mesTarjeta, annoTarjeta, csvTarjeta));
                    daoFactoryLocal.getMetodoPagoDaoLocal().edit(metodoPago);
                    lista.add(metodoPago);
                    cliente.setMetodosPagoCliente(lista);
                    daoFactoryLocal.getClienteDaoLocal().edit(cliente);
                } else {
                    Integer numeroTarjeta = Integer.parseInt(request.getParameter("numeroTarjeta"));
                    Integer mesTarjeta = Integer.parseInt(request.getParameter("mesTarjeta"));
                    Integer annoTarjeta = Integer.parseInt(request.getParameter("annoTarjeta"));
                    Integer csvTarjeta = Integer.parseInt(request.getParameter("cvsTarjeta"));
                    tarjeta = new Tarjeta(numeroTarjeta, mesTarjeta, annoTarjeta, csvTarjeta);
                    daoFactoryLocal.getTarjetaDaoLocal().create(tarjeta);

                    cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
                    cliente.addMPago(tarjeta);
                    daoFactoryLocal.getClienteDaoLocal().edit(cliente);
                }

            }

//            cliente.addMPago(tarjeta);
        } else if (request.getParameter("metodoPago").equalsIgnoreCase("paypal")) {

            exceptions = metodoFactory.getPagoPayPal().validar(request, response);
            if (exceptions.isEmpty()) {
                String id = request.getParameter("idPaypal");
                if (id != "") {
                    idPago = Integer.parseInt(id);
                    metodoPago = daoFactoryLocal.getMetodoPagoDaoLocal().find(idPago);
                    List<MetodoPago> lista = cliente.getMetodosPagoCliente();
                    lista.remove(metodoPago);
                    String cuentaPaypal = request.getParameter("cuentaPaypal");
                    metodoPago.editarMetodoPago(new Paypal(cuentaPaypal));
                    daoFactoryLocal.getMetodoPagoDaoLocal().edit(metodoPago);
                    lista.add(metodoPago);
                    cliente.setMetodosPagoCliente(lista);
                    daoFactoryLocal.getClienteDaoLocal().edit(cliente);
                } else {
                    paypal = new Paypal(request.getParameter("cuentaPaypal"));
                    cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
                    daoFactoryLocal.getPayPalDaoLocal().create(paypal);

                    cliente.addMPago(paypal);
                    daoFactoryLocal.getClienteDaoLocal().edit(cliente);
                }
            }

        } else {

            exceptions = metodoFactory.getPagoTransferencia().validar(request, response);
            if (exceptions.isEmpty()) {
                String id = request.getParameter("idTransferencia");
                if (id != "") {
                    idPago = Integer.parseInt(id);
                    metodoPago = daoFactoryLocal.getMetodoPagoDaoLocal().find(idPago);
                    List<MetodoPago> lista = cliente.getMetodosPagoCliente();
                    lista.remove(metodoPago);
                    Integer numCuenta = Integer.parseInt(request.getParameter("IBAN"));
                    metodoPago.editarMetodoPago(new Transferencia(numCuenta));
                    daoFactoryLocal.getMetodoPagoDaoLocal().edit(metodoPago);
                    lista.add(metodoPago);
                    cliente.setMetodosPagoCliente(lista);
                    daoFactoryLocal.getClienteDaoLocal().edit(cliente);

                } else {
                    transferencia = new Transferencia(Integer.parseInt(request.getParameter("IBAN")));
                    cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
                    daoFactoryLocal.getTransferenciaDaoLocal().create(transferencia);

                    cliente.addMPago(transferencia);
                    daoFactoryLocal.getClienteDaoLocal().edit(cliente);
                }

            }

        }
        
        cliente = daoFactoryLocal.getClienteDaoLocal().find(cliente.getIdCliente());
        request.setAttribute("errores", exceptions);
        request.setAttribute("clienteSession", cliente);
        return request.getRequestDispatcher("./PreMetodosPagoServlet");

    }

}
