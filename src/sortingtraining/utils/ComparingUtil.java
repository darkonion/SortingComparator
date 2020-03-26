package sortingtraining.utils;

import sortingtraining.models.TimeMeasurement;
import sortingtraining.sortalgorythms.BubbleSort;
import sortingtraining.sortalgorythms.DefaultSort;
import sortingtraining.sortalgorythms.InsertionSort;
import sortingtraining.sortalgorythms.QuickSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparingUtil {

    public void compare(int[] numbers) {

        List<TimeMeasurement> times = new ArrayList<>();

        times.add(new TimeMeasurement(TimerUtil.measure(new InsertionSort(), numbers), "Insertion Sort"));

        times.add(new TimeMeasurement(TimerUtil.measure(new BubbleSort(), numbers), "Bubble Sort"));

        times.add(new TimeMeasurement(TimerUtil.measure(new QuickSort(), numbers), "Quick Sort"));

        //times.add(new TimeMeasurement(TimerUtil.measure(new BucketSort(), numbers), "Bucket Sort"));

        times.add(new TimeMeasurement(TimerUtil.measure(new DefaultSort(), numbers), "Default Library Sort"));

        Collections.sort(times); //dsc

        print(times);

    }


    private void print(List<TimeMeasurement> times) {
        System.out.println();
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
        System.out.println("-------------------------------------------------------------------------");

        /*
          clearly Quick Delay And Default Util Library sorting types are similar in performance, however
          sometimes one is a little bit better, sometimes second one, it clearly depends on Quick Sort pivot
          which is totally random - the closest to the average, the better.

          Author
        */
    }
}
