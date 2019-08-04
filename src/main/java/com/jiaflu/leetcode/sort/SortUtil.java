package com.jiaflu.leetcode.sort;

import java.util.*;

public class SortUtil {
    public static void arraySort() {
        int[] arr = new int[]{3,1,4,7,6};
        // 升序
        Arrays.sort(arr);

        // 降序
        // 要实现降序，得通过包装类型数组，基本类型数组不行
        Integer[] arrInteger = new Integer[]{3,1,4,7,6};
        Arrays.sort(arrInteger, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });

    }


    public static void collectionsSort() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        // 按字母升序
        //Collections.sort(names);

        // 原始方法
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//
        // 按字母降序
        Collections.sort(names, (String o1, String o2) -> {
            return o2.compareTo(o1);
        });

    }

    // map 遍历
    public static void mapErgodic() {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer key : map.keySet()) {

        }
    }

    // set 遍历
    public static void serErgodic() {
        Set<String> set = new HashSet<>();
        for (String str : set) {
            System.out.println(str);
        }
    }


    public static void main(String[] args) {
        collectionsSort();
    }
}
