package org.example.data;

import java.util.ArrayList;

public class OutputData{
    private final int initTime;
    private ArrayList<ResultData> result;

    public OutputData(int i, ArrayList<ResultData> result) {
        this.initTime = i;
        this.result = result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"initTime\": ").append(initTime).append(",\n");
        sb.append("  \"result\": [\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i).toString());
            if (i < result.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("  ]\n}");
        return sb.toString();
    }
}
