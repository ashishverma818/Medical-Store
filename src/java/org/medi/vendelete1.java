/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.medi;
import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
@ManagedBean
@RequestScoped
public class vendelete1 implements Serializable {

   private String id;
   private String name;
   private String eid;
   private String pn;
   private String vcn;
   private String companyad;
   private String did;
   private String viid;
 
    public String getViid() {
        return viid;
    }

    public void setViid(String viid) {
        this.viid = viid;
    }
 private List<SelectItem> bind1=new ArrayList<SelectItem>();

    public List<SelectItem> getBind1() {
        return bind1;
    }

    public void setBind1(List<SelectItem> bind1) {
        this.bind1 = bind1;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }
    public String getCompanyad() {
        return companyad;
    }

    public void setCompanyad(String companyad) {
        this.companyad = companyad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }
  

    

    public String getVcn() {
        return vcn;
    }

    public void setVcn(String vcn) {
        this.vcn = vcn;
    }
    private String vid;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVeid() {
        return veid;
    }

    public void setVeid(String veid) {
        this.veid = veid;
    }

    public String getVpn() {
        return vpn;
    }

    public void setVpn(String vpn) {
        this.vpn = vpn;
    }

    public String getVconame() {
        return vconame;
    }

    public void setVconame(String vconame) {
        this.vconame = vconame;
    }
    private String vname;
    private String veid;
    private String vpn;
    private String vconame;
    private String vadd;

    public String getVadd() {
        return vadd;
    }

    public void setVadd(String vadd) {
        this.vadd = vadd;
    }
    
  
  @PostConstruct
          public void init()
          {
         
          try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_vendor_id from vendor");
            
            ResultSet rs=pst.executeQuery();
             bind1.clear();
            while(rs.next())
            {
               // add m=new add();
               viid=rs.getString("medicine_vendor_id");
            //m.add(rs.getString("medicine_vendor_id")); 
               System.out.println(viid);
            bind1.add(new SelectItem(""+viid));
         //   list.add(m);
            
           }
            con.close();
          
          }
           // return list;}
            
            catch(Exception e)
            {
        e.printStackTrace();
          }
        }
          
          
   Connection con;
    public List<vendelete1> listven()
        {
            List<vendelete1> list=new ArrayList();
            try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_vendor_id,vendor_name,vendor_email,vendor_phone,company_name,company_address from vendor");
            
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
            vendelete1 v=new vendelete1();
            v.setVid(rs.getString("medicine_vendor_id"));   
            v.setVname(rs.getString("vendor_name"));
            v.setVeid(rs.getString("vendor_email"));
            v.setVpn(rs.getString("vendor_phone"));
            v.setVconame(rs.getString("company_name"));
            v.setVadd(rs.getString("company_address"));
            list.add(v);
            
           }
           
            return list;}
            
            catch(Exception e)
            {
        e.printStackTrace();
          return null;}
        }
   
    public void delete()throws SQLException
    {
     try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("Delete from vendor where medicine_vendor_id=? ");
            pst.setString(1,did);
             pst.executeUpdate();
            /*PreparedStatement pst1=con.prepareStatement("Delete from newmedicine where medicine_vendor_id=? ");
            pst1.setString(1,did);
            pst1.executeUpdate();
            PreparedStatement pst2=con.prepareStatement("Delete from medicines where medicine_vendor_id=? ");
            pst2.setString(1,did);
             pst2.executeUpdate();
             PreparedStatement pst3=con.prepareStatement("Delete from vendorbdetails where medicine_vendor_id=? ");
            pst3.setString(1,did);
             pst3.executeUpdate();
           */
            
         
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Vendor Deleted !!!! " ));
      FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    
        FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
            
           
            con.close();
          
          }
           // return list;}
            
            catch(Exception e)
            {
        e.printStackTrace();
          }
    
    }
    
  
     
    

}