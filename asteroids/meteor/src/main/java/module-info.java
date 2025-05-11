import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.meteor.MeteorControlSystem;
import org.sdu.mikni23.meteor.MeteorPlugin;

module meteor {
    requires transitive common;

    provides EntityProcessingServiceInterface with MeteorControlSystem;
    provides GamePluginServiceInterface with MeteorPlugin;

    exports org.sdu.mikni23.meteor;
}
