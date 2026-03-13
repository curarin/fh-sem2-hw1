package org.lecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameArtificialIntelligenceTest {

    /**
     * Validates that all gameChoice values available are covered.
     */
    @Test
    public void aiGameChoiceCanReturnAllValues() {
        GameArtificialIntelligence aiGameChoice = new GameArtificialIntelligence();
        int maximumRange = 100_000;
        int currentIterator = 0;
        boolean rockWasFound = false;
        boolean paperWasFound = false;
        boolean scissorsWasFound = false;

        while (currentIterator < maximumRange) {
            GameChoice currentChoice = aiGameChoice.getAiChoice();

            if (currentChoice.equals(GameChoice.ROCK)) {
                rockWasFound = true;
            } else if (currentChoice.equals(GameChoice.PAPER)) {
                paperWasFound = true;
            } else if (currentChoice.equals(GameChoice.SCISSORS)) {
                scissorsWasFound = true;
            }
            currentIterator += 1;
        }

        assertTrue(rockWasFound);
        assertTrue(paperWasFound);
        assertTrue(scissorsWasFound);
    }

    /**
     * Validates that the default branch wont be triggered.
     */
    @Test
    public void aiGameChoiceDoesntThrowException() {
        assertDoesNotThrow(() -> {
            GameArtificialIntelligence aiGameChoice = new GameArtificialIntelligence();
            int maximumRange = 100_000;
            int currentIterator = 0;

            while (currentIterator < maximumRange) {
                GameChoice currentChoice = aiGameChoice.getAiChoice();
                currentIterator += 1;
            }
        });
    }
}
