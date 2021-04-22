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
public class Robot {
    int x, y, width, fuel;
    int playerX, playerY;
    Player player;
    
    public Robot(int x, int y, int fuel,Player player){
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        this.player = player;
        //this.prob = prob;
        
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    void move(){
        if(fuel > 0){
            if (player.getX() > x){
                x++;
            }
            else 
                x--;

            if (player.getY() > y){
                y++;
            }
            else
                y--;
            }
        fuel--;
    }
    
    
    boolean isExploded()  {
        if (playerX == x){
            if(playerY == y)
                return true;
        }
        return false;
    }
    /*public String toString(){
        String s = new String();
        s += "\nThe different value are: \n"+"x and y of robot are"+x+y ;
        return s;
    }*/
}
