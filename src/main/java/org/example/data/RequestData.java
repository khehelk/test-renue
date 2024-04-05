package org.example.data;

import org.example.loader.Loader;
import org.example.loader.RequestLoader;

import java.util.HashMap;
import java.util.HashSet;

public class RequestData {
    private final HashMap<String, HashSet<String>> requests;
    private final Loader requestLoader;

    public RequestData(String requestFilePath){
        requestLoader = new RequestLoader();
        requests = loadRequests(requestFilePath);
    }

    private HashMap<String, HashSet<String>> loadRequests(String requestFilePath) {
        return requestLoader.loadData(requestFilePath);
    }
}
