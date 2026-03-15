package org.lecture.service;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.lecture.handler.FileReader;
import org.lecture.model.GameBoard;
import org.lecture.model.GameMove;
import org.lecture.model.GamePlayer;
import org.lecture.model.GameScore;


@Log4j2
public class GameLoadHandler {
    @Getter
    private int safeGameMoveCounterStart = 0;
    private final String gameSaveFileNameWanted = "safeGame.csv";

    public GameBoard generateGameBoardFromGameSafe() {
        log.trace("generateGameBoardFromGameSafe()");
        FileReader fileReader = new FileReader();
        GameBoard gameBoard = fileReader.readGameBoard(this.gameSaveFileNameWanted);

        int currentIndex = 0;
        for (GameMove gameMove : gameBoard.gameMovesArray) {
            if (gameMove.getWinner().equals(GamePlayer.NOT_SET)) {
                this.safeGameMoveCounterStart = currentIndex;
                log.info("We are starting the previous board on index {}", this.safeGameMoveCounterStart);
            } else {
                currentIndex++;
            }
        }
        return gameBoard;
    }

    public GameScore generateGameScoreFromGameSafe() {
        FileReader fileReader = new FileReader();
        GameBoard gameBoard = fileReader.readGameBoard(this.gameSaveFileNameWanted);
        GameScore gameScore = new GameScore();

        for (GameMove gameMove : gameBoard.gameMovesArray) {
            gameScore.addToCount(gameMove.getWinner());
        }
        return gameScore;

    }
}
