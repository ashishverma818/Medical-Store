

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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;



@ManagedBean
@RequestScoped
public class update2 implements Serializable {

private List<SelectItem> bind=new ArrayList<SelectItem>();
private List<SelectItem> bind1=new ArrayList<SelectItem>();

    public List<SelectItem> getBind1() {
        return bind1;
    }

    public void setBind1(List<SelectItem> bind1) {
        this.bind1 = bind1;
    }

    public List<SelectItem> getBind() {
        return bind;
    }
   
    public void setBind(List<SelectItem> bind) {
        this.bind = bind;
    }

    private String uid;
    private String id;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
  private String name;
    private float mrpt;
      private Date manudate;
        private Date exidate;
          private int quantity;
            private String compname;
              private String desc;
                private String category;
                
    private String mid;
        private String mid1;

    public String getMid1() {
        return mid1;
    }

    public void setMid1(String mid1) {
        this.mid1 = mid1;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Date getManu() {
        return manu;
    }

    public void setManu(Date manu) {
        this.manu = manu;
    }
    private Date manu;
    
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
  private String miid;

    public String getMiid() {
        return miid;
    }

    public void setMiid(String miid) {
        this.miid = miid;
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

    public Date getManud() {
        return manud;
    }

    public void setManud(Date manud) {
        this.manud = manud;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public Date getExi() {
        return exi;
    }

    public void setExi(Date exi) {
        this.exi = exi;
    }

   
  private String mrp;
   private String pprice;
    private Date manud;
     private String qt;
      private Date exi;
     
       private String viid;

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
          { try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_id from newmedicine");
            
            ResultSet rs=pst.executeQuery();
             bind.clear();
            while(rs.next())
            {
               // add m=new add();
               uid=rs.getString("medicine_id");
            //m.add(rs.getString("medicine_vendor_id")); 
              
               System.out.println(uid);
            bind.add(new SelectItem(""+uid));
         //   list.add(m);
            
           }
            con.close();
          
          }

           
           catch(Exception e)
            {
        e.printStackTrace();
            } 
          }
          // delete stock when become zero
          {
            int i=0;
          try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
           PreparedStatement pst=con.prepareStatement("delete from medicines where medicine_quantity='"+0+"'");
           i=pst.executeUpdate();
        if(i!=0)
        {
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Stock Cleared !!!! " ));
      FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
         
         con.close();
        }
          }
           catch(Exception e)
            {
        e.printStackTrace();
            } 
          }
          
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
          
          
        }
//displaying the updated medicines
 public List<update2> updatemedidisplay()
        {
            List<update2> list=new ArrayList();
            try{
        Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_category,medicine_id,medicine_name,mrp,medicine_description,company_name,medicine_quantity,manu_date,expiry_date from newmedicine");
            
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                update2 m=new update2();
            m.setId(rs.getString("medicine_id"));   
            m.setName(rs.getString("medicine_name"));
            m.setMrpt(rs.getFloat("mrp"));
            m.setManudate(rs.getDate("manu_date"));
            m.setExidate(rs.getDate("expiry_date"));
            m.setQuantity(rs.getInt("medicine_quantity"));
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
 int de=0;
 int temp1,temp2;
public void delete() throws SQLException
{
    try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
           PreparedStatement pst=con.prepareStatement("Delete from newmedicine where medicine_id=? and manu_date=?");
           pst.setString(1,mid);
           String manudate = dateFormat.format(manu);
           pst.setString(2,manudate);
             
           PreparedStatement pst1=con.prepareStatement("select medicine_quantity from medicines where medicine_category_id=? and med_manufacture_date=?");
           pst1.setString(1,mid);
           String manudate1 = dateFormat.format(manu);
           pst1.setString(2,manudate1);
           ResultSet rs=pst1.executeQuery();
           
            while(rs.next())
           {  temp1=rs.getInt("medicine_quantity");}
            
           PreparedStatement pst2=con.prepareStatement("select medicine_quantity from newmedicine where medicine_category_id=?");
           pst2.setString(1,mid);
            ResultSet rs1=pst2.executeQuery();
              while(rs1.next())
              {  temp2=rs1.getInt("medicine_quantity");}
            
             int temp3=temp2-temp1;
             PreparedStatement pst3=con.prepareStatement("update newmedicine set medicine_quantity=? where medicine_category_id=?");
           pst3.setInt(1,temp3);
           pst3.setString(2,mid);
           pst3.executeUpdate();
           
             de=pst.executeUpdate();
         if(de!=0)
       {  
           
    
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Medicine/Product Stock Deleted !!!! " ));
      FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    
        FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
            
           
            con.close();
         }
         else
         {
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Stock does not Exist !!!! " ));
      FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
         
         con.close();
         }
          }
           // return list;}
            
            catch(Exception e)
            {
        e.printStackTrace();
          }




}
public void deleted() throws SQLException
{
    try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("Delete from medicines where medicine_id=?");
            PreparedStatement pst1=con.prepareStatement("DELETE FROM newmedicine WHERE medicine_id = ?");
           
            int mmid=Integer.parseInt(mid1);
            pst.setString(1,mid1);
            pst1.setInt(1,mmid);
        
            //de=pst.executeUpdate();
            
            de=pst1.executeUpdate();
      
        
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Medicine/Product Deleted !!!! " ));
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



private String umedicine_name;
private String umedicine_generic_name;
private String umedicine_company_name;
private String umedicine_category_medicine;
private String ucondition;
private String umed_description;
private String umedicine_vendor_id;
private String umed_manufacture_date;
private String umed_expiry_date;
private int umedicine_quantity; 
private float umrp;
private float upprice;
private int uquantity;
int goal=0;
//updating the medicine
public void update() throws SQLException
{
try
{
    Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select medicine_name,general_name,company_name,medicine_category,medicine_quantity,medicine_condition,medicine_description,medicine_vendor_id from newmedicine where medicine_id=?");
           pst.setString(1,miid);
         
           ResultSet rs=pst.executeQuery();
           while(rs.next())
           {
            umedicine_name=rs.getString("medicine_name");
            umedicine_generic_name=rs.getString("general_name");
            umedicine_company_name=rs.getString("company_name");
            umedicine_category_medicine=rs.getString("medicine_category");
            ucondition=rs.getString("medicine_condition");
            umed_description=rs.getString("medicine_description");
            umedicine_vendor_id=rs.getString("medicine_vendor_id");      
            umedicine_quantity=rs.getInt("medicine_quantity");
           }
  //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","12345");
            PreparedStatement pst1=con.prepareStatement("insert into newmedicine values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                       
           pst1.setString(1,miid);
             pst1.setString(2,umedicine_name);
               pst1.setString(3,umedicine_generic_name);
               umrp=Float.parseFloat(mrp);
                 pst1.setFloat(4,umrp);
                 upprice=Float.parseFloat(pprice);
                   pst1.setFloat(5,upprice);
                   pst1.setString(6,umedicine_company_name);
                     pst1.setString(7,umedicine_vendor_id);
                     uquantity=Integer.parseInt(qt);
                       pst1.setInt(8,uquantity);
                         pst1.setString(9,umedicine_category_medicine);
                         pst1.setString(10,ucondition);
                           pst1.setString(11,umed_description);
                           
                           String manudate1 = dateFormat.format(manud);
                                  
                                 pst1.setString(12,manudate1);
                           String exidate1 = dateFormat.format(exi);
    
                           pst1.setString(13,exidate1);
                            
                           Date date=new Date(); 
                           
                         //  date1=dateFormat.format(date);
           PreparedStatement pst2=con.prepareStatement("select med_manufacture_date,med_expiry_date from medicines where medicine_category_id=?");
           PreparedStatement pst3=con.prepareStatement("update newmedicine set medicine_mrp=?,medicine_purchase_price=?,medicine_quantity=? where medicine_category_id=? ");
           pst3.setFloat(1,umrp);
           pst3.setFloat(2,upprice);
           umedicine_quantity=umedicine_quantity+uquantity;
           pst3.setInt(3,umedicine_quantity);
           pst3.setString(4,miid);
           
           pst2.setString(1,miid);
           ResultSet rs1=pst2.executeQuery();
           while(rs1.next())
           {
               umed_manufacture_date=rs1.getString("manu_date");
           umed_expiry_date=rs1.getString("expiry_date");
           if(umed_manufacture_date.equals(manudate1)||umed_expiry_date.equals(exidate1))
           {
             goal=1;   
           }
           }
           if(exi.after(manud)&&goal==0&&date.after(manud))
        {
      
        pst1.executeUpdate();
        pst3.executeUpdate();
    
        
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(" Medicine Stock Added !!!! " ));
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

catch (NumberFormatException e) 
     {
        e.printStackTrace(); 
       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Invalid input enter valid Amount !!!! " ));
    }      
 catch(Exception e)
            {
        e.printStackTrace();
          }


 


}
//setting the price in update stock 
public void setprice() throws SQLException
{
try
{
    Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","23456");
            PreparedStatement pst=con.prepareStatement("select mrp,purchase_price,medicine_quantity from newmedicine where medicine_id=?");
      pst.setString(1,miid);
      ResultSet rs=pst.executeQuery();
      while(rs.next())     
      {
             String m = Float.toString(rs.getFloat("mrp"));
             String p = Float.toString(rs.getFloat("purchase_price"));
             String q = Integer.toString(rs.getInt("medicine_quantity"));
         
             setMrp(""+m);
             setPprice(""+p);
             setQt(""+q);
      } }

catch(Exception e)
            {
        e.printStackTrace();
          }


 


}

}