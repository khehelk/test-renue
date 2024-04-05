package org.example;

import org.example.data.ClassifierProperties;
import org.example.data.ReportData;
import org.example.data.ResultData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextClassifier {
    private ClassifierProperties properties;
    private ReportData reports;

    public TextClassifier(ClassifierProperties properties) {
        this.properties = properties;
    }

    public void setProperties(ClassifierProperties properties) {
        this.properties = properties;
    }

    public ArrayList<ResultData> startSearch() {
        if (reports == null) {
            throw new IllegalStateException("Не загружены данные для классификатора!");
        }
        ArrayList<ResultData> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(properties.getInputFilePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                long startSearch = System.currentTimeMillis();
                HashMap<String, Integer> matches = new HashMap<>();
                var i = StemmerPorter.getStemmedLine(line);

                for (var report : reports.getReports().entrySet()) {
                    int matchesNumber = countMatches(i,
                        report.getValue());
                    if (matchesNumber > 0) {
                        matches.put(report.getKey(), matchesNumber);
                    }
                }
                List<Map.Entry<String, Integer>> entryList = new ArrayList<>(matches.entrySet());
                entryList.sort(Map.Entry.comparingByValue());
                ArrayList<String> reportList = new ArrayList<>();

                for (Map.Entry<String, Integer> entry : entryList) {
                    reportList.add(entry.getKey());
                }

                long searchTime = System.currentTimeMillis() - startSearch;
                result.add(new ResultData(line, reportList, (int) searchTime));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private int countMatches(Set<String> request, Set<String> report) {
        Set<String> requestWords = new HashSet<>(request);
        requestWords.retainAll(report);
        return requestWords.size();
    }

    public void loadReports() {
        this.reports = new ReportData(properties.getDataFilePath());
        System.out.println(this.reports.getReports());
    }
}
