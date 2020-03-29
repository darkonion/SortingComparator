package sortingtraining.utils;

import java.util.Random;

public class ArrayGeneratorUtil {

    private ArrayGeneratorUtil() {
    }

    private static final Random gen = new Random();

    public static int[] generate(int n) {

        if (n < 1) {
            System.out.println("Too small, changing size to 1000");
            n = 1000;
        }

        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = gen.nextInt(100000) - 50000;
        }

        return numbers;
    }

}
