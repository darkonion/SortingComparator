package sortingtraining.models;

public class TimeMeasurement {

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

}
