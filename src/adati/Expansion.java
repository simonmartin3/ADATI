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
public class Expansion {
    
    private BufferedImage img;
    private BufferedImage newImage;
    
    public Expansion(BufferedImage src, float scaleX, float scaleY)
    {
        img = src;
        int newWidth = (int) (src.getWidth() * scaleX);
        int newHeight = (int) (src.getHeight() * scaleY);
        newImage = new BufferedImage(newWidth, newHeight, src.getType());
        for (int x = 0; x < newWidth; ++x) {
            for (int y = 0; y < newHeight; ++y) {
                float gx = ((float) x) / newWidth * (src.getWidth() - 1);
                float gy = ((float) y) / newHeight * (src.getHeight() - 1);
                int gxi = (int) gx;
                int gyi = (int) gy;
                int rgb = 0;
                int c00 = src.getRGB(gxi, gyi);
                int c10 = src.getRGB(gxi + 1, gyi);
                int c01 = src.getRGB(gxi, gyi + 1);
                int c11 = src.getRGB(gxi + 1, gyi + 1);
                for (int i = 0; i <= 2; ++i) {
                    float b00 = get(c00, i);
                    float b10 = get(c10, i);
                    float b01 = get(c01, i);
                    float b11 = get(c11, i);
                    int ble = ((int) blerp(b00, b10, b01, b11, gx - gxi, gy - gyi)) << (8 * i);
                    rgb = rgb | ble;
                }
                newImage.setRGB(x, y, rgb);
            }
        }
    }
    
        /* gets the 'n'th byte of a 4-byte integer */
    private static int get(int self, int n) {
        return (self >> (n * 8)) & 0xFF;
    }
 
    private static float lerp(float s, float e, float t) {
        return s + (e - s) * t;
    }
 
    private static float blerp(final Float c00, float c10, float c01, float c11, float tx, float ty) {
        return lerp(lerp(c00, c10, tx), lerp(c01, c11, tx), ty);
    }
    
    public BufferedImage getExpansion()
    {
        return newImage;
    }
}
