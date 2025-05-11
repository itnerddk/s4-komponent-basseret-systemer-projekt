package org.sdu.mikni23.meteor;

import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;
import org.sdu.mikni23.meteor.objects.MeteorObject;

public class MeteorControlSystem implements EntityProcessingServiceInterface {

    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {
        for (EntityObject e : world.getEntities(MeteorObject.class)) {
            double cX = Math.cos(Math.toRadians(e.getR()));
            double cY = Math.sin(Math.toRadians(e.getR()));
            e.setX(e.getX() + cX);
            e.setY(e.getY() + cY);

            // limit the meteors movement to inside the visible playing field, and transport them to the other side. Once they hit a wall
            if (e.getX() < 0) {
                e.setX(gameData.getDisplayWidth() - 1);
            }

            if (e.getX() > gameData.getDisplayWidth()) {
                e.setX(1);
            }

            if (e.getY() < 0) {
                e.setY(gameData.getDisplayHeight() - 1);
            }

            if (e.getY() > gameData.getDisplayHeight()) {
                e.setY(1);
            }
        }
    }
    
}
