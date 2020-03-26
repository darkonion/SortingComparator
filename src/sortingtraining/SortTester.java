package sortingtraining;

import sortingtraining.resolver.SortingStrategySwitchResolver;
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

			System.out.print("Type size of your Array with random numbers: ");

			final int[] numbers = ArrayGeneratorUtil.generate(Integer.parseInt(in.nextLine()));

			System.out.println("Your new Array: " + Arrays.toString(numbers));


			while (true) {

				System.out.println("");
				System.out.print("Type a sorting strategy (BUBBLE, BUCKET, INSERTION, QUICK, DEFAULT, ALL(compare all), EXIT): ");
				String strategy = in.nextLine();

				if (strategy.equals("EXIT")) {
					break;

				} else if (strategy.equals("ALL")) {
					ComparingUtil comparingUtil = new ComparingUtil();
					comparingUtil.compare(numbers);

				} else {

					SortingUtil sortingUtil = new SortingUtil(new SortingStrategySwitchResolver());
					sortingUtil.sort(numbers, strategy);

				}
			}
		}
	}

}
