package org.lecture.handler;

import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameChoice;

import java.util.Scanner;

@Log4j2
public class InputHandler {

    public GameChoice getRockPaperScissorsInput() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        char startingLetter = choice.toLowerCase().charAt(0);

        if (startingLetter == 'r') {
            return GameChoice.ROCK;
        } else if (startingLetter == 'p') {
            return GameChoice.PAPER;
        } else if (startingLetter == 's') {
            return GameChoice.SCISSORS;
        } else {
            // ToDo: Anforderung = Man soll wieder picken können in dem Case, so lange bis was valides dabei ist.
            log.error("Invalid choice");
            return GameChoice.EMPTY;
        }
    }
}
