/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotapp;

/**
 *
 * @author shekh
 */
public class Player {
    int x, y, width, height, hits;
    Robot robot;
    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //this.hits = hits;
    }
    
    public int getX(){
        return x; 
    } 
    
     public int getY(){
         return y;
     }
     
     void move(String s) {
        if((x < width) && (x >= 0) && (y < height) && ( y >= 0)){
            if (s.equals("north"))
                  y += 1;

            else if (s.equals("west"))
                   y -= 1;

            else if (s.equals("east"))
                   x += 1;

            else 
                x -= 1;
         }
        }
     
     public int getHits(){
         if (robot.getX() == x){
             if (robot.getY() == y)
                 hits++;
    }             
        return hits;
     }
     
}        

