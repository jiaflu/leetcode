package com.jiaflu.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void cloneTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> listCopy = (List<Integer>) list.clone();
        listCopy.remove(2);
        for (Integer i : list) {
            System.out.println(i);
        }

        for (Integer i : listCopy) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        cloneTest();
    }

}
