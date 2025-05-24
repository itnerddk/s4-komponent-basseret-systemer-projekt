import org.sdu.mikni23.collision.CollisionController;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;

module collision {
    requires common;

    exports org.sdu.mikni23.collision;

    provides EntityProcessingServiceInterface with CollisionController;
}
