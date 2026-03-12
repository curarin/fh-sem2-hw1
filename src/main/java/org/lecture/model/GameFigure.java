package org.lecture.model;

import lombok.Getter;

@Getter
public enum GameFigure {
    ROCK("R"),
    PAPER("P"),
    SCISSORS("S"),
    EMPTY("-");

    private final String shortName;

    GameFigure(String shortName) {
        this.shortName = shortName;
    }
}
