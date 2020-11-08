/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Option;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class ChainageParallele {
    BufferedImage img;
    public static final int BLACK = 0;
    public static final int RED = 127;
    public static final int WHITE = 255;
    public static final int OUT = 0;
    public static final int IN = 1;
    int array[][] = null;
    int polygon = 0;
    int w;
    int h;
    
    public ChainageParallele(BufferedImage src) throws InterruptedException
    {
        Graphics2D g2d = src.createGraphics();
        w = src.getWidth(); // x
        h = src.getHeight(); // y
        int ret = 0;
        boolean tri = false;
        array = new int[w][h];
           
        for (int y = 0; y < h && ret != -1; y++) 
        {
            for (int x = 0; x < w && ret != -1; x++)
            {
                int pixel = src.getRGB(x, y);
                ret = checkPixelARGB(pixel);
                
                switch (ret) 
                {
                    case 0:
                        // Pixel noir trouvé
                        array[x][y] = checkAround(x, y);
                        break;
                        
                    case 255:
                        array[x][y] = 0;
                        break;
                        
                    case 127:
                        // nothing, on passe ça a déjà été fait.
                        break;
                    default:
                        JOptionPane.showMessageDialog(new JFrame(), "Charger une image en noir et blanc.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
        
        for (int y=0; y < h ; y++) 
        { 
            for (int x=0; x < w ; x++) 
            {
                if(array[x][y] != 0)
                {
                    ret = checkAround(x, y);
                    array[x][y] = ret;
                }
            }
        }
        
        for(int i = 1; i < polygon; i++)
        {
            Trace t = new Trace();
            tri = false;
            int j = 1;
            for (int y=0; y < h ; y++) 
            { 
                for (int x=0; x < w ; x++) 
                {
                    if(array[x][y] == i)
                    {
                        t.addPixel(x, y);
                        if(j == 1)
                        {
                            ret = checkAroundForTri(x,y);
                            if(ret >= 2)
                            {
                                tri = true;
                            }
                        }
                        j++;
                    }
                }
            }
            t.getPolyline(g2d, tri);
        }
        
        // display array 
//        for (int y=0; y < h ; y++) 
//        { 
//            for (int x=0; x < w ; x++) 
//                System.out.print(array[x][y] + " "); 
//  
//            System.out.println(); 
//        }
    }
    
    public int checkPixelARGB(int pixel) 
    {
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        
        if(red >= 200 && green >= 200 && blue >= 200)
            return WHITE;
        else if(red <= 55 && green <= 55 && blue <= 55)
            return BLACK;
        else if(red >= 200 && green <= 25 && blue <= 25)
            return RED;
        else
            return -1;
    }
    
    private int checkAround(int x, int y)
    {
        int ret;
        
        if(array[x-1][y-1] != 0)
        {
            ret = array[x-1][y-1];
        }
        else if(array[x][y-1] != 0 )
        {
            ret = array[x][y-1];
        }
        else if(array[x+1][y-1] != 0)
        {
            ret = array[x+1][y-1];
        }
        else if(array[x-1][y] != 0)
        {
            ret = array[x-1][y];
        }
        else if(array[x+1][y] != 0)
        {
            ret = array[x+1][y];
        }
        else if(array[x-1][y+1] != 0)
        {
            ret = array[x-1][y+1];
        }
        else if(array[x][y+1] != 0)
        {
            ret = array[x][y+1];
        }
        else if(array[x+1][y+1] != 0)
        {
            ret = array[x+1][y+1];
        }
        else
        {
            ret = ++polygon;
        }
        return ret;
    }
    
    private int checkAroundForTri(int x, int y)
    {
        int ret = 0;
        
        if(array[x-1][y-1] != 0)
        {
            ret++;
        }
        if(array[x][y-1] != 0 )
        {
            ret++;
        }
        if(array[x+1][y-1] != 0)
        {
            ret++;
        }
        if(array[x-1][y] != 0)
        {
            ret++;
        }
        if(array[x+1][y] != 0)
        {
            ret++;
        }
        if(array[x-1][y+1] != 0)
        {
            ret++;
        }
        if(array[x][y+1] != 0)
        {
            ret++;
        }
        if(array[x+1][y+1] != 0)
        {
            ret++;
        }

        return ret;
    }
}
