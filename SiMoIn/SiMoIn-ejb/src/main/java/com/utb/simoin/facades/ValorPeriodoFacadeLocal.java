/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades;

import com.utb.simoin.entities.ValorPeriodo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface ValorPeriodoFacadeLocal {

    void create(ValorPeriodo valorPeriodo);

    void edit(ValorPeriodo valorPeriodo);

    void remove(ValorPeriodo valorPeriodo);

    ValorPeriodo find(Object id);

    List<ValorPeriodo> findAll();

    List<ValorPeriodo> findRange(int[] range);

    int count();
    
}
