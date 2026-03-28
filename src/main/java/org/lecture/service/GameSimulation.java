package org.lecture.service;

import lombok.extern.log4j.Log4j2;
import org.lecture.handler.FileWriter;

import org.lecture.handler.InputHandler;
import org.lecture.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * End-to-End-Simulation of the Rock-Paper-Scissors-Game. Shall only be called from Main.
 */
@Log4j2
public class GameSimulation {
    public void runSimulation() {
        log.trace("runSimulation()");
        Menu menu = new Menu();
        GameBoard gameBoard = new GameBoard();
        GameScore gameScore = new GameScore();
        InputHandler inputHandler = new InputHandler();
        GameArtificialIntelligence gameAiMove = new GameArtificialIntelligence();

        menu.mainMenu();
        if (Files.exists(Paths.get("src", "main", "resources", "gameSafes", "safeGame.csv"))) {
            menu.gameActionPlayOrLoad();
            GameAction startingGameAction = inputHandler.getGameActionInput();

            if(startingGameAction.equals(GameAction.LOAD)) {
                log.info("Loading game...");
                GameLoadHandler gameLoadHandler = new GameLoadHandler();
                gameScore = gameLoadHandler.generateGameScoreFromGameSafe();
                gameBoard = gameLoadHandler.generateGameBoardFromGameSafe();
            }
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
                gameBoard = gameBoard.playMove(currentGameMove);
                gameBoard.printGameBoard();

                if(gameScore.gameIsRunning()) {
                    menu.gameActionPlayOrSafe();
                    GameAction currentGameAction = inputHandler.getGameActionInput();
                    if(currentGameAction.equals(GameAction.SAFE)) {
                        log.info("Safe current state to file.");
                        FileWriter fileWriter = new FileWriter();
                        fileWriter.writeFile(gameBoard.getGameMoves());
                    }
                }

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
