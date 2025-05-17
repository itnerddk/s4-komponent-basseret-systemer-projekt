package org.sdu.mikni23.asteroid.objects;

import java.util.concurrent.ThreadLocalRandom;

import org.sdu.mikni23.asteroid.AsteroidPlugin;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class AsteroidObject extends EntityObject {

    @Override
    public void handleCollide(GameDataObject gamedata, GameWorldObject world, EntityObject entity2) {
        
        // the asteroid will not be removed if the other entity is an asteroid
        if (entity2 instanceof AsteroidObject) {
            return;
        }

        world.removeEntity(this); // remove itself when hit

        if (this.getRadius() > 2) {
            AsteroidPlugin.createAsteroid(world, (int) this.getRadius() - 2, (int) this.getX() + 20, (int) this.getY() - 20, ThreadLocalRandom.current().nextInt(0, 359));
            AsteroidPlugin.createAsteroid(world, (int) this.getRadius() - 2, (int) this.getX() - 20, (int) this.getY() + 20, ThreadLocalRandom.current().nextInt(0, 359));
        }
    }
    
}
