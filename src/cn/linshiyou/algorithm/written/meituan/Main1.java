package cn.linshiyou.algorithm.written.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @create 2023/4/1
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n =in.nextInt();
            List<Integer> nums = new ArrayList<>(n);
            for (int i=0; i<n; i++){
                nums.add(in.nextInt());
            }
            Collections.sort(nums);

            int sum = 0;
            for (int i=0; i<n-1; i++){
                sum += Math.abs(nums.get(i)-nums.get(i+1));
            }
            System.out.println(sum);

        }
    }

}
