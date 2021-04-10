package jcf;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a3", "aa");
        hashMap.put("a2", "bb");
        hashMap.put("b1", "cc");
        for (String s : hashMap.keySet()) {
            System.out.println(s);
        }

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a3", "aa");
        linkedHashMap.put("a2", "bb");
        linkedHashMap.put("b1", "cc");
        for (String s : linkedHashMap.keySet()) {
            System.out.println(s);
        }
    }
}
