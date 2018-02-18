/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_main;

import java_game.GameSetUp;

/**
 *
 * @author kavyareddy
 */
public class Main {
    public static void main(String[] args)
    {
        GameSetUp game= new GameSetUp("Traffic Car Game",500,600);
        game.start();
    }
    
}
