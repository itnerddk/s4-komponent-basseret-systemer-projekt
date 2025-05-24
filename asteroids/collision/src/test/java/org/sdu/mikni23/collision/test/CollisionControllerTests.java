package org.sdu.mikni23.collision.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.sdu.mikni23.collision.CollisionController;
import org.sdu.mikni23.collision.test.objects.EntityTestObject;

@TestInstance(Lifecycle.PER_CLASS)
public class CollisionControllerTests {

    private CollisionController collisionController;

    @BeforeAll
    public void setup() {

        // Create an collisionController
        this.collisionController = new CollisionController();
    }
    
    @Test
    public void testCollision() {
        
        // Create first entity
        EntityTestObject e1 = new EntityTestObject();
        e1.setRadius(3f);
        e1.setR(5);
        e1.setX(7);
        e1.setY(7);

        // Create second entity (That overlaps with the first entity)
        EntityTestObject e2 = new EntityTestObject();
        e2.setRadius(3f);
        e2.setR(15);
        e2.setX(5);
        e2.setY(5);

        // check if the CollisionController detects the collision
        assertTrue(collisionController.collides(e1, e2));
    }

    @Test
    public void testNotCollision() {
        // Create first entity
        EntityTestObject e1 = new EntityTestObject();
        e1.setRadius(3f);
        e1.setR(5);
        e1.setX(7);
        e1.setY(7);

        // Create second entity (That do not overlap with the first entity)
        EntityTestObject e2 = new EntityTestObject();
        e2.setRadius(3f);
        e2.setR(15);
        e2.setX(15);
        e2.setY(15);

        // check if the CollisionController detects the collision
        assertFalse(collisionController.collides(e1, e2));
    }
}
