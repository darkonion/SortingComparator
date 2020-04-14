package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class SelectionSort implements SortingStrategy {
	

	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		if (numbsToSort.length <= 1) {
			System.out.println("There is nothing to sort!!! \n");
			return numbsToSort;
		}

		for (int last = numbsToSort.length - 1; last > 0; last--) {

			int largest = 0;
			for (int i = 1; i <= last; i++) {
				if (numbsToSort[i] > numbsToSort[largest]) {
					largest = i;
				}
			}

			int temp = numbsToSort[largest];
			numbsToSort[largest] = numbsToSort[last];
			numbsToSort[last] = temp;

		}
		return numbsToSort;
		
	}

}
