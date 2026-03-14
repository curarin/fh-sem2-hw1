package org.lecture.handler;

import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameMove;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Log4j2
public class FileWriter {
    public void writeFile(GameMove[] gameMovesArray) throws IOException {
        LocalDateTime currentTimestamp = LocalDateTime.now();

        Path path = Paths.get("src", "main", "resources", "gameSafes", currentTimestamp + ".csv");

        if (Files.notExists(path)) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("playerChoice;computerChoice;moveWinner\n");
            for (GameMove gameMove : gameMovesArray) {
                writeData(gameMove, bw);
                bw.newLine();
            }
        }
        log.info("File written successfully to {}", path);
        System.out.println("Game successfully saved.");
    }

    private static void writeData(GameMove gameMove, BufferedWriter bw) throws IOException {
        bw.write(String.format("%s;%s;%s", gameMove.getPlayerChoice(), gameMove.getComputerChoice(), gameMove.getWinner()));
    }
}
