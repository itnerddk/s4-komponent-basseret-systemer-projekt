module Core {
    requires transitive common;
    requires transitive javafx.graphics;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    exports org.sdu.mikni23.main;
    opens org.sdu.mikni23.main to javafx.graphics,spring.core;

    uses org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
    uses org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
    uses org.sdu.mikni23.common.interfaces.PostEntityProcessingServiceInterface;
}
