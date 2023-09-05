package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return x -> {
            for (String word : x) {
                if (!Character.isUpperCase(word.charAt(0))) {
                    return false;
                }
            }
            return true;
        };

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            ArrayList<Integer> tempArray = new ArrayList<>();
            for (Integer e : x) {
                if (e % 2 == 0) {
                    tempArray.add(e);
                }
            }
            x.addAll(tempArray);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredList = new ArrayList<>();
            for (String value : values) {
                if (Character.isUpperCase(value.charAt(0))
                        && value.endsWith(".")
                        && value.split(" ").length >= 4) {
                    filteredList.add(value);
                }
            }
            return filteredList;
        };
    }


    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for( String e : x ) {
                map.put( e , e.length() );
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return ( list1 , list2 ) -> {
            List<Integer> mergedList = new ArrayList<>(list1);
            mergedList.addAll(list2);
            return mergedList;
        };
    }
}
