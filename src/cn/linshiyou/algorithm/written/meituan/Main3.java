package cn.linshiyou.algorithm.written.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LJ
 * @create 2023/4/1
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n =in.nextInt();

            List<Integer> full = new ArrayList<>();
            List<Integer> strat = new ArrayList<>();
            List<Integer> buy = new ArrayList<>();
            List<Integer> tryfull = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();

            for (int i=0; i<n; i++){
                full.add(in.nextInt());
            }
            for (int i=0; i<n; i++){
                strat.add(in.nextInt());
            }
            for (int i=0; i<n; i++){
                buy.add(in.nextInt());
            }
            int m = in.nextInt();
            for (int i=0; i<m; i++){
                tryfull.add(in.nextInt()-1);
            }

            for (int i=0; i<m; i++){
                List<Integer> strattest = new ArrayList<>(strat);
                int tart = tryfull.get(i);

                int cha = full.get(tart) - strattest.get(tart);
                int min = cha * buy.get(tart);

                for  (int j=tart-1; j>=0; j--){
                    int nowcha = 0;
                    for (int k=j; k<=tart; k++){
                        nowcha += full.get(k) - strattest.get(k);
                    }
                    int com = nowcha*buy.get(j);
                    min = Math.min(min, com);

                }
                ans.add(min);
            }

            for (int i=0; i<ans.size(); i++){
                if (i==n-1){
                    System.out.print(ans.get(i));
                    continue;
                }
                System.out.print(ans.get(i)+" ");

            }


        }
    }
}
