/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_manager;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java_enemies.EnemyMotor;
import java_graphics.LoadImage;
import java_traffic.Traffic;
import java_world.World;

/**
 *
 * @author kavyareddy
 */
public class GameManager {
    
    private World world;
    private Traffic traffic;
    
    private long time = System.nanoTime();
    private long delay; 
    private int health;
    
    private ArrayList<EnemyMotor> eMotor;
    
    public GameManager()
    {
        traffic =  new Traffic(); 
        world = new World(traffic);
        eMotor = new ArrayList<EnemyMotor>();
        
        delay= 2000;
        health=3;
    }
    public void init()
    { 
      LoadImage.init();
      traffic.init();      
    }
    public void tick()
    {
        Random rand = new Random();
        int randX = rand.nextInt(300);
        int randY = rand.nextInt(1+ traffic.getOfset());
        
        while(randX < 150)
        {
            randX = rand.nextInt(300);
        }
        
         for(int i = 0 ; i<eMotor.size(); i++){
        	  //player
        	  int px = traffic.getX();
        	  int py = traffic.getY();
        	  // enemy Motor
        	  
        	 int ex = eMotor.get(i).getX();
        	  int ey = eMotor.get(i).getY();
        	     /*  if (r1.x < r2.x +width &&
 	         r1.x + width > r2.x &&
 	         r1.y < r2.y + width &&
 		     r1.y +width > r2.y) */
        	  if(px < ex + 40 && px + 40 > ex &&  
        		 py < ey + 40 &&  py + 40> ey ){
        		   // collided
        		  
        		   eMotor.remove(i);
        		    i--;
        		    health--; 
                             		    
        		    traffic.setSpeed(0);
         		    traffic.setHealth(health);
        	  }
        	  
        	  
          }
        
        
        
        
        long elapsed = (System.nanoTime()-time)/1000000;
        if(elapsed > delay)
        {
            if(traffic.getSpeed()>0)
            {
        eMotor.add(new EnemyMotor(traffic, randX,randY));
            }
        time = System.nanoTime();
        }
       traffic.tick();
       for(int i=0; i<eMotor.size(); i++)
       {
           eMotor.get(i).tick();
       }
    }
    public void render(Graphics g)
    {
      
      
      world.render(g);
      traffic.render(g);
      for(int i=0; i<eMotor.size();i++)
      {
          eMotor.get(i).render(g);
      }
    }
}
