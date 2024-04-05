package org.example.data;

import java.util.ArrayList;

public class ResultData {
    private String search;
    private ArrayList<String> result;
    private int time;

    public ResultData(String line, ArrayList<String> reportList, int searchTime) {
        this.search = line;
        this.result = reportList;
        this.time = searchTime;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("    {\n");
        sb.append("      \"search\": ").append("\"").append(search).append("\"").append(",\n");
        sb.append("      \"result\": [\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append("        \"").append(result.get(i)).append("\"");
            if (i < result.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("      ],\n");
        sb.append("      \"time\": ")
            .append(time)
            .append("\n");
        sb.append("    }");
        return sb.toString();
    }
}
