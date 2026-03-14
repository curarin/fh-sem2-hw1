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

        assertEquals(Integer.valueOf(1), gameScore.getHumanWinCounter());
        assertEquals(Integer.valueOf(0), gameScore.getComputerWinCounter());
        assertEquals(Integer.valueOf(0), gameScore.getDrawCounter());

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

        assertEquals(Integer.valueOf(1), gameScore.getDrawCounter());
        assertEquals(Integer.valueOf(0), gameScore.getComputerWinCounter());
        assertEquals(Integer.valueOf(0), gameScore.getHumanWinCounter());

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

        assertEquals(Integer.valueOf(0), gameScore.getHumanWinCounter());
        assertEquals(Integer.valueOf(0), gameScore.getDrawCounter());
        assertEquals(Integer.valueOf(1), gameScore.getComputerWinCounter());
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

        assertEquals(Integer.valueOf(1), gameScore.getHumanWinCounter());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        gameScore.addToCount(gameMove2.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.getHumanWinCounter());
        assertEquals(Integer.valueOf(1), gameScore.getComputerWinCounter());

        GameMove gameMove3 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        gameScore.addToCount(gameMove3.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.getHumanWinCounter());
        assertEquals(Integer.valueOf(2), gameScore.getComputerWinCounter());

        GameMove gameMove4 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        gameScore.addToCount(gameMove4.getWinner());

        assertEquals(Integer.valueOf(1), gameScore.getHumanWinCounter());
        assertEquals(Integer.valueOf(1), gameScore.getDrawCounter());
        assertEquals(Integer.valueOf(2), gameScore.getComputerWinCounter());
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

    /**
     * Validates the game is running in round 5 because noone has 3 wins yet.
     */
    @Test
    public void testGameIsRunningInRound5BecauseNooneHas3Wins() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);

        assertTrue(gameScore.gameIsRunning());
    }

    /**
     * Validates the game is over after 5 rounds.
     */
    @Test
    public void testGameIsOverAfter5Rounds() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.DRAW);
        gameScore.addToCount(GamePlayer.COMPUTER);

        assertFalse(gameScore.gameIsRunning());
    }

    /**
     * Validates the game is won by Human because he has 3 wins.
     */
    @Test
    public void testGameWinnerIsHumanWith3Wins() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);

        assertEquals(GamePlayer.HUMAN, gameScore.getGameWinner());
    }

    /**
     * Validates the game is won by Computer because he has 3 wins.
     */
    @Test
    public void testGameWinnerIsComputerWith3Wins() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);

        assertEquals(GamePlayer.COMPUTER, gameScore.getGameWinner());
    }

    /**
     * Validates the game has no winner because neither Human nor Computer have 3 wins.
     */
    @Test
    public void testGameWinnerIsDrawWithHumanAndComputerWithLessThan3Wins() {
        GameScore gameScore = new GameScore();
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.HUMAN);
        gameScore.addToCount(GamePlayer.COMPUTER);
        gameScore.addToCount(GamePlayer.COMPUTER);

        assertEquals(GamePlayer.DRAW, gameScore.getGameWinner());
    }


}
