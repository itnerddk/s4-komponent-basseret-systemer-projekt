import org.sdu.mikni23.Bullet.BulletControlSystem;
import org.sdu.mikni23.Bullet.BulletPlugin;
import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;

module bullet {
    requires common;
    requires commonbullet;

    provides BulletSPI with BulletControlSystem;
    provides GamePluginServiceInterface with BulletPlugin;
    
    exports org.sdu.mikni23.Bullet;
}
