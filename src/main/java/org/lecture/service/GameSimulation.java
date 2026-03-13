package org.lecture.service;

import lombok.extern.log4j.Log4j2;
import org.lecture.handler.InputHandler;
import org.lecture.model.GameArtificalIntelligence;
import org.lecture.model.GameBoard;
import org.lecture.model.GameChoice;
import org.lecture.model.GameMove;

@Log4j2
public class GameSimulation {
    public void runSimulation() {
        Menu menu = new Menu();
        GameBoard gameBoard = new GameBoard();
        InputHandler inputHandler = new InputHandler();
        GameArtificalIntelligence gameAiMove = new GameArtificalIntelligence();

        menu.mainMenu();

        boolean isRunning = false;

        do {
            isRunning = true;
            menu.choiceMenu();
            GameChoice currentPlayerGameChoice = inputHandler.getRockPaperScissorsInput();

            GameChoice currentComputerGameChoice = gameAiMove.getAiChoice();
            GameMove currentGameMove = GameMove.builder()
                    .playerChoice(currentPlayerGameChoice)
                    .computerChoice(currentComputerGameChoice)
                    .build();

            System.out.println(currentGameMove);
            gameBoard.addGameMoveToGameBoard(currentGameMove);
            gameBoard.printGameBoard();

        } while (isRunning);
    }
}
