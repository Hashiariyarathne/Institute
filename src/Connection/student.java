/*gh
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashi
 */
public class student implements  IPerson {
    
    

    
    private String id;
    private String firstName;
    private String lastName;
    private String school;
    private String grade;
    private String dob;
  //  private String gender;
    private String currentAddress;
    private String homeAddress;
    private String mobileNumber;
    private String homeNumber;
   
    

    public String getId(){
        return this.id;
    }
    
    
    public void setfirstName(String firstName){
        this.firstName = firstName;
    }
    
    
    public void setlastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setschool (String school){
        this.school = school;
    }
    
    public void setgrade (String grade){
        this.grade = grade;
    }
    
    public void setdob (String dob) {
        this.dob = dob;
    }
    

    public void setcurrentAddress (String currentAddress){
        this.currentAddress = currentAddress;
        
    }
    
    
    public void sethomeAddress ( String homeAddress){
        this.homeAddress = homeAddress;
    }
    
    
    public void setmobileNumber (String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    
    public void sethomeNumber (String homeNumber){
        this.homeNumber = homeNumber ;
    }
    
    
    public String getfirstName(){
        return this.firstName;
    }
    
    public String getlastName(){
        return this.lastName;
    }
    
    public String getschool(){
        return this.school;
    }
    
    public String getgrade(){
        return this.grade;
    }
    
    public String getdob(){
        return this.dob;
    }

    
    public String getcurrentAddress(){
        return this.currentAddress;
    }
    
    public String gethomeAddress(){
        return this.homeAddress;
    }
    
    public String getmobileNumber(){
        return this.mobileNumber;
    }
    
    public String gethomeNumber(){
        return this.homeNumber;
    }
    
  
    
    //default constructor
    public student(){
        
    }
    
    //Constructor overload
    public student(String firstName,String lastName, String school, String grade,String dob,String currentAddress,String homeAddress,String mobileNumber,String homeNumber){
        
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.grade = grade;
        this.dob = dob;
        //this.gender = gender;
        this.currentAddress = currentAddress;
        this.homeAddress = homeAddress;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        
    }
    
    @Override
    public boolean add() {
        DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        String sql = "insert into students(`first_name`, `last_name`, `school`, `grade`, `dob`, `current_address` , `home_address` , `mobile_number` , `home_number` ) values('"+firstName+"','"+lastName+"','"+school+"','"+grade+"','"+dob+"','"+currentAddress+"','"+homeAddress+"','"+mobileNumber+"','"+homeNumber+"')";
        
        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    

    @Override
    public boolean delete(String id) {
       
        
        DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        
        
        
        String sql = "delete from students where id = '"+id+"'";
        
        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
            return true;
     ,gn                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    
    @Override
    public void getDetails(String id) {
      DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        String sql = "select * from students where studen_id = '"+id+"'";
        try {
            stm = con.createStatement();
           ResultSet rs = stm.executeQuery(sql);
           if (rs.next()) {
                this.id = rs.getString("id");
                this.firstName = rs.getString("first_name");
                this.lastName = rs.getString("last_name");
                this.school = rs.getString("school");
            
            }else{
                JOptionPane.showMessageDialog(null," Ther is no Students for order student_id - "+id, "Error !! ", JOptionPane.ERROR_MESSAGE);
            }
           con.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    
    public boolean EditSave(String id){
    DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        String sql = "update students set first_name ='"+firstName+"', last_name = '"+lastName+"' , school = '"+school+"' , dob = '"+dob+"' , current_address = '"+currentAddress+"' , home_address = '"+homeAddress+"' , mobile_number = '"+mobileNumber+"' , home_number = '"+homeNumber+"'  where id = '"+id+"'";
        
        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close(); 
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    
}
