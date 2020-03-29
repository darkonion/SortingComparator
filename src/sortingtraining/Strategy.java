package sortingtraining;

import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.BucketSort;
import sortingtraining.sortalgorythms.DefaultSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.QuickSort;
import sortingtraining.sortalgorythms.SortingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {

    COMPARE{
        SortingStrategy resolve() {
            return null;
        }
    },
    BUBBLE {
        SortingStrategy resolve() {
            return new BubbleSort();
        }
    },
    BUCKET {
        SortingStrategy resolve() {
            return new BucketSort();
        }
    },
    INSERTION {
        SortingStrategy resolve() {
            return new InsertionSort();
        }
    },
    DEFAULT {
        SortingStrategy resolve() {
            return new DefaultSort();
        }
    },
    QUICK {
        SortingStrategy resolve() {
            return new QuickSort();
        }
    },
    EXIT {
        SortingStrategy resolve() {
            return null;
        }
    };

    abstract SortingStrategy resolve();

    public static String list() {

        List<String> str = new ArrayList<>();
        Arrays.asList(Strategy.values()).forEach($ -> str.add($.toString()));
        String result = str.stream().collect(Collectors.joining(", "));

        return result;
    }

}
