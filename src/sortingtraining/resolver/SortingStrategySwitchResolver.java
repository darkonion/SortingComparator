package sortingtraining.resolver;


import sortingtraining.sortalgorythms.SortingStrategy;
import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.BucketSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.QuickSort;

public class SortingStrategySwitchResolver implements SortingStrategyResolver {

    public SortingStrategy resolve(String strategy) {

       SortingStrategy sortingStrategy;

        switch (strategy) {
            case "BUBBLE":
                sortingStrategy = new BubbleSort();
                break;
            case "INSERTION":
                sortingStrategy = new InsertionSort();
                break;
            case "QUICK":
                sortingStrategy = new QuickSort();
                break;
            case "BUCKET":
                sortingStrategy = new BucketSort();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + strategy);
        }

        return sortingStrategy;
    }
}
