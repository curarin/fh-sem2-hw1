package org.lecture.service;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameChoice;
import org.lecture.model.GameMove;
import org.lecture.model.GamePlayer;

/**
 * Calculates the winner of each GameMove and stores the number of wins.
 */
@Log4j2
@Getter
public class GameScore {
    public int humanWins = 0;
    public int computerWins = 0;

    public GameMove calculateWinner(GameMove gameMove) {
        if (
                gameMove.getPlayerChoice() == GameChoice.ROCK && (
                        gameMove.getComputerChoice() == GameChoice.SCISSORS || gameMove.getComputerChoice() == GameChoice.EMPTY)
        ) {
            humanWins += 1;
            gameMove.setWinner(GamePlayer.HUMAN);
        } else if (
                gameMove.getPlayerChoice() == GameChoice.PAPER && (
                        gameMove.getComputerChoice() == GameChoice.ROCK || gameMove.getComputerChoice() == GameChoice.EMPTY
                        )
        ) {
            humanWins += 1;
            gameMove.setWinner(GamePlayer.HUMAN);
        } else if (
                gameMove.getPlayerChoice() == GameChoice.SCISSORS && (
                        gameMove.getComputerChoice() == GameChoice.PAPER || gameMove.getComputerChoice() == GameChoice.EMPTY
                        )
        ) {
            humanWins += 1;
            gameMove.setWinner(GamePlayer.HUMAN);
        }
        else {
            computerWins += 1;
            gameMove.setWinner(GamePlayer.COMPUTER);
        }
        return gameMove;
    }
}
