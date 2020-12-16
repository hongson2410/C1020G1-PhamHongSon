package bai11_generic_stack_queue.bai_tap.dem_so_lan_suat_hien_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        Integer value = 1;
        Map<String, Integer> map = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String[] arr = text.split(" ");
        for (String w : arr) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, value);
            }
        }
        System.out.println(map.toString());
    }
}
