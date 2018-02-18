/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_traffic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java_display.Display;
import java_graphics.LoadImage;
import java_tile.Tile;

/**
 *
 * @author kavyareddy
 */
public class Traffic implements KeyListener {
    
    private int x,y;
    private int ofset;
    
    private double speed;
    
    private boolean left, right, up, down;
    
    private int health;
    private int gear;
    
    public Traffic()
    {
        x=Display.width/2;
        y= Tile.tileHeight*120;   
        ofset=0;
        
        speed = 0.3f;
        health = 3;
        gear=0;
    }
    public void init()
    {
        Display.frame.addKeyListener(this);
        
    }
    public void tick()
    {
        ofset=y- (Display.height-100);
        if(right)
        {
            x += 1;
        }
        if(left)
        {
            x -= 1;
        }
        if(up)
        {
            speed += 0.03f;
            if(speed >= 7)
            {
                speed = 7;
            }
        }
        
        y-=speed;
        if(down)
        {
           speed -= 0.030f; 
           if(speed <=0)
               speed=0;
        }
        
        
    }
    public void setSpeed(double speed)
    {
      this.speed = speed;  
    }
    
    public double getSpeed()
    {
        return speed;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    
    public int getOfset()
    {
        return ofset;
    }
    
    public void setHealth(int health){
		this.health = health;
		
	}
    
	public void drawBoard(Graphics g){
		 int speed1 = (int)speed ;
		switch(speed1){
		
		case 0 : gear = 0; break; 
		case 2 : gear = 1; break; 
		case 4 : gear = 2; break; 
		case 6 : gear = 3; break;
		
		}
		g.setColor(Color.white);
		g.fillRect(10, 10, 150, 80);
	 
		// draw gare ;
		
		g.setColor(Color.BLACK);
 		g.setFont(new Font("arial", Font.BOLD, 25));
		g.drawString("Gear : "+gear, 20, 40);
		g.drawString("Health : " + health, 20, 80);
		
		
	}
	public void GameOver(Graphics g){
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD, 28));
	    g.drawString("Game Over",Display.width/3, Display.height/2);
	}
    
    public void render(Graphics g)
    {
        if(health>0)
        {
        g.setColor(Color.red);
        g.drawImage(LoadImage.playerMotor,x, y-ofset, 40, 60,null);
        }
        else
        {
            GameOver(g);
        }
        
        drawBoard(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT)
        {
          right = true;  
        }
        if(source == KeyEvent.VK_LEFT)
        {
            left = true;
        }
        if(source == KeyEvent.VK_DOWN)
        {
            down = true;
        }
        if(source == KeyEvent.VK_UP)
        {
            up = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT)
        {
          right = false;  
        }
        if(source == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        if(source == KeyEvent.VK_DOWN)
        {
            down = false;
        }
        if(source == KeyEvent.VK_UP)
        {
            up = false;
        }
    }
}
