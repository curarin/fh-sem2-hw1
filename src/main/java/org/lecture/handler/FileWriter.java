package org.lecture.handler;

import org.lecture.model.GameMove;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class FileWriter {
    public void writeFile(GameMove[] gameMovesArray) throws IOException {
        LocalDateTime currentTimestamp = LocalDateTime.now();

        Path path = Paths.get("src", "main", "resources", "gameSafes", currentTimestamp + ".txt");

        if (Files.notExists(path)) {
            Files.createDirectories(path.getParent());
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (GameMove gameMove : gameMovesArray) {
                writeData(gameMove, bw);
                bw.newLine();
            }
        }
        System.out.printf(
                "File successfully written to '%s'.\n",
                path)
        ;
    }

    private static void writeData(GameMove gameMove, BufferedWriter bw) throws IOException {
        bw.write(String.format("%s,%s,%s", gameMove.getPlayerChoice(), gameMove.getComputerChoice(), gameMove.getWinner()));
    }
}
