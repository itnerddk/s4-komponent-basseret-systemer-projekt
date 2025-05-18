package org.sdu.mikni23.asteroid;

import java.util.concurrent.ThreadLocalRandom;

import org.sdu.mikni23.asteroid.objects.AsteroidObject;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class AsteroidPlugin implements GamePluginServiceInterface {

    @Override
    public void start(GameDataObject gameData, GameWorldObject world) {
        
        // create meteors
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(5, 15); i++) {
            createAsteroid(world, ThreadLocalRandom.current().nextInt(5, 15), ThreadLocalRandom.current().nextInt(0, gameData.getDisplayWidth()), ThreadLocalRandom.current().nextInt(0, gameData.getDisplayHeight()), ThreadLocalRandom.current().nextInt(0, 359));
        }
    }

    @Override
    public void stop(GameDataObject gameData, GameWorldObject world) {
        
        // Remove all Meteors
        for (EntityObject e : world.getEntities(AsteroidObject.class)) {
            world.removeEntity(e);
        }
    }

    /**
     * 
     * Creates an new asteroid, and adds it to the world
     * 
     * @param world
     * @param size of asteroid
     * @param x position
     * @param y position
     * @param r rotation
     */
    public static void createAsteroid(GameWorldObject world, int size, int x, int y, int r) {
        EntityObject m = new AsteroidObject();
        m.setRadius(size);
        m.setPolygonCoordinates(m.getRadius(), -m.getRadius(), -m.getRadius(), -m.getRadius(), -m.getRadius(), m.getRadius(), m.getRadius(), m.getRadius());
        m.setX(x);
        m.setY(y);
        m.setR(r);

        world.addEntity(m);
    }
    
}
