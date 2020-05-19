package sortingtraining.utils;

import sortingtraining.models.TimeMeasurement;
import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.BucketSort;
import sortingtraining.sortalgorythms.DefaultParallelSort;
import sortingtraining.sortalgorythms.DefaultSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.MergeSort;
import sortingtraining.sortalgorythms.QuickSort;
import sortingtraining.sortalgorythms.SelectionSort;
import sortingtraining.sortalgorythms.ShellSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparingUtil {

    public void compare(int[] numbers) {

        List<TimeMeasurement> times = Arrays.asList(
                new TimeMeasurement(TimerUtil.measure(new InsertionSort(), numbers), "Insertion Sort"),
                new TimeMeasurement(TimerUtil.measure(new ShellSort(), numbers), "Shell Sort"),
                new TimeMeasurement(TimerUtil.measure(new BubbleSort(), numbers), "Bubble Sort"),
                new TimeMeasurement(TimerUtil.measure(new SelectionSort(), numbers), "Selection Sort"),
                new TimeMeasurement(TimerUtil.measure(new MergeSort(), numbers), "Merge Sort"),
                new TimeMeasurement(TimerUtil.measure(new QuickSort(), numbers), "Quick Sort"),
                new TimeMeasurement(TimerUtil.measure(new BucketSort(), numbers), "Bucket Sort"),
                new TimeMeasurement(TimerUtil.measure(new DefaultSort(), numbers), "JDK Sort"),
                new TimeMeasurement(TimerUtil.measure(new DefaultParallelSort(), numbers), "JDK Parallel Sort")

        );

        Collections.sort(times,
                Comparator.comparingDouble(TimeMeasurement::getMeasurement).reversed()); //dsc

        print(times);

    }


    private void print(List<TimeMeasurement> times) {

        System.out.println("-------------------------------------------------------------------------");
        for (int n = 0; n < times.size(); n++) {

            System.out.print(times.get(n).getName());
            System.out.print(" Delay: " + times.get(n).getMeasurement() + "s ");

            if (n>0) {
                int x = (int) (times.get(n-1).getMeasurement()/times.get(n).getMeasurement());

                if (x == 1) {
                    System.out.print(" ||  Almost equal performance to " + times.get(n-1).getName());
                } else {
                    System.out.print(" ||  " + x + "x times faster than " + times.get(n - 1).getName());
                }

            } else {
                System.out.print(" ||  The slowest one!");
            }

            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------\n");

        /*
          Clearly Quick Delay And Default Util Library sorting types are similar in performance, however
          sometimes one is a little bit better, sometimes second one, it clearly depends on Quick Sort pivot
          which is totally random - the closest to the average, the better.

          What is also interesting - with large Array size (lets say 50000), when you can expect, that 'density' is quite high
          Bucket Sort algorithm has very good performance, situation is changing when you are using smaller array
          lets say 1000 records. Here due to the rather large range of array (now -50000 to 50000 @ArrayGeneratorUtil)
          we can expect lesser density, so we have a lot of empty 'buckets', and in this case, this method is not as
          efficient as for example QuickSort, which seem to be rather resistant to array size.

          Author
        */
    }
}
