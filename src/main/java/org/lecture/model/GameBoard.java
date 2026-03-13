package org.lecture.model;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Represents the game board as a whole of a ROCK-PAPER-SCISSORS game.
 * Has a 1:n relationship with GameMove class.
 */
@Log4j2
public final class GameBoard {
    public ArrayList<GameMove> gameMoves = new ArrayList<>();
    public GameMove[] gameMovesArray = {
            GameMove.builder().playerChoice(GameChoice.EMPTY).computerChoice(GameChoice.EMPTY).build(),
            GameMove.builder().playerChoice(GameChoice.EMPTY).computerChoice(GameChoice.EMPTY).build(),
            GameMove.builder().playerChoice(GameChoice.EMPTY).computerChoice(GameChoice.EMPTY).build(),
            GameMove.builder().playerChoice(GameChoice.EMPTY).computerChoice(GameChoice.EMPTY).build(),
            GameMove.builder().playerChoice(GameChoice.EMPTY).computerChoice(GameChoice.EMPTY).build()
    };

    public void addGameMoveToGameBoard(GameMove gameMove, int moveCounter) {
        log.trace("addGameMoveToGameBoard");
        log.info("Adding {} to Array", gameMove);
        log.info("Move Counter is currently: {}", moveCounter);
        this.gameMovesArray[moveCounter] = gameMove;
    }

    public void printGameBoard() {
        log.trace("printGameBoard");
        log.info("gameMoves = {}", gameMoves);
        System.out.println("---------- Current GameBoard -----------");
        for (GameMove gameMove : this.gameMovesArray) {
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
