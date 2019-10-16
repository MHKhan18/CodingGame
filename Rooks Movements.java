import java.util.*;
import java.io.*;
import java.math.*;


 
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        String rookPosition = in.next();
       // System.out.println(rookPosition );
        String[] parts = rookPosition.split("(?<=\\D)(?=\\d)");
        String letPos = parts[0];
        int numPos = Integer.parseInt(parts[1]);
       
       // rook white
       int  ALLY = 0;
        
        // piece position : color
        Hashtable<String,Integer> pieces = new Hashtable<>();
        
        // piece positions
        ArrayList<String>pos = new ArrayList<>();
        
        // store hte positions of opposition pieces
        ArrayList<String> opp = new ArrayList<>();
        
        
        int nbPieces = in.nextInt();
        //System.out.println("parts:");
        for (int i = 0; i < nbPieces; i++) {
            int color = in.nextInt();
            String onePiece = in.next();
           // System.out.println(onePiece);
            
            pieces.put( onePiece, color );
            pos.add( onePiece );
            if ( color != ALLY) {
                opp.add( onePiece );
            }
        }
        
        // hor positions of all the pieces in the row of the rook 
        ArrayList<String> letts = new ArrayList<>();
        // ver positions of all the pieces in the col of the rook 
        ArrayList<Integer> digis = new ArrayList<>();
        
        for ( int i=0; i<pos.size(); i++ ){
            
            String position = pos.get(i);
            
            // match letter
            if ( position.substring(0,1).equals(letPos) ){
                // store matching ver pos
                int digit = Integer.parseInt(position.substring(1));
                // check ally / opp
                if ( pieces.get( position) != ALLY ){
                    digis.add( digit) ;
                }
                else{
                    if ( digit < numPos ){
                        digis.add( digit+1);
                    }
                    if ( digit > numPos ){
                        digis.add( digit -1 );
                    }
                }
            }
            
            // match digit 
            if ( Integer.parseInt(position.substring(1)) == numPos ){
                // store corresponding hor pos
                char letter = position.charAt(0) ;
                char rookLet = letPos.charAt(0); // for comparison
                
                // check ally / opp
                if ( pieces.get( position) != ALLY ){
                    letts.add( position.substring(0,1) ) ;
                }
                
                else{
                    if ( letter < rookLet ){
                        letts.add ( Character.toString((char)letter+1) ) ;
                        }
                    if ( letter > rookLet ){
                        letts.add ( Character.toString((char)letter-1) );
                        }
                    }
            }
        }
        
        Collections.sort( letts );
        Collections.sort( digis );
        
        String alphabets = "abcdefgh" ;
        int[] numbers = { 1,2,3,4,5,6,7,8 };
        
        
      
        int alphS = 0;
        int alphE = 7;
        
        if ( !(letts.isEmpty()) && letts.size()>1 ){
              alphS = alphabets.indexOf( letts.get(0) );
              alphE = alphabets.indexOf ( letts.get ( letts.size() -1 ) ); 
            }
        else if ( letts.size() == 1){
            if ( letts.get(0).charAt(0) > letPos.charAt(0) ){
                alphE = alphabets.indexOf( letts.get(0) );
            }
            else{
                alphS = alphabets.indexOf( letts.get(0) );
            }
        }
       
        
        ArrayList<String> res = new ArrayList<>();
        
        // print hor possibilities 
        for ( int i= alphS ; i<= alphE ; i++ ) {
            if ( i== alphabets.indexOf( letPos ) ){
                continue;
            }
            //System.out.println(alphabets.substring(i,i+1) + Integer.toString(numPos));
            
            String avPos = alphabets.substring(i,i+1) + Integer.toString(numPos) ;
            
            if ( !(opp.isEmpty()) && opp.contains(avPos) ){
                avPos = "x"+ avPos ;
            }
            else{
                avPos = "-" + avPos ;
            }
            
            res.add("R" + rookPosition + avPos );
            
        }
       
        
        int numS = 1;
        int numE = 8;
        if ( !(digis.isEmpty()) && digis.size() > 1 ){
             numS = numbers[ digis.get(0) - 1 ];
             numE = numbers[ digis.get ( digis.size() -1 ) - 1];
        }
        
        else if ( digis.size() == 1) {
            if ( digis.get(0) > numPos ){
                numE = digis.get(0);
            }
            else{
                numS = digis.get(0);
            }
        }
        
     // print vertical possibilities
        for ( int i= numS ; i<= numE ; i++ ){
            if ( i == numPos ) {
                continue;
            }
            //System.out.println(letPos + Integer.toString(i));
            String avPos = letPos + Integer.toString(i) ;
            
            if ( !(opp.isEmpty()) && opp.contains(avPos) ){
                avPos = "x"+ avPos ;
            }
            else{
                avPos = "-" + avPos ;
            }
            
            res.add("R" + rookPosition + avPos );
        }
        
        Collections.sort( res );
        
        for ( int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}