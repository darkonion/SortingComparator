package sortingtraining;

import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.BucketSort;
import sortingtraining.sortalgorythms.DefaultParallelSort;
import sortingtraining.sortalgorythms.DefaultSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.MergeSort;
import sortingtraining.sortalgorythms.QuickSort;
import sortingtraining.sortalgorythms.SelectionSort;
import sortingtraining.sortalgorythms.ShellSort;
import sortingtraining.sortalgorythms.SortingStrategy;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Strategy {


    COMPARE("Comparing"){
        public SortingStrategy resolve() {
            return null;
        }
    },
    BUBBLE("Bubble Sort") {
        public SortingStrategy resolve() {
            return new BubbleSort();
        }
    },
    SELECTION("Selection Sort") {
        public SortingStrategy resolve() {
            return new SelectionSort();
        }
    },
    BUCKET("Bucket Sort") {
        public SortingStrategy resolve() {
            return new BucketSort();
        }
    },
    INSERTION("Insertion Sort") {
        public SortingStrategy resolve() {
            return new InsertionSort();
        }
    },
    SHELL("Shell Sort") {
        public SortingStrategy resolve() {
            return new ShellSort();
        }
    },
    JDK_SORT("JDK Sort") {
        public SortingStrategy resolve() {
            return new DefaultSort();
        }
    },
    JDK_PARALLEL("JDK Parallel Sort") {
        public SortingStrategy resolve() {
            return new DefaultParallelSort();
        }
    },
    MERGE("Merge Sort") {
        public SortingStrategy resolve() {
            return new MergeSort();
        }
    },
    QUICK("Quick Sort") {
        public SortingStrategy resolve() {
            return new QuickSort();
        }
    },
    EXIT("EXIT") {
        public SortingStrategy resolve() {
            return null;
        }
    };

    private String sortName;

    Strategy(String sortName) {
        this.sortName = sortName;
    }

    public abstract SortingStrategy resolve();

    public static String list() {

        return Arrays.stream(Strategy.values())
                .map(Enum::toString)
                .collect(Collectors.joining(", "));
    }

    public String getSortName() {
        return sortName;
    }
}
