package cn.linshiyou.algorithm.written.meituan;

import java.util.*;

/**
 * @author LJ
 * @create 2023/4/1
 */
public class Main5 {
/*
  1
 2 3

 */
    static List<Integer> op = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i=1; i<n; i++){
                int x = in.nextInt()-1;
                List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(i);
                map.put(x, list);
            }

            for (int i=0; i<n; i++){
                op.add(in.nextInt());
            }

            int sum = 0;

            sum = dfs(map, 1);

            System.out.println(sum);
        }
    }

    private static int dfs(Map<Integer, List<Integer>> map, int node) {

        int sum = 0;
        List<Integer> list = map.get(node);
        if (list==null || list.size()==0){
            return 1;
        }

        for (int i=0; i<list.size(); i++){
            int x = list.get(i);
            if (op.get(i)==2){
                sum ^= dfs(map, x);
            }else {
                sum += dfs(map, x);
            }
        }

        return sum;
    }


}
