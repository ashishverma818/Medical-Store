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
 * @author ashish
 */
@ManagedBean
@RequestScoped
public class vendor {
   
    private List<venadd> addven=new ArrayList();

    public List<venadd> getAddven() {
        return addven;
    }

    public void setAddven(List<venadd> addven) {
        this.addven = addven;
    }
    public vendor()
    {
        venadd a=new venadd();
        addven=a.listven();
        
    }
}
