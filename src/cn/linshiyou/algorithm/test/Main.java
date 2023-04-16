package cn.linshiyou.algorithm.test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 55
 *
 * (c+55+y)/y = x!
 * (55+y-c)/y = x!
 * (x!-1)y-n = ?
 * (x!-1)y-55 = ?
 */

/**
 * 35
 * 28 26 74
 * 25 2 26
 * 29 22 7
 * 28 14 53
 * 16 3 31
 * 31 34 40
 * 17 16 87
 * 25 15 92
 * 12 34 88
 * 33 16 40
 * 5 27 4
 * 22 1 3
 * 6 15 9
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {

            int n = in.nextInt();


            int[][] edge = new int[n][n];


        }
    }



}
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
////        while (in.hasNextInt()) {
////            int n = in.nextInt();
//            int n = 55;
//            int min = Integer.MAX_VALUE;
//            int a=0, b=0;
//            for (int x=1; x<30; x++){
//                if (x==2) continue;
//                int xc = getx(x)-1;
//
//                for (int y=1; y<30;y++){
//                    if (y==2) continue;
//                    int zhi = Math.abs(xc*y-n) ;
//                    if(min>zhi){
//                        min = zhi;
//                        a = x;
//                        b = y;
//                    }
//                }
//            }
//        System.out.println(min);
//        System.out.println(a);
//        System.out.println(b);
//
//
//
//
//
//
////        }
//    }
//
//    public static int getx(int jc){
//        int ans=1;
//        for (int x=1; x<=jc; x++){
//            ans *= x;
//        }
//        return ans;
//    }
//}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            String s = in.nextLine();
//            int ans = 0;
//            char[] chars = s.toCharArray();
//            for (int i=0; i<chars.length; i++){
//                char c = chars[i];
//                if (c=='0'|| c=='6'||c=='9'){
//                    ans++;
//                }else if (c=='8'){
//                    ans = ans+2;
//                }
//            }
//            System.out.println(ans);
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String a = in.nextLine();
//            String[] s = a.split(" ");
//            int n = Integer.valueOf(s[0]);
//            int k = Integer.valueOf(s[1]);
////            if (s.length!=0){
////                throw new RuntimeException(n+":"+k);
////            }
////            int k = in.nextInt();
//
//            List<Integer> list = new ArrayList<>(n);
//            List<Integer> good = new ArrayList<>(n);
//
//            for (int i=0; i<n; i++){
//                if (i>=n-k){
//                    good.add(i+1);
//                }else {
//                    list.add(i+1);
//                }
//            }
//
//            List<Integer> ans = new ArrayList<>(n);
//            int min = Math.min(good.size(), list.size());
//            for (int i=0; i<min; i++){
//                ans.add(good.remove(0));
//                ans.add(list.remove(0));
//            }
//
//            if (!good.isEmpty()) ans.addAll(good);
//            else ans.addAll(list);
//
//            for (Integer c : ans){
//                System.out.print(c+" ");
//            }
//
////            System.out.println(ans.toString());
//
//        }
//    }