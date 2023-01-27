package cn.linshiyou.algorithm.weeklyContest.doubleweekly;

import java.util.HashSet;
import java.util.Set;

/**
 * 双周赛98，第2题
 *
 * @author: LJ
 * @create: 2023/1/21
 */
public class week96_2 {

    public static void main(String[] args) {

    }
/*
[4,3,1,4]
[1,3,7,1]
3,0,-6,3

[3,8,5,2]
[2,4,1,6]
1,4,4,-4
[4,3,1,4]
[2,3,6,1]
2,0,-5,3
*/

    class Solution {
        public long minOperations(int[] nums1, int[] nums2, int k) {
            if (nums1.length==0) return 0;
            int s = 0;
            long num = 0;
            for (int i=0; i<nums1.length; i++){
                int tmp = nums1[i]-nums2[i];
                s += tmp;

                if (tmp>0){
                    num += tmp;
                }

            }
            System.out.println("num = "+num);
            System.out.println("s = "+s);
            if (s==0 && k>=num && num%k==0){
                return num/k;

            }
            return -1;

        }
    }
}
