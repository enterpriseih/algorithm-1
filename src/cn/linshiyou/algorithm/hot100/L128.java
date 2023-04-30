package cn.linshiyou.algorithm.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @author shiyou.lin
 * @date 2023/4/28
 */
public class L128 {

    public static void main(String[] args) {

    }


    class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            int longestStreak = 0;

            for (int num : numSet){
                if (!numSet.contains(num-1)){
                    int currentNum = num;
                    int currentStreak = 1;

                    while (numSet.contains(currentNum+1)){
                        currentNum += 1;
                        currentStreak += 1;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }

}
