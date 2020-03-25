package sortingtraining.decorators;

import sortingtraining.sortalgorythms.SortingStrategy;

public abstract class SortingDecorator implements SortingStrategy {

    final SortingStrategy decorated;

    public SortingDecorator(SortingStrategy decorated) {
        this.decorated = decorated;
    }
}
