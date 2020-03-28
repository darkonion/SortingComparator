package sortingtraining;

import sortingtraining.resolver.SortingStrategySwitchResolver;
import sortingtraining.utils.ArrayGeneratorUtil;
import sortingtraining.utils.ComparingUtil;
import sortingtraining.utils.SortingUtil;

import java.util.Arrays;
import java.util.Scanner;


public class SortTester {

	private Strategy strategy;

	public static void main(String[] args) {
		new SortTester().run();
	}

	void run() {

		try (Scanner in = new Scanner(System.in)) {

			int[] numbers;

			numbers = getInts(in);

			mainMenu(in, numbers);
		}
	}

	private void mainMenu(Scanner in, int[] numbers) {

		while (true) {

			while (true) {
				System.out.print(
						"Type a sorting strategy (BUBBLE, BUCKET, INSERTION, QUICK, DEFAULT, ALL(compare all), EXIT): ");
				try {
					strategy = Strategy.valueOf(in.nextLine().toUpperCase());

					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Wrong input, try again!");
				}
			}

			if (strategy == Strategy.EXIT) {
				break;

			} else if (strategy == Strategy.ALL) {
				ComparingUtil comparingUtil = new ComparingUtil();
				comparingUtil.compare(numbers);

			} else {
				SortingUtil sortingUtil = new SortingUtil(new SortingStrategySwitchResolver());
				sortingUtil.sort(numbers, strategy);
			}
		}
	}

	private int[] getInts(Scanner in) {
		int[] numbers;
		while (true) {
			System.out.print("Type size of your Array with random numbers: ");

			try {
				numbers = ArrayGeneratorUtil.generate(Integer.parseInt(in.nextLine()));
				break;
			} catch (NumberFormatException e) {
				System.out.println("Wrong input, try again, only numbers allowed!");
			}
		}

		System.out.println("Your new Array: " + Arrays.toString(numbers));
		System.out.println("");
		return numbers;
	}
}
