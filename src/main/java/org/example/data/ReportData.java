package org.example.data;

import org.example.ReportLoader;

import java.util.HashMap;
import java.util.HashSet;

public class ReportData {
    private final HashMap<String, HashSet<String>> reports;
    private final ReportLoader reportLoader;

    public ReportData(String reportFilePath){
        reportLoader = new ReportLoader();
        reports = loadReports(reportFilePath);
    }

    private HashMap<String, HashSet<String>> loadReports(String dataFilePath) {
        return reportLoader.loadData(dataFilePath);
    }

    public HashMap<String, HashSet<String>> getReports() {
        return reports;
    }
}
