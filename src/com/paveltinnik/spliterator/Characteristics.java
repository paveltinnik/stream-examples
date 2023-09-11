package com.paveltinnik.spliterator;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Characteristics {
    private void distinct() {
        // Defines if for each pair of encountered elements x, y, !x.equals(y).

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Spliterator<Integer> spliterator = set.stream().spliterator();
        System.out.println(spliterator.hasCharacteristics(Spliterator.DISTINCT)); // true
    }

    private void ordered() {
        // Defines if the elements have an order. If so, Spliterator traverses and splits elements accordingly.
        // Note that a Spliterator guaranteed to be ORDERED for any List.

        var spliterator = LongStream.range(0, 10_000).spliterator();
        System.out.println(spliterator.hasCharacteristics(Spliterator.ORDERED)); // true
    }

    private void sorted() {
        // Defines if the traversed elements follow a predefined sort order.
        // Note that if a Spliterator is SORTED, it must also report ORDERED.

        Spliterator<Integer> spliterator = IntStream.range(0, 1000).spliterator();
        System.out.println(spliterator.hasCharacteristics(Spliterator.SORTED)); // true
    }

    private void sized() {
        // Defines if a Spliterator was created from a structure with a known size.
        // For example, a Spliterator of the infinite stream will not have this characteristic.

        IntStream.generate(() -> 2)
                .spliterator()
                .hasCharacteristics(Spliterator.SIZED); // false
    }

    private void nonnull() {
        //Defines if the source guarantees that Spliterator elements will not be null.

        List<String> list = new ArrayList<>();
        list.add("text");
        list.add(null);
        list.add("more text");

        list.spliterator()
                .hasCharacteristics(Spliterator.NONNULL); // false
    }

    private void immutable() {
        // Defines if the element source cannot be structurally modified.

        List<String> list = new ArrayList<>();
        list.add("text");
        list.add(null);
        list.add("more text");

        list.spliterator()
                .hasCharacteristics(Spliterator.IMMUTABLE); // false

        System.out.println(list.spliterator().characteristics());
    }

    private void concurrent() {
        // Defines if the source of Spliterator elements may be safely concurrently modified
        // by multiple threads without external synchronization.

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        arrayBlockingQueue
                .spliterator()
                .hasCharacteristics(Spliterator.CONCURRENT); // true
    }

    private void subsized() {
        // Defines if the current Spliterator and all further Spliterators produced
        // by the trySplit method are SIZED.

        IntStream.range(0, 1000)
                .spliterator()
                .hasCharacteristics(Spliterator.SUBSIZED); // true
    }
}
