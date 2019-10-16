import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("42");
        
        while ( r1 !=r2){
            
            if ( r2 > r1) {
                
                long rc = r1;
                long increment = 0;
                
                while ( rc > 0){
                    increment += rc%10;
                    rc = rc/10;
                }
                
                r1 += increment;
                continue;
            }
            
            if ( r1 > r2) {
                
                long rc = r2;
                long increment = 0;
                
                while ( rc > 0){
                    increment += rc%10;
                    rc = rc/10;
                }
                
                r2 += increment;
                continue;
            }
        }
        
        System.out.println(r1);
    }
}