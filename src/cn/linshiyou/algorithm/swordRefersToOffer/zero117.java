package cn.linshiyou.algorithm.swordRefersToOffer;


/**
 * @Author: LJ
 * @Description: 剑指 Offer II 117. 相似的字符串
 *
 * 理解题意：并查集, 转化为连通分量，并查集的问题。
 * find和check为并查集的模板代码
 *
 */
public class zero117 {

    public static void main(String[] args) {


        String[] strs = {
//                "nmiwx","mniwx","wminx","mnixw","xnmwi"
                "blw","bwl","wlb"
        };

        int circleNum = new Solution().numSimilarGroups(strs);
        System.out.println(circleNum);
    }

    static class Solution {
        int[] f;

        public int numSimilarGroups(String[] strs) {

            int n = strs.length;
            int m = strs[0].length();

            f = new int[n];
            for (int i=0; i<n; i++)
                f[i] = i;
            for (int i=0; i<n; i++){
                for (int j=i+1; j<n; j++){
                    int fi = find(i);
                    int fj = find(j);

                    if (fi==fj) continue;
                    if (check(strs[i], strs[j], m))
                        f[fi] = fj;

                }
            }

            int ans = 0;
            for (int i=0; i<n; i++)
                if (f[i]==i)
                    ans++;

            return ans;
        }

        private boolean check(String a, String b, int m) {
            int num = 0;

            for (int i=0; i<m; i++){
                if (a.charAt(i) != b.charAt(i))
                    num++;
                if (num>2) return false;
            }

            return true;

        }

        private int find(int x) {
            return f[x]==x? x : (f[x] = find(f[x]));
        }
    }


}
