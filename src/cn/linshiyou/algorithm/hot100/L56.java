package cn.linshiyou.algorithm.hot100;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @author LJ
 * @create 2023/4/15
 */
public class L56 {

    public static void main(String[] args) {

    }

    class Solution {
        public int[][] merge(int[][] intervals) {


            List<int[]> merged = new ArrayList<>();

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            for (int i=0; i<intervals.length; i++){
                int left = intervals[i][0];
                int right = intervals[i][1];

                //  没有重合
                if (merged.size()==0 || merged.get(merged.size()-1)[1] < left){
                    merged.add(new int[]{left, right});
                }else{
                    //有重合，可能是包含，也可能是合并的。
                    merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], right);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }

}
