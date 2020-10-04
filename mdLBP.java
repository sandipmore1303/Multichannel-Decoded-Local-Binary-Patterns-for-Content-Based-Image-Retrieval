/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class mdLBP {
    
    mdM am;
    int mdLBP_t1_n[][][][];
    int mdLBP_t1[][][];
    int Hist_mdLBP_t1[][];
    double Histogram_mdLBP_t1[][];
    double Histogram_mdLBP[];
    public mdLBP(mdM p){
        am=p;
        mdLBP_t1_n=new int[am.lbp.height][am.lbp.width][8][8];
        mdLBP_t1=new int[am.lbp.height][am.lbp.width][8];
        Hist_mdLBP_t1=new int[8][256];
        Histogram_mdLBP_t1=new double[8][256];
        Histogram_mdLBP=new double[8*256];
        for(int row=0;row<am.lbp.height;row++)
            for(int col=0;col<am.lbp.width;col++)
            {
              for(int i=0;i<8;i++){
                   for(int j=0;j<8;j++){
                       if(am.mdM[row][col][j]==i){
                       mdLBP_t1_n[row][col][i][j]=1;
                       }
                       else{
                           mdLBP_t1_n[row][col][i][j]=0;
                       } 
                   }
                   for(int jj=0;jj<8;jj++){
                       mdLBP_t1[row][col][i] += mdLBP_t1_n[row][col][i][jj]*(int)Math.pow(2.0, jj*1.0);     
                   }
                  
              }  
            }
        
    }
    public void compute_Hist_mdLBP_t1(){
        for(int row=0;row<am.lbp.height;row++)
            for(int col=0;col<am.lbp.width;col++)
            {
              for(int i=0;i<8;i++){
                Hist_mdLBP_t1[i][mdLBP_t1[row][col][i]]++;  
              }
            }
        
        
        int k=0;
        for(int c=0;c<8;c++){
            for(int jj=0;jj<256;jj++){
               Histogram_mdLBP_t1[c][jj]= (double)Hist_mdLBP_t1[c][jj]/(am.lbp.height*am.lbp.width);
               Histogram_mdLBP[k]=Histogram_mdLBP_t1[c][jj];
               k++;
            }
        }
       
            
        
    }
}
