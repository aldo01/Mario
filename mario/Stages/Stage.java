package mario.Stages;

import mario.core.KeyButtons;
import java.util.ArrayList;
import java.util.Iterator;
import mario.core.AiDirector;
import mario.core.StageObject;
import mario.core.interfaces.ReUse;
import mario.core.engine.Sound;

/**
 *
 * @author danny
 */
public class Stage
{
    private AiDirector aiDirector = new AiDirector(this);
    private StageMario mario = new StageMario(this,200, 420, 42, 57);
    private Sound sound = new Sound();
    private MapCompiler stageLoader = new MapCompiler(this);
    private StageArray stageArray;

    //private Background background = new Background(this, 0, 552, 800,  48);
    //private Background background2 = new Background(this, 800, 552, 800,  48);
    //work around try for bug. With out the 3rt background there where holes in the ground.
    //private Background background3 = new Background(this, 400, 552, 800,  48);


    private ScoreBalk ScoreBalk = new ScoreBalk(this, 0, 0, 45, 48);
    private ArrayList<StageObject> mapObjects = new ArrayList<StageObject>();
    

    public Stage()
    {
        //sound.playSound("/sound/theme.wav");
        //mapObjects.add(background);
        //mapObjects.add(background2);
       
        mapObjects.add(mario);
        mapObjects.add(ScoreBalk);
    }

    public StageMario getMario()
    {
        return mario;
    }

    public void addMapObject(StageObject mapObject)
    {
        mapObjects.add(mapObject);
    }

    public ArrayList<StageObject> getMapObjects()
    {
        return mapObjects;
    }

    public void doLoopAction()
    {
        removeObjects();
        gameObjectLoopAction();
    }

    public void removeObjects()
    {
        for (Iterator<StageObject> it = mapObjects.iterator(); it.hasNext();)
        {
            StageObject mapObject = it.next();
            if (!mapObject.isAlive() || (mapObject.getX() + mapObject.getWidth()) <= 0 || ((mapObject.getY() + mapObject.getHeight() )>= 556 && !(mapObject instanceof ReUse)))
            {
                if(mapObject instanceof ReUse)
                {
                    mapObject.setX(800, true);
                }
                else
                {
                    it.remove();
                    aiDirector.removeObject();
                }
            }
        }
    }

     private void gameObjectLoopAction()
    {
         aiDirector.createMapObjects();

        for (StageObject stageObject : mapObjects)
        {
            stageObject.doMapCollision();
            stageObject.doLoopAction();
        }
    }

    public ScoreBalk getScoreBalk()
    {
        return ScoreBalk;
    }

    public AiDirector getAiDirector()
    {
        return aiDirector;
    }

    public Sound getSound()
    {
        return sound;
    }

    public void handlePressedKeys(ArrayList<KeyButtons> keyPressed)
    {
        boolean setter = true;
        handleKeys(keyPressed, setter);
        
    }

    public void handleReleasedKeys(ArrayList<KeyButtons> keyPressed)
    {
        boolean setter = false;
        handleKeys(keyPressed, setter);
    }

    private void handleKeys(ArrayList<KeyButtons> keyPressed, boolean setter)
    {
        if(keyPressed.contains(KeyButtons.LEFT))
        {
            mario.setLeft(setter);
        }
        if(keyPressed.contains(KeyButtons.RIGHT))
        {
            mario.setRight(setter);
        }
        if(keyPressed.contains(KeyButtons.JUMP))
        {
            if(setter == true)
            {
                mario.setJump(setter);
            }
        }
        if(keyPressed.contains(KeyButtons.DOWN))
        {
            mario.setDown(setter);
        }
    }

    public void setStage(String stageName)
    {
        //stageArray = stageLoader.getStage(stageName);
    }
}