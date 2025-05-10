package org.sdu.mikni23.Bullet;

import org.sdu.mikni23.CommonBullet.BulletObject;
import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class BulletControlSystem implements EntityProcessingServiceInterface, BulletSPI {

    private final static float bulletSize = 1f;
    private final static int bulletChangeMultiplier = 3;
    private final static int bulletChangeMultiplerCreated = 10;

    @Override
    public EntityObject createBullet(EntityObject shooter, GameDataObject gameData) {
        EntityObject b = new BulletObject();
        b.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        double cX = Math.cos(Math.toRadians(shooter.getR()));
        double cY = Math.sin(Math.toRadians(shooter.getR()));
        b.setX(shooter.getX() + cX * bulletChangeMultiplerCreated);
        b.setY(shooter.getY() + cY * bulletChangeMultiplerCreated);
        b.setR(shooter.getR());
        b.setRadius(bulletSize);
        return b;
    }

    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {
        // process each bullet
        for (EntityObject e : world.getEntities(BulletObject.class)) {
            double cX = Math.cos(Math.toRadians(e.getR()));
            double cY = Math.sin(Math.toRadians(e.getR()));
            e.setX(e.getX() + cX * bulletChangeMultiplier);
            e.setY(e.getY() + cY * bulletChangeMultiplier);
        }
    }
    
}
