package org.sdu.mikni23.enemy.objects;

import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class EnemyObject extends EntityObject {

    /**
     * Health
     */
    private int health = 30;

    @Override
    public void handleCollide(GameDataObject gamedata, GameWorldObject world, EntityObject entity2) {
        
        // take damage
        health -= 1;

        System.out.println("Enemy hit, current health: " + health);

        // remove enemy once it runs out of life
        if (health <= 0) {
            world.removeEntity(this);
            System.out.println("Enemy died!");
        }

    }
    
}
