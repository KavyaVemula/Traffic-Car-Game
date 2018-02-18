/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_display.Display;

import java_tile.Tile;
import java_traffic.Traffic;

/**
 *
 * @author kavyareddy
 */
public class World {
    
    private int[][] tile;
    private int width,height;
    private Traffic traffic;
    
    public World(Traffic traffic)
    {
        loadWorld("res/world.txt");
        this.traffic = traffic;
    }
    
    private int parseInt(String number)
    {
        return Integer.parseInt(number);
    }
    public void loadWorld(String path)
    {
        String file = loadFile(path);
        String[] space = file.split("\\s+");
        width = parseInt(space[0]);
        height = parseInt(space[1]);
        tile = new int[width][height];
        for(int x=0; x<width; x++)
        {
            for(int y=0; y<height; y++)
            {
                tile[x][y] = parseInt( space[2 + (x+y *width)]);
            }
        }
    }
    
    public String loadFile(String path)
    {
        StringBuilder sr = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            
            String line;
            while((line = reader.readLine()) != null)
            {
                sr.append(line +"\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sr.toString();
    }
    
    public void render(Graphics g)
    {
        int start= Math.max(0, (traffic.getOfset())/Tile.tileHeight);
                int end=Math.min(height, (traffic.getOfset()+Display.height+20)/Tile.tileHeight);
      for(int i=0; i<width; i++)
      {
          for(int j=start; j<end; j++)
          {
              
              Tile t = Tile.tiles[tile[i][j]];
              t.render(g, i*Tile.tileWidth, (j*Tile.tileHeight)-traffic.getOfset());
          }
      }
    }
    
}
