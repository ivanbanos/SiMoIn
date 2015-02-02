/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades;

import com.utb.simoin.entities.Periodo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface PeriodoFacadeLocal {

    void create(Periodo periodo);

    void edit(Periodo periodo);

    void remove(Periodo periodo);

    Periodo find(Object id);

    List<Periodo> findAll();

    List<Periodo> findRange(int[] range);

    int count();
    
}
