/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adati;

import java.awt.image.BufferedImage;

/**
 *
 * @author Simon
 */
public class MultiThresholding {
    BufferedImage img;
    
    public MultiThresholding(BufferedImage src, int seuil1, int seuil2)
    {
        img = src;
        
        int rgba;
        
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                rgba = img.getRGB(i, j);
                if((rgba & 0xFF) < seuil1)
                    img.setRGB(i, j, (rgba & 0xFF000000));
                else if((rgba & 0xFF) > seuil2)
                    img.setRGB(i, j, ((rgba & 0xFF000000) + 0xFFFFFF));
                else
                    img.setRGB(i, j, (rgba & 0xFF000000) + 0x7F7F7F); 
            }
        }
    }
    
    public BufferedImage getMultiThresholding()
    {
        return img;
    }
}
