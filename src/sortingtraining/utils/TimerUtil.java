package sortingtraining.utils;

import sortingtraining.sortalgorythms.SortingStrategy;

import java.time.Instant;

public class TimerUtil {

    public static double measure(SortingStrategy sortingStrategy, int[] numbers) {

        long start = Instant.now().toEpochMilli();
        sortingStrategy.sort(numbers);
        long end = Instant.now().toEpochMilli();

        double difference = (double)(end - start)/1000;

        return difference;


    }
}
