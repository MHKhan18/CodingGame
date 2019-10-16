import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        //System.out.println(N);
        int L = in.nextInt();
        
        int[][] room = new int[N+2][N+2]; // "padding" squares to avoid corner cases
        
       in.nextLine();
        
        for (int i = 1; i < N+1; i++) {
            
            String LINE = in.nextLine();
            
            LINE = LINE.replaceAll("//s+","");
          // System.out.println(LINE);
            String[] line = LINE.split("");
            int size = line.length;
            
            int index=1;
            for ( int j=0; j<size; j+=2 ){
               // room[i][index++] = line[j];
               if ( !(line[j].equals("X")) ){
                   room[i][index] = L;
               }
               index++;
               
            }
        }
      

        for ( int row=1; row<N+1; row++ ){
            for ( int col=1; col<N+1; col++ ){
                
                int cellVal = room[row][col];
                
                if ( cellVal > 0){
                    
                    //left-up
                    int lu = room[row-1][col-1];
                    room[row-1][col-1] = Math.max(lu,cellVal-1);
                    
                    //up 
                    int u = room[row-1][col];
                    room[row-1][col] = Math.max(u,cellVal-1);
                    
                    //right-up
                    int ru = room[row-1][col+1];
                    room[row-1][col+1] = Math.max(ru,cellVal-1);
                    
                    //left
                    int l = room[row][col-1];
                    room[row][col-1] = Math.max(l,cellVal-1);
                    
                    //right
                    int r = room[row][col+1];
                    room[row][col+1] = Math.max(r,cellVal-1);
                    
                    //left-down
                    int ld = room[row+1][col-1];
                    room[row+1][col-1] = Math.max(ld,cellVal-1);
                    
                    //down
                    int d = room[row+1][col];
                    room[row+1][col] = Math.max(d,cellVal-1);
                    
                    //right-down
                    int rd = room[row+1][col+1];
                    room[row+1][col+1] = Math.max(rd,cellVal-1);
                }
                }
            }
            
            
           // traversing 2D array from bottom right to account for superposition effect
           for ( int row=N; row>0; row-- ){
                for ( int col=N; col>0; col-- ){
                
                    int cellVal = room[row][col];
                    
                    if ( cellVal > 0){
                        
                        //left-up
                        int lu = room[row-1][col-1];
                        room[row-1][col-1] = Math.max(lu,cellVal-1);
                        
                        //up 
                        int u = room[row-1][col];
                        room[row-1][col] = Math.max(u,cellVal-1);
                        
                        //right-up
                        int ru = room[row-1][col+1];
                        room[row-1][col+1] = Math.max(ru,cellVal-1);
                        
                        //left
                        int l = room[row][col-1];
                        room[row][col-1] = Math.max(l,cellVal-1);
                        
                        //right
                        int r = room[row][col+1];
                        room[row][col+1] = Math.max(r,cellVal-1);
                        
                        //left-down
                        int ld = room[row+1][col-1];
                        room[row+1][col-1] = Math.max(ld,cellVal-1);
                        
                        //down
                        int d = room[row+1][col];
                        room[row+1][col] = Math.max(d,cellVal-1);
                        
                        //right-down
                        int rd = room[row+1][col+1];
                        room[row+1][col+1] = Math.max(rd,cellVal-1);
                    }
                }
            } 
            
            
        
            
           
         int count = 0 ;
            
          for ( int row=1; row<N+1; row++ ){
              for ( int col=1; col<N+1; col++ ){
                  if (room[row][col] == 0){
                      count+=1;
                  }
              }
          }
          
          System.out.println(count);
                      
            
            
            
        
    }
}