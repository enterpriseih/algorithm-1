package cn.linshiyou.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: LJ
 * @Description: 344. 反转字符串
 *
 * 双指针：左右指针
 */
public class L344 {


    public static void main(String[] args) {


    }

    static class Solution {
        public void reverseString(char[] s) {

            int left = 0;
            int right = s.length-1;

            while(left < right){

                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;

                left++;
                right--;

            }

        }
    }


}
