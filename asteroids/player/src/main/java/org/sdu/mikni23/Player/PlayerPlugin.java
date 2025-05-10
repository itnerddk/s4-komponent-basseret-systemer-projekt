package org.sdu.mikni23.Player;

import org.sdu.mikni23.Player.objects.PlayerObject;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class PlayerPlugin implements GamePluginServiceInterface {

    @Override
    public void start(GameDataObject gameData, GameWorldObject world) {
        
        // Create the player
        EntityObject p = new PlayerObject();
        p.setPolygonCoordinates(-5,-5,10,0,-5,5);
        p.setX(gameData.getDisplayWidth() / 2);
        p.setY(gameData.getDisplayHeight() / 2);
        p.setRadius(8f);

        world.addEntity(p);

    }

    @Override
    public void stop(GameDataObject gameData, GameWorldObject world) {
        // remove player
        for (EntityObject e : world.getEntities(PlayerObject.class)) {
            world.removeEntity(e);
        }
    }
    
}
