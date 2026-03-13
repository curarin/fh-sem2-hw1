package org.lecture.model;

import lombok.extern.log4j.Log4j2;

import java.util.Random;

/**
 * Very complex algorithm which returns a totally random gameChoice object.
 */
@Log4j2
public class GameArtificialIntelligence {
    public GameChoice getAiChoice() {
        log.trace("getAiChoice()");
        Random random = new Random();
        int rng = random.nextInt(3);
        log.info("rng is '{}'", rng);

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
