/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_display;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author kavyareddy
 */
public class Display {
    private String title;
    public static int width;
    public static int height;
    public static JFrame frame;
    public static Canvas canvas;
    
    public Display(String tile,int width,int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
        
    }
    public void createDisplay()
    {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
        
        
    }
                      
    
}
