
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class Extract_maLBP_Features {
   
     public    Extract_maLBP_Features() throws IOException, WriteException{
      JFileChooser chooser = new JFileChooser();
      chooser.setCurrentDirectory(new java.io.File("."));
      chooser.setDialogTitle("Select Directory");
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      chooser.setAcceptAllFileFilterUsed(false);
      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
          System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
      } else {
          System.out.println("No Selection ");
      }

      String filepath = chooser.getSelectedFile().toString();
      File file = new File(filepath);

      String list[];
      String sCurrentLine;
      BufferedReader br = null;
      
      File file1 = new File("maLBP_Features.txt");
      FileWriter fileWriter = new FileWriter(file1);
      //Number number = null;      
      if (file.isDirectory()) {
          System.out.println("Given file is a directory ");
          list = file.list();
          

          for (int i = 0; i < list.length; i++) {
              String filenamepath = new String(chooser.getSelectedFile() + "\\" + Integer.toString(i)+".jpg");
              System.out.println("Current file=" + filenamepath);
              
              //fileWriter.write(Integer.toString(i)+".jpg: ");
              I image = new I(filenamepath);
              LBP lbp=new LBP(image);
              lbp.compute_LBP(image);
              maM ma=new maM(lbp);
              maLBP malbp=new maLBP(ma);
              malbp.compute_Hist_maLBP_t1();
              for(int ws_c=0;ws_c<malbp.Histogram_maLBP.length;ws_c++){
                //jxl.write.Number number = new jxl.write.Number(ws_c, i, malbp.Histogram_maLBP[ws_c]);
                //sheet.addCell(number); 
                  fileWriter.write(Double.toString(malbp.Histogram_maLBP[ws_c])+" ");
              }
              fileWriter.write("\n");
              //System.out.println(source.dump());
          }
      }
      fileWriter.flush();
      fileWriter.close();
    }
     public static void main(String[] ar) throws IOException, WriteException{
     
     Extract_maLBP_Features elpbf=new Extract_maLBP_Features();
     }
}
