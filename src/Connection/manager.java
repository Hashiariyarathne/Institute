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
public class manager implements IPerson {

    private String id;
    private String name;
    private String password;
    private String position;

    public String getId() {
        return this.id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public String getname() {
        return this.name;
    }

    public String getpassword() {
        return this.password;
    }

    public String getposition() {
        return this.position;
    }

    //default constructor
    public manager() {

    }

    //Constructor overload
    public manager(String name,String password, String position) {

        this.name = name;
        this.password = password;
        this.position = position;


    }

    @Override
    public boolean add() {
        DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        String sql = "insert into users(`name`, `password`, `position` ) values('" + name + "','" + password + "','" + position + "')";

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
        String sql = "delete from users where id = '" + id + "'";

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
    public void getDetails(String id) {
        DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        String sql = "select * from users where id = '" + id + "'";
        try {
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                this.id = rs.getString("id");
                this.name = rs.getString("first_name");
                this.password = rs.getString("last_name");
                this.position = rs.getString("school");

            } else {
                JOptionPane.showMessageDialog(null, " Ther is no user for order id - " + id, "Error !! ", JOptionPane.ERROR_MESSAGE);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public boolean EditSave(String id) {
        DBConnection db = new DBConnection();
        Connection con = db.getDbConnection();
        Statement stm = null;
        String sql = "update users set name ='" + name + "', password = '" + password + "' , position = '" + position + "' where id = '" + id + "'";

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
