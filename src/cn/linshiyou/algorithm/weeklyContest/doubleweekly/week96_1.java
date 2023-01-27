package cn.linshiyou.algorithm.weeklyContest.doubleweekly;

import java.util.HashSet;
import java.util.Set;

/**
 * 双周赛98，第一题
 *
 * @author: LJ
 * @create: 2023/1/21
 */
public class week96_1 {



    class Solution {
        public int getCommon(int[] nums1, int[] nums2) {

            Set<Integer> nums1Map = new HashSet<>();
            for (int a: nums1){
                nums1Map.add(a);
            }

            for (int b: nums2){
                if (nums1Map.contains(b)) return b;
            }

            return -1;

        }
    }
}
