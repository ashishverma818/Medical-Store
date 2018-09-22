/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.medi;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kunal
 */
@ManagedBean
@RequestScoped
public class update1 {
    private List<update2> addmedi=new ArrayList();

    public List<update2> getAddmedi() {
        return addmedi;
    }

    public void setAddmedi(List<update2> addmedi) {
        this.addmedi = addmedi;
    }
    /**
     * Creates a new instance of med
     */
    public update1() {
        update2 a=new update2();
       addmedi= a.updatemedidisplay();
    }
    
}
