import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        
        String[][] data = new String[H][W];
        
        
        
        for (int i = -1; i < H; i++) {
            String line = in.nextLine();
            if ( i==-1 ){
                continue;
            }
            String[] arr = line.split("");
            data[i] = arr;
            
            
        }
        
      
        for ( int i=0; i<W; i++){
            if( data[0][i].equals(" ") ){
                continue;
            }
            else{
                String T = data[0][i];
                String B;
                int pos = i;
               
                for ( int j=1; j<H; j++){
                    
                    //check right
                    if ( pos<W-1 && data[j][pos+1].equals("-") ){
                        while ( pos<W && data[j][pos+1].equals("-") ){
                            pos++;
                        }
                        pos++;
                        
                        continue;
                    }
                    
                    //check left
                    if ( pos>0 && data[j][pos-1].equals("-") ){
                        while ( pos>0 && data[j][pos-1].equals("-") ){
                            pos--;
                        }
                        pos--;
                        continue;
                    }
                }
                
                B = data[H-1][pos];
                
                String res = T.concat(B);
                System.out.println(res);
            }
        }
                
         

       
    }
}