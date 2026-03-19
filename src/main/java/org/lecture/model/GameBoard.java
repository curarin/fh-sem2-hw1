package org.lecture.model;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game board as a whole of a ROCK-PAPER-SCISSORS game.
 * Has a 1:n relationship with GameMove class.
 */
@Log4j2
@Getter
@ToString
public final class GameBoard {
    private final List<GameMove> gameMoves;

    /**
     * Constructor with no arguments - initializes an empty board.
     */
    public GameBoard() {
        List<GameMove> initialGameMoves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            initialGameMoves.add(
                    GameMove.builder().playerChoice(GameChoice.EMPTY).computerChoice(GameChoice.EMPTY).build()
            );
        }
        this.gameMoves = List.copyOf(initialGameMoves);
    }

    /**
     * Constructor used when loading an existing game state - persists the immutable state.
     * @param gameMoves list of game moves (e.g. from file loading)
     */
    public GameBoard(List<GameMove> gameMoves) {
        List<GameMove> newGameMoves = new ArrayList<>(gameMoves);
        this.gameMoves = List.copyOf(newGameMoves);
    }


    /**
     * Adds a GameMove to the current game Board
     * @param gameMove current Game Move
     * @return updated GameBoard which is immutable
     */
    public GameBoard addGameMoveToGameBoard(GameMove gameMove) {
        log.trace("addGameMoveToGameBoard");
        log.info("Adding {} to Array", gameMove);

        List<GameMove> updatedGameMoves = new ArrayList<>(this.gameMoves);

        for (int i = 0; i < this.gameMoves.size(); i++) {
            GameMove currentGameMove = updatedGameMoves.get(i);
            if (currentGameMove.getComputerChoice().equals(GameChoice.EMPTY)
                    && currentGameMove.getPlayerChoice().equals(GameChoice.EMPTY)) {
                updatedGameMoves.set(i, gameMove);
                return new GameBoard(updatedGameMoves);
            }
        }
        return new GameBoard(updatedGameMoves);
    }

    /**
     * Prints the current game Board
     */
    public void printGameBoard() {
        log.trace("printGameBoard");
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
    public void printEndOfGameMessage(GameScore gameScore) {
        log.trace("printEndOfGameMessage");
        log.info("board Winner: {}", gameScore.getGameWinner());

        if (gameScore.getGameWinner().equals(GamePlayer.NO_WINNER)) {
            System.out.println("The game ended in an STALEMATE. Thanks for playing.");
        } else {
            List<GameMove> winningGameMoves = this.gameMoves
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
