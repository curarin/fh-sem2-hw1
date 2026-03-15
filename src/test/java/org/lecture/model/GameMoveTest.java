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


        assertEquals(GamePlayer.NO_WINNER, gameMove.getWinner());
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

        assertEquals(GamePlayer.NO_WINNER, gameMove4.getWinner());
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

        assertEquals(GamePlayer.NO_WINNER, gameMoveScissors.getWinner());
        assertEquals(GamePlayer.NO_WINNER, gameMoveRock.getWinner());
        assertEquals(GamePlayer.NO_WINNER, gameMovePaper.getWinner());
    }

    /**
     * validates that an exception os thrown when input was incorrect.
     */
    @Test
    public void testGameMoveThrowsExceptionWhenHumanPickIsEmptyDueToIncorrectInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameMove gameMoveEmpty = GameMove
                    .builder()
                    .playerChoice(GameChoice.EMPTY)
                    .computerChoice(GameChoice.SCISSORS)
                    .build();
        });
    }
}
