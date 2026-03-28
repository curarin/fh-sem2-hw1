package org.lecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {

    /**
     * Test validates that the empty board is initialized.
     */
    @Test
    public void testInitialBoardIsAllEmpty() {
        GameBoard gameBoard = new GameBoard();
        for (GameMove gameMove : gameBoard.getGameMoves()) {
            assertEquals(GamePlayer.NOT_SET, gameMove.getWinner());
            assertEquals(GameChoice.EMPTY, gameMove.getPlayerChoice());
            assertEquals(GameChoice.EMPTY, gameMove.getComputerChoice());
        }
    }

    /**
     * Test that validates that the game board has one move stored.
     */
    @Test
    public void testGameBoardHasFirstAndOnlyMoveStored() {
        GameBoard gameBoard = new GameBoard();
        GameMove gameMoveOne = GameMove.builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.ROCK)
                .build();
        GameBoard gameBoardAfterMoveOne = gameBoard.playMove(gameMoveOne);
        assertEquals(GameChoice.ROCK, gameBoardAfterMoveOne.getGameMoves().getFirst().getPlayerChoice());
        assertEquals(4, gameBoardAfterMoveOne.getGameMoves().stream().filter(gameMove -> gameMove.getWinner().equals(GamePlayer.NOT_SET)).count());
    }

    /**
     * Test validates that the game board has actually two moves stored in the latest variation / instance.
     */
    @Test
    public void testGameBoardHasTwoMovesStored() {
        GameBoard gameBoard = new GameBoard();
        GameMove gameMoveOne = GameMove.builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.ROCK)
                .build();
        GameMove gameMoveTwo = GameMove.builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameBoard gameBoardAfterMoveOne = gameBoard.playMove(gameMoveOne);
        GameBoard gameBoardAfterMoveTwo = gameBoardAfterMoveOne.playMove(gameMoveTwo);

        assertEquals(4, gameBoardAfterMoveOne.getGameMoves().stream().filter(gameMove -> gameMove.getWinner().equals(GamePlayer.NOT_SET)).count());
        assertEquals(3, gameBoardAfterMoveTwo.getGameMoves().stream().filter(gameMove -> gameMove.getWinner().equals(GamePlayer.NOT_SET)).count());
        assertEquals(2, gameBoardAfterMoveTwo.getGameMoves().stream().filter(gameMove -> gameMove.getComputerChoice().equals(GameChoice.ROCK)).count());
        assertEquals(1, gameBoardAfterMoveTwo.getGameMoves().stream().filter(gameMove -> gameMove.getPlayerChoice().equals(GameChoice.ROCK)).count());
        assertEquals(1, gameBoardAfterMoveTwo.getGameMoves().stream().filter(gameMove -> gameMove.getPlayerChoice().equals(GameChoice.PAPER)).count());
    }

    /**
     * Test validates, that even after using the add method to the empty board we still have an empty initial board
     * which also differentiates from the GameBoard after Move one
     */
    @Test
    public void testGameBoardIsActuallyImmutable() {
        GameBoard gameBoard = new GameBoard();
        GameMove gameMoveOne = GameMove.builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameBoard gameBoardAfterMoveOne = gameBoard.playMove(gameMoveOne);
        gameBoard.playMove(gameMoveOne);

        assertEquals(5, gameBoard.getGameMoves().stream().filter(gameMove -> gameMove.getWinner().equals(GamePlayer.NOT_SET)).count());
        assertNotEquals(gameBoard, gameBoardAfterMoveOne);
    }
}
