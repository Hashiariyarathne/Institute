/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hashi
 */
public class DBConnection{
    
    final private String DATABASE_NAME = "institutemanagement";
    final private String DATABASE_HOST = "localhost";
    final private String DATABASE_PASSWORD = "123";
    final private String DATABASE_USERNAME = "root";
    final private String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    
    
    public Connection getDbConnection(){
       try {
          Class.forName(DATABASE_DRIVER);
          Connection connection = DriverManager.getConnection("jdbc:mysql://"+DATABASE_HOST+"/"+DATABASE_NAME+"?"
                  + "user="+DATABASE_USERNAME+"&password="+DATABASE_PASSWORD);
          return connection;
        }catch(ClassNotFoundException | SQLException e){
             System.out.println("Exception occured : "+ e.getMessage());
             return null;
        }
        
    }
    
}
