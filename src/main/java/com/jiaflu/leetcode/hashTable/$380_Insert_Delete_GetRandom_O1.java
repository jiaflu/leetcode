package com.jiaflu.leetcode.hashTable;

import java.util.*;

/**
 * 题目：常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * - insert(val)：当元素 val 不存在时，向集合中插入该项。
 * - remove(val)：元素 val 存在时，从集合中移除该项。
 * - getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * 解答:
 * - 难点：随机返回集合中的一项
 * - 难点：
 */

public class $380_Insert_Delete_GetRandom_O1 {

    // 时间复杂度过高
//    Set<Integer> set;
//    /** Initialize your data structure here. */
//    public RandomizedSet() {
//        set = new HashSet<Integer>();
//    }
//
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        return set.add(val);
//    }
//
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        return set.remove(val);
//    }
//
//    /** Get a random element from the set. */
//    public int getRandom() {
//        Integer[] arr = set.toArray(new Integer[1]);
//        return arr[new Random().nextInt(arr.length)];
//    }

    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Integer> idxMap;
    /** Initialize your data structure here. */
    public $380_Insert_Delete_GetRandom_O1() {
        valueMap = new HashMap<>();
        idxMap = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valueMap.containsKey(val)){
            return false;
        }

        valueMap.put(val, valueMap.size());
        idxMap.put(idxMap.size(), val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(!valueMap.containsKey(val)){
            return false;
        }

        int idx = valueMap.get(val);
        valueMap.remove(val);
        idxMap.remove(idx);

        // 将最后一个元素保存到删除元素的位置，保持idxMap里面的下标是连续的。（***难点）
        Integer tailElem = idxMap.get(idxMap.size());
        if(tailElem!=null){
            idxMap.put(idx,tailElem);
            valueMap.put(tailElem, idx);
        }

        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(valueMap.size()==0){
            return -1;
        }

        if(valueMap.size()==1){
            return idxMap.get(0);
        }

        Random r = new Random();
        int idx = r.nextInt(valueMap.size());

        return idxMap.get(idx);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //
        Integer[] a = new Integer[list.size()];
        Integer[] arr = list.toArray(a);
        list.toArray(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

}
