package org.lecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameMoveTest {
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

        assertEquals(GamePlayer.HUMAN, gameMove.getWinner());

        GameMove gameMove2 = GameMove
                .builder()
                .computerChoice(GameChoice.SCISSORS)
                .playerChoice(GameChoice.PAPER)
                .build();
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
     * Validates that draw is correctly recognized.
     */
    @Test
    public void testDraw() {
        GameMove gameMove = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.ROCK)
                .build();


        assertEquals(GamePlayer.DRAW, gameMove.getWinner());
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

        GameMove gameMove4 = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        assertEquals(GamePlayer.DRAW, gameMove4.getWinner());
    }

    /**
     * Validates that Rock correctly beats Scissors.
     */
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

    /**
     * Validates that paper correctly beats rock.
     */
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

    /**
     * Validates that Scissors correctly beat paper.
     */
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

    /**
     * validates that same picks always end in draw.
     */
    @Test
    public void testNoneWinsAgainstSamePick() {
        GameMove gameMoveScissors = GameMove
                .builder()
                .playerChoice(GameChoice.SCISSORS)
                .computerChoice(GameChoice.SCISSORS)
                .build();

        GameMove gameMoveRock = GameMove
                .builder()
                .playerChoice(GameChoice.ROCK)
                .computerChoice(GameChoice.ROCK)
                .build();

        GameMove gameMovePaper = GameMove
                .builder()
                .playerChoice(GameChoice.PAPER)
                .computerChoice(GameChoice.PAPER)
                .build();

        assertEquals(GamePlayer.DRAW, gameMoveScissors.getWinner());
        assertEquals(GamePlayer.DRAW, gameMoveRock.getWinner());
        assertEquals(GamePlayer.DRAW, gameMovePaper.getWinner());
    }

    /**
     * validates placeholder picks.
     */
    @Test
    public void testPlaceholderPicksPriorToGameStart() {
        GameMove gameMoveEmpty = GameMove
                .builder()
                .playerChoice(GameChoice.EMPTY)
                .computerChoice(GameChoice.EMPTY)
                .build();

        assertEquals("N/A", gameMoveEmpty.getWinner().getName());
    }
}
