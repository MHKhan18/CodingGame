import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        Point[] vertices = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Point vertex = new Point(x,y);
            vertices[i] = vertex;
        }
        
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Point p = new Point(x,y);
            
            if (isInside( p, vertices )) {
                System.out.println("hit");}
                else{
                System.out.println("miss");}
        }

        
    }
    
    
    // jordan's curve theorem 
    private static boolean  isInside( Point p, Point[] vertices ){
        
        boolean res = false;
        
        
        int j= vertices.length-1;
        
        for ( int i=0; i < vertices.length;j= i++){
            if ( ( vertices[i].getY() > p.getY() ) !=  ( vertices[j].getY() > p.getY() ) 
                                &&
                p.getX() < ( vertices[j].getX()-vertices[i].getX() ) * ( p.getY() - vertices[i].getY() ) / (vertices[j].getY() - vertices[i].getY() ) + vertices[i].getX() )
                {
                    res = !res;
                }
                
            }
            
        return res;
        
    }
}