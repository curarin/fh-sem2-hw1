package org.lecture.service;

import lombok.extern.log4j.Log4j2;
import org.lecture.handler.FileWriter;
import org.lecture.handler.FileReader;

import org.lecture.handler.InputHandler;
import org.lecture.model.*;

import java.io.IOException;
import java.util.Arrays;

@Log4j2
public class GameSimulation {
    public void runSimulation() {
        log.trace("runSimulation()");
        Menu menu = new Menu();
        int moveCounter = 0;
        GameBoard gameBoard = new GameBoard();
        GameScore gameScore = new GameScore();
        InputHandler inputHandler = new InputHandler();
        GameArtificialIntelligence gameAiMove = new GameArtificialIntelligence();

        menu.mainMenu();
        menu.gameActionPlayOrLoad();
        GameAction startingGameAction = inputHandler.getGameActionInput();

        if(startingGameAction.equals(GameAction.LOAD)) {
            log.info("Loading game...");
            GameLoadHandler gameLoadHandler = new GameLoadHandler();

            gameLoadHandler.printTop10LatestGameSafes();
            int safeGamePositionWanted = inputHandler.getGameSavePosition();
            gameScore = gameLoadHandler.generateGameScoreFromGameSafe(gameLoadHandler.getFileNameBasedOnGameSafePosition(safeGamePositionWanted));
            gameBoard = gameLoadHandler.generateGameBoardFromGameSafe(gameLoadHandler.getFileNameBasedOnGameSafePosition(safeGamePositionWanted));
        }

        gameBoard.printGameBoard();
        boolean isRunning;
        do {
            menu.choiceMenu();
            GameChoice currentPlayerGameChoice = inputHandler.getRockPaperScissorsInput();

            GameChoice currentComputerGameChoice = gameAiMove.getAiChoice();
            try {
                GameMove currentGameMove = GameMove.builder()
                        .playerChoice(currentPlayerGameChoice)
                        .computerChoice(currentComputerGameChoice)
                        .build();
                gameScore.addToCount(currentGameMove.getWinner());
                gameBoard.addGameMoveToGameBoard(currentGameMove, moveCounter);
                gameBoard.printGameBoard();


                menu.gameActionPlayOrSafe();
                GameAction currentGameAction = inputHandler.getGameActionInput();
                if(currentGameAction.equals(GameAction.SAFE)) {
                    log.info("Safe current state to file.");
                    FileWriter fileWriter = new FileWriter();
                    fileWriter.writeFile(gameBoard.gameMovesArray);
                }
                moveCounter++;

            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                isRunning = gameScore.gameIsRunning();
            }
        } while (isRunning);

        gameBoard.printEndOfGameMessage(gameScore);
    }
}
