/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades;

import com.utb.simoin.entities.Meta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface MetaFacadeLocal {

    void create(Meta meta);

    void edit(Meta meta);

    void remove(Meta meta);

    Meta find(Object id);

    List<Meta> findAll();

    List<Meta> findRange(int[] range);

    int count();
    
}
