package org.lecture.handler;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameAction;
import org.lecture.model.GameChoice;

import java.util.Scanner;

/**
 * Helper function for input handling. Setter is used as helper for unit testing this.
 */
@Log4j2
@Setter
public class InputHandler {
    String input;


    private String getInput() {
        log.trace("getInput()");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public GameChoice getRockPaperScissorsInput() {
        log.trace("getRockPaperScissorsInput()");
        String choice;
        if (this.input == null) {
            choice = this.getInput();
        } else {
            choice = this.input;
        }
        //String choice = this.getInput();

        char startingLetter = choice.toLowerCase().charAt(0);

        log.info("choice given is '{}'", choice);
        log.info("starting letter is '{}'", startingLetter);
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

    public GameAction getGameActionInput() {
        log.trace("getGameActionInput()");
        String choice;
        if (this.input == null) {
            choice = this.getInput();
        } else {
            choice = this.input;
        }
        char startingLetter = choice.toLowerCase().charAt(0);
        log.info("choice given is '{}'", choice);
        log.info("starting letter is '{}'", startingLetter);
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

    public int getGameSavePosition() {
        log.trace("getGameSavePosition()");
        String choice;
        if (this.input == null) {
            choice = this.getInput();
        } else {
            choice = this.input;
        }
        int savePosition = Integer.parseInt(choice);
        log.info("Position choosen is '{}'", savePosition);
        return savePosition;
    }
}
