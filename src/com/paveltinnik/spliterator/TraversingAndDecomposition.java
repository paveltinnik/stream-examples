package com.paveltinnik.spliterator;

import java.util.Spliterator;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;

public class TraversingAndDecomposition {
    private void tryAdvance() {
        /* The tryAdvance method of the Spliterator interface behaves similarly to the Iterator.
        * It sequentially consumes elements of Spliterator one by one and performs a specified
        * action returning true if a remaining element exists. Otherwise, it returns false.
        * There is an example: */

        var spliterator = LongStream.range(0, 10_000).spliterator();

        int count = 0;

        LongConsumer display = System.out::println;
        while (spliterator.tryAdvance(display)) {
            count++;
        }

        System.out.println("count: " + count);
    }

    private void trySplit() {
        /* In contrast to the tryAdvance, the trySplit method is unique to the Spliterator design.
        * As the name implies, the trySplit method is used to decompose some of the source elements
        * into another Spliterator. It allows us to process multiple chunks of data in parallel.
        * It's important to remember that the trySplit returns a Spliterator covering elements that
        * will not be covered by a calling Spliterator. As the official documentation declares:
        * trySplit may return null for any reason, including emptiness, inability to split after
        * traversal has commenced, data structure constraints, and efficiency considerations. */

        var spliterator1 = LongStream.range(0, 10_000).spliterator();
        spliterator1.estimateSize(); // 10 000

        Spliterator.OfLong spliterator2 = spliterator1.trySplit();
        spliterator1.estimateSize(); // 5 000
        spliterator2.estimateSize(); // 5 000

        Spliterator.OfLong spliterator3 = spliterator2.trySplit();
        spliterator1.estimateSize(); // 5 000
        spliterator2.estimateSize(); // 2 500
        spliterator3.estimateSize(); // 2 500
    }
}
