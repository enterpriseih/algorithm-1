package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 075. 数组相对排序
 *
 * 简单：根据规则直接排序Arrays.sort();
 */
public class zero75 {

    public static void main(String[] args) {

        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.relativeSortArray(arr1, arr2)));

    }

    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            if (arr1.length==0) return null;
            List<Integer> ans = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int a: arr1) ans.add(a);
            for (int i=0; i<arr2.length; i++) map.put(arr2[i], i);

            Collections.sort(ans, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    if (map.containsKey(a) && map.containsKey(b)){
                        return map.get(a) - map.get(b);
                    }else if(map.containsKey(a) || map.containsKey(b)){
                        return 1;
                    }else {
                        return a-b;
                    }
                }
            });

            int[] res = new int[ans.size()];
            for (int i=0; i<ans.size(); i++){
                res[i] = ans.get(i);
            }


            return res;
        }
    }

}
