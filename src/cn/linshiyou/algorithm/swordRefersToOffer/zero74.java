package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 074. 合并区间
 * 有序树（没有必要是使用）
 * 中等：左端点排序，比较右端点。合并
 */
public class zero74 {

    public static void main(String[] args) {

        int[][] intervals={
                {2,3},
                {4,5},
                {6,7},
                {8,9},
                {1,10},
        };

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            List<int[]> merged = new ArrayList<>();
            merged.add(new int[]{intervals[0][0], intervals[0][1]});
            for (int i=1; i<intervals.length; i++){
                int left = intervals[i][0];
                int right = intervals[i][1];

                if (merged.get(merged.size()-1)[1]<left){
                    merged.add(new int[]{left, right});
                }else {
                    merged.get(merged.size()-1)[1] = Math.max(right, merged.get(merged.size()-1)[1]);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
