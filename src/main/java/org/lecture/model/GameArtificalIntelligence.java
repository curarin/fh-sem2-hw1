package org.lecture.model;

import java.util.Random;

/**
 * Very complex algorithm which returns a totally random gameChoice object.
 */
public class GameArtificalIntelligence {
    public GameChoice getAiChoice() {
        Random random = new Random();
        int rng = random.nextInt(3);

        GameChoice aiGameChoice = null;

        switch (rng) {
            case 0 -> aiGameChoice = GameChoice.ROCK;
            case 1 -> aiGameChoice = GameChoice.PAPER;
            case 2 -> aiGameChoice = GameChoice.SCISSORS;
            default -> throw new IllegalArgumentException("Invalid choice");
        }
        return aiGameChoice;
    }
}
