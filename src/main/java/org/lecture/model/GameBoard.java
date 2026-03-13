package org.lecture.model;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;

/**
 * Represents the game board as a whole of a ROCK-PAPER-SCISSORS game.
 * Has a 1:n relationship with GameMove class.
 */
@Log4j2
public class GameBoard {
    public ArrayList<GameMove> gameMoves = new ArrayList<>();

    public void addGameMoveToGameBoard(GameMove gameMove) {
        log.trace("addGameMoveToGameBoard");
        log.info("Adding {} to Array", gameMove);
        this.gameMoves.add(gameMove);
    }

    public void printGameBoard() {
        log.trace("printGameBoard");
        log.info("gameMoves = {}", gameMoves);
        System.out.println("---------- Current GameBoard -----------");
        for (GameMove gameMove : this.gameMoves) {
            System.out.printf(
                    "%s x %s : %s\n",
                    gameMove.getPlayerChoice().getShortName(),
                    gameMove.getComputerChoice().getShortName(),
                    gameMove.getWinner().getName()
            );
        }
        System.out.println("----------------------------------------\n");
    }

    /**
     * Prints end of game statistics depending on who one. Utilizes java streams for that.
     */
    public void printEndOfGameMessage() {
        log.trace("printEndOfGameMessage");

    }
}
