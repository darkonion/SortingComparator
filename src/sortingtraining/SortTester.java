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

			System.out.println("\nYour new Array: " + Arrays.toString(numbers) + "\n");

			if (strategy == Strategy.COMPARE) {
				new ComparingUtil().compare(numbers); //does this kind of shortcut is a 'faux pas'?
			} else {
				SortingUtil sortingUtil = new SortingUtil(strategy.resolve());
				sortingUtil.sort(numbers);
			}
		}
	}

	private Strategy getStrategy(Scanner in) {

		while (true) {
			System.out.println(
					"Type a sorting strategy(" + Strategy.list() + "):\n");
			try {
				return Strategy.valueOf(in.nextLine().toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("\nWrong input, try again!\n");
			}
		}
	}

	private int[] getInts(Scanner in) {

		while (true) {
			System.out.println("\nType size of your Array with random numbers: \n");

			try {
				return ArrayGeneratorUtil.generate(Integer.parseInt(in.nextLine()));
			} catch (NumberFormatException e) {
				System.out.println("\nWrong input, try again, only numbers allowed!\n");
			}
		}
	}
}
