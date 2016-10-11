/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

/**
 *
 * @author Hashi
 */
public interface IPerson {
    
    public boolean add();
    public boolean delete(String id);
    public void getDetails(String id);
}
