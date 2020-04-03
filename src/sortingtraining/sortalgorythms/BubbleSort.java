package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class BubbleSort implements SortingStrategy {
	
	
	
	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		if (numbsToSort.length <= 1) {
			System.out.println("There is nothing to sort!!! \n");
			return numbsToSort;
		}

		int size = numbsToSort.length - 1;
		
		for (int i = 0; i <= size - 1; i++) {
			for (int j = 0; j <= size -1; j++) {
				if (numbsToSort[j] > numbsToSort[j+1]) {
					int temp = numbsToSort[j];
					numbsToSort[j] = numbsToSort[j+1];
					numbsToSort[j+1] = temp;
				}
			}
		}

		return numbsToSort;
		
	}

}
