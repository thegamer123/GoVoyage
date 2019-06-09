/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Lenovo
 */
public class CreatePDF {

    public static void create(String path, String fileName, String textToAdd, String logo) throws IOException {

        PDDocument document = new PDDocument();
        document.save(path + fileName + ".pdf");
        System.out.println("PDF created");
        File file = new File(path + fileName + ".pdf");
        PDDocument doc = PDDocument.load(file);
        System.out.println("PDF loaded");
        //Retrieving the pages of the document 
        PDPage page = document.getPage(1);
        PDImageXObject pdImage = PDImageXObject.createFromFile(logo, doc);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.drawImage(pdImage, 70, 250);

        //Begin the Content stream 
        contentStream.beginText();
        //Setting the font to the Content stream  
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        //Setting the position for the line 
        contentStream.newLineAtOffset(25, 500);

        //Adding text in the form of string 
        contentStream.showText(textToAdd);

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");
        //Closing the content stream
        contentStream.close();

        //Saving the document
        //document.save(new File("C:/PdfBox_Examples/new.pdf"));
        //Closing the document  
        document.close();
    }

}
