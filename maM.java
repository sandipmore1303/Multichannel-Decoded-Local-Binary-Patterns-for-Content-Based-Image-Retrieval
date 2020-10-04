/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class maM {
    
    LBP lbp;
    int maM[][][];
    public maM(LBP p){
        lbp=p;
        maM=new int[lbp.height][lbp.width][8];
        for(int row=0;row<lbp.height;row++)
            for(int col=0;col<lbp.width;col++)
            {
              for(int i=0;i<8;i++){
                  maM[row][col][i]=lbp.LBP_1_8[row][col][i]+lbp.LBP_2_8[row][col][i]+lbp.LBP_3_8[row][col][i];
                  
              }  
            }
        
        
        
    }
}
