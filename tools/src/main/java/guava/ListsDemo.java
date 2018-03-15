package guava;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class ListsDemo {

    public static void main(String[] args) {
        List<Integer> bigList = new ArrayList<>();
        List<List<Integer>> smallerLists = Lists.partition(bigList, 10);
    }
}
