package org.sdu.mikni23.objects;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * World data object
 */
public class GameWorldObject {
    
    /*
     * Entities
     */
    private final Map<UUID, EntityObject> entityMap = new ConcurrentHashMap<>();

    /**
     * Add entity to the world
     * 
     * @param entity The entity to add
     * @return the UUID of the entity
     */
    public UUID addEntity(EntityObject entity) {
        entityMap.put(entity.getId(), entity);
        return entity.getId();
    }

    /**
     * Remove entity by the entity object reference
     * 
     * @param entity
     */
    public void removeEntity(EntityObject entity) {
        entityMap.remove(entity.getId());
    }

    /**
     * Remove entity by the uuid
     * 
     * @param id UUID
     */
    public void removeEntity(UUID id) {
        entityMap.remove(id);
    }

    /**
     * Get entity by the UUID
     * 
     * @param id UUID
     * @return Entity object
     */
    public EntityObject getEntity(UUID id) {
        return entityMap.get(id);
    }

    /**
     * Get all entities in the world
     * 
     * @return Collection of entities
     */
    public Collection<EntityObject> getEntities() {
        return entityMap.values();
    }

}
