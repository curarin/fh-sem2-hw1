package org.lecture.model;

import lombok.*;

/**
 * Represents a game move of a ROCK-PAPER-SCISSORS game.
 */
@Builder
@Getter
@ToString
public class GameMove {
    @NonNull
    private final GameChoice playerChoice;
    @NonNull
    private final GameChoice computerChoice;

    public GamePlayer getWinner() {
        if (
                this.getPlayerChoice() == GameChoice.ROCK && (
                        this.getComputerChoice() == GameChoice.SCISSORS || this.getComputerChoice() == GameChoice.EMPTY)
        ) {
            return GamePlayer.HUMAN;
        } else if (
                this.getPlayerChoice() == GameChoice.PAPER && (
                        this.getComputerChoice() == GameChoice.ROCK || this.getComputerChoice() == GameChoice.EMPTY
                )
        ) {
            return GamePlayer.HUMAN;
        } else if (
                this.getPlayerChoice() == GameChoice.SCISSORS && (
                        this.getComputerChoice() == GameChoice.PAPER || this.getComputerChoice() == GameChoice.EMPTY
                )
        ) {
            return GamePlayer.HUMAN;
        }
        else {
            return GamePlayer.COMPUTER;
        }
    }
}
