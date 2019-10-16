import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int SIZE = in.nextInt();
        double diam = (SIZE) / 2; 
       
       
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>(N);
        for ( int i=0; i<N; i++){
            scores.add(0);
        }
        
        for (int i = 0; i < N; i++) {
            String name = in.nextLine();
            names.add(name);
        }
        int T = in.nextInt();
        
        
        for (int i = 0; i < T; i++) {
            String throwName = in.next();
            int throwX = in.nextInt();
            int throwY = in.nextInt();
            int index = names.indexOf(throwName);
            
            if ( Math.abs( throwX ) <= diam  && Math.abs( throwY ) <= diam ){
                if ( (throwY <= diam-throwX) && (throwY <= throwX+diam) && (throwY >= -diam-throwX) && (throwY >= throwX-diam) ){
                    scores.set( index , scores.get(index)+15 ); 
                }
                else if ( Math.abs( throwY ) <= Math.sqrt(  Math.pow(diam,2) - Math.pow(throwX,2) ) ){
                    scores.set( index , scores.get(index)+10 ); 
                }
                else {
                    scores.set( index , scores.get(index)+5 ); 
                   
                }
            }
            
            
        }
        
         Hashtable< String, Integer > dict = new Hashtable<>();
         
         for ( int i=0; i<N; i++){
             dict.put( names.get(i) , scores.get(i) );
         }
        
        
        Collections.sort(scores);
        Collections.reverse(scores);
        
       
        int lim = N;
        for ( int i=0; i<N ; i++){
            int score = scores.get(i) ;
            
            for ( int j=0; j<lim; j++ ){
                if ( dict.get(names.get(j)) == score ){
                    System.out.print(names.get(j));
                    System.out.print(" ");
                    System.out.println(score);
                    names.remove(j);
                    lim--;
                    break;
                }
            }
            
        }
        }
    
   
}