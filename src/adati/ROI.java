/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adati;

/**
 *
 * @author Simon
 */
public class ROI {
    
    private static int x, y, x2, y2, width, height;
    
    public ROI()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }
    
    public ROI(int xTmp, int yTmp, int x2Tmp, int y2Tmp)
    {
        
        if(xTmp < x2Tmp && yTmp < y2Tmp)
        {
            x = xTmp;
            y = yTmp;
            width = x2Tmp - xTmp;
            height = y2Tmp - yTmp;
        }
        else if (xTmp < x2Tmp && yTmp > y2Tmp){
            x = xTmp;
            y = y2Tmp;
            width = x2Tmp - xTmp;
            height = yTmp - y2Tmp;
        }
        else if (xTmp > x2Tmp && yTmp < y2Tmp){
            x = x2Tmp;
            y = yTmp;
            width = xTmp - x2Tmp;
            height = y2Tmp - yTmp;
        }
        else {
            x = x2Tmp;
            y = y2Tmp;
            width = xTmp - x2Tmp;
            height = yTmp - y2Tmp;
        }
    }
    
    public void setXRoi(int xTmp){x = xTmp;}
    
    public void setYRoi(int yTmp){y = yTmp;}
    
    public void setX2Roi(int x2Tmp){x2 = x2Tmp;}
    
    public void setY2Roi(int y2Tmp){y2 = y2Tmp;}
    
    public int getWidthRoi(){
        
        if(x < x2)
        {
            width = x2 - x;
        }
        else {
            width = x - x2;
        }
        
        return width;
    }
    
    public int getHeightRoi(){
        
        if(y < y2)
        {
            height = y2 - y;
        }
        else {
            height = y - y2;
        }
        return height;
    }
    
    public int getXRoi(){
        
        if(x < x2)
        {
            return x;
        }
        else {
            return x2;
        }
    }
    
    public int getYRoi(){
        if(y < y2)
        {
            return y;
        }
        else {
            return y2;
        }
    }
}
