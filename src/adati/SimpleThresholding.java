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
public class SimpleThresholding {
    
    BufferedImage img;
    
    public SimpleThresholding(BufferedImage src, int tmp)
    {
        img = src;
        
        int rgba;
        
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                rgba = img.getRGB(i, j);
                if((rgba & 0xFF) < tmp)
                    img.setRGB(i, j, (rgba & 0xFF000000));
                else
                    img.setRGB(i, j, ((rgba & 0xFF000000) + 0x00FFFFFF));
            }
        }
    }
    
    public BufferedImage getSimpleThresholding()
    {
        return img;
    }
    
}
