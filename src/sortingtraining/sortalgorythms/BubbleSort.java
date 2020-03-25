package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class BubbleSort implements SortingStrategy {
	
	
	
	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);
		
		int size = numbsToSort.length - 1;
		
		for (int m = 0; m <= size - 1; m++) {
			for (int n = 0; n <= size -1; n++) {
				if (numbsToSort[n] > numbsToSort[n+1]) {
					int temp = numbsToSort[n];
					numbsToSort[n] = numbsToSort[n+1];
					numbsToSort[n+1] = temp;
				}
			}
		}

		return numbsToSort;
		
	}

}
