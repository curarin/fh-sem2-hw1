package org.lecture.service;

import lombok.extern.log4j.Log4j2;
import org.lecture.handler.InputHandler;
import org.lecture.model.*;

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
                moveCounter++;
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            } finally {
                isRunning = gameScore.gameIsRunning();
            }
        } while (isRunning);

        gameBoard.printEndOfGameMessage(gameScore);
    }
}
