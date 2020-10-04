/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
 
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class I {
   BufferedImage image;
   int width;
   int height;
   
   int I_1[][];
   int I_2[][];
   int I_3[][];
   public I(String filename) {
      try {
         File input = new File(filename);
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         I_1=new int[height][width];
         I_2=new int[height][width];
         I_3=new int[height][width];
         int count = 0;
         
         for(int i=0; i<height; i++){
         
            for(int j=0; j<width; j++){
            
               count++;
               Color c = new Color(image.getRGB(j, i));
               I_1[i][j]=c.getRed();
               I_2[i][j]=c.getGreen();
               I_3[i][j]=c.getBlue();
               //System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
            }
         }
         
      } catch (Exception e) {}
   }
   
   static public void main(String args[]) throws Exception 
   {
      I image = new I("111.jpg");
      LBP lbp=new LBP(image);
      lbp.compute_LBP(image);
      maM ma=new maM(lbp);
      maLBP malbp=new maLBP(ma);
      malbp.compute_Hist_maLBP_t1();
      int count=0;
      for(int i=0;i<256*4;i++)
      {//count +=malbp.Hist_maLBP_t1[0][i];
         // System.out.println(malbp.Hist_maLBP_t1[0][i]+" "+malbp.Hist_maLBP_t1[1][i]+" "+malbp.Hist_maLBP_t1[2][i]+" "+malbp.Hist_maLBP_t1[1][i]);
      //System.out.println(malbp.Histogram_maLBP[i]);
      }
      //System.out.println(image.height*image.width+"  "+count);
      I image1 = new I("111.jpg");
      LBP lbp1=new LBP(image1);
      lbp1.compute_LBP(image1);
      mdM ma1=new mdM(lbp1);
      mdLBP malbp1=new mdLBP(ma1);
      malbp1.compute_Hist_mdLBP_t1();
      count=0;
      for(int i=0;i<256;i++)
      {count +=malbp1.Hist_mdLBP_t1[1][i];
         System.out.println(malbp1.Hist_mdLBP_t1[0][i]+" "+malbp1.Hist_mdLBP_t1[1][i]+" "+malbp1.Hist_mdLBP_t1[2][i]+" "+malbp1.Hist_mdLBP_t1[1][i]);
      //System.out.println(malbp1.Histogram_mdLBP[i]);
      }
      System.out.println(image.height*image.width+"  "+count);
   }
}