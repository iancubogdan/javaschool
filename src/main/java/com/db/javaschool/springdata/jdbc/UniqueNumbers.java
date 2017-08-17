package com.db.javaschool.springdata.jdbc;

import java.util.*;


public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (Integer integer : numbers) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, map.get(integer)+1);
            }
        }

        List result = new ArrayList();
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                result.add(integer);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}