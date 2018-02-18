/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author kavyareddy
 */
public class Tile {
    
    public static Tile[] tiles = new Tile[24];
    
    public static Tile RoadTile = new RoadTile(0);
    public static Tile grassTile = new GrassTile(1);
    public static Tile footPathTile = new FootPathTile(2);
    
    public BufferedImage texture;
    
    public static final int tileWidth = 64, tileHeight=64;
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        tiles[id] = this;
    }
    
    public void render(Graphics g, int x, int y)
    {
      g.drawImage(texture, x, y, null);
    }
    
}
