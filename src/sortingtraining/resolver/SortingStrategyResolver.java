package sortingtraining.resolver;


import sortingtraining.Strategy;
import sortingtraining.sortalgorythms.SortingStrategy;

public interface SortingStrategyResolver {

    SortingStrategy resolve(Strategy strategy);
}
