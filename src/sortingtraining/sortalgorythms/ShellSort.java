package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class ShellSort implements SortingStrategy {
	
	
	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		if (numbsToSort.length <= 1) {
			System.out.println("There is nothing to sort!!! \n");
			return numbsToSort;
		}

		for (int gap = numbsToSort.length/2; gap > 0 ; gap /= 2) {


			for (int i = gap; i <= numbsToSort.length - 1; i++) {

				int key = numbsToSort[i];

				int j = i;

				while (j >= gap && numbsToSort[j - gap] > key) {
					numbsToSort[j] = numbsToSort[j - gap];
					j -= gap;
				}

				numbsToSort[j] = key;
			}
		}

		return numbsToSort;
		
		
	}



}
