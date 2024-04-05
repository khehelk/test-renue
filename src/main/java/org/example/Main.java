package org.example;

import org.example.data.ClassifierProperties;
import org.example.data.OutputData;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ClassifierProperties properties = getProperties(args);
        TextClassifier textClassifier = new TextClassifier(properties);
        textClassifier.loadReports();
        long endTime = System.currentTimeMillis();

        var result = textClassifier.startSearch();

        SaveResults.writeToJsonFile(new OutputData((int)(endTime - startTime), result), properties.getOutputFilePath());
    }

    private static ClassifierProperties getProperties(String[] args) {
        ClassifierProperties properties = new ClassifierProperties();

        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "--data" -> properties.setDataFilePath(args[++i]);
                case "--input-file" -> properties.setInputFilePath(args[++i]);
                case "--output-file" -> properties.setOutputFilePath(args[++i]);
            }
        }

        if (!properties.isAssigned()) {
            throw new IllegalArgumentException("Не все данные получены");
        }
        return properties;
    }
}