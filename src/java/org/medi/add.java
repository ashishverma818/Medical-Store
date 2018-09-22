


package org.medi;

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



@ManagedBean
@RequestScoped
public class add implements Serializable {

     
    private String mid;
private List<SelectItem> bind=new ArrayList<SelectItem>();

    public List<SelectItem> getBind() {
        return bind;
    }

    public void setBind(List<SelectItem> bind) {
        this.bind = bind;
   }
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Date getManu() {
        return manu;
    }

    public void setManu(Date manu) {
        this.manu = manu;
   
    }

    public Date getExi() {
        return exi;
    }

    public void setExi(Date exi) {
        this.exi = exi;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

   
    public String getMcategory() {
        return mcategory;
    }

    public void setMcategory(String mcategory) {
        this.mcategory = mcategory;
    }

   

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
     private String mname;
      private String gname;
       private String mrp;
        private String pprice;
        private String cname;
        private String vid;
        private Date manu;
        private Date exi;
        private String qt;
        
        private String mcategory;
       
        private String cond;
        private String des;
        private String id;
        private String chse; 

    public String getChse() {
        return chse;
    }

    public void setChse(String chse) {
        this.chse = chse;
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

    public float getMrpt() {
        return mrpt;
    }

    public void setMrpt(float mrpt) {
        this.mrpt = mrpt;
    }

    public Date getManudate() {
        return manudate;
    }

    public void setManudate(Date manudate) {
        this.manudate = manudate;
    }

    public Date getExidate() {
        return exidate;
    }

    public void setExidate(Date exidate) {
        this.exidate = exidate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

  

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
        private String name;
        private float mrpt;
        private Date manudate;
        private Date exidate;
        private int quantity;
        private String compname;
       private String vendorid;

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }
        private String desc; 
        
        private String viid;
        private float fmrp;
        private float fpprice;
        private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getFpprice() {
        return fpprice;
    }

    public void setFpprice(float fpprice) {
        this.fpprice = fpprice;
    }

    public int getIqt() {
        return iqt;
    }

    public void setIqt(int iqt) {
        this.iqt = iqt;
    }
        private int iqt;

    public float getFmrp() {
        return fmrp;
    }

    public void setFmrp(float fmrp) {
        this.fmrp = fmrp;
    }

    public String getViid() {
        return viid;
    }

    public void setViid(String viid) {
        this.viid = viid;
    }
        
        
     
        Connection con;
        
        @PostConstruct
       
         public void init()
        {
          System.out.println("going in");
          
          
          {   try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_vendor_id from vendor");
            
            ResultSet rs=pst.executeQuery();
             bind.clear();
            while(rs.next())
            {
               // add m=new add();
               viid=rs.getString("medicine_vendor_id");
            //m.add(rs.getString("medicine_vendor_id")); 
               System.out.println(viid);
            bind.add(new SelectItem(""+viid));
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
          {
              try{
           Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select medicine_id from newmedicine order by medicine_id desc limit 1");
          rs.next();
            setMid(""+(rs.getInt("medicine_id")+1));
           setCond("--NA--");
           setGname("--NA--");
            con.close();}
              
               catch(Exception e)
            {
        e.printStackTrace();
          }
          
          }
        }
        
        
        
        public List<add> listmedi()
        {
            List<add> list=new ArrayList();
            try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_category,medicine_vendor_id,medicine_id,medicine_name,medicine_description,company_name from newmedicine");
            
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                add m=new add();
            m.setId(rs.getString("medicine_id"));   
            m.setName(rs.getString("medicine_name"));
           m.setVendorid(rs.getString("medicine_vendor_id"));
            m.setCompname(rs.getString("company_name"));
            m.setDesc(rs.getString("medicine_description"));
           m.setCategory(rs.getString("medicine_category"));
            list.add(m);
            
           }
           
            return list;}
            
            catch(Exception e)
            {
        e.printStackTrace();
          return null;}
        }
        
       
        
DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
//DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
String nmedicinename;
String nmedicinevendor;
int goal=0;
    public void addmed() throws SQLException
    
    { 
        try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
       
        
               Date date=new Date(); 
           
           PreparedStatement pst=con.prepareStatement("insert into medicines values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
           PreparedStatement pst1=con.prepareStatement("insert into newmedicine values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
           PreparedStatement pst2;
           pst2 = con.prepareStatement("select medicine_id,medicine_name from newmedicine");
           
         pst.setString(1,mid);
         pst1.setString(1,mid);
         pst.setString(2,mname);
          pst1.setString(2,mname);
         pst.setString(3,gname);
         pst1.setString(3,gname);
         
         fmrp=Float.parseFloat(mrp);
         
         pst.setFloat(4,fmrp);
          pst1.setFloat(4,fmrp);
         
         fpprice=Float.parseFloat(pprice);
         
         pst.setFloat(5,fpprice);
          pst1.setFloat(5,fpprice);
         pst.setString(6,cname);
          pst1.setString(6,cname);
         pst.setString(7,vid);
          pst1.setString(7,vid);
         
         iqt=Integer.parseInt(qt);
         
         pst.setInt(8,iqt);
          pst1.setInt(8,iqt);
         pst.setString(9,mcategory);
         pst1.setString(9,mcategory);
        
         pst.setString(10,cond);
          pst1.setString(10,cond);
         pst.setString(11,des);
           pst1.setString(11,des);
     
        String manudate = dateFormat.format(manu);
        String exidate = dateFormat.format(exi);
        
        pst.setString(12,manudate);
        pst1.setString(12,manudate);
        pst.setString(13,exidate);
          pst1.setString(13,exidate);
        
         ResultSet rs1=pst2.executeQuery();
         while(rs1.next())
         {
             nmedicinename=rs1.getString("medicine_name");
             nmedicinevendor=rs1.getString("medicine_id");
         if(nmedicinename.equalsIgnoreCase(mname) && nmedicinevendor.equals(vid) )
         {
         goal=1;
         }
           }
        
         
         if(goal==1)
         {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Medicine Already Added Please update the Stocks Instead !!!! " ));
         }
         else
         {
             if( exi.after(manu)&& date.after(manu))
        {
       // pst.execute();
        pst1.execute();
        
        
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("New Medicine Added !!!! " ));
      FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    // FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
      //  clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
        }
        else
        {
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Invalid manufacture or Expiry Credentials !!!! " ));
        }
         }
        }
        
     catch (NumberFormatException e) 
     {
        // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
       e.printStackTrace(); 
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Invalid input enter valid Amount !!!! " ));
    }      
catch(Exception e)
        {
        e.printStackTrace();
        }
     
        
        }
public void clear()
{
try{


this.mname=null;
this.gname=null;
this.mrp=null;
this.pprice=null;
this.cname=null;
this.vid=null;
this.manu=null;
this.qt=null;
this.exi=null;

this.mcategory=null;

this.cond=null;
this.des=null;

}
catch(Exception e)
{

e.printStackTrace();
}


}
    


  
public void onEdit(RowEditEvent event)
{
        int i,j=0;
        String id=((add) event.getObject()).getId();
        String name=((add) event.getObject()).getName();
        String compname=((add) event.getObject()).getCompname();
        
        String desc=((add) event.getObject()).getDesc();
       
        System.out.println(name+" "+compname+" "+desc);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");    
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","12345");
            Statement st=con.createStatement();
           i=st.executeUpdate("update newmedicine set medicine_name='"+name+"' , med_description='"+desc+"' , medicine_company_name='"+compname+"' where medicine_category_id='"+id+"'");
           j=st.executeUpdate("update medicines set medicine_name='"+name+"' , med_description='"+desc+"' , medicine_company_name='"+compname+"' where medicine_category_id='"+id+"'");
          
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

 