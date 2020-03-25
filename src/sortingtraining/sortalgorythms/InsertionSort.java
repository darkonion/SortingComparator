package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class InsertionSort implements SortingStrategy {
	
	
	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		for (int i=1; i <= numbsToSort.length - 1; i++) {
		
			int key = numbsToSort[i];
			
			int j = i-1;
			
			while (j>=0 && numbsToSort[j] > key) {
				numbsToSort[j+1] = numbsToSort[j];
				j--;
				
			}	
			
			numbsToSort[j+1] = key;
					
		}

		return numbsToSort;
		
		
	}



}
