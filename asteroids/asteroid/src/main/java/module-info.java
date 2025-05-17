import org.sdu.mikni23.asteroid.AsteroidControlSystem;
import org.sdu.mikni23.asteroid.AsteroidPlugin;
import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;

module asteroid {
    requires transitive common;

    provides EntityProcessingServiceInterface with AsteroidControlSystem;
    provides GamePluginServiceInterface with AsteroidPlugin;

    exports org.sdu.mikni23.asteroid;
}
