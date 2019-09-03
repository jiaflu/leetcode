package com.jiaflu.xinlang;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution1 {
    private LRUCache lruCache;
    public Solution1(int capacity) {
        lruCache = new LRUCache(capacity);
    }

    public int get(int key) {
        return lruCache.get(key);
    }

    public void put(int key, int value) {
        lruCache.put(key, value);
    }

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
