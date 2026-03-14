package org.lecture.handler;

import org.junit.jupiter.api.Test;
import org.lecture.model.GameChoice;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {

    /**
     * Validates that only parsing the first letter of the input string correctly matches the GameChoice type.
     */
    @Test
    public void testHappyPathInputWithFullOrPartialVariations() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.setInput("Rock");
        assertEquals(GameChoice.ROCK, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("rOcK");
        assertEquals(GameChoice.ROCK, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("r");
        assertEquals(GameChoice.ROCK, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("R");
        assertEquals(GameChoice.ROCK, inputHandler.getRockPaperScissorsInput());

        inputHandler.setInput("Paper");
        assertEquals(GameChoice.PAPER, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("paPEr");
        assertEquals(GameChoice.PAPER, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("p");
        assertEquals(GameChoice.PAPER, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("P");
        assertEquals(GameChoice.PAPER, inputHandler.getRockPaperScissorsInput());


        inputHandler.setInput("Scissors");
        assertEquals(GameChoice.SCISSORS, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("sCissors");
        assertEquals(GameChoice.SCISSORS, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("s");
        assertEquals(GameChoice.SCISSORS, inputHandler.getRockPaperScissorsInput());
        inputHandler.setInput("S");
        assertEquals(GameChoice.SCISSORS, inputHandler.getRockPaperScissorsInput());
    }

    /**
     * Incorrect input returns an empty type which is further down the road throwing an exception.
     * We got another unit test which checks for the exception.
     */
    @Test
    public void testIncorrectInputYieldsEmptyInput() {
        InputHandler inputHandler = new InputHandler();
        inputHandler.setInput("Blabber");
        assertEquals(GameChoice.EMPTY, inputHandler.getRockPaperScissorsInput());

        inputHandler.setInput("dingerdonger");
        assertEquals(GameChoice.EMPTY, inputHandler.getRockPaperScissorsInput());

    }
}
