package com.vetan.service;
  
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;
  
public class ByteToImage {
    public static void generateImage(String path,byte[] byteArray) throws IOException {
        
      // create the object of ByteArrayInputStream class
      // and initialized it with the byte array.
      ByteArrayInputStream inStreambj = new ByteArrayInputStream(byteArray);
        
      // read image from byte array
      BufferedImage newImage = ImageIO.read(inStreambj);
        
      // write output image
      ImageIO.write(newImage, "jpg", new File("outputImage.jpg"));
      System.out.println("Image generated from the byte array.");
    }
    
    public static void generateFile(String fileName,byte[] bytes) throws IOException {
    	
        FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(bytes);
    }
}