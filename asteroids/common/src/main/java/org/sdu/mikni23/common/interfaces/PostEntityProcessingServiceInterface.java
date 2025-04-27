package org.sdu.mikni23.common.interfaces;

import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

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
