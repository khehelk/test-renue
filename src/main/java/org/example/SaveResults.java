package org.example;

import org.example.data.OutputData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveResults {
    public static void writeToJsonFile(OutputData jsonData, String filePath) {
        try (BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
            fileWriter.write(jsonData.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
