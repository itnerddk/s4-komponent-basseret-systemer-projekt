package org.sdu.mikni23.objects;

/*
 * Game data object
 */
public class GameDataObject {
    
    /*
     * Display size in pixels
     */
    private int displayWidth = 900;
    private int displayHeight = 900;

    /*
     * Key state
     */
    private final GameKeysObject keys = new GameKeysObject();

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }

    public GameKeysObject getKeys() {
        return keys;
    }

}
