package org.lecture.model;

import org.junit.jupiter.api.Test;
import org.lecture.service.GameScore;

import static org.junit.jupiter.api.Assertions.*;

public class GameMoveTest {

    // Source: https://www.baeldung.com/junit-assert-exception
    /**
     * GameMove object is expected to be instantiated with both computerChoice and playerChoice
     * We expect a NullPointerException if that's not the case.
     */
    @Test
    public void testNullArgumentsThrowException() {
        assertThrows(NullPointerException.class, () -> {
            GameMove
                    .builder()
                    .computerChoice(GameChoice.ROCK)
                    //.playerChoice(GameChoice.PAPER)
                    .build();
        });

        assertThrows(NullPointerException.class, () -> {
            GameMove
                    .builder()
                    //.computerChoice(GameChoice.ROCK)
                    .playerChoice(GameChoice.PAPER)
                    .build();
        });
    }

    /**
     * GameMove object is expected to be instantiated with both computerChoice and playerChoice
     * If those parameters are provided we expect that no exception is thrown.
     */
    @Test
    public void testNoExceptionIsThrown() {
        assertDoesNotThrow(() -> {
            GameMove
                    .builder()
                    .computerChoice(GameChoice.ROCK)
                    .playerChoice(GameChoice.PAPER)
                    .build();
        });
    }

    /**
     * GameMove Object holds the winner of the specific move.
     * We expect the attribute to hold the correct entry we provided via the setWinner method.
     */
    @Test
    public void testWinnerCanBePlaced() {
        GameMove gameMove = GameMove
                .builder()
                .computerChoice(GameChoice.ROCK)
                .playerChoice(GameChoice.PAPER)
                .build();

        gameMove.getWinner();
        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .computerChoice(GameChoice.SCISSORS)
                .playerChoice(GameChoice.PAPER)
                .build();
        gameMove.getWinner();
        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }

    /**
     * Validates that the correct player wins based on input.
     */
    @Test
    public void testHumanWins() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());
    }

    /**
     * Validates that the correct player wins based on input.
     */
    @Test
    public void testComputerWins() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();


        assertEquals(GamePlayer.COMPUTER, gameMove.getWinner());
    }

    /**
     * Validates that if no choice is provided (aka EMPTY) then this player always looses.
     */
    @Test
    public void testEmptyMoveAlwaysLooses() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.EMPTY)
                .computerChoice(GameChoice.PAPER)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.EMPTY)
                .build();

        assertEquals(GamePlayer.HUMAN, gameMove2.getWinner());
    }

    /**
     * Validates that over the course of the game, which consists of many moves, the winner of each move works as expected.
     */
    @Test
    public void testWinnerWithMultipleMoves() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());

        GameMove gameMove3 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameMove3.getWinner());
    }

    @Test
    public void testRockBeatsScissors() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.ROCK)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }

    @Test
    public void testPaperBeatsRock() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.ROCK)
                .build();

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.PAPER)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }

    @Test
    public void testScissorsBeatsPaper() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.PAPER)
                .build();

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        assertEquals(GamePlayer.COMPUTER, gameMove2.getWinner());
    }
}
