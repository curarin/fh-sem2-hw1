package org.lecture.model;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * Calculates the winner of each GameMove and stores the number of wins.
 */
@Log4j2
@Getter
public class GameScore {
    public int humanWinCounter = 0;
    public int computerWinCounter = 0;
    public int drawCounter = 0;

    /**
     * Takes the winning player and stores metrics for the board game. can be used to get humanWins, computerWins or draws.
     * @param winner The player who won the last gameMove based on calculation in gameMove class.
     */
    public void addToCount(GamePlayer winner) {
        log.trace("addToCount");
        if (winner.equals(GamePlayer.COMPUTER)) {
            log.info("Computer wins - +1 counted towards computerWinCounter");
            computerWinCounter++;
        } else if (winner.equals(GamePlayer.HUMAN)) {
            log.info("Human wins - +1 counted towards humanWinCounter");
            humanWinCounter++;
        } else if (winner.equals(GamePlayer.DRAW)) {
            log.info("Move ended in draw - +1 counted towards drawCounter");
            drawCounter++;
        }
    }

    /**
     * Business logic for the running game state
     * @return false when one of each player (human or computer) won 3 games - this ends the game.
     */
    public boolean gameIsRunning() {
        log.trace("gameIsRunning()");
        return (this.humanWinCounter + this.computerWinCounter + this.drawCounter) < 5;
    }

}
