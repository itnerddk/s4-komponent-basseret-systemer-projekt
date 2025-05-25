package org.sdu.mikni23.main;

import java.util.ServiceLoader;

import org.sdu.mikni23.common.interfaces.EntityProcessingServiceInterface;
import org.sdu.mikni23.common.interfaces.GamePluginServiceInterface;
import org.sdu.mikni23.common.interfaces.PostEntityProcessingServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfig {

    @Bean
    public ServiceLoader<GamePluginServiceInterface> gamePluginServices() {
        return ServiceLoader.load(GamePluginServiceInterface.class);
    }

    @Bean
    public ServiceLoader<EntityProcessingServiceInterface> entityProcessingServices() {
        return ServiceLoader.load(EntityProcessingServiceInterface.class);
    }

    @Bean
    public ServiceLoader<PostEntityProcessingServiceInterface> postEntityProcessingServices() {
        return ServiceLoader.load(PostEntityProcessingServiceInterface.class);
    }

    @Bean
    public Game game() {
        return new Game(gamePluginServices(), entityProcessingServices(), postEntityProcessingServices());
    }

}
