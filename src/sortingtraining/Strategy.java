package sortingtraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Strategy {
    COMPARE,
    BUBBLE,
    BUCKET,
    INSERTION,
    DEFAULT,
    QUICK,
    EXIT;

    public static String list() {

        List<String> str = new ArrayList<>();
        Arrays.asList(Strategy.values()).forEach($ -> str.add($.toString()));
        String result = str.stream().collect(Collectors.joining(", "));

        return result;
    }

}
