package org.sdu.mikni23.enemy;

import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;
import org.sdu.mikni23.enemy.objects.EnemyObject;

public class EnemyPlugin implements GamePluginServiceInterface{
    
    @Override
    public void start(GameDataObject gameData, GameWorldObject world) {

        // Create a enemy
        EntityObject e = new EnemyObject();
        e.setPolygonCoordinates(-5,-5,10,0,-5,5);
        e.setX(gameData.getDisplayWidth() / 2);
        e.setY(gameData.getDisplayHeight() / 2);
        e.setRadius(8f);

        world.addEntity(e);

    }

    @Override
    public void stop(GameDataObject gameData, GameWorldObject world) {

        // Remove all enemies
        for (EntityObject e : world.getEntities(EnemyObject.class)) {
            world.removeEntity(e);
        }
        
    }
}
