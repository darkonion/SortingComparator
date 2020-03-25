package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class QuickSort implements SortingStrategy {
	

	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		mainSort(numbsToSort, 0, numbsToSort.length -1);

		return numbsToSort;
	}


	public void mainSort(int[] numbers, int left, int right) {
		
		int index = divide(numbers, left, right);
		
		if (index-1 > left) {
			mainSort(numbers, left, index-1);
		}
		
		if (index < right) {
			mainSort(numbers, index, right);
		}

		
	}

	private static int divide(int[] numbers, int left, int right) {
		
		int pivot = numbers[(left+right)/2];
		
		int i = left;
		int j = right;
		
		while (i <= j) {
			
			while (numbers[i] < pivot) {
				i++;
			}
			
			while (numbers[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		}

		return i;
	}

}
