package com.scholastic.intl.litpro.test.automation.pageobjects;

import java.util.HashMap;
import java.util.Map;

public class util {

    private static final HashMap<String, String> map;
    private static util instance;

    private util() {
    }

    static {
    	 map = new HashMap<String, String>();
    	 instance =new util();
    }
    
    public static util getInstance() {
        return instance;
    }
    
    public static Map getMap() {
        return map;
    }

    public static String getValue(String key) {
        return map.get(key);
    }

    public static void add(String[][] pairs) {
        for(String[] pair : pairs) {
            map.put(pair[0], pair[1]);
        }
    }

    public static void add(String string, String string1) {
        //for (int i = 0; i < string.length(); ++i) {
            map.put(string, string1);
        //}
    }
}
