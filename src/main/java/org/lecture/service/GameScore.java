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

    public void addToCount(GamePlayer winner) {
        if (winner.equals(GamePlayer.COMPUTER)) {
            computerWins++;
        } else if (winner.equals(GamePlayer.HUMAN)) {
            humanWins++;
        }
    }

    public boolean gameIsRunning() {
        return this.humanWins < 3 && this.computerWins < 3;
    }

}
