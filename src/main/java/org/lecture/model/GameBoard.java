package org.lecture.model;
import java.util.ArrayList;

/**
 * Represents the game board as a whole of a ROCK-PAPER-SCISSORS game.
 * Has a 1:n relationship with GameMove class.
 */
public final class GameBoard {
    private ArrayList<GameMove> gameMoves;

    public void putGameMove(GameMove gameMove) {
        gameMoves.add(gameMove);
    }

    public void printGameBoard() {
        for (GameMove gameMove : gameMoves) {
            System.out.printf(
                    "%s x %s : %s",
                    gameMove.getPlayerChoice().getShortName(),
                    gameMove.getComputerChoice().getShortName(),
                    gameMove.getWinner()
            );
        }
    }
}
