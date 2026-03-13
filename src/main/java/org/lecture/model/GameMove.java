package org.lecture.model;

import lombok.*;

/**
 * Represents a game move of a ROCK-PAPER-SCISSORS game.
 */
@Builder
@Getter
@ToString
public class GameMove {
    private final GameChoice playerChoice;
    private final GameChoice computerChoice;
    // We calculate the winner in a seperate class and store it here afterwards
    @Setter
    private GamePlayer winner;
}
