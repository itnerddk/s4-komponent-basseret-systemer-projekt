package org.sdu.mikni23.collision.test.objects;

import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

/**
 * A implementation of EntityObject (an abstract class)
 */
public class EntityTestObject extends EntityObject {

    @Override
    public void handleCollide(GameDataObject gamedata, GameWorldObject world, EntityObject entity2) {
        System.out.println(this.toString() + " Collided with " + entity2.toString());
    }
    
}
