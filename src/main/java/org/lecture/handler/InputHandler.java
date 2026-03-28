package org.lecture.handler;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameAction;
import org.lecture.model.GameChoice;

import java.util.Scanner;

/**
 * Helper function for input handling. Setter is used as helper for unit testing this.
 * Two constructors are here to be used - no args for production, all args for unit tests.
 */
@Log4j2
@Getter
public class InputHandler {
    private String input;
    private Scanner scanner;

    /**
     * Empty constructor which is used for getting user input from CLI (e.g. during production).
     */
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Constructor which is used solely for unit-testing purposes.
     */
    public InputHandler(String input) {
        this.input = input;
    }


    /**
     * Reads input from CLI.
     */
    public String readInput() {
        if (scanner != null) {
            return scanner.nextLine();
        }
        return input;

    }
    /**
     * Gets input for user choices - either Rock, Paper or Scissors are needed
     * @return GameChoice (ROCK, PAPER, SCISSORS)
     */
    public GameChoice getRockPaperScissorsInput() {
        log.trace("getRockPaperScissorsInput()");
        String choice = readInput();

        // We need that for "" inputs.
        if (choice == null || choice.isBlank()) {
            return GameChoice.EMPTY;
        }

        char startingLetter = choice.toLowerCase().charAt(0);

        logProducer(choice, startingLetter);
        if (startingLetter == 'r') {
            return GameChoice.ROCK;
        } else if (startingLetter == 'p') {
            return GameChoice.PAPER;
        } else if (startingLetter == 's') {
            return GameChoice.SCISSORS;
        } else {
            return GameChoice.EMPTY;
        }
    }

    /**
     * Is used when we prompt the user if they want to safe, load or play the game
     * @return GameAction (SAFE, LOAD, PLAY, NOTHING)
     */
    public GameAction getGameActionInput() {
        log.trace("getGameActionInput()");

        String choice = readInput();

        // We need that for "" inputs.
        if (choice == null || choice.isBlank()) {
            return GameAction.NOTHING;
        }

        char startingLetter = choice.toLowerCase().charAt(0);
        logProducer(choice, startingLetter);
        if (startingLetter == 's') {
            return GameAction.SAFE;
        } else if (startingLetter == 'l') {
            return GameAction.LOAD;
        } else if (startingLetter == 'p') {
            return GameAction.PLAY;
        } else {
            return GameAction.NOTHING;
        }
    }

    /**
     * Generate Log Info for InputHandler only.
     */
    private void logProducer(String choice, char letter) {
        log.trace("logProducer()");

        log.info("choice given is '{}'", choice);
        log.info("letter is '{}'", letter);
    }
}
