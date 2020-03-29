package sortingtraining.sortalgorythms;

import sortingtraining.utils.ArrayGeneratorUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {

    public static void main(String... args) {
        new SortTest().run();
    }

    private void run() {
        sortingTest(1);
        sortingTest(10);
        sortingTest(0);
        sortingTest(943859);
    }

    private void sortingTest(final int length) {
        System.out.println("Sorting array length: " + length);
        int[] originalArr = ArrayGeneratorUtil.generate(length);
        printArray(originalArr);
        int[] referenceArr = Arrays.copyOf(originalArr, length);
        Arrays.sort(referenceArr);
        for (SortingStrategy testedStrategy: Arrays.asList(new BucketSort(),new QuickSort(), new InsertionSort())) {
            testSort(testedStrategy, originalArr, referenceArr);
        }
    }

    private void testSort(SortingStrategy strategy, int[] arr, int[] referenceArr) {
        System.out.println("Starting test strategy: " + strategy.getClass());
        final long start = System.currentTimeMillis();
        final int[] sorted = strategy.sort(arr);
        System.out.println("Finished: " + strategy.getClass() + " in: " + (System.currentTimeMillis() - start) + "ms.");
        trivialAssertTrue(sorted != arr, "arrays should not be equal (the same address in memory)");
        trivialAssertTrue(sorted.length == arr.length, "arrays should have the same length");
        System.out.println("Sorted:");
        printArray(sorted);
        System.out.println("Reference:");
        printArray(referenceArr);
        trivialAssertTrue(Arrays.equals(sorted, referenceArr), "arrays should be equal");
    }

    private void printArray(int[] arr) {
        List<String> arrAsInt = new ArrayList<>();
        for (int i : arr) {
            arrAsInt.add(String.valueOf(i));
        }
        System.out.println(String.join(", ", arrAsInt));
    }

    private void trivialAssertTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}