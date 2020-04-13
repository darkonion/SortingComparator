package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class BubbleSort implements SortingStrategy {
	
	
	
	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		if (numbsToSort.length <= 1) {
			System.out.println("There is nothing to sort!!! \n");
			return numbsToSort;
		}

		int numbsSize = numbsToSort.length - 1;
		
		for (int size = numbsSize; size > 0; size--) {
			for (int i = 0; i < size; i++) {
				if (numbsToSort[i] > numbsToSort[i+1]) {
					int temp = numbsToSort[i];
					numbsToSort[i] = numbsToSort[i+1];
					numbsToSort[i+1] = temp;
				}
			}
		}

		return numbsToSort;
		
	}

}
