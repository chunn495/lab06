package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            array.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> list = new LinkedList<>(array);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int integer : array) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int elements = 100000;
        long startArrayList = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            array.add(0, i);
        }
        long endArrayList = System.currentTimeMillis();
        System.out.println("Tempo ArrayList: " + (endArrayList - startArrayList) + " ms");
        long startLinkedList = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            list.add(0, i);
        }
        long endLinkedList = System.currentTimeMillis();
        System.out.println("Tempo LinkedList: " + (endLinkedList - startLinkedList) + "ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int reads = 1000;
        long startArrayListRead = System.currentTimeMillis();

        for (int i = 0; i < reads; i++) {
            array.get(array.size() / 2);
        }
        long endArrayListRead = System.currentTimeMillis();
        System.out.println("ArrayList Read Time: " + (endArrayListRead - startArrayListRead));
        long startLinkedListRead = System.currentTimeMillis();
        for (int i = 0; i < reads; i++) {
            list.get(list.size() / 2);
        }
        long endLinkedListRead = System.currentTimeMillis();
        System.out.println("LinkedList Read Time: " + (endLinkedListRead - startLinkedListRead));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>(); 
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        Long sumLong = 0L;
        for (final Long l : map.values()){
        sumLong = sumLong + l;
        System.out.println("Popolazione mondiale totale: " + sumLong);
        }
    } 
}
