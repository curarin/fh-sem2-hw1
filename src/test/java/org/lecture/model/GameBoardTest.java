package org.lecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameBoardTest {

    @Test
    public void testInitialBoardIsAllEmpty() {
        GameBoard gameBoard = new GameBoard();
        for (GameMove gameMove : gameBoard.gameMovesArray) {
            assertEquals(GamePlayer.NOT_SET, gameMove.getWinner());
            assertEquals(GameChoice.EMPTY, gameMove.getPlayerChoice());
            assertEquals(GameChoice.EMPTY, gameMove.getComputerChoice());
        }
    }
}
