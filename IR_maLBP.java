
import ij.ImagePlus;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class IR_maLBP {
    
    double distances[];
    maLBP ip_image;
    public IR_maLBP(int noofimages) throws FileNotFoundException, IOException{
        //take ip image
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Image");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }

        String filepath = chooser.getSelectedFile().toString();
        //find its malbp feature 
        I image = new I(filepath);
        LBP lbp = new LBP(image);
        lbp.compute_LBP(image);
        maM ma = new maM(lbp);
        ip_image = new maLBP(ma);
        ip_image.compute_Hist_maLBP_t1();
        
    //compare it with every malbp feature in database . find distance of it from every feature
        //1 read feature file
        //store the
         BufferedReader br = new BufferedReader(new FileReader("maLBP_Features.txt"));
         int count=0;
         String line=null;
         String[] split =null;
         distances=new double[1000];//
         for(int i=0;i<1000;i++){//
             line=br.readLine();
             split = line.split(" ");
             double features[]=new double[split.length];
             for(int j=0;j<split.length;j++){
                  features[j]= Double.parseDouble(split[j]);
                  distances[i] +=(ip_image.Histogram_maLBP[j]-features[j])*(ip_image.Histogram_maLBP[j]-features[j]);
             }
             distances[i]=Math.sqrt(distances[i]);
             //System.out.println(split.length);
             //System.out.println(distances[i]);    
         }
         

        
        //sort the distances in increasing order
         selectionsort mm=new selectionsort(distances); 
         //mm.dispaly();
        //find first n nearest features
         display_selected_image(filepath);
         display_images(noofimages,mm);
        //display corresponding n images      
    }
    public static void main(String[] ar) throws IOException{
        IR_maLBP ir=new IR_maLBP(10);
    }

    

    private void display_images(int noofimages, selectionsort mm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < noofimages; i++) {
            JFrame frame_oi = new JFrame("Retrieved Image:"+Integer.toString(mm.INDEX[i])+".jpg");
            Panel panel_oi = new ShowImage("DB1000\\"+Integer.toString(mm.INDEX[i])+".jpg");
            //Panel panel_oi = new ShowImage("F:\\PROJECT_DATA\\PSM_PROJECT\\maLBP_mdLBP\\DB1000\\0.jpg");
            frame_oi.getContentPane().add(panel_oi);
            frame_oi.setSize(500, 500);
            frame_oi.setVisible(true);
        }
        
    }

    private void display_selected_image(String filepath) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JFrame frame_oi = new JFrame("search image");
    Panel panel_oi = new ShowImage(filepath);
    frame_oi.getContentPane().add(panel_oi);
    frame_oi.setSize(500, 500);
    frame_oi.setVisible(true);
        
    }
}
