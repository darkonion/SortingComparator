package sortingtraining;

import sortingtraining.utils.ArrayGeneratorUtil;
import sortingtraining.utils.ComparingUtil;
import sortingtraining.utils.SortingUtil;

import java.util.Arrays;
import java.util.Scanner;

public class SortTester {

	public static void main(String[] args) {
		new SortTester().run();
	}

	void run() {

		try (Scanner in = new Scanner(System.in)) {

			mainMenu(in);
		}
	}

	private void mainMenu(Scanner in) {

		while (true) {

			Strategy strategy = getStrategy(in);

			if (strategy == Strategy.EXIT) {

				System.out.println("\nSee you again!\n");
				break;
			}

			int[] numbers = getInts(in);

			if (strategy == Strategy.COMPARE) {
				ComparingUtil comparingUtil = new ComparingUtil();
				comparingUtil.compare(numbers);

			} else {

				SortingUtil sortingUtil = new SortingUtil(strategy.resolve());

				sortingUtil.sort(numbers, strategy);

			}
		}
	}

	private Strategy getStrategy(Scanner in) {

		Strategy strategy;
		while (true) {

			System.out.println(
					"Type a sorting strategy(" + Strategy.list() + "):\n");
			try {
				strategy = Strategy.valueOf(in.nextLine().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("\nWrong input, try again!\n");
			}
		}
		return strategy;
	}

	private int[] getInts(Scanner in) {
		int[] numbers;
		while (true) {
			System.out.println("\nType size of your Array with random numbers: \n");

			try {
				numbers = ArrayGeneratorUtil.generate(Integer.parseInt(in.nextLine()));
					break;
			} catch (NumberFormatException e) {
				System.out.println("\nWrong input, try again, only numbers allowed!\n");
			}
		}

		System.out.println("\nYour new Array: " + Arrays.toString(numbers) + "\n");
		return numbers;
	}
}
