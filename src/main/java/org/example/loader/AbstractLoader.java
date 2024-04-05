package org.example.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public abstract class AbstractLoader implements Loader{
    public HashMap<String, HashSet<String>> loadData(String dataFilePath) {
        var dataMap = new LinkedHashMap<String, HashSet<String>>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                var i = getEntry(line);
                dataMap.put(line.trim(), i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataMap;
    }

    protected abstract HashSet<String> getEntry(String line);
}
