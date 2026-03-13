package org.lecture.handler;

import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameChoice;

import java.util.Scanner;

@Log4j2
public class InputHandler {

    private String getInput() {
        log.trace("getInput()");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public GameChoice getRockPaperScissorsInput() {
        log.trace("getRockPaperScissorsInput()");
        String choice = this.getInput();

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
            // ToDo: Anforderung = Man soll wieder picken können in dem Case, so lange bis was valides dabei ist.
            log.error("Invalid input choice for ROCK, PAPER or SCISSORS. Given was '{}'", choice);
            return GameChoice.EMPTY;
        }
    }
}
