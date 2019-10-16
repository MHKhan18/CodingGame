import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String xthenCOMMANDS = in.nextLine();
       // System.out.println(xthenCOMMANDS);
        
        String[] commands =  xthenCOMMANDS.split(";") ;
        int x = Integer.parseInt( commands[0] );
        
        
        
        String ROAD = "";
        ArrayList<String> road = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String rthenROADPATTERN = in.nextLine();
            String[] parts = rthenROADPATTERN.split(";");
            int r = Integer.parseInt ( parts[0] );
            //System.out.println(parts[1].length());
            for ( int j=0; j<r; j++ ){
                ROAD += parts[1] + "\n" ;
                road.add(  parts[1]  );
            }
        }
        
        //System.out.println(ROAD);
        
        // insert into initial pos 
        String line1 = road.get(0);
        String nline1 = "";
        for ( int i=0; i<x-1 ; i++ ){
            nline1 += line1.substring(i,i+1) ;
        }
        nline1 += "#";
        for ( int i=x ; i<line1.length() ; i++ ){
            nline1 += line1.substring(i,i+1) ;
        }
        
        //System.out.println(nline1);
        
        
         ArrayList<String> res = new ArrayList<>();
         res.add ( nline1);
         
         
         int lineCount = 1;
         int totalLine = road.size();
        
        // for each command 
        for ( int i=1; i< commands.length; i++ ){
            
            String[] comParts = commands[i].split("(?<=\\d)(?=\\D)");
            int rep = Integer.parseInt(comParts[0]);
            String com = comParts[1];
            //System.out.println(com);
            
             // have to decrement rep by one for the first command
            if ( i==1){
                rep--;
            }
                
            
            
            // repeat command rep times
            for ( int j=0; j<rep; j++ ){
                
                // each new line
                String nln="";
                
                String currLine = road.get(lineCount);
                int prevPos = res.get(lineCount-1).indexOf("#");
                
                
                // for S
                if ( com.equals("S") ){
                    
                    nln += currLine.substring(0,prevPos) ;
                    nln += "#";
                    nln += currLine.substring(prevPos+1) ;
                }
                // for R
                if ( com.equals("R") ){
                    nln += currLine.substring(0,prevPos+1) ;
                    nln += "#";
                    nln += currLine.substring(prevPos+2) ;
                }
                // for L
                if ( com.equals("L") ){
                    nln += currLine.substring(0,prevPos-1) ;
                    nln += "#";
                    nln += currLine.substring(prevPos) ;
                }
                
                lineCount++;
                res.add( nln );
            }
        }
        
        for ( int i=0; i<res.size(); i++ ){
            System.out.println(res.get(i));
        }
    }
}