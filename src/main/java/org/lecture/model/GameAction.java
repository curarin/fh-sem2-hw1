package org.lecture.model;

/**
 * Fixed values for an Action during menu selection - a Player can choose to play a gameMove, safe the game
 * or load an existing game. 'Nothing' is just a fallback so I don't need to work with nulls.
 */
public enum GameAction {
    LOAD,
    SAFE,
    PLAY,
    NOTHING
}
