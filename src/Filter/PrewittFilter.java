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
public class PrewittFilter {
    BufferedImage img;
    
    public PrewittFilter(BufferedImage src)
    {
        img = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color[] pixel = new Color[9];
        int[] filter = {-1, 0, 1, 
                        -1, 0, 1, 
                        -1, 0, 1};
        
        int[] filter2 = {-1, -1, -1, 
                          0, 0, 0, 
                          1, 1, 1};
        
        int R, G, B, R2, G2, B2, sum = 0;
        
        for(int i=0; i<filter.length; i++)
            sum += filter[i];
        
        for (int i = 1; i < src.getWidth() - 1; i++) {
            for (int j = 1; j < src.getHeight() - 1; j++) {
                R = 0;
                B = 0;
                G = 0;
                R2 = 0;
                B2 = 0;
                G2 = 0;
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
                
                for (int k = 0; k < 9; k++) {
                    R2 += pixel[k].getRed() * filter2[k];
                    B2 += pixel[k].getBlue() * filter2[k];
                    G2 += pixel[k].getGreen() * filter2[k];
                }
                
                R = R<0 ? R=0 : (R>255 ? R=255 : R); // If R<0 -> R=0
                B = B<0 ? B=0 : (B>255 ? B=255 : B); // If R>255 -> R=255
                G = G<0 ? G=0 : (G>255 ? G=255 : G);
                
                R2 = R2<0 ? R2=0 : (R2>255 ? R2=255 : R2); // If R<0 -> R=0
                B2 = B2<0 ? B2=0 : (B2>255 ? B2=255 : B2); // If R>255 -> R=255
                G2 = G2<0 ? G2=0 : (G2>255 ? G2=255 : G2);
                
                img.setRGB(i, j, new Color(R/6|R2/6, G/6|G2/6, B/6|B2/6).getRGB());
            }
        }
    }

    public BufferedImage getPrewittFilter() {
        return img;
    }
}
