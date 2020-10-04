/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sam
 */
public class LBP {
    int LBP_1[][];
    int LBP_2[][];
    int LBP_3[][];
    int LBP_1_8[][][];
    int LBP_2_8[][][];
    int LBP_3_8[][][];
    int height;
    int width;
    public LBP(I image){
        LBP_1=new int[image.height][image.width];
        LBP_2=new int[image.height][image.width];
        LBP_3=new int[image.height][image.width];
        LBP_1_8=new int[image.height][image.width][8];
        LBP_2_8=new int[image.height][image.width][8];
        LBP_3_8=new int[image.height][image.width][8];
        height=image.height;
        width=image.width;
    }
    public void compute_LBP(I image){
        for(int row=0;row<image.height;row++)
            for(int col=0;col<image.width;col++)
            {
                if (check_constrains(row, col + 1)) {
                    if (image.I_1[row][col + 1] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][0] = 1;
                    } else {
                        LBP_1_8[row][col][0] = 0;
                    }

                    if (image.I_2[row][col + 1] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][0] = 1;
                    } else {
                        LBP_2_8[row][col][0] = 0;
                    }

                    if (image.I_3[row][col + 1] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][0] = 1;
                    } else {
                        LBP_3_8[row][col][0] = 0;
                    }

                } else {
                    LBP_1_8[row][col][0] = 0;
                    LBP_2_8[row][col][0] = 0;
                    LBP_3_8[row][col][0] = 0;
                }
               
                
                
                
                 if (check_constrains(row+1, col + 1)) {
                    if (image.I_1[row+1][col + 1] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][1] = 1;
                    } else {
                        LBP_1_8[row][col][1] = 0;
                    }

                    if (image.I_2[row+1][col + 1] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][1] = 1;
                    } else {
                        LBP_2_8[row][col][1] = 0;
                    }

                    if (image.I_3[row+1][col + 1] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][1] = 1;
                    } else {
                        LBP_3_8[row][col][1] = 0;
                    }

                } else {
                    LBP_1_8[row][col][1] = 0;
                    LBP_2_8[row][col][1] = 0;
                    LBP_3_8[row][col][1] = 0;
                }
                 
                 
                 
                  if (check_constrains(row+1, col)) {
                    if (image.I_1[row+1][col] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][2] = 1;
                    } else {
                        LBP_1_8[row][col][2] = 0;
                    }

                    if (image.I_2[row+1][col] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][2] = 1;
                    } else {
                        LBP_2_8[row][col][2] = 0;
                    }

                    if (image.I_3[row+1][col] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][2] = 1;
                    } else {
                        LBP_3_8[row][col][2] = 0;
                    }

                } else {
                    LBP_1_8[row][col][2] = 0;
                    LBP_2_8[row][col][2] = 0;
                    LBP_3_8[row][col][2] = 0;
                }
                 
                 
                 
                  if (check_constrains(row+1, col-1)) {
                    if (image.I_1[row+1][col-1] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][3] = 1;
                    } else {
                        LBP_1_8[row][col][3] = 0;
                    }

                    if (image.I_2[row+1][col-1] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][3] = 1;
                    } else {
                        LBP_2_8[row][col][3] = 0;
                    }

                    if (image.I_3[row+1][col-1] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][3] = 1;
                    } else {
                        LBP_3_8[row][col][3] = 0;
                    }

                } else {
                    LBP_1_8[row][col][3] = 0;
                    LBP_2_8[row][col][3] = 0;
                    LBP_3_8[row][col][3] = 0;
                }
                  
                  
                  
                  
                  if (check_constrains(row, col-1)) {
                    if (image.I_1[row][col-1] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][4] = 1;
                    } else {
                        LBP_1_8[row][col][4] = 0;
                    }

                    if (image.I_2[row][col-1] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][4] = 1;
                    } else {
                        LBP_2_8[row][col][4] = 0;
                    }

                    if (image.I_3[row][col-1] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][4] = 1;
                    } else {
                        LBP_3_8[row][col][4] = 0;
                    }

                } else {
                    LBP_1_8[row][col][4] = 0;
                    LBP_2_8[row][col][4] = 0;
                    LBP_3_8[row][col][4] = 0;
                }
                  
                  
                  
                  if (check_constrains(row-1, col-1)) {
                    if (image.I_1[row-1][col-1] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][5] = 1;
                    } else {
                        LBP_1_8[row][col][5] = 0;
                    }

                    if (image.I_2[row-1][col-1] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][5] = 1;
                    } else {
                        LBP_2_8[row][col][5] = 0;
                    }

                    if (image.I_3[row-1][col-1] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][5] = 1;
                    } else {
                        LBP_3_8[row][col][5] = 0;
                    }

                } else {
                    LBP_1_8[row][col][5] = 0;
                    LBP_2_8[row][col][5] = 0;
                    LBP_3_8[row][col][5] = 0;
                }
                  
                  
               if (check_constrains(row-1, col)) {
                    if (image.I_1[row-1][col] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][6] = 1;
                    } else {
                        LBP_1_8[row][col][6] = 0;
                    }

                    if (image.I_2[row-1][col] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][6] = 1;
                    } else {
                        LBP_2_8[row][col][6] = 0;
                    }

                    if (image.I_3[row-1][col] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][6] = 1;
                    } else {
                        LBP_3_8[row][col][6] = 0;
                    }

                } else {
                    LBP_1_8[row][col][6] = 0;
                    LBP_2_8[row][col][6] = 0;
                    LBP_3_8[row][col][6] = 0;
                }   
               
               
               if (check_constrains(row-1, col+1)) {
                    if (image.I_1[row-1][col+1] >= image.I_1[row][col]) {
                        LBP_1_8[row][col][7] = 1;
                    } else {
                        LBP_1_8[row][col][7] = 0;
                    }

                    if (image.I_2[row-1][col+1] >= image.I_2[row][col]) {
                        LBP_2_8[row][col][7] = 1;
                    } else {
                        LBP_2_8[row][col][7] = 0;
                    }

                    if (image.I_3[row-1][col+1] >= image.I_3[row][col]) {
                        LBP_3_8[row][col][7] = 1;
                    } else {
                        LBP_3_8[row][col][7] = 0;
                    }

                } else {
                    LBP_1_8[row][col][7] = 0;
                    LBP_2_8[row][col][7] = 0;
                    LBP_3_8[row][col][7] = 0;
                }
               
               for(int ii=0;ii<8;ii++){
                   LBP_1[row][col] += LBP_1_8[row][col][ii]*(int)Math.pow(2.0, ii*1.0);
                   LBP_2[row][col] += LBP_2_8[row][col][ii]*(int)Math.pow(2.0, ii*1.0);
                   LBP_3[row][col] += LBP_3_8[row][col][ii]*(int)Math.pow(2.0, ii*1.0);
               }
               
            }
    }
    
    public boolean check_constrains(int x,int y){
       
        if((x>=0 && x< height) && (y>=0 && y< width))
        { //System.out.println("x="+x+"y="+y+" true");
            return true;
        }
        else 
        {//System.out.println("x="+x+"y="+y+" false");
            return false;
        }
    }

    
}
