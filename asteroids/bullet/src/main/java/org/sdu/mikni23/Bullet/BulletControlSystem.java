package org.sdu.mikni23.Bullet;

import org.sdu.mikni23.CommonBullet.BulletObject;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class BulletControlSystem implements EntityProcessingServiceInterface {

    
    private final static int bulletChangeMultiplier = 3;


    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {        
        // process each bullet
        for (EntityObject e : world.getEntities(BulletObject.class)) {

            // update location
            double cX = Math.cos(Math.toRadians(e.getR()));
            double cY = Math.sin(Math.toRadians(e.getR()));
            e.setX(e.getX() + cX * bulletChangeMultiplier);
            e.setY(e.getY() + cY * bulletChangeMultiplier);

            // check if location is outside of the world
            if ((e.getX() < 0 || e.getX() > gameData.getDisplayWidth()) || (e.getY() < 0 || e.getY() > gameData.getDisplayHeight())) {
                world.removeEntity(e);
            }
        }
    }
    
}
