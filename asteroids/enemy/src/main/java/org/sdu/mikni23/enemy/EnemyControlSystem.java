package org.sdu.mikni23.enemy;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.concurrent.ThreadLocalRandom;

import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;
import org.sdu.mikni23.enemy.objects.EnemyObject;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements EntityProcessingServiceInterface {

    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {
        
        // process each enemy
        for (EntityObject e : world.getEntities(EnemyObject.class)) {
            
            // Forward
            if (ThreadLocalRandom.current().nextInt(0, 100) < 99) {
                double cX = Math.cos(Math.toRadians(e.getR()));
                double cY = Math.sin(Math.toRadians(e.getR()));
                e.setX(e.getX() + cX);
                e.setY(e.getY() + cY);
            }

            // Rotate
            // TODO: Make the random better, it has a tendency to go in circles currently
            if (ThreadLocalRandom.current().nextInt(0, 1) == 0) {
                e.setR(e.getR() + ThreadLocalRandom.current().nextInt(0, 2));
            } else {
                e.setR(e.getR() - ThreadLocalRandom.current().nextInt(0, 2));
            }   
            
            // Shoot
            if (ThreadLocalRandom.current().nextInt(0, 10) > 6) {
                getBulletSPIs().stream().findFirst().ifPresent(
                    spi -> {
                        world.addEntity(spi.createBullet(e, gameData));
                    }
                );
            }

            // limit the enemies movement to inside the visible playing field
            if (e.getX() < 0) {
                e.setX(1);
            }

            if (e.getX() > gameData.getDisplayWidth()) {
                e.setX(gameData.getDisplayWidth() - 1);
            }

            if (e.getY() < 0) {
                e.setY(1);
            }

            if (e.getY() > gameData.getDisplayHeight()) {
                e.setY(gameData.getDisplayHeight() - 1);
            }
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
