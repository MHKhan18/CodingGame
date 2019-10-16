import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("YES|NO");
        
        boolean meet = false;
        int num = r1-1;
        
        ArrayList<Integer> store = new ArrayList<>();
        
         
       String strRep = Integer.toString(r1);
       
       int check = ((Integer.parseInt( strRep.substring(0,1) ) -1) + ( strRep.length() -1 )) * 9; 
       
      
    
   // while ( num > 0 ){
       
       for ( int i=0; i< check ; i++ ){
            int rivK = num;
            if ( store.contains(rivK) ){
                continue;}
          
            
            // producing the river for each number
            while ( rivK < r1 ){
                int holder = rivK;
                int increment = 0;
                while ( holder > 0){
                    increment += holder%10;
                    holder /= 10;
                }
                
                rivK += increment;
                store.add(rivK);
                
            }
            
            if ( rivK == r1){
                meet = true;
                break;
            }
            
            num--;
        }
        
        if ( meet ){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}