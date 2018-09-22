/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ser;
import java.io.IOException;
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
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;
import java.util.Date;
import javax.servlet.http.HttpSession;
import java.util.Arrays; 
/**
 *
 * @author ashish
 */
@ManagedBean(name="service",eager=true)
@RequestScoped
public class addservices implements Serializable
{
    Connection con;
    private int custid;
    private String stype;
    private String sdesc;
    private Date sdate;
    private int Staffid;
    private String sstatus;
    private int sid;
 
    private List<SelectItem> bindsid=new ArrayList<SelectItem>();//add Staff Id to admin Service Tab for editing of staff  
    private List<SelectItem> bindstatus=new ArrayList<SelectItem>();
    private List<SelectItem> bindserviceid=new ArrayList<SelectItem>();

    

    
   static int size=2;
    private final static String[] s;
    static {
        s = new String[size];
        s[0] = "pending";
        s[1] = "processed";
    }
    private String status;

    public String getStatus() {
        return status;
        
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
   
    
   
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public int getStaffid() {
        return Staffid;
    }

    public void setStaffid(int Staffid) {
        this.Staffid = Staffid;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }
    public List<SelectItem> getBindsid() {
        return bindsid;
    }

    public void setBindsid(List<SelectItem> bindsid) {
        this.bindsid = bindsid;
    }
 
    public List<SelectItem> getBindstatus() {
        return bindstatus;
    }

    public void setBindstatus(List<SelectItem> bindstatus) {
        this.bindstatus = bindstatus;
    }
    
    public List<SelectItem> getBindserviceid() {
        return bindserviceid;
    }

    public void setBindserviceid(List<SelectItem> bindserviceid) {
        this.bindserviceid = bindserviceid;
    }
   @PostConstruct
   public void init()
   {
        { try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home","root","12345");
            PreparedStatement pst=con.prepareStatement("select S_Id from staff");
            
            ResultSet rs=pst.executeQuery();
             bindsid.clear();
            while(rs.next())
            {
               // add m=new add();
               Staffid=rs.getInt("S_Id");
            //m.add(rs.getString("medicine_vendor_id")); 
              
               System.out.println(Staffid);
            bindsid.add(new SelectItem(""+Staffid));
         //   list.add(m);
            
           }
            con.close();
          
          }

           
           catch(Exception e)
            {
        e.printStackTrace();
            } 
          }
       { try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home","root","12345");
            PreparedStatement pst=con.prepareStatement("select S_Id from services");
            
            ResultSet rs=pst.executeQuery();
             bindserviceid.clear();
            while(rs.next())
            {
               // add m=new add();
               sid=rs.getInt("S_Id");
            //m.add(rs.getString("medicine_vendor_id")); 
              
               System.out.println(sid);
            bindserviceid.add(new SelectItem(""+sid));
         //   list.add(m);
            
           }
            con.close();
          
          }

           
           catch(Exception e)
            {
        e.printStackTrace();
            } 
          }
        {
            
            
        for(int i = 0 ; i < 2 ; i++) {
           
            bindstatus.add(new SelectItem(""+s[i]));
           // m.setSstatus(s[i]);
           
        }
         
      
        }
   }
    public void addservices() throws SQLException, ClassNotFoundException
    
    { 
        try{
       
            
             HttpSession sess=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);         
             String un=sess.getAttribute("username").toString();
             String uid=(sess.getAttribute("userid")).toString();
             
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("User Already Exists !!!! "+un +"Usserid"+uid));   
                   
              
                   
               
        
         //fpprice=Float.parseFloat(pprice);
         
         
     
        //String exidate = dateFormat.format(exi);
        

         
        }      
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
        
        }
        
   //list of customer whos service are still pending 
    public List<addservices> listpendingService()
        {
            
            List<addservices> list=new ArrayList();
            try
            {
                
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home","root","12345");
                PreparedStatement pst=con.prepareStatement("select S_Id,Cust_Id,Service_Type,S_Desc,S_Date,Staff_Id,S_Status from services where S_Status='pending'");

                ResultSet rs=pst.executeQuery();
                while(rs.next())
                {
                    addservices m=new addservices();
                    m.setSid(rs.getInt("S_Id"));
                    m.setCustid(rs.getInt("Cust_Id"));
                    m.setStype(rs.getString("Service_Type"));
                    m.setSdesc(rs.getString("S_Desc"));
                    m.setSdate(rs.getDate("S_Date"));
                    m.setStaffid(rs.getInt("Staff_Id"));
                    m.setSstatus(rs.getString("S_Status"));
                    
                    list.add(m);

                }

                return list;
            }
            
            catch(Exception e)
            {
              e.printStackTrace();
              return null;
            }
            
        }
    
     public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
     
     //list of customer whos service are proceeded   
     public List<addservices> listproceedService()
        {
            
            List<addservices> list=new ArrayList();
            try
            {
                
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home","root","12345");
                PreparedStatement pst=con.prepareStatement("select S_Id,Cust_Id,Service_Type,S_Desc,S_Date,Staff_Id,S_Status from services where S_Status='proceed'");

                ResultSet rs=pst.executeQuery();
                while(rs.next())
                {
                    addservices m=new addservices();
                    m.setSid(rs.getInt("S_Id"));
                    m.setCustid(rs.getInt("Cust_Id"));
                    m.setStype(rs.getString("Service_Type"));
                    m.setSdesc(rs.getString("S_Desc"));
                    m.setSdate(rs.getDate("S_Date"));
                    m.setStaffid(rs.getInt("Staff_Id"));
                    m.setSstatus(rs.getString("S_Status"));
                    
                    list.add(m);

                }

                return list;
            }
            
            catch(Exception e)
            {
              e.printStackTrace();
              return null;
            }
            
        }
     
      public void onRowEdit()
        {
                int i,j=0;
               // int seid=((addservices) event.getObject()).getSid();
                //int staid=((addservices) event.getObject()).getStaffid();
                //String desc=((addservices) event.getObject()).getSdesc();
               // String stat=((addservices) event.getObject()).getSstatus();
               // String stat=((addservices) event.getObject()).getSstatus();
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");    
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home","root","12345");
                    Statement st=con.createStatement();
                    i=st.executeUpdate("update services set Staff_Id="+Staffid+" , S_Status='"+sstatus+"' where S_Id="+1000);
                 
                    if(i!=0)    
                    {

                        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Content Successfully Edited ....." ));
                        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("test.xhtml"); 
                 
                    }
             }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
/*

 //list of Status to be displayed on admin page for upadating the status of customer   
     public List<addservices> createstatus() {
        List<addservices> list = new ArrayList<addservices>();
        for(int i = 0 ; i < 2 ; i++) {
            addservices m=new addservices();
            
            
            m.setSstatus(s[i]);
            list.add(m);
        }
         
        return list;
    }
     
    
//list of Staff Id to be displayed on admin page for editing purpose    
     public List<addservices> createsid()
     {
             List<addservices> list=new ArrayList();
          { 
              try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home","root","12345");
                   PreparedStatement pst=con.prepareStatement("select S_Id from staff");

              
                   ResultSet rs=pst.executeQuery();
                    bindsid.clear();
                   
                   while(rs.next())
                   {
                      addservices m=new addservices();
                      
                     // m.add(rs.getString("medicine_vendor_id")); 
                      m.setStaffid(rs.getInt("S_Id"));
                   
                      // bindsid.add(rs.getInt("Staff_Id"));
                       list.add(m);

                  }
                  
                   con.close();

                 }

           
           catch(Exception e)
            {
        e.printStackTrace();
            } 
              return list;
          }       
        }
     
     
      */
        

}
