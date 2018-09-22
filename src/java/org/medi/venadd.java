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
import org.primefaces.event.RowEditEvent;
@ManagedBean
@RequestScoped
public class venadd implements Serializable {

   private String id;
    private String name;
   private String eid;
   private int pn;

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }
   private String vcn;
   private String companyad;


   
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
          
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select medicine_vendor_id from vendor order by medicine_vendor_id desc limit 1");
          rs.next();
            setId(""+(rs.getInt("medicine_vendor_id")+1));
                   

            con.close();}
              
               catch(Exception e)
            {
        e.printStackTrace();
          }
          
        }
          
          
   Connection con;
    public List<venadd> listven()
        {
            List<venadd> list=new ArrayList();
            try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_vendor_id,vendor_name,vendor_email,vendor_phone,company_name,company_address from vendor");
            
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                venadd v=new venadd();
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
    
    private String chkid;
    private String chkemail;
    private String chkphone;
    private int flag=0;
    public void addvendor() throws SQLException
    
    { 
        try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
       PreparedStatement pst1=con.prepareStatement("select medicine_vendor_id,vendor_email,vendor_phone from vendor");
     ResultSet rs=pst1.executeQuery();
     while(rs.next())
     {
     chkid=rs.getString("medicine_vendor_id");
        chkemail=rs.getString("vendor_email");
          chkphone=rs.getString("vendor_phone");


if(chkemail.equals(eid))
{
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Email-ID Already Exists !!!! " ));
flag=1;
con.close();
}
else
{
if(chkphone.equals(pn))
{
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Contact number Already Exists !!!! " ));
flag=1;
con.close();

}
}
}
     

if(flag==0)
{
           
           PreparedStatement pst=con.prepareStatement("INSERT INTO vendor VALUES(?,?,?,?,?,?)");
           
         pst.setString(1,id);
         pst.setString(2,name);
         pst.setString(3,eid);
       
         pst.setInt(4,pn);
         pst.setString(5,vcn);
        pst.setString(6,companyad);
        
        
               pst.execute();
        
        
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("New Vendor Added !!!! " ));
      FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
      FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
        

}

}
        
        
catch(Exception e)
        {
        e.printStackTrace();
        }
        
        }
    
public void onEdit(RowEditEvent event)
{
        int i,j=0;
        String vid=((venadd) event.getObject()).getVid();
        String vname=((venadd) event.getObject()).getVname();
        String vconame=((venadd) event.getObject()).getVconame();
        
        String vadd=((venadd) event.getObject()).getVadd();
       
        System.out.println(vname+" "+vconame+" "+vadd);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");    
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            Statement st=con.createStatement();
           i=st.executeUpdate("update vendor set vendor_name='"+vname+"' , company_name='"+vconame+"' ,company_address='"+vadd+"' where medicine_vendor_id='"+vid+"'");
       //  j=st.executeUpdate("update vendorbdetails set medicine_vendor_name='"+vname+"' , vendor_company_name='"+vconame+"' where medicine_vendor_id='"+vid+"'");
         
         if(i!=0||j!=0)    
            {
                
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Content Successfully Edited ....." ));
               FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                 FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml"); 
                  System.out.println("successful update in product");        
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    
}
