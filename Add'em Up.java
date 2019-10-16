import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        
        ArrayList<Integer> cards = new ArrayList<>();
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            cards.add(x);
        }
        
        Collections.sort(cards);
        
        int sum = 0;
        int increment;
        
        while ( cards.size() > 1 ){
            Collections.sort(cards);
            increment = cards.get(0) + cards.get(1);
            cards.remove(0);
            cards.remove(0);
            cards.add(increment);
            sum += increment;
            
        }
      
        

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(sum);
    }
}