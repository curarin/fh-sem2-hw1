package org.lecture.model;

import lombok.Getter;

@Getter
public enum GameChoice {
    ROCK("R"),
    PAPER("P"),
    SCISSORS("S"),
    EMPTY("-");

    private final String shortName;

    GameChoice(String shortName) {
        this.shortName = shortName;
    }
}
