package cn.linshiyou.algorithm.hot100;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author LJ
 * @create 2023/2/15
 */
public class L49 {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for (String str: strs){

                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);

                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);

            }
            return new ArrayList<>(map.values());
        }
    }

}
