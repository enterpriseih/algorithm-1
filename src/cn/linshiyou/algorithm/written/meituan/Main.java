package cn.linshiyou.algorithm.written.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @create 2023/4/1
 */
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int n = in.nextInt();
            List<Double> nums = new ArrayList<>(n);
            List<Double> ans = new ArrayList<>(n);
            for (int i=0; i<n; i++){
                nums.add((double) in.nextInt());
            }

            int m = in.nextInt();
            in.nextLine();
            String[] s = in.nextLine().split(" ");
            System.out.println(s.toString());
            for (int i=0; i<s.length; i++,i++){
                int x = Integer.valueOf(s[i])-1;
                String op = s[i+1];

                double sum = 0;

                if (op.equals("+")){
                    sum = nums.get(x) + nums.get(x+1);
                    sum += total(nums, x);
                    ans.add(sum);
                }

                if (op.equals("-")){
                    sum = nums.get(x) - nums.get(x+1);
                    sum += total(nums, x);
                    ans.add(sum);
                }

                if (op.equals("*")){
                    sum = nums.get(x) * nums.get(x+1);
                    sum += total(nums, x);
                    ans.add(sum);
                }

                if (op.equals("/")){
                    sum = nums.get(x) / nums.get(x+1);
                    sum += total(nums, x);
                    ans.add(sum);
                }

            }

            for (int i=0; i<ans.size(); i++){
                if (i==ans.size()-1){
                    System.out.println(ans.get(i));
                }else {
                    System.out.println(ans.get(i)+" ");
                }
            }
        }
    }
    private static double total(List<Double> nums, int x){
        double ans = 0.0;

        for (int i=0; i<nums.size(); i++){
            if (i==x || i==x+1) continue;
            ans += nums.get(i);
        }


        return ans;
    }

}
