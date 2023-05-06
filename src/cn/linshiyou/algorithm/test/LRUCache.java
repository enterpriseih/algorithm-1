package cn.linshiyou.algorithm.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU
 *
 * @author shiyou.lin
 * @date 2023/5/6
 */
class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }

    int capacity = 0;
    Map<Integer, Integer> map;
    Map<Integer, Integer> lru;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
        lru = new LinkedHashMap<>();
    }

    public int get(int key) {

        for (Integer integer : lru.keySet()) {
            lru.put(integer, lru.get(integer)-1);
        }

        if (lru.containsKey(key)){
            lru.remove(key);
            lru.put(key, 0);
        }

        return map.getOrDefault(key,-1);

    }

    public void put(int key, int value) {


        if (map.size() == capacity && !map.containsKey(key)){
            int min = Integer.MAX_VALUE;
            Integer del = null;
            for (Integer integer : lru.keySet()) {
                if (min>lru.get(integer)){
                    min = lru.get(integer);
                    del = integer;
                }
            }
            if (del!=null){
                lru.remove(del);
                map.remove(del);
            }
        }
        if (map.containsKey(key)){
            lru.remove(key);
        }
        map.put(key, value);
        lru.put(key,0);
    }
}
