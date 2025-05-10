import org.sdu.mikni23.Bullet.BulletControlSystem;
import org.sdu.mikni23.Bullet.BulletPlugin;
import org.sdu.mikni23.Bullet.BulletSPIService;
import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;

module bullet {
    requires transitive common;
    requires commonbullet;

    provides BulletSPI with BulletSPIService;
    provides EntityProcessingServiceInterface with BulletControlSystem;
    provides GamePluginServiceInterface with BulletPlugin;
    
    exports org.sdu.mikni23.Bullet;
}
