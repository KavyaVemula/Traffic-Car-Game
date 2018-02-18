/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_tile;

import java.awt.image.BufferedImage;
import java_graphics.LoadImage;

/**
 *
 * @author kavyareddy
 */
public class GrassTile extends Tile{
    
    public GrassTile(int id) {
        super(LoadImage.grass, id);
    }
    
}
