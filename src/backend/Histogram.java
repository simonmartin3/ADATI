/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.Color; 
import java.awt.Paint; 
import adati.windowMain;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;


/**
 *
 * @author Simon
 */
public class Histogram extends JDialog{
    
    windowMain WM;
    BufferedImage image;
    private XYBarRenderer renderer; 
//    private final int[] rouge = new int[256];
//    private final int[] vert = new int[256];
//    private final int[] bleu = new int[256];
    
    public Histogram(BufferedImage img) {
        this.setTitle("Histogram");
        this.setResizable(false);
        image = img;
        JFreeChart HistogramChart = ChartFactory.createHistogram(
        "Histogram",
        "Value","Count",
        createDataset(),
        PlotOrientation.VERTICAL,
        true,true,false);
        
        XYPlot plot = (XYPlot) HistogramChart.getPlot(); 
        renderer = (XYBarRenderer) plot.getRenderer(); 
        renderer.setBarPainter(new StandardXYBarPainter()); 
        // translucent red, green & blue 
        Paint[] paintArray = { 
         new Color(0x80ff0000, true), 
         new Color(0x8000ff00, true), 
         new Color(0x800000ff, true) 
        }; 
        plot.setDrawingSupplier(new DefaultDrawingSupplier(
            paintArray, 
            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE, 
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE, 
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, 
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, 
            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
         
        ChartPanel chartPanel = new ChartPanel( HistogramChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 500 , 500 ) );
        setContentPane( chartPanel );
    }
    
    private HistogramDataset createDataset( ) {
      
        HistogramDataset dataset = new HistogramDataset(); 
        
        Raster raster = image.getRaster();
        
        int w = image.getWidth(); 
        int h = image.getHeight();
         
        double[] r = new double[w * h]; 
        r = raster.getSamples(0, 0, w, h, 0, r); 
        dataset.addSeries("Red", r, 256); 
        r = raster.getSamples(0, 0, w, h, 1, r); 
        dataset.addSeries("Green", r, 256); 
        r = raster.getSamples(0, 0, w, h, 2, r); 
        dataset.addSeries("Blue", r, 256);
      
        return dataset;
   }
}