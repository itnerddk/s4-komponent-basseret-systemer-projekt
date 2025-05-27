package org.sdu.mikni23.Player.objects;

import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class PlayerObject extends EntityObject {

    /**
     * Health of the player
     */
    private int health = 20;

    @Override
    public void handleCollide(GameDataObject gamedata, GameWorldObject world, EntityObject entity2) {
        
        // take damage
        health -= 1;

        // remove points
        world.addScore(-2);


        System.out.println("Player hit, current health: " + health);

        // remove player if player runs out of life
        if (health <= 0) {
            world.removeEntity(this);
            System.out.println("Player died!");

            // end game
            world.setGameover(true);
        }

    }
    
}
