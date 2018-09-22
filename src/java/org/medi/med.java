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
public class med {
    private List<add> addmedi=new ArrayList();

    public List<add> getAddmedi() {
        return addmedi;
    }

    public void setAddmedi(List<add> addmedi) {
        this.addmedi = addmedi;
    }
    /**
     * Creates a new instance of med
     */
    public med() {
        add a=new add();
       addmedi= a.listmedi();
    }
    
}
