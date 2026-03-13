package org.lecture.model;

import lombok.*;

/**
 * Represents a game move of a ROCK-PAPER-SCISSORS game.
 */
@ToString
@Getter
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
    private GamePlayer calculateWinner() {
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
            return GamePlayer.HUMAN;
        } else if (
                this.playerChoice.equals(this.computerChoice)
        ) {
            return GamePlayer.NONE;
        } else {
            return GamePlayer.COMPUTER;
        }
    }
}
