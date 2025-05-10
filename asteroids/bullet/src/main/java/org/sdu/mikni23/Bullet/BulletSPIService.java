package org.sdu.mikni23.Bullet;

import org.sdu.mikni23.CommonBullet.BulletObject;
import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;

public class BulletSPIService implements BulletSPI {

    private final static float bulletSize = 1f;
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
    
}
