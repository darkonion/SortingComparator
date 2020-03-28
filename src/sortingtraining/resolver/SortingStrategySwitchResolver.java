package sortingtraining.resolver;


import sortingtraining.Strategy;
import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.BucketSort;
import sortingtraining.sortalgorythms.DefaultSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.QuickSort;
import sortingtraining.sortalgorythms.SortingStrategy;

public class SortingStrategySwitchResolver implements SortingStrategyResolver {

    public SortingStrategy resolve(Strategy strategy) {

       SortingStrategy sortingStrategy;

        switch (strategy) {
            case BUBBLE:
                sortingStrategy = new BubbleSort();
                break;
            case INSERTION:
                sortingStrategy = new InsertionSort();
                break;
            case QUICK:
                sortingStrategy = new QuickSort();
                break;
            case BUCKET:
                sortingStrategy = new BucketSort();
                break;
            case DEFAULT:
                sortingStrategy = new DefaultSort();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + strategy);
        }

        return sortingStrategy;
    }
}
