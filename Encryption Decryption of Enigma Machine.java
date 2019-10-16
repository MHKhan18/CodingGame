import java.util.*;
import java.io.*;
import java.math.*;


class Solution {
    
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        String operation = in.nextLine();
        //System.out.println(operation);
        int pseudoRandomNumber = in.nextInt();
        in.nextLine();
        
        String rotor1 = "";
        String rotor2 = "";
        String rotor3 = "";
        
        for (int i = 0; i < 3; i++) {
           
            String rotor = in.nextLine();
            
            if ( i==0){
                rotor1 = rotor;
            }
            if ( i==1){
                rotor2 = rotor;
            }
             if ( i==2){
                rotor3 = rotor;
            }
            
        }
        String message = in.nextLine();
        //System.out.println(message);
        
        if ( operation.equals("ENCODE") ){
            
            String shifted = shift( message, pseudoRandomNumber , 1 );
            String translate1 = translate( ALPHABET, shifted, rotor1 );
            String translate2 = translate( ALPHABET, translate1, rotor2);
            String translate3 = translate( ALPHABET, translate2, rotor3 );
            System.out.println( translate3);
        }
        
         if ( operation.equals("DECODE") ){
            
            String translate1 = translate( rotor3, message, ALPHABET );
            String translate2 = translate( rotor2, translate1, ALPHABET);
            String translate3 = translate( rotor1, translate2, ALPHABET );
            
             String shifted = shift( translate3, -1*pseudoRandomNumber , -1 );
           
           
            System.out.println(shifted);
        }
        
        }
        
        // from ALPHABET to rotor during encryption
        // from rotor to ALPHABET during decryption
    private static String translate ( String from, String message, String to){
        String result = "";
       
        for ( int i=0; i < message.length(); i++ ){
            String lett = message.substring(i,i+1);
            int index = from.indexOf( lett );
            result = result.concat( to.substring( index, index+1 ) );;
            }
        return result ;
        
        }
        
    private static String shift ( String message, int num, int change){
        String result = "";
        for ( int i=0; i < message.length(); i++ ){
            String lett = message.substring(i,i+1);
            int index = ALPHABET.indexOf( lett );
            int newIndex = num + index ;
            
            if ( newIndex > 25 ) {
                newIndex = newIndex % 26 ;
            }
            if ( newIndex < 0 ){
                
                if ( (newIndex % 26 ) == 0 ){
                    newIndex = 0 ;
                }
                else if ( newIndex < -26){
                    newIndex = ( newIndex % 26 ) + 26 ;
                }
                else{
                    newIndex = newIndex+26;
                    }
               // System.out.println(newIndex);
            }
            result = result.concat( ALPHABET.substring( newIndex, newIndex+1 ) );
            num+=change; 
            }
        return result ;
    }
}