package org.example.loader;

import org.example.StemmerPorter;

import java.util.HashSet;

public class ReportLoader extends AbstractLoader {
    @Override
    protected HashSet<String> getEntry(String line){
        String[] parts = line.split("\\|");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid input format");
        }

        return StemmerPorter.getStemmedLine(parts[2]);
    }
}
