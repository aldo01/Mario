/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package background;

import java.awt.Polygon;
import java.awt.Rectangle;
import mario.GameObject;

/**
 *
 * @author Onno
 */
public class Background extends GameObject
{
    private Polygon mapLayOut = new Polygon();
    public Background()
    {
        super(0, 0, 800, 600, "/images/background_gameplay.png");
        frames.put("drawBackground 0", new Rectangle(0, 0, 800, 600));
        setAnimation(new String[]
                {
                    "drawBackground 0"
                });
    }

    public Rectangle getRectengles()
    {
        return null;
    }

    @Override
    public void doLoopAction()
    {
        
    }
}
