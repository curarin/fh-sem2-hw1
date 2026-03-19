package org.lecture.model;

import lombok.Getter;

/**
 * Fixed values for the participating players - also represents potential winners or wether the GamePlayer is set or not.
 */
@Getter
public enum GamePlayer {
    HUMAN("Player"),
    COMPUTER("Computer"),
    NOT_SET("N/A"),
    NO_WINNER("Draw");

    private final String name;

    /**
     * Represents the player - either Human, Computer or None. The latter is used for draws.
     * @param name Returns the beautiful string for logging purposes.
     */
    GamePlayer(String name) {
        this.name = name;
    }
}
