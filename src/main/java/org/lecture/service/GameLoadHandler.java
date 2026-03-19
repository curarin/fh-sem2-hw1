package org.lecture.service;

import lombok.extern.log4j.Log4j2;
import org.lecture.handler.FileReader;
import org.lecture.model.GameBoard;
import org.lecture.model.GameMove;
import org.lecture.model.GameScore;


@Log4j2
public class GameLoadHandler {
    private final String gameSaveFileNameWanted = "safeGame.csv";

    /**
     * Generates the gameBoard from game safe
     * @return GameBoard object with state of moves previously done and safed.
     */
    public GameBoard generateGameBoardFromGameSafe() {
        log.trace("generateGameBoardFromGameSafe()");
        FileReader fileReader = new FileReader();
        return fileReader.readGameBoard(this.gameSaveFileNameWanted);
    }

    /**
     * Generates the gameScore object from the loaded file
     * @return gameScore which consists of humanWinCounter, computerWinCounter
     */
    public GameScore generateGameScoreFromGameSafe() {
        FileReader fileReader = new FileReader();
        GameBoard gameBoard = fileReader.readGameBoard(this.gameSaveFileNameWanted);
        GameScore gameScore = new GameScore();

        for (GameMove gameMove : gameBoard.getGameMoves()) {
            gameScore.addToCount(gameMove.getWinner());
        }
        return gameScore;

    }
}
