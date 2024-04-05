package org.example.loader;

import java.util.HashMap;
import java.util.HashSet;

public interface Loader {
    HashMap<String, HashSet<String>> loadData(String inputFilePath);
}
