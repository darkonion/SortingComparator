package sortingtraining.utils;

import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.QuickSort;

public class ComparingUtil {

    public void compare(int[] numbers) {

        double bubbleSortTime = TimerUtil.measure(new BubbleSort(), numbers);
        double insertionSortTime = TimerUtil.measure(new InsertionSort(), numbers);
        double quickSortTime = TimerUtil.measure(new QuickSort(), numbers);

        System.out.println("__________________________________________");

        System.out.println("Size of sorted array: " + numbers.length);

        System.out.println("Bubble Sort time: " + bubbleSortTime + "s");

        System.out.println("Insertion Sort time: " + insertionSortTime + "s "
                + (int)(bubbleSortTime/insertionSortTime) + "x Times faster than Bubble Sort!");

        System.out.println("Quick Sort time: " + quickSortTime + "s "
                + (int)(insertionSortTime/quickSortTime) + "x Times faster than Insertion Sort! | "
                + (int)(bubbleSortTime/quickSortTime) + "x Times faster than Bubble Sort!");

        System.out.println("__________________________________________");


    }
}
