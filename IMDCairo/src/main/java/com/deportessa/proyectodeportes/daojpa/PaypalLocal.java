/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Paypal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface PaypalLocal {

    void create(Paypal paypal);
    
    void edit(Paypal paypal);

    void remove(Paypal paypal);

    List<Paypal> findAll();

    List<Paypal> findRange(int[] range);

    int count();
    
}
