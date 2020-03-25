package sortingtraining.resolver;


import sortingtraining.sortalgorythms.SortingStrategy;

public interface SortingStrategyResolver {

    SortingStrategy resolve(String strategy);
}
