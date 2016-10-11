/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hashi
 */
public class DB {
    private static Connection c;
    public static Connection GetMyConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://127.0.1.1:3306/ldb?useldb=true&characterEncoding=UTF-8","root", "");
        return c;
    }
    
}
