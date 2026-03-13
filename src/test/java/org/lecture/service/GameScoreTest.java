package org.lecture.service;

import org.junit.jupiter.api.Test;
import org.lecture.model.GameChoice;
import org.lecture.model.GameMove;
import org.lecture.model.GamePlayer;
import org.lecture.model.GameScore;

import static org.junit.jupiter.api.Assertions.*;

public class GameScoreTest {

    /**
     * Validates the object counter to correctly count towards the winning player (=human) based on moves.
     */
    @Test
    public void testHumanWinCounter() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.addToCount(gameMove.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.humanWinCounter);
        assertEquals(Integer.valueOf(0), gameScore.computerWinCounter);
        assertEquals(Integer.valueOf(0), gameScore.drawCounter);

    }

    /**
     * Validates the object counter to correctly count towards the winning player (=human) based on moves.
     */
    @Test
    public void testDrawCounter() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.PAPER)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.addToCount(gameMove.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.drawCounter);
        assertEquals(Integer.valueOf(0), gameScore.computerWinCounter);
        assertEquals(Integer.valueOf(0), gameScore.humanWinCounter);

    }

    /**
     * Validates the object counter to correctly count towards the winning player (=computer) based on moves.
     */
    @Test
    public void testComputerWinCounter() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.addToCount(gameMove.getWinner());

        assertEquals(Integer.valueOf(0), gameScore.humanWinCounter);
        assertEquals(Integer.valueOf(0), gameScore.drawCounter);
        assertEquals(Integer.valueOf(1), gameScore.computerWinCounter);
    }

    /**
     * Validates that over the course of the game, which consists of many moves, the counter works as expected.
     */
    @Test
    public void testScoreCounterWithMultipleMoves() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.addToCount(gameMove.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.humanWinCounter);

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        gameScore.addToCount(gameMove2.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.humanWinCounter);
        assertEquals(Integer.valueOf(1), gameScore.computerWinCounter);

        GameMove gameMove3 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        gameScore.addToCount(gameMove3.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.humanWinCounter);
        assertEquals(Integer.valueOf(2), gameScore.computerWinCounter);

        GameMove gameMove4 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        gameScore.addToCount(gameMove4.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.humanWinCounter);
        assertEquals(Integer.valueOf(1), gameScore.drawCounter);
        assertEquals(Integer.valueOf(2), gameScore.computerWinCounter);
    }

    /**
     * Validates the game is running as long as noone won 3 games.
     */
    @Test
    public void testGameIsRunningWithLessThan3Wins() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.HUMAN);

        assertTrue(gameScore.gameIsRunning());
    }

    /**
     * Validates the game is over with the first person hitting 3 wins.
     */
    @Test
    public void testGameIsOverWith3Wins() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);

        assertFalse(gameScore.gameIsRunning());
    }


}
