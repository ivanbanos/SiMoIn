/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utb.simoin.facades;

import com.utb.simoin.entities.Vision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ivan
 */
@Local
public interface VisionFacadeLocal {

    void create(Vision vision);

    void edit(Vision vision);

    void remove(Vision vision);

    Vision find(Object id);

    List<Vision> findAll();

    List<Vision> findRange(int[] range);

    int count();
    
}
