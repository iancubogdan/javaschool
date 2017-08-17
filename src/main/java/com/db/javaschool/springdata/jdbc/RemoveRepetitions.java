package com.db.javaschool.springdata.jdbc;

/**
 * Created by iancu on 8/13/2017.
 */
public class RemoveRepetitions {
    public static String transform(String input) {
        return input.replaceAll("(.)\\1{1,}", "$1");
    }

    public static void main(String[] args) {
        System.out.println(RemoveRepetitions.transform("abbcbbb"));
    }
}
