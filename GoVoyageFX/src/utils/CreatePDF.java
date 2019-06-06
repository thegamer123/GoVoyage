/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Lenovo
 */
public class CreatePDF {

    public static void create(String path, String fileName) throws IOException {

        PDDocument document = new PDDocument();
        document.save(path + fileName + ".pdf");
        System.out.println("PDF created");
        File file = new File(path + fileName + ".pdf");
        PDDocument doc = PDDocument.load(file);
        System.out.println("PDF loaded");
        //Closing the document  
        document.close();
    }

}
