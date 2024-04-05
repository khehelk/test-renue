package org.example;

import org.example.StemmerPorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class ReportLoader {
    public HashMap<String, HashSet<String>> loadData(String dataFilePath) {
        var dataMap = new LinkedHashMap<String, HashSet<String>>();

        try (BufferedReader fileReader = Files.newBufferedReader(Paths.get(dataFilePath))) {
            String line;

            while ((line = fileReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid input format");
                }

                var i = getEntry(parts[2].trim());
                dataMap.put(parts[0].trim(), i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataMap;
    }

    protected HashSet<String> getEntry(String line){
        return StemmerPorter.getStemmedLine(line.trim());
    }
}
