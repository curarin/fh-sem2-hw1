package org.lecture.handler;

import org.lecture.model.GameBoard;
import org.lecture.model.GameChoice;
import org.lecture.model.GameMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * File Reader which reads an existing file from a .csv and returns an immutable instance of the gameboard.
 */
public class FileReader {
    public GameBoard readGameBoard(String fileName) {
        GameBoard gameBoard = new GameBoard();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src", "main", "resources", "gameSafes", fileName))) {
            String line;
            boolean headerLine = true;

            while ((line = reader.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                    continue;
                }
                String[] values = line.split(";");
                try {
                    GameMove currentGameMove = GameMove.builder()
                            .playerChoice(GameChoice.valueOf(values[0]))
                            .computerChoice(GameChoice.valueOf(values[1]))
                            .build();
                    gameBoard = gameBoard.addGameMoveToGameBoard(currentGameMove);
                } catch (Exception e) {
                    System.out.println("Fehler beim Parsen der Zeile: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameBoard;
    }
}
