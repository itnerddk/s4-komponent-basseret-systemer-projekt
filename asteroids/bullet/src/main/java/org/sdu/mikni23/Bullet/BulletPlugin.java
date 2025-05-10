package org.sdu.mikni23.Bullet;

import org.sdu.mikni23.CommonBullet.BulletObject;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class BulletPlugin implements GamePluginServiceInterface {

    @Override
    public void start(GameDataObject gameData, GameWorldObject world) {
    }

    @Override
    public void stop(GameDataObject gameData, GameWorldObject world) {
        // Remove bullets
        for (EntityObject e : world.getEntities(BulletObject.class)) {
            world.removeEntity(e);
        }
    }
    
}
