package day2;

import java.util.Set;
import java.util.TreeSet;

public class SmallestFreeIndex {

    public static void main(String[] args) {
        System.out.println(method(451));
//        method(451);
    }


    private static int method(int a) {
        String result = "";
        while (a > 1) {
            result = a % 2 + result;
            a = a / 2;
        }
        result = "0001111000001111000";
        System.out.println(result.substring(result.indexOf("1"), result.lastIndexOf("1")));
        String[] s = result.split("1");

        int result2 = 0;
        for (String p : s) {
            int i = p.length();
            if (i > result2) {
                result2 = i;
            }
        }
//        System.out.println(result2);
        return result2;
    }


    public int getIndex(int[] a) {
        Set<Integer> set = new TreeSet<>();
        for (int i : a)
            if (i > 0) {
                set.add(i);
            }

        int result = 1;
        for (int i : set) {
            if (i == result) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

}
