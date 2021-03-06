/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import adati.windowMain;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Simon
 */
public class Histogram extends javax.swing.JDialog {

    /**
     * Creates new form Histogram
     */
    windowMain WM;
    private int minValue, maxValue, values[];
 
    public Histogram(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        WM = (windowMain) parent;
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setLocation(0, (height-WM.getHeight())/2);
        
        
        BufferedImage img = WM.getBufferedSource();
        updateHistogram(img);
        
        this.setTitle("Histogram");
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hightvalues = new javax.swing.JLabel();
        histogram = new javax.swing.JLabel();
        Button_Refresh = new javax.swing.JButton();
        Buton_OK = new javax.swing.JButton();
        Button_Egalisation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("0");

        jLabel2.setText("255");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nuance de gris");

        jLabel4.setText("Pixels");

        hightvalues.setText("  ");

        histogram.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        histogram.setToolTipText("");
        histogram.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Button_Refresh.setText("Refresh");
        Button_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RefreshActionPerformed(evt);
            }
        });

        Buton_OK.setText("OK");
        Buton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buton_OKActionPerformed(evt);
            }
        });

        Button_Egalisation.setText("Egalisation");
        Button_Egalisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EgalisationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hightvalues, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(histogram, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Button_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Egalisation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buton_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hightvalues, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(histogram, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_Refresh)
                            .addComponent(Buton_OK)
                            .addComponent(Button_Egalisation))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Buton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buton_OKActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Buton_OKActionPerformed

    public void updateHistogram(BufferedImage img)
    {
        values = new int[256];
        int highValue = 0;
        
        // Get pixel number of same color
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                values[img.getRGB(i, j) & 0xFF]++; // Add 1 to that color in values
            }
        }
        
    
        // Get color with most pixels
        minValue = -1;
        for(int i = 0; i < values.length; i++)
        {
            if(values[i] > img.getWidth()*img.getHeight()/100) // Get min and max values for equalisation
            {
                maxValue = i;
                
                if(minValue == -1)
                {
                    if(i == 0)
                        minValue = 0;
                    else
                        minValue = i;
                }
            }
                    
            if(values[i] > values[highValue])
                highValue = i;
        }
        hightvalues.setText(String.valueOf(values[highValue]));
        
        BufferedImage histo = new BufferedImage(histogram.getWidth(), histogram.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = histo.createGraphics();
        
        for(int i = 0; i < values.length; i++)
        {
            g2d.setColor(new Color(i, i, i));
            g2d.drawLine(i, histo.getHeight(), i, histo.getHeight() - (int) ((double)values[i]/values[highValue]*histo.getHeight()));

        }
        g2d.dispose();
        histogram.setIcon(new ImageIcon(histo));
    }
    
    private void Button_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RefreshActionPerformed
        // TODO add your handling code here:
        BufferedImage img = WM.getBufferedSource();
        updateHistogram(img);
    }//GEN-LAST:event_Button_RefreshActionPerformed

    private void Button_EgalisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EgalisationActionPerformed
        // TODO add your handling code here:
        int rgba, value;
        int[] cumul = new int[256];
        
        BufferedImage img = WM.getBufferedSource();
        int tailleMatrice= img.getWidth()*img.getHeight();

        cumul[0] = values[0];
        for(int i=1;i<256;i++){
            cumul[i] = cumul[i-1] + values[i];
        }
        
        float[] arr = new float[256];
        for(int i=0;i<256;i++){
            arr[i] =  (float)((cumul[i]*255.0)/(float)tailleMatrice);
        }
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                rgba = img.getRGB(i, j);
                value = (int) arr[img.getRGB(i, j) & 0xFF];
                
                rgba = (rgba & 0xFF000000) + (value << 16) + (value << 8) + value;
                
                img.setRGB(i, j, rgba);
            }
        }
        updateHistogram(img);
        WM.setBufferedSource(img);
    }//GEN-LAST:event_Button_EgalisationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Histogram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Histogram dialog = new Histogram(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buton_OK;
    private javax.swing.JButton Button_Egalisation;
    private javax.swing.JButton Button_Refresh;
    private javax.swing.JLabel hightvalues;
    private javax.swing.JLabel histogram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
