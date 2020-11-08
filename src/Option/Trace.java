/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Option;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

/**
 *
 * @author Simon
 */
public class Trace {
    private final Vector<Point> coord = new Vector<>();
    
    public Trace(){}
    
    public void addPixel(int x, int y)
    {
        Point p = new Point(x,y);
        coord.add(p);
    }
    
    public void getPolyline(Graphics2D g2d, boolean tri)
    {      
        int[] xValues = new int[coord.size()];
        int[] yValues = new int[coord.size()];
        
        for(int i = 0; i < coord.size(); i++)
        {
            xValues[i] = (int) coord.get(i).getX();
            yValues[i] = (int) coord.get(i).getY();
        }
        
        if(tri)
        {
            // Tri 
            for(int i = 0; i < coord.size(); i++)
            {
                int index = i;  
                for (int j = i + 1; j < xValues.length; j++)
                {
                    if (xValues[j] < xValues[index]){ 
                        index = j;
                    }
                }
                int minX = xValues[index];
                xValues[index] = xValues[i]; 
                xValues[i] = minX;

                int minY = yValues[index];
                yValues[index] = yValues[i]; 
                yValues[i] = minY;
            }
        }
        // set the color of line drawn to blue 
        g2d.setColor(Color.red); 
        
        // draw the polygon using drawPolygon 
        // function using object of polyline class
//        g2d.drawPolyline(tmpX, tmpY, 3);
        g2d.drawPolyline(xValues, yValues, xValues.length);
   
    }
}
