/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.medi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class vendelete2 {
   private List<vendelete1> addven=new ArrayList();

    public List<vendelete1> getAddven() {
        return addven;
    }

    public void setAddven(List<vendelete1> addven) {
        this.addven = addven;
    }
    /**
     * Creates a new instance of med
     */
    public vendelete2() {
        vendelete1 aven=new vendelete1();
       addven= aven.listven();
    }
 
}