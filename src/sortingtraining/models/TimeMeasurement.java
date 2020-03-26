package sortingtraining.models;

public class TimeMeasurement implements Comparable<Object> {

    private final double measurement;
    private final String name;

    public TimeMeasurement(double measurement, String name) {
        this.measurement = measurement;
        this.name = name;
    }

    public double getMeasurement() {
        return measurement;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TimeMeasurement{" +
                "measurement=" + measurement +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        TimeMeasurement other = (TimeMeasurement) o;
        //return (int)(1000*measurement - 1000*other.measurement);  //asc
        return (int)(1000*other.measurement - 1000*measurement); //dsc
    }
}
