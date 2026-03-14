package org.lecture.model;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the game board as a whole of a ROCK-PAPER-SCISSORS game.
 * Has a 1:n relationship with GameMove class.
 */
@Log4j2
public final class GameBoard {
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
    public void printEndOfGameMessage(GameScore gameScore) {
        log.trace("printEndOfGameMessage");
        List<GameMove> gameMoves = Arrays.asList(gameMovesArray);
        log.info("board Winner: {}", gameScore.getGameWinner());

        if (gameScore.getGameWinner().equals(GamePlayer.DRAW)) {
            System.out.println("The game ended in an STALEMATE. Thanks for playing.");
        } else {
            List<GameMove> winningGameMoves = gameMoves
                    .stream()
                    .filter(gameMove -> gameMove.getWinner().equals(gameScore.getGameWinner()))
                    .toList();
            log.info("Winning Game Moves: {}", winningGameMoves);
            System.out.printf("Congrat to %s - you won with the following picks:\n", gameScore.getGameWinner().getName());
            for (GameMove gameMove : winningGameMoves) {
                if (gameScore.getGameWinner().equals(GamePlayer.HUMAN)) {
                    System.out.printf("%s (versus: %s)\n", gameMove.getPlayerChoice(), gameMove.getComputerChoice());
                } else {
                    System.out.printf("%s (versus: %s)\n", gameMove.getComputerChoice(), gameMove.getPlayerChoice());
                }
            }
        }
    }
}
