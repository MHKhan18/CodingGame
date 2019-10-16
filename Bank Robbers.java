import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int V = in.nextInt();
        
        int[] times = new int[V];
        
        for (int i = 0; i < V; i++) {
            int voltTime = 1;
            int C = in.nextInt();
            int N = in.nextInt();
            for ( int j=0; j<N; j++ ){
                voltTime *= 10;
            }
            for ( int j=0; j<(C-N); j++ ){
                voltTime *= 5;
            }
            times[i] = voltTime;
        }
        
        
        // initial assignment
        int[] robbers = new int[R];
        
        for ( int i=0; i<R; i++ ){
            robbers[i] = times[i];
        }
        
        int index = R;
        // times[R] -> nxt val
        for ( int j=0; j <(V-R); j++ ){
            int minInd = minValInd(robbers)[0];
            int minVal = minValInd(robbers)[1];
            
            robbers[minInd] = minVal + times[index];
            index++;
            
        }
        
        Arrays.sort(robbers);
        int res = robbers[R-1];
        
        System.out.println(res);

        
    }
    
    // robbers[0] -> index of min
    // robbers[1] -> val of min
    
     private static int[] minValInd( int[] robbers ){
         
         int[] holder = robbers.clone();
         
         Arrays.sort(holder);
         int min = holder[0];
         
         int j=0;
         for ( int i=0; i<robbers.length; i++ ){
             if ( robbers[i] == min ){
                 break;
             }
             j++;
         }
         
         int[] result = { j , min } ;
         return result;
     }
}