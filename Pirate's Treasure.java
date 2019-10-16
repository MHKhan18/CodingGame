import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    private static int cornerOb = 3;
    private static  int edgeOb = 5;
    private static int insideOb = 8;
    
    private static List<List<Integer>> board = new ArrayList<List<Integer>>();
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        for (int i = 0; i < H; i++) {
            List<Integer> line = new ArrayList<Integer>();
            for (int j = 0; j < W; j++) {
                int v = in.nextInt();
                line.add(v);
            }
            board.add(line);
        }
        
        int x=0;
        int y=0;
        //traversal
        for (int i = 0; i < H; i++) {
           for (int j = 0; j < W; j++) {
                if ( getVal(i,j) == 0){
                    //cases
                    if ( detectCorner(i,j,W,H) && obstacleCount(i,j,W,H)==cornerOb ) { x=j ; y=i; }
                    else if ( detectEdge(i,j,W,H) && obstacleCount(i,j,W,H)==edgeOb ) { x=j;y=i; }
                    else if ( detectInside(i,j,W,H) && obstacleCount(i,j,W,H)==insideOb ) { x=j; y=i; }
                }
            }
            
        }
        

        

        System.out.print(x);
        System.out.print(" ");
        System.out.println(y);
    }

    
    private static int getVal ( int row, int col ){
        return board.get(row).get(col);
    }
    
    private static int obstacleCount( int row , int col, int W, int H){
        int count = 0;
        // upper row
        if ( row-1 >= 0){
            if ( col-1 >= 0 && getVal(row-1, col-1) == 1 ){
                count++;
            }
            
            if ( getVal(row-1, col) == 1){
                count++;
            }
            if ( col+1 < W && getVal( row-1, col+1)==1 ){
                count++;
            }
        }
        
        //left
        if ( col-1>=0 && getVal( row, col-1) == 1){
            count++;
        }
        // right
        if ( col+1<W && getVal( row, col+1)==1 ){
            count++;
        }
        
        // bottom row
         if ( row+1 < H){
            if ( col-1 >= 0 && getVal(row+1, col-1) == 1 ){
                count++;
            }
            
            if ( getVal(row+1, col) == 1){
                count++;
            }
            if ( col+1 < W && getVal( row+1, col+1)==1 ){
                count++;
            }
        }
        
        return count;
            
        
    }
    
    private static boolean detectCorner( int row,int col, int W, int H){
        return (row==0 && col==0) || ( row==H-1 && col==0) || ( row==0 && col==W-1) || ( row==H-1 && col==W-1 )  ;
    }
    
    private static boolean detectEdge( int row, int col, int W, int H){
        return row==0 || row==H-1 || col==0 || col==W-1;
    }
    
    private static boolean detectInside( int row, int col, int W, int H){
        return ( row>0 && row<H-1 ) && ( col>0 && col<W-1 );
    }
}