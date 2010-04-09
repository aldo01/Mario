/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import background.Background;
import blokjes.Munt;
import blokjes.Questionmark;
import blokjes.Stone;
import java.util.ArrayList;
import mario.enemy.*;

/**
 *
 * @author danny
 */
public class Game
{
    private boolean running         = false;
    private boolean paused          = false;


    private Mario mario = new Mario();
    private Goomba goomba = new Goomba(300, 512, 66, 66);
    private Background background   = new Background();
    private Munt Munt   = new Munt();
    private Questionmark Questionmark   = new Questionmark();
    private Stone Stone   = new Stone();
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    

    public Game()
    {
        gameObjects.add(background);
        gameObjects.add(mario);
        gameObjects.add(Munt);
        gameObjects.add(Questionmark);
        gameObjects.add(goomba);
        gameObjects.add(Stone);
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public void setPaused(boolean paused)
    {
        this.paused = paused;
    }
    
    public ArrayList<GameObject> getGameObjects()
    {
        return gameObjects;
    }

    public Mario getMario()
    {
        return mario;
    }

    public Goomba getGoomba()
    {
        return goomba;
    }
}
