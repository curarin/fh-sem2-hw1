package org.lecture.model;

import lombok.*;
import lombok.extern.log4j.Log4j2;

/**
 * Represents a game move of a ROCK-PAPER-SCISSORS game.
 */
@ToString
@Getter
@Log4j2
public class GameMove {
    private final GameChoice playerChoice;
    private final GameChoice computerChoice;
    private final GamePlayer winner;

    /**
     *
     * @param playerChoice Whatever a player picked (Rock, Paper or Scissors)
     * @param computerChoice Whatever the magical AI algorithms choose for the gameMove (Rock, Paper or Scissors)
     */
    @Builder
    private GameMove(GameChoice playerChoice, GameChoice computerChoice) {
        this.playerChoice = playerChoice;
        this.computerChoice = computerChoice;
        this.winner = calculateWinner();
    }

    /**
     * Business logic for calculating the winner based on input choices
     * @return Human, Computer or No Winner (in case of draw)
     */
    private GamePlayer calculateWinner() throws IllegalArgumentException {
        log.trace("calculateWinner");
        log.info("Player choice is '{}'", playerChoice);
        log.info("Computer choice is '{}'", computerChoice);
        if (
                (
                        this.playerChoice == GameChoice.ROCK && (
                                this.computerChoice == GameChoice.SCISSORS || this.computerChoice == GameChoice.EMPTY))
                ||
                        (
                                this.playerChoice == GameChoice.PAPER && (
                                        this.computerChoice == GameChoice.ROCK || this.computerChoice == GameChoice.EMPTY
                                )
                                ||
                                        (
                                                this.playerChoice == GameChoice.SCISSORS && (
                                                        this.computerChoice == GameChoice.PAPER || this.computerChoice == GameChoice.EMPTY
                                                )
                                        ))
        ) {
            log.info("Winner is: HUMAN");
            return GamePlayer.HUMAN;
        } else if (this.playerChoice == GameChoice.EMPTY && this.computerChoice == GameChoice.EMPTY) {
            return GamePlayer.NOT_SET;
        } else if (this.playerChoice == GameChoice.EMPTY || this.computerChoice == GameChoice.EMPTY) {
                throw new IllegalArgumentException("Please pick either Rock, Paper or Scissors");
        }
        else if (this.playerChoice.equals(this.computerChoice)) {
            log.info("Game ends in: DRAW");
            return GamePlayer.NO_WINNER;
        } else {
            log.info("Winner is: COMPUTER");
            return GamePlayer.COMPUTER;
        }
    }
}
