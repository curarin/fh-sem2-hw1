package org.lecture.handler;

import lombok.extern.log4j.Log4j2;
import org.lecture.model.GameMove;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Log4j2
public class FileWriter {
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

    private static void writeData(GameMove gameMove, BufferedWriter bw) throws IOException {
        bw.write(String.format("%s;%s;%s", gameMove.getPlayerChoice(), gameMove.getComputerChoice(), gameMove.getWinner()));
    }
}
