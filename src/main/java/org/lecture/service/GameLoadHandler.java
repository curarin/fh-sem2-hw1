package org.lecture.service;

import lombok.Data;
import org.lecture.model.GameBoard;

public class GameLoadHandler {
    private final String gameSaveSlot;

    /**
     * Handles loading process of game saves.
     *
     * @param gameSaveSlot the game slot number
     */
    public GameLoadHandler(String gameSaveSlot) {
        this.gameSaveSlot = gameSaveSlot;
    }

}
