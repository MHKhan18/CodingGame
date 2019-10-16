import java.util.*;
import java.io.*;
import java.math.*;


class Solution {
    
    private static final double G = 9.81;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // no. of bikes
        int v = in.nextInt();   // no of bends
        
        String alph = "abcdefghijklmnopqrstuvwxyz";
        Hashtable<Integer,String>speedBike = new Hashtable<>();  // speed -> bike
        ArrayList<Integer> speeds  = new ArrayList<>();
        
        
        for (int i = 0; i < n; i++) {
            int speed = in.nextInt();
            speedBike.put(speed,alph.substring(i,i+1));
            speeds.add( speed);
        }
        
        
        ArrayList<Integer> bends  = new ArrayList<>();
        ArrayList<Integer> optVs  = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            int bendR = in.nextInt();
            bends.add(bendR);
            int optV = (int)Math.sqrt(bendR*G*Math.tan(Math.toRadians(60))); 
            optVs.add(optV);
        }
        
        Collections.sort(optVs);
        Collections.sort(speeds);
        Collections.reverse(speeds);
        
        ArrayList< ArrayList<Integer> > falls = new ArrayList< ArrayList<Integer> >();
        // figure out which bike/speed falls in which bend
        for ( int i=0; i<v; i++ ){
            int r = bends.get(i);
            // which bikes fall at each bend
            ArrayList<Integer> fRound = new ArrayList<>();
            for ( int j=0; j<n ; j++ ){
                int spd = speeds.get(j);
                double theta = Math.pow(spd,2)/(r*G);
                int angle = (int)Math.toDegrees(Math.atan(theta));
                if ( angle >= 60 ){
                    fRound.add(spd);
                    speeds.remove( (Integer)spd );
                    n--;
                    j--;
                }
            }
            falls.add(fRound); 
        }
        
        // traverse falls from rear to get the ordered list
        ArrayList<Integer> res = new ArrayList<>();
        
        for ( int i=v-1; i>=0 ; i-- ){
            if ( !falls.get(i).isEmpty() ){
                for ( Integer spd : falls.get(i) ){
                    res.add( spd );
                }
            }
        }
        
        // optimal speed
        System.out.println(optVs.get(0));
        System.out.println("y");
        
        
         //System.out.println(speeds.toString());
         for ( Integer  spd : speeds ){
             System.out.println(speedBike.get(spd));
         }
         
         for ( Integer  spd : res ){
             System.out.println(speedBike.get(spd));
         }
    }
}