
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class ARP_ARR_maLBP {
    double ARP,ARR;//ARP is average retrieval precision,ARR is average retreival rate
    int C;//no of classes in image database (10)
    int Ci;//no of images in each class (100)
    int NS,NR,ND;//NS is no of retrieved similar images,NR is no of retrived images (to vary from 5,10,15,20,...95)
    //ND is no of similar images in whole database (100)
    double Pr[][];//precision of j th image of i th category 
    double Re[][];//recall for j th image of i th category
    double AP[];//average precision for i th category
    double AR[];//average recall for i th category
    double Feature_Matrix[][];
    //algorithm
    //1. For each  image feature vector 
        //compute its euclidean distance from each feature vector
        //sort these distances in ascending order
        //take first NR images 
        //determine NS no of similar images
        //calculate Pr[][],Re[][];
     ARP_ARR_maLBP(int nr) throws FileNotFoundException, IOException{
        NR=nr;
        ND=100;
        Pr=new double[1000][10];
        Re=new double[1000][10];
        AP=new double[10];
        AR=new double[10];
        ARP=0;
        ARR=0;
        
        
        BufferedReader br_query = new BufferedReader(new FileReader("maLBP_Features.txt"));
        
        int count=0;
         String line_query=null;
         String[] split_query =null;
         String line=null;
         String[] split =null;
         double distances[]=new double[1000];//
         for(int i=0;i<1000;i++){
             //get features of query image
             line_query=br_query.readLine();
             split_query = line_query.split(" ");
             double features_query[]=new double[split_query.length];
             for(int jj=0;jj<split_query.length;jj++){
                  features_query[jj]= Double.parseDouble(split_query[jj]);
                  //distances[i] +=(ip_image.Histogram_maLBP[j]-features[j])*(ip_image.Histogram_maLBP[j]-features[j]);
             }
             BufferedReader br = new BufferedReader(new FileReader("maLBP_Features.txt")); 
             for(int j=0;j<1000;j++){
                 //System.out.println("j="+j+" i="+i);
              line=br.readLine();
              split = line.split(" ");
              double features[]=new double[split.length];
              for(int jj=0;jj<split.length;jj++){
                  features[jj]= Double.parseDouble(split[jj]);
                  //distances[i] +=(ip_image.Histogram_maLBP[j]-features[j])*(ip_image.Histogram_maLBP[j]-features[j]);
                  }
              for(int jj=0;jj<split.length;jj++){
                   distances[j] +=(features_query[jj]-features[jj])*(features_query[jj]-features[jj]);
                  }
              distances[j]=Math.sqrt(distances[j]);
              
             }
             
             //sort the distances in increasing order
              selectionsort mm=new selectionsort(distances);
              //get first NR no of images
              //determine NS the no of retreived similar images
              NS=0;
              int class_index_query;
              int class_index;
              class_index_query=(int)(i/100);
              for(int kk=0;kk<NR;kk++){
                  class_index=(int)(mm.INDEX[kk]/100);
                  if (class_index==class_index_query){
                      NS++;
                  }
              }
              Pr[i][class_index_query]=NS/NR;
              Re[i][class_index_query]=NS/ND;
         }
          
       //calculate AP and AR
         int cn;
         for(int mn=0;mn<10;mn++){
             for(int cc=0;cc<1000;cc++){
                 cn=(int)(cc/100);
                 if(cn==mn){
                 AP[mn]+=Pr[cc][cn];
                 AR[mn]+=Re[cc][cn];
                 }
                 
             }
             AP[mn]=AP[mn]/100;
             AR[mn]=AR[mn]/100;
          }
         
        for(int mn=0;mn<10;mn++){
            ARP +=AP[mn];
            ARR +=AR[mn];
        }
         ARP=ARP/10;
         ARR=ARR/10;
         System.out.println("ARP="+ARP+" ARR="+ARR);
         //mm.dispaly();
        //find first n nearest features
         //display_selected_image(filepath);
         //display_images(noofimages,mm);
    }
    public static void main(String[] ar) throws IOException{
        ARP_ARR_maLBP nv=new ARP_ARR_maLBP(5);
    }
}
