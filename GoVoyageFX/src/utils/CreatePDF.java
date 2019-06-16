/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

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
        PDPage my_page = new PDPage();
        document.addPage(my_page);
        System.out.println("PDF loaded");
        //Retrieving the pages of the document 
        PDPage page = document.getPage(0);

        //BufferedImage image = ImageIO.read(new File(logo));
        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //ImageIO.write(image, "png", outputStream);
        //byte[] imageByte = outputStream.toByteArray();
        File filePicture = new File(logo);
        // convert byte array to image object
        PDImageXObject imageObject = PDImageXObject.createFromFileByContent(filePicture, doc);

        PDRectangle mediaBox = page.getMediaBox();

        //PDImageXObject pdImage = PDImageXObject.createFromFile(logo, doc);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.drawImage(imageObject, 5, mediaBox.getHeight() - 2 * 100, 200, 200);

        //Begin the Content stream Content
        contentStream.beginText();
        //Setting the font to the Content stream  
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        //Setting the position for the line 
        contentStream.newLineAtOffset(25, 600);
        //Adding text in the form of string 
        contentStream.showText(textToAdd);

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");
        //Closing the content stream
        contentStream.close();

        //Saving the document
        //documen0t
        document.save(file);
        //Closing the document  
        document.close();
    }

    public static void viewToPdf(String savePath, String fileName, String textToAdd, String viewPicturePath, String logo) throws IOException {

        PDDocument document = new PDDocument();
        document.save(savePath + fileName + ".pdf");
        System.out.println("PDF created");
        File file = new File(savePath + fileName + ".pdf");
        PDDocument doc = PDDocument.load(file);
        PDPage my_page = new PDPage();
        document.addPage(my_page);
        System.out.println("PDF loaded");
        //Retrieving the pages of the document 
        PDPage page = document.getPage(0);

        //BufferedImage image = ImageIO.read(new File(logo));
        //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //ImageIO.write(image, "png", outputStream);
        //byte[] imageByte = outputStream.toByteArray();
        File filePicture = new File(logo);
        // convert byte array to image object
        PDImageXObject imageObject = PDImageXObject.createFromFileByContent(filePicture, doc);

        PDRectangle mediaBox = page.getMediaBox();

        File filePictureToInsert = new File(viewPicturePath);
        PDImageXObject imageObjectToInsert = PDImageXObject.createFromFileByContent(filePictureToInsert, doc);

        //PDImageXObject pdImage = PDImageXObject.createFromFile(logo, doc);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.drawImage(imageObject, 5, mediaBox.getHeight() - 2 * 100, 200, 200);

        contentStream.drawImage(imageObjectToInsert, 100, 100, 400, 400);

        //Begin the Content stream Content
        contentStream.beginText();
        //Setting the font to the Content stream  
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

        //Setting the position for the line 
        contentStream.newLineAtOffset(25, 600);
        //Adding text in the form of string 
        contentStream.showText(textToAdd);

        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");
        //Closing the content stream
        contentStream.close();

        //Saving the document
        //documen0t
        document.save(file);
        //Closing the document  
        document.close();
    }

}
