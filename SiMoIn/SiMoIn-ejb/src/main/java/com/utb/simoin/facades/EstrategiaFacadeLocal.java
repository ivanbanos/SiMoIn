/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades;

import com.utb.simoin.entities.Estrategia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface EstrategiaFacadeLocal {

    void create(Estrategia estrategia);

    void edit(Estrategia estrategia);

    void remove(Estrategia estrategia);

    Estrategia find(Object id);

    List<Estrategia> findAll();

    List<Estrategia> findRange(int[] range);

    int count();
    
}
