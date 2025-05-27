package org.sdu.mikni23.score;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;

import org.sdu.mikni23.common.interfaces.PostEntityProcessingServiceInterface;
import org.sdu.mikni23.common.objects.GameDataObject;
import org.sdu.mikni23.common.objects.GameWorldObject;

public class ScorePostEntityProcessingService implements PostEntityProcessingServiceInterface {

    private String scoreMicroservice = "http://localhost:8080";

    private int getTopScore() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(scoreMicroservice))
            .GET()
            .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            return Integer.parseInt(response.body());

        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    private void setTopScore(int score) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(scoreMicroservice + "?score=" + score))
                .POST(BodyPublishers.noBody())
                .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void updateTopScore(int score) {
        if (score > getTopScore()) {
            setTopScore(score);
        }
    }

    @Override
    public void process(GameDataObject gameData, GameWorldObject world) {
        
        if (world.isGameover()) {
            System.out.println("Game Over!");

            System.out.println("Score was: " + world.getScore());

            updateTopScore(world.getScore());

            System.exit(0);
        }

    }
    
}
