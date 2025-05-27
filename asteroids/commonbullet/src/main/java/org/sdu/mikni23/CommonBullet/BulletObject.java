package org.sdu.mikni23.CommonBullet;

import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class BulletObject extends EntityObject {

    @Override
    public void handleCollide(GameDataObject gamedata, GameWorldObject world, EntityObject entity2) {
        
        // do not collide with other bullets
        if (entity2 instanceof BulletObject) {
            return;
        }

        // add score
        world.addScore(1);

        world.removeEntity(this); // remove the bullet when it hits something
    }
    
}
