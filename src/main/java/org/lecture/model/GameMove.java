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

    @Builder
    private GameMove(GameChoice playerChoice, GameChoice computerChoice) {
        this.playerChoice = playerChoice;
        this.computerChoice = computerChoice;
        this.winner = calculateWinner();
    }

    private GamePlayer calculateWinner() {
        if (
                this.playerChoice == GameChoice.ROCK && (
                        this.computerChoice == GameChoice.SCISSORS || this.computerChoice == GameChoice.EMPTY)
        ) {
            return GamePlayer.HUMAN;
        } else if (
                this.playerChoice == GameChoice.PAPER && (
                        this.computerChoice == GameChoice.ROCK || this.computerChoice == GameChoice.EMPTY
                )
        ) {
            return GamePlayer.HUMAN;
        } else if (
                this.playerChoice == GameChoice.SCISSORS && (
                        this.computerChoice == GameChoice.PAPER || this.computerChoice == GameChoice.EMPTY
                )
        ) {
            return GamePlayer.HUMAN;
        }
        else {
            return GamePlayer.COMPUTER;
        }
    }
}
