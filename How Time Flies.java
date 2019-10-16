import java.util.*;
import java.io.*;
import java.math.*;


class Solution {
    
    public static int days;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String BEGIN = in.next();
        String[] date = BEGIN.split("\\.");
        int begDay = Integer.parseInt(date[0]);
        int begMon = Integer.parseInt(date[1]);
        int begYr = Integer.parseInt(date[2]);
        String END = in.next();
        String[] eDate = END.split("\\.");
        int endDay = Integer.parseInt(eDate[0]);
        int endMon = Integer.parseInt(eDate[1]);
        int endYr = Integer.parseInt(eDate[2]);

       
        
        int currDay = begDay;
        int currMon = begMon;
        int currYr = begYr;
        
        // count variables
         days = 0;
        int month = 0;
        int year = 0;
        
        // dict month: days
        // make no. of days in Feb dependent on curr yr
        Hashtable< Integer, Integer> dayMon = new Hashtable<>();
        dayMon.put(1,31);
        if ( isLeapYr( currYr ) ){
             dayMon.put(2,29);
        }
        else{
            dayMon.put(2,28);
        }
        dayMon.put(3,31);
        dayMon.put(4,30);
        dayMon.put(5,31);
        dayMon.put(6,30);
        dayMon.put(7,31);
        dayMon.put(8,31);
        dayMon.put(9,30);
        dayMon.put(10,31);
        dayMon.put(11,30);
        dayMon.put(12,31);
        
        // caes like 02/29 to nxt yr 02/28
        
        // split days
        while ( currDay != endDay && trapCheck(  currDay ,  currMon,  currYr,  endDay,  endMon,  endYr)){
             if ( isLeapYr( currYr ) ){
                 dayMon.put(2,29);
            }
            else{
                dayMon.put(2,28);
            }
            currDay++;
            days++;
            
            if ( currDay > dayMon.get(currMon) ){
                currDay = 1;
                currMon++;
            }
            
            if ( currMon > 12 ){
                currMon = 1;
                currYr++;
            }
        }
        
        // split months
        while ( currMon != endMon ){
             if ( isLeapYr( currYr ) ){
                 dayMon.put(2,29);
            }
            else{
                dayMon.put(2,28);
            }
            days += dayMon.get(currMon);
            currMon++;
            month++;
            if ( currMon > 12 ){
                currMon = 1;
                currYr++;
            }
            
            
        }
        
        // years
        while ( currYr != endYr ){
             if ( ((currMon>2)&&isLeapYr(currYr+1)) || ((currMon<=2)&&isLeapYr(currYr)) ){ // which years feb matters?
                days+= 366;
            }
            else{
                days += 365;
            }
            currYr++;
            year++;
        }
        
        
        // res format
        if ( year > 0){
            if ( year == 1){
                System.out.print(Integer.toString(year)+" year, ");
             }
             else{
                System.out.print(Integer.toString(year)+" years, ");
             }
        }
        
         if ( month > 0 && month%12 != 0){
             if ( month == 1){
                System.out.print(Integer.toString(month)+" month, ");
             }
             else{
                System.out.print(Integer.toString(month)+" months, ");
             }
        }
        if ( days == 1){
             System.out.print("total " + Integer.toString(days) + " day");
        }
        else{  
            System.out.print("total " + Integer.toString(days) + " days"); 
        }
    }
    
    
    public static boolean isLeapYr( int currYr ){
        if ( (currYr%4) == 0){
            if ( currYr % 100 != 0 ){
                return true;
            }
            if ( currYr % 400 == 0 ){
                return true;
            }
        }
        return false;
    }
    
    public static boolean trapCheck( int currDay , int currMon, int currYr, int endDay, int endMon, int endYr){
        if( isLeapYr(currYr) && !isLeapYr(endYr) ){
            if ( currMon == endMon && endMon == 2){
                if ( currDay==29 && endDay==28 ){
                    return false ; // same day
                }
            }
        }
        
        if( !isLeapYr(currYr) && isLeapYr(endYr) ){
            if ( currMon == endMon && endMon == 2){
                if ( currDay==28 && endDay==29 ){
                    days++;
                    return false ; // same day
                }
            }
        }
        
        return true;
    }
    
}