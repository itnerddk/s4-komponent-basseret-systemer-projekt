import org.sdu.mikni23.collision.CollisionController;
import org.sdu.mikni23.collision.CollisionPlugin;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;

module collision {
    requires common;

    provides GamePluginServiceInterface with CollisionPlugin;
    provides EntityProcessingServiceInterface with CollisionController;

}
