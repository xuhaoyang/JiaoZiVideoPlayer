package com.jzvd.demo;

public class Utils {

    public static boolean isContent(String path) {
        try {
            if (path.startsWith("content:")) {
                return true;
            }
        } catch (NullPointerException e) {
        }
        return false;
    }

    public static boolean isFile(String path) {
        try {
            if (path.startsWith("file:")) {
                return true;
            }
        } catch (NullPointerException e) {
        }
        return false;
    }

}
