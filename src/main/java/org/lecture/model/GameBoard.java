package org.lecture.model;
import java.util.ArrayList;

/**
 * Represents the game board as a whole of a ROCK-PAPER-SCISSORS game.
 * Has a 1:n relationship with GameMove class.
 */
public class GameBoard {
    public ArrayList<GameMove> gameMoves = new ArrayList<>();

    public void addGameMoveToGameBoard(GameMove gameMove) {
        this.gameMoves.add(gameMove);
    }

    public void printGameBoard() {
        for (GameMove gameMove : this.gameMoves) {
            System.out.printf(
                    "%s x %s : %s\n",
                    gameMove.getPlayerChoice().getShortName(),
                    gameMove.getComputerChoice().getShortName(),
                    gameMove.getWinner()
            );
        }
    }
}
