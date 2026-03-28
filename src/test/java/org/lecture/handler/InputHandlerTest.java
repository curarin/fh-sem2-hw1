package org.lecture.handler;

import org.junit.jupiter.api.Test;
import org.lecture.model.GameAction;
import org.lecture.model.GameChoice;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {

    /**
     * Validates that only parsing the first letter of the input string correctly matches the GameChoice type.
     */
    @Test
    public void testHappyPathInputWithFullOrPartialVariations() {
        InputHandler inputHandler = new InputHandler("Rock");
        assertEquals(GameChoice.ROCK, inputHandler.getRockPaperScissorsInput());
        InputHandler inputHandler2 = new InputHandler("rOcK");
        assertEquals(GameChoice.ROCK, inputHandler2.getRockPaperScissorsInput());
        InputHandler inputHandler3 = new InputHandler("r");
        assertEquals(GameChoice.ROCK, inputHandler3.getRockPaperScissorsInput());
        InputHandler inputHandler4 = new InputHandler("R");
        assertEquals(GameChoice.ROCK, inputHandler4.getRockPaperScissorsInput());

        InputHandler inputHandler5 = new InputHandler("Paper");
        assertEquals(GameChoice.PAPER, inputHandler5.getRockPaperScissorsInput());
        InputHandler inputHandler6 = new InputHandler("pApEr");
        assertEquals(GameChoice.PAPER, inputHandler6.getRockPaperScissorsInput());
        InputHandler inputHandler7 = new InputHandler("P");
        assertEquals(GameChoice.PAPER, inputHandler7.getRockPaperScissorsInput());
        InputHandler inputHandler8 = new InputHandler("p");
        assertEquals(GameChoice.PAPER, inputHandler8.getRockPaperScissorsInput());


        InputHandler inputHandler9 = new InputHandler("Scissors");
        assertEquals(GameChoice.SCISSORS, inputHandler9.getRockPaperScissorsInput());
        InputHandler inputHandler10 = new InputHandler("sCissors");
        assertEquals(GameChoice.SCISSORS, inputHandler10.getRockPaperScissorsInput());
        InputHandler inputHandler11 = new InputHandler("s");
        assertEquals(GameChoice.SCISSORS, inputHandler11.getRockPaperScissorsInput());
        InputHandler inputHandler12 = new InputHandler("S");
        assertEquals(GameChoice.SCISSORS, inputHandler12.getRockPaperScissorsInput());
    }

    /**
     * Incorrect input returns an empty type which is further down the road throwing an exception.
     * We got another unit test which checks for the exception.
     */
    @Test
    public void testIncorrectInputYieldsEmptyInput() {
        InputHandler inputHandler = new InputHandler("Blabber");
        assertEquals(GameChoice.EMPTY, inputHandler.getRockPaperScissorsInput());

        InputHandler inputHandler2 = new InputHandler("dingerdonger");
        assertEquals(GameChoice.EMPTY, inputHandler2.getRockPaperScissorsInput());

    }

    /**
     * Validates that we get the correct game action returned with our input.
     */
    @Test
    public void testCorrectGameActionIsReturned() {
        InputHandler inputHandler = new InputHandler("load");
        assertEquals(GameAction.LOAD, inputHandler.getGameActionInput());

        InputHandler inputHandler2 = new InputHandler("LOAD");
        assertEquals(GameAction.LOAD, inputHandler2.getGameActionInput());

        InputHandler inputHandler3 = new InputHandler("L");
        assertEquals(GameAction.LOAD, inputHandler3.getGameActionInput());

        InputHandler inputHandler4 = new InputHandler("Safe");
        assertEquals(GameAction.SAFE, inputHandler4.getGameActionInput());

        InputHandler inputHandler5 = new InputHandler("s");
        assertEquals(GameAction.SAFE, inputHandler5.getGameActionInput());

    }

    /**
     * Validates that blank inputs are now correctly returning Blank / Nothing States.
     */
    @Test
    public void testBlankInputsNowCorrectlyReturnEmptyOrNothingState() {
        InputHandler inputHandler = new InputHandler("");
        assertEquals(GameAction.NOTHING, inputHandler.getGameActionInput());
        assertEquals(GameChoice.EMPTY, inputHandler.getRockPaperScissorsInput());
    }
}
