package org.example.loader;

import org.example.StemmerPorter;

import java.util.HashSet;

public class RequestLoader extends AbstractLoader {
    @Override
    protected HashSet<String> getEntry(String line){
        return StemmerPorter.getStemmedLine(line);
    }
}
