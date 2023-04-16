package cn.linshiyou.algorithm.written.meituan;

import java.util.*;

/**
 * @author LJ
 * @create 2023/4/1
 */
public class Main2 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n =in.nextInt();
            int m = in.nextInt();
            List<Integer> list = new ArrayList<>(n);
            List<Integer> ans = new ArrayList<>();
            for (int i=0; i<n; i++){
                list.add(0);
            }
            List<Integer> op = new ArrayList<>(m);
            List<Integer> loacl = new ArrayList<>(m);
            List<Integer> score = new ArrayList<>(m);

            for (int i=0; i<m; i++){
                op.add(in.nextInt());
            }
            for (int i=0; i<m; i++){
                loacl.add(in.nextInt()-1);
            }
            for (int i=0; i<m; i++){
                score.add(in.nextInt());
            }

            for (int i=0; i<m; i++){
                if (op.get(i)==1){
                    int sum = 0;
                    for (int j=loacl.get(i);j<score.get(i); j++){
                        sum += list.get(j);
                    }
                    ans.add(sum);
                }else {
                    list.set(loacl.get(i), score.get(i));
                }
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
