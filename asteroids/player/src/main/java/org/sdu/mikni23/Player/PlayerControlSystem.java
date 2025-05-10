package org.sdu.mikni23.Player;

import java.util.Collection;
import java.util.ServiceLoader;

import org.sdu.mikni23.Player.objects.PlayerObject;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;
import org.sdu.mikni23.CommonBullet.BulletSPI;

import static java.util.stream.Collectors.toList;

public class PlayerControlSystem implements EntityProcessingServiceInterface {

    private final static float playerRoatationSpeed = 3f;

    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {
        

        // Movement
        for (EntityObject p : world.getEntities(PlayerObject.class)) {
            
            // Forward
            if (gameData.getKeys().isUp() && !gameData.getKeys().isDown()) {
                double cX = Math.cos(Math.toRadians(p.getR()));
                double cY = Math.sin(Math.toRadians(p.getR()));
                p.setX(p.getX() + cX);
                p.setY(p.getY() + cY);
            }

            // Rotate Left
            if (gameData.getKeys().isLeft() && !gameData.getKeys().isRight()) {
                p.setR(p.getR() - playerRoatationSpeed);
            }

            // Rotate Right
            if (gameData.getKeys().isRight() && !gameData.getKeys().isLeft()) {
                p.setR(p.getR() + playerRoatationSpeed);
            }

            // Shoot
            if (gameData.getKeys().isSpace()) {
                getBulletSPIs().stream().findFirst().ifPresent(
                    spi -> {
                        world.addEntity(spi.createBullet(p, gameData));
                    }
                );
            }
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
    
}
