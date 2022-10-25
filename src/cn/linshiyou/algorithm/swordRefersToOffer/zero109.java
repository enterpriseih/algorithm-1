package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 109. 开密码锁
 *
 * 不会
 * 中等： bfs
 */
public class zero109 {

    public static void main(String[] args) {

    }

    class Solution {
        public int openLock(String[] deadends, String target) {
            if ("0000".equals(target)) return 0;

            Set<String> dead = new HashSet<>();
            Collections.addAll(dead, deadends);

            if (dead.contains("0000")) return -1;

            int setp = 0;
            LinkedList<String> queue = new LinkedList<>();
            queue.addLast("0000");
            Set<String> seen = new HashSet<>();
            seen.add("0000");

            while (!queue.isEmpty()){
                setp++;
                int size = queue.size();
                for (int i=0; i<size; i++){
                    String status = queue.removeFirst();
                    for (String nextStatus : get(status)){
                        if (!seen.contains(nextStatus) && !dead.contains(nextStatus)){
                            if (nextStatus.equals(target)) return setp;

                            queue.addLast(nextStatus);
                            seen.add(nextStatus);
                        }
                    }

                }

            }
            return -1;
        }

        /**
         * // 枚举 status 通过一次旋转得到的数字
         * @param status
         * @return
         */
        private List<String> get(String status) {

            List<String> ret = new ArrayList<>();
            char[] array = status.toCharArray();
            for (int i=0; i<4; i++){
                char num = array[i];
                array[i] = numPrev(num);
                ret.add(new String(array));
                array[i] = numSucc(num);
                ret.add(new String(array));
                array[i] = num;
            }
            return ret;
        }

        /**
         * 后一个数
         * @param num
         * @return
         */
        private char numSucc(char num) {
            return num=='9'? '0' : (char) (num+1);
        }

        /**
         * 前一个数
         * @param num
         * @return
         */
        private char numPrev(char num) {
            return num=='0'? '9' : (char) (num-1);
        }
    }

}
