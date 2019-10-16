import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tributes = in.nextInt();
        ArrayList<Tribute> tribs = new ArrayList<>();
        
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < tributes; i++) {
            String playerName = in.nextLine(); 
            tribs.add ( new Tribute( playerName ) );
            }
        Collections.sort( tribs );
        
        int turns = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
         // builds field killed
        for (int i = 0; i < turns; i++) {
            String info = in.nextLine(); 
            int space = info.indexOf(" ");
            String name = info.substring(0,space);
            for ( Tribute trib : tribs ){
                if ( trib.getName().equals( name ) ){
                    String vics = info.substring( space+8 ); 
                    if ( vics.indexOf(",") != -1 ){
                        String[] vicLst = vics.split(",");
                        for ( int j=0; j<vicLst.length; j++ ){
                            trib.addVictim( vicLst[j].trim() );
                        }
                    }
                    else{
                        trib.addVictim( vics );
                    }
                }
            }
        }
        
        // builds field killer
        for ( Tribute trib : tribs ){
            String name = trib.getName();
            for ( Tribute player : tribs ){
                for ( String victim : player.getVictims() ){
                    //System.out.println(victim);
                    if ( victim.trim().equals( name ) ){
                        trib.setKiller( player.getName() );
                    }
                }
            }
            
            if ( trib.getKiller().equals("") ){
                trib.setKiller("Winner");
            }
        }
        
        for ( int i=0; i<tribs.size(); i++ ){
            System.out.println(tribs.get(i));
            if( i != tribs.size()-1 ){System.out.println();}
        }
    }
}

class Tribute implements Comparable<Tribute>{
    private  String name;
    private  ArrayList<String>killed = new ArrayList<>() ;
    private String killer = "";
    
    public Tribute( String name ){
        this.name = name;
    }
    
    public void addVictim( String victim){
        killed.add( victim );
        Collections.sort(killed);
    }
    
    public void setKiller( String killer){
        this.killer = killer;
    }
    
    public String  getName(){
        return name;
    }
    
    public ArrayList<String> getVictims(){
        return killed;
    }
    
    public String getKiller(){
        return killer;
    }
    
    private String killedLst(){
        String res="";
        for ( int i=0; i<killed.size(); i++ ){
            res += killed.get(i);
            if ( i != killed.size()-1 ){ res += ", "; }
        }
        
        if ( res.equals("") ){ res = "None" ;}
            
        
        return res;
    }
    
    public String toString(){
        return "Name: " + name + "\n" +
                "Killed: " + killedLst() + "\n" +
                "Killer: " + killer ;
    }
    
    public int compareTo( Tribute other ){
        return name.compareTo( other.getName() );
    }
}