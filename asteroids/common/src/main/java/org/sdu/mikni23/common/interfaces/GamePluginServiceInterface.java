package org.sdu.mikni23.common.interfaces;

import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

/*
 * An interface descriping the contract between the core and a plugin
 */
public interface GamePluginServiceInterface {
    
    /**
     * Starts the plugin
     * 
     * @param gameData
     * @param world
     */
    public void start(GameDataObject gameData, GameWorldObject world);

    /**
     * Stops the plugin
     * 
     * @param gameData
     * @param world
     */
    public void stop(GameDataObject gameData, GameWorldObject world);
}
