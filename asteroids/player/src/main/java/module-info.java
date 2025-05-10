import org.sdu.mikni23.CommonBullet.BulletSPI;
import org.sdu.mikni23.Player.PlayerControlSystem;
import org.sdu.mikni23.Player.PlayerPlugin;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;

module player {
    requires common;
    requires commonbullet;

    provides GamePluginServiceInterface with PlayerPlugin;
    provides EntityProcessingServiceInterface with PlayerControlSystem;

    uses BulletSPI;
    
    exports org.sdu.mikni23.Player;
}
