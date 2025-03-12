package org.sdu.mikni23.interfaces;

import org.sdu.mikni23.objects.GameDataObject;
import org.sdu.mikni23.objects.GameWorldObject;

/*
 * Interface for post processing
 */
public interface PostEntityProcessingServiceInterface {

    /**
     * Process
     * 
     * @param gameData
     * @param world
     */
    public void process(GameDataObject gameData, GameWorldObject world);
}
