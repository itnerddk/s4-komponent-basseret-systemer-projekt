import org.sdu.mikni23.common.interfaces.PostEntityProcessingServiceInterface;
import org.sdu.mikni23.score.ScorePostEntityProcessingService;

module score {
    requires common;
    requires java.net.http;
    
    provides PostEntityProcessingServiceInterface with ScorePostEntityProcessingService;
}
