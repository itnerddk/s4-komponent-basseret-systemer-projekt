package org.sdu.mikni23.CommonBullet;

import org.sdu.mikni23.common.objects.EntityObject;
import org.sdu.mikni23.common.objects.GameDataObject;

public interface BulletSPI {
    EntityObject createBullet(EntityObject e, GameDataObject gameData);
}
