package org.sdu.mikni23.common.interfaces;

import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

/*
 * Interface for entity processing
 */
public interface EntityProcessingServiceInterface {
    
    /**
     * Process a frame
     * 
     * @param gameData for the game
     * @param world for the world
     */
    public void process(GameDataObject gameData, GameWorldObject world);
}
