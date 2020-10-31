/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 *
 * @author Simon
 */
public class MedianFilter {
    BufferedImage img;
    
    public MedianFilter(BufferedImage src)
    {
        img = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color[] pixel = new Color[9];
        int[] R = new int[9];
        int[] B = new int[9];
        int[] G = new int[9];

        for (int i = 1; i < src.getWidth() - 1; i++) {
            for (int j = 1; j < src.getHeight() - 1; j++) {
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
                    R[k] = pixel[k].getRed();
                    B[k] = pixel[k].getBlue();
                    G[k] = pixel[k].getGreen();
                }
                Arrays.sort(R);
                Arrays.sort(G);
                Arrays.sort(B);
                img.setRGB(i, j, new Color(R[4], G[4], B[4]).getRGB());
            }
        }
    }
    
    public BufferedImage getMedianFilter()
    {
        return img;
    }
}
