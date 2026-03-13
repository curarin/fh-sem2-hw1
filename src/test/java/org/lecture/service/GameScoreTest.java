package org.lecture.service;

import org.junit.jupiter.api.Test;
import org.lecture.model.GameChoice;
import org.lecture.model.GameMove;
import org.lecture.model.GamePlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameScoreTest {

    @Test
    public void testHumanWinCounter() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(Integer.valueOf(1), gameScore.humanWins);
        assertEquals(Integer.valueOf(0), gameScore.computerWins);

    }

    @Test
    public void testComputerWinCounter() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(Integer.valueOf(0), gameScore.humanWins);
        assertEquals(Integer.valueOf(1), gameScore.computerWins);
    }

    @Test
    public void testHumanWins() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());
    }

    @Test
    public void testComputerWins() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.COMPUTER, gameMove.getWinner());
    }

    @Test
    public void testEmptyMoveAlwaysLooses() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.EMPTY)
                .computerChoice(GameChoice.PAPER)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.COMPUTER, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.EMPTY)
                .build();

        gameScore.calculateWinner(gameMove2);

        assertEquals(GamePlayer.HUMAN, gameMove2.getWinner());
    }

    @Test
    public void testScoreCounterWithMultipleMoves() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(Integer.valueOf(1), gameScore.humanWins);

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        gameScore.calculateWinner(gameMove2);

        assertEquals(Integer.valueOf(1), gameScore.humanWins);
        assertEquals(Integer.valueOf(1), gameScore.computerWins);

        GameMove gameMove3 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        gameScore.calculateWinner(gameMove3);

        assertEquals(Integer.valueOf(1), gameScore.humanWins);
        assertEquals(Integer.valueOf(2), gameScore.computerWins);
    }

    @Test
    public void testWinnerWithMultipleMoves() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameScore.calculateWinner(gameMove2).getWinner());

        GameMove gameMove3 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameScore.calculateWinner(gameMove3).getWinner());
    }

    @Test
    public void testRockBeatsScissors() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        gameScore.calculateWinner(gameMove2);

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }

    @Test
    public void testPaperBeatsRock() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        gameScore.calculateWinner(gameMove2);

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }

    @Test
    public void testScissorsBeatsPaper() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.PAPER)
                .build();

        GameScore gameScore = new GameScore();
        gameScore.calculateWinner(gameMove);

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        gameScore.calculateWinner(gameMove2);

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }
    ı
}
