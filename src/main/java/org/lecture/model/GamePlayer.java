package org.lecture.model;

import lombok.Getter;

/**
 * Fixed values for the participating players
 */
@Getter
public enum GamePlayer {
    HUMAN("Player"),
    COMPUTER("Computer"),
    NONE("None");

    private final String name;

    GamePlayer(String name) {
        this.name = name;
    }
}
