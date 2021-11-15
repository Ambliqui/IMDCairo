/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;


import com.deportessa.proyectodeportes.modelo.Cliente;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.math.BigDecimal;

/**
 *
 * @author pryet
 */
@WebServlet(name = "PruebaDAO", urlPatterns = {"/prueba"})
public class PruebaDAO extends HttpServlet {

    
    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String xxx=controlerManager.getString();
        
        inicializarbbdd();
        
        
        
//        /////////////////// AÑADIR ACTIVIDAD ///////////////////////
//        Actividad jockey = new Actividad("jockey playa", "playa", "comer arena", new BigDecimal(20), "L-Mi-V");
//        Actividad futbol = new Actividad("futbol", "campos de futbol", "pegar patas", new BigDecimal(10), "L-M-Mi");
//        actiDAO.create(jockey);
//        actiDAO.create(futbol);
//
//        /////////////// AÑADIR CLIENTE /////////////////
//
//        Cliente cliente1 = new Cliente("prueba3@email.com", "1234", "paco", "garcia", "666555444");
//        Cliente cliente2 = new Cliente("prueba4@email.com", "1234", "paco2", "perez2", "222222222");
//
//        daoFactoryLocal.getClienteDaoLocal().create(cliente1);
//        daoFactoryLocal.getClienteDaoLocal().create(cliente2);
//
//        /////////////// AÑADIR TARJETA /////////////////
//        Tarjeta t2 = new Tarjeta(123, 5, 2022, 254);
//        Tarjeta t3 = new Tarjeta(345, 12, 2022, 555);
//        Tarjeta t4 = new Tarjeta(678, 12, 2022, 555);
//        
//        Paypal p=new Paypal("prueba@email.com");
//        
//        cliente1.addMPago(t2);
//        cliente1.addMPago(t3);
//        cliente1.addMPago(p);
//        cliente2.addMPago(t4);
//        daoFactoryLocal.getClienteDaoLocal().edit(cliente1);
//        daoFactoryLocal.getClienteDaoLocal().edit(cliente2);
//        try {
//            clienteDAO.edit(cliente1);
//            clienteDAO.edit(cliente2);
//        } catch (Exception ex) {
//            Logger.getLogger(PruebaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        List<MetodoPago> lista2 = clienteDAO.find(1).getMetodosPagoCliente();
//        for (MetodoPago p : lista2) {
//            System.out.println(p);
//        }
//
//        /////////// EDITAR METODO DE PAGO ////////////////////
//        Tarjeta nueva = new Tarjeta(0000, 5, 3000, 258);
//        MetodoPago mp = metodoDAO.find(1);
//        mp.editarMetodoPago(nueva);
//        try {
//            metodoDAO.edit(mp);
//            cliente2 = clienteDAO.find(2);
//            cliente1 = clienteDAO.find(1);
//            clienteDAO.edit(cliente2);
//            clienteDAO.edit(cliente1);
//            clienteDAO.edit(cliente2);
//            clienteDAO.edit(cliente1);
//
//        } catch (Exception ex) {
//            Logger.getLogger(PruebaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        List<MetodoPago> lista3 = cliente1.getMetodosPagoCliente();
//        for (MetodoPago p : lista3) {
//            System.out.println(p);
//        }
////////////// INSCRIPCIONES  /////////////////////////
//        Inscripcion insc = new Inscripcion(futbol, cliente1.getMetodosPagoCliente().get(0));
//        mp=cliente1.getMetodosPagoCliente().get(0);
//        mp.addInscripcion(insc);
//        try {
//            metodoDAO.edit(mp);
//        } catch (Exception ex) {
//            Logger.getLogger(PruebaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(mp.getInscripciones().size());
        
//       List<MetodoPago> mPago= daoFactoryLocal.getClienteDaoLocal().findByEmail("prueba@email.com").get().getMetodosPagoCliente();
//        for (MetodoPago metodoPago : mPago) {
//            System.out.println(metodoPago);
//        }
//        System.out.println(daoFactoryLocal.getPayPalDaoLocal().find(1));
//        System.out.println(daoFactoryLocal.getClienteDaoLocal().findByEmail("prueba@email.com"));
//        
//        System.out.println(clienteDAO.findByEmail("prueba@email.com")) ;
//        System.out.println(clienteDAO.findByEmail("xxx@email.com")) ;
    }
    
    
     private void inicializarbbdd() {
         
        //crear clientes
        Cliente cliente = new Cliente("1@1.com", "1", "George", "Hurtado", "111111111");
        Cliente cliente1 = new Cliente("2@2.com", "1", "Pedro", "Perez", "222222222");
        Cliente cliente2 = new Cliente("3@3.com", "1", "Antonio", "Prieto", "333333333");
        Cliente cliente3 = new Cliente("4@4.com", "1", "Ruben", "Beltran", "444444444");
        Cliente cliente4 = new Cliente("5@5.com", "1", "Agustin", "Morillo", "555555555");
        daoFactoryLocal.getClienteDaoLocal().create(cliente);
        daoFactoryLocal.getClienteDaoLocal().create(cliente1);
        daoFactoryLocal.getClienteDaoLocal().create(cliente2);
        daoFactoryLocal.getClienteDaoLocal().create(cliente3);
        daoFactoryLocal.getClienteDaoLocal().create(cliente4);

        //crear actividades
        Actividad actividad = new Actividad("Fútbol", "Macarena", "El sueño de todo niño iberico, ser como un portugues o como un argentino", new BigDecimal(10), "M-Mi-J");
        Actividad actividad2 = new Actividad("Natación", "Tiro de linea", "Si quieres participar en la pelicula live action de la sirenita este es tu momento", new BigDecimal(11), "M-Mi-J");
        Actividad actividad3 = new Actividad("Ajedrez", "Hytassa", "Con todo lo mejor de Gambito de Dama y Juego de Tronos. Vive la experiencia sin tener plataformas streaming", new BigDecimal(12), "L-M-V");
        Actividad actividad4 = new Actividad("Baloncesto", "San Pablo", "Todo se centra en pasar por el aro. Una bella oda a la vida misma y lo que vas a pasar dia a dia", new BigDecimal(13), "Mi-V");
        Actividad actividad5 = new Actividad("Hockey", "Centro Deportivo Sevilla 3000", "Deporte exotico que solo vemos en las olimpiadas y no conoces a nadie que lo practique. Se tu el primero", new BigDecimal(14), "L-Mi-V");
        Actividad actividad6 = new Actividad("Tenis", "Centro Deportivo Tenis Betis", "Por la tele se ve mas facil, todos quieren ser Rafa Nadal", new BigDecimal(15), "M-Mi-J");
        daoFactoryLocal.getActividadDaoLocal().create(actividad);
        daoFactoryLocal.getActividadDaoLocal().create(actividad2);
        daoFactoryLocal.getActividadDaoLocal().create(actividad3);
        daoFactoryLocal.getActividadDaoLocal().create(actividad4);
        daoFactoryLocal.getActividadDaoLocal().create(actividad5);
        daoFactoryLocal.getActividadDaoLocal().create(actividad6);

        //crear metodo de pago
        Tarjeta t = new Tarjeta(111, 5, 2022, 254);
        Tarjeta t1 = new Tarjeta(222, 2, 2022, 169);
        Tarjeta t2 = new Tarjeta(333, 8, 2023, 555);

        //añadir tarjeta al cliente
        cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente.getEmailCliente()).get();
        cliente.addMPago(t);
        cliente.addMPago(t1);
        daoFactoryLocal.getClienteDaoLocal().edit(cliente);
        cliente1 = daoFactoryLocal.getClienteDaoLocal().findByEmail(cliente1.getEmailCliente()).get();
        cliente1.addMPago(t2);
        daoFactoryLocal.getClienteDaoLocal().edit(cliente1);
        
        //añadir inscripcion
        cliente=daoFactoryLocal.getClienteDaoLocal().find(1);
        cliente1=daoFactoryLocal.getClienteDaoLocal().find(2);
        
        MetodoPago mp=cliente.getMetodosPagoCliente().get(0);
        MetodoPago mp1=cliente.getMetodosPagoCliente().get(1);
        MetodoPago mp3=cliente1.getMetodosPagoCliente().get(0);
        
        
        Inscripcion inscripcion=new Inscripcion(actividad, mp);
        Inscripcion inscripcion2=new Inscripcion(actividad2, mp1);
        Inscripcion inscripcion3=new Inscripcion(actividad3, mp1);
        Inscripcion inscripcion4=new Inscripcion(actividad4, mp3);
        
        
        mp.addInscripcion(inscripcion);
        mp1.addInscripcion(inscripcion2);
        mp1.addInscripcion(inscripcion3);
        mp3.addInscripcion(inscripcion4);
        
        daoFactoryLocal.getMetodoPagoDaoLocal().edit(mp);
        daoFactoryLocal.getMetodoPagoDaoLocal().edit(mp1);
        daoFactoryLocal.getMetodoPagoDaoLocal().edit(mp3);
        

        
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
