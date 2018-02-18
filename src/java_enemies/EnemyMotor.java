/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_enemies;

import java.awt.Graphics;
import java_graphics.LoadImage;
import java_traffic.Traffic;

/**
 *
 * @author kavyareddy
 */
public class EnemyMotor {
   
        private int x ;
        private int y ;
        private Traffic traffic;
	public EnemyMotor(Traffic traffic, int x, int y){
		this.traffic = traffic;
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		y += 1;
	}
	public void render(Graphics g){
		g.drawImage(LoadImage.enemyMotor, x, y-traffic.getOfset(), 40, 70, null);
	}
	public int getX(){
		return x;
		
	}
	public int getY(){
		return y;
	}
	
	
	
} 

