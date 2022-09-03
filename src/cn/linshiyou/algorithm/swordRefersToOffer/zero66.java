package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 066. 单词之和
 * 中等
 * 思路：使用Map和list进行暴力
 */
public class zero66 {

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int num = mapSum.sum("ap");           // return 3 (apple = 3)

        System.out.println(num);

        mapSum.insert("app", 2);
        num = mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

        System.out.println(num);
    }

    static class MapSum {


        Map<String, Integer> map;
        //这里使用List而不是直接使用Map的原因是在Map里面遍历key很慢
        List<String> list;
        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public void insert(String key, int val) {

            if (!map.containsKey(key)){
                list.add(key);
            }
            map.put(key, val);

        }

        public int sum(String prefix) {

            int sum = 0;

            for (String s : list){
                if (s.startsWith(prefix)){
                    sum += map.get(s);
                }
            }

            return sum;
        }
    }

}
