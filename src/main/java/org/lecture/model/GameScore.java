package org.lecture.model;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Calculates the winner of each GameMove and stores the number of wins.
 */
@Log4j2
@Getter
@ToString
public class GameScore {
    private int humanWinCounter = 0;
    private int computerWinCounter = 0;
    private int drawCounter = 0;

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
        } else if (winner.equals(GamePlayer.NO_WINNER)) {
            log.info("Move ended in draw - +1 counted towards drawCounter");
            drawCounter++;
        }
    }

    /**
     * Business logic for the running game state - logic is:
     * either 5 rounds are played OR either human or computer won >= 3 games
     * @return false when game is over
     */
    public boolean gameIsRunning() {
        log.trace("gameIsRunning()");
        return this.humanWinCounter < 3 && this.computerWinCounter < 3 && (this.humanWinCounter + this.computerWinCounter + this.drawCounter) < 5;
    }

    /**
     * Business logic für game winner. NO_WINNER equals draw.
     * @return GamePlayer > can be either of HUMAN, COMPUTER or NO_WINNER
     */
    public GamePlayer getGameWinner() {
        log.trace("getGameWinner()");
        if (this.humanWinCounter >= 3) {
            return GamePlayer.HUMAN;
        } else if (this.computerWinCounter >= 3) {
            return GamePlayer.COMPUTER;
        } else {
            return GamePlayer.NO_WINNER;
        }
    }


}
