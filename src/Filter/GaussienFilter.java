/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Simon
 */
public class GaussienFilter {
    BufferedImage img;
    
    public GaussienFilter(BufferedImage src)
    {
        img = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color[] pixel = new Color[9];
        int[] filter = {1, 2, 1, 
                        2, 4, 2, 
                        1, 2, 1};
        
        int R, G, B, sum = 0;
        
        for(int i=0; i<filter.length; i++)
            sum += filter[i];
        
        for (int i = 1; i < src.getWidth() - 1; i++) {
            for (int j = 1; j < src.getHeight() - 1; j++) {
                R = 0;
                B = 0;
                G = 0;
                pixel[0] = new Color(src.getRGB(i - 1, j - 1));
                pixel[1] = new Color(src.getRGB(i - 1, j));
                pixel[2] = new Color(src.getRGB(i - 1, j + 1));
                pixel[3] = new Color(src.getRGB(i, j + 1));
                pixel[4] = new Color(src.getRGB(i + 1, j + 1));
                pixel[5] = new Color(src.getRGB(i + 1, j));
                pixel[6] = new Color(src.getRGB(i + 1, j - 1));
                pixel[7] = new Color(src.getRGB(i, j - 1));
                pixel[8] = new Color(src.getRGB(i, j));
                for (int k = 0; k < 9; k++) {
                    R += pixel[k].getRed() * filter[k];
                    B += pixel[k].getBlue() * filter[k];
                    G += pixel[k].getGreen() * filter[k];
                }
                img.setRGB(i, j, new Color(R / sum, G / sum, B / sum).getRGB());
            }
        }
    }

    public BufferedImage getGaussienFilter() {
        return img;
    }
}
