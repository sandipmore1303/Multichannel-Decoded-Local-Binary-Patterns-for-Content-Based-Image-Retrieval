/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class mdM {
    
    LBP lbp;
    int mdM[][][];
    public mdM(LBP p){
        lbp=p;
        mdM=new int[lbp.height][lbp.width][8];
        for(int row=0;row<lbp.height;row++)
            for(int col=0;col<lbp.width;col++)
            {
              for(int i=0;i<8;i++){
                  mdM[row][col][i]=4*lbp.LBP_1_8[row][col][i]+2*lbp.LBP_2_8[row][col][i]+1*lbp.LBP_3_8[row][col][i];
                  
              }  
            }
        
        
        
    }
}
