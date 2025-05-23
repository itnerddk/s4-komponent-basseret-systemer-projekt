package org.sdu.mikni23.collision;

import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

/**
 * This class handle the collision of objects
 * 
 * It will not handle what happens, but rather if they have collided.
 * The logic for what happens with a object when it collides. Is on the specific implementation of the EntityObject
 */
public class CollisionController implements EntityProcessingServiceInterface {

    /**
     * 
     * Tests if e1 and e2 collides
     * 
     * @param e1
     * @param e2
     * @return true if collided, otherwise false
     */
    public boolean collides(EntityObject e1, EntityObject e2) {
        double dx = e1.getX() - e2.getX();
        double dy = e1.getY() - e2.getY();

        // calculate distance between e1 and e2
        double d = Math.sqrt(dx * dx + dy * dy);

        // added radius of both entities
        double r = e1.getRadius() + e2.getRadius();

        // check if the distance is smaller than the combined radius aka. if they have collided 
        return d < r;
    }

    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {
        for (EntityObject e1 : world.getEntities()) {
            for (EntityObject e2 : world.getEntities()) {

                // do not process collision for itself
                if (e2.equals(e1)) {
                    continue;
                }

                // check if e1 have collided with e2
                if (collides(e1, e2)) {
                    // call the method on the entity, to let the specific implementation, handle how the entity will respond.
                    e1.handleCollide(gameData, world, e2); 
                }
                    
            }
        }
    }
    
}
