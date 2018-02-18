/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author kavyareddy
 */
public class LoadImage {
    
    public static BufferedImage Motors, playerMotor, enemyMotor, fullImage, road, grass, footpath;
    
    public static void init()
    {
     fullImage = imageLoader("/grid.png");  
     playerMotor = imageLoader("/motor.png");
     enemyMotor = imageLoader("/enemy.png");
     crop();
    }
    public static BufferedImage imageLoader(String path)
    {
        try {
        return ImageIO.read(LoadImage.class.getResource(path));
        } 
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    public static void crop()
    {
       grass = fullImage.getSubimage(0,0, 130, 119);
       road = fullImage.getSubimage(130, 0, 130, 119); 
       footpath = fullImage.getSubimage(130*2, 0, 130, 119);
    }
    
    
    
    
    
    
}
