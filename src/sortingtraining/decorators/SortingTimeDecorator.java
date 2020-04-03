package sortingtraining.decorators;

import sortingtraining.sortalgorythms.SortingStrategy;

import java.time.Instant;

public class SortingTimeDecorator extends SortingDecorator {


    public SortingTimeDecorator(SortingStrategy decorated) {
        super(decorated);
    }

    public int[] sort(int[] numbers) {

        long start = Instant.now().toEpochMilli();
        int[] sorted = decorated.sort(numbers);
        long end = Instant.now().toEpochMilli();

        System.out.println("Sorting type: " + decorated.getClass().getSimpleName());
        System.out.println("Sorting time: " + (double)(end - start)/1000 + " s \n");

        return sorted;
    }
}
