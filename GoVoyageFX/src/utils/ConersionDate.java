/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoVoyage.utiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author ASUS
 */
public class ConersionDate {

    public ConersionDate() {
    }
    
    
    public Date convertirStringToDate(){

		final SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yy");
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
 
		final String dateStr = "01/01/16";
		try {
 
			final Date date = formatter1.parse(dateStr);
			System.out.println(date);
			System.out.println(formatter.format(date));
 
		} catch (final ParseException e) {
			e.printStackTrace();
		}
       // return formatter.format(date);
      //  return date;
        return null;
        
  }
   public int convertirDateToString(DatePicker date){
      String date1 = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));  
       String an=date1.substring(0, 4);
       System.out.println("an = "+ an);
       String mm=date1.substring(5, 7);
       System.out.println("mm = "+ mm);
        String jj=date1.substring(8, 10);
        System.out.println("jj = "+ jj);
        String datefinal=an+mm+jj;
        int dt=Integer.valueOf(datefinal);
        System.out.println("datefin = "+ datefinal);
       return dt;
        

}
}