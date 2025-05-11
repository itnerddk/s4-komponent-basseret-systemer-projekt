package org.sdu.mikni23.meteor;

import java.util.concurrent.ThreadLocalRandom;

import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;
import org.sdu.mikni23.meteor.objects.MeteorObject;

public class MeteorPlugin implements GamePluginServiceInterface {

    @Override
    public void start(GameDataObject gameData, GameWorldObject world) {
        
        // create meteors
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(10, 50); i++) {
            EntityObject m = new MeteorObject();
            m.setRadius(ThreadLocalRandom.current().nextInt(5, 15));
            m.setPolygonCoordinates(m.getRadius(), -m.getRadius(), -m.getRadius(), -m.getRadius(), -m.getRadius(), m.getRadius(), m.getRadius(), m.getRadius());
            m.setX(ThreadLocalRandom.current().nextInt(0, gameData.getDisplayWidth()));
            m.setY(ThreadLocalRandom.current().nextInt(0, gameData.getDisplayHeight()));
            m.setR(ThreadLocalRandom.current().nextInt(0, 359));

            world.addEntity(m);
        }
    }

    @Override
    public void stop(GameDataObject gameData, GameWorldObject world) {
        
        // Remove all Meteors
        for (EntityObject e : world.getEntities(MeteorObject.class)) {
            world.removeEntity(e);
        }
    }
    
}
