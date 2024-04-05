package org.example.data;

public class ClassifierProperties {
    private String dataFilePath;
    private String inputFilePath;
    private String outputFilePath;

    public boolean isAssigned(){
        return dataFilePath != null
            && inputFilePath != null
            && outputFilePath != null;
    }

    public void setDataFilePath(String arg) {
        this.dataFilePath = arg;
    }

    public void setInputFilePath(String arg) {
        this.inputFilePath = arg;
    }

    public void setOutputFilePath(String arg) {
        this.outputFilePath = arg;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    public String getInputFilePath() {
        return this.inputFilePath;
    }

    public String getDataFilePath() {
        return this.dataFilePath;
    }
}
