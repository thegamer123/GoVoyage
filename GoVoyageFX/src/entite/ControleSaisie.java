/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author omar
 */
public class ControleSaisie {
//        public static boolean isString(String text) {
//
//        if (text.matches("^[a-zA-Z]+$"))  {
//            return true;
//        } else {
//            return false;
//        }
//    }
      public static boolean isUsername(String text) {

        if (text.matches("^[A-Za-z0-9]+$")) {
            return true;
        } else {
            return false;
        }
    }
      public static boolean isString(String text) {

        if (text.matches("^[A-Z a-z 0-9]+$")) {
            return true;
        } else {
            return false;
        }
    }
       public static boolean iscin(String text) {

        if (text.matches("^[0-9]+$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}

      private static Matcher matcher;
     private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
     
     
    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private static final String pwd=  "^[A-Za-z0-9]+$";
    private static Pattern pattern1 = Pattern.compile(pwd);
    
    
     public static boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
     
     
      public static boolean validate1(final String hex) {
        matcher = pattern1.matcher(hex);
        return matcher.matches();
    }
    
}


