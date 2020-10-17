/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adati;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon
 */
public class GreyScale {
    
    private BufferedImage img;
    
    public GreyScale(BufferedImage src)
    {
        img = src;
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //Retrieving the values of a pixel
                int pixel = img.getRGB(x,y);
                //Creating a Color object from pixel value
                Color color = new Color(pixel, true);
                //Retrieving the R G B values
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                //Finding the average of the red green blue values
                int average = (red+green+blue)/3;
                //Creating new Color object
                color = new Color(average, average, average);
                //Setting new Color object to the image
                img.setRGB(x, y, color.getRGB());
            }
        }
    }
    
    public BufferedImage getImgToGray()
    {
        return img;
    }
}
