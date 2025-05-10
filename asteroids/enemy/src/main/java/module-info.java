import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;

import org.sdu.mikni23.enemy.EnemyControlSystem;
import org.sdu.mikni23.enemy.EnemyPlugin;

module enemy {
    requires transitive common;
    requires commonbullet;

    uses BulletSPI;

    provides EntityProcessingServiceInterface with EnemyControlSystem;
    provides GamePluginServiceInterface with EnemyPlugin;

    exports org.sdu.mikni23.enemy.objects;
    exports org.sdu.mikni23.enemy;
}
