package org.lecture.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.lecture.handler.FileReader;
import org.lecture.model.GameBoard;
import org.lecture.model.GameMove;
import org.lecture.model.GamePlayer;
import org.lecture.model.GameScore;

import java.lang.reflect.Array;

@Log4j2
public class GameLoadHandler {
    @Getter
    private int safeGameMoveCounterStart = 0;
    private Array safeGameFileNames;

    public void printTop10LatestGameSafes() {
        log.trace("printTop10LatestGameSafes()");
        // ToDo: Aus dem gameSafes Path alle Files einlesen
        // Sortieren nach Timestamp (aus dem Filename)
        // in sortierter reihenfolge safeGameFileNames reinpushen und printen
    }

    public String getFileNameBasedOnGameSafePosition(int gameSavePosition) {
        log.trace("getFileNameBasedOnGameSafePosition()");
        int index = gameSavePosition - 1;
        // ToDo: Auf Basis der Safe Game Position aus dem Array den Title bekommen
        // und in safeGameFileNameWanted speichern
        return "Filename";
    }

    public GameBoard generateGameBoardFromGameSafe(String gameSaveFileNameWanted) {
        log.trace("generateGameBoardFromGameSafe()");
        FileReader fileReader = new FileReader();
        GameBoard gameBoard = fileReader.readGameBoard(gameSaveFileNameWanted);

        int currentIndex = 0;
        for (GameMove gameMove : gameBoard.gameMovesArray) {
            if (gameMove.getWinner().equals(GamePlayer.NOT_SET)) {
                this.safeGameMoveCounterStart = currentIndex;
                log.info("We are starting the previous board on index {}", safeGameMoveCounterStart);
            } else {
                currentIndex++;
            }
        }
        return gameBoard;
    }

    public GameScore generateGameScoreFromGameSafe(String gameSaveFileNameWanted) {
        FileReader fileReader = new FileReader();
        GameBoard gameBoard = fileReader.readGameBoard(gameSaveFileNameWanted);
        GameScore gameScore = new GameScore();

        for (GameMove gameMove : gameBoard.gameMovesArray) {
            gameScore.addToCount(gameMove.getWinner());
        }
        return gameScore;

    }
}
