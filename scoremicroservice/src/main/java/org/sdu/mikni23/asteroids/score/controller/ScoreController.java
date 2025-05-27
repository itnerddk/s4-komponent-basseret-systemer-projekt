package org.sdu.mikni23.asteroids.score.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    
    private int topScore = 0;

    @GetMapping
    public int getTopScore() {
        return topScore;
    }

    @PostMapping
    public int setTopScore(@RequestParam("score") int score) {
        this.topScore = score;
        return topScore;
    }
}
