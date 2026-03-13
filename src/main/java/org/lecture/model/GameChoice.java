package org.lecture.model;

import lombok.Getter;

@Getter
public enum GameChoice {
    ROCK("R"),
    PAPER("P"),
    SCISSORS("S"),
    EMPTY("-");

    private final String shortName;

    /**
     * Represents the move each player can pick (human or computer) during a Rock-Paper-Scissors-Game.
     * @param shortName ShortName used for logging purposes
     */
    GameChoice(String shortName) {
        this.shortName = shortName;
    }
}
