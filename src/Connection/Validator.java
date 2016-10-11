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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Validator {

    List errors = new ArrayList();

    public void length(int min, int max, String text, String fieldName) {
        if (text.length() > max || text.length() < min) {
            errors.add(fieldName + " length should between " + min + " and " + max);
        }
    }

    public void number(String text, String fieldName) {
        try {
            double d = Double.parseDouble(text);
        } catch (NumberFormatException nfe) {
            errors.add(fieldName + " should be a number ");
        }
    }

    public void string(String text, String fieldName) {
        String regex = "[0-9]+";
        if (text.matches(regex)) {
            errors.add(fieldName + " should contain characters");
        }
    }

    public Date date(String text){
        String format = "yyyy-MM-d";
        Date date;
        try {
            date = new SimpleDateFormat(format).parse(text);
            System.out.println(date);
            return date;
        } catch (ParseException ex) {
            errors.add("Invalid Date format");
            return null;
        }
        
    }

    public boolean validate() {
        if (!errors.isEmpty()) {
            String er = errors.get(0).toString();
            JOptionPane.showMessageDialog(null, er, "Invalid Data", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
}
