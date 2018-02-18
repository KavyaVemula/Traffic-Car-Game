/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java_display.Display;
import java_manager.GameManager;

/**
 *
 * @author kavyareddy
 */
public class GameSetUp implements Runnable{
    
    private Thread thread;
    private Display display;
    private String title;
    private int width, height;
    private BufferStrategy buffer;
    private Graphics g;
    private int y;
    private GameManager manager;
  
    
    public GameSetUp(String title, int width, int height)
    {
        this.title=title;
        this.width=width;
        this.height=height;
    }
    public void init()
    {
        display = new Display(title,width,height);
        manager = new GameManager();
        manager.init();
    }
    
    public synchronized void start()
    {
        if(thread == null)
        {
       thread = new Thread(this); 
       thread.start();
        }
    }
    public synchronized void stop()
    {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void tick()
    {
        manager.tick();
    }
       
    public void render()
    {
        buffer = display.canvas.getBufferStrategy();
        if(buffer == null)
        {
            display.canvas.createBufferStrategy(3);
            return;
        }
        g = buffer.getDrawGraphics();
        g.clearRect(0,0,width,height);
        
        manager.render(g);
        
        buffer.show();
        g.dispose();
    }
    
    @Override
    public void run()
    {
        init();
        
        int fps=50;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();
        
        while(true)
        {
        
            delta = delta+(System.nanoTime()-current)/timePerTick;
            current = System.nanoTime();
            if(delta>=1)
            {
                tick();
                render();
                delta--;
                
            }
            
        
        }
    }
    
}
