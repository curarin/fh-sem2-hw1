package org.lecture.handler;

import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameMove;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * File writer which stores the current GameMove into a comma-seperated file with fixed schema.
 */
@Log4j2
public class FileWriter {

    /**
     * Writes directly to file based on a list of GameMoves
     * @param gameMoves List of Game Moves as input
     * @throws IOException Due to using the BufferedWriter this can throw an exception
     */
    public void writeFile(List<GameMove> gameMoves) throws IOException {
        Path path = Paths.get("src", "main", "resources", "gameSafes", "safeGame.csv");

        if (Files.notExists(path)) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("playerChoice;computerChoice;moveWinner\n");
            for (GameMove gameMove : gameMoves) {
                writeData(gameMove, bw);
                bw.newLine();
            }
        }
        log.info("File written successfully to {}", path);
        System.out.println("Game successfully saved.");
    }

    /**
     * Writes the set schema to the file.
     * @param gameMove GameMove which repesents what the player picked, computer picked and who the winner is
     * @param bw bufferd Writer
     * @throws IOException can throw an exception due to bufferd writer
     */
    private static void writeData(GameMove gameMove, BufferedWriter bw) throws IOException {
        bw.write(String.format("%s;%s;%s", gameMove.getPlayerChoice(), gameMove.getComputerChoice(), gameMove.getWinner()));
    }
}
