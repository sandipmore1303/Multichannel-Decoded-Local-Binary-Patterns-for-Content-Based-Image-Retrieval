/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class maLBP {
    
    maM am;
    int maLBP_t1_n[][][][];
    int maLBP_t1[][][];
    int Hist_maLBP_t1[][];
    double Histogram_maLBP_t1[][];
    double Histogram_maLBP[];
    public maLBP(maM p){
        am=p;
        maLBP_t1_n=new int[am.lbp.height][am.lbp.width][4][8];
        maLBP_t1=new int[am.lbp.height][am.lbp.width][4];
        Hist_maLBP_t1=new int[4][256];
        Histogram_maLBP_t1=new double[4][256];
        Histogram_maLBP=new double[4*256];
        for(int row=0;row<am.lbp.height;row++)
            for(int col=0;col<am.lbp.width;col++)
            {
              for(int i=0;i<4;i++){
                   for(int j=0;j<8;j++){
                       if(am.maM[row][col][j]==i){
                       maLBP_t1_n[row][col][i][j]=1;
                       }
                       else{
                           maLBP_t1_n[row][col][i][j]=0;
                       } 
                   }
                   for(int jj=0;jj<8;jj++){
                       maLBP_t1[row][col][i] += maLBP_t1_n[row][col][i][jj]*(int)Math.pow(2.0, jj*1.0);     
                   }
                  
              }  
            }
        
    }
    public void compute_Hist_maLBP_t1(){
        for(int row=0;row<am.lbp.height;row++)
            for(int col=0;col<am.lbp.width;col++)
            {
              for(int i=0;i<4;i++){
                Hist_maLBP_t1[i][maLBP_t1[row][col][i]]++;  
              }
            }
        
        
        int k=0;
        for(int c=0;c<4;c++){
            for(int jj=0;jj<256;jj++){
               Histogram_maLBP_t1[c][jj]= (double)Hist_maLBP_t1[c][jj]/(am.lbp.height*am.lbp.width);
               Histogram_maLBP[k]=Histogram_maLBP_t1[c][jj];
               k++;
            }
        }
       
            
        
    }
}
