import java.util.*;
import java.io.*;
import java.math.*;


class Solution {
    
    private static final String OPEN = "([{";
	private static final String CLOSE = ")]}";
	

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String expression = in.next();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("true/false");
        System.out.println(isBalanced(expression));
    }
    
    public static boolean isBalanced(String expression) {
		
		Stack<Character> s = new Stack<Character>();
		boolean balanced = true;
		
		for (int index = 0; balanced && index < expression.length(); index++) {
			char nextCh = expression.charAt(index);
			
			if (isOpen(nextCh)) {
				s.push(nextCh);
				} 
			else if (isClose(nextCh)) {
				if (s.empty()) {
					balanced = false;
					break;
			} 
				else {
					balanced = (OPEN.indexOf(s.pop()) == CLOSE.indexOf(nextCh));
					}
				}
			}
		 return (balanced && s.empty());
		
	}
	
	 
	
	private static boolean isOpen(char ch) {
		return OPEN.indexOf(ch) > -1;
	 }
	private static boolean isClose(char ch) {
		return CLOSE.indexOf(ch) > -1;
	}
}