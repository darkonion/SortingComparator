package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class MergeSort implements SortingStrategy {


	public int[] sort(int[] numbers) {

		int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

		if (numbsToSort.length <= 1) {
			System.out.println("There is nothing to sort!!! \n");
			return numbsToSort;
		}

		mainSort(numbsToSort, 0, numbsToSort.length);

		return numbsToSort;
	}


	public void mainSort(int[] numbers, int left, int right) {

		if (right - left < 2) {			// our Base Case - you cannot divide array of 1 element
			return;
		}

		int mid = (left + right)/2;

		mainSort(numbers, left, mid);   //dividing arrays into /2 ones - divide and conquer
		mainSort(numbers, mid, right);

		merge(numbers, left, mid, right);
	}

	private void merge(int[] numbers, int left, int mid, int right) {

		if (numbers[mid-1] <= numbers[mid]) { //shortcut - if the last position in left array is lesser than
			return;                           // first position in the right array, than we are already done!
		}										// it is because left and right subsets are already sorted!

		int i = left;
		int j = mid;
		int tempIndex = 0;

		int[] temp = new int [right - left];

		while (i < mid && j < right) {
			// if numbers of j is >= numbers of i then =numbers[i++], else =numbers[j++]
			temp[tempIndex++] = numbers[i] <= numbers[j] ? numbers[i++] : numbers[j++];
 		}

		System.arraycopy(numbers, i, numbers, left + tempIndex, mid - i);
		System.arraycopy(temp, 0, numbers, left, tempIndex);

	}
}
